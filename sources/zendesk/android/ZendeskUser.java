package zendesk.android;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/android/ZendeskUser;", "", "id", "", "externalId", "(Ljava/lang/String;Ljava/lang/String;)V", "getExternalId", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskUser.kt */
public final class ZendeskUser {
    private final String externalId;
    private final String id;

    public static /* synthetic */ ZendeskUser copy$default(ZendeskUser zendeskUser, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = zendeskUser.id;
        }
        if ((i & 2) != 0) {
            str2 = zendeskUser.externalId;
        }
        return zendeskUser.copy(str, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.externalId;
    }

    public final ZendeskUser copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new ZendeskUser(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZendeskUser)) {
            return false;
        }
        ZendeskUser zendeskUser = (ZendeskUser) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) zendeskUser.id) && Intrinsics.areEqual((Object) this.externalId, (Object) zendeskUser.externalId);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.externalId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "ZendeskUser(id=" + this.id + ", externalId=" + this.externalId + ')';
    }

    public ZendeskUser(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.externalId = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getExternalId() {
        return this.externalId;
    }
}
