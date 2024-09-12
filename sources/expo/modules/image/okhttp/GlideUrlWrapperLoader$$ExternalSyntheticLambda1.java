package expo.modules.image.okhttp;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class GlideUrlWrapperLoader$$ExternalSyntheticLambda1 implements Interceptor {
    public final /* synthetic */ GlideUrlWrapper f$0;

    public /* synthetic */ GlideUrlWrapperLoader$$ExternalSyntheticLambda1(GlideUrlWrapper glideUrlWrapper) {
        this.f$0 = glideUrlWrapper;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return GlideUrlWrapperLoader.m765buildLoadData$lambda1(this.f$0, chain);
    }
}
