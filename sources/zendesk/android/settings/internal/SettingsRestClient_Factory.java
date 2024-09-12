package zendesk.android.settings.internal;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;
import zendesk.android.internal.di.ZendeskComponentConfig;

public final class SettingsRestClient_Factory implements Factory<SettingsRestClient> {
    private final Provider<Moshi> moshiProvider;
    private final Provider<SettingsApi> settingsApiProvider;
    private final Provider<ZendeskComponentConfig> zendeskComponentConfigProvider;

    public SettingsRestClient_Factory(Provider<SettingsApi> provider, Provider<Moshi> provider2, Provider<ZendeskComponentConfig> provider3) {
        this.settingsApiProvider = provider;
        this.moshiProvider = provider2;
        this.zendeskComponentConfigProvider = provider3;
    }

    public SettingsRestClient get() {
        return newInstance(this.settingsApiProvider.get(), this.moshiProvider.get(), this.zendeskComponentConfigProvider.get());
    }

    public static SettingsRestClient_Factory create(Provider<SettingsApi> provider, Provider<Moshi> provider2, Provider<ZendeskComponentConfig> provider3) {
        return new SettingsRestClient_Factory(provider, provider2, provider3);
    }

    public static SettingsRestClient newInstance(SettingsApi settingsApi, Moshi moshi, ZendeskComponentConfig zendeskComponentConfig) {
        return new SettingsRestClient(settingsApi, moshi, zendeskComponentConfig);
    }
}
