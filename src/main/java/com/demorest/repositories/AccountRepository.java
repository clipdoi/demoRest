package com.demorest.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demorest.models.Account;

@Repository("accountRepository")
public interface AccountRepository extends JpaRepository<Account, Long> {
	// JPQL
	@Query(value = "select * from Account",  nativeQuery = true)
    public List<Account> findAllAccount();
}
