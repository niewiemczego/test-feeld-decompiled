package expo.modules.core.logging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u0007J\u0006\u0010\r\u001a\u00020\u0006R\u001e\u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\u00070\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000e"}, d2 = {"Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueue;", "", "()V", "channel", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function0;", "", "Lexpo/modules/core/logging/PersistentFileLogSerialDispatchQueueBlock;", "queueRunner", "Lkotlinx/coroutines/Job;", "getQueueRunner$annotations", "add", "block", "stop", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PersistentFileLogSerialDispatchQueue.kt */
public final class PersistentFileLogSerialDispatchQueue {
    /* access modifiers changed from: private */
    public final Channel<Function0<Unit>> channel = ChannelKt.Channel$default(-2, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    private final Job queueRunner = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new PersistentFileLogSerialDispatchQueue$queueRunner$1(this, (Continuation<? super PersistentFileLogSerialDispatchQueue$queueRunner$1>) null), 3, (Object) null);

    private static /* synthetic */ void getQueueRunner$annotations() {
    }

    public final void add(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new PersistentFileLogSerialDispatchQueue$add$1(this, function0, (Continuation<? super PersistentFileLogSerialDispatchQueue$add$1>) null), 1, (Object) null);
    }

    public final void stop() {
        Job.DefaultImpls.cancel$default(this.queueRunner, (CancellationException) null, 1, (Object) null);
    }
}
