package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Account findByUserId(UUID userId);
}
