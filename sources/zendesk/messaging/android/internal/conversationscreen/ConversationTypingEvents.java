package zendesk.messaging.android.internal.conversationscreen;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationTypingEvents;", "", "processLifecycleObserver", "Lzendesk/core/android/internal/app/ProcessLifecycleObserver;", "conversationScreenViewModel", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "sdkCoroutineScope", "(Lzendesk/core/android/internal/app/ProcessLifecycleObserver;Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineScope;)V", "typingEventJob", "Lkotlinx/coroutines/Job;", "canSendTypingStop", "", "onSendMessage", "", "conversationId", "", "onTyping", "sendTypingStartEvent", "sendTypingStopEvent", "subscribeToLifecycleUpdate", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationTypingEvents.kt */
public final class ConversationTypingEvents {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ConversationTypingEvents";
    public static final long TIME_INTERVAL_IN_MILLIS = 10000;
    /* access modifiers changed from: private */
    public final ConversationScreenViewModel conversationScreenViewModel;
    private final CoroutineScope lifecycleScope;
    /* access modifiers changed from: private */
    public final ProcessLifecycleObserver processLifecycleObserver;
    private final CoroutineScope sdkCoroutineScope;
    private Job typingEventJob;

    public ConversationTypingEvents(ProcessLifecycleObserver processLifecycleObserver2, ConversationScreenViewModel conversationScreenViewModel2, CoroutineScope coroutineScope, CoroutineScope coroutineScope2) {
        Intrinsics.checkNotNullParameter(processLifecycleObserver2, "processLifecycleObserver");
        Intrinsics.checkNotNullParameter(conversationScreenViewModel2, "conversationScreenViewModel");
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(coroutineScope2, "sdkCoroutineScope");
        this.processLifecycleObserver = processLifecycleObserver2;
        this.conversationScreenViewModel = conversationScreenViewModel2;
        this.lifecycleScope = coroutineScope;
        this.sdkCoroutineScope = coroutineScope2;
    }

    public final void subscribeToLifecycleUpdate(String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$subscribeToLifecycleUpdate$1(this, str, (Continuation<? super ConversationTypingEvents$subscribeToLifecycleUpdate$1>) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$subscribeToLifecycleUpdate$2(this, str, (Continuation<? super ConversationTypingEvents$subscribeToLifecycleUpdate$2>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean canSendTypingStop() {
        Job job = this.typingEventJob;
        if (job == null) {
            return false;
        }
        return job != null ? job.isActive() : false;
    }

    public final void onTyping(String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Job job = this.typingEventJob;
        if (job != null) {
            boolean z = false;
            if (job != null && job.isCompleted()) {
                z = true;
            }
            if (!z) {
                Job job2 = this.typingEventJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.typingEventJob = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$onTyping$1(this, str, (Continuation<? super ConversationTypingEvents$onTyping$1>) null), 3, (Object) null);
            }
        }
        sendTypingStartEvent(str);
        this.typingEventJob = BuildersKt__Builders_commonKt.launch$default(this.lifecycleScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$onTyping$1(this, str, (Continuation<? super ConversationTypingEvents$onTyping$1>) null), 3, (Object) null);
    }

    public final void onSendMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        if (canSendTypingStop()) {
            sendTypingStopEvent(str);
        }
    }

    private final void sendTypingStartEvent(String str) {
        Logger.i(LOG_TAG, "Sending typing start event", new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.sdkCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$sendTypingStartEvent$1(this, str, (Continuation<? super ConversationTypingEvents$sendTypingStartEvent$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void sendTypingStopEvent(String str) {
        Logger.i(LOG_TAG, "Sending typing stop event", new Object[0]);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.sdkCoroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationTypingEvents$sendTypingStopEvent$1(this, str, (Continuation<? super ConversationTypingEvents$sendTypingStopEvent$1>) null), 3, (Object) null);
        Job job = this.typingEventJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationTypingEvents$Companion;", "", "()V", "LOG_TAG", "", "TIME_INTERVAL_IN_MILLIS", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationTypingEvents.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
