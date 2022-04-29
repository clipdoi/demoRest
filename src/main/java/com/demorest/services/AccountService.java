package com.demorest.services;

import java.util.List;

import com.demorest.models.Account;
import org.springframework.data.repository.query.Param;

public interface AccountService {
	List<Account> findAll();
	Account find(long id);
	Account save(Account p);
	boolean delete(long id);
	List<String> getRolesByAccountId(long id);
	Account findByUsername(String username);
	Account findByEmail(String username);
	void updateAccountById(String userName, String pw, String name, String email, boolean status, long id);
}
