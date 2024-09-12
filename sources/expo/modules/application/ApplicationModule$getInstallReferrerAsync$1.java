package expo.modules.application;

import android.os.RemoteException;
import android.util.Log;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import expo.modules.core.Promise;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"expo/modules/application/ApplicationModule$getInstallReferrerAsync$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "expo-application_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ApplicationModule.kt */
public final class ApplicationModule$getInstallReferrerAsync$1 implements InstallReferrerStateListener {
    final /* synthetic */ StringBuilder $installReferrer;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    ApplicationModule$getInstallReferrerAsync$1(InstallReferrerClient installReferrerClient, StringBuilder sb, Promise promise) {
        this.$referrerClient = installReferrerClient;
        this.$installReferrer = sb;
        this.$promise = promise;
    }

    public void onInstallReferrerSetupFinished(int i) {
        if (i == 0) {
            try {
                this.$installReferrer.append(this.$referrerClient.getInstallReferrer().getInstallReferrer());
            } catch (RemoteException e) {
                Throwable th = e;
                Log.e(ApplicationModuleKt.TAG, "Exception: ", th);
                this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_REMOTE_EXCEPTION", "RemoteException getting install referrer information. This may happen if the process hosting the remote object is no longer available.", th);
            }
            this.$promise.resolve(this.$installReferrer.toString());
        } else if (i == 1) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_CONNECTION", "Could not establish a connection to Google Play");
        } else if (i != 2) {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER", "General error retrieving the install referrer: response code " + i);
        } else {
            this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_UNAVAILABLE", "The current Play Store app doesn't provide the installation referrer API, or the Play Store may not be installed.");
        }
        this.$referrerClient.endConnection();
    }

    public void onInstallReferrerServiceDisconnected() {
        this.$promise.reject("ERR_APPLICATION_INSTALL_REFERRER_SERVICE_DISCONNECTED", "Connection to install referrer service was lost.");
    }
}
