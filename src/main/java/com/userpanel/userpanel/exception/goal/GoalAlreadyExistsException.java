package com.userpanel.userpanel.exception.goal;

public class GoalAlreadyExistsException extends RuntimeException {

    public GoalAlreadyExistsException(String name) {
        super(String.format("Goal %s already exists", name));
    }
}
