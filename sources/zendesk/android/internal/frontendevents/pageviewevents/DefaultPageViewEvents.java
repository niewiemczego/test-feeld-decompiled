package zendesk.android.internal.frontendevents.pageviewevents;

import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.android.ZendeskResult;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.frontendevents.FrontendEventsRepository;
import zendesk.android.internal.proactivemessaging.ProactiveMessagingManager;
import zendesk.android.pageviewevents.PageView;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lzendesk/android/internal/frontendevents/pageviewevents/DefaultPageViewEvents;", "Lzendesk/android/internal/frontendevents/pageviewevents/PageViewEvents;", "frontendEventsRepository", "Lzendesk/android/internal/frontendevents/FrontendEventsRepository;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "proactiveMessagingManager", "Lzendesk/android/internal/proactivemessaging/ProactiveMessagingManager;", "(Lzendesk/android/internal/frontendevents/FrontendEventsRepository;Lkotlinx/coroutines/CoroutineDispatcher;Lzendesk/android/internal/proactivemessaging/ProactiveMessagingManager;)V", "sendPageViewEvent", "Lzendesk/android/ZendeskResult;", "", "", "pageView", "Lzendesk/android/pageviewevents/PageView;", "(Lzendesk/android/pageviewevents/PageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: DefaultPageViewEvents.kt */
public final class DefaultPageViewEvents implements PageViewEvents {
    /* access modifiers changed from: private */
    public final FrontendEventsRepository frontendEventsRepository;
    private final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    public final ProactiveMessagingManager proactiveMessagingManager;

    @Inject
    public DefaultPageViewEvents(FrontendEventsRepository frontendEventsRepository2, @Named("IO_DISPATCHER") CoroutineDispatcher coroutineDispatcher, ProactiveMessagingManager proactiveMessagingManager2) {
        Intrinsics.checkNotNullParameter(frontendEventsRepository2, "frontendEventsRepository");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(proactiveMessagingManager2, "proactiveMessagingManager");
        this.frontendEventsRepository = frontendEventsRepository2;
        this.ioDispatcher = coroutineDispatcher;
        this.proactiveMessagingManager = proactiveMessagingManager2;
    }

    public Object sendPageViewEvent(PageView pageView, Continuation<? super ZendeskResult<Unit, ? extends Throwable>> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new DefaultPageViewEvents$sendPageViewEvent$2(this, pageView, (Continuation<? super DefaultPageViewEvents$sendPageViewEvent$2>) null), continuation);
    }
}
