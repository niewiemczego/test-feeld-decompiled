package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0014\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/types/ListTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "listType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "elementConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromAny", "value", "", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromReadableArray", "jsArray", "Lcom/facebook/react/bridge/ReadableArray;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ListTypeConverter.kt */
public final class ListTypeConverter extends DynamicAwareTypeConverters<List<?>> {
    private final TypeConverter<?> elementConverter;
    private final KType listType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ListTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "listType");
        this.listType = kType;
        KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
        if (type != null) {
            this.elementConverter = typeConverterProvider.obtainTypeConverter(type);
            return;
        }
        throw new IllegalArgumentException("The list type should contain the type of elements.".toString());
    }

    public List<?> convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        ReadableArray asArray = dynamic.asArray();
        Intrinsics.checkNotNullExpressionValue(asArray, "jsArray");
        return convertFromReadableArray(asArray);
    }

    public List<?> convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.elementConverter.isTrivial()) {
            return (List) obj;
        }
        Iterable iterable = (List) obj;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            try {
                arrayList.add(this.elementConverter.convert(next));
            } catch (CodedException e) {
                KType kType = this.listType;
                KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(next);
                throw new CollectionElementCastException(kType, type, (KClass<?>) Reflection.getOrCreateKotlinClass(next.getClass()), e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.listType;
                KType type2 = ((KTypeProjection) CollectionsKt.first(kType2.getArguments())).getType();
                Intrinsics.checkNotNull(type2);
                Intrinsics.checkNotNull(next);
                throw new CollectionElementCastException(kType2, type2, (KClass<?>) Reflection.getOrCreateKotlinClass(next.getClass()), codedException);
            } catch (Throwable th) {
                KType kType3 = this.listType;
                KType type3 = ((KTypeProjection) CollectionsKt.first(kType3.getArguments())).getType();
                Intrinsics.checkNotNull(type3);
                Intrinsics.checkNotNull(next);
                throw new CollectionElementCastException(kType3, type3, (KClass<?>) Reflection.getOrCreateKotlinClass(next.getClass()), (CodedException) new UnexpectedException(th));
            }
        }
        return (List) arrayList;
    }

    private final List<?> convertFromReadableArray(ReadableArray readableArray) {
        int size = readableArray.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        while (i < size) {
            Dynamic dynamic = readableArray.getDynamic(i);
            Intrinsics.checkNotNullExpressionValue(dynamic, "jsArray.getDynamic(index)");
            try {
                Object convert = this.elementConverter.convert(dynamic);
                dynamic.recycle();
                arrayList.add(convert);
                i++;
            } catch (CodedException e) {
                KType kType = this.listType;
                KType type = ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType();
                Intrinsics.checkNotNull(type);
                ReadableType type2 = dynamic.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
                throw new CollectionElementCastException(kType, type, type2, e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.listType;
                KType type3 = ((KTypeProjection) CollectionsKt.first(kType2.getArguments())).getType();
                Intrinsics.checkNotNull(type3);
                ReadableType type4 = dynamic.getType();
                Intrinsics.checkNotNullExpressionValue(type4, "type");
                throw new CollectionElementCastException(kType2, type3, type4, codedException);
            } catch (Throwable th) {
                dynamic.recycle();
                throw th;
            }
        }
        return arrayList;
    }

    public ExpectedType getCppRequiredTypes() {
        return ExpectedType.Companion.forList(this.elementConverter.getCppRequiredTypes());
    }

    public boolean isTrivial() {
        return this.elementConverter.isTrivial();
    }
}
