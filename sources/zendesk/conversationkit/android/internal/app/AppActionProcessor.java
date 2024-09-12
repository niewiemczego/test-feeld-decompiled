package zendesk.conversationkit.android.internal.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.ConversationKitSettings;
import zendesk.conversationkit.android.internal.Action;
import zendesk.conversationkit.android.internal.ActionProcessor;
import zendesk.conversationkit.android.internal.ClientDtoProvider;
import zendesk.conversationkit.android.internal.ConversationKitDispatchers;
import zendesk.conversationkit.android.internal.ConversationKitStorage;
import zendesk.conversationkit.android.internal.Effect;
import zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage;
import zendesk.conversationkit.android.internal.rest.AppRestClient;
import zendesk.conversationkit.android.internal.user.Jwt;
import zendesk.conversationkit.android.model.Config;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 42\u00020\u0001:\u00014BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0011\u0010\u001c\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020%H@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010+\u001a\u00020,2\u0006\u0010\u001e\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0010\u0010/\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u000200H\u0002J\u0019\u00101\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u000202H@ø\u0001\u0000¢\u0006\u0002\u00103R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lzendesk/conversationkit/android/internal/app/AppActionProcessor;", "Lzendesk/conversationkit/android/internal/ActionProcessor;", "conversationKitSettings", "Lzendesk/conversationkit/android/ConversationKitSettings;", "config", "Lzendesk/conversationkit/android/model/Config;", "appRestClient", "Lzendesk/conversationkit/android/internal/rest/AppRestClient;", "clientDtoProvider", "Lzendesk/conversationkit/android/internal/ClientDtoProvider;", "appStorage", "Lzendesk/conversationkit/android/internal/app/AppStorage;", "conversationKitStorage", "Lzendesk/conversationkit/android/internal/ConversationKitStorage;", "proactiveMessagingStorage", "Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;", "jwtDecoder", "Lzendesk/conversationkit/android/internal/user/Jwt$Decoder;", "dispatchers", "Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;", "(Lzendesk/conversationkit/android/ConversationKitSettings;Lzendesk/conversationkit/android/model/Config;Lzendesk/conversationkit/android/internal/rest/AppRestClient;Lzendesk/conversationkit/android/internal/ClientDtoProvider;Lzendesk/conversationkit/android/internal/app/AppStorage;Lzendesk/conversationkit/android/internal/ConversationKitStorage;Lzendesk/conversationkit/android/internal/proactivemessaging/ProactiveMessagingStorage;Lzendesk/conversationkit/android/internal/user/Jwt$Decoder;Lzendesk/conversationkit/android/internal/ConversationKitDispatchers;)V", "getConfig", "()Lzendesk/conversationkit/android/model/Config;", "getConversationKitSettings", "()Lzendesk/conversationkit/android/ConversationKitSettings;", "checkForPersistedUser", "Lzendesk/conversationkit/android/internal/Effect;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createUser", "preparePushToken", "action", "Lzendesk/conversationkit/android/internal/Action$PreparePushToken;", "(Lzendesk/conversationkit/android/internal/Action$PreparePushToken;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "Lzendesk/conversationkit/android/internal/Action;", "(Lzendesk/conversationkit/android/internal/Action;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processAddProactiveMessage", "Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;", "(Lzendesk/conversationkit/android/internal/Action$AddProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processGetProactiveMessage", "Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;", "(Lzendesk/conversationkit/android/internal/Action$GetProactiveMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processGetVisitTypeReceived", "processLoginUser", "Lzendesk/conversationkit/android/internal/Effect$LoginUserResult;", "Lzendesk/conversationkit/android/internal/Action$LoginUser;", "(Lzendesk/conversationkit/android/internal/Action$LoginUser;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNetworkConnectionStatusUpdate", "Lzendesk/conversationkit/android/internal/Action$NetworkConnectionStatusUpdate;", "processSetVisitTypeReceived", "Lzendesk/conversationkit/android/internal/Action$SetVisitType;", "(Lzendesk/conversationkit/android/internal/Action$SetVisitType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AppActionProcessor.kt */
public final class AppActionProcessor implements ActionProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "AppActionProcessor";
    /* access modifiers changed from: private */
    public final AppRestClient appRestClient;
    private final AppStorage appStorage;
    private final ClientDtoProvider clientDtoProvider;
    private final Config config;
    private final ConversationKitSettings conversationKitSettings;
    private final ConversationKitStorage conversationKitStorage;
    private final ConversationKitDispatchers dispatchers;
    private final Jwt.Decoder jwtDecoder;
    private final ProactiveMessagingStorage proactiveMessagingStorage;

    public AppActionProcessor(ConversationKitSettings conversationKitSettings2, Config config2, AppRestClient appRestClient2, ClientDtoProvider clientDtoProvider2, AppStorage appStorage2, ConversationKitStorage conversationKitStorage2, ProactiveMessagingStorage proactiveMessagingStorage2, Jwt.Decoder decoder, ConversationKitDispatchers conversationKitDispatchers) {
        Intrinsics.checkNotNullParameter(conversationKitSettings2, "conversationKitSettings");
        Intrinsics.checkNotNullParameter(config2, "config");
        Intrinsics.checkNotNullParameter(appRestClient2, "appRestClient");
        Intrinsics.checkNotNullParameter(clientDtoProvider2, "clientDtoProvider");
        Intrinsics.checkNotNullParameter(appStorage2, "appStorage");
        Intrinsics.checkNotNullParameter(conversationKitStorage2, "conversationKitStorage");
        Intrinsics.checkNotNullParameter(proactiveMessagingStorage2, "proactiveMessagingStorage");
        Intrinsics.checkNotNullParameter(decoder, "jwtDecoder");
        Intrinsics.checkNotNullParameter(conversationKitDispatchers, "dispatchers");
        this.conversationKitSettings = conversationKitSettings2;
        this.config = config2;
        this.appRestClient = appRestClient2;
        this.clientDtoProvider = clientDtoProvider2;
        this.appStorage = appStorage2;
        this.conversationKitStorage = conversationKitStorage2;
        this.proactiveMessagingStorage = proactiveMessagingStorage2;
        this.jwtDecoder = decoder;
        this.dispatchers = conversationKitDispatchers;
    }

    public final ConversationKitSettings getConversationKitSettings() {
        return this.conversationKitSettings;
    }

    public final Config getConfig() {
        return this.config;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppActionProcessor(zendesk.conversationkit.android.ConversationKitSettings r15, zendesk.conversationkit.android.model.Config r16, zendesk.conversationkit.android.internal.rest.AppRestClient r17, zendesk.conversationkit.android.internal.ClientDtoProvider r18, zendesk.conversationkit.android.internal.app.AppStorage r19, zendesk.conversationkit.android.internal.ConversationKitStorage r20, zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r21, zendesk.conversationkit.android.internal.user.Jwt.Decoder r22, zendesk.conversationkit.android.internal.ConversationKitDispatchers r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r14 = this;
            r0 = r24
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x000f
            zendesk.conversationkit.android.internal.user.Jwt$Decoder r1 = new zendesk.conversationkit.android.internal.user.Jwt$Decoder
            r2 = 1
            r3 = 0
            r1.<init>(r3, r2, r3)
            r12 = r1
            goto L_0x0011
        L_0x000f:
            r12 = r22
        L_0x0011:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x001e
            zendesk.conversationkit.android.internal.DefaultConversationKitDispatchers r0 = new zendesk.conversationkit.android.internal.DefaultConversationKitDispatchers
            r0.<init>()
            zendesk.conversationkit.android.internal.ConversationKitDispatchers r0 = (zendesk.conversationkit.android.internal.ConversationKitDispatchers) r0
            r13 = r0
            goto L_0x0020
        L_0x001e:
            r13 = r23
        L_0x0020:
            r4 = r14
            r5 = r15
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.<init>(zendesk.conversationkit.android.ConversationKitSettings, zendesk.conversationkit.android.model.Config, zendesk.conversationkit.android.internal.rest.AppRestClient, zendesk.conversationkit.android.internal.ClientDtoProvider, zendesk.conversationkit.android.internal.app.AppStorage, zendesk.conversationkit.android.internal.ConversationKitStorage, zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage, zendesk.conversationkit.android.internal.user.Jwt$Decoder, zendesk.conversationkit.android.internal.ConversationKitDispatchers, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public Object process(Action action, Continuation<? super Effect> continuation) {
        if (action instanceof Action.NetworkConnectionStatusUpdate) {
            return processNetworkConnectionStatusUpdate((Action.NetworkConnectionStatusUpdate) action);
        }
        if (Intrinsics.areEqual((Object) action, (Object) Action.CreateUser.INSTANCE)) {
            return createUser(continuation);
        }
        if (action instanceof Action.LoginUser) {
            Object processLoginUser = processLoginUser((Action.LoginUser) action, continuation);
            return processLoginUser == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? processLoginUser : (Effect) processLoginUser;
        } else if (Intrinsics.areEqual((Object) action, (Object) Action.CheckForPersistedUser.INSTANCE)) {
            return checkForPersistedUser(continuation);
        } else {
            if (action instanceof Action.PreparePushToken) {
                return preparePushToken((Action.PreparePushToken) action, continuation);
            }
            if (action instanceof Action.GetVisitType) {
                return processGetVisitTypeReceived(continuation);
            }
            if (action instanceof Action.SetVisitType) {
                return processSetVisitTypeReceived((Action.SetVisitType) action, continuation);
            }
            if (action instanceof Action.AddProactiveMessage) {
                return processAddProactiveMessage((Action.AddProactiveMessage) action, continuation);
            }
            if (action instanceof Action.GetProactiveMessage) {
                return processGetProactiveMessage((Action.GetProactiveMessage) action, continuation);
            }
            Logger.w(LOG_TAG, action + " cannot processed.", new Object[0]);
            return Effect.IncorrectAccessLevel.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processSetVisitTypeReceived(zendesk.conversationkit.android.internal.Action.SetVisitType r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$processSetVisitTypeReceived$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processSetVisitTypeReceived$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$processSetVisitTypeReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processSetVisitTypeReceived$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$processSetVisitTypeReceived$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r4.conversationKitStorage
            zendesk.conversationkit.android.model.VisitType r5 = r5.getVisitType()
            r0.label = r3
            java.lang.Object r5 = r6.setVisitType(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.internal.Effect$None r5 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.processSetVisitTypeReceived(zendesk.conversationkit.android.internal.Action$SetVisitType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processGetVisitTypeReceived(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetVisitTypeReceived$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetVisitTypeReceived$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetVisitTypeReceived$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetVisitTypeReceived$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetVisitTypeReceived$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            zendesk.conversationkit.android.internal.ConversationKitStorage r5 = r4.conversationKitStorage
            r0.label = r3
            java.lang.Object r5 = r5.getVisitType(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.model.VisitType r5 = (zendesk.conversationkit.android.model.VisitType) r5
            zendesk.conversationkit.android.internal.Effect$GetVisitType r0 = new zendesk.conversationkit.android.internal.Effect$GetVisitType
            r0.<init>(r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.processGetVisitTypeReceived(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Effect processNetworkConnectionStatusUpdate(Action.NetworkConnectionStatusUpdate networkConnectionStatusUpdate) {
        return new Effect.NetworkConnectionChanged(networkConnectionStatusUpdate.getConnectionStatus());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x012c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x014e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0199 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r27) {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$1 r2 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$1 r2 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            java.lang.String r6 = "AppActionProcessor"
            r7 = 5
            r8 = 4
            r9 = 3
            r10 = 1
            r11 = 2
            r12 = 0
            if (r4 == 0) goto L_0x00b4
            if (r4 == r10) goto L_0x009e
            if (r4 == r11) goto L_0x008a
            if (r4 == r9) goto L_0x0075
            if (r4 == r8) goto L_0x005e
            if (r4 != r7) goto L_0x0056
            java.lang.Object r3 = r2.L$3
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
            java.lang.Object r5 = r2.L$1
            zendesk.conversationkit.android.model.Config r5 = (zendesk.conversationkit.android.model.Config) r5
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.ConversationKitSettings r2 = (zendesk.conversationkit.android.ConversationKitSettings) r2
            kotlin.ResultKt.throwOnFailure(r0)
            r6 = r3
            r3 = r2
        L_0x004f:
            r25 = r5
            r5 = r4
            r4 = r25
            goto L_0x019e
        L_0x0056:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x005e:
            java.lang.Object r4 = r2.L$2
            zendesk.conversationkit.android.model.User r4 = (zendesk.conversationkit.android.model.User) r4
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.rest.model.ClientDto r8 = (zendesk.conversationkit.android.internal.rest.model.ClientDto) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r9 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0072, all -> 0x006f }
            goto L_0x0151
        L_0x006f:
            r0 = move-exception
            goto L_0x015d
        L_0x0072:
            r0 = move-exception
            goto L_0x016f
        L_0x0075:
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.internal.rest.model.ClientDto r4 = (zendesk.conversationkit.android.internal.rest.model.ClientDto) r4
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r9 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            goto L_0x012e
        L_0x0082:
            r0 = move-exception
            r8 = r4
            goto L_0x015d
        L_0x0086:
            r0 = move-exception
            r8 = r4
            goto L_0x016f
        L_0x008a:
            java.lang.Object r4 = r2.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r10 = r2.L$2
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r13 = r2.L$1
            zendesk.conversationkit.android.internal.ClientDtoProvider r13 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r13
            java.lang.Object r14 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r14 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r14
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00ef
        L_0x009e:
            java.lang.Object r4 = r2.L$2
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r10 = r2.L$1
            zendesk.conversationkit.android.internal.ClientDtoProvider r10 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r10
            java.lang.Object r13 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r13 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r13
            kotlin.ResultKt.throwOnFailure(r0)
            r25 = r10
            r10 = r4
            r4 = r13
            r13 = r25
            goto L_0x00d4
        L_0x00b4:
            kotlin.ResultKt.throwOnFailure(r0)
            zendesk.conversationkit.android.internal.ClientDtoProvider r0 = r1.clientDtoProvider
            zendesk.conversationkit.android.ConversationKitSettings r4 = r1.conversationKitSettings
            java.lang.String r4 = r4.getIntegrationId()
            zendesk.conversationkit.android.internal.ConversationKitStorage r13 = r1.conversationKitStorage
            r2.L$0 = r1
            r2.L$1 = r0
            r2.L$2 = r4
            r2.label = r10
            java.lang.Object r10 = r13.getClientId(r2)
            if (r10 != r3) goto L_0x00d0
            return r3
        L_0x00d0:
            r13 = r0
            r0 = r10
            r10 = r4
            r4 = r1
        L_0x00d4:
            java.lang.String r0 = (java.lang.String) r0
            zendesk.conversationkit.android.internal.ConversationKitStorage r14 = r4.conversationKitStorage
            r2.L$0 = r4
            r2.L$1 = r13
            r2.L$2 = r10
            r2.L$3 = r0
            r2.label = r11
            java.lang.Object r14 = r14.getPushToken(r2)
            if (r14 != r3) goto L_0x00e9
            return r3
        L_0x00e9:
            r25 = r4
            r4 = r0
            r0 = r14
            r14 = r25
        L_0x00ef:
            java.lang.String r0 = (java.lang.String) r0
            zendesk.conversationkit.android.internal.rest.model.ClientDto r4 = r13.buildClient(r10, r4, r0)
            zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto r0 = new zendesk.conversationkit.android.internal.rest.model.AppUserRequestDto
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 126(0x7e, float:1.77E-43)
            r24 = 0
            r15 = r0
            r16 = r4
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24)
            zendesk.conversationkit.android.internal.ConversationKitDispatchers r10 = r14.dispatchers     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            kotlinx.coroutines.CoroutineDispatcher r10 = r10.io()     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$result$user$1 r13 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$createUser$result$user$1     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r13.<init>(r14, r4, r0, r12)     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r2.L$0 = r14     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r2.L$2 = r12     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r2.L$3 = r12     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            r2.label = r9     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r10, r13, r2)     // Catch:{ JsonDataException -> 0x016c, all -> 0x015a }
            if (r0 != r3) goto L_0x012d
            return r3
        L_0x012d:
            r9 = r14
        L_0x012e:
            zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto r0 = (zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r0     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            zendesk.conversationkit.android.model.Config r10 = r9.config     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            zendesk.conversationkit.android.model.App r10 = r10.getApp()     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            java.lang.String r10 = r10.getId()     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            zendesk.conversationkit.android.model.User r0 = zendesk.conversationkit.android.model.UserKt.toUser$default(r0, r10, r12, r11, r12)     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            zendesk.conversationkit.android.internal.app.AppStorage r10 = r9.appStorage     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            r2.L$0 = r9     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            r2.L$1 = r4     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            r2.L$2 = r0     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            r2.label = r8     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            java.lang.Object r8 = r10.setUser(r0, r2)     // Catch:{ JsonDataException -> 0x0086, all -> 0x0082 }
            if (r8 != r3) goto L_0x014f
            return r3
        L_0x014f:
            r8 = r4
            r4 = r0
        L_0x0151:
            zendesk.conversationkit.android.ConversationKitResult$Success r0 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ JsonDataException -> 0x0072, all -> 0x006f }
            r0.<init>(r4)     // Catch:{ JsonDataException -> 0x0072, all -> 0x006f }
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0     // Catch:{ JsonDataException -> 0x0072, all -> 0x006f }
            r4 = r0
            goto L_0x017f
        L_0x015a:
            r0 = move-exception
            r8 = r4
            r9 = r14
        L_0x015d:
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = "Failed to create appUser."
            zendesk.logger.Logger.e(r6, r5, r0, r4)
            zendesk.conversationkit.android.ConversationKitResult$Failure r4 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r4.<init>(r0)
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
            goto L_0x017f
        L_0x016c:
            r0 = move-exception
            r8 = r4
            r9 = r14
        L_0x016f:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.String r5 = "POST request for App User Creation failed to decode malformed JSON response."
            zendesk.logger.Logger.e(r6, r5, r0, r4)
            zendesk.conversationkit.android.ConversationKitResult$Failure r4 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r4.<init>(r0)
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
        L_0x017f:
            zendesk.conversationkit.android.ConversationKitSettings r0 = r9.conversationKitSettings
            zendesk.conversationkit.android.model.Config r5 = r9.config
            java.lang.String r6 = r8.getId()
            zendesk.conversationkit.android.internal.ConversationKitStorage r8 = r9.conversationKitStorage
            r2.L$0 = r0
            r2.L$1 = r5
            r2.L$2 = r4
            r2.L$3 = r6
            r2.label = r7
            java.lang.Object r2 = r8.getPushToken(r2)
            if (r2 != r3) goto L_0x019a
            return r3
        L_0x019a:
            r3 = r0
            r0 = r2
            goto L_0x004f
        L_0x019e:
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            zendesk.conversationkit.android.internal.Effect$CreateUserResult r0 = new zendesk.conversationkit.android.internal.Effect$CreateUserResult
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.createUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: zendesk.conversationkit.android.internal.app.AppActionProcessor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: zendesk.conversationkit.android.internal.app.AppActionProcessor} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r0 = (java.lang.String) r0;
        r9 = r8.conversationKitStorage;
        r2.L$0 = r8;
        r2.L$1 = r7;
        r2.L$2 = r4;
        r2.L$3 = r6;
        r2.L$4 = r0;
        r2.label = 2;
        r9 = r9.getPushToken(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ee, code lost:
        if (r9 != r3) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f0, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f1, code lost:
        r17 = r4;
        r4 = r0;
        r0 = r9;
        r9 = r8;
        r8 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r12 = r8.buildClient(r6, r4, (java.lang.String) r0);
        r4 = r9.appRestClient;
        r6 = r7.getJwt();
        r10 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody(((zendesk.conversationkit.android.internal.user.Jwt) zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r9.jwtDecoder.decode(r7.getJwt()))).getExternalId(), r12, (java.lang.String) null, (java.lang.String) null, 12, (kotlin.jvm.internal.DefaultConstructorMarker) null);
        r2.L$0 = r9;
        r2.L$1 = r7;
        r2.L$2 = null;
        r2.L$3 = null;
        r2.L$4 = null;
        r2.label = 3;
        r0 = r4.loginAppUser(r6, r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0135, code lost:
        if (r0 != r3) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0137, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0138, code lost:
        r4 = r7;
        r8 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r4 = zendesk.conversationkit.android.model.UserKt.toUser((zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r0, r8.config.getApp().getId(), new zendesk.conversationkit.android.model.AuthenticationType.Jwt(r4.getJwt()));
        r0 = r8.appStorage;
        r2.L$0 = r8;
        r2.L$1 = r4;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0162, code lost:
        if (r0.setUser(r4, r2) != r3) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0164, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0165, code lost:
        r7 = r8.conversationKitSettings;
        r6 = r8.config;
        r4 = new zendesk.conversationkit.android.ConversationKitResult.Success(r4);
        r0 = r8.conversationKitStorage;
        r2.L$0 = r8;
        r2.L$1 = r7;
        r2.L$2 = r6;
        r2.L$3 = r4;
        r2.label = 5;
        r0 = r0.getClientId(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0182, code lost:
        if (r0 != r3) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0184, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x018c, code lost:
        return new zendesk.conversationkit.android.internal.Effect.LoginUserResult(r7, r6, r4, (java.lang.String) r0);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01bc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processLoginUser(zendesk.conversationkit.android.internal.Action.LoginUser r19, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect.LoginUserResult> r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$processLoginUser$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processLoginUser$1 r2 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$processLoginUser$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processLoginUser$1 r2 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$processLoginUser$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 0
            switch(r4) {
                case 0: goto L_0x00b1;
                case 1: goto L_0x0095;
                case 2: goto L_0x0073;
                case 3: goto L_0x0065;
                case 4: goto L_0x0057;
                case 5: goto L_0x0042;
                case 6: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0031:
            java.lang.Object r3 = r2.L$2
            zendesk.conversationkit.android.ConversationKitResult r3 = (zendesk.conversationkit.android.ConversationKitResult) r3
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.model.Config r4 = (zendesk.conversationkit.android.model.Config) r4
            java.lang.Object r2 = r2.L$0
            zendesk.conversationkit.android.ConversationKitSettings r2 = (zendesk.conversationkit.android.ConversationKitSettings) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x01c1
        L_0x0042:
            java.lang.Object r4 = r2.L$3
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4
            java.lang.Object r6 = r2.L$2
            zendesk.conversationkit.android.model.Config r6 = (zendesk.conversationkit.android.model.Config) r6
            java.lang.Object r7 = r2.L$1
            zendesk.conversationkit.android.ConversationKitSettings r7 = (zendesk.conversationkit.android.ConversationKitSettings) r7
            java.lang.Object r8 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r8 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0185
        L_0x0057:
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.model.User r4 = (zendesk.conversationkit.android.model.User) r4
            java.lang.Object r6 = r2.L$0
            r8 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor r8 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00ae }
            goto L_0x0165
        L_0x0065:
            java.lang.Object r4 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r4 = (zendesk.conversationkit.android.internal.Action.LoginUser) r4
            java.lang.Object r6 = r2.L$0
            r8 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor r8 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00ae }
            goto L_0x013a
        L_0x0073:
            java.lang.Object r4 = r2.L$4
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r2.L$2
            zendesk.conversationkit.android.internal.ClientDtoProvider r7 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r7
            java.lang.Object r8 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r8 = (zendesk.conversationkit.android.internal.Action.LoginUser) r8
            java.lang.Object r9 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r9 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0091 }
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x00f8
        L_0x0091:
            r0 = move-exception
            r8 = r9
            goto L_0x018f
        L_0x0095:
            java.lang.Object r4 = r2.L$3
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r6 = r2.L$2
            zendesk.conversationkit.android.internal.ClientDtoProvider r6 = (zendesk.conversationkit.android.internal.ClientDtoProvider) r6
            java.lang.Object r7 = r2.L$1
            zendesk.conversationkit.android.internal.Action$LoginUser r7 = (zendesk.conversationkit.android.internal.Action.LoginUser) r7
            java.lang.Object r8 = r2.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r8 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x00ae }
            r17 = r6
            r6 = r4
            r4 = r17
            goto L_0x00d9
        L_0x00ae:
            r0 = move-exception
            goto L_0x018f
        L_0x00b1:
            kotlin.ResultKt.throwOnFailure(r0)
            zendesk.conversationkit.android.internal.ClientDtoProvider r0 = r1.clientDtoProvider     // Catch:{ Exception -> 0x018d }
            zendesk.conversationkit.android.ConversationKitSettings r4 = r1.conversationKitSettings     // Catch:{ Exception -> 0x018d }
            java.lang.String r4 = r4.getIntegrationId()     // Catch:{ Exception -> 0x018d }
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r1.conversationKitStorage     // Catch:{ Exception -> 0x018d }
            r2.L$0 = r1     // Catch:{ Exception -> 0x018d }
            r7 = r19
            r2.L$1 = r7     // Catch:{ Exception -> 0x018d }
            r2.L$2 = r0     // Catch:{ Exception -> 0x018d }
            r2.L$3 = r4     // Catch:{ Exception -> 0x018d }
            r8 = 1
            r2.label = r8     // Catch:{ Exception -> 0x018d }
            java.lang.Object r6 = r6.getClientId(r2)     // Catch:{ Exception -> 0x018d }
            if (r6 != r3) goto L_0x00d2
            return r3
        L_0x00d2:
            r8 = r1
            r17 = r4
            r4 = r0
            r0 = r6
            r6 = r17
        L_0x00d9:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.internal.ConversationKitStorage r9 = r8.conversationKitStorage     // Catch:{ Exception -> 0x00ae }
            r2.L$0 = r8     // Catch:{ Exception -> 0x00ae }
            r2.L$1 = r7     // Catch:{ Exception -> 0x00ae }
            r2.L$2 = r4     // Catch:{ Exception -> 0x00ae }
            r2.L$3 = r6     // Catch:{ Exception -> 0x00ae }
            r2.L$4 = r0     // Catch:{ Exception -> 0x00ae }
            r10 = 2
            r2.label = r10     // Catch:{ Exception -> 0x00ae }
            java.lang.Object r9 = r9.getPushToken(r2)     // Catch:{ Exception -> 0x00ae }
            if (r9 != r3) goto L_0x00f1
            return r3
        L_0x00f1:
            r17 = r4
            r4 = r0
            r0 = r9
            r9 = r8
            r8 = r17
        L_0x00f8:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.internal.rest.model.ClientDto r12 = r8.buildClient(r6, r4, r0)     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.internal.user.Jwt$Decoder r0 = r9.jwtDecoder     // Catch:{ Exception -> 0x0091 }
            java.lang.String r4 = r7.getJwt()     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.ConversationKitResult r0 = r0.decode(r4)     // Catch:{ Exception -> 0x0091 }
            java.lang.Object r0 = zendesk.conversationkit.android.ConversationKitResultKt.getOrThrow(r0)     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.internal.user.Jwt r0 = (zendesk.conversationkit.android.internal.user.Jwt) r0     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.internal.rest.AppRestClient r4 = r9.appRestClient     // Catch:{ Exception -> 0x0091 }
            java.lang.String r6 = r7.getJwt()     // Catch:{ Exception -> 0x0091 }
            zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody r8 = new zendesk.conversationkit.android.internal.rest.user.model.LoginRequestBody     // Catch:{ Exception -> 0x0091 }
            java.lang.String r11 = r0.getExternalId()     // Catch:{ Exception -> 0x0091 }
            r13 = 0
            r14 = 0
            r15 = 12
            r16 = 0
            r10 = r8
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x0091 }
            r2.L$0 = r9     // Catch:{ Exception -> 0x0091 }
            r2.L$1 = r7     // Catch:{ Exception -> 0x0091 }
            r2.L$2 = r5     // Catch:{ Exception -> 0x0091 }
            r2.L$3 = r5     // Catch:{ Exception -> 0x0091 }
            r2.L$4 = r5     // Catch:{ Exception -> 0x0091 }
            r0 = 3
            r2.label = r0     // Catch:{ Exception -> 0x0091 }
            java.lang.Object r0 = r4.loginAppUser(r6, r8, r2)     // Catch:{ Exception -> 0x0091 }
            if (r0 != r3) goto L_0x0138
            return r3
        L_0x0138:
            r4 = r7
            r8 = r9
        L_0x013a:
            zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto r0 = (zendesk.conversationkit.android.internal.rest.model.AppUserResponseDto) r0     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.Config r6 = r8.config     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.App r6 = r6.getApp()     // Catch:{ Exception -> 0x00ae }
            java.lang.String r6 = r6.getId()     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.AuthenticationType$Jwt r7 = new zendesk.conversationkit.android.model.AuthenticationType$Jwt     // Catch:{ Exception -> 0x00ae }
            java.lang.String r4 = r4.getJwt()     // Catch:{ Exception -> 0x00ae }
            r7.<init>(r4)     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.AuthenticationType r7 = (zendesk.conversationkit.android.model.AuthenticationType) r7     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.User r4 = zendesk.conversationkit.android.model.UserKt.toUser(r0, r6, r7)     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.internal.app.AppStorage r0 = r8.appStorage     // Catch:{ Exception -> 0x00ae }
            r2.L$0 = r8     // Catch:{ Exception -> 0x00ae }
            r2.L$1 = r4     // Catch:{ Exception -> 0x00ae }
            r6 = 4
            r2.label = r6     // Catch:{ Exception -> 0x00ae }
            java.lang.Object r0 = r0.setUser(r4, r2)     // Catch:{ Exception -> 0x00ae }
            if (r0 != r3) goto L_0x0165
            return r3
        L_0x0165:
            zendesk.conversationkit.android.ConversationKitSettings r7 = r8.conversationKitSettings     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.model.Config r6 = r8.config     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.ConversationKitResult$Success r0 = new zendesk.conversationkit.android.ConversationKitResult$Success     // Catch:{ Exception -> 0x00ae }
            r0.<init>(r4)     // Catch:{ Exception -> 0x00ae }
            r4 = r0
            zendesk.conversationkit.android.ConversationKitResult r4 = (zendesk.conversationkit.android.ConversationKitResult) r4     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.internal.ConversationKitStorage r0 = r8.conversationKitStorage     // Catch:{ Exception -> 0x00ae }
            r2.L$0 = r8     // Catch:{ Exception -> 0x00ae }
            r2.L$1 = r7     // Catch:{ Exception -> 0x00ae }
            r2.L$2 = r6     // Catch:{ Exception -> 0x00ae }
            r2.L$3 = r4     // Catch:{ Exception -> 0x00ae }
            r9 = 5
            r2.label = r9     // Catch:{ Exception -> 0x00ae }
            java.lang.Object r0 = r0.getClientId(r2)     // Catch:{ Exception -> 0x00ae }
            if (r0 != r3) goto L_0x0185
            return r3
        L_0x0185:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00ae }
            zendesk.conversationkit.android.internal.Effect$LoginUserResult r9 = new zendesk.conversationkit.android.internal.Effect$LoginUserResult     // Catch:{ Exception -> 0x00ae }
            r9.<init>(r7, r6, r4, r0)     // Catch:{ Exception -> 0x00ae }
            return r9
        L_0x018d:
            r0 = move-exception
            r8 = r1
        L_0x018f:
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r6 = "AppActionProcessor"
            java.lang.String r7 = "Failed to login"
            zendesk.logger.Logger.e(r6, r7, r0, r4)
            zendesk.conversationkit.android.ConversationKitSettings r4 = r8.conversationKitSettings
            zendesk.conversationkit.android.model.Config r6 = r8.config
            zendesk.conversationkit.android.ConversationKitResult$Failure r7 = new zendesk.conversationkit.android.ConversationKitResult$Failure
            r7.<init>(r0)
            r0 = r7
            zendesk.conversationkit.android.ConversationKitResult r0 = (zendesk.conversationkit.android.ConversationKitResult) r0
            zendesk.conversationkit.android.internal.ConversationKitStorage r7 = r8.conversationKitStorage
            r2.L$0 = r4
            r2.L$1 = r6
            r2.L$2 = r0
            r2.L$3 = r5
            r2.L$4 = r5
            r5 = 6
            r2.label = r5
            java.lang.Object r2 = r7.getClientId(r2)
            if (r2 != r3) goto L_0x01bd
            return r3
        L_0x01bd:
            r3 = r0
            r0 = r2
            r2 = r4
            r4 = r6
        L_0x01c1:
            java.lang.String r0 = (java.lang.String) r0
            zendesk.conversationkit.android.internal.Effect$LoginUserResult r5 = new zendesk.conversationkit.android.internal.Effect$LoginUserResult
            r5.<init>(r2, r4, r3, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.processLoginUser(zendesk.conversationkit.android.internal.Action$LoginUser, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkForPersistedUser(kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$checkForPersistedUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.conversationkit.android.internal.app.AppActionProcessor$checkForPersistedUser$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$checkForPersistedUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$checkForPersistedUser$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$checkForPersistedUser$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r1 = r0.L$2
            zendesk.conversationkit.android.ConversationKitResult$Success r1 = (zendesk.conversationkit.android.ConversationKitResult.Success) r1
            java.lang.Object r2 = r0.L$1
            zendesk.conversationkit.android.ConversationKitSettings r2 = (zendesk.conversationkit.android.ConversationKitSettings) r2
            java.lang.Object r0 = r0.L$0
            zendesk.conversationkit.android.model.User r0 = (zendesk.conversationkit.android.model.User) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007b
        L_0x0039:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0041:
            java.lang.Object r2 = r0.L$0
            zendesk.conversationkit.android.internal.app.AppActionProcessor r2 = (zendesk.conversationkit.android.internal.app.AppActionProcessor) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005a
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r9)
            zendesk.conversationkit.android.internal.app.AppStorage r9 = r8.appStorage
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r9 = r9.getUser(r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r8
        L_0x005a:
            zendesk.conversationkit.android.model.User r9 = (zendesk.conversationkit.android.model.User) r9
            zendesk.conversationkit.android.ConversationKitSettings r4 = r2.conversationKitSettings
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = new zendesk.conversationkit.android.ConversationKitResult$Success
            zendesk.conversationkit.android.model.Config r6 = r2.config
            r5.<init>(r6)
            zendesk.conversationkit.android.internal.ConversationKitStorage r2 = r2.conversationKitStorage
            r0.L$0 = r9
            r0.L$1 = r4
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r0 = r2.getClientId(r0)
            if (r0 != r1) goto L_0x0076
            return r1
        L_0x0076:
            r2 = r4
            r1 = r5
            r7 = r0
            r0 = r9
            r9 = r7
        L_0x007b:
            java.lang.String r9 = (java.lang.String) r9
            zendesk.conversationkit.android.internal.Effect$CheckForPersistedUserResult r3 = new zendesk.conversationkit.android.internal.Effect$CheckForPersistedUserResult
            r3.<init>(r0, r2, r1, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.checkForPersistedUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object preparePushToken(zendesk.conversationkit.android.internal.Action.PreparePushToken r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$preparePushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor$preparePushToken$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$preparePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$preparePushToken$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$preparePushToken$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            zendesk.conversationkit.android.internal.Action$PreparePushToken r5 = (zendesk.conversationkit.android.internal.Action.PreparePushToken) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004a
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.ConversationKitStorage r6 = r4.conversationKitStorage
            java.lang.String r2 = r5.getPushToken()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.setPushToken(r2, r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            zendesk.conversationkit.android.internal.Effect$PushTokenPrepared r6 = new zendesk.conversationkit.android.internal.Effect$PushTokenPrepared
            java.lang.String r5 = r5.getPushToken()
            r6.<init>(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.preparePushToken(zendesk.conversationkit.android.internal.Action$PreparePushToken, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processAddProactiveMessage(zendesk.conversationkit.android.internal.Action.AddProactiveMessage r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$processAddProactiveMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processAddProactiveMessage$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$processAddProactiveMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processAddProactiveMessage$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$processAddProactiveMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r6 = r4.proactiveMessagingStorage
            zendesk.conversationkit.android.model.ProactiveMessage r5 = r5.getProactiveMessage()
            r0.label = r3
            java.lang.Object r5 = r6.setProactiveMessage(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.internal.Effect$None r5 = zendesk.conversationkit.android.internal.Effect.None.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.processAddProactiveMessage(zendesk.conversationkit.android.internal.Action$AddProactiveMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object processGetProactiveMessage(zendesk.conversationkit.android.internal.Action.GetProactiveMessage r5, kotlin.coroutines.Continuation<? super zendesk.conversationkit.android.internal.Effect> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetProactiveMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetProactiveMessage$1 r0 = (zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetProactiveMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetProactiveMessage$1 r0 = new zendesk.conversationkit.android.internal.app.AppActionProcessor$processGetProactiveMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.internal.proactivemessaging.ProactiveMessagingStorage r6 = r4.proactiveMessagingStorage
            int r5 = r5.getProactiveMessageId()
            r0.label = r3
            java.lang.Object r6 = r6.getProactiveMessage(r5, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            zendesk.conversationkit.android.model.ProactiveMessage r6 = (zendesk.conversationkit.android.model.ProactiveMessage) r6
            zendesk.conversationkit.android.internal.Effect$GetProactiveMessage r5 = new zendesk.conversationkit.android.internal.Effect$GetProactiveMessage
            r5.<init>(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.app.AppActionProcessor.processGetProactiveMessage(zendesk.conversationkit.android.internal.Action$GetProactiveMessage, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/internal/app/AppActionProcessor$Companion;", "", "()V", "LOG_TAG", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AppActionProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
