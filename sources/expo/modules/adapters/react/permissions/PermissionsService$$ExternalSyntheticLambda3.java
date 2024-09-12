package expo.modules.adapters.react.permissions;

import expo.modules.interfaces.permissions.PermissionsResponseListener;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PermissionsService$$ExternalSyntheticLambda3 implements PermissionsResponseListener {
    public final /* synthetic */ PermissionsService f$0;
    public final /* synthetic */ PermissionsResponseListener f$1;

    public /* synthetic */ PermissionsService$$ExternalSyntheticLambda3(PermissionsService permissionsService, PermissionsResponseListener permissionsResponseListener) {
        this.f$0 = permissionsService;
        this.f$1 = permissionsResponseListener;
    }

    public final void onResult(Map map) {
        PermissionsService.m684askForPermissions$lambda10(this.f$0, this.f$1, map);
    }
}
