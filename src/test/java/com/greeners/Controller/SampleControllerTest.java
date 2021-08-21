package com.greeners.Controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test //"/index" 경로로 get 요청보내고, 예상되는 응답 상태(status)로 OK(200) 설정하기
	public void getTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/index"))
	         .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test //요청 보낼 때 Content-Type을 명시하기
	public void mediaTypeTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.TEXT_HTML))
	         .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test //응답 받은 내용 print()하기
	public void printTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.TEXT_HTML))
	         .andExpect(MockMvcResultMatchers.status().isOk())
	         .andDo(MockMvcResultHandlers.print());
	}
	
	@Test //"sample" 키에 "sampleTest"이라는 값이 담겨 있는지 확인하기
	public void modelTest() throws Exception {
	 mockMvc.perform(MockMvcRequestBuilders.get("/index").accept(MediaType.TEXT_HTML))
	         .andExpect(MockMvcResultMatchers.status().isOk())
	         .andExpect(MockMvcResultMatchers.model().attribute("sample", "sampleTest"))
	         .andDo(MockMvcResultHandlers.print());
	}
}
