package zendesk.android.internal.frontendevents.pageviewevents.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewDto;", "", "pageTitle", "", "navigatorLanguage", "userAgent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNavigatorLanguage", "()Ljava/lang/String;", "getPageTitle", "getUserAgent", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageViewEventsDto.kt */
public final class PageViewDto {
    private final String navigatorLanguage;
    private final String pageTitle;
    private final String userAgent;

    public static /* synthetic */ PageViewDto copy$default(PageViewDto pageViewDto, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pageViewDto.pageTitle;
        }
        if ((i & 2) != 0) {
            str2 = pageViewDto.navigatorLanguage;
        }
        if ((i & 4) != 0) {
            str3 = pageViewDto.userAgent;
        }
        return pageViewDto.copy(str, str2, str3);
    }

    public final String component1() {
        return this.pageTitle;
    }

    public final String component2() {
        return this.navigatorLanguage;
    }

    public final String component3() {
        return this.userAgent;
    }

    public final PageViewDto copy(@Json(name = "pageTitle") String str, @Json(name = "navigatorLanguage") String str2, @Json(name = "userAgent") String str3) {
        Intrinsics.checkNotNullParameter(str, "pageTitle");
        Intrinsics.checkNotNullParameter(str2, "navigatorLanguage");
        Intrinsics.checkNotNullParameter(str3, "userAgent");
        return new PageViewDto(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageViewDto)) {
            return false;
        }
        PageViewDto pageViewDto = (PageViewDto) obj;
        return Intrinsics.areEqual((Object) this.pageTitle, (Object) pageViewDto.pageTitle) && Intrinsics.areEqual((Object) this.navigatorLanguage, (Object) pageViewDto.navigatorLanguage) && Intrinsics.areEqual((Object) this.userAgent, (Object) pageViewDto.userAgent);
    }

    public int hashCode() {
        return (((this.pageTitle.hashCode() * 31) + this.navigatorLanguage.hashCode()) * 31) + this.userAgent.hashCode();
    }

    public String toString() {
        return "PageViewDto(pageTitle=" + this.pageTitle + ", navigatorLanguage=" + this.navigatorLanguage + ", userAgent=" + this.userAgent + ')';
    }

    public PageViewDto(@Json(name = "pageTitle") String str, @Json(name = "navigatorLanguage") String str2, @Json(name = "userAgent") String str3) {
        Intrinsics.checkNotNullParameter(str, "pageTitle");
        Intrinsics.checkNotNullParameter(str2, "navigatorLanguage");
        Intrinsics.checkNotNullParameter(str3, "userAgent");
        this.pageTitle = str;
        this.navigatorLanguage = str2;
        this.userAgent = str3;
    }

    public final String getPageTitle() {
        return this.pageTitle;
    }

    public final String getNavigatorLanguage() {
        return this.navigatorLanguage;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }
}
