package com.braze.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import com.braze.models.cards.ImageOnlyCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.view.BaseFeedCardView;

public class ImageOnlyCardView extends BaseFeedCardView<ImageOnlyCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) ImageOnlyCardView.class);
    private float mAspectRatio;
    private IAction mCardAction;
    private final ImageView mImage;

    public ImageOnlyCardView(Context context) {
        this(context, (ImageOnlyCard) null);
    }

    public ImageOnlyCardView(Context context, ImageOnlyCard imageOnlyCard) {
        super(context);
        this.mAspectRatio = 6.0f;
        ImageView imageView = (ImageView) getProperViewFromInflatedStub(R.id.com_braze_image_only_card_imageview_stub);
        this.mImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAdjustViewBounds(true);
        if (imageOnlyCard != null) {
            setCard(imageOnlyCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_braze_card_background, (Resources.Theme) null));
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.com_braze_image_only_card;
    }

    public void onSetCard(ImageOnlyCard imageOnlyCard) {
        if (imageOnlyCard.getAspectRatio() != 0.0f) {
            this.mAspectRatio = imageOnlyCard.getAspectRatio();
        }
        setImageViewToUrl(this.mImage, imageOnlyCard.getImageUrl(), this.mAspectRatio, imageOnlyCard);
        this.mCardAction = getUriActionForCard(imageOnlyCard);
        setOnClickListener(new ImageOnlyCardView$$ExternalSyntheticLambda0(this, imageOnlyCard));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onSetCard$0$com-braze-ui-widget-ImageOnlyCardView  reason: not valid java name */
    public /* synthetic */ void m186lambda$onSetCard$0$combrazeuiwidgetImageOnlyCardView(ImageOnlyCard imageOnlyCard, View view) {
        handleCardClick(this.applicationContext, imageOnlyCard, this.mCardAction);
    }
}
