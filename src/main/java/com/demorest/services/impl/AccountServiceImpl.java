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
	public List<String> getRolesByAccountId(long id) {
		return accountRepository.getRolesByAccountId(id);
	}

	@Override
	public Account findByUsername(String username) {
		return accountRepository.findAccountByUsername(username);
	}

	@Override
	public Account findByEmail(String email) {
		return accountRepository.findAccountByEmail(email);
	}

	@Override
	public void updateAccountById(String userName, String pw, String name, String email, boolean status, long id) {
		accountRepository.updateAccountById(userName, pw, name, email, status, id);
	}

}
