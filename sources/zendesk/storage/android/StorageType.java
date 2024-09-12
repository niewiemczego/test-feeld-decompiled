package zendesk.storage.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/storage/android/StorageType;", "", "()V", "Basic", "Complex", "Lzendesk/storage/android/StorageType$Basic;", "Lzendesk/storage/android/StorageType$Complex;", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StorageType.kt */
public abstract class StorageType {
    public /* synthetic */ StorageType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private StorageType() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/storage/android/StorageType$Basic;", "Lzendesk/storage/android/StorageType;", "()V", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StorageType.kt */
    public static final class Basic extends StorageType {
        public static final Basic INSTANCE = new Basic();

        private Basic() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/storage/android/StorageType$Complex;", "Lzendesk/storage/android/StorageType;", "serializer", "Lzendesk/storage/android/Serializer;", "(Lzendesk/storage/android/Serializer;)V", "getSerializer", "()Lzendesk/storage/android/Serializer;", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StorageType.kt */
    public static final class Complex extends StorageType {
        private final Serializer serializer;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Complex(Serializer serializer2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(serializer2, "serializer");
            this.serializer = serializer2;
        }

        public final Serializer getSerializer() {
            return this.serializer;
        }
    }
}
