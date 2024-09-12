package com.facebook.common.internal;

public class Ints {
    private Ints() {
    }

    public static int max(int... iArr) {
        Preconditions.checkArgument(Boolean.valueOf(iArr.length > 0));
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 > i) {
                i = i3;
            }
        }
        return i;
    }
}
