package zendesk.android.internal.frontendevents;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.internal.di.ZendeskComponentConfig;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.network.NetworkData;
import zendesk.conversationkit.android.ConversationKit;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ%\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lzendesk/android/internal/frontendevents/FrontendEventsRepository;", "", "frontendEventsApi", "Lzendesk/android/internal/frontendevents/FrontendEventsApi;", "zendeskComponentConfig", "Lzendesk/android/internal/di/ZendeskComponentConfig;", "frontendEventsStorage", "Lzendesk/android/internal/frontendevents/FrontendEventsStorage;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "networkData", "Lzendesk/android/internal/network/NetworkData;", "(Lzendesk/android/internal/frontendevents/FrontendEventsApi;Lzendesk/android/internal/di/ZendeskComponentConfig;Lzendesk/android/internal/frontendevents/FrontendEventsStorage;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/android/internal/network/NetworkData;)V", "sendPageViewEvent", "Lzendesk/android/ZendeskResult;", "", "", "pageTitle", "Lzendesk/android/pageviewevents/PageView;", "(Lzendesk/android/pageviewevents/PageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendProactiveMessagingAnalyticsEvent", "proactiveCampaign", "Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;", "(Lzendesk/android/internal/frontendevents/analyticsevents/model/ProactiveCampaignAnalyticsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: FrontendEventsRepository.kt */
public final class FrontendEventsRepository {
    @Deprecated
    private static final String CHANNEL = "mobile-sdk";
    @Deprecated
    private static final String CLIENT_ID = "383F2407-53F9-475B-87BD-6D2F1CE12105";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String LOG_TAG = "FrontendEventsRepository";
    @Deprecated
    private static final String ZENDESK_SDK_VERSION = "Zendesk-SDK/";
    private final ConversationKit conversationKit;
    private final FrontendEventsApi frontendEventsApi;
    private final FrontendEventsStorage frontendEventsStorage;
    private final NetworkData networkData;
    private final ZendeskComponentConfig zendeskComponentConfig;

    @Inject
    public FrontendEventsRepository(FrontendEventsApi frontendEventsApi2, ZendeskComponentConfig zendeskComponentConfig2, FrontendEventsStorage frontendEventsStorage2, ConversationKit conversationKit2, NetworkData networkData2) {
        Intrinsics.checkNotNullParameter(frontendEventsApi2, "frontendEventsApi");
        Intrinsics.checkNotNullParameter(zendeskComponentConfig2, "zendeskComponentConfig");
        Intrinsics.checkNotNullParameter(frontendEventsStorage2, "frontendEventsStorage");
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        Intrinsics.checkNotNullParameter(networkData2, "networkData");
        this.frontendEventsApi = frontendEventsApi2;
        this.zendeskComponentConfig = zendeskComponentConfig2;
        this.frontendEventsStorage = frontendEventsStorage2;
        this.conversationKit = conversationKit2;
        this.networkData = networkData2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dd A[Catch:{ Exception -> 0x0031 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendPageViewEvent(zendesk.android.pageviewevents.PageView r14, kotlin.coroutines.Continuation<? super zendesk.android.ZendeskResult<kotlin.Unit, ? extends java.lang.Throwable>> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof zendesk.android.internal.frontendevents.FrontendEventsRepository$sendPageViewEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.android.internal.frontendevents.FrontendEventsRepository$sendPageViewEvent$1 r0 = (zendesk.android.internal.frontendevents.FrontendEventsRepository$sendPageViewEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.frontendevents.FrontendEventsRepository$sendPageViewEvent$1 r0 = new zendesk.android.internal.frontendevents.FrontendEventsRepository$sendPageViewEvent$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0059
            if (r2 == r5) goto L_0x004d
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00de
        L_0x0031:
            r14 = move-exception
            goto L_0x00fd
        L_0x0034:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003c:
            java.lang.Object r14 = r0.L$2
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$1
            zendesk.android.pageviewevents.PageView r2 = (zendesk.android.pageviewevents.PageView) r2
            java.lang.Object r4 = r0.L$0
            zendesk.android.internal.frontendevents.FrontendEventsRepository r4 = (zendesk.android.internal.frontendevents.FrontendEventsRepository) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r14
            goto L_0x0083
        L_0x004d:
            java.lang.Object r14 = r0.L$1
            zendesk.android.pageviewevents.PageView r14 = (zendesk.android.pageviewevents.PageView) r14
            java.lang.Object r2 = r0.L$0
            zendesk.android.internal.frontendevents.FrontendEventsRepository r2 = (zendesk.android.internal.frontendevents.FrontendEventsRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006c
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r15)
            zendesk.android.internal.frontendevents.FrontendEventsStorage r15 = r13.frontendEventsStorage
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r15 = r15.getSUID(r0)
            if (r15 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r13
        L_0x006c:
            java.lang.String r15 = (java.lang.String) r15
            zendesk.conversationkit.android.ConversationKit r5 = r2.conversationKit
            r0.L$0 = r2
            r0.L$1 = r14
            r0.L$2 = r15
            r0.label = r4
            java.lang.Object r4 = r5.getClientId(r0)
            if (r4 != r1) goto L_0x007f
            return r1
        L_0x007f:
            r11 = r15
            r15 = r4
            r4 = r2
            r2 = r14
        L_0x0083:
            java.lang.String r15 = (java.lang.String) r15
            zendesk.android.internal.frontendevents.pageviewevents.model.PageViewEventDto r14 = new zendesk.android.internal.frontendevents.pageviewevents.model.PageViewEventDto
            java.lang.String r6 = r2.getUrl()
            if (r15 != 0) goto L_0x008f
            java.lang.String r15 = ""
        L_0x008f:
            r7 = r15
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r5 = "Zendesk-SDK/"
            java.lang.StringBuilder r15 = r15.append(r5)
            zendesk.android.internal.di.ZendeskComponentConfig r5 = r4.zendeskComponentConfig
            java.lang.String r5 = r5.getVersionName()
            java.lang.StringBuilder r15 = r15.append(r5)
            java.lang.String r9 = r15.toString()
            zendesk.android.internal.extension.DateTimeExt r15 = zendesk.android.internal.extension.DateTimeExt.INSTANCE
            java.lang.String r10 = r15.currentIso8601UtcTimestamp()
            zendesk.android.internal.frontendevents.pageviewevents.model.PageViewDto r12 = new zendesk.android.internal.frontendevents.pageviewevents.model.PageViewDto
            java.lang.String r15 = r2.getPageTitle()
            zendesk.android.internal.network.NetworkData r2 = r4.networkData
            java.lang.String r2 = r2.languageTag()
            zendesk.android.internal.network.NetworkData r5 = r4.networkData
            java.lang.String r5 = r5.userAgent()
            r12.<init>(r15, r2, r5)
            java.lang.String r8 = "mobile-sdk"
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            zendesk.android.internal.frontendevents.FrontendEventsApi r15 = r4.frontendEventsApi     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = "383F2407-53F9-475B-87BD-6D2F1CE12105"
            r4 = 0
            r0.L$0 = r4     // Catch:{ Exception -> 0x0031 }
            r0.L$1 = r4     // Catch:{ Exception -> 0x0031 }
            r0.L$2 = r4     // Catch:{ Exception -> 0x0031 }
            r0.label = r3     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r15 = r15.sendPageViewEvent(r2, r14, r0)     // Catch:{ Exception -> 0x0031 }
            if (r15 != r1) goto L_0x00de
            return r1
        L_0x00de:
            retrofit2.Response r15 = (retrofit2.Response) r15     // Catch:{ Exception -> 0x0031 }
            boolean r14 = r15.isSuccessful()
            if (r14 == 0) goto L_0x00f0
            zendesk.android.ZendeskResult$Success r14 = new zendesk.android.ZendeskResult$Success
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r14.<init>(r15)
            zendesk.android.ZendeskResult r14 = (zendesk.android.ZendeskResult) r14
            goto L_0x00fc
        L_0x00f0:
            zendesk.android.ZendeskResult$Failure r14 = new zendesk.android.ZendeskResult$Failure
            retrofit2.HttpException r0 = new retrofit2.HttpException
            r0.<init>(r15)
            r14.<init>(r0)
            zendesk.android.ZendeskResult r14 = (zendesk.android.ZendeskResult) r14
        L_0x00fc:
            return r14
        L_0x00fd:
            zendesk.android.ZendeskResult$Failure r15 = new zendesk.android.ZendeskResult$Failure
            r15.<init>(r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.frontendevents.FrontendEventsRepository.sendPageViewEvent(zendesk.android.pageviewevents.PageView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendProactiveMessagingAnalyticsEvent(zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof zendesk.android.internal.frontendevents.FrontendEventsRepository$sendProactiveMessagingAnalyticsEvent$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.android.internal.frontendevents.FrontendEventsRepository$sendProactiveMessagingAnalyticsEvent$1 r0 = (zendesk.android.internal.frontendevents.FrontendEventsRepository$sendProactiveMessagingAnalyticsEvent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.frontendevents.FrontendEventsRepository$sendProactiveMessagingAnalyticsEvent$1 r0 = new zendesk.android.internal.frontendevents.FrontendEventsRepository$sendProactiveMessagingAnalyticsEvent$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005a
            if (r2 == r5) goto L_0x004e
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00e1
        L_0x0031:
            r14 = move-exception
            goto L_0x00d5
        L_0x0034:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003c:
            java.lang.Object r14 = r0.L$2
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r2 = r0.L$1
            zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO r2 = (zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO) r2
            java.lang.Object r4 = r0.L$0
            zendesk.android.internal.frontendevents.FrontendEventsRepository r4 = (zendesk.android.internal.frontendevents.FrontendEventsRepository) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r10 = r14
            r12 = r2
            goto L_0x0084
        L_0x004e:
            java.lang.Object r14 = r0.L$1
            zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO r14 = (zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO) r14
            java.lang.Object r2 = r0.L$0
            zendesk.android.internal.frontendevents.FrontendEventsRepository r2 = (zendesk.android.internal.frontendevents.FrontendEventsRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006d
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r15)
            zendesk.android.internal.frontendevents.FrontendEventsStorage r15 = r13.frontendEventsStorage
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r15 = r15.getSUID(r0)
            if (r15 != r1) goto L_0x006c
            return r1
        L_0x006c:
            r2 = r13
        L_0x006d:
            java.lang.String r15 = (java.lang.String) r15
            zendesk.conversationkit.android.ConversationKit r5 = r2.conversationKit
            r0.L$0 = r2
            r0.L$1 = r14
            r0.L$2 = r15
            r0.label = r4
            java.lang.Object r4 = r5.getClientId(r0)
            if (r4 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r12 = r14
            r10 = r15
            r15 = r4
            r4 = r2
        L_0x0084:
            java.lang.String r15 = (java.lang.String) r15
            if (r15 != 0) goto L_0x008c
            java.lang.String r14 = ""
            r6 = r14
            goto L_0x008d
        L_0x008c:
            r6 = r15
        L_0x008d:
            zendesk.android.internal.extension.DateTimeExt r14 = zendesk.android.internal.extension.DateTimeExt.INSTANCE
            java.lang.String r9 = r14.currentIso8601UtcTimestamp()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Zendesk-SDK/"
            java.lang.StringBuilder r14 = r14.append(r15)
            zendesk.android.internal.di.ZendeskComponentConfig r15 = r4.zendeskComponentConfig
            java.lang.String r15 = r15.getVersionName()
            java.lang.StringBuilder r14 = r14.append(r15)
            java.lang.String r8 = r14.toString()
            java.util.UUID r14 = java.util.UUID.randomUUID()
            java.lang.String r11 = r14.toString()
            zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveMessageAnalyticsEvent r14 = new zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveMessageAnalyticsEvent
            java.lang.String r15 = "toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r15)
            java.lang.String r7 = "mobile-sdk"
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            zendesk.android.internal.frontendevents.FrontendEventsApi r15 = r4.frontendEventsApi     // Catch:{ Exception -> 0x0031 }
            java.lang.String r2 = "383F2407-53F9-475B-87BD-6D2F1CE12105"
            r4 = 0
            r0.L$0 = r4     // Catch:{ Exception -> 0x0031 }
            r0.L$1 = r4     // Catch:{ Exception -> 0x0031 }
            r0.L$2 = r4     // Catch:{ Exception -> 0x0031 }
            r0.label = r3     // Catch:{ Exception -> 0x0031 }
            java.lang.Object r14 = r15.sendProactiveCampaignAnalyticsEvent(r2, r14, r0)     // Catch:{ Exception -> 0x0031 }
            if (r14 != r1) goto L_0x00e1
            return r1
        L_0x00d5:
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            r15 = 0
            java.lang.Object[] r15 = new java.lang.Object[r15]
            java.lang.String r0 = "FrontendEventsRepository"
            java.lang.String r1 = "Failed to send analytics event"
            zendesk.logger.Logger.e(r0, r1, r14, r15)
        L_0x00e1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.frontendevents.FrontendEventsRepository.sendProactiveMessagingAnalyticsEvent(zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/android/internal/frontendevents/FrontendEventsRepository$Companion;", "", "()V", "CHANNEL", "", "CLIENT_ID", "LOG_TAG", "ZENDESK_SDK_VERSION", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FrontendEventsRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
