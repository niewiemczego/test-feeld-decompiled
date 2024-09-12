package expo.modules.adapters.react.permissions;

import expo.modules.core.Promise;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PermissionsService$$ExternalSyntheticLambda2 implements PermissionsResponseListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ PermissionsService$$ExternalSyntheticLambda2(Promise promise) {
        this.f$0 = promise;
    }

    public final void onResult(Map map) {
        PermissionsService.m687getPermissionsWithPromise$lambda6(this.f$0, map);
    }
}
