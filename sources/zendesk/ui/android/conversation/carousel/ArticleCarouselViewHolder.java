package zendesk.ui.android.conversation.carousel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import coil.ImageLoader;
import coil.request.Disposable;
import coil.request.ImageRequest;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.ui.android.R;
import zendesk.ui.android.conversation.carousel.CarouselCellData;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/carousel/ArticleCarouselViewHolder;", "Lzendesk/ui/android/conversation/carousel/CarouselViewHolder;", "view", "Landroid/view/View;", "imageLoader", "Lcoil/ImageLoader;", "(Landroid/view/View;Lcoil/ImageLoader;)V", "actionButton", "Landroid/widget/TextView;", "desc", "image", "Landroid/widget/ImageView;", "imageLoadingDisposable", "Lcoil/request/Disposable;", "title", "bind", "", "rendering", "Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "cellData", "Lzendesk/ui/android/conversation/carousel/CarouselCellData$Item;", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselViewPagerViewHolders.kt */
public final class ArticleCarouselViewHolder extends CarouselViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final TextView actionButton;
    private final TextView desc;
    private final ImageView image;
    private final ImageLoader imageLoader;
    private Disposable imageLoadingDisposable;
    private final TextView title;
    private final View view;

    public /* synthetic */ ArticleCarouselViewHolder(View view2, ImageLoader imageLoader2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view2, imageLoader2);
    }

    private ArticleCarouselViewHolder(View view2, ImageLoader imageLoader2) {
        super(view2);
        this.view = view2;
        this.imageLoader = imageLoader2;
        View findViewById = view2.findViewById(R.id.zuia_carousel_list_item_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.z…carousel_list_item_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = view2.findViewById(R.id.zuia_carousel_list_item_description);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.z…el_list_item_description)");
        this.desc = (TextView) findViewById2;
        View findViewById3 = view2.findViewById(R.id.zuia_carousel_list_item_image);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.z…carousel_list_item_image)");
        this.image = (ImageView) findViewById3;
        View findViewById4 = view2.findViewById(R.id.zuia_carousel_list_item_article_button);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.z…list_item_article_button)");
        this.actionButton = (TextView) findViewById4;
    }

    public final void bind(CarouselRendering carouselRendering, CarouselCellData.Item item) {
        int i;
        Intrinsics.checkNotNullParameter(carouselRendering, "rendering");
        Intrinsics.checkNotNullParameter(item, "cellData");
        this.title.setText(item.getTitle());
        this.desc.setText(item.getDescription());
        this.title.setTextColor(carouselRendering.getTextColor());
        this.desc.setTextColor(carouselRendering.getTextColor());
        CarouselCellAction action = item.getAction();
        CharSequence text = action != null ? action.getText() : null;
        boolean z = true;
        if (!(text == null || StringsKt.isBlank(text))) {
            TextView textView = this.actionButton;
            CarouselCellAction action2 = item.getAction();
            textView.setText(action2 != null ? action2.getText() : null);
            TextView textView2 = this.actionButton;
            Integer actionColor = carouselRendering.getActionColor();
            if (actionColor != null) {
                i = actionColor.intValue();
            } else {
                i = ContextCompat.getColor(this.view.getContext(), R.color.zuia_color_green);
            }
            textView2.setTextColor(i);
            if (item.getAction() != null) {
                this.actionButton.setOnClickListener(new ArticleCarouselViewHolder$$ExternalSyntheticLambda0(item));
            }
            this.actionButton.setBackgroundResource(R.drawable.zuia_ic_carousel_cell_action_ripple);
        } else {
            TextView textView3 = this.actionButton;
            textView3.setText(textView3.getResources().getText(R.string.zuia_option_not_supported));
            this.actionButton.setTextColor(ContextCompat.getColor(this.view.getContext(), R.color.zuia_color_black_38p));
            this.actionButton.setOnClickListener((View.OnClickListener) null);
            this.actionButton.setBackgroundResource(R.drawable.zuia_ic_carousel_cell_action_disabled);
        }
        Disposable disposable = this.imageLoadingDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        if (item.getMediaUrl() != null) {
            String mediaType = item.getMediaType();
            if (mediaType == null || true != StringsKt.contains$default((CharSequence) mediaType, (CharSequence) "image", false, 2, (Object) null)) {
                z = false;
            }
            if (z) {
                this.image.setVisibility(0);
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
                this.imageLoadingDisposable = this.imageLoader.enqueue(new ImageRequest.Builder(context).data(item.getMediaUrl()).target(this.image).build());
                return;
            }
        }
        this.image.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2761bind$lambda1$lambda0(CarouselCellData.Item item, View view2) {
        Intrinsics.checkNotNullParameter(item, "$cellData");
        item.getAction().getClickListener().invoke(item.getAction());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lzendesk/ui/android/conversation/carousel/ArticleCarouselViewHolder$Companion;", "", "()V", "create", "Lzendesk/ui/android/conversation/carousel/ArticleCarouselViewHolder;", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "imageLoader", "Lcoil/ImageLoader;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CarouselViewPagerViewHolders.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArticleCarouselViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup, ImageLoader imageLoader) {
            Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(imageLoader, "imageLoader");
            View inflate = layoutInflater.inflate(R.layout.zuia_view_carousel_item_article, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, ViewHierarchyConstants.VIEW_KEY);
            return new ArticleCarouselViewHolder(inflate, imageLoader, (DefaultConstructorMarker) null);
        }
    }
}
