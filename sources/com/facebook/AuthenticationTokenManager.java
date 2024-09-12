package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.Utility;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u001c\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/AuthenticationTokenManager;", "", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "authenticationTokenCache", "Lcom/facebook/AuthenticationTokenCache;", "(Landroidx/localbroadcastmanager/content/LocalBroadcastManager;Lcom/facebook/AuthenticationTokenCache;)V", "value", "Lcom/facebook/AuthenticationToken;", "currentAuthenticationToken", "getCurrentAuthenticationToken", "()Lcom/facebook/AuthenticationToken;", "setCurrentAuthenticationToken", "(Lcom/facebook/AuthenticationToken;)V", "currentAuthenticationTokenField", "currentAuthenticationTokenChanged", "", "loadCurrentAuthenticationToken", "", "sendCurrentAuthenticationTokenChangedBroadcastIntent", "oldAuthenticationToken", "saveToCache", "Companion", "CurrentAuthenticationTokenChangedBroadcastReceiver", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AuthenticationTokenManager.kt */
public final class AuthenticationTokenManager {
    public static final String ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_NEW_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_NEW_AUTHENTICATION_TOKEN";
    public static final String EXTRA_OLD_AUTHENTICATION_TOKEN = "com.facebook.sdk.EXTRA_OLD_AUTHENTICATION_TOKEN";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AuthenticationTokenManager.SharedPreferences";
    public static final String TAG = "AuthenticationTokenManager";
    /* access modifiers changed from: private */
    public static AuthenticationTokenManager instanceField;
    private final AuthenticationTokenCache authenticationTokenCache;
    private AuthenticationToken currentAuthenticationTokenField;
    private final LocalBroadcastManager localBroadcastManager;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$CurrentAuthenticationTokenChangedBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AuthenticationTokenManager.kt */
    public static final class CurrentAuthenticationTokenChangedBroadcastReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        }
    }

    @JvmStatic
    public static final AuthenticationTokenManager getInstance() {
        return Companion.getInstance();
    }

    public AuthenticationTokenManager(LocalBroadcastManager localBroadcastManager2, AuthenticationTokenCache authenticationTokenCache2) {
        Intrinsics.checkNotNullParameter(localBroadcastManager2, "localBroadcastManager");
        Intrinsics.checkNotNullParameter(authenticationTokenCache2, "authenticationTokenCache");
        this.localBroadcastManager = localBroadcastManager2;
        this.authenticationTokenCache = authenticationTokenCache2;
    }

    public final AuthenticationToken getCurrentAuthenticationToken() {
        return this.currentAuthenticationTokenField;
    }

    public final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken) {
        setCurrentAuthenticationToken(authenticationToken, true);
    }

    public final boolean loadCurrentAuthenticationToken() {
        AuthenticationToken load = this.authenticationTokenCache.load();
        if (load == null) {
            return false;
        }
        setCurrentAuthenticationToken(load, false);
        return true;
    }

    public final void currentAuthenticationTokenChanged() {
        sendCurrentAuthenticationTokenChangedBroadcastIntent(getCurrentAuthenticationToken(), getCurrentAuthenticationToken());
    }

    private final void setCurrentAuthenticationToken(AuthenticationToken authenticationToken, boolean z) {
        AuthenticationToken currentAuthenticationToken = getCurrentAuthenticationToken();
        this.currentAuthenticationTokenField = authenticationToken;
        if (z) {
            if (authenticationToken != null) {
                this.authenticationTokenCache.save(authenticationToken);
            } else {
                this.authenticationTokenCache.clear();
                Utility utility = Utility.INSTANCE;
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        Utility utility2 = Utility.INSTANCE;
        if (!Utility.areObjectsEqual(currentAuthenticationToken, authenticationToken)) {
            sendCurrentAuthenticationTokenChangedBroadcastIntent(currentAuthenticationToken, authenticationToken);
        }
    }

    private final void sendCurrentAuthenticationTokenChangedBroadcastIntent(AuthenticationToken authenticationToken, AuthenticationToken authenticationToken2) {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAuthenticationTokenChangedBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_AUTHENTICATION_TOKEN, authenticationToken);
        intent.putExtra(EXTRA_NEW_AUTHENTICATION_TOKEN, authenticationToken2);
        this.localBroadcastManager.sendBroadcast(intent);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/AuthenticationTokenManager$Companion;", "", "()V", "ACTION_CURRENT_AUTHENTICATION_TOKEN_CHANGED", "", "EXTRA_NEW_AUTHENTICATION_TOKEN", "EXTRA_OLD_AUTHENTICATION_TOKEN", "SHARED_PREFERENCES_NAME", "TAG", "instanceField", "Lcom/facebook/AuthenticationTokenManager;", "getInstance", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AuthenticationTokenManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AuthenticationTokenManager getInstance() {
            AuthenticationTokenManager access$getInstanceField$cp;
            AuthenticationTokenManager access$getInstanceField$cp2 = AuthenticationTokenManager.instanceField;
            if (access$getInstanceField$cp2 != null) {
                return access$getInstanceField$cp2;
            }
            synchronized (this) {
                access$getInstanceField$cp = AuthenticationTokenManager.instanceField;
                if (access$getInstanceField$cp == null) {
                    FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                    LocalBroadcastManager instance = LocalBroadcastManager.getInstance(FacebookSdk.getApplicationContext());
                    Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
                    AuthenticationTokenManager authenticationTokenManager = new AuthenticationTokenManager(instance, new AuthenticationTokenCache());
                    Companion companion = AuthenticationTokenManager.Companion;
                    AuthenticationTokenManager.instanceField = authenticationTokenManager;
                    access$getInstanceField$cp = authenticationTokenManager;
                }
            }
            return access$getInstanceField$cp;
        }
    }
}
