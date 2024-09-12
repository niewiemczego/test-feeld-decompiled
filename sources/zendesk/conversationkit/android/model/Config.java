package zendesk.conversationkit.android.model;

import io.sentry.protocol.App;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/model/Config;", "", "app", "Lzendesk/conversationkit/android/model/App;", "baseUrl", "", "integration", "Lzendesk/conversationkit/android/model/Integration;", "restRetryPolicy", "Lzendesk/conversationkit/android/model/RestRetryPolicy;", "(Lzendesk/conversationkit/android/model/App;Ljava/lang/String;Lzendesk/conversationkit/android/model/Integration;Lzendesk/conversationkit/android/model/RestRetryPolicy;)V", "getApp", "()Lzendesk/conversationkit/android/model/App;", "getBaseUrl", "()Ljava/lang/String;", "getIntegration", "()Lzendesk/conversationkit/android/model/Integration;", "getRestRetryPolicy", "()Lzendesk/conversationkit/android/model/RestRetryPolicy;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Config.kt */
public final class Config {

    /* renamed from: app  reason: collision with root package name */
    private final App f44app;
    private final String baseUrl;
    private final Integration integration;
    private final RestRetryPolicy restRetryPolicy;

    public static /* synthetic */ Config copy$default(Config config, App app2, String str, Integration integration2, RestRetryPolicy restRetryPolicy2, int i, Object obj) {
        if ((i & 1) != 0) {
            app2 = config.f44app;
        }
        if ((i & 2) != 0) {
            str = config.baseUrl;
        }
        if ((i & 4) != 0) {
            integration2 = config.integration;
        }
        if ((i & 8) != 0) {
            restRetryPolicy2 = config.restRetryPolicy;
        }
        return config.copy(app2, str, integration2, restRetryPolicy2);
    }

    public final App component1() {
        return this.f44app;
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final Integration component3() {
        return this.integration;
    }

    public final RestRetryPolicy component4() {
        return this.restRetryPolicy;
    }

    public final Config copy(App app2, String str, Integration integration2, RestRetryPolicy restRetryPolicy2) {
        Intrinsics.checkNotNullParameter(app2, App.TYPE);
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(integration2, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicy2, "restRetryPolicy");
        return new Config(app2, str, integration2, restRetryPolicy2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Config)) {
            return false;
        }
        Config config = (Config) obj;
        return Intrinsics.areEqual((Object) this.f44app, (Object) config.f44app) && Intrinsics.areEqual((Object) this.baseUrl, (Object) config.baseUrl) && Intrinsics.areEqual((Object) this.integration, (Object) config.integration) && Intrinsics.areEqual((Object) this.restRetryPolicy, (Object) config.restRetryPolicy);
    }

    public int hashCode() {
        return (((((this.f44app.hashCode() * 31) + this.baseUrl.hashCode()) * 31) + this.integration.hashCode()) * 31) + this.restRetryPolicy.hashCode();
    }

    public String toString() {
        return "Config(app=" + this.f44app + ", baseUrl=" + this.baseUrl + ", integration=" + this.integration + ", restRetryPolicy=" + this.restRetryPolicy + ')';
    }

    public Config(App app2, String str, Integration integration2, RestRetryPolicy restRetryPolicy2) {
        Intrinsics.checkNotNullParameter(app2, App.TYPE);
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(integration2, "integration");
        Intrinsics.checkNotNullParameter(restRetryPolicy2, "restRetryPolicy");
        this.f44app = app2;
        this.baseUrl = str;
        this.integration = integration2;
        this.restRetryPolicy = restRetryPolicy2;
    }

    public final App getApp() {
        return this.f44app;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final Integration getIntegration() {
        return this.integration;
    }

    public final RestRetryPolicy getRestRetryPolicy() {
        return this.restRetryPolicy;
    }
}
