package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.ContextKind;
import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.android.ConnectionInformation;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class TestData implements ComponentConfigurer<DataSource> {
    private final Map<String, FlagBuilder> currentBuilders = new HashMap();
    private final Map<String, Integer> currentFlagVersions = new HashMap();
    private final List<DataSourceImpl> instances = new CopyOnWriteArrayList();
    private final Object lock = new Object();

    public static TestData dataSource() {
        return new TestData();
    }

    private TestData() {
    }

    public FlagBuilder flag(String str) {
        FlagBuilder flagBuilder;
        synchronized (this.lock) {
            flagBuilder = this.currentBuilders.get(str);
        }
        if (flagBuilder != null) {
            return new FlagBuilder(flagBuilder);
        }
        return new FlagBuilder(str).booleanFlag();
    }

    public TestData update(FlagBuilder flagBuilder) {
        int intValue;
        String str = flagBuilder.key;
        FlagBuilder flagBuilder2 = new FlagBuilder(flagBuilder);
        synchronized (this.lock) {
            intValue = (this.currentFlagVersions.containsKey(str) ? this.currentFlagVersions.get(str).intValue() : 0) + 1;
            this.currentFlagVersions.put(str, Integer.valueOf(intValue));
            this.currentBuilders.put(str, flagBuilder2);
        }
        for (DataSourceImpl doUpdate : this.instances) {
            doUpdate.doUpdate(flagBuilder2, intValue);
        }
        return this;
    }

    public DataSource build(ClientContext clientContext) {
        DataSourceImpl dataSourceImpl = new DataSourceImpl(clientContext.getEvaluationContext(), clientContext.getDataSourceUpdateSink());
        synchronized (this.lock) {
            this.instances.add(dataSourceImpl);
        }
        return dataSourceImpl;
    }

    /* access modifiers changed from: private */
    public Map<String, DataModel.Flag> makeInitData(LDContext lDContext) {
        HashMap hashMap = new HashMap();
        synchronized (this.lock) {
            for (Map.Entry next : this.currentBuilders.entrySet()) {
                hashMap.put((String) next.getKey(), ((FlagBuilder) next.getValue()).createFlag(this.currentFlagVersions.containsKey(next.getKey()) ? this.currentFlagVersions.get(next.getKey()).intValue() : 1, lDContext));
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void closedInstance(DataSourceImpl dataSourceImpl) {
        synchronized (this.lock) {
            this.instances.remove(dataSourceImpl);
        }
    }

    public static final class FlagBuilder {
        private static final int FALSE_VARIATION_FOR_BOOLEAN = 1;
        private static final int TRUE_VARIATION_FOR_BOOLEAN = 0;
        int defaultVariation;
        final String key;
        Map<ContextKind, Map<String, Integer>> variationByContextKey;
        VariationFunc<Integer> variationFunc;
        CopyOnWriteArrayList<LDValue> variations;

        public interface VariationFunc<T> {
            T apply(LDContext lDContext);
        }

        /* access modifiers changed from: private */
        public static int variationForBoolean(boolean z) {
            return z ^ true ? 1 : 0;
        }

        private FlagBuilder(String str) {
            this.key = str;
            this.variations = new CopyOnWriteArrayList<>();
            this.defaultVariation = 0;
            this.variationByContextKey = new HashMap();
        }

        private FlagBuilder(FlagBuilder flagBuilder) {
            this.key = flagBuilder.key;
            this.variations = new CopyOnWriteArrayList<>(flagBuilder.variations);
            this.defaultVariation = flagBuilder.defaultVariation;
            this.variationByContextKey = new HashMap();
            for (Map.Entry next : flagBuilder.variationByContextKey.entrySet()) {
                this.variationByContextKey.put((ContextKind) next.getKey(), new HashMap((Map) next.getValue()));
            }
            this.variationFunc = flagBuilder.variationFunc;
        }

        private boolean isBooleanFlag() {
            if (this.variations.size() != 2 || !this.variations.get(0).equals(LDValue.of(true)) || !this.variations.get(1).equals(LDValue.of(false))) {
                return false;
            }
            return true;
        }

        public FlagBuilder booleanFlag() {
            if (isBooleanFlag()) {
                return this;
            }
            return variations(LDValue.of(true), LDValue.of(false));
        }

        public FlagBuilder variation(boolean z) {
            return booleanFlag().variation(variationForBoolean(z));
        }

        public FlagBuilder variation(int i) {
            this.defaultVariation = i;
            return this;
        }

        public FlagBuilder variation(LDValue lDValue) {
            this.defaultVariation = findOrAddVariationValue(lDValue);
            this.variationFunc = null;
            return this;
        }

        public FlagBuilder variationForUser(String str, boolean z) {
            return variationForKey(ContextKind.DEFAULT, str, z);
        }

        public FlagBuilder variationForUser(String str, int i) {
            return variationForKey(ContextKind.DEFAULT, str, i);
        }

        public FlagBuilder variationForUser(String str, LDValue lDValue) {
            return variationForUser(str, findOrAddVariationValue(lDValue));
        }

        public FlagBuilder variationForKey(ContextKind contextKind, String str, boolean z) {
            return booleanFlag().variationForKey(contextKind, str, variationForBoolean(z));
        }

        public FlagBuilder variationForKey(ContextKind contextKind, String str, int i) {
            if (contextKind == null) {
                contextKind = ContextKind.DEFAULT;
            }
            Map map = this.variationByContextKey.get(contextKind);
            if (map == null) {
                map = new HashMap();
                this.variationByContextKey.put(contextKind, map);
            }
            map.put(str, Integer.valueOf(i));
            return this;
        }

        public FlagBuilder variationForKey(ContextKind contextKind, String str, LDValue lDValue) {
            return variationForKey(contextKind, str, findOrAddVariationValue(lDValue));
        }

        public FlagBuilder variationFunc(final VariationFunc<Boolean> variationFunc2) {
            return booleanFlag().variationIndexFunc(new VariationFunc<Integer>() {
                public Integer apply(LDContext lDContext) {
                    Boolean bool = (Boolean) variationFunc2.apply(lDContext);
                    if (bool == null) {
                        return null;
                    }
                    return Integer.valueOf(FlagBuilder.variationForBoolean(bool.booleanValue()));
                }
            });
        }

        public FlagBuilder variationValueFunc(final VariationFunc<LDValue> variationFunc2) {
            return variationIndexFunc(new VariationFunc<Integer>() {
                public Integer apply(LDContext lDContext) {
                    LDValue lDValue = (LDValue) variationFunc2.apply(lDContext);
                    if (FlagBuilder.this.variations.contains(lDValue)) {
                        return Integer.valueOf(FlagBuilder.this.variations.indexOf(lDValue));
                    }
                    return null;
                }
            });
        }

        public FlagBuilder variationIndexFunc(VariationFunc<Integer> variationFunc2) {
            this.variationFunc = variationFunc2;
            return this;
        }

        public FlagBuilder variations(LDValue... lDValueArr) {
            this.variations.clear();
            for (LDValue add : lDValueArr) {
                this.variations.add(add);
            }
            return this;
        }

        private int findOrAddVariationValue(LDValue lDValue) {
            if (!this.variations.contains(lDValue)) {
                this.variations.add(lDValue);
            }
            return this.variations.indexOf(lDValue);
        }

        private Integer findVariationInTargets(LDContext lDContext) {
            if (lDContext.isMultiple()) {
                for (int i = 0; i < lDContext.getIndividualContextCount(); i++) {
                    Integer findVariationInTargets = findVariationInTargets(lDContext.getIndividualContext(i));
                    if (findVariationInTargets != null) {
                        return findVariationInTargets;
                    }
                }
                return null;
            }
            Map map = this.variationByContextKey.get(lDContext.getKind());
            if (map == null) {
                return null;
            }
            return (Integer) map.get(lDContext.getKey());
        }

        /* access modifiers changed from: package-private */
        public DataModel.Flag createFlag(int i, LDContext lDContext) {
            LDValue lDValue;
            EvaluationReason evaluationReason;
            VariationFunc<Integer> variationFunc2;
            Integer findVariationInTargets = findVariationInTargets(lDContext);
            if (findVariationInTargets == null && (variationFunc2 = this.variationFunc) != null) {
                findVariationInTargets = variationFunc2.apply(lDContext);
            }
            int intValue = findVariationInTargets == null ? this.defaultVariation : findVariationInTargets.intValue();
            if (intValue < 0 || intValue >= this.variations.size()) {
                lDValue = LDValue.ofNull();
            } else {
                lDValue = this.variations.get(intValue);
            }
            LDValue lDValue2 = lDValue;
            if (findVariationInTargets == null) {
                evaluationReason = EvaluationReason.fallthrough();
            } else {
                evaluationReason = EvaluationReason.targetMatch();
            }
            return new DataModel.Flag(this.key, lDValue2, i, (Integer) null, Integer.valueOf(intValue), false, false, (Long) null, evaluationReason);
        }
    }

    private final class DataSourceImpl implements DataSource {
        final LDContext currentContext;
        final DataSourceUpdateSink updates;

        DataSourceImpl(LDContext lDContext, DataSourceUpdateSink dataSourceUpdateSink) {
            this.currentContext = lDContext;
            this.updates = dataSourceUpdateSink;
        }

        public void start(Callback<Boolean> callback) {
            this.updates.init(TestData.this.makeInitData(this.currentContext));
            this.updates.setStatus(ConnectionInformation.ConnectionMode.STREAMING, (Throwable) null);
            callback.onSuccess(true);
        }

        public void stop(Callback<Void> callback) {
            TestData.this.closedInstance(this);
        }

        /* access modifiers changed from: package-private */
        public void doUpdate(FlagBuilder flagBuilder, int i) {
            this.updates.upsert(flagBuilder.createFlag(i, this.currentContext));
        }
    }
}
