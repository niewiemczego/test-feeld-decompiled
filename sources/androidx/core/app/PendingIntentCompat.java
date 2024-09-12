package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PendingIntentCompat {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getActivities(context, i, intentArr, addMutabilityFlags(z, i2), bundle);
        }
        return PendingIntent.getActivities(context, i, intentArr, i2);
    }

    public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, boolean z) {
        return PendingIntent.getActivities(context, i, intentArr, addMutabilityFlags(z, i2));
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getActivity(context, i, intent, addMutabilityFlags(z, i2));
    }

    public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle, boolean z) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getActivity(context, i, intent, addMutabilityFlags(z, i2), bundle);
        }
        return PendingIntent.getActivity(context, i, intent, i2);
    }

    public static PendingIntent getBroadcast(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getBroadcast(context, i, intent, addMutabilityFlags(z, i2));
    }

    public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2, boolean z) {
        return Api26Impl.getForegroundService(context, i, intent, addMutabilityFlags(z, i2));
    }

    public static PendingIntent getService(Context context, int i, Intent intent, int i2, boolean z) {
        return PendingIntent.getService(context, i, intent, addMutabilityFlags(z, i2));
    }

    private static int addMutabilityFlags(boolean z, int i) {
        int i2;
        if (z) {
            if (Build.VERSION.SDK_INT < 31) {
                return i;
            }
            i2 = 33554432;
        } else if (Build.VERSION.SDK_INT < 23) {
            return i;
        } else {
            i2 = 67108864;
        }
        return i | i2;
    }

    private PendingIntentCompat() {
    }

    private static class Api16Impl {
        private Api16Impl() {
        }

        public static PendingIntent getActivities(Context context, int i, Intent[] intentArr, int i2, Bundle bundle) {
            return PendingIntent.getActivities(context, i, intentArr, i2, bundle);
        }

        public static PendingIntent getActivity(Context context, int i, Intent intent, int i2, Bundle bundle) {
            return PendingIntent.getActivity(context, i, intent, i2, bundle);
        }
    }

    private static class Api26Impl {
        private Api26Impl() {
        }

        public static PendingIntent getForegroundService(Context context, int i, Intent intent, int i2) {
            return PendingIntent.getForegroundService(context, i, intent, i2);
        }
    }
}
