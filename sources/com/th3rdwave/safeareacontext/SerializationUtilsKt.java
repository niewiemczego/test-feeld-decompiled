package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\f"}, d2 = {"edgeInsetsToJavaMap", "", "", "", "insets", "Lcom/th3rdwave/safeareacontext/EdgeInsets;", "edgeInsetsToJsMap", "Lcom/facebook/react/bridge/WritableMap;", "rectToJavaMap", "rect", "Lcom/th3rdwave/safeareacontext/Rect;", "rectToJsMap", "react-native-safe-area-context_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SerializationUtils.kt */
public final class SerializationUtilsKt {
    public static final WritableMap edgeInsetsToJsMap(EdgeInsets edgeInsets) {
        Intrinsics.checkNotNullParameter(edgeInsets, "insets");
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("top", (double) PixelUtil.toDIPFromPixel(edgeInsets.getTop()));
        createMap.putDouble("right", (double) PixelUtil.toDIPFromPixel(edgeInsets.getRight()));
        createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel(edgeInsets.getBottom()));
        createMap.putDouble("left", (double) PixelUtil.toDIPFromPixel(edgeInsets.getLeft()));
        Intrinsics.checkNotNullExpressionValue(createMap, "insetsMap");
        return createMap;
    }

    public static final Map<String, Float> edgeInsetsToJavaMap(EdgeInsets edgeInsets) {
        Intrinsics.checkNotNullParameter(edgeInsets, "insets");
        return MapsKt.mapOf(TuplesKt.to("top", Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.getTop()))), TuplesKt.to("right", Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.getRight()))), TuplesKt.to(ViewProps.BOTTOM, Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.getBottom()))), TuplesKt.to("left", Float.valueOf(PixelUtil.toDIPFromPixel(edgeInsets.getLeft()))));
    }

    public static final WritableMap rectToJsMap(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(ViewHierarchyNode.JsonKeys.X, (double) PixelUtil.toDIPFromPixel(rect.getX()));
        createMap.putDouble(ViewHierarchyNode.JsonKeys.Y, (double) PixelUtil.toDIPFromPixel(rect.getY()));
        createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel(rect.getWidth()));
        createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel(rect.getHeight()));
        Intrinsics.checkNotNullExpressionValue(createMap, "rectMap");
        return createMap;
    }

    public static final Map<String, Float> rectToJavaMap(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        return MapsKt.mapOf(TuplesKt.to(ViewHierarchyNode.JsonKeys.X, Float.valueOf(PixelUtil.toDIPFromPixel(rect.getX()))), TuplesKt.to(ViewHierarchyNode.JsonKeys.Y, Float.valueOf(PixelUtil.toDIPFromPixel(rect.getY()))), TuplesKt.to("width", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getWidth()))), TuplesKt.to("height", Float.valueOf(PixelUtil.toDIPFromPixel(rect.getHeight()))));
    }
}
