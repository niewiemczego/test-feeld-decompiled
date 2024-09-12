package com.facebook.react.animated;

import android.util.SparseArray;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import io.sentry.protocol.SentryStackTrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class NativeAnimatedNodesManager implements EventDispatcherListener {
    private static final String TAG = "NativeAnimatedNodesManager";
    private final SparseArray<AnimationDriver> mActiveAnimations = new SparseArray<>();
    private int mAnimatedGraphBFSColor = 0;
    private final SparseArray<AnimatedNode> mAnimatedNodes = new SparseArray<>();
    private final List<EventAnimationDriver> mEventDrivers = new ArrayList();
    private boolean mEventListenerInitializedForFabric = false;
    private boolean mEventListenerInitializedForNonFabric = false;
    private final ReactApplicationContext mReactApplicationContext;
    private final List<AnimatedNode> mRunUpdateNodeList = new LinkedList();
    private final SparseArray<AnimatedNode> mUpdatedNodes = new SparseArray<>();
    private boolean mWarnedAboutGraphTraversal = false;

    public NativeAnimatedNodesManager(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    public void initializeEventListenerForUIManagerType(int i) {
        if (i == 2) {
            if (this.mEventListenerInitializedForFabric) {
                return;
            }
        } else if (this.mEventListenerInitializedForNonFabric) {
            return;
        }
        UIManager uIManager = UIManagerHelper.getUIManager(this.mReactApplicationContext, i);
        if (uIManager != null) {
            ((EventDispatcher) uIManager.getEventDispatcher()).addListener(this);
            if (i == 2) {
                this.mEventListenerInitializedForFabric = true;
            } else {
                this.mEventListenerInitializedForNonFabric = true;
            }
        }
    }

    public AnimatedNode getNodeById(int i) {
        return this.mAnimatedNodes.get(i);
    }

    public boolean hasActiveAnimations() {
        return this.mActiveAnimations.size() > 0 || this.mUpdatedNodes.size() > 0;
    }

    public void createAnimatedNode(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode;
        if (this.mAnimatedNodes.get(i) == null) {
            String string = readableMap.getString("type");
            if ("style".equals(string)) {
                animatedNode = new StyleAnimatedNode(readableMap, this);
            } else if ("value".equals(string)) {
                animatedNode = new ValueAnimatedNode(readableMap);
            } else if ("color".equals(string)) {
                animatedNode = new ColorAnimatedNode(readableMap, this, this.mReactApplicationContext);
            } else if ("props".equals(string)) {
                animatedNode = new PropsAnimatedNode(readableMap, this);
            } else if ("interpolation".equals(string)) {
                animatedNode = new InterpolationAnimatedNode(readableMap);
            } else if ("addition".equals(string)) {
                animatedNode = new AdditionAnimatedNode(readableMap, this);
            } else if ("subtraction".equals(string)) {
                animatedNode = new SubtractionAnimatedNode(readableMap, this);
            } else if ("division".equals(string)) {
                animatedNode = new DivisionAnimatedNode(readableMap, this);
            } else if ("multiplication".equals(string)) {
                animatedNode = new MultiplicationAnimatedNode(readableMap, this);
            } else if ("modulus".equals(string)) {
                animatedNode = new ModulusAnimatedNode(readableMap, this);
            } else if ("diffclamp".equals(string)) {
                animatedNode = new DiffClampAnimatedNode(readableMap, this);
            } else if (ViewProps.TRANSFORM.equals(string)) {
                animatedNode = new TransformAnimatedNode(readableMap, this);
            } else if ("tracking".equals(string)) {
                animatedNode = new TrackingAnimatedNode(readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            animatedNode.mTag = i;
            this.mAnimatedNodes.put(i, animatedNode);
            this.mUpdatedNodes.put(i, animatedNode);
            return;
        }
        throw new JSApplicationIllegalArgumentException("createAnimatedNode: Animated node [" + i + "] already exists");
    }

    public void updateAnimatedNodeConfig(int i, ReadableMap readableMap) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("updateAnimatedNode: Animated node [" + i + "] does not exist");
        } else if (animatedNode instanceof AnimatedNodeWithUpdateableConfig) {
            stopAnimationsForNode(animatedNode);
            ((AnimatedNodeWithUpdateableConfig) animatedNode).onUpdateConfig(readableMap);
            this.mUpdatedNodes.put(i, animatedNode);
        }
    }

    public void dropAnimatedNode(int i) {
        this.mAnimatedNodes.remove(i);
        this.mUpdatedNodes.remove(i);
    }

    public void startListeningToAnimatedNodeValue(int i, AnimatedNodeValueListener animatedNodeValueListener) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener(animatedNodeValueListener);
    }

    public void stopListeningToAnimatedNodeValue(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("startListeningToAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).setValueListener((AnimatedNodeValueListener) null);
    }

    public void setAnimatedNodeValue(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeValue: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        stopAnimationsForNode(animatedNode);
        ((ValueAnimatedNode) animatedNode).mValue = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void setAnimatedNodeOffset(int i, double d) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("setAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).mOffset = d;
        this.mUpdatedNodes.put(i, animatedNode);
    }

    public void flattenAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("flattenAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).flattenOffset();
    }

    public void extractAnimatedNodeOffset(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("extractAnimatedNodeOffset: Animated node [" + i + "] does not exist, or is not a 'value' node");
        }
        ((ValueAnimatedNode) animatedNode).extractOffset();
    }

    public void startAnimatingNode(int i, int i2, ReadableMap readableMap, Callback callback) {
        AnimationDriver animationDriver;
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] does not exist");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            AnimationDriver animationDriver2 = this.mActiveAnimations.get(i);
            if (animationDriver2 != null) {
                animationDriver2.resetConfig(readableMap);
                return;
            }
            String string = readableMap.getString("type");
            if (SentryStackTrace.JsonKeys.FRAMES.equals(string)) {
                animationDriver = new FrameBasedAnimationDriver(readableMap);
            } else if ("spring".equals(string)) {
                animationDriver = new SpringAnimation(readableMap);
            } else if ("decay".equals(string)) {
                animationDriver = new DecayAnimation(readableMap);
            } else {
                throw new JSApplicationIllegalArgumentException("startAnimatingNode: Unsupported animation type [" + i2 + "]: " + string);
            }
            animationDriver.mId = i;
            animationDriver.mEndCallback = callback;
            animationDriver.mAnimatedValue = (ValueAnimatedNode) animatedNode;
            this.mActiveAnimations.put(i, animationDriver);
        } else {
            throw new JSApplicationIllegalArgumentException("startAnimatingNode: Animated node [" + i2 + "] should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    private void stopAnimationsForNode(AnimatedNode animatedNode) {
        int i = 0;
        while (i < this.mActiveAnimations.size()) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i);
            if (animatedNode.equals(valueAt.mAnimatedValue)) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                } else if (this.mReactApplicationContext != null) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putInt("animationId", valueAt.mId);
                    createMap2.putBoolean("finished", false);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onNativeAnimatedModuleAnimationFinished", createMap2);
                }
                this.mActiveAnimations.removeAt(i);
                i--;
            }
            i++;
        }
    }

    public void stopAnimation(int i) {
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            if (valueAt.mId == i) {
                if (valueAt.mEndCallback != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("finished", false);
                    valueAt.mEndCallback.invoke(createMap);
                } else if (this.mReactApplicationContext != null) {
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putInt("animationId", valueAt.mId);
                    createMap2.putBoolean("finished", false);
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onNativeAnimatedModuleAnimationFinished", createMap2);
                }
                this.mActiveAnimations.removeAt(i2);
                return;
            }
        }
    }

    public void connectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.addChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("connectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
    }

    public void disconnectAnimatedNodes(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            AnimatedNode animatedNode2 = this.mAnimatedNodes.get(i2);
            if (animatedNode2 != null) {
                animatedNode.removeChild(animatedNode2);
                this.mUpdatedNodes.put(i2, animatedNode2);
                return;
            }
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (child) [" + i2 + "] does not exist");
        }
        throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodes: Animated node with tag (parent) [" + i + "] does not exist");
    }

    public void connectAnimatedNodeToView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node with tag [" + i + "] does not exist");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ReactApplicationContext reactApplicationContext = this.mReactApplicationContext;
            if (reactApplicationContext != null) {
                UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i2);
                if (uIManagerForReactTag == null) {
                    ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("connectAnimatedNodeToView: Animated node could not be connected to UIManager - uiManager disappeared for tag: " + i2));
                    return;
                }
                ((PropsAnimatedNode) animatedNode).connectToView(i2, uIManagerForReactTag);
                this.mUpdatedNodes.put(i, animatedNode);
                return;
            }
            throw new IllegalStateException("connectAnimatedNodeToView: Animated node could not be connected, no ReactApplicationContext: " + i2);
        } else {
            throw new JSApplicationIllegalArgumentException("connectAnimatedNodeToView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void disconnectAnimatedNodeFromView(int i, int i2) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node with tag [" + i + "] does not exist");
        } else if (animatedNode instanceof PropsAnimatedNode) {
            ((PropsAnimatedNode) animatedNode).disconnectFromView(i2);
        } else {
            throw new JSApplicationIllegalArgumentException("disconnectAnimatedNodeFromView: Animated node connected to view [" + i2 + "] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void getValue(int i, Callback callback) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode == null || !(animatedNode instanceof ValueAnimatedNode)) {
            throw new JSApplicationIllegalArgumentException("getValue: Animated node with tag [" + i + "] does not exist or is not a 'value' node");
        }
        double value = ((ValueAnimatedNode) animatedNode).getValue();
        if (callback != null) {
            callback.invoke(Double.valueOf(value));
        } else if (this.mReactApplicationContext != null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("tag", i);
            createMap.putDouble("value", value);
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onNativeAnimatedModuleGetValue", createMap);
        }
    }

    public void restoreDefaultValues(int i) {
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i);
        if (animatedNode != null) {
            if (animatedNode instanceof PropsAnimatedNode) {
                ((PropsAnimatedNode) animatedNode).restoreDefaultValues();
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view [?] should be of type " + PropsAnimatedNode.class.getName());
        }
    }

    public void addAnimatedEventToView(int i, String str, ReadableMap readableMap) {
        int i2 = readableMap.getInt("animatedValueTag");
        AnimatedNode animatedNode = this.mAnimatedNodes.get(i2);
        if (animatedNode == null) {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node with tag [" + i2 + "] does not exist");
        } else if (animatedNode instanceof ValueAnimatedNode) {
            ReadableArray array = readableMap.getArray("nativeEventPath");
            ArrayList arrayList = new ArrayList(array.size());
            for (int i3 = 0; i3 < array.size(); i3++) {
                arrayList.add(array.getString(i3));
            }
            this.mEventDrivers.add(new EventAnimationDriver(normalizeEventName(str), i, arrayList, (ValueAnimatedNode) animatedNode));
        } else {
            throw new JSApplicationIllegalArgumentException("addAnimatedEventToView: Animated node on view [" + i + "] connected to event handler (" + str + ") should be of type " + ValueAnimatedNode.class.getName());
        }
    }

    public void removeAnimatedEventFromView(int i, String str, int i2) {
        String normalizeEventName = normalizeEventName(str);
        ListIterator<EventAnimationDriver> listIterator = this.mEventDrivers.listIterator();
        while (listIterator.hasNext()) {
            EventAnimationDriver next = listIterator.next();
            if (normalizeEventName.equals(next.mEventName) && i == next.mViewTag && i2 == next.mValueNode.mTag) {
                listIterator.remove();
                return;
            }
        }
    }

    public void onEventDispatch(final Event event) {
        if (UiThreadUtil.isOnUiThread()) {
            handleEvent(event);
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    NativeAnimatedNodesManager.this.handleEvent(event);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void handleEvent(Event event) {
        ReactApplicationContext reactApplicationContext;
        if (!this.mEventDrivers.isEmpty() && (reactApplicationContext = this.mReactApplicationContext) != null && UIManagerHelper.getUIManager(reactApplicationContext, event.getUIManagerType()) != null) {
            boolean z = false;
            Event.EventAnimationDriverMatchSpec eventAnimationDriverMatchSpec = event.getEventAnimationDriverMatchSpec();
            for (EventAnimationDriver next : this.mEventDrivers) {
                if (eventAnimationDriverMatchSpec.match(next.mViewTag, next.mEventName)) {
                    z = true;
                    stopAnimationsForNode(next.mValueNode);
                    event.dispatch(next);
                    this.mRunUpdateNodeList.add(next.mValueNode);
                }
            }
            if (z) {
                updateNodes(this.mRunUpdateNodeList);
                this.mRunUpdateNodeList.clear();
            }
        }
    }

    public void runUpdates(long j) {
        UiThreadUtil.assertOnUiThread();
        for (int i = 0; i < this.mUpdatedNodes.size(); i++) {
            this.mRunUpdateNodeList.add(this.mUpdatedNodes.valueAt(i));
        }
        this.mUpdatedNodes.clear();
        boolean z = false;
        for (int i2 = 0; i2 < this.mActiveAnimations.size(); i2++) {
            AnimationDriver valueAt = this.mActiveAnimations.valueAt(i2);
            valueAt.runAnimationStep(j);
            this.mRunUpdateNodeList.add(valueAt.mAnimatedValue);
            if (valueAt.mHasFinished) {
                z = true;
            }
        }
        updateNodes(this.mRunUpdateNodeList);
        this.mRunUpdateNodeList.clear();
        if (z) {
            for (int size = this.mActiveAnimations.size() - 1; size >= 0; size--) {
                AnimationDriver valueAt2 = this.mActiveAnimations.valueAt(size);
                if (valueAt2.mHasFinished) {
                    if (valueAt2.mEndCallback != null) {
                        WritableMap createMap = Arguments.createMap();
                        createMap.putBoolean("finished", true);
                        valueAt2.mEndCallback.invoke(createMap);
                    } else if (this.mReactApplicationContext != null) {
                        WritableMap createMap2 = Arguments.createMap();
                        createMap2.putInt("animationId", valueAt2.mId);
                        createMap2.putBoolean("finished", true);
                        DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
                        if (rCTDeviceEventEmitter != null) {
                            rCTDeviceEventEmitter.emit("onNativeAnimatedModuleAnimationFinished", createMap2);
                        }
                    }
                    this.mActiveAnimations.removeAt(size);
                }
            }
        }
    }

    private void updateNodes(List<AnimatedNode> list) {
        int i;
        int i2 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i2;
        if (i2 == 0) {
            this.mAnimatedGraphBFSColor = i2 + 1;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i3 = 0;
        for (AnimatedNode next : list) {
            int i4 = next.mBFSColor;
            int i5 = this.mAnimatedGraphBFSColor;
            if (i4 != i5) {
                next.mBFSColor = i5;
                i3++;
                arrayDeque.add(next);
            }
        }
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode = (AnimatedNode) arrayDeque.poll();
            if (animatedNode.mChildren != null) {
                for (int i6 = 0; i6 < animatedNode.mChildren.size(); i6++) {
                    AnimatedNode animatedNode2 = animatedNode.mChildren.get(i6);
                    animatedNode2.mActiveIncomingNodes++;
                    int i7 = animatedNode2.mBFSColor;
                    int i8 = this.mAnimatedGraphBFSColor;
                    if (i7 != i8) {
                        animatedNode2.mBFSColor = i8;
                        i3++;
                        arrayDeque.add(animatedNode2);
                    }
                }
            }
        }
        int i9 = this.mAnimatedGraphBFSColor + 1;
        this.mAnimatedGraphBFSColor = i9;
        if (i9 == 0) {
            this.mAnimatedGraphBFSColor = i9 + 1;
        }
        int i10 = 0;
        for (AnimatedNode next2 : list) {
            if (next2.mActiveIncomingNodes == 0 && next2.mBFSColor != (i = this.mAnimatedGraphBFSColor)) {
                next2.mBFSColor = i;
                i10++;
                arrayDeque.add(next2);
            }
        }
        int i11 = 0;
        while (!arrayDeque.isEmpty()) {
            AnimatedNode animatedNode3 = (AnimatedNode) arrayDeque.poll();
            try {
                animatedNode3.update();
                if (animatedNode3 instanceof PropsAnimatedNode) {
                    ((PropsAnimatedNode) animatedNode3).updateView();
                }
            } catch (JSApplicationCausedNativeException e) {
                FLog.e(TAG, "Native animation workaround, frame lost as result of race condition", (Throwable) e);
            }
            if (animatedNode3 instanceof ValueAnimatedNode) {
                ((ValueAnimatedNode) animatedNode3).onValueUpdate();
            }
            if (animatedNode3.mChildren != null) {
                for (int i12 = 0; i12 < animatedNode3.mChildren.size(); i12++) {
                    AnimatedNode animatedNode4 = animatedNode3.mChildren.get(i12);
                    animatedNode4.mActiveIncomingNodes--;
                    if (animatedNode4.mBFSColor != this.mAnimatedGraphBFSColor && animatedNode4.mActiveIncomingNodes == 0) {
                        animatedNode4.mBFSColor = this.mAnimatedGraphBFSColor;
                        i10++;
                        arrayDeque.add(animatedNode4);
                    } else if (animatedNode4.mBFSColor == this.mAnimatedGraphBFSColor) {
                        i11++;
                    }
                }
            }
        }
        if (i3 == i10) {
            this.mWarnedAboutGraphTraversal = false;
        } else if (!this.mWarnedAboutGraphTraversal) {
            this.mWarnedAboutGraphTraversal = true;
            FLog.e(TAG, "Detected animation cycle or disconnected graph. ");
            for (AnimatedNode prettyPrintWithChildren : list) {
                FLog.e(TAG, prettyPrintWithChildren.prettyPrintWithChildren());
            }
            IllegalStateException illegalStateException = new IllegalStateException("Looks like animated nodes graph has " + (i11 > 0 ? "cycles (" + i11 + ")" : "disconnected regions") + ", there are " + i3 + " but toposort visited only " + i10);
            boolean z = this.mEventListenerInitializedForFabric;
            if (z && i11 == 0) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else if (z) {
                ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException((Throwable) illegalStateException));
            } else {
                throw illegalStateException;
            }
        }
    }

    private String normalizeEventName(String str) {
        return str.startsWith("on") ? "top" + str.substring(2) : str;
    }
}
