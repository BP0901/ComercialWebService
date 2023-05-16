package com.R2S.R2Sshop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {


        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        final Map<String, Object> BODY = new HashMap<>();
        if (authException instanceof InsufficientAuthenticationException) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            BODY.put("status", HttpServletResponse.SC_FORBIDDEN);
            BODY.put("error", "Forbidden!");
            BODY.put("message", "Forbidden");
        } else {
            BODY.put("status", HttpStatus.UNAUTHORIZED.value());
            BODY.put("error", "Không có quyền");
        }
        BODY.put("message", authException.getMessage());
        BODY.put("path", request.getServletPath());
        final ObjectMapper MAPPER = new ObjectMapper();
        MAPPER.writeValue(response.getOutputStream(), BODY);
    }
}
