package zendesk.android.settings.internal;

import dagger.internal.Factory;
import javax.inject.Provider;

public final class SettingsRepository_Factory implements Factory<SettingsRepository> {
    private final Provider<SettingsRestClient> settingsRestClientProvider;

    public SettingsRepository_Factory(Provider<SettingsRestClient> provider) {
        this.settingsRestClientProvider = provider;
    }

    public SettingsRepository get() {
        return newInstance(this.settingsRestClientProvider.get());
    }

    public static SettingsRepository_Factory create(Provider<SettingsRestClient> provider) {
        return new SettingsRepository_Factory(provider);
    }

    public static SettingsRepository newInstance(SettingsRestClient settingsRestClient) {
        return new SettingsRepository(settingsRestClient);
    }
}
