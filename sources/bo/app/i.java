package bo.app;

import com.braze.models.IPutIntoJson;
import com.google.firebase.dynamiclinks.DynamicLink;
import kotlin.jvm.internal.Intrinsics;

public final class i implements IPutIntoJson {
    private final String b;

    public i(String str) {
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && Intrinsics.areEqual((Object) this.b, (Object) ((i) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.b;
    }

    /* renamed from: u */
    public String forJsonPut() {
        return this.b;
    }
}
