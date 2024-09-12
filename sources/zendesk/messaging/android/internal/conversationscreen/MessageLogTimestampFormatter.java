package zendesk.messaging.android.internal.conversationscreen;

import android.content.Context;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;", "", "context", "Landroid/content/Context;", "locale", "Ljava/util/Locale;", "is24HourFormat", "", "(Landroid/content/Context;Ljava/util/Locale;Z)V", "dayAndTimeFormat", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "timeOnlyFormat", "dayAndTime", "", "timestamp", "Ljava/time/LocalDateTime;", "timeOnly", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogTimestampFormatter.kt */
public final class MessageLogTimestampFormatter {
    private final DateTimeFormatter dayAndTimeFormat;
    private final DateTimeFormatter timeOnlyFormat;

    public MessageLogTimestampFormatter(Context context, Locale locale, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.timeOnlyFormat = DateTimeFormatter.ofPattern(z ? "H:mm" : "h:mm a", locale);
        this.dayAndTimeFormat = DateTimeFormatter.ofPattern(z ? "MMMM d, H:mm" : "MMMM d, h:mm a", locale);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageLogTimestampFormatter(android.content.Context r1, java.util.Locale r2, boolean r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000d
            java.util.Locale r2 = java.util.Locale.getDefault()
            java.lang.String r5 = "getDefault()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
        L_0x000d:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0015
            boolean r3 = android.text.format.DateFormat.is24HourFormat(r1)
        L_0x0015:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter.<init>(android.content.Context, java.util.Locale, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String timeOnly(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "timestamp");
        String format = this.timeOnlyFormat.format(localDateTime);
        Intrinsics.checkNotNullExpressionValue(format, "timeOnlyFormat.format(timestamp)");
        return format;
    }

    public final String dayAndTime(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "timestamp");
        String format = this.dayAndTimeFormat.format(localDateTime);
        Intrinsics.checkNotNullExpressionValue(format, "dayAndTimeFormat.format(timestamp)");
        return format;
    }
}
