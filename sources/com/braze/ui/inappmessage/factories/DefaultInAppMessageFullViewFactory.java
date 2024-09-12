package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.braze.Braze;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.enums.inappmessage.Orientation;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.ui.R;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageFullView;
import com.braze.ui.inappmessage.views.InAppMessageImageView;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageFullViewFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "()V", "createInAppMessageView", "Lcom/braze/ui/inappmessage/views/InAppMessageFullView;", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "getAppropriateFullView", "isGraphic", "", "resetLayoutParamsIfAppropriate", "view", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageFullViewFactory.kt */
public class DefaultInAppMessageFullViewFactory implements IInAppMessageViewFactory {
    private static final int BUTTONS_PRESENT_SCROLLVIEW_EXCESS_HEIGHT_VALUE_IN_DP = 64;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public InAppMessageFullView createInAppMessageView(Activity activity, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Context applicationContext = activity.getApplicationContext();
        InAppMessageFull inAppMessageFull = (InAppMessageFull) iInAppMessage;
        boolean z = false;
        boolean z2 = inAppMessageFull.getImageStyle() == ImageStyle.GRAPHIC;
        InAppMessageFullView appropriateFullView = getAppropriateFullView(activity, z2);
        appropriateFullView.createAppropriateViews(activity, inAppMessageFull, z2);
        String appropriateImageUrl = InAppMessageBaseView.Companion.getAppropriateImageUrl(inAppMessageFull);
        CharSequence charSequence = appropriateImageUrl;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            Braze.Companion companion = Braze.Companion;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
            IBrazeImageLoader imageLoader = companion.getInstance(applicationContext).getImageLoader();
            ImageView messageImageView = appropriateFullView.getMessageImageView();
            if (messageImageView != null) {
                imageLoader.renderUrlIntoInAppMessageView(applicationContext, iInAppMessage, appropriateImageUrl, messageImageView, BrazeViewBounds.NO_BOUNDS);
            }
        }
        View frameView = appropriateFullView.getFrameView();
        if (frameView != null) {
            frameView.setOnClickListener((View.OnClickListener) null);
        }
        appropriateFullView.setMessageBackgroundColor(inAppMessageFull.getBackgroundColor());
        Integer frameColor = inAppMessageFull.getFrameColor();
        if (frameColor != null) {
            appropriateFullView.setFrameColor(frameColor.intValue());
        }
        appropriateFullView.setMessageButtons(inAppMessageFull.getMessageButtons());
        appropriateFullView.setMessageCloseButtonColor(inAppMessageFull.getCloseButtonColor());
        if (!z2) {
            String message = inAppMessageFull.getMessage();
            if (message != null) {
                appropriateFullView.setMessage(message);
            }
            appropriateFullView.setMessageTextColor(inAppMessageFull.getMessageTextColor());
            String header = inAppMessageFull.getHeader();
            if (header != null) {
                appropriateFullView.setMessageHeaderText(header);
            }
            appropriateFullView.setMessageHeaderTextColor(inAppMessageFull.getHeaderTextColor());
            appropriateFullView.setMessageHeaderTextAlignment(inAppMessageFull.getHeaderTextAlign());
            appropriateFullView.setMessageTextAlign(inAppMessageFull.getMessageTextAlign());
            appropriateFullView.resetMessageMargins(inAppMessageFull.getImageDownloadSuccessful());
            ImageView messageImageView2 = appropriateFullView.getMessageImageView();
            Intrinsics.checkNotNull(messageImageView2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageImageView");
            ((InAppMessageImageView) messageImageView2).setToHalfParentHeight(true);
        }
        appropriateFullView.setLargerCloseButtonClickArea(appropriateFullView.getMessageCloseButtonView());
        resetLayoutParamsIfAppropriate(activity, inAppMessageFull, appropriateFullView);
        appropriateFullView.setupDirectionalNavigation(inAppMessageFull.getMessageButtons().size());
        View findViewById = appropriateFullView.findViewById(R.id.com_braze_inappmessage_full_scrollview);
        if (findViewById != null) {
            findViewById.post(new DefaultInAppMessageFullViewFactory$$ExternalSyntheticLambda0(appropriateFullView.findViewById(R.id.com_braze_inappmessage_full_all_content_parent), appropriateFullView, inAppMessageFull, applicationContext, findViewById));
        }
        return appropriateFullView;
    }

    /* access modifiers changed from: private */
    public static final void createInAppMessageView$lambda$4(View view, InAppMessageFullView inAppMessageFullView, InAppMessageFull inAppMessageFull, Context context, View view2) {
        Intrinsics.checkNotNullParameter(inAppMessageFullView, "$view");
        Intrinsics.checkNotNullParameter(inAppMessageFull, "$inAppMessageFull");
        int height = view.getHeight() / 2;
        ViewGroup.LayoutParams layoutParams = inAppMessageFullView.findViewById(R.id.com_braze_inappmessage_full_text_and_button_content_parent).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int i = marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
        if (!inAppMessageFull.getMessageButtons().isEmpty()) {
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            i += (int) ViewUtils.convertDpToPixels(context, 64.0d);
        }
        int min = Math.min(view2.getHeight(), height - i);
        Intrinsics.checkNotNullExpressionValue(view2, "scrollView");
        ViewUtils.setHeightOnViewLayoutParams(view2, min);
        view2.requestLayout();
        ImageView messageImageView = inAppMessageFullView.getMessageImageView();
        if (messageImageView != null) {
            messageImageView.requestLayout();
        }
    }

    private final boolean resetLayoutParamsIfAppropriate(Activity activity, IInAppMessage iInAppMessage, InAppMessageFullView inAppMessageFullView) {
        RelativeLayout.LayoutParams layoutParams;
        if (!ViewUtils.isRunningOnTablet(activity) || iInAppMessage.getOrientation() == Orientation.ANY) {
            return false;
        }
        int longEdge = inAppMessageFullView.getLongEdge();
        int shortEdge = inAppMessageFullView.getShortEdge();
        if (longEdge <= 0 || shortEdge <= 0) {
            return false;
        }
        if (iInAppMessage.getOrientation() == Orientation.LANDSCAPE) {
            layoutParams = new RelativeLayout.LayoutParams(longEdge, shortEdge);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(shortEdge, longEdge);
        }
        layoutParams.addRule(13, -1);
        View messageBackgroundObject = inAppMessageFullView.getMessageBackgroundObject();
        if (messageBackgroundObject == null) {
            return true;
        }
        messageBackgroundObject.setLayoutParams(layoutParams);
        return true;
    }

    public final InAppMessageFullView getAppropriateFullView(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (z) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_full_graphic, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
            return (InAppMessageFullView) inflate;
        }
        View inflate2 = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_full, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageFullView");
        return (InAppMessageFullView) inflate2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageFullViewFactory$Companion;", "", "()V", "BUTTONS_PRESENT_SCROLLVIEW_EXCESS_HEIGHT_VALUE_IN_DP", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageFullViewFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
