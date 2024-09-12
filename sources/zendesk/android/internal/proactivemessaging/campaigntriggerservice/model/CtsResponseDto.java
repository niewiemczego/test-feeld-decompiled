package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0003\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsResponseDto;", "", "jwt", "", "message", "campaignId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCampaignId", "()Ljava/lang/String;", "getJwt", "getMessage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CtsResponseDto.kt */
public final class CtsResponseDto {
    private final String campaignId;
    private final String jwt;
    private final String message;

    public static /* synthetic */ CtsResponseDto copy$default(CtsResponseDto ctsResponseDto, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ctsResponseDto.jwt;
        }
        if ((i & 2) != 0) {
            str2 = ctsResponseDto.message;
        }
        if ((i & 4) != 0) {
            str3 = ctsResponseDto.campaignId;
        }
        return ctsResponseDto.copy(str, str2, str3);
    }

    public final String component1() {
        return this.jwt;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.campaignId;
    }

    public final CtsResponseDto copy(String str, String str2, @Json(name = "pcm_id") String str3) {
        Intrinsics.checkNotNullParameter(str2, "message");
        return new CtsResponseDto(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CtsResponseDto)) {
            return false;
        }
        CtsResponseDto ctsResponseDto = (CtsResponseDto) obj;
        return Intrinsics.areEqual((Object) this.jwt, (Object) ctsResponseDto.jwt) && Intrinsics.areEqual((Object) this.message, (Object) ctsResponseDto.message) && Intrinsics.areEqual((Object) this.campaignId, (Object) ctsResponseDto.campaignId);
    }

    public int hashCode() {
        String str = this.jwt;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.message.hashCode()) * 31;
        String str2 = this.campaignId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CtsResponseDto(jwt=" + this.jwt + ", message=" + this.message + ", campaignId=" + this.campaignId + ')';
    }

    public CtsResponseDto(String str, String str2, @Json(name = "pcm_id") String str3) {
        Intrinsics.checkNotNullParameter(str2, "message");
        this.jwt = str;
        this.message = str2;
        this.campaignId = str3;
    }

    public final String getJwt() {
        return this.jwt;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }
}
