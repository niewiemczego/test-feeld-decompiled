package com.facebook.appevents.cloudbridge;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventType;", "", "(Ljava/lang/String;I)V", "MOBILE_APP_INSTALL", "CUSTOM", "OTHER", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventsConversionsAPITransformer.kt */
public enum AppEventType {
    MOBILE_APP_INSTALL,
    CUSTOM,
    OTHER;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/facebook/appevents/cloudbridge/AppEventType$Companion;", "", "()V", "invoke", "Lcom/facebook/appevents/cloudbridge/AppEventType;", "rawValue", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventsConversionsAPITransformer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AppEventType invoke(String str) {
            Intrinsics.checkNotNullParameter(str, "rawValue");
            Companion companion = this;
            if (Intrinsics.areEqual((Object) str, (Object) "MOBILE_APP_INSTALL")) {
                return AppEventType.MOBILE_APP_INSTALL;
            }
            if (Intrinsics.areEqual((Object) str, (Object) "CUSTOM_APP_EVENTS")) {
                return AppEventType.CUSTOM;
            }
            return AppEventType.OTHER;
        }
    }
}
