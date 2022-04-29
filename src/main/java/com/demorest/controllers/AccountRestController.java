package com.demorest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.demorest.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.demorest.exception.DataNotFoundException;
import com.demorest.exception.InputInvalidException;
import com.demorest.models.Account;

import com.demorest.services.AccountService;
import com.demorest.utils.constraints.ErrorConstraints;

@RestController
@RequestMapping("api")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
	@GetMapping("/account/{id}/roles")
	public List<String> getRolesByAccountId(@PathVariable long id) {
		if (id <= 0) {
            throw new InputInvalidException(ErrorConstraints.INVALID_REQUEST);
        } 
		if(accountService.find(id) == null) {
			throw new DataNotFoundException(ErrorConstraints.ACCOUNT_NOT_FOUND);
		}
		if(String.valueOf(id).isEmpty()) {
			throw new InputInvalidException(ErrorConstraints.INVALID_ID);
		}
		List<String> listRoles = accountService.getRolesByAccountId(id);
        return listRoles;
	}

	@PostMapping("/account")
	@ResponseBody
	public Account createAccount(@RequestBody Account account) {
		if(account != null) {
//			String username = accountService.findByUsername(account.getUsername()).getUsername();
//			String email = accountService.findByEmail(account.getEmail()).getEmail();
//			if(username.equals(account.getUsername()) && email.equals(account.getEmail())) {
//				throw new DataNotFoundException(ErrorConstraints.ACCOUNT_EXIST);
//			}
			if (!EmailUtils.isEmail(account.getEmail())){
				throw new InputInvalidException(ErrorConstraints.INVALID_EMAIL);
			}
			return accountService.save(account);
		} else {
			throw new InputInvalidException(ErrorConstraints.INVALID_REQUEST);
		}
	}

	@PutMapping("/account/{id}")
	@ResponseBody
	public Account updateAccount(@PathVariable long id, @RequestBody Account account) {
			Account acc = accountService.find(id);
			if (acc != null) {
				if (!EmailUtils.isEmail(account.getEmail())) {
					throw new InputInvalidException(ErrorConstraints.INVALID_EMAIL);
				} else if (acc.getUsername().equals(account.getUsername())) {
					throw new DataNotFoundException(ErrorConstraints.USERNAME_EXIST);
				} else {
					accountService.updateAccountById(account.getUsername(), account.getPassword(), account.getName(),
							account.getEmail(), account.isStatus(), id);
				}
			}
			return accountService.find(id);
	}

	@DeleteMapping("/account/{id}")
	public Account deleteAccount(@PathVariable long id) {
		Account account = accountService.find(id);
		account.setStatus(false);
		accountService.save(account);
		return account;
	}
}
