package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
final class zbh extends zba {
    final /* synthetic */ zbi zba;

    zbh(zbi zbi) {
        this.zba = zbi;
    }

    public final void zbc(Status status) throws RemoteException {
        this.zba.setResult(status);
    }
}
