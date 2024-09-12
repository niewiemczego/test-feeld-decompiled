package com.swmansion.gesturehandler.core;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 ¿\u0001*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002:\u0006¾\u0001¿\u0001À\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010`\u001a\u00020aJ\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020\u001dH\u0016J\u0010\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020dH\u0002J\u0010\u0010f\u001a\u00020a2\u0006\u0010g\u001a\u00020RH\u0002J\u0010\u0010h\u001a\u00020a2\u0006\u0010g\u001a\u00020RH\u0002J*\u0010i\u001a\u00028\u00002\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020a0k¢\u0006\u0002\blH\bø\u0001\u0000¢\u0006\u0002\u0010mJ\u0006\u0010n\u001a\u00020aJ\u0006\u0010o\u001a\u00020aJ\b\u0010p\u001a\u00020aH\u0002J\b\u0010q\u001a\u0004\u0018\u00010\u000eJ\b\u0010r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010s\u001a\n u*\u0004\u0018\u00010t0t2\u0006\u0010g\u001a\u00020RH\u0002J\u0010\u0010v\u001a\u00020a2\u0006\u0010e\u001a\u00020dH\u0016J\u0018\u0010w\u001a\u00020a2\u0006\u0010x\u001a\u00020\u00052\u0006\u0010y\u001a\u00020\u0005H\u0016J\u0010\u0010z\u001a\u00020a2\u0006\u0010e\u001a\u00020dH\u0002J\b\u0010{\u001a\u00020aH\u0016J\u0010\u0010|\u001a\u00020a2\u0006\u0010e\u001a\u00020dH\u0002J\u0010\u0010}\u001a\u00020a2\u0006\u0010e\u001a\u00020dH\u0002J\u0006\u0010~\u001a\u00020aJ\b\u0010\u001a\u00020aH\u0002J\u0007\u0010\u0001\u001a\u00020aJ\t\u0010\u0001\u001a\u00020\u0005H\u0002J\u0018\u0010\u0001\u001a\u0005\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0019\u0010\u0001\u001a\u00020a2\u0007\u0010\u0001\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020dJ\u0014\u0010\u0001\u001a\u00020\u001d2\u000b\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000J\"\u0010$\u001a\u00020\u001d2\b\u0010X\u001a\u0004\u0018\u00010W2\u0007\u0010\u0001\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%J\u0011\u0010\u0001\u001a\u00020a2\u0006\u0010x\u001a\u00020\u0005H\u0002J\u0011\u0010\u0001\u001a\u00020\u001d2\u0006\u0010e\u001a\u00020dH\u0002J\t\u0010\u0001\u001a\u00020aH\u0014J\u001a\u0010\u0001\u001a\u00020a2\u0006\u0010e\u001a\u00020d2\u0007\u0010\u0001\u001a\u00020dH\u0014J\t\u0010\u0001\u001a\u00020aH\u0014J\t\u0010\u0001\u001a\u00020aH\u0014J\u001a\u0010\u0001\u001a\u00020a2\u0006\u0010x\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0014J\u001b\u0010\u0001\u001a\u00020a2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010=\u001a\u0004\u0018\u00010>J\u0007\u0010\u0001\u001a\u00020aJ\t\u0010\u0001\u001a\u00020aH\u0016J\t\u0010\u0001\u001a\u00020aH\u0016J\u000f\u0010\u0001\u001a\u00028\u0000H\u0004¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00028\u00002\u0007\u0010\u0001\u001a\u00020%¢\u0006\u0003\u0010 \u0001JC\u0010\u0001\u001a\u00028\u00002\u0007\u0010¡\u0001\u001a\u00020%2\u0007\u0010¢\u0001\u001a\u00020%2\u0007\u0010£\u0001\u001a\u00020%2\u0007\u0010¤\u0001\u001a\u00020%2\u0007\u0010¥\u0001\u001a\u00020%2\u0007\u0010¦\u0001\u001a\u00020%¢\u0006\u0003\u0010§\u0001J\u0018\u0010¨\u0001\u001a\u00028\u00002\t\u0010©\u0001\u001a\u0004\u0018\u00010\u001b¢\u0006\u0003\u0010ª\u0001J\u0015\u0010«\u0001\u001a\u00028\u00002\u0006\u00105\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010¬\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\t\u0010­\u0001\u001a\u0004\u0018\u00010<J\u0015\u0010®\u0001\u001a\u00028\u00002\u0006\u0010C\u001a\u00020\u001d¢\u0006\u0003\u0010\u0001J\u0016\u0010¯\u0001\u001a\u00020\u001d2\u000b\u0010°\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0016\u0010±\u0001\u001a\u00020\u001d2\u000b\u0010°\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0016\u0010²\u0001\u001a\u00020\u001d2\u000b\u0010°\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\u0014\u0010³\u0001\u001a\u00020\u001d2\u000b\u0010°\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000J\u0010\u0010´\u0001\u001a\u00020a2\u0007\u0010µ\u0001\u001a\u00020\u0005J\u0010\u0010¶\u0001\u001a\u00020a2\u0007\u0010µ\u0001\u001a\u00020\u0005J\n\u0010·\u0001\u001a\u00030¸\u0001H\u0016J\u0014\u0010¹\u0001\u001a\u00030º\u00012\b\u0010»\u0001\u001a\u00030º\u0001H\u0004J\u000f\u0010¼\u0001\u001a\u00020a2\u0006\u0010e\u001a\u00020dJ\u0007\u0010½\u0001\u001a\u00020\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0014@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 R\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u001e\u0010$\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u001d@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u001e\u0010&\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u000e\u0010+\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b.\u0010(R\u0011\u0010/\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b0\u0010(R\u0011\u00101\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b2\u0010(R\u0011\u00103\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b4\u0010(R\u000e\u00105\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\u001e\u00109\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u000e\u0010C\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u001e\"\u0004\bF\u0010 R\u001e\u0010G\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0007R\u001a\u0010I\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR\u001e\u0010L\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\u0007R\u000e\u0010N\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010P\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010R0QX\u0004¢\u0006\u0004\n\u0002\u0010SR\u001e\u0010T\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007R\u000e\u0010V\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\"\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\r\u001a\u0004\u0018\u00010W@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u000e\u0010[\u001a\u00020OX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\\\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b]\u0010(R\u001e\u0010^\u001a\u00020%2\u0006\u0010\r\u001a\u00020%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b_\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006Á\u0001"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler;", "ConcreteGestureHandlerT", "", "()V", "actionType", "", "getActionType", "()I", "setActionType", "(I)V", "activationIndex", "getActivationIndex", "setActivationIndex", "<set-?>", "Lcom/facebook/react/bridge/WritableArray;", "allTouchesPayload", "getAllTouchesPayload", "()Lcom/facebook/react/bridge/WritableArray;", "changedTouchesPayload", "getChangedTouchesPayload", "", "eventCoalescingKey", "getEventCoalescingKey", "()S", "hitSlop", "", "interactionController", "Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;", "isActive", "", "()Z", "setActive", "(Z)V", "isAwaiting", "setAwaiting", "isEnabled", "isWithinBounds", "", "lastAbsolutePositionX", "getLastAbsolutePositionX", "()F", "lastAbsolutePositionY", "getLastAbsolutePositionY", "lastEventOffsetX", "lastEventOffsetY", "lastPositionInWindowX", "getLastPositionInWindowX", "lastPositionInWindowY", "getLastPositionInWindowY", "lastRelativePositionX", "getLastRelativePositionX", "lastRelativePositionY", "getLastRelativePositionY", "manualActivation", "needsPointerData", "getNeedsPointerData", "setNeedsPointerData", "numberOfPointers", "getNumberOfPointers", "onTouchEventListener", "Lcom/swmansion/gesturehandler/core/OnTouchEventListener;", "orchestrator", "Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "getOrchestrator", "()Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;", "setOrchestrator", "(Lcom/swmansion/gesturehandler/core/GestureHandlerOrchestrator;)V", "shouldCancelWhenOutside", "shouldResetProgress", "getShouldResetProgress", "setShouldResetProgress", "state", "getState", "tag", "getTag", "setTag", "touchEventType", "getTouchEventType", "trackedPointerIDs", "", "trackedPointers", "", "Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "[Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "trackedPointersCount", "getTrackedPointersCount", "trackedPointersIDsCount", "Landroid/view/View;", "view", "getView", "()Landroid/view/View;", "windowOffset", "x", "getX", "y", "getY", "activate", "", "force", "adaptEvent", "Landroid/view/MotionEvent;", "event", "addChangedPointer", "pointerData", "addPointerToAll", "applySelf", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "begin", "cancel", "cancelPointers", "consumeAllTouchesPayload", "consumeChangedTouchesPayload", "createPointerData", "Lcom/facebook/react/bridge/WritableMap;", "kotlin.jvm.PlatformType", "dispatchHandlerUpdate", "dispatchStateChange", "newState", "prevState", "dispatchTouchDownEvent", "dispatchTouchEvent", "dispatchTouchMoveEvent", "dispatchTouchUpEvent", "end", "extractAllPointersData", "fail", "findNextLocalPointerId", "getWindow", "Landroid/view/Window;", "context", "Landroid/content/Context;", "handle", "transformedEvent", "sourceEvent", "hasCommonPointers", "other", "posX", "posY", "moveToState", "needAdapt", "onCancel", "onHandle", "onPrepare", "onReset", "onStateChange", "previousState", "prepare", "reset", "resetConfig", "resetProgress", "self", "()Lcom/swmansion/gesturehandler/core/GestureHandler;", "setEnabled", "enabled", "(Z)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setHitSlop", "padding", "(F)Lcom/swmansion/gesturehandler/core/GestureHandler;", "leftPad", "topPad", "rightPad", "bottomPad", "width", "height", "(FFFFFF)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setInteractionController", "controller", "(Lcom/swmansion/gesturehandler/core/GestureHandlerInteractionController;)Lcom/swmansion/gesturehandler/core/GestureHandler;", "setManualActivation", "setOnTouchEventListener", "listener", "setShouldCancelWhenOutside", "shouldBeCancelledBy", "handler", "shouldRecognizeSimultaneously", "shouldRequireToWaitForFailure", "shouldWaitForHandlerFailure", "startTrackingPointer", "pointerId", "stopTrackingPointer", "toString", "", "transformPoint", "Landroid/graphics/PointF;", "point", "updatePointerData", "wantEvents", "AdaptEventException", "Companion", "PointerData", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GestureHandler.kt */
public class GestureHandler<ConcreteGestureHandlerT extends GestureHandler<ConcreteGestureHandlerT>> {
    public static final int ACTION_TYPE_JS_FUNCTION_NEW_API = 4;
    public static final int ACTION_TYPE_JS_FUNCTION_OLD_API = 3;
    public static final int ACTION_TYPE_NATIVE_ANIMATED_EVENT = 2;
    public static final int ACTION_TYPE_REANIMATED_WORKLET = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private static final int HIT_SLOP_BOTTOM_IDX = 3;
    private static final int HIT_SLOP_HEIGHT_IDX = 5;
    private static final int HIT_SLOP_LEFT_IDX = 0;
    public static final float HIT_SLOP_NONE = Float.NaN;
    private static final int HIT_SLOP_RIGHT_IDX = 2;
    private static final int HIT_SLOP_TOP_IDX = 1;
    private static final int HIT_SLOP_WIDTH_IDX = 4;
    private static final int MAX_POINTERS_COUNT = 12;
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_BEGAN = 2;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_END = 5;
    public static final int STATE_FAILED = 1;
    public static final int STATE_UNDETERMINED = 0;
    private static short nextEventCoalescingKey;
    /* access modifiers changed from: private */
    public static MotionEvent.PointerCoords[] pointerCoords;
    /* access modifiers changed from: private */
    public static MotionEvent.PointerProperties[] pointerProps;
    private int actionType;
    private int activationIndex;
    private WritableArray allTouchesPayload;
    private WritableArray changedTouchesPayload;
    private short eventCoalescingKey;
    private float[] hitSlop;
    private GestureHandlerInteractionController interactionController;
    private boolean isActive;
    private boolean isAwaiting;
    private boolean isEnabled;
    private boolean isWithinBounds;
    private float lastAbsolutePositionX;
    private float lastAbsolutePositionY;
    private float lastEventOffsetX;
    private float lastEventOffsetY;
    private boolean manualActivation;
    private boolean needsPointerData;
    private int numberOfPointers;
    private OnTouchEventListener onTouchEventListener;
    private GestureHandlerOrchestrator orchestrator;
    private boolean shouldCancelWhenOutside;
    private boolean shouldResetProgress;
    private int state;
    private int tag;
    private int touchEventType;
    /* access modifiers changed from: private */
    public final int[] trackedPointerIDs = new int[12];
    private final PointerData[] trackedPointers;
    private int trackedPointersCount;
    /* access modifiers changed from: private */
    public int trackedPointersIDsCount;
    private View view;
    private final int[] windowOffset;
    private float x;
    private float y;

    /* access modifiers changed from: protected */
    public void onCancel() {
    }

    /* access modifiers changed from: protected */
    public void onPrepare() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStateChange(int i, int i2) {
    }

    public void resetProgress() {
    }

    public GestureHandler() {
        int[] iArr = new int[2];
        for (int i = 0; i < 2; i++) {
            iArr[i] = 0;
        }
        this.windowOffset = iArr;
        this.isEnabled = true;
        PointerData[] pointerDataArr = new PointerData[12];
        for (int i2 = 0; i2 < 12; i2++) {
            pointerDataArr[i2] = null;
        }
        this.trackedPointers = pointerDataArr;
    }

    public final int getTag() {
        return this.tag;
    }

    public final void setTag(int i) {
        this.tag = i;
    }

    public final View getView() {
        return this.view;
    }

    public final int getState() {
        return this.state;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final boolean isWithinBounds() {
        return this.isWithinBounds;
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final void setActionType(int i) {
        this.actionType = i;
    }

    public final WritableArray getChangedTouchesPayload() {
        return this.changedTouchesPayload;
    }

    public final WritableArray getAllTouchesPayload() {
        return this.allTouchesPayload;
    }

    public final int getTouchEventType() {
        return this.touchEventType;
    }

    public final int getTrackedPointersCount() {
        return this.trackedPointersCount;
    }

    public final boolean getNeedsPointerData() {
        return this.needsPointerData;
    }

    public final void setNeedsPointerData(boolean z) {
        this.needsPointerData = z;
    }

    public final short getEventCoalescingKey() {
        return this.eventCoalescingKey;
    }

    public final float getLastAbsolutePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastAbsolutePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final int getNumberOfPointers() {
        return this.numberOfPointers;
    }

    /* access modifiers changed from: protected */
    public final GestureHandlerOrchestrator getOrchestrator() {
        return this.orchestrator;
    }

    /* access modifiers changed from: protected */
    public final void setOrchestrator(GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        this.orchestrator = gestureHandlerOrchestrator;
    }

    /* access modifiers changed from: protected */
    public final ConcreteGestureHandlerT self() {
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type ConcreteGestureHandlerT of com.swmansion.gesturehandler.core.GestureHandler");
        GestureHandler gestureHandler = this;
        return this;
    }

    /* access modifiers changed from: protected */
    public final ConcreteGestureHandlerT applySelf(Function1<? super ConcreteGestureHandlerT, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ConcreteGestureHandlerT access$self = self();
        function1.invoke(access$self);
        return access$self;
    }

    public final int getActivationIndex() {
        return this.activationIndex;
    }

    public final void setActivationIndex(int i) {
        this.activationIndex = i;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final void setActive(boolean z) {
        this.isActive = z;
    }

    public final boolean isAwaiting() {
        return this.isAwaiting;
    }

    public final void setAwaiting(boolean z) {
        this.isAwaiting = z;
    }

    public final boolean getShouldResetProgress() {
        return this.shouldResetProgress;
    }

    public final void setShouldResetProgress(boolean z) {
        this.shouldResetProgress = z;
    }

    public void dispatchStateChange(int i, int i2) {
        OnTouchEventListener onTouchEventListener2 = this.onTouchEventListener;
        if (onTouchEventListener2 != null) {
            onTouchEventListener2.onStateChange(self(), i, i2);
        }
    }

    public void dispatchHandlerUpdate(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        OnTouchEventListener onTouchEventListener2 = this.onTouchEventListener;
        if (onTouchEventListener2 != null) {
            onTouchEventListener2.onHandlerUpdate(self(), motionEvent);
        }
    }

    public void dispatchTouchEvent() {
        OnTouchEventListener onTouchEventListener2;
        if (this.changedTouchesPayload != null && (onTouchEventListener2 = this.onTouchEventListener) != null) {
            onTouchEventListener2.onTouchEvent(self());
        }
    }

    public void resetConfig() {
        this.needsPointerData = false;
        this.manualActivation = false;
        this.shouldCancelWhenOutside = false;
        this.isEnabled = true;
        this.hitSlop = null;
    }

    public final boolean hasCommonPointers(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "other");
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            if (this.trackedPointerIDs[i] != -1 && gestureHandler.trackedPointerIDs[i] != -1) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: setEnabled$lambda-3$lambda-2  reason: not valid java name */
    public static final void m631setEnabled$lambda3$lambda2(GestureHandler gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "$this_applySelf");
        gestureHandler.cancel();
    }

    public final ConcreteGestureHandlerT setHitSlop(float f) {
        return setHitSlop(f, f, f, f, Float.NaN, Float.NaN);
    }

    public final void prepare(View view2, GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        if (this.view == null && this.orchestrator == null) {
            Arrays.fill(this.trackedPointerIDs, -1);
            this.trackedPointersIDsCount = 0;
            this.state = 0;
            this.view = view2;
            this.orchestrator = gestureHandlerOrchestrator;
            View view3 = null;
            Window window = getWindow(view2 != null ? view2.getContext() : null);
            if (window != null) {
                view3 = window.getDecorView();
            }
            if (view3 != null) {
                Rect rect = new Rect();
                view3.getWindowVisibleDisplayFrame(rect);
                this.windowOffset[0] = rect.left;
                this.windowOffset[1] = rect.top;
            } else {
                int[] iArr = this.windowOffset;
                iArr[0] = 0;
                iArr[1] = 0;
            }
            onPrepare();
            return;
        }
        throw new IllegalStateException("Already prepared or hasn't been reset".toString());
    }

    private final Window getWindow(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow();
        }
        if (context instanceof ContextWrapper) {
            return getWindow(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    private final int findNextLocalPointerId() {
        int[] iArr;
        int i = 0;
        while (i < this.trackedPointersIDsCount) {
            int i2 = 0;
            while (true) {
                iArr = this.trackedPointerIDs;
                if (i2 < iArr.length && iArr[i2] != i) {
                    i2++;
                }
            }
            if (i2 == iArr.length) {
                return i;
            }
            i++;
        }
        return i;
    }

    public final void startTrackingPointer(int i) {
        int[] iArr = this.trackedPointerIDs;
        if (iArr[i] == -1) {
            iArr[i] = findNextLocalPointerId();
            this.trackedPointersIDsCount++;
        }
    }

    public final void stopTrackingPointer(int i) {
        int[] iArr = this.trackedPointerIDs;
        if (iArr[i] != -1) {
            iArr[i] = -1;
            this.trackedPointersIDsCount--;
        }
    }

    private final boolean needAdapt(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.trackedPointersIDsCount) {
            return true;
        }
        int length = this.trackedPointerIDs.length;
        for (int i = 0; i < length; i++) {
            int i2 = this.trackedPointerIDs[i];
            if (i2 != -1 && i2 != i) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v1, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v2, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: android.view.MotionEvent$PointerCoords} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: android.view.MotionEvent$PointerProperties[]} */
    /* JADX WARNING: type inference failed for: r6v11, types: [android.view.MotionEvent$PointerCoords[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00b6 A[EDGE_INSN: B:80:0x00b6->B:42:0x00b6 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.view.MotionEvent adaptEvent(android.view.MotionEvent r27) {
        /*
            r26 = this;
            r1 = r26
            r2 = r27
            boolean r0 = r26.needAdapt(r27)
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            int r0 = r27.getActionMasked()
            r3 = 2
            r4 = 5
            r5 = -1
            r7 = 1
            if (r0 == 0) goto L_0x0035
            r8 = 6
            if (r0 == r7) goto L_0x001f
            if (r0 == r4) goto L_0x0035
            if (r0 == r8) goto L_0x001f
            r3 = r0
            r0 = r5
            goto L_0x004a
        L_0x001f:
            int r0 = r27.getActionIndex()
            int r4 = r2.getPointerId(r0)
            int[] r9 = r1.trackedPointerIDs
            r4 = r9[r4]
            if (r4 == r5) goto L_0x004a
            int r3 = r1.trackedPointersIDsCount
            if (r3 != r7) goto L_0x0033
            r3 = r7
            goto L_0x004a
        L_0x0033:
            r3 = r8
            goto L_0x004a
        L_0x0035:
            int r0 = r27.getActionIndex()
            int r8 = r2.getPointerId(r0)
            int[] r9 = r1.trackedPointerIDs
            r8 = r9[r8]
            if (r8 == r5) goto L_0x004a
            int r3 = r1.trackedPointersIDsCount
            if (r3 != r7) goto L_0x0049
            r3 = 0
            goto L_0x004a
        L_0x0049:
            r3 = r4
        L_0x004a:
            com.swmansion.gesturehandler.core.GestureHandler$Companion r4 = Companion
            int r8 = r1.trackedPointersIDsCount
            r4.initPointerProps(r8)
            float r4 = r27.getRawX()
            float r8 = r27.getX()
            float r4 = r4 - r8
            float r8 = r27.getRawY()
            float r9 = r27.getY()
            float r8 = r8 - r9
            r2.offsetLocation(r4, r8)
            int r9 = r27.getPointerCount()
            r14 = r3
            r3 = 0
            r15 = 0
        L_0x006d:
            java.lang.String r10 = "pointerCoords"
            java.lang.String r11 = "pointerProps"
            r12 = 0
            if (r3 >= r9) goto L_0x00b6
            int r13 = r2.getPointerId(r3)
            int[] r6 = r1.trackedPointerIDs
            r6 = r6[r13]
            if (r6 == r5) goto L_0x00b3
            android.view.MotionEvent$PointerProperties[] r6 = pointerProps
            if (r6 != 0) goto L_0x0086
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r6 = r12
        L_0x0086:
            r6 = r6[r15]
            r2.getPointerProperties(r3, r6)
            android.view.MotionEvent$PointerProperties[] r6 = pointerProps
            if (r6 != 0) goto L_0x0093
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r6 = r12
        L_0x0093:
            r6 = r6[r15]
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            int[] r11 = r1.trackedPointerIDs
            r11 = r11[r13]
            r6.id = r11
            android.view.MotionEvent$PointerCoords[] r6 = pointerCoords
            if (r6 != 0) goto L_0x00a6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            goto L_0x00a7
        L_0x00a6:
            r12 = r6
        L_0x00a7:
            r6 = r12[r15]
            r2.getPointerCoords(r3, r6)
            if (r3 != r0) goto L_0x00b1
            int r6 = r15 << 8
            r14 = r14 | r6
        L_0x00b1:
            int r15 = r15 + 1
        L_0x00b3:
            int r3 = r3 + 1
            goto L_0x006d
        L_0x00b6:
            android.view.MotionEvent$PointerProperties[] r0 = pointerProps
            if (r0 != 0) goto L_0x00be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            r0 = r12
        L_0x00be:
            int r0 = r0.length
            if (r0 != 0) goto L_0x00c3
            r0 = r7
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            if (r0 != 0) goto L_0x012f
            android.view.MotionEvent$PointerCoords[] r0 = pointerCoords
            if (r0 != 0) goto L_0x00ce
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r0 = r12
        L_0x00ce:
            int r0 = r0.length
            if (r0 != 0) goto L_0x00d3
            r6 = r7
            goto L_0x00d4
        L_0x00d3:
            r6 = 0
        L_0x00d4:
            if (r6 == 0) goto L_0x00d7
            goto L_0x012f
        L_0x00d7:
            long r5 = r27.getDownTime()     // Catch:{ IllegalArgumentException -> 0x0128 }
            long r16 = r27.getEventTime()     // Catch:{ IllegalArgumentException -> 0x0128 }
            android.view.MotionEvent$PointerProperties[] r0 = pointerProps     // Catch:{ IllegalArgumentException -> 0x0128 }
            if (r0 != 0) goto L_0x00e7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r0 = r12
        L_0x00e7:
            android.view.MotionEvent$PointerCoords[] r3 = pointerCoords     // Catch:{ IllegalArgumentException -> 0x0128 }
            if (r3 != 0) goto L_0x00ef
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)     // Catch:{ IllegalArgumentException -> 0x0128 }
            r3 = r12
        L_0x00ef:
            int r18 = r27.getMetaState()     // Catch:{ IllegalArgumentException -> 0x0128 }
            int r19 = r27.getButtonState()     // Catch:{ IllegalArgumentException -> 0x0128 }
            float r20 = r27.getXPrecision()     // Catch:{ IllegalArgumentException -> 0x0128 }
            float r21 = r27.getYPrecision()     // Catch:{ IllegalArgumentException -> 0x0128 }
            int r22 = r27.getDeviceId()     // Catch:{ IllegalArgumentException -> 0x0128 }
            int r23 = r27.getEdgeFlags()     // Catch:{ IllegalArgumentException -> 0x0128 }
            int r24 = r27.getSource()     // Catch:{ IllegalArgumentException -> 0x0128 }
            int r25 = r27.getFlags()     // Catch:{ IllegalArgumentException -> 0x0128 }
            r10 = r5
            r12 = r16
            r16 = r0
            r17 = r3
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r10, r12, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ IllegalArgumentException -> 0x0128 }
            java.lang.String r3 = "obtain(\n        event.do…      event.flags\n      )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ IllegalArgumentException -> 0x0128 }
            float r3 = -r4
            float r4 = -r8
            r2.offsetLocation(r3, r4)
            r0.offsetLocation(r3, r4)
            return r0
        L_0x0128:
            r0 = move-exception
            com.swmansion.gesturehandler.core.GestureHandler$AdaptEventException r3 = new com.swmansion.gesturehandler.core.GestureHandler$AdaptEventException
            r3.<init>(r1, r2, r0)
            throw r3
        L_0x012f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "pointerCoords.size="
            java.lang.StringBuilder r2 = r2.append(r3)
            android.view.MotionEvent$PointerCoords[] r3 = pointerCoords
            if (r3 != 0) goto L_0x0144
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r3 = r12
        L_0x0144:
            int r3 = r3.length
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = ", pointerProps.size="
            java.lang.StringBuilder r2 = r2.append(r3)
            android.view.MotionEvent$PointerProperties[] r3 = pointerProps
            if (r3 != 0) goto L_0x0157
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)
            goto L_0x0158
        L_0x0157:
            r12 = r3
        L_0x0158:
            int r3 = r12.length
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.GestureHandler.adaptEvent(android.view.MotionEvent):android.view.MotionEvent");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$AdaptEventException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handler", "Lcom/swmansion/gesturehandler/core/GestureHandler;", "event", "Landroid/view/MotionEvent;", "e", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "(Lcom/swmansion/gesturehandler/core/GestureHandler;Landroid/view/MotionEvent;Ljava/lang/IllegalArgumentException;)V", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GestureHandler.kt */
    public static final class AdaptEventException extends Exception {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdaptEventException(GestureHandler<?> gestureHandler, MotionEvent motionEvent, IllegalArgumentException illegalArgumentException) {
            super(StringsKt.trimIndent("\n    handler: " + Reflection.getOrCreateKotlinClass(gestureHandler.getClass()).getSimpleName() + "\n    state: " + gestureHandler.getState() + "\n    view: " + gestureHandler.getView() + "\n    orchestrator: " + gestureHandler.getOrchestrator() + "\n    isEnabled: " + gestureHandler.isEnabled() + "\n    isActive: " + gestureHandler.isActive() + "\n    isAwaiting: " + gestureHandler.isAwaiting() + "\n    trackedPointersCount: " + gestureHandler.trackedPointersIDsCount + "\n    trackedPointers: " + ArraysKt.joinToString$default(gestureHandler.trackedPointerIDs, (CharSequence) ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + "\n    while handling event: " + motionEvent + "\n    "), illegalArgumentException);
            Intrinsics.checkNotNullParameter(gestureHandler, "handler");
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            Intrinsics.checkNotNullParameter(illegalArgumentException, "e");
        }
    }

    public final void handle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        int i;
        Intrinsics.checkNotNullParameter(motionEvent, "transformedEvent");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        if (this.isEnabled && (i = this.state) != 3 && i != 1 && i != 5 && this.trackedPointersIDsCount >= 1) {
            try {
                MotionEvent adaptEvent = adaptEvent(motionEvent2);
                MotionEvent motionEvent3 = new MotionEvent[]{adaptEvent(motionEvent), adaptEvent}[0];
                this.x = motionEvent3.getX();
                this.y = motionEvent3.getY();
                this.numberOfPointers = motionEvent3.getPointerCount();
                boolean isWithinBounds2 = isWithinBounds(this.view, this.x, this.y);
                this.isWithinBounds = isWithinBounds2;
                if (!this.shouldCancelWhenOutside || isWithinBounds2) {
                    this.lastAbsolutePositionX = GestureUtils.INSTANCE.getLastPointerX(motionEvent3, true);
                    this.lastAbsolutePositionY = GestureUtils.INSTANCE.getLastPointerY(motionEvent3, true);
                    this.lastEventOffsetX = motionEvent3.getRawX() - motionEvent3.getX();
                    this.lastEventOffsetY = motionEvent3.getRawY() - motionEvent3.getY();
                    onHandle(motionEvent3, adaptEvent);
                    if (!Intrinsics.areEqual((Object) motionEvent3, (Object) motionEvent)) {
                        motionEvent3.recycle();
                    }
                    if (!Intrinsics.areEqual((Object) adaptEvent, (Object) motionEvent2)) {
                        adaptEvent.recycle();
                        return;
                    }
                    return;
                }
                int i2 = this.state;
                if (i2 == 4) {
                    cancel();
                } else if (i2 == 2) {
                    fail();
                }
            } catch (AdaptEventException unused) {
                fail();
            }
        }
    }

    private final void dispatchTouchDownEvent(MotionEvent motionEvent) {
        this.changedTouchesPayload = null;
        this.touchEventType = 1;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        this.trackedPointers[pointerId] = new PointerData(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent.getX(motionEvent.getActionIndex()) + (motionEvent.getRawX() - motionEvent.getX())) - ((float) this.windowOffset[0]), (motionEvent.getY(motionEvent.getActionIndex()) + (motionEvent.getRawY() - motionEvent.getY())) - ((float) this.windowOffset[1]));
        this.trackedPointersCount++;
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        extractAllPointersData();
        dispatchTouchEvent();
    }

    private final void dispatchTouchUpEvent(MotionEvent motionEvent) {
        extractAllPointersData();
        this.changedTouchesPayload = null;
        this.touchEventType = 3;
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        this.trackedPointers[pointerId] = new PointerData(pointerId, motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex()), (motionEvent.getX(motionEvent.getActionIndex()) + (motionEvent.getRawX() - motionEvent.getX())) - ((float) this.windowOffset[0]), (motionEvent.getY(motionEvent.getActionIndex()) + (motionEvent.getRawY() - motionEvent.getY())) - ((float) this.windowOffset[1]));
        PointerData pointerData = this.trackedPointers[pointerId];
        Intrinsics.checkNotNull(pointerData);
        addChangedPointer(pointerData);
        this.trackedPointers[pointerId] = null;
        this.trackedPointersCount--;
        dispatchTouchEvent();
    }

    private final void dispatchTouchMoveEvent(MotionEvent motionEvent) {
        this.changedTouchesPayload = null;
        this.touchEventType = 2;
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            PointerData pointerData = this.trackedPointers[motionEvent.getPointerId(i2)];
            if (pointerData != null) {
                if (pointerData.getX() == motionEvent.getX(i2)) {
                    if (pointerData.getY() == motionEvent.getY(i2)) {
                    }
                }
                pointerData.setX(motionEvent.getX(i2));
                pointerData.setY(motionEvent.getY(i2));
                pointerData.setAbsoluteX((motionEvent.getX(i2) + rawX) - ((float) this.windowOffset[0]));
                pointerData.setAbsoluteY((motionEvent.getY(i2) + rawY) - ((float) this.windowOffset[1]));
                addChangedPointer(pointerData);
                i++;
            }
        }
        if (i > 0) {
            extractAllPointersData();
            dispatchTouchEvent();
        }
    }

    public final void updatePointerData(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getActionMasked() == 0 || motionEvent.getActionMasked() == 5) {
            dispatchTouchDownEvent(motionEvent);
            dispatchTouchMoveEvent(motionEvent);
        } else if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 6) {
            dispatchTouchMoveEvent(motionEvent);
            dispatchTouchUpEvent(motionEvent);
        } else if (motionEvent.getActionMasked() == 2) {
            dispatchTouchMoveEvent(motionEvent);
        }
    }

    private final void extractAllPointersData() {
        this.allTouchesPayload = null;
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addPointerToAll(pointerData);
            }
        }
    }

    private final void cancelPointers() {
        this.touchEventType = 4;
        this.changedTouchesPayload = null;
        extractAllPointersData();
        for (PointerData pointerData : this.trackedPointers) {
            if (pointerData != null) {
                addChangedPointer(pointerData);
            }
        }
        this.trackedPointersCount = 0;
        ArraysKt.fill$default((Object[]) this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        dispatchTouchEvent();
    }

    private final void addChangedPointer(PointerData pointerData) {
        if (this.changedTouchesPayload == null) {
            this.changedTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.changedTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final void addPointerToAll(PointerData pointerData) {
        if (this.allTouchesPayload == null) {
            this.allTouchesPayload = Arguments.createArray();
        }
        WritableArray writableArray = this.allTouchesPayload;
        Intrinsics.checkNotNull(writableArray);
        writableArray.pushMap(createPointerData(pointerData));
    }

    private final WritableMap createPointerData(PointerData pointerData) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("id", pointerData.getPointerId());
        createMap.putDouble(ViewHierarchyNode.JsonKeys.X, (double) PixelUtil.toDIPFromPixel(pointerData.getX()));
        createMap.putDouble(ViewHierarchyNode.JsonKeys.Y, (double) PixelUtil.toDIPFromPixel(pointerData.getY()));
        createMap.putDouble("absoluteX", (double) PixelUtil.toDIPFromPixel(pointerData.getAbsoluteX()));
        createMap.putDouble("absoluteY", (double) PixelUtil.toDIPFromPixel(pointerData.getAbsoluteY()));
        return createMap;
    }

    public final WritableArray consumeChangedTouchesPayload() {
        WritableArray writableArray = this.changedTouchesPayload;
        this.changedTouchesPayload = null;
        return writableArray;
    }

    public final WritableArray consumeAllTouchesPayload() {
        WritableArray writableArray = this.allTouchesPayload;
        this.allTouchesPayload = null;
        return writableArray;
    }

    private final void moveToState(int i) {
        UiThreadUtil.assertOnUiThread();
        if (this.state != i) {
            if (this.trackedPointersCount > 0 && (i == 5 || i == 3 || i == 1)) {
                cancelPointers();
            }
            int i2 = this.state;
            this.state = i;
            if (i == 4) {
                short s = nextEventCoalescingKey;
                nextEventCoalescingKey = (short) (s + 1);
                this.eventCoalescingKey = s;
            }
            GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
            Intrinsics.checkNotNull(gestureHandlerOrchestrator);
            gestureHandlerOrchestrator.onHandlerStateChange(this, i, i2);
            onStateChange(i, i2);
        }
    }

    public final boolean wantEvents() {
        int i;
        if (!this.isEnabled || (i = this.state) == 1 || i == 3 || i == 5 || this.trackedPointersIDsCount <= 0) {
            return false;
        }
        return true;
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler<?> gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if (gestureHandler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldRequireHandlerToWaitForFailure(this, gestureHandler);
    }

    public final boolean shouldWaitForHandlerFailure(GestureHandler<?> gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if (gestureHandler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldWaitForHandlerFailure(this, gestureHandler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if (gestureHandler == this) {
            return true;
        }
        GestureHandlerInteractionController gestureHandlerInteractionController = this.interactionController;
        if (gestureHandlerInteractionController != null) {
            return gestureHandlerInteractionController.shouldRecognizeSimultaneously(this, gestureHandler);
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler<?> gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        Intrinsics.checkNotNullParameter(gestureHandler, "handler");
        if (gestureHandler == this || (gestureHandlerInteractionController = this.interactionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldHandlerBeCancelledBy(this, gestureHandler);
    }

    public final boolean isWithinBounds(View view2, float f, float f2) {
        float f3;
        Intrinsics.checkNotNull(view2);
        float width = (float) view2.getWidth();
        float height = (float) view2.getHeight();
        float[] fArr = this.hitSlop;
        float f4 = 0.0f;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            Companion companion = Companion;
            float f9 = companion.hitSlopSet(f5) ? 0.0f - f5 : 0.0f;
            if (companion.hitSlopSet(f6)) {
                f4 = 0.0f - f6;
            }
            if (companion.hitSlopSet(f7)) {
                width += f7;
            }
            if (companion.hitSlopSet(f8)) {
                height += f8;
            }
            float f10 = fArr[4];
            float f11 = fArr[5];
            if (companion.hitSlopSet(f10)) {
                if (!companion.hitSlopSet(f5)) {
                    f9 = width - f10;
                } else if (!companion.hitSlopSet(f7)) {
                    width = f10 + f9;
                }
            }
            if (companion.hitSlopSet(f11)) {
                if (!companion.hitSlopSet(f6)) {
                    f4 = height - f11;
                } else if (!companion.hitSlopSet(f8)) {
                    height = f11 + f4;
                }
            }
            f3 = f4;
            f4 = f9;
        } else {
            f3 = 0.0f;
        }
        if (f4 <= f && f <= width) {
            if (f3 <= f2 && f2 <= height) {
                return true;
            }
        }
        return false;
    }

    public final void cancel() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            onCancel();
            moveToState(3);
        }
    }

    public final void fail() {
        int i = this.state;
        if (i == 4 || i == 0 || i == 2) {
            moveToState(1);
        }
    }

    public final void activate() {
        activate(false);
    }

    public void activate(boolean z) {
        if (!this.manualActivation || z) {
            int i = this.state;
            if (i == 0 || i == 2) {
                moveToState(4);
            }
        }
    }

    public final void begin() {
        if (this.state == 0) {
            moveToState(2);
        }
    }

    public final void end() {
        int i = this.state;
        if (i == 2 || i == 4) {
            moveToState(5);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent, MotionEvent motionEvent2) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        Intrinsics.checkNotNullParameter(motionEvent2, "sourceEvent");
        moveToState(1);
    }

    /* access modifiers changed from: protected */
    public final PointF transformPoint(PointF pointF) {
        PointF transformPointToViewCoords;
        Intrinsics.checkNotNullParameter(pointF, "point");
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.orchestrator;
        if (gestureHandlerOrchestrator != null && (transformPointToViewCoords = gestureHandlerOrchestrator.transformPointToViewCoords(this.view, pointF)) != null) {
            return transformPointToViewCoords;
        }
        GestureHandler gestureHandler = this;
        pointF.x = Float.NaN;
        pointF.y = Float.NaN;
        return pointF;
    }

    public final void reset() {
        this.view = null;
        this.orchestrator = null;
        Arrays.fill(this.trackedPointerIDs, -1);
        this.trackedPointersIDsCount = 0;
        this.trackedPointersCount = 0;
        ArraysKt.fill$default((Object[]) this.trackedPointers, (Object) null, 0, 0, 6, (Object) null);
        this.touchEventType = 0;
        onReset();
    }

    public final GestureHandler<?> setOnTouchEventListener(OnTouchEventListener onTouchEventListener2) {
        this.onTouchEventListener = onTouchEventListener2;
        return this;
    }

    public String toString() {
        String str;
        View view2 = this.view;
        if (view2 == null) {
            str = null;
        } else {
            Intrinsics.checkNotNull(view2);
            str = view2.getClass().getSimpleName();
        }
        return getClass().getSimpleName() + "@[" + this.tag + "]:" + str;
    }

    public final float getLastRelativePositionX() {
        return this.lastAbsolutePositionX;
    }

    public final float getLastRelativePositionY() {
        return this.lastAbsolutePositionY;
    }

    public final float getLastPositionInWindowX() {
        return (this.lastAbsolutePositionX + this.lastEventOffsetX) - ((float) this.windowOffset[0]);
    }

    public final float getLastPositionInWindowY() {
        return (this.lastAbsolutePositionY + this.lastEventOffsetY) - ((float) this.windowOffset[1]);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0010H\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0004H\u0002J\u0010\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eX.¢\u0006\u0004\n\u0002\u0010 R\u0018\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001eX.¢\u0006\u0004\n\u0002\u0010#¨\u0006-"}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$Companion;", "", "()V", "ACTION_TYPE_JS_FUNCTION_NEW_API", "", "ACTION_TYPE_JS_FUNCTION_OLD_API", "ACTION_TYPE_NATIVE_ANIMATED_EVENT", "ACTION_TYPE_REANIMATED_WORKLET", "DIRECTION_DOWN", "DIRECTION_LEFT", "DIRECTION_RIGHT", "DIRECTION_UP", "HIT_SLOP_BOTTOM_IDX", "HIT_SLOP_HEIGHT_IDX", "HIT_SLOP_LEFT_IDX", "HIT_SLOP_NONE", "", "HIT_SLOP_RIGHT_IDX", "HIT_SLOP_TOP_IDX", "HIT_SLOP_WIDTH_IDX", "MAX_POINTERS_COUNT", "STATE_ACTIVE", "STATE_BEGAN", "STATE_CANCELLED", "STATE_END", "STATE_FAILED", "STATE_UNDETERMINED", "nextEventCoalescingKey", "", "pointerCoords", "", "Landroid/view/MotionEvent$PointerCoords;", "[Landroid/view/MotionEvent$PointerCoords;", "pointerProps", "Landroid/view/MotionEvent$PointerProperties;", "[Landroid/view/MotionEvent$PointerProperties;", "hitSlopSet", "", "value", "initPointerProps", "", "size", "stateToString", "", "state", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GestureHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String stateToString(int i) {
            if (i == 0) {
                return "UNDETERMINED";
            }
            if (i == 1) {
                return "FAILED";
            }
            if (i == 2) {
                return "BEGIN";
            }
            if (i == 3) {
                return "CANCELLED";
            }
            if (i == 4) {
                return "ACTIVE";
            }
            if (i != 5) {
                return null;
            }
            return "END";
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void initPointerProps(int i) {
            if (GestureHandler.pointerProps == null) {
                GestureHandler.pointerProps = new MotionEvent.PointerProperties[12];
                GestureHandler.pointerCoords = new MotionEvent.PointerCoords[12];
            }
            while (i > 0) {
                MotionEvent.PointerProperties[] access$getPointerProps$cp = GestureHandler.pointerProps;
                MotionEvent.PointerCoords[] pointerCoordsArr = null;
                if (access$getPointerProps$cp == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                    access$getPointerProps$cp = null;
                }
                int i2 = i - 1;
                if (access$getPointerProps$cp[i2] == null) {
                    MotionEvent.PointerProperties[] access$getPointerProps$cp2 = GestureHandler.pointerProps;
                    if (access$getPointerProps$cp2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerProps");
                        access$getPointerProps$cp2 = null;
                    }
                    access$getPointerProps$cp2[i2] = new MotionEvent.PointerProperties();
                    MotionEvent.PointerCoords[] access$getPointerCoords$cp = GestureHandler.pointerCoords;
                    if (access$getPointerCoords$cp == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pointerCoords");
                    } else {
                        pointerCoordsArr = access$getPointerCoords$cp;
                    }
                    pointerCoordsArr[i2] = new MotionEvent.PointerCoords();
                    i--;
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean hitSlopSet(float f) {
            return !Float.isNaN(f);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006\""}, d2 = {"Lcom/swmansion/gesturehandler/core/GestureHandler$PointerData;", "", "pointerId", "", "x", "", "y", "absoluteX", "absoluteY", "(IFFFF)V", "getAbsoluteX", "()F", "setAbsoluteX", "(F)V", "getAbsoluteY", "setAbsoluteY", "getPointerId", "()I", "getX", "setX", "getY", "setY", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GestureHandler.kt */
    private static final class PointerData {
        private float absoluteX;
        private float absoluteY;
        private final int pointerId;
        private float x;
        private float y;

        public static /* synthetic */ PointerData copy$default(PointerData pointerData, int i, float f, float f2, float f3, float f4, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = pointerData.pointerId;
            }
            if ((i2 & 2) != 0) {
                f = pointerData.x;
            }
            float f5 = f;
            if ((i2 & 4) != 0) {
                f2 = pointerData.y;
            }
            float f6 = f2;
            if ((i2 & 8) != 0) {
                f3 = pointerData.absoluteX;
            }
            float f7 = f3;
            if ((i2 & 16) != 0) {
                f4 = pointerData.absoluteY;
            }
            return pointerData.copy(i, f5, f6, f7, f4);
        }

        public final int component1() {
            return this.pointerId;
        }

        public final float component2() {
            return this.x;
        }

        public final float component3() {
            return this.y;
        }

        public final float component4() {
            return this.absoluteX;
        }

        public final float component5() {
            return this.absoluteY;
        }

        public final PointerData copy(int i, float f, float f2, float f3, float f4) {
            return new PointerData(i, f, f2, f3, f4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PointerData)) {
                return false;
            }
            PointerData pointerData = (PointerData) obj;
            return this.pointerId == pointerData.pointerId && Intrinsics.areEqual((Object) Float.valueOf(this.x), (Object) Float.valueOf(pointerData.x)) && Intrinsics.areEqual((Object) Float.valueOf(this.y), (Object) Float.valueOf(pointerData.y)) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteX), (Object) Float.valueOf(pointerData.absoluteX)) && Intrinsics.areEqual((Object) Float.valueOf(this.absoluteY), (Object) Float.valueOf(pointerData.absoluteY));
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.pointerId) * 31) + Float.hashCode(this.x)) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.absoluteX)) * 31) + Float.hashCode(this.absoluteY);
        }

        public String toString() {
            return "PointerData(pointerId=" + this.pointerId + ", x=" + this.x + ", y=" + this.y + ", absoluteX=" + this.absoluteX + ", absoluteY=" + this.absoluteY + ')';
        }

        public PointerData(int i, float f, float f2, float f3, float f4) {
            this.pointerId = i;
            this.x = f;
            this.y = f2;
            this.absoluteX = f3;
            this.absoluteY = f4;
        }

        public final int getPointerId() {
            return this.pointerId;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final float getAbsoluteX() {
            return this.absoluteX;
        }

        public final void setAbsoluteX(float f) {
            this.absoluteX = f;
        }

        public final float getAbsoluteY() {
            return this.absoluteY;
        }

        public final void setAbsoluteY(float f) {
            this.absoluteY = f;
        }
    }

    public final ConcreteGestureHandlerT setShouldCancelWhenOutside(boolean z) {
        ConcreteGestureHandlerT access$self = self();
        access$self.shouldCancelWhenOutside = z;
        return access$self;
    }

    public final ConcreteGestureHandlerT setEnabled(boolean z) {
        ConcreteGestureHandlerT access$self = self();
        if (!(access$self.view == null || access$self.isEnabled == z)) {
            UiThreadUtil.runOnUiThread(new GestureHandler$$ExternalSyntheticLambda0(access$self));
        }
        access$self.isEnabled = z;
        return access$self;
    }

    public final ConcreteGestureHandlerT setManualActivation(boolean z) {
        ConcreteGestureHandlerT access$self = self();
        access$self.manualActivation = z;
        return access$self;
    }

    public final ConcreteGestureHandlerT setHitSlop(float f, float f2, float f3, float f4, float f5, float f6) {
        ConcreteGestureHandlerT access$self = self();
        if (access$self.hitSlop == null) {
            access$self.hitSlop = new float[6];
        }
        float[] fArr = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr);
        boolean z = false;
        fArr[0] = f;
        float[] fArr2 = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr2);
        fArr2[1] = f2;
        float[] fArr3 = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr3);
        fArr3[2] = f3;
        float[] fArr4 = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr4);
        fArr4[3] = f4;
        float[] fArr5 = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr5);
        fArr5[4] = f5;
        float[] fArr6 = access$self.hitSlop;
        Intrinsics.checkNotNull(fArr6);
        fArr6[5] = f6;
        Companion companion = Companion;
        if (!companion.hitSlopSet(f5) || !companion.hitSlopSet(f) || !companion.hitSlopSet(f3)) {
            if (!companion.hitSlopSet(f5) || companion.hitSlopSet(f) || companion.hitSlopSet(f3)) {
                if (!companion.hitSlopSet(f6) || !companion.hitSlopSet(f4) || !companion.hitSlopSet(f2)) {
                    if (!companion.hitSlopSet(f6) || companion.hitSlopSet(f4) || companion.hitSlopSet(f2)) {
                        z = true;
                    }
                    if (z) {
                        return access$self;
                    }
                    throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined".toString());
                }
                throw new IllegalArgumentException("Cannot have all of top, bottom and height defined".toString());
            }
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined".toString());
        }
        throw new IllegalArgumentException("Cannot have all of left, right and width defined".toString());
    }

    public final ConcreteGestureHandlerT setInteractionController(GestureHandlerInteractionController gestureHandlerInteractionController) {
        ConcreteGestureHandlerT access$self = self();
        access$self.interactionController = gestureHandlerInteractionController;
        return access$self;
    }
}
