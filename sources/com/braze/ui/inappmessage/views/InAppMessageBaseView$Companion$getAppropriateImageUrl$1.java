package com.braze.ui.inappmessage.views;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageBaseView.kt */
final class InAppMessageBaseView$Companion$getAppropriateImageUrl$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $localImagePath;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageBaseView$Companion$getAppropriateImageUrl$1(String str) {
        super(0);
        this.$localImagePath = str;
    }

    public final String invoke() {
        return "Local bitmap file does not exist. Using remote url instead. Local path: " + this.$localImagePath;
    }
}
