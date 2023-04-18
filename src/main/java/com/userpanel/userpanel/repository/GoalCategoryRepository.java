package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.GoalCategory;
import com.userpanel.userpanel.projection.goal.GoalCategoryProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GoalCategoryRepository extends JpaRepository<GoalCategory, UUID> {

    Boolean existsByName(String name);

    List<GoalCategoryProjection> findAllByAccountId(UUID accountId);
}
