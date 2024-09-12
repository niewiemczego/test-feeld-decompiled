package zendesk.android.settings.internal.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jz\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016¨\u0006-"}, d2 = {"Lzendesk/android/settings/internal/model/BrandDto;", "", "id", "", "accountId", "name", "", "active", "", "deletedAt", "createdAt", "updatedAt", "routeId", "signatureTemplate", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "getAccountId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getActive", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCreatedAt", "()Ljava/lang/String;", "getDeletedAt", "getId", "getName", "getRouteId", "getSignatureTemplate", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lzendesk/android/settings/internal/model/BrandDto;", "equals", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrandDto.kt */
public final class BrandDto {
    private final Long accountId;
    private final Boolean active;
    private final String createdAt;
    private final String deletedAt;
    private final Long id;
    private final String name;
    private final Long routeId;
    private final String signatureTemplate;
    private final String updatedAt;

    public static /* synthetic */ BrandDto copy$default(BrandDto brandDto, Long l, Long l2, String str, Boolean bool, String str2, String str3, String str4, Long l3, String str5, int i, Object obj) {
        BrandDto brandDto2 = brandDto;
        int i2 = i;
        return brandDto.copy((i2 & 1) != 0 ? brandDto2.id : l, (i2 & 2) != 0 ? brandDto2.accountId : l2, (i2 & 4) != 0 ? brandDto2.name : str, (i2 & 8) != 0 ? brandDto2.active : bool, (i2 & 16) != 0 ? brandDto2.deletedAt : str2, (i2 & 32) != 0 ? brandDto2.createdAt : str3, (i2 & 64) != 0 ? brandDto2.updatedAt : str4, (i2 & 128) != 0 ? brandDto2.routeId : l3, (i2 & 256) != 0 ? brandDto2.signatureTemplate : str5);
    }

    public final Long component1() {
        return this.id;
    }

    public final Long component2() {
        return this.accountId;
    }

    public final String component3() {
        return this.name;
    }

    public final Boolean component4() {
        return this.active;
    }

    public final String component5() {
        return this.deletedAt;
    }

    public final String component6() {
        return this.createdAt;
    }

    public final String component7() {
        return this.updatedAt;
    }

    public final Long component8() {
        return this.routeId;
    }

    public final String component9() {
        return this.signatureTemplate;
    }

    public final BrandDto copy(Long l, @Json(name = "account_id") Long l2, String str, Boolean bool, @Json(name = "deleted_at") String str2, @Json(name = "created_at") String str3, @Json(name = "updated_at") String str4, @Json(name = "route_id") Long l3, @Json(name = "signature_template") String str5) {
        return new BrandDto(l, l2, str, bool, str2, str3, str4, l3, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrandDto)) {
            return false;
        }
        BrandDto brandDto = (BrandDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) brandDto.id) && Intrinsics.areEqual((Object) this.accountId, (Object) brandDto.accountId) && Intrinsics.areEqual((Object) this.name, (Object) brandDto.name) && Intrinsics.areEqual((Object) this.active, (Object) brandDto.active) && Intrinsics.areEqual((Object) this.deletedAt, (Object) brandDto.deletedAt) && Intrinsics.areEqual((Object) this.createdAt, (Object) brandDto.createdAt) && Intrinsics.areEqual((Object) this.updatedAt, (Object) brandDto.updatedAt) && Intrinsics.areEqual((Object) this.routeId, (Object) brandDto.routeId) && Intrinsics.areEqual((Object) this.signatureTemplate, (Object) brandDto.signatureTemplate);
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.accountId;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.active;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.deletedAt;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.createdAt;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.updatedAt;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Long l3 = this.routeId;
        int hashCode8 = (hashCode7 + (l3 == null ? 0 : l3.hashCode())) * 31;
        String str5 = this.signatureTemplate;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "BrandDto(id=" + this.id + ", accountId=" + this.accountId + ", name=" + this.name + ", active=" + this.active + ", deletedAt=" + this.deletedAt + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", routeId=" + this.routeId + ", signatureTemplate=" + this.signatureTemplate + ')';
    }

    public BrandDto(Long l, @Json(name = "account_id") Long l2, String str, Boolean bool, @Json(name = "deleted_at") String str2, @Json(name = "created_at") String str3, @Json(name = "updated_at") String str4, @Json(name = "route_id") Long l3, @Json(name = "signature_template") String str5) {
        this.id = l;
        this.accountId = l2;
        this.name = str;
        this.active = bool;
        this.deletedAt = str2;
        this.createdAt = str3;
        this.updatedAt = str4;
        this.routeId = l3;
        this.signatureTemplate = str5;
    }

    public final Long getId() {
        return this.id;
    }

    public final Long getAccountId() {
        return this.accountId;
    }

    public final String getName() {
        return this.name;
    }

    public final Boolean getActive() {
        return this.active;
    }

    public final String getDeletedAt() {
        return this.deletedAt;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final Long getRouteId() {
        return this.routeId;
    }

    public final String getSignatureTemplate() {
        return this.signatureTemplate;
    }
}
