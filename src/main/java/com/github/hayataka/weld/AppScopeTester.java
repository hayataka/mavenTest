package com.github.hayataka.weld;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppScopeTester {

	private Date thisTime = new Date();
	
	public Date time () {
		
		new RuntimeException();
		return thisTime;
	}
}
