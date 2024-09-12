package com.braze.ui.inappmessage.utils;

import com.braze.models.inappmessage.IInAppMessageZippedAssetHtml;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackgroundInAppMessagePreparer.kt */
final class BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5 extends Lambda implements Function0<String> {
    final /* synthetic */ IInAppMessageZippedAssetHtml $inAppMessageHtml;
    final /* synthetic */ String $localWebContentUrl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundInAppMessagePreparer$prepareInAppMessageWithZippedAssetHtml$5(IInAppMessageZippedAssetHtml iInAppMessageZippedAssetHtml, String str) {
        super(0);
        this.$inAppMessageHtml = iInAppMessageZippedAssetHtml;
        this.$localWebContentUrl = str;
    }

    public final String invoke() {
        return "Download of html content to local directory failed for remote url: " + this.$inAppMessageHtml.getAssetsZipRemoteUrl() + " . Returned local url is: " + this.$localWebContentUrl;
    }
}
