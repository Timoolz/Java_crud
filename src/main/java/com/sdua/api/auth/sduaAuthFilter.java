package com.sdua.api.auth;

import io.dropwizard.auth.AuthFilter;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import java.io.IOException;
import java.security.Principal;

@Priority(Priorities.AUTHENTICATION)
public class sduaAuthFilter extends AuthFilter<String, Principal> {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

    }

    @Override
    public boolean authenticate(ContainerRequestContext requestContext, String token, String scheme) {
        return true;
    }
}
