package com.braze.ui.actions;

import android.content.pm.ResolveInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UriAction.kt */
final class UriAction$getActionViewIntent$1 extends Lambda implements Function0<String> {
    final /* synthetic */ ResolveInfo $resolveInfo;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UriAction$getActionViewIntent$1(ResolveInfo resolveInfo) {
        super(0);
        this.$resolveInfo = resolveInfo;
    }

    public final String invoke() {
        return "Setting deep link intent package to " + this.$resolveInfo.activityInfo.packageName + '.';
    }
}
