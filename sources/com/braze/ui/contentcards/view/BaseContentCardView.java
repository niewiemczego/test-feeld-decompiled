package com.braze.ui.contentcards.view;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.models.cards.Card;
import com.braze.ui.R;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.widget.BaseCardView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH&J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0005J*\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0004¨\u0006\u001e"}, d2 = {"Lcom/braze/ui/contentcards/view/BaseContentCardView;", "T", "Lcom/braze/models/cards/Card;", "Lcom/braze/ui/widget/BaseCardView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "card", "createViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "isClickHandled", "", "cardAction", "Lcom/braze/ui/actions/IAction;", "safeSetClipToOutline", "imageView", "Landroid/widget/ImageView;", "setOptionalCardImage", "cardAspectRatio", "", "cardImageUrl", "", "setViewBackground", "view", "Landroid/view/View;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BaseContentCardView.kt */
public abstract class BaseContentCardView<T extends Card> extends BaseCardView<T> {
    public abstract ContentCardViewHolder createViewHolder(ViewGroup viewGroup);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseContentCardView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bindViewHolder(ContentCardViewHolder contentCardViewHolder, Card card) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
        contentCardViewHolder.setPinnedIconVisible(card.isPinned());
        boolean z = true;
        contentCardViewHolder.setUnreadBarVisible(this.configurationProvider.isContentCardsUnreadVisualIndicatorEnabled() && !card.isIndicatorHighlighted());
        BaseCardView.Companion companion = BaseCardView.Companion;
        UriAction uriActionForCard = BaseCardView.getUriActionForCard(card);
        contentCardViewHolder.itemView.setOnClickListener(new BaseContentCardView$$ExternalSyntheticLambda0(this, card, uriActionForCard));
        if (uriActionForCard == null) {
            z = false;
        }
        contentCardViewHolder.setActionHintVisible(z);
    }

    /* access modifiers changed from: private */
    public static final void bindViewHolder$lambda$0(BaseContentCardView baseContentCardView, Card card, UriAction uriAction, View view) {
        Intrinsics.checkNotNullParameter(baseContentCardView, "this$0");
        Intrinsics.checkNotNullParameter(card, "$card");
        baseContentCardView.handleCardClick(baseContentCardView.applicationContext, card, uriAction);
    }

    public final void setOptionalCardImage(ImageView imageView, float f, String str, Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (imageView != null && str != null) {
            setImageViewToUrl(imageView, str, f, card);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isClickHandled(Context context, Card card, IAction iAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        return contentCardsActionListener != null && contentCardsActionListener.onContentCardClicked(context, card, iAction);
    }

    /* access modifiers changed from: protected */
    public final void safeSetClipToOutline(ImageView imageView) {
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
    }

    /* access modifiers changed from: protected */
    public final void setViewBackground(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        view.setBackground(getResources().getDrawable(R.drawable.com_braze_content_card_background));
        if (Build.VERSION.SDK_INT >= 23) {
            view.setForeground(getResources().getDrawable(R.drawable.com_braze_content_card_scrim));
        }
    }
}
