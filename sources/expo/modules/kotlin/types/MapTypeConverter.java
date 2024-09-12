package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.CollectionElementCastException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.jni.ExpectedType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/kotlin/types/MapTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "converterProvider", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "mapType", "Lkotlin/reflect/KType;", "(Lexpo/modules/kotlin/types/TypeConverterProvider;Lkotlin/reflect/KType;)V", "valueConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "convertFromAny", "value", "", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "convertFromReadableMap", "jsMap", "Lcom/facebook/react/bridge/ReadableMap;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MapTypeConverter.kt */
public final class MapTypeConverter extends DynamicAwareTypeConverters<Map<?, ?>> {
    private final KType mapType;
    private final TypeConverter<?> valueConverter;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapTypeConverter(TypeConverterProvider typeConverterProvider, KType kType) {
        super(kType.isMarkedNullable());
        Intrinsics.checkNotNullParameter(typeConverterProvider, "converterProvider");
        Intrinsics.checkNotNullParameter(kType, "mapType");
        this.mapType = kType;
        if (Intrinsics.areEqual((Object) ((KTypeProjection) CollectionsKt.first(kType.getArguments())).getType(), (Object) Reflection.typeOf(String.class))) {
            KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.getOrNull(kType.getArguments(), 1);
            KType type = kTypeProjection != null ? kTypeProjection.getType() : null;
            if (type != null) {
                this.valueConverter = typeConverterProvider.obtainTypeConverter(type);
                return;
            }
            throw new IllegalArgumentException("The map type should contain the key type.".toString());
        }
        throw new IllegalArgumentException(("The map key type should be String, but received " + CollectionsKt.first(kType.getArguments()) + ".").toString());
    }

    public Map<?, ?> convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        ReadableMap asMap = dynamic.asMap();
        Intrinsics.checkNotNullExpressionValue(asMap, "jsMap");
        return convertFromReadableMap(asMap);
    }

    public Map<?, ?> convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (this.valueConverter.isTrivial()) {
            return (Map) obj;
        }
        Map map = (Map) obj;
        Map<?, ?> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            try {
                linkedHashMap.put(key, this.valueConverter.convert(value));
            } catch (CodedException e) {
                KType kType = this.mapType;
                KType type = kType.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type);
                Intrinsics.checkNotNull(value);
                throw new CollectionElementCastException(kType, type, (KClass<?>) Reflection.getOrCreateKotlinClass(value.getClass()), e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.mapType;
                KType type2 = kType2.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type2);
                Intrinsics.checkNotNull(value);
                throw new CollectionElementCastException(kType2, type2, (KClass<?>) Reflection.getOrCreateKotlinClass(value.getClass()), codedException);
            } catch (Throwable th) {
                KType kType3 = this.mapType;
                KType type3 = kType3.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type3);
                Intrinsics.checkNotNull(value);
                throw new CollectionElementCastException(kType3, type3, (KClass<?>) Reflection.getOrCreateKotlinClass(value.getClass()), (CodedException) new UnexpectedException(th));
            }
        }
        return linkedHashMap;
    }

    private final Map<?, ?> convertFromReadableMap(ReadableMap readableMap) {
        Map<?, ?> linkedHashMap = new LinkedHashMap<>();
        Iterator<Map.Entry<String, Object>> entryIterator = readableMap.getEntryIterator();
        Intrinsics.checkNotNullExpressionValue(entryIterator, "jsMap.entryIterator");
        while (entryIterator.hasNext()) {
            Map.Entry next = entryIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "(key, value)");
            String str = (String) next.getKey();
            Dynamic dynamicFromObject = new DynamicFromObject(next.getValue());
            try {
                Intrinsics.checkNotNullExpressionValue(str, "key");
                linkedHashMap.put(str, this.valueConverter.convert(dynamicFromObject));
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
                dynamicFromObject.recycle();
            } catch (CodedException e) {
                KType kType = this.mapType;
                KType type = kType.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type);
                ReadableType type2 = dynamicFromObject.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
                throw new CollectionElementCastException(kType, type, type2, e);
            } catch (expo.modules.core.errors.CodedException e2) {
                String code = e2.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "e.code");
                CodedException codedException = new CodedException(code, e2.getMessage(), e2.getCause());
                KType kType2 = this.mapType;
                KType type3 = kType2.getArguments().get(1).getType();
                Intrinsics.checkNotNull(type3);
                ReadableType type4 = dynamicFromObject.getType();
                Intrinsics.checkNotNullExpressionValue(type4, "type");
                throw new CollectionElementCastException(kType2, type3, type4, codedException);
            } catch (Throwable th) {
                dynamicFromObject.recycle();
                throw th;
            }
        }
        return linkedHashMap;
    }

    public ExpectedType getCppRequiredTypes() {
        return ExpectedType.Companion.forMap(this.valueConverter.getCppRequiredTypes());
    }

    public boolean isTrivial() {
        return this.valueConverter.isTrivial();
    }
}
