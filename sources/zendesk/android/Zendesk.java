package zendesk.android;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import zendesk.android.events.ZendeskEventListener;
import zendesk.android.events.internal.ZendeskEventDispatcher;
import zendesk.android.internal.NotInitializedConversationKit;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.frontendevents.pageviewevents.NotInitializedPageViewEvents;
import zendesk.android.internal.frontendevents.pageviewevents.PageViewEvents;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.MessagingFactory;
import zendesk.android.messaging.internal.NotInitializedMessaging;
import zendesk.android.pageviewevents.PageView;
import zendesk.conversationkit.android.ConversationKit;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B/\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J%\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\u0006\u0010\u0018\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ*\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eJ\u001d\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00170\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010 J\"\u0010\u001f\u001a\u00020\u00112\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eJ\u000e\u0010!\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J*\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0004\n\u0002\b\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lzendesk/android/Zendesk;", "", "messaging", "Lzendesk/android/messaging/Messaging;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "eventDispatcher", "Lzendesk/android/events/internal/ZendeskEventDispatcher;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "pageViewEvents", "Lzendesk/android/internal/frontendevents/pageviewevents/PageViewEvents;", "(Lzendesk/android/messaging/Messaging;Lkotlinx/coroutines/CoroutineScope;Lzendesk/android/events/internal/ZendeskEventDispatcher;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/android/internal/frontendevents/pageviewevents/PageViewEvents;)V", "getMessaging", "()Lzendesk/android/messaging/Messaging;", "scope$1", "addEventListener", "", "listener", "Lzendesk/android/events/ZendeskEventListener;", "loginUser", "Lzendesk/android/ZendeskResult;", "Lzendesk/android/ZendeskUser;", "", "jwt", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "successCallback", "Lzendesk/android/SuccessCallback;", "failureCallback", "Lzendesk/android/FailureCallback;", "logoutUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeEventListener", "sendPageView", "pageView", "Lzendesk/android/pageviewevents/PageView;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: Zendesk.kt */
public final class Zendesk {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG = "Zendesk";
    /* access modifiers changed from: private */
    public static final Mutex initializeMutex = MutexKt.Mutex$default(false, 1, (Object) null);
    /* access modifiers changed from: private */
    public static CoroutineScope scope;
    /* access modifiers changed from: private */
    public static final CompletableJob supervisorJob;
    /* access modifiers changed from: private */

    /* renamed from: zendesk  reason: collision with root package name */
    public static Zendesk f39zendesk;
    private final ConversationKit conversationKit;
    /* access modifiers changed from: private */
    public final ZendeskEventDispatcher eventDispatcher;
    private final Messaging messaging;
    /* access modifiers changed from: private */
    public final PageViewEvents pageViewEvents;
    private final CoroutineScope scope$1;

    public static final Zendesk getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void initialize(Context context, String str, SuccessCallback<Zendesk> successCallback, FailureCallback<Throwable> failureCallback) {
        Companion.initialize(context, str, successCallback, failureCallback);
    }

    @JvmStatic
    public static final void initialize(Context context, String str, SuccessCallback<Zendesk> successCallback, FailureCallback<Throwable> failureCallback, MessagingFactory messagingFactory) {
        Companion.initialize(context, str, successCallback, failureCallback, messagingFactory);
    }

    @JvmStatic
    public static final void invalidate() {
        Companion.invalidate();
    }

    @Inject
    public Zendesk(Messaging messaging2, CoroutineScope coroutineScope, ZendeskEventDispatcher zendeskEventDispatcher, ConversationKit conversationKit2, PageViewEvents pageViewEvents2) {
        Intrinsics.checkNotNullParameter(messaging2, "messaging");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(zendeskEventDispatcher, "eventDispatcher");
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        Intrinsics.checkNotNullParameter(pageViewEvents2, "pageViewEvents");
        this.messaging = messaging2;
        this.scope$1 = coroutineScope;
        this.eventDispatcher = zendeskEventDispatcher;
        this.conversationKit = conversationKit2;
        this.pageViewEvents = pageViewEvents2;
    }

    public final Messaging getMessaging() {
        return this.messaging;
    }

    public final void addEventListener(ZendeskEventListener zendeskEventListener) {
        Intrinsics.checkNotNullParameter(zendeskEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope$1, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$addEventListener$1(this, zendeskEventListener, (Continuation<? super Zendesk$addEventListener$1>) null), 3, (Object) null);
    }

    public final void removeEventListener(ZendeskEventListener zendeskEventListener) {
        Intrinsics.checkNotNullParameter(zendeskEventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope$1, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$removeEventListener$1(this, zendeskEventListener, (Continuation<? super Zendesk$removeEventListener$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object loginUser(java.lang.String r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof zendesk.android.Zendesk$loginUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            zendesk.android.Zendesk$loginUser$1 r0 = (zendesk.android.Zendesk$loginUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            zendesk.android.Zendesk$loginUser$1 r0 = new zendesk.android.Zendesk$loginUser$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            zendesk.conversationkit.android.ConversationKit r6 = r4.conversationKit
            r0.label = r3
            java.lang.Object r6 = r6.loginUser(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.ConversationKitResult r6 = (zendesk.conversationkit.android.ConversationKitResult) r6
            boolean r5 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r5 == 0) goto L_0x0054
            zendesk.android.ZendeskResult$Failure r5 = new zendesk.android.ZendeskResult$Failure
            zendesk.conversationkit.android.ConversationKitResult$Failure r6 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r6
            java.lang.Throwable r6 = r6.getCause()
            r5.<init>(r6)
            zendesk.android.ZendeskResult r5 = (zendesk.android.ZendeskResult) r5
            goto L_0x006b
        L_0x0054:
            boolean r5 = r6 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r5 == 0) goto L_0x006c
            zendesk.android.ZendeskResult$Success r5 = new zendesk.android.ZendeskResult$Success
            zendesk.conversationkit.android.ConversationKitResult$Success r6 = (zendesk.conversationkit.android.ConversationKitResult.Success) r6
            java.lang.Object r6 = r6.getValue()
            zendesk.conversationkit.android.model.User r6 = (zendesk.conversationkit.android.model.User) r6
            zendesk.android.ZendeskUser r6 = zendesk.android.ZendeskUserKt.toZendeskUser(r6)
            r5.<init>(r6)
            zendesk.android.ZendeskResult r5 = (zendesk.android.ZendeskResult) r5
        L_0x006b:
            return r5
        L_0x006c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.Zendesk.loginUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void loginUser(String str, SuccessCallback<ZendeskUser> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(str, "jwt");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope$1, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$loginUser$2(this, str, failureCallback, successCallback, (Continuation<? super Zendesk$loginUser$2>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object logoutUser(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof zendesk.android.Zendesk$logoutUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            zendesk.android.Zendesk$logoutUser$1 r0 = (zendesk.android.Zendesk$logoutUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            zendesk.android.Zendesk$logoutUser$1 r0 = new zendesk.android.Zendesk$logoutUser$1
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
            zendesk.conversationkit.android.ConversationKit r5 = r4.conversationKit
            r0.label = r3
            java.lang.Object r5 = r5.logoutUser(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            zendesk.conversationkit.android.ConversationKitResult r5 = (zendesk.conversationkit.android.ConversationKitResult) r5
            boolean r0 = r5 instanceof zendesk.conversationkit.android.ConversationKitResult.Failure
            if (r0 == 0) goto L_0x0054
            zendesk.android.ZendeskResult$Failure r0 = new zendesk.android.ZendeskResult$Failure
            zendesk.conversationkit.android.ConversationKitResult$Failure r5 = (zendesk.conversationkit.android.ConversationKitResult.Failure) r5
            java.lang.Throwable r5 = r5.getCause()
            r0.<init>(r5)
            zendesk.android.ZendeskResult r0 = (zendesk.android.ZendeskResult) r0
            goto L_0x0066
        L_0x0054:
            boolean r0 = r5 instanceof zendesk.conversationkit.android.ConversationKitResult.Success
            if (r0 == 0) goto L_0x0067
            zendesk.android.ZendeskResult$Success r0 = new zendesk.android.ZendeskResult$Success
            zendesk.conversationkit.android.ConversationKitResult$Success r5 = (zendesk.conversationkit.android.ConversationKitResult.Success) r5
            r5.getValue()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r0.<init>(r5)
            zendesk.android.ZendeskResult r0 = (zendesk.android.ZendeskResult) r0
        L_0x0066:
            return r0
        L_0x0067:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.Zendesk.logoutUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void logoutUser(SuccessCallback<Unit> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope$1, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$logoutUser$2(this, failureCallback, successCallback, (Continuation<? super Zendesk$logoutUser$2>) null), 3, (Object) null);
    }

    public final void sendPageView(PageView pageView, SuccessCallback<Unit> successCallback, FailureCallback<Throwable> failureCallback) {
        Intrinsics.checkNotNullParameter(pageView, "pageView");
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope$1, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$sendPageView$1(this, pageView, failureCallback, successCallback, (Continuation<? super Zendesk$sendPageView$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J9\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001a0\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\b8FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lzendesk/android/Zendesk$Companion;", "", "()V", "LOG_TAG", "", "initializeMutex", "Lkotlinx/coroutines/sync/Mutex;", "instance", "Lzendesk/android/Zendesk;", "getInstance$annotations", "getInstance", "()Lzendesk/android/Zendesk;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "supervisorJob", "Lkotlinx/coroutines/CompletableJob;", "zendesk", "initialize", "", "context", "Landroid/content/Context;", "channelKey", "successCallback", "Lzendesk/android/SuccessCallback;", "failureCallback", "Lzendesk/android/FailureCallback;", "", "messagingFactory", "Lzendesk/android/messaging/MessagingFactory;", "Lzendesk/android/ZendeskResult;", "(Landroid/content/Context;Ljava/lang/String;Lzendesk/android/messaging/MessagingFactory;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Zendesk.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @JvmStatic
        public final void initialize(Context context, String str, SuccessCallback<Zendesk> successCallback, FailureCallback<Throwable> failureCallback) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelKey");
            Intrinsics.checkNotNullParameter(successCallback, "successCallback");
            Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
            initialize$default(this, context, str, successCallback, failureCallback, (MessagingFactory) null, 16, (Object) null);
        }

        private Companion() {
        }

        public final Zendesk getInstance() {
            Zendesk access$getZendesk$cp = Zendesk.f39zendesk;
            return access$getZendesk$cp == null ? new Zendesk(NotInitializedMessaging.INSTANCE, Zendesk.scope, new ZendeskEventDispatcher(Dispatchers.getMain()), NotInitializedConversationKit.INSTANCE, NotInitializedPageViewEvents.INSTANCE) : access$getZendesk$cp;
        }

        public static /* synthetic */ void initialize$default(Companion companion, Context context, String str, SuccessCallback successCallback, FailureCallback failureCallback, MessagingFactory messagingFactory, int i, Object obj) {
            if ((i & 16) != 0) {
                messagingFactory = null;
            }
            companion.initialize(context, str, successCallback, failureCallback, messagingFactory);
        }

        @JvmStatic
        public final void initialize(Context context, String str, SuccessCallback<Zendesk> successCallback, FailureCallback<Throwable> failureCallback, MessagingFactory messagingFactory) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "channelKey");
            Intrinsics.checkNotNullParameter(successCallback, "successCallback");
            Intrinsics.checkNotNullParameter(failureCallback, "failureCallback");
            Job unused = BuildersKt__Builders_commonKt.launch$default(Zendesk.scope, (CoroutineContext) null, (CoroutineStart) null, new Zendesk$Companion$initialize$1(context, str, messagingFactory, failureCallback, successCallback, (Continuation<? super Zendesk$Companion$initialize$1>) null), 3, (Object) null);
        }

        public static /* synthetic */ Object initialize$default(Companion companion, Context context, String str, MessagingFactory messagingFactory, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                messagingFactory = null;
            }
            return companion.initialize(context, str, messagingFactory, continuation);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: zendesk.android.messaging.MessagingFactory} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0073 A[Catch:{ all -> 0x00ef }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0085 A[SYNTHETIC, Splitter:B:24:0x0085] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00ca A[Catch:{ all -> 0x0033 }] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object initialize(android.content.Context r9, java.lang.String r10, zendesk.android.messaging.MessagingFactory r11, kotlin.coroutines.Continuation r12) {
            /*
                r8 = this;
                boolean r0 = r12 instanceof zendesk.android.Zendesk$Companion$initialize$2
                if (r0 == 0) goto L_0x0014
                r0 = r12
                zendesk.android.Zendesk$Companion$initialize$2 r0 = (zendesk.android.Zendesk$Companion$initialize$2) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r12 = r0.label
                int r12 = r12 - r2
                r0.label = r12
                goto L_0x0019
            L_0x0014:
                zendesk.android.Zendesk$Companion$initialize$2 r0 = new zendesk.android.Zendesk$Companion$initialize$2
                r0.<init>(r8, r12)
            L_0x0019:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x0055
                if (r2 == r4) goto L_0x003e
                if (r2 != r3) goto L_0x0036
                java.lang.Object r9 = r0.L$0
                kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
                kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0033 }
                goto L_0x00c4
            L_0x0033:
                r10 = move-exception
                goto L_0x00de
            L_0x0036:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L_0x003e:
                java.lang.Object r9 = r0.L$3
                kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
                java.lang.Object r10 = r0.L$2
                r11 = r10
                zendesk.android.messaging.MessagingFactory r11 = (zendesk.android.messaging.MessagingFactory) r11
                java.lang.Object r10 = r0.L$1
                java.lang.String r10 = (java.lang.String) r10
                java.lang.Object r2 = r0.L$0
                android.content.Context r2 = (android.content.Context) r2
                kotlin.ResultKt.throwOnFailure(r12)
                r12 = r9
                r9 = r2
                goto L_0x006d
            L_0x0055:
                kotlin.ResultKt.throwOnFailure(r12)
                kotlinx.coroutines.sync.Mutex r12 = zendesk.android.Zendesk.initializeMutex
                r0.L$0 = r9
                r0.L$1 = r10
                r0.L$2 = r11
                r0.L$3 = r12
                r0.label = r4
                java.lang.Object r2 = r12.lock(r5, r0)
                if (r2 != r1) goto L_0x006d
                return r1
            L_0x006d:
                zendesk.android.Zendesk r2 = zendesk.android.Zendesk.f39zendesk     // Catch:{ all -> 0x00ef }
                if (r2 == 0) goto L_0x0085
                java.lang.String r9 = "Zendesk"
                java.lang.String r10 = "Zendesk.initialize was already called, returning early."
                r11 = 0
                java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ all -> 0x00ef }
                zendesk.logger.Logger.i(r9, r10, r11)     // Catch:{ all -> 0x00ef }
                zendesk.android.ZendeskResult$Success r9 = new zendesk.android.ZendeskResult$Success     // Catch:{ all -> 0x00ef }
                r9.<init>(r2)     // Catch:{ all -> 0x00ef }
                zendesk.android.ZendeskResult r9 = (zendesk.android.ZendeskResult) r9     // Catch:{ all -> 0x00ef }
                goto L_0x00e7
            L_0x0085:
                zendesk.android.ZendeskCredentials$Companion r2 = zendesk.android.ZendeskCredentials.Companion     // Catch:{ all -> 0x00dc }
                zendesk.android.ZendeskCredentials$Builder r10 = r2.builder(r10)     // Catch:{ all -> 0x00dc }
                zendesk.android.ZendeskCredentials r10 = r10.build()     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.di.ZendeskComponentConfig r10 = zendesk.android.ZendeskCredentialsKt.getZendeskComponentConfig(r10)     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.di.DaggerZendeskComponent$Builder r2 = zendesk.android.internal.di.DaggerZendeskComponent.builder()     // Catch:{ all -> 0x00dc }
                kotlinx.coroutines.CoroutineScope r4 = zendesk.android.Zendesk.scope     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.di.ZendeskModule r6 = new zendesk.android.internal.di.ZendeskModule     // Catch:{ all -> 0x00dc }
                r6.<init>(r9, r4, r10)     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.di.DaggerZendeskComponent$Builder r9 = r2.zendeskModule(r6)     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.di.ZendeskComponent r9 = r9.build()     // Catch:{ all -> 0x00dc }
                zendesk.android.internal.ZendeskFactory r10 = zendesk.android.internal.ZendeskFactory.INSTANCE     // Catch:{ all -> 0x00dc }
                java.lang.String r2 = "zendeskComponent"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)     // Catch:{ all -> 0x00dc }
                r0.L$0 = r12     // Catch:{ all -> 0x00dc }
                r0.L$1 = r5     // Catch:{ all -> 0x00dc }
                r0.L$2 = r5     // Catch:{ all -> 0x00dc }
                r0.L$3 = r5     // Catch:{ all -> 0x00dc }
                r0.label = r3     // Catch:{ all -> 0x00dc }
                java.lang.Object r9 = r10.create(r9, r11, r0)     // Catch:{ all -> 0x00dc }
                if (r9 != r1) goto L_0x00c1
                return r1
            L_0x00c1:
                r7 = r12
                r12 = r9
                r9 = r7
            L_0x00c4:
                zendesk.android.ZendeskResult r12 = (zendesk.android.ZendeskResult) r12     // Catch:{ all -> 0x0033 }
                boolean r10 = r12 instanceof zendesk.android.ZendeskResult.Success     // Catch:{ all -> 0x0033 }
                if (r10 == 0) goto L_0x00d8
                zendesk.android.Zendesk$Companion r10 = zendesk.android.Zendesk.Companion     // Catch:{ all -> 0x0033 }
                r10 = r12
                zendesk.android.ZendeskResult$Success r10 = (zendesk.android.ZendeskResult.Success) r10     // Catch:{ all -> 0x0033 }
                java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0033 }
                zendesk.android.Zendesk r10 = (zendesk.android.Zendesk) r10     // Catch:{ all -> 0x0033 }
                zendesk.android.Zendesk.f39zendesk = r10     // Catch:{ all -> 0x0033 }
            L_0x00d8:
                r7 = r12
                r12 = r9
                r9 = r7
                goto L_0x00e7
            L_0x00dc:
                r10 = move-exception
                r9 = r12
            L_0x00de:
                zendesk.android.ZendeskResult$Failure r11 = new zendesk.android.ZendeskResult$Failure     // Catch:{ all -> 0x00eb }
                r11.<init>(r10)     // Catch:{ all -> 0x00eb }
                zendesk.android.ZendeskResult r11 = (zendesk.android.ZendeskResult) r11     // Catch:{ all -> 0x00eb }
                r12 = r9
                r9 = r11
            L_0x00e7:
                r12.unlock(r5)
                return r9
            L_0x00eb:
                r10 = move-exception
                r12 = r9
                r9 = r10
                goto L_0x00f0
            L_0x00ef:
                r9 = move-exception
            L_0x00f0:
                r12.unlock(r5)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.android.Zendesk.Companion.initialize(android.content.Context, java.lang.String, zendesk.android.messaging.MessagingFactory, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @JvmStatic
        public final void invalidate() {
            JobKt__JobKt.cancelChildren$default((Job) Zendesk.supervisorJob, (CancellationException) null, 1, (Object) null);
            Zendesk.f39zendesk = null;
        }
    }

    static {
        CompletableJob SupervisorJob$default = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null);
        supervisorJob = SupervisorJob$default;
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorJob$default));
    }
}
