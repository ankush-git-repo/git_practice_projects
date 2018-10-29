package com.gslab.avaya.springbootwebapp.controller;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gslab.avaya.springbootwebapp.model.User;
import com.gslab.avaya.springbootwebapp.service.GitHubLookupService;

@Controller
public class WelcomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);
	
	@Autowired
	private GitHubLookupService gitHubLookupService;
	
	@RequestMapping(value="/welcome")
	public ModelAndView greeting() throws Exception{
		//Start the clock 
		long start = System.currentTimeMillis();
		
        // Kick of multiple, asynchronous lookups
        CompletableFuture<User> page1 = gitHubLookupService.findUser("PivotalSoftware");
        CompletableFuture<User> page2 = gitHubLookupService.findUser("CloudFoundry");
        CompletableFuture<User> page3 = gitHubLookupService.findUser("Spring-Projects");

        // Wait until they are all done
        CompletableFuture.allOf(page1,page2,page3).join();

        // Print results, including elapsed time
        LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
        System.out.println("--> " + page1.get());
        System.out.println("--> " + page2.get());
        System.out.println("--> " + page3.get());
        
        LOGGER.info("--> " + page1.get());
        LOGGER.info("--> " + page2.get());
        LOGGER.info("--> " + page3.get());
		return new ModelAndView("welcome");
	}
}
