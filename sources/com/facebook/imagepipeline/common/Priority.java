package com.facebook.imagepipeline.common;

public enum Priority {
    LOW,
    MEDIUM,
    HIGH;

    public static Priority getHigherPriority(Priority priority, Priority priority2) {
        return priority.ordinal() > priority2.ordinal() ? priority : priority2;
    }
}
