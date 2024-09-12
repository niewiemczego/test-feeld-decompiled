package com.braze.support;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001\u001a\"\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u00012\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0016\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0017\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001\u001a\f\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0001\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0001\u001a \u0010\u001f\u001a\u00020 *\u0004\u0018\u00010\u00012\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020 0\"\u001a\u0012\u0010#\u001a\u00020\u0001*\u00020\u00012\u0006\u0010$\u001a\u00020\u0019\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0007\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00018\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"CACHE_SUFFIX_PREFERENCES_FILE", "", "getCACHE_SUFFIX_PREFERENCES_FILE$annotations", "()V", "MD5_HASH_OF_THE_STRING_NULL", "getMD5_HASH_OF_THE_STRING_NULL$annotations", "NULL_USER_ID_SUBSTITUTE_STRING", "SUFFIX_CACHE_USER_ID_HASH_VALUE", "getSUFFIX_CACHE_USER_ID_HASH_VALUE$annotations", "SUFFIX_CACHE_USER_ID_KEY", "getSUFFIX_CACHE_USER_ID_KEY$annotations", "TAG", "getCacheFileSuffix", "context", "Landroid/content/Context;", "userId", "apiKey", "getSuffixFromUserIdHashAndApiKey", "userIdHash", "isBlank", "", "reference", "isNullOrBlank", "isNullOrEmpty", "countOccurrences", "", "subString", "emptyToNull", "getByteSize", "", "getMd5Hash", "ifNonEmpty", "", "block", "Lkotlin/Function1;", "truncateToByteLength", "desiredByteLength", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class StringUtils {
    public static final String CACHE_SUFFIX_PREFERENCES_FILE = "com.appboy.support.stringutils.cachefilesuffix";
    public static final String MD5_HASH_OF_THE_STRING_NULL = "37a6259cc0c1dae299a7866489dff0bd";
    private static final String NULL_USER_ID_SUBSTITUTE_STRING = "null";
    public static final String SUFFIX_CACHE_USER_ID_HASH_VALUE = "user_id_hash_value";
    public static final String SUFFIX_CACHE_USER_ID_KEY = "user_id_key";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("StringUtils");

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "The saved user id hash was null or empty.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Generating MD5 for user id: " + this.b + " apiKey: " + this.c;
        }
    }

    public static final int countOccurrences(String str, String str2) {
        List list;
        boolean z;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "subString");
        List split$default = StringsKt.split$default((CharSequence) str, new String[]{str2}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            ListIterator listIterator = split$default.listIterator(split$default.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                if (((String) listIterator.previous()).length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    list = CollectionsKt.take(split$default, listIterator.nextIndex() + 1);
                    break;
                }
            }
            return list.toArray(new String[0]).length - 1;
        }
        list = CollectionsKt.emptyList();
        return list.toArray(new String[0]).length - 1;
    }

    public static final String emptyToNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt.isBlank(str)) {
            return null;
        }
        return str;
    }

    public static final long getByteSize(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return (long) bytes.length;
    }

    public static /* synthetic */ void getCACHE_SUFFIX_PREFERENCES_FILE$annotations() {
    }

    public static /* synthetic */ void getMD5_HASH_OF_THE_STRING_NULL$annotations() {
    }

    public static final String getMd5Hash(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        BigInteger bigInteger = new BigInteger(1, instance.digest(bytes));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%032x", Arrays.copyOf(new Object[]{bigInteger}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }

    public static /* synthetic */ void getSUFFIX_CACHE_USER_ID_HASH_VALUE$annotations() {
    }

    public static /* synthetic */ void getSUFFIX_CACHE_USER_ID_KEY$annotations() {
    }

    private static final String getSuffixFromUserIdHashAndApiKey(String str, String str2) {
        if (str2 == null || StringsKt.isBlank(str2)) {
            return '.' + str;
        }
        return '.' + str + '.' + str2;
    }

    public static final void ifNonEmpty(String str, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (!(str == null || str.length() == 0)) {
            function1.invoke(str);
        }
    }

    public static final boolean isBlank(String str) {
        if (str != null) {
            return StringsKt.isBlank(str);
        }
        return false;
    }

    public static final boolean isNullOrBlank(String str) {
        return str == null || StringsKt.isBlank(str);
    }

    public static final boolean isNullOrEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static final String truncateToByteLength(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (getByteSize(str) <= ((long) i)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
        int i2 = 0;
        for (char c : charArray) {
            i2 += (int) getByteSize(String.valueOf(c));
            if (i2 > i) {
                break;
            }
            sb.append(c);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "truncatedStringBuilder.toString()");
        return sb2;
    }

    public static final String getCacheFileSuffix(Context context, String str, String str2) {
        Context context2 = context;
        String str3 = str2;
        Intrinsics.checkNotNullParameter(context2, "context");
        String str4 = str == null ? NULL_USER_ID_SUBSTITUTE_STRING : str;
        if (Intrinsics.areEqual((Object) str4, (Object) NULL_USER_ID_SUBSTITUTE_STRING)) {
            return getSuffixFromUserIdHashAndApiKey(MD5_HASH_OF_THE_STRING_NULL, str3);
        }
        boolean z = false;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(CACHE_SUFFIX_PREFERENCES_FILE, 0);
        String string = sharedPreferences.getString(SUFFIX_CACHE_USER_ID_KEY, (String) null);
        if (string != null && Intrinsics.areEqual((Object) string, (Object) str4)) {
            String string2 = sharedPreferences.getString(SUFFIX_CACHE_USER_ID_HASH_VALUE, (String) null);
            if (string2 == null || string2.length() == 0) {
                z = true;
            }
            if (!z) {
                return getSuffixFromUserIdHashAndApiKey(string2, str3);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 6, (Object) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(str4, str3), 4, (Object) null);
        String md5Hash = getMd5Hash(str4);
        sharedPreferences.edit().putString(SUFFIX_CACHE_USER_ID_KEY, str4).putString(SUFFIX_CACHE_USER_ID_HASH_VALUE, md5Hash).apply();
        return getSuffixFromUserIdHashAndApiKey(md5Hash, str3);
    }

    public static final String getCacheFileSuffix(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getCacheFileSuffix(context, str, (String) null);
    }
}
