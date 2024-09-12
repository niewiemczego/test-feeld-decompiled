package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/UpdateAppUserLocaleDto;", "", "locale", "", "(Ljava/lang/String;)V", "getLocale", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpdateAppUserLocaleDto.kt */
public final class UpdateAppUserLocaleDto {
    private final String locale;

    public static /* synthetic */ UpdateAppUserLocaleDto copy$default(UpdateAppUserLocaleDto updateAppUserLocaleDto, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateAppUserLocaleDto.locale;
        }
        return updateAppUserLocaleDto.copy(str);
    }

    public final String component1() {
        return this.locale;
    }

    public final UpdateAppUserLocaleDto copy(String str) {
        Intrinsics.checkNotNullParameter(str, "locale");
        return new UpdateAppUserLocaleDto(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UpdateAppUserLocaleDto) && Intrinsics.areEqual((Object) this.locale, (Object) ((UpdateAppUserLocaleDto) obj).locale);
    }

    public int hashCode() {
        return this.locale.hashCode();
    }

    public String toString() {
        return "UpdateAppUserLocaleDto(locale=" + this.locale + ')';
    }

    public UpdateAppUserLocaleDto(String str) {
        Intrinsics.checkNotNullParameter(str, "locale");
        this.locale = str;
    }

    public final String getLocale() {
        return this.locale;
    }
}
