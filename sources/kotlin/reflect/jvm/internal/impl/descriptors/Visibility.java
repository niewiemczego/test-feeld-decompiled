package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Visibility.kt */
public abstract class Visibility {
    private final boolean isPublicAPI;
    private final String name;

    public Visibility normalize() {
        return this;
    }

    protected Visibility(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.isPublicAPI = z;
    }

    public final boolean isPublicAPI() {
        return this.isPublicAPI;
    }

    public String getInternalDisplayName() {
        return this.name;
    }

    public Integer compareTo(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "visibility");
        return Visibilities.INSTANCE.compareLocal$compiler_common(this, visibility);
    }

    public final String toString() {
        return getInternalDisplayName();
    }
}
