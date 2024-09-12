package com.facebook.login;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/login/LoginTargetApp;", "", "targetApp", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "FACEBOOK", "INSTAGRAM", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginTargetApp.kt */
public enum LoginTargetApp {
    FACEBOOK(AccessToken.DEFAULT_GRAPH_DOMAIN),
    INSTAGRAM(FacebookSdk.INSTAGRAM);
    
    public static final Companion Companion = null;
    private final String targetApp;

    @JvmStatic
    public static final LoginTargetApp fromString(String str) {
        return Companion.fromString(str);
    }

    private LoginTargetApp(String str) {
        this.targetApp = str;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    public String toString() {
        return this.targetApp;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/LoginTargetApp$Companion;", "", "()V", "fromString", "Lcom/facebook/login/LoginTargetApp;", "stringValue", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: LoginTargetApp.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LoginTargetApp fromString(String str) {
            LoginTargetApp[] values = LoginTargetApp.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                LoginTargetApp loginTargetApp = values[i];
                i++;
                if (Intrinsics.areEqual((Object) loginTargetApp.toString(), (Object) str)) {
                    return loginTargetApp;
                }
            }
            return LoginTargetApp.FACEBOOK;
        }
    }
}
