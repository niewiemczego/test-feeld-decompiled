package com.facebook.react.uimanager;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.TouchTargetHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.PointerEvent;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSPointerDispatcher {
    private static final float ONMOVE_EPSILON = 0.1f;
    private static final String TAG = "POINTER EVENTS";
    private static final int UNSET_POINTER_ID = -1;
    private int mChildHandlingNativeGesture = -1;
    private int mCoalescingKey = 0;
    private int mLastButtonState = 0;
    private Map<Integer, float[]> mLastEventCoordinatesByPointerId;
    private Map<Integer, List<TouchTargetHelper.ViewTarget>> mLastHitPathByPointerId;
    private int mPrimaryPointerId = -1;
    private final ViewGroup mRootViewGroup;

    public JSPointerDispatcher(ViewGroup viewGroup) {
        this.mRootViewGroup = viewGroup;
    }

    public void onChildStartedNativeGesture(View view, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildHandlingNativeGesture == -1 && view != null) {
            dispatchCancelEvent(motionEvent, eventDispatcher);
            this.mChildHandlingNativeGesture = view.getId();
        }
    }

    public void onChildEndedNativeGesture() {
        this.mChildHandlingNativeGesture = -1;
    }

    private void onUp(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        boolean supportsHover = PointerEventHelper.supportsHover(motionEvent);
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.UP, PointerEventHelper.EVENT.UP_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_UP, i, pointerEventState, motionEvent));
        }
        if (!supportsHover) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OUT, i, pointerEventState, motionEvent));
            }
            dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent, filterByShouldDispatch(list, PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, false), eventDispatcher);
        }
        if (motionEvent.getActionMasked() == 1) {
            this.mPrimaryPointerId = -1;
        }
    }

    private void incrementCoalescingKey() {
        this.mCoalescingKey = (this.mCoalescingKey + 1) % Integer.MAX_VALUE;
    }

    private short getCoalescingKey() {
        return (short) (this.mCoalescingKey & 65535);
    }

    private void onDown(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        incrementCoalescingKey();
        if (!PointerEventHelper.supportsHover(motionEvent)) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OVER, i, pointerEventState, motionEvent));
            }
            List<TouchTargetHelper.ViewTarget> filterByShouldDispatch = filterByShouldDispatch(list, PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, false);
            Collections.reverse(filterByShouldDispatch);
            dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, pointerEventState, motionEvent, filterByShouldDispatch, eventDispatcher);
        }
        if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.DOWN, PointerEventHelper.EVENT.DOWN_CAPTURE)) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_DOWN, i, pointerEventState, motionEvent));
        }
    }

    private PointerEvent.PointerEventState createEventState(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (int i = 0; i < motionEvent.getPointerCount(); i++) {
            float[] fArr = new float[2];
            float y = motionEvent.getY(i);
            float[] fArr2 = {motionEvent.getX(i), y};
            List<TouchTargetHelper.ViewTarget> findTargetPathAndCoordinatesForTouch = TouchTargetHelper.findTargetPathAndCoordinatesForTouch(fArr2[0], y, this.mRootViewGroup, fArr);
            int pointerId = motionEvent.getPointerId(i);
            hashMap.put(Integer.valueOf(pointerId), fArr);
            hashMap2.put(Integer.valueOf(pointerId), findTargetPathAndCoordinatesForTouch);
            hashMap3.put(Integer.valueOf(pointerId), fArr2);
        }
        return new PointerEvent.PointerEventState(this.mPrimaryPointerId, motionEvent.getPointerId(actionIndex), this.mLastButtonState, UIManagerHelper.getSurfaceId((View) this.mRootViewGroup), hashMap, hashMap2, hashMap3);
    }

    public void handleMotionEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        if (this.mChildHandlingNativeGesture == -1) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.mPrimaryPointerId = motionEvent.getPointerId(0);
            }
            PointerEvent.PointerEventState createEventState = createEventState(motionEvent);
            List list = createEventState.getHitPathByPointerId().get(Integer.valueOf(createEventState.getActivePointerId()));
            if (list != null && !list.isEmpty()) {
                int viewId = ((TouchTargetHelper.ViewTarget) list.get(0)).getViewId();
                if (actionMasked != 0) {
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                dispatchCancelEvent(createEventState, motionEvent, eventDispatcher);
                            } else if (actionMasked != 5) {
                                if (actionMasked != 6) {
                                    if (actionMasked != 7) {
                                        FLog.w(ReactConstants.TAG, "Warning : Motion Event was ignored. Action=" + actionMasked + " Target=" + viewId);
                                        return;
                                    }
                                    onMove(viewId, createEventState, motionEvent, eventDispatcher);
                                }
                            }
                        } else if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.MOVE, PointerEventHelper.EVENT.MOVE_CAPTURE)) {
                            eventDispatcher.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_MOVE, viewId, createEventState, motionEvent, getCoalescingKey()));
                        }
                        this.mLastHitPathByPointerId = createEventState.getHitPathByPointerId();
                        this.mLastEventCoordinatesByPointerId = createEventState.getEventCoordinatesByPointerId();
                        this.mLastButtonState = motionEvent.getButtonState();
                    }
                    incrementCoalescingKey();
                    onUp(viewId, createEventState, motionEvent, eventDispatcher);
                    this.mLastHitPathByPointerId = createEventState.getHitPathByPointerId();
                    this.mLastEventCoordinatesByPointerId = createEventState.getEventCoordinatesByPointerId();
                    this.mLastButtonState = motionEvent.getButtonState();
                }
                onDown(viewId, createEventState, motionEvent, eventDispatcher);
                this.mLastHitPathByPointerId = createEventState.getHitPathByPointerId();
                this.mLastEventCoordinatesByPointerId = createEventState.getEventCoordinatesByPointerId();
                this.mLastButtonState = motionEvent.getButtonState();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isAnyoneListeningForBubblingEvent(java.util.List<com.facebook.react.uimanager.TouchTargetHelper.ViewTarget> r2, com.facebook.react.uimanager.events.PointerEventHelper.EVENT r3, com.facebook.react.uimanager.events.PointerEventHelper.EVENT r4) {
        /*
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r2.next()
            com.facebook.react.uimanager.TouchTargetHelper$ViewTarget r0 = (com.facebook.react.uimanager.TouchTargetHelper.ViewTarget) r0
            android.view.View r1 = r0.getView()
            boolean r1 = com.facebook.react.uimanager.events.PointerEventHelper.isListening(r1, r3)
            if (r1 != 0) goto L_0x0024
            android.view.View r0 = r0.getView()
            boolean r0 = com.facebook.react.uimanager.events.PointerEventHelper.isListening(r0, r4)
            if (r0 == 0) goto L_0x0004
        L_0x0024:
            r2 = 1
            return r2
        L_0x0026:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.JSPointerDispatcher.isAnyoneListeningForBubblingEvent(java.util.List, com.facebook.react.uimanager.events.PointerEventHelper$EVENT, com.facebook.react.uimanager.events.PointerEventHelper$EVENT):boolean");
    }

    private static List<TouchTargetHelper.ViewTarget> filterByShouldDispatch(List<TouchTargetHelper.ViewTarget> list, PointerEventHelper.EVENT event, PointerEventHelper.EVENT event2, boolean z) {
        ArrayList arrayList = new ArrayList(list);
        if (z) {
            return arrayList;
        }
        boolean z2 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            View view = list.get(size).getView();
            if (!z2 && !PointerEventHelper.isListening(view, event2) && !PointerEventHelper.isListening(view, event)) {
                arrayList.remove(size);
            } else if (!z2 && PointerEventHelper.isListening(view, event2)) {
                z2 = true;
            }
        }
        return arrayList;
    }

    private void dispatchEventForViewTargets(String str, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, List<TouchTargetHelper.ViewTarget> list, EventDispatcher eventDispatcher) {
        for (TouchTargetHelper.ViewTarget viewId : list) {
            eventDispatcher.dispatchEvent(PointerEvent.obtain(str, viewId.getViewId(), pointerEventState, motionEvent));
        }
    }

    private void onMove(int i, PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        List list;
        int i2 = i;
        PointerEvent.PointerEventState pointerEventState2 = pointerEventState;
        MotionEvent motionEvent2 = motionEvent;
        EventDispatcher eventDispatcher2 = eventDispatcher;
        int activePointerId = pointerEventState.getActivePointerId();
        float[] fArr = pointerEventState.getEventCoordinatesByPointerId().get(Integer.valueOf(activePointerId));
        List list2 = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(activePointerId));
        Map<Integer, List<TouchTargetHelper.ViewTarget>> map = this.mLastHitPathByPointerId;
        if (map == null || !map.containsKey(Integer.valueOf(activePointerId))) {
            list = new ArrayList();
        } else {
            list = this.mLastHitPathByPointerId.get(Integer.valueOf(activePointerId));
        }
        Map<Integer, float[]> map2 = this.mLastEventCoordinatesByPointerId;
        float[] fArr2 = (map2 == null || !map2.containsKey(Integer.valueOf(activePointerId))) ? new float[]{0.0f, 0.0f} : this.mLastEventCoordinatesByPointerId.get(Integer.valueOf(activePointerId));
        boolean z = true;
        if (Math.abs(fArr2[0] - fArr[0]) > 0.1f || Math.abs(fArr2[1] - fArr[1]) > 0.1f) {
            boolean z2 = false;
            int i3 = 0;
            boolean z3 = false;
            while (i3 < Math.min(list2.size(), list.size()) && ((TouchTargetHelper.ViewTarget) list2.get((list2.size() - 1) - i3)).equals(list.get((list.size() - 1) - i3))) {
                View view = ((TouchTargetHelper.ViewTarget) list2.get((list2.size() - 1) - i3)).getView();
                if (!z3 && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.ENTER_CAPTURE)) {
                    z3 = true;
                }
                if (!z2 && PointerEventHelper.isListening(view, PointerEventHelper.EVENT.LEAVE_CAPTURE)) {
                    z2 = true;
                }
                i3++;
            }
            if (i3 >= Math.max(list2.size(), list.size())) {
                z = false;
            }
            if (z) {
                incrementCoalescingKey();
                if (list.size() > 0) {
                    int viewId = ((TouchTargetHelper.ViewTarget) list.get(0)).getViewId();
                    if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.OUT, PointerEventHelper.EVENT.OUT_CAPTURE)) {
                        eventDispatcher2.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OUT, viewId, pointerEventState2, motionEvent2));
                    }
                    List<TouchTargetHelper.ViewTarget> filterByShouldDispatch = filterByShouldDispatch(list.subList(0, list.size() - i3), PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, z2);
                    if (filterByShouldDispatch.size() > 0) {
                        dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent, filterByShouldDispatch, eventDispatcher);
                    }
                }
                if (isAnyoneListeningForBubblingEvent(list2, PointerEventHelper.EVENT.OVER, PointerEventHelper.EVENT.OVER_CAPTURE)) {
                    eventDispatcher2.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_OVER, i2, pointerEventState2, motionEvent2));
                }
                List<TouchTargetHelper.ViewTarget> filterByShouldDispatch2 = filterByShouldDispatch(list2.subList(0, list2.size() - i3), PointerEventHelper.EVENT.ENTER, PointerEventHelper.EVENT.ENTER_CAPTURE, z3);
                if (filterByShouldDispatch2.size() > 0) {
                    Collections.reverse(filterByShouldDispatch2);
                    dispatchEventForViewTargets(PointerEventHelper.POINTER_ENTER, pointerEventState, motionEvent, filterByShouldDispatch2, eventDispatcher);
                }
            }
            if (isAnyoneListeningForBubblingEvent(list2, PointerEventHelper.EVENT.MOVE, PointerEventHelper.EVENT.MOVE_CAPTURE)) {
                eventDispatcher2.dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_MOVE, i2, pointerEventState2, motionEvent2, getCoalescingKey()));
            }
        }
    }

    private void dispatchCancelEvent(MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Assertions.assertCondition(this.mChildHandlingNativeGesture == -1, "Expected to not have already sent a cancel for this gesture");
        dispatchCancelEvent(createEventState(motionEvent), motionEvent, eventDispatcher);
    }

    private void dispatchCancelEvent(PointerEvent.PointerEventState pointerEventState, MotionEvent motionEvent, EventDispatcher eventDispatcher) {
        Assertions.assertCondition(this.mChildHandlingNativeGesture == -1, "Expected to not have already sent a cancel for this gesture");
        List list = pointerEventState.getHitPathByPointerId().get(Integer.valueOf(pointerEventState.getActivePointerId()));
        if (!list.isEmpty()) {
            if (isAnyoneListeningForBubblingEvent(list, PointerEventHelper.EVENT.CANCEL, PointerEventHelper.EVENT.CANCEL_CAPTURE)) {
                ((EventDispatcher) Assertions.assertNotNull(eventDispatcher)).dispatchEvent(PointerEvent.obtain(PointerEventHelper.POINTER_CANCEL, ((TouchTargetHelper.ViewTarget) list.get(0)).getViewId(), pointerEventState, motionEvent));
            }
            dispatchEventForViewTargets(PointerEventHelper.POINTER_LEAVE, pointerEventState, motionEvent, filterByShouldDispatch(list, PointerEventHelper.EVENT.LEAVE, PointerEventHelper.EVENT.LEAVE_CAPTURE, false), eventDispatcher);
            incrementCoalescingKey();
            this.mPrimaryPointerId = -1;
        }
    }

    private void debugPrintHitPath(List<TouchTargetHelper.ViewTarget> list) {
        StringBuilder sb = new StringBuilder("hitPath: ");
        for (TouchTargetHelper.ViewTarget viewId : list) {
            sb.append(String.format("%d, ", new Object[]{Integer.valueOf(viewId.getViewId())}));
        }
        FLog.d(TAG, sb.toString());
    }
}
