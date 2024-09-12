package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.profilemeasurements.ProfileMeasurement;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: reflectClassUtil.kt */
public final class ReflectClassUtilKt {
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final List<KClass<? extends Object>> PRIMITIVE_CLASSES;
    private static final Map<Class<? extends Object>, Class<? extends Object>> PRIMITIVE_TO_WRAPPER;
    private static final Map<Class<? extends Object>, Class<? extends Object>> WRAPPER_TO_PRIMITIVE;

    public static final ClassLoader getSafeClassLoader(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Intrinsics.checkNotNullExpressionValue(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final boolean isEnumClassOrSpecializedEnumEntryClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }

    static {
        int i = 0;
        List<KClass<? extends Object>> listOf = CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(Boolean.TYPE), Reflection.getOrCreateKotlinClass(Byte.TYPE), Reflection.getOrCreateKotlinClass(Character.TYPE), Reflection.getOrCreateKotlinClass(Double.TYPE), Reflection.getOrCreateKotlinClass(Float.TYPE), Reflection.getOrCreateKotlinClass(Integer.TYPE), Reflection.getOrCreateKotlinClass(Long.TYPE), Reflection.getOrCreateKotlinClass(Short.TYPE));
        PRIMITIVE_CLASSES = listOf;
        Iterable<KClass> iterable = listOf;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (KClass kClass : iterable) {
            arrayList.add(TuplesKt.to(JvmClassMappingKt.getJavaObjectType(kClass), JvmClassMappingKt.getJavaPrimitiveType(kClass)));
        }
        WRAPPER_TO_PRIMITIVE = MapsKt.toMap((List) arrayList);
        Iterable<KClass> iterable2 = PRIMITIVE_CLASSES;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (KClass kClass2 : iterable2) {
            arrayList2.add(TuplesKt.to(JvmClassMappingKt.getJavaPrimitiveType(kClass2), JvmClassMappingKt.getJavaObjectType(kClass2)));
        }
        PRIMITIVE_TO_WRAPPER = MapsKt.toMap((List) arrayList2);
        Iterable listOf2 = CollectionsKt.listOf(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf2, 10));
        for (Object next : listOf2) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList3.add(TuplesKt.to((Class) next, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = MapsKt.toMap((List) arrayList3);
    }

    public static final Class<?> getPrimitiveByWrapper(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return WRAPPER_TO_PRIMITIVE.get(cls);
    }

    public static final Class<?> getWrapperByPrimitive(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return PRIMITIVE_TO_WRAPPER.get(cls);
    }

    public static final Integer getFunctionClassArity(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return FUNCTION_CLASSES.get(cls);
    }

    public static final ClassId getClassId(Class<?> cls) {
        ClassId classId;
        ClassId classId2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
        } else if (!cls.isArray()) {
            if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                String simpleName = cls.getSimpleName();
                Intrinsics.checkNotNullExpressionValue(simpleName, "simpleName");
                if (!(simpleName.length() == 0)) {
                    Class<?> declaringClass = cls.getDeclaringClass();
                    if (declaringClass == null || (classId2 = getClassId(declaringClass)) == null || (classId = classId2.createNestedClassId(Name.identifier(cls.getSimpleName()))) == null) {
                        classId = ClassId.topLevel(new FqName(cls.getName()));
                    }
                    Intrinsics.checkNotNullExpressionValue(classId, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                    return classId;
                }
            }
            FqName fqName = new FqName(cls.getName());
            return new ClassId(fqName.parent(), FqName.topLevel(fqName.shortName()), true);
        } else {
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
    }

    public static final String getDesc(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            return "D";
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            return "I";
                        }
                        break;
                    case 3039496:
                        if (name.equals(ProfileMeasurement.UNIT_BYTES)) {
                            return "B";
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            return "C";
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            return "J";
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            return "Z";
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            return "F";
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            return ExifInterface.LATITUDE_SOUTH;
                        }
                        break;
                }
            }
            throw new IllegalArgumentException("Unsupported primitive type: " + cls);
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "name");
            return StringsKt.replace$default(name2, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null);
        } else {
            StringBuilder append = new StringBuilder().append('L');
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "name");
            return append.append(StringsKt.replace$default(name3, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null)).append(';').toString();
        }
    }

    public static final List<Type> getParameterizedTypeArguments(Type type) {
        Intrinsics.checkNotNullParameter(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            return CollectionsKt.emptyList();
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() != null) {
            return SequencesKt.toList(SequencesKt.flatMap(SequencesKt.generateSequence(type, ReflectClassUtilKt$parameterizedTypeArguments$1.INSTANCE), ReflectClassUtilKt$parameterizedTypeArguments$2.INSTANCE));
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "actualTypeArguments");
        return ArraysKt.toList((T[]) (Object[]) actualTypeArguments);
    }
}
