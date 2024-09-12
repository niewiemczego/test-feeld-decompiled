package com.reactnativepagerview;

import androidx.viewpager2.widget.ViewPager2;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativepagerview.event.PageScrollEvent;
import com.reactnativepagerview.event.PageScrollStateChangedEvent;
import com.reactnativepagerview.event.PageSelectedEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/reactnativepagerview/PagerViewViewManager$createViewInstance$1$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PagerViewViewManager.kt */
public final class PagerViewViewManager$createViewInstance$1$1 extends ViewPager2.OnPageChangeCallback {
    final /* synthetic */ NestedScrollableHost $host;
    final /* synthetic */ PagerViewViewManager this$0;

    PagerViewViewManager$createViewInstance$1$1(PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
        this.this$0 = pagerViewViewManager;
        this.$host = nestedScrollableHost;
    }

    public void onPageScrolled(int i, float f, int i2) {
        super.onPageScrolled(i, f, i2);
        EventDispatcher access$getEventDispatcher$p = this.this$0.eventDispatcher;
        if (access$getEventDispatcher$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            access$getEventDispatcher$p = null;
        }
        access$getEventDispatcher$p.dispatchEvent(new PageScrollEvent(this.$host.getId(), i, f));
    }

    public void onPageSelected(int i) {
        super.onPageSelected(i);
        EventDispatcher access$getEventDispatcher$p = this.this$0.eventDispatcher;
        if (access$getEventDispatcher$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            access$getEventDispatcher$p = null;
        }
        access$getEventDispatcher$p.dispatchEvent(new PageSelectedEvent(this.$host.getId(), i));
    }

    public void onPageScrollStateChanged(int i) {
        String str;
        super.onPageScrollStateChanged(i);
        if (i == 0) {
            str = "idle";
        } else if (i == 1) {
            str = "dragging";
        } else if (i == 2) {
            str = "settling";
        } else {
            throw new IllegalStateException("Unsupported pageScrollState");
        }
        EventDispatcher access$getEventDispatcher$p = this.this$0.eventDispatcher;
        if (access$getEventDispatcher$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            access$getEventDispatcher$p = null;
        }
        access$getEventDispatcher$p.dispatchEvent(new PageScrollStateChangedEvent(this.$host.getId(), str));
    }
}
