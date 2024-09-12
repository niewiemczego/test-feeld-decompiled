package com.braze.ui.widget;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.feed.view.BaseFeedCardView;

public class DefaultCardView extends BaseFeedCardView<Card> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) DefaultCardView.class);

    public DefaultCardView(Context context) {
        this(context, (Card) null);
    }

    public DefaultCardView(Context context, Card card) {
        super(context);
        if (card != null) {
            setCard(card);
        }
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.com_braze_default_card;
    }

    public void onSetCard(Card card) {
        BrazeLogger.w(TAG, "onSetCard called for blank view with: " + card.toString());
    }
}
