package com.launchdarkly.sdk;

import java.util.HashMap;
import java.util.Map;

public final class ObjectBuilder {
    private volatile Map<String, LDValue> builder = new HashMap();
    private volatile boolean copyOnWrite = false;

    public ObjectBuilder put(String str, LDValue lDValue) {
        if (this.copyOnWrite) {
            this.builder = new HashMap(this.builder);
            this.copyOnWrite = false;
        }
        Map<String, LDValue> map = this.builder;
        if (lDValue == null) {
            lDValue = LDValue.ofNull();
        }
        map.put(str, lDValue);
        return this;
    }

    public ObjectBuilder put(String str, boolean z) {
        return put(str, LDValue.of(z));
    }

    public ObjectBuilder put(String str, int i) {
        return put(str, LDValue.of(i));
    }

    public ObjectBuilder put(String str, long j) {
        return put(str, LDValue.of(j));
    }

    public ObjectBuilder put(String str, float f) {
        return put(str, LDValue.of(f));
    }

    public ObjectBuilder put(String str, double d) {
        return put(str, LDValue.of(d));
    }

    public ObjectBuilder put(String str, String str2) {
        return put(str, LDValue.of(str2));
    }

    public LDValue build() {
        this.copyOnWrite = true;
        return LDValueObject.fromMap(this.builder);
    }
}
