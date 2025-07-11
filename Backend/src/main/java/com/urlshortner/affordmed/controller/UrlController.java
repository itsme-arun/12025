package com.urlshortner.affordmed.controller;

import com.urlshortner.affordmed.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public String shortenUrl(@RequestBody Map<String, String> body) {
        String url = body.get("url");
        String shortCode = urlService.shortenUrl(url);
        return "http://localhost:8080/" + shortCode;
    }

    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String originalUrl = urlService.getOriginalUrl(shortCode);
        if (originalUrl != null) {
            response.sendRedirect(originalUrl);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "URL not found");
        }
    }
}

