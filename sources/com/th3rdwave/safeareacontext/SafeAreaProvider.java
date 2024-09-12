package com.th3rdwave.safeareacontext;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.facebook.react.views.view.ReactViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016J[\u0010\u0018\u001a\u00020\u000f2S\u0010\u0019\u001aO\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010R[\u0010\u0006\u001aO\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007j\u0004\u0018\u0001`\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaProvider;", "Lcom/facebook/react/views/view/ReactViewGroup;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mInsetsChangeHandler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "view", "Lcom/th3rdwave/safeareacontext/EdgeInsets;", "insets", "Lcom/th3rdwave/safeareacontext/Rect;", "frame", "", "Lcom/th3rdwave/safeareacontext/OnInsetsChangeHandler;", "mLastFrame", "mLastInsets", "maybeUpdateInsets", "onAttachedToWindow", "onDetachedFromWindow", "onPreDraw", "", "setOnInsetsChangeHandler", "handler", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SafeAreaProvider.kt */
public final class SafeAreaProvider extends ReactViewGroup implements ViewTreeObserver.OnPreDrawListener {
    private Function3<? super SafeAreaProvider, ? super EdgeInsets, ? super Rect, Unit> mInsetsChangeHandler;
    private Rect mLastFrame;
    private EdgeInsets mLastInsets;

    public SafeAreaProvider(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void maybeUpdateInsets() {
        /*
            r5 = this;
            kotlin.jvm.functions.Function3<? super com.th3rdwave.safeareacontext.SafeAreaProvider, ? super com.th3rdwave.safeareacontext.EdgeInsets, ? super com.th3rdwave.safeareacontext.Rect, kotlin.Unit> r0 = r5.mInsetsChangeHandler
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r1 = r5
            android.view.View r1 = (android.view.View) r1
            com.th3rdwave.safeareacontext.EdgeInsets r2 = com.th3rdwave.safeareacontext.SafeAreaUtilsKt.getSafeAreaInsets(r1)
            if (r2 != 0) goto L_0x000f
            return
        L_0x000f:
            android.view.View r3 = r5.getRootView()
            java.lang.String r4 = "null cannot be cast to non-null type android.view.ViewGroup"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            com.th3rdwave.safeareacontext.Rect r1 = com.th3rdwave.safeareacontext.SafeAreaUtilsKt.getFrame(r3, r1)
            if (r1 != 0) goto L_0x0021
            return
        L_0x0021:
            com.th3rdwave.safeareacontext.EdgeInsets r3 = r5.mLastInsets
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r2)
            if (r3 == 0) goto L_0x0031
            com.th3rdwave.safeareacontext.Rect r3 = r5.mLastFrame
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r1)
            if (r3 != 0) goto L_0x0038
        L_0x0031:
            r0.invoke(r5, r2, r1)
            r5.mLastInsets = r2
            r5.mLastFrame = r1
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaProvider.maybeUpdateInsets():void");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this);
        maybeUpdateInsets();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        maybeUpdateInsets();
        return true;
    }

    public final void setOnInsetsChangeHandler(Function3<? super SafeAreaProvider, ? super EdgeInsets, ? super Rect, Unit> function3) {
        this.mInsetsChangeHandler = function3;
        maybeUpdateInsets();
    }
}
