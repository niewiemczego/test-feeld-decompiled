package com.adapty.react;

import androidx.exifinterface.media.ExifInterface;
import com.adapty.Adapty;
import com.adapty.internal.crossplatform.CrossplatformHelper;
import com.adapty.internal.crossplatform.CrossplatformName;
import com.adapty.internal.crossplatform.MetaInfo;
import com.adapty.listeners.OnProfileUpdatedListener;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.util.JSStackTrace;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J \u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0017\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u00020\u000b\"\n\b\u0000\u0010\u001d\u0018\u0001*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u001e2\u0006\u0010\f\u001a\u00020\u001f2\u0006\u0010 \u001a\u0002H\u001dH\b¢\u0006\u0002\u0010!R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/adapty/react/AdaptyReactModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "callHandler", "Lcom/adapty/react/AdaptyCallHandler;", "ctx", "listenerCount", "", "addListener", "", "eventName", "", "getConstants", "", "", "getName", "handle", "methodName", "args", "Lcom/facebook/react/bridge/ReadableMap;", "promise", "Lcom/facebook/react/bridge/Promise;", "initialize", "removeListeners", "count", "(Ljava/lang/Integer;)V", "sendEvent", "T", "Lcom/facebook/react/bridge/ReactContext;", "Lcom/adapty/react/EventName;", "params", "(Lcom/facebook/react/bridge/ReactContext;Lcom/adapty/react/EventName;Ljava/lang/Object;)V", "react-native-adapty_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AdaptyReactModule.kt */
public final class AdaptyReactModule extends ReactContextBaseJavaModule {
    private final AdaptyCallHandler callHandler;
    /* access modifiers changed from: private */
    public final ReactApplicationContext ctx;
    private int listenerCount;

    public String getName() {
        return "RNAdapty";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdaptyReactModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        this.ctx = reactApplicationContext;
        this.callHandler = new AdaptyCallHandler(reactApplicationContext, new AdaptyReactModule$callHandler$1(this));
    }

    public void initialize() {
        super.initialize();
        CrossplatformHelper.Companion.init(MetaInfo.Companion.from(CrossplatformName.REACT_NATIVE, "2.10.1"));
    }

    public Map<String, Object> getConstants() {
        return MapsKt.hashMapOf(TuplesKt.to("HANDLER", "handle"));
    }

    private final /* synthetic */ <T> void sendEvent(ReactContext reactContext, EventName eventName, T t) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        String simpleName = Reflection.getOrCreateKotlinClass(Object.class).getSimpleName();
        if (simpleName == null) {
            simpleName = "Any";
        }
        AdaptyBridgeResult adaptyBridgeResult = new AdaptyBridgeResult(t, simpleName);
        Class cls = DeviceEventManagerModule.RCTDeviceEventEmitter.class;
        Class cls2 = cls;
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(cls)).emit(eventName.getValue(), CrossplatformHelper.Companion.getShared().toJson(adaptyBridgeResult));
    }

    @ReactMethod
    public final void addListener(String str) {
        this.listenerCount++;
    }

    @ReactMethod
    public final void removeListeners(Integer num) {
        int i = this.listenerCount - 1;
        this.listenerCount = i;
        if (i == 0) {
            Adapty.setOnProfileUpdatedListener((OnProfileUpdatedListener) null);
        }
    }

    @ReactMethod
    public final void handle(String str, ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(readableMap, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.callHandler.handle(new AdaptyContext(str, readableMap, promise, getCurrentActivity()));
    }
}
