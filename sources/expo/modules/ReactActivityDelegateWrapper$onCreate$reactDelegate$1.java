package expo.modules;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.react.ReactDelegate;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, d2 = {"expo/modules/ReactActivityDelegateWrapper$onCreate$reactDelegate$1", "Lcom/facebook/react/ReactDelegate;", "createRootView", "Lcom/facebook/react/ReactRootView;", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactActivityDelegateWrapper.kt */
public final class ReactActivityDelegateWrapper$onCreate$reactDelegate$1 extends ReactDelegate {
    final /* synthetic */ ReactActivityDelegateWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReactActivityDelegateWrapper$onCreate$reactDelegate$1(ReactActivityDelegateWrapper reactActivityDelegateWrapper, Activity activity, ReactNativeHost reactNativeHost, String str, Bundle bundle) {
        super(activity, reactNativeHost, str, bundle);
        this.this$0 = reactActivityDelegateWrapper;
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        return this.this$0.createRootView();
    }
}
