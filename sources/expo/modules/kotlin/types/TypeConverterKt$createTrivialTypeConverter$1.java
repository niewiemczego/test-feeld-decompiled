package expo.modules.kotlin.types;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.exception.UnsupportedClass;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "", "it", "Lcom/facebook/react/bridge/Dynamic;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
/* compiled from: TypeConverter.kt */
public final class TypeConverterKt$createTrivialTypeConverter$1 extends Lambda implements Function1 {
    public static final TypeConverterKt$createTrivialTypeConverter$1 INSTANCE = new TypeConverterKt$createTrivialTypeConverter$1();

    public TypeConverterKt$createTrivialTypeConverter$1() {
        super(1);
    }

    public final Void invoke(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "it");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        throw new UnsupportedClass(Reflection.getOrCreateKotlinClass(Object.class));
    }
}
