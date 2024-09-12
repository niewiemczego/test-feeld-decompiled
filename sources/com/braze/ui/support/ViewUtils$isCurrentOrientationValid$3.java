package com.braze.ui.support;

import com.braze.enums.inappmessage.Orientation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
final class ViewUtils$isCurrentOrientationValid$3 extends Lambda implements Function0<String> {
    final /* synthetic */ int $currentScreenOrientation;
    final /* synthetic */ Orientation $preferredOrientation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ViewUtils$isCurrentOrientationValid$3(int i, Orientation orientation) {
        super(0);
        this.$currentScreenOrientation = i;
        this.$preferredOrientation = orientation;
    }

    public final String invoke() {
        return "Current orientation " + this.$currentScreenOrientation + " and preferred orientation " + this.$preferredOrientation + " don't match";
    }
}
