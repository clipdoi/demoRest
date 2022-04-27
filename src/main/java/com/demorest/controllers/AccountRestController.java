package com.demorest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demorest.dto.request.AccountIdRequest;
import com.demorest.dto.response.GetRolesOfAccountResponse;
import com.demorest.exception.DataNotFoundException;
import com.demorest.exception.InputInvalidException;
import com.demorest.models.Account;
import com.demorest.models.Role;
import com.demorest.services.AccountService;
import com.demorest.utils.constraints.ErrorConstraints;


@RestController
@RequestMapping("api/accounts")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("")
	public List<Account> findAll() {
		return accountService.findAll();
	}
	
	@GetMapping("/{id}/roles")
	public List<String> getRolesByAccountId(@Valid @PathVariable long id) {
		if (id <= 0) {
            throw new InputInvalidException(ErrorConstraints.INVALID_REQUEST);
        } 
		if(accountService.find(id) == null) {
			throw new DataNotFoundException(ErrorConstraints.ID_ACCOUNT_NOT_FOUND);
		}
		if(String.valueOf(id).isEmpty()) {
			throw new InputInvalidException(ErrorConstraints.INVALID_ID);
		}
		List<String> listRoles = accountService.getRolesByAccountId(id);
        return listRoles;
	}
	
}
