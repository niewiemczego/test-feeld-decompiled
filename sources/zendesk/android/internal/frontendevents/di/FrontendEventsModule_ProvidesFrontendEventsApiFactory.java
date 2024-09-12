package zendesk.android.internal.frontendevents.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import retrofit2.Retrofit;
import zendesk.android.internal.frontendevents.FrontendEventsApi;

public final class FrontendEventsModule_ProvidesFrontendEventsApiFactory implements Factory<FrontendEventsApi> {
    private final FrontendEventsModule module;
    private final Provider<Retrofit> retrofitProvider;

    public FrontendEventsModule_ProvidesFrontendEventsApiFactory(FrontendEventsModule frontendEventsModule, Provider<Retrofit> provider) {
        this.module = frontendEventsModule;
        this.retrofitProvider = provider;
    }

    public FrontendEventsApi get() {
        return providesFrontendEventsApi(this.module, this.retrofitProvider.get());
    }

    public static FrontendEventsModule_ProvidesFrontendEventsApiFactory create(FrontendEventsModule frontendEventsModule, Provider<Retrofit> provider) {
        return new FrontendEventsModule_ProvidesFrontendEventsApiFactory(frontendEventsModule, provider);
    }

    public static FrontendEventsApi providesFrontendEventsApi(FrontendEventsModule frontendEventsModule, Retrofit retrofit) {
        return (FrontendEventsApi) Preconditions.checkNotNullFromProvides(frontendEventsModule.providesFrontendEventsApi(retrofit));
    }
}
