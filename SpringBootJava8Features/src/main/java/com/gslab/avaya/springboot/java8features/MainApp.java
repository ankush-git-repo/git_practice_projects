package com.gslab.avaya.springboot.java8features;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.gslab.avaya.springboot.java8features.service.ForEachExample;
import com.gslab.avaya.springboot.java8features.service.FunctionalInterface1;
import com.gslab.avaya.springboot.java8features.service.FunctionalInterface2;

@SpringBootApplication
public class MainApp implements CommandLineRunner{

	@Autowired
	private ApplicationContext ctx;
	
		public static void main(String [] args) {
			SpringApplication.run(MainApp.class, args);
		}

		public void run(String... args) throws Exception {
			System.out.println("[Length of argument ="+args.length+"]");
			if(args.length>0) {
				if("foreach".equalsIgnoreCase(args[0]))
					ctx.getBean(ForEachExample.class).execute();
				else if("functionalinterface".equalsIgnoreCase(args[0])) {
					ctx.getBean(FunctionalInterface1.class).log("logging with interface1");
					ctx.getBean(FunctionalInterface1.class).method1("Calling from method1");
					ctx.getBean(FunctionalInterface2.class).log("logging with interface2");
				}
			}
		}
}
