package com.facebook.internal;

import com.android.installreferrer.api.InstallReferrerClient;
import com.facebook.FacebookSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil;", "", "()V", "IS_REFERRER_UPDATED", "", "isUpdated", "", "()Z", "tryConnectReferrerInfo", "", "callback", "Lcom/facebook/internal/InstallReferrerUtil$Callback;", "tryUpdateReferrerInfo", "updateReferrer", "Callback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstallReferrerUtil.kt */
public final class InstallReferrerUtil {
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/InstallReferrerUtil$Callback;", "", "onReceiveReferrerUrl", "", "s", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstallReferrerUtil.kt */
    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    @JvmStatic
    public static final void tryUpdateReferrerInfo(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (!installReferrerUtil.isUpdated()) {
            installReferrerUtil.tryConnectReferrerInfo(callback);
        }
    }

    private final void tryConnectReferrerInfo(Callback callback) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        InstallReferrerClient build = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        try {
            build.startConnection(new InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1(build, callback));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }

    private final boolean isUpdated() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }
}
