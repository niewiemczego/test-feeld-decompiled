package com.facebook.login;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/login/NonceUtil;", "", "()V", "isValidNonce", "", "nonce", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: NonceUtil.kt */
public final class NonceUtil {
    public static final NonceUtil INSTANCE = new NonceUtil();

    private NonceUtil() {
    }

    @JvmStatic
    public static final boolean isValidNonce(String str) {
        CharSequence charSequence = str;
        boolean z = false;
        if (charSequence == null || charSequence.length() == 0) {
            return false;
        }
        if (StringsKt.indexOf$default(charSequence, ' ', 0, false, 6, (Object) null) >= 0) {
            z = true;
        }
        return !z;
    }
}
