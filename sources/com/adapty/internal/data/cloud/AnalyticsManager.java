package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.utils.ErrorCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\\\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0013J<\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00162\"\u0010\r\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000eH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/adapty/internal/data/cloud/AnalyticsManager;", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "eventRecorder", "eventQueueDispatcher", "Lcom/adapty/internal/data/cloud/AnalyticsEventQueueDispatcher;", "(Lcom/adapty/internal/data/cloud/AnalyticsTracker;Lcom/adapty/internal/data/cloud/AnalyticsEventQueueDispatcher;)V", "trackEvent", "", "eventName", "", "subMap", "", "", "onEventRegistered", "Lkotlin/Function2;", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "Lkotlin/coroutines/Continuation;", "completion", "Lcom/adapty/utils/ErrorCallback;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lcom/adapty/utils/ErrorCallback;)V", "trackSystemEvent", "customData", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "(Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;Lkotlin/jvm/functions/Function2;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsManager.kt */
public final class AnalyticsManager implements AnalyticsTracker {
    /* access modifiers changed from: private */
    public final AnalyticsEventQueueDispatcher eventQueueDispatcher;
    private final AnalyticsTracker eventRecorder;

    public AnalyticsManager(AnalyticsTracker analyticsTracker, AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher) {
        Intrinsics.checkNotNullParameter(analyticsTracker, "eventRecorder");
        Intrinsics.checkNotNullParameter(analyticsEventQueueDispatcher, "eventQueueDispatcher");
        this.eventRecorder = analyticsTracker;
        this.eventQueueDispatcher = analyticsEventQueueDispatcher;
    }

    public void trackSystemEvent(AnalyticsEvent.CustomData customData, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(customData, "customData");
        Intrinsics.checkNotNullParameter(function2, "onEventRegistered");
        this.eventRecorder.trackSystemEvent(customData, new AnalyticsManager$trackSystemEvent$1(this, (Continuation<? super AnalyticsManager$trackSystemEvent$1>) null));
    }

    public void trackEvent(String str, Map<String, ? extends Object> map, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2, ErrorCallback errorCallback) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(function2, "onEventRegistered");
        this.eventRecorder.trackEvent(str, map, new AnalyticsManager$trackEvent$1(this, (Continuation<? super AnalyticsManager$trackEvent$1>) null), errorCallback);
    }
}
