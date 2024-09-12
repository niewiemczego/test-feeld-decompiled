package com.launchdarkly.sdk;

import com.facebook.hermes.intl.Constants;
import com.facebook.internal.ServerProtocol;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

@JsonAdapter(LDValueTypeAdapter.class)
final class LDValueBool extends LDValue {
    static final LDValueBool FALSE = new LDValueBool(false);
    static final LDValueBool TRUE = new LDValueBool(true);
    private final boolean value;

    static LDValueBool fromBoolean(boolean z) {
        return z ? TRUE : FALSE;
    }

    private LDValueBool(boolean z) {
        this.value = z;
    }

    public LDValueType getType() {
        return LDValueType.BOOLEAN;
    }

    public boolean booleanValue() {
        return this.value;
    }

    public String toJsonString() {
        return this.value ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : Constants.CASEFIRST_FALSE;
    }

    /* access modifiers changed from: package-private */
    public void write(JsonWriter jsonWriter) throws IOException {
        jsonWriter.value(this.value);
    }
}
