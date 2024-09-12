package com.facebook.react.animated;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.GuardedFrameCallback;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.common.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

@ReactModule(name = "NativeAnimatedModule")
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, UIManagerListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean ANIMATED_MODULE_DEBUG = false;
    public static final String NAME = "NativeAnimatedModule";
    /* access modifiers changed from: private */
    public final GuardedFrameCallback mAnimatedFrameCallback;
    private boolean mBatchingControlledByJS = false;
    private volatile long mCurrentBatchNumber;
    private volatile long mCurrentFrameNumber;
    private boolean mInitializedForFabric = false;
    private boolean mInitializedForNonFabric = false;
    private final AtomicReference<NativeAnimatedNodesManager> mNodesManager = new AtomicReference<>();
    private int mNumFabricAnimations = 0;
    private int mNumNonFabricAnimations = 0;
    /* access modifiers changed from: private */
    public final ConcurrentOperationQueue mOperations = new ConcurrentOperationQueue();
    /* access modifiers changed from: private */
    public final ConcurrentOperationQueue mPreOperations = new ConcurrentOperationQueue();
    /* access modifiers changed from: private */
    public final ReactChoreographer mReactChoreographer = ReactChoreographer.getInstance();
    private int mUIManagerType = 1;

    public void addListener(String str) {
    }

    public String getName() {
        return NAME;
    }

    public void removeListeners(double d) {
    }

    private enum BatchExecutionOpCodes {
        OP_CODE_CREATE_ANIMATED_NODE(1),
        OP_CODE_UPDATE_ANIMATED_NODE_CONFIG(2),
        OP_CODE_GET_VALUE(3),
        OP_START_LISTENING_TO_ANIMATED_NODE_VALUE(4),
        OP_STOP_LISTENING_TO_ANIMATED_NODE_VALUE(5),
        OP_CODE_CONNECT_ANIMATED_NODES(6),
        OP_CODE_DISCONNECT_ANIMATED_NODES(7),
        OP_CODE_START_ANIMATING_NODE(8),
        OP_CODE_STOP_ANIMATION(9),
        OP_CODE_SET_ANIMATED_NODE_VALUE(10),
        OP_CODE_SET_ANIMATED_NODE_OFFSET(11),
        OP_CODE_FLATTEN_ANIMATED_NODE_OFFSET(12),
        OP_CODE_EXTRACT_ANIMATED_NODE_OFFSET(13),
        OP_CODE_CONNECT_ANIMATED_NODE_TO_VIEW(14),
        OP_CODE_DISCONNECT_ANIMATED_NODE_FROM_VIEW(15),
        OP_CODE_RESTORE_DEFAULT_VALUES(16),
        OP_CODE_DROP_ANIMATED_NODE(17),
        OP_CODE_ADD_ANIMATED_EVENT_TO_VIEW(18),
        OP_CODE_REMOVE_ANIMATED_EVENT_FROM_VIEW(19),
        OP_CODE_ADD_LISTENER(20),
        OP_CODE_REMOVE_LISTENERS(21);
        
        private static BatchExecutionOpCodes[] valueMap;
        private final int value;

        static {
            valueMap = null;
        }

        private BatchExecutionOpCodes(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public static BatchExecutionOpCodes fromId(int i) {
            if (valueMap == null) {
                valueMap = values();
            }
            return valueMap[i - 1];
        }
    }

    private abstract class UIThreadOperation {
        long mBatchNumber;

        /* access modifiers changed from: package-private */
        public abstract void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager);

        private UIThreadOperation() {
            this.mBatchNumber = -1;
        }

        public void setBatchNumber(long j) {
            this.mBatchNumber = j;
        }

        public long getBatchNumber() {
            return this.mBatchNumber;
        }
    }

    private class ConcurrentOperationQueue {
        private UIThreadOperation mPeekedOperation;
        private final Queue<UIThreadOperation> mQueue;

        private ConcurrentOperationQueue() {
            this.mQueue = new ConcurrentLinkedQueue();
            this.mPeekedOperation = null;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.mQueue.isEmpty() && this.mPeekedOperation == null;
        }

        /* access modifiers changed from: package-private */
        public void add(UIThreadOperation uIThreadOperation) {
            this.mQueue.add(uIThreadOperation);
        }

        /* access modifiers changed from: package-private */
        public void executeBatch(long j, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
            List<UIThreadOperation> drainQueueIntoList = drainQueueIntoList(j);
            if (drainQueueIntoList != null) {
                for (UIThreadOperation execute : drainQueueIntoList) {
                    execute.execute(nativeAnimatedNodesManager);
                }
            }
        }

        private List<UIThreadOperation> drainQueueIntoList(long j) {
            if (isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (true) {
                UIThreadOperation uIThreadOperation = this.mPeekedOperation;
                if (uIThreadOperation != null) {
                    if (uIThreadOperation.getBatchNumber() > j) {
                        break;
                    }
                    arrayList.add(this.mPeekedOperation);
                    this.mPeekedOperation = null;
                }
                UIThreadOperation poll = this.mQueue.poll();
                if (poll == null) {
                    break;
                } else if (poll.getBatchNumber() > j) {
                    this.mPeekedOperation = poll;
                    break;
                } else {
                    arrayList.add(poll);
                }
            }
            return arrayList;
        }
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mAnimatedFrameCallback = new GuardedFrameCallback(reactApplicationContext) {
            /* access modifiers changed from: protected */
            public void doFrameGuarded(long j) {
                try {
                    NativeAnimatedNodesManager nodesManager = NativeAnimatedModule.this.getNodesManager();
                    if (nodesManager != null && nodesManager.hasActiveAnimations()) {
                        nodesManager.runUpdates(j);
                    }
                    if (nodesManager != null || NativeAnimatedModule.this.mReactChoreographer != null) {
                        ((ReactChoreographer) Assertions.assertNotNull(NativeAnimatedModule.this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.addLifecycleEventListener(this);
        }
    }

    public void onHostResume() {
        enqueueFrameCallback();
    }

    private void addOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(this.mCurrentBatchNumber);
        this.mOperations.add(uIThreadOperation);
    }

    private void addUnbatchedOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(-1);
        this.mOperations.add(uIThreadOperation);
    }

    private void addPreOperation(UIThreadOperation uIThreadOperation) {
        uIThreadOperation.setBatchNumber(this.mCurrentBatchNumber);
        this.mPreOperations.add(uIThreadOperation);
    }

    public void didScheduleMountItems(UIManager uIManager) {
        this.mCurrentFrameNumber++;
    }

    public void didDispatchMountItems(UIManager uIManager) {
        if (this.mUIManagerType == 2) {
            long j = this.mCurrentBatchNumber - 1;
            if (!this.mBatchingControlledByJS) {
                this.mCurrentFrameNumber++;
                if (this.mCurrentFrameNumber - this.mCurrentBatchNumber > 2) {
                    this.mCurrentBatchNumber = this.mCurrentFrameNumber;
                    j = this.mCurrentBatchNumber;
                }
            }
            this.mPreOperations.executeBatch(j, getNodesManager());
            this.mOperations.executeBatch(j, getNodesManager());
        }
    }

    public void willDispatchViewUpdates(UIManager uIManager) {
        if ((!this.mOperations.isEmpty() || !this.mPreOperations.isEmpty()) && this.mUIManagerType != 2) {
            final long j = this.mCurrentBatchNumber;
            this.mCurrentBatchNumber = 1 + j;
            AnonymousClass2 r2 = new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedModule.this.mPreOperations.executeBatch(j, NativeAnimatedModule.this.getNodesManager());
                }
            };
            AnonymousClass3 r3 = new UIBlock() {
                public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                    NativeAnimatedModule.this.mOperations.executeBatch(j, NativeAnimatedModule.this.getNodesManager());
                }
            };
            UIManagerModule uIManagerModule = (UIManagerModule) uIManager;
            uIManagerModule.prependUIBlock(r2);
            uIManagerModule.addUIBlock(r3);
        }
    }

    public void onHostPause() {
        clearFrameCallback();
    }

    public void onHostDestroy() {
        clearFrameCallback();
    }

    public NativeAnimatedNodesManager getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager.get() == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.mNodesManager, (Object) null, new NativeAnimatedNodesManager(reactApplicationContextIfActiveOrWarn));
        }
        return this.mNodesManager.get();
    }

    private void clearFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).removeFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void enqueueFrameCallback() {
        ((ReactChoreographer) Assertions.assertNotNull(this.mReactChoreographer)).postFrameCallback(ReactChoreographer.CallbackType.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    public void setNodesManager(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNodesManager.set(nativeAnimatedNodesManager);
    }

    private void initializeLifecycleEventListenersForViewTag(int i) {
        UIManager uIManager;
        int uIManagerType = ViewUtil.getUIManagerType(i);
        this.mUIManagerType = uIManagerType;
        if (uIManagerType == 2) {
            this.mNumFabricAnimations++;
        } else {
            this.mNumNonFabricAnimations++;
        }
        NativeAnimatedNodesManager nodesManager = getNodesManager();
        if (nodesManager != null) {
            nodesManager.initializeEventListenerForUIManagerType(this.mUIManagerType);
        } else {
            ReactSoftExceptionLogger.logSoftException(NAME, new RuntimeException("initializeLifecycleEventListenersForViewTag could not get NativeAnimatedNodesManager"));
        }
        if (this.mUIManagerType == 2) {
            if (this.mInitializedForFabric) {
                return;
            }
        } else if (this.mInitializedForNonFabric) {
            return;
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        if (reactApplicationContext != null && (uIManager = UIManagerHelper.getUIManager(reactApplicationContext, this.mUIManagerType)) != null) {
            uIManager.addUIManagerEventListener(this);
            if (this.mUIManagerType == 2) {
                this.mInitializedForFabric = true;
            } else {
                this.mInitializedForNonFabric = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void decrementInFlightAnimationsForViewTag(int i) {
        if (ViewUtil.getUIManagerType(i) == 2) {
            this.mNumFabricAnimations--;
        } else {
            this.mNumNonFabricAnimations--;
        }
        int i2 = this.mNumNonFabricAnimations;
        if (i2 == 0 && this.mNumFabricAnimations > 0 && this.mUIManagerType != 2) {
            this.mUIManagerType = 2;
        } else if (this.mNumFabricAnimations == 0 && i2 > 0 && this.mUIManagerType != 1) {
            this.mUIManagerType = 1;
        }
    }

    public void startOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void finishOperationBatch() {
        this.mBatchingControlledByJS = true;
        this.mCurrentBatchNumber++;
    }

    public void createAnimatedNode(double d, final ReadableMap readableMap) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.createAnimatedNode(i, readableMap);
            }
        });
    }

    public void updateAnimatedNodeConfig(double d, final ReadableMap readableMap) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.updateAnimatedNodeConfig(i, readableMap);
            }
        });
    }

    public void startListeningToAnimatedNodeValue(double d) {
        final int i = (int) d;
        final AnonymousClass6 r3 = new AnimatedNodeValueListener() {
            public void onValueUpdate(double d) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("tag", i);
                createMap.putDouble("value", d);
                ReactApplicationContext access$600 = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
                if (access$600 != null) {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) access$600.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
                }
            }
        };
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startListeningToAnimatedNodeValue(i, r3);
            }
        });
    }

    public void stopListeningToAnimatedNodeValue(double d) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopListeningToAnimatedNodeValue(i);
            }
        });
    }

    public void dropAnimatedNode(double d) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.dropAnimatedNode(i);
            }
        });
    }

    public void setAnimatedNodeValue(double d, final double d2) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeValue(i, d2);
            }
        });
    }

    public void setAnimatedNodeOffset(double d, final double d2) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.setAnimatedNodeOffset(i, d2);
            }
        });
    }

    public void flattenAnimatedNodeOffset(double d) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.flattenAnimatedNodeOffset(i);
            }
        });
    }

    public void extractAnimatedNodeOffset(double d) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.extractAnimatedNodeOffset(i);
            }
        });
    }

    public void startAnimatingNode(double d, double d2, ReadableMap readableMap, Callback callback) {
        final int i = (int) d;
        final int i2 = (int) d2;
        final ReadableMap readableMap2 = readableMap;
        final Callback callback2 = callback;
        addUnbatchedOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.startAnimatingNode(i, i2, readableMap2, callback2);
            }
        });
    }

    public void stopAnimation(double d) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.stopAnimation(i);
            }
        });
    }

    public void connectAnimatedNodes(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodes(i, i2);
            }
        });
    }

    public void disconnectAnimatedNodes(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodes(i, i2);
            }
        });
    }

    public void connectAnimatedNodeToView(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        initializeLifecycleEventListenersForViewTag(i2);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.connectAnimatedNodeToView(i, i2);
            }
        });
    }

    public void disconnectAnimatedNodeFromView(double d, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        decrementInFlightAnimationsForViewTag(i2);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.disconnectAnimatedNodeFromView(i, i2);
            }
        });
    }

    public void restoreDefaultValues(double d) {
        final int i = (int) d;
        addPreOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.restoreDefaultValues(i);
            }
        });
    }

    public void addAnimatedEventToView(double d, final String str, final ReadableMap readableMap) {
        final int i = (int) d;
        initializeLifecycleEventListenersForViewTag(i);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.addAnimatedEventToView(i, str, readableMap);
            }
        });
    }

    public void removeAnimatedEventFromView(double d, final String str, double d2) {
        final int i = (int) d;
        final int i2 = (int) d2;
        decrementInFlightAnimationsForViewTag(i);
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.removeAnimatedEventFromView(i, str, i2);
            }
        });
    }

    public void getValue(double d, final Callback callback) {
        final int i = (int) d;
        addOperation(new UIThreadOperation() {
            public void execute(NativeAnimatedNodesManager nativeAnimatedNodesManager) {
                nativeAnimatedNodesManager.getValue(i, callback);
            }
        });
    }

    public void invalidate() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.removeLifecycleEventListener(this);
        }
    }

    public void queueAndExecuteBatchedOperations(final ReadableArray readableArray) {
        int i;
        final int size = readableArray.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            switch (AnonymousClass25.$SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes[BatchExecutionOpCodes.fromId(readableArray.getInt(i2)).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    i = i3 + 1;
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    i = i3 + 2;
                    break;
                case 18:
                case 19:
                    i = i3 + 3;
                    break;
                case 20:
                    int i4 = i3 + 1;
                    i2 = i4 + 1;
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i4));
                    continue;
                case 21:
                    initializeLifecycleEventListenersForViewTag(readableArray.getInt(i3));
                    i2 = i3 + 1 + 1 + 1;
                    continue;
                default:
                    throw new IllegalArgumentException("Batch animation execution op: fetching viewTag: unknown op code");
            }
            i2 = i;
        }
        startOperationBatch();
        addUnbatchedOperation(new UIThreadOperation() {
            /* JADX WARNING: Code restructure failed: missing block: B:10:0x007b, code lost:
                r0 = r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x0190, code lost:
                r0 = r1;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x019e, code lost:
                r0 = r3;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void execute(com.facebook.react.animated.NativeAnimatedNodesManager r7) {
                /*
                    r6 = this;
                    com.facebook.react.animated.NativeAnimatedModule r0 = com.facebook.react.animated.NativeAnimatedModule.this
                    com.facebook.react.bridge.ReactApplicationContext unused = r0.getReactApplicationContextIfActiveOrWarn()
                    r0 = 0
                L_0x0006:
                    int r1 = r0
                    if (r0 >= r1) goto L_0x01a1
                    com.facebook.react.bridge.ReadableArray r1 = r5
                    int r2 = r0 + 1
                    int r0 = r1.getInt(r0)
                    com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r0 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.fromId(r0)
                    int[] r1 = com.facebook.react.animated.NativeAnimatedModule.AnonymousClass25.$SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes
                    int r0 = r0.ordinal()
                    r0 = r1[r0]
                    r1 = 0
                    switch(r0) {
                        case 1: goto L_0x0193;
                        case 2: goto L_0x0180;
                        case 3: goto L_0x0174;
                        case 4: goto L_0x0168;
                        case 5: goto L_0x015c;
                        case 6: goto L_0x0150;
                        case 7: goto L_0x0144;
                        case 8: goto L_0x0138;
                        case 9: goto L_0x0133;
                        case 10: goto L_0x0133;
                        case 11: goto L_0x011e;
                        case 12: goto L_0x0109;
                        case 13: goto L_0x00f4;
                        case 14: goto L_0x00df;
                        case 15: goto L_0x00ca;
                        case 16: goto L_0x00b5;
                        case 17: goto L_0x009b;
                        case 18: goto L_0x007d;
                        case 19: goto L_0x005b;
                        case 20: goto L_0x0046;
                        case 21: goto L_0x002a;
                        default: goto L_0x0022;
                    }
                L_0x0022:
                    java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                    java.lang.String r0 = "Batch animation execution op: unknown op code"
                    r7.<init>(r0)
                    throw r7
                L_0x002a:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    java.lang.String r1 = r2.getString(r1)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r4 = r3 + 1
                    com.facebook.react.bridge.ReadableMap r2 = r2.getMap(r3)
                    r7.addAnimatedEventToView(r0, r1, r2)
                    goto L_0x007b
                L_0x0046:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    int r1 = r2.getInt(r1)
                    r7.connectAnimatedNodeToView(r0, r1)
                    goto L_0x019e
                L_0x005b:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.animated.NativeAnimatedModule r2 = com.facebook.react.animated.NativeAnimatedModule.this
                    r2.decrementInFlightAnimationsForViewTag(r0)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    java.lang.String r1 = r2.getString(r1)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r4 = r3 + 1
                    int r2 = r2.getInt(r3)
                    r7.removeAnimatedEventFromView(r0, r1, r2)
                L_0x007b:
                    r0 = r4
                    goto L_0x0006
                L_0x007d:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r3 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r4 = r3 + 1
                    int r2 = r2.getInt(r3)
                    com.facebook.react.bridge.ReadableArray r3 = r5
                    int r5 = r4 + 1
                    com.facebook.react.bridge.ReadableMap r3 = r3.getMap(r4)
                    r7.startAnimatingNode(r0, r2, r3, r1)
                    r0 = r5
                    goto L_0x0006
                L_0x009b:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    int r1 = r2.getInt(r1)
                    com.facebook.react.animated.NativeAnimatedModule r2 = com.facebook.react.animated.NativeAnimatedModule.this
                    r2.decrementInFlightAnimationsForViewTag(r1)
                    r7.disconnectAnimatedNodeFromView(r0, r1)
                    goto L_0x019e
                L_0x00b5:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    double r1 = r2.getDouble(r1)
                    r7.setAnimatedNodeValue(r0, r1)
                    goto L_0x019e
                L_0x00ca:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    double r1 = r2.getDouble(r1)
                    r7.setAnimatedNodeValue(r0, r1)
                    goto L_0x019e
                L_0x00df:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    int r1 = r2.getInt(r1)
                    r7.disconnectAnimatedNodes(r0, r1)
                    goto L_0x019e
                L_0x00f4:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    int r1 = r2.getInt(r1)
                    r7.connectAnimatedNodes(r0, r1)
                    goto L_0x019e
                L_0x0109:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    com.facebook.react.bridge.ReadableMap r1 = r2.getMap(r1)
                    r7.updateAnimatedNodeConfig(r0, r1)
                    goto L_0x019e
                L_0x011e:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.bridge.ReadableArray r2 = r5
                    int r3 = r1 + 1
                    com.facebook.react.bridge.ReadableMap r1 = r2.getMap(r1)
                    r7.createAnimatedNode(r0, r1)
                    goto L_0x019e
                L_0x0133:
                    int r2 = r2 + 1
                    r0 = r2
                    goto L_0x0006
                L_0x0138:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.dropAnimatedNode(r0)
                    goto L_0x0190
                L_0x0144:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.restoreDefaultValues(r0)
                    goto L_0x0190
                L_0x0150:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.extractAnimatedNodeOffset(r0)
                    goto L_0x0190
                L_0x015c:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.flattenAnimatedNodeOffset(r0)
                    goto L_0x0190
                L_0x0168:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.stopAnimation(r0)
                    goto L_0x0190
                L_0x0174:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.stopListeningToAnimatedNodeValue(r0)
                    goto L_0x0190
                L_0x0180:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r1 = r2 + 1
                    int r0 = r0.getInt(r2)
                    com.facebook.react.animated.NativeAnimatedModule$24$1 r2 = new com.facebook.react.animated.NativeAnimatedModule$24$1
                    r2.<init>(r0)
                    r7.startListeningToAnimatedNodeValue(r0, r2)
                L_0x0190:
                    r0 = r1
                    goto L_0x0006
                L_0x0193:
                    com.facebook.react.bridge.ReadableArray r0 = r5
                    int r3 = r2 + 1
                    int r0 = r0.getInt(r2)
                    r7.getValue(r0, r1)
                L_0x019e:
                    r0 = r3
                    goto L_0x0006
                L_0x01a1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.NativeAnimatedModule.AnonymousClass24.execute(com.facebook.react.animated.NativeAnimatedNodesManager):void");
            }
        });
        finishOperationBatch();
    }

    /* renamed from: com.facebook.react.animated.NativeAnimatedModule$25  reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes;

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|(3:41|42|44)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes[] r0 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes = r0
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_GET_VALUE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_START_LISTENING_TO_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_STOP_LISTENING_TO_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_STOP_ANIMATION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_FLATTEN_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_EXTRACT_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_RESTORE_DEFAULT_VALUES     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_DROP_ANIMATED_NODE     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x006c }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_ADD_LISTENER     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_REMOVE_LISTENERS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_CREATE_ANIMATED_NODE     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_UPDATE_ANIMATED_NODE_CONFIG     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x009c }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_CONNECT_ANIMATED_NODES     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_DISCONNECT_ANIMATED_NODES     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_SET_ANIMATED_NODE_VALUE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_SET_ANIMATED_NODE_OFFSET     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_DISCONNECT_ANIMATED_NODE_FROM_VIEW     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_START_ANIMATING_NODE     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_REMOVE_ANIMATED_EVENT_FROM_VIEW     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_CONNECT_ANIMATED_NODE_TO_VIEW     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$facebook$react$animated$NativeAnimatedModule$BatchExecutionOpCodes     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.facebook.react.animated.NativeAnimatedModule$BatchExecutionOpCodes r1 = com.facebook.react.animated.NativeAnimatedModule.BatchExecutionOpCodes.OP_CODE_ADD_ANIMATED_EVENT_TO_VIEW     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.NativeAnimatedModule.AnonymousClass25.<clinit>():void");
        }
    }
}
