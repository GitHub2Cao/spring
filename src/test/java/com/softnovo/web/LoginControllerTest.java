package com.softnovo.web;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.softnovo.base.ControllerBaseTest;
import com.softnovo.domain.User;

public class LoginControllerTest extends ControllerBaseTest {

	@Test
	public void test() {
		try {
			System.out.println("_+_+_+_+_+_+_+_+");
			RestTemplate restTemplate = new RestTemplate();
			MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
			form.add("userName", "userNamesss");
			
			form.add("password", "ddddd");
			form.add("credit", "12");
			form.add("lastIp", "127.0.0.1");
			restTemplate.postForLocation("http://127.0.0.1:8081/spring/add", form);
			String user = restTemplate.postForObject("http://127.0.0.1:8081/spring/add", form, String.class);
			System.out.println(")_)_)_)_)_)_)_)_)_)  " + JSON.toJSONString(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
