package expo.modules.filesystem;

import expo.modules.filesystem.FileSystemModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "intercept", "okhttp3/OkHttpClient$Builder$addNetworkInterceptor$2"}, k = 3, mv = {1, 7, 1})
/* renamed from: expo.modules.filesystem.FileSystemModule$downloadResumableStartAsync$$inlined$-addNetworkInterceptor$1  reason: invalid class name */
/* compiled from: OkHttpClient.kt */
public final class FileSystemModule$downloadResumableStartAsync$$inlined$addNetworkInterceptor$1 implements Interceptor {
    final /* synthetic */ FileSystemModule.ProgressListener $progressListener$inlined;

    public FileSystemModule$downloadResumableStartAsync$$inlined$addNetworkInterceptor$1(FileSystemModule.ProgressListener progressListener) {
        this.$progressListener$inlined = progressListener;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        return proceed.newBuilder().body(new FileSystemModule.ProgressResponseBody(proceed.body(), this.$progressListener$inlined)).build();
    }
}
