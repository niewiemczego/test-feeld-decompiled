package com.appsflyer.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

public interface AFc1zSDK {
    AFa1vSDK AFInAppEventType(Context context);

    public static final class AFa1vSDK {
        public final float valueOf;
        public final String values;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1vSDK)) {
                return false;
            }
            AFa1vSDK aFa1vSDK = (AFa1vSDK) obj;
            return Intrinsics.areEqual((Object) Float.valueOf(this.valueOf), (Object) Float.valueOf(aFa1vSDK.valueOf)) && Intrinsics.areEqual((Object) this.values, (Object) aFa1vSDK.values);
        }

        public final int hashCode() {
            int hashCode = Float.hashCode(this.valueOf) * 31;
            String str = this.values;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public final String toString() {
            return new StringBuilder("BatteryData(level=").append(this.valueOf).append(", charging=").append(this.values).append(')').toString();
        }

        public AFa1vSDK(float f, String str) {
            this.valueOf = f;
            this.values = str;
        }
    }
}
