package com.lmc.shopleasing.security;

import com.lmc.shopleasing.global.Results;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    // ~ Static fields/initializers
    // =====================================================================================

    protected static final Log logger = LogFactory.getLog(AccessDeniedHandlerImpl.class);

    // ~ Methods
    // ========================================================================================================

    public void handle(HttpServletRequest request, HttpServletResponse response,
            AccessDeniedException accessDeniedException) throws IOException,
            ServletException {
        logger.warn("没有访问权限:"+accessDeniedException.getMessage());
        if (!response.isCommitted()) {
            Results.forbidden(response,"没有访问权限");
            response.flushBuffer();
        }
    }

}