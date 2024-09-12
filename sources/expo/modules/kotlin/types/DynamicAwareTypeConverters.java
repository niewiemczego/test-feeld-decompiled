package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0002H&¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\t¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "T", "", "Lexpo/modules/kotlin/types/TypeConverter;", "isOptional", "", "(Z)V", "convertFromAny", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "(Lcom/facebook/react/bridge/Dynamic;)Ljava/lang/Object;", "convertNonOptional", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeConverter.kt */
public abstract class DynamicAwareTypeConverters<T> extends TypeConverter<T> {
    public abstract T convertFromAny(Object obj);

    public abstract T convertFromDynamic(Dynamic dynamic);

    public DynamicAwareTypeConverters(boolean z) {
        super(z);
    }

    public T convertNonOptional(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        if (obj instanceof Dynamic) {
            return convertFromDynamic((Dynamic) obj);
        }
        return convertFromAny(obj);
    }
}
