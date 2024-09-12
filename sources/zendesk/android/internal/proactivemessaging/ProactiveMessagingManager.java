package zendesk.android.internal.proactivemessaging;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.frontendevents.analyticsevents.ProactiveMessagingAnalyticsManager;
import zendesk.android.internal.proactivemessaging.model.Trigger;
import zendesk.android.internal.proactivemessaging.model.TriggerType;
import zendesk.android.pageviewevents.PageView;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;
import zendesk.logger.Logger;

@ZendeskInitializedComponentScope
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 22\u00020\u0001:\u00012BO\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020!H\u0002J\u001b\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0004\b#\u0010$J/\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020'2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)2\u0006\u0010\u001f\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020!H\u0002J\u001f\u0010-\u001a\u00020!2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H@ø\u0001\u0000¢\u0006\u0002\u0010.J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\b\u00101\u001a\u00020!H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R.\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u00158\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingManager;", "", "processLifecycleObserver", "Lzendesk/core/android/internal/app/ProcessLifecycleObserver;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "localeProvider", "Lzendesk/android/internal/proactivemessaging/LocaleProvider;", "visitTypeProvider", "Lzendesk/android/internal/proactivemessaging/VisitTypeProvider;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "proactiveMessagingRepository", "Lzendesk/android/internal/proactivemessaging/ProactiveMessagingRepository;", "currentTimeProvider", "Lkotlin/Function0;", "", "proactiveMessagingAnalyticsManager", "Lzendesk/android/internal/frontendevents/analyticsevents/ProactiveMessagingAnalyticsManager;", "(Lzendesk/core/android/internal/app/ProcessLifecycleObserver;Lkotlinx/coroutines/CoroutineScope;Lzendesk/android/internal/proactivemessaging/LocaleProvider;Lzendesk/android/internal/proactivemessaging/VisitTypeProvider;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/android/internal/proactivemessaging/ProactiveMessagingRepository;Lkotlin/jvm/functions/Function0;Lzendesk/android/internal/frontendevents/analyticsevents/ProactiveMessagingAnalyticsManager;)V", "evaluationStatesByPageView", "", "Lzendesk/android/pageviewevents/PageView;", "", "Lzendesk/android/internal/proactivemessaging/EvaluationState;", "getEvaluationStatesByPageView$zendesk_zendesk_android$annotations", "()V", "getEvaluationStatesByPageView$zendesk_zendesk_android", "()Ljava/util/Map;", "areAllJobsCompleted", "", "event", "clearAllTimers", "", "evaluate", "evaluate$zendesk_zendesk_android", "(Lzendesk/android/pageviewevents/PageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateTrigger", "trigger", "Lzendesk/android/internal/proactivemessaging/model/Trigger;", "evaluationResults", "", "Lzendesk/android/internal/proactivemessaging/EvaluationResult;", "(Lzendesk/android/internal/proactivemessaging/model/Trigger;Ljava/util/List;Lzendesk/android/pageviewevents/PageView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "reportToCts", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resume", "resumeAllTimers", "stopAllTimers", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessagingManager.kt */
public final class ProactiveMessagingManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "PM-Manager";
    private final ConversationKit conversationKit;
    private final CoroutineScope coroutineScope;
    private final Function0<Long> currentTimeProvider;
    private final Map<PageView, List<EvaluationState>> evaluationStatesByPageView = new LinkedHashMap();
    private final LocaleProvider localeProvider;
    private final ProactiveMessagingRepository proactiveMessagingRepository;
    /* access modifiers changed from: private */
    public final ProcessLifecycleObserver processLifecycleObserver;
    private final VisitTypeProvider visitTypeProvider;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessagingManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TriggerType.values().length];
            iArr[TriggerType.ON_PAGE.ordinal()] = 1;
            iArr[TriggerType.LOAD_PAGE.ordinal()] = 2;
            iArr[TriggerType.UNKNOWN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getEvaluationStatesByPageView$zendesk_zendesk_android$annotations() {
    }

    @Inject
    public ProactiveMessagingManager(ProcessLifecycleObserver processLifecycleObserver2, CoroutineScope coroutineScope2, LocaleProvider localeProvider2, VisitTypeProvider visitTypeProvider2, ConversationKit conversationKit2, ProactiveMessagingRepository proactiveMessagingRepository2, @Named("CURRENT_TIME_PROVIDER") Function0<Long> function0, ProactiveMessagingAnalyticsManager proactiveMessagingAnalyticsManager) {
        Intrinsics.checkNotNullParameter(processLifecycleObserver2, "processLifecycleObserver");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(localeProvider2, "localeProvider");
        Intrinsics.checkNotNullParameter(visitTypeProvider2, "visitTypeProvider");
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        Intrinsics.checkNotNullParameter(proactiveMessagingRepository2, "proactiveMessagingRepository");
        Intrinsics.checkNotNullParameter(function0, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(proactiveMessagingAnalyticsManager, "proactiveMessagingAnalyticsManager");
        this.processLifecycleObserver = processLifecycleObserver2;
        this.coroutineScope = coroutineScope2;
        this.localeProvider = localeProvider2;
        this.visitTypeProvider = visitTypeProvider2;
        this.conversationKit = conversationKit2;
        this.proactiveMessagingRepository = proactiveMessagingRepository2;
        this.currentTimeProvider = function0;
        if (Companion.isProactiveMessagingEnabled$zendesk_zendesk_android()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            proactiveMessagingAnalyticsManager.subscribe();
        }
    }

    public final Map<PageView, List<EvaluationState>> getEvaluationStatesByPageView$zendesk_zendesk_android() {
        return this.evaluationStatesByPageView;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$1", f = "ProactiveMessagingManager.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$1  reason: invalid class name */
    /* compiled from: ProactiveMessagingManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ProactiveMessagingManager this$0;

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
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> isInForeground = this.this$0.processLifecycleObserver.isInForeground();
                final ProactiveMessagingManager proactiveMessagingManager = this.this$0;
                this.label = 1;
                if (isInForeground.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        if (z) {
                            proactiveMessagingManager.resume();
                        } else {
                            proactiveMessagingManager.pause();
                        }
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object evaluate$zendesk_zendesk_android(zendesk.android.pageviewevents.PageView r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$evaluate$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$evaluate$1 r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$evaluate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$evaluate$1 r0 = new zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$evaluate$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 != r3) goto L_0x0038
            java.lang.Object r9 = r0.L$2
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r2 = r0.L$1
            zendesk.android.pageviewevents.PageView r2 = (zendesk.android.pageviewevents.PageView) r2
            java.lang.Object r4 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager r4 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager) r4
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r2
            goto L_0x0109
        L_0x0038:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.String r10 = java.lang.String.valueOf(r9)
            r2 = 0
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "PM-Manager"
            zendesk.logger.Logger.d(r5, r10, r4)
            boolean r10 = r8.areAllJobsCompleted(r9)
            if (r10 == 0) goto L_0x0133
            r8.clearAllTimers()
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r10 = r8.proactiveMessagingRepository
            java.util.List r10 = r10.getCampaignsForEvaluation()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r4)
            r2.<init>(r4)
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x0071:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x0096
            java.lang.Object r4 = r10.next()
            zendesk.android.internal.proactivemessaging.model.Campaign r4 = (zendesk.android.internal.proactivemessaging.model.Campaign) r4
            zendesk.android.internal.proactivemessaging.LocaleProvider r5 = r8.localeProvider
            java.util.Locale r5 = r5.getLocale()
            zendesk.android.internal.proactivemessaging.VisitTypeProvider r6 = r8.visitTypeProvider
            zendesk.conversationkit.android.model.VisitType r6 = r6.getVisitType$zendesk_zendesk_android()
            java.util.List r5 = r4.evaluate(r9, r5, r6)
            zendesk.android.internal.proactivemessaging.EvaluationResult r6 = new zendesk.android.internal.proactivemessaging.EvaluationResult
            r6.<init>(r4, r5, r9)
            r2.add(r6)
            goto L_0x0071
        L_0x0096:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r2 = r2.iterator()
        L_0x00a5:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x00c3
            java.lang.Object r4 = r2.next()
            r5 = r4
            zendesk.android.internal.proactivemessaging.EvaluationResult r5 = (zendesk.android.internal.proactivemessaging.EvaluationResult) r5
            java.util.List r5 = r5.getSuccessfulPaths()
            java.util.Collection r5 = (java.util.Collection) r5
            boolean r5 = r5.isEmpty()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x00a5
            r10.add(r4)
            goto L_0x00a5
        L_0x00c3:
            java.util.List r10 = (java.util.List) r10
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            java.util.Map r2 = (java.util.Map) r2
            java.util.Iterator r10 = r10.iterator()
        L_0x00d2:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto L_0x00fd
            java.lang.Object r4 = r10.next()
            r5 = r4
            zendesk.android.internal.proactivemessaging.EvaluationResult r5 = (zendesk.android.internal.proactivemessaging.EvaluationResult) r5
            zendesk.android.internal.proactivemessaging.model.Campaign r5 = r5.getCampaign()
            zendesk.android.internal.proactivemessaging.model.Trigger r5 = r5.getTrigger()
            java.lang.Object r6 = r2.get(r5)
            if (r6 != 0) goto L_0x00f7
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.List r6 = (java.util.List) r6
            r2.put(r5, r6)
        L_0x00f7:
            java.util.List r6 = (java.util.List) r6
            r6.add(r4)
            goto L_0x00d2
        L_0x00fd:
            java.util.Set r10 = r2.entrySet()
            java.util.Iterator r10 = r10.iterator()
            r4 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0109:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0130
            java.lang.Object r2 = r9.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r5 = r2.getKey()
            zendesk.android.internal.proactivemessaging.model.Trigger r5 = (zendesk.android.internal.proactivemessaging.model.Trigger) r5
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            r0.L$0 = r4
            r0.L$1 = r10
            r0.L$2 = r9
            r0.label = r3
            java.lang.Object r2 = r4.evaluateTrigger(r5, r2, r10, r0)
            if (r2 != r1) goto L_0x0109
            return r1
        L_0x0130:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0133:
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Jobs are still running, returning early"
            zendesk.logger.Logger.d(r5, r10, r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingManager.evaluate$zendesk_zendesk_android(zendesk.android.pageviewevents.PageView, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean areAllJobsCompleted(PageView pageView) {
        List list = this.evaluationStatesByPageView.get(pageView);
        if (!(list != null && (list.isEmpty() ^ true))) {
            return true;
        }
        boolean z = true;
        for (PageView pageView2 : this.evaluationStatesByPageView.keySet()) {
            List<EvaluationState> list2 = this.evaluationStatesByPageView.get(pageView2);
            if (list2 != null) {
                for (EvaluationState job : list2) {
                    z = job.getJob().isCompleted() && z;
                }
            }
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final Object evaluateTrigger(Trigger trigger, List<EvaluationResult> list, PageView pageView, Continuation<? super Unit> continuation) {
        List<EvaluationResult> list2 = list;
        PageView pageView2 = pageView;
        int i = WhenMappings.$EnumSwitchMapping$0[trigger.getType().ordinal()];
        if (i == 1) {
            Trigger trigger2 = trigger;
            EvaluationState evaluationState = new EvaluationState(list, BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProactiveMessagingManager$evaluateTrigger$job$1(trigger, this, list, (Continuation<? super ProactiveMessagingManager$evaluateTrigger$job$1>) null), 3, (Object) null), this.currentTimeProvider.invoke().longValue(), 0, 8, (DefaultConstructorMarker) null);
            List list3 = this.evaluationStatesByPageView.get(pageView);
            if (list3 == null) {
                list3 = new ArrayList();
            }
            list3.add(evaluationState);
            this.evaluationStatesByPageView.put(pageView, list3);
        } else if (i == 2) {
            Object reportToCts = reportToCts(list, continuation);
            return reportToCts == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? reportToCts : Unit.INSTANCE;
        } else if (i == 3) {
            Logger.d(LOG_TAG, "TriggerType UNKNOWN", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    private final void clearAllTimers() {
        stopAllTimers();
        this.evaluationStatesByPageView.clear();
    }

    /* access modifiers changed from: private */
    public final void pause() {
        Logger.d(LOG_TAG, "Paused", new Object[0]);
        stopAllTimers();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        r6 = (r6 = (r6 = r6.getCampaign()).getTrigger()).getDuration();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void stopAllTimers() {
        /*
            r8 = this;
            java.util.Map<zendesk.android.pageviewevents.PageView, java.util.List<zendesk.android.internal.proactivemessaging.EvaluationState>> r0 = r8.evaluationStatesByPageView
            java.util.Set r0 = r0.keySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r0.next()
            zendesk.android.pageviewevents.PageView r1 = (zendesk.android.pageviewevents.PageView) r1
            java.util.Map<zendesk.android.pageviewevents.PageView, java.util.List<zendesk.android.internal.proactivemessaging.EvaluationState>> r2 = r8.evaluationStatesByPageView
            java.lang.Object r1 = r2.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x000c
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0028:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x000c
            java.lang.Object r2 = r1.next()
            zendesk.android.internal.proactivemessaging.EvaluationState r2 = (zendesk.android.internal.proactivemessaging.EvaluationState) r2
            kotlin.jvm.functions.Function0<java.lang.Long> r3 = r8.currentTimeProvider
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            long r3 = r3.longValue()
            long r5 = r2.getStartTime()
            long r3 = r3 - r5
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            java.util.List r6 = r2.getEvaluationResults()
            java.lang.Object r6 = kotlin.collections.CollectionsKt.firstOrNull(r6)
            zendesk.android.internal.proactivemessaging.EvaluationResult r6 = (zendesk.android.internal.proactivemessaging.EvaluationResult) r6
            if (r6 == 0) goto L_0x006b
            zendesk.android.internal.proactivemessaging.model.Campaign r6 = r6.getCampaign()
            if (r6 == 0) goto L_0x006b
            zendesk.android.internal.proactivemessaging.model.Trigger r6 = r6.getTrigger()
            if (r6 == 0) goto L_0x006b
            java.lang.Integer r6 = r6.getDuration()
            if (r6 == 0) goto L_0x006b
            int r6 = r6.intValue()
            long r6 = (long) r6
            goto L_0x006d
        L_0x006b:
            r6 = 0
        L_0x006d:
            long r5 = r5.toMillis(r6)
            long r5 = r5 - r3
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r3 = r3.toSeconds(r5)
            r2.setRemainingSeconds(r3)
            kotlinx.coroutines.Job r2 = r2.getJob()
            r3 = 1
            r4 = 0
            kotlinx.coroutines.Job.DefaultImpls.cancel$default((kotlinx.coroutines.Job) r2, (java.util.concurrent.CancellationException) r4, (int) r3, (java.lang.Object) r4)
            goto L_0x0028
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingManager.stopAllTimers():void");
    }

    /* access modifiers changed from: private */
    public final void resume() {
        Logger.d(LOG_TAG, "Resumed", new Object[0]);
        resumeAllTimers();
    }

    private final void resumeAllTimers() {
        for (PageView pageView : this.evaluationStatesByPageView.keySet()) {
            List<EvaluationState> list = this.evaluationStatesByPageView.get(pageView);
            if (list != null) {
                for (EvaluationState evaluationState : list) {
                    if (evaluationState.getRemainingSeconds() > 0) {
                        evaluationState.setJob(BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ProactiveMessagingManager$resumeAllTimers$1$1$1(evaluationState, this, (Continuation<? super ProactiveMessagingManager$resumeAllTimers$1$1$1>) null), 3, (Object) null));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00fe A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0125 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object reportToCts(java.util.List<zendesk.android.internal.proactivemessaging.EvaluationResult> r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$reportToCts$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$reportToCts$1 r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$reportToCts$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$reportToCts$1 r0 = new zendesk.android.internal.proactivemessaging.ProactiveMessagingManager$reportToCts$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x005e
            if (r2 == r5) goto L_0x004e
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r14 = r0.L$1
            zendesk.conversationkit.android.model.ProactiveMessage r14 = (zendesk.conversationkit.android.model.ProactiveMessage) r14
            java.lang.Object r0 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager r0 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager) r0
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0127
        L_0x003a:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0042:
            java.lang.Object r14 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager r14 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager) r14
            kotlin.ResultKt.throwOnFailure(r15)
            r12 = r0
            r0 = r14
            r14 = r12
            goto L_0x0101
        L_0x004e:
            java.lang.Object r14 = r0.L$2
            java.util.Iterator r14 = (java.util.Iterator) r14
            java.lang.Object r2 = r0.L$1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r7 = r0.L$0
            zendesk.android.internal.proactivemessaging.ProactiveMessagingManager r7 = (zendesk.android.internal.proactivemessaging.ProactiveMessagingManager) r7
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x006a
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r15 = r14.iterator()
            r7 = r13
            r2 = r14
            r14 = r15
        L_0x006a:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x008b
            java.lang.Object r15 = r14.next()
            zendesk.android.internal.proactivemessaging.EvaluationResult r15 = (zendesk.android.internal.proactivemessaging.EvaluationResult) r15
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r8 = r7.proactiveMessagingRepository
            zendesk.android.internal.proactivemessaging.model.Campaign r15 = r15.getCampaign()
            r0.L$0 = r7
            r0.L$1 = r2
            r0.L$2 = r14
            r0.label = r5
            java.lang.Object r15 = r8.updateFilterOutCampaigns(r15, r0)
            if (r15 != r1) goto L_0x006a
            return r1
        L_0x008b:
            java.util.ArrayList r14 = new java.util.ArrayList
            r15 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r15)
            r14.<init>(r5)
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r2 = r2.iterator()
        L_0x009c:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x00ec
            java.lang.Object r5 = r2.next()
            zendesk.android.internal.proactivemessaging.EvaluationResult r5 = (zendesk.android.internal.proactivemessaging.EvaluationResult) r5
            zendesk.android.internal.proactivemessaging.model.Campaign r8 = r5.getCampaign()
            java.lang.String r8 = r8.getCampaignId()
            java.util.List r9 = r5.getSuccessfulPaths()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r15)
            r10.<init>(r11)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x00c5:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00d9
            java.lang.Object r11 = r9.next()
            zendesk.android.internal.proactivemessaging.model.Path r11 = (zendesk.android.internal.proactivemessaging.model.Path) r11
            java.lang.String r11 = r11.getPathId()
            r10.add(r11)
            goto L_0x00c5
        L_0x00d9:
            java.util.List r10 = (java.util.List) r10
            zendesk.android.internal.proactivemessaging.model.Campaign r5 = r5.getCampaign()
            int r5 = r5.getVersion()
            zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CampaignPathDto r9 = new zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CampaignPathDto
            r9.<init>(r8, r10, r5)
            r14.add(r9)
            goto L_0x009c
        L_0x00ec:
            java.util.List r14 = (java.util.List) r14
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r15 = r7.proactiveMessagingRepository
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r4
            java.lang.Object r15 = r15.getProactiveMessage(r14, r0)
            if (r15 != r1) goto L_0x00ff
            return r1
        L_0x00ff:
            r14 = r0
            r0 = r7
        L_0x0101:
            zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto r15 = (zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.CtsResponseDto) r15
            if (r15 == 0) goto L_0x0109
            java.lang.String r6 = r15.getJwt()
        L_0x0109:
            if (r6 == 0) goto L_0x013a
            zendesk.android.internal.proactivemessaging.ProactiveMessagingRepository r2 = r0.proactiveMessagingRepository
            java.lang.String r15 = r15.getJwt()
            zendesk.conversationkit.android.model.ProactiveMessage r15 = r2.buildProactiveMessage(r15)
            if (r15 == 0) goto L_0x013a
            zendesk.conversationkit.android.ConversationKit r2 = r0.conversationKit
            r14.L$0 = r0
            r14.L$1 = r15
            r14.label = r3
            java.lang.Object r14 = r2.addProactiveMessage(r15, r14)
            if (r14 != r1) goto L_0x0126
            return r1
        L_0x0126:
            r14 = r15
        L_0x0127:
            zendesk.conversationkit.android.ConversationKit r15 = r0.conversationKit
            zendesk.conversationkit.android.ConversationKitEvent$ProactiveMessageStatusChanged r0 = new zendesk.conversationkit.android.ConversationKitEvent$ProactiveMessageStatusChanged
            zendesk.conversationkit.android.model.ProactiveMessageStatus$NotificationWillDisplay r1 = new zendesk.conversationkit.android.model.ProactiveMessageStatus$NotificationWillDisplay
            r1.<init>(r14)
            zendesk.conversationkit.android.model.ProactiveMessageStatus r1 = (zendesk.conversationkit.android.model.ProactiveMessageStatus) r1
            r0.<init>(r1)
            zendesk.conversationkit.android.ConversationKitEvent r0 = (zendesk.conversationkit.android.ConversationKitEvent) r0
            r15.dispatchEvent(r0)
        L_0x013a:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.ProactiveMessagingManager.reportToCts(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/android/internal/proactivemessaging/ProactiveMessagingManager$Companion;", "", "()V", "LOG_TAG", "", "isProactiveMessagingEnabled", "", "isProactiveMessagingEnabled$zendesk_zendesk_android", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProactiveMessagingManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isProactiveMessagingEnabled$zendesk_zendesk_android() {
            return false;
        }

        private Companion() {
        }
    }
}
