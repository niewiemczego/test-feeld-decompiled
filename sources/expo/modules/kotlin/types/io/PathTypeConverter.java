package expo.modules.kotlin.types.io;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.types.DynamicAwareTypeConverters;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lexpo/modules/kotlin/types/io/PathTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "Ljava/nio/file/Path;", "isOptional", "", "(Z)V", "convertFromAny", "value", "", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "isTrivial", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PathTypeConverter.kt */
public final class PathTypeConverter extends DynamicAwareTypeConverters<Path> {
    public boolean isTrivial() {
        return false;
    }

    public PathTypeConverter(boolean z) {
        super(z);
    }

    public Path convertFromDynamic(Dynamic dynamic) {
        Intrinsics.checkNotNullParameter(dynamic, "value");
        Path path = Paths.get(dynamic.asString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(stringPath)");
        return path;
    }

    public Path convertFromAny(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        Path path = Paths.get((String) obj, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(stringPath)");
        return path;
    }

    public ExpectedType getCppRequiredTypes() {
        return new ExpectedType(CppType.STRING);
    }
}
