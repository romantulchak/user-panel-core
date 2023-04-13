package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.model.GoalCategory;
import com.userpanel.userpanel.repository.GoalCategoryRepository;
import com.userpanel.userpanel.service.GoalService;
import com.userpanel.userpanel.util.FileUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalCategoryRepository goalCategoryRepository;
    private final FileUploader fileUploader;

    @Override
    public void createGoalCategory(MultipartFile image, String name) {
        String filePath = fileUploader.uploadFile(image);
        GoalCategory goalCategory = new GoalCategory()
                .setName(name)
                .setIconPath(filePath);
        goalCategoryRepository.save(goalCategory);
    }
}
