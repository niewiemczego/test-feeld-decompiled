package com.google.firebase.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzact;
import com.google.android.gms.internal.p002firebaseauthapi.zzaec;
import com.google.firebase.auth.internal.GenericIdpActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public class OAuthProvider extends FederatedAuthProvider {
    private final Bundle zza;

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class CredentialBuilder {
        private final String zza;
        private String zzb;
        private String zzc;
        private String zzd;

        public AuthCredential build() {
            return zzd.zza(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public CredentialBuilder setAccessToken(String str) {
            this.zzc = str;
            return this;
        }

        public CredentialBuilder setIdToken(String str) {
            this.zzb = str;
            return this;
        }

        public CredentialBuilder setIdTokenWithRawNonce(String str, String str2) {
            this.zzb = str;
            this.zzd = str2;
            return this;
        }

        public String getAccessToken() {
            return this.zzc;
        }

        public String getIdToken() {
            return this.zzb;
        }

        private CredentialBuilder(String str) {
            this.zza = str;
        }
    }

    @Deprecated
    public static AuthCredential getCredential(String str, String str2, String str3) {
        return zzd.zza(str, str2, str3);
    }

    /* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
    public static class Builder {
        private final FirebaseAuth zza;
        private final Bundle zzb;
        private final Bundle zzc;

        public Builder addCustomParameter(String str, String str2) {
            this.zzc.putString(str, str2);
            return this;
        }

        public Builder addCustomParameters(Map<String, String> map) {
            for (Map.Entry next : map.entrySet()) {
                this.zzc.putString((String) next.getKey(), (String) next.getValue());
            }
            return this;
        }

        public Builder setScopes(List<String> list) {
            this.zzb.putStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES", new ArrayList(list));
            return this;
        }

        public OAuthProvider build() {
            return new OAuthProvider(this.zzb);
        }

        public List<String> getScopes() {
            ArrayList<String> stringArrayList = this.zzb.getStringArrayList("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
            if (stringArrayList != null) {
                return stringArrayList;
            }
            return Collections.emptyList();
        }

        private Builder(String str, FirebaseAuth firebaseAuth) {
            Bundle bundle = new Bundle();
            this.zzb = bundle;
            Bundle bundle2 = new Bundle();
            this.zzc = bundle2;
            this.zza = firebaseAuth;
            bundle.putString("com.google.firebase.auth.KEY_API_KEY", firebaseAuth.getApp().getOptions().getApiKey());
            bundle.putString("com.google.firebase.auth.KEY_PROVIDER_ID", str);
            bundle.putBundle("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS", bundle2);
            bundle.putString("com.google.firebase.auth.internal.CLIENT_VERSION", zzact.zza().zzb());
            bundle.putString("com.google.firebase.auth.KEY_TENANT_ID", firebaseAuth.getTenantId());
            bundle.putString("com.google.firebase.auth.KEY_FIREBASE_APP_NAME", firebaseAuth.getApp().getName());
            bundle.putString("com.google.firebase.auth.KEY_CUSTOM_AUTH_DOMAIN", firebaseAuth.getCustomAuthDomain());
        }
    }

    public static Builder newBuilder(String str) {
        return newBuilder(str, FirebaseAuth.getInstance());
    }

    public static Builder newBuilder(String str, FirebaseAuth firebaseAuth) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseAuth);
        if (!"facebook.com".equals(str) || zzaec.zza(firebaseAuth.getApp())) {
            return new Builder(str, firebaseAuth);
        }
        throw new IllegalArgumentException("Sign in with Facebook is not supported via this method; the Facebook TOS dictate that you must use the Facebook Android SDK for Facebook login.");
    }

    public static CredentialBuilder newCredentialBuilder(String str) {
        return new CredentialBuilder(Preconditions.checkNotEmpty(str));
    }

    public String getProviderId() {
        Bundle bundle = this.zza;
        if (bundle == null) {
            return null;
        }
        return bundle.getString("com.google.firebase.auth.KEY_PROVIDER_ID");
    }

    private OAuthProvider(Bundle bundle) {
        this.zza = bundle;
    }

    public final void zza(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_LINK");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public final void zzb(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }

    public final void zzc(Activity activity) {
        Intent intent = new Intent("com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN");
        intent.setClass(activity, GenericIdpActivity.class);
        intent.setPackage(activity.getPackageName());
        intent.putExtras(this.zza);
        activity.startActivity(intent);
    }
}
