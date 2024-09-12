package com.braze.ui.contentcards.adapters;

import com.braze.models.cards.Card;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ContentCardAdapter.kt */
final class ContentCardAdapter$logImpression$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Card $card;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ContentCardAdapter$logImpression$1(Card card) {
        super(0);
        this.$card = card;
    }

    public final String invoke() {
        return "Logged impression for card " + this.$card.getId();
    }
}
