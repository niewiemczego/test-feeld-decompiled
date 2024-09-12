package zendesk.android.internal.extension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/android/internal/extension/DateTimeExt;", "", "()V", "iso8601DateFormat", "Ljava/text/SimpleDateFormat;", "currentIso8601UtcTimestamp", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DateTimeExt.kt */
public final class DateTimeExt {
    public static final DateTimeExt INSTANCE = new DateTimeExt();
    private static final SimpleDateFormat iso8601DateFormat;

    private DateTimeExt() {
    }

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        iso8601DateFormat = simpleDateFormat;
    }

    public final String currentIso8601UtcTimestamp() {
        String format = iso8601DateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "iso8601DateFormat.format(Date())");
        return format;
    }
}
