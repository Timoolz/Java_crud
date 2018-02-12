package com.sdua.api.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class sduaConfiguration extends Configuration
{
	@Valid
	@NotNull
	@JsonProperty("database")
	private DataSourceFactory database = new DataSourceFactory();

	@JsonProperty("config")
	private AppConfiguration appConfig;

	@JsonProperty("swagger")
	private SwaggerBundleConfiguration swaggerBundleConfiguration;

	public DataSourceFactory getDataSourceFactory()
	{
		return database;
	}

	public SwaggerBundleConfiguration getSwaggerBundleConfiguration()
	{
		return swaggerBundleConfiguration;
	}

	public AppConfiguration getAppConfig()
	{
		return appConfig;
	}
}
