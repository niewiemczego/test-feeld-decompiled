package com.braze.ui.widget;

import com.braze.models.cards.Card;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Lcom/braze/models/cards/Card;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseCardView.kt */
final class BaseCardView$handleCardClick$5 extends Lambda implements Function0<String> {
    final /* synthetic */ Card $card;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseCardView$handleCardClick$5(Card card) {
        super(0);
        this.$card = card;
    }

    public final String invoke() {
        return "Card click was handled by custom listener on card: " + this.$card.getId();
    }
}
