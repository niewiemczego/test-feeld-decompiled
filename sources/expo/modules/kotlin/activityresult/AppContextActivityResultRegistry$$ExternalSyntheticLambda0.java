package expo.modules.kotlin.activityresult;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppContextActivityResultRegistry$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ AppContextActivityResultRegistry f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ AppContextActivityResultRegistry$$ExternalSyntheticLambda0(AppContextActivityResultRegistry appContextActivityResultRegistry, String str) {
        this.f$0 = appContextActivityResultRegistry;
        this.f$1 = str;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        AppContextActivityResultRegistry.m777register$lambda4(this.f$0, this.f$1, lifecycleOwner, event);
    }
}
