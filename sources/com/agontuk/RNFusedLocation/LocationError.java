package com.agontuk.RNFusedLocation;

public enum LocationError {
    PERMISSION_DENIED(1),
    POSITION_UNAVAILABLE(2),
    TIMEOUT(3),
    PLAY_SERVICE_NOT_AVAILABLE(4),
    SETTINGS_NOT_SATISFIED(5),
    INTERNAL_ERROR(-1);
    
    private final int value;

    private LocationError(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
