package com.facebook.react.animated;

import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.common.ViewUtil;
import java.util.HashMap;
import java.util.Map;

class PropsAnimatedNode extends AnimatedNode {
    private int mConnectedViewTag = -1;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;
    private final JavaOnlyMap mPropMap;
    private final Map<String, Integer> mPropNodeMapping;
    private UIManager mUIManager;

    PropsAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        ReadableMap map = readableMap.getMap("props");
        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
        this.mPropNodeMapping = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            this.mPropNodeMapping.put(nextKey, Integer.valueOf(map.getInt(nextKey)));
        }
        this.mPropMap = new JavaOnlyMap();
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
    }

    public void connectToView(int i, UIManager uIManager) {
        if (this.mConnectedViewTag == -1) {
            this.mConnectedViewTag = i;
            this.mUIManager = uIManager;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node " + this.mTag + " is already attached to a view: " + this.mConnectedViewTag);
    }

    public void disconnectFromView(int i) {
        int i2 = this.mConnectedViewTag;
        if (i2 == i || i2 == -1) {
            this.mConnectedViewTag = -1;
            return;
        }
        throw new JSApplicationIllegalArgumentException("Attempting to disconnect view that has not been connected with the given animated node: " + i + " but is connected to view " + this.mConnectedViewTag);
    }

    public void restoreDefaultValues() {
        int i = this.mConnectedViewTag;
        if (i != -1 && ViewUtil.getUIManagerType(i) != 2) {
            ReadableMapKeySetIterator keySetIterator = this.mPropMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                this.mPropMap.putNull(keySetIterator.nextKey());
            }
            this.mUIManager.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mPropMap);
        }
    }

    public final void updateView() {
        if (this.mConnectedViewTag != -1) {
            for (Map.Entry next : this.mPropNodeMapping.entrySet()) {
                AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(((Integer) next.getValue()).intValue());
                if (nodeById == null) {
                    throw new IllegalArgumentException("Mapped property node does not exists");
                } else if (nodeById instanceof StyleAnimatedNode) {
                    ((StyleAnimatedNode) nodeById).collectViewUpdates(this.mPropMap);
                } else if (nodeById instanceof ValueAnimatedNode) {
                    ValueAnimatedNode valueAnimatedNode = (ValueAnimatedNode) nodeById;
                    Object animatedObject = valueAnimatedNode.getAnimatedObject();
                    if (animatedObject instanceof String) {
                        this.mPropMap.putString((String) next.getKey(), (String) animatedObject);
                    } else {
                        this.mPropMap.putDouble((String) next.getKey(), valueAnimatedNode.getValue());
                    }
                } else if (nodeById instanceof ColorAnimatedNode) {
                    this.mPropMap.putInt((String) next.getKey(), ((ColorAnimatedNode) nodeById).getColor());
                } else {
                    throw new IllegalArgumentException("Unsupported type of node used in property node " + nodeById.getClass());
                }
            }
            this.mUIManager.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mPropMap);
        }
    }

    public View getConnectedView() {
        try {
            return this.mUIManager.resolveView(this.mConnectedViewTag);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }

    public String prettyPrint() {
        StringBuilder append = new StringBuilder().append("PropsAnimatedNode[").append(this.mTag).append("] connectedViewTag: ").append(this.mConnectedViewTag).append(" mPropNodeMapping: ");
        Map<String, Integer> map = this.mPropNodeMapping;
        String str = "null";
        StringBuilder append2 = append.append(map != null ? map.toString() : str).append(" mPropMap: ");
        JavaOnlyMap javaOnlyMap = this.mPropMap;
        if (javaOnlyMap != null) {
            str = javaOnlyMap.toString();
        }
        return append2.append(str).toString();
    }
}
