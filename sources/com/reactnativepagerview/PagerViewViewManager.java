package com.reactnativepagerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager2.widget.ViewPager2;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativepagerview.event.PageScrollEvent;
import com.reactnativepagerview.event.PageScrollStateChangedEvent;
import com.reactnativepagerview.event.PageSelectedEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J \u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00160\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\nH\u0016J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0019\u0010#\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\fH\u0002J\u0018\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\fH\u0007J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0015H\u0007J\u0018\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\fH\u0007J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0019H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/reactnativepagerview/NestedScrollableHost;", "()V", "eventDispatcher", "Lcom/facebook/react/uimanager/events/EventDispatcher;", "addView", "", "host", "child", "Landroid/view/View;", "index", "", "createViewInstance", "reactContext", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getChildAt", "parent", "getChildCount", "getExportedCustomDirectEventTypeConstants", "", "", "", "getName", "needsCustomLayoutForChildren", "", "receiveCommand", "root", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "removeAllViews", "removeView", "view", "removeViewAt", "set", "value", "setInitialPage", "setLayoutDirection", "setOrientation", "setOverScrollMode", "setPageMargin", "margin", "setScrollEnabled", "Companion", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PagerViewViewManager.kt */
public final class PagerViewViewManager extends ViewGroupManager<NestedScrollableHost> {
    private static final String COMMAND_SET_PAGE = "setPage";
    private static final String COMMAND_SET_PAGE_WITHOUT_ANIMATION = "setPageWithoutAnimation";
    private static final String COMMAND_SET_SCROLL_ENABLED = "setScrollEnabledImperatively";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public EventDispatcher eventDispatcher;

    public String getName() {
        return PagerViewViewManagerImpl.NAME;
    }

    /* access modifiers changed from: protected */
    public NestedScrollableHost createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "reactContext");
        Context context = themedReactContext;
        NestedScrollableHost nestedScrollableHost = new NestedScrollableHost(context);
        nestedScrollableHost.setId(View.generateViewId());
        nestedScrollableHost.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        nestedScrollableHost.setSaveEnabled(false);
        ViewPager2 viewPager2 = new ViewPager2(context);
        viewPager2.setAdapter(new ViewPagerAdapter());
        viewPager2.setSaveEnabled(false);
        NativeModule nativeModule = themedReactContext.getNativeModule(UIManagerModule.class);
        Intrinsics.checkNotNull(nativeModule);
        EventDispatcher eventDispatcher2 = ((UIManagerModule) nativeModule).getEventDispatcher();
        Intrinsics.checkNotNullExpressionValue(eventDispatcher2, "reactContext.getNativeMo…s.java)!!.eventDispatcher");
        this.eventDispatcher = eventDispatcher2;
        viewPager2.post(new PagerViewViewManager$$ExternalSyntheticLambda0(viewPager2, this, nestedScrollableHost));
        nestedScrollableHost.addView(viewPager2);
        return nestedScrollableHost;
    }

    /* access modifiers changed from: private */
    /* renamed from: createViewInstance$lambda-0  reason: not valid java name */
    public static final void m624createViewInstance$lambda0(ViewPager2 viewPager2, PagerViewViewManager pagerViewViewManager, NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(viewPager2, "$vp");
        Intrinsics.checkNotNullParameter(pagerViewViewManager, "this$0");
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "$host");
        viewPager2.registerOnPageChangeCallback(new PagerViewViewManager$createViewInstance$1$1(pagerViewViewManager, nestedScrollableHost));
        EventDispatcher eventDispatcher2 = pagerViewViewManager.eventDispatcher;
        if (eventDispatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eventDispatcher");
            eventDispatcher2 = null;
        }
        eventDispatcher2.dispatchEvent(new PageSelectedEvent(nestedScrollableHost.getId(), viewPager2.getCurrentItem()));
    }

    public void addView(NestedScrollableHost nestedScrollableHost, View view, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        PagerViewViewManagerImpl.INSTANCE.addView(nestedScrollableHost, view, i);
    }

    public int getChildCount(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildCount(nestedScrollableHost);
    }

    public View getChildAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        return PagerViewViewManagerImpl.INSTANCE.getChildAt(nestedScrollableHost, i);
    }

    public void removeView(NestedScrollableHost nestedScrollableHost, View view) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        PagerViewViewManagerImpl.INSTANCE.removeView(nestedScrollableHost, view);
    }

    public void removeAllViews(NestedScrollableHost nestedScrollableHost) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeAllViews(nestedScrollableHost);
    }

    public void removeViewAt(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "parent");
        PagerViewViewManagerImpl.INSTANCE.removeViewAt(nestedScrollableHost, i);
    }

    public boolean needsCustomLayoutForChildren() {
        return PagerViewViewManagerImpl.INSTANCE.needsCustomLayoutForChildren();
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public final void setScrollEnabled(NestedScrollableHost nestedScrollableHost, boolean z) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        PagerViewViewManagerImpl.INSTANCE.setScrollEnabled(nestedScrollableHost, z);
    }

    @ReactProp(defaultInt = 0, name = "initialPage")
    public final void setInitialPage(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        PagerViewViewManagerImpl.INSTANCE.setInitialPage(nestedScrollableHost, i);
    }

    @ReactProp(name = "orientation")
    public final void setOrientation(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        PagerViewViewManagerImpl.INSTANCE.setOrientation(nestedScrollableHost, str);
    }

    @ReactProp(defaultInt = -1, name = "offscreenPageLimit")
    public final void set(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        PagerViewViewManagerImpl.INSTANCE.setOffscreenPageLimit(nestedScrollableHost, i);
    }

    @ReactProp(name = "overScrollMode")
    public final void setOverScrollMode(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        PagerViewViewManagerImpl.INSTANCE.setOverScrollMode(nestedScrollableHost, str);
    }

    @ReactProp(name = "layoutDirection")
    public final void setLayoutDirection(NestedScrollableHost nestedScrollableHost, String str) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        Intrinsics.checkNotNullParameter(str, "value");
        PagerViewViewManagerImpl.INSTANCE.setLayoutDirection(nestedScrollableHost, str);
    }

    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        Map<String, Map<String, String>> of = MapBuilder.of(PageScrollEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScroll"), PageScrollStateChangedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageScrollStateChanged"), PageSelectedEvent.EVENT_NAME, MapBuilder.of("registrationName", "onPageSelected"));
        Intrinsics.checkNotNullExpressionValue(of, "of(\n                Page…Name\", \"onPageSelected\"))");
        return of;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r8.equals(COMMAND_SET_PAGE) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        if (r8.equals(COMMAND_SET_PAGE_WITHOUT_ANIMATION) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveCommand(com.reactnativepagerview.NestedScrollableHost r7, java.lang.String r8, com.facebook.react.bridge.ReadableArray r9) {
        /*
            r6 = this;
            java.lang.String r0 = "root"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = r7
            android.view.View r0 = (android.view.View) r0
            super.receiveCommand(r0, (java.lang.String) r8, (com.facebook.react.bridge.ReadableArray) r9)
            com.reactnativepagerview.PagerViewViewManagerImpl r0 = com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE
            androidx.viewpager2.widget.ViewPager2 r7 = r0.getViewPager(r7)
            com.facebook.infer.annotation.Assertions.assertNotNull(r7)
            com.facebook.infer.annotation.Assertions.assertNotNull(r9)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r7.getAdapter()
            if (r0 == 0) goto L_0x0026
            int r0 = r0.getItemCount()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            r1 = 1
            r2 = 0
            if (r8 == 0) goto L_0x0087
            int r3 = r8.hashCode()
            r4 = -445763635(0xffffffffe56e2fcd, float:-7.030031E22)
            java.lang.String r5 = "setPage"
            if (r3 == r4) goto L_0x005a
            r4 = 1747675147(0x682b680b, float:3.2377757E24)
            if (r3 == r4) goto L_0x0047
            r4 = 1984860689(0x764e9211, float:1.0474372E33)
            if (r3 != r4) goto L_0x0087
            boolean r3 = r8.equals(r5)
            if (r3 == 0) goto L_0x0087
            goto L_0x0062
        L_0x0047:
            java.lang.String r0 = "setScrollEnabledImperatively"
            boolean r0 = r8.equals(r0)
            if (r0 == 0) goto L_0x0087
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r8 = r9.getBoolean(r2)
            r7.setUserInputEnabled(r8)
            goto L_0x0086
        L_0x005a:
            java.lang.String r3 = "setPageWithoutAnimation"
            boolean r3 = r8.equals(r3)
            if (r3 == 0) goto L_0x0087
        L_0x0062:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r9 = r9.getInt(r2)
            if (r0 == 0) goto L_0x007a
            int r3 = r0.intValue()
            if (r3 <= 0) goto L_0x007a
            if (r9 < 0) goto L_0x007a
            int r0 = r0.intValue()
            if (r9 >= r0) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            if (r1 == 0) goto L_0x0086
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r5)
            com.reactnativepagerview.PagerViewViewManagerImpl r0 = com.reactnativepagerview.PagerViewViewManagerImpl.INSTANCE
            r0.setCurrentItem(r7, r9, r8)
        L_0x0086:
            return
        L_0x0087:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r9 = 2
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r0[r2] = r8
            java.lang.Class r8 = r6.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r0[r1] = r8
            java.lang.Object[] r8 = java.util.Arrays.copyOf(r0, r9)
            java.lang.String r9 = "Unsupported command %d received by %s."
            java.lang.String r8 = java.lang.String.format(r9, r8)
            java.lang.String r9 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativepagerview.PagerViewViewManager.receiveCommand(com.reactnativepagerview.NestedScrollableHost, java.lang.String, com.facebook.react.bridge.ReadableArray):void");
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public final void setPageMargin(NestedScrollableHost nestedScrollableHost, int i) {
        Intrinsics.checkNotNullParameter(nestedScrollableHost, "host");
        PagerViewViewManagerImpl.INSTANCE.setPageMargin(nestedScrollableHost, i);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/reactnativepagerview/PagerViewViewManager$Companion;", "", "()V", "COMMAND_SET_PAGE", "", "COMMAND_SET_PAGE_WITHOUT_ANIMATION", "COMMAND_SET_SCROLL_ENABLED", "react-native-pager-view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PagerViewViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
