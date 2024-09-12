package com.facebook.gamingservices.internal;

import android.os.Build;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/gamingservices/internal/DateFormatter;", "", "()V", "format", "Ljava/time/ZonedDateTime;", "isoDate", "", "format$facebook_gamingservices_release", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DateFormatter.kt */
public final class DateFormatter {
    public static final DateFormatter INSTANCE = new DateFormatter();

    private DateFormatter() {
    }

    public final ZonedDateTime format$facebook_gamingservices_release(String str) {
        Intrinsics.checkNotNullParameter(str, "isoDate");
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
        Intrinsics.checkNotNullExpressionValue(ofPattern, "ofPattern(\"yyyy-MM-dd'T'HH:mm:ssZ\")");
        return ZonedDateTime.parse(str, ofPattern);
    }
}
