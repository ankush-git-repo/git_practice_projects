package com.gslab.avaya.springboot.java8features.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.gslab.avaya.springboot.java8features.service.ForEachExample;

@Service
public class ForEachExampleImpl implements ForEachExample {

	public void execute() {
		
		//Sample collection to add 10 integer numbers
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0; i<10; i++) myList.add(i);
		
		System.out.println("Iterate value using simple iterator-");
		//traversing using iterator
		Iterator<Integer> it = myList.iterator();
		while(it.hasNext()) {
			Integer i = it.next();
			System.out.println("<Iterator value ::" + i +">");
		}
		
		System.out.println("\n Iterate using java 6");
		//traversing using java 6
		for(Integer i: myList) {
			System.out.println("<Iterator using java6 ::" + i +">");
		}
		
		System.out.println("\n Iterate using java8, comsumer interface");
		//traversing through forEach method of iterable with anonymous class
		myList.forEach(new Consumer<Integer>() {
			public void accept(Integer t) {
				System.out.println("<ForEach anonymous class value ::" + t +">");
			}
		});		
		
	}

}
