package zendesk.messaging.android.internal.conversationscreen;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.AttachmentIntents;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.ui.android.Renderer;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationActivity$onCreate$1", f = "ConversationActivity.kt", i = {}, l = {154, 171}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConversationActivity.kt */
final class ConversationActivity$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConversationActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationActivity$onCreate$1(ConversationActivity conversationActivity, Continuation<? super ConversationActivity$onCreate$1> continuation) {
        super(2, continuation);
        this.this$0 = conversationActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConversationActivity$onCreate$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConversationActivity$onCreate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ConversationScreenViewModel conversationScreenViewModel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.setupConversationScreenViewModel(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ConversationActivity conversationActivity = this.this$0;
        View findViewById = this.this$0.findViewById(R.id.zma_conversation_screen_conversation);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zma_co…tion_screen_conversation)");
        Renderer renderer = (Renderer) findViewById;
        Function0 access$getOnBackButtonClickedHandler$p = this.this$0.onBackButtonClickedHandler;
        Function0 access$getOnDeniedPermissionActionClicked$p = this.this$0.onDeniedPermissionActionClicked;
        Function1 access$getOnAttachButtonClicked$p = this.this$0.onAttachButtonClicked;
        UriHandler access$getUriHandler$p = this.this$0.uriHandler;
        AttachmentIntents access$getAttachmentIntents = this.this$0.getAttachmentIntents();
        CoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        ProcessLifecycleObserver newInstance = ProcessLifecycleObserver.Companion.newInstance();
        CoroutineScope sdkCoroutineScope = this.this$0.getSdkCoroutineScope();
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.this$0);
        ConversationScreenViewModel access$getConversationScreenViewModel$p = this.this$0.conversationScreenViewModel;
        if (access$getConversationScreenViewModel$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationScreenViewModel");
            access$getConversationScreenViewModel$p = null;
        }
        ConversationTypingEvents conversationTypingEvents = new ConversationTypingEvents(newInstance, access$getConversationScreenViewModel$p, lifecycleScope2, sdkCoroutineScope);
        ConversationScreenViewModel access$getConversationScreenViewModel$p2 = this.this$0.conversationScreenViewModel;
        if (access$getConversationScreenViewModel$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("conversationScreenViewModel");
            conversationScreenViewModel = null;
        } else {
            conversationScreenViewModel = access$getConversationScreenViewModel$p2;
        }
        conversationActivity.conversationScreenCoordinator = new ConversationScreenCoordinator(renderer, access$getOnBackButtonClickedHandler$p, access$getOnDeniedPermissionActionClicked$p, access$getOnAttachButtonClicked$p, access$getUriHandler$p, access$getAttachmentIntents, lifecycleScope, conversationTypingEvents, conversationScreenViewModel);
        Lifecycle lifecycle = this.this$0.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        final ConversationActivity conversationActivity2 = this.this$0;
        this.label = 2;
        if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Continuation<? super Unit>) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "zendesk.messaging.android.internal.conversationscreen.ConversationActivity$onCreate$1$1", f = "ConversationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: zendesk.messaging.android.internal.conversationscreen.ConversationActivity$onCreate$1$1  reason: invalid class name */
    /* compiled from: ConversationActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(conversationActivity2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final ConversationActivity conversationActivity = conversationActivity2;
                ConversationScreenCoordinator conversationScreenCoordinator = null;
                Job unused = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 
                    }
