package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import io.sentry.protocol.App;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/ConfigDto;", "", "app", "Lzendesk/conversationkit/android/internal/rest/model/AppDto;", "baseUrl", "Lzendesk/conversationkit/android/internal/rest/model/BaseUrlDto;", "integration", "Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;", "restRetryPolicy", "Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;", "(Lzendesk/conversationkit/android/internal/rest/model/AppDto;Lzendesk/conversationkit/android/internal/rest/model/BaseUrlDto;Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;)V", "getApp", "()Lzendesk/conversationkit/android/internal/rest/model/AppDto;", "getBaseUrl", "()Lzendesk/conversationkit/android/internal/rest/model/BaseUrlDto;", "getIntegration", "()Lzendesk/conversationkit/android/internal/rest/model/IntegrationDto;", "getRestRetryPolicy", "()Lzendesk/conversationkit/android/internal/rest/model/RestRetryPolicyDto;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfigDto.kt */
public final class ConfigDto {

    /* renamed from: app  reason: collision with root package name */
    private final AppDto f43app;
    private final BaseUrlDto baseUrl;
    private final IntegrationDto integration;
    private final RestRetryPolicyDto restRetryPolicy;

    public static /* synthetic */ ConfigDto copy$default(ConfigDto configDto, AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto, int i, Object obj) {
        if ((i & 1) != 0) {
            appDto = configDto.f43app;
        }
        if ((i & 2) != 0) {
            baseUrlDto = configDto.baseUrl;
        }
        if ((i & 4) != 0) {
            integrationDto = configDto.integration;
        }
        if ((i & 8) != 0) {
            restRetryPolicyDto = configDto.restRetryPolicy;
        }
        return configDto.copy(appDto, baseUrlDto, integrationDto, restRetryPolicyDto);
    }

    public final AppDto component1() {
        return this.f43app;
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

    public final ConfigDto copy(AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto) {
        Intrinsics.checkNotNullParameter(appDto, App.TYPE);
        Intrinsics.checkNotNullParameter(baseUrlDto, "baseUrl");
        Intrinsics.checkNotNullParameter(integrationDto, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicyDto, "restRetryPolicy");
        return new ConfigDto(appDto, baseUrlDto, integrationDto, restRetryPolicyDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigDto)) {
            return false;
        }
        ConfigDto configDto = (ConfigDto) obj;
        return Intrinsics.areEqual((Object) this.f43app, (Object) configDto.f43app) && Intrinsics.areEqual((Object) this.baseUrl, (Object) configDto.baseUrl) && Intrinsics.areEqual((Object) this.integration, (Object) configDto.integration) && Intrinsics.areEqual((Object) this.restRetryPolicy, (Object) configDto.restRetryPolicy);
    }

    public int hashCode() {
        return (((((this.f43app.hashCode() * 31) + this.baseUrl.hashCode()) * 31) + this.integration.hashCode()) * 31) + this.restRetryPolicy.hashCode();
    }

    public String toString() {
        return "ConfigDto(app=" + this.f43app + ", baseUrl=" + this.baseUrl + ", integration=" + this.integration + ", restRetryPolicy=" + this.restRetryPolicy + ')';
    }

    public ConfigDto(AppDto appDto, BaseUrlDto baseUrlDto, IntegrationDto integrationDto, RestRetryPolicyDto restRetryPolicyDto) {
        Intrinsics.checkNotNullParameter(appDto, App.TYPE);
        Intrinsics.checkNotNullParameter(baseUrlDto, "baseUrl");
        Intrinsics.checkNotNullParameter(integrationDto, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicyDto, "restRetryPolicy");
        this.f43app = appDto;
        this.baseUrl = baseUrlDto;
        this.integration = integrationDto;
        this.restRetryPolicy = restRetryPolicyDto;
    }

    public final AppDto getApp() {
        return this.f43app;
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
}
