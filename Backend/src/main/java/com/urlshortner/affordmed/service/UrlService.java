package com.urlshortner.affordmed.service;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

@Service
public class UrlService {
    private final ConcurrentHashMap<String, String> urlDatabase = new ConcurrentHashMap<>();

    public String shortenUrl(String originalUrl) {
        String shortCode = UUID.randomUUID().toString().substring(0, 6);
        urlDatabase.put(shortCode, originalUrl);
        return shortCode;
    }
    public String getOriginalUrl(String shortCode) {
        return urlDatabase.get(shortCode);
    }

}

