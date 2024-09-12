package zendesk.messaging.android.internal.conversationscreen;

import android.content.ActivityNotFoundException;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.android.messaging.MessagingScreen;
import zendesk.android.messaging.UrlSource;
import zendesk.logger.Logger;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.AttachmentIntents;
import zendesk.messaging.android.internal.ScreenStateStore;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.conversationscreen.permissions.RuntimePermission;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010%\u001a\u00020\u0017H\u0002J\u0012\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0014J\b\u0010)\u001a\u00020\u0017H\u0014J\b\u0010*\u001a\u00020\u0017H\u0014J\u0011\u0010+\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010,R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lzendesk/android/messaging/MessagingScreen;", "()V", "attachmentIntents", "Lzendesk/messaging/android/internal/AttachmentIntents;", "getAttachmentIntents", "()Lzendesk/messaging/android/internal/AttachmentIntents;", "attachmentIntents$delegate", "Lkotlin/Lazy;", "conversationScreenCoordinator", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenCoordinator;", "conversationScreenViewModel", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationScreenViewModelFactory", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "getConversationScreenViewModelFactory", "()Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "setConversationScreenViewModelFactory", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;)V", "onAttachButtonClicked", "Lkotlin/Function1;", "", "", "onBackButtonClickedHandler", "Lkotlin/Function0;", "onDeniedPermissionActionClicked", "runtimePermission", "Lzendesk/messaging/android/internal/conversationscreen/permissions/RuntimePermission;", "sdkCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getSdkCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setSdkCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "uriHandler", "Lzendesk/messaging/android/internal/UriHandler;", "errorHandler", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setupConversationScreenViewModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationActivity.kt */
public final class ConversationActivity extends AppCompatActivity implements MessagingScreen {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String INTENT_URI_SCHEMA = "package";
    @Deprecated
    private static final String LOG_TAG = "MessagingConversationActivity";
    private final Lazy attachmentIntents$delegate = LazyKt.lazy(new ConversationActivity$attachmentIntents$2(this));
    /* access modifiers changed from: private */
    public ConversationScreenCoordinator conversationScreenCoordinator;
    /* access modifiers changed from: private */
    public ConversationScreenViewModel conversationScreenViewModel;
    @Inject
    public ConversationScreenViewModelFactory conversationScreenViewModelFactory;
    /* access modifiers changed from: private */
    public final Function1<Integer, Unit> onAttachButtonClicked = new ConversationActivity$onAttachButtonClicked$1(this);
    /* access modifiers changed from: private */
    public final Function0<Unit> onBackButtonClickedHandler = new ConversationActivity$onBackButtonClickedHandler$1(this);
    /* access modifiers changed from: private */
    public final Function0<Unit> onDeniedPermissionActionClicked = new ConversationActivity$onDeniedPermissionActionClicked$1(this);
    /* access modifiers changed from: private */
    public final RuntimePermission runtimePermission = new RuntimePermission(this);
    @Inject
    public CoroutineScope sdkCoroutineScope;
    /* access modifiers changed from: private */
    public final UriHandler uriHandler = new ConversationActivity$$ExternalSyntheticLambda0(this);

    public final ConversationScreenViewModelFactory getConversationScreenViewModelFactory() {
        ConversationScreenViewModelFactory conversationScreenViewModelFactory2 = this.conversationScreenViewModelFactory;
        if (conversationScreenViewModelFactory2 != null) {
            return conversationScreenViewModelFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("conversationScreenViewModelFactory");
        return null;
    }

    public final void setConversationScreenViewModelFactory(ConversationScreenViewModelFactory conversationScreenViewModelFactory2) {
        Intrinsics.checkNotNullParameter(conversationScreenViewModelFactory2, "<set-?>");
        this.conversationScreenViewModelFactory = conversationScreenViewModelFactory2;
    }

    public final CoroutineScope getSdkCoroutineScope() {
        CoroutineScope coroutineScope = this.sdkCoroutineScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sdkCoroutineScope");
        return null;
    }

    public final void setSdkCoroutineScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.sdkCoroutineScope = coroutineScope;
    }

    /* access modifiers changed from: private */
    /* renamed from: uriHandler$lambda-0  reason: not valid java name */
    public static final void m688uriHandler$lambda0(ConversationActivity conversationActivity, String str, UrlSource urlSource) {
        Intrinsics.checkNotNullParameter(conversationActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "uri");
        Intrinsics.checkNotNullParameter(urlSource, "source");
        try {
            ConversationScreenCoordinator conversationScreenCoordinator2 = conversationActivity.conversationScreenCoordinator;
            if (conversationScreenCoordinator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationScreenCoordinator");
                conversationScreenCoordinator2 = null;
            }
            conversationScreenCoordinator2.handleUri(str, urlSource, new ConversationActivity$uriHandler$1$1(urlSource, conversationActivity, str));
        } catch (UninitializedPropertyAccessException e) {
            Logger.e(LOG_TAG, "conversationScreenCoordinator was not initialized, unable to handle " + str, e, new Object[0]);
        } catch (ActivityNotFoundException e2) {
            Logger.e(LOG_TAG, "Failed to launch the ACTION_VIEW intent for : " + str, e2, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    public final AttachmentIntents getAttachmentIntents() {
        return (AttachmentIntents) this.attachmentIntents$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.zma_screen_conversation);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConversationActivity$onCreate$1(this, (Continuation<? super ConversationActivity$onCreate$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        ScreenStateStore.INSTANCE.setAsVisibleMessagingScreen$zendesk_messaging_messaging_android(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (!isChangingConfigurations()) {
            ConversationScreenCoordinator conversationScreenCoordinator2 = this.conversationScreenCoordinator;
            if (conversationScreenCoordinator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("conversationScreenCoordinator");
                conversationScreenCoordinator2 = null;
            }
            conversationScreenCoordinator2.clearNewMessagesDivider$zendesk_messaging_messaging_android();
        }
        ScreenStateStore.INSTANCE.clearAsVisibleMessagingScreen$zendesk_messaging_messaging_android(this);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setupConversationScreenViewModel(kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof zendesk.messaging.android.internal.conversationscreen.ConversationActivity$setupConversationScreenViewModel$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.messaging.android.internal.conversationscreen.ConversationActivity$setupConversationScreenViewModel$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationActivity$setupConversationScreenViewModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ConversationActivity$setupConversationScreenViewModel$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ConversationActivity$setupConversationScreenViewModel$1
            r0.<init>(r8, r9)
        L_0x0019:
            r5 = r0
            java.lang.Object r9 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r0 = r5.L$0
            zendesk.messaging.android.internal.conversationscreen.ConversationActivity r0 = (zendesk.messaging.android.internal.conversationscreen.ConversationActivity) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0064
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r9)
            zendesk.android.ZendeskCredentials$Companion r9 = zendesk.android.ZendeskCredentials.Companion
            android.content.Intent r1 = r8.getIntent()
            java.lang.String r3 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.String r1 = zendesk.messaging.android.internal.conversationscreen.ConversationActivityKt.getCredentials(r1)
            zendesk.android.ZendeskCredentials r3 = r9.fromQuery(r1)
            if (r3 == 0) goto L_0x00b7
            zendesk.android.Zendesk$Companion r1 = zendesk.android.Zendesk.Companion
            r9 = r8
            android.content.Context r9 = (android.content.Context) r9
            r4 = 0
            r6 = 4
            r7 = 0
            r5.L$0 = r8
            r5.label = r2
            r2 = r9
            java.lang.Object r9 = zendesk.messaging.android.internal.extension.ZendeskKtxKt.messaging$default(r1, r2, r3, r4, r5, r6, r7)
            if (r9 != r0) goto L_0x0063
            return r0
        L_0x0063:
            r0 = r8
        L_0x0064:
            zendesk.android.ZendeskResult r9 = (zendesk.android.ZendeskResult) r9
            boolean r1 = r9 instanceof zendesk.android.ZendeskResult.Failure
            if (r1 == 0) goto L_0x006e
            r0.errorHandler()
            goto L_0x00ba
        L_0x006e:
            boolean r1 = r9 instanceof zendesk.android.ZendeskResult.Success
            if (r1 == 0) goto L_0x00ba
            zendesk.android.ZendeskResult$Success r9 = (zendesk.android.ZendeskResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            zendesk.android.messaging.Messaging r9 = (zendesk.android.messaging.Messaging) r9
            boolean r1 = r9 instanceof zendesk.messaging.android.internal.DefaultMessaging
            if (r1 != 0) goto L_0x0084
            r0.errorHandler()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0084:
            zendesk.messaging.android.internal.DefaultMessaging r9 = (zendesk.messaging.android.internal.DefaultMessaging) r9
            zendesk.messaging.android.internal.di.MessagingComponent r9 = r9.getMessagingComponent$zendesk_messaging_messaging_android()
            zendesk.messaging.android.internal.conversationscreen.di.ConversationActivityComponent$Factory r1 = r9.conversationActivityComponent()
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            r3 = r0
            androidx.savedstate.SavedStateRegistryOwner r3 = (androidx.savedstate.SavedStateRegistryOwner) r3
            r4 = 0
            r5 = 4
            r6 = 0
            zendesk.messaging.android.internal.conversationscreen.di.ConversationActivityComponent r9 = zendesk.messaging.android.internal.conversationscreen.di.ConversationActivityComponent.Factory.DefaultImpls.create$default(r1, r2, r3, r4, r5, r6)
            r9.inject(r0)
            androidx.lifecycle.ViewModelProvider r9 = new androidx.lifecycle.ViewModelProvider
            r1 = r0
            androidx.lifecycle.ViewModelStoreOwner r1 = (androidx.lifecycle.ViewModelStoreOwner) r1
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModelFactory r2 = r0.getConversationScreenViewModelFactory()
            androidx.lifecycle.ViewModelProvider$Factory r2 = (androidx.lifecycle.ViewModelProvider.Factory) r2
            r9.<init>((androidx.lifecycle.ViewModelStoreOwner) r1, (androidx.lifecycle.ViewModelProvider.Factory) r2)
            java.lang.Class<zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel> r1 = zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel.class
            androidx.lifecycle.ViewModel r9 = r9.get(r1)
            zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel r9 = (zendesk.messaging.android.internal.conversationscreen.ConversationScreenViewModel) r9
            r0.conversationScreenViewModel = r9
            goto L_0x00ba
        L_0x00b7:
            r8.errorHandler()
        L_0x00ba:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ConversationActivity.setupConversationScreenViewModel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void errorHandler() {
        Logger.e(LOG_TAG, "Unable to show the conversation screen without a Messaging instance.", new Object[0]);
        finish();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ConversationActivity$Companion;", "", "()V", "INTENT_URI_SCHEMA", "", "LOG_TAG", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationActivity.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
