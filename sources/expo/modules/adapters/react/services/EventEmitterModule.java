package expo.modules.adapters.react.services;

import android.os.Bundle;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import expo.modules.adapters.react.views.ViewManagerAdapterUtils;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.services.EventEmitter;
import java.util.Collections;
import java.util.List;

public class EventEmitterModule implements EventEmitter, InternalModule {
    private ReactContext mReactContext;

    public EventEmitterModule(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    public void emit(String str, Bundle bundle) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, Arguments.fromBundle(bundle));
    }

    public void emit(int i, EventEmitter.Event event) {
        UIManagerHelper.getEventDispatcherForReactTag(this.mReactContext, i).dispatchEvent(getReactEventFromEvent(i, event));
    }

    public void emit(int i, String str, Bundle bundle) {
        final String str2 = str;
        final int i2 = i;
        final Bundle bundle2 = bundle;
        UIManagerHelper.getEventDispatcherForReactTag(this.mReactContext, i).dispatchEvent(new Event(i) {
            public boolean canCoalesce() {
                return false;
            }

            public short getCoalescingKey() {
                return 0;
            }

            public String getEventName() {
                return ViewManagerAdapterUtils.normalizeEventName(str2);
            }

            public void dispatch(RCTEventEmitter rCTEventEmitter) {
                int i = i2;
                String eventName = getEventName();
                Bundle bundle = bundle2;
                rCTEventEmitter.receiveEvent(i, eventName, bundle != null ? Arguments.fromBundle(bundle) : null);
            }
        });
    }

    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(EventEmitter.class);
    }

    private static Event getReactEventFromEvent(final int i, final EventEmitter.Event event) {
        return new Event(i) {
            public String getEventName() {
                return ViewManagerAdapterUtils.normalizeEventName(event.getEventName());
            }

            public void dispatch(RCTEventEmitter rCTEventEmitter) {
                rCTEventEmitter.receiveEvent(i, getEventName(), Arguments.fromBundle(event.getEventBody()));
            }

            public boolean canCoalesce() {
                return event.canCoalesce();
            }

            public short getCoalescingKey() {
                return event.getCoalescingKey();
            }
        };
    }
}
