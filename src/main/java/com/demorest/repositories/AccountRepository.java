package com.demorest.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demorest.models.Account;
import com.demorest.models.Role;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
	// JPQL
	@Query(value = "select * from account",  nativeQuery = true)
    List<Account> findAllAccount();
	
	@Query(value = "select r.name from account a, account_role ar join \"role\" r on ar.roleid = r.id where ar.accid = a.id and a.id = :id",  nativeQuery = true)
    List<String> getRolesByAccountId(@Param("id") long id);
}
