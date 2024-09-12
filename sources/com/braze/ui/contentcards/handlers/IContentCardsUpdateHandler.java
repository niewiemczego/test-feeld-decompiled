package com.braze.ui.contentcards.handlers;

import android.os.Parcelable;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/braze/ui/contentcards/handlers/IContentCardsUpdateHandler;", "Landroid/os/Parcelable;", "handleCardUpdate", "", "Lcom/braze/models/cards/Card;", "event", "Lcom/braze/events/ContentCardsUpdatedEvent;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IContentCardsUpdateHandler.kt */
public interface IContentCardsUpdateHandler extends Parcelable {
    List<Card> handleCardUpdate(ContentCardsUpdatedEvent contentCardsUpdatedEvent);
}
