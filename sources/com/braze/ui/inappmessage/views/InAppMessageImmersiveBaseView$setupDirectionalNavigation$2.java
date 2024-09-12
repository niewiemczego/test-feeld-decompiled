package com.braze.ui.inappmessage.views;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageImmersiveBaseView.kt */
final class InAppMessageImmersiveBaseView$setupDirectionalNavigation$2 extends Lambda implements Function0<String> {
    final /* synthetic */ int $numButtons;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageImmersiveBaseView$setupDirectionalNavigation$2(int i) {
        super(0);
        this.$numButtons = i;
    }

    public final String invoke() {
        return "Cannot setup directional navigation. Got unsupported number of buttons: " + this.$numButtons;
    }
}
