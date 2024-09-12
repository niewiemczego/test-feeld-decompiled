package zendesk.conversationkit.android.internal.integration;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.ActionProcessor;
import zendesk.conversationkit.android.internal.ConversationKitDispatchers;
import zendesk.conversationkit.android.internal.DefaultConversationKitDispatchers;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.conversationkit.android.internal.rest.IntegrationRestClient;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/integration/IntegrationActionProcessor;", "Lzendesk/conversationkit/android/internal/ActionProcessor;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "integrationRestClient", "Lzendesk/conversationkit/android/internal/rest/IntegrationRestClient;", "dispatchers", "Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/internal/rest/IntegrationRestClient;Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;)V", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "getConfig", "Lzendesk/conversationkit/android/internal/Effect;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "action", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntegrationActionProcessor.kt */
public final class IntegrationActionProcessor implements ActionProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "IntegrationActionProcessor";
    private final ConversationKitSettings conversationKitSettings;
    private final ConversationKitDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final IntegrationRestClient integrationRestClient;

    public IntegrationActionProcessor(ConversationKitSettings conversationKitSettings2, IntegrationRestClient integrationRestClient2, ConversationKitDispatchers conversationKitDispatchers) {
        Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
        Intrinsics.checkNotNullParameter(integrationRestClient2, "integrationRestClient");
        Intrinsics.checkNotNullParameter(conversationKitDispatchers, "dispatchers");
        this.conversationKitSettings = conversationKitSettings2;
        this.integrationRestClient = integrationRestClient2;
        this.dispatchers = conversationKitDispatchers;
    }

    public final ConversationKitSettings getConversationKitSettings() {
        return this.conversationKitSettings;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IntegrationActionProcessor(ConversationKitSettings conversationKitSettings2, IntegrationRestClient integrationRestClient2, ConversationKitDispatchers conversationKitDispatchers, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(conversationKitSettings2, integrationRestClient2, (i & 4) != 0 ? new DefaultConversationKitDispatchers() : conversationKitDispatchers);
    }

    public Object process(Action action, Continuation<? super Effect> continuation) {
        if (Intrinsics.areEqual((Object) action, (Object) Action.GetConfig.INSTANCE)) {
            return getConfig(continuation);
        }
        if (action instanceof Action.ForwardConfig) {
            return new Effect.ConfigResultReceived(this.conversationKitSettings, new ConversationKitResult.Success(((Action.ForwardConfig) action).getConfig()));
        }
        Logger.w(LOG_TAG, action + " cannot processed.", new Object[0]);
        return Effect.IncorrectAccessLevel.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getConfig(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$1 r0 = (zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$1 r0 = new zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            java.lang.String r4 = "IntegrationActionProcessor"
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r5) goto L_0x0035
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor r0 = (zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            goto L_0x005c
        L_0x0031:
            r8 = move-exception
            goto L_0x006c
        L_0x0033:
            r8 = move-exception
            goto L_0x007d
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.conversationkit.android.internal.ConversationKitDispatchers r8 = r7.dispatchers     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            kotlinx.coroutines.CoroutineDispatcher r8 = r8.io()     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$result$config$1 r2 = new zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor$getConfig$result$config$1     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            r6 = 0
            r2.<init>(r7, r6)     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            r0.L$0 = r7     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            r0.label = r5     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r2, r0)     // Catch:{ JsonDataException -> 0x007b, all -> 0x006a }
            if (r8 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r0 = r7
        L_0x005c:
            zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto r8 = (zendesk.conversationkit.android.internal.rest.model.ConfigResponseDto) r8     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            zendesk.conversationkit.android.model.Config r8 = zendesk.conversationkit.android.model.ConfigKt.toConfig(r8)     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            zendesk.conversationkit.android.ConversationKitResult$Success r1 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            r1.<init>(r8)     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1     // Catch:{ JsonDataException -> 0x0033, all -> 0x0031 }
            goto L_0x008d
        L_0x006a:
            r8 = move-exception
            r0 = r7
        L_0x006c:
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "Failed to get config."
            zendesk.logger.Logger.e(r4, r2, r8, r1)
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r8)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
            goto L_0x008d
        L_0x007b:
            r8 = move-exception
            r0 = r7
        L_0x007d:
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object[] r1 = new java.lang.Object[r3]
            java.lang.String r2 = "GET request for Config failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r4, r2, r8, r1)
            zendesk.conversationkit.android.ConversationKitResult$Failure r1 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r1.<init>(r8)
            zendesk.conversationkit.android.ConversationKitResult r1 = (zendesk.conversationkit.android.ConversationKitResult) r1
        L_0x008d:
            zendesk.conversationkit.android.internal.Effect$ConfigResultReceived r8 = new zendesk.conversationkit.android.internal.Effect$ConfigResultReceived
            zendesk.conversationkit.android.ConversationKitSettings r0 = r0.conversationKitSettings
            r8.<init>(r0, r1)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor.getConfig(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/integration/IntegrationActionProcessor$Companion;", "", "()V", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntegrationActionProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
