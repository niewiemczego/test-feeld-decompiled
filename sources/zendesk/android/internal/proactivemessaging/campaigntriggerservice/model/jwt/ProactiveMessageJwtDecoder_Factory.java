package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

import com.squareup.moshi.Moshi;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class ProactiveMessageJwtDecoder_Factory implements Factory<ProactiveMessageJwtDecoder> {
    private final Provider<Moshi> moshiProvider;

    public ProactiveMessageJwtDecoder_Factory(Provider<Moshi> provider) {
        this.moshiProvider = provider;
    }

    public ProactiveMessageJwtDecoder get() {
        return newInstance(this.moshiProvider.get());
    }

    public static ProactiveMessageJwtDecoder_Factory create(Provider<Moshi> provider) {
        return new ProactiveMessageJwtDecoder_Factory(provider);
    }

    public static ProactiveMessageJwtDecoder newInstance(Moshi moshi) {
        return new ProactiveMessageJwtDecoder(moshi);
    }
}
