package expo.modules.av.player.datasource;

import android.content.Context;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import expo.modules.core.ModuleRegistry;
import java.util.Map;

public interface DataSourceFactoryProvider {
    DataSource.Factory createFactory(Context context, ModuleRegistry moduleRegistry, String str, Map<String, Object> map, TransferListener transferListener);
}
