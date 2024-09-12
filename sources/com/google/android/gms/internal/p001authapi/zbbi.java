package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api.zbbi  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbbi {
    public static final Feature zba;
    public static final Feature zbb;
    public static final Feature zbc;
    public static final Feature zbd;
    public static final Feature zbe;
    public static final Feature zbf;
    public static final Feature zbg;
    public static final Feature zbh;
    public static final Feature[] zbi;

    static {
        Feature feature = new Feature("auth_api_credentials_begin_sign_in", 8);
        zba = feature;
        Feature feature2 = new Feature("auth_api_credentials_sign_out", 2);
        zbb = feature2;
        Feature feature3 = new Feature("auth_api_credentials_authorize", 1);
        zbc = feature3;
        Feature feature4 = new Feature("auth_api_credentials_revoke_access", 1);
        zbd = feature4;
        Feature feature5 = new Feature("auth_api_credentials_save_password", 4);
        zbe = feature5;
        Feature feature6 = new Feature("auth_api_credentials_get_sign_in_intent", 6);
        zbf = feature6;
        Feature feature7 = new Feature("auth_api_credentials_save_account_linking_token", 3);
        zbg = feature7;
        Feature feature8 = new Feature("auth_api_credentials_get_phone_number_hint_intent", 3);
        zbh = feature8;
        zbi = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8};
    }
}
