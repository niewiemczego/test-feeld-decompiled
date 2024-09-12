package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@17.1.0 */
final class zzp {
    private final Messenger zza;
    private final zze zzb;

    zzp(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (zzo.zza(interfaceDescriptor, "android.os.IMessenger")) {
            this.zza = new Messenger(iBinder);
            this.zzb = null;
        } else if (zzo.zza(interfaceDescriptor, IMessengerCompat.DESCRIPTOR)) {
            this.zzb = new zze(iBinder);
            this.zza = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zze zze = this.zzb;
        if (zze != null) {
            zze.zzb(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
