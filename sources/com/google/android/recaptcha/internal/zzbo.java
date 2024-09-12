package com.google.android.recaptcha.internal;

import android.net.TrafficStats;
import android.webkit.URLUtil;
import androidx.browser.trusted.sharing.ShareTarget;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbo implements zzbn {
    private final String zza;

    public zzbo(String str) {
        this.zza = str;
    }

    private static final void zzb(byte[] bArr) {
        for (zznf zznf : zzni.zzk(bArr).zzH()) {
            if (!CollectionsKt.listOf("INIT_TOTAL", "EXECUTE_TOTAL").contains(zznf.zzj().name()) || !zznf.zzT()) {
                zznf.zzJ();
                zznf.zzK();
                zznf.zzj().name();
                zznf.zzU();
            } else {
                zznf.zzJ();
                zznf.zzK();
                zznf.zzj().name();
                zznf.zzg().zzk();
                zznf.zzg().zzf();
                zznf.zzU();
            }
        }
    }

    public final boolean zza(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        try {
            TrafficStats.setThreadStatsTag((int) Thread.currentThread().getId());
            zzb(bArr);
            if (URLUtil.isHttpUrl(this.zza)) {
                URLConnection openConnection = new URL(this.zza).openConnection();
                Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
                httpURLConnection = (HttpURLConnection) openConnection;
            } else if (URLUtil.isHttpsUrl(this.zza)) {
                URLConnection openConnection2 = new URL(this.zza).openConnection();
                Intrinsics.checkNotNull(openConnection2, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                httpURLConnection = (HttpsURLConnection) openConnection2;
            } else {
                throw new MalformedURLException("Recaptcha server url only allows using Http or Https.");
            }
            httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-protobuffer");
            httpURLConnection.connect();
            httpURLConnection.getOutputStream().write(bArr);
            if (httpURLConnection.getResponseCode() == 200) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }
}
