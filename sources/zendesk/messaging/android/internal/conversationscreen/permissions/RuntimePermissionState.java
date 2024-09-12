package zendesk.messaging.android.internal.conversationscreen.permissions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermissionState;", "", "permission", "", "isGranted", "", "shouldShowRational", "(Ljava/lang/String;ZZ)V", "()Z", "getPermission", "()Ljava/lang/String;", "getShouldShowRational", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RuntimePermissionState.kt */
public final class RuntimePermissionState {
    private final boolean isGranted;
    private final String permission;
    private final boolean shouldShowRational;

    public RuntimePermissionState() {
        this((String) null, false, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ RuntimePermissionState copy$default(RuntimePermissionState runtimePermissionState, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = runtimePermissionState.permission;
        }
        if ((i & 2) != 0) {
            z = runtimePermissionState.isGranted;
        }
        if ((i & 4) != 0) {
            z2 = runtimePermissionState.shouldShowRational;
        }
        return runtimePermissionState.copy(str, z, z2);
    }

    public final String component1() {
        return this.permission;
    }

    public final boolean component2() {
        return this.isGranted;
    }

    public final boolean component3() {
        return this.shouldShowRational;
    }

    public final RuntimePermissionState copy(String str, boolean z, boolean z2) {
        return new RuntimePermissionState(str, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RuntimePermissionState)) {
            return false;
        }
        RuntimePermissionState runtimePermissionState = (RuntimePermissionState) obj;
        return Intrinsics.areEqual((Object) this.permission, (Object) runtimePermissionState.permission) && this.isGranted == runtimePermissionState.isGranted && this.shouldShowRational == runtimePermissionState.shouldShowRational;
    }

    public int hashCode() {
        String str = this.permission;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        boolean z = this.isGranted;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.shouldShowRational;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "RuntimePermissionState(permission=" + this.permission + ", isGranted=" + this.isGranted + ", shouldShowRational=" + this.shouldShowRational + ')';
    }

    public RuntimePermissionState(String str, boolean z, boolean z2) {
        this.permission = str;
        this.isGranted = z;
        this.shouldShowRational = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RuntimePermissionState(String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2);
    }

    public final String getPermission() {
        return this.permission;
    }

    public final boolean isGranted() {
        return this.isGranted;
    }

    public final boolean getShouldShowRational() {
        return this.shouldShowRational;
    }
}
