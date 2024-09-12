package com.braze.ui.contentcards.view;

import android.view.View;
import com.braze.models.cards.Card;
import com.braze.ui.actions.UriAction;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseContentCardView$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ BaseContentCardView f$0;
    public final /* synthetic */ Card f$1;
    public final /* synthetic */ UriAction f$2;

    public /* synthetic */ BaseContentCardView$$ExternalSyntheticLambda0(BaseContentCardView baseContentCardView, Card card, UriAction uriAction) {
        this.f$0 = baseContentCardView;
        this.f$1 = card;
        this.f$2 = uriAction;
    }

    public final void onClick(View view) {
        BaseContentCardView.bindViewHolder$lambda$0(this.f$0, this.f$1, this.f$2, view);
    }
}
