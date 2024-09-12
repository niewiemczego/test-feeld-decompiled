package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueNumber extends LDValue {
    private static final LDValueNumber ZERO = new LDValueNumber(0.0d);
    private final double value;

    public boolean isNumber() {
        return true;
    }

    static LDValueNumber fromDouble(double d) {
        return d == 0.0d ? ZERO : new LDValueNumber(d);
    }

    private LDValueNumber(double d) {
        this.value = d;
    }

    public LDValueType getType() {
        return LDValueType.NUMBER;
    }

    public boolean isInt() {
        return isInteger(this.value);
    }

    public int intValue() {
        return (int) this.value;
    }

    public long longValue() {
        return (long) this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public String toJsonString() {
        return isInt() ? String.valueOf(intValue()) : String.valueOf(this.value);
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        if (isInt()) {
            jsonWriter.value((long) intValue());
        } else {
            jsonWriter.value(this.value);
        }
    }
}
