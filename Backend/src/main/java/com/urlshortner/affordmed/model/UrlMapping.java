package com.urlshortner.affordmed.model;

public class UrlMapping {
    private String originalUrl;
    private String shortUrl;
    public UrlMapping(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortUrl = shortCode;
    }
    public String getOriginalUrl() {
        return originalUrl;
    }
    public String getShortCode() {
        return shortUrl;
    }

}
