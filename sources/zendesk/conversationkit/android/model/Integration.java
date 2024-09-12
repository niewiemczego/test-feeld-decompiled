package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lzendesk/conversationkit/android/model/Integration;", "", "id", "", "canUserCreateMoreConversations", "", "canUserSeeConversationList", "(Ljava/lang/String;ZZ)V", "getCanUserCreateMoreConversations", "()Z", "getCanUserSeeConversationList", "getId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Integration.kt */
public final class Integration {
    private final boolean canUserCreateMoreConversations;
    private final boolean canUserSeeConversationList;
    private final String id;

    public static /* synthetic */ Integration copy$default(Integration integration, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = integration.id;
        }
        if ((i & 2) != 0) {
            z = integration.canUserCreateMoreConversations;
        }
        if ((i & 4) != 0) {
            z2 = integration.canUserSeeConversationList;
        }
        return integration.copy(str, z, z2);
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component2() {
        return this.canUserCreateMoreConversations;
    }

    public final boolean component3() {
        return this.canUserSeeConversationList;
    }

    public final Integration copy(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new Integration(str, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Integration)) {
            return false;
        }
        Integration integration = (Integration) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) integration.id) && this.canUserCreateMoreConversations == integration.canUserCreateMoreConversations && this.canUserSeeConversationList == integration.canUserSeeConversationList;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        boolean z = this.canUserCreateMoreConversations;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.canUserSeeConversationList;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "Integration(id=" + this.id + ", canUserCreateMoreConversations=" + this.canUserCreateMoreConversations + ", canUserSeeConversationList=" + this.canUserSeeConversationList + ')';
    }

    public Integration(String str, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.canUserCreateMoreConversations = z;
        this.canUserSeeConversationList = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getCanUserCreateMoreConversations() {
        return this.canUserCreateMoreConversations;
    }

    public final boolean getCanUserSeeConversationList() {
        return this.canUserSeeConversationList;
    }
}
