package com.braze.ui.inappmessage.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.models.inappmessage.IInAppMessageImmersive;
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

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\bH\u0002J\u0018\u0010,\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010-\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020*H\u0016J \u00100\u001a\u00020(2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u00105\u001a\b\u0012\u0004\u0012\u00020\b062\u0006\u00107\u001a\u00020\u0010H\u0016J\u0010\u00108\u001a\u00020(2\u0006\u00109\u001a\u00020\u000eH\u0016J \u0010:\u001a\u00020(2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u0010\u000b\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u0010H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0016\u0010\u0015\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0016\u0010\u0017\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\nR\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8VX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0014\u0010%\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u0012¨\u0006>"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageFullView;", "Lcom/braze/ui/inappmessage/views/InAppMessageImmersiveBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameView", "Landroid/view/View;", "getFrameView", "()Landroid/view/View;", "inAppMessageImageView", "Lcom/braze/ui/inappmessage/views/InAppMessageImageView;", "isGraphic", "", "longEdge", "", "getLongEdge", "()I", "messageBackgroundObject", "getMessageBackgroundObject", "messageClickableView", "getMessageClickableView", "messageCloseButtonView", "getMessageCloseButtonView", "messageHeaderTextView", "Landroid/widget/TextView;", "getMessageHeaderTextView", "()Landroid/widget/TextView;", "messageIconView", "getMessageIconView", "messageImageView", "Landroid/widget/ImageView;", "getMessageImageView", "()Landroid/widget/ImageView;", "messageTextView", "getMessageTextView", "shortEdge", "getShortEdge", "applyDisplayCutoutMarginsToCloseButton", "", "windowInsets", "Landroidx/core/view/WindowInsetsCompat;", "closeButtonView", "applyDisplayCutoutMarginsToContentArea", "contentAreaView", "applyWindowInsets", "insets", "createAppropriateViews", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "getMessageButtonViews", "", "numButtons", "resetMessageMargins", "imageRetrievalSuccessful", "setInAppMessageImageViewAttributes", "Lcom/braze/ui/inappmessage/views/IInAppMessageImageView;", "setMessageBackgroundColor", "color", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageFullView.kt */
public class InAppMessageFullView extends InAppMessageImmersiveBaseView {
    private InAppMessageImageView inAppMessageImageView;
    private boolean isGraphic;

    public TextView getMessageIconView() {
        return null;
    }

    public InAppMessageFullView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextView getMessageTextView() {
        View findViewById = findViewById(R.id.com_braze_inappmessage_full_message);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.com_br…nappmessage_full_message)");
        return (TextView) findViewById;
    }

    public TextView getMessageHeaderTextView() {
        View findViewById = findViewById(R.id.com_braze_inappmessage_full_header_text);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.com_br…message_full_header_text)");
        return (TextView) findViewById;
    }

    public View getFrameView() {
        return findViewById(R.id.com_braze_inappmessage_full_frame);
    }

    public View getMessageCloseButtonView() {
        return findViewById(R.id.com_braze_inappmessage_full_close_button);
    }

    public View getMessageClickableView() {
        return findViewById(R.id.com_braze_inappmessage_full);
    }

    public ImageView getMessageImageView() {
        return this.inAppMessageImageView;
    }

    public View getMessageBackgroundObject() {
        return findViewById(R.id.com_braze_inappmessage_full);
    }

    public int getLongEdge() {
        return findViewById(R.id.com_braze_inappmessage_full).getLayoutParams().height;
    }

    public int getShortEdge() {
        return findViewById(R.id.com_braze_inappmessage_full).getLayoutParams().width;
    }

    public void createAppropriateViews(Activity activity, IInAppMessageImmersive iInAppMessageImmersive, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "inAppMessage");
        InAppMessageImageView inAppMessageImageView2 = (InAppMessageImageView) findViewById(R.id.com_braze_inappmessage_full_imageview);
        this.inAppMessageImageView = inAppMessageImageView2;
        if (inAppMessageImageView2 != null) {
            setInAppMessageImageViewAttributes(activity, iInAppMessageImmersive, inAppMessageImageView2);
        }
        this.isGraphic = z;
    }

    public void setMessageBackgroundColor(int i) {
        View messageBackgroundObject = getMessageBackgroundObject();
        if ((messageBackgroundObject != null ? messageBackgroundObject.getBackground() : null) instanceof GradientDrawable) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageBackgroundObject, i);
        } else if (this.isGraphic) {
            super.setMessageBackgroundColor(i);
        } else {
            View findViewById = findViewById(R.id.com_braze_inappmessage_full_all_content_parent);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.com_br…_full_all_content_parent)");
            InAppMessageViewUtils.setViewBackgroundColor(findViewById, i);
            View findViewById2 = findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.com_br…nd_button_content_parent)");
            InAppMessageViewUtils.setViewBackgroundColor(findViewById2, i);
        }
    }

    public List<View> getMessageButtonViews(int i) {
        List<View> arrayList = new ArrayList<>();
        if (i == 1) {
            View findViewById = findViewById(R.id.com_braze_inappmessage_full_button_layout_single);
            if (findViewById != null) {
                findViewById.setVisibility(0);
            }
            View findViewById2 = findViewById(R.id.com_braze_inappmessage_full_button_single_one);
            if (findViewById2 != null) {
                arrayList.add(findViewById2);
            }
        } else if (i == 2) {
            View findViewById3 = findViewById(R.id.com_braze_inappmessage_full_button_layout_dual);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
            View findViewById4 = findViewById(R.id.com_braze_inappmessage_full_button_dual_one);
            View findViewById5 = findViewById(R.id.com_braze_inappmessage_full_button_dual_two);
            if (findViewById4 != null) {
                arrayList.add(findViewById4);
            }
            if (findViewById5 != null) {
                arrayList.add(findViewById5);
            }
        }
        return arrayList;
    }

    public void resetMessageMargins(boolean z) {
        super.resetMessageMargins(z);
        View messageClickableView = getMessageClickableView();
        if (messageClickableView != null) {
            findViewById(R.id.com_braze_inappmessage_full_text_layout).setOnClickListener(new InAppMessageFullView$$ExternalSyntheticLambda0(this, messageClickableView));
        }
    }

    /* access modifiers changed from: private */
    public static final void resetMessageMargins$lambda$2$lambda$1(InAppMessageFullView inAppMessageFullView, View view, View view2) {
        Intrinsics.checkNotNullParameter(inAppMessageFullView, "this$0");
        Intrinsics.checkNotNullParameter(view, "$msgClickableView");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) inAppMessageFullView, (BrazeLogger.Priority) null, (Throwable) null, (Function0) InAppMessageFullView$resetMessageMargins$1$1$1.INSTANCE, 3, (Object) null);
        view.performClick();
    }

    public void applyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsCompat, "insets");
        super.applyWindowInsets(windowInsetsCompat);
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView != null) {
            applyDisplayCutoutMarginsToCloseButton(windowInsetsCompat, messageCloseButtonView);
        }
        if (this.isGraphic) {
            View findViewById = findViewById(R.id.com_braze_inappmessage_full_button_layout_single);
            boolean z = true;
            if (findViewById != null && findViewById.getVisibility() == 0) {
                Intrinsics.checkNotNullExpressionValue(findViewById, "singleButtonParent");
                applyDisplayCutoutMarginsToContentArea(windowInsetsCompat, findViewById);
                return;
            }
            View findViewById2 = findViewById(R.id.com_braze_inappmessage_full_button_layout_dual);
            if (findViewById2 == null || findViewById2.getVisibility() != 0) {
                z = false;
            }
            if (z) {
                Intrinsics.checkNotNullExpressionValue(findViewById2, "dualButtonParent");
                applyDisplayCutoutMarginsToContentArea(windowInsetsCompat, findViewById2);
                return;
            }
            return;
        }
        View findViewById3 = findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent);
        if (findViewById3 != null) {
            applyDisplayCutoutMarginsToContentArea(windowInsetsCompat, findViewById3);
        }
    }

    private final void setInAppMessageImageViewAttributes(Activity activity, IInAppMessageImmersive iInAppMessageImmersive, IInAppMessageImageView iInAppMessageImageView) {
        iInAppMessageImageView.setInAppMessageImageCropType(iInAppMessageImmersive.getCropType());
        if (ViewUtils.isRunningOnTablet(activity)) {
            float convertDpToPixels = (float) ViewUtils.convertDpToPixels(activity, BrazeInAppMessageParams.getModalizedImageRadiusDp());
            if (iInAppMessageImmersive.getImageStyle() == ImageStyle.GRAPHIC) {
                iInAppMessageImageView.setCornersRadiusPx(convertDpToPixels);
            } else {
                iInAppMessageImageView.setCornersRadiiPx(convertDpToPixels, convertDpToPixels, 0.0f, 0.0f);
            }
        } else {
            iInAppMessageImageView.setCornersRadiusPx(0.0f);
        }
    }

    private final void applyDisplayCutoutMarginsToCloseButton(WindowInsetsCompat windowInsetsCompat, View view) {
        if (view.getLayoutParams() == null || !(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) InAppMessageFullView$applyDisplayCutoutMarginsToCloseButton$1.INSTANCE, 3, (Object) null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, ViewUtils.getMaxSafeTopInset(windowInsetsCompat) + marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
    }

    private final void applyDisplayCutoutMarginsToContentArea(WindowInsetsCompat windowInsetsCompat, View view) {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) InAppMessageFullView$applyDisplayCutoutMarginsToContentArea$1.INSTANCE, 3, (Object) null);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(ViewUtils.getMaxSafeLeftInset(windowInsetsCompat) + marginLayoutParams.leftMargin, marginLayoutParams.topMargin, ViewUtils.getMaxSafeRightInset(windowInsetsCompat) + marginLayoutParams.rightMargin, ViewUtils.getMaxSafeBottomInset(windowInsetsCompat) + marginLayoutParams.bottomMargin);
    }
}
