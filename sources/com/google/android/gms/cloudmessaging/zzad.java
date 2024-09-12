package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
final class zzad extends zzf {
    final /* synthetic */ Rpc zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzad(Rpc rpc, Looper looper) {
        super(looper);
        this.zza = rpc;
    }

    public final void handleMessage(Message message) {
        Rpc.zzc(this.zza, message);
    }
}
