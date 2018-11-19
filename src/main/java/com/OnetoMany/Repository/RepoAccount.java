package com.OnetoMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OnetoMany.dto.Account;

public interface RepoAccount extends JpaRepository<Account, Long> {

}
