package zendesk.android.settings.internal.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/android/settings/internal/model/ChannelIntegration;", "", "id", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoConfigDto.kt */
public final class ChannelIntegration {
    private final String id;
    private final String type;

    public static /* synthetic */ ChannelIntegration copy$default(ChannelIntegration channelIntegration, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelIntegration.id;
        }
        if ((i & 2) != 0) {
            str2 = channelIntegration.type;
        }
        return channelIntegration.copy(str, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final ChannelIntegration copy(@Json(name = "_id") String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        return new ChannelIntegration(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChannelIntegration)) {
            return false;
        }
        ChannelIntegration channelIntegration = (ChannelIntegration) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) channelIntegration.id) && Intrinsics.areEqual((Object) this.type, (Object) channelIntegration.type);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.type.hashCode();
    }

    public String toString() {
        return "ChannelIntegration(id=" + this.id + ", type=" + this.type + ')';
    }

    public ChannelIntegration(@Json(name = "_id") String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.id = str;
        this.type = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }
}
