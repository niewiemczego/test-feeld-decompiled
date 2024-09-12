package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.sdk.android.ConnectionInformation;
import com.launchdarkly.sdk.android.DataModel;
import java.util.Map;

public interface DataSourceUpdateSink {
    void init(Map<String, DataModel.Flag> map);

    void setStatus(ConnectionInformation.ConnectionMode connectionMode, Throwable th);

    void shutDown();

    void upsert(DataModel.Flag flag);
}
