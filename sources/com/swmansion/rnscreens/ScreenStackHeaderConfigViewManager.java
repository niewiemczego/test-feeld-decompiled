package com.swmansion.rnscreens;

import android.util.Log;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackHeaderConfigManagerInterface;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import java.util.Map;
import javax.annotation.Nonnull;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b2\b\u0007\u0018\u0000 M2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001MB\u0005¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014J\u0016\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0014J\u0012\u0010\u001e\u001a\u00020\b2\b\b\u0001\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u001cH\u0017J\u001c\u0010%\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010'\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010(\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\rH\u0016J\u001a\u0010)\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u001cH\u0016J\u001f\u0010*\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010+\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u0010,J\u001f\u0010-\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010.\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u0010,J\u001a\u0010/\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u00100\u001a\u0004\u0018\u00010\u0016H\u0017J\u001a\u00101\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u001cH\u0016J\u0018\u00102\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u001cH\u0017J\u0018\u00104\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u001cH\u0017J\u0018\u00106\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u00107\u001a\u00020\u001cH\u0017J\u001a\u00108\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u001cH\u0016J!\u00109\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010,J!\u0010:\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010,J\u001c\u0010;\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010<\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\rH\u0016J\u001c\u0010=\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010>\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\u001cH\u0016J\u001a\u0010?\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010@\u001a\u0004\u0018\u00010\u0016H\u0017J\u001f\u0010A\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010B\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0002\u0010,J\u001a\u0010C\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010\u0016H\u0017J\u0018\u0010E\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010F\u001a\u00020\rH\u0017J\u001a\u0010G\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\b\u0010H\u001a\u0004\u0018\u00010\u0016H\u0017J\u0018\u0010I\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u001cH\u0017J\u0018\u0010K\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u001cH\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfigViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "Lcom/facebook/react/viewmanagers/RNSScreenStackHeaderConfigManagerInterface;", "()V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "addView", "", "parent", "child", "Landroid/view/View;", "index", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "getChildCount", "getDelegate", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "logNotAvailable", "propName", "needsCustomLayoutForChildren", "", "onAfterUpdateTransaction", "onDropViewInstance", "view", "removeAllViews", "removeViewAt", "setBackButtonInCustomView", "config", "backButtonInCustomView", "setBackTitle", "value", "setBackTitleFontFamily", "setBackTitleFontSize", "setBackTitleVisible", "setBackgroundColor", "backgroundColor", "(Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;Ljava/lang/Integer;)V", "setColor", "color", "setDirection", "direction", "setDisableBackButtonMenu", "setHidden", "hidden", "setHideBackButton", "hideBackButton", "setHideShadow", "hideShadow", "setLargeTitle", "setLargeTitleBackgroundColor", "setLargeTitleColor", "setLargeTitleFontFamily", "setLargeTitleFontSize", "setLargeTitleFontWeight", "setLargeTitleHideShadow", "setTitle", "title", "setTitleColor", "titleColor", "setTitleFontFamily", "titleFontFamily", "setTitleFontSize", "titleFontSize", "setTitleFontWeight", "titleFontWeight", "setTopInsetEnabled", "topInsetEnabled", "setTranslucent", "translucent", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNSScreenStackHeaderConfig")
/* compiled from: ScreenStackHeaderConfigViewManager.kt */
public final class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> implements RNSScreenStackHeaderConfigManagerInterface<ScreenStackHeaderConfig> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";
    private final ViewManagerDelegate<ScreenStackHeaderConfig> delegate = new RNSScreenStackHeaderConfigManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    /* access modifiers changed from: protected */
    public ScreenStackHeaderConfig createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        return new ScreenStackHeaderConfig(themedReactContext);
    }

    public void addView(ScreenStackHeaderConfig screenStackHeaderConfig, View view, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        Intrinsics.checkNotNullParameter(view, "child");
        if (view instanceof ScreenStackHeaderSubview) {
            screenStackHeaderConfig.addConfigSubview((ScreenStackHeaderSubview) view, i);
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    public void onDropViewInstance(@Nonnull ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, ViewHierarchyConstants.VIEW_KEY);
        screenStackHeaderConfig.destroy();
    }

    public void removeAllViews(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.removeAllConfigSubviews();
    }

    public void removeViewAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        screenStackHeaderConfig.removeConfigSubview(i);
    }

    public int getChildCount(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.getConfigSubviewsCount();
    }

    public View getChildAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        return screenStackHeaderConfig.getConfigSubview(i);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ScreenStackHeaderConfig screenStackHeaderConfig) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "parent");
        super.onAfterUpdateTransaction(screenStackHeaderConfig);
        screenStackHeaderConfig.onUpdate();
    }

    @ReactProp(name = "title")
    public void setTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitle(str);
    }

    @ReactProp(name = "titleFontFamily")
    public void setTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontFamily(str);
    }

    @ReactProp(name = "titleFontSize")
    public void setTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontSize((float) i);
    }

    @ReactProp(name = "titleFontWeight")
    public void setTitleFontWeight(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTitleFontWeight(str);
    }

    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        if (num != null) {
            screenStackHeaderConfig.setTitleColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackgroundColor(num);
    }

    @ReactProp(name = "hideShadow")
    public void setHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideShadow(z);
    }

    @ReactProp(name = "hideBackButton")
    public void setHideBackButton(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHideBackButton(z);
    }

    @ReactProp(name = "topInsetEnabled")
    public void setTopInsetEnabled(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTopInsetEnabled(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTintColor(num != null ? num.intValue() : 0);
    }

    @ReactProp(name = "hidden")
    public void setHidden(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setHidden(z);
    }

    @ReactProp(name = "translucent")
    public void setTranslucent(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setTranslucent(z);
    }

    @ReactProp(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setBackButtonInCustomView(z);
    }

    @ReactProp(name = "direction")
    public void setDirection(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        Intrinsics.checkNotNullParameter(screenStackHeaderConfig, "config");
        screenStackHeaderConfig.setDirection(str);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of(HeaderAttachedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onAttached"), HeaderDetachedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onDetached"));
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ScreenStackHeaderConfig> getDelegate() {
        return this.delegate;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/ScreenStackHeaderConfigViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenStackHeaderConfigViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void logNotAvailable(String str) {
        Log.w("RN SCREENS", str + " prop is not available on Android");
    }

    public void setBackTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("backTitle");
    }

    public void setBackTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("backTitleFontFamily");
    }

    public void setBackTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        logNotAvailable("backTitleFontSize");
    }

    public void setBackTitleVisible(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("backTitleVisible");
    }

    public void setLargeTitle(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("largeTitle");
    }

    public void setLargeTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("largeTitleFontFamily");
    }

    public void setLargeTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        logNotAvailable("largeTitleFontSize");
    }

    public void setLargeTitleFontWeight(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        logNotAvailable("largeTitleFontWeight");
    }

    public void setLargeTitleBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        logNotAvailable("largeTitleBackgroundColor");
    }

    public void setLargeTitleHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("largeTitleHideShadow");
    }

    public void setLargeTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        logNotAvailable("largeTitleColor");
    }

    public void setDisableBackButtonMenu(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        logNotAvailable("disableBackButtonMenu");
    }
}
