package io.sentry.react;

import com.facebook.react.bridge.ReadableMap;
import io.sentry.IScope;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda4 implements ScopeCallback {
    public final /* synthetic */ ReadableMap f$0;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda4(ReadableMap readableMap) {
        this.f$0 = readableMap;
    }

    public final void run(IScope iScope) {
        RNSentryModuleImpl.lambda$addBreadcrumb$5(this.f$0, iScope);
    }
}
