package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/BaseUrlDto;", "", "android", "", "(Ljava/lang/String;)V", "getAndroid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseUrlDto.kt */
public final class BaseUrlDto {

    /* renamed from: android  reason: collision with root package name */
    private final String f42android;

    public static /* synthetic */ BaseUrlDto copy$default(BaseUrlDto baseUrlDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = baseUrlDto.f42android;
        }
        return baseUrlDto.copy(str);
    }

    public final String component1() {
        return this.f42android;
    }

    public final BaseUrlDto copy(String str) {
        Intrinsics.checkNotNullParameter(str, "android");
        return new BaseUrlDto(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BaseUrlDto) && Intrinsics.areEqual((Object) this.f42android, (Object) ((BaseUrlDto) obj).f42android);
    }

    public int hashCode() {
        return this.f42android.hashCode();
    }

    public String toString() {
        return "BaseUrlDto(android=" + this.f42android + ')';
    }

    public BaseUrlDto(String str) {
        Intrinsics.checkNotNullParameter(str, "android");
        this.f42android = str;
    }

    public final String getAndroid() {
        return this.f42android;
    }
}
