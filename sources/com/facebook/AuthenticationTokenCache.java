package com.facebook;

import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0007R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/AuthenticationTokenCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "cachedAuthenticationToken", "Lcom/facebook/AuthenticationToken;", "getCachedAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "clear", "", "hasCachedAuthenticationToken", "", "load", "save", "authenticationToken", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationTokenCache.kt */
public final class AuthenticationTokenCache {
    public static final String CACHED_AUTHENTICATION_TOKEN_KEY = "com.facebook.AuthenticationManager.CachedAuthenticationToken";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SharedPreferences sharedPreferences;

    public AuthenticationTokenCache(SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AuthenticationTokenCache() {
        /*
            r3 = this;
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.String r1 = "com.facebook.AuthenticationTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AuthenticationTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r3.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AuthenticationTokenCache.<init>():void");
    }

    public final AuthenticationToken load() {
        if (hasCachedAuthenticationToken()) {
            return getCachedAuthenticationToken();
        }
        return null;
    }

    public final void save(AuthenticationToken authenticationToken) {
        Intrinsics.checkNotNullParameter(authenticationToken, "authenticationToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_AUTHENTICATION_TOKEN_KEY, authenticationToken.toJSONObject$facebook_core_release().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_AUTHENTICATION_TOKEN_KEY).apply();
    }

    private final boolean hasCachedAuthenticationToken() {
        return this.sharedPreferences.contains(CACHED_AUTHENTICATION_TOKEN_KEY);
    }

    private final AuthenticationToken getCachedAuthenticationToken() {
        String string = this.sharedPreferences.getString(CACHED_AUTHENTICATION_TOKEN_KEY, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return new AuthenticationToken(new JSONObject(string));
        } catch (JSONException unused) {
            AuthenticationToken authenticationToken = null;
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/AuthenticationTokenCache$Companion;", "", "()V", "CACHED_AUTHENTICATION_TOKEN_KEY", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AuthenticationTokenCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
