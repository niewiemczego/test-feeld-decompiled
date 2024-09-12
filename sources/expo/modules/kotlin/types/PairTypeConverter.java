package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.SingleType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/kotlin/types/PairTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Lkotlin/Pair;", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "pairType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "converters", "", "Lexpo/modules/kotlin/types/TypeConverter;", "", "convertElement", "array", "Lcom/facebook/react/bridge/ReadableArray;", "index", "", "convertFromAny", "value", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromReadableArray", "jsArray", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PairTypeConverter.kt */
public final class PairTypeConverter extends DynamicAwareTypeConverters<Pair<?, ?>> {
    private final List<TypeConverter<? extends Object>> converters;
    private final KType pairType;

    public boolean isTrivial() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "pairType");
        this.pairType = kType;
        TypeConverter[] typeConverterArr = new TypeConverter[2];
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 0);
        KType kType2 = null;
        KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
        if (type != null) {
            typeConverterArr[0] = typeConverterProvider.obtainTypeConverter(type);
            KTypeProjection kTypeProjection2 = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            kType2 = kTypeProjection2 != null ? kTypeProjection2.getType() : kType2;
            if (kType2 != null) {
                typeConverterArr[1] = typeConverterProvider.obtainTypeConverter(kType2);
                this.converters = CollectionsKt.listOf(typeConverterArr);
                return;
            }
            throw new IllegalArgumentException("The pair type should contain the type of the second parameter.".toString());
        }
        throw new IllegalArgumentException("The pair type should contain the type of the first parameter.".toString());
    }

    public Pair<?, ?> convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        ReadableArray asArray = dynamic.asArray();
        Intrinsics.checkNotNullExpressionValue(asArray, "jsArray");
        return convertFromReadableArray(asArray);
    }

    public Pair<?, ?> convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof ReadableArray) {
            return convertFromReadableArray((ReadableArray) obj);
        }
        return (Pair) obj;
    }

    private final Pair<?, ?> convertFromReadableArray(ReadableArray readableArray) {
        return new Pair<>(convertElement(readableArray, 0), convertElement(readableArray, 1));
    }

    private final Object convertElement(ReadableArray readableArray, int i) {
        Dynamic dynamic = readableArray.getDynamic(i);
        Intrinsics.checkNotNullExpressionValue(dynamic, "array.getDynamic(index)");
        try {
            Object convert = this.converters.get(i).convert(dynamic);
            dynamic.recycle();
            return convert;
        } catch (CodedException e) {
            KType kType = this.pairType;
            KType type = kType.getArguments().get(i).getType();
            Intrinsics.checkNotNull(type);
            ReadableType type2 = dynamic.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "type");
            throw new CollectionElementCastException(kType, type, type2, e);
        } catch (expo.modules.core.errors.CodedException e2) {
            String code = e2.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "e.code");
            CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
            KType kType2 = this.pairType;
            KType type3 = kType2.getArguments().get(i).getType();
            Intrinsics.checkNotNull(type3);
            ReadableType type4 = dynamic.getType();
            Intrinsics.checkNotNullExpressionValue(type4, "type");
            throw new CollectionElementCastException(kType2, type3, type4, codedException);
        } catch (Throwable th) {
            dynamic.recycle();
            throw th;
        }
    }

    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(new SingleType(CppType.READABLE_ARRAY, (ExpectedType[]) null, 2, (DefaultConstructorMarker) null));
    }
}
