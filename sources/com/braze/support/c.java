package com.braze.support;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class c {
    public static final c a = new c();

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to create valid enum from string: " + this.b;
        }
    }

    private c() {
    }

    public static final Enum a(String str, Class cls) {
        Intrinsics.checkNotNullParameter(str, "enumValue");
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        return Enum.valueOf(cls, str);
    }

    public static final EnumSet a(Class cls, Set set) {
        Intrinsics.checkNotNullParameter(cls, "targetEnumClass");
        Intrinsics.checkNotNullParameter(set, "sourceStringSet");
        EnumSet noneOf = EnumSet.noneOf(cls);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String upperCase = str.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                noneOf.add(a(upperCase, cls));
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new a(str));
            }
        }
        Intrinsics.checkNotNullExpressionValue(noneOf, "result");
        return noneOf;
    }

    public static final Set a(EnumSet enumSet) {
        Intrinsics.checkNotNullParameter(enumSet, "sourceEnumSet");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(enumSet, 10));
        Iterator it = enumSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((Enum) it.next()).name());
        }
        return CollectionsKt.toSet(arrayList);
    }
}
