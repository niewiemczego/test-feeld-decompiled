package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u0004\u0018\u00010\tJ\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\tJ\b\u0010\u001a\u001a\u00020\u0016H\u0002R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8CX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/AccessTokenCache;", "", "()V", "sharedPreferences", "Landroid/content/SharedPreferences;", "tokenCachingStrategyFactory", "Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "(Landroid/content/SharedPreferences;Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;)V", "cachedAccessToken", "Lcom/facebook/AccessToken;", "getCachedAccessToken", "()Lcom/facebook/AccessToken;", "legacyAccessToken", "getLegacyAccessToken", "tokenCachingStrategy", "Lcom/facebook/LegacyTokenHelper;", "getTokenCachingStrategy", "()Lcom/facebook/LegacyTokenHelper;", "tokenCachingStrategyField", "clear", "", "hasCachedAccessToken", "", "load", "save", "accessToken", "shouldCheckLegacyToken", "Companion", "SharedPreferencesTokenCachingStrategyFactory", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessTokenCache.kt */
public final class AccessTokenCache {
    public static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SharedPreferences sharedPreferences;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;
    private LegacyTokenHelper tokenCachingStrategyField;

    public AccessTokenCache(SharedPreferences sharedPreferences2, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        Intrinsics.checkNotNullParameter(sharedPreferencesTokenCachingStrategyFactory, "tokenCachingStrategyFactory");
        this.sharedPreferences = sharedPreferences2;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
        com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0037, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.facebook.LegacyTokenHelper getTokenCachingStrategy() {
        /*
            r3 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r3)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0020
            monitor-enter(r3)     // Catch:{ all -> 0x0033 }
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x0019
            com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory r0 = r3.tokenCachingStrategyFactory     // Catch:{ all -> 0x001d }
            com.facebook.LegacyTokenHelper r0 = r0.create()     // Catch:{ all -> 0x001d }
            r3.tokenCachingStrategyField = r0     // Catch:{ all -> 0x001d }
        L_0x0019:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001d }
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            goto L_0x0020
        L_0x001d:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0033 }
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x0020:
            com.facebook.LegacyTokenHelper r0 = r3.tokenCachingStrategyField     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0025
            return r0
        L_0x0025:
            java.lang.String r0 = "Required value was null."
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0033 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0033 }
            r2.<init>(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ all -> 0x0033 }
            throw r2     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenCache.getTokenCachingStrategy():com.facebook.LegacyTokenHelper");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AccessTokenCache() {
        /*
            r3 = this;
            com.facebook.FacebookSdk r0 = com.facebook.FacebookSdk.INSTANCE
            android.content.Context r0 = com.facebook.FacebookSdk.getApplicationContext()
            java.lang.String r1 = "com.facebook.AccessTokenManager.SharedPreferences"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "FacebookSdk.getApplicationContext()\n              .getSharedPreferences(\n                  AccessTokenManager.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory r1 = new com.facebook.AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory
            r1.<init>()
            r3.<init>(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.AccessTokenCache.<init>():void");
    }

    public final AccessToken load() {
        if (hasCachedAccessToken()) {
            return getCachedAccessToken();
        }
        if (!shouldCheckLegacyToken()) {
            return null;
        }
        AccessToken legacyAccessToken = getLegacyAccessToken();
        if (legacyAccessToken == null) {
            return legacyAccessToken;
        }
        save(legacyAccessToken);
        getTokenCachingStrategy().clear();
        return legacyAccessToken;
    }

    public final void save(AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, SDKConstants.PARAM_ACCESS_TOKEN);
        try {
            this.sharedPreferences.edit().putString(CACHED_ACCESS_TOKEN_KEY, accessToken.toJSONObject$facebook_core_release().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    public final void clear() {
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
    }

    private final boolean hasCachedAccessToken() {
        return this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
    }

    private final AccessToken getCachedAccessToken() {
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, (String) null);
        if (string == null) {
            return null;
        }
        try {
            return AccessToken.Companion.createFromJSONObject$facebook_core_release(new JSONObject(string));
        } catch (JSONException unused) {
            AccessToken accessToken = null;
            return null;
        }
    }

    private final boolean shouldCheckLegacyToken() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.isLegacyTokenUpgradeSupported();
    }

    private final AccessToken getLegacyAccessToken() {
        Bundle load = getTokenCachingStrategy().load();
        if (load == null || !LegacyTokenHelper.Companion.hasTokenInformation(load)) {
            return null;
        }
        return AccessToken.Companion.createFromLegacyCache$facebook_core_release(load);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$SharedPreferencesTokenCachingStrategyFactory;", "", "()V", "create", "Lcom/facebook/LegacyTokenHelper;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenCache.kt */
    public static final class SharedPreferencesTokenCachingStrategyFactory {
        public final LegacyTokenHelper create() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return new LegacyTokenHelper(FacebookSdk.getApplicationContext(), (String) null, 2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/AccessTokenCache$Companion;", "", "()V", "CACHED_ACCESS_TOKEN_KEY", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
