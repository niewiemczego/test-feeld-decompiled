package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWorkManagerImplCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";

    public static class Default implements IWorkManagerImplCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onFailure(String str) throws RemoteException {
        }

        public void onSuccess(byte[] bArr) throws RemoteException {
        }
    }

    void onFailure(String str) throws RemoteException;

    void onSuccess(byte[] bArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {
        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IWorkManagerImplCallback.DESCRIPTOR);
        }

        public static IWorkManagerImplCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IWorkManagerImplCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IWorkManagerImplCallback)) {
                return new Proxy(iBinder);
            }
            return (IWorkManagerImplCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IWorkManagerImplCallback.DESCRIPTOR);
            }
            if (i != 1598968902) {
                if (i == 1) {
                    onSuccess(parcel.createByteArray());
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    onFailure(parcel.readString());
                }
                return true;
            }
            parcel2.writeString(IWorkManagerImplCallback.DESCRIPTOR);
            return true;
        }

        private static class Proxy implements IWorkManagerImplCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IWorkManagerImplCallback.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onSuccess(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWorkManagerImplCallback.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onFailure(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IWorkManagerImplCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
