package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuiltInsResourceLoader.kt */
public final class BuiltInsResourceLoader {
    public final InputStream loadResource(String str) {
        Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection openConnection = resource.openConnection();
        openConnection.setUseCaches(false);
        return openConnection.getInputStream();
    }
}
