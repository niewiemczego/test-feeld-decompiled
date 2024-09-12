package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.user.UserActionProcessor;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/internal/UserAccess;", "Lzendesk/conversationkit/android/internal/AccessLevel;", "userProcessor", "Lzendesk/conversationkit/android/internal/user/UserActionProcessor;", "conversationKitStorage", "Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "(Lzendesk/conversationkit/android/internal/user/UserActionProcessor;Lzendesk/conversationkit/android/internal/ConversationKitStorage;)V", "getConversationKitStorage", "()Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "getUserProcessor", "()Lzendesk/conversationkit/android/internal/user/UserActionProcessor;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevel.kt */
public final class UserAccess extends AccessLevel {
    private final ConversationKitStorage conversationKitStorage;
    private final UserActionProcessor userProcessor;

    public static /* synthetic */ UserAccess copy$default(UserAccess userAccess, UserActionProcessor userActionProcessor, ConversationKitStorage conversationKitStorage2, int i, Object obj) {
        if ((i & 1) != 0) {
            userActionProcessor = userAccess.userProcessor;
        }
        if ((i & 2) != 0) {
            conversationKitStorage2 = userAccess.conversationKitStorage;
        }
        return userAccess.copy(userActionProcessor, conversationKitStorage2);
    }

    public final UserActionProcessor component1() {
        return this.userProcessor;
    }

    public final ConversationKitStorage component2() {
        return this.conversationKitStorage;
    }

    public final UserAccess copy(UserActionProcessor userActionProcessor, ConversationKitStorage conversationKitStorage2) {
        Intrinsics.checkNotNullParameter(userActionProcessor, "userProcessor");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        return new UserAccess(userActionProcessor, conversationKitStorage2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserAccess)) {
            return false;
        }
        UserAccess userAccess = (UserAccess) obj;
        return Intrinsics.areEqual((Object) this.userProcessor, (Object) userAccess.userProcessor) && Intrinsics.areEqual((Object) this.conversationKitStorage, (Object) userAccess.conversationKitStorage);
    }

    public int hashCode() {
        return (this.userProcessor.hashCode() * 31) + this.conversationKitStorage.hashCode();
    }

    public String toString() {
        return "UserAccess(userProcessor=" + this.userProcessor + ", conversationKitStorage=" + this.conversationKitStorage + ')';
    }

    public final UserActionProcessor getUserProcessor() {
        return this.userProcessor;
    }

    public final ConversationKitStorage getConversationKitStorage() {
        return this.conversationKitStorage;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserAccess(UserActionProcessor userActionProcessor, ConversationKitStorage conversationKitStorage2) {
        super("UserAccess", (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(userActionProcessor, "userProcessor");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        this.userProcessor = userActionProcessor;
        this.conversationKitStorage = conversationKitStorage2;
    }
}
