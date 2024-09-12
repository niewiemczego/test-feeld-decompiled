package com.facebook.appevents;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/facebook/appevents/FlushStatistics;", "", "()V", "numEvents", "", "getNumEvents", "()I", "setNumEvents", "(I)V", "result", "Lcom/facebook/appevents/FlushResult;", "getResult", "()Lcom/facebook/appevents/FlushResult;", "setResult", "(Lcom/facebook/appevents/FlushResult;)V", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FlushStatistics.kt */
public final class FlushStatistics {
    private int numEvents;
    private FlushResult result = FlushResult.SUCCESS;

    public final int getNumEvents() {
        return this.numEvents;
    }

    public final void setNumEvents(int i) {
        this.numEvents = i;
    }

    public final FlushResult getResult() {
        return this.result;
    }

    public final void setResult(FlushResult flushResult) {
        Intrinsics.checkNotNullParameter(flushResult, "<set-?>");
        this.result = flushResult;
    }
}
