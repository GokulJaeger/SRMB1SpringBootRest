package com.org.springrest4.springrest4.repository;

import java.util.List;

import com.org.springrest4.springrest4.model.Account;
import com.org.springrest4.springrest4.model.AccountId;

import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, AccountId> {

    List<Account> findByAccountType(String accountType);
}
