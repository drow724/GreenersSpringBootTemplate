package com.greeners.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greeners.common.CommonResult;
import com.greeners.common.ListResult;
import com.greeners.common.SingleResult;

@Service
public interface ResponseService {
    
    public <T> SingleResult<T> getSingleResult(T data);
   
    public <T> ListResult<T> getListResult(List<T> list);
    
    public CommonResult getSuccessResult();
    
    public CommonResult getFailResult(int resultCode, String resultMessage);
    
    public void setSuccessResult(CommonResult result);
    
}
