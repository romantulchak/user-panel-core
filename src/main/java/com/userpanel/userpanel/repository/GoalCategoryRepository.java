package com.userpanel.userpanel.repository;

import com.userpanel.userpanel.model.GoalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GoalCategoryRepository extends JpaRepository<GoalCategory, UUID> {
}
