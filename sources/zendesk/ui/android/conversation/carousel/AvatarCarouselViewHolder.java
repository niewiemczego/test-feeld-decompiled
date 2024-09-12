package zendesk.ui.android.conversation.carousel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.conversation.avatar.AvatarImageView;
import zendesk.ui.android.conversation.carousel.CarouselCellData;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lzendesk/ui/android/conversation/carousel/AvatarCarouselViewHolder;", "Lzendesk/ui/android/conversation/carousel/CarouselViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarImageView", "Lzendesk/ui/android/conversation/avatar/AvatarImageView;", "bind", "", "rendering", "Lzendesk/ui/android/conversation/carousel/CarouselRendering;", "cellData", "Lzendesk/ui/android/conversation/carousel/CarouselCellData$Avatar;", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselViewPagerViewHolders.kt */
public final class AvatarCarouselViewHolder extends CarouselViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AvatarImageView avatarImageView;

    public /* synthetic */ AvatarCarouselViewHolder(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    private AvatarCarouselViewHolder(View view) {
        super(view);
        View findViewById = view.findViewById(R.id.zuia_carousel_list_item_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.z…arousel_list_item_avatar)");
        this.avatarImageView = (AvatarImageView) findViewById;
    }

    public final void bind(CarouselRendering carouselRendering, CarouselCellData.Avatar avatar) {
        Intrinsics.checkNotNullParameter(carouselRendering, "rendering");
        Intrinsics.checkNotNullParameter(avatar, "cellData");
        if (!carouselRendering.getShowAvatar() || avatar.getAvatarImageState() == null) {
            this.avatarImageView.setVisibility(8);
            return;
        }
        this.avatarImageView.render(new AvatarCarouselViewHolder$bind$1(avatar));
        this.avatarImageView.setVisibility(0);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lzendesk/ui/android/conversation/carousel/AvatarCarouselViewHolder$Companion;", "", "()V", "create", "Lzendesk/ui/android/conversation/carousel/AvatarCarouselViewHolder;", "layoutInflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CarouselViewPagerViewHolders.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AvatarCarouselViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(layoutInflater, "layoutInflater");
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = layoutInflater.inflate(R.layout.zuia_view_carousel_item_avatar, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, ViewHierarchyConstants.VIEW_KEY);
            return new AvatarCarouselViewHolder(inflate, (DefaultConstructorMarker) null);
        }
    }
}
