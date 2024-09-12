package com.facebook.gamingservices.cloudgaming.internal;

public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");
    
    private final String mStringValue;

    private SDKShareIntentEnum(String str) {
        this.mStringValue = str;
    }

    public String toString() {
        return this.mStringValue;
    }

    public static String validate(String str) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(str)) {
                return str;
            }
        }
        return null;
    }

    public static SDKShareIntentEnum fromString(String str) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(str)) {
                return sDKShareIntentEnum;
            }
        }
        return null;
    }
}
