package zendesk.conversationkit.android.internal;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.user.UserActionProcessor;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.User;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0004\u000f\u0010\u0011\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/AccessLevel;", "", "logName", "", "(Ljava/lang/String;)V", "getLogName", "()Ljava/lang/String;", "getClientId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfig", "Lzendesk/conversationkit/android/model/Config;", "getCurrentUser", "Lzendesk/conversationkit/android/model/User;", "getSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "Lzendesk/conversationkit/android/internal/NoAccess;", "Lzendesk/conversationkit/android/internal/IntegrationAccess;", "Lzendesk/conversationkit/android/internal/AppAccess;", "Lzendesk/conversationkit/android/internal/UserAccess;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccessLevel.kt */
public abstract class AccessLevel {
    private final String logName;

    public /* synthetic */ AccessLevel(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private AccessLevel(String str) {
        this.logName = str;
    }

    public final String getLogName() {
        return this.logName;
    }

    public final ConversationKitSettings getSettings() {
        if (this instanceof NoAccess) {
            return null;
        }
        if (this instanceof IntegrationAccess) {
            return ((IntegrationAccess) this).getIntegrationProcessor().getConversationKitSettings();
        }
        if (this instanceof AppAccess) {
            return ((AppAccess) this).getAppProcessor().getConversationKitSettings();
        }
        if (this instanceof UserAccess) {
            return ((UserAccess) this).getUserProcessor().getConversationKitSettings();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Config getConfig() {
        if ((this instanceof NoAccess) || (this instanceof IntegrationAccess)) {
            return null;
        }
        if (this instanceof AppAccess) {
            return ((AppAccess) this).getAppProcessor().getConfig();
        }
        if (this instanceof UserAccess) {
            return ((UserAccess) this).getUserProcessor().getConfig();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Object getClientId(Continuation<? super String> continuation) {
        if ((this instanceof NoAccess) || (this instanceof IntegrationAccess)) {
            return null;
        }
        if (this instanceof AppAccess) {
            Object clientId = ((AppAccess) this).getConversationKitStorage().getClientId(continuation);
            return clientId == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clientId : (String) clientId;
        } else if (this instanceof UserAccess) {
            Object clientId2 = ((UserAccess) this).getConversationKitStorage().getClientId(continuation);
            return clientId2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? clientId2 : (String) clientId2;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final User getCurrentUser() {
        UserActionProcessor userProcessor;
        UserAccess userAccess = this instanceof UserAccess ? (UserAccess) this : null;
        if (userAccess == null || (userProcessor = userAccess.getUserProcessor()) == null) {
            return null;
        }
        return userProcessor.getUser();
    }
}
