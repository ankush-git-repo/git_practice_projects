package com.gslab.avaya.springbootwebapp.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gslab.avaya.springbootwebapp.model.User;

@Service
public class GitHubLookupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GitHubLookupService.class);
	
	private final RestTemplate restTemplate;

	public GitHubLookupService(RestTemplateBuilder restTemplateBuilder) {
		
		this.restTemplate = restTemplateBuilder.build();
	}
	
	public CompletableFuture<User> findUser(String user) throws InterruptedException {
		LOGGER.info("Looking up " + user);
		System.out.println("Looking up " + user);
        String url = String.format("https://api.github.com/users/%s", user);
        User results = restTemplate.getForObject(url, User.class);
        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
	}
}
