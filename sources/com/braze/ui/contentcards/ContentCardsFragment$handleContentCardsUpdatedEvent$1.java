package com.braze.ui.contentcards;

import com.braze.events.ContentCardsUpdatedEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$handleContentCardsUpdatedEvent$1", f = "ContentCardsFragment.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentCardsFragment.kt */
final class ContentCardsFragment$handleContentCardsUpdatedEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContentCardsUpdatedEvent $event;
    int label;
    final /* synthetic */ ContentCardsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardsFragment$handleContentCardsUpdatedEvent$1(ContentCardsFragment contentCardsFragment, ContentCardsUpdatedEvent contentCardsUpdatedEvent, Continuation<? super ContentCardsFragment$handleContentCardsUpdatedEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = contentCardsFragment;
        this.$event = contentCardsUpdatedEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentCardsFragment$handleContentCardsUpdatedEvent$1(this.this$0, this.$event, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$handleContentCardsUpdatedEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.contentCardsUpdate(this.$event, this) == coroutine_suspended) {
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
