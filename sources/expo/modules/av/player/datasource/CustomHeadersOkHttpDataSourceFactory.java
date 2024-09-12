package expo.modules.av.player.datasource;

import androidx.collection.ArrayMap;
import com.google.android.exoplayer2.ext.okhttp.OkHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.CacheControl;
import okhttp3.Call;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u001e\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/av/player/datasource/CustomHeadersOkHttpDataSourceFactory;", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$BaseFactory;", "callFactory", "Lokhttp3/Call$Factory;", "userAgent", "", "requestHeaders", "", "", "(Lokhttp3/Call$Factory;Ljava/lang/String;Ljava/util/Map;)V", "cacheControl", "Lokhttp3/CacheControl;", "createDataSourceInternal", "Lcom/google/android/exoplayer2/ext/okhttp/OkHttpDataSource;", "defaultRequestProperties", "Lcom/google/android/exoplayer2/upstream/HttpDataSource$RequestProperties;", "updateRequestProperties", "", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomHeadersOkHttpDataSourceFactory.kt */
public final class CustomHeadersOkHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final String userAgent;

    public CustomHeadersOkHttpDataSourceFactory(Call.Factory factory, String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(factory, "callFactory");
        this.callFactory = factory;
        this.userAgent = str;
        updateRequestProperties(map);
    }

    private final void updateRequestProperties(Map<String, ? extends Object> map) {
        if (map != null) {
            ArrayMap arrayMap = new ArrayMap();
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    arrayMap.put(str, value);
                }
            }
            setDefaultRequestProperties(arrayMap);
        }
    }

    /* access modifiers changed from: protected */
    public OkHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        Intrinsics.checkNotNullParameter(requestProperties, "defaultRequestProperties");
        return new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, requestProperties);
    }
}
