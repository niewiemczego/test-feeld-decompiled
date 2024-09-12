package expo.modules.adapters.react.permissions;

import expo.modules.core.Promise;
import expo.modules.interfaces.permissions.PermissionsResponseListener;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PermissionsService$$ExternalSyntheticLambda1 implements PermissionsResponseListener {
    public final /* synthetic */ PermissionsService f$0;
    public final /* synthetic */ Promise f$1;
    public final /* synthetic */ String[] f$2;

    public /* synthetic */ PermissionsService$$ExternalSyntheticLambda1(PermissionsService permissionsService, Promise promise, String[] strArr) {
        this.f$0 = permissionsService;
        this.f$1 = promise;
        this.f$2 = strArr;
    }

    public final void onResult(Map map) {
        PermissionsService.m685askForPermissionsWithPromise$lambda7(this.f$0, this.f$1, this.f$2, map);
    }
}
