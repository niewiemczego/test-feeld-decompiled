package com.facebook.react.defaults;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u0007H\u0014R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactActivityDelegate;", "Lcom/facebook/react/ReactActivityDelegate;", "activity", "Lcom/facebook/react/ReactActivity;", "mainComponentName", "", "fabricEnabled", "", "concurrentRootEnabled", "(Lcom/facebook/react/ReactActivity;Ljava/lang/String;ZZ)V", "createRootView", "Lcom/facebook/react/ReactRootView;", "isConcurrentRootEnabled", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultReactActivityDelegate.kt */
public class DefaultReactActivityDelegate extends ReactActivityDelegate {
    private final boolean concurrentRootEnabled;
    private final boolean fabricEnabled;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultReactActivityDelegate(ReactActivity reactActivity, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactActivity, str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultReactActivityDelegate(ReactActivity reactActivity, String str, boolean z, boolean z2) {
        super(reactActivity, str);
        Intrinsics.checkNotNullParameter(reactActivity, "activity");
        Intrinsics.checkNotNullParameter(str, "mainComponentName");
        this.fabricEnabled = z;
        this.concurrentRootEnabled = z2;
    }

    /* access modifiers changed from: protected */
    public boolean isConcurrentRootEnabled() {
        return this.concurrentRootEnabled;
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        ReactRootView reactRootView = new ReactRootView(getContext());
        reactRootView.setIsFabric(this.fabricEnabled);
        return reactRootView;
    }
}
