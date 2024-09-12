package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.appsflyer.AFLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

@Deprecated
public final class AFa1eSDK {
    public final String[] AFKeystoreWrapper;

    AFa1eSDK() {
    }

    static AFa1ySDK values(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AFa1wSDK aFa1wSDK = new AFa1wSDK((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (!context.bindService(intent, aFa1wSDK, 1)) {
                    if (context != null) {
                        context.unbindService(aFa1wSDK);
                    }
                    throw new IOException("Google Play connection failed");
                } else if (!aFa1wSDK.AFKeystoreWrapper) {
                    aFa1wSDK.AFKeystoreWrapper = true;
                    IBinder poll = aFa1wSDK.values.poll(10, TimeUnit.SECONDS);
                    if (poll != null) {
                        AFa1zSDK aFa1zSDK = new AFa1zSDK(poll);
                        return new AFa1ySDK(aFa1zSDK.AFKeystoreWrapper(), aFa1zSDK.AFInAppEventParameterName());
                    }
                    throw new TimeoutException("Timed out waiting for the service connection");
                } else {
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
            } finally {
                if (context != null) {
                    context.unbindService(aFa1wSDK);
                }
            }
        } else {
            throw new IllegalStateException("Cannot be called from the main thread");
        }
    }

    static final class AFa1ySDK {
        private final boolean valueOf;
        final String values;

        AFa1ySDK(String str, boolean z) {
            this.values = str;
            this.valueOf = z;
        }

        /* access modifiers changed from: package-private */
        public final boolean valueOf() {
            return this.valueOf;
        }
    }

    static final class AFa1wSDK implements ServiceConnection {
        boolean AFKeystoreWrapper;
        final LinkedBlockingQueue<IBinder> values;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private AFa1wSDK() {
            this.values = new LinkedBlockingQueue<>(1);
            this.AFKeystoreWrapper = false;
        }

        /* synthetic */ AFa1wSDK(byte b) {
            this();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.values.put(iBinder);
            } catch (InterruptedException e) {
                AFLogger.afErrorLogForExcManagerOnly("onServiceConnected Interrupted", e);
            }
        }
    }

    static final class AFa1zSDK implements IInterface {
        private final IBinder AFInAppEventType;

        AFa1zSDK(IBinder iBinder) {
            this.AFInAppEventType = iBinder;
        }

        public final IBinder asBinder() {
            return this.AFInAppEventType;
        }

        public final String AFKeystoreWrapper() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.AFInAppEventType.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean AFInAppEventParameterName() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.AFInAppEventType.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public AFa1eSDK(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            this.AFKeystoreWrapper = null;
            return;
        }
        Pattern compile = Pattern.compile("[\\w]{1,45}");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null || !compile.matcher(str).matches()) {
                AFLogger.afWarnLog("Invalid partner name: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(str.toLowerCase(Locale.getDefault()));
            }
        }
        if (arrayList.contains("all")) {
            this.AFKeystoreWrapper = new String[]{"all"};
        } else if (!arrayList.isEmpty()) {
            this.AFKeystoreWrapper = (String[]) arrayList.toArray(new String[0]);
        } else {
            this.AFKeystoreWrapper = null;
        }
    }
}
