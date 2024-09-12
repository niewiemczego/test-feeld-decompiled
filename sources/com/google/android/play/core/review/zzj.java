package com.google.android.play.core.review;

import android.os.Bundle;
import com.google.android.play.core.review.internal.zzi;
import io.sentry.SentryBaseEvent;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.play:review@@2.0.1 */
public final class zzj {
    private static final Set zza = new HashSet(Arrays.asList(new String[]{"native", "unity"}));
    private static final Map zzb = new HashMap();
    private static final zzi zzc = new zzi("PlayCoreVersion");

    public static Bundle zza() {
        Bundle bundle = new Bundle();
        Map zzb2 = zzb();
        bundle.putInt("playcore_version_code", ((Integer) zzb2.get(SentryBaseEvent.DEFAULT_PLATFORM)).intValue());
        if (zzb2.containsKey("native")) {
            bundle.putInt("playcore_native_version", ((Integer) zzb2.get("native")).intValue());
        }
        if (zzb2.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) zzb2.get("unity")).intValue());
        }
        return bundle;
    }

    public static synchronized Map zzb() {
        Map map;
        synchronized (zzj.class) {
            map = zzb;
            map.put(SentryBaseEvent.DEFAULT_PLATFORM, 11004);
        }
        return map;
    }
}
