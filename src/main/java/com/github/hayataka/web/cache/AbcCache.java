package com.github.hayataka.web.cache;

import com.github.hayataka.web.cache.client.SampleError;

/**
 * ここも正常
 * @author hayakawatakahiko
 *
 */
public class AbcCache {
	/**
	 * hello.
	 * @return hello world
	 */
	public String hello() {
		return "hello world";
	}
	/**
	 * nagasa
	 * @param name userName
	 * @return length
	 */
	public int say(String name) {
		return name == null ? 0: name.length();
	}
	
	public SampleError test(SampleError e) {
		return new SampleError();
	}
}
