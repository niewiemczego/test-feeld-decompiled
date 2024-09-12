package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsRequestDto;", "", "campaignPaths", "", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDto;", "(Ljava/util/List;)V", "getCampaignPaths", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CtsRequestDto.kt */
public final class CtsRequestDto {
    private final List<CampaignPathDto> campaignPaths;

    public static /* synthetic */ CtsRequestDto copy$default(CtsRequestDto ctsRequestDto, List<CampaignPathDto> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = ctsRequestDto.campaignPaths;
        }
        return ctsRequestDto.copy(list);
    }

    public final List<CampaignPathDto> component1() {
        return this.campaignPaths;
    }

    public final CtsRequestDto copy(@Json(name = "campaign_paths") List<CampaignPathDto> list) {
        Intrinsics.checkNotNullParameter(list, "campaignPaths");
        return new CtsRequestDto(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CtsRequestDto) && Intrinsics.areEqual((Object) this.campaignPaths, (Object) ((CtsRequestDto) obj).campaignPaths);
    }

    public int hashCode() {
        return this.campaignPaths.hashCode();
    }

    public String toString() {
        return "CtsRequestDto(campaignPaths=" + this.campaignPaths + ')';
    }

    public CtsRequestDto(@Json(name = "campaign_paths") List<CampaignPathDto> list) {
        Intrinsics.checkNotNullParameter(list, "campaignPaths");
        this.campaignPaths = list;
    }

    public final List<CampaignPathDto> getCampaignPaths() {
        return this.campaignPaths;
    }
}
