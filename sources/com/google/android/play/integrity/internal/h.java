package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public abstract class h extends b implements i {
    public static i b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.integrity.protocol.IExpressIntegrityService");
        return queryLocalInterface instanceof i ? (i) queryLocalInterface : new g(iBinder);
    }
}
