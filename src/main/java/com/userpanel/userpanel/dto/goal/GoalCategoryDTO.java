package com.userpanel.userpanel.dto.goal;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.UUID;

@Value
@AllArgsConstructor
public class GoalCategoryDTO {

    UUID id;
    String name;
    String image;
}
