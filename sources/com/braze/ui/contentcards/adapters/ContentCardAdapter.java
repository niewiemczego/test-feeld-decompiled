package com.braze.ui.contentcards.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00017B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0007J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bJ\u0010\u0010%\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0007J\u0006\u0010*\u001a\u00020(J\u0018\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u00102\u001a\u00020(2\u0006\u00103\u001a\u00020\u0002H\u0016J\u0010\u00104\u001a\u00020(2\u0006\u00103\u001a\u00020\u0002H\u0016J\u0014\u00105\u001a\u00020(2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\n0\u0011R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/braze/ui/contentcards/adapters/ContentCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "Lcom/braze/ui/contentcards/recycler/ItemTouchHelperAdapter;", "context", "Landroid/content/Context;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "cardData", "", "Lcom/braze/models/cards/Card;", "contentCardsViewBindingHandler", "Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "(Landroid/content/Context;Landroidx/recyclerview/widget/LinearLayoutManager;Ljava/util/List;Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;)V", "handler", "Landroid/os/Handler;", "impressedCardIds", "", "", "getImpressedCardIds", "()Ljava/util/List;", "setImpressedCardIds", "(Ljava/util/List;)V", "impressedCardIdsInternal", "", "getCardAtIndex", "index", "", "getItemCount", "getItemId", "", "position", "getItemViewType", "isAdapterPositionOnScreen", "", "adapterPosition", "isControlCardAtPosition", "isInvalidIndex", "isItemDismissable", "logImpression", "", "card", "markOnScreenCardsAsRead", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "onItemDismiss", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "replaceCards", "newCardData", "CardListDiffCallback", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardAdapter.kt */
public class ContentCardAdapter extends RecyclerView.Adapter<ContentCardViewHolder> implements ItemTouchHelperAdapter {
    /* access modifiers changed from: private */
    public final List<Card> cardData;
    private final IContentCardsViewBindingHandler contentCardsViewBindingHandler;
    private final Context context;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private Set<String> impressedCardIdsInternal = new LinkedHashSet();
    private final LinearLayoutManager layoutManager;

    public ContentCardAdapter(Context context2, LinearLayoutManager linearLayoutManager, List<Card> list, IContentCardsViewBindingHandler iContentCardsViewBindingHandler) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(list, "cardData");
        Intrinsics.checkNotNullParameter(iContentCardsViewBindingHandler, "contentCardsViewBindingHandler");
        this.context = context2;
        this.layoutManager = linearLayoutManager;
        this.cardData = list;
        this.contentCardsViewBindingHandler = iContentCardsViewBindingHandler;
        setHasStableIds(true);
    }

    public final List<String> getImpressedCardIds() {
        return CollectionsKt.toList(this.impressedCardIdsInternal);
    }

    public final void setImpressedCardIds(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "impressedCardIds");
        this.impressedCardIdsInternal = CollectionsKt.toMutableSet(list);
    }

    public ContentCardViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return this.contentCardsViewBindingHandler.onCreateViewHolder(this.context, this.cardData, viewGroup, i);
    }

    public void onBindViewHolder(ContentCardViewHolder contentCardViewHolder, int i) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        this.contentCardsViewBindingHandler.onBindViewHolder(this.context, this.cardData, contentCardViewHolder, i);
    }

    public int getItemViewType(int i) {
        return this.contentCardsViewBindingHandler.getItemViewType(this.context, this.cardData, i);
    }

    public int getItemCount() {
        return this.cardData.size();
    }

    public void onItemDismiss(int i) {
        if (isInvalidIndex(i)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new ContentCardAdapter$onItemDismiss$1(i, this), 3, (Object) null);
            return;
        }
        Card remove = this.cardData.remove(i);
        remove.setDismissed(true);
        notifyItemRemoved(i);
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        if (contentCardsActionListener != null) {
            contentCardsActionListener.onContentCardDismissed(this.context, remove);
        }
    }

    public boolean isItemDismissable(int i) {
        if (this.cardData.isEmpty() || isInvalidIndex(i)) {
            return false;
        }
        return this.cardData.get(i).isDismissibleByUser();
    }

    public void onViewAttachedToWindow(ContentCardViewHolder contentCardViewHolder) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "holder");
        super.onViewAttachedToWindow(contentCardViewHolder);
        if (!this.cardData.isEmpty()) {
            int bindingAdapterPosition = contentCardViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new ContentCardAdapter$onViewAttachedToWindow$1(bindingAdapterPosition), 2, (Object) null);
                return;
            }
            logImpression(getCardAtIndex(bindingAdapterPosition));
        }
    }

    public void onViewDetachedFromWindow(ContentCardViewHolder contentCardViewHolder) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "holder");
        super.onViewDetachedFromWindow(contentCardViewHolder);
        if (!this.cardData.isEmpty()) {
            int bindingAdapterPosition = contentCardViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new ContentCardAdapter$onViewDetachedFromWindow$1(bindingAdapterPosition), 2, (Object) null);
                return;
            }
            Card cardAtIndex = getCardAtIndex(bindingAdapterPosition);
            if (cardAtIndex != null && !cardAtIndex.isIndicatorHighlighted()) {
                cardAtIndex.setIndicatorHighlighted(true);
                this.handler.post(new ContentCardAdapter$$ExternalSyntheticLambda0(this, bindingAdapterPosition));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewDetachedFromWindow$lambda$0(ContentCardAdapter contentCardAdapter, int i) {
        Intrinsics.checkNotNullParameter(contentCardAdapter, "this$0");
        contentCardAdapter.notifyItemChanged(i);
    }

    public long getItemId(int i) {
        String id;
        Card cardAtIndex = getCardAtIndex(i);
        if (cardAtIndex == null || (id = cardAtIndex.getId()) == null) {
            return 0;
        }
        return (long) id.hashCode();
    }

    public final synchronized void replaceCards(List<? extends Card> list) {
        Intrinsics.checkNotNullParameter(list, "newCardData");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new CardListDiffCallback(this.cardData, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(diffCallback)");
        this.cardData.clear();
        this.cardData.addAll(list);
        calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this);
    }

    public final void markOnScreenCardsAsRead() {
        if (this.cardData.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) ContentCardAdapter$markOnScreenCardsAsRead$1.INSTANCE, 3, (Object) null);
            return;
        }
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new ContentCardAdapter$markOnScreenCardsAsRead$2(findFirstVisibleItemPosition, findLastVisibleItemPosition), 3, (Object) null);
            return;
        }
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i = findFirstVisibleItemPosition;
            while (true) {
                Card cardAtIndex = getCardAtIndex(i);
                if (cardAtIndex != null) {
                    cardAtIndex.setIndicatorHighlighted(true);
                }
                if (i == findLastVisibleItemPosition) {
                    break;
                }
                i++;
            }
        }
        this.handler.post(new ContentCardAdapter$$ExternalSyntheticLambda1(findLastVisibleItemPosition, findFirstVisibleItemPosition, this));
    }

    /* access modifiers changed from: private */
    public static final void markOnScreenCardsAsRead$lambda$1(int i, int i2, ContentCardAdapter contentCardAdapter) {
        Intrinsics.checkNotNullParameter(contentCardAdapter, "this$0");
        contentCardAdapter.notifyItemRangeChanged(i2, (i - i2) + 1);
    }

    public final boolean isControlCardAtPosition(int i) {
        Card cardAtIndex = getCardAtIndex(i);
        return cardAtIndex != null && cardAtIndex.isControl();
    }

    public final Card getCardAtIndex(int i) {
        if (!isInvalidIndex(i)) {
            return this.cardData.get(i);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new ContentCardAdapter$getCardAtIndex$1(i, this), 3, (Object) null);
        return null;
    }

    public final boolean isAdapterPositionOnScreen(int i) {
        return Math.min(this.layoutManager.findFirstVisibleItemPosition(), this.layoutManager.findFirstCompletelyVisibleItemPosition()) <= i && i <= Math.max(this.layoutManager.findLastVisibleItemPosition(), this.layoutManager.findLastCompletelyVisibleItemPosition());
    }

    public final void logImpression(Card card) {
        if (card != null) {
            if (!this.impressedCardIdsInternal.contains(card.getId())) {
                card.logImpression();
                this.impressedCardIdsInternal.add(card.getId());
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new ContentCardAdapter$logImpression$1(card), 2, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new ContentCardAdapter$logImpression$2(card), 2, (Object) null);
            }
            if (!card.getViewed()) {
                card.setViewed(true);
            }
        }
    }

    private final boolean isInvalidIndex(int i) {
        return i < 0 || i >= this.cardData.size();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/contentcards/adapters/ContentCardAdapter$CardListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldCards", "", "Lcom/braze/models/cards/Card;", "newCards", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "doItemsShareIds", "getNewListSize", "getOldListSize", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ContentCardAdapter.kt */
    private static final class CardListDiffCallback extends DiffUtil.Callback {
        private final List<Card> newCards;
        private final List<Card> oldCards;

        public CardListDiffCallback(List<? extends Card> list, List<? extends Card> list2) {
            Intrinsics.checkNotNullParameter(list, "oldCards");
            Intrinsics.checkNotNullParameter(list2, "newCards");
            this.oldCards = list;
            this.newCards = list2;
        }

        public int getOldListSize() {
            return this.oldCards.size();
        }

        public int getNewListSize() {
            return this.newCards.size();
        }

        public boolean areItemsTheSame(int i, int i2) {
            return doItemsShareIds(i, i2);
        }

        public boolean areContentsTheSame(int i, int i2) {
            return doItemsShareIds(i, i2);
        }

        private final boolean doItemsShareIds(int i, int i2) {
            return Intrinsics.areEqual((Object) this.oldCards.get(i).getId(), (Object) this.newCards.get(i2).getId());
        }
    }
}
