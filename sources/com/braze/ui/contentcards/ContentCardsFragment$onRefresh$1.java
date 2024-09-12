package com.braze.ui.contentcards;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$onRefresh$1", f = "ContentCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentCardsFragment.kt */
final class ContentCardsFragment$onRefresh$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ContentCardsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardsFragment$onRefresh$1(ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$onRefresh$1> continuation) {
        super(1, continuation);
        this.this$0 = contentCardsFragment;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ContentCardsFragment$onRefresh$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$onRefresh$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SwipeRefreshLayout contentCardsSwipeLayout = this.this$0.getContentCardsSwipeLayout();
            if (contentCardsSwipeLayout != null) {
                contentCardsSwipeLayout.setRefreshing(false);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
