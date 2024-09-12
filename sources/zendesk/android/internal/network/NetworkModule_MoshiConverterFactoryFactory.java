package zendesk.android.internal.network;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.converter.moshi.MoshiConverterFactory;

public final class NetworkModule_MoshiConverterFactoryFactory implements Factory<MoshiConverterFactory> {
    private final NetworkModule module;
    private final Provider<Moshi> moshiProvider;

    public NetworkModule_MoshiConverterFactoryFactory(NetworkModule networkModule, Provider<Moshi> provider) {
        this.module = networkModule;
        this.moshiProvider = provider;
    }

    public MoshiConverterFactory get() {
        return moshiConverterFactory(this.module, this.moshiProvider.get());
    }

    public static NetworkModule_MoshiConverterFactoryFactory create(NetworkModule networkModule, Provider<Moshi> provider) {
        return new NetworkModule_MoshiConverterFactoryFactory(networkModule, provider);
    }

    public static MoshiConverterFactory moshiConverterFactory(NetworkModule networkModule, Moshi moshi) {
        return (MoshiConverterFactory) Preconditions.checkNotNullFromProvides(networkModule.moshiConverterFactory(moshi));
    }
}
