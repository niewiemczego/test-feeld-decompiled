package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p002firebaseauthapi.zzacg;
import com.google.android.gms.internal.p002firebaseauthapi.zzaci;
import com.google.android.gms.internal.p002firebaseauthapi.zzacl;
import com.google.android.gms.internal.p002firebaseauthapi.zzaec;
import com.google.android.gms.internal.p002firebaseauthapi.zzags;
import com.google.android.gms.internal.p002firebaseauthapi.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.inject.Provider;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class GenericIdpActivity extends FragmentActivity implements zzaci {
    private static long zzb;
    private static final zzce zzc = zzce.zzc();
    private boolean zzd = false;

    public final Context zza() {
        return getApplicationContext();
    }

    private final Uri.Builder zza(Uri.Builder builder, Intent intent, String str, String str2) {
        Uri.Builder builder2 = builder;
        Intent intent2 = intent;
        String stringExtra = intent2.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent2.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent2.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent2.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent2.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        String zza = zza(intent2.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS"));
        String uuid = UUID.randomUUID().toString();
        String zza2 = zzacl.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent2.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String str3 = stringExtra;
        String str4 = zza2;
        String str5 = uuid;
        String str6 = zza;
        String str7 = join;
        zzo.zza().zza(getApplicationContext(), str, uuid, zza2, action, stringExtra2, stringExtra3, stringExtra4);
        String zza3 = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(stringExtra4).getPersistenceKey()).zza();
        if (TextUtils.isEmpty(zza3)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            zza(zzao.zza("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        } else if (str4 == null) {
            return null;
        } else {
            builder2.appendQueryParameter("eid", "p").appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter(DynamicLink.Builder.KEY_API_KEY, str3).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", str4).appendQueryParameter("eventId", str5).appendQueryParameter(DynamicLink.AndroidParameters.KEY_ANDROID_PACKAGE_NAME, str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zza3);
            if (!TextUtils.isEmpty(str7)) {
                builder2.appendQueryParameter("scopes", str7);
            }
            if (!TextUtils.isEmpty(str6)) {
                builder2.appendQueryParameter("customParameters", str6);
            }
            if (!TextUtils.isEmpty(stringExtra3)) {
                builder2.appendQueryParameter("tid", stringExtra3);
            }
            return builder2;
        }
    }

    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return zza(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    static /* synthetic */ Uri zza(Uri uri, Task task) throws Exception {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                Log.w("GenericIdpActivity", "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(appCheckTokenResult.getError()));
            }
            buildUpon.fragment("fac=" + appCheckTokenResult.getToken());
        } else {
            Log.e("GenericIdpActivity", "Unexpected error getting App Check token: " + task.getException().getMessage());
        }
        return buildUpon.build();
    }

    public final String zza(String str) {
        return zzaec.zzb(str);
    }

    private static String zza(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put(str, (Object) string);
                }
            }
        } catch (JSONException unused) {
            Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
        }
        return jSONObject.toString();
    }

    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zzb.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    private final void zzb() {
        zzb = 0;
        this.zzd = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!zza(intent)) {
            zzbl.zza((Context) this, zzao.zza("WEB_CONTEXT_CANCELED"));
        } else {
            zzc.zza((Context) this);
        }
        finish();
    }

    private final void zza(Status status) {
        zzb = 0;
        this.zzd = false;
        Intent intent = new Intent();
        zzcf.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!zza(intent)) {
            zzbl.zza(getApplicationContext(), status);
        } else {
            zzc.zza((Context) this);
        }
        finish();
    }

    public final void zza(String str, Status status) {
        if (status == null) {
            zzb();
        } else {
            zza(status);
        }
    }

    public final void zza(Uri uri, String str, Provider<InteropAppCheckTokenProvider> provider) {
        Task<TContinuationResult> task;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = provider.get();
        if (interopAppCheckTokenProvider != null) {
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzbf(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzbg(this, str));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzb < 30000) {
                Log.e("GenericIdpActivity", "Could not start operation - already in progress");
                return;
            }
            zzb = currentTimeMillis;
            if (bundle != null) {
                this.zzd = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
                return;
            }
            return;
        }
        Log.e("GenericIdpActivity", "Could not do operation - unknown action: " + action);
        zzb();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if ("android.intent.action.VIEW".equals(getIntent().getAction())) {
            Intent intent = getIntent();
            if (intent.hasExtra("firebaseError")) {
                zza(zzcf.zza(intent.getStringExtra("firebaseError")));
            } else if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
                zzb();
            } else {
                String stringExtra = intent.getStringExtra("link");
                String stringExtra2 = intent.getStringExtra("eventId");
                String packageName = getPackageName();
                boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
                zzr zza = zzo.zza().zza(this, packageName, stringExtra2);
                if (zza == null) {
                    zzb();
                }
                if (booleanExtra) {
                    stringExtra = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(zza.zza()).getPersistenceKey()).zza(stringExtra);
                }
                zzags zzags = new zzags(zza, stringExtra);
                String zze = zza.zze();
                String zzb2 = zza.zzb();
                zzags.zzb(zze);
                if ("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(zzb2) || "com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(zzb2)) {
                    zzb = 0;
                    this.zzd = false;
                    Intent intent2 = new Intent();
                    SafeParcelableSerializer.serializeToIntentExtra(zzags, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
                    intent2.putExtra("com.google.firebase.auth.internal.OPERATION", zzb2);
                    intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                    if (!zza(intent2)) {
                        zzbl.zza(getApplicationContext(), zzags, zzb2, zze);
                    } else {
                        zzc.zza((Context) this);
                    }
                    finish();
                    return;
                }
                Log.e("GenericIdpActivity", "unsupported operation: " + zzb2);
                zzb();
            }
        } else if (!this.zzd) {
            String packageName2 = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName2)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
                if (!zzaec.zza(instance)) {
                    new zzacg(packageName2, lowerCase, getIntent(), instance, this).executeOnExecutor(instance2.zze(), new Void[0]);
                } else {
                    zza(zza(Uri.parse(zzaec.zza(instance.getOptions().getApiKey())).buildUpon(), getIntent(), packageName2, lowerCase).build(), packageName2, instance2.zzc());
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName2 + " " + String.valueOf(e));
                zzacl.zzb(this, packageName2);
            }
            this.zzd = true;
        } else {
            zzb();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzd);
    }

    private final boolean zza(Intent intent) {
        return LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
