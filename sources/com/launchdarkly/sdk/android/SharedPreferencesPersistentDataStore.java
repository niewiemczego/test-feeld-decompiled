package com.launchdarkly.sdk.android;

import android.app.Application;
import android.content.SharedPreferences;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.android.subsystems.PersistentDataStore;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

final class SharedPreferencesPersistentDataStore implements PersistentDataStore {
    private final Application application;
    private final LDLogger logger;

    public SharedPreferencesPersistentDataStore(Application application2, LDLogger lDLogger) {
        this.application = application2;
        this.logger = lDLogger;
    }

    public SharedPreferencesPersistentDataStore(Application application2) {
        this(application2, LDLogger.none());
    }

    public String getValue(String str, String str2) {
        SharedPreferences sharedPreferences = getSharedPreferences(str);
        try {
            return sharedPreferences.getString(str2, (String) null);
        } catch (ClassCastException unused) {
            try {
                Long valueOf = Long.valueOf(sharedPreferences.getLong(str2, 0));
                if (valueOf == null) {
                    return null;
                }
                return String.valueOf(valueOf);
            } catch (ClassCastException unused2) {
                return null;
            }
        }
    }

    public void setValue(String str, String str2, String str3) {
        SharedPreferences.Editor edit = getSharedPreferences(str).edit();
        if (str3 == null) {
            edit.remove(str2);
        } else {
            edit.putString(str2, str3);
        }
        edit.apply();
    }

    public void setValues(String str, Map<String, String> map) {
        SharedPreferences.Editor edit = getSharedPreferences(str).edit();
        for (Map.Entry next : map.entrySet()) {
            edit.putString((String) next.getKey(), (String) next.getValue());
        }
        edit.apply();
    }

    public Collection<String> getKeys(String str) {
        return getSharedPreferences(str).getAll().keySet();
    }

    public Collection<String> getAllNamespaces() {
        File[] listFiles = new File(this.application.getFilesDir().getParent() + "/shared_prefs/").listFiles();
        ArrayList arrayList = new ArrayList();
        if (listFiles == null) {
            return arrayList;
        }
        for (File file : listFiles) {
            if (file.isFile() && file.getName().endsWith(".xml")) {
                arrayList.add(file.getName().substring(0, file.getName().length() - 4));
            }
        }
        return arrayList;
    }

    public void clear(String str, boolean z) {
        getSharedPreferences(str).edit().clear().apply();
        if (z) {
            new File(this.application.getFilesDir().getParent() + "/shared_prefs/" + str + ".xml").delete();
        }
    }

    private SharedPreferences getSharedPreferences(String str) {
        return this.application.getSharedPreferences(str, 0);
    }
}
