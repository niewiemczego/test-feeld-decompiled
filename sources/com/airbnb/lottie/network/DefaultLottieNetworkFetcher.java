package com.airbnb.lottie.network;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultLottieNetworkFetcher implements LottieNetworkFetcher {
    public LottieFetchResult fetchSync(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
        httpURLConnection.connect();
        return new DefaultLottieFetchResult(httpURLConnection);
    }
}
