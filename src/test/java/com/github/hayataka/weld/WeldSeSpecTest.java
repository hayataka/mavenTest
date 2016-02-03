package com.github.hayataka.weld;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Instance;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

public class WeldSeSpecTest {


	@Test
	public void test() {

		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		Instance<Object> instance = container.instance();
		AppScopeTester appScopeTester = instance.select(AppScopeTester.class).get();
		Date time = appScopeTester.time();
		System.out.println(time);
		Assert.assertNotNull(time);

		FacadeService fs = instance.select(FacadeService.class).get();
		System.out.println(fs.appTime());
		System.out.println(fs.nonA(3, 4));

		Swithcer sw = instance.select(Swithcer.class).get();
		Map<String, Object> requestDataStore = new HashMap<>();
		sw.startRequest(requestDataStore);

		EreqTester ereqTester = instance.select(EreqTester.class).get();
		ereqTester.diff(3, 4);
		System.out.println("ここまで来た");
		sw.endRequest(requestDataStore);

		weld.shutdown();

	}

	//
	// @Test(expected=Exception.class)
	// public void errPattern() {
	// EreqTester ereq = instance.select(EreqTester.class).get();
	// System.out.println(ereq.diff(4, 1));
	// }

}
