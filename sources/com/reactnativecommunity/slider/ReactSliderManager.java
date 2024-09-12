package com.reactnativecommunity.slider;

import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactSliderManager extends SimpleViewManager<ReactSlider> {
    private static final SeekBar.OnSeekBarChangeListener ON_CHANGE_LISTENER = new SeekBar.OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ReactSlider reactSlider = (ReactSlider) seekBar;
            if (i < reactSlider.getLowerLimit()) {
                i = reactSlider.getLowerLimit();
                seekBar.setProgress(i);
            } else if (i > reactSlider.getUpperLimit()) {
                i = reactSlider.getUpperLimit();
                seekBar.setProgress(i);
            }
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            if (z) {
                ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), reactSlider.toRealProgress(i), true));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(true);
            ((UIManagerModule) ((ReactContext) seekBar.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingStartEvent(seekBar.getId(), reactSlider.toRealProgress(seekBar.getProgress())));
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            ReactContext reactContext = (ReactContext) seekBar.getContext();
            ReactSlider reactSlider = (ReactSlider) seekBar;
            reactSlider.isSliding(false);
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSlidingCompleteEvent(seekBar.getId(), reactSlider.toRealProgress(seekBar.getProgress())));
            ((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactSliderEvent(seekBar.getId(), reactSlider.toRealProgress(seekBar.getProgress()), !reactSlider.isSliding()));
        }
    };

    public String getName() {
        return ReactSliderManagerImpl.REACT_CLASS;
    }

    static class ReactSliderShadowNode extends LayoutShadowNode implements YogaMeasureFunction {
        private int mHeight;
        private boolean mMeasured;
        private int mWidth;

        private ReactSliderShadowNode() {
            initMeasureFunction();
        }

        private void initMeasureFunction() {
            setMeasureFunction(this);
        }

        public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
            if (!this.mMeasured) {
                ReactSlider reactSlider = new ReactSlider(getThemedContext(), (AttributeSet) null);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                reactSlider.measure(makeMeasureSpec, makeMeasureSpec);
                this.mWidth = reactSlider.getMeasuredWidth();
                this.mHeight = reactSlider.getMeasuredHeight();
                this.mMeasured = true;
            }
            return YogaMeasureOutput.make(this.mWidth, this.mHeight);
        }
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ReactSliderShadowNode();
    }

    public Class getShadowNodeClass() {
        return ReactSliderShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public ReactSlider createViewInstance(ThemedReactContext themedReactContext) {
        return ReactSliderManagerImpl.createViewInstance(themedReactContext);
    }

    @ReactProp(defaultBoolean = false, name = "disabled")
    public void setDisabled(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setDisabled(reactSlider, z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "value")
    public void setValue(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setValue(reactSlider, (double) f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumValue")
    public void setMinimumValue(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setMinimumValue(reactSlider, f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "maximumValue")
    public void setMaximumValue(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setMaximumValue(reactSlider, f);
    }

    @ReactProp(name = "lowerLimit")
    public void setLowerLimit(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setLowerLimit(reactSlider, (double) f);
    }

    @ReactProp(name = "upperLimit")
    public void setUpperLimit(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setUpperLimit(reactSlider, (double) f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "step")
    public void setStep(ReactSlider reactSlider, float f) {
        ReactSliderManagerImpl.setStep(reactSlider, f);
    }

    @ReactProp(customType = "Color", name = "thumbTintColor")
    public void setThumbTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setThumbTintColor(reactSlider, num);
    }

    @ReactProp(customType = "Color", name = "minimumTrackTintColor")
    public void setMinimumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMinimumTrackTintColor(reactSlider, num);
    }

    @ReactProp(name = "thumbImage")
    public void setThumbImage(ReactSlider reactSlider, @Nullable ReadableMap readableMap) {
        ReactSliderManagerImpl.setThumbImage(reactSlider, readableMap);
    }

    @ReactProp(customType = "Color", name = "maximumTrackTintColor")
    public void setMaximumTrackTintColor(ReactSlider reactSlider, Integer num) {
        ReactSliderManagerImpl.setMaximumTrackTintColor(reactSlider, num);
    }

    @ReactProp(defaultBoolean = false, name = "inverted")
    public void setInverted(ReactSlider reactSlider, boolean z) {
        ReactSliderManagerImpl.setInverted(reactSlider, z);
    }

    @ReactProp(name = "accessibilityUnits")
    public void setAccessibilityUnits(ReactSlider reactSlider, String str) {
        ReactSliderManagerImpl.setAccessibilityUnits(reactSlider, str);
    }

    @ReactProp(name = "accessibilityIncrements")
    public void setAccessibilityIncrements(ReactSlider reactSlider, ReadableArray readableArray) {
        ReactSliderManagerImpl.setAccessibilityIncrements(reactSlider, readableArray);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, ReactSlider reactSlider) {
        reactSlider.setOnSeekBarChangeListener(ON_CHANGE_LISTENER);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return ReactSliderManagerImpl.getExportedCustomDirectEventTypeConstants();
    }
}
