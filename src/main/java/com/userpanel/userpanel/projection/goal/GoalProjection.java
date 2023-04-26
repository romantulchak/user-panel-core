package com.userpanel.userpanel.projection.goal;

import java.time.LocalDate;
import java.util.UUID;

public interface GoalProjection {

    UUID getId();
    String getName();

    double getPrice();

    boolean getIsActive();

    String getIconPath();

    GoalCategoryProjection getCategory();

    LocalDate getAddDate();
}
