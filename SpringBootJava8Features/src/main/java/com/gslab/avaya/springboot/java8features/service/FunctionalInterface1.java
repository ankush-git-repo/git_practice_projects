package com.gslab.avaya.springboot.java8features.service;

@FunctionalInterface
public interface FunctionalInterface1 {
	void method1(String str);
	
	default void log(String str) {
		System.out.println("FunctionalInteface1 logging " + str);
	}
	
	static void print(String str) {
		System.out.println("FunctionalInteface1 printing " + str);
	}
}
