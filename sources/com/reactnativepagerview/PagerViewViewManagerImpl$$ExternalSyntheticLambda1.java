package com.reactnativepagerview;

import android.view.View;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PagerViewViewManagerImpl$$ExternalSyntheticLambda1 implements ViewPager2.PageTransformer {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ViewPager2 f$1;

    public /* synthetic */ PagerViewViewManagerImpl$$ExternalSyntheticLambda1(int i, ViewPager2 viewPager2) {
        this.f$0 = i;
        this.f$1 = viewPager2;
    }

    public final void transformPage(View view, float f) {
        PagerViewViewManagerImpl.m628setPageMargin$lambda1(this.f$0, this.f$1, view, f);
    }
}
