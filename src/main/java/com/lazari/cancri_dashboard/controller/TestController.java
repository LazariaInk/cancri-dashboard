package com.lazari.cancri_dashboard.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class TestController {
    @GetMapping("/hello")
    public String printMockData() {
        return "Hello from Cancri dashboard service";
    }

    @GetMapping("/user-info")
    public ResponseEntity<Map<String, Object>> getUserInfo(
            @AuthenticationPrincipal Jwt jwt,
            @RequestHeader("X-User-Email") String email) {
        System.out.println("test");
        return ResponseEntity.ok(Map.of(
                "email", email,
                "userId", jwt.getSubject()));
    }
}
