package zendesk.storage.android;

import com.oblador.keychain.KeychainModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\u000eJ,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\r2\b\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010\u0012R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/storage/android/PersistedProperty;", "T", "", "storage", "Lzendesk/storage/android/Storage;", "key", "", "clazz", "Ljava/lang/Class;", "(Lzendesk/storage/android/Storage;Ljava/lang/String;Ljava/lang/Class;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersistedProperty.kt */
public final class PersistedProperty<T> {
    private final Class<T> clazz;
    private final String key;
    private final Storage storage;

    public PersistedProperty(Storage storage2, String str, Class<T> cls) {
        Intrinsics.checkNotNullParameter(storage2, KeychainModule.Maps.STORAGE);
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.storage = storage2;
        this.key = str;
        this.clazz = cls;
    }

    public final T getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.storage.get(this.key, this.clazz);
    }

    public final void setValue(Object obj, KProperty<?> kProperty, T t) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        this.storage.set(this.key, t, this.clazz);
    }
}
