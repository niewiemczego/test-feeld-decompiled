package zendesk.android.messaging;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lzendesk/android/messaging/UrlSource;", "", "(Ljava/lang/String;I)V", "TEXT", "CAROUSEL", "FILE", "IMAGE", "LINK_MESSAGE_ACTION", "WEBVIEW_MESSAGE_ACTION", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UrlSource.kt */
public enum UrlSource {
    TEXT,
    CAROUSEL,
    FILE,
    IMAGE,
    LINK_MESSAGE_ACTION,
    WEBVIEW_MESSAGE_ACTION;
    
    public static final Companion Companion = null;

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/android/messaging/UrlSource$Companion;", "", "()V", "findByValue", "Lzendesk/android/messaging/UrlSource;", "value", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UrlSource.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UrlSource findByValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.TEXT.name())) {
                return UrlSource.TEXT;
            }
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.CAROUSEL.name())) {
                return UrlSource.CAROUSEL;
            }
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.FILE.name())) {
                return UrlSource.FILE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.IMAGE.name())) {
                return UrlSource.IMAGE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.LINK_MESSAGE_ACTION.name())) {
                return UrlSource.LINK_MESSAGE_ACTION;
            }
            if (Intrinsics.areEqual((Object) str, (Object) UrlSource.WEBVIEW_MESSAGE_ACTION.name())) {
                return UrlSource.WEBVIEW_MESSAGE_ACTION;
            }
            return null;
        }
    }
}
