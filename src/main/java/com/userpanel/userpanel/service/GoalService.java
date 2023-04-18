package com.userpanel.userpanel.service;

import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoalService {

    void createGoalCategory(MultipartFile image, String name, Authentication authentication);

    List<GoalCategoryDTO> getAllCategories(Authentication authentication);
}
