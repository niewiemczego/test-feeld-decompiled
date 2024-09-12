package com.braze.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.braze.models.cards.TextAnnouncementCard;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.feed.view.BaseFeedCardView;

public class TextAnnouncementCardView extends BaseFeedCardView<TextAnnouncementCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) TextAnnouncementCardView.class);
    private IAction mCardAction;
    private final TextView mDescription;
    private final TextView mDomain;
    private final TextView mTitle;

    public TextAnnouncementCardView(Context context) {
        this(context, (TextAnnouncementCard) null);
    }

    public TextAnnouncementCardView(Context context, TextAnnouncementCard textAnnouncementCard) {
        super(context);
        this.mTitle = (TextView) findViewById(R.id.com_braze_text_announcement_card_title);
        this.mDescription = (TextView) findViewById(R.id.com_braze_text_announcement_card_description);
        this.mDomain = (TextView) findViewById(R.id.com_braze_text_announcement_card_domain);
        if (textAnnouncementCard != null) {
            setCard(textAnnouncementCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_braze_card_background, (Resources.Theme) null));
    }

    /* access modifiers changed from: protected */
    public int getLayoutResource() {
        return R.layout.com_braze_text_announcement_card;
    }

    public void onSetCard(TextAnnouncementCard textAnnouncementCard) {
        this.mTitle.setText(textAnnouncementCard.getTitle());
        this.mDescription.setText(textAnnouncementCard.getDescription());
        setOptionalTextView(this.mDomain, textAnnouncementCard.getDomain());
        this.mCardAction = getUriActionForCard(textAnnouncementCard);
        setOnClickListener(new TextAnnouncementCardView$$ExternalSyntheticLambda0(this, textAnnouncementCard));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onSetCard$0$com-braze-ui-widget-TextAnnouncementCardView  reason: not valid java name */
    public /* synthetic */ void m188lambda$onSetCard$0$combrazeuiwidgetTextAnnouncementCardView(TextAnnouncementCard textAnnouncementCard, View view) {
        handleCardClick(this.applicationContext, textAnnouncementCard, this.mCardAction);
    }
}
