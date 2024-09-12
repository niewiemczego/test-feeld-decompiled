package io.invertase.firebase.installations;

import android.util.Log;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.installations.InstallationTokenResult;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.concurrent.Executor;

public class ReactNativeFirebaseInstallationsModule extends ReactNativeFirebaseModule {
    private static final String TAG = "Installations";

    ReactNativeFirebaseInstallationsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    @ReactMethod
    public void getId(String str, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda0(FirebaseApp.getInstance(str))).addOnCompleteListener((Executor) getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda1(promise));
    }

    static /* synthetic */ String lambda$getId$0(FirebaseApp firebaseApp) throws Exception {
        return (String) Tasks.await(FirebaseInstallations.getInstance(firebaseApp).getId());
    }

    static /* synthetic */ void lambda$getId$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
            return;
        }
        Log.e(TAG, "RNFB: Unknown error while fetching Installations ID " + task.getException().getMessage());
        rejectPromiseWithCodeAndMessage(promise, "id-error", task.getException().getMessage());
    }

    @ReactMethod
    public void getToken(String str, boolean z, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda2(FirebaseApp.getInstance(str), z)).addOnCompleteListener((Executor) getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda3(promise));
    }

    static /* synthetic */ InstallationTokenResult lambda$getToken$2(FirebaseApp firebaseApp, boolean z) throws Exception {
        return (InstallationTokenResult) Tasks.await(FirebaseInstallations.getInstance(firebaseApp).getToken(z));
    }

    static /* synthetic */ void lambda$getToken$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(((InstallationTokenResult) task.getResult()).getToken());
            return;
        }
        Log.e(TAG, "RNFB: Unknown error while fetching Installations token " + task.getException().getMessage());
        rejectPromiseWithCodeAndMessage(promise, "token-error", task.getException().getMessage());
    }

    @ReactMethod
    public void delete(String str, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda4(FirebaseApp.getInstance(str))).addOnCompleteListener((Executor) getExecutor(), new ReactNativeFirebaseInstallationsModule$$ExternalSyntheticLambda5(promise));
    }

    static /* synthetic */ Void lambda$delete$4(FirebaseApp firebaseApp) throws Exception {
        return (Void) Tasks.await(FirebaseInstallations.getInstance(firebaseApp).delete());
    }

    static /* synthetic */ void lambda$delete$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve((Object) null);
            return;
        }
        Log.e(TAG, "RNFB: Unknown error while deleting Installations" + task.getException().getMessage());
        rejectPromiseWithCodeAndMessage(promise, "delete-error", task.getException().getMessage());
    }
}
