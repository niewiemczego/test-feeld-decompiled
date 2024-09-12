package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0019\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/types/ArrayTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "arrayType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "arrayElementConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromAny", "value", "", "(Ljava/lang/Object;)[Ljava/lang/Object;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)[Ljava/lang/Object;", "createTypedArray", "size", "", "(I)[Ljava/lang/Object;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArrayTypeConverter.kt */
public final class ArrayTypeConverter extends DynamicAwareTypeConverters<Object[]> {
    private final TypeConverter<?> arrayElementConverter;
    private final KType arrayType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArrayTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "arrayType");
        this.arrayType = kType;
        KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
        if (type != null) {
            this.arrayElementConverter = typeConverterProvider.obtainTypeConverter(type);
            return;
        }
        throw new IllegalArgumentException("The array type should contain the type of the elements.".toString());
    }

    public Object[] convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        ReadableArray asArray = dynamic.asArray();
        Object[] createTypedArray = createTypedArray(asArray.size());
        int size = asArray.size();
        int i = 0;
        while (i < size) {
            Dynamic dynamic2 = asArray.getDynamic(i);
            Intrinsics.checkNotNullExpressionValue(dynamic2, "jsArray\n        .getDynamic(i)");
            try {
                Object convert = this.arrayElementConverter.convert(dynamic2);
                dynamic2.recycle();
                createTypedArray[i] = convert;
                i++;
            } catch (CodedException e) {
                KType kType = this.arrayType;
                KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
                Intrinsics.checkNotNull(type);
                ReadableType type2 = dynamic2.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
                throw new CollectionElementCastException(kType, type, type2, e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.arrayType;
                KType type3 = ((KTypeProjection) CollectionsKt.first(kType2.getArguments())).getType();
                Intrinsics.checkNotNull(type3);
                ReadableType type4 = dynamic2.getType();
                Intrinsics.checkNotNullExpressionValue(type4, "type");
                throw new CollectionElementCastException(kType2, type3, type4, codedException);
            } catch (Throwable th) {
                dynamic2.recycle();
                throw th;
            }
        }
        return createTypedArray;
    }

    public Object[] convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.arrayElementConverter.isTrivial()) {
            return (Object[]) obj;
        }
        Object[] objArr = (Object[]) obj;
        Collection arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj2 = objArr[i];
            try {
                arrayList.add(this.arrayElementConverter.convert(obj2));
                i++;
            } catch (CodedException e) {
                KType kType = this.arrayType;
                KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(obj2);
                throw new CollectionElementCastException(kType, type, (KClass<?>) Reflection.getOrCreateKotlinClass(obj2.getClass()), e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.arrayType;
                KType type2 = ((KTypeProjection) CollectionsKt.first(kType2.getArguments())).getType();
                Intrinsics.checkNotNull(type2);
                Intrinsics.checkNotNull(obj2);
                throw new CollectionElementCastException(kType2, type2, (KClass<?>) Reflection.getOrCreateKotlinClass(obj2.getClass()), codedException);
            } catch (Throwable th) {
                KType kType3 = this.arrayType;
                KType type3 = ((KTypeProjection) CollectionsKt.first(kType3.getArguments())).getType();
                Intrinsics.checkNotNull(type3);
                Intrinsics.checkNotNull(obj2);
                throw new CollectionElementCastException(kType3, type3, (KClass<?>) Reflection.getOrCreateKotlinClass(obj2.getClass()), (CodedException) new UnexpectedException(th));
            }
        }
        Object[] array = ((List) arrayList).toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return array;
    }

    private final Object[] createTypedArray(int i) {
        KType type = ((KTypeProjection) CollectionsKt.first(this.arrayType.getArguments())).getType();
        Intrinsics.checkNotNull(type);
        KClassifier classifier = type.getClassifier();
        Intrinsics.checkNotNull(classifier, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass((KClass) classifier), i);
        Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return (Object[]) newInstance;
    }

    public ExpectedType getCppRequiredTypes() {
        return ExpectedType.Companion.forPrimitiveArray(this.arrayElementConverter.getCppRequiredTypes());
    }

    public boolean isTrivial() {
        return this.arrayElementConverter.isTrivial();
    }
}
