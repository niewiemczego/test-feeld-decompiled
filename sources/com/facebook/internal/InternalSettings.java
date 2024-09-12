package com.facebook.internal;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078FX\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\u0006\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/InternalSettings;", "", "()V", "UNITY_PREFIX", "", "customUserAgent", "isUnityApp", "", "isUnityApp$annotations", "()Z", "getCustomUserAgent", "setCustomUserAgent", "", "value", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InternalSettings.kt */
public final class InternalSettings {
    public static final InternalSettings INSTANCE = new InternalSettings();
    private static final String UNITY_PREFIX = "Unity.";
    private static volatile String customUserAgent;

    @JvmStatic
    public static /* synthetic */ void isUnityApp$annotations() {
    }

    private InternalSettings() {
    }

    @JvmStatic
    public static final String getCustomUserAgent() {
        return customUserAgent;
    }

    @JvmStatic
    public static final void setCustomUserAgent(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        customUserAgent = str;
    }

    public static final boolean isUnityApp() {
        String str = customUserAgent;
        Boolean bool = null;
        if (str != null) {
            bool = Boolean.valueOf(StringsKt.startsWith$default(str, UNITY_PREFIX, false, 2, (Object) null));
        }
        return Intrinsics.areEqual((Object) bool, (Object) true);
    }
}
