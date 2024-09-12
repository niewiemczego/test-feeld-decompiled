package expo.modules.kotlin.events;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.kotlin.records.Record;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J!\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011H\u0001J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u001a0\u001aH\u0001J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u001bH\u0016J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001cH\u0016J)\u0010\f\u001a\u00020\r2\u000e\u0010\u0013\u001a\n \u0012*\u0004\u0018\u00010\u00140\u00142\u000e\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u001a0\u001aH\u0001R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "Lexpo/modules/kotlin/events/EventEmitter;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "legacyEventEmitter", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/core/interfaces/services/EventEmitter;Ljava/lang/ref/WeakReference;)V", "deviceEventEmitter", "Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "getDeviceEventEmitter", "()Lcom/facebook/react/modules/core/DeviceEventManagerModule$RCTDeviceEventEmitter;", "emit", "", "viewId", "", "event", "Lexpo/modules/core/interfaces/services/EventEmitter$Event;", "kotlin.jvm.PlatformType", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "Landroid/os/Bundle;", "Lexpo/modules/kotlin/records/Record;", "", "UIEvent", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KModuleEventEmitterWrapper.kt */
public class KEventEmitterWrapper implements EventEmitter, EventEmitter {
    private final EventEmitter legacyEventEmitter;
    private final WeakReference<ReactApplicationContext> reactContextHolder;

    public void emit(int i, EventEmitter.Event event) {
        this.legacyEventEmitter.emit(i, event);
    }

    public void emit(int i, String str, Bundle bundle) {
        this.legacyEventEmitter.emit(i, str, bundle);
    }

    public void emit(String str, Bundle bundle) {
        this.legacyEventEmitter.emit(str, bundle);
    }

    public KEventEmitterWrapper(EventEmitter eventEmitter, WeakReference<ReactApplicationContext> weakReference) {
        Intrinsics.checkNotNullParameter(eventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(weakReference, "reactContextHolder");
        this.legacyEventEmitter = eventEmitter;
        this.reactContextHolder = weakReference;
    }

    private final DeviceEventManagerModule.RCTDeviceEventEmitter getDeviceEventEmitter() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        return null;
    }

    public void emit(String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(str, writableMap);
        }
    }

    public void emit(String str, Record record) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(str, JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, record, (JSTypeConverter.ContainerProvider) null, 2, (Object) null));
        }
    }

    public void emit(String str, Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        DeviceEventManagerModule.RCTDeviceEventEmitter deviceEventEmitter = getDeviceEventEmitter();
        if (deviceEventEmitter != null) {
            deviceEventEmitter.emit(str, JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, map, (JSTypeConverter.ContainerProvider) null, 2, (Object) null));
        }
    }

    public void emit(int i, String str, WritableMap writableMap, Short sh) {
        EventDispatcher eventDispatcherForReactTag;
        Intrinsics.checkNotNullParameter(str, "eventName");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null && (eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactApplicationContext, i)) != null) {
            eventDispatcherForReactTag.dispatchEvent(new UIEvent(i, str, writableMap, sh));
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0016R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/events/KEventEmitterWrapper$UIEvent;", "Lcom/facebook/react/uimanager/events/Event;", "viewId", "", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "Ljava/lang/Short;", "canCoalesce", "", "getCoalescingKey", "getEventData", "getEventName", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: KModuleEventEmitterWrapper.kt */
    private static final class UIEvent extends Event<UIEvent> {
        private final Short coalescingKey;
        private final WritableMap eventBody;
        private final String eventName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UIEvent(int i, String str, WritableMap writableMap, Short sh) {
            super(i);
            Intrinsics.checkNotNullParameter(str, "eventName");
            this.eventName = str;
            this.eventBody = writableMap;
            this.coalescingKey = sh;
        }

        public String getEventName() {
            return KModuleEventEmitterWrapperKt.normalizeEventName(this.eventName);
        }

        public boolean canCoalesce() {
            return this.coalescingKey != null;
        }

        public short getCoalescingKey() {
            Short sh = this.coalescingKey;
            if (sh != null) {
                return sh.shortValue();
            }
            return 0;
        }

        /* access modifiers changed from: protected */
        public WritableMap getEventData() {
            WritableMap writableMap = this.eventBody;
            if (writableMap != null) {
                return writableMap;
            }
            WritableMap createMap = Arguments.createMap();
            Intrinsics.checkNotNullExpressionValue(createMap, "createMap()");
            return createMap;
        }
    }
}
