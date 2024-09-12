package expo.modules;

import android.content.Intent;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/ReactActivityDelegateWrapper$onActivityResult$reactContextListener$1", "Lcom/facebook/react/ReactInstanceEventListener;", "onReactContextInitialized", "", "context", "Lcom/facebook/react/bridge/ReactContext;", "expo_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReactActivityDelegateWrapper.kt */
public final class ReactActivityDelegateWrapper$onActivityResult$reactContextListener$1 implements ReactInstanceEventListener {
    final /* synthetic */ Intent $data;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ int $resultCode;
    final /* synthetic */ ReactActivityDelegateWrapper this$0;

    ReactActivityDelegateWrapper$onActivityResult$reactContextListener$1(ReactActivityDelegateWrapper reactActivityDelegateWrapper, int i, int i2, Intent intent) {
        this.this$0 = reactActivityDelegateWrapper;
        this.$requestCode = i;
        this.$resultCode = i2;
        this.$data = intent;
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        this.this$0.delegate.getReactInstanceManager().removeReactInstanceEventListener(this);
        this.this$0.delegate.onActivityResult(this.$requestCode, this.$resultCode, this.$data);
    }
}
