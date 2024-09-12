package com.braze.support;

import android.os.Build;
import android.os.SystemClock;
import com.braze.enums.BrazeDateFormat;
import com.braze.support.BrazeLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a>\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bH\u0007\u001a\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013\u001a\u0006\u0010\u0014\u001a\u00020\u0001\u001a\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0006\u0010\u0016\u001a\u00020\u0017\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0001\u001a\u001e\u0010\u0018\u001a\u00020\u0004*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0007\u001a \u0010\u001a\u001a\u00020\u0004*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0000\u001a\n\u0010\u001b\u001a\u00020\u0001*\u00020\t\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0004\u001a\u0012\u0010\u001e\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"MINIMUM_NETWORK_TIME", "", "MSECS_IN_SEC", "TAG", "", "UTC_TIME_ZONE", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "createDate", "Ljava/util/Date;", "year", "", "month", "day", "hours", "minutes", "seconds", "formatDateNow", "dateFormat", "Lcom/braze/enums/BrazeDateFormat;", "nowInMilliseconds", "nowInSeconds", "nowInSecondsPrecise", "", "formatDate", "timeZone", "formatDateFromMillis", "getTimeFromEpochInSeconds", "isValidTimeZone", "", "parseDate", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateTimeUtils {
    private static final long MINIMUM_NETWORK_TIME = 1691768838316L;
    private static final long MSECS_IN_SEC = 1000;
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("DateTimeUtils");
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error reading date and time from network. Using system time instead.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception parsing date " + this.b + ". Returning null";
        }
    }

    public static final Date createDate(int i, int i2, int i3) {
        return createDate$default(i, i2, i3, 0, 0, 0, 56, (Object) null);
    }

    public static /* synthetic */ Date createDate$default(int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        return createDate(i, i2, i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6);
    }

    public static final String formatDate(Date date, BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        return formatDate$default(date, brazeDateFormat, (TimeZone) null, 2, (Object) null);
    }

    public static /* synthetic */ String formatDate$default(Date date, BrazeDateFormat brazeDateFormat, TimeZone timeZone, int i, Object obj) {
        if ((i & 2) != 0) {
            timeZone = UTC_TIME_ZONE;
            Intrinsics.checkNotNullExpressionValue(timeZone, "UTC_TIME_ZONE");
        }
        return formatDate(date, brazeDateFormat, timeZone);
    }

    public static final String formatDateFromMillis(long j, BrazeDateFormat brazeDateFormat, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return formatDate(new Date(j), brazeDateFormat, timeZone);
    }

    public static /* synthetic */ String formatDateFromMillis$default(long j, BrazeDateFormat brazeDateFormat, TimeZone timeZone, int i, Object obj) {
        if ((i & 1) != 0) {
            brazeDateFormat = BrazeDateFormat.ANDROID_LOGCAT;
        }
        if ((i & 2) != 0) {
            timeZone = TimeZone.getDefault();
            Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        }
        return formatDateFromMillis(j, brazeDateFormat, timeZone);
    }

    public static final String formatDateNow(BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        Date createDate = createDate(nowInSeconds());
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        return formatDate(createDate, brazeDateFormat, timeZone);
    }

    public static final long getTimeFromEpochInSeconds(Date date) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        return TimeUnit.MILLISECONDS.toSeconds(date.getTime());
    }

    public static final boolean isValidTimeZone(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String[] availableIDs = TimeZone.getAvailableIDs();
        Intrinsics.checkNotNullExpressionValue(availableIDs, "getAvailableIDs()");
        return ArraysKt.contains((T[]) availableIDs, str);
    }

    public static final long nowInMilliseconds() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (Build.VERSION.SDK_INT < 33) {
                return currentTimeMillis;
            }
            long millis = SystemClock.currentNetworkTimeClock().millis();
            return millis < MINIMUM_NETWORK_TIME ? currentTimeMillis : millis;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) a.b);
            return currentTimeMillis;
        }
    }

    public static final long nowInSeconds() {
        return TimeUnit.MILLISECONDS.toSeconds(nowInMilliseconds());
    }

    public static final double nowInSecondsPrecise() {
        return ((double) nowInMilliseconds()) / 1000.0d;
    }

    public static final Date parseDate(String str, BrazeDateFormat brazeDateFormat) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(brazeDateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
        try {
            Date parse = simpleDateFormat.parse(str);
            Intrinsics.checkNotNull(parse);
            return parse;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new b(str));
            throw e;
        }
    }

    public static final Date createDate(int i, int i2, int i3, int i4) {
        return createDate$default(i, i2, i3, i4, 0, 0, 48, (Object) null);
    }

    public static final String formatDate(Date date, BrazeDateFormat brazeDateFormat, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(brazeDateFormat, "dateFormat");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(brazeDateFormat.getFormat(), Locale.US);
        simpleDateFormat.setTimeZone(timeZone);
        String format = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(format, "simpleDateFormat.format(this)");
        return format;
    }

    public static final Date createDate(int i, int i2, int i3, int i4, int i5) {
        return createDate$default(i, i2, i3, i4, i5, 0, 32, (Object) null);
    }

    public static final Date createDate(int i, int i2, int i3, int i4, int i5, int i6) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(i, i2, i3, i4, i5, i6);
        gregorianCalendar.setTimeZone(UTC_TIME_ZONE);
        Date time = gregorianCalendar.getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        return time;
    }

    public static final Date createDate(long j) {
        return new Date(j * 1000);
    }
}
