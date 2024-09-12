package zendesk.android.settings.internal.model;

import com.squareup.moshi.JsonClass;
import io.sentry.protocol.App;
import io.sentry.protocol.SdkVersion;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JA\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lzendesk/android/settings/internal/model/SunCoConfigDto;", "", "app", "Lzendesk/android/settings/internal/model/AppDto;", "baseUrl", "Lzendesk/android/settings/internal/model/BaseUrlDto;", "integration", "Lzendesk/android/settings/internal/model/IntegrationDto;", "restRetryPolicy", "Lzendesk/android/settings/internal/model/RestRetryPolicyDto;", "integrations", "", "Lzendesk/android/settings/internal/model/ChannelIntegration;", "(Lzendesk/android/settings/internal/model/AppDto;Lzendesk/android/settings/internal/model/BaseUrlDto;Lzendesk/android/settings/internal/model/IntegrationDto;Lzendesk/android/settings/internal/model/RestRetryPolicyDto;Ljava/util/List;)V", "getApp", "()Lzendesk/android/settings/internal/model/AppDto;", "getBaseUrl", "()Lzendesk/android/settings/internal/model/BaseUrlDto;", "getIntegration", "()Lzendesk/android/settings/internal/model/IntegrationDto;", "getIntegrations", "()Ljava/util/List;", "getRestRetryPolicy", "()Lzendesk/android/settings/internal/model/RestRetryPolicyDto;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SunCoConfigDto.kt */
public final class SunCoConfigDto {

    /* renamed from: app  reason: collision with root package name */
    private final AppDto f41app;
    private final BaseUrlDto baseUrl;
    private final IntegrationDto integration;
    private final List<ChannelIntegration> integrations;
    private final RestRetryPolicyDto restRetryPolicy;

    public static /* synthetic */ SunCoConfigDto copy$default(SunCoConfigDto sunCoConfigDto, AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto, List<ChannelIntegration> list, int i, Object obj) {
        if ((i & 1) != 0) {
            appDto = sunCoConfigDto.f41app;
        }
        if ((i & 2) != 0) {
            baseUrlDto = sunCoConfigDto.baseUrl;
        }
        BaseUrlDto baseUrlDto2 = baseUrlDto;
        if ((i & 4) != 0) {
            integrationDto = sunCoConfigDto.integration;
        }
        IntegrationDto integrationDto2 = integrationDto;
        if ((i & 8) != 0) {
            restRetryPolicyDto = sunCoConfigDto.restRetryPolicy;
        }
        RestRetryPolicyDto restRetryPolicyDto2 = restRetryPolicyDto;
        if ((i & 16) != 0) {
            list = sunCoConfigDto.integrations;
        }
        return sunCoConfigDto.copy(appDto, baseUrlDto2, integrationDto2, restRetryPolicyDto2, list);
    }

    public final AppDto component1() {
        return this.f41app;
    }

    public final BaseUrlDto component2() {
        return this.baseUrl;
    }

    public final IntegrationDto component3() {
        return this.integration;
    }

    public final RestRetryPolicyDto component4() {
        return this.restRetryPolicy;
    }

    public final List<ChannelIntegration> component5() {
        return this.integrations;
    }

    public final SunCoConfigDto copy(AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto, List<ChannelIntegration> list) {
        Intrinsics.checkNotNullParameter(appDto, App.TYPE);
        Intrinsics.checkNotNullParameter(baseUrlDto, "baseUrl");
        Intrinsics.checkNotNullParameter(integrationDto, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicyDto, "restRetryPolicy");
        Intrinsics.checkNotNullParameter(list, SdkVersion.JsonKeys.INTEGRATIONS);
        return new SunCoConfigDto(appDto, baseUrlDto, integrationDto, restRetryPolicyDto, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SunCoConfigDto)) {
            return false;
        }
        SunCoConfigDto sunCoConfigDto = (SunCoConfigDto) obj;
        return Intrinsics.areEqual((Object) this.f41app, (Object) sunCoConfigDto.f41app) && Intrinsics.areEqual((Object) this.baseUrl, (Object) sunCoConfigDto.baseUrl) && Intrinsics.areEqual((Object) this.integration, (Object) sunCoConfigDto.integration) && Intrinsics.areEqual((Object) this.restRetryPolicy, (Object) sunCoConfigDto.restRetryPolicy) && Intrinsics.areEqual((Object) this.integrations, (Object) sunCoConfigDto.integrations);
    }

    public int hashCode() {
        return (((((((this.f41app.hashCode() * 31) + this.baseUrl.hashCode()) * 31) + this.integration.hashCode()) * 31) + this.restRetryPolicy.hashCode()) * 31) + this.integrations.hashCode();
    }

    public String toString() {
        return "SunCoConfigDto(app=" + this.f41app + ", baseUrl=" + this.baseUrl + ", integration=" + this.integration + ", restRetryPolicy=" + this.restRetryPolicy + ", integrations=" + this.integrations + ')';
    }

    public SunCoConfigDto(AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto, List<ChannelIntegration> list) {
        Intrinsics.checkNotNullParameter(appDto, App.TYPE);
        Intrinsics.checkNotNullParameter(baseUrlDto, "baseUrl");
        Intrinsics.checkNotNullParameter(integrationDto, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicyDto, "restRetryPolicy");
        Intrinsics.checkNotNullParameter(list, SdkVersion.JsonKeys.INTEGRATIONS);
        this.f41app = appDto;
        this.baseUrl = baseUrlDto;
        this.integration = integrationDto;
        this.restRetryPolicy = restRetryPolicyDto;
        this.integrations = list;
    }

    public final AppDto getApp() {
        return this.f41app;
    }

    public final BaseUrlDto getBaseUrl() {
        return this.baseUrl;
    }

    public final IntegrationDto getIntegration() {
        return this.integration;
    }

    public final RestRetryPolicyDto getRestRetryPolicy() {
        return this.restRetryPolicy;
    }

    public final List<ChannelIntegration> getIntegrations() {
        return this.integrations;
    }
}
