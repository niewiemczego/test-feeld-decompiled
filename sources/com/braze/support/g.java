package com.braze.support;

import com.braze.support.BrazeLogger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

public abstract class g {
    private static final String a = BrazeLogger.INSTANCE.getBrazeLogTag("HttpUtils");
    private static final SimpleDateFormat b = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not parse http-date value: " + this.b;
        }
    }

    public static final Long a(String str) {
        Long valueOf;
        if (str == null) {
            return null;
        }
        try {
            Double doubleOrNull = StringsKt.toDoubleOrNull(str);
            if (doubleOrNull != null) {
                valueOf = Long.valueOf((long) (doubleOrNull.doubleValue() * ((double) 1000)));
            } else {
                Date parse = b.parse(str);
                if (parse == null) {
                    return null;
                }
                valueOf = Long.valueOf(parse.getTime() - DateTimeUtils.nowInMilliseconds());
            }
            return valueOf;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog(a, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new a(str));
            return null;
        }
    }

    public static final String a(Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, "requestArgs");
        long j = 1;
        for (Object hashCode : objArr) {
            j *= (long) hashCode.hashCode();
        }
        String hexString = Long.toHexString(j);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(\n    request…lement.hashCode()\n    }\n)");
        return hexString;
    }

    public static final Map a(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            if (((String) entry.getKey()) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Object key = entry2.getKey();
            Intrinsics.checkNotNull(key);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String lowerCase = ((String) key).toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            linkedHashMap2.put(lowerCase, entry2.getValue());
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(entry3.getKey(), CollectionsKt.joinToString$default((Iterable) entry3.getValue(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
        }
        return linkedHashMap3;
    }
}
