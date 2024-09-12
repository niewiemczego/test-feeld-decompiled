package zendesk.android.settings.internal.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J[\u0010\u001e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006$"}, d2 = {"Lzendesk/android/settings/internal/model/NativeMessagingDto;", "", "integrationId", "", "platform", "enabled", "", "brand", "Lzendesk/android/settings/internal/model/BrandDto;", "title", "description", "logoUrl", "(Ljava/lang/String;Ljava/lang/String;ZLzendesk/android/settings/internal/model/BrandDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBrand", "()Lzendesk/android/settings/internal/model/BrandDto;", "getDescription", "()Ljava/lang/String;", "getEnabled", "()Z", "getIntegrationId", "getLogoUrl", "getPlatform", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NativeMessagingDto.kt */
public final class NativeMessagingDto {
    private final BrandDto brand;
    private final String description;
    private final boolean enabled;
    private final String integrationId;
    private final String logoUrl;
    private final String platform;
    private final String title;

    public static /* synthetic */ NativeMessagingDto copy$default(NativeMessagingDto nativeMessagingDto, String str, String str2, boolean z, BrandDto brandDto, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeMessagingDto.integrationId;
        }
        if ((i & 2) != 0) {
            str2 = nativeMessagingDto.platform;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            z = nativeMessagingDto.enabled;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            brandDto = nativeMessagingDto.brand;
        }
        BrandDto brandDto2 = brandDto;
        if ((i & 16) != 0) {
            str3 = nativeMessagingDto.title;
        }
        String str7 = str3;
        if ((i & 32) != 0) {
            str4 = nativeMessagingDto.description;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            str5 = nativeMessagingDto.logoUrl;
        }
        return nativeMessagingDto.copy(str, str6, z2, brandDto2, str7, str8, str5);
    }

    public final String component1() {
        return this.integrationId;
    }

    public final String component2() {
        return this.platform;
    }

    public final boolean component3() {
        return this.enabled;
    }

    public final BrandDto component4() {
        return this.brand;
    }

    public final String component5() {
        return this.title;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.logoUrl;
    }

    public final NativeMessagingDto copy(@Json(name = "integration_id") String str, String str2, boolean z, BrandDto brandDto, String str3, String str4, @Json(name = "logo_url") String str5) {
        return new NativeMessagingDto(str, str2, z, brandDto, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NativeMessagingDto)) {
            return false;
        }
        NativeMessagingDto nativeMessagingDto = (NativeMessagingDto) obj;
        return Intrinsics.areEqual((Object) this.integrationId, (Object) nativeMessagingDto.integrationId) && Intrinsics.areEqual((Object) this.platform, (Object) nativeMessagingDto.platform) && this.enabled == nativeMessagingDto.enabled && Intrinsics.areEqual((Object) this.brand, (Object) nativeMessagingDto.brand) && Intrinsics.areEqual((Object) this.title, (Object) nativeMessagingDto.title) && Intrinsics.areEqual((Object) this.description, (Object) nativeMessagingDto.description) && Intrinsics.areEqual((Object) this.logoUrl, (Object) nativeMessagingDto.logoUrl);
    }

    public int hashCode() {
        String str = this.integrationId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.platform;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        BrandDto brandDto = this.brand;
        int hashCode3 = (i2 + (brandDto == null ? 0 : brandDto.hashCode())) * 31;
        String str3 = this.title;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.logoUrl;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "NativeMessagingDto(integrationId=" + this.integrationId + ", platform=" + this.platform + ", enabled=" + this.enabled + ", brand=" + this.brand + ", title=" + this.title + ", description=" + this.description + ", logoUrl=" + this.logoUrl + ')';
    }

    public NativeMessagingDto(@Json(name = "integration_id") String str, String str2, boolean z, BrandDto brandDto, String str3, String str4, @Json(name = "logo_url") String str5) {
        this.integrationId = str;
        this.platform = str2;
        this.enabled = z;
        this.brand = brandDto;
        this.title = str3;
        this.description = str4;
        this.logoUrl = str5;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final BrandDto getBrand() {
        return this.brand;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }
}
