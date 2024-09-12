package zendesk.android.events.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.events.ZendeskEventListener;

@Singleton
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lzendesk/android/events/internal/ZendeskEventDispatcher;", "", "mainDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "listeners", "", "Lzendesk/android/events/ZendeskEventListener;", "addEventListener", "", "listener", "(Lzendesk/android/events/ZendeskEventListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyEventListeners", "event", "Lzendesk/android/events/ZendeskEvent;", "(Lzendesk/android/events/ZendeskEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeEventListener", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskEventDispatcher.kt */
public final class ZendeskEventDispatcher {
    /* access modifiers changed from: private */
    public final Set<ZendeskEventListener> listeners = new LinkedHashSet();
    private final CoroutineDispatcher mainDispatcher;

    @Inject
    public ZendeskEventDispatcher(@Named("MAIN_DISPATCHER") CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "mainDispatcher");
        this.mainDispatcher = coroutineDispatcher;
    }

    public final Object addEventListener(ZendeskEventListener zendeskEventListener, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.mainDispatcher, new ZendeskEventDispatcher$addEventListener$2(this, zendeskEventListener, (Continuation<? super ZendeskEventDispatcher$addEventListener$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object removeEventListener(ZendeskEventListener zendeskEventListener, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.mainDispatcher, new ZendeskEventDispatcher$removeEventListener$2(this, zendeskEventListener, (Continuation<? super ZendeskEventDispatcher$removeEventListener$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Object notifyEventListeners(ZendeskEvent zendeskEvent, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.mainDispatcher, new ZendeskEventDispatcher$notifyEventListeners$2(this, zendeskEvent, (Continuation<? super ZendeskEventDispatcher$notifyEventListeners$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
