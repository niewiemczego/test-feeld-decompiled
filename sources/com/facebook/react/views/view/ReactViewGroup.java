package com.facebook.react.views.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingProhibitedView;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactOverflowViewWithInset;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.view.ReactViewBackgroundDrawable;
import com.facebook.yoga.YogaConstants;

public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup, ReactOverflowViewWithInset {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    private View[] mAllChildren;
    private int mAllChildrenCount;
    private float mBackfaceOpacity;
    private String mBackfaceVisibility;
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    private Rect mClippingRect;
    private ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    private Rect mHitSlopRect;
    private int mLayoutDirection;
    private boolean mNeedsOffscreenAlphaCompositing;
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    private String mOverflow;
    private final Rect mOverflowInset = new Rect();
    private Path mPath;
    private PointerEvents mPointerEvents;
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private boolean mRemoveClippedSubviews;

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void requestLayout() {
    }

    private static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private final ReactViewGroup mParent;

        private ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.mParent = reactViewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews()) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        setClipChildren(false);
        this.mRemoveClippedSubviews = false;
        this.mAllChildren = null;
        this.mAllChildrenCount = 0;
        this.mClippingRect = null;
        this.mHitSlopRect = null;
        this.mOverflow = null;
        this.mPointerEvents = PointerEvents.AUTO;
        this.mChildrenLayoutChangeListener = null;
        this.mReactBackgroundDrawable = null;
        this.mOnInterceptTouchEventListener = null;
        this.mNeedsOffscreenAlphaCompositing = false;
        this.mDrawingOrderHelper = null;
        this.mPath = null;
        this.mLayoutDirection = 0;
        this.mBackfaceOpacity = 1.0f;
        this.mBackfaceVisibility = ViewProps.VISIBLE;
    }

    /* access modifiers changed from: package-private */
    public void recycleView() {
        initView();
        this.mOverflowInset.setEmpty();
        sHelperRect.setEmpty();
        removeAllViews();
        updateBackgroundDrawable((Drawable) null);
        resetPointerEvents();
    }

    private ViewGroupDrawingOrderHelper getDrawingOrderHelper() {
        if (this.mDrawingOrderHelper == null) {
            this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
        }
        return this.mDrawingOrderHelper;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null) {
            reactViewBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e) {
            FLog.e(ReactConstants.TAG, "NullPointerException when executing dispatchProvideStructure", (Throwable) e);
        }
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setTranslucentBackgroundDrawable(Drawable drawable) {
        updateBackgroundDrawable((Drawable) null);
        if (this.mReactBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if ((onInterceptTouchEventListener == null || !onInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent)) && PointerEvents.canChildrenBeTouchTarget(this.mPointerEvents)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return PointerEvents.canBeTouchTarget(this.mPointerEvents);
    }

    public boolean dispatchGenericPointerEvent(MotionEvent motionEvent) {
        if (!PointerEvents.canChildrenBeTouchTarget(this.mPointerEvents)) {
            return false;
        }
        return super.dispatchGenericPointerEvent(motionEvent);
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateReactViewBackground().setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateReactViewBackground().setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        getOrCreateReactViewBackground().setRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        getOrCreateReactViewBackground().setRadius(f, i);
    }

    public void setBorderStyle(String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            if (z) {
                Rect rect = new Rect();
                this.mClippingRect = rect;
                ReactClippingViewGroupHelper.calculateClippingRect(this, rect);
                int childCount = getChildCount();
                this.mAllChildrenCount = childCount;
                this.mAllChildren = new View[Math.max(12, childCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener();
                for (int i = 0; i < this.mAllChildrenCount; i++) {
                    View childAt = getChildAt(i);
                    this.mAllChildren[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    private void updateClippingToRect(Rect rect) {
        Assertions.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (this.mAllChildren[i2].getParent() == null) {
                i++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        if (r7 != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateSubviewClipStatus(android.graphics.Rect r7, int r8, int r9) {
        /*
            r6 = this;
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()
            android.view.View[] r0 = r6.mAllChildren
            java.lang.Object r0 = com.facebook.infer.annotation.Assertions.assertNotNull(r0)
            android.view.View[] r0 = (android.view.View[]) r0
            r0 = r0[r8]
            android.graphics.Rect r1 = sHelperRect
            int r2 = r0.getLeft()
            int r3 = r0.getTop()
            int r4 = r0.getRight()
            int r5 = r0.getBottom()
            r1.set(r2, r3, r4, r5)
            int r2 = r1.left
            int r3 = r1.top
            int r4 = r1.right
            int r1 = r1.bottom
            boolean r7 = r7.intersects(r2, r3, r4, r1)
            android.view.animation.Animation r1 = r0.getAnimation()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003e
            boolean r1 = r1.hasEnded()
            if (r1 != 0) goto L_0x003e
            r1 = r3
            goto L_0x003f
        L_0x003e:
            r1 = r2
        L_0x003f:
            if (r7 != 0) goto L_0x004e
            android.view.ViewParent r4 = r0.getParent()
            if (r4 == 0) goto L_0x004e
            if (r1 != 0) goto L_0x004e
            int r8 = r8 - r9
            super.removeViewsInLayout(r8, r3)
            goto L_0x0062
        L_0x004e:
            if (r7 == 0) goto L_0x0060
            android.view.ViewParent r1 = r0.getParent()
            if (r1 != 0) goto L_0x0060
            int r8 = r8 - r9
            android.view.ViewGroup$LayoutParams r7 = sDefaultLayoutParam
            super.addViewInLayout(r0, r8, r7, r3)
            r6.invalidate()
            goto L_0x0062
        L_0x0060:
            if (r7 == 0) goto L_0x0063
        L_0x0062:
            r2 = r3
        L_0x0063:
            if (r2 == 0) goto L_0x0074
            boolean r7 = r0 instanceof com.facebook.react.uimanager.ReactClippingViewGroup
            if (r7 == 0) goto L_0x0074
            com.facebook.react.uimanager.ReactClippingViewGroup r0 = (com.facebook.react.uimanager.ReactClippingViewGroup) r0
            boolean r7 = r0.getRemoveClippedSubviews()
            if (r7 == 0) goto L_0x0074
            r0.updateClippingRect()
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewGroup.updateSubviewClipStatus(android.graphics.Rect, int, int):void");
    }

    /* access modifiers changed from: private */
    public void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews && getParent() != null) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Rect rect = sHelperRect;
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (this.mClippingRect.intersects(rect.left, rect.top, rect.right, rect.bottom) != (view.getParent() != null)) {
                int i = 0;
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    View view2 = this.mAllChildren[i2];
                    if (view2 == view) {
                        updateSubviewClipStatus(this.mClippingRect, i2, i);
                        return;
                    }
                    if (view2.getParent() == null) {
                        i++;
                    }
                }
            }
        }
    }

    public boolean getChildVisibleRect(View view, Rect rect, Point point) {
        return super.getChildVisibleRect(view, rect, point);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    private boolean customDrawOrderDisabled() {
        if (getId() != -1 && ViewUtil.getUIManagerType(getId()) == 2) {
            return true;
        }
        return false;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleAddView(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleRemoveView(view);
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().handleRemoveView(getChildAt(i));
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
        } else {
            setChildrenDrawingOrderEnabled(false);
        }
        super.removeViewAt(i);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        UiThreadUtil.assertOnUiThread();
        return !customDrawOrderDisabled() ? getDrawingOrderHelper().getChildDrawingOrder(i, i2) : i2;
    }

    public int getZIndexMappedChildIndex(int i) {
        UiThreadUtil.assertOnUiThread();
        return (customDrawOrderDisabled() || !getDrawingOrderHelper().shouldEnableCustomDrawingOrder()) ? i : getDrawingOrderHelper().getChildDrawingOrder(getChildCount(), i);
    }

    public void updateDrawingOrder() {
        if (!customDrawOrderDisabled()) {
            getDrawingOrderHelper().update();
            setChildrenDrawingOrderEnabled(getDrawingOrderHelper().shouldEnableCustomDrawingOrder());
            invalidate();
        }
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    /* access modifiers changed from: package-private */
    public void resetPointerEvents() {
        this.mPointerEvents = PointerEvents.AUTO;
    }

    /* access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    /* access modifiers changed from: package-private */
    public View getChildAtWithSubviewClippingEnabled(int i) {
        return ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i) {
        addViewWithSubviewClippingEnabled(view, i, sDefaultLayoutParam);
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(final View view, int i, ViewGroup.LayoutParams layoutParams) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        addInArray(view, i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.mAllChildren[i3].getParent() == null) {
                i2++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i2);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        if (view instanceof ReactClippingProhibitedView) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (!view.isShown()) {
                        ReactSoftExceptionLogger.logSoftException(ReactConstants.TAG, new ReactNoCrashSoftException("Child view has been added to Parent view in which it is clipped and not visible. This is not legal for this particular child view. Child: [" + view.getId() + "] " + view.toString() + " Parent: [" + ReactViewGroup.this.getId() + "] " + toString()));
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void removeViewWithSubviewClippingEnabled(View view) {
        UiThreadUtil.assertOnUiThread();
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int indexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (this.mAllChildren[indexOfChildInAllChildren].getParent() != null) {
            int i = 0;
            for (int i2 = 0; i2 < indexOfChildInAllChildren; i2++) {
                if (this.mAllChildren[i2].getParent() == null) {
                    i++;
                }
            }
            super.removeViewsInLayout(indexOfChildInAllChildren - i, 1);
        }
        removeFromArray(indexOfChildInAllChildren);
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mAllChildren);
        for (int i = 0; i < this.mAllChildrenCount; i++) {
            this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    private int indexOfChildInAllChildren(View view) {
        int i = this.mAllChildrenCount;
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void addInArray(View view, int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                View[] viewArr2 = new View[(length + 12)];
                this.mAllChildren = viewArr2;
                System.arraycopy(viewArr, 0, viewArr2, 0, length);
                viewArr = this.mAllChildren;
            }
            int i3 = this.mAllChildrenCount;
            this.mAllChildrenCount = i3 + 1;
            viewArr[i3] = view;
        } else if (i < i2) {
            if (length == i2) {
                View[] viewArr3 = new View[(length + 12)];
                this.mAllChildren = viewArr3;
                System.arraycopy(viewArr, 0, viewArr3, 0, i);
                System.arraycopy(viewArr, i, this.mAllChildren, i + 1, i2 - i);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        }
    }

    private void removeFromArray(int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        if (i == i2 - 1) {
            int i3 = i2 - 1;
            this.mAllChildrenCount = i3;
            viewArr[i3] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            int i4 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i4;
            viewArr[i4] = null;
        }
    }

    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).getColor();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable((Drawable) null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            boolean isRTL = I18nUtil.getInstance().isRTL(getContext());
            this.mLayoutDirection = isRTL ? 1 : 0;
            this.mReactBackgroundDrawable.setResolvedLayoutDirection(isRTL);
        }
        return this.mReactBackgroundDrawable;
    }

    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public void setHitSlopRect(Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    public String getOverflow() {
        return this.mOverflow;
    }

    public void setOverflowInset(int i, int i2, int i3, int i4) {
        this.mOverflowInset.set(i, i2, i3, i4);
    }

    public Rect getOverflowInset() {
        return this.mOverflowInset;
    }

    /* access modifiers changed from: package-private */
    public void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException | StackOverflowError e) {
            RootView rootView = RootViewUtil.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e));
            } else {
                throw e;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z = view.getElevation() > 0.0f;
        if (z) {
            CanvasUtil.enableZ(canvas, true);
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        if (z) {
            CanvasUtil.enableZ(canvas, false);
        }
        return drawChild;
    }

    private void dispatchOverflowDraw(Canvas canvas) {
        float f;
        boolean z;
        float f2;
        float f3;
        float f4;
        float f5;
        Canvas canvas2 = canvas;
        String str = this.mOverflow;
        if (str != null) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1217487446:
                    if (str.equals(ViewProps.HIDDEN)) {
                        c = 0;
                        break;
                    }
                    break;
                case -907680051:
                    if (str.equals(ViewProps.SCROLL)) {
                        c = 1;
                        break;
                    }
                    break;
                case 466743410:
                    if (str.equals(ViewProps.VISIBLE)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    float width = (float) getWidth();
                    float height = (float) getHeight();
                    ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
                    float f6 = 0.0f;
                    if (reactViewBackgroundDrawable != null) {
                        RectF directionAwareBorderInsets = reactViewBackgroundDrawable.getDirectionAwareBorderInsets();
                        if (directionAwareBorderInsets.top > 0.0f || directionAwareBorderInsets.left > 0.0f || directionAwareBorderInsets.bottom > 0.0f || directionAwareBorderInsets.right > 0.0f) {
                            f2 = directionAwareBorderInsets.left + 0.0f;
                            f = directionAwareBorderInsets.top + 0.0f;
                            width -= directionAwareBorderInsets.right;
                            height -= directionAwareBorderInsets.bottom;
                        } else {
                            f2 = 0.0f;
                            f = 0.0f;
                        }
                        float fullBorderRadius = this.mReactBackgroundDrawable.getFullBorderRadius();
                        float borderRadiusOrDefaultTo = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT);
                        float borderRadiusOrDefaultTo2 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT);
                        float borderRadiusOrDefaultTo3 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT);
                        float borderRadiusOrDefaultTo4 = this.mReactBackgroundDrawable.getBorderRadiusOrDefaultTo(fullBorderRadius, ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT);
                        boolean z2 = this.mLayoutDirection == 1;
                        float borderRadius = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START);
                        float borderRadius2 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END);
                        float borderRadius3 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START);
                        float f7 = borderRadiusOrDefaultTo4;
                        float borderRadius4 = this.mReactBackgroundDrawable.getBorderRadius(ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END);
                        float f8 = borderRadiusOrDefaultTo;
                        if (I18nUtil.getInstance().doLeftAndRightSwapInRTL(getContext())) {
                            f3 = YogaConstants.isUndefined(borderRadius) ? f8 : borderRadius;
                            if (!YogaConstants.isUndefined(borderRadius2)) {
                                borderRadiusOrDefaultTo2 = borderRadius2;
                            }
                            if (!YogaConstants.isUndefined(borderRadius3)) {
                                borderRadiusOrDefaultTo3 = borderRadius3;
                            }
                            if (YogaConstants.isUndefined(borderRadius4)) {
                                borderRadius4 = f7;
                            }
                            f5 = z2 ? borderRadiusOrDefaultTo2 : f3;
                            if (!z2) {
                                f3 = borderRadiusOrDefaultTo2;
                            }
                            f4 = z2 ? borderRadius4 : borderRadiusOrDefaultTo3;
                            if (z2) {
                                borderRadius4 = borderRadiusOrDefaultTo3;
                            }
                        } else {
                            float f9 = z2 ? borderRadius2 : borderRadius;
                            if (!z2) {
                                borderRadius = borderRadius2;
                            }
                            float f10 = z2 ? borderRadius4 : borderRadius3;
                            if (!z2) {
                                borderRadius3 = borderRadius4;
                            }
                            if (YogaConstants.isUndefined(f9)) {
                                f9 = f8;
                            }
                            if (!YogaConstants.isUndefined(borderRadius)) {
                                borderRadiusOrDefaultTo2 = borderRadius;
                            }
                            if (!YogaConstants.isUndefined(f10)) {
                                borderRadiusOrDefaultTo3 = f10;
                            }
                            if (!YogaConstants.isUndefined(borderRadius3)) {
                                borderRadius4 = borderRadius3;
                                f5 = f9;
                                f3 = borderRadiusOrDefaultTo2;
                                f4 = borderRadiusOrDefaultTo3;
                            } else {
                                f5 = f9;
                                f3 = borderRadiusOrDefaultTo2;
                                f4 = borderRadiusOrDefaultTo3;
                                borderRadius4 = f7;
                            }
                        }
                        if (f5 > 0.0f || f3 > 0.0f || borderRadius4 > 0.0f || f4 > 0.0f) {
                            if (this.mPath == null) {
                                this.mPath = new Path();
                            }
                            this.mPath.rewind();
                            this.mPath.addRoundRect(new RectF(f2, f, width, height), new float[]{Math.max(f5 - directionAwareBorderInsets.left, 0.0f), Math.max(f5 - directionAwareBorderInsets.top, 0.0f), Math.max(f3 - directionAwareBorderInsets.right, 0.0f), Math.max(f3 - directionAwareBorderInsets.top, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.right, 0.0f), Math.max(borderRadius4 - directionAwareBorderInsets.bottom, 0.0f), Math.max(f4 - directionAwareBorderInsets.left, 0.0f), Math.max(f4 - directionAwareBorderInsets.bottom, 0.0f)}, Path.Direction.CW);
                            canvas2.clipPath(this.mPath);
                            f6 = f2;
                            z = true;
                        } else {
                            f6 = f2;
                            z = false;
                        }
                    } else {
                        f = 0.0f;
                        z = false;
                    }
                    if (!z) {
                        canvas2.clipRect(new RectF(f6, f, width, height));
                        return;
                    }
                    return;
                case 2:
                    Path path = this.mPath;
                    if (path != null) {
                        path.rewind();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void setOpacityIfPossible(float f) {
        this.mBackfaceOpacity = f;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals(ViewProps.VISIBLE)) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }
}
