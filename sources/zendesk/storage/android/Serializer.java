package zendesk.storage.android;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\u0004\b\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\bJ)\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u00032\u0006\u0010\n\u001a\u0002H\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0007H&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lzendesk/storage/android/Serializer;", "", "deserialize", "T", "source", "", "type", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "serialize", "data", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/String;", "zendesk.storage_storage-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Serializer.kt */
public interface Serializer {
    <T> T deserialize(String str, Class<T> cls);

    <T> String serialize(T t, Class<T> cls);
}
