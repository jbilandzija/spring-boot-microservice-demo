package com.example.service.alpha.shared;

/**
 * Application wide constants.
 * <p><ul><li>Currently mainly needed for service authentication</li></ul></p>
 */
public class Constants {

    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
    public static final String SIGNING_KEY = "jbi123r";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTHORITIES_KEY = "scopes";
}

