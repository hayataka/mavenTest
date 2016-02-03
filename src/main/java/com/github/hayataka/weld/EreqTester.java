package com.github.hayataka.weld;


import javax.enterprise.context.RequestScoped;

@RequestScoped
public class EreqTester {

	public int diff(int x, int y) {
		return Math.abs(x - y);
	}
	
}
