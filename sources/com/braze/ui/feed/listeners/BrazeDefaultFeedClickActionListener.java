package com.braze.ui.feed.listeners;

import android.content.Context;
import com.braze.models.cards.Card;
import com.braze.ui.actions.IAction;

public class BrazeDefaultFeedClickActionListener implements IFeedClickActionListener {
    public boolean onFeedCardClicked(Context context, Card card, IAction iAction) {
        return false;
    }
}
