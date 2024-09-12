package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import com.facebook.react.R;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.ReactAccessibilityDelegate;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.yoga.YogaMeasureMode;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "RCTText")
public class ReactTextViewManager extends ReactTextAnchorViewManager<ReactTextView, ReactTextShadowNode> implements IViewManagerWithChildren {
    public static final String REACT_CLASS = "RCTText";
    private static final short TX_STATE_KEY_ATTRIBUTED_STRING = 0;
    private static final short TX_STATE_KEY_HASH = 2;
    private static final short TX_STATE_KEY_MOST_RECENT_EVENT_COUNT = 3;
    private static final short TX_STATE_KEY_PARAGRAPH_ATTRIBUTES = 1;
    protected ReactTextViewManagerCallback mReactTextViewManagerCallback;

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public ReactTextViewManager() {
        this((ReactTextViewManagerCallback) null);
    }

    public ReactTextViewManager(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        this.mReactTextViewManagerCallback = reactTextViewManagerCallback;
        setupViewRecycling();
    }

    /* access modifiers changed from: protected */
    public ReactTextView prepareToRecycleView(ThemedReactContext themedReactContext, ReactTextView reactTextView) {
        super.prepareToRecycleView(themedReactContext, reactTextView);
        reactTextView.recycleView();
        setSelectionColor(reactTextView, (Integer) null);
        return reactTextView;
    }

    public ReactTextView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactTextView(themedReactContext);
    }

    public void updateExtraData(ReactTextView reactTextView, Object obj) {
        ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
        Spannable text = reactTextUpdate.getText();
        if (reactTextUpdate.containsImages()) {
            TextInlineImageSpan.possiblyUpdateInlineImageSpans(text, reactTextView);
        }
        reactTextView.setText(reactTextUpdate);
        ReactClickableSpan[] reactClickableSpanArr = (ReactClickableSpan[]) text.getSpans(0, reactTextUpdate.getText().length(), ReactClickableSpan.class);
        if (reactClickableSpanArr.length > 0) {
            reactTextView.setTag(R.id.accessibility_links, new ReactAccessibilityDelegate.AccessibilityLinks(reactClickableSpanArr, text));
            ReactAccessibilityDelegate.resetDelegate(reactTextView, reactTextView.isFocusable(), reactTextView.getImportantForAccessibility());
        }
    }

    public ReactTextShadowNode createShadowNodeInstance() {
        return new ReactTextShadowNode(this.mReactTextViewManagerCallback);
    }

    public ReactTextShadowNode createShadowNodeInstance(ReactTextViewManagerCallback reactTextViewManagerCallback) {
        return new ReactTextShadowNode(reactTextViewManagerCallback);
    }

    public Class<ReactTextShadowNode> getShadowNodeClass() {
        return ReactTextShadowNode.class;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactTextView reactTextView) {
        super.onAfterUpdateTransaction(reactTextView);
        reactTextView.updateView();
    }

    public Object updateState(ReactTextView reactTextView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        ReadableMapBuffer stateDataMapBuffer = stateWrapper.getStateDataMapBuffer();
        if (stateDataMapBuffer != null) {
            return getReactTextUpdate(reactTextView, reactStylesDiffMap, stateDataMapBuffer);
        }
        ReadableNativeMap stateData = stateWrapper.getStateData();
        if (stateData == null) {
            return null;
        }
        ReadableNativeMap map = stateData.getMap("attributedString");
        ReadableNativeMap map2 = stateData.getMap("paragraphAttributes");
        Spannable orCreateSpannableForText = TextLayoutManager.getOrCreateSpannableForText(reactTextView.getContext(), map, this.mReactTextViewManagerCallback);
        reactTextView.setSpanned(orCreateSpannableForText);
        return new ReactTextUpdate(orCreateSpannableForText, stateData.hasKey("mostRecentEventCount") ? stateData.getInt("mostRecentEventCount") : -1, false, TextAttributeProps.getTextAlignment(reactStylesDiffMap, TextLayoutManager.isRTL(map), reactTextView.getGravityHorizontal()), TextAttributeProps.getTextBreakStrategy(map2.getString(ViewProps.TEXT_BREAK_STRATEGY)), TextAttributeProps.getJustificationMode(reactStylesDiffMap, Build.VERSION.SDK_INT < 26 ? 0 : reactTextView.getJustificationMode()));
    }

    private Object getReactTextUpdate(ReactTextView reactTextView, ReactStylesDiffMap reactStylesDiffMap, MapBuffer mapBuffer) {
        int i = 0;
        MapBuffer mapBuffer2 = mapBuffer.getMapBuffer(0);
        MapBuffer mapBuffer3 = mapBuffer.getMapBuffer(1);
        Spannable orCreateSpannableForText = TextLayoutManagerMapBuffer.getOrCreateSpannableForText(reactTextView.getContext(), mapBuffer2, this.mReactTextViewManagerCallback);
        reactTextView.setSpanned(orCreateSpannableForText);
        int textBreakStrategy = TextAttributeProps.getTextBreakStrategy(mapBuffer3.getString(2));
        if (Build.VERSION.SDK_INT >= 26) {
            i = reactTextView.getJustificationMode();
        }
        return new ReactTextUpdate(orCreateSpannableForText, -1, false, TextAttributeProps.getTextAlignment(reactStylesDiffMap, TextLayoutManagerMapBuffer.isRTL(mapBuffer2), reactTextView.getGravityHorizontal()), textBreakStrategy, TextAttributeProps.getJustificationMode(reactStylesDiffMap, i));
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.of("topTextLayout", MapBuilder.of("registrationName", "onTextLayout"), "topInlineViewLayout", MapBuilder.of("registrationName", "onInlineViewLayout")));
        return exportedCustomDirectEventTypeConstants;
    }

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return TextLayoutManager.measureText(context, readableMap, readableMap2, f, yogaMeasureMode, f2, yogaMeasureMode2, this.mReactTextViewManagerCallback, fArr);
    }

    public long measure(Context context, MapBuffer mapBuffer, MapBuffer mapBuffer2, MapBuffer mapBuffer3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2, float[] fArr) {
        return TextLayoutManagerMapBuffer.measureText(context, mapBuffer, mapBuffer2, f, yogaMeasureMode, f2, yogaMeasureMode2, this.mReactTextViewManagerCallback, fArr);
    }

    public void setPadding(ReactTextView reactTextView, int i, int i2, int i3, int i4) {
        reactTextView.setPadding(i, i2, i3, i4);
    }
}
