package com.facebook.react.views.view;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.DynamicFromObject;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bK\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VJ\u001c\u0010W\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010X\u001a\u00020VH\u0002J\u001c\u0010Y\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u0014\u0010[\u001a\u00020P*\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010\\\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u001c\u0010]\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020^H\u0002J\u001c\u0010_\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010`\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010a\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u001c\u0010b\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u001c\u0010c\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010d\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u0014\u0010e\u001a\u00020P*\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u0014\u0010f\u001a\u00020P*\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010g\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u001c\u0010h\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002J\u001c\u0010i\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u0014\u0010j\u001a\u00020P*\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u001c\u0010k\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020\u0004H\u0002J\u000e\u0010l\u001a\u0004\u0018\u00010m*\u00020VH\u0002J\u001c\u0010n\u001a\u00020P*\u00020T2\u0006\u0010Q\u001a\u00020R2\u0006\u0010Z\u001a\u00020VH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006o"}, d2 = {"Lcom/facebook/react/views/view/ReactMapBufferPropSetter;", "", "()V", "ACCESSIBILITY_ACTION_LABEL", "", "ACCESSIBILITY_ACTION_NAME", "ACCESSIBILITY_STATE_BUSY", "ACCESSIBILITY_STATE_CHECKED", "ACCESSIBILITY_STATE_DISABLED", "ACCESSIBILITY_STATE_EXPANDED", "ACCESSIBILITY_STATE_SELECTED", "CORNER_ALL", "CORNER_BOTTOM_END", "CORNER_BOTTOM_LEFT", "CORNER_BOTTOM_RIGHT", "CORNER_BOTTOM_START", "CORNER_TOP_END", "CORNER_TOP_LEFT", "CORNER_TOP_RIGHT", "CORNER_TOP_START", "EDGE_ALL", "EDGE_BOTTOM", "EDGE_END", "EDGE_LEFT", "EDGE_RIGHT", "EDGE_START", "EDGE_TOP", "NATIVE_DRAWABLE_ATTRIBUTE", "NATIVE_DRAWABLE_BORDERLESS", "NATIVE_DRAWABLE_COLOR", "NATIVE_DRAWABLE_KIND", "NATIVE_DRAWABLE_RIPPLE_RADIUS", "UNDEF_COLOR", "VP_ACCESSIBILITY_ACTIONS", "VP_ACCESSIBILITY_HINT", "VP_ACCESSIBILITY_LABEL", "VP_ACCESSIBILITY_LABELLED_BY", "VP_ACCESSIBILITY_LIVE_REGION", "VP_ACCESSIBILITY_ROLE", "VP_ACCESSIBILITY_STATE", "VP_ACCESSIBILITY_VALUE", "VP_ACCESSIBLE", "VP_BACKFACE_VISIBILITY", "VP_BG_COLOR", "VP_BORDER_COLOR", "VP_BORDER_CURVES", "VP_BORDER_RADII", "VP_BORDER_STYLE", "VP_COLLAPSABLE", "VP_ELEVATION", "VP_FG_COLOR", "VP_FOCUSABLE", "VP_HAS_TV_FOCUS", "VP_HIT_SLOP", "VP_IMPORTANT_FOR_ACCESSIBILITY", "VP_NATIVE_BACKGROUND", "VP_NATIVE_FOREGROUND", "VP_NATIVE_ID", "VP_OFFSCREEN_ALPHA_COMPOSITING", "VP_OPACITY", "VP_POINTER_ENTER", "VP_POINTER_ENTER_CAPTURE", "VP_POINTER_EVENTS", "VP_POINTER_LEAVE", "VP_POINTER_LEAVE_CAPTURE", "VP_POINTER_MOVE", "VP_POINTER_MOVE_CAPTURE", "VP_POINTER_OUT", "VP_POINTER_OUT_CAPTURE", "VP_POINTER_OVER", "VP_POINTER_OVER_CAPTURE", "VP_REMOVE_CLIPPED_SUBVIEW", "VP_RENDER_TO_HARDWARE_TEXTURE", "VP_SHADOW_COLOR", "VP_TEST_ID", "VP_TRANSFORM", "VP_ZINDEX", "YG_BORDER_WIDTH", "YG_OVERFLOW", "setProps", "", "view", "Lcom/facebook/react/views/view/ReactViewGroup;", "viewManager", "Lcom/facebook/react/views/view/ReactViewManager;", "props", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "accessibilityActions", "mapBuffer", "accessibilityLabelledBy", "value", "accessibilityLiveRegion", "accessibilityState", "accessibilityValue", "", "backfaceVisibility", "backgroundColor", "borderColor", "borderRadius", "borderStyle", "borderWidth", "hitSlop", "importantForAccessibility", "nativeBackground", "nativeForeground", "overflow", "pointerEvents", "shadowColor", "toJsDrawableDescription", "Lcom/facebook/react/bridge/ReadableMap;", "transform", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReactMapBufferPropSetter.kt */
public final class ReactMapBufferPropSetter {
    private static final int ACCESSIBILITY_ACTION_LABEL = 1;
    private static final int ACCESSIBILITY_ACTION_NAME = 0;
    private static final int ACCESSIBILITY_STATE_BUSY = 0;
    private static final int ACCESSIBILITY_STATE_CHECKED = 4;
    private static final int ACCESSIBILITY_STATE_DISABLED = 1;
    private static final int ACCESSIBILITY_STATE_EXPANDED = 2;
    private static final int ACCESSIBILITY_STATE_SELECTED = 3;
    private static final int CORNER_ALL = 8;
    private static final int CORNER_BOTTOM_END = 6;
    private static final int CORNER_BOTTOM_LEFT = 3;
    private static final int CORNER_BOTTOM_RIGHT = 2;
    private static final int CORNER_BOTTOM_START = 7;
    private static final int CORNER_TOP_END = 5;
    private static final int CORNER_TOP_LEFT = 0;
    private static final int CORNER_TOP_RIGHT = 1;
    private static final int CORNER_TOP_START = 4;
    private static final int EDGE_ALL = 6;
    private static final int EDGE_BOTTOM = 3;
    private static final int EDGE_END = 5;
    private static final int EDGE_LEFT = 1;
    private static final int EDGE_RIGHT = 2;
    private static final int EDGE_START = 4;
    private static final int EDGE_TOP = 0;
    public static final ReactMapBufferPropSetter INSTANCE = new ReactMapBufferPropSetter();
    private static final int NATIVE_DRAWABLE_ATTRIBUTE = 1;
    private static final int NATIVE_DRAWABLE_BORDERLESS = 3;
    private static final int NATIVE_DRAWABLE_COLOR = 2;
    private static final int NATIVE_DRAWABLE_KIND = 0;
    private static final int NATIVE_DRAWABLE_RIPPLE_RADIUS = 4;
    private static final int UNDEF_COLOR = Integer.MAX_VALUE;
    private static final int VP_ACCESSIBILITY_ACTIONS = 0;
    private static final int VP_ACCESSIBILITY_HINT = 1;
    private static final int VP_ACCESSIBILITY_LABEL = 2;
    private static final int VP_ACCESSIBILITY_LABELLED_BY = 3;
    private static final int VP_ACCESSIBILITY_LIVE_REGION = 4;
    private static final int VP_ACCESSIBILITY_ROLE = 5;
    private static final int VP_ACCESSIBILITY_STATE = 6;
    private static final int VP_ACCESSIBILITY_VALUE = 7;
    private static final int VP_ACCESSIBLE = 8;
    private static final int VP_BACKFACE_VISIBILITY = 9;
    private static final int VP_BG_COLOR = 10;
    private static final int VP_BORDER_COLOR = 11;
    private static final int VP_BORDER_CURVES = 45;
    private static final int VP_BORDER_RADII = 12;
    private static final int VP_BORDER_STYLE = 13;
    private static final int VP_COLLAPSABLE = 14;
    private static final int VP_ELEVATION = 15;
    private static final int VP_FG_COLOR = 46;
    private static final int VP_FOCUSABLE = 16;
    private static final int VP_HAS_TV_FOCUS = 17;
    private static final int VP_HIT_SLOP = 18;
    private static final int VP_IMPORTANT_FOR_ACCESSIBILITY = 19;
    private static final int VP_NATIVE_BACKGROUND = 20;
    private static final int VP_NATIVE_FOREGROUND = 21;
    private static final int VP_NATIVE_ID = 22;
    private static final int VP_OFFSCREEN_ALPHA_COMPOSITING = 23;
    private static final int VP_OPACITY = 24;
    private static final int VP_POINTER_ENTER = 26;
    private static final int VP_POINTER_ENTER_CAPTURE = 38;
    private static final int VP_POINTER_EVENTS = 25;
    private static final int VP_POINTER_LEAVE = 27;
    private static final int VP_POINTER_LEAVE_CAPTURE = 39;
    private static final int VP_POINTER_MOVE = 28;
    private static final int VP_POINTER_MOVE_CAPTURE = 40;
    private static final int VP_POINTER_OUT = 41;
    private static final int VP_POINTER_OUT_CAPTURE = 42;
    private static final int VP_POINTER_OVER = 43;
    private static final int VP_POINTER_OVER_CAPTURE = 44;
    private static final int VP_REMOVE_CLIPPED_SUBVIEW = 29;
    private static final int VP_RENDER_TO_HARDWARE_TEXTURE = 30;
    private static final int VP_SHADOW_COLOR = 31;
    private static final int VP_TEST_ID = 32;
    private static final int VP_TRANSFORM = 33;
    private static final int VP_ZINDEX = 34;
    private static final int YG_BORDER_WIDTH = 100;
    private static final int YG_OVERFLOW = 101;

    private ReactMapBufferPropSetter() {
    }

    public final void setProps(ReactViewGroup reactViewGroup, ReactViewManager reactViewManager, MapBuffer mapBuffer) {
        Intrinsics.checkNotNullParameter(reactViewGroup, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(reactViewManager, "viewManager");
        Intrinsics.checkNotNullParameter(mapBuffer, "props");
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            if (key != 46) {
                if (key == 100) {
                    borderWidth(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                } else if (key != 101) {
                    String str = null;
                    boolean z = true;
                    switch (key) {
                        case 0:
                            accessibilityActions(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                            break;
                        case 1:
                            View view = reactViewGroup;
                            String stringValue = entry.getStringValue();
                            if (stringValue.length() <= 0) {
                                z = false;
                            }
                            if (z) {
                                str = stringValue;
                            }
                            reactViewManager.setAccessibilityHint(view, str);
                            break;
                        case 2:
                            View view2 = reactViewGroup;
                            String stringValue2 = entry.getStringValue();
                            if (stringValue2.length() <= 0) {
                                z = false;
                            }
                            if (z) {
                                str = stringValue2;
                            }
                            reactViewManager.setAccessibilityLabel(view2, str);
                            break;
                        case 3:
                            accessibilityLabelledBy(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                            break;
                        case 4:
                            accessibilityLiveRegion(reactViewGroup, entry.getIntValue());
                            break;
                        case 5:
                            View view3 = reactViewGroup;
                            String stringValue3 = entry.getStringValue();
                            if (stringValue3.length() <= 0) {
                                z = false;
                            }
                            if (z) {
                                str = stringValue3;
                            }
                            reactViewManager.setAccessibilityRole(view3, str);
                            break;
                        case 6:
                            accessibilityState(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                            break;
                        case 7:
                            accessibilityValue(reactViewManager, reactViewGroup, entry.getStringValue());
                            break;
                        case 8:
                            reactViewManager.setAccessible(reactViewGroup, entry.getBooleanValue());
                            break;
                        case 9:
                            backfaceVisibility(reactViewManager, reactViewGroup, entry.getIntValue());
                            break;
                        case 10:
                            backgroundColor(reactViewManager, reactViewGroup, entry.getIntValue());
                            break;
                        case 11:
                            borderColor(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                            break;
                        case 12:
                            borderRadius(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                            break;
                        case 13:
                            MapBuffer mapBufferValue = entry.getMapBufferValue();
                            if (!mapBufferValue.contains(8)) {
                                break;
                            } else {
                                borderStyle(reactViewManager, reactViewGroup, (int) mapBufferValue.getDouble(8));
                                break;
                            }
                        default:
                            switch (key) {
                                case 15:
                                    reactViewManager.setElevation(reactViewGroup, (float) entry.getDoubleValue());
                                    break;
                                case 16:
                                    reactViewManager.setFocusable(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 17:
                                    reactViewManager.setTVPreferredFocus(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 18:
                                    hitSlop(reactViewGroup, entry.getMapBufferValue());
                                    break;
                                case 19:
                                    importantForAccessibility(reactViewGroup, entry.getIntValue());
                                    break;
                                case 20:
                                    nativeBackground(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                    break;
                                case 21:
                                    nativeForeground(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                    break;
                                case 22:
                                    View view4 = reactViewGroup;
                                    String stringValue4 = entry.getStringValue();
                                    if (stringValue4.length() <= 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        str = stringValue4;
                                    }
                                    reactViewManager.setNativeId(view4, str);
                                    break;
                                case 23:
                                    reactViewManager.setNeedsOffscreenAlphaCompositing(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 24:
                                    reactViewManager.setOpacity(reactViewGroup, (float) entry.getDoubleValue());
                                    break;
                                case 25:
                                    pointerEvents(reactViewGroup, entry.getIntValue());
                                    break;
                                case 26:
                                    reactViewManager.setPointerEnter(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 27:
                                    reactViewManager.setPointerLeave(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 28:
                                    reactViewManager.setPointerMove(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 29:
                                    reactViewManager.setRemoveClippedSubviews(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 30:
                                    reactViewManager.setRenderToHardwareTexture(reactViewGroup, entry.getBooleanValue());
                                    break;
                                case 31:
                                    shadowColor(reactViewManager, reactViewGroup, entry.getIntValue());
                                    break;
                                case 32:
                                    View view5 = reactViewGroup;
                                    String stringValue5 = entry.getStringValue();
                                    if (stringValue5.length() <= 0) {
                                        z = false;
                                    }
                                    if (z) {
                                        str = stringValue5;
                                    }
                                    reactViewManager.setTestId(view5, str);
                                    break;
                                case 33:
                                    transform(reactViewManager, reactViewGroup, entry.getMapBufferValue());
                                    break;
                                case 34:
                                    reactViewManager.setZIndex(reactViewGroup, (float) entry.getIntValue());
                                    break;
                                default:
                                    switch (key) {
                                        case 38:
                                            reactViewManager.setPointerEnterCapture(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 39:
                                            reactViewManager.setPointerLeaveCapture(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 40:
                                            reactViewManager.setPointerMoveCapture(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 41:
                                            reactViewManager.setPointerOut(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 42:
                                            reactViewManager.setPointerOutCapture(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 43:
                                            reactViewManager.setPointerOver(reactViewGroup, entry.getBooleanValue());
                                            break;
                                        case 44:
                                            reactViewManager.setPointerOverCapture(reactViewGroup, entry.getBooleanValue());
                                            break;
                                    }
                            }
                    }
                } else {
                    overflow(reactViewManager, reactViewGroup, entry.getIntValue());
                }
            }
        }
    }

    private final void accessibilityActions(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        List arrayList = new ArrayList();
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            MapBuffer mapBufferValue = ((MapBuffer.Entry) it.next()).getMapBufferValue();
            if (mapBufferValue != null) {
                javaOnlyMap.putString("name", mapBufferValue.getString(0));
                if (mapBufferValue.contains(1)) {
                    javaOnlyMap.putString("label", mapBufferValue.getString(1));
                }
            }
            arrayList.add(javaOnlyMap);
        }
        reactViewManager.setAccessibilityActions(reactViewGroup, JavaOnlyArray.from(arrayList));
    }

    private final void accessibilityLiveRegion(ReactViewGroup reactViewGroup, int i) {
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 1;
            } else if (i == 2) {
                i2 = 2;
            }
        }
        ViewCompat.setAccessibilityLiveRegion(reactViewGroup, i2);
    }

    private final void accessibilityState(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putBoolean("selected", mapBuffer.getBoolean(3));
        javaOnlyMap.putBoolean("busy", mapBuffer.getBoolean(0));
        javaOnlyMap.putBoolean("expanded", mapBuffer.getBoolean(2));
        javaOnlyMap.putBoolean("disabled", mapBuffer.getBoolean(1));
        int i = mapBuffer.getInt(4);
        if (i == 0) {
            javaOnlyMap.putBoolean("checked", false);
        } else if (i == 1) {
            javaOnlyMap.putBoolean("checked", true);
        } else if (i == 2) {
            javaOnlyMap.putString("checked", "mixed");
        }
        reactViewManager.setViewState(reactViewGroup, javaOnlyMap);
    }

    private final void accessibilityValue(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, String str) {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (str.length() > 0) {
            javaOnlyMap.putString("text", str);
        }
        reactViewManager.setAccessibilityValue(reactViewGroup, javaOnlyMap);
    }

    private final void accessibilityLabelledBy(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        DynamicFromObject dynamicFromObject;
        if (mapBuffer.getCount() == 0) {
            dynamicFromObject = new DynamicFromObject((Object) null);
        } else {
            JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
            Iterator it = mapBuffer.iterator();
            while (it.hasNext()) {
                javaOnlyArray.pushString(((MapBuffer.Entry) it.next()).getStringValue());
            }
            dynamicFromObject = new DynamicFromObject(javaOnlyArray);
        }
        reactViewManager.setAccessibilityLabelledBy(reactViewGroup, dynamicFromObject);
    }

    private final void backfaceVisibility(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i) {
        reactViewManager.setBackfaceVisibility(reactViewGroup, i != 1 ? i != 2 ? "auto" : ViewProps.HIDDEN : ViewProps.VISIBLE);
    }

    private final void backgroundColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i) {
        Integer valueOf = Integer.valueOf(i);
        int i2 = 0;
        if (!(valueOf.intValue() != Integer.MAX_VALUE)) {
            valueOf = null;
        }
        if (valueOf != null) {
            i2 = valueOf.intValue();
        }
        reactViewManager.setBackgroundColor(reactViewGroup, i2);
    }

    private final void borderColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i;
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            boolean z = false;
            switch (key) {
                case 0:
                    i = 3;
                    break;
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown key for border color: ", Integer.valueOf(key)));
            }
            Integer valueOf = Integer.valueOf(entry.getIntValue());
            if (valueOf.intValue() != -1) {
                z = true;
            }
            if (!z) {
                valueOf = null;
            }
            reactViewManager.setBorderColor(reactViewGroup, i, valueOf);
        }
    }

    private final void borderRadius(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i;
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            switch (key) {
                case 0:
                    i = 1;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 3;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 8;
                    break;
                case 7:
                    i = 7;
                    break;
                case 8:
                    i = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown key for border style: ", Integer.valueOf(key)));
            }
            double doubleValue = entry.getDoubleValue();
            if (!Double.isNaN(doubleValue)) {
                reactViewManager.setBorderRadius(reactViewGroup, i, (float) doubleValue);
            }
        }
    }

    private final void borderStyle(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i) {
        reactViewManager.setBorderStyle(reactViewGroup, i != 0 ? i != 1 ? i != 2 ? null : "dashed" : "dotted" : "solid");
    }

    private final void hitSlop(ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewGroup.setHitSlopRect(new Rect((int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(1)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(0)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(2)), (int) PixelUtil.toPixelFromDIP(mapBuffer.getDouble(3))));
    }

    private final void importantForAccessibility(ReactViewGroup reactViewGroup, int i) {
        int i2 = 0;
        if (i != 0) {
            if (i == 1) {
                i2 = 1;
            } else if (i == 2) {
                i2 = 2;
            } else if (i == 3) {
                i2 = 4;
            }
        }
        ViewCompat.setImportantForAccessibility(reactViewGroup, i2);
    }

    private final void pointerEvents(ReactViewGroup reactViewGroup, int i) {
        PointerEvents pointerEvents;
        if (i == 0) {
            pointerEvents = PointerEvents.AUTO;
        } else if (i == 1) {
            pointerEvents = PointerEvents.NONE;
        } else if (i == 2) {
            pointerEvents = PointerEvents.BOX_NONE;
        } else if (i == 3) {
            pointerEvents = PointerEvents.BOX_ONLY;
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown value for pointer events: ", Integer.valueOf(i)));
        }
        reactViewGroup.setPointerEvents(pointerEvents);
    }

    private final void transform(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            javaOnlyArray.pushDouble(((MapBuffer.Entry) it.next()).getDoubleValue());
        }
        reactViewManager.setTransform(reactViewGroup, (ReadableArray) javaOnlyArray);
    }

    private final void borderWidth(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        int i;
        Iterator it = mapBuffer.iterator();
        while (it.hasNext()) {
            MapBuffer.Entry entry = (MapBuffer.Entry) it.next();
            int key = entry.getKey();
            switch (key) {
                case 0:
                    i = 3;
                    break;
                case 1:
                    i = 1;
                    break;
                case 2:
                    i = 2;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 5;
                    break;
                case 5:
                    i = 6;
                    break;
                case 6:
                    i = 0;
                    break;
                default:
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown key for border width: ", Integer.valueOf(key)));
            }
            double doubleValue = entry.getDoubleValue();
            if (!Double.isNaN(doubleValue)) {
                reactViewManager.setBorderWidth(reactViewGroup, i, (float) doubleValue);
            }
        }
    }

    private final void overflow(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i) {
        String str;
        if (i == 0) {
            str = ViewProps.VISIBLE;
        } else if (i == 1) {
            str = ViewProps.HIDDEN;
        } else if (i == 2) {
            str = ViewProps.SCROLL;
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown overflow value: ", Integer.valueOf(i)));
        }
        reactViewManager.setOverflow(reactViewGroup, str);
    }

    private final void shadowColor(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, int i) {
        Integer valueOf = Integer.valueOf(i);
        if (!(valueOf.intValue() != Integer.MAX_VALUE)) {
            valueOf = null;
        }
        reactViewManager.setShadowColor(reactViewGroup, valueOf == null ? ViewCompat.MEASURED_STATE_MASK : valueOf.intValue());
    }

    private final void nativeBackground(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewManager.setNativeBackground(reactViewGroup, toJsDrawableDescription(mapBuffer));
    }

    private final void nativeForeground(ReactViewManager reactViewManager, ReactViewGroup reactViewGroup, MapBuffer mapBuffer) {
        reactViewManager.setNativeForeground(reactViewGroup, toJsDrawableDescription(mapBuffer));
    }

    private final ReadableMap toJsDrawableDescription(MapBuffer mapBuffer) {
        if (mapBuffer.getCount() == 0) {
            return null;
        }
        int i = mapBuffer.getInt(0);
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        if (i == 0) {
            javaOnlyMap.putString("type", "ThemeAttrAndroid");
            javaOnlyMap.putString("attribute", mapBuffer.getString(1));
        } else if (i == 1) {
            javaOnlyMap.putString("type", "RippleAndroid");
            if (mapBuffer.contains(2)) {
                javaOnlyMap.putInt("color", mapBuffer.getInt(2));
            }
            javaOnlyMap.putBoolean("borderless", mapBuffer.getBoolean(3));
            if (mapBuffer.contains(4)) {
                javaOnlyMap.putDouble("rippleRadius", mapBuffer.getDouble(4));
            }
        } else {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unknown native drawable: ", Integer.valueOf(i)));
        }
        return javaOnlyMap;
    }
}
