package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.inappmessage.config.BrazeInAppMessageParams;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0.2\u0006\u0010/\u001a\u000200H\u0016J0\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\u0006\u00106\u001a\u0002002\u0006\u00107\u001a\u000200H\u0014J\u0010\u00108\u001a\u00020,2\u0006\u00109\u001a\u000203H\u0016J\u001a\u0010:\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J \u0010;\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020<2\u0006\u0010\u0011\u001a\u00020=H\u0014J\u0010\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u000200H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\nR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0016\u0010%\u001a\u0004\u0018\u00010&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0016\u0010)\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\"¨\u0006@"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageModalView;", "Lcom/braze/ui/inappmessage/views/InAppMessageImmersiveBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameView", "Landroid/view/View;", "getFrameView", "()Landroid/view/View;", "inAppMessage", "Lcom/braze/models/inappmessage/InAppMessageModal;", "getInAppMessage", "()Lcom/braze/models/inappmessage/InAppMessageModal;", "setInAppMessage", "(Lcom/braze/models/inappmessage/InAppMessageModal;)V", "inAppMessageImageView", "Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "getInAppMessageImageView", "()Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "setInAppMessageImageView", "(Lcom/braze/ui/inappmessage/views/InAppMessageImageView;)V", "messageBackgroundObject", "Landroid/graphics/drawable/Drawable;", "getMessageBackgroundObject", "()Landroid/graphics/drawable/Drawable;", "messageClickableView", "getMessageClickableView", "messageCloseButtonView", "getMessageCloseButtonView", "messageHeaderTextView", "Landroid/widget/TextView;", "getMessageHeaderTextView", "()Landroid/widget/TextView;", "messageIconView", "getMessageIconView", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "applyInAppMessageParameters", "", "getMessageButtonViews", "", "numButtons", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "resetMessageMargins", "imageRetrievalSuccessful", "resizeGraphicFrameIfAppropriate", "setInAppMessageImageViewAttributes", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "Lcom/braze/ui/inappmessage/views/IInAppMessageImageView;", "setMessageBackgroundColor", "color", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageModalView.kt */
public class InAppMessageModalView extends InAppMessageImmersiveBaseView {
    private InAppMessageModal inAppMessage;
    private InAppMessageImageView inAppMessageImageView;

    public InAppMessageModalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public final InAppMessageImageView getInAppMessageImageView() {
        return this.inAppMessageImageView;
    }

    /* access modifiers changed from: protected */
    public final void setInAppMessageImageView(InAppMessageImageView inAppMessageImageView2) {
        this.inAppMessageImageView = inAppMessageImageView2;
    }

    /* access modifiers changed from: protected */
    public final InAppMessageModal getInAppMessage() {
        return this.inAppMessage;
    }

    /* access modifiers changed from: protected */
    public final void setInAppMessage(InAppMessageModal inAppMessageModal) {
        this.inAppMessage = inAppMessageModal;
    }

    public View getFrameView() {
        return findViewById(R.id.com_braze_inappmessage_modal_frame);
    }

    public TextView getMessageTextView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_message);
    }

    public TextView getMessageHeaderTextView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_header_text);
    }

    public View getMessageClickableView() {
        return findViewById(R.id.com_braze_inappmessage_modal);
    }

    public View getMessageCloseButtonView() {
        return findViewById(R.id.com_braze_inappmessage_modal_close_button);
    }

    public TextView getMessageIconView() {
        return (TextView) findViewById(R.id.com_braze_inappmessage_modal_icon);
    }

    public Drawable getMessageBackgroundObject() {
        View messageClickableView = getMessageClickableView();
        if (messageClickableView != null) {
            return messageClickableView.getBackground();
        }
        return null;
    }

    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    public void resetMessageMargins(boolean z) {
        super.resetMessageMargins(z);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.com_braze_inappmessage_modal_image_layout);
        if ((z || getMessageIconView() != null) && relativeLayout != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(0, 0, 0, 0);
            relativeLayout.setLayoutParams(layoutParams);
        }
        View findViewById = findViewById(R.id.com_braze_inappmessage_modal_text_layout);
        if (findViewById != null) {
            findViewById.setOnClickListener(new InAppMessageModalView$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void resetMessageMargins$lambda$0(InAppMessageModalView inAppMessageModalView, View view) {
        Intrinsics.checkNotNullParameter(inAppMessageModalView, "this$0");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) inAppMessageModalView, (BrazeLogger.Priority) null, (Throwable) null, (Function0) InAppMessageModalView$resetMessageMargins$1$1.INSTANCE, 3, (Object) null);
        View messageClickableView = inAppMessageModalView.getMessageClickableView();
        if (messageClickableView != null) {
            messageClickableView.performClick();
        }
    }

    public void setMessageBackgroundColor(int i) {
        View findViewById = findViewById(R.id.com_braze_inappmessage_modal);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.com_braze_inappmessage_modal)");
        InAppMessageViewUtils.setViewBackgroundColorFilter(findViewById, i);
    }

    public List<View> getMessageButtonViews(int i) {
        List<View> arrayList = new ArrayList<>();
        if (i == 1) {
            View findViewById = findViewById(R.id.com_braze_inappmessage_modal_button_layout_single);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = findViewById(R.id.com_braze_inappmessage_modal_button_single_one);
            if (findViewById2 != null) {
                arrayList.add(findViewById2);
            }
        } else if (i == 2) {
            View findViewById3 = findViewById(R.id.com_braze_inappmessage_modal_button_layout_dual);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            View findViewById4 = findViewById(R.id.com_braze_inappmessage_modal_button_dual_one);
            View findViewById5 = findViewById(R.id.com_braze_inappmessage_modal_button_dual_two);
            if (findViewById4 != null) {
                arrayList.add(findViewById4);
            }
            if (findViewById5 != null) {
                arrayList.add(findViewById5);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "this.context");
        resizeGraphicFrameIfAppropriate(context, this.inAppMessage);
    }

    public void applyInAppMessageParameters(Context context, InAppMessageModal inAppMessageModal) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inAppMessageModal, "inAppMessage");
        this.inAppMessage = inAppMessageModal;
        InAppMessageImageView inAppMessageImageView2 = (InAppMessageImageView) findViewById(R.id.com_braze_inappmessage_modal_imageview);
        this.inAppMessageImageView = inAppMessageImageView2;
        if (inAppMessageImageView2 != null) {
            setInAppMessageImageViewAttributes(context, inAppMessageModal, inAppMessageImageView2);
        }
        resizeGraphicFrameIfAppropriate(context, inAppMessageModal);
    }

    /* access modifiers changed from: protected */
    public void setInAppMessageImageViewAttributes(Context context, IInAppMessageImmersive iInAppMessageImmersive, IInAppMessageImageView iInAppMessageImageView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "inAppMessage");
        Intrinsics.checkNotNullParameter(iInAppMessageImageView, "inAppMessageImageView");
        float convertDpToPixels = (float) ViewUtils.convertDpToPixels(context, BrazeInAppMessageParams.getModalizedImageRadiusDp());
        if (iInAppMessageImmersive.getImageStyle() == ImageStyle.GRAPHIC) {
            iInAppMessageImageView.setCornersRadiusPx(convertDpToPixels);
        } else {
            iInAppMessageImageView.setCornersRadiiPx(convertDpToPixels, convertDpToPixels, 0.0f, 0.0f);
        }
        iInAppMessageImageView.setInAppMessageImageCropType(iInAppMessageImmersive.getCropType());
    }

    /* access modifiers changed from: protected */
    public void resizeGraphicFrameIfAppropriate(Context context, InAppMessageModal inAppMessageModal) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(context, "context");
        if (inAppMessageModal != null && (bitmap = inAppMessageModal.getBitmap()) != null && inAppMessageModal.getImageStyle() == ImageStyle.GRAPHIC) {
            Resources resources = context.getResources();
            post(new InAppMessageModalView$$ExternalSyntheticLambda0(this, resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_margin), resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_max_width), resources.getDimensionPixelSize(R.dimen.com_braze_inappmessage_modal_max_height), ((double) bitmap.getWidth()) / ((double) bitmap.getHeight())));
        }
    }

    /* access modifiers changed from: private */
    public static final void resizeGraphicFrameIfAppropriate$lambda$2(InAppMessageModalView inAppMessageModalView, int i, int i2, int i3, double d) {
        Intrinsics.checkNotNullParameter(inAppMessageModalView, "this$0");
        double min = (double) Math.min(inAppMessageModalView.getMeasuredWidth() - i, i2);
        double min2 = (double) Math.min(inAppMessageModalView.getMeasuredHeight() - i, i3);
        double d2 = min / min2;
        View findViewById = inAppMessageModalView.findViewById(R.id.com_braze_inappmessage_modal_graphic_bound);
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (d >= d2) {
                layoutParams2.width = (int) min;
                layoutParams2.height = (int) (min / d);
            } else {
                layoutParams2.width = (int) (d * min2);
                layoutParams2.height = (int) min2;
            }
            findViewById.setLayoutParams(layoutParams2);
        }
    }
}
