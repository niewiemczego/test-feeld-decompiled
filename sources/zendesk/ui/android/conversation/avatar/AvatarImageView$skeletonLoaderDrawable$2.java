package zendesk.ui.android.conversation.avatar;

import android.content.Context;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarImageView.kt */
final class AvatarImageView$skeletonLoaderDrawable$2 extends Lambda implements Function0<AnimatedVectorDrawableCompat> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AvatarImageView$skeletonLoaderDrawable$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final AnimatedVectorDrawableCompat invoke() {
        return AnimatedVectorDrawableCompat.create(this.$context, R.drawable.zuia_skeleton_loader_inbound);
    }
}
