package com.horcrux.svg;

import android.graphics.Rect;
import android.util.SparseArray;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerDelegate;
import com.facebook.react.viewmanagers.RNSVGSvgViewAndroidManagerInterface;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class SvgViewManager extends ReactViewManager implements RNSVGSvgViewAndroidManagerInterface<SvgView> {
    public static final String REACT_CLASS = "RNSVGSvgViewAndroid";
    private static final SparseArray<Runnable> mTagToRunnable = new SparseArray<>();
    private static final SparseArray<SvgView> mTagToSvgView = new SparseArray<>();
    private final ViewManagerDelegate<SvgView> mDelegate = new RNSVGSvgViewAndroidManagerDelegate(this);

    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate getDelegate() {
        return this.mDelegate;
    }

    static void setSvgView(int i, SvgView svgView) {
        mTagToSvgView.put(i, svgView);
        SparseArray<Runnable> sparseArray = mTagToRunnable;
        Runnable runnable = sparseArray.get(i);
        if (runnable != null) {
            runnable.run();
            sparseArray.delete(i);
        }
    }

    static void runWhenViewIsAvailable(int i, Runnable runnable) {
        mTagToRunnable.put(i, runnable);
    }

    @Nullable
    static SvgView getSvgViewByTag(int i) {
        return mTagToSvgView.get(i);
    }

    @Nonnull
    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new SvgView(themedReactContext);
    }

    public void updateExtraData(ReactViewGroup reactViewGroup, Object obj) {
        super.updateExtraData(reactViewGroup, obj);
        reactViewGroup.invalidate();
    }

    public void onDropViewInstance(@Nonnull ReactViewGroup reactViewGroup) {
        super.onDropViewInstance(reactViewGroup);
        mTagToSvgView.remove(reactViewGroup.getId());
    }

    @ReactProp(customType = "Color", name = "tintColor")
    public void setTintColor(SvgView svgView, Integer num) {
        svgView.setTintColor(num);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(SvgView svgView, Integer num) {
        svgView.setTintColor(num);
    }

    @ReactProp(name = "minX")
    public void setMinX(SvgView svgView, float f) {
        svgView.setMinX(f);
    }

    @ReactProp(name = "minY")
    public void setMinY(SvgView svgView, float f) {
        svgView.setMinY(f);
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(SvgView svgView, float f) {
        svgView.setVbWidth(f);
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(SvgView svgView, float f) {
        svgView.setVbHeight(f);
    }

    @ReactProp(name = "bbWidth")
    public void setBbWidth(SvgView svgView, Dynamic dynamic) {
        svgView.setBbWidth(dynamic);
    }

    @ReactProp(name = "bbHeight")
    public void setBbHeight(SvgView svgView, Dynamic dynamic) {
        svgView.setBbHeight(dynamic);
    }

    @ReactProp(name = "align")
    public void setAlign(SvgView svgView, String str) {
        svgView.setAlign(str);
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(SvgView svgView, int i) {
        svgView.setMeetOrSlice(i);
    }

    public void setBbWidth(SvgView svgView, @Nullable String str) {
        svgView.setBbWidth(str);
    }

    public void setBbWidth(SvgView svgView, @Nullable Double d) {
        svgView.setBbWidth(d);
    }

    public void setBbHeight(SvgView svgView, @Nullable String str) {
        svgView.setBbHeight(str);
    }

    public void setBbHeight(SvgView svgView, @Nullable Double d) {
        svgView.setBbHeight(d);
    }

    @ReactProp(name = "pointerEvents")
    public void setPointerEvents(SvgView svgView, @Nullable String str) {
        try {
            Class<? super Object> superclass = svgView.getClass().getSuperclass();
            if (superclass != null) {
                Method declaredMethod = superclass.getDeclaredMethod("setPointerEvents", new Class[]{PointerEvents.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(svgView, new Object[]{PointerEvents.valueOf(str.toUpperCase(Locale.US).replace("-", "_"))});
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void setHasTVPreferredFocus(SvgView svgView, boolean z) {
        super.setTVPreferredFocus(svgView, z);
    }

    public void setBorderTopEndRadius(SvgView svgView, float f) {
        super.setBorderRadius(svgView, 6, f);
    }

    public void setBorderBottomStartRadius(SvgView svgView, float f) {
        super.setBorderRadius(svgView, 7, f);
    }

    public void setBorderBottomColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 4, num);
    }

    public void setNextFocusDown(SvgView svgView, int i) {
        super.nextFocusDown(svgView, i);
    }

    public void setBorderRightColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 2, num);
    }

    public void setNextFocusRight(SvgView svgView, int i) {
        super.nextFocusRight(svgView, i);
    }

    public void setBorderLeftColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 1, num);
    }

    public void setBorderColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 0, num);
    }

    public void setRemoveClippedSubviews(SvgView svgView, boolean z) {
        super.setRemoveClippedSubviews(svgView, z);
    }

    public void setNextFocusForward(SvgView svgView, int i) {
        super.nextFocusForward(svgView, i);
    }

    public void setNextFocusUp(SvgView svgView, int i) {
        super.nextFocusUp(svgView, i);
    }

    public void setAccessible(SvgView svgView, boolean z) {
        super.setAccessible(svgView, z);
    }

    public void setBorderStartColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 5, num);
    }

    public void setBorderBottomEndRadius(SvgView svgView, float f) {
        super.setBorderRadius(svgView, 8, f);
    }

    public void setBorderEndColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 6, num);
    }

    public void setFocusable(SvgView svgView, boolean z) {
        super.setFocusable(svgView, z);
    }

    public void setNativeBackgroundAndroid(SvgView svgView, @Nullable ReadableMap readableMap) {
        super.setNativeBackground(svgView, readableMap);
    }

    public void setBorderTopStartRadius(SvgView svgView, float f) {
        super.setBorderRadius(svgView, 5, f);
    }

    public void setNativeForegroundAndroid(SvgView svgView, @Nullable ReadableMap readableMap) {
        super.setNativeForeground(svgView, readableMap);
    }

    public void setBackfaceVisibility(SvgView svgView, @Nullable String str) {
        super.setBackfaceVisibility(svgView, str);
    }

    public void setBorderStyle(SvgView svgView, @Nullable String str) {
        super.setBorderStyle(svgView, str);
    }

    public void setNeedsOffscreenAlphaCompositing(SvgView svgView, boolean z) {
        super.setNeedsOffscreenAlphaCompositing(svgView, z);
    }

    public void setHitSlop(SvgView svgView, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            int i = 0;
            int pixelFromDIP = readableMap.hasKey("left") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("left")) : 0;
            int pixelFromDIP2 = readableMap.hasKey("top") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("top")) : 0;
            int pixelFromDIP3 = readableMap.hasKey("right") ? (int) PixelUtil.toPixelFromDIP(readableMap.getDouble("right")) : 0;
            if (readableMap.hasKey(ViewProps.BOTTOM)) {
                i = (int) PixelUtil.toPixelFromDIP(readableMap.getDouble(ViewProps.BOTTOM));
            }
            svgView.setHitSlopRect(new Rect(pixelFromDIP, pixelFromDIP2, pixelFromDIP3, i));
        }
    }

    public void setBorderTopColor(SvgView svgView, @Nullable Integer num) {
        super.setBorderColor(svgView, 3, num);
    }

    public void setNextFocusLeft(SvgView svgView, int i) {
        super.nextFocusLeft(svgView, i);
    }

    public void setBorderRadius(SvgView svgView, double d) {
        super.setBorderRadius(svgView, 0, (float) d);
    }

    public void setBorderTopLeftRadius(SvgView svgView, double d) {
        super.setBorderRadius(svgView, 1, (float) d);
    }

    public void setBorderTopRightRadius(SvgView svgView, double d) {
        super.setBorderRadius(svgView, 2, (float) d);
    }

    public void setBorderBottomRightRadius(SvgView svgView, double d) {
        super.setBorderRadius(svgView, 3, (float) d);
    }

    public void setBorderBottomLeftRadius(SvgView svgView, double d) {
        super.setBorderRadius(svgView, 4, (float) d);
    }
}
