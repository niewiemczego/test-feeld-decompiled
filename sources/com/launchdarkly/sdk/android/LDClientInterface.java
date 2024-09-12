package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.EvaluationDetail;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.LDValue;
import java.io.Closeable;
import java.util.Map;
import java.util.concurrent.Future;

public interface LDClientInterface extends Closeable {
    Map<String, LDValue> allFlags();

    boolean boolVariation(String str, boolean z);

    EvaluationDetail<Boolean> boolVariationDetail(String str, boolean z);

    double doubleVariation(String str, double d);

    EvaluationDetail<Double> doubleVariationDetail(String str, double d);

    void flush();

    ConnectionInformation getConnectionInformation();

    String getVersion();

    Future<Void> identify(LDContext lDContext);

    Future<Void> identify(LDUser lDUser);

    int intVariation(String str, int i);

    EvaluationDetail<Integer> intVariationDetail(String str, int i);

    boolean isDisableBackgroundPolling();

    boolean isInitialized();

    boolean isOffline();

    LDValue jsonValueVariation(String str, LDValue lDValue);

    EvaluationDetail<LDValue> jsonValueVariationDetail(String str, LDValue lDValue);

    void registerAllFlagsListener(LDAllFlagsListener lDAllFlagsListener);

    void registerFeatureFlagListener(String str, FeatureFlagChangeListener featureFlagChangeListener);

    void registerStatusListener(LDStatusListener lDStatusListener);

    void setOffline();

    void setOnline();

    String stringVariation(String str, String str2);

    EvaluationDetail<String> stringVariationDetail(String str, String str2);

    void track(String str);

    void trackData(String str, LDValue lDValue);

    void trackMetric(String str, LDValue lDValue, double d);

    void unregisterAllFlagsListener(LDAllFlagsListener lDAllFlagsListener);

    void unregisterFeatureFlagListener(String str, FeatureFlagChangeListener featureFlagChangeListener);

    void unregisterStatusListener(LDStatusListener lDStatusListener);
}
