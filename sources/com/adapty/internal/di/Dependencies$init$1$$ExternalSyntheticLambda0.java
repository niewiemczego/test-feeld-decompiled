package com.adapty.internal.di;

import com.adapty.internal.data.cloud.ResponseDataExtractor;
import com.google.gson.JsonElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dependencies$init$1$$ExternalSyntheticLambda0 implements ResponseDataExtractor {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ Dependencies$init$1$$ExternalSyntheticLambda0(String str, String str2) {
        this.f$0 = str;
        this.f$1 = str2;
    }

    public final JsonElement extract(JsonElement jsonElement) {
        return Dependencies$init$1.invoke$lambda$0(this.f$0, this.f$1, jsonElement);
    }
}
