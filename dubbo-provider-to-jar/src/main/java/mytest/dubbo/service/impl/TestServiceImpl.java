package mytest.dubbo.service.impl;

import mytest.dubbo.service.TestService;

public class TestServiceImpl implements TestService {

	public String sayHello(String name) {
		return "Hello "+name;
	}

}
