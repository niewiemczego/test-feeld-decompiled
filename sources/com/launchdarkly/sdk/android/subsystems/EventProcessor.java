package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import java.io.Closeable;

public interface EventProcessor extends Closeable {
    public static final int NO_VERSION = -1;

    void blockingFlush();

    void flush();

    void recordCustomEvent(LDContext lDContext, String str, LDValue lDValue, Double d);

    void recordEvaluationEvent(LDContext lDContext, String str, int i, int i2, LDValue lDValue, EvaluationReason evaluationReason, LDValue lDValue2, boolean z, Long l);

    void recordIdentifyEvent(LDContext lDContext);

    void setInBackground(boolean z);

    void setOffline(boolean z);
}
