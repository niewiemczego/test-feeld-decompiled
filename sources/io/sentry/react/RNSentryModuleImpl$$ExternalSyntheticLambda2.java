package io.sentry.react;

import io.sentry.IScope;
import io.sentry.ScopeCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNSentryModuleImpl$$ExternalSyntheticLambda2 implements ScopeCallback {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ RNSentryModuleImpl$$ExternalSyntheticLambda2(String str, String str2) {
        this.f$0 = str;
        this.f$1 = str2;
    }

    public final void run(IScope iScope) {
        iScope.setTag(this.f$0, this.f$1);
    }
}
