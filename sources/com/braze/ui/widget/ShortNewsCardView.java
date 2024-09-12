package com.braze.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.braze.models.cards.ShortNewsCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.view.BaseFeedCardView;

public class ShortNewsCardView extends BaseFeedCardView<ShortNewsCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) ShortNewsCardView.class);
    private final float mAspectRatio;
    private IAction mCardAction;
    private final TextView mDescription;
    private final TextView mDomain;
    private final ImageView mImage;
    private final TextView mTitle;

    public ShortNewsCardView(Context context) {
        this(context, (ShortNewsCard) null);
    }

    public ShortNewsCardView(Context context, ShortNewsCard shortNewsCard) {
        super(context);
        this.mAspectRatio = 1.0f;
        this.mDescription = (TextView) findViewById(R.id.com_braze_short_news_card_description);
        this.mTitle = (TextView) findViewById(R.id.com_braze_short_news_card_title);
        this.mDomain = (TextView) findViewById(R.id.com_braze_short_news_card_domain);
        ImageView imageView = (ImageView) getProperViewFromInflatedStub(R.id.com_braze_short_news_card_imageview_stub);
        this.mImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAdjustViewBounds(true);
        if (shortNewsCard != null) {
            setCard(shortNewsCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_braze_card_background, (Resources.Theme) null));
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.com_braze_short_news_card;
    }

    public void onSetCard(ShortNewsCard shortNewsCard) {
        this.mDescription.setText(shortNewsCard.getDescription());
        setOptionalTextView(this.mTitle, shortNewsCard.getTitle());
        setOptionalTextView(this.mDomain, shortNewsCard.getDomain());
        this.mCardAction = getUriActionForCard(shortNewsCard);
        setOnClickListener(new ShortNewsCardView$$ExternalSyntheticLambda0(this, shortNewsCard));
        setImageViewToUrl(this.mImage, shortNewsCard.getImageUrl(), 1.0f, shortNewsCard);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onSetCard$0$com-braze-ui-widget-ShortNewsCardView  reason: not valid java name */
    public /* synthetic */ void m187lambda$onSetCard$0$combrazeuiwidgetShortNewsCardView(ShortNewsCard shortNewsCard, View view) {
        handleCardClick(this.applicationContext, shortNewsCard, this.mCardAction);
    }
}
