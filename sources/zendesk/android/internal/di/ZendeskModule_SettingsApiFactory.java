package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;
import zendesk.android.settings.internal.SettingsApi;

public final class ZendeskModule_SettingsApiFactory implements Factory<SettingsApi> {
    private final ZendeskModule module;
    private final Provider<Retrofit> retrofitProvider;

    public ZendeskModule_SettingsApiFactory(ZendeskModule zendeskModule, Provider<Retrofit> provider) {
        this.module = zendeskModule;
        this.retrofitProvider = provider;
    }

    public SettingsApi get() {
        return settingsApi(this.module, this.retrofitProvider.get());
    }

    public static ZendeskModule_SettingsApiFactory create(ZendeskModule zendeskModule, Provider<Retrofit> provider) {
        return new ZendeskModule_SettingsApiFactory(zendeskModule, provider);
    }

    public static SettingsApi settingsApi(ZendeskModule zendeskModule, Retrofit retrofit) {
        return (SettingsApi) Preconditions.checkNotNullFromProvides(zendeskModule.settingsApi(retrofit));
    }
}
