package zendesk.storage.android;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b\u001a*\u0010\b\u001a\u00020\t\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"get", "T", "Lzendesk/storage/android/Storage;", "key", "", "(Lzendesk/storage/android/Storage;Ljava/lang/String;)Ljava/lang/Object;", "persistedProperty", "Lzendesk/storage/android/PersistedProperty;", "set", "", "value", "(Lzendesk/storage/android/Storage;Ljava/lang/String;Ljava/lang/Object;)V", "zendesk.storage_storage-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageKtx.kt */
public final class StorageKtxKt {
    public static final /* synthetic */ <T> T get(Storage storage, String str) {
        Intrinsics.checkNotNullParameter(storage, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2056817302:
                    if (name.equals("java.lang.Integer")) {
                        Class cls3 = Integer.TYPE;
                        Class cls4 = cls3;
                        T t = storage.get(str, cls3);
                        Intrinsics.reifiedOperationMarker(1, "T?");
                        Object obj = (Object) t;
                        return t;
                    }
                    break;
                case -527879800:
                    if (name.equals("java.lang.Float")) {
                        Class cls5 = Float.TYPE;
                        Class cls6 = cls5;
                        T t2 = storage.get(str, cls5);
                        Intrinsics.reifiedOperationMarker(1, "T?");
                        Object obj2 = (Object) t2;
                        return t2;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        Class cls7 = Boolean.TYPE;
                        Class cls8 = cls7;
                        T t3 = storage.get(str, cls7);
                        Intrinsics.reifiedOperationMarker(1, "T?");
                        Object obj3 = (Object) t3;
                        return t3;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        Class cls9 = Long.TYPE;
                        Class cls10 = cls9;
                        T t4 = storage.get(str, cls9);
                        Intrinsics.reifiedOperationMarker(1, "T?");
                        Object obj4 = (Object) t4;
                        return t4;
                    }
                    break;
            }
        }
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls11 = Object.class;
        Class cls12 = cls11;
        return storage.get(str, cls11);
    }

    public static final /* synthetic */ <T> void set(Storage storage, String str, T t) {
        Intrinsics.checkNotNullParameter(storage, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        storage.set(str, t, cls);
    }

    public static final /* synthetic */ <T> PersistedProperty<T> persistedProperty(Storage storage, String str) {
        Intrinsics.checkNotNullParameter(storage, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        return new PersistedProperty<>(storage, str, cls);
    }
}
