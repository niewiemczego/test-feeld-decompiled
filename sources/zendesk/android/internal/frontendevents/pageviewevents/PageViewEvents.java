package zendesk.android.internal.frontendevents.pageviewevents;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import zendesk.android.ZendeskResult;
import zendesk.android.pageviewevents.PageView;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lzendesk/android/internal/frontendevents/pageviewevents/PageViewEvents;", "", "sendPageViewEvent", "Lzendesk/android/ZendeskResult;", "", "", "pageView", "Lzendesk/android/pageviewevents/PageView;", "(Lzendesk/android/pageviewevents/PageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PageViewEvents.kt */
public interface PageViewEvents {
    Object sendPageViewEvent(PageView pageView, Continuation<? super ZendeskResult<Unit, ? extends Throwable>> continuation);
}
