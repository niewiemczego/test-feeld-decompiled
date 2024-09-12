package kotlin.reflect.jvm.internal.impl.util.capitalizeDecapitalize;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: capitalizeDecapitalize.kt */
public final class CapitalizeDecapitalizeKt {
    public static final String decapitalizeSmartForCompiler(String str, boolean z) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharSequence charSequence = str;
        if ((charSequence.length() == 0) || !isUpperCaseCharAt(str, 0, z)) {
            return str;
        }
        if (str.length() != 1 && isUpperCaseCharAt(str, 1, z)) {
            Iterator it = StringsKt.getIndices(charSequence).iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (!isUpperCaseCharAt(str, ((Number) obj).intValue(), z)) {
                    break;
                }
            }
            Integer num = (Integer) obj;
            if (num == null) {
                return toLowerCase(str, z);
            }
            int intValue = num.intValue() - 1;
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, intValue);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            StringBuilder append = sb.append(toLowerCase(substring, z));
            String substring2 = str.substring(intValue);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
            return append.append(substring2).toString();
        } else if (z) {
            return decapitalizeAsciiOnly(str);
        } else {
            if (!(charSequence.length() > 0)) {
                return str;
            }
            char lowerCase = Character.toLowerCase(str.charAt(0));
            String substring3 = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            return lowerCase + substring3;
        }
    }

    private static final boolean isUpperCaseCharAt(String str, int i, boolean z) {
        char charAt = str.charAt(i);
        if (z) {
            return 'A' <= charAt && charAt < '[';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String toLowerCase(String str, boolean z) {
        if (z) {
            return toLowerCaseAsciiOnly(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return upperCase + substring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        boolean z = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt < '[') {
            z = true;
        }
        if (!z) {
            return str;
        }
        char lowerCase = Character.toLowerCase(charAt);
        String substring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return lowerCase + substring;
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        return sb2;
    }
}
