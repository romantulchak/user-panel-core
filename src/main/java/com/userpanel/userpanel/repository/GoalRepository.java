package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

    Boolean existsByName(String name);
}
