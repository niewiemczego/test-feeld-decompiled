package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.braze.models.cards.Card;
import com.braze.models.cards.ShortNewsCard;
import com.braze.ui.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000f\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0011"}, d2 = {"Lcom/braze/ui/contentcards/view/ShortNewsContentCardView;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "Lcom/braze/models/cards/ShortNewsCard;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "card", "Lcom/braze/models/cards/Card;", "createViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "Companion", "ViewHolder", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShortNewsContentCardView.kt */
public class ShortNewsContentCardView extends BaseContentCardView<ShortNewsCard> {
    private static final float ASPECT_RATIO = 1.0f;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShortNewsContentCardView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/contentcards/view/ShortNewsContentCardView$ViewHolder;", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "view", "Landroid/view/View;", "(Lcom/braze/ui/contentcards/view/ShortNewsContentCardView;Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "title", "getTitle", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ShortNewsContentCardView.kt */
    private final class ViewHolder extends ContentCardViewHolder {
        private final TextView description;
        private final ImageView imageView;
        final /* synthetic */ ShortNewsContentCardView this$0;
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(ShortNewsContentCardView shortNewsContentCardView, View view) {
            super(view, shortNewsContentCardView.isUnreadIndicatorEnabled());
            Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
            this.this$0 = shortNewsContentCardView;
            this.title = (TextView) view.findViewById(R.id.com_braze_content_cards_short_news_card_title);
            this.description = (TextView) view.findViewById(R.id.com_braze_content_cards_short_news_card_description);
            this.imageView = (ImageView) view.findViewById(R.id.com_braze_content_cards_short_news_card_image);
        }

        public final TextView getTitle() {
            return this.title;
        }

        public final TextView getDescription() {
            return this.description;
        }

        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    public ContentCardViewHolder createViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.com_braze_short_news_content_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, ViewHierarchyConstants.VIEW_KEY);
        setViewBackground(inflate);
        return new ViewHolder(this, inflate);
    }

    public void bindViewHolder(ContentCardViewHolder contentCardViewHolder, Card card) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
        if (card instanceof ShortNewsCard) {
            super.bindViewHolder(contentCardViewHolder, card);
            ViewHolder viewHolder = (ViewHolder) contentCardViewHolder;
            TextView title = viewHolder.getTitle();
            if (title != null) {
                setOptionalTextView(title, ((ShortNewsCard) card).getTitle());
            }
            TextView description = viewHolder.getDescription();
            if (description != null) {
                setOptionalTextView(description, ((ShortNewsCard) card).getDescription());
            }
            ShortNewsCard shortNewsCard = (ShortNewsCard) card;
            CharSequence domain = shortNewsCard.getDomain();
            String url = domain == null || StringsKt.isBlank(domain) ? card.getUrl() : shortNewsCard.getDomain();
            if (url != null) {
                viewHolder.setActionHintText(url);
            }
            setOptionalCardImage(viewHolder.getImageView(), 1.0f, shortNewsCard.getImageUrl(), card);
            safeSetClipToOutline(viewHolder.getImageView());
            contentCardViewHolder.itemView.setContentDescription(shortNewsCard.getTitle() + " . " + shortNewsCard.getDescription());
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/braze/ui/contentcards/view/ShortNewsContentCardView$Companion;", "", "()V", "ASPECT_RATIO", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ShortNewsContentCardView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
