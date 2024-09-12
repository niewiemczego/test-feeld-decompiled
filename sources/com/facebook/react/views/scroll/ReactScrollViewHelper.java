package com.facebook.react.views.scroll;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.FabricViewStateManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class ReactScrollViewHelper {
    public static final String AUTO = "auto";
    private static final String CONTENT_OFFSET_LEFT = "contentOffsetLeft";
    private static final String CONTENT_OFFSET_TOP = "contentOffsetTop";
    private static boolean DEBUG_MODE = false;
    public static final long MOMENTUM_DELAY = 20;
    public static final String OVER_SCROLL_ALWAYS = "always";
    public static final String OVER_SCROLL_NEVER = "never";
    private static final String SCROLL_AWAY_PADDING_TOP = "scrollAwayPaddingTop";
    private static int SMOOTH_SCROLL_DURATION = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;
    public static final int SNAP_ALIGNMENT_CENTER = 2;
    public static final int SNAP_ALIGNMENT_DISABLED = 0;
    public static final int SNAP_ALIGNMENT_END = 3;
    public static final int SNAP_ALIGNMENT_START = 1;
    private static String TAG = "ReactHorizontalScrollView";
    private static boolean mSmoothScrollDurationInitialized = false;
    private static final Set<ScrollListener> sScrollListeners = Collections.newSetFromMap(new WeakHashMap());

    public interface HasFlingAnimator {
        ValueAnimator getFlingAnimator();

        int getFlingExtrapolatedDistance(int i);

        void startFlingAnimator(int i, int i2);
    }

    public interface HasScrollEventThrottle {
        long getLastScrollDispatchTime();

        int getScrollEventThrottle();

        void setLastScrollDispatchTime(long j);

        void setScrollEventThrottle(int i);
    }

    public interface HasScrollState {
        ReactScrollViewScrollState getReactScrollViewScrollState();
    }

    public interface ScrollListener {
        void onLayout(ViewGroup viewGroup);

        void onScroll(ViewGroup viewGroup, ScrollEventType scrollEventType, float f, float f2);
    }

    static {
        Class<ReactHorizontalScrollView> cls = ReactHorizontalScrollView.class;
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, float f, float f2) {
        emitScrollEvent(t, ScrollEventType.SCROLL, f, f2);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollBeginDragEvent(T t) {
        emitScrollEvent(t, ScrollEventType.BEGIN_DRAG);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEndDragEvent(T t, float f, float f2) {
        emitScrollEvent(t, ScrollEventType.END_DRAG, f, f2);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumBeginEvent(T t, int i, int i2) {
        emitScrollEvent(t, ScrollEventType.MOMENTUM_BEGIN, (float) i, (float) i2);
    }

    public static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollMomentumEndEvent(T t) {
        emitScrollEvent(t, ScrollEventType.MOMENTUM_END);
    }

    private static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, ScrollEventType scrollEventType) {
        emitScrollEvent(t, scrollEventType, 0.0f, 0.0f);
    }

    private static <T extends ViewGroup & HasScrollEventThrottle> void emitScrollEvent(T t, ScrollEventType scrollEventType, float f, float f2) {
        T t2 = t;
        long currentTimeMillis = System.currentTimeMillis();
        View childAt = t2.getChildAt(0);
        if (childAt != null) {
            for (ScrollListener onScroll : sScrollListeners) {
                onScroll.onScroll(t2, scrollEventType, f, f2);
            }
            ScrollEventType scrollEventType2 = scrollEventType;
            float f3 = f;
            float f4 = f2;
            ReactContext reactContext = (ReactContext) t.getContext();
            int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
            EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, t.getId());
            if (eventDispatcherForReactTag != null) {
                eventDispatcherForReactTag.dispatchEvent(ScrollEvent.obtain(surfaceId, t.getId(), scrollEventType, (float) t.getScrollX(), (float) t.getScrollY(), f, f2, childAt.getWidth(), childAt.getHeight(), t.getWidth(), t.getHeight()));
                ((HasScrollEventThrottle) t2).setLastScrollDispatchTime(currentTimeMillis);
            }
        }
    }

    public static void emitLayoutEvent(ViewGroup viewGroup) {
        for (ScrollListener onLayout : sScrollListeners) {
            onLayout.onLayout(viewGroup);
        }
    }

    public static int parseOverScrollMode(String str) {
        if (str == null || str.equals("auto")) {
            return 1;
        }
        if (str.equals("always")) {
            return 0;
        }
        if (str.equals("never")) {
            return 2;
        }
        throw new JSApplicationIllegalArgumentException("wrong overScrollMode: " + str);
    }

    public static int parseSnapToAlignment(String str) {
        if (str == null) {
            return 0;
        }
        if ("start".equalsIgnoreCase(str)) {
            return 1;
        }
        if (TtmlNode.CENTER.equalsIgnoreCase(str)) {
            return 2;
        }
        if ("end".equals(str)) {
            return 3;
        }
        throw new JSApplicationIllegalArgumentException("wrong snap alignment value: " + str);
    }

    public static int getDefaultScrollAnimationDuration(Context context) {
        if (!mSmoothScrollDurationInitialized) {
            mSmoothScrollDurationInitialized = true;
            try {
                SMOOTH_SCROLL_DURATION = new OverScrollerDurationGetter(context).getScrollAnimationDuration();
            } catch (Throwable unused) {
            }
        }
        return SMOOTH_SCROLL_DURATION;
    }

    private static class OverScrollerDurationGetter extends OverScroller {
        private int mScrollAnimationDuration = ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION;

        OverScrollerDurationGetter(Context context) {
            super(context);
        }

        public int getScrollAnimationDuration() {
            super.startScroll(0, 0, 0, 0);
            return this.mScrollAnimationDuration;
        }

        public void startScroll(int i, int i2, int i3, int i4, int i5) {
            this.mScrollAnimationDuration = i5;
        }
    }

    public static void addScrollListener(ScrollListener scrollListener) {
        sScrollListeners.add(scrollListener);
    }

    public static void removeScrollListener(ScrollListener scrollListener) {
        sScrollListeners.remove(scrollListener);
    }

    public static class ReactScrollViewScrollState {
        private float mDecelerationRate = 0.985f;
        private final Point mFinalAnimatedPositionScroll = new Point();
        private boolean mIsCanceled = false;
        private boolean mIsFinished = true;
        private final Point mLastStateUpdateScroll = new Point(-1, -1);
        private final int mLayoutDirection;
        private int mScrollAwayPaddingTop = 0;

        public ReactScrollViewScrollState(int i) {
            this.mLayoutDirection = i;
        }

        public int getLayoutDirection() {
            return this.mLayoutDirection;
        }

        public Point getFinalAnimatedPositionScroll() {
            return this.mFinalAnimatedPositionScroll;
        }

        public ReactScrollViewScrollState setFinalAnimatedPositionScroll(int i, int i2) {
            this.mFinalAnimatedPositionScroll.set(i, i2);
            return this;
        }

        public Point getLastStateUpdateScroll() {
            return this.mLastStateUpdateScroll;
        }

        public ReactScrollViewScrollState setLastStateUpdateScroll(int i, int i2) {
            this.mLastStateUpdateScroll.set(i, i2);
            return this;
        }

        public int getScrollAwayPaddingTop() {
            return this.mScrollAwayPaddingTop;
        }

        public ReactScrollViewScrollState setScrollAwayPaddingTop(int i) {
            this.mScrollAwayPaddingTop = i;
            return this;
        }

        public boolean getIsCanceled() {
            return this.mIsCanceled;
        }

        public ReactScrollViewScrollState setIsCanceled(boolean z) {
            this.mIsCanceled = z;
            return this;
        }

        public boolean getIsFinished() {
            return this.mIsFinished;
        }

        public ReactScrollViewScrollState setIsFinished(boolean z) {
            this.mIsFinished = z;
            return this;
        }

        public float getDecelerationRate() {
            return this.mDecelerationRate;
        }

        public ReactScrollViewScrollState setDecelerationRate(float f) {
            this.mDecelerationRate = f;
            return this;
        }
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void smoothScrollTo(T t, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "smoothScrollTo[%d] x %d y %d", (Object) Integer.valueOf(t.getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        HasFlingAnimator hasFlingAnimator = (HasFlingAnimator) t;
        ValueAnimator flingAnimator = hasFlingAnimator.getFlingAnimator();
        if (flingAnimator.getListeners() == null || flingAnimator.getListeners().size() == 0) {
            registerFlingAnimator(t);
        }
        ((HasScrollState) t).getReactScrollViewScrollState().setFinalAnimatedPositionScroll(i, i2);
        int scrollX = t.getScrollX();
        int scrollY = t.getScrollY();
        if (scrollX != i) {
            hasFlingAnimator.startFlingAnimator(scrollX, i);
        }
        if (scrollY != i2) {
            hasFlingAnimator.startFlingAnimator(scrollY, i2);
        }
        updateFabricScrollState(t, i, i2);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> int getNextFlingStartValue(T t, int i, int i2, int i3) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
        boolean z = false;
        if ((i3 != 0 ? i3 / Math.abs(i3) : 0) * (i2 - i) > 0) {
            z = true;
        }
        return (!reactScrollViewScrollState.getIsFinished() || (reactScrollViewScrollState.getIsCanceled() && z)) ? i2 : i;
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> boolean updateFabricScrollState(T t) {
        return updateFabricScrollState(t, t.getScrollX(), t.getScrollY());
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> boolean updateFabricScrollState(T t, int i, int i2) {
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d", (Object) Integer.valueOf(t.getId()), (Object) Integer.valueOf(i), (Object) Integer.valueOf(i2));
        }
        if (ViewUtil.getUIManagerType(t.getId()) == 1) {
            return false;
        }
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
        if (reactScrollViewScrollState.getLastStateUpdateScroll().equals(i, i2)) {
            return false;
        }
        reactScrollViewScrollState.setLastStateUpdateScroll(i, i2);
        forceUpdateState(t);
        return true;
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void forceUpdateState(T t) {
        int i;
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
        final int scrollAwayPaddingTop = reactScrollViewScrollState.getScrollAwayPaddingTop();
        Point lastStateUpdateScroll = reactScrollViewScrollState.getLastStateUpdateScroll();
        final int i2 = lastStateUpdateScroll.x;
        final int i3 = lastStateUpdateScroll.y;
        if (reactScrollViewScrollState.getLayoutDirection() == 1) {
            int i4 = 0;
            View childAt = t.getChildAt(0);
            if (childAt != null) {
                i4 = childAt.getWidth();
            }
            i = -((i4 - i2) - t.getWidth());
        } else {
            i = i2;
        }
        if (DEBUG_MODE) {
            FLog.i(TAG, "updateFabricScrollState[%d] scrollX %d scrollY %d fabricScrollX", (Object) Integer.valueOf(t.getId()), (Object) Integer.valueOf(i2), (Object) Integer.valueOf(i3), (Object) Integer.valueOf(i));
        }
        ((FabricViewStateManager.HasFabricViewStateManager) t).getFabricViewStateManager().setState(new FabricViewStateManager.StateUpdateCallback() {
            public WritableMap getStateUpdate() {
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                writableNativeMap.putDouble(ReactScrollViewHelper.CONTENT_OFFSET_LEFT, (double) PixelUtil.toDIPFromPixel((float) i2));
                writableNativeMap.putDouble(ReactScrollViewHelper.CONTENT_OFFSET_TOP, (double) PixelUtil.toDIPFromPixel((float) i3));
                writableNativeMap.putDouble(ReactScrollViewHelper.SCROLL_AWAY_PADDING_TOP, (double) PixelUtil.toDIPFromPixel((float) scrollAwayPaddingTop));
                return writableNativeMap;
            }
        });
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator & HasScrollEventThrottle> void updateStateOnScrollChanged(T t, float f, float f2) {
        updateFabricScrollState(t);
        emitScrollEvent(t, f, f2);
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> void registerFlingAnimator(final T t) {
        ((HasFlingAnimator) t).getFlingAnimator().addListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
                reactScrollViewScrollState.setIsCanceled(false);
                reactScrollViewScrollState.setIsFinished(false);
            }

            public void onAnimationEnd(Animator animator) {
                ((HasScrollState) t).getReactScrollViewScrollState().setIsFinished(true);
                ReactScrollViewHelper.updateFabricScrollState(t);
            }

            public void onAnimationCancel(Animator animator) {
                ((HasScrollState) t).getReactScrollViewScrollState().setIsCanceled(true);
            }
        });
    }

    public static <T extends ViewGroup & FabricViewStateManager.HasFabricViewStateManager & HasScrollState & HasFlingAnimator> Point predictFinalScrollPosition(T t, int i, int i2, int i3, int i4) {
        ReactScrollViewScrollState reactScrollViewScrollState = ((HasScrollState) t).getReactScrollViewScrollState();
        OverScroller overScroller = new OverScroller(t.getContext());
        overScroller.setFriction(1.0f - reactScrollViewScrollState.getDecelerationRate());
        int width = (t.getWidth() - ViewCompat.getPaddingStart(t)) - ViewCompat.getPaddingEnd(t);
        int height = (t.getHeight() - t.getPaddingBottom()) - t.getPaddingTop();
        Point finalAnimatedPositionScroll = reactScrollViewScrollState.getFinalAnimatedPositionScroll();
        int i5 = i;
        overScroller.fling(getNextFlingStartValue(t, t.getScrollX(), finalAnimatedPositionScroll.x, i), getNextFlingStartValue(t, t.getScrollY(), finalAnimatedPositionScroll.y, i2), i, i2, 0, i3, 0, i4, width / 2, height / 2);
        return new Point(overScroller.getFinalX(), overScroller.getFinalY());
    }
}
