package com.facebook.react.uimanager;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;

public class FabricViewStateManager {
    private static final String TAG = "FabricViewStateManager";
    private StateWrapper mStateWrapper = null;

    public interface HasFabricViewStateManager {
        FabricViewStateManager getFabricViewStateManager();
    }

    public interface StateUpdateCallback {
        WritableMap getStateUpdate();
    }

    public void setStateWrapper(StateWrapper stateWrapper) {
        this.mStateWrapper = stateWrapper;
    }

    public boolean hasStateWrapper() {
        return this.mStateWrapper != null;
    }

    private void setState(StateWrapper stateWrapper, StateUpdateCallback stateUpdateCallback, int i) {
        WritableMap stateUpdate;
        if (stateWrapper == null) {
            FLog.e(TAG, "setState called without a StateWrapper");
        } else if (stateWrapper == this.mStateWrapper && i <= 60 && (stateUpdate = stateUpdateCallback.getStateUpdate()) != null) {
            stateWrapper.updateState(stateUpdate);
        }
    }

    public void setState(StateUpdateCallback stateUpdateCallback) {
        setState(this.mStateWrapper, stateUpdateCallback, 0);
    }

    public ReadableMap getStateData() {
        StateWrapper stateWrapper = this.mStateWrapper;
        if (stateWrapper != null) {
            return stateWrapper.getStateData();
        }
        return null;
    }
}
