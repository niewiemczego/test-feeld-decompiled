package com.braze.ui.contentcards;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import java.util.List;
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
@DebugMetadata(c = "com.braze.ui.contentcards.ContentCardsFragment$onViewStateRestored$1", f = "ContentCardsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ContentCardsFragment.kt */
final class ContentCardsFragment$onViewStateRestored$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $savedInstanceState;
    int label;
    final /* synthetic */ ContentCardsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardsFragment$onViewStateRestored$1(Bundle bundle, ContentCardsFragment contentCardsFragment, Continuation<? super ContentCardsFragment$onViewStateRestored$1> continuation) {
        super(2, continuation);
        this.$savedInstanceState = bundle;
        this.this$0 = contentCardsFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContentCardsFragment$onViewStateRestored$1(this.$savedInstanceState, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ContentCardsFragment$onViewStateRestored$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Parcelable parcelable;
        List stringArrayList;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) this.$savedInstanceState.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", Parcelable.class);
            } else {
                parcelable = this.$savedInstanceState.getParcelable("LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY");
            }
            RecyclerView contentCardsRecyclerView = this.this$0.getContentCardsRecyclerView();
            if (contentCardsRecyclerView != null) {
                RecyclerView.LayoutManager layoutManager = contentCardsRecyclerView.getLayoutManager();
                if (!(parcelable == null || layoutManager == null)) {
                    layoutManager.onRestoreInstanceState(parcelable);
                }
            }
            ContentCardAdapter contentCardAdapter = this.this$0.cardAdapter;
            if (!(contentCardAdapter == null || (stringArrayList = this.$savedInstanceState.getStringArrayList("KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY")) == null)) {
                contentCardAdapter.setImpressedCardIds(stringArrayList);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
