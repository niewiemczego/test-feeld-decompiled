package io.invertase.notifee;

import android.os.Bundle;
import app.notifee.core.interfaces.MethodCallResult;
import com.facebook.react.bridge.Promise;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotifeeApiModule$$ExternalSyntheticLambda14 implements MethodCallResult {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ NotifeeApiModule$$ExternalSyntheticLambda14(Promise promise) {
        this.f$0 = promise;
    }

    public final void onComplete(Exception exc, Object obj) {
        NotifeeReactUtils.promiseResolver(this.f$0, exc, (List<Bundle>) (List) obj);
    }
}
