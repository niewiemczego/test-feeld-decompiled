package com.braze.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.braze.models.cards.CaptionedImageCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.view.BaseFeedCardView;

public class CaptionedImageCardView extends BaseFeedCardView<CaptionedImageCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) CaptionedImageCardView.class);
    private float mAspectRatio;
    private IAction mCardAction;
    private final TextView mDescription;
    private final TextView mDomain;
    private final ImageView mImage;
    private final TextView mTitle;

    public CaptionedImageCardView(Context context) {
        this(context, (CaptionedImageCard) null);
    }

    public CaptionedImageCardView(Context context, CaptionedImageCard captionedImageCard) {
        super(context);
        this.mAspectRatio = 1.3333334f;
        ImageView imageView = (ImageView) getProperViewFromInflatedStub(R.id.com_braze_captioned_image_card_imageview_stub);
        this.mImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAdjustViewBounds(true);
        this.mTitle = (TextView) findViewById(R.id.com_braze_captioned_image_title);
        this.mDescription = (TextView) findViewById(R.id.com_braze_captioned_image_description);
        this.mDomain = (TextView) findViewById(R.id.com_braze_captioned_image_card_domain);
        if (captionedImageCard != null) {
            setCard(captionedImageCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_braze_card_background, (Resources.Theme) null));
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.com_braze_captioned_image_card;
    }

    public void onSetCard(CaptionedImageCard captionedImageCard) {
        this.mTitle.setText(captionedImageCard.getTitle());
        this.mDescription.setText(captionedImageCard.getDescription());
        setOptionalTextView(this.mDomain, captionedImageCard.getDomain());
        this.mCardAction = getUriActionForCard(captionedImageCard);
        setOnClickListener(new CaptionedImageCardView$$ExternalSyntheticLambda0(this, captionedImageCard));
        this.mAspectRatio = captionedImageCard.getAspectRatio();
        setImageViewToUrl(this.mImage, captionedImageCard.getImageUrl(), this.mAspectRatio, captionedImageCard);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onSetCard$0$com-braze-ui-widget-CaptionedImageCardView  reason: not valid java name */
    public /* synthetic */ void m185lambda$onSetCard$0$combrazeuiwidgetCaptionedImageCardView(CaptionedImageCard captionedImageCard, View view) {
        handleCardClick(this.applicationContext, captionedImageCard, this.mCardAction);
    }
}
