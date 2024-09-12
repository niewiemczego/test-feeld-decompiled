package zendesk.android.internal.network;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import java.io.File;
import javax.inject.Provider;

public final class NetworkModule_CacheDirFactory implements Factory<File> {
    private final Provider<Context> contextProvider;
    private final NetworkModule module;

    public NetworkModule_CacheDirFactory(NetworkModule networkModule, Provider<Context> provider) {
        this.module = networkModule;
        this.contextProvider = provider;
    }

    public File get() {
        return cacheDir(this.module, this.contextProvider.get());
    }

    public static NetworkModule_CacheDirFactory create(NetworkModule networkModule, Provider<Context> provider) {
        return new NetworkModule_CacheDirFactory(networkModule, provider);
    }

    public static File cacheDir(NetworkModule networkModule, Context context) {
        return (File) Preconditions.checkNotNullFromProvides(networkModule.cacheDir(context));
    }
}
