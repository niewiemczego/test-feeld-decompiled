package io.sentry.android.core.internal.gestures;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.IScope;
import io.sentry.ITransaction;
import io.sentry.SentryLevel;
import io.sentry.SpanStatus;
import io.sentry.TransactionContext;
import io.sentry.TransactionOptions;
import io.sentry.TypeCheckHint;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.internal.gestures.UiElement;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.util.TracingUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;

public final class SentryGestureListener implements GestureDetector.OnGestureListener {
    private static final String TRACE_ORIGIN = "auto.ui.gesture_listener";
    static final String UI_ACTION = "ui.action";
    private GestureType activeEventType = GestureType.Unknown;
    private ITransaction activeTransaction = null;
    private UiElement activeUiElement = null;
    private final WeakReference<Activity> activityRef;
    private final IHub hub;
    private final SentryAndroidOptions options;
    private final ScrollState scrollState = new ScrollState((AnonymousClass1) null);

    private enum GestureType {
        Click,
        Scroll,
        Swipe,
        Unknown
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public SentryGestureListener(Activity activity, IHub iHub, SentryAndroidOptions sentryAndroidOptions) {
        this.activityRef = new WeakReference<>(activity);
        this.hub = iHub;
        this.options = sentryAndroidOptions;
    }

    public void onUp(MotionEvent motionEvent) {
        View ensureWindowDecorView = ensureWindowDecorView("onUp");
        UiElement access$100 = this.scrollState.target;
        if (ensureWindowDecorView != null && access$100 != null) {
            if (this.scrollState.type == GestureType.Unknown) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
                return;
            }
            addBreadcrumb(access$100, this.scrollState.type, Collections.singletonMap("direction", this.scrollState.calculateDirection(motionEvent)), motionEvent);
            startTracing(access$100, this.scrollState.type);
            this.scrollState.reset();
        }
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.scrollState.reset();
        float unused = this.scrollState.startX = motionEvent.getX();
        float unused2 = this.scrollState.startY = motionEvent.getY();
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        View ensureWindowDecorView = ensureWindowDecorView("onSingleTapUp");
        if (!(ensureWindowDecorView == null || motionEvent == null)) {
            UiElement findTarget = ViewUtils.findTarget(this.options, ensureWindowDecorView, motionEvent.getX(), motionEvent.getY(), UiElement.Type.CLICKABLE);
            if (findTarget == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            addBreadcrumb(findTarget, GestureType.Click, Collections.emptyMap(), motionEvent);
            startTracing(findTarget, GestureType.Click);
        }
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        View ensureWindowDecorView = ensureWindowDecorView("onScroll");
        if (!(ensureWindowDecorView == null || motionEvent == null || this.scrollState.type != GestureType.Unknown)) {
            UiElement findTarget = ViewUtils.findTarget(this.options, ensureWindowDecorView, motionEvent.getX(), motionEvent.getY(), UiElement.Type.SCROLLABLE);
            if (findTarget == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                return false;
            }
            this.options.getLogger().log(SentryLevel.DEBUG, "Scroll target found: " + findTarget.getIdentifier(), new Object[0]);
            this.scrollState.setTarget(findTarget);
            GestureType unused = this.scrollState.type = GestureType.Scroll;
        }
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        GestureType unused = this.scrollState.type = GestureType.Swipe;
        return false;
    }

    private void addBreadcrumb(UiElement uiElement, GestureType gestureType, Map<String, Object> map, MotionEvent motionEvent) {
        if (this.options.isEnableUserInteractionBreadcrumbs()) {
            String gestureType2 = getGestureType(gestureType);
            Hint hint = new Hint();
            hint.set(TypeCheckHint.ANDROID_MOTION_EVENT, motionEvent);
            hint.set(TypeCheckHint.ANDROID_VIEW, uiElement.getView());
            this.hub.addBreadcrumb(Breadcrumb.userInteraction(gestureType2, uiElement.getResourceName(), uiElement.getClassName(), uiElement.getTag(), map), hint);
        }
    }

    private void startTracing(UiElement uiElement, GestureType gestureType) {
        boolean z = (gestureType == GestureType.Click) || !(gestureType == this.activeEventType && uiElement.equals(this.activeUiElement));
        if (this.options.isTracingEnabled() && this.options.isEnableUserInteractionTracing()) {
            Activity activity = (Activity) this.activityRef.get();
            if (activity == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
                return;
            }
            String identifier = uiElement.getIdentifier();
            ITransaction iTransaction = this.activeTransaction;
            if (iTransaction != null) {
                if (z || iTransaction.isFinished()) {
                    stopTracing(SpanStatus.OK);
                } else {
                    this.options.getLogger().log(SentryLevel.DEBUG, "The view with id: " + identifier + " already has an ongoing transaction assigned. Rescheduling finish", new Object[0]);
                    if (this.options.getIdleTimeout() != null) {
                        this.activeTransaction.scheduleFinish();
                        return;
                    }
                    return;
                }
            }
            TransactionOptions transactionOptions = new TransactionOptions();
            transactionOptions.setWaitForChildren(true);
            transactionOptions.setDeadlineTimeout(30000L);
            transactionOptions.setIdleTimeout(this.options.getIdleTimeout());
            transactionOptions.setTrimEnd(true);
            ITransaction startTransaction = this.hub.startTransaction(new TransactionContext(getActivityName(activity) + "." + identifier, TransactionNameSource.COMPONENT, "ui.action." + getGestureType(gestureType)), transactionOptions);
            startTransaction.getSpanContext().setOrigin("auto.ui.gesture_listener." + uiElement.getOrigin());
            this.hub.configureScope(new SentryGestureListener$$ExternalSyntheticLambda2(this, startTransaction));
            this.activeTransaction = startTransaction;
            this.activeUiElement = uiElement;
            this.activeEventType = gestureType;
        } else if (z) {
            TracingUtils.startNewTrace(this.hub);
            this.activeUiElement = uiElement;
            this.activeEventType = gestureType;
        }
    }

    /* access modifiers changed from: package-private */
    public void stopTracing(SpanStatus spanStatus) {
        ITransaction iTransaction = this.activeTransaction;
        if (iTransaction != null) {
            if (iTransaction.getStatus() == null) {
                this.activeTransaction.finish(spanStatus);
            } else {
                this.activeTransaction.finish();
            }
        }
        this.hub.configureScope(new SentryGestureListener$$ExternalSyntheticLambda1(this));
        this.activeTransaction = null;
        if (this.activeUiElement != null) {
            this.activeUiElement = null;
        }
        this.activeEventType = GestureType.Unknown;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: clearScope */
    public void m910lambda$stopTracing$1$iosentryandroidcoreinternalgesturesSentryGestureListener(IScope iScope) {
        iScope.withTransaction(new SentryGestureListener$$ExternalSyntheticLambda3(this, iScope));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$clearScope$2$io-sentry-android-core-internal-gestures-SentryGestureListener  reason: not valid java name */
    public /* synthetic */ void m908lambda$clearScope$2$iosentryandroidcoreinternalgesturesSentryGestureListener(IScope iScope, ITransaction iTransaction) {
        if (iTransaction == this.activeTransaction) {
            iScope.clearTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: applyScope */
    public void m909lambda$startTracing$0$iosentryandroidcoreinternalgesturesSentryGestureListener(IScope iScope, ITransaction iTransaction) {
        iScope.withTransaction(new SentryGestureListener$$ExternalSyntheticLambda0(this, iScope, iTransaction));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$applyScope$3$io-sentry-android-core-internal-gestures-SentryGestureListener  reason: not valid java name */
    public /* synthetic */ void m907lambda$applyScope$3$iosentryandroidcoreinternalgesturesSentryGestureListener(IScope iScope, ITransaction iTransaction, ITransaction iTransaction2) {
        if (iTransaction2 == null) {
            iScope.setTransaction(iTransaction);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", iTransaction.getName());
    }

    private String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    private View ensureWindowDecorView(String str) {
        Activity activity = (Activity) this.activityRef.get();
        if (activity == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Activity is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Window is null in " + str + ". No breadcrumb captured.", new Object[0]);
            return null;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            return decorView;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "DecorView is null in " + str + ". No breadcrumb captured.", new Object[0]);
        return null;
    }

    /* renamed from: io.sentry.android.core.internal.gestures.SentryGestureListener$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                io.sentry.android.core.internal.gestures.SentryGestureListener$GestureType[] r0 = io.sentry.android.core.internal.gestures.SentryGestureListener.GestureType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType = r0
                io.sentry.android.core.internal.gestures.SentryGestureListener$GestureType r1 = io.sentry.android.core.internal.gestures.SentryGestureListener.GestureType.Click     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType     // Catch:{ NoSuchFieldError -> 0x001d }
                io.sentry.android.core.internal.gestures.SentryGestureListener$GestureType r1 = io.sentry.android.core.internal.gestures.SentryGestureListener.GestureType.Scroll     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.sentry.android.core.internal.gestures.SentryGestureListener$GestureType r1 = io.sentry.android.core.internal.gestures.SentryGestureListener.GestureType.Swipe     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.sentry.android.core.internal.gestures.SentryGestureListener$GestureType r1 = io.sentry.android.core.internal.gestures.SentryGestureListener.GestureType.Unknown     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.internal.gestures.SentryGestureListener.AnonymousClass1.<clinit>():void");
        }
    }

    private static String getGestureType(GestureType gestureType) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$android$core$internal$gestures$SentryGestureListener$GestureType[gestureType.ordinal()];
        if (i == 1) {
            return "click";
        }
        if (i != 2) {
            return i != 3 ? "unknown" : "swipe";
        }
        return ViewProps.SCROLL;
    }

    private static final class ScrollState {
        /* access modifiers changed from: private */
        public float startX;
        /* access modifiers changed from: private */
        public float startY;
        /* access modifiers changed from: private */
        public UiElement target;
        /* access modifiers changed from: private */
        public GestureType type;

        private ScrollState() {
            this.type = GestureType.Unknown;
            this.startX = 0.0f;
            this.startY = 0.0f;
        }

        /* synthetic */ ScrollState(AnonymousClass1 r1) {
            this();
        }

        /* access modifiers changed from: private */
        public void setTarget(UiElement uiElement) {
            this.target = uiElement;
        }

        /* access modifiers changed from: private */
        public String calculateDirection(MotionEvent motionEvent) {
            float x = motionEvent.getX() - this.startX;
            float y = motionEvent.getY() - this.startY;
            return Math.abs(x) > Math.abs(y) ? x > 0.0f ? "right" : "left" : y > 0.0f ? "down" : "up";
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.target = null;
            this.type = GestureType.Unknown;
            this.startX = 0.0f;
            this.startY = 0.0f;
        }
    }
}
