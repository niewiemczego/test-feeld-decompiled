package io.seon.androidsdk.service;

import android.os.AsyncTask;
import androidx.browser.trusted.sharing.ShareTarget;
import io.seon.androidsdk.logger.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

class PublicIP extends AsyncTask<Void, Void, String> {
    private static final Logger a = Logger.withClass(PublicIP.class);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Void... voidArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("https://ipinfo.io/ip").openConnection();
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    return sb.toString();
                }
            }
        } catch (IOException e) {
            a.withCause(e, 6);
            return null;
        }
    }
}
