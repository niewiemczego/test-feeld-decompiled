package zendesk.faye;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import zendesk.faye.internal.DefaultFayeClient;
import zendesk.faye.internal.OkHttpWebSocket;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/faye/FayeClientBuilder;", "", "serverUrl", "", "(Ljava/lang/String;)V", "fayeClientListener", "Lzendesk/faye/FayeClientListener;", "okHttpClient", "Lokhttp3/OkHttpClient;", "build", "Lzendesk/faye/FayeClient;", "withListener", "withOkHttpClient", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FayeClientBuilder.kt */
public final class FayeClientBuilder {
    private FayeClientListener fayeClientListener;
    private OkHttpClient okHttpClient;
    private final String serverUrl;

    public FayeClientBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "serverUrl");
        this.serverUrl = str;
    }

    public final FayeClientBuilder withOkHttpClient(OkHttpClient okHttpClient2) {
        Intrinsics.checkNotNullParameter(okHttpClient2, "okHttpClient");
        FayeClientBuilder fayeClientBuilder = this;
        this.okHttpClient = okHttpClient2;
        return this;
    }

    public final FayeClientBuilder withListener(FayeClientListener fayeClientListener2) {
        Intrinsics.checkNotNullParameter(fayeClientListener2, "fayeClientListener");
        FayeClientBuilder fayeClientBuilder = this;
        this.fayeClientListener = fayeClientListener2;
        return this;
    }

    public final FayeClient build() {
        OkHttpClient okHttpClient2 = this.okHttpClient;
        if (okHttpClient2 == null) {
            okHttpClient2 = new OkHttpClient();
        }
        DefaultFayeClient defaultFayeClient = new DefaultFayeClient(this.serverUrl, new OkHttpWebSocket(okHttpClient2));
        FayeClientListener fayeClientListener2 = this.fayeClientListener;
        if (fayeClientListener2 != null) {
            defaultFayeClient.addListener(fayeClientListener2);
        }
        return defaultFayeClient;
    }
}
