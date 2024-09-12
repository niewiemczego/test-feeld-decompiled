package expo.modules.adapters.react.views;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.ViewManager;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import java.util.Map;
import javax.annotation.Nullable;

public class SimpleViewManagerAdapter<M extends ViewManager<V>, V extends View> extends SimpleViewManager<V> implements RegistryLifecycleListener {
    private M mViewManager;

    public SimpleViewManagerAdapter(M m) {
        this.mViewManager = m;
    }

    /* access modifiers changed from: protected */
    public V createViewInstance(ThemedReactContext themedReactContext) {
        return this.mViewManager.createViewInstance(themedReactContext);
    }

    public void onDropViewInstance(V v) {
        this.mViewManager.onDropViewInstance(v);
        super.onDropViewInstance(v);
    }

    @Nullable
    public Map<String, Object> getConstants() {
        return ViewManagerAdapterUtils.getConstants(this.mViewManager);
    }

    public String getName() {
        return ViewManagerAdapterUtils.getViewManagerAdapterName(this.mViewManager);
    }

    @ReactProp(name = "proxiedProperties")
    public void setProxiedProperties(V v, ReadableMap readableMap) {
        ViewManagerAdapterUtils.setProxiedProperties(getName(), this.mViewManager, v, readableMap);
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return ViewManagerAdapterUtils.getExportedCustomDirectEventTypeConstants(this.mViewManager);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mViewManager.onCreate(moduleRegistry);
    }
}
