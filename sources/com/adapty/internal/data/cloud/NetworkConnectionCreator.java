package com.adapty.internal.data.cloud;

import java.net.HttpURLConnection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\ba\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/cloud/NetworkConnectionCreator;", "", "createUrlConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/adapty/internal/data/cloud/Request;", "getTimeOut", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NetworkConnectionCreator.kt */
public interface NetworkConnectionCreator {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: NetworkConnectionCreator.kt */
    public static final class DefaultImpls {
        public static int getTimeOut(NetworkConnectionCreator networkConnectionCreator) {
            return 30000;
        }
    }

    HttpURLConnection createUrlConnection(Request request);

    int getTimeOut();
}
