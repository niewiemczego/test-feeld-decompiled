package zendesk.messaging.android.internal.conversationscreen;

import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.MessagingScreen;
import zendesk.logger.Logger;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.ScreenStateStore;
import zendesk.ui.android.conversation.imagerviewer.ImageViewerView;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0015J\b\u0010\u0013\u001a\u00020\u000fH\u0014J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0011\u0010\u0015\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ImageViewerActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lzendesk/android/messaging/MessagingScreen;", "()V", "conversationScreenViewModel", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModel;", "conversationScreenViewModelFactory", "Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "getConversationScreenViewModelFactory", "()Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;", "setConversationScreenViewModelFactory", "(Lzendesk/messaging/android/internal/conversationscreen/ConversationScreenViewModelFactory;)V", "imageViewerScreenCoordinator", "Lzendesk/messaging/android/internal/conversationscreen/ImageViewerScreenCoordinator;", "errorHandler", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "setupConversationScreenViewModel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerActivity.kt */
public final class ImageViewerActivity extends AppCompatActivity implements MessagingScreen {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ImageViewerActivity";
    /* access modifiers changed from: private */
    public ConversationScreenViewModel conversationScreenViewModel;
    @Inject
    public ConversationScreenViewModelFactory conversationScreenViewModelFactory;
    /* access modifiers changed from: private */
    public ImageViewerScreenCoordinator imageViewerScreenCoordinator;

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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImageViewerView imageViewerView = new ImageViewerView(this, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        imageViewerView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        imageViewerView.setBackground(getDrawable(R.color.zuia_color_black));
        LifecycleOwner lifecycleOwner = this;
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenCreated(new ImageViewerActivity$onCreate$1(this, imageViewerView, (Continuation<? super ImageViewerActivity$onCreate$1>) null));
        LifecycleOwnerKt.getLifecycleScope(lifecycleOwner).launchWhenStarted(new ImageViewerActivity$onCreate$2(this, (Continuation<? super ImageViewerActivity$onCreate$2>) null));
        setContentView((View) imageViewerView);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        ScreenStateStore.INSTANCE.setAsVisibleMessagingScreen$zendesk_messaging_messaging_android(this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
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
            boolean r0 = r9 instanceof zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$setupConversationScreenViewModel$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$setupConversationScreenViewModel$1 r0 = (zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$setupConversationScreenViewModel$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$setupConversationScreenViewModel$1 r0 = new zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity$setupConversationScreenViewModel$1
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
            zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity r0 = (zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity) r0
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
            java.lang.String r1 = zendesk.messaging.android.internal.conversationscreen.ImageViewerActivityKt.getCredentials(r1)
            zendesk.android.ZendeskCredentials r3 = r9.fromQuery(r1)
            if (r3 == 0) goto L_0x009d
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
            goto L_0x00a0
        L_0x006e:
            boolean r1 = r9 instanceof zendesk.android.ZendeskResult.Success
            if (r1 == 0) goto L_0x00a0
            zendesk.android.ZendeskResult$Success r9 = (zendesk.android.ZendeskResult.Success) r9
            java.lang.Object r9 = r9.getValue()
            zendesk.android.messaging.Messaging r9 = (zendesk.android.messaging.Messaging) r9
            boolean r9 = r9 instanceof zendesk.messaging.android.internal.DefaultMessaging
            if (r9 != 0) goto L_0x0084
            r0.errorHandler()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0084:
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
            goto L_0x00a0
        L_0x009d:
            r8.errorHandler()
        L_0x00a0:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.ImageViewerActivity.setupConversationScreenViewModel(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void errorHandler() {
        Logger.e(LOG_TAG, "Unable to show the conversation screen without a Messaging instance.", new Object[0]);
        finish();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/ImageViewerActivity$Companion;", "", "()V", "LOG_TAG", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageViewerActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
