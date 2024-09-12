package androidx.privacysandbox.ads.adservices.appsetid;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId;", "", "id", "", "scope", "", "(Ljava/lang/String;I)V", "getId", "()Ljava/lang/String;", "getScope", "()I", "equals", "", "other", "hashCode", "toString", "Companion", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AppSetId.kt */
public final class AppSetId {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    private final String id;
    private final int scope;

    public AppSetId(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.id = str;
        this.scope = i;
        boolean z = true;
        if (!(i == 1 || i == 2)) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException("Scope undefined.".toString());
        }
    }

    public final String getId() {
        return this.id;
    }

    public final int getScope() {
        return this.scope;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        if (!Intrinsics.areEqual((Object) this.id, (Object) appSetId.id) || this.scope != appSetId.scope) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + Integer.hashCode(this.scope);
    }

    public String toString() {
        return "AppSetId: id=" + this.id + ", scope=" + (this.scope == 1 ? "SCOPE_APP" : "SCOPE_DEVELOPER");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/privacysandbox/ads/adservices/appsetid/AppSetId$Companion;", "", "()V", "SCOPE_APP", "", "SCOPE_DEVELOPER", "ads-adservices_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AppSetId.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
