package com.facebook.react.views.swiperefresh;

import android.view.View;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.facebook.hermes.intl.Constants;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerDelegate;
import com.facebook.react.viewmanagers.AndroidSwipeRefreshLayoutManagerInterface;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "AndroidSwipeRefreshLayout")
public class SwipeRefreshLayoutManager extends ViewGroupManager<ReactSwipeRefreshLayout> implements AndroidSwipeRefreshLayoutManagerInterface<ReactSwipeRefreshLayout> {
    public static final String REACT_CLASS = "AndroidSwipeRefreshLayout";
    private final ViewManagerDelegate<ReactSwipeRefreshLayout> mDelegate = new AndroidSwipeRefreshLayoutManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public ReactSwipeRefreshLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactSwipeRefreshLayout(themedReactContext);
    }

    @ReactProp(defaultBoolean = true, name = "enabled")
    public void setEnabled(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setEnabled(z);
    }

    @ReactProp(customType = "ColorArray", name = "colors")
    public void setColors(ReactSwipeRefreshLayout reactSwipeRefreshLayout, ReadableArray readableArray) {
        if (readableArray != null) {
            int[] iArr = new int[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                if (readableArray.getType(i) == ReadableType.Map) {
                    iArr[i] = ColorPropConverter.getColor(readableArray.getMap(i), reactSwipeRefreshLayout.getContext()).intValue();
                } else {
                    iArr[i] = readableArray.getInt(i);
                }
            }
            reactSwipeRefreshLayout.setColorSchemeColors(iArr);
            return;
        }
        reactSwipeRefreshLayout.setColorSchemeColors(new int[0]);
    }

    @ReactProp(customType = "Color", name = "progressBackgroundColor")
    public void setProgressBackgroundColor(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Integer num) {
        reactSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(num == null ? 0 : num.intValue());
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, int i) {
        reactSwipeRefreshLayout.setSize(i);
    }

    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str) {
        if (str == null || str.equals(Constants.COLLATION_DEFAULT)) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (str.equals("large")) {
            reactSwipeRefreshLayout.setSize(0);
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large', received: " + str);
        }
    }

    @ReactProp(name = "size")
    public void setSize(ReactSwipeRefreshLayout reactSwipeRefreshLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactSwipeRefreshLayout.setSize(1);
        } else if (dynamic.getType() == ReadableType.Number) {
            reactSwipeRefreshLayout.setSize(dynamic.asInt());
        } else if (dynamic.getType() == ReadableType.String) {
            setSize(reactSwipeRefreshLayout, dynamic.asString());
        } else {
            throw new IllegalArgumentException("Size must be 'default' or 'large'");
        }
    }

    @ReactProp(name = "refreshing")
    public void setRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        reactSwipeRefreshLayout.setRefreshing(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "progressViewOffset")
    public void setProgressViewOffset(ReactSwipeRefreshLayout reactSwipeRefreshLayout, float f) {
        reactSwipeRefreshLayout.setProgressViewOffset(f);
    }

    public void setNativeRefreshing(ReactSwipeRefreshLayout reactSwipeRefreshLayout, boolean z) {
        setRefreshing(reactSwipeRefreshLayout, z);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        reactSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactSwipeRefreshLayout.getId());
                if (eventDispatcherForReactTag != null) {
                    eventDispatcherForReactTag.dispatchEvent(new RefreshEvent(UIManagerHelper.getSurfaceId((View) reactSwipeRefreshLayout), reactSwipeRefreshLayout.getId()));
                }
            }
        });
    }

    public void receiveCommand(ReactSwipeRefreshLayout reactSwipeRefreshLayout, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeRefreshing") && readableArray != null) {
            setRefreshing(reactSwipeRefreshLayout, readableArray.getBoolean(0));
        }
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.of("SIZE", MapBuilder.of("DEFAULT", 1, "LARGE", 0));
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put("topRefresh", MapBuilder.of("registrationName", "onRefresh")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ReactSwipeRefreshLayout> getDelegate() {
        return this.mDelegate;
    }
}
