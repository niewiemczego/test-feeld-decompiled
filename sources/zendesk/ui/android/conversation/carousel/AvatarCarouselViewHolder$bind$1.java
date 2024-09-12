package zendesk.ui.android.conversation.carousel;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.avatar.AvatarImageRendering;
import zendesk.ui.android.conversation.avatar.AvatarImageState;
import zendesk.ui.android.conversation.carousel.CarouselCellData;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;", "avatarViewRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CarouselViewPagerViewHolders.kt */
final class AvatarCarouselViewHolder$bind$1 extends Lambda implements Function1<AvatarImageRendering, AvatarImageRendering> {
    final /* synthetic */ CarouselCellData.Avatar $cellData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarCarouselViewHolder$bind$1(CarouselCellData.Avatar avatar) {
        super(1);
        this.$cellData = avatar;
    }

    public final AvatarImageRendering invoke(AvatarImageRendering avatarImageRendering) {
        Intrinsics.checkNotNullParameter(avatarImageRendering, "avatarViewRendering");
        AvatarImageRendering.Builder builder = avatarImageRendering.toBuilder();
        final CarouselCellData.Avatar avatar = this.$cellData;
        return builder.state(new Function1<AvatarImageState, AvatarImageState>() {
            public final AvatarImageState invoke(AvatarImageState avatarImageState) {
                Intrinsics.checkNotNullParameter(avatarImageState, "it");
                return avatar.getAvatarImageState();
            }
        }).build();
    }
}
