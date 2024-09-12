package zendesk.android.internal.network;

import com.google.common.net.HttpHeaders;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import zendesk.android.internal.ZendeskLoggingInterceptor;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.okhttp.HeaderInterceptor;

@Singleton
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u0007\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/android/internal/network/HeaderFactory;", "", "componentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "networkData", "Lzendesk/android/internal/network/NetworkData;", "(Lzendesk/android/internal/di/ZendeskComponentConfig;Lzendesk/android/internal/network/NetworkData;)V", "loggingInterceptor", "Lzendesk/android/internal/ZendeskLoggingInterceptor;", "createHeaderInterceptor", "Lzendesk/okhttp/HeaderInterceptor;", "Lokhttp3/Interceptor;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeaderFactory.kt */
public final class HeaderFactory {
    /* access modifiers changed from: private */
    public final ZendeskComponentConfig componentConfig;
    private final ZendeskLoggingInterceptor loggingInterceptor = new ZendeskLoggingInterceptor();
    /* access modifiers changed from: private */
    public final NetworkData networkData;

    @Inject
    public HeaderFactory(ZendeskComponentConfig zendeskComponentConfig, NetworkData networkData2) {
        Intrinsics.checkNotNullParameter(zendeskComponentConfig, "componentConfig");
        Intrinsics.checkNotNullParameter(networkData2, "networkData");
        this.componentConfig = zendeskComponentConfig;
        this.networkData = networkData2;
    }

    public final HeaderInterceptor createHeaderInterceptor() {
        return new HeaderInterceptor(SetsKt.setOf(TuplesKt.to("Accept", new HeaderFactory$createHeaderInterceptor$1((Continuation<? super HeaderFactory$createHeaderInterceptor$1>) null)), TuplesKt.to("Content-Type", new HeaderFactory$createHeaderInterceptor$2((Continuation<? super HeaderFactory$createHeaderInterceptor$2>) null)), TuplesKt.to(HttpHeaders.ACCEPT_LANGUAGE, new HeaderFactory$createHeaderInterceptor$3(this, (Continuation<? super HeaderFactory$createHeaderInterceptor$3>) null)), TuplesKt.to("User-Agent", new HeaderFactory$createHeaderInterceptor$4(this, (Continuation<? super HeaderFactory$createHeaderInterceptor$4>) null)), TuplesKt.to("X-Zendesk-Client", new HeaderFactory$createHeaderInterceptor$5((Continuation<? super HeaderFactory$createHeaderInterceptor$5>) null)), TuplesKt.to("X-Zendesk-Client-Version", new HeaderFactory$createHeaderInterceptor$6(this, (Continuation<? super HeaderFactory$createHeaderInterceptor$6>) null))));
    }

    public final Interceptor loggingInterceptor() {
        return this.loggingInterceptor;
    }
}
