package expo.modules.kotlin.types;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter;", "", "()V", "convertToJSValue", "value", "containerProvider", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "ContainerProvider", "DefaultContainerProvider", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSTypeConverter.kt */
public final class JSTypeConverter {
    public static final JSTypeConverter INSTANCE = new JSTypeConverter();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JSTypeConverter.kt */
    public interface ContainerProvider {
        WritableArray createArray();

        WritableMap createMap();
    }

    private JSTypeConverter() {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/types/JSTypeConverter$DefaultContainerProvider;", "Lexpo/modules/kotlin/types/JSTypeConverter$ContainerProvider;", "()V", "createArray", "Lcom/facebook/react/bridge/WritableArray;", "createMap", "Lcom/facebook/react/bridge/WritableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: JSTypeConverter.kt */
    public static final class DefaultContainerProvider implements ContainerProvider {
        public static final DefaultContainerProvider INSTANCE = new DefaultContainerProvider();

        private DefaultContainerProvider() {
        }

        public WritableMap createMap() {
            WritableMap createMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
            return createMap;
        }

        public WritableArray createArray() {
            WritableArray createArray = Arguments.createArray();
            Intrinsics.checkNotNullExpressionValue(createArray, "createArray()");
            return createArray;
        }
    }

    public static /* synthetic */ Object convertToJSValue$default(JSTypeConverter jSTypeConverter, Object obj, ContainerProvider containerProvider, int i, Object obj2) {
        if ((i & 2) != 0) {
            containerProvider = DefaultContainerProvider.INSTANCE;
        }
        return jSTypeConverter.convertToJSValue(obj, containerProvider);
    }

    public final Object convertToJSValue(Object obj, ContainerProvider containerProvider) {
        Intrinsics.checkNotNullParameter(containerProvider, "containerProvider");
        if (obj == null ? true : obj instanceof Unit) {
            return null;
        }
        if (obj instanceof Bundle) {
            return JSTypeConverterHelperKt.toJSValue((Bundle) obj, containerProvider);
        }
        if (obj instanceof Iterable) {
            return JSTypeConverterHelperKt.toJSValue((Iterable) obj, containerProvider);
        }
        if (obj instanceof Object[]) {
            return JSTypeConverterHelperKt.toJSValue((T[]) (Object[]) obj, containerProvider);
        }
        if (obj instanceof int[]) {
            return JSTypeConverterHelperKt.toJSValue((int[]) obj, containerProvider);
        }
        if (obj instanceof float[]) {
            return JSTypeConverterHelperKt.toJSValue((float[]) obj, containerProvider);
        }
        if (obj instanceof double[]) {
            return JSTypeConverterHelperKt.toJSValue((double[]) obj, containerProvider);
        }
        if (obj instanceof boolean[]) {
            return JSTypeConverterHelperKt.toJSValue((boolean[]) obj, containerProvider);
        }
        if (obj instanceof Map) {
            return JSTypeConverterHelperKt.toJSValue((Map) obj, containerProvider);
        }
        if (obj instanceof Enum) {
            return JSTypeConverterHelperKt.toJSValue((Enum<?>) (Enum) obj);
        }
        if (obj instanceof Record) {
            return JSTypeConverterHelperKt.toJSValue((Record) obj, containerProvider);
        }
        if (obj instanceof URI) {
            return JSTypeConverterHelperKt.toJSValue((URI) obj);
        }
        if (obj instanceof URL) {
            return JSTypeConverterHelperKt.toJSValue((URL) obj);
        }
        if (obj instanceof Uri) {
            return JSTypeConverterHelperKt.toJSValue((Uri) obj);
        }
        if (obj instanceof File) {
            return JSTypeConverterHelperKt.toJSValue((File) obj);
        }
        if (obj instanceof Pair) {
            return JSTypeConverterHelperKt.toJSValue((Pair<?, ?>) (Pair) obj, containerProvider);
        }
        return obj instanceof Long ? Double.valueOf((double) ((Number) obj).longValue()) : obj;
    }
}
