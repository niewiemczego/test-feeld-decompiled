package com.google.android.gms.internal.p001authapi;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* renamed from: com.google.android.gms.internal.auth-api.zbm  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
abstract class zbm extends BaseImplementation.ApiMethodImpl {
    zbm(GoogleApiClient googleApiClient) {
        super((Api<?>) Auth.CREDENTIALS_API, googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zbo zbo = (zbo) anyClient;
        zba(zbo.getContext(), (zbt) zbo.getService());
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    /* access modifiers changed from: protected */
    public abstract void zba(Context context, zbt zbt) throws DeadObjectException, RemoteException;
}
