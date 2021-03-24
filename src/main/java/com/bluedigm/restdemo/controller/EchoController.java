package com.bluedigm.restdemo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.log4j.Log4j;

@RestController
public class EchoController {
	
	@RequestMapping("/**")
	@ResponseBody
	public ResponseEntity<String> echo( 
			HttpServletRequest request,
			@RequestBody @Nullable String reqBody, 
			@RequestHeader @Nullable MultiValueMap<String, String> reqHeader) {
		
		String method = request.getMethod();
		String uri = request.getRequestURI();
		Map<String, String[]> param = request.getParameterMap();
		
		MultiValueMap<String, String> resHeader = reqHeader;
		String resBody = reqBody;
		
		Map<String, Object> resObj = new HashMap<>();
		
		resObj.put("resHeader", resHeader);
		resObj.put("resBody", resBody);
		resObj.put("uri", uri);
		resObj.put("params", param);
		resObj.put("method", method);
		
		Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().serializeNulls().create();
		
		String responseString = gson.toJson(resObj);
		
		System.out.println(responseString);
		
		ResponseEntity<String> response = new ResponseEntity<String>(responseString, HttpStatus.OK);
		
		return response;
	}
	
}
