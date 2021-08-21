package com.greeners.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.greeners.common.CommonResult;
import com.greeners.common.ListResult;
import com.greeners.common.SingleResult;
import com.greeners.domain.entity.SampleEntity;

import javassist.expr.NewArray;

@Service
public class ResponseServiceImpl implements ResponseService {

    //api 요청 결과에 대한 code, message를 정의
    public enum CommonResponse {
        SUCCESS(0000, "성공하였습니디."),
        FAIL(-1, "실패하였습니다.");
 
        int code;
        String msg;
 
        CommonResponse(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
 
        public int getCode() {
            return code;
        }
 
        public String getMsg() {
            return msg;
        }
    }
    
    /**
	 * 단일건 결과를 처리하는 메서드
	 * 
	 * @param T data
	 * @return SingleResult<T>
	 */
    public <T> SingleResult<T> getSingleResult(T data) {
        SingleResult<T> result = new SingleResult<>();
        result.setResultData(data);
        setSuccessResult(result);
        return result;
    }
   
    /**
	 * 다중건 결과를 처리하는 메서드
	 * 
	 * @param List<T>
	 * @return ListResult<T>
	 */
    public <T> ListResult<T> getListResult(List<T> list) {
        ListResult<T> result = new ListResult<>();
        result.setResultData(list);
        setSuccessResult(result);
        return result;
    }
    
    /**
	 * 성공 결과만 처리하는 메서드
	 * 
	 * @param 
	 * @return CommonResult
	 */
    public CommonResult getSuccessResult() {
        CommonResult result = new CommonResult();
        setSuccessResult(result);
        return result;
    }
    
    /**
	 * 실패 결과만 처리하는 메서드
	 * 
	 * @param int code
	 * @param String msg
	 * @return CommonResult
	 */
    public CommonResult getFailResult(int resultCode, String resultMessage) {
        CommonResult result = new CommonResult();
        result.setResultCode(resultCode);
        result.setResultMessage(resultMessage);
        return result;
    }
    
    /**
	 * 결과 모델에 api 요청 성공 데이터를 세팅해주는 메서드
	 * 
	 * @param CommonResult result
	 * @return 
	 */
    public void setSuccessResult(CommonResult result) {
        result.setResultCode(CommonResponse.SUCCESS.getCode());
        result.setResultMessage(CommonResponse.SUCCESS.getMsg());
    }
}
