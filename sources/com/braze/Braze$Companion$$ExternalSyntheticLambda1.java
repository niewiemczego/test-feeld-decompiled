package com.braze;

import android.net.Uri;
import com.braze.Braze;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Braze$Companion$$ExternalSyntheticLambda1 implements IBrazeEndpointProvider {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Braze$Companion$$ExternalSyntheticLambda1(String str) {
        this.f$0 = str;
    }

    public final Uri getApiEndpoint(Uri uri) {
        return Braze.Companion.setConfiguredCustomEndpoint$lambda$12$lambda$11(this.f$0, uri);
    }
}
