package com.userpanel.userpanel.exception.goal;

public class GoalNotFoundException extends RuntimeException {

    public GoalNotFoundException() {
        super("Goal not found exception");
    }
}
