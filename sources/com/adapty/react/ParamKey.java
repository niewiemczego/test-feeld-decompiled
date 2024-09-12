package com.adapty.react;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/adapty/react/ParamKey;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ATTRIBUTION", "ID", "LOG_LEVEL", "NETWORK_USER_ID", "OBSERVER_MODE", "ONBOARDING_PARAMS", "PARAMS", "PAYWALL", "PAYWALLS", "PRODUCT", "SDK_KEY", "SOURCE", "TRANSACTION_ID", "USER_ID", "VARIATION_ID", "VALUE", "LOCALE", "PLACEMENT_ID", "FETCH_POLICY", "LOAD_TIMEOUT", "IS_OFFER_PERSONALIZED", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyConstants.kt */
public enum ParamKey {
    ATTRIBUTION("attribution"),
    ID("id"),
    LOG_LEVEL("log_level"),
    NETWORK_USER_ID("network_user_id"),
    OBSERVER_MODE("observer_mode"),
    ONBOARDING_PARAMS("onboarding_params"),
    PARAMS("params"),
    PAYWALL("paywall"),
    PAYWALLS("paywalls"),
    PRODUCT("product"),
    SDK_KEY("sdk_key"),
    SOURCE("source"),
    TRANSACTION_ID("transaction_id"),
    USER_ID("user_id"),
    VARIATION_ID("variation_id"),
    VALUE("value"),
    LOCALE("locale"),
    PLACEMENT_ID("placement_id"),
    FETCH_POLICY("fetch_policy"),
    LOAD_TIMEOUT("load_timeout"),
    IS_OFFER_PERSONALIZED("is_offer_personalized");
    
    private final String value;

    private ParamKey(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
