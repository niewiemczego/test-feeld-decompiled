package com.facebook.react.fabric;

import android.content.Context;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.DevToolsReactPerfLogger;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountItemDispatcher;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.fabric.mounting.mountitems.DispatchIntCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.IntBufferBatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.SendAccessibilityEvent;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherImpl;
import com.facebook.react.uimanager.events.RCTModernEventEmitter;
import com.facebook.react.views.text.TextLayoutManager;
import com.facebook.react.views.text.TextLayoutManagerMapBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;

public class FabricUIManager implements UIManager, LifecycleEventListener {
    public static final boolean ENABLE_FABRIC_LOGS;
    public static final boolean ENABLE_FABRIC_PERF_LOGS;
    private static final DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener FABRIC_PERF_LOGGER = new DevToolsReactPerfLogger.DevToolsReactPerfLoggerListener() {
        public void onFabricCommitEnd(DevToolsReactPerfLogger.FabricCommitPoint fabricCommitPoint) {
            long commitDuration = fabricCommitPoint.getCommitDuration();
            long layoutDuration = fabricCommitPoint.getLayoutDuration();
            long diffDuration = fabricCommitPoint.getDiffDuration();
            long transactionEndDuration = fabricCommitPoint.getTransactionEndDuration();
            long batchExecutionDuration = fabricCommitPoint.getBatchExecutionDuration();
            DevToolsReactPerfLogger.mStreamingCommitStats.add(commitDuration);
            DevToolsReactPerfLogger.mStreamingLayoutStats.add(layoutDuration);
            DevToolsReactPerfLogger.mStreamingDiffStats.add(diffDuration);
            DevToolsReactPerfLogger.mStreamingTransactionEndStats.add(transactionEndDuration);
            DevToolsReactPerfLogger.mStreamingBatchExecutionStats.add(batchExecutionDuration);
            FLog.i(FabricUIManager.TAG, "Statistics of Fabric commit #%d:\n - Total commit time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Layout time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Diffing time: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - FinishTransaction (Diffing + JNI serialization): %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n - Mounting: %d ms. Avg: %.2f. Median: %.2f ms. Max: %d ms.\n", Long.valueOf(fabricCommitPoint.getCommitNumber()), Long.valueOf(commitDuration), Double.valueOf(DevToolsReactPerfLogger.mStreamingCommitStats.getAverage()), Double.valueOf(DevToolsReactPerfLogger.mStreamingCommitStats.getMedian()), Long.valueOf(DevToolsReactPerfLogger.mStreamingCommitStats.getMax()), Long.valueOf(layoutDuration), Double.valueOf(DevToolsReactPerfLogger.mStreamingLayoutStats.getAverage()), Double.valueOf(DevToolsReactPerfLogger.mStreamingLayoutStats.getMedian()), Long.valueOf(DevToolsReactPerfLogger.mStreamingLayoutStats.getMax()), Long.valueOf(diffDuration), Double.valueOf(DevToolsReactPerfLogger.mStreamingDiffStats.getAverage()), Double.valueOf(DevToolsReactPerfLogger.mStreamingDiffStats.getMedian()), Long.valueOf(DevToolsReactPerfLogger.mStreamingDiffStats.getMax()), Long.valueOf(transactionEndDuration), Double.valueOf(DevToolsReactPerfLogger.mStreamingTransactionEndStats.getAverage()), Double.valueOf(DevToolsReactPerfLogger.mStreamingTransactionEndStats.getMedian()), Long.valueOf(DevToolsReactPerfLogger.mStreamingTransactionEndStats.getMax()), Long.valueOf(batchExecutionDuration), Double.valueOf(DevToolsReactPerfLogger.mStreamingBatchExecutionStats.getAverage()), Double.valueOf(DevToolsReactPerfLogger.mStreamingBatchExecutionStats.getMedian()), Long.valueOf(DevToolsReactPerfLogger.mStreamingBatchExecutionStats.getMax()));
        }
    };
    public static final boolean IS_DEVELOPMENT_ENVIRONMENT = false;
    public static final String TAG = "FabricUIManager";
    /* access modifiers changed from: private */
    public Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = 10000;
    /* access modifiers changed from: private */
    public volatile boolean mDestroyed = false;
    public DevToolsReactPerfLogger mDevToolsReactPerfLogger;
    /* access modifiers changed from: private */
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    /* access modifiers changed from: private */
    public boolean mDriveCxxAnimations = false;
    private final EventBeatManager mEventBeatManager;
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    private long mLayoutTime = 0;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<UIManagerListener> mListeners = new CopyOnWriteArrayList<>();
    /* access modifiers changed from: private */
    public final MountItemDispatcher mMountItemDispatcher;
    private MountingManager.MountItemExecutor mMountItemExecutor = new MountingManager.MountItemExecutor() {
        public void executeItems(Queue<MountItem> queue) {
            FabricUIManager.this.mMountItemDispatcher.dispatchMountItems(queue);
        }
    };
    private final MountingManager mMountingManager;
    private final ReactApplicationContext mReactApplicationContext;
    private volatile boolean mShouldDeallocateEventDispatcher = false;
    private final ViewManagerRegistry mViewManagerRegistry;

    public void onHostDestroy() {
    }

    public void profileNextBatch() {
    }

    static {
        boolean z = false;
        boolean z2 = ReactFeatureFlags.enableFabricLogs || PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER);
        ENABLE_FABRIC_LOGS = z2;
        if (z2) {
            z = true;
        }
        ENABLE_FABRIC_PERF_LOGS = z;
        FabricSoLoader.staticInit();
    }

    @Deprecated
    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(viewManagerRegistry, this.mMountItemExecutor);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener());
        this.mEventDispatcher = eventDispatcher;
        this.mShouldDeallocateEventDispatcher = false;
        this.mEventBeatManager = eventBeatManager;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mViewManagerRegistry = viewManagerRegistry;
        reactApplicationContext.registerComponentCallbacks(viewManagerRegistry);
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        MountingManager mountingManager = new MountingManager(viewManagerRegistry, this.mMountItemExecutor);
        this.mMountingManager = mountingManager;
        this.mMountItemDispatcher = new MountItemDispatcher(mountingManager, new MountItemDispatchListener());
        this.mEventDispatcher = new EventDispatcherImpl(reactApplicationContext);
        this.mShouldDeallocateEventDispatcher = true;
        this.mEventBeatManager = eventBeatManager;
        reactApplicationContext.addLifecycleEventListener(this);
        this.mViewManagerRegistry = viewManagerRegistry;
        reactApplicationContext.registerComponentCallbacks(viewManagerRegistry);
    }

    @Deprecated
    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        String str2 = TAG;
        ReactSoftExceptionLogger.logSoftException(str2, new IllegalViewOperationException("Do not call addRootView in Fabric; it is unsupported. Call startSurface instead."));
        ReactRoot reactRoot = (ReactRoot) t;
        int rootViewTag = reactRoot.getRootViewTag();
        this.mMountingManager.startSurface(rootViewTag, new ThemedReactContext(this.mReactApplicationContext, t.getContext(), reactRoot.getSurfaceID(), rootViewTag), t);
        String jSModuleName = reactRoot.getJSModuleName();
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(str2, "Starting surface for module: %s and reactTag: %d", (Object) jSModuleName, (Object) Integer.valueOf(rootViewTag));
        }
        this.mBinding.startSurface(rootViewTag, jSModuleName, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(rootViewTag, str);
        }
        return rootViewTag;
    }

    public ReadableMap getInspectorDataForInstance(int i, View view) {
        UiThreadUtil.assertOnUiThread();
        return this.mBinding.getInspectorDataForInstance(this.mMountingManager.getEventEmitter(i, view.getId()));
    }

    public void preInitializeViewManagers(List<String> list) {
        for (String initializeViewManager : list) {
            this.mMountingManager.initializeViewManager(initializeViewManager);
        }
    }

    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i, int i2) {
        T t2 = t;
        String str2 = str;
        int rootViewTag = ((ReactRoot) t2).getRootViewTag();
        Context context = t.getContext();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, context, str2, rootViewTag);
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) str2, (Object) Integer.valueOf(rootViewTag));
        }
        this.mMountingManager.startSurface(rootViewTag, themedReactContext, t2);
        Point viewportOffset = UiThreadUtil.isOnUiThread() ? RootViewUtil.getViewportOffset(t) : new Point(0, 0);
        this.mBinding.startSurfaceWithConstraints(rootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i), LayoutMetricsConversions.getMaxSize(i), LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), (float) viewportOffset.x, (float) viewportOffset.y, I18nUtil.getInstance().isRTL(context), I18nUtil.getInstance().doLeftAndRightSwapInRTL(context));
        return rootViewTag;
    }

    public void startSurface(SurfaceHandler surfaceHandler, Context context, View view) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        this.mMountingManager.startSurface(nextRootViewTag, new ThemedReactContext(this.mReactApplicationContext, context, surfaceHandler.getModuleName(), nextRootViewTag), view);
        surfaceHandler.setSurfaceId(nextRootViewTag);
        if (surfaceHandler instanceof SurfaceHandlerBinding) {
            this.mBinding.registerSurface((SurfaceHandlerBinding) surfaceHandler);
        }
        surfaceHandler.setMountable(view != null);
        surfaceHandler.start();
    }

    public void attachRootView(SurfaceHandler surfaceHandler, View view) {
        this.mMountingManager.attachRootView(surfaceHandler.getSurfaceId(), view, new ThemedReactContext(this.mReactApplicationContext, view.getContext(), surfaceHandler.getModuleName(), surfaceHandler.getSurfaceId()));
        surfaceHandler.setMountable(true);
    }

    public void stopSurface(SurfaceHandler surfaceHandler) {
        if (!surfaceHandler.isRunning()) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Trying to stop surface that hasn't started yet"));
            return;
        }
        this.mMountingManager.stopSurface(surfaceHandler.getSurfaceId());
        surfaceHandler.stop();
        if (surfaceHandler instanceof SurfaceHandlerBinding) {
            this.mBinding.unregisterSurface((SurfaceHandlerBinding) surfaceHandler);
        }
    }

    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    public void stopSurface(int i) {
        this.mMountingManager.stopSurface(i);
        this.mBinding.stopSurface(i);
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, (RCTModernEventEmitter) new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
        if (ENABLE_FABRIC_PERF_LOGS) {
            DevToolsReactPerfLogger devToolsReactPerfLogger = new DevToolsReactPerfLogger();
            this.mDevToolsReactPerfLogger = devToolsReactPerfLogger;
            devToolsReactPerfLogger.addDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.addFabricListener(this.mDevToolsReactPerfLogger);
        }
    }

    public void onCatalystInstanceDestroy() {
        String str = TAG;
        FLog.i(str, "FabricUIManager.onCatalystInstanceDestroy");
        DevToolsReactPerfLogger devToolsReactPerfLogger = this.mDevToolsReactPerfLogger;
        if (devToolsReactPerfLogger != null) {
            devToolsReactPerfLogger.removeDevToolsReactPerfLoggerListener(FABRIC_PERF_LOGGER);
            ReactMarker.removeFabricListener(this.mDevToolsReactPerfLogger);
        }
        if (this.mDestroyed) {
            ReactSoftExceptionLogger.logSoftException(str, new IllegalStateException("Cannot double-destroy FabricUIManager"));
            return;
        }
        this.mDestroyed = true;
        this.mDispatchUIFrameCallback.stop();
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mReactApplicationContext.unregisterComponentCallbacks(this.mViewManagerRegistry);
        this.mReactApplicationContext.removeLifecycleEventListener(this);
        onHostPause();
        this.mBinding.unregister();
        this.mBinding = null;
        ViewManagerPropertyUpdater.clear();
        if (this.mShouldDeallocateEventDispatcher) {
            this.mEventDispatcher.onCatalystInstanceDestroyed();
        }
    }

    private NativeArray measureLines(ReadableMap readableMap, ReadableMap readableMap2, float f, float f2) {
        return (NativeArray) TextLayoutManager.measureLines(this.mReactApplicationContext, readableMap, readableMap2, PixelUtil.toPixelFromDIP(f));
    }

    private NativeArray measureLinesMapBuffer(ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, float f, float f2) {
        return (NativeArray) TextLayoutManagerMapBuffer.measureLines(this.mReactApplicationContext, readableMapBuffer, readableMapBuffer2, PixelUtil.toPixelFromDIP(f));
    }

    private long measure(int i, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, float f2, float f3, float f4) {
        return measure(i, str, readableMap, readableMap2, readableMap3, f, f2, f3, f4, (float[]) null);
    }

    public int getColor(int i, String[] strArr) {
        ThemedReactContext context = this.mMountingManager.getSurfaceManagerEnforced(i, "getColor").getContext();
        for (String resolveResourcePath : strArr) {
            Integer resolveResourcePath2 = ColorPropConverter.resolveResourcePath(context, resolveResourcePath);
            if (resolveResourcePath2 != null) {
                return resolveResourcePath2.intValue();
            }
        }
        return 0;
    }

    private long measure(int i, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, float f2, float f3, float f4, float[] fArr) {
        ReactContext reactContext;
        if (i > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measure(reactContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4), fArr);
    }

    private long measureMapBuffer(int i, String str, ReadableMapBuffer readableMapBuffer, ReadableMapBuffer readableMapBuffer2, ReadableMapBuffer readableMapBuffer3, float f, float f2, float f3, float f4, float[] fArr) {
        ReactContext reactContext;
        if (i > 0) {
            SurfaceMountingManager surfaceManagerEnforced = this.mMountingManager.getSurfaceManagerEnforced(i, "measure");
            if (surfaceManagerEnforced.isStopped()) {
                return 0;
            }
            reactContext = surfaceManagerEnforced.getContext();
        } else {
            reactContext = this.mReactApplicationContext;
        }
        return this.mMountingManager.measureMapBuffer(reactContext, str, readableMapBuffer, readableMapBuffer2, readableMapBuffer3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4), fArr);
    }

    public boolean getThemeData(int i, float[] fArr) {
        ThemedReactContext context = this.mMountingManager.getSurfaceManagerEnforced(i, "getThemeData").getContext();
        if (context == null) {
            FLog.w(TAG, "\"themedReactContext\" is null when call \"getThemeData\"");
            return false;
        }
        float[] defaultTextInputPadding = UIManagerHelper.getDefaultTextInputPadding(context);
        fArr[0] = defaultTextInputPadding[0];
        fArr[1] = defaultTextInputPadding[1];
        fArr[2] = defaultTextInputPadding[2];
        fArr[3] = defaultTextInputPadding[3];
        return true;
    }

    public void addUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.add(uIManagerListener);
    }

    public void removeUIManagerEventListener(UIManagerListener uIManagerListener) {
        this.mListeners.remove(uIManagerListener);
    }

    public void synchronouslyUpdateViewOnUIThread(final int i, final ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        int i2 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i2 + 1;
        AnonymousClass3 r1 = new MountItem() {
            public int getSurfaceId() {
                return -1;
            }

            public void execute(MountingManager mountingManager) {
                try {
                    mountingManager.updateProps(i, readableMap);
                } catch (Exception unused) {
                }
            }

            public String toString() {
                return String.format("SYNC UPDATE PROPS [%d]: %s", new Object[]{Integer.valueOf(i), "<hidden>"});
            }
        };
        if (!this.mMountingManager.getViewExists(i)) {
            this.mMountItemDispatcher.addMountItem(r1);
            return;
        }
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, (String) null, i2);
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "SynchronouslyUpdateViewOnUIThread for tag %d: %s", (Object) Integer.valueOf(i), (Object) "<hidden>");
        }
        r1.execute(this.mMountingManager);
        ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, (String) null, i2);
    }

    private void preallocateView(int i, int i2, String str, Object obj, Object obj2, Object obj3, boolean z) {
        this.mMountItemDispatcher.addPreAllocateMountItem(new PreAllocateViewMountItem(i, i2, FabricComponents.getFabricComponentName(str), obj, (StateWrapper) obj2, (EventEmitterWrapper) obj3, z));
    }

    private MountItem createIntBufferBatchMountItem(int i, int[] iArr, Object[] objArr, int i2) {
        return new IntBufferBatchMountItem(i, iArr, objArr, i2);
    }

    private void scheduleMountItem(MountItem mountItem, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        MountItem mountItem2 = mountItem;
        int i2 = i;
        long j8 = j;
        long j9 = j4;
        long j10 = j5;
        long j11 = j6;
        long j12 = j7;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = mountItem2 instanceof IntBufferBatchMountItem;
        boolean z2 = (z && ((IntBufferBatchMountItem) mountItem2).shouldSchedule()) || (!z && mountItem2 != null);
        for (Iterator<UIManagerListener> it = this.mListeners.iterator(); it.hasNext(); it = it) {
            it.next().didScheduleMountItems(this);
        }
        if (z) {
            this.mCommitStartTime = j8;
            this.mLayoutTime = j10 - j9;
            this.mFinishTransactionCPPTime = j12 - j11;
            this.mFinishTransactionTime = uptimeMillis - j11;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        if (z2) {
            this.mMountItemDispatcher.addMountItem(mountItem2);
            AnonymousClass4 r1 = new Runnable() {
                public void run() {
                    FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                }
            };
            if (UiThreadUtil.isOnUiThread()) {
                r1.run();
            } else if (ReactFeatureFlags.enableEarlyScheduledMountItemExecution) {
                UiThreadUtil.runOnUiThread(r1);
            }
        }
        if (z) {
            int i3 = i;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, (String) null, i3, j);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, (String) null, i3, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, (String) null, i3, j12);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, (String) null, i3, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, (String) null, i3, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, (String) null, i3, j9);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, (String) null, i3, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, (String) null, i3);
        }
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    public void updateRootLayoutSpecs(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        boolean z2;
        int i6 = i;
        if (ENABLE_FABRIC_LOGS) {
            FLog.d(TAG, "Updating Root Layout Specs for [%d]", (Object) Integer.valueOf(i));
        }
        SurfaceMountingManager surfaceManager = this.mMountingManager.getSurfaceManager(i);
        if (surfaceManager == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalViewOperationException("Cannot updateRootLayoutSpecs on surfaceId that does not exist: " + i));
            return;
        }
        ThemedReactContext context = surfaceManager.getContext();
        if (context != null) {
            boolean isRTL = I18nUtil.getInstance().isRTL(context);
            z = I18nUtil.getInstance().doLeftAndRightSwapInRTL(context);
            z2 = isRTL;
        } else {
            z2 = false;
            z = false;
        }
        this.mBinding.setConstraints(i, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3), (float) i4, (float) i5, z2, z);
    }

    public View resolveView(int i) {
        UiThreadUtil.assertOnUiThread();
        SurfaceMountingManager surfaceManagerForView = this.mMountingManager.getSurfaceManagerForView(i);
        if (surfaceManagerForView == null) {
            return null;
        }
        return surfaceManagerForView.getView(i);
    }

    public void receiveEvent(int i, String str, WritableMap writableMap) {
        receiveEvent(-1, i, str, writableMap);
    }

    public void receiveEvent(int i, int i2, String str, WritableMap writableMap) {
        receiveEvent(i, i2, str, false, 0, writableMap);
    }

    public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap) {
        receiveEvent(i, i2, str, z, i3, writableMap, 2);
    }

    public void receiveEvent(int i, int i2, String str, boolean z, int i3, WritableMap writableMap, int i4) {
        if (this.mDestroyed) {
            FLog.e(TAG, "Attempted to receiveEvent after destruction");
            return;
        }
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i, i2);
        if (eventEmitter == null) {
            if (!ReactFeatureFlags.enableFabricPendingEventQueue || !this.mMountingManager.getViewExists(i2)) {
                FLog.d(TAG, "Unable to invoke event: " + str + " for reactTag: " + i2);
            } else {
                this.mMountingManager.enqueuePendingEvent(i2, new SurfaceMountingManager.ViewEvent(str, writableMap, i4, z, i3));
            }
        } else if (z) {
            eventEmitter.invokeUnique(str, writableMap, i3);
        } else {
            eventEmitter.invoke(str, writableMap, i4);
        }
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public EventDispatcher getEventDispatcher() {
        return this.mEventDispatcher;
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    @Deprecated
    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        throw new UnsupportedOperationException("dispatchCommand called without surfaceId - Fabric dispatchCommand must be called through Fabric JSI API");
    }

    @Deprecated
    public void dispatchCommand(int i, int i2, int i3, ReadableArray readableArray) {
        this.mMountItemDispatcher.dispatchCommandMountItem(new DispatchIntCommandMountItem(i, i2, i3, readableArray));
    }

    public void dispatchCommand(int i, int i2, String str, ReadableArray readableArray) {
        this.mMountItemDispatcher.dispatchCommandMountItem(new DispatchStringCommandMountItem(i, i2, str, readableArray));
    }

    public void sendAccessibilityEvent(int i, int i2) {
        this.mMountItemDispatcher.addMountItem(new SendAccessibilityEvent(-1, i, i2));
    }

    public void sendAccessibilityEventFromJS(int i, int i2, String str) {
        int i3;
        if ("focus".equals(str)) {
            i3 = 8;
        } else if ("windowStateChange".equals(str)) {
            i3 = 32;
        } else if ("click".equals(str)) {
            i3 = 1;
        } else {
            throw new IllegalArgumentException("sendAccessibilityEventFromJS: invalid eventType " + str);
        }
        this.mMountItemDispatcher.addMountItem(new SendAccessibilityEvent(i, i2, i3));
    }

    public void setJSResponder(int i, int i2, int i3, boolean z) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public void execute(MountingManager mountingManager) {
                SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(i4);
                if (surfaceManager != null) {
                    surfaceManager.setJSResponder(i5, i6, z2);
                } else {
                    FLog.e(FabricUIManager.TAG, "setJSResponder skipped, surface no longer available [" + i4 + "]");
                }
            }

            public int getSurfaceId() {
                return i4;
            }

            public String toString() {
                return String.format("SET_JS_RESPONDER [%d] [surface:%d]", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
            }
        });
    }

    public void clearJSResponder() {
        this.mMountItemDispatcher.addMountItem(new MountItem() {
            public int getSurfaceId() {
                return -1;
            }

            public String toString() {
                return "CLEAR_JS_RESPONDER";
            }

            public void execute(MountingManager mountingManager) {
                mountingManager.clearJSResponder();
            }
        });
    }

    @Deprecated
    public String resolveCustomDirectEventName(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("top") ? "on" + str.substring(3) : str;
    }

    public void onAnimationStarted() {
        this.mDriveCxxAnimations = true;
    }

    public void onAllAnimationsComplete() {
        this.mDriveCxxAnimations = false;
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mMountItemDispatcher.getRunStartTime()));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mMountItemDispatcher.getBatchedExecutionTime()));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    private class MountItemDispatchListener implements MountItemDispatcher.ItemDispatchListener {
        private MountItemDispatchListener() {
        }

        public void didDispatchMountItems() {
            Iterator it = FabricUIManager.this.mListeners.iterator();
            while (it.hasNext()) {
                ((UIManagerListener) it.next()).didDispatchMountItems(FabricUIManager.this);
            }
        }
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private volatile boolean mIsMountingEnabled;

        private DispatchUIFrameCallback(ReactContext reactContext) {
            super(reactContext);
            this.mIsMountingEnabled = true;
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.mIsMountingEnabled = false;
        }

        public void doFrameGuarded(long j) {
            if (!this.mIsMountingEnabled || FabricUIManager.this.mDestroyed) {
                FLog.w(FabricUIManager.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            if (FabricUIManager.this.mDriveCxxAnimations && FabricUIManager.this.mBinding != null) {
                FabricUIManager.this.mBinding.driveCxxAnimations();
            }
            try {
                FabricUIManager.this.mMountItemDispatcher.dispatchPreMountItems(j);
                FabricUIManager.this.mMountItemDispatcher.tryDispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e) {
                FLog.e(FabricUIManager.TAG, "Exception thrown when executing UIFrameGuarded", (Throwable) e);
                stop();
                throw e;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }
    }
}
