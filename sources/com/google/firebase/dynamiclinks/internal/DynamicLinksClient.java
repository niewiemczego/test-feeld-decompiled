package com.google.firebase.dynamiclinks.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks;
import com.google.firebase.dynamiclinks.internal.IDynamicLinksService;

public class DynamicLinksClient extends GmsClient<IDynamicLinksService> {
    public static final String ACTION_START_SERVICE = "com.google.firebase.dynamiclinks.service.START";
    private static final int DYNAMIC_LINKS_API_VALUE = 131;
    public static final String SERVICE_DESCRIPTOR = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
    private static final int V17 = 12451000;

    public int getMinApkVersion() {
        return 12451000;
    }

    /* access modifiers changed from: protected */
    public String getServiceDescriptor() {
        return SERVICE_DESCRIPTOR;
    }

    /* access modifiers changed from: protected */
    public String getStartServiceAction() {
        return ACTION_START_SERVICE;
    }

    public boolean usesClientTelemetry() {
        return true;
    }

    public DynamicLinksClient(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, (int) DYNAMIC_LINKS_API_VALUE, clientSettings, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    public IDynamicLinksService createServiceInterface(IBinder iBinder) {
        return IDynamicLinksService.Stub.asInterface(iBinder);
    }

    /* access modifiers changed from: package-private */
    public void getDynamicLink(IDynamicLinksCallbacks.Stub stub, String str) {
        try {
            ((IDynamicLinksService) getService()).getDynamicLink(stub, str);
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void createShortDynamicLink(IDynamicLinksCallbacks.Stub stub, Bundle bundle) {
        try {
            ((IDynamicLinksService) getService()).createShortDynamicLink(stub, bundle);
        } catch (RemoteException unused) {
        }
    }
}
