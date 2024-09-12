package com.swmansion.reanimated.keyboard;

public enum KeyboardState {
    UNKNOWN(0),
    OPENING(1),
    OPEN(2),
    CLOSING(3),
    CLOSED(4);
    
    private final int mValue;

    private KeyboardState(int i) {
        this.mValue = i;
    }

    public int asInt() {
        return this.mValue;
    }
}
