package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.IInAppMessageWithImage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016J \u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020!2\u0006\u00101\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020!2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020!2\u0006\u0010*\u001a\u00020+H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0019¨\u00068"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageBaseView;", "Landroid/widget/RelativeLayout;", "Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "hasAppliedWindowInsets", "", "getHasAppliedWindowInsets", "()Z", "setHasAppliedWindowInsets", "(Z)V", "messageBackgroundObject", "", "getMessageBackgroundObject", "()Ljava/lang/Object;", "messageClickableView", "Landroid/view/View;", "getMessageClickableView", "()Landroid/view/View;", "messageIconView", "Landroid/widget/TextView;", "getMessageIconView", "()Landroid/widget/TextView;", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "applyWindowInsets", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "resetMessageMargins", "imageRetrievalSuccessful", "setMessage", "text", "", "setMessageBackgroundColor", "color", "", "setMessageIcon", "icon", "iconColor", "iconBackgroundColor", "setMessageImageView", "bitmap", "Landroid/graphics/Bitmap;", "setMessageTextAlign", "textAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "setMessageTextColor", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageBaseView.kt */
public abstract class InAppMessageBaseView extends RelativeLayout implements IInAppMessageView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private boolean hasAppliedWindowInsets;

    @JvmStatic
    public static final String getAppropriateImageUrl(IInAppMessageWithImage iInAppMessageWithImage) {
        return Companion.getAppropriateImageUrl(iInAppMessageWithImage);
    }

    public abstract Object getMessageBackgroundObject();

    public abstract TextView getMessageIconView();

    public abstract ImageView getMessageImageView();

    public abstract TextView getMessageTextView();

    public InAppMessageBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public View getMessageClickableView() {
        return this;
    }

    public boolean getHasAppliedWindowInsets() {
        return this.hasAppliedWindowInsets;
    }

    public void setHasAppliedWindowInsets(boolean z) {
        this.hasAppliedWindowInsets = z;
    }

    public void setMessageBackgroundColor(int i) {
        Object messageBackgroundObject = getMessageBackgroundObject();
        Intrinsics.checkNotNull(messageBackgroundObject, "null cannot be cast to non-null type android.view.View");
        InAppMessageViewUtils.setViewBackgroundColor((View) messageBackgroundObject, i);
    }

    public void setMessageTextColor(int i) {
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageTextView, i);
        }
    }

    public void setMessageTextAlign(TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageTextView, textAlign);
        }
    }

    public void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView messageTextView = getMessageTextView();
        if (messageTextView != null) {
            messageTextView.setText(str);
        }
    }

    public void setMessageImageView(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            InAppMessageViewUtils.setImage(bitmap, messageImageView);
        }
    }

    public void setMessageIcon(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, InAppMessageBase.ICON);
        TextView messageIconView = getMessageIconView();
        if (messageIconView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            InAppMessageViewUtils.setIcon(context, str, i, i2, messageIconView);
        }
    }

    public void resetMessageMargins(boolean z) {
        CharSequence text;
        String obj;
        ImageView messageImageView = getMessageImageView();
        if (messageImageView != null) {
            if (!z) {
                ViewUtils.removeViewFromParent(messageImageView);
            } else {
                ViewUtils.removeViewFromParent(getMessageIconView());
            }
        }
        TextView messageIconView = getMessageIconView();
        boolean z2 = true;
        if (messageIconView == null || (text = messageIconView.getText()) == null || (obj = text.toString()) == null || !StringsKt.isBlank(obj)) {
            z2 = false;
        }
        if (z2) {
            ViewUtils.removeViewFromParent(getMessageIconView());
        }
    }

    public void applyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        setHasAppliedWindowInsets(true);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageBaseView$Companion;", "", "()V", "getAppropriateImageUrl", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessageWithImage;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InAppMessageBaseView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final String getAppropriateImageUrl(IInAppMessageWithImage iInAppMessageWithImage) {
            Intrinsics.checkNotNullParameter(iInAppMessageWithImage, "inAppMessage");
            String localImageUrl = iInAppMessageWithImage.getLocalImageUrl();
            CharSequence charSequence = localImageUrl;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                if (new File(localImageUrl).exists()) {
                    return localImageUrl;
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, (Function0) new InAppMessageBaseView$Companion$getAppropriateImageUrl$1(localImageUrl), 2, (Object) null);
            }
            return iInAppMessageWithImage.getRemoteImageUrl();
        }
    }
}
