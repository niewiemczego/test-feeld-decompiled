package com.facebook.react.views.scroll;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.views.view.ReactClippingViewManager;

@ReactModule(name = "AndroidHorizontalScrollContentView")
public class ReactHorizontalScrollContainerViewManager extends ReactClippingViewManager<ReactHorizontalScrollContainerView> {
    public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

    public String getName() {
        return REACT_CLASS;
    }

    public ReactHorizontalScrollContainerView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactHorizontalScrollContainerView(themedReactContext);
    }
}
