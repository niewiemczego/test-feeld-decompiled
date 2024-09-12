package com.braze.ui.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.braze.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.BrazeFeedManager;
import com.braze.ui.feed.BrazeImageSwitcher;
import com.braze.ui.widget.BaseCardView;

public abstract class BaseFeedCardView<T extends Card> extends BaseCardView<T> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BaseCardView.class);

    /* access modifiers changed from: protected */
    public abstract int getLayoutResource();

    /* access modifiers changed from: protected */
    public abstract void onSetCard(T t);

    public BaseFeedCardView(Context context) {
        super(context);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
        this.imageSwitcher = (BrazeImageSwitcher) findViewById(R.id.com_braze_newsfeed_item_read_indicator_image_switcher);
        if (this.imageSwitcher != null) {
            this.imageSwitcher.setFactory(new BaseFeedCardView$$ExternalSyntheticLambda1(this));
        }
        if (!isUnreadIndicatorEnabled() && this.imageSwitcher != null) {
            this.imageSwitcher.setVisibility(8);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-braze-ui-feed-view-BaseFeedCardView  reason: not valid java name */
    public /* synthetic */ View m176lambda$new$0$combrazeuifeedviewBaseFeedCardView() {
        return new ImageView(this.applicationContext);
    }

    public View getProperViewFromInflatedStub(int i) {
        ((ViewStub) findViewById(i)).inflate();
        return findViewById(R.id.com_braze_stubbed_feed_image_view);
    }

    public void setCard(T t) {
        this.card = t;
        onSetCard(this.card);
        this.card.setListener(new BaseFeedCardView$$ExternalSyntheticLambda0(this));
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setCard$1$com-braze-ui-feed-view-BaseFeedCardView  reason: not valid java name */
    public /* synthetic */ void m177lambda$setCard$1$combrazeuifeedviewBaseFeedCardView() {
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }

    public Card getCard() {
        return this.card;
    }

    /* access modifiers changed from: protected */
    public boolean isClickHandled(Context context, Card card, IAction iAction) {
        return BrazeFeedManager.getInstance().getFeedCardClickActionListener().onFeedCardClicked(context, card, iAction);
    }
}
