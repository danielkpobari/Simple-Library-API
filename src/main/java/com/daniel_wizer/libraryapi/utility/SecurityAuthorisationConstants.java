package com.daniel_wizer.libraryapi.utility;

public class SecurityAuthorisationConstants {

    public static final long TOKEN_EXPIRATION_TIME = 864_000_000;
    public static final String[] PUBLIC_URIS = new String[]{
            "/",
            // -- Swagger UI v3 (OpenAPI) Start
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui/login/",
            "/swagger-ui/api/login/",
            "/swagger-ui/#/**",
            // -- Swagger UI v3 (OpenAPI) End
            "/api/v1/auth/register",
            "/api/v1/auth/login",
            "/api/v1/auth/admin/register",
            "/users/**",
    };
}
