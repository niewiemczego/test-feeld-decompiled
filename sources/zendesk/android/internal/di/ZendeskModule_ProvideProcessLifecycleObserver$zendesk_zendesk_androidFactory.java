package zendesk.android.internal.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;

public final class ZendeskModule_ProvideProcessLifecycleObserver$zendesk_zendesk_androidFactory implements Factory<ProcessLifecycleObserver> {
    private final ZendeskModule module;

    public ZendeskModule_ProvideProcessLifecycleObserver$zendesk_zendesk_androidFactory(ZendeskModule zendeskModule) {
        this.module = zendeskModule;
    }

    public ProcessLifecycleObserver get() {
        return provideProcessLifecycleObserver$zendesk_zendesk_android(this.module);
    }

    public static ZendeskModule_ProvideProcessLifecycleObserver$zendesk_zendesk_androidFactory create(ZendeskModule zendeskModule) {
        return new ZendeskModule_ProvideProcessLifecycleObserver$zendesk_zendesk_androidFactory(zendeskModule);
    }

    public static ProcessLifecycleObserver provideProcessLifecycleObserver$zendesk_zendesk_android(ZendeskModule zendeskModule) {
        return (ProcessLifecycleObserver) Preconditions.checkNotNullFromProvides(zendeskModule.provideProcessLifecycleObserver$zendesk_zendesk_android());
    }
}
