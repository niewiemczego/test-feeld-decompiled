package com.braze;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeActivityLifecycleCallbackListener.kt */
final class BrazeActivityLifecycleCallbackListener$setSessionHandlingBlocklist$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Set<Class<?>> $blocklist;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeActivityLifecycleCallbackListener$setSessionHandlingBlocklist$1(Set<? extends Class<?>> set) {
        super(0);
        this.$blocklist = set;
    }

    public final String invoke() {
        return "setSessionHandlingBlocklist called with blocklist: " + this.$blocklist;
    }
}
