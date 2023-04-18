package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.service.GoalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/goal")
@CrossOrigin(value = "*", maxAge = 3600L)
@RequiredArgsConstructor
public class GoalRestController {

    private final GoalService goalService;

    @PostMapping("/category/{name}")
    public void createGoalCategory(@NotNull @Valid @RequestPart(value = "file") MultipartFile image,
                                   @NotNull @Valid @PathVariable("name") String name,
                                   Authentication authentication
    ) {
        goalService.createGoalCategory(image, name, authentication);
    }

    @GetMapping("/categories")
    public List<GoalCategoryDTO> getAllCategories(Authentication authentication) {
        return goalService.getAllCategories(authentication);
    }
}
