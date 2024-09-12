package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.inject.Provider;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaci  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public interface zzaci {
    public static final Logger zza = new Logger("FirebaseAuth", "GetAuthDomainTaskResponseHandler");

    Context zza();

    Uri.Builder zza(Intent intent, String str, String str2);

    String zza(String str);

    HttpURLConnection zza(URL url);

    void zza(Uri uri, String str, Provider<InteropAppCheckTokenProvider> provider);

    void zza(String str, Status status);
}
