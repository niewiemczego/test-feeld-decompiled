package com.adapty.react;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0001\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/adapty/react/MethodName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ACTIVATE", "UPDATE_ATTRIBUTION", "GET_PAYWALL", "GET_PAYWALL_PRODUCTS", "LOG_SHOW_ONBOARDING", "LOG_SHOW_PAYWALL", "SET_FALLBACK_PAYWALLS", "SET_VARIATION_ID", "GET_PROFILE", "IDENTIFY", "LOGOUT", "UPDATE_PROFILE", "MAKE_PURCHASE", "RESTORE_PURCHASES", "SET_LOG_LEVEL", "NOT_IMPLEMENTED", "Companion", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyConstants.kt */
public enum MethodName {
    ACTIVATE("activate"),
    UPDATE_ATTRIBUTION("update_attribution"),
    GET_PAYWALL("get_paywall"),
    GET_PAYWALL_PRODUCTS("get_paywall_products"),
    LOG_SHOW_ONBOARDING("log_show_onboarding"),
    LOG_SHOW_PAYWALL("log_show_paywall"),
    SET_FALLBACK_PAYWALLS("set_fallback_paywalls"),
    SET_VARIATION_ID("set_variation_id"),
    GET_PROFILE("get_profile"),
    IDENTIFY("identify"),
    LOGOUT("logout"),
    UPDATE_PROFILE("update_profile"),
    MAKE_PURCHASE("make_purchase"),
    RESTORE_PURCHASES("restore_purchases"),
    SET_LOG_LEVEL("set_log_level"),
    NOT_IMPLEMENTED("not_implemented");
    
    public static final Companion Companion = null;
    private final String value;

    private MethodName(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/react/MethodName$Companion;", "", "()V", "fromString", "Lcom/adapty/react/MethodName;", "value", "", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AdaptyConstants.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MethodName fromString(String str) {
            MethodName methodName;
            Intrinsics.checkNotNullParameter(str, "value");
            MethodName[] values = MethodName.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    methodName = null;
                    break;
                }
                methodName = values[i];
                if (Intrinsics.areEqual((Object) methodName.getValue(), (Object) str)) {
                    break;
                }
                i++;
            }
            return methodName == null ? MethodName.NOT_IMPLEMENTED : methodName;
        }
    }
}
