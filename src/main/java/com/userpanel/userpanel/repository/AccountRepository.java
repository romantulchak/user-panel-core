package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    Account findByUserId(UUID userId);

    @Query(value = "SELECT a.id FROM Account a WHERE a.user.id = ?1")
    Optional<UUID> findAccountIdByUserId(UUID userId);
}
