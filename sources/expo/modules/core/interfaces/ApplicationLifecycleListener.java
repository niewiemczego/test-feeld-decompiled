package expo.modules.core.interfaces;

import android.app.Application;
import android.content.res.Configuration;

public interface ApplicationLifecycleListener {
    void onConfigurationChanged(Configuration configuration) {
    }

    void onCreate(Application application) {
    }
}
