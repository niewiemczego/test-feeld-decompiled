package com.reactnativepagerview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.uimanager.PixelUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\nJ\u0016\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0014J\u0016\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\fJ\u0016\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010\"\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010#\u001a\u00020\fJ\u0016\u0010$\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManagerImpl;", "", "()V", "NAME", "", "addView", "", "host", "Lcom/reactnativepagerview/NestedScrollableHost;", "child", "Landroid/view/View;", "index", "", "getChildAt", "parent", "getChildCount", "getViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "view", "needsCustomLayoutForChildren", "", "refreshViewChildrenLayout", "removeAllViews", "removeView", "removeViewAt", "setCurrentItem", "selectedTab", "scrollSmooth", "setInitialPage", "value", "setLayoutDirection", "setOffscreenPageLimit", "setOrientation", "setOverScrollMode", "setPageMargin", "margin", "setScrollEnabled", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PagerViewViewManagerImpl.kt */
public final class PagerViewViewManagerImpl {
    public static final PagerViewViewManagerImpl INSTANCE = new PagerViewViewManagerImpl();
    public static final String NAME = "RNCViewPager";

    public final boolean needsCustomLayoutForChildren() {
        return true;
    }

    private PagerViewViewManagerImpl() {
    }

    public final ViewPager2 getViewPager(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, ViewHierarchyConstants.VIEW_KEY);
        if (nestedScrollableHost.getChildAt(0) instanceof ViewPager2) {
            View childAt = nestedScrollableHost.getChildAt(0);
            Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.viewpager2.widget.ViewPager2");
            return (ViewPager2) childAt;
        }
        throw new ClassNotFoundException("Could not retrieve ViewPager2 instance");
    }

    public final void setCurrentItem(ViewPager2 viewPager2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(viewPager2, ViewHierarchyConstants.VIEW_KEY);
        refreshViewChildrenLayout(viewPager2);
        viewPager2.setCurrentItem(i, z);
    }

    public final void addView(NestedScrollableHost nestedScrollableHost, View view, int i) {
        Integer initialIndex;
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        if (view != null) {
            ViewPager2 viewPager = getViewPager(nestedScrollableHost);
            ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
            if (viewPagerAdapter != null) {
                viewPagerAdapter.addChild(view, i);
            }
            if (viewPager.getCurrentItem() == i) {
                refreshViewChildrenLayout(viewPager);
            }
            if (!nestedScrollableHost.getDidSetInitialIndex() && (initialIndex = nestedScrollableHost.getInitialIndex()) != null && initialIndex.intValue() == i) {
                nestedScrollableHost.setDidSetInitialIndex(true);
                setCurrentItem(viewPager, i, false);
            }
        }
    }

    public final int getChildCount(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        RecyclerView.Adapter adapter = getViewPager(nestedScrollableHost).getAdapter();
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public final View getChildAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) getViewPager(nestedScrollableHost).getAdapter();
        Intrinsics.checkNotNull(viewPagerAdapter);
        return viewPagerAdapter.getChildAt(i);
    }

    public final void removeView(NestedScrollableHost nestedScrollableHost, View view) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChild(view);
        }
        refreshViewChildrenLayout(viewPager);
    }

    public final void removeAllViews(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        viewPager.setUserInputEnabled(false);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeAll();
        }
    }

    public final void removeViewAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        ViewPagerAdapter viewPagerAdapter = (ViewPagerAdapter) viewPager.getAdapter();
        if (viewPagerAdapter != null) {
            viewPagerAdapter.removeChildAt(i);
        }
        refreshViewChildrenLayout(viewPager);
    }

    public final void setScrollEnabled(NestedScrollableHost nestedScrollableHost, boolean z) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        getViewPager(nestedScrollableHost).setUserInputEnabled(z);
    }

    public final void setLayoutDirection(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        if (Intrinsics.areEqual((Object) str, (Object) "rtl")) {
            viewPager.setLayoutDirection(1);
        } else {
            viewPager.setLayoutDirection(0);
        }
    }

    public final void setInitialPage(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        if (nestedScrollableHost.getInitialIndex() == null) {
            nestedScrollableHost.setInitialIndex(Integer.valueOf(i));
            viewPager.post(new PagerViewViewManagerImpl$$ExternalSyntheticLambda0(nestedScrollableHost));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setInitialPage$lambda-0  reason: not valid java name */
    public static final void m627setInitialPage$lambda0(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "$host");
        nestedScrollableHost.setDidSetInitialIndex(true);
    }

    public final void setOrientation(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        getViewPager(nestedScrollableHost).setOrientation(Intrinsics.areEqual((Object) str, (Object) "vertical") ? 1 : 0);
    }

    public final void setOffscreenPageLimit(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        getViewPager(nestedScrollableHost).setOffscreenPageLimit(i);
    }

    public final void setOverScrollMode(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        View childAt = getViewPager(nestedScrollableHost).getChildAt(0);
        if (Intrinsics.areEqual((Object) str, (Object) "never")) {
            childAt.setOverScrollMode(2);
        } else if (Intrinsics.areEqual((Object) str, (Object) "always")) {
            childAt.setOverScrollMode(0);
        } else {
            childAt.setOverScrollMode(1);
        }
    }

    public final void setPageMargin(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        ViewPager2 viewPager = getViewPager(nestedScrollableHost);
        viewPager.setPageTransformer(new PagerViewViewManagerImpl$$ExternalSyntheticLambda1((int) PixelUtil.toPixelFromDIP((double) i), viewPager));
    }

    /* access modifiers changed from: private */
    /* renamed from: setPageMargin$lambda-1  reason: not valid java name */
    public static final void m628setPageMargin$lambda1(int i, ViewPager2 viewPager2, View view, float f) {
        Intrinsics.checkNotNullParameter(viewPager2, "$pager");
        Intrinsics.checkNotNullParameter(view, "page");
        float f2 = ((float) i) * f;
        if (viewPager2.getOrientation() == 0) {
            boolean z = true;
            if (viewPager2.getLayoutDirection() != 1) {
                z = false;
            }
            if (z) {
                f2 = -f2;
            }
            view.setTranslationX(f2);
            return;
        }
        view.setTranslationY(f2);
    }

    private final void refreshViewChildrenLayout(View view) {
        view.post(new PagerViewViewManagerImpl$$ExternalSyntheticLambda2(view));
    }

    /* access modifiers changed from: private */
    /* renamed from: refreshViewChildrenLayout$lambda-2  reason: not valid java name */
    public static final void m626refreshViewChildrenLayout$lambda2(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }
}
