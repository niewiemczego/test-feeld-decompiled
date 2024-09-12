package com.facebook.react.common.mapbuffer;

import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/common/mapbuffer/MapBufferSoLoader;", "", "()V", "didInit", "", "staticInit", "", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MapBufferSoLoader.kt */
public final class MapBufferSoLoader {
    public static final MapBufferSoLoader INSTANCE = new MapBufferSoLoader();
    private static volatile boolean didInit;

    private MapBufferSoLoader() {
    }

    @JvmStatic
    public static final void staticInit() {
        if (!didInit) {
            didInit = true;
            Systrace.beginSection(0, "ReadableMapBufferSoLoader.staticInit::load:mapbufferjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_START);
            SoLoader.loadLibrary("mapbufferjni");
            ReactMarker.logMarker(ReactMarkerConstants.LOAD_REACT_NATIVE_MAPBUFFER_SO_FILE_END);
            Systrace.endSection(0);
        }
    }
}
