package com.facebook.react.viewmanagers;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

public interface RNSVGMarkerManagerInterface<T extends View> {
    void setAlign(T t, String str);

    void setClipPath(T t, String str);

    void setClipRule(T t, int i);

    void setDisplay(T t, String str);

    void setFill(T t, ReadableMap readableMap);

    void setFillOpacity(T t, float f);

    void setFillRule(T t, int i);

    void setFont(T t, ReadableMap readableMap);

    void setFontSize(T t, Double d);

    void setFontSize(T t, String str);

    void setFontWeight(T t, Double d);

    void setFontWeight(T t, String str);

    void setMarkerEnd(T t, String str);

    void setMarkerHeight(T t, Double d);

    void setMarkerHeight(T t, String str);

    void setMarkerMid(T t, String str);

    void setMarkerStart(T t, String str);

    void setMarkerUnits(T t, String str);

    void setMarkerWidth(T t, Double d);

    void setMarkerWidth(T t, String str);

    void setMask(T t, String str);

    void setMatrix(T t, ReadableArray readableArray);

    void setMeetOrSlice(T t, int i);

    void setMinX(T t, float f);

    void setMinY(T t, float f);

    void setName(T t, String str);

    void setOpacity(T t, float f);

    void setOrient(T t, String str);

    void setPointerEvents(T t, String str);

    void setPropList(T t, ReadableArray readableArray);

    void setRefX(T t, Double d);

    void setRefX(T t, String str);

    void setRefY(T t, Double d);

    void setRefY(T t, String str);

    void setResponsible(T t, boolean z);

    void setStroke(T t, ReadableMap readableMap);

    void setStrokeDasharray(T t, ReadableArray readableArray);

    void setStrokeDashoffset(T t, float f);

    void setStrokeLinecap(T t, int i);

    void setStrokeLinejoin(T t, int i);

    void setStrokeMiterlimit(T t, float f);

    void setStrokeOpacity(T t, float f);

    void setStrokeWidth(T t, Double d);

    void setStrokeWidth(T t, String str);

    void setVbHeight(T t, float f);

    void setVbWidth(T t, float f);

    void setVectorEffect(T t, int i);
}