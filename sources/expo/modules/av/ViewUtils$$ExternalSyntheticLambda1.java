package expo.modules.av;

import expo.modules.av.ViewUtils;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ModuleRegistry f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ ViewUtils.VideoViewCallback f$2;
    public final /* synthetic */ Promise f$3;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda1(ModuleRegistry moduleRegistry, int i, ViewUtils.VideoViewCallback videoViewCallback, Promise promise) {
        this.f$0 = moduleRegistry;
        this.f$1 = i;
        this.f$2 = videoViewCallback;
        this.f$3 = promise;
    }

    public final void run() {
        ViewUtils.m711tryRunWithVideoView$lambda0(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
