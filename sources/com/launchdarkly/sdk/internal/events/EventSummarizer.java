package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class EventSummarizer {
    private EventSummary eventsState = new EventSummary();

    EventSummarizer() {
    }

    /* access modifiers changed from: package-private */
    public void summarizeEvent(long j, String str, int i, int i2, LDValue lDValue, LDValue lDValue2, LDContext lDContext) {
        this.eventsState.incrementCounter(str, i, i2, lDValue, lDValue2, lDContext);
        this.eventsState.noteTimestamp(j);
    }

    /* access modifiers changed from: package-private */
    public EventSummary getSummaryAndReset() {
        EventSummary eventSummary = this.eventsState;
        clear();
        return eventSummary;
    }

    /* access modifiers changed from: package-private */
    public void restoreTo(EventSummary eventSummary) {
        this.eventsState = eventSummary;
    }

    /* access modifiers changed from: package-private */
    public boolean isEmpty() {
        return this.eventsState.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.eventsState = new EventSummary();
    }

    static final class EventSummary {
        final Map<String, FlagInfo> counters;
        long endDate;
        long startDate;

        public int hashCode() {
            return 0;
        }

        EventSummary() {
            this.counters = new HashMap();
        }

        EventSummary(EventSummary eventSummary) {
            this.counters = new HashMap(eventSummary.counters);
            this.startDate = eventSummary.startDate;
            this.endDate = eventSummary.endDate;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.counters.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public void incrementCounter(String str, int i, int i2, LDValue lDValue, LDValue lDValue2, LDContext lDContext) {
            FlagInfo flagInfo = this.counters.get(str);
            if (flagInfo == null) {
                flagInfo = new FlagInfo(lDValue2, new SimpleIntKeyedMap(), new HashSet());
                this.counters.put(str, flagInfo);
            }
            for (int i3 = 0; i3 < lDContext.getIndividualContextCount(); i3++) {
                flagInfo.contextKinds.add(lDContext.getIndividualContext(i3).getKind().toString());
            }
            SimpleIntKeyedMap simpleIntKeyedMap = flagInfo.versionsAndVariations.get(i);
            if (simpleIntKeyedMap == null) {
                simpleIntKeyedMap = new SimpleIntKeyedMap();
                flagInfo.versionsAndVariations.put(i, simpleIntKeyedMap);
            }
            CounterValue counterValue = (CounterValue) simpleIntKeyedMap.get(i2);
            if (counterValue == null) {
                simpleIntKeyedMap.put(i2, new CounterValue(1, lDValue));
            } else {
                counterValue.increment();
            }
        }

        /* access modifiers changed from: package-private */
        public void noteTimestamp(long j) {
            long j2 = this.startDate;
            if (j2 == 0 || j < j2) {
                this.startDate = j;
            }
            if (j > this.endDate) {
                this.endDate = j;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof EventSummary)) {
                return false;
            }
            EventSummary eventSummary = (EventSummary) obj;
            if (eventSummary.counters.equals(this.counters) && this.startDate == eventSummary.startDate && this.endDate == eventSummary.endDate) {
                return true;
            }
            return false;
        }
    }

    static final class FlagInfo {
        final Set<String> contextKinds;
        final LDValue defaultVal;
        final SimpleIntKeyedMap<SimpleIntKeyedMap<CounterValue>> versionsAndVariations;

        FlagInfo(LDValue lDValue, SimpleIntKeyedMap<SimpleIntKeyedMap<CounterValue>> simpleIntKeyedMap, Set<String> set) {
            this.defaultVal = lDValue;
            this.versionsAndVariations = simpleIntKeyedMap;
            this.contextKinds = set;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FlagInfo)) {
                return false;
            }
            FlagInfo flagInfo = (FlagInfo) obj;
            if (!flagInfo.defaultVal.equals(this.defaultVal) || !flagInfo.versionsAndVariations.equals(this.versionsAndVariations) || !flagInfo.contextKinds.equals(this.contextKinds)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.defaultVal.hashCode() + (this.versionsAndVariations.hashCode() * 31);
        }

        public String toString() {
            return "(default=" + this.defaultVal + ", counters=" + this.versionsAndVariations + ", contextKinds=" + String.join(",", this.contextKinds) + ")";
        }
    }

    static final class CounterValue {
        long count;
        final LDValue flagValue;

        CounterValue(long j, LDValue lDValue) {
            this.count = j;
            this.flagValue = lDValue;
        }

        /* access modifiers changed from: package-private */
        public void increment() {
            this.count++;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CounterValue)) {
                return false;
            }
            CounterValue counterValue = (CounterValue) obj;
            if (this.count != counterValue.count || !Objects.equals(this.flagValue, counterValue.flagValue)) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "(" + this.count + "," + this.flagValue + ")";
        }
    }

    static final class SimpleIntKeyedMap<T> {
        private static final int INITIAL_CAPACITY = 4;
        private int[] keys = new int[4];

        /* renamed from: n  reason: collision with root package name */
        private int f26n;
        private Object[] values = new Object[4];

        SimpleIntKeyedMap() {
        }

        /* access modifiers changed from: package-private */
        public int size() {
            return this.f26n;
        }

        /* access modifiers changed from: package-private */
        public int capacity() {
            return this.keys.length;
        }

        /* access modifiers changed from: package-private */
        public int keyAt(int i) {
            return this.keys[i];
        }

        /* access modifiers changed from: package-private */
        public T valueAt(int i) {
            return this.values[i];
        }

        /* access modifiers changed from: package-private */
        public T get(int i) {
            for (int i2 = 0; i2 < this.f26n; i2++) {
                if (this.keys[i2] == i) {
                    return this.values[i2];
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public SimpleIntKeyedMap<T> put(int i, T t) {
            int i2 = 0;
            while (true) {
                int i3 = this.f26n;
                if (i2 >= i3) {
                    int[] iArr = this.keys;
                    if (i3 == iArr.length) {
                        int[] iArr2 = new int[(iArr.length * 2)];
                        System.arraycopy(iArr, 0, iArr2, 0, i3);
                        Object[] objArr = new Object[(this.keys.length * 2)];
                        System.arraycopy(this.values, 0, objArr, 0, this.f26n);
                        this.keys = iArr2;
                        this.values = objArr;
                    }
                    int[] iArr3 = this.keys;
                    int i4 = this.f26n;
                    iArr3[i4] = i;
                    this.values[i4] = t;
                    this.f26n = i4 + 1;
                    return this;
                } else if (this.keys[i2] == i) {
                    this.values[i2] = t;
                    return this;
                } else {
                    i2++;
                }
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof SimpleIntKeyedMap) {
                SimpleIntKeyedMap simpleIntKeyedMap = (SimpleIntKeyedMap) obj;
                if (this.f26n == simpleIntKeyedMap.f26n) {
                    for (int i = 0; i < this.f26n; i++) {
                        if (!Objects.equals(this.values[i], simpleIntKeyedMap.get(this.keys[i]))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            for (int i = 0; i < this.f26n; i++) {
                StringBuilder append = sb.append(this.keys[i]).append("=");
                Object obj = this.values[i];
                append.append(obj == null ? "null" : obj.toString());
            }
            sb.append("}");
            return sb.toString();
        }
    }
}
