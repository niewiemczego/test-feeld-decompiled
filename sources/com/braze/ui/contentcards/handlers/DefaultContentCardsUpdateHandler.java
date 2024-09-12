package com.braze.ui.contentcards.handlers;

import android.os.Parcel;
import android.os.Parcelable;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.models.cards.Card;
import com.braze.ui.actions.brazeactions.BrazeActionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsUpdateHandler;", "Lcom/braze/ui/contentcards/handlers/IContentCardsUpdateHandler;", "()V", "describeContents", "", "handleCardUpdate", "", "Lcom/braze/models/cards/Card;", "event", "Lcom/braze/events/ContentCardsUpdatedEvent;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultContentCardsUpdateHandler.kt */
public class DefaultContentCardsUpdateHandler implements IContentCardsUpdateHandler {
    public static final Parcelable.Creator<DefaultContentCardsUpdateHandler> CREATOR = new DefaultContentCardsUpdateHandler$Companion$CREATOR$1();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
    }

    /* access modifiers changed from: private */
    public static final int handleCardUpdate$lambda$0(Card card, Card card2) {
        Intrinsics.checkNotNullParameter(card, "cardA");
        Intrinsics.checkNotNullParameter(card2, "cardB");
        if (!card.isPinned() || card2.isPinned()) {
            if (!card.isPinned() && card2.isPinned()) {
                return 1;
            }
            if (card.getCreated() <= card2.getCreated()) {
                if (card.getCreated() < card2.getCreated()) {
                    return 1;
                }
                if (card.getId().compareTo(card2.getId()) <= 0) {
                    if (card.getId().compareTo(card2.getId()) < 0) {
                        return 1;
                    }
                    return 0;
                }
            }
        }
        return -1;
    }

    public List<Card> handleCardUpdate(ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "event");
        DefaultContentCardsUpdateHandler$$ExternalSyntheticLambda0 defaultContentCardsUpdateHandler$$ExternalSyntheticLambda0 = new DefaultContentCardsUpdateHandler$$ExternalSyntheticLambda0();
        Collection arrayList = new ArrayList();
        for (Object next : contentCardsUpdatedEvent.getAllCards()) {
            if (!BrazeActionUtils.containsInvalidBrazeAction((Card) next)) {
                arrayList.add(next);
            }
        }
        return CollectionsKt.sortedWith((List) arrayList, defaultContentCardsUpdateHandler$$ExternalSyntheticLambda0);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/braze/ui/contentcards/handlers/DefaultContentCardsUpdateHandler$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/braze/ui/contentcards/handlers/DefaultContentCardsUpdateHandler;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultContentCardsUpdateHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
