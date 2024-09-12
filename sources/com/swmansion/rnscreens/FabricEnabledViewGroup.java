package com.swmansion.rnscreens;

import android.view.ViewGroup;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.FabricViewStateManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "Landroid/view/ViewGroup;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "fabricViewStateManager", "Lcom/facebook/react/uimanager/FabricViewStateManager;", "getFabricViewStateManager", "()Lcom/facebook/react/uimanager/FabricViewStateManager;", "updateScreenSizeFabric", "", "width", "", "height", "headerHeight", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FabricEnabledViewGroup.kt */
public abstract class FabricEnabledViewGroup extends ViewGroup {
    /* access modifiers changed from: protected */
    public final void updateScreenSizeFabric(int i, int i2, double d) {
    }

    public FabricEnabledViewGroup(ReactContext reactContext) {
        super(reactContext);
    }

    public final FabricViewStateManager getFabricViewStateManager() {
        FabricViewStateManager fabricViewStateManager = null;
        return null;
    }
}
