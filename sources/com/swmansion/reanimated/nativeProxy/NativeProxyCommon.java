package com.swmansion.reanimated.nativeProxy;

import android.os.SystemClock;
import android.provider.Settings;
import android.util.Log;
import com.facebook.jni.HybridData;
import com.facebook.react.ReactApplication;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.soloader.SoLoader;
import com.swmansion.common.GestureHandlerStateManager;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.reanimated.BuildConfig;
import com.swmansion.reanimated.NativeProxy;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.reanimated.Utils;
import com.swmansion.reanimated.keyboard.KeyboardAnimationManager;
import com.swmansion.reanimated.keyboard.KeyboardWorkletWrapper;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.sensor.ReanimatedSensorContainer;
import com.swmansion.reanimated.sensor.ReanimatedSensorType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class NativeProxyCommon {
    protected String cppVersion;
    private Long firstUptime = Long.valueOf(SystemClock.uptimeMillis());
    private final GestureHandlerStateManager gestureHandlerStateManager;
    private KeyboardAnimationManager keyboardAnimationManager;
    protected AndroidUIScheduler mAndroidUIScheduler;
    protected final WeakReference<ReactApplicationContext> mContext;
    protected NodesManager mNodesManager;
    private ReanimatedSensorContainer reanimatedSensorContainer;
    private boolean slowAnimationsEnabled = false;

    /* access modifiers changed from: protected */
    public abstract HybridData getHybridData();

    public String getReanimatedJavaVersion() {
        return BuildConfig.REANIMATED_VERSION_JAVA;
    }

    /* access modifiers changed from: protected */
    public native void installJSIBindings();

    static {
        SoLoader.loadLibrary("reanimated");
    }

    protected NativeProxyCommon(ReactApplicationContext reactApplicationContext) {
        GestureHandlerStateManager gestureHandlerStateManager2 = null;
        this.cppVersion = null;
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactApplicationContext);
        WeakReference<ReactApplicationContext> weakReference = new WeakReference<>(reactApplicationContext);
        this.mContext = weakReference;
        this.reanimatedSensorContainer = new ReanimatedSensorContainer(weakReference);
        this.keyboardAnimationManager = new KeyboardAnimationManager(weakReference);
        addDevMenuOption();
        try {
            gestureHandlerStateManager2 = (GestureHandlerStateManager) reactApplicationContext.getNativeModule(Class.forName("com.swmansion.gesturehandler.react.RNGestureHandlerModule"));
        } catch (ClassCastException | ClassNotFoundException unused) {
        }
        this.gestureHandlerStateManager = gestureHandlerStateManager2;
    }

    public AndroidUIScheduler getAndroidUIScheduler() {
        return this.mAndroidUIScheduler;
    }

    /* access modifiers changed from: private */
    public void toggleSlowAnimations() {
        boolean z = !this.slowAnimationsEnabled;
        this.slowAnimationsEnabled = z;
        if (z) {
            this.firstUptime = Long.valueOf(SystemClock.uptimeMillis());
        }
    }

    private void addDevMenuOption() {
        if (((ReactApplicationContext) this.mContext.get()).getApplicationContext() instanceof ReactApplication) {
            ((ReactApplication) ((ReactApplicationContext) this.mContext.get()).getApplicationContext()).getReactNativeHost().getReactInstanceManager().getDevSupportManager().addCustomDevOption("Toggle slow animations (Reanimated)", new NativeProxyCommon$$ExternalSyntheticLambda0(this));
        }
    }

    public void requestRender(AnimationFrameCallback animationFrameCallback) {
        this.mNodesManager.postOnAnimation(animationFrameCallback);
    }

    /* access modifiers changed from: protected */
    public void setCppVersion(String str) {
        this.cppVersion = str;
    }

    /* access modifiers changed from: protected */
    public void checkCppVersion() {
        if (this.cppVersion != null) {
            String reanimatedJavaVersion = getReanimatedJavaVersion();
            if (!this.cppVersion.equals(reanimatedJavaVersion)) {
                throw new RuntimeException("[Reanimated] Mismatch between Java code version and C++ code version (" + reanimatedJavaVersion + " vs. " + this.cppVersion + " respectively). See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#mismatch-between-java-code-version-and-c-code-version for more information.");
            }
            return;
        }
        throw new RuntimeException("[Reanimated] Java side failed to resolve C++ code version. See https://docs.swmansion.com/react-native-reanimated/docs/guides/troubleshooting#java-side-failed-to-resolve-c-code-version for more information.");
    }

    public void updateProps(int i, Map<String, Object> map) {
        this.mNodesManager.updateProps(i, map);
    }

    public void synchronouslyUpdateUIProps(int i, ReadableMap readableMap) {
        this.mNodesManager.synchronouslyUpdateUIProps(i, readableMap);
    }

    public String obtainProp(int i, String str) {
        return this.mNodesManager.obtainProp(i, str);
    }

    public void scrollTo(int i, double d, double d2, boolean z) {
        this.mNodesManager.scrollTo(i, d, d2, z);
    }

    public void dispatchCommand(int i, String str, ReadableArray readableArray) {
        this.mNodesManager.dispatchCommand(i, str, readableArray);
    }

    public void setGestureState(int i, int i2) {
        GestureHandlerStateManager gestureHandlerStateManager2 = this.gestureHandlerStateManager;
        if (gestureHandlerStateManager2 != null) {
            gestureHandlerStateManager2.setGestureHandlerState(i, i2);
        }
    }

    public long getAnimationTimestamp() {
        if (this.slowAnimationsEnabled) {
            return this.firstUptime.longValue() + ((SystemClock.uptimeMillis() - this.firstUptime.longValue()) / 10);
        }
        return SystemClock.uptimeMillis();
    }

    public float[] measure(int i) {
        return this.mNodesManager.measure(i);
    }

    public void configureProps(ReadableNativeArray readableNativeArray, ReadableNativeArray readableNativeArray2) {
        this.mNodesManager.configureProps(convertProps(readableNativeArray), convertProps(readableNativeArray2));
    }

    private Set<String> convertProps(ReadableNativeArray readableNativeArray) {
        HashSet hashSet = new HashSet();
        ArrayList<Object> arrayList = readableNativeArray.toArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            hashSet.add((String) arrayList.get(i));
        }
        return hashSet;
    }

    public void registerEventHandler(EventHandler eventHandler) {
        eventHandler.mCustomEventNamesResolver = this.mNodesManager.getEventNameResolver();
        this.mNodesManager.registerEventHandler(eventHandler);
    }

    public int registerSensor(int i, int i2, SensorSetter sensorSetter) {
        return this.reanimatedSensorContainer.registerSensor(ReanimatedSensorType.getInstanceById(i), i2, sensorSetter);
    }

    public void unregisterSensor(int i) {
        this.reanimatedSensorContainer.unregisterSensor(i);
    }

    public int subscribeForKeyboardEvents(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z) {
        return this.keyboardAnimationManager.subscribeForKeyboardUpdates(keyboardWorkletWrapper, z);
    }

    public void unsubscribeFromKeyboardEvents(int i) {
        this.keyboardAnimationManager.unsubscribeFromKeyboardUpdates(i);
    }

    public void invalidate() {
        this.mAndroidUIScheduler.deactivate();
    }

    public void prepareLayoutAnimations(LayoutAnimations layoutAnimations) {
        if (Utils.isChromeDebugger) {
            Log.w("[REANIMATED]", "You can not use LayoutAnimation with enabled Chrome Debugger");
            return;
        }
        this.mNodesManager = ((ReanimatedModule) ((ReactApplicationContext) this.mContext.get()).getNativeModule(ReanimatedModule.class)).getNodesManager();
        ((ReanimatedModule) ((ReactApplicationContext) this.mContext.get()).getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager().setNativeMethods(NativeProxy.createNativeMethodsHolder(layoutAnimations));
    }

    public boolean getIsReducedMotion() {
        String string = Settings.Global.getString(((ReactApplicationContext) this.mContext.get()).getContentResolver(), "transition_animation_scale");
        return (string != null ? Float.parseFloat(string) : 1.0f) == 0.0f;
    }

    /* access modifiers changed from: package-private */
    public void maybeFlushUIUpdatesQueue() {
        if (!this.mNodesManager.isAnimationRunning()) {
            this.mNodesManager.performOperations();
        }
    }
}
