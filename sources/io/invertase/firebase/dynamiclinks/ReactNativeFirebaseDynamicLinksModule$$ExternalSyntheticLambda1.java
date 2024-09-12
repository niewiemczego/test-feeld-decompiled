package io.invertase.firebase.dynamiclinks;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda1 implements OnCompleteListener {
    public final /* synthetic */ ReactNativeFirebaseDynamicLinksModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ ReactNativeFirebaseDynamicLinksModule$$ExternalSyntheticLambda1(ReactNativeFirebaseDynamicLinksModule reactNativeFirebaseDynamicLinksModule, Promise promise) {
        this.f$0 = reactNativeFirebaseDynamicLinksModule;
        this.f$1 = promise;
    }

    public final void onComplete(Task task) {
        this.f$0.m862lambda$getInitialLink$4$ioinvertasefirebasedynamiclinksReactNativeFirebaseDynamicLinksModule(this.f$1, task);
    }
}
