package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher", f = "AnalyticsEventQueueDispatcher.kt", i = {0, 0, 0, 0}, l = {146}, m = "removeProcessedEventsOnSuccess", n = {"this", "processedEvents", "$this$withPermit$iv", "isSystemLog"}, s = {"L$0", "L$1", "L$2", "Z$0"})
/* compiled from: AnalyticsEventQueueDispatcher.kt */
final class AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnalyticsEventQueueDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1(AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher, Continuation<? super AnalyticsEventQueueDispatcher$removeProcessedEventsOnSuccess$1> continuation) {
        super(continuation);
        this.this$0 = analyticsEventQueueDispatcher;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.removeProcessedEventsOnSuccess((List<AnalyticsEvent>) null, false, this);
    }
}
