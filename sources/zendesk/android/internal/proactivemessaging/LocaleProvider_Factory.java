package zendesk.android.internal.proactivemessaging;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class LocaleProvider_Factory implements Factory<LocaleProvider> {
    private final Provider<Context> contextProvider;

    public LocaleProvider_Factory(Provider<Context> provider) {
        this.contextProvider = provider;
    }

    public LocaleProvider get() {
        return newInstance(this.contextProvider.get());
    }

    public static LocaleProvider_Factory create(Provider<Context> provider) {
        return new LocaleProvider_Factory(provider);
    }

    public static LocaleProvider newInstance(Context context) {
        return new LocaleProvider(context);
    }
}
