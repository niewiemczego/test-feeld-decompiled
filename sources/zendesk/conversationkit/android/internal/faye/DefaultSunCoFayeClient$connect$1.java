package zendesk.conversationkit.android.internal.faye;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient$connect$1", f = "SunCoFayeClient.kt", i = {}, l = {99, 101, 105}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SunCoFayeClient.kt */
final class DefaultSunCoFayeClient$connect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultSunCoFayeClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultSunCoFayeClient$connect$1(DefaultSunCoFayeClient defaultSunCoFayeClient, Continuation<? super DefaultSunCoFayeClient$connect$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultSunCoFayeClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultSunCoFayeClient$connect$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultSunCoFayeClient$connect$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0026
            if (r1 == r4) goto L_0x0022
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00a4
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x007d
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r8 = r7.this$0
            zendesk.conversationkit.android.model.RealtimeSettings r8 = r8.realtimeSettings
            java.util.concurrent.TimeUnit r8 = r8.getTimeUnit()
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r1 = r7.this$0
            zendesk.conversationkit.android.model.RealtimeSettings r1 = r1.realtimeSettings
            long r5 = r1.getConnectionDelay()
            long r5 = r8.toMillis(r5)
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r8)
            if (r8 != r0) goto L_0x004d
            return r0
        L_0x004d:
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r8 = r7.this$0
            zendesk.faye.FayeClient r8 = r8.fayeClient
            zendesk.faye.ConnectMessage$Companion r1 = zendesk.faye.ConnectMessage.Companion
            zendesk.faye.ConnectMessage$Builder r1 = r1.builder()
            zendesk.faye.ConnectMessage r1 = r1.build()
            zendesk.faye.BayeuxMessage r1 = (zendesk.faye.BayeuxMessage) r1
            r8.send(r1)
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r8 = r7.this$0
            zendesk.conversationkit.android.internal.ActionDispatcher r8 = r8.actionDispatcher
            zendesk.conversationkit.android.internal.Action$RealtimeConnectionStatusUpdate r1 = new zendesk.conversationkit.android.internal.Action$RealtimeConnectionStatusUpdate
            zendesk.conversationkit.android.ConnectionStatus r4 = zendesk.conversationkit.android.ConnectionStatus.CONNECTING_REALTIME
            r1.<init>(r4)
            zendesk.conversationkit.android.internal.Action r1 = (zendesk.conversationkit.android.internal.Action) r1
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.label = r3
            java.lang.Object r8 = r8.dispatch(r1, r4)
            if (r8 != r0) goto L_0x007d
            return r0
        L_0x007d:
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r8 = r7.this$0
            zendesk.faye.FayeClient r8 = r8.fayeClient
            boolean r8 = r8.isConnected()
            if (r8 == 0) goto L_0x00a4
            zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient r8 = r7.this$0
            zendesk.conversationkit.android.internal.ActionDispatcher r8 = r8.actionDispatcher
            zendesk.conversationkit.android.internal.Action$RealtimeConnectionStatusUpdate r1 = new zendesk.conversationkit.android.internal.Action$RealtimeConnectionStatusUpdate
            zendesk.conversationkit.android.ConnectionStatus r3 = zendesk.conversationkit.android.ConnectionStatus.CONNECTED_REALTIME
            r1.<init>(r3)
            zendesk.conversationkit.android.internal.Action r1 = (zendesk.conversationkit.android.internal.Action) r1
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.label = r2
            java.lang.Object r8 = r8.dispatch(r1, r3)
            if (r8 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.faye.DefaultSunCoFayeClient$connect$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
