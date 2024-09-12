package com.facebook.react.views.modal;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.ModalHostViewManagerDelegate;
import com.facebook.react.viewmanagers.ModalHostViewManagerInterface;
import com.facebook.react.views.modal.ReactModalHostView;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "RCTModalHostView")
public class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> implements ModalHostViewManagerInterface<ReactModalHostView> {
    public static final String REACT_CLASS = "RCTModalHostView";
    private final ViewManagerDelegate<ReactModalHostView> mDelegate = new ModalHostViewManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "animated")
    public void setAnimated(ReactModalHostView reactModalHostView, boolean z) {
    }

    @ReactProp(name = "identifier")
    public void setIdentifier(ReactModalHostView reactModalHostView, int i) {
    }

    @ReactProp(name = "presentationStyle")
    public void setPresentationStyle(ReactModalHostView reactModalHostView, String str) {
    }

    @ReactProp(name = "supportedOrientations")
    public void setSupportedOrientations(ReactModalHostView reactModalHostView, ReadableArray readableArray) {
    }

    @ReactProp(name = "visible")
    public void setVisible(ReactModalHostView reactModalHostView, boolean z) {
    }

    /* access modifiers changed from: protected */
    public ReactModalHostView createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactModalHostView(themedReactContext);
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new ModalHostShadowNode();
    }

    public Class<? extends LayoutShadowNode> getShadowNodeClass() {
        return ModalHostShadowNode.class;
    }

    public void onDropViewInstance(ReactModalHostView reactModalHostView) {
        super.onDropViewInstance(reactModalHostView);
        reactModalHostView.onDropInstance();
    }

    @ReactProp(name = "animationType")
    public void setAnimationType(ReactModalHostView reactModalHostView, String str) {
        if (str != null) {
            reactModalHostView.setAnimationType(str);
        }
    }

    @ReactProp(name = "transparent")
    public void setTransparent(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.setTransparent(z);
    }

    @ReactProp(name = "statusBarTranslucent")
    public void setStatusBarTranslucent(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.setStatusBarTranslucent(z);
    }

    @ReactProp(name = "hardwareAccelerated")
    public void setHardwareAccelerated(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.setHardwareAccelerated(z);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(final ThemedReactContext themedReactContext, final ReactModalHostView reactModalHostView) {
        final EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(themedReactContext, reactModalHostView.getId());
        if (eventDispatcherForReactTag != null) {
            reactModalHostView.setOnRequestCloseListener(new ReactModalHostView.OnRequestCloseListener() {
                public void onRequestClose(DialogInterface dialogInterface) {
                    eventDispatcherForReactTag.dispatchEvent(new RequestCloseEvent(UIManagerHelper.getSurfaceId((Context) themedReactContext), reactModalHostView.getId()));
                }
            });
            reactModalHostView.setOnShowListener(new DialogInterface.OnShowListener() {
                public void onShow(DialogInterface dialogInterface) {
                    eventDispatcherForReactTag.dispatchEvent(new ShowEvent(UIManagerHelper.getSurfaceId((Context) themedReactContext), reactModalHostView.getId()));
                }
            });
            reactModalHostView.setEventDispatcher(eventDispatcherForReactTag);
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = new HashMap<>();
        }
        exportedCustomDirectEventTypeConstants.putAll(MapBuilder.builder().put(RequestCloseEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRequestClose")).put(ShowEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShow")).put("topDismiss", MapBuilder.of("registrationName", "onDismiss")).put("topOrientationChange", MapBuilder.of("registrationName", "onOrientationChange")).build());
        return exportedCustomDirectEventTypeConstants;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ReactModalHostView reactModalHostView) {
        super.onAfterUpdateTransaction(reactModalHostView);
        reactModalHostView.showOrUpdate();
    }

    public Object updateState(ReactModalHostView reactModalHostView, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        reactModalHostView.getFabricViewStateManager().setStateWrapper(stateWrapper);
        Point modalHostSize = ModalHostHelper.getModalHostSize(reactModalHostView.getContext());
        reactModalHostView.updateState(modalHostSize.x, modalHostSize.y);
        return null;
    }

    public ViewManagerDelegate<ReactModalHostView> getDelegate() {
        return this.mDelegate;
    }
}
