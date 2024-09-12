package com.adapty.internal.utils;

import android.util.Log;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.adapty.utils.AdaptyLogHandler;
import com.adapty.utils.AdaptyLogLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\nH\bJ\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/utils/DefaultLogHandler;", "Lcom/adapty/utils/AdaptyLogHandler;", "()V", "log", "", "level", "Lcom/adapty/utils/AdaptyLogLevel;", "originalMessage", "", "logAction", "Lkotlin/Function1;", "onLogMessageReceived", "message", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultLogHandler.kt */
public final class DefaultLogHandler implements AdaptyLogHandler {
    @Deprecated
    private static final int CHUNK_MAX_LENGTH = 4000;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int MAX_CHUNKS = 5;
    @Deprecated
    private static final String TAG = "Adapty_v2.10.4";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/adapty/internal/utils/DefaultLogHandler$Companion;", "", "()V", "CHUNK_MAX_LENGTH", "", "MAX_CHUNKS", "TAG", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultLogHandler.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onLogMessageReceived(AdaptyLogLevel adaptyLogLevel, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(adaptyLogLevel, "level");
        Intrinsics.checkNotNullParameter(str, "message");
        int i = 0;
        if (Intrinsics.areEqual((Object) adaptyLogLevel, (Object) AdaptyLogLevel.ERROR)) {
            if (str.length() > CHUNK_MAX_LENGTH) {
                int coerceAtMost = RangesKt.coerceAtMost(str.length(), (int) AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                while (i < coerceAtMost) {
                    int i2 = (i / CHUNK_MAX_LENGTH) + 1;
                    if (coerceAtMost == str.length()) {
                        int coerceAtMost2 = RangesKt.coerceAtMost(i + CHUNK_MAX_LENGTH, coerceAtMost);
                        StringBuilder append = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                        String substring = str.substring(i, coerceAtMost2);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                        str5 = append.append(substring).toString();
                    } else if (i2 == 5) {
                        String str6 = " (total length: " + str.length() + ')';
                        int length = (i + CHUNK_MAX_LENGTH) - str6.length();
                        StringBuilder append2 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                        String substring2 = str.substring(i, length);
                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                        str5 = append2.append(substring2).append(str6).toString();
                    } else {
                        int i3 = i + CHUNK_MAX_LENGTH;
                        StringBuilder append3 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                        String substring3 = str.substring(i, i3);
                        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                        str5 = append3.append(substring3).toString();
                    }
                    Log.e(TAG, str5);
                    i += CHUNK_MAX_LENGTH;
                }
                return;
            }
            Log.e(TAG, adaptyLogLevel + ": " + str);
        } else if (Intrinsics.areEqual((Object) adaptyLogLevel, (Object) AdaptyLogLevel.WARN)) {
            if (str.length() > CHUNK_MAX_LENGTH) {
                int coerceAtMost3 = RangesKt.coerceAtMost(str.length(), (int) AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                while (i < coerceAtMost3) {
                    int i4 = (i / CHUNK_MAX_LENGTH) + 1;
                    if (coerceAtMost3 == str.length()) {
                        int coerceAtMost4 = RangesKt.coerceAtMost(i + CHUNK_MAX_LENGTH, coerceAtMost3);
                        StringBuilder append4 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i4).append(") ");
                        String substring4 = str.substring(i, coerceAtMost4);
                        Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
                        str4 = append4.append(substring4).toString();
                    } else if (i4 == 5) {
                        String str7 = " (total length: " + str.length() + ')';
                        int length2 = (i + CHUNK_MAX_LENGTH) - str7.length();
                        StringBuilder append5 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i4).append(") ");
                        String substring5 = str.substring(i, length2);
                        Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
                        str4 = append5.append(substring5).append(str7).toString();
                    } else {
                        int i5 = i + CHUNK_MAX_LENGTH;
                        StringBuilder append6 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i4).append(") ");
                        String substring6 = str.substring(i, i5);
                        Intrinsics.checkNotNullExpressionValue(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
                        str4 = append6.append(substring6).toString();
                    }
                    Log.w(TAG, str4);
                    i += CHUNK_MAX_LENGTH;
                }
                return;
            }
            Log.w(TAG, adaptyLogLevel + ": " + str);
        } else if (Intrinsics.areEqual((Object) adaptyLogLevel, (Object) AdaptyLogLevel.INFO)) {
            if (str.length() > CHUNK_MAX_LENGTH) {
                int coerceAtMost5 = RangesKt.coerceAtMost(str.length(), (int) AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                while (i < coerceAtMost5) {
                    int i6 = (i / CHUNK_MAX_LENGTH) + 1;
                    if (coerceAtMost5 == str.length()) {
                        int coerceAtMost6 = RangesKt.coerceAtMost(i + CHUNK_MAX_LENGTH, coerceAtMost5);
                        StringBuilder append7 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i6).append(") ");
                        String substring7 = str.substring(i, coerceAtMost6);
                        Intrinsics.checkNotNullExpressionValue(substring7, "this as java.lang.String…ing(startIndex, endIndex)");
                        str3 = append7.append(substring7).toString();
                    } else if (i6 == 5) {
                        String str8 = " (total length: " + str.length() + ')';
                        int length3 = (i + CHUNK_MAX_LENGTH) - str8.length();
                        StringBuilder append8 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i6).append(") ");
                        String substring8 = str.substring(i, length3);
                        Intrinsics.checkNotNullExpressionValue(substring8, "this as java.lang.String…ing(startIndex, endIndex)");
                        str3 = append8.append(substring8).append(str8).toString();
                    } else {
                        int i7 = i + CHUNK_MAX_LENGTH;
                        StringBuilder append9 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i6).append(") ");
                        String substring9 = str.substring(i, i7);
                        Intrinsics.checkNotNullExpressionValue(substring9, "this as java.lang.String…ing(startIndex, endIndex)");
                        str3 = append9.append(substring9).toString();
                    }
                    Log.i(TAG, str3);
                    i += CHUNK_MAX_LENGTH;
                }
                return;
            }
            Log.i(TAG, adaptyLogLevel + ": " + str);
        } else if (!Intrinsics.areEqual((Object) adaptyLogLevel, (Object) AdaptyLogLevel.VERBOSE)) {
        } else {
            if (str.length() > CHUNK_MAX_LENGTH) {
                int coerceAtMost7 = RangesKt.coerceAtMost(str.length(), (int) AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
                while (i < coerceAtMost7) {
                    int i8 = (i / CHUNK_MAX_LENGTH) + 1;
                    if (coerceAtMost7 == str.length()) {
                        int coerceAtMost8 = RangesKt.coerceAtMost(i + CHUNK_MAX_LENGTH, coerceAtMost7);
                        StringBuilder append10 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i8).append(") ");
                        String substring10 = str.substring(i, coerceAtMost8);
                        Intrinsics.checkNotNullExpressionValue(substring10, "this as java.lang.String…ing(startIndex, endIndex)");
                        str2 = append10.append(substring10).toString();
                    } else if (i8 == 5) {
                        String str9 = " (total length: " + str.length() + ')';
                        int length4 = (i + CHUNK_MAX_LENGTH) - str9.length();
                        StringBuilder append11 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i8).append(") ");
                        String substring11 = str.substring(i, length4);
                        Intrinsics.checkNotNullExpressionValue(substring11, "this as java.lang.String…ing(startIndex, endIndex)");
                        str2 = append11.append(substring11).append(str9).toString();
                    } else {
                        int i9 = i + CHUNK_MAX_LENGTH;
                        StringBuilder append12 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i8).append(") ");
                        String substring12 = str.substring(i, i9);
                        Intrinsics.checkNotNullExpressionValue(substring12, "this as java.lang.String…ing(startIndex, endIndex)");
                        str2 = append12.append(substring12).toString();
                    }
                    Log.v(TAG, str2);
                    i += CHUNK_MAX_LENGTH;
                }
                return;
            }
            Log.v(TAG, adaptyLogLevel + ": " + str);
        }
    }

    private final void log(AdaptyLogLevel adaptyLogLevel, String str, Function1<? super String, Unit> function1) {
        String str2;
        if (str.length() > CHUNK_MAX_LENGTH) {
            int coerceAtMost = RangesKt.coerceAtMost(str.length(), (int) AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
            for (int i = 0; i < coerceAtMost; i += CHUNK_MAX_LENGTH) {
                int i2 = (i / CHUNK_MAX_LENGTH) + 1;
                if (coerceAtMost == str.length()) {
                    int coerceAtMost2 = RangesKt.coerceAtMost(i + CHUNK_MAX_LENGTH, coerceAtMost);
                    StringBuilder append = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                    String substring = str.substring(i, coerceAtMost2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    str2 = append.append(substring).toString();
                } else if (i2 == 5) {
                    String str3 = " (total length: " + str.length() + ')';
                    int length = (i + CHUNK_MAX_LENGTH) - str3.length();
                    StringBuilder append2 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                    String substring2 = str.substring(i, length);
                    Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    str2 = append2.append(substring2).append(str3).toString();
                } else {
                    int i3 = i + CHUNK_MAX_LENGTH;
                    StringBuilder append3 = new StringBuilder().append(adaptyLogLevel).append(": (chunk ").append(i2).append(") ");
                    String substring3 = str.substring(i, i3);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    str2 = append3.append(substring3).toString();
                }
                function1.invoke(str2);
            }
            return;
        }
        function1.invoke(adaptyLogLevel + ": " + str);
    }
}
