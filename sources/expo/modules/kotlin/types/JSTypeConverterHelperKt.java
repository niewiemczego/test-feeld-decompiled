package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverter;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0018\n\u0002\u0010\u0013\n\u0002\u0010\u0010\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\t\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\r2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u000e\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u000f\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0010\u001a#\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u00122\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\u0013\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00142\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f\u001a\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u0016\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\b\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\b\u001a\u00020\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00192\u0006\u0010\u000b\u001a\u00020\f\u001a\u001e\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110\u001a2\u0006\u0010\u000b\u001a\u00020\f\u001a*\u0010\b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c*\u000e\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001c0\u001d2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u001e"}, d2 = {"putGeneric", "", "Lcom/facebook/react/bridge/WritableArray;", "value", "", "Lcom/facebook/react/bridge/WritableMap;", "key", "", "toJSValue", "Landroid/net/Uri;", "Landroid/os/Bundle;", "containerProvider", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/File;", "Ljava/net/URI;", "Ljava/net/URL;", "T", "", "([Ljava/lang/Object;Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;)Lcom/facebook/react/bridge/WritableArray;", "", "", "", "", "", "Lkotlin/Pair;", "", "K", "V", "", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSTypeConverterHelper.kt */
public final class JSTypeConverterHelperKt {
    public static final WritableMap toJSValue(Record record, JSTypeConverter.ContainerProvider containerProvider) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(record, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap createMap = containerProvider.createMap();
        Iterable<KProperty1> memberProperties = KClasses.getMemberProperties(JvmClassMappingKt.getKotlinClass(record.getClass()));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(memberProperties, 10));
        for (KProperty1 kProperty1 : memberProperties) {
            Iterator it = kProperty1.getAnnotations().iterator();
            while (true) {
                str = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((Annotation) obj) instanceof Field) {
                    break;
                }
            }
            Field field = (Field) obj;
            if (field != null) {
                String key = field.key();
                if (!Intrinsics.areEqual((Object) key, (Object) "")) {
                    str = key;
                }
                if (str == null) {
                    str = kProperty1.getName();
                }
                KCallablesJvm.setAccessible(kProperty1, true);
                putGeneric(createMap, str, JSTypeConverter.INSTANCE.convertToJSValue(kProperty1.get(record), containerProvider));
            }
            arrayList.add(Unit.INSTANCE);
        }
        List list = (List) arrayList;
        return createMap;
    }

    public static final WritableMap toJSValue(Bundle bundle, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap createMap = containerProvider.createMap();
        for (String str : bundle.keySet()) {
            Object convertToJSValue = JSTypeConverter.INSTANCE.convertToJSValue(bundle.get(str), containerProvider);
            Intrinsics.checkNotNullExpressionValue(str, "key");
            putGeneric(createMap, str, convertToJSValue);
        }
        return createMap;
    }

    public static final <K, V> WritableMap toJSValue(Map<K, ? extends V> map, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableMap createMap = containerProvider.createMap();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            putGeneric(createMap, String.valueOf(key), JSTypeConverter.INSTANCE.convertToJSValue(next.getValue(), containerProvider));
        }
        return createMap;
    }

    public static final <T> WritableArray toJSValue(Iterable<? extends T> iterable, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (Object convertToJSValue : iterable) {
            putGeneric(createArray, JSTypeConverter.INSTANCE.convertToJSValue(convertToJSValue, containerProvider));
        }
        return createArray;
    }

    public static final <T> WritableArray toJSValue(T[] tArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (T convertToJSValue : tArr) {
            putGeneric(createArray, JSTypeConverter.INSTANCE.convertToJSValue(convertToJSValue, containerProvider));
        }
        return createArray;
    }

    public static final WritableArray toJSValue(int[] iArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (int pushInt : iArr) {
            createArray.pushInt(pushInt);
        }
        return createArray;
    }

    public static final WritableArray toJSValue(float[] fArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(fArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (float f : fArr) {
            createArray.pushDouble((double) f);
        }
        return createArray;
    }

    public static final WritableArray toJSValue(double[] dArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(dArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (double pushDouble : dArr) {
            createArray.pushDouble(pushDouble);
        }
        return createArray;
    }

    public static final WritableArray toJSValue(boolean[] zArr, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(zArr, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        for (boolean pushBoolean : zArr) {
            createArray.pushBoolean(pushBoolean);
        }
        return createArray;
    }

    public static final Object toJSValue(Enum<?> enumR) {
        Object obj;
        Intrinsics.checkNotNullParameter(enumR, "<this>");
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(Reflection.getOrCreateKotlinClass(enumR.getClass()));
        if (primaryConstructor == null) {
            throw new IllegalArgumentException("Cannot convert enum without the primary constructor to js value".toString());
        } else if (primaryConstructor.getParameters().isEmpty()) {
            return enumR.name();
        } else {
            if (primaryConstructor.getParameters().size() == 1) {
                String name = ((KParameter) CollectionsKt.first(primaryConstructor.getParameters())).getName();
                Intrinsics.checkNotNull(name);
                Iterator it = KClasses.getDeclaredMemberProperties(Reflection.getOrCreateKotlinClass(enumR.getClass())).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((KProperty1) obj).getName(), (Object) name)) {
                        break;
                    }
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Enum<*>, *>");
                return ((KProperty1) obj).get(enumR);
            }
            throw new IllegalStateException("Enum '" + enumR.getClass() + "' cannot be used as return type (incompatible with JS)");
        }
    }

    public static final String toJSValue(URL url) {
        Intrinsics.checkNotNullParameter(url, "<this>");
        String url2 = url.toString();
        Intrinsics.checkNotNullExpressionValue(url2, "toString()");
        return url2;
    }

    public static final String toJSValue(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString()");
        return uri2;
    }

    public static final String toJSValue(URI uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString()");
        return uri2;
    }

    public static final String toJSValue(File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "absolutePath");
        return absolutePath;
    }

    public static final WritableArray toJSValue(Pair<?, ?> pair, JSTypeConverter.ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        WritableArray createArray = containerProvider.createArray();
        Object convertToJSValue = JSTypeConverter.INSTANCE.convertToJSValue(pair.getFirst(), containerProvider);
        Object convertToJSValue2 = JSTypeConverter.INSTANCE.convertToJSValue(pair.getSecond(), containerProvider);
        putGeneric(createArray, convertToJSValue);
        putGeneric(createArray, convertToJSValue2);
        return createArray;
    }

    public static final void putGeneric(WritableMap writableMap, String str, Object obj) {
        Intrinsics.checkNotNullParameter(writableMap, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        if (obj == null ? true : obj instanceof Unit) {
            writableMap.putNull(str);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else {
            throw new IllegalArgumentException("Could not put '" + obj.getClass() + "' to WritableMap");
        }
    }

    public static final void putGeneric(WritableArray writableArray, Object obj) {
        Intrinsics.checkNotNullParameter(writableArray, "<this>");
        if (obj == null ? true : obj instanceof Unit) {
            writableArray.pushNull();
        } else if (obj instanceof ReadableArray) {
            writableArray.pushArray((ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableArray.pushMap((ReadableMap) obj);
        } else if (obj instanceof String) {
            writableArray.pushString((String) obj);
        } else if (obj instanceof Integer) {
            writableArray.pushInt(((Number) obj).intValue());
        } else if (obj instanceof Number) {
            writableArray.pushDouble(((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableArray.pushBoolean(((Boolean) obj).booleanValue());
        } else {
            throw new IllegalArgumentException("Could not put '" + obj.getClass() + "' to WritableArray");
        }
    }
}
