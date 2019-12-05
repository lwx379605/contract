package com.lmc.shopleasing.security;

import com.lmc.shopleasing.global.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.session.InvalidSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RestInvalidSessionStrategy implements InvalidSessionStrategy {

    protected Logger logger= LoggerFactory.getLogger(getClass());

    @Override
    public void onInvalidSessionDetected(HttpServletRequest request,
                                         HttpServletResponse response) throws IOException{
        logger.warn("不正确的sessionId:"+request.getSession().getId());
        Results.forbidden(response,"session回话过期，请登录");
        response.flushBuffer();
    }

}
