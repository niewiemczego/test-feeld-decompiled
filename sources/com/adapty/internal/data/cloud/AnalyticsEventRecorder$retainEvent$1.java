package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventRecorder", f = "AnalyticsEventRecorder.kt", i = {0, 0, 0, 0}, l = {130}, m = "retainEvent", n = {"this", "event", "$this$withPermit$iv", "isSystemLog"}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* compiled from: AnalyticsEventRecorder.kt */
final class AnalyticsEventRecorder$retainEvent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnalyticsEventRecorder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventRecorder$retainEvent$1(AnalyticsEventRecorder analyticsEventRecorder, Continuation<? super AnalyticsEventRecorder$retainEvent$1> continuation) {
        super(continuation);
        this.this$0 = analyticsEventRecorder;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.retainEvent((AnalyticsEvent) null, this);
    }
}
