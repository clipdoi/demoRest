package com.demorest.services;

import java.util.Date;
import java.util.List;

import com.demorest.models.Account;

public interface AccountService {
	List<Account> findAll();
	Account find(long id);
	Account save(Account p);
	boolean delete(long id);
	List<Account> findAllAccount();
}
