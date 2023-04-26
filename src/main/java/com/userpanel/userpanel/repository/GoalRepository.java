package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.Goal;
import com.userpanel.userpanel.projection.goal.GoalProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalRepository extends JpaRepository<Goal, UUID> {

    Boolean existsByName(String name);

    Slice<GoalProjection> findAllByAccountId(UUID accountId, Pageable pageable);
}
