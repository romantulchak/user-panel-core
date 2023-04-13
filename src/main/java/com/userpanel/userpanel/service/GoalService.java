package com.userpanel.userpanel.service;

import org.springframework.web.multipart.MultipartFile;

public interface GoalService {

    void createGoalCategory(MultipartFile image, String name);
}
