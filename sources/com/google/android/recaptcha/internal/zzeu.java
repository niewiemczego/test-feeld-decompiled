package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.AssetHelper;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzeu extends WebViewClient {
    final /* synthetic */ zzez zza;

    zzeu(zzez zzez) {
        this.zza = zzez;
    }

    public final void onLoadResource(WebView webView, String str) {
        System.currentTimeMillis();
    }

    public final void onPageFinished(WebView webView, String str) {
        zzez zzez = this.zza;
        zzez.zzi.zza(zzez.zzp.zza(zzne.INIT_NETWORK));
        long zza2 = this.zza.zzn.zza(TimeUnit.MICROSECONDS);
        zzv zzv = zzv.zza;
        zzv.zza(zzx.zzl.zza(), zza2);
    }

    @Deprecated(message = "Use onReceivedError(WebView,request,error) instead")
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        zzn zzn = zzn.zze;
        zzl zzl = (zzl) this.zza.zzk.get(Integer.valueOf(i));
        if (zzl == null) {
            zzl = zzl.zzY;
        }
        zzp zzp = new zzp(zzn, zzl, (String) null);
        this.zza.zzk().hashCode();
        zzp.getMessage();
        this.zza.zzk().completeExceptionally(zzp);
    }

    @Deprecated(message = "Use shouldInterceptRequest(WebView,WebResourceRequest) instead")
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        zzfb zzfb = zzfb.zza;
        Intrinsics.checkNotNull(parse);
        if (!zzfb.zzb(parse) || zzfb.zza(parse)) {
            return super.shouldInterceptRequest(webView, str);
        }
        zzp zzp = new zzp(zzn.zzc, zzl.zzac, (String) null);
        this.zza.zzk().hashCode();
        parse.toString();
        this.zza.zzk().completeExceptionally(zzp);
        return new WebResourceResponse(AssetHelper.DEFAULT_MIME_TYPE, "UTF-8", new ByteArrayInputStream(new byte[0]));
    }
}
