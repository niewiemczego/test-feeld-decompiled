package zendesk.storage.android;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J+\u0010\b\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H&J3\u0010\u000f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u0001H\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\fH&¢\u0006\u0002\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"Lzendesk/storage/android/Storage;", "", "namespace", "", "getNamespace", "()Ljava/lang/String;", "clear", "", "get", "T", "key", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Class;)V", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Storage.kt */
public interface Storage {
    void clear();

    <T> T get(String str, Class<T> cls);

    String getNamespace();

    void remove(String str);

    <T> void set(String str, T t, Class<T> cls);
}
