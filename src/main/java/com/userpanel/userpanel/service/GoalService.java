package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.request.CreateGoalRequest;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoalService {

    void createGoalCategory(MultipartFile image, String name, Authentication authentication);

    void createGoal(CreateGoalRequest createGoalRequest, MultipartFile file, Authentication authentication);

    List<GoalCategoryDTO> getAllCategories(Authentication authentication);
}
