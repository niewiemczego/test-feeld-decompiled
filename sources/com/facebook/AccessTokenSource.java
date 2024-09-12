package com.facebook;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/facebook/AccessTokenSource;", "", "canExtendToken", "", "(Ljava/lang/String;IZ)V", "fromInstagram", "NONE", "FACEBOOK_APPLICATION_WEB", "FACEBOOK_APPLICATION_NATIVE", "FACEBOOK_APPLICATION_SERVICE", "WEB_VIEW", "CHROME_CUSTOM_TAB", "TEST_USER", "CLIENT_TOKEN", "DEVICE_AUTH", "INSTAGRAM_APPLICATION_WEB", "INSTAGRAM_CUSTOM_CHROME_TAB", "INSTAGRAM_WEB_VIEW", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AccessTokenSource.kt */
public enum AccessTokenSource {
    NONE(false),
    FACEBOOK_APPLICATION_WEB(true),
    FACEBOOK_APPLICATION_NATIVE(true),
    FACEBOOK_APPLICATION_SERVICE(true),
    WEB_VIEW(true),
    CHROME_CUSTOM_TAB(true),
    TEST_USER(true),
    CLIENT_TOKEN(true),
    DEVICE_AUTH(true),
    INSTAGRAM_APPLICATION_WEB(true),
    INSTAGRAM_CUSTOM_CHROME_TAB(true),
    INSTAGRAM_WEB_VIEW(true);
    
    private final boolean canExtendToken;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AccessTokenSource.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[AccessTokenSource.values().length];
            iArr[AccessTokenSource.INSTAGRAM_APPLICATION_WEB.ordinal()] = 1;
            iArr[AccessTokenSource.INSTAGRAM_CUSTOM_CHROME_TAB.ordinal()] = 2;
            iArr[AccessTokenSource.INSTAGRAM_WEB_VIEW.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AccessTokenSource(boolean z) {
        this.canExtendToken = z;
    }

    public final boolean canExtendToken() {
        return this.canExtendToken;
    }

    public final boolean fromInstagram() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        return i == 1 || i == 2 || i == 3;
    }
}
