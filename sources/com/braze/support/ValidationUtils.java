package com.braze.support;

import bo.app.l5;
import com.braze.support.BrazeLogger;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.language.bm.Rule;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b*\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0007J6\u0010\u0012\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u001a\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0007J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0007R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000e8\u0006XT¢\u0006\f\n\u0004\b$\u0010%\u0012\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020!8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010#R\u0014\u0010)\u001a\u00020\u000e8\u0006XT¢\u0006\u0006\n\u0004\b)\u0010%¨\u0006+"}, d2 = {"Lcom/braze/support/ValidationUtils;", "", "", "emailAddress", "", "isValidEmailAddress", "phoneNumber", "isValidPhoneNumber", "field", "ensureBrazeFieldLength", "productId", "currencyCode", "Ljava/math/BigDecimal;", "price", "", "quantity", "Lbo/app/l5;", "serverConfigStorageProvider", "isValidLogPurchaseInput", "eventName", "isValidLogCustomEventInput", "campaignId", "pageId", "isValidPushStoryClickInput", "", "latitude", "longitude", "isValidLocation", "", "VALID_CURRENCY_CODES", "Ljava/util/Set;", "getVALID_CURRENCY_CODES", "()Ljava/util/Set;", "Lkotlin/text/Regex;", "EMAIL_ADDRESS_REGEX", "Lkotlin/text/Regex;", "EMAIL_ADDRESS_MAX_LENGTH", "I", "getEMAIL_ADDRESS_MAX_LENGTH$annotations", "()V", "PHONE_NUMBER_REGEX", "BRAZE_STRING_MAX_LENGTH", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class ValidationUtils {
    public static final int BRAZE_STRING_MAX_LENGTH = 255;
    public static final int EMAIL_ADDRESS_MAX_LENGTH = 255;
    private static final Regex EMAIL_ADDRESS_REGEX = new Regex(".+@.+\\..+");
    public static final ValidationUtils INSTANCE = new ValidationUtils();
    private static final Regex PHONE_NUMBER_REGEX = new Regex("^[0-9 .\\(\\)\\+\\-]+$");
    private static final Set<String> VALID_CURRENCY_CODES = SetsKt.setOf("AED", "AFN", Rule.ALL, "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL");

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Provided string field is too long [" + ((String) this.b.element).length() + "]. The max length is 255, truncating provided field.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The custom event name cannot be null or contain only whitespaces. Invalid custom event.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The custom event is a blocklisted custom event: " + this.b + ". Invalid custom event.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The productId is empty, not logging in-app purchase to Braze.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The productId is a blocklisted productId: " + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The currencyCode is empty. Expected one of " + ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES();
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The currencyCode " + this.b + " is invalid. Expected one of " + ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES();
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The price is null.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The requested purchase quantity of " + this.b + " is less than one. Invalid purchase";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The requested purchase quantity of " + this.b + " is greater than the maximum of 100";
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Campaign ID cannot be null or blank";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push story page ID cannot be null or blank";
        }
    }

    private ValidationUtils() {
    }

    @JvmStatic
    public static final String ensureBrazeFieldLength(String str) {
        if (str == null || StringsKt.isBlank(str)) {
            return "";
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T obj = StringsKt.trim((CharSequence) str).toString();
        objectRef.element = obj;
        if (obj.length() > 255) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(objectRef), 2, (Object) null);
            T substring = ((String) objectRef.element).substring(0, 255);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            objectRef.element = substring;
        }
        return (String) objectRef.element;
    }

    public static /* synthetic */ void getEMAIL_ADDRESS_MAX_LENGTH$annotations() {
    }

    @JvmStatic
    public static final boolean isValidEmailAddress(String str) {
        if (!(str == null || str.length() == 0) && str.length() <= 255) {
            return EMAIL_ADDRESS_REGEX.matches(str);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidLocation(double d2, double d3) {
        return d2 < 90.0d && d2 > -90.0d && d3 < 180.0d && d3 > -180.0d;
    }

    @JvmStatic
    public static final boolean isValidLogCustomEventInput(String str, l5 l5Var) {
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        if (str == null || StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
        } else if (!l5Var.e().contains(str)) {
            return true;
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new c(str), 2, (Object) null);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidLogPurchaseInput(String str, String str2, BigDecimal bigDecimal, int i2, l5 l5Var) {
        String str3 = str;
        String str4 = str2;
        int i3 = i2;
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        if (str3 == null || StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
        } else if (l5Var.f().contains(str3)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new e(str3), 2, (Object) null);
        } else {
            if (str4 == null || StringsKt.isBlank(str2)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) f.b, 2, (Object) null);
            } else {
                Set<String> set = VALID_CURRENCY_CODES;
                String obj = StringsKt.trim((CharSequence) str2).toString();
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String upperCase = obj.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                if (!set.contains(upperCase)) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(str4), 2, (Object) null);
                } else if (bigDecimal == null) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) h.b, 2, (Object) null);
                } else if (i3 <= 0) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new i(i3), 2, (Object) null);
                } else if (i3 <= 100) {
                    return true;
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) new j(i3), 2, (Object) null);
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean isValidPhoneNumber(String str) {
        return str != null && PHONE_NUMBER_REGEX.matches(str);
    }

    @JvmStatic
    public static final boolean isValidPushStoryClickInput(String str, String str2) {
        if (str == null || StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) k.b, 2, (Object) null);
        } else {
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) INSTANCE, BrazeLogger.Priority.W, (Throwable) null, (Function0) l.b, 2, (Object) null);
        }
        return false;
    }

    public final Set<String> getVALID_CURRENCY_CODES() {
        return VALID_CURRENCY_CODES;
    }
}
