package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/App;", "", "id", "", "status", "name", "isMultiConvoEnabled", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "getStatus", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: App.kt */
public final class App {
    private final String id;
    private final boolean isMultiConvoEnabled;
    private final String name;
    private final String status;

    public static /* synthetic */ App copy$default(App app2, String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = app2.id;
        }
        if ((i & 2) != 0) {
            str2 = app2.status;
        }
        if ((i & 4) != 0) {
            str3 = app2.name;
        }
        if ((i & 8) != 0) {
            z = app2.isMultiConvoEnabled;
        }
        return app2.copy(str, str2, str3, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.name;
    }

    public final boolean component4() {
        return this.isMultiConvoEnabled;
    }

    public final App copy(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "name");
        return new App(str, str2, str3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof App)) {
            return false;
        }
        App app2 = (App) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) app2.id) && Intrinsics.areEqual((Object) this.status, (Object) app2.status) && Intrinsics.areEqual((Object) this.name, (Object) app2.name) && this.isMultiConvoEnabled == app2.isMultiConvoEnabled;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.status.hashCode()) * 31) + this.name.hashCode()) * 31;
        boolean z = this.isMultiConvoEnabled;
        if (z) {
            z = true;
        }
        return hashCode + (z ? 1 : 0);
    }

    public String toString() {
        return "App(id=" + this.id + ", status=" + this.status + ", name=" + this.name + ", isMultiConvoEnabled=" + this.isMultiConvoEnabled + ')';
    }

    public App(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "status");
        Intrinsics.checkNotNullParameter(str3, "name");
        this.id = str;
        this.status = str2;
        this.name = str3;
        this.isMultiConvoEnabled = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isMultiConvoEnabled() {
        return this.isMultiConvoEnabled;
    }
}
