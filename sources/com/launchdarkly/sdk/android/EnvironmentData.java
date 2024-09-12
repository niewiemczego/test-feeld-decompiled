package com.launchdarkly.sdk.android;

import com.google.gson.reflect.TypeToken;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.internal.GsonHelpers;
import com.launchdarkly.sdk.json.SerializationException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

final class EnvironmentData {
    static final Type FLAGS_MAP_TYPE = new TypeToken<Map<String, DataModel.Flag>>() {
    }.getType();
    private final Map<String, DataModel.Flag> flags;

    public EnvironmentData() {
        this(new HashMap());
    }

    private EnvironmentData(Map<String, DataModel.Flag> map) {
        this.flags = map == null ? new HashMap<>() : map;
    }

    public static EnvironmentData copyingFlagsMap(Map<String, DataModel.Flag> map) {
        return new EnvironmentData(map == null ? null : new HashMap(map));
    }

    public static EnvironmentData usingExistingFlagsMap(Map<String, DataModel.Flag> map) {
        return new EnvironmentData(map);
    }

    public DataModel.Flag getFlag(String str) {
        return this.flags.get(str);
    }

    public Map<String, DataModel.Flag> getAll() {
        return new HashMap(this.flags);
    }

    public Collection<DataModel.Flag> values() {
        return this.flags.values();
    }

    public EnvironmentData withFlagUpdatedOrAdded(DataModel.Flag flag) {
        if (flag == null) {
            return this;
        }
        HashMap hashMap = new HashMap(this.flags);
        hashMap.put(flag.getKey(), flag);
        return new EnvironmentData(hashMap);
    }

    public EnvironmentData withFlagRemoved(String str) {
        if (str == null || !this.flags.containsKey(str)) {
            return this;
        }
        HashMap hashMap = new HashMap(this.flags);
        hashMap.remove(str);
        return new EnvironmentData(hashMap);
    }

    public static EnvironmentData fromJson(String str) throws SerializationException {
        try {
            Map map = (Map) GsonHelpers.gsonInstance().fromJson(str, FLAGS_MAP_TYPE);
            for (Map.Entry entry : map.entrySet()) {
                DataModel.Flag flag = (DataModel.Flag) entry.getValue();
                if (flag.getKey() == null) {
                    map.put((String) entry.getKey(), new DataModel.Flag((String) entry.getKey(), flag.getValue(), flag.getVersion(), flag.getFlagVersion(), flag.getVariation(), flag.isTrackEvents(), flag.isTrackReason(), flag.getDebugEventsUntilDate(), flag.getReason()));
                }
            }
            return new EnvironmentData(map);
        } catch (Exception e) {
            throw new SerializationException((Throwable) e);
        }
    }

    public String toJson() {
        return GsonHelpers.gsonInstance().toJson((Object) this.flags);
    }
}
