package zendesk.android.internal.proactivemessaging;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
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
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitResult;
import zendesk.conversationkit.android.model.VisitType;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lzendesk/android/internal/proactivemessaging/VisitTypeProvider;", "", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lzendesk/conversationkit/android/ConversationKit;Lkotlinx/coroutines/CoroutineScope;)V", "<set-?>", "Lzendesk/conversationkit/android/model/VisitType;", "visitType", "getVisitType$zendesk_zendesk_android", "()Lzendesk/conversationkit/android/model/VisitType;", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: VisitTypeProvider.kt */
public final class VisitTypeProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String LOG_TAG = "VisitTypeRepository";
    /* access modifiers changed from: private */
    public VisitType visitType;

    @Inject
    public VisitTypeProvider(final ConversationKit conversationKit, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(conversationKit, "conversationKit");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final VisitType getVisitType$zendesk_zendesk_android() {
        VisitType visitType2 = this.visitType;
        if (visitType2 != null) {
            return visitType2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("visitType");
        return null;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "zendesk.android.internal.proactivemessaging.VisitTypeProvider$1", f = "VisitTypeProvider.kt", i = {}, l = {40, 48}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: zendesk.android.internal.proactivemessaging.VisitTypeProvider$1  reason: invalid class name */
    /* compiled from: VisitTypeProvider.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ VisitTypeProvider this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, conversationKit, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            VisitTypeProvider visitTypeProvider;
            VisitType visitType;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                visitTypeProvider = this.this$0;
                this.L$0 = visitTypeProvider;
                this.label = 1;
                obj = conversationKit.getVisitType(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                visitTypeProvider = (VisitTypeProvider) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ConversationKitResult conversationKitResult = (ConversationKitResult) obj;
            if (conversationKitResult instanceof ConversationKitResult.Failure) {
                Logger.e(VisitTypeProvider.LOG_TAG, "Failure getting visit type ", ((ConversationKitResult.Failure) conversationKitResult).getCause(), new Object[0]);
                visitType = VisitType.NEW;
            } else if (conversationKitResult instanceof ConversationKitResult.Success) {
                visitType = (VisitType) ((ConversationKitResult.Success) conversationKitResult).getValue();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            visitTypeProvider.visitType = visitType;
            this.L$0 = null;
            this.label = 2;
            if (conversationKit.setVisitType(VisitType.REPEAT, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/android/internal/proactivemessaging/VisitTypeProvider$Companion;", "", "()V", "LOG_TAG", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VisitTypeProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
