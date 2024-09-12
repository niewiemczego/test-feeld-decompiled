package expo.modules.image.okhttp;

import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.modules.network.ProgressResponseBody;
import expo.modules.image.events.OkHttpProgressListener;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapperLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "Ljava/io/InputStream;", "commonClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "Factory", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideUrlWrapperLoader.kt */
public final class GlideUrlWrapperLoader implements ModelLoader<GlideUrlWrapper, InputStream> {
    private final OkHttpClient commonClient;

    public boolean handles(GlideUrlWrapper glideUrlWrapper) {
        Intrinsics.checkNotNullParameter(glideUrlWrapper, "model");
        return true;
    }

    public GlideUrlWrapperLoader(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "commonClient");
        this.commonClient = okHttpClient;
    }

    public ModelLoader.LoadData<InputStream> buildLoadData(GlideUrlWrapper glideUrlWrapper, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(glideUrlWrapper, "model");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new OkHttpUrlLoader(this.commonClient.newBuilder().addInterceptor(new GlideUrlWrapperLoader$$ExternalSyntheticLambda1(glideUrlWrapper)).build()).buildLoadData(glideUrlWrapper.getGlideUrl(), i, i2, options);
    }

    /* access modifiers changed from: private */
    /* renamed from: buildLoadData$lambda-1  reason: not valid java name */
    public static final Response m765buildLoadData$lambda1(GlideUrlWrapper glideUrlWrapper, Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(glideUrlWrapper, "$model");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), new GlideUrlWrapperLoader$$ExternalSyntheticLambda0(glideUrlWrapper))).build();
    }

    /* access modifiers changed from: private */
    /* renamed from: buildLoadData$lambda-1$lambda-0  reason: not valid java name */
    public static final void m766buildLoadData$lambda1$lambda0(GlideUrlWrapper glideUrlWrapper, long j, long j2, boolean z) {
        Intrinsics.checkNotNullParameter(glideUrlWrapper, "$model");
        OkHttpProgressListener progressListener = glideUrlWrapper.getProgressListener();
        if (progressListener != null) {
            progressListener.onProgress(j, j2, z);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapperLoader$Factory;", "Lcom/bumptech/glide/load/model/ModelLoaderFactory;", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "Ljava/io/InputStream;", "commonClient", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "build", "Lcom/bumptech/glide/load/model/ModelLoader;", "multiFactory", "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;", "teardown", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GlideUrlWrapperLoader.kt */
    public static final class Factory implements ModelLoaderFactory<GlideUrlWrapper, InputStream> {
        private final OkHttpClient commonClient;

        public void teardown() {
        }

        public Factory(OkHttpClient okHttpClient) {
            Intrinsics.checkNotNullParameter(okHttpClient, "commonClient");
            this.commonClient = okHttpClient;
        }

        public ModelLoader<GlideUrlWrapper, InputStream> build(MultiModelLoaderFactory multiModelLoaderFactory) {
            Intrinsics.checkNotNullParameter(multiModelLoaderFactory, "multiFactory");
            return new GlideUrlWrapperLoader(this.commonClient);
        }
    }
}
