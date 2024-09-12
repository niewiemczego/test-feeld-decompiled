package com.adapty.internal.crossplatform;

import android.util.Base64;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"CLASS_KEY", "", "getClassForNameOrNull", "Ljava/lang/Class;", "className", "fromBase64", "toBase64", "crossplatform_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    public static final String CLASS_KEY = "class";

    public static final String fromBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(this, Base64.DEFAULT)");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        return new String(decode, forName);
    }

    public static final String toBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(this.toBy…UTF-8\")), Base64.DEFAULT)");
        return encodeToString;
    }

    public static final Class<?> getClassForNameOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
