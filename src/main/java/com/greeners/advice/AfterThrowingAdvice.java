package com.greeners.advice;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.greeners.advice.exception.SampleException;
import com.greeners.common.CommonResult;
import com.greeners.service.ResponseService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestControllerAdvice
public class AfterThrowingAdvice {

	private final Environment env;
	
	private final ResponseService responseService;
	
	@ExceptionHandler(SampleException.class)
	public CommonResult SampleException(HttpServletRequest request, Exception e) throws UnsupportedEncodingException{
		return exceptionResult("exception.sample.code", "exception.sample.message", e);
	}
	
	@ExceptionHandler(Exception.class) 
	public CommonResult defaultException(HttpServletRequest request, Exception e) throws UnsupportedEncodingException {
		return exceptionResult("exception.unKnown.code", "exception.unKnown.msg", e);
	}
	
	private CommonResult exceptionResult(String resultCode, String resultMessage, Exception e) throws UnsupportedEncodingException {
		String encodingCode = encodingProperty(resultCode);
		String encodingMessage = encodingProperty(resultMessage);
		
		if (log.isErrorEnabled()) {
			log.error("exception code : {}, message : {}", encodingCode, encodingMessage, e);
		}
		
		return responseService.getFailResult(Integer.parseInt(encodingCode), encodingMessage);
	}
	
	private String encodingProperty(String prop) throws UnsupportedEncodingException {
		//이클립스, 스프링부트 인코딩 설정, @propertysource 인코딩 속성을 적용해도 한글이 깨져서 일일히 인코딩 변경 해줌..
		return new String(env.getProperty(prop).getBytes("ISO-8859-1"), "UTF-8");
	}
	
}
