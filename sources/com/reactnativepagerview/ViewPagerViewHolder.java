package com.reactnativepagerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/reactnativepagerview/ViewPagerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "container", "Landroid/widget/FrameLayout;", "(Landroid/widget/FrameLayout;)V", "getContainer", "()Landroid/widget/FrameLayout;", "Companion", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewPagerViewHolder.kt */
public final class ViewPagerViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ ViewPagerViewHolder(FrameLayout frameLayout, DefaultConstructorMarker defaultConstructorMarker) {
        this(frameLayout);
    }

    private ViewPagerViewHolder(FrameLayout frameLayout) {
        super(frameLayout);
    }

    public final FrameLayout getContainer() {
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) view;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/reactnativepagerview/ViewPagerViewHolder$Companion;", "", "()V", "create", "Lcom/reactnativepagerview/ViewPagerViewHolder;", "parent", "Landroid/view/ViewGroup;", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ViewPagerViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ViewPagerViewHolder create(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            frameLayout.setSaveEnabled(false);
            return new ViewPagerViewHolder(frameLayout, (DefaultConstructorMarker) null);
        }
    }
}
