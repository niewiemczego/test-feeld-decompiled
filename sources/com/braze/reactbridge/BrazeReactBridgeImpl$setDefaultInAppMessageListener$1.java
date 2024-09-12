package com.braze.reactbridge;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.inappmessage.listeners.DefaultInAppMessageManagerListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/braze/reactbridge/BrazeReactBridgeImpl$setDefaultInAppMessageListener$1", "Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageManagerListener;", "beforeInAppMessageDisplayed", "Lcom/braze/ui/inappmessage/InAppMessageOperation;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "braze_react-native-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
public final class BrazeReactBridgeImpl$setDefaultInAppMessageListener$1 extends DefaultInAppMessageManagerListener {
    final /* synthetic */ BrazeReactBridgeImpl this$0;

    BrazeReactBridgeImpl$setDefaultInAppMessageListener$1(BrazeReactBridgeImpl brazeReactBridgeImpl) {
        this.this$0 = brazeReactBridgeImpl;
    }

    public InAppMessageOperation beforeInAppMessageDisplayed(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        WritableMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("inAppMessage", ((JSONObject) iInAppMessage.forJsonPut()).toString());
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.this$0.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("inAppMessageReceived", writableNativeMap);
        return this.this$0.inAppMessageDisplayOperation;
    }
}
