package zendesk.android.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.android.internal.di.ZendeskComponent;
import zendesk.android.messaging.MessagingFactory;
import zendesk.conversationkit.android.ConversationKitEvent;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lzendesk/android/internal/ZendeskFactory;", "", "()V", "create", "Lzendesk/android/ZendeskResult;", "Lzendesk/android/Zendesk;", "", "zendeskComponent", "Lzendesk/android/internal/di/ZendeskComponent;", "messagingFactory", "Lzendesk/android/messaging/MessagingFactory;", "(Lzendesk/android/internal/di/ZendeskComponent;Lzendesk/android/messaging/MessagingFactory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskFactory.kt */
public final class ZendeskFactory {
    public static final ZendeskFactory INSTANCE = new ZendeskFactory();

    private ZendeskFactory() {
    }

    public static /* synthetic */ Object create$default(ZendeskFactory zendeskFactory, ZendeskComponent zendeskComponent, MessagingFactory messagingFactory, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            messagingFactory = null;
        }
        return zendeskFactory.create(zendeskComponent, messagingFactory, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f4, code lost:
        r3 = (r3 = r3.getApp()).getSettings();
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d A[Catch:{ Exception -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0089 A[Catch:{ Exception -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7 A[Catch:{ Exception -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0154 A[Catch:{ Exception -> 0x0175 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object create(zendesk.android.internal.di.ZendeskComponent r10, zendesk.android.messaging.MessagingFactory r11, kotlin.coroutines.Continuation<? super zendesk.android.ZendeskResult<zendesk.android.Zendesk, ? extends java.lang.Throwable>> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof zendesk.android.internal.ZendeskFactory$create$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            zendesk.android.internal.ZendeskFactory$create$1 r0 = (zendesk.android.internal.ZendeskFactory$create$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.ZendeskFactory$create$1 r0 = new zendesk.android.internal.ZendeskFactory$create$1
            r0.<init>(r9, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005d
            if (r2 == r4) goto L_0x0049
            if (r2 != r3) goto L_0x0041
            java.lang.Object r10 = r0.L$3
            zendesk.android.settings.internal.model.SettingsDto r10 = (zendesk.android.settings.internal.model.SettingsDto) r10
            java.lang.Object r11 = r0.L$2
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            java.lang.Object r1 = r0.L$1
            zendesk.android.messaging.MessagingFactory r1 = (zendesk.android.messaging.MessagingFactory) r1
            java.lang.Object r0 = r0.L$0
            zendesk.android.internal.di.ZendeskComponent r0 = (zendesk.android.internal.di.ZendeskComponent) r0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0175 }
            r4 = r11
            r11 = r0
            r7 = r1
            goto L_0x00b1
        L_0x0041:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0049:
            java.lang.Object r10 = r0.L$2
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r11 = r0.L$1
            zendesk.android.messaging.MessagingFactory r11 = (zendesk.android.messaging.MessagingFactory) r11
            java.lang.Object r2 = r0.L$0
            zendesk.android.internal.di.ZendeskComponent r2 = (zendesk.android.internal.di.ZendeskComponent) r2
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ Exception -> 0x0175 }
            r8 = r12
            r12 = r10
            r10 = r2
            r2 = r8
            goto L_0x0077
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.CoroutineScope r12 = r10.mainScope()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.SettingsRepository r2 = r10.settingsRepository()     // Catch:{ Exception -> 0x0175 }
            r0.L$0 = r10     // Catch:{ Exception -> 0x0175 }
            r0.L$1 = r11     // Catch:{ Exception -> 0x0175 }
            r0.L$2 = r12     // Catch:{ Exception -> 0x0175 }
            r0.label = r4     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r2 = r2.fetchSettings$zendesk_zendesk_android(r0)     // Catch:{ Exception -> 0x0175 }
            if (r2 != r1) goto L_0x0077
            return r1
        L_0x0077:
            zendesk.android.ZendeskResult r2 = (zendesk.android.ZendeskResult) r2     // Catch:{ Exception -> 0x0175 }
            boolean r4 = r2 instanceof zendesk.android.ZendeskResult.Failure     // Catch:{ Exception -> 0x0175 }
            if (r4 == 0) goto L_0x0089
            zendesk.android.ZendeskResult$Failure r10 = new zendesk.android.ZendeskResult$Failure     // Catch:{ Exception -> 0x0175 }
            zendesk.android.ZendeskResult$Failure r2 = (zendesk.android.ZendeskResult.Failure) r2     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r11 = r2.getError()     // Catch:{ Exception -> 0x0175 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0175 }
            return r10
        L_0x0089:
            boolean r4 = r2 instanceof zendesk.android.ZendeskResult.Success     // Catch:{ Exception -> 0x0175 }
            if (r4 == 0) goto L_0x016f
            zendesk.android.ZendeskResult$Success r2 = (zendesk.android.ZendeskResult.Success) r2     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.model.SettingsDto r2 = (zendesk.android.settings.internal.model.SettingsDto) r2     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.ConversationKitProvider r4 = zendesk.android.internal.ConversationKitProvider.INSTANCE     // Catch:{ Exception -> 0x0175 }
            android.content.Context r5 = r10.context()     // Catch:{ Exception -> 0x0175 }
            r0.L$0 = r10     // Catch:{ Exception -> 0x0175 }
            r0.L$1 = r11     // Catch:{ Exception -> 0x0175 }
            r0.L$2 = r12     // Catch:{ Exception -> 0x0175 }
            r0.L$3 = r2     // Catch:{ Exception -> 0x0175 }
            r0.label = r3     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r0 = r4.createConversationKit$zendesk_zendesk_android(r2, r5, r0)     // Catch:{ Exception -> 0x0175 }
            if (r0 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r7 = r11
            r4 = r12
            r12 = r0
            r11 = r10
            r10 = r2
        L_0x00b1:
            zendesk.conversationkit.android.ConversationKitResult r12 = (zendesk.conversationkit.android.ConversationKitResult) r12     // Catch:{ Exception -> 0x0175 }
            boolean r0 = r12 instanceof zendesk.conversationkit.android.ConversationKitResult.Success     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x0154
            zendesk.conversationkit.android.ConversationKitResult$Success r12 = (zendesk.conversationkit.android.ConversationKitResult.Success) r12     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r12 = r12.getValue()     // Catch:{ Exception -> 0x0175 }
            zendesk.conversationkit.android.ConversationKit r12 = (zendesk.conversationkit.android.ConversationKit) r12     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.ZendeskFactory$$ExternalSyntheticLambda0 r0 = new zendesk.android.internal.ZendeskFactory$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x0175 }
            r0.<init>(r4, r11)     // Catch:{ Exception -> 0x0175 }
            r12.addEventListener(r0)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.model.NativeMessagingDto r0 = r10.getNativeMessaging()     // Catch:{ Exception -> 0x0175 }
            boolean r0 = r0.getEnabled()     // Catch:{ Exception -> 0x0175 }
            if (r0 == 0) goto L_0x0135
            if (r7 == 0) goto L_0x0135
            zendesk.android.settings.internal.model.NativeMessagingDto r0 = r10.getNativeMessaging()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.model.ColorThemeDto r1 = r10.getLightTheme()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.messaging.model.ColorTheme r1 = zendesk.android.messaging.model.ColorThemeKt.toColorTheme(r1)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.model.ColorThemeDto r2 = r10.getDarkTheme()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.messaging.model.ColorTheme r2 = zendesk.android.messaging.model.ColorThemeKt.toColorTheme(r2)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.settings.internal.model.SunCoConfigDto r3 = r10.getSunCoConfigDto()     // Catch:{ Exception -> 0x0175 }
            r5 = 0
            if (r3 == 0) goto L_0x00ff
            zendesk.android.settings.internal.model.AppDto r3 = r3.getApp()     // Catch:{ Exception -> 0x0175 }
            if (r3 == 0) goto L_0x00ff
            zendesk.android.settings.internal.model.AppSettingsDto r3 = r3.getSettings()     // Catch:{ Exception -> 0x0175 }
            if (r3 == 0) goto L_0x00ff
            boolean r3 = r3.isMultiConvoEnabled()     // Catch:{ Exception -> 0x0175 }
            goto L_0x0100
        L_0x00ff:
            r3 = r5
        L_0x0100:
            zendesk.android.settings.internal.model.SunCoConfigDto r10 = r10.getSunCoConfigDto()     // Catch:{ Exception -> 0x0175 }
            if (r10 == 0) goto L_0x0110
            zendesk.android.settings.internal.model.IntegrationDto r10 = r10.getIntegration()     // Catch:{ Exception -> 0x0175 }
            if (r10 == 0) goto L_0x0110
            boolean r5 = r10.getCanUserCreateMoreConversations()     // Catch:{ Exception -> 0x0175 }
        L_0x0110:
            zendesk.android.messaging.model.MessagingSettings r3 = zendesk.android.messaging.model.MessagingSettingsKt.toMessagingSettings(r0, r1, r2, r3, r5)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.di.ZendeskComponentConfig r10 = r11.componentData()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.ZendeskCredentials r1 = r10.getChannelKey()     // Catch:{ Exception -> 0x0175 }
            android.content.Context r6 = r11.context()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.messaging.MessagingFactory$CreateParams r10 = new zendesk.android.messaging.MessagingFactory$CreateParams     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.ZendeskFactory$create$messaging$1 r0 = new zendesk.android.internal.ZendeskFactory$create$messaging$1     // Catch:{ Exception -> 0x0175 }
            r2 = 0
            r0.<init>(r11, r2)     // Catch:{ Exception -> 0x0175 }
            r5 = r0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ Exception -> 0x0175 }
            r0 = r10
            r2 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.messaging.Messaging r10 = r7.create(r10)     // Catch:{ Exception -> 0x0175 }
            goto L_0x0139
        L_0x0135:
            zendesk.android.messaging.internal.NotEnabledMessaging r10 = zendesk.android.messaging.internal.NotEnabledMessaging.INSTANCE     // Catch:{ Exception -> 0x0175 }
            zendesk.android.messaging.Messaging r10 = (zendesk.android.messaging.Messaging) r10     // Catch:{ Exception -> 0x0175 }
        L_0x0139:
            zendesk.android.internal.di.ZendeskInitializedComponent$Builder r11 = r11.getZendeskInitializedComponent()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.di.ZendeskInitializedModule r0 = new zendesk.android.internal.di.ZendeskInitializedModule     // Catch:{ Exception -> 0x0175 }
            r0.<init>(r12, r10)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.di.ZendeskInitializedComponent$Builder r10 = r11.zendeskInitializedModule(r0)     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.di.ZendeskInitializedComponent r10 = r10.build()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.Zendesk r10 = r10.zendesk()     // Catch:{ Exception -> 0x0175 }
            zendesk.android.ZendeskResult$Success r11 = new zendesk.android.ZendeskResult$Success     // Catch:{ Exception -> 0x0175 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0175 }
            return r11
        L_0x0154:
            boolean r10 = r12 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure     // Catch:{ Exception -> 0x0175 }
            if (r10 == 0) goto L_0x0169
            zendesk.android.ZendeskResult$Failure r10 = new zendesk.android.ZendeskResult$Failure     // Catch:{ Exception -> 0x0175 }
            zendesk.android.internal.ZendeskError$FailedToInitialize r11 = new zendesk.android.internal.ZendeskError$FailedToInitialize     // Catch:{ Exception -> 0x0175 }
            zendesk.conversationkit.android.ConversationKitResult$Failure r12 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r12     // Catch:{ Exception -> 0x0175 }
            java.lang.Throwable r12 = r12.getCause()     // Catch:{ Exception -> 0x0175 }
            r11.<init>(r12)     // Catch:{ Exception -> 0x0175 }
            r10.<init>(r11)     // Catch:{ Exception -> 0x0175 }
            return r10
        L_0x0169:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException     // Catch:{ Exception -> 0x0175 }
            r10.<init>()     // Catch:{ Exception -> 0x0175 }
            throw r10     // Catch:{ Exception -> 0x0175 }
        L_0x016f:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException     // Catch:{ Exception -> 0x0175 }
            r10.<init>()     // Catch:{ Exception -> 0x0175 }
            throw r10     // Catch:{ Exception -> 0x0175 }
        L_0x0175:
            r10 = move-exception
            zendesk.android.ZendeskResult$Failure r11 = new zendesk.android.ZendeskResult$Failure
            r11.<init>(r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.ZendeskFactory.create(zendesk.android.internal.di.ZendeskComponent, zendesk.android.messaging.MessagingFactory, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-0  reason: not valid java name */
    public static final void m2749create$lambda0(CoroutineScope coroutineScope, ZendeskComponent zendeskComponent, ConversationKitEvent conversationKitEvent) {
        Intrinsics.checkNotNullParameter(coroutineScope, "$scope");
        Intrinsics.checkNotNullParameter(zendeskComponent, "$zendeskComponent");
        Intrinsics.checkNotNullParameter(conversationKitEvent, "conversationKitEvent");
        if (conversationKitEvent instanceof ConversationKitEvent.UserAccessRevoked) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ZendeskFactory$create$2$1(zendeskComponent, conversationKitEvent, (Continuation<? super ZendeskFactory$create$2$1>) null), 3, (Object) null);
        }
    }
}
