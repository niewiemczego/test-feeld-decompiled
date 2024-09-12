package coil.map;

import coil.request.Options;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002J\u001f\u0010\u0004\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcoil/map/Mapper;", "T", "", "V", "map", "data", "options", "Lcoil/request/Options;", "(Ljava/lang/Object;Lcoil/request/Options;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Mapper.kt */
public interface Mapper<T, V> {
    V map(T t, Options options);
}
