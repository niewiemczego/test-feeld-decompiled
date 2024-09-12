package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.noaccess.NoAccessActionProcessor;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lzendesk/conversationkit/android/internal/NoAccess;", "Lzendesk/conversationkit/android/internal/AccessLevel;", "noAccessProcessor", "Lzendesk/conversationkit/android/internal/noaccess/NoAccessActionProcessor;", "(Lzendesk/conversationkit/android/internal/noaccess/NoAccessActionProcessor;)V", "getNoAccessProcessor", "()Lzendesk/conversationkit/android/internal/noaccess/NoAccessActionProcessor;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevel.kt */
public final class NoAccess extends AccessLevel {
    private final NoAccessActionProcessor noAccessProcessor;

    public static /* synthetic */ NoAccess copy$default(NoAccess noAccess, NoAccessActionProcessor noAccessActionProcessor, int i, Object obj) {
        if ((i & 1) != 0) {
            noAccessActionProcessor = noAccess.noAccessProcessor;
        }
        return noAccess.copy(noAccessActionProcessor);
    }

    public final NoAccessActionProcessor component1() {
        return this.noAccessProcessor;
    }

    public final NoAccess copy(NoAccessActionProcessor noAccessActionProcessor) {
        Intrinsics.checkNotNullParameter(noAccessActionProcessor, "noAccessProcessor");
        return new NoAccess(noAccessActionProcessor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof NoAccess) && Intrinsics.areEqual((Object) this.noAccessProcessor, (Object) ((NoAccess) obj).noAccessProcessor);
    }

    public int hashCode() {
        return this.noAccessProcessor.hashCode();
    }

    public String toString() {
        return "NoAccess(noAccessProcessor=" + this.noAccessProcessor + ')';
    }

    public final NoAccessActionProcessor getNoAccessProcessor() {
        return this.noAccessProcessor;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoAccess(NoAccessActionProcessor noAccessActionProcessor) {
        super("NoAccess", (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(noAccessActionProcessor, "noAccessProcessor");
        this.noAccessProcessor = noAccessActionProcessor;
    }
}
