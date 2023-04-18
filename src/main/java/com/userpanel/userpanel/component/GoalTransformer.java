package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.projection.goal.GoalCategoryProjection;
import org.springframework.stereotype.Component;

@Component
public class GoalTransformer {

    public GoalCategoryDTO toGoalCategoryDto(GoalCategoryProjection goalCategory) {
        return new GoalCategoryDTO(goalCategory.getId(), goalCategory.getName(), goalCategory.getIconPath());
    }
}
