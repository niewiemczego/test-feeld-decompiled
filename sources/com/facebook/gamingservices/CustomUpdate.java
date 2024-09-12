package com.facebook.gamingservices;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.gamingservices.model.CustomUpdateContent;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, d2 = {"Lcom/facebook/gamingservices/CustomUpdate;", "", "()V", "newCustomUpdateRequest", "Lcom/facebook/GraphRequest;", "content", "Lcom/facebook/gamingservices/model/CustomUpdateContent;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomUpdate.kt */
public final class CustomUpdate {
    public static final CustomUpdate INSTANCE = new CustomUpdate();

    private CustomUpdate() {
    }

    @JvmStatic
    public static final GraphRequest newCustomUpdateRequest(CustomUpdateContent customUpdateContent, GraphRequest.Callback callback) {
        Intrinsics.checkNotNullParameter(customUpdateContent, "content");
        return GraphRequest.Companion.newPostRequest(AccessToken.Companion.getCurrentAccessToken(), "me/custom_update", customUpdateContent.toGraphRequestContent(), callback);
    }
}
