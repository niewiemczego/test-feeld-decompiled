package com.reactnativepagerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/reactnativepagerview/NestedScrollableHost;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "child", "Landroid/view/View;", "getChild", "()Landroid/view/View;", "didSetInitialIndex", "", "getDidSetInitialIndex", "()Z", "setDidSetInitialIndex", "(Z)V", "initialIndex", "", "getInitialIndex", "()Ljava/lang/Integer;", "setInitialIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "initialX", "", "initialY", "parentViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getParentViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "touchSlop", "canChildScroll", "orientation", "delta", "handleInterceptTouchEvent", "", "e", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NestedScrollableHost.kt */
public final class NestedScrollableHost extends FrameLayout {
    private boolean didSetInitialIndex;
    private Integer initialIndex;
    private float initialX;
    private float initialY;
    private int touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollableHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final Integer getInitialIndex() {
        return this.initialIndex;
    }

    public final void setInitialIndex(Integer num) {
        this.initialIndex = num;
    }

    public final boolean getDidSetInitialIndex() {
        return this.didSetInitialIndex;
    }

    public final void setDidSetInitialIndex(boolean z) {
        this.didSetInitialIndex = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e A[EDGE_INSN: B:13:0x001e->B:10:0x001e ?: BREAK  
    EDGE_INSN: B:15:0x001e->B:10:0x001e ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.viewpager2.widget.ViewPager2 getParentViewPager() {
        /*
            r3 = this;
            android.view.ViewParent r0 = r3.getParent()
            boolean r1 = r0 instanceof android.view.View
            r2 = 0
            if (r1 == 0) goto L_0x000c
            android.view.View r0 = (android.view.View) r0
            goto L_0x000d
        L_0x000c:
            r0 = r2
        L_0x000d:
            if (r0 == 0) goto L_0x001e
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 != 0) goto L_0x001e
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x000c
            android.view.View r0 = (android.view.View) r0
            goto L_0x000d
        L_0x001e:
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L_0x0025
            r2 = r0
            androidx.viewpager2.widget.ViewPager2 r2 = (androidx.viewpager2.widget.ViewPager2) r2
        L_0x0025:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.NestedScrollableHost.getParentViewPager():androidx.viewpager2.widget.ViewPager2");
    }

    private final View getChild() {
        if (getChildCount() > 0) {
            return getChildAt(0);
        }
        return null;
    }

    private final boolean canChildScroll(int i, float f) {
        int i2 = -((int) Math.signum(f));
        if (i == 0) {
            View child = getChild();
            if (child != null) {
                return child.canScrollHorizontally(i2);
            }
            return false;
        } else if (i == 1) {
            View child2 = getChild();
            if (child2 != null) {
                return child2.canScrollVertically(i2);
            }
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "e");
        handleInterceptTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    private final void handleInterceptTouchEvent(MotionEvent motionEvent) {
        ViewPager2 parentViewPager = getParentViewPager();
        if (parentViewPager != null) {
            int orientation = parentViewPager.getOrientation();
            float f = 1.0f;
            if (!canChildScroll(orientation, -1.0f) && !canChildScroll(orientation, 1.0f)) {
                return;
            }
            if (motionEvent.getAction() == 0) {
                this.initialX = motionEvent.getX();
                this.initialY = motionEvent.getY();
                getParent().requestDisallowInterceptTouchEvent(true);
            } else if (motionEvent.getAction() == 2) {
                float x = motionEvent.getX() - this.initialX;
                float y = motionEvent.getY() - this.initialY;
                boolean z = orientation == 0;
                float abs = Math.abs(x) * (z ? 0.5f : 1.0f);
                float abs2 = Math.abs(y);
                if (!z) {
                    f = 0.5f;
                }
                float f2 = abs2 * f;
                int i = this.touchSlop;
                if (abs > ((float) i) || f2 > ((float) i)) {
                    if (z == (f2 > abs)) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    if (!z) {
                        x = y;
                    }
                    if (canChildScroll(orientation, x)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
            }
        }
    }
}
