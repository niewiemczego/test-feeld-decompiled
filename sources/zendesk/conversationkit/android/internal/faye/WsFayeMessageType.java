package zendesk.conversationkit.android.internal.faye;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsFayeMessageType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MESSAGE", "ACTIVITY", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WsFayeMessageDto.kt */
public enum WsFayeMessageType {
    MESSAGE("message"),
    ACTIVITY("activity");
    
    public static final Companion Companion = null;
    private final String value;

    private WsFayeMessageType(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/faye/WsFayeMessageType$Companion;", "", "()V", "findByValue", "Lzendesk/conversationkit/android/internal/faye/WsFayeMessageType;", "value", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: WsFayeMessageDto.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WsFayeMessageType findByValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            if (Intrinsics.areEqual((Object) str, (Object) WsFayeMessageType.MESSAGE.getValue())) {
                return WsFayeMessageType.MESSAGE;
            }
            if (Intrinsics.areEqual((Object) str, (Object) WsFayeMessageType.ACTIVITY.getValue())) {
                return WsFayeMessageType.ACTIVITY;
            }
            return null;
        }
    }
}
