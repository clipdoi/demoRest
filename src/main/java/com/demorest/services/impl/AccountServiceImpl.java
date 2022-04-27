package com.demorest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demorest.models.Account;
import com.demorest.repositories.AccountRepository;
import com.demorest.services.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Account find(long id) {
		return accountRepository.findById(id).get();
	}

	@Override
	public Account save(Account a) {
		return accountRepository.save(a);
	}

	@Override
	public boolean delete(long id) {
		try {
			accountRepository.deleteById(id);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Account> findAllAccount() {
		return accountRepository.findAllAccount();
	}

	@Override
	public List<String> getRolesByAccountId(long id) {
		return accountRepository.getRolesByAccountId(id);
	}
	
}
