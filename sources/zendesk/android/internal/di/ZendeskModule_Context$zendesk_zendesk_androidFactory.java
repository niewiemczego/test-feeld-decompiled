package zendesk.android.internal.di;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ZendeskModule_Context$zendesk_zendesk_androidFactory implements Factory<Context> {
    private final ZendeskModule module;

    public ZendeskModule_Context$zendesk_zendesk_androidFactory(ZendeskModule zendeskModule) {
        this.module = zendeskModule;
    }

    public Context get() {
        return context$zendesk_zendesk_android(this.module);
    }

    public static ZendeskModule_Context$zendesk_zendesk_androidFactory create(ZendeskModule zendeskModule) {
        return new ZendeskModule_Context$zendesk_zendesk_androidFactory(zendeskModule);
    }

    public static Context context$zendesk_zendesk_android(ZendeskModule zendeskModule) {
        return (Context) Preconditions.checkNotNullFromProvides(zendeskModule.context$zendesk_zendesk_android());
    }
}
