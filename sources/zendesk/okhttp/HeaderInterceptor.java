package zendesk.okhttp;

import java.io.IOException;
import java.text.Normalizer;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B:\u00120\u0010\u0002\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u00040\u0003ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0002R;\u0010\u0002\u001a,\u0012(\u0012&\u0012\u0004\u0012\u00020\u0005\u0012\u001c\u0012\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00060\u00040\u0003X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lzendesk/okhttp/HeaderInterceptor;", "Lokhttp3/Interceptor;", "headers", "", "Lkotlin/Pair;", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/util/Set;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "normalizeHeaderValue", "headerValue", "zendesk.okhttp_okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeaderInterceptor.kt */
public final class HeaderInterceptor implements Interceptor {
    private final Set<Pair<String, Function1<Continuation<? super String>, Object>>> headers;

    public HeaderInterceptor(Set<? extends Pair<String, ? extends Function1<? super Continuation<? super String>, ? extends Object>>> set) {
        Intrinsics.checkNotNullParameter(set, "headers");
        this.headers = set;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder newBuilder = chain.request().newBuilder();
        for (Pair next : this.headers) {
            String str = (String) next.component1();
            String str2 = null;
            String str3 = (String) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new HeaderInterceptor$intercept$headerValue$1((Function1) next.component2(), (Continuation<? super HeaderInterceptor$intercept$headerValue$1>) null), 1, (Object) null);
            if (str3 != null) {
                if (true ^ StringsKt.isBlank(str3)) {
                    str2 = str3;
                }
                if (str2 != null) {
                    newBuilder.addHeader(str, normalizeHeaderValue(str2));
                }
            }
        }
        return chain.proceed(newBuilder.build());
    }

    private final String normalizeHeaderValue(String str) {
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        Intrinsics.checkNotNullExpressionValue(normalize, "normalize(headerValue, Normalizer.Form.NFD)");
        return new Regex("[^\\p{ASCII}]").replace((CharSequence) normalize, "");
    }
}
