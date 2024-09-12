package coil.key;

import coil.request.Options;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u001f\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcoil/key/Keyer;", "T", "", "key", "", "data", "options", "Lcoil/request/Options;", "(Ljava/lang/Object;Lcoil/request/Options;)Ljava/lang/String;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Keyer.kt */
public interface Keyer<T> {
    String key(T t, Options options);
}
