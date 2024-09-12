package zendesk.android.internal.proactivemessaging;

import com.oblador.keychain.KeychainModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessageJwtDecoder;
import zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessageResponse;
import zendesk.android.internal.proactivemessaging.model.Campaign;
import zendesk.android.internal.proactivemessaging.model.Frequency;
import zendesk.android.settings.internal.SettingsRepository;
import zendesk.conversationkit.android.model.ProactiveMessage;
import zendesk.logger.Logger;

@ZendeskInitializedComponentScope
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 .2\u00020\u0001:\u0001.B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000f2\u0006\u0010 \u001a\u00020\u0018J\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010#J!\u0010$\u001a\u0004\u0018\u00010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020*H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010-R*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingRepository;", "", "settingsRepository", "Lzendesk/android/settings/internal/SettingsRepository;", "storage", "Lzendesk/android/internal/proactivemessaging/ProactiveMessagingStorage;", "proactiveMessageJwtDecoder", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageJwtDecoder;", "proactiveMessagingService", "Lzendesk/android/internal/proactivemessaging/ProactiveMessagingService;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lzendesk/android/settings/internal/SettingsRepository;Lzendesk/android/internal/proactivemessaging/ProactiveMessagingStorage;Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageJwtDecoder;Lzendesk/android/internal/proactivemessaging/ProactiveMessagingService;Lkotlinx/coroutines/CoroutineScope;)V", "campaigns", "", "Lzendesk/android/internal/proactivemessaging/model/Campaign;", "getCampaigns$zendesk_zendesk_android$annotations", "()V", "getCampaigns$zendesk_zendesk_android", "()Ljava/util/List;", "setCampaigns$zendesk_zendesk_android", "(Ljava/util/List;)V", "filterOutCampaigns", "", "", "getFilterOutCampaigns$zendesk_zendesk_android$annotations", "getFilterOutCampaigns$zendesk_zendesk_android", "setFilterOutCampaigns$zendesk_zendesk_android", "buildProactiveMessage", "Lzendesk/conversationkit/android/model/ProactiveMessage;", "jwt", "getCampaign", "campaignId", "getCampaignsForEvaluation", "getLiveCampaigns", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProactiveMessage", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CtsResponseDto;", "campaignPaths", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/CampaignPathDto;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializeFilterOutCampaigns", "", "updateFilterOutCampaigns", "campaign", "(Lzendesk/android/internal/proactivemessaging/model/Campaign;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessagingRepository.kt */
public final class ProactiveMessagingRepository {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String LOG_TAG = "PM-Repository";
    public List<Campaign> campaigns;
    private List<String> filterOutCampaigns = new ArrayList();
    private final ProactiveMessageJwtDecoder proactiveMessageJwtDecoder;
    private final ProactiveMessagingService proactiveMessagingService;
    private final SettingsRepository settingsRepository;
    private final ProactiveMessagingStorage storage;

    public static /* synthetic */ void getCampaigns$zendesk_zendesk_android$annotations() {
    }

    public static /* synthetic */ void getFilterOutCampaigns$zendesk_zendesk_android$annotations() {
    }

    @Inject
    public ProactiveMessagingRepository(SettingsRepository settingsRepository2, ProactiveMessagingStorage proactiveMessagingStorage, ProactiveMessageJwtDecoder proactiveMessageJwtDecoder2, ProactiveMessagingService proactiveMessagingService2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(settingsRepository2, "settingsRepository");
        Intrinsics.checkNotNullParameter(proactiveMessagingStorage, KeychainModule.Maps.STORAGE);
        Intrinsics.checkNotNullParameter(proactiveMessageJwtDecoder2, "proactiveMessageJwtDecoder");
        Intrinsics.checkNotNullParameter(proactiveMessagingService2, "proactiveMessagingService");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.settingsRepository = settingsRepository2;
        this.storage = proactiveMessagingStorage;
        this.proactiveMessageJwtDecoder = proactiveMessageJwtDecoder2;
        this.proactiveMessagingService = proactiveMessagingService2;
        if (ProactiveMessagingManager.Companion.isProactiveMessagingEnabled$zendesk_zendesk_android()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        setCampaigns$zendesk_zendesk_android(CollectionsKt.emptyList());
    }

    public final List<Campaign> getCampaigns$zendesk_zendesk_android() {
        List<Campaign> list = this.campaigns;
        if (list != null) {
            return list;
        }
        Intrinsics.throwUninitializedPropertyAccessException("campaigns");
        return null;
    }

    public final void setCampaigns$zendesk_zendesk_android(List<Campaign> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.campaigns = list;
    }

    public final List<String> getFilterOutCampaigns$zendesk_zendesk_android() {
        return this.filterOutCampaigns;
    }

    public final void setFilterOutCampaigns$zendesk_zendesk_android(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.filterOutCampaigns = list;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$1", f = "ProactiveMessagingRepository.kt", i = {}, l = {39, 40}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$1  reason: invalid class name */
    /* compiled from: ProactiveMessagingRepository.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ ProactiveMessagingRepository this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            ProactiveMessagingRepository proactiveMessagingRepository;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                proactiveMessagingRepository = this.this$0;
                this.L$0 = proactiveMessagingRepository;
                this.label = 1;
                obj = proactiveMessagingRepository.getLiveCampaigns(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                proactiveMessagingRepository = (ProactiveMessagingRepository) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            proactiveMessagingRepository.setCampaigns$zendesk_zendesk_android((List) obj);
            this.L$0 = null;
            this.label = 2;
            if (this.this$0.initializeFilterOutCampaigns(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x010e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initializeFilterOutCampaigns(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$initializeFilterOutCampaigns$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$initializeFilterOutCampaigns$1 r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$initializeFilterOutCampaigns$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$initializeFilterOutCampaigns$1 r0 = new zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$initializeFilterOutCampaigns$1
            r0.<init>(r10, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005d
            if (r2 == r5) goto L_0x0050
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r0 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x010f
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x003d:
            java.lang.Object r2 = r0.L$2
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r5 = r0.L$1
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r6 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository) r6
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r0
            r0 = r6
            goto L_0x00da
        L_0x0050:
            java.lang.Object r2 = r0.L$1
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r5 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r5 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00cf
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r11)
            java.util.List r11 = r10.getCampaigns$zendesk_zendesk_android()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r11 = r11.iterator()
        L_0x0071:
            boolean r6 = r11.hasNext()
            if (r6 == 0) goto L_0x0093
            java.lang.Object r6 = r11.next()
            r7 = r6
            zendesk.android.internal.proactivemessaging.model.Campaign r7 = (zendesk.android.internal.proactivemessaging.model.Campaign) r7
            zendesk.android.internal.proactivemessaging.model.Schedule r7 = r7.getSchedule()
            zendesk.android.internal.proactivemessaging.model.Frequency r7 = r7.getFrequency()
            zendesk.android.internal.proactivemessaging.model.Frequency r8 = zendesk.android.internal.proactivemessaging.model.Frequency.SEND_ONCE
            if (r7 != r8) goto L_0x008c
            r7 = r5
            goto L_0x008d
        L_0x008c:
            r7 = 0
        L_0x008d:
            if (r7 == 0) goto L_0x0071
            r2.add(r6)
            goto L_0x0071
        L_0x0093:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r11 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r6)
            r11.<init>(r6)
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.Iterator r2 = r2.iterator()
        L_0x00a8:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r2.next()
            zendesk.android.internal.proactivemessaging.model.Campaign r6 = (zendesk.android.internal.proactivemessaging.model.Campaign) r6
            java.lang.String r6 = r6.getCampaignId()
            r11.add(r6)
            goto L_0x00a8
        L_0x00bc:
            r2 = r11
            java.util.List r2 = (java.util.List) r2
            zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage r11 = r10.storage
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r5
            java.lang.Object r11 = r11.getSendOnceCampaignIds(r0)
            if (r11 != r1) goto L_0x00ce
            return r1
        L_0x00ce:
            r5 = r10
        L_0x00cf:
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.Iterator r11 = r11.iterator()
            r9 = r2
            r2 = r11
            r11 = r0
            r0 = r5
            r5 = r9
        L_0x00da:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00fd
            java.lang.Object r6 = r2.next()
            java.lang.String r6 = (java.lang.String) r6
            boolean r7 = r5.contains(r6)
            if (r7 != 0) goto L_0x00da
            zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage r7 = r0.storage
            r11.L$0 = r0
            r11.L$1 = r5
            r11.L$2 = r2
            r11.label = r4
            java.lang.Object r6 = r7.removeSendOnceCampaign(r6, r11)
            if (r6 != r1) goto L_0x00da
            return r1
        L_0x00fd:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingStorage r2 = r0.storage
            r11.L$0 = r0
            r4 = 0
            r11.L$1 = r4
            r11.L$2 = r4
            r11.label = r3
            java.lang.Object r11 = r2.getSendOnceCampaignIds(r11)
            if (r11 != r1) goto L_0x010f
            return r1
        L_0x010f:
            java.util.Collection r11 = (java.util.Collection) r11
            java.util.List r11 = kotlin.collections.CollectionsKt.toMutableList(r11)
            r0.filterOutCampaigns = r11
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository.initializeFilterOutCampaigns(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c2 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00f3 A[Catch:{ Exception -> 0x002e }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLiveCampaigns(kotlin.coroutines.Continuation<? super java.util.List<zendesk.android.internal.proactivemessaging.model.Campaign>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getLiveCampaigns$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getLiveCampaigns$1 r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getLiveCampaigns$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getLiveCampaigns$1 r0 = new zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getLiveCampaigns$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r5) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x002e }
            goto L_0x0082
        L_0x002e:
            r8 = move-exception
            goto L_0x0113
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r2 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0052
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r8)
            zendesk.android.settings.internal.SettingsRepository r8 = r7.settingsRepository
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r8 = r8.fetchSettings$zendesk_zendesk_android(r0)
            if (r8 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r7
        L_0x0052:
            zendesk.android.ZendeskResult r8 = (zendesk.android.ZendeskResult) r8
            boolean r6 = r8 instanceof zendesk.android.ZendeskResult.Failure
            if (r6 == 0) goto L_0x005e
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0127
        L_0x005e:
            boolean r6 = r8 instanceof zendesk.android.ZendeskResult.Success
            if (r6 == 0) goto L_0x0128
            zendesk.android.ZendeskResult$Success r8 = (zendesk.android.ZendeskResult.Success) r8
            java.lang.Object r8 = r8.getValue()
            zendesk.android.settings.internal.model.SettingsDto r8 = (zendesk.android.settings.internal.model.SettingsDto) r8
            zendesk.android.settings.internal.model.NativeMessagingDto r8 = r8.getNativeMessaging()
            java.lang.String r8 = r8.getIntegrationId()
            if (r8 == 0) goto L_0x0123
            zendesk.android.internal.proactivemessaging.ProactiveMessagingService r2 = r2.proactiveMessagingService     // Catch:{ Exception -> 0x002e }
            r6 = 0
            r0.L$0 = r6     // Catch:{ Exception -> 0x002e }
            r0.label = r3     // Catch:{ Exception -> 0x002e }
            java.lang.Object r8 = r2.getCampaigns(r8, r0)     // Catch:{ Exception -> 0x002e }
            if (r8 != r1) goto L_0x0082
            return r1
        L_0x0082:
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x002e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x002e }
            r0.<init>()     // Catch:{ Exception -> 0x002e }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x002e }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x002e }
        L_0x008f:
            boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x00ad
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x002e }
            r2 = r1
            zendesk.android.internal.proactivemessaging.model.Campaign r2 = (zendesk.android.internal.proactivemessaging.model.Campaign) r2     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Status r2 = r2.getStatus()     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Status r3 = zendesk.android.internal.proactivemessaging.model.Status.LIVE     // Catch:{ Exception -> 0x002e }
            if (r2 != r3) goto L_0x00a6
            r2 = r5
            goto L_0x00a7
        L_0x00a6:
            r2 = r4
        L_0x00a7:
            if (r2 == 0) goto L_0x008f
            r0.add(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x008f
        L_0x00ad:
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x002e }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ Exception -> 0x002e }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Exception -> 0x002e }
            r8.<init>()     // Catch:{ Exception -> 0x002e }
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ Exception -> 0x002e }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x002e }
        L_0x00bc:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x00de
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x002e }
            r2 = r1
            zendesk.android.internal.proactivemessaging.model.Campaign r2 = (zendesk.android.internal.proactivemessaging.model.Campaign) r2     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Integration r2 = r2.getIntegration()     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.IntegrationType r2 = r2.getType()     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.IntegrationType r3 = zendesk.android.internal.proactivemessaging.model.IntegrationType.ANDROID     // Catch:{ Exception -> 0x002e }
            if (r2 != r3) goto L_0x00d7
            r2 = r5
            goto L_0x00d8
        L_0x00d7:
            r2 = r4
        L_0x00d8:
            if (r2 == 0) goto L_0x00bc
            r8.add(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x00bc
        L_0x00de:
            java.util.List r8 = (java.util.List) r8     // Catch:{ Exception -> 0x002e }
            java.lang.Iterable r8 = (java.lang.Iterable) r8     // Catch:{ Exception -> 0x002e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x002e }
            r0.<init>()     // Catch:{ Exception -> 0x002e }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Exception -> 0x002e }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x002e }
        L_0x00ed:
            boolean r1 = r8.hasNext()     // Catch:{ Exception -> 0x002e }
            if (r1 == 0) goto L_0x010f
            java.lang.Object r1 = r8.next()     // Catch:{ Exception -> 0x002e }
            r2 = r1
            zendesk.android.internal.proactivemessaging.model.Campaign r2 = (zendesk.android.internal.proactivemessaging.model.Campaign) r2     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Schedule r2 = r2.getSchedule()     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Frequency r2 = r2.getFrequency()     // Catch:{ Exception -> 0x002e }
            zendesk.android.internal.proactivemessaging.model.Frequency r3 = zendesk.android.internal.proactivemessaging.model.Frequency.UNKNOWN     // Catch:{ Exception -> 0x002e }
            if (r2 != r3) goto L_0x0108
            r2 = r5
            goto L_0x0109
        L_0x0108:
            r2 = r4
        L_0x0109:
            if (r2 != 0) goto L_0x00ed
            r0.add(r1)     // Catch:{ Exception -> 0x002e }
            goto L_0x00ed
        L_0x010f:
            java.util.List r0 = (java.util.List) r0     // Catch:{ Exception -> 0x002e }
            r8 = r0
            goto L_0x0127
        L_0x0113:
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.String r1 = "PM-Repository"
            java.lang.String r2 = "Failed to get campaigns"
            zendesk.logger.Logger.e(r1, r2, r8, r0)
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x0127
        L_0x0123:
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x0127:
            return r8
        L_0x0128:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository.getLiveCampaigns(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final List<Campaign> getCampaignsForEvaluation() {
        Collection arrayList = new ArrayList();
        for (Object next : getCampaigns$zendesk_zendesk_android()) {
            if (!this.filterOutCampaigns.contains(((Campaign) next).getCampaignId())) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final Object updateFilterOutCampaigns(Campaign campaign, Continuation<? super Unit> continuation) {
        if (campaign.getSchedule().getFrequency() == Frequency.ONCE_PER_SESSION) {
            this.filterOutCampaigns.add(campaign.getCampaignId());
        } else if (campaign.getSchedule().getFrequency() == Frequency.SEND_ONCE) {
            this.filterOutCampaigns.add(campaign.getCampaignId());
            Object addSendOnceCampaign = this.storage.addSendOnceCampaign(campaign.getCampaignId(), continuation);
            return addSendOnceCampaign == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? addSendOnceCampaign : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getProactiveMessage(java.util.List<zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CampaignPathDto> r5, kotlin.coroutines.Continuation<? super zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getProactiveMessage$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getProactiveMessage$1 r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getProactiveMessage$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getProactiveMessage$1 r0 = new zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository$getProactiveMessage$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ Exception -> 0x002a }
            goto L_0x0047
        L_0x002a:
            r5 = move-exception
            goto L_0x004a
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.android.internal.proactivemessaging.ProactiveMessagingService r6 = r4.proactiveMessagingService     // Catch:{ Exception -> 0x002a }
            zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsRequestDto r2 = new zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsRequestDto     // Catch:{ Exception -> 0x002a }
            r2.<init>(r5)     // Catch:{ Exception -> 0x002a }
            r0.label = r3     // Catch:{ Exception -> 0x002a }
            java.lang.Object r6 = r6.getProactiveMessage(r2, r0)     // Catch:{ Exception -> 0x002a }
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto r6 = (zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto) r6     // Catch:{ Exception -> 0x002a }
            goto L_0x005a
        L_0x004a:
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.String r0 = "PM-Repository"
            java.lang.String r1 = "Failed to get proactive message"
            zendesk.logger.Logger.e(r0, r1, r5, r6)
            r6 = 0
            r5 = r6
            zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto r5 = (zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto) r5
        L_0x005a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository.getProactiveMessage(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Campaign getCampaign(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Iterator it = getCampaigns$zendesk_zendesk_android().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Campaign) obj).getCampaignId(), (Object) str)) {
                break;
            }
        }
        return (Campaign) obj;
    }

    public final ProactiveMessage buildProactiveMessage(String str) {
        List<zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessage> messages;
        zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessage proactiveMessage;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "jwt");
        try {
            ProactiveMessageResponse decode = this.proactiveMessageJwtDecoder.decode(str2);
            if (decode == null || (messages = decode.getMessages()) == null || (proactiveMessage = (zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt.ProactiveMessage) CollectionsKt.firstOrNull(messages)) == null) {
                ProactiveMessagingRepository proactiveMessagingRepository = this;
                Logger.e(LOG_TAG, "Proactive message response doesn't contain enough information", new Object[0]);
                ProactiveMessage proactiveMessage2 = null;
                return null;
            }
            String displayName = proactiveMessage.getAuthor().getDisplayName();
            String text = proactiveMessage.getContent().getText();
            String id = decode.getCampaign().getId();
            Campaign campaign = getCampaign(decode.getCampaign().getId());
            return new ProactiveMessage(0, displayName, text, id, campaign != null ? campaign.getVersion() : 0, str, 1, (DefaultConstructorMarker) null);
        } catch (Exception e) {
            Logger.e(LOG_TAG, "Failed to build local notification", e, new Object[0]);
            ProactiveMessage proactiveMessage3 = null;
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingRepository$Companion;", "", "()V", "LOG_TAG", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessagingRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
