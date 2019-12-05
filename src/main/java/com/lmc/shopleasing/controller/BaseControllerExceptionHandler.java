package com.lmc.shopleasing.controller;

import com.lmc.shopleasing.core.ServiceException;
import com.lmc.shopleasing.global.BeanValidators;
import com.lmc.shopleasing.global.DateEditor;
import com.lmc.shopleasing.global.Results;
import com.lmc.shopleasing.global.StringEditor;
import com.lmc.shopleasing.util.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author lmc
 */
@RestControllerAdvice("com.lmc.shopleasing.controller")
public class BaseControllerExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 数据绑定
     *
     * @param binder
     *            WebDataBinder
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        binder.registerCustomEditor(Date.class, new DateEditor(true));
        binder.registerCustomEditor(String.class, "password", new StringEditor(true));
    }

    /**
     * 异常处理
     *
     * @param typeMismatchException
     *            类型配比错误
     * @return 视图
     */
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity exceptionHandler(TypeMismatchException typeMismatchException) {
        log.error("类型配比错误:{}", typeMismatchException);
        //按需重新封装需要返回的错误信息
        return Results.badRequest("类型配比错误:" + typeMismatchException.getPropertyName());
    }

    /**
     * 拦截业务异常
     */
    @ExceptionHandler({ ServiceException.class, ServletException.class })
    public ResponseEntity serviceError(Exception e) {
        log.error("业务异常:{}", e);
        Map<String, String> data = new HashMap<>();
        data.put("message", "内部服务错误，请联系管理员");
        return Results.status(HttpStatus.INTERNAL_SERVER_ERROR,data);
    }


    /**
     * 请求url不存在异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity noFoundError(HttpServletRequest request) {
        return Results.notFound("接口 [" + request.getRequestURI() + "] 不存在");
    }

    /**
     * 参数绑定异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity bindParamsError(BindException e) {
        Map map =new HashMap();
        for (FieldError fieldError : e.getFieldErrors()) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        String msg = JsonUtils.toJson(map);
        log.error("参数绑定异常:{}", msg);
        //按需重新封装需要返回的错误信息
        return Results.badRequest("参数绑定异常:"+msg);
    }

    /**
     * 校验异常（参数请求错误），单独参数校验
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity paramReqError(ConstraintViolationException ex) {
        Map<String, String> stringStringMap = BeanValidators.extractPropertyAndMessage(ex);
        String msg = JsonUtils.toJson(stringStringMap);
        log.error("校验异常（参数请求错误）:{}", msg);
        return Results.badRequest("校验异常（参数请求错误）:"+ msg);
    }
    
    /**
     * 校验异常（参数请求错误）对象校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentError(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder errorMesssage = new StringBuilder();
        Map map =new HashMap();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        String msg = JsonUtils.toJson(map);
        log.error("方法参数校验异常:{}", msg);
        return Results.badRequest("方法参数校验异常:"+msg);
    }

    
    /**
    * 拦截未知的运行时异常
    */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity otherError(HttpServletRequest request, Object handler, RuntimeException e) {
        String message;
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            message = String.format("接口 [%s] 出现异常，方法：%s.%s，异常摘要：%s", request.getRequestURI(),
                handlerMethod.getBean().getClass().getName(), handlerMethod.getMethod().getName(),
                e.getMessage());
        } else {
            message = e.getMessage();
        }
        log.error("运行时异常-"+message, e);
        Map<String, String> data = new HashMap<>();
        data.put("message", "接口 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
        return Results.status(HttpStatus.INTERNAL_SERVER_ERROR,data);

    }

}