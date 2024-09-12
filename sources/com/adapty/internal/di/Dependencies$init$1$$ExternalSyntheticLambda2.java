package com.adapty.internal.di;

import com.adapty.internal.data.cloud.ResponseDataExtractor;
import com.google.gson.JsonElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dependencies$init$1$$ExternalSyntheticLambda2 implements ResponseDataExtractor {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Dependencies$init$1$$ExternalSyntheticLambda2(String str) {
        this.f$0 = str;
    }

    public final JsonElement extract(JsonElement jsonElement) {
        return Dependencies$init$1.invoke$lambda$2(this.f$0, jsonElement);
    }
}
