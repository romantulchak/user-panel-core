package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FinanceRepository extends JpaRepository<Finance, UUID> {
}
