package androidx.work.impl.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/work/impl/model/SystemIdInfo;", "", "workSpecId", "", "generation", "", "systemId", "(Ljava/lang/String;II)V", "getGeneration", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SystemIdInfo.kt */
public final class SystemIdInfo {
    private final int generation;
    public final int systemId;
    public final String workSpecId;

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo systemIdInfo, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = systemIdInfo.workSpecId;
        }
        if ((i3 & 2) != 0) {
            i = systemIdInfo.generation;
        }
        if ((i3 & 4) != 0) {
            i2 = systemIdInfo.systemId;
        }
        return systemIdInfo.copy(str, i, i2);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        return new SystemIdInfo(str, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return Intrinsics.areEqual((Object) this.workSpecId, (Object) systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + Integer.hashCode(this.generation)) * 31) + Integer.hashCode(this.systemId);
    }

    public String toString() {
        return "SystemIdInfo(workSpecId=" + this.workSpecId + ", generation=" + this.generation + ", systemId=" + this.systemId + ')';
    }

    public SystemIdInfo(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "workSpecId");
        this.workSpecId = str;
        this.generation = i;
        this.systemId = i2;
    }

    public final int getGeneration() {
        return this.generation;
    }
}
