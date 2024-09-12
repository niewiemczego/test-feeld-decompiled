package bo.app;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

public final class k1 {
    private final JSONArray a;

    public k1(JSONArray jSONArray) {
        Intrinsics.checkNotNullParameter(jSONArray, "featureFlagsData");
        this.a = jSONArray;
    }

    public final JSONArray a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k1) && Intrinsics.areEqual((Object) this.a, (Object) ((k1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "FeatureFlagsReceivedEvent(featureFlagsData=" + this.a + ')';
    }
}
