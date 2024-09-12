package zendesk.android.internal.network;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;
import zendesk.android.internal.di.ZendeskComponentConfig;

public final class NetworkData_Factory implements Factory<NetworkData> {
    private final Provider<ZendeskComponentConfig> configProvider;
    private final Provider<Context> contextProvider;

    public NetworkData_Factory(Provider<Context> provider, Provider<ZendeskComponentConfig> provider2) {
        this.contextProvider = provider;
        this.configProvider = provider2;
    }

    public NetworkData get() {
        return newInstance(this.contextProvider.get(), this.configProvider.get());
    }

    public static NetworkData_Factory create(Provider<Context> provider, Provider<ZendeskComponentConfig> provider2) {
        return new NetworkData_Factory(provider, provider2);
    }

    public static NetworkData newInstance(Context context, ZendeskComponentConfig zendeskComponentConfig) {
        return new NetworkData(context, zendeskComponentConfig);
    }
}
