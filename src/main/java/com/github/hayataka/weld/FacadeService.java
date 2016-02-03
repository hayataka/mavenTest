package com.github.hayataka.weld;

import java.util.Date;

import javax.inject.*;

public class FacadeService {

	@Inject
	private NonAnnoTester nonAnnoTester;
	@Inject
	private AppScopeTester appScopeTester;
	
	public Date appTime() {
		return appScopeTester.time();
	}
	
	public int nonA(int x, int y) {
		return nonAnnoTester.plus(x, y);
	}
}
