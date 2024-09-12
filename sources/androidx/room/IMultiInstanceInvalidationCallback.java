package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IMultiInstanceInvalidationCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx.room.IMultiInstanceInvalidationCallback";

    public static class Default implements IMultiInstanceInvalidationCallback {
        public IBinder asBinder() {
            return null;
        }

        public void onInvalidation(String[] strArr) throws RemoteException {
        }
    }

    void onInvalidation(String[] strArr) throws RemoteException;

    public static abstract class Stub extends Binder implements IMultiInstanceInvalidationCallback {
        static final int TRANSACTION_onInvalidation = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMultiInstanceInvalidationCallback.DESCRIPTOR);
        }

        public static IMultiInstanceInvalidationCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IMultiInstanceInvalidationCallback)) {
                return new Proxy(iBinder);
            }
            return (IMultiInstanceInvalidationCallback) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMultiInstanceInvalidationCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMultiInstanceInvalidationCallback.DESCRIPTOR);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                onInvalidation(parcel.createStringArray());
                return true;
            }
        }

        private static class Proxy implements IMultiInstanceInvalidationCallback {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return IMultiInstanceInvalidationCallback.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void onInvalidation(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IMultiInstanceInvalidationCallback.DESCRIPTOR);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
