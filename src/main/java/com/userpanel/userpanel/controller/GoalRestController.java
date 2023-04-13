package com.userpanel.userpanel.controller;

import com.userpanel.userpanel.service.GoalService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/api/v1/goal")
@CrossOrigin(value = "*", maxAge = 3600L)
@RequiredArgsConstructor
public class GoalRestController {

    private final GoalService goalService;

    @PostMapping("/category/{name}")
    public void createGoalCategory(@NotNull @Valid @RequestPart(value = "image") MultipartFile image,
                                   @NotNull @Valid @PathVariable("name") String name
    ) {
        goalService.createGoalCategory(image, name);
    }

}
