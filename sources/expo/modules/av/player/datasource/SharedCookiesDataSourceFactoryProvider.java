package expo.modules.av.player.datasource;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.InternalModule;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SharedCookiesDataSourceFactoryProvider implements InternalModule, DataSourceFactoryProvider {
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(DataSourceFactoryProvider.class);
    }

    public DataSource.Factory createFactory(Context context, ModuleRegistry moduleRegistry, String str, Map<String, Object> map, TransferListener transferListener) {
        return new SharedCookiesDataSourceFactory(context, moduleRegistry, str, map, transferListener);
    }
}
