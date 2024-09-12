package com.google.firebase.dynamiclinks.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.firebase.dynamiclinks.internal.IDynamicLinksCallbacks;

public interface IDynamicLinksService extends IInterface {

    public static class Default implements IDynamicLinksService {
        public IBinder asBinder() {
            return null;
        }

        public void createShortDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, Bundle bundle) throws RemoteException {
        }

        public void getDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, String str) throws RemoteException {
        }
    }

    void createShortDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, Bundle bundle) throws RemoteException;

    void getDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IDynamicLinksService {
        private static final String DESCRIPTOR = "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
        static final int TRANSACTION_createShortDynamicLink = 2;
        static final int TRANSACTION_getDynamicLink = 1;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, "com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
        }

        public static IDynamicLinksService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IDynamicLinksService)) {
                return new Proxy(iBinder);
            }
            return (IDynamicLinksService) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
                getDynamicLink(IDynamicLinksCallbacks.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
                createShortDynamicLink(IDynamicLinksCallbacks.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
                return true;
            }
        }

        private static class Proxy implements IDynamicLinksService {
            public static IDynamicLinksService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return "com.google.firebase.dynamiclinks.internal.IDynamicLinksService";
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void getDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
                    obtain.writeStrongBinder(iDynamicLinksCallbacks != null ? iDynamicLinksCallbacks.asBinder() : null);
                    obtain.writeString(str);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().getDynamicLink(iDynamicLinksCallbacks, str);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void createShortDynamicLink(IDynamicLinksCallbacks iDynamicLinksCallbacks, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.firebase.dynamiclinks.internal.IDynamicLinksService");
                    obtain.writeStrongBinder(iDynamicLinksCallbacks != null ? iDynamicLinksCallbacks.asBinder() : null);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    Stub.getDefaultImpl().createShortDynamicLink(iDynamicLinksCallbacks, bundle);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IDynamicLinksService iDynamicLinksService) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            } else if (iDynamicLinksService == null) {
                return false;
            } else {
                Proxy.sDefaultImpl = iDynamicLinksService;
                return true;
            }
        }

        public static IDynamicLinksService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
