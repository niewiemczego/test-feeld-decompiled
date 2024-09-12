package zendesk.android.internal.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;
import zendesk.android.internal.di.ZendeskComponentConfig;

public final class NetworkModule_RetrofitFactory implements Factory<Retrofit> {
    private final Provider<ZendeskComponentConfig> componentConfigProvider;
    private final NetworkModule module;
    private final Provider<MoshiConverterFactory> moshiConverterFactoryProvider;
    private final Provider<OkHttpClient> okHttpClientProvider;

    public NetworkModule_RetrofitFactory(NetworkModule networkModule, Provider<ZendeskComponentConfig> provider, Provider<OkHttpClient> provider2, Provider<MoshiConverterFactory> provider3) {
        this.module = networkModule;
        this.componentConfigProvider = provider;
        this.okHttpClientProvider = provider2;
        this.moshiConverterFactoryProvider = provider3;
    }

    public Retrofit get() {
        return retrofit(this.module, this.componentConfigProvider.get(), this.okHttpClientProvider.get(), this.moshiConverterFactoryProvider.get());
    }

    public static NetworkModule_RetrofitFactory create(NetworkModule networkModule, Provider<ZendeskComponentConfig> provider, Provider<OkHttpClient> provider2, Provider<MoshiConverterFactory> provider3) {
        return new NetworkModule_RetrofitFactory(networkModule, provider, provider2, provider3);
    }

    public static Retrofit retrofit(NetworkModule networkModule, ZendeskComponentConfig zendeskComponentConfig, OkHttpClient okHttpClient, MoshiConverterFactory moshiConverterFactory) {
        return (Retrofit) Preconditions.checkNotNullFromProvides(networkModule.retrofit(zendeskComponentConfig, okHttpClient, moshiConverterFactory));
    }
}
