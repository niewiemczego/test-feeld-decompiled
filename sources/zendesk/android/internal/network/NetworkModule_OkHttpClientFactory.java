package zendesk.android.internal.network;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

public final class NetworkModule_OkHttpClientFactory implements Factory<OkHttpClient> {
    private final Provider<File> cacheDirProvider;
    private final Provider<HeaderFactory> headerFactoryProvider;
    private final NetworkModule module;

    public NetworkModule_OkHttpClientFactory(NetworkModule networkModule, Provider<HeaderFactory> provider, Provider<File> provider2) {
        this.module = networkModule;
        this.headerFactoryProvider = provider;
        this.cacheDirProvider = provider2;
    }

    public OkHttpClient get() {
        return okHttpClient(this.module, this.headerFactoryProvider.get(), this.cacheDirProvider.get());
    }

    public static NetworkModule_OkHttpClientFactory create(NetworkModule networkModule, Provider<HeaderFactory> provider, Provider<File> provider2) {
        return new NetworkModule_OkHttpClientFactory(networkModule, provider, provider2);
    }

    public static OkHttpClient okHttpClient(NetworkModule networkModule, HeaderFactory headerFactory, File file) {
        return (OkHttpClient) Preconditions.checkNotNullFromProvides(networkModule.okHttpClient(headerFactory, file));
    }
}
