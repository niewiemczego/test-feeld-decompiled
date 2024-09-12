package com.braze.ui.inappmessage;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/braze/ui/inappmessage/InAppMessageOperation;", "", "(Ljava/lang/String;I)V", "DISPLAY_NOW", "DISPLAY_LATER", "DISCARD", "REENQUEUE", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageOperation.kt */
public enum InAppMessageOperation {
    DISPLAY_NOW,
    DISPLAY_LATER,
    DISCARD,
    REENQUEUE;
    
    public static final Companion Companion = null;

    @JvmStatic
    public static final InAppMessageOperation fromValue(String str) {
        return Companion.fromValue(str);
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/InAppMessageOperation$Companion;", "", "()V", "fromValue", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "value", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InAppMessageOperation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final InAppMessageOperation fromValue(String str) {
            InAppMessageOperation[] values = InAppMessageOperation.values();
            int length = values.length;
            int i = 0;
            while (true) {
                String str2 = null;
                if (i >= length) {
                    return null;
                }
                InAppMessageOperation inAppMessageOperation = values[i];
                String name = inAppMessageOperation.name();
                if (str != null) {
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "US");
                    str2 = str.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toUpperCase(locale)");
                }
                if (Intrinsics.areEqual((Object) name, (Object) str2)) {
                    return inAppMessageOperation;
                }
                i++;
            }
        }
    }
}
