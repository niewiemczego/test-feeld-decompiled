package zendesk.android.internal.network;

import dagger.internal.Factory;
import javax.inject.Provider;
import zendesk.android.internal.di.ZendeskComponentConfig;

public final class HeaderFactory_Factory implements Factory<HeaderFactory> {
    private final Provider<ZendeskComponentConfig> componentConfigProvider;
    private final Provider<NetworkData> networkDataProvider;

    public HeaderFactory_Factory(Provider<ZendeskComponentConfig> provider, Provider<NetworkData> provider2) {
        this.componentConfigProvider = provider;
        this.networkDataProvider = provider2;
    }

    public HeaderFactory get() {
        return newInstance(this.componentConfigProvider.get(), this.networkDataProvider.get());
    }

    public static HeaderFactory_Factory create(Provider<ZendeskComponentConfig> provider, Provider<NetworkData> provider2) {
        return new HeaderFactory_Factory(provider, provider2);
    }

    public static HeaderFactory newInstance(ZendeskComponentConfig zendeskComponentConfig, NetworkData networkData) {
        return new HeaderFactory(zendeskComponentConfig, networkData);
    }
}
