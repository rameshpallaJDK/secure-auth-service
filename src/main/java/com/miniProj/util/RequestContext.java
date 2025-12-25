package com.miniProj.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class RequestContext {

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attributes != null ? attributes.getRequest() : null;
    }

    public static String getClientIP() {
        HttpServletRequest req = getRequest();
        if (req == null) return "UNKNOWN";
        return req.getRemoteAddr();
    }

    public static String getUserAgent() {
        HttpServletRequest req = getRequest();
        if (req == null) return "UNKNOWN";
        return req.getHeader("User-Agent");
    }
}

