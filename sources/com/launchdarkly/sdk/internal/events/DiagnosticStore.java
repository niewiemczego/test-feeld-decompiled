package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.LDValueType;
import com.launchdarkly.sdk.ObjectBuilder;
import com.launchdarkly.sdk.internal.events.DiagnosticEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class DiagnosticStore {
    private final long creationDate;
    private volatile long dataSinceDate;
    private final DiagnosticId diagnosticId;
    private final SdkDiagnosticParams diagnosticParams;
    private final AtomicInteger eventsInLastBatch = new AtomicInteger(0);
    private ArrayList<DiagnosticEvent.StreamInit> streamInits = new ArrayList<>();
    private final Object streamInitsLock = new Object();

    public static class SdkDiagnosticParams {
        final List<LDValue> configProperties;
        final Map<String, String> defaultHttpHeaders;
        final LDValue extraPlatformData;
        final String platformName;
        final String sdkKeyOrMobileKey;
        final String sdkName;
        final String sdkVersion;

        public SdkDiagnosticParams(String str, String str2, String str3, String str4, LDValue lDValue, Map<String, String> map, List<LDValue> list) {
            this.sdkKeyOrMobileKey = str;
            this.sdkName = str2;
            this.sdkVersion = str3;
            this.platformName = str4;
            this.extraPlatformData = lDValue;
            this.defaultHttpHeaders = map == null ? Collections.emptyMap() : new HashMap<>(map);
            this.configProperties = list == null ? Collections.emptyList() : new ArrayList<>(list);
        }
    }

    public DiagnosticStore(SdkDiagnosticParams sdkDiagnosticParams) {
        long currentTimeMillis = System.currentTimeMillis();
        this.dataSinceDate = currentTimeMillis;
        this.creationDate = currentTimeMillis;
        this.diagnosticId = new DiagnosticId(sdkDiagnosticParams.sdkKeyOrMobileKey);
        this.diagnosticParams = sdkDiagnosticParams;
    }

    public DiagnosticId getDiagnosticId() {
        return this.diagnosticId;
    }

    public long getDataSinceDate() {
        return this.dataSinceDate;
    }

    public DiagnosticEvent getInitEvent() {
        return DiagnosticEvent.makeInit(this.creationDate, this.diagnosticId, makeInitEventSdkData(), makeInitEventConfigData(), makeInitEventPlatformData());
    }

    private LDValue makeInitEventSdkData() {
        ObjectBuilder put = LDValue.buildObject().put("name", this.diagnosticParams.sdkName).put("version", this.diagnosticParams.sdkVersion);
        for (Map.Entry next : this.diagnosticParams.defaultHttpHeaders.entrySet()) {
            if (((String) next.getKey()).equalsIgnoreCase("x-launchdarkly-wrapper")) {
                if (((String) next.getValue()).contains("/")) {
                    put.put("wrapperName", ((String) next.getValue()).substring(0, ((String) next.getValue()).indexOf("/")));
                    put.put("wrapperVersion", ((String) next.getValue()).substring(((String) next.getValue()).indexOf("/") + 1));
                } else {
                    put.put("wrapperName", (String) next.getValue());
                }
            }
        }
        return put.build();
    }

    private LDValue makeInitEventConfigData() {
        ObjectBuilder buildObject = LDValue.buildObject();
        for (LDValue next : this.diagnosticParams.configProperties) {
            if (next != null && next.getType() == LDValueType.OBJECT) {
                for (String next2 : next.keys()) {
                    DiagnosticConfigProperty[] values = DiagnosticConfigProperty.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        DiagnosticConfigProperty diagnosticConfigProperty = values[i];
                        if (diagnosticConfigProperty.name.equals(next2)) {
                            LDValue lDValue = next.get(next2);
                            if (lDValue.getType() == diagnosticConfigProperty.type) {
                                buildObject.put(next2, lDValue);
                            }
                        } else {
                            i++;
                        }
                    }
                }
            }
        }
        return buildObject.build();
    }

    private LDValue makeInitEventPlatformData() {
        ObjectBuilder put = LDValue.buildObject().put("name", this.diagnosticParams.platformName).put("osArch", System.getProperty("os.arch")).put("osVersion", System.getProperty("os.version"));
        if (this.diagnosticParams.extraPlatformData != null) {
            for (String next : this.diagnosticParams.extraPlatformData.keys()) {
                put.put(next, this.diagnosticParams.extraPlatformData.get(next));
            }
        }
        return put.build();
    }

    public void recordStreamInit(long j, long j2, boolean z) {
        synchronized (this.streamInitsLock) {
            this.streamInits.add(new DiagnosticEvent.StreamInit(j, j2, z));
        }
    }

    public void recordEventsInBatch(int i) {
        this.eventsInLastBatch.set(i);
    }

    public DiagnosticEvent createEventAndReset(long j, long j2) {
        ArrayList<DiagnosticEvent.StreamInit> arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.streamInitsLock) {
            arrayList = this.streamInits;
            this.streamInits = new ArrayList<>();
        }
        long j3 = currentTimeMillis;
        DiagnosticEvent makeStatistics = DiagnosticEvent.makeStatistics(j3, this.diagnosticId, this.dataSinceDate, j, j2, (long) this.eventsInLastBatch.getAndSet(0), arrayList);
        this.dataSinceDate = currentTimeMillis;
        return makeStatistics;
    }
}
