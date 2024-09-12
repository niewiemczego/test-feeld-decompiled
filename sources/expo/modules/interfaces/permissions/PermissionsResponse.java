package expo.modules.interfaces.permissions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lexpo/modules/interfaces/permissions/PermissionsResponse;", "", "status", "Lexpo/modules/interfaces/permissions/PermissionsStatus;", "canAskAgain", "", "(Lexpo/modules/interfaces/permissions/PermissionsStatus;Z)V", "getCanAskAgain", "()Z", "getStatus", "()Lexpo/modules/interfaces/permissions/PermissionsStatus;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PermissionsResponse.kt */
public final class PermissionsResponse {
    public static final String CAN_ASK_AGAIN_KEY = "canAskAgain";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXPIRES_KEY = "expires";
    public static final String GRANTED_KEY = "granted";
    public static final String PERMISSION_EXPIRES_NEVER = "never";
    public static final String SCOPE_ALWAYS = "always";
    public static final String SCOPE_IN_USE = "whenInUse";
    public static final String SCOPE_KEY = "scope";
    public static final String SCOPE_NONE = "none";
    public static final String STATUS_KEY = "status";
    private final boolean canAskAgain;
    private final PermissionsStatus status;

    public static /* synthetic */ PermissionsResponse copy$default(PermissionsResponse permissionsResponse, PermissionsStatus permissionsStatus, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            permissionsStatus = permissionsResponse.status;
        }
        if ((i & 2) != 0) {
            z = permissionsResponse.canAskAgain;
        }
        return permissionsResponse.copy(permissionsStatus, z);
    }

    public final PermissionsStatus component1() {
        return this.status;
    }

    public final boolean component2() {
        return this.canAskAgain;
    }

    public final PermissionsResponse copy(PermissionsStatus permissionsStatus, boolean z) {
        Intrinsics.checkNotNullParameter(permissionsStatus, "status");
        return new PermissionsResponse(permissionsStatus, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionsResponse)) {
            return false;
        }
        PermissionsResponse permissionsResponse = (PermissionsResponse) obj;
        return this.status == permissionsResponse.status && this.canAskAgain == permissionsResponse.canAskAgain;
    }

    public int hashCode() {
        int hashCode = this.status.hashCode() * 31;
        boolean z = this.canAskAgain;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        PermissionsStatus permissionsStatus = this.status;
        return "PermissionsResponse(status=" + permissionsStatus + ", canAskAgain=" + this.canAskAgain + ")";
    }

    public PermissionsResponse(PermissionsStatus permissionsStatus, boolean z) {
        Intrinsics.checkNotNullParameter(permissionsStatus, "status");
        this.status = permissionsStatus;
        this.canAskAgain = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionsResponse(PermissionsStatus permissionsStatus, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionsStatus, (i & 2) != 0 ? true : z);
    }

    public final PermissionsStatus getStatus() {
        return this.status;
    }

    public final boolean getCanAskAgain() {
        return this.canAskAgain;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/interfaces/permissions/PermissionsResponse$Companion;", "", "()V", "CAN_ASK_AGAIN_KEY", "", "EXPIRES_KEY", "GRANTED_KEY", "PERMISSION_EXPIRES_NEVER", "SCOPE_ALWAYS", "SCOPE_IN_USE", "SCOPE_KEY", "SCOPE_NONE", "STATUS_KEY", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PermissionsResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
