package com.sdua.api.config;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfiguration {
    @JsonProperty("appBaseUrl")
    private String appBaseUrl;

    public String getAppBaseUrl() {
        return appBaseUrl;
    }
}
