package com.userpanel.userpanel.exception.goal;

public class GoalCategoryAlreadyExists extends RuntimeException {

    public GoalCategoryAlreadyExists(String name) {
        super(String.format("Goal category with name %s already exists", name));
    }
}
