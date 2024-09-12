package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.systrace.Systrace;

public class TouchesHelper {
    public static final String CHANGED_TOUCHES_KEY = "changedTouches";
    private static final String LOCATION_X_KEY = "locationX";
    private static final String LOCATION_Y_KEY = "locationY";
    private static final String PAGE_X_KEY = "pageX";
    private static final String PAGE_Y_KEY = "pageY";
    private static final String POINTER_IDENTIFIER_KEY = "identifier";
    private static final String TAG = "TouchesHelper";
    public static final String TARGET_KEY = "target";
    public static final String TARGET_SURFACE_KEY = "targetSurface";
    private static final String TIMESTAMP_KEY = "timestamp";
    public static final String TOUCHES_KEY = "touches";

    private static WritableMap[] createPointersArray(TouchEvent touchEvent) {
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableMap[] writableMapArr = new WritableMap[motionEvent.getPointerCount()];
        float x = motionEvent.getX() - touchEvent.getViewX();
        float y = motionEvent.getY() - touchEvent.getViewY();
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble(PAGE_X_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i)));
            createMap.putDouble(PAGE_Y_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i)));
            createMap.putDouble(LOCATION_X_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getX(i) - x));
            createMap.putDouble(LOCATION_Y_KEY, (double) PixelUtil.toDIPFromPixel(motionEvent.getY(i) - y));
            createMap.putInt(TARGET_SURFACE_KEY, touchEvent.getSurfaceId());
            createMap.putInt(TARGET_KEY, touchEvent.getViewTag());
            createMap.putDouble("timestamp", (double) touchEvent.getTimestampMs());
            createMap.putDouble("identifier", (double) motionEvent.getPointerId(i));
            writableMapArr[i] = createMap;
        }
        return writableMapArr;
    }

    public static void sendTouchesLegacy(RCTEventEmitter rCTEventEmitter, TouchEvent touchEvent) {
        TouchEventType touchEventType = touchEvent.getTouchEventType();
        WritableArray writableArray = getWritableArray(false, createPointersArray(touchEvent));
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        WritableArray createArray = Arguments.createArray();
        if (touchEventType == TouchEventType.MOVE || touchEventType == TouchEventType.CANCEL) {
            for (int i = 0; i < motionEvent.getPointerCount(); i++) {
                createArray.pushInt(i);
            }
        } else if (touchEventType == TouchEventType.START || touchEventType == TouchEventType.END) {
            createArray.pushInt(motionEvent.getActionIndex());
        } else {
            throw new RuntimeException("Unknown touch type: " + touchEventType);
        }
        rCTEventEmitter.receiveTouches(TouchEventType.getJSEventName(touchEventType), writableArray, createArray);
    }

    public static void sendTouchEvent(RCTModernEventEmitter rCTModernEventEmitter, TouchEvent touchEvent) {
        WritableMap[] writableMapArr;
        WritableMap[] writableMapArr2;
        Systrace.beginSection(0, "TouchesHelper.sentTouchEventModern(" + touchEvent.getEventName() + ")");
        TouchEventType touchEventType = touchEvent.getTouchEventType();
        MotionEvent motionEvent = touchEvent.getMotionEvent();
        if (motionEvent == null) {
            ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot dispatch a TouchEvent that has no MotionEvent; the TouchEvent has been recycled"));
            return;
        }
        WritableMap[] createPointersArray = createPointersArray(touchEvent);
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$uimanager$events$TouchEventType[touchEventType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int actionIndex = motionEvent.getActionIndex();
                WritableMap writableMap = createPointersArray[actionIndex];
                createPointersArray[actionIndex] = null;
                writableMapArr2 = new WritableMap[]{writableMap};
            } else if (i == 3) {
                writableMapArr2 = new WritableMap[createPointersArray.length];
                for (int i2 = 0; i2 < createPointersArray.length; i2++) {
                    writableMapArr2[i2] = createPointersArray[i2].copy();
                }
            } else if (i != 4) {
                writableMapArr = createPointersArray;
                createPointersArray = null;
            } else {
                writableMapArr = new WritableMap[0];
            }
            WritableMap[] writableMapArr3 = createPointersArray;
            createPointersArray = writableMapArr2;
            writableMapArr = writableMapArr3;
        } else {
            writableMapArr = createPointersArray;
            createPointersArray = new WritableMap[]{createPointersArray[motionEvent.getActionIndex()].copy()};
        }
        for (WritableMap copy : createPointersArray) {
            WritableMap copy2 = copy.copy();
            WritableArray writableArray = getWritableArray(true, createPointersArray);
            WritableArray writableArray2 = getWritableArray(true, writableMapArr);
            copy2.putArray(CHANGED_TOUCHES_KEY, writableArray);
            copy2.putArray(TOUCHES_KEY, writableArray2);
            rCTModernEventEmitter.receiveEvent(touchEvent.getSurfaceId(), touchEvent.getViewTag(), touchEvent.getEventName(), touchEvent.canCoalesce(), 0, copy2, touchEvent.getEventCategory());
        }
        Systrace.endSection(0);
    }

    /* renamed from: com.facebook.react.uimanager.events.TouchesHelper$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$uimanager$events$TouchEventType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.facebook.react.uimanager.events.TouchEventType[] r0 = com.facebook.react.uimanager.events.TouchEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$uimanager$events$TouchEventType = r0
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.START     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.END     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.MOVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$uimanager$events$TouchEventType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.uimanager.events.TouchEventType r1 = com.facebook.react.uimanager.events.TouchEventType.CANCEL     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.events.TouchesHelper.AnonymousClass1.<clinit>():void");
        }
    }

    private static WritableArray getWritableArray(boolean z, WritableMap... writableMapArr) {
        WritableArray createArray = Arguments.createArray();
        for (WritableMap writableMap : writableMapArr) {
            if (writableMap != null) {
                if (z) {
                    writableMap = writableMap.copy();
                }
                createArray.pushMap(writableMap);
            }
        }
        return createArray;
    }
}
