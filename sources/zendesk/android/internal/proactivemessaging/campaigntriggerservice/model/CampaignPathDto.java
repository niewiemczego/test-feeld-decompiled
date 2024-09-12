package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDto;", "", "campaignId", "", "pathIds", "", "version", "", "(Ljava/lang/String;Ljava/util/List;I)V", "getCampaignId", "()Ljava/lang/String;", "getPathIds", "()Ljava/util/List;", "getVersion", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CampaignPathDto.kt */
public final class CampaignPathDto {
    private final String campaignId;
    private final List<String> pathIds;
    private final int version;

    public static /* synthetic */ CampaignPathDto copy$default(CampaignPathDto campaignPathDto, String str, List<String> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = campaignPathDto.campaignId;
        }
        if ((i2 & 2) != 0) {
            list = campaignPathDto.pathIds;
        }
        if ((i2 & 4) != 0) {
            i = campaignPathDto.version;
        }
        return campaignPathDto.copy(str, list, i);
    }

    public final String component1() {
        return this.campaignId;
    }

    public final List<String> component2() {
        return this.pathIds;
    }

    public final int component3() {
        return this.version;
    }

    public final CampaignPathDto copy(@Json(name = "pcm_id") String str, @Json(name = "path_ids") List<String> list, int i) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(list, "pathIds");
        return new CampaignPathDto(str, list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignPathDto)) {
            return false;
        }
        CampaignPathDto campaignPathDto = (CampaignPathDto) obj;
        return Intrinsics.areEqual((Object) this.campaignId, (Object) campaignPathDto.campaignId) && Intrinsics.areEqual((Object) this.pathIds, (Object) campaignPathDto.pathIds) && this.version == campaignPathDto.version;
    }

    public int hashCode() {
        return (((this.campaignId.hashCode() * 31) + this.pathIds.hashCode()) * 31) + Integer.hashCode(this.version);
    }

    public String toString() {
        return "CampaignPathDto(campaignId=" + this.campaignId + ", pathIds=" + this.pathIds + ", version=" + this.version + ')';
    }

    public CampaignPathDto(@Json(name = "pcm_id") String str, @Json(name = "path_ids") List<String> list, int i) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(list, "pathIds");
        this.campaignId = str;
        this.pathIds = list;
        this.version = i;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final List<String> getPathIds() {
        return this.pathIds;
    }

    public final int getVersion() {
        return this.version;
    }
}
