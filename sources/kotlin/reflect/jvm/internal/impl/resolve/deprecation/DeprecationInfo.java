package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeprecationInfo.kt */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    public int compareTo(DeprecationInfo deprecationInfo) {
        Intrinsics.checkNotNullParameter(deprecationInfo, "other");
        int compareTo = getDeprecationLevel().compareTo(deprecationInfo.getDeprecationLevel());
        if (compareTo != 0 || getPropagatesToOverrides() || !deprecationInfo.getPropagatesToOverrides()) {
            return compareTo;
        }
        return 1;
    }
}
