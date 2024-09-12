package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: ClassMapperLite.kt */
public final class ClassMapperLite {
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f34kotlin = CollectionsKt.joinToString$default(CollectionsKt.listOf('k', 'o', 't', 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    private static final Map<String, String> map;

    private ClassMapperLite() {
    }

    static {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        List listOf = CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f34kotlin;
                int i2 = i + 1;
                linkedHashMap.put(sb.append(str).append(IOUtils.DIR_SEPARATOR_UNIX).append((String) listOf.get(i)).toString(), listOf.get(i2));
                linkedHashMap.put(str + IOUtils.DIR_SEPARATOR_UNIX + ((String) listOf.get(i)) + "Array", '[' + ((String) listOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        linkedHashMap.put(f34kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m2268map$lambda0$add(linkedHashMap, "Any", "java/lang/Object");
        m2268map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m2268map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            m2268map$lambda0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            m2268map$lambda0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            m2268map$lambda0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        m2268map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m2268map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m2268map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m2268map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f34kotlin;
            m2268map$lambda0$add(linkedHashMap, "Function" + i3, sb2.append(str4).append("/jvm/functions/Function").append(i3).toString());
            m2268map$lambda0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            m2268map$lambda0$add(linkedHashMap, str5 + ".Companion", f34kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    /* renamed from: map$lambda-0$add  reason: not valid java name */
    private static final void m2268map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f34kotlin + IOUtils.DIR_SEPARATOR_UNIX + str, 'L' + str2 + ';');
    }

    @JvmStatic
    public static final String mapClass(String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        return str2 == null ? 'L' + StringsKt.replace$default(str, '.', '$', false, 4, (Object) null) + ';' : str2;
    }
}
