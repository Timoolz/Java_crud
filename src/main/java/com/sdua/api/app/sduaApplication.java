package com.sdua.api.app;

import com.sdua.api.config.AppConfiguration;
import com.sdua.api.auth.sduaAuthFilter;
import com.sdua.api.dao.BugDaoImpl;
import com.sdua.api.resource.sduaResource;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.sdua.api.config.sduaConfiguration;
import com.sdua.api.resource.sdua;
import com.sdua.api.service.sduaService;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jersey.errors.EarlyEofExceptionMapper;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class sduaApplication extends Application<sduaConfiguration> {
    public static void main(String[] args) throws Exception {
        new sduaApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<sduaConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<sduaConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(sduaConfiguration configuration) {
                return configuration.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(sduaConfiguration config, Environment env) throws Exception {
        final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);

        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        ((DefaultServerFactory) config.getServerFactory()).setRegisterDefaultExceptionMappers(false);

        env.jersey().register(new EarlyEofExceptionMapper());

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "mariadb");
        final BugDaoImpl dao = jdbi.onDemand(BugDaoImpl.class);

        Injector injector = createInjector(config, jdbi);
        env.jersey().register(injector.getInstance(sduaAuthFilter.class));
        env.jersey().register(injector.getInstance(sduaResource.class));

        //resources
    }

    private Injector createInjector(sduaConfiguration config, DBI jdbi) {
        return Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                bind(AppConfiguration.class).toInstance(config.getAppConfig());

                bind(sdua.class).to(sduaService.class);
                bind(BugDaoImpl.class).toInstance(jdbi.onDemand(BugDaoImpl.class));
            }
        });

    }
}
