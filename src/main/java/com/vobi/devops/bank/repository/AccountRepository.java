package com.vobi.devops.bank.repository;

import com.vobi.devops.bank.domain.Account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org/
* www.zathuracode.org
*
*/
public interface AccountRepository extends JpaRepository<Account, String> {
}
