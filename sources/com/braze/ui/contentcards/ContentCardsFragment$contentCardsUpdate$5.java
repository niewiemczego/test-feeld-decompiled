package com.braze.ui.contentcards;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$contentCardsUpdate$5", f = "ContentCardsFragment.kt", i = {}, l = {309}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentCardsFragment.kt */
final class ContentCardsFragment$contentCardsUpdate$5 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ContentCardsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardsFragment$contentCardsUpdate$5(ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$contentCardsUpdate$5> continuation) {
        super(1, continuation);
        this.this$0 = contentCardsFragment;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ContentCardsFragment$contentCardsUpdate$5(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$contentCardsUpdate$5) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.networkUnavailable(this) == coroutine_suspended) {
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
