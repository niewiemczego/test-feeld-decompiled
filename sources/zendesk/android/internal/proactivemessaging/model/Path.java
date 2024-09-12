package zendesk.android.internal.proactivemessaging.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Path;", "", "pathId", "", "zrlVersion", "condition", "Lzendesk/android/internal/proactivemessaging/model/Condition;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/android/internal/proactivemessaging/model/Condition;)V", "getCondition", "()Lzendesk/android/internal/proactivemessaging/model/Condition;", "getPathId", "()Ljava/lang/String;", "getZrlVersion", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Path.kt */
public final class Path {
    private final Condition condition;
    private final String pathId;
    private final String zrlVersion;

    public static /* synthetic */ Path copy$default(Path path, String str, String str2, Condition condition2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = path.pathId;
        }
        if ((i & 2) != 0) {
            str2 = path.zrlVersion;
        }
        if ((i & 4) != 0) {
            condition2 = path.condition;
        }
        return path.copy(str, str2, condition2);
    }

    public final String component1() {
        return this.pathId;
    }

    public final String component2() {
        return this.zrlVersion;
    }

    public final Condition component3() {
        return this.condition;
    }

    public final Path copy(@Json(name = "path_id") String str, @Json(name = "zrl_version") String str2, Condition condition2) {
        Intrinsics.checkNotNullParameter(str, "pathId");
        Intrinsics.checkNotNullParameter(str2, "zrlVersion");
        Intrinsics.checkNotNullParameter(condition2, "condition");
        return new Path(str, str2, condition2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Path)) {
            return false;
        }
        Path path = (Path) obj;
        return Intrinsics.areEqual((Object) this.pathId, (Object) path.pathId) && Intrinsics.areEqual((Object) this.zrlVersion, (Object) path.zrlVersion) && Intrinsics.areEqual((Object) this.condition, (Object) path.condition);
    }

    public int hashCode() {
        return (((this.pathId.hashCode() * 31) + this.zrlVersion.hashCode()) * 31) + this.condition.hashCode();
    }

    public String toString() {
        return "Path(pathId=" + this.pathId + ", zrlVersion=" + this.zrlVersion + ", condition=" + this.condition + ')';
    }

    public Path(@Json(name = "path_id") String str, @Json(name = "zrl_version") String str2, Condition condition2) {
        Intrinsics.checkNotNullParameter(str, "pathId");
        Intrinsics.checkNotNullParameter(str2, "zrlVersion");
        Intrinsics.checkNotNullParameter(condition2, "condition");
        this.pathId = str;
        this.zrlVersion = str2;
        this.condition = condition2;
    }

    public final String getPathId() {
        return this.pathId;
    }

    public final String getZrlVersion() {
        return this.zrlVersion;
    }

    public final Condition getCondition() {
        return this.condition;
    }
}
