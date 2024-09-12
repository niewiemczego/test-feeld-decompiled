package io.sentry;

import io.sentry.JsonObjectDeserializer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class JsonObjectDeserializer$$ExternalSyntheticLambda2 implements JsonObjectDeserializer.NextValue {
    public final /* synthetic */ JsonObjectReader f$0;

    public /* synthetic */ JsonObjectDeserializer$$ExternalSyntheticLambda2(JsonObjectReader jsonObjectReader) {
        this.f$0 = jsonObjectReader;
    }

    public final Object nextValue() {
        return Boolean.valueOf(this.f$0.nextBoolean());
    }
}
