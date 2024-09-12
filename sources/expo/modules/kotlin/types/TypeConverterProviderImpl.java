package expo.modules.kotlin.types;

import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.exception.MissingTypeConverter;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JavaScriptObject;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.records.RecordTypeConverter;
import expo.modules.kotlin.typedarray.BigInt64Array;
import expo.modules.kotlin.typedarray.BigUint64Array;
import expo.modules.kotlin.typedarray.Float32Array;
import expo.modules.kotlin.typedarray.Float64Array;
import expo.modules.kotlin.typedarray.Int16Array;
import expo.modules.kotlin.typedarray.Int32Array;
import expo.modules.kotlin.typedarray.Int8Array;
import expo.modules.kotlin.typedarray.TypedArray;
import expo.modules.kotlin.typedarray.Uint16Array;
import expo.modules.kotlin.typedarray.Uint32Array;
import expo.modules.kotlin.typedarray.Uint8Array;
import expo.modules.kotlin.typedarray.Uint8ClampedArray;
import expo.modules.kotlin.types.io.FileTypeConverter;
import expo.modules.kotlin.types.io.PathTypeConverter;
import expo.modules.kotlin.types.net.JavaURITypeConverter;
import expo.modules.kotlin.types.net.URLTypConverter;
import expo.modules.kotlin.types.net.UriTypeConverter;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.full.KClassifiers;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00052\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000e\u001a\u00020\u0005H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverterProviderImpl;", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "()V", "cachedConverters", "", "Lkotlin/reflect/KType;", "Lexpo/modules/kotlin/types/TypeConverter;", "cachedRecordConverters", "", "Lkotlin/reflect/KClass;", "createCashedConverters", "isOptional", "", "handelEither", "type", "kClass", "obtainTypeConverter", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeConverterProvider.kt */
public final class TypeConverterProviderImpl implements TypeConverterProvider {
    public static final TypeConverterProviderImpl INSTANCE;
    private static final Map<KType, TypeConverter<?>> cachedConverters;
    private static final Map<KClass<?>, TypeConverter<?>> cachedRecordConverters = new LinkedHashMap();

    private TypeConverterProviderImpl() {
    }

    static {
        TypeConverterProviderImpl typeConverterProviderImpl = new TypeConverterProviderImpl();
        INSTANCE = typeConverterProviderImpl;
        cachedConverters = MapsKt.plus(typeConverterProviderImpl.createCashedConverters(false), typeConverterProviderImpl.createCashedConverters(true));
    }

    public TypeConverter<?> obtainTypeConverter(KType kType) {
        Intrinsics.checkNotNullParameter(kType, "type");
        TypeConverter<?> typeConverter = cachedConverters.get(kType);
        if (typeConverter != null) {
            return typeConverter;
        }
        KClassifier classifier = kType.getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        if (kClass == null) {
            throw new MissingTypeConverter(kType);
        } else if (JvmClassMappingKt.getJavaClass(kClass).isArray()) {
            return new ArrayTypeConverter(this, kType);
        } else {
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(List.class))) {
                return new ListTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Map.class))) {
                return new MapTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
                return new PairTypeConverter(this, kType);
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Object[].class))) {
                return new ArrayTypeConverter(this, kType);
            }
            if (JvmClassMappingKt.getJavaClass(kClass).isEnum()) {
                return new EnumTypeConverter(kClass, kType.isMarkedNullable());
            }
            Map<KClass<?>, TypeConverter<?>> map = cachedRecordConverters;
            TypeConverter<?> typeConverter2 = map.get(kClass);
            if (typeConverter2 != null) {
                return typeConverter2;
            }
            if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Record.class))) {
                RecordTypeConverter recordTypeConverter = new RecordTypeConverter(this, kType);
                map.put(kClass, recordTypeConverter);
                return recordTypeConverter;
            }
            TypeConverter<?> handelEither = handelEither(kType, kClass);
            if (handelEither != null) {
                return handelEither;
            }
            throw new MissingTypeConverter(kType);
        }
    }

    private final TypeConverter<?> handelEither(KType kType, KClass<?> kClass) {
        if (!KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(Either.class))) {
            return null;
        }
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(EitherOfFour.class))) {
            return new EitherOfFourTypeConverter<>(this, kType);
        }
        if (KClasses.isSubclassOf(kClass, Reflection.getOrCreateKotlinClass(EitherOfThree.class))) {
            return new EitherOfThreeTypeConverter<>(this, kType);
        }
        return new EitherTypeConverter<>(this, kType);
    }

    private final Map<KType, TypeConverter<?>> createCashedConverters(boolean z) {
        boolean z2 = z;
        TypeConverter typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$1 = new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$1(z2, new ExpectedType(CppType.INT));
        TypeConverter typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$2 = new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$2(z2, new ExpectedType(CppType.LONG));
        TypeConverter typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$3 = new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$3(z2, new ExpectedType(CppType.DOUBLE));
        TypeConverter typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$4 = new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$4(z2, new ExpectedType(CppType.FLOAT));
        TypeConverter typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$5 = new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$5(z2, new ExpectedType(CppType.BOOLEAN));
        boolean z3 = z;
        boolean z4 = z;
        Map<KType, TypeConverter<?>> mapOf = MapsKt.mapOf(TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Integer.TYPE), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$1), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Integer.class), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$1), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Long.TYPE), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$2), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Long.class), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$2), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Double.TYPE), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$3), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Double.class), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$3), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float.TYPE), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$4), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float.class), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$4), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Boolean.TYPE), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$5), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Boolean.class), (List) null, z3, (List) null, 5, (Object) null), typeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$5), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(String.class), (List) null, z3, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$6(z2, new ExpectedType(CppType.STRING))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableArray.class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$7(z2, new ExpectedType(CppType.READABLE_ARRAY))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(ReadableMap.class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$8(z2, new ExpectedType(CppType.READABLE_MAP))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(int[].class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$9(z2, ExpectedType.Companion.forPrimitiveArray(CppType.INT))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(double[].class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$10(z2, ExpectedType.Companion.forPrimitiveArray(CppType.DOUBLE))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(float[].class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$11(z2, ExpectedType.Companion.forPrimitiveArray(CppType.FLOAT))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(boolean[].class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$12(z2, ExpectedType.Companion.forPrimitiveArray(CppType.BOOLEAN))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(JavaScriptValue.class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$default$1(z2, new ExpectedType(CppType.JS_VALUE))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(JavaScriptObject.class), (List) null, z, (List) null, 5, (Object) null), new TypeConverterProviderImpl$createCashedConverters$$inlined$createTrivialTypeConverter$default$2(z2, new ExpectedType(CppType.JS_OBJECT))), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Int8Array.class), (List) null, z4, (List) null, 5, (Object) null), new Int8ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Int16Array.class), (List) null, z4, (List) null, 5, (Object) null), new Int16ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Int32Array.class), (List) null, z4, (List) null, 5, (Object) null), new Int32ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Uint8Array.class), (List) null, z4, (List) null, 5, (Object) null), new Uint8ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Uint8ClampedArray.class), (List) null, z4, (List) null, 5, (Object) null), new Uint8ClampedArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Uint16Array.class), (List) null, z4, (List) null, 5, (Object) null), new Uint16ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Uint32Array.class), (List) null, z4, (List) null, 5, (Object) null), new Uint32ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float32Array.class), (List) null, z4, (List) null, 5, (Object) null), new Float32ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Float64Array.class), (List) null, z4, (List) null, 5, (Object) null), new Float64ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(BigInt64Array.class), (List) null, z4, (List) null, 5, (Object) null), new BigInt64ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(BigUint64Array.class), (List) null, z4, (List) null, 5, (Object) null), new BigUint64ArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(TypedArray.class), (List) null, z4, (List) null, 5, (Object) null), new TypedArrayTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Color.class), (List) null, z4, (List) null, 5, (Object) null), new ColorTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(URL.class), (List) null, z4, (List) null, 5, (Object) null), new URLTypConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Uri.class), (List) null, z4, (List) null, 5, (Object) null), new UriTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(URI.class), (List) null, z4, (List) null, 5, (Object) null), new JavaURITypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(File.class), (List) null, z4, (List) null, 5, (Object) null), new FileTypeConverter(z2)), TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Object.class), (List) null, z4, (List) null, 5, (Object) null), new AnyTypeConverter(z2)));
        return Build.VERSION.SDK_INT >= 26 ? MapsKt.plus(mapOf, (Map<KType, TypeConverter<?>>) MapsKt.mapOf(TuplesKt.to(KClassifiers.createType$default(Reflection.getOrCreateKotlinClass(Path.class), (List) null, z, (List) null, 5, (Object) null), new PathTypeConverter(z2)))) : mapOf;
    }
}
