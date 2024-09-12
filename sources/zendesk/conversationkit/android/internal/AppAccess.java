package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.app.AppActionProcessor;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/AppAccess;", "Lzendesk/conversationkit/android/internal/AccessLevel;", "appProcessor", "Lzendesk/conversationkit/android/internal/app/AppActionProcessor;", "conversationKitStorage", "Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "(Lzendesk/conversationkit/android/internal/app/AppActionProcessor;Lzendesk/conversationkit/android/internal/ConversationKitStorage;)V", "getAppProcessor", "()Lzendesk/conversationkit/android/internal/app/AppActionProcessor;", "getConversationKitStorage", "()Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevel.kt */
public final class AppAccess extends AccessLevel {
    private final AppActionProcessor appProcessor;
    private final ConversationKitStorage conversationKitStorage;

    public static /* synthetic */ AppAccess copy$default(AppAccess appAccess, AppActionProcessor appActionProcessor, ConversationKitStorage conversationKitStorage2, int i, Object obj) {
        if ((i & 1) != 0) {
            appActionProcessor = appAccess.appProcessor;
        }
        if ((i & 2) != 0) {
            conversationKitStorage2 = appAccess.conversationKitStorage;
        }
        return appAccess.copy(appActionProcessor, conversationKitStorage2);
    }

    public final AppActionProcessor component1() {
        return this.appProcessor;
    }

    public final ConversationKitStorage component2() {
        return this.conversationKitStorage;
    }

    public final AppAccess copy(AppActionProcessor appActionProcessor, ConversationKitStorage conversationKitStorage2) {
        Intrinsics.checkNotNullParameter(appActionProcessor, "appProcessor");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        return new AppAccess(appActionProcessor, conversationKitStorage2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppAccess)) {
            return false;
        }
        AppAccess appAccess = (AppAccess) obj;
        return Intrinsics.areEqual((Object) this.appProcessor, (Object) appAccess.appProcessor) && Intrinsics.areEqual((Object) this.conversationKitStorage, (Object) appAccess.conversationKitStorage);
    }

    public int hashCode() {
        return (this.appProcessor.hashCode() * 31) + this.conversationKitStorage.hashCode();
    }

    public String toString() {
        return "AppAccess(appProcessor=" + this.appProcessor + ", conversationKitStorage=" + this.conversationKitStorage + ')';
    }

    public final AppActionProcessor getAppProcessor() {
        return this.appProcessor;
    }

    public final ConversationKitStorage getConversationKitStorage() {
        return this.conversationKitStorage;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppAccess(AppActionProcessor appActionProcessor, ConversationKitStorage conversationKitStorage2) {
        super("AppAccess", (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(appActionProcessor, "appProcessor");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        this.appProcessor = appActionProcessor;
        this.conversationKitStorage = conversationKitStorage2;
    }
}
