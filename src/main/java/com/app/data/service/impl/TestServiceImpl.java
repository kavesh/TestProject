package com.app.data.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.data.dao.TestDao;
import com.app.data.service.TestService;

@Service("testService")
public class TestServiceImpl implements TestService {

	private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
	
	@Autowired
	TestDao testDao;
	
	@Override
	@Transactional
	public void processOtp(String msgData){
		logger.info("Inside Method processOtp()");
		
	}
}
