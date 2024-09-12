package com.braze.ui.inappmessage;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.JsonUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeInAppMessageManager.kt */
final class BrazeInAppMessageManager$displayInAppMessage$15 extends Lambda implements Function0<String> {
    final /* synthetic */ IInAppMessage $inAppMessage;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeInAppMessageManager$displayInAppMessage$15(IInAppMessage iInAppMessage) {
        super(0);
        this.$inAppMessage = iInAppMessage;
    }

    public final String invoke() {
        return "Could not display in-app message with payload: " + JsonUtils.getPrettyPrintedString((JSONObject) this.$inAppMessage.forJsonPut());
    }
}
