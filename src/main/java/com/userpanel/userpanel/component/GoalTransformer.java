package com.userpanel.userpanel.component;

import com.userpanel.userpanel.dto.goal.GoalCategoryDTO;
import com.userpanel.userpanel.dto.goal.GoalDTO;
import com.userpanel.userpanel.projection.goal.GoalCategoryProjection;
import com.userpanel.userpanel.projection.goal.GoalProjection;
import org.springframework.stereotype.Component;

@Component
public class GoalTransformer {

    public GoalCategoryDTO toGoalCategoryDto(GoalCategoryProjection goalCategory) {
        return new GoalCategoryDTO(goalCategory.getId(), goalCategory.getName(), goalCategory.getIconPath());
    }

    public GoalDTO toGoalDto(GoalProjection goalProjection, double currentMoney) {
        double percentToCompletion = (currentMoney / goalProjection.getPrice()) * 100;
        return new GoalDTO(
                goalProjection.getId(),
                goalProjection.getName(),
                goalProjection.getPrice(),
                goalProjection.getIsActive(),
                toGoalCategoryDto(goalProjection.getCategory()),
                goalProjection.getAddDate(),
                percentToCompletion
        );
    }
}
