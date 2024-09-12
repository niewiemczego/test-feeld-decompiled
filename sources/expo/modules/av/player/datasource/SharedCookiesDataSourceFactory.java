package expo.modules.av.player.datasource;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.TransferListener;
import expo.modules.core.ModuleRegistry;
import java.net.CookieHandler;
import java.util.Map;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;

public class SharedCookiesDataSourceFactory implements DataSource.Factory {
    private final DataSource.Factory mDataSourceFactory;

    public SharedCookiesDataSourceFactory(Context context, ModuleRegistry moduleRegistry, String str, Map<String, Object> map, TransferListener transferListener) {
        CookieHandler cookieHandler = (CookieHandler) moduleRegistry.getModule(CookieHandler.class);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (cookieHandler != null) {
            builder.cookieJar(new JavaNetCookieJar(cookieHandler));
        }
        this.mDataSourceFactory = new DefaultDataSourceFactory(context, transferListener, (DataSource.Factory) new CustomHeadersOkHttpDataSourceFactory(builder.build(), str, map));
    }

    public DataSource createDataSource() {
        return this.mDataSourceFactory.createDataSource();
    }
}
