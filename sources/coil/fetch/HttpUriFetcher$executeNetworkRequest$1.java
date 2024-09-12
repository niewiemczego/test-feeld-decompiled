package coil.fetch;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okhttp3.Request;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "coil.fetch.HttpUriFetcher", f = "HttpUriFetcher.kt", i = {}, l = {223}, m = "executeNetworkRequest", n = {}, s = {})
/* compiled from: HttpUriFetcher.kt */
final class HttpUriFetcher$executeNetworkRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpUriFetcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpUriFetcher$executeNetworkRequest$1(HttpUriFetcher httpUriFetcher, Continuation<? super HttpUriFetcher$executeNetworkRequest$1> continuation) {
        super(continuation);
        this.this$0 = httpUriFetcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.executeNetworkRequest((Request) null, this);
    }
}
