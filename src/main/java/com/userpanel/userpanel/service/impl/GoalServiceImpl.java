package com.userpanel.userpanel.service.impl;

import com.userpanel.userpanel.component.GoalTransformer;
import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.exception.goal.GoalAlreadyExistsException;
import com.userpanel.userpanel.exception.goal.GoalCategoryAlreadyExists;
import com.userpanel.userpanel.model.Account;
import com.userpanel.userpanel.model.Goal;
import com.userpanel.userpanel.model.GoalCategory;
import com.userpanel.userpanel.repository.AccountRepository;
import com.userpanel.userpanel.repository.GoalCategoryRepository;
import com.userpanel.userpanel.repository.GoalRepository;
import com.userpanel.userpanel.request.CreateGoalRequest;
import com.userpanel.userpanel.security.UserDetailsImpl;
import com.userpanel.userpanel.service.GoalService;
import com.userpanel.userpanel.util.FileUploader;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalCategoryRepository goalCategoryRepository;
    private final GoalRepository goalRepository;
    private final AccountRepository accountRepository;
    private final FileUploader fileUploader;
    private final GoalTransformer goalTransformer;

    @Override
    public void createGoalCategory(MultipartFile image, String name, Authentication authentication) {
        if (goalCategoryRepository.existsByName(name)) {
            throw new GoalCategoryAlreadyExists(name);
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByUserId(userDetails.getId());
        String filePath = fileUploader.uploadFile(image);
        GoalCategory goalCategory = new GoalCategory(name, filePath, account);
        goalCategoryRepository.save(goalCategory);
    }

    @Override
    public void createGoal(CreateGoalRequest createGoalRequest, MultipartFile file, Authentication authentication) {
        if (goalRepository.existsByName(createGoalRequest.getName())) {
            throw new GoalAlreadyExistsException(createGoalRequest.getName());
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByUserId(userDetails.getId());
        GoalCategory category = goalCategoryRepository.findByAccountId(account.getId());
        Goal goal = new Goal(
                createGoalRequest.getName(),
                createGoalRequest.getPrice(),
                createGoalRequest.isActive(),
                "",
                category,
                account
        );
        goalRepository.save(goal);
    }

    @Override
    public List<GoalCategoryDTO> getAllCategories(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        Account account = accountRepository.findByUserId(userDetails.getId());
        return goalCategoryRepository
                .findAllByAccountId(account.getId())
                .stream()
                .map(goalTransformer::toGoalCategoryDto)
                .toList();
    }
}
