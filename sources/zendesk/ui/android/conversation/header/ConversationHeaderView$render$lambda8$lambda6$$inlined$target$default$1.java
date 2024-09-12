package zendesk.ui.android.conversation.header;

import android.graphics.drawable.Drawable;
import coil.target.Target;
import com.google.android.material.appbar.MaterialToolbar;
import kotlin.Metadata;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n¸\u0006\u0000"}, d2 = {"coil/request/ImageRequest$Builder$target$4", "Lcoil/target/Target;", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: zendesk.ui.android.conversation.header.ConversationHeaderView$render$lambda-8$lambda-6$$inlined$target$default$1  reason: invalid class name */
/* compiled from: ImageRequest.kt */
public final class ConversationHeaderView$render$lambda8$lambda6$$inlined$target$default$1 implements Target {
    final /* synthetic */ MaterialToolbar $this_apply$inlined;

    public void onError(Drawable drawable) {
    }

    public void onStart(Drawable drawable) {
    }

    public ConversationHeaderView$render$lambda8$lambda6$$inlined$target$default$1(MaterialToolbar materialToolbar) {
        this.$this_apply$inlined = materialToolbar;
    }

    public void onSuccess(Drawable drawable) {
        this.$this_apply$inlined.setLogo(drawable);
        MaterialToolbar materialToolbar = this.$this_apply$inlined;
        materialToolbar.setLogoDescription((CharSequence) materialToolbar.getContext().getString(R.string.zuia_conversation_header_logo));
    }
}
