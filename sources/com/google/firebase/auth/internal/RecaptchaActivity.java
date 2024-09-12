package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsService;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p002firebaseauthapi.zzacg;
import com.google.android.gms.internal.p002firebaseauthapi.zzaci;
import com.google.android.gms.internal.p002firebaseauthapi.zzacl;
import com.google.android.gms.internal.p002firebaseauthapi.zzacu;
import com.google.android.gms.internal.p002firebaseauthapi.zzaec;
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
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class RecaptchaActivity extends FragmentActivity implements zzaci {
    private static final String zzb = "RecaptchaActivity";
    private static long zzc;
    private static final zzce zzd = zzce.zzc();
    private boolean zze = false;

    public final Context zza() {
        return getApplicationContext();
    }

    private final Uri.Builder zza(Uri.Builder builder, Intent intent, String str, String str2) {
        String str3;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        FirebaseApp instance = FirebaseApp.getInstance(stringExtra3);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzo.zza().zza(getApplicationContext(), str, uuid, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA", stringExtra3);
        String zza = zzq.zza(getApplicationContext(), instance.getPersistenceKey()).zza();
        if (TextUtils.isEmpty(zza)) {
            Log.e(zzb, "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            zza(zzao.zza("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        if (!TextUtils.isEmpty(instance2.getLanguageCode())) {
            str3 = instance2.getLanguageCode();
        } else {
            str3 = zzacu.zza();
        }
        builder.appendQueryParameter(DynamicLink.Builder.KEY_API_KEY, stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter(DynamicLink.AndroidParameters.KEY_ANDROID_PACKAGE_NAME, str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", zza);
        return builder;
    }

    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return zza(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    static /* synthetic */ Uri zza(Uri uri, Task task) throws Exception {
        Uri.Builder buildUpon = uri.buildUpon();
        if (task.isSuccessful()) {
            AppCheckTokenResult appCheckTokenResult = (AppCheckTokenResult) task.getResult();
            if (appCheckTokenResult.getError() != null) {
                Log.w(zzb, "Error getting App Check token; using placeholder token instead. Error: " + String.valueOf(appCheckTokenResult.getError()));
            }
            buildUpon.fragment("fac=" + appCheckTokenResult.getToken());
        } else {
            Log.e(zzb, "Unexpected error getting App Check token: " + task.getException().getMessage());
        }
        return buildUpon.build();
    }

    public final String zza(String str) {
        return zzaec.zzb(str);
    }

    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zzb.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    private final void zzb() {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        zza(intent);
        zzd.zza((Context) this);
        finish();
    }

    private final void zza(Status status) {
        zzc = 0;
        this.zze = false;
        Intent intent = new Intent();
        zzcf.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        zza(intent);
        zzd.zza((Context) this);
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
            task = interopAppCheckTokenProvider.getToken(false).continueWith(new zzbp(uri));
        } else {
            task = Tasks.forResult(uri);
        }
        task.addOnCompleteListener(new zzbn(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, Task task) {
        boolean z = false;
        if (getPackageManager().resolveActivity(new Intent("android.intent.action.VIEW"), 0) != null) {
            List<ResolveInfo> queryIntentServices = getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                z = true;
            }
            if (z) {
                CustomTabsIntent build = new CustomTabsIntent.Builder().build();
                build.intent.addFlags(1073741824);
                build.intent.addFlags(268435456);
                build.launchUrl(this, (Uri) task.getResult());
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", (Uri) task.getResult());
            intent.putExtra("com.android.browser.application_id", str);
            intent.addFlags(1073741824);
            intent.addFlags(268435456);
            startActivity(intent);
            return;
        }
        Log.e(zzb, "Device cannot resolve intent for: android.intent.action.VIEW");
        zzacl.zzb(this, str);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) || "android.intent.action.VIEW".equals(action)) {
            long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
            if (currentTimeMillis - zzc < 30000) {
                Log.e(zzb, "Could not start operation - already in progress");
                return;
            }
            zzc = currentTimeMillis;
            if (bundle != null) {
                this.zze = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
                return;
            }
            return;
        }
        Log.e(zzb, "Could not do operation - unknown action: " + action);
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
                String zzb2 = zzo.zza().zzb(getApplicationContext(), getPackageName(), intent.getStringExtra("eventId"));
                if (TextUtils.isEmpty(zzb2)) {
                    Log.e(zzb, "Failed to find registration for this event - failing to prevent session injection.");
                    zza(zzao.zza("Failed to find registration for this reCAPTCHA event"));
                }
                if (intent.getBooleanExtra("encryptionEnabled", true)) {
                    stringExtra = zzq.zza(getApplicationContext(), FirebaseApp.getInstance(zzb2).getPersistenceKey()).zza(stringExtra);
                }
                String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
                zzc = 0;
                this.zze = false;
                Intent intent2 = new Intent();
                intent2.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
                intent2.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
                if (!zza(intent2)) {
                    zzbl.zza(getApplicationContext(), queryParameter, "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
                } else {
                    zzd.zza((Context) this);
                }
                finish();
            }
        } else if (!this.zze) {
            Intent intent3 = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                FirebaseApp instance = FirebaseApp.getInstance(intent3.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
                if (!zzaec.zza(instance)) {
                    new zzacg(packageName, lowerCase, intent3, instance, this).executeOnExecutor(instance2.zze(), new Void[0]);
                } else {
                    zza(zza(Uri.parse(zzaec.zza(instance.getOptions().getApiKey())).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, instance2.zzc());
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.e(zzb, "Could not get package signature: " + packageName + " " + String.valueOf(e));
                zzacl.zzb(this, packageName);
            }
            this.zze = true;
        } else {
            zzb();
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.zze);
    }

    private final boolean zza(Intent intent) {
        return LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
}
