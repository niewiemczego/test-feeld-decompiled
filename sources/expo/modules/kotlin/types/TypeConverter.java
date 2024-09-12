package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.exception.NullArgumentException;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0002\u0010\bJ\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/kotlin/types/TypeConverter;", "Type", "", "isOptional", "", "(Z)V", "convert", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "convertNonOptional", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TypeConverter.kt */
public abstract class TypeConverter<Type> {
    private final boolean isOptional;

    public abstract Type convertNonOptional(Object obj);

    public abstract ExpectedType getCppRequiredTypes();

    public boolean isTrivial() {
        return true;
    }

    public TypeConverter(boolean z) {
        this.isOptional = z;
    }

    public Type convert(Object obj) {
        if (obj != null && (!(obj instanceof Dynamic) || !((Dynamic) obj).isNull())) {
            return convertNonOptional(obj);
        }
        if (this.isOptional) {
            return null;
        }
        throw new NullArgumentException();
    }
}
