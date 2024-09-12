package kotlin.reflect.jvm.internal.impl.name;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FqNamesUtil.kt */
public final class FqNamesUtilKt {

    /* compiled from: FqNamesUtil.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean isSubpackageOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "packageName");
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "this.asString()");
        String asString2 = fqName2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isChildOf(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "packageName");
        return Intrinsics.areEqual((Object) parentOrNull(fqName), (Object) fqName2);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        return StringsKt.startsWith$default(str, str2, false, 2, (Object) null) && str.charAt(str2.length()) == '.';
    }

    public static final FqName tail(FqName fqName, FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkNotNullExpressionValue(fqName3, "ROOT");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString()");
        String substring = asString.substring(fqName2.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return new FqName(substring);
    }

    public static final FqName parentOrNull(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    public static final boolean isValidJavaFqName(String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int i2 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i2 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        if (state != State.AFTER_DOT) {
            return true;
        }
        return false;
    }

    public static final <V> V findValueForMostSpecificFqname(FqName fqName, Map<FqName, ? extends V> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(map, "values");
        Map linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            FqName fqName2 = (FqName) next.getKey();
            if (!Intrinsics.areEqual((Object) fqName, (Object) fqName2) && !isChildOf(fqName, fqName2)) {
                z = false;
            }
            if (z) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (!it2.hasNext()) {
            obj = null;
        } else {
            obj = it2.next();
            if (it2.hasNext()) {
                int length = tail((FqName) ((Map.Entry) obj).getKey(), fqName).asString().length();
                do {
                    Object next2 = it2.next();
                    int length2 = tail((FqName) ((Map.Entry) next2).getKey(), fqName).asString().length();
                    if (length > length2) {
                        obj = next2;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }
}
