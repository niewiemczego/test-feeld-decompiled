package com.braze.ui.contentcards.handlers;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.braze.models.cards.Card;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\u0003H&J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0003H&J.\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "Landroid/os/Parcelable;", "getItemViewType", "", "context", "Landroid/content/Context;", "cards", "", "Lcom/braze/models/cards/Card;", "adapterPosition", "onBindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IContentCardsViewBindingHandler.kt */
public interface IContentCardsViewBindingHandler extends Parcelable {
    int getItemViewType(Context context, List<? extends Card> list, int i);

    void onBindViewHolder(Context context, List<? extends Card> list, ContentCardViewHolder contentCardViewHolder, int i);

    ContentCardViewHolder onCreateViewHolder(Context context, List<? extends Card> list, ViewGroup viewGroup, int i);
}
