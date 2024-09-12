package expo.modules.image.okhttp;

import com.facebook.react.modules.network.ProgressListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GlideUrlWrapperLoader$$ExternalSyntheticLambda0 implements ProgressListener {
    public final /* synthetic */ GlideUrlWrapper f$0;

    public /* synthetic */ GlideUrlWrapperLoader$$ExternalSyntheticLambda0(GlideUrlWrapper glideUrlWrapper) {
        this.f$0 = glideUrlWrapper;
    }

    public final void onProgress(long j, long j2, boolean z) {
        GlideUrlWrapperLoader.m766buildLoadData$lambda1$lambda0(this.f$0, j, j2, z);
    }
}
