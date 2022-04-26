package com.demorest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demorest.models.Account;
import com.demorest.services.AccountService;


@RestController
@RequestMapping("api/account")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
}
