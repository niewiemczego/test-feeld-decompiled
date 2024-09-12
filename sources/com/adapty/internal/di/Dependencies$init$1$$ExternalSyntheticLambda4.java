package com.adapty.internal.di;

import com.adapty.internal.data.cloud.ResponseDataExtractor;
import com.google.gson.JsonElement;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Dependencies$init$1$$ExternalSyntheticLambda4 implements ResponseDataExtractor {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ Dependencies$init$1$$ExternalSyntheticLambda4(String str, String str2, String str3, String str4) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
        this.f$3 = str4;
    }

    public final JsonElement extract(JsonElement jsonElement) {
        return Dependencies$init$1.invoke$lambda$8(this.f$0, this.f$1, this.f$2, this.f$3, jsonElement);
    }
}
