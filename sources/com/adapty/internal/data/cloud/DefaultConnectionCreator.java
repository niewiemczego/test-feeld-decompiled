package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cloud.NetworkConnectionCreator;
import com.adapty.internal.data.cloud.Request;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/cloud/DefaultConnectionCreator;", "Lcom/adapty/internal/data/cloud/NetworkConnectionCreator;", "()V", "createUrlConnection", "Ljava/net/HttpURLConnection;", "request", "Lcom/adapty/internal/data/cloud/Request;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NetworkConnectionCreator.kt */
public final class DefaultConnectionCreator implements NetworkConnectionCreator {
    public int getTimeOut() {
        return NetworkConnectionCreator.DefaultImpls.getTimeOut(this);
    }

    public HttpURLConnection createUrlConnection(Request request) {
        Intrinsics.checkNotNullParameter(request, "request");
        URLConnection openConnection = new URL(request.getUrl()).openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
        httpURLConnection.setConnectTimeout(getTimeOut());
        httpURLConnection.setReadTimeout(getTimeOut());
        httpURLConnection.setRequestMethod(request.getMethod().name());
        httpURLConnection.setDoInput(true);
        Set<Request.Header> set = request.headers;
        if (set != null) {
            for (Request.Header header : set) {
                httpURLConnection.setRequestProperty(header.getKey(), header.getValue());
            }
        }
        if (request.getMethod() != Request.Method.GET) {
            httpURLConnection.setDoOutput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(request.body);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
        }
        return httpURLConnection;
    }
}
