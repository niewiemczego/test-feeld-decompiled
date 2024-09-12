package expo.modules.adapters.react.apploader;

import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNHeadlessAppLoader$$ExternalSyntheticLambda0 implements ReactInstanceEventListener {
    public final /* synthetic */ HeadlessAppLoader.Params f$0;
    public final /* synthetic */ Consumer f$1;

    public /* synthetic */ RNHeadlessAppLoader$$ExternalSyntheticLambda0(HeadlessAppLoader.Params params, Consumer consumer) {
        this.f$0 = params;
        this.f$1 = consumer;
    }

    public final void onReactContextInitialized(ReactContext reactContext) {
        RNHeadlessAppLoader.m682loadApp$lambda0(this.f$0, this.f$1, reactContext);
    }
}
