package io.sentry.react;

import com.facebook.react.bridge.ReadableMap;
import io.sentry.IScope;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda9 implements ScopeCallback {
    public final /* synthetic */ ReadableMap f$0;
    public final /* synthetic */ ReadableMap f$1;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda9(ReadableMap readableMap, ReadableMap readableMap2) {
        this.f$0 = readableMap;
        this.f$1 = readableMap2;
    }

    public final void run(IScope iScope) {
        RNSentryModuleImpl.lambda$setUser$4(this.f$0, this.f$1, iScope);
    }
}
