package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: IncompatibleVersionErrorData.kt */
public final class IncompatibleVersionErrorData<T> {
    private final T actualVersion;
    private final ClassId classId;
    private final T expectedVersion;
    private final String filePath;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IncompatibleVersionErrorData)) {
            return false;
        }
        IncompatibleVersionErrorData incompatibleVersionErrorData = (IncompatibleVersionErrorData) obj;
        return Intrinsics.areEqual((Object) this.actualVersion, (Object) incompatibleVersionErrorData.actualVersion) && Intrinsics.areEqual((Object) this.expectedVersion, (Object) incompatibleVersionErrorData.expectedVersion) && Intrinsics.areEqual((Object) this.filePath, (Object) incompatibleVersionErrorData.filePath) && Intrinsics.areEqual((Object) this.classId, (Object) incompatibleVersionErrorData.classId);
    }

    public int hashCode() {
        T t = this.actualVersion;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.expectedVersion;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return ((((hashCode + i) * 31) + this.filePath.hashCode()) * 31) + this.classId.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.actualVersion + ", expectedVersion=" + this.expectedVersion + ", filePath=" + this.filePath + ", classId=" + this.classId + ')';
    }

    public IncompatibleVersionErrorData(T t, T t2, String str, ClassId classId2) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(classId2, "classId");
        this.actualVersion = t;
        this.expectedVersion = t2;
        this.filePath = str;
        this.classId = classId2;
    }
}
