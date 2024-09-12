package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.ContextKind;
import com.launchdarkly.sdk.android.subsystems.PersistentDataStore;
import java.util.ArrayList;

abstract class Migration {
    static final String CURRENT_SCHEMA_ID = "v4.0.0";
    static final String MIGRATIONS_NAMESPACE = "LaunchDarkly-migrations";
    static final String SHARED_PREFS_BASE_KEY = "LaunchDarkly-";

    private Migration() {
    }

    static void migrateWhenNeeded(PersistentDataStore persistentDataStore, LDLogger lDLogger) {
        if (persistentDataStore.getValue(MIGRATIONS_NAMESPACE, CURRENT_SCHEMA_ID) == null) {
            updateFromPre_v4_0_0(persistentDataStore, lDLogger);
            persistentDataStore.setValue(MIGRATIONS_NAMESPACE, CURRENT_SCHEMA_ID, CURRENT_SCHEMA_ID);
        }
    }

    static void updateFromPre_v4_0_0(PersistentDataStore persistentDataStore, LDLogger lDLogger) {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = null;
        for (String next : persistentDataStore.getAllNamespaces()) {
            if (next.startsWith(SHARED_PREFS_BASE_KEY)) {
                arrayList.add(next);
                if (next.equals("LaunchDarkly-id")) {
                    str = persistentDataStore.getValue(next, "instanceId");
                }
            }
        }
        for (String clear : arrayList) {
            persistentDataStore.clear(clear, true);
        }
        if (str != null) {
            new PersistentDataStoreWrapper(persistentDataStore, lDLogger).setGeneratedContextKey(ContextKind.DEFAULT, str);
        }
        if (arrayList.size() != 0) {
            lDLogger.debug("initialized v4.0.0 store schema and removed earlier SDK data");
        }
    }
}
