package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Dynamic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¢\u0006\u0002\u0010\u0004\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007\u001a \u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005H\b¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0005H\b¨\u0006\u000b"}, d2 = {"convert", "T", "value", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "", "type", "Lkotlin/reflect/KType;", "(Ljava/lang/Object;)Ljava/lang/Object;", "obtainTypeConverter", "Lexpo/modules/kotlin/types/TypeConverter;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeConverterProvider.kt */
public final class TypeConverterProviderKt {
    public static final /* synthetic */ <T> TypeConverter<T> obtainTypeConverter() {
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        TypeConverter<?> obtainTypeConverter = typeConverterProviderImpl.obtainTypeConverter((KType) null);
        Intrinsics.checkNotNull(obtainTypeConverter, "null cannot be cast to non-null type expo.modules.kotlin.types.TypeConverter<T of expo.modules.kotlin.types.TypeConverterProviderKt.obtainTypeConverter>");
        TypeConverter typeConverter = obtainTypeConverter;
        return obtainTypeConverter;
    }

    public static final /* synthetic */ <T> T convert(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T convert = typeConverterProviderImpl.obtainTypeConverter((KType) null).convert(dynamic);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = (Object) convert;
        return convert;
    }

    public static final /* synthetic */ <T> T convert(Object obj) {
        TypeConverterProviderImpl typeConverterProviderImpl = TypeConverterProviderImpl.INSTANCE;
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        T convert = typeConverterProviderImpl.obtainTypeConverter((KType) null).convert(obj);
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj2 = (Object) convert;
        return convert;
    }

    public static final Object convert(Dynamic dynamic, KType kType) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        Intrinsics.checkNotNullParameter(kType, "type");
        return TypeConverterProviderImpl.INSTANCE.obtainTypeConverter(kType).convert(dynamic);
    }
}
