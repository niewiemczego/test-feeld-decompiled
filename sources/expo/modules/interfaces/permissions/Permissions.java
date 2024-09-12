package expo.modules.interfaces.permissions;

import expo.modules.core.Promise;

public interface Permissions {
    void askForPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr);

    void askForPermissionsWithPromise(Promise promise, String... strArr);

    void getPermissions(PermissionsResponseListener permissionsResponseListener, String... strArr);

    void getPermissionsWithPromise(Promise promise, String... strArr);

    boolean hasGrantedPermissions(String... strArr);

    boolean isPermissionPresentInManifest(String str);

    static void getPermissionsWithPermissionsManager(Permissions permissions, Promise promise, String... strArr) {
        if (permissions == null) {
            promise.reject("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            permissions.getPermissionsWithPromise(promise, strArr);
        }
    }

    static void getPermissionsWithPermissionsManager(Permissions permissions, final expo.modules.kotlin.Promise promise, String... strArr) {
        getPermissionsWithPermissionsManager(permissions, (Promise) new Promise() {
            public void resolve(Object obj) {
                expo.modules.kotlin.Promise.this.resolve(obj);
            }

            public void reject(String str, String str2, Throwable th) {
                expo.modules.kotlin.Promise.this.reject(str, str2, th);
            }
        }, strArr);
    }

    static void askForPermissionsWithPermissionsManager(Permissions permissions, Promise promise, String... strArr) {
        if (permissions == null) {
            promise.reject("E_NO_PERMISSIONS", "Permissions module is null. Are you sure all the installed Expo modules are properly linked?");
        } else {
            permissions.askForPermissionsWithPromise(promise, strArr);
        }
    }

    static void askForPermissionsWithPermissionsManager(Permissions permissions, final expo.modules.kotlin.Promise promise, String... strArr) {
        askForPermissionsWithPermissionsManager(permissions, (Promise) new Promise() {
            public void resolve(Object obj) {
                expo.modules.kotlin.Promise.this.resolve(obj);
            }

            public void reject(String str, String str2, Throwable th) {
                expo.modules.kotlin.Promise.this.reject(str, str2, th);
            }
        }, strArr);
    }
}
