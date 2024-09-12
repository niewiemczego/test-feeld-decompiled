package zendesk.android.internal.frontendevents.pageviewevents.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.frontendevents.FrontendEventsStorage;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006#"}, d2 = {"Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewEventDto;", "", "url", "", "buid", "channel", "version", "timestamp", "suid", "pageView", "Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewDto;)V", "getBuid", "()Ljava/lang/String;", "getChannel", "getPageView", "()Lzendesk/android/internal/frontendevents/pageviewevents/model/PageViewDto;", "getSuid", "getTimestamp", "getUrl", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageViewEventsDto.kt */
public final class PageViewEventDto {
    private final String buid;
    private final String channel;
    private final PageViewDto pageView;
    private final String suid;
    private final String timestamp;
    private final String url;
    private final String version;

    public static /* synthetic */ PageViewEventDto copy$default(PageViewEventDto pageViewEventDto, String str, String str2, String str3, String str4, String str5, String str6, PageViewDto pageViewDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pageViewEventDto.url;
        }
        if ((i & 2) != 0) {
            str2 = pageViewEventDto.buid;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = pageViewEventDto.channel;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = pageViewEventDto.version;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = pageViewEventDto.timestamp;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = pageViewEventDto.suid;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            pageViewDto = pageViewEventDto.pageView;
        }
        return pageViewEventDto.copy(str, str7, str8, str9, str10, str11, pageViewDto);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.buid;
    }

    public final String component3() {
        return this.channel;
    }

    public final String component4() {
        return this.version;
    }

    public final String component5() {
        return this.timestamp;
    }

    public final String component6() {
        return this.suid;
    }

    public final PageViewDto component7() {
        return this.pageView;
    }

    public final PageViewEventDto copy(@Json(name = "url") String str, @Json(name = "buid") String str2, @Json(name = "channel") String str3, @Json(name = "version") String str4, @Json(name = "timestamp") String str5, @Json(name = "suid") String str6, @Json(name = "pageView") PageViewDto pageViewDto) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "buid");
        Intrinsics.checkNotNullParameter(str3, "channel");
        Intrinsics.checkNotNullParameter(str4, "version");
        Intrinsics.checkNotNullParameter(str5, "timestamp");
        Intrinsics.checkNotNullParameter(str6, FrontendEventsStorage.KEY_SUID);
        PageViewDto pageViewDto2 = pageViewDto;
        Intrinsics.checkNotNullParameter(pageViewDto2, "pageView");
        return new PageViewEventDto(str, str2, str3, str4, str5, str6, pageViewDto2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageViewEventDto)) {
            return false;
        }
        PageViewEventDto pageViewEventDto = (PageViewEventDto) obj;
        return Intrinsics.areEqual((Object) this.url, (Object) pageViewEventDto.url) && Intrinsics.areEqual((Object) this.buid, (Object) pageViewEventDto.buid) && Intrinsics.areEqual((Object) this.channel, (Object) pageViewEventDto.channel) && Intrinsics.areEqual((Object) this.version, (Object) pageViewEventDto.version) && Intrinsics.areEqual((Object) this.timestamp, (Object) pageViewEventDto.timestamp) && Intrinsics.areEqual((Object) this.suid, (Object) pageViewEventDto.suid) && Intrinsics.areEqual((Object) this.pageView, (Object) pageViewEventDto.pageView);
    }

    public int hashCode() {
        return (((((((((((this.url.hashCode() * 31) + this.buid.hashCode()) * 31) + this.channel.hashCode()) * 31) + this.version.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.suid.hashCode()) * 31) + this.pageView.hashCode();
    }

    public String toString() {
        return "PageViewEventDto(url=" + this.url + ", buid=" + this.buid + ", channel=" + this.channel + ", version=" + this.version + ", timestamp=" + this.timestamp + ", suid=" + this.suid + ", pageView=" + this.pageView + ')';
    }

    public PageViewEventDto(@Json(name = "url") String str, @Json(name = "buid") String str2, @Json(name = "channel") String str3, @Json(name = "version") String str4, @Json(name = "timestamp") String str5, @Json(name = "suid") String str6, @Json(name = "pageView") PageViewDto pageViewDto) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "buid");
        Intrinsics.checkNotNullParameter(str3, "channel");
        Intrinsics.checkNotNullParameter(str4, "version");
        Intrinsics.checkNotNullParameter(str5, "timestamp");
        Intrinsics.checkNotNullParameter(str6, FrontendEventsStorage.KEY_SUID);
        Intrinsics.checkNotNullParameter(pageViewDto, "pageView");
        this.url = str;
        this.buid = str2;
        this.channel = str3;
        this.version = str4;
        this.timestamp = str5;
        this.suid = str6;
        this.pageView = pageViewDto;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getBuid() {
        return this.buid;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final String getSuid() {
        return this.suid;
    }

    public final PageViewDto getPageView() {
        return this.pageView;
    }
}
