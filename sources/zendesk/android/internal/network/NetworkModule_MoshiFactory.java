package zendesk.android.internal.network;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class NetworkModule_MoshiFactory implements Factory<Moshi> {
    private final NetworkModule module;

    public NetworkModule_MoshiFactory(NetworkModule networkModule) {
        this.module = networkModule;
    }

    public Moshi get() {
        return moshi(this.module);
    }

    public static NetworkModule_MoshiFactory create(NetworkModule networkModule) {
        return new NetworkModule_MoshiFactory(networkModule);
    }

    public static Moshi moshi(NetworkModule networkModule) {
        return (Moshi) Preconditions.checkNotNullFromProvides(networkModule.moshi());
    }
}
