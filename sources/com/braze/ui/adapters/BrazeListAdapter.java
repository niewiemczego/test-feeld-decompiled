package com.braze.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.models.cards.Card;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.models.cards.ShortNewsCard;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.feed.view.BaseFeedCardView;
import com.braze.ui.widget.CaptionedImageCardView;
import com.braze.ui.widget.DefaultCardView;
import com.braze.ui.widget.ImageOnlyCardView;
import com.braze.ui.widget.ShortNewsCardView;
import com.braze.ui.widget.TextAnnouncementCardView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BrazeListAdapter extends ArrayAdapter<Card> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BrazeListAdapter.class);
    private final Set<String> mCardIdImpressions = new HashSet();
    private final Context mContext;

    public int getViewTypeCount() {
        return 5;
    }

    public BrazeListAdapter(Context context, int i, List<Card> list) {
        super(context, i, list);
        this.mContext = context;
    }

    public int getItemViewType(int i) {
        Card card = (Card) getItem(i);
        if (card instanceof ImageOnlyCard) {
            return 1;
        }
        if (card instanceof CaptionedImageCard) {
            return 2;
        }
        if (card instanceof ShortNewsCard) {
            return 3;
        }
        return card instanceof TextAnnouncementCard ? 4 : 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseFeedCardView baseFeedCardView;
        Card card = (Card) getItem(i);
        if (view != null) {
            BrazeLogger.v(TAG, "Reusing convertView for rendering of item " + i);
            baseFeedCardView = (BaseFeedCardView) view;
        } else if (card instanceof ImageOnlyCard) {
            baseFeedCardView = new ImageOnlyCardView(this.mContext);
        } else if (card instanceof CaptionedImageCard) {
            baseFeedCardView = new CaptionedImageCardView(this.mContext);
        } else if (card instanceof ShortNewsCard) {
            baseFeedCardView = new ShortNewsCardView(this.mContext);
        } else if (card instanceof TextAnnouncementCard) {
            baseFeedCardView = new TextAnnouncementCardView(this.mContext);
        } else {
            baseFeedCardView = new DefaultCardView(this.mContext);
        }
        BrazeLogger.v(TAG, "Using view of type: " + baseFeedCardView.getClass().getName() + " for card at position " + i + ": " + card.toString());
        baseFeedCardView.setCard(card);
        logCardImpression(card);
        return baseFeedCardView;
    }

    public synchronized void replaceFeed(List<Card> list) {
        int i = 0;
        setNotifyOnChange(false);
        if (list == null) {
            clear();
            notifyDataSetChanged();
            return;
        }
        BrazeLogger.d(TAG, "Replacing existing feed of " + getCount() + " cards with new feed containing " + list.size() + " cards.");
        int size = list.size();
        int i2 = 0;
        while (i < getCount()) {
            Card card = (Card) getItem(i);
            Card card2 = null;
            if (i2 < size) {
                card2 = list.get(i2);
            }
            if (card2 == null || !card2.equals(card)) {
                remove(card);
            } else {
                i++;
                i2++;
            }
        }
        super.addAll(list.subList(i2, size));
        notifyDataSetChanged();
    }

    public synchronized void add(Card card) {
        super.add(card);
    }

    public void resetCardImpressionTracker() {
        this.mCardIdImpressions.clear();
    }

    private void logCardImpression(Card card) {
        String id = card.getId();
        if (!this.mCardIdImpressions.contains(id)) {
            this.mCardIdImpressions.add(id);
            card.logImpression();
            BrazeLogger.v(TAG, "Logged impression for card " + id);
        } else {
            BrazeLogger.v(TAG, "Already counted impression for card " + id);
        }
        if (!card.getViewed()) {
            card.setViewed(true);
        }
    }

    public void batchSetCardsToRead(int i, int i2) {
        if (getCount() == 0) {
            BrazeLogger.d(TAG, "mAdapter is empty in setting some cards to viewed.");
            return;
        }
        int min = Math.min(getCount(), i2);
        for (int max = Math.max(0, i); max < min; max++) {
            Card card = (Card) getItem(max);
            if (card == null) {
                BrazeLogger.d(TAG, "Card was null in setting some cards to viewed.");
                return;
            }
            if (!card.isIndicatorHighlighted()) {
                card.setIndicatorHighlighted(true);
            }
        }
    }
}
