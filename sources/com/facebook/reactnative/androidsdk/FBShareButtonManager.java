package com.facebook.reactnative.androidsdk;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.share.model.ShareContent;
import com.facebook.share.widget.ShareButton;

public class FBShareButtonManager extends SimpleViewManager<ShareButton> {
    public static final String REACT_CLASS = "RCTFBShareButton";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public ShareButton createViewInstance(ThemedReactContext themedReactContext) {
        return new ShareButton(themedReactContext);
    }

    @ReactProp(name = "shareContent")
    public void setShareContent(ShareButton shareButton, ReadableMap readableMap) {
        ShareContent buildShareContent = Utility.buildShareContent(readableMap);
        if (buildShareContent != null) {
            shareButton.setShareContent(buildShareContent);
        }
    }
}
