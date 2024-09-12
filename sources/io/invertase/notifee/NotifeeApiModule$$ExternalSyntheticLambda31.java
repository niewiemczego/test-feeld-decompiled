package io.invertase.notifee;

import app.notifee.core.interfaces.MethodCallResult;
import com.facebook.react.bridge.Promise;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotifeeApiModule$$ExternalSyntheticLambda31 implements MethodCallResult {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ NotifeeApiModule$$ExternalSyntheticLambda31(Promise promise) {
        this.f$0 = promise;
    }

    public final void onComplete(Exception exc, Object obj) {
        NotifeeReactUtils.promiseStringListResolver(this.f$0, exc, (List) obj);
    }
}
