package com.userpanel.userpanel.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.dto.goal.GoalDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface GoalService {

    void createGoalCategory(MultipartFile image, String name, Authentication authentication);

    void createGoal(String createGoalRequestString, MultipartFile file, Authentication authentication) throws JsonProcessingException;

    List<GoalCategoryDTO> getAllCategories(Authentication authentication);

    List<GoalDTO> getGoals(Authentication authentication);

    boolean updateStatus(UUID id, Authentication authentication);
}
