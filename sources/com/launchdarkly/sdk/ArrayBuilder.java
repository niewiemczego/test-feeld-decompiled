package com.launchdarkly.sdk;

import java.util.ArrayList;
import java.util.List;

public final class ArrayBuilder {
    private List<LDValue> builder = new ArrayList();
    private volatile boolean copyOnWrite = false;

    public ArrayBuilder add(LDValue lDValue) {
        if (this.copyOnWrite) {
            this.builder = new ArrayList(this.builder);
            this.copyOnWrite = false;
        }
        List<LDValue> list = this.builder;
        if (lDValue == null) {
            lDValue = LDValue.ofNull();
        }
        list.add(lDValue);
        return this;
    }

    public ArrayBuilder add(boolean z) {
        return add(LDValue.of(z));
    }

    public ArrayBuilder add(int i) {
        return add(LDValue.of(i));
    }

    public ArrayBuilder add(long j) {
        return add(LDValue.of(j));
    }

    public ArrayBuilder add(float f) {
        return add(LDValue.of(f));
    }

    public ArrayBuilder add(double d) {
        return add(LDValue.of(d));
    }

    public ArrayBuilder add(String str) {
        return add(LDValue.of(str));
    }

    public LDValue build() {
        this.copyOnWrite = true;
        return LDValueArray.fromList(this.builder);
    }
}
