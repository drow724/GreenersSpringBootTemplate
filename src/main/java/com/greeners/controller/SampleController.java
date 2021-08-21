package com.greeners.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greeners.advice.exception.SampleException;
import com.greeners.common.SingleResult;
import com.greeners.domain.entity.SampleEntity;
import com.greeners.domain.entity.SampleEntityRepository;
import com.greeners.service.ResponseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SampleController {

	private final ResponseService responseService;
	
	private final SampleEntityRepository sampleEntityRepository;
	
	@GetMapping("/index")
	public SingleResult<SampleEntity> index(){
		return responseService.getSingleResult(sampleEntityRepository.findById(1L).get());
	}
	
}