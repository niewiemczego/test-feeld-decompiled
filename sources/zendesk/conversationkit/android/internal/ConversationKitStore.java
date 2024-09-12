package zendesk.conversationkit.android.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.noaccess.NoAccessActionProcessor;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.User;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u0001:\u00016B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0015\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\rH\u0000¢\u0006\u0002\b\u001dJ%\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010 2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u0004\u0018\u00010%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\b\u0010'\u001a\u0004\u0018\u00010(J\b\u0010)\u001a\u0004\u0018\u00010*J\b\u0010+\u001a\u0004\u0018\u00010,J\u001b\u0010-\u001a\u00020\u00192\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0000¢\u0006\u0002\b1J\u000e\u00102\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017J\u0016\u00103\u001a\u00020\u00192\f\u0010.\u001a\b\u0012\u0004\u0012\u0002040/H\u0002J\u0012\u00105\u001a\u00020\u0019*\b\u0012\u0004\u0012\u00020\"0/H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"Lzendesk/conversationkit/android/internal/ConversationKitStore;", "Lzendesk/conversationkit/android/internal/ActionDispatcher;", "effectProcessor", "Lzendesk/conversationkit/android/internal/EffectProcessor;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "conversationKitDispatchers", "Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "(Lzendesk/conversationkit/android/internal/EffectProcessor;Lkotlinx/coroutines/CoroutineScope;Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;)V", "_connectionStatusFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lzendesk/conversationkit/android/ConnectionStatus;", "<set-?>", "Lzendesk/conversationkit/android/internal/AccessLevel;", "accessLevel", "getAccessLevel$zendesk_conversationkit_conversationkit_android", "()Lzendesk/conversationkit/android/internal/AccessLevel;", "connectionStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getConnectionStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "listeners", "", "Lzendesk/conversationkit/android/ConversationKitEventListener;", "addEventListener", "", "listener", "changeAccessLevel", "newAccessLevel", "changeAccessLevel$zendesk_conversationkit_conversationkit_android", "dispatch", "Lzendesk/conversationkit/android/ConversationKitResult;", "T", "action", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClientId", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConfig", "Lzendesk/conversationkit/android/model/Config;", "getCurrentUser", "Lzendesk/conversationkit/android/model/User;", "getSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "notifyAllEventListeners", "events", "", "Lzendesk/conversationkit/android/ConversationKitEvent;", "notifyAllEventListeners$zendesk_conversationkit_conversationkit_android", "removeEventListener", "updateConnectionStatus", "Lzendesk/conversationkit/android/ConversationKitEvent$ConnectionStatusChanged;", "launchAll", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitStore.kt */
public final class ConversationKitStore implements ActionDispatcher {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ConversationKitStore";
    private final MutableStateFlow<ConnectionStatus> _connectionStatusFlow;
    private AccessLevel accessLevel;
    private final StateFlow<ConnectionStatus> connectionStatusFlow;
    /* access modifiers changed from: private */
    public final ConversationKitDispatchers conversationKitDispatchers;
    private final CoroutineScope coroutineScope;
    private final EffectProcessor effectProcessor;
    /* access modifiers changed from: private */
    public final Set<ConversationKitEventListener> listeners;

    public ConversationKitStore(EffectProcessor effectProcessor2, CoroutineScope coroutineScope2, ConversationKitDispatchers conversationKitDispatchers2) {
        Intrinsics.checkNotNullParameter(effectProcessor2, "effectProcessor");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(conversationKitDispatchers2, "conversationKitDispatchers");
        this.effectProcessor = effectProcessor2;
        this.coroutineScope = coroutineScope2;
        this.conversationKitDispatchers = conversationKitDispatchers2;
        this.accessLevel = new NoAccess(new NoAccessActionProcessor());
        this.listeners = new HashSet();
        MutableStateFlow<ConnectionStatus> MutableStateFlow = StateFlowKt.MutableStateFlow(ConnectionStatus.DISCONNECTED);
        this._connectionStatusFlow = MutableStateFlow;
        this.connectionStatusFlow = MutableStateFlow;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationKitStore(EffectProcessor effectProcessor2, CoroutineScope coroutineScope2, ConversationKitDispatchers conversationKitDispatchers2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(effectProcessor2, coroutineScope2, (i & 4) != 0 ? new DefaultConversationKitDispatchers() : conversationKitDispatchers2);
    }

    public final AccessLevel getAccessLevel$zendesk_conversationkit_conversationkit_android() {
        return this.accessLevel;
    }

    public final StateFlow<ConnectionStatus> getConnectionStatusFlow() {
        return this.connectionStatusFlow;
    }

    public final void addEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationKitStore$addEventListener$1(this, conversationKitEventListener, (Continuation<? super ConversationKitStore$addEventListener$1>) null), 3, (Object) null);
    }

    public final void removeEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationKitStore$removeEventListener$1(this, conversationKitEventListener, (Continuation<? super ConversationKitStore$removeEventListener$1>) null), 3, (Object) null);
    }

    public final ConversationKitSettings getSettings() {
        return this.accessLevel.getSettings();
    }

    public final Config getConfig() {
        return this.accessLevel.getConfig();
    }

    public final Object getClientId(Continuation<? super String> continuation) {
        return this.accessLevel.getClientId(continuation);
    }

    public final User getCurrentUser() {
        return this.accessLevel.getCurrentUser();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> java.lang.Object dispatch(zendesk.conversationkit.android.internal.Action r10, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<? extends T>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$1 r0 = (zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$1 r0 = new zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0050
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0107
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            java.lang.Object r10 = r0.L$1
            zendesk.conversationkit.android.internal.EffectProcessorResult r10 = (zendesk.conversationkit.android.internal.EffectProcessorResult) r10
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.ConversationKitStore r2 = (zendesk.conversationkit.android.internal.ConversationKitStore) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e9
        L_0x0047:
            java.lang.Object r10 = r0.L$0
            zendesk.conversationkit.android.internal.ConversationKitStore r10 = (zendesk.conversationkit.android.internal.ConversationKitStore) r10
            kotlin.ResultKt.throwOnFailure(r11)
            r2 = r10
            goto L_0x0094
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r11)
            zendesk.conversationkit.android.internal.AccessLevel r11 = r9.accessLevel
            boolean r2 = r11 instanceof zendesk.conversationkit.android.internal.NoAccess
            if (r2 == 0) goto L_0x0062
            zendesk.conversationkit.android.internal.NoAccess r11 = (zendesk.conversationkit.android.internal.NoAccess) r11
            zendesk.conversationkit.android.internal.noaccess.NoAccessActionProcessor r11 = r11.getNoAccessProcessor()
            zendesk.conversationkit.android.internal.ActionProcessor r11 = (zendesk.conversationkit.android.internal.ActionProcessor) r11
            goto L_0x0088
        L_0x0062:
            boolean r2 = r11 instanceof zendesk.conversationkit.android.internal.IntegrationAccess
            if (r2 == 0) goto L_0x006f
            zendesk.conversationkit.android.internal.IntegrationAccess r11 = (zendesk.conversationkit.android.internal.IntegrationAccess) r11
            zendesk.conversationkit.android.internal.integration.IntegrationActionProcessor r11 = r11.getIntegrationProcessor()
            zendesk.conversationkit.android.internal.ActionProcessor r11 = (zendesk.conversationkit.android.internal.ActionProcessor) r11
            goto L_0x0088
        L_0x006f:
            boolean r2 = r11 instanceof zendesk.conversationkit.android.internal.AppAccess
            if (r2 == 0) goto L_0x007c
            zendesk.conversationkit.android.internal.AppAccess r11 = (zendesk.conversationkit.android.internal.AppAccess) r11
            zendesk.conversationkit.android.internal.app.AppActionProcessor r11 = r11.getAppProcessor()
            zendesk.conversationkit.android.internal.ActionProcessor r11 = (zendesk.conversationkit.android.internal.ActionProcessor) r11
            goto L_0x0088
        L_0x007c:
            boolean r2 = r11 instanceof zendesk.conversationkit.android.internal.UserAccess
            if (r2 == 0) goto L_0x0119
            zendesk.conversationkit.android.internal.UserAccess r11 = (zendesk.conversationkit.android.internal.UserAccess) r11
            zendesk.conversationkit.android.internal.user.UserActionProcessor r11 = r11.getUserProcessor()
            zendesk.conversationkit.android.internal.ActionProcessor r11 = (zendesk.conversationkit.android.internal.ActionProcessor) r11
        L_0x0088:
            r0.L$0 = r9
            r0.label = r5
            java.lang.Object r11 = r11.process(r10, r0)
            if (r11 != r1) goto L_0x0093
            return r1
        L_0x0093:
            r2 = r9
        L_0x0094:
            zendesk.conversationkit.android.internal.Effect r11 = (zendesk.conversationkit.android.internal.Effect) r11
            zendesk.conversationkit.android.internal.EffectProcessor r10 = r2.effectProcessor
            zendesk.conversationkit.android.internal.EffectProcessorResult r10 = r10.process(r11)
            zendesk.conversationkit.android.internal.AccessLevel r11 = r10.getNewAccessLevel()
            if (r11 == 0) goto L_0x00a5
            r2.changeAccessLevel$zendesk_conversationkit_conversationkit_android(r11)
        L_0x00a5:
            java.util.List r11 = r10.getEvents()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r11 = r11.iterator()
        L_0x00b6:
            boolean r7 = r11.hasNext()
            if (r7 == 0) goto L_0x00c8
            java.lang.Object r7 = r11.next()
            boolean r8 = r7 instanceof zendesk.conversationkit.android.ConversationKitEvent.ConnectionStatusChanged
            if (r8 == 0) goto L_0x00b6
            r5.add(r7)
            goto L_0x00b6
        L_0x00c8:
            java.util.List r5 = (java.util.List) r5
            r2.updateConnectionStatus(r5)
            zendesk.conversationkit.android.internal.ConversationKitDispatchers r11 = r2.conversationKitDispatchers
            kotlinx.coroutines.CoroutineDispatcher r11 = r11.main()
            kotlin.coroutines.CoroutineContext r11 = (kotlin.coroutines.CoroutineContext) r11
            zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$3 r5 = new zendesk.conversationkit.android.internal.ConversationKitStore$dispatch$3
            r5.<init>(r2, r10, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r0.L$0 = r2
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.BuildersKt.withContext(r11, r5, r0)
            if (r11 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            java.util.List r11 = r10.getSupplementaryActions()
            r2.launchAll(r11)
            boolean r11 = r10 instanceof zendesk.conversationkit.android.internal.EffectProcessorResult.Continues
            if (r11 == 0) goto L_0x0108
            zendesk.conversationkit.android.internal.EffectProcessorResult$Continues r10 = (zendesk.conversationkit.android.internal.EffectProcessorResult.Continues) r10
            zendesk.conversationkit.android.internal.Action r10 = r10.getFollowingAction()
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r11 = r2.dispatch(r10, r0)
            if (r11 != r1) goto L_0x0107
            return r1
        L_0x0107:
            return r11
        L_0x0108:
            boolean r11 = r10 instanceof zendesk.conversationkit.android.internal.EffectProcessorResult.Ends
            if (r11 == 0) goto L_0x0113
            zendesk.conversationkit.android.internal.EffectProcessorResult$Ends r10 = (zendesk.conversationkit.android.internal.EffectProcessorResult.Ends) r10
            zendesk.conversationkit.android.ConversationKitResult r10 = r10.getResult()
            return r10
        L_0x0113:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x0119:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.ConversationKitStore.dispatch(zendesk.conversationkit.android.internal.Action, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateConnectionStatus(List<ConversationKitEvent.ConnectionStatusChanged> list) {
        for (ConversationKitEvent.ConnectionStatusChanged connectionStatus : list) {
            this._connectionStatusFlow.setValue(connectionStatus.getConnectionStatus());
        }
    }

    public final void changeAccessLevel$zendesk_conversationkit_conversationkit_android(AccessLevel accessLevel2) {
        Intrinsics.checkNotNullParameter(accessLevel2, "newAccessLevel");
        Logger.d(LOG_TAG, "Changing access level to " + accessLevel2.getLogName(), new Object[0]);
        this.accessLevel = accessLevel2;
    }

    public final void notifyAllEventListeners$zendesk_conversationkit_conversationkit_android(List<? extends ConversationKitEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        for (ConversationKitEvent conversationKitEvent : list) {
            for (ConversationKitEventListener onEvent : this.listeners) {
                onEvent.onEvent(conversationKitEvent);
            }
        }
    }

    private final void launchAll(List<? extends Action> list) {
        for (Action conversationKitStore$launchAll$1$1 : list) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ConversationKitStore$launchAll$1$1(this, conversationKitStore$launchAll$1$1, (Continuation<? super ConversationKitStore$launchAll$1$1>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/ConversationKitStore$Companion;", "", "()V", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitStore.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
