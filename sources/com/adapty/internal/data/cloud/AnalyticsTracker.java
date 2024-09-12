package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import com.adapty.utils.ErrorCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001Jb\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH&ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ>\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112$\b\u0002\u0010\b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH&ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "", "trackEvent", "", "eventName", "", "subMap", "", "onEventRegistered", "Lkotlin/Function2;", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "Lkotlin/coroutines/Continuation;", "completion", "Lcom/adapty/utils/ErrorCallback;", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lcom/adapty/utils/ErrorCallback;)V", "trackSystemEvent", "customData", "Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;", "(Lcom/adapty/internal/data/models/AnalyticsEvent$CustomData;Lkotlin/jvm/functions/Function2;)V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsTracker.kt */
public interface AnalyticsTracker {
    void trackEvent(String str, Map<String, ? extends Object> map, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2, ErrorCallback errorCallback);

    void trackSystemEvent(AnalyticsEvent.CustomData customData, Function2<? super AnalyticsEvent, ? super Continuation<? super Unit>, ? extends Object> function2);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsTracker.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void trackSystemEvent$default(AnalyticsTracker analyticsTracker, AnalyticsEvent.CustomData customData, Function2 function2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    function2 = new AnalyticsTracker$trackSystemEvent$1((Continuation<? super AnalyticsTracker$trackSystemEvent$1>) null);
                }
                analyticsTracker.trackSystemEvent(customData, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackSystemEvent");
        }

        public static /* synthetic */ void trackEvent$default(AnalyticsTracker analyticsTracker, String str, Map map, Function2 function2, ErrorCallback errorCallback, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    map = null;
                }
                if ((i & 4) != 0) {
                    function2 = new AnalyticsTracker$trackEvent$1((Continuation<? super AnalyticsTracker$trackEvent$1>) null);
                }
                if ((i & 8) != 0) {
                    errorCallback = null;
                }
                analyticsTracker.trackEvent(str, map, function2, errorCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackEvent");
        }
    }
}
