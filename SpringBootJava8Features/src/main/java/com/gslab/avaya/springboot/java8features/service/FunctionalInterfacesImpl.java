package com.gslab.avaya.springboot.java8features.service;

import org.springframework.stereotype.Service;

@Service
public class FunctionalInterfacesImpl implements FunctionalInterface1, FunctionalInterface2 {

	@Override
	public void method2() {
		System.out.println("Implementation for method2 from Functionalinterface2");

	}

	@Override
	public void method1(String str) {
		System.out.println("Implementation for method1 from FuncitonalInterface1");

	}

	@Override
	public void log(String str) {
		FunctionalInterface1.super.log(str);
		FunctionalInterface1.print("FunctoinalInterface1 print method calling...");
			
	}

}
