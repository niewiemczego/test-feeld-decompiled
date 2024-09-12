package zendesk.conversationkit.android;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.ConnectivityObserver;
import zendesk.conversationkit.android.internal.ConversationKitStore;
import zendesk.conversationkit.android.internal.Environment;
import zendesk.conversationkit.android.model.ActivityData;
import zendesk.conversationkit.android.model.Config;
import zendesk.conversationkit.android.model.Conversation;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.conversationkit.android.model.User;
import zendesk.conversationkit.android.model.VisitType;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"H\u0016J\u0013\u0010#\u001a\u0004\u0018\u00010$H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010(\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010)J\n\u0010*\u001a\u0004\u0018\u00010\u001fH\u0016J-\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0\u001b2\u0006\u0010(\u001a\u00020$2\u0006\u0010.\u001a\u00020/H@ø\u0001\u0000¢\u0006\u0002\u00100J\u001f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u00102\u001a\u000203H@ø\u0001\u0000¢\u0006\u0002\u00104J\n\u00105\u001a\u0004\u0018\u000106H\u0016J\u0017\u00107\u001a\b\u0012\u0004\u0012\u0002080\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001b2\u0006\u0010:\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0011\u0010<\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u0010\u0010=\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0011\u0010>\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ!\u0010?\u001a\u00020\u00132\u0006\u0010@\u001a\u00020A2\u0006\u0010(\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010BJ'\u0010C\u001a\b\u0012\u0004\u0012\u00020-0\u001b2\u0006\u0010D\u001a\u00020-2\u0006\u0010(\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010EJ\u0019\u0010F\u001a\u00020\u00132\u0006\u0010G\u001a\u000208H@ø\u0001\u0000¢\u0006\u0002\u0010HJ+\u0010I\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0006\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010&H@ø\u0001\u0000¢\u0006\u0004\bL\u0010MJ\u0019\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010)R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lzendesk/conversationkit/android/DefaultConversationKit;", "Lzendesk/conversationkit/android/ConversationKit;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectionStatusFlow", "Lkotlinx/coroutines/flow/StateFlow;", "Lzendesk/conversationkit/android/ConnectionStatus;", "getConnectionStatusFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "connectivityObserver", "Lzendesk/conversationkit/android/internal/ConnectivityObserver;", "conversationKitStore", "Lzendesk/conversationkit/android/internal/ConversationKitStore;", "environment", "Lzendesk/conversationkit/android/internal/Environment;", "userCreationMutex", "Lkotlinx/coroutines/sync/Mutex;", "addEventListener", "", "listener", "Lzendesk/conversationkit/android/ConversationKitEventListener;", "addProactiveMessage", "proactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "(Lzendesk/conversationkit/android/model/ProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createConversation", "Lzendesk/conversationkit/android/ConversationKitResult;", "Lzendesk/conversationkit/android/model/Conversation;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "Lzendesk/conversationkit/android/model/User;", "dispatchEvent", "event", "Lzendesk/conversationkit/android/ConversationKitEvent;", "getClientId", "", "getConfig", "Lzendesk/conversationkit/android/model/Config;", "getConversation", "conversationId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "getMessages", "", "Lzendesk/conversationkit/android/model/Message;", "beforeTimestamp", "", "(Ljava/lang/String;DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "proactiveMessageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "getVisitType", "Lzendesk/conversationkit/android/model/VisitType;", "loginUser", "jwt", "logoutUser", "pause", "removeEventListener", "resume", "sendActivityData", "activityData", "Lzendesk/conversationkit/android/model/ActivityData;", "(Lzendesk/conversationkit/android/model/ActivityData;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "message", "(Lzendesk/conversationkit/android/model/Message;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setVisitType", "visitType", "(Lzendesk/conversationkit/android/model/VisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setup", "conversationKitSettings", "config", "setup$zendesk_conversationkit_conversationkit_android", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePushNotificationToken", "pushNotificationToken", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKit.kt */
public final class DefaultConversationKit implements ConversationKit {
    private final StateFlow<ConnectionStatus> connectionStatusFlow;
    private final ConnectivityObserver connectivityObserver;
    private final ConversationKitStore conversationKitStore;
    private final Environment environment;
    private final Mutex userCreationMutex = MutexKt.Mutex$default(false, 1, (Object) null);

    public DefaultConversationKit(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Environment main = Environment.Companion.main(context);
        this.environment = main;
        ConversationKitStore conversationKitStore2 = main.conversationKitStore();
        this.conversationKitStore = conversationKitStore2;
        this.connectivityObserver = main.createConnectivityObserver();
        this.connectionStatusFlow = conversationKitStore2.getConnectionStatusFlow();
    }

    public StateFlow<ConnectionStatus> getConnectionStatusFlow() {
        return this.connectionStatusFlow;
    }

    public void addEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.conversationKitStore.addEventListener(conversationKitEventListener);
    }

    public void removeEventListener(ConversationKitEventListener conversationKitEventListener) {
        Intrinsics.checkNotNullParameter(conversationKitEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.conversationKitStore.removeEventListener(conversationKitEventListener);
    }

    public void dispatchEvent(ConversationKitEvent conversationKitEvent) {
        Intrinsics.checkNotNullParameter(conversationKitEvent, "event");
        this.conversationKitStore.notifyAllEventListeners$zendesk_conversationkit_conversationkit_android(CollectionsKt.listOf(conversationKitEvent));
    }

    public final Object setup$zendesk_conversationkit_conversationkit_android(ConversationKitSettings conversationKitSettings, Config config, Continuation<? super ConversationKitResult<Config>> continuation) {
        Action action;
        this.connectivityObserver.startObserving(this.conversationKitStore);
        if (config != null) {
            action = new Action.SetupWithConfig(conversationKitSettings, config);
        } else {
            action = new Action.Setup(conversationKitSettings);
        }
        return this.conversationKitStore.dispatch(action, continuation);
    }

    public Object pause(Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(Action.PauseRealtimeConnection.INSTANCE, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Object resume(Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(Action.StartRealtimeConnection.INSTANCE, continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public ConversationKitSettings getSettings() {
        return this.conversationKitStore.getSettings();
    }

    public Config getConfig() {
        return this.conversationKitStore.getConfig();
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object createUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<zendesk.conversationkit.android.model.User>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.DefaultConversationKit$createUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.DefaultConversationKit$createUser$1 r0 = (zendesk.conversationkit.android.DefaultConversationKit$createUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.DefaultConversationKit$createUser$1 r0 = new zendesk.conversationkit.android.DefaultConversationKit$createUser$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0032 }
            goto L_0x0072
        L_0x0032:
            r8 = move-exception
            goto L_0x007c
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            zendesk.conversationkit.android.DefaultConversationKit r4 = (zendesk.conversationkit.android.DefaultConversationKit) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005c
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.userCreationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r4 = r7
        L_0x005c:
            zendesk.conversationkit.android.internal.ConversationKitStore r2 = r4.conversationKitStore     // Catch:{ all -> 0x0078 }
            zendesk.conversationkit.android.internal.Action$CreateUser r4 = zendesk.conversationkit.android.internal.Action.CreateUser.INSTANCE     // Catch:{ all -> 0x0078 }
            zendesk.conversationkit.android.internal.Action r4 = (zendesk.conversationkit.android.internal.Action) r4     // Catch:{ all -> 0x0078 }
            r0.L$0 = r8     // Catch:{ all -> 0x0078 }
            r0.L$1 = r5     // Catch:{ all -> 0x0078 }
            r0.label = r3     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r2.dispatch(r4, r0)     // Catch:{ all -> 0x0078 }
            if (r0 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0072:
            zendesk.conversationkit.android.ConversationKitResult r8 = (zendesk.conversationkit.android.ConversationKitResult) r8     // Catch:{ all -> 0x0032 }
            r0.unlock(r5)
            return r8
        L_0x0078:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x007c:
            r0.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.DefaultConversationKit.createUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object loginUser(java.lang.String r8, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<zendesk.conversationkit.android.model.User>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof zendesk.conversationkit.android.DefaultConversationKit$loginUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.conversationkit.android.DefaultConversationKit$loginUser$1 r0 = (zendesk.conversationkit.android.DefaultConversationKit$loginUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.DefaultConversationKit$loginUser$1 r0 = new zendesk.conversationkit.android.DefaultConversationKit$loginUser$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0032 }
            goto L_0x007e
        L_0x0032:
            r9 = move-exception
            goto L_0x0088
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            java.lang.Object r8 = r0.L$2
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$0
            zendesk.conversationkit.android.DefaultConversationKit r4 = (zendesk.conversationkit.android.DefaultConversationKit) r4
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r2
            goto L_0x0063
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.userCreationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.label = r4
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r4 = r7
        L_0x0063:
            zendesk.conversationkit.android.internal.ConversationKitStore r2 = r4.conversationKitStore     // Catch:{ all -> 0x0084 }
            zendesk.conversationkit.android.internal.Action$LoginUser r4 = new zendesk.conversationkit.android.internal.Action$LoginUser     // Catch:{ all -> 0x0084 }
            r4.<init>(r8)     // Catch:{ all -> 0x0084 }
            zendesk.conversationkit.android.internal.Action r4 = (zendesk.conversationkit.android.internal.Action) r4     // Catch:{ all -> 0x0084 }
            r0.L$0 = r9     // Catch:{ all -> 0x0084 }
            r0.L$1 = r5     // Catch:{ all -> 0x0084 }
            r0.L$2 = r5     // Catch:{ all -> 0x0084 }
            r0.label = r3     // Catch:{ all -> 0x0084 }
            java.lang.Object r8 = r2.dispatch(r4, r0)     // Catch:{ all -> 0x0084 }
            if (r8 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x007e:
            zendesk.conversationkit.android.ConversationKitResult r9 = (zendesk.conversationkit.android.ConversationKitResult) r9     // Catch:{ all -> 0x0032 }
            r8.unlock(r5)
            return r9
        L_0x0084:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0088:
            r8.unlock(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.DefaultConversationKit.loginUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public User getCurrentUser() {
        return this.conversationKitStore.getCurrentUser();
    }

    public Object getClientId(Continuation<? super String> continuation) {
        return this.conversationKitStore.getAccessLevel$zendesk_conversationkit_conversationkit_android().getClientId(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object logoutUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.ConversationKitResult<kotlin.Unit>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof zendesk.conversationkit.android.DefaultConversationKit$logoutUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.conversationkit.android.DefaultConversationKit$logoutUser$1 r0 = (zendesk.conversationkit.android.DefaultConversationKit$logoutUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.DefaultConversationKit$logoutUser$1 r0 = new zendesk.conversationkit.android.DefaultConversationKit$logoutUser$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0032 }
            goto L_0x0072
        L_0x0032:
            r8 = move-exception
            goto L_0x007c
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.L$0
            zendesk.conversationkit.android.DefaultConversationKit r4 = (zendesk.conversationkit.android.DefaultConversationKit) r4
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L_0x005c
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.userCreationMutex
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r4 = r7
        L_0x005c:
            zendesk.conversationkit.android.internal.ConversationKitStore r2 = r4.conversationKitStore     // Catch:{ all -> 0x0078 }
            zendesk.conversationkit.android.internal.Action$LogoutUser r4 = zendesk.conversationkit.android.internal.Action.LogoutUser.INSTANCE     // Catch:{ all -> 0x0078 }
            zendesk.conversationkit.android.internal.Action r4 = (zendesk.conversationkit.android.internal.Action) r4     // Catch:{ all -> 0x0078 }
            r0.L$0 = r8     // Catch:{ all -> 0x0078 }
            r0.L$1 = r5     // Catch:{ all -> 0x0078 }
            r0.label = r3     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = r2.dispatch(r4, r0)     // Catch:{ all -> 0x0078 }
            if (r0 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x0072:
            zendesk.conversationkit.android.ConversationKitResult r8 = (zendesk.conversationkit.android.ConversationKitResult) r8     // Catch:{ all -> 0x0032 }
            r0.unlock(r5)
            return r8
        L_0x0078:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L_0x007c:
            r0.unlock(r5)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.DefaultConversationKit.logoutUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object createConversation(Continuation<? super ConversationKitResult<Conversation>> continuation) {
        return this.conversationKitStore.dispatch(Action.CreateConversation.INSTANCE, continuation);
    }

    public Object getConversation(String str, Continuation<? super ConversationKitResult<Conversation>> continuation) {
        return this.conversationKitStore.dispatch(new Action.GetConversation(str), continuation);
    }

    public Object sendMessage(Message message, String str, Continuation<? super ConversationKitResult<Message>> continuation) {
        return this.conversationKitStore.dispatch(new Action.PrepareMessage(message, str), continuation);
    }

    public Object getMessages(String str, double d, Continuation<? super ConversationKitResult<? extends List<Message>>> continuation) {
        return this.conversationKitStore.dispatch(new Action.LoadMoreMessages(str, d), continuation);
    }

    public Object updatePushNotificationToken(String str, Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(new Action.PreparePushToken(str), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Object sendActivityData(ActivityData activityData, String str, Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(new Action.SendActivityData(activityData, str), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Object getVisitType(Continuation<? super ConversationKitResult<? extends VisitType>> continuation) {
        return this.conversationKitStore.dispatch(Action.GetVisitType.INSTANCE, continuation);
    }

    public Object setVisitType(VisitType visitType, Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(new Action.SetVisitType(visitType), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Object addProactiveMessage(ProactiveMessage proactiveMessage, Continuation<? super Unit> continuation) {
        Object dispatch = this.conversationKitStore.dispatch(new Action.AddProactiveMessage(proactiveMessage), continuation);
        return dispatch == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? dispatch : Unit.INSTANCE;
    }

    public Object getProactiveMessage(int i, Continuation<? super ConversationKitResult<ProactiveMessage>> continuation) {
        return this.conversationKitStore.dispatch(new Action.GetProactiveMessage(i), continuation);
    }
}
