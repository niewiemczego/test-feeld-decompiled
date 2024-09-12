package com.facebook.react.views.switchview;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidSwitchManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwitchManagerInterface;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

public class ReactSwitchManager extends SimpleViewManager<ReactSwitch> implements AndroidSwitchManagerInterface<ReactSwitch> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReactContext reactContext = (ReactContext) compoundButton.getContext();
            int id = compoundButton.getId();
            UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new ReactSwitchEvent(UIManagerHelper.getSurfaceId((Context) reactContext), id, z));
        }
    };
    public static final String REACT_CLASS = "AndroidSwitch";
    private final ViewManagerDelegate<ReactSwitch> mDelegate = new AndroidSwitchManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    static class ReactSwitchShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSwitchShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSwitch reactSwitch = new ReactSwitch(getThemedContext());
                reactSwitch.setShowText(false);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSwitch.getMeasuredWidth();
                this.mHeight = reactSwitch.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSwitchShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSwitchShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public ReactSwitch createViewInstance(ThemedReactContext themedReactContext) {
        ReactSwitch reactSwitch = new ReactSwitch(themedReactContext);
        reactSwitch.setShowText(false);
        return reactSwitch;
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(!z);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setEnabled(z);
    }

    @ReactProp(name = "on")
    public void setOn(ReactSwitch reactSwitch, boolean z) {
        setValueInternal(reactSwitch, z);
    }

    @ReactProp(name = "value")
    public void setValue(ReactSwitch reactSwitch, boolean z) {
        setValueInternal(reactSwitch, z);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSwitch reactSwitch, Integer num) {
        setThumbColor(reactSwitch, num);
    }

    @ReactProp(customType = "Color", name = "thumbColor")
    public void setThumbColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setThumbColor(num);
    }

    @ReactProp(customType = "Color", name = "trackColorForFalse")
    public void setTrackColorForFalse(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForFalse(num);
    }

    @ReactProp(customType = "Color", name = "trackColorForTrue")
    public void setTrackColorForTrue(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColorForTrue(num);
    }

    @ReactProp(customType = "Color", name = "trackTintColor")
    public void setTrackTintColor(ReactSwitch reactSwitch, Integer num) {
        reactSwitch.setTrackColor(num);
    }

    public void setNativeValue(ReactSwitch reactSwitch, boolean z) {
        setValueInternal(reactSwitch, z);
    }

    public void receiveCommand(ReactSwitch reactSwitch, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeValue")) {
            boolean z = false;
            if (readableArray != null && readableArray.getBoolean(0)) {
                z = true;
            }
            setValueInternal(reactSwitch, z);
        }
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSwitch reactSwitch) {
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactSwitch> getDelegate() {
        return this.mDelegate;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        ReactSwitch reactSwitch = new ReactSwitch(context);
        reactSwitch.setShowText(false);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        reactSwitch.measure(makeMeasureSpec, makeMeasureSpec);
        return YogaMeasureOutput.make(PixelUtil.toDIPFromPixel((float) reactSwitch.getMeasuredWidth()), PixelUtil.toDIPFromPixel((float) reactSwitch.getMeasuredHeight()));
    }

    private static void setValueInternal(ReactSwitch reactSwitch, boolean z) {
        reactSwitch.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        reactSwitch.setOn(z);
        reactSwitch.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }
}
