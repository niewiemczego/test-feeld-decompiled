package com.braze.ui.inappmessage.factories;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.braze.Braze;
import com.braze.enums.BrazeViewBounds;
import com.braze.enums.inappmessage.ImageStyle;
import com.braze.images.IBrazeImageLoader;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.views.InAppMessageBaseView;
import com.braze.ui.inappmessage.views.InAppMessageImageView;
import com.braze.ui.inappmessage.views.InAppMessageModalView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0003¨\u0006\r"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageModalViewFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "()V", "createInAppMessageView", "Lcom/braze/ui/inappmessage/views/InAppMessageModalView;", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "getAppropriateModalView", "isGraphic", "", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultInAppMessageModalViewFactory.kt */
public class DefaultInAppMessageModalViewFactory implements IInAppMessageViewFactory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float NON_GRAPHIC_ASPECT_RATIO = 2.9f;

    public InAppMessageModalView createInAppMessageView(Activity activity, IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Context applicationContext = activity.getApplicationContext();
        InAppMessageModal inAppMessageModal = (InAppMessageModal) iInAppMessage;
        boolean z = true;
        boolean z2 = inAppMessageModal.getImageStyle() == ImageStyle.GRAPHIC;
        InAppMessageModalView appropriateModalView = getAppropriateModalView(activity, z2);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        appropriateModalView.applyInAppMessageParameters(applicationContext, inAppMessageModal);
        String appropriateImageUrl = InAppMessageBaseView.Companion.getAppropriateImageUrl(inAppMessageModal);
        CharSequence charSequence = appropriateImageUrl;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            IBrazeImageLoader imageLoader = Braze.Companion.getInstance(applicationContext).getImageLoader();
            ImageView messageImageView = appropriateModalView.getMessageImageView();
            if (messageImageView != null) {
                imageLoader.renderUrlIntoInAppMessageView(applicationContext, iInAppMessage, appropriateImageUrl, messageImageView, BrazeViewBounds.IN_APP_MESSAGE_MODAL);
            }
        }
        View frameView = appropriateModalView.getFrameView();
        if (frameView != null) {
            frameView.setOnClickListener(new DefaultInAppMessageModalViewFactory$$ExternalSyntheticLambda0(this));
        }
        appropriateModalView.setMessageBackgroundColor(iInAppMessage.getBackgroundColor());
        Integer frameColor = inAppMessageModal.getFrameColor();
        if (frameColor != null) {
            appropriateModalView.setFrameColor(frameColor.intValue());
        }
        appropriateModalView.setMessageButtons(inAppMessageModal.getMessageButtons());
        appropriateModalView.setMessageCloseButtonColor(inAppMessageModal.getCloseButtonColor());
        if (!z2) {
            String message = iInAppMessage.getMessage();
            if (message != null) {
                appropriateModalView.setMessage(message);
            }
            appropriateModalView.setMessageTextColor(iInAppMessage.getMessageTextColor());
            String header = inAppMessageModal.getHeader();
            if (header != null) {
                appropriateModalView.setMessageHeaderText(header);
            }
            appropriateModalView.setMessageHeaderTextColor(inAppMessageModal.getHeaderTextColor());
            String icon = iInAppMessage.getIcon();
            if (icon != null) {
                appropriateModalView.setMessageIcon(icon, iInAppMessage.getIconColor(), iInAppMessage.getIconBackgroundColor());
            }
            appropriateModalView.setMessageHeaderTextAlignment(inAppMessageModal.getHeaderTextAlign());
            appropriateModalView.setMessageTextAlign(inAppMessageModal.getMessageTextAlign());
            appropriateModalView.resetMessageMargins(inAppMessageModal.getImageDownloadSuccessful());
            ImageView messageImageView2 = appropriateModalView.getMessageImageView();
            Intrinsics.checkNotNull(messageImageView2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageImageView");
            ((InAppMessageImageView) messageImageView2).setAspectRatio(NON_GRAPHIC_ASPECT_RATIO);
        }
        appropriateModalView.setLargerCloseButtonClickArea(appropriateModalView.getMessageCloseButtonView());
        appropriateModalView.setupDirectionalNavigation(inAppMessageModal.getMessageButtons().size());
        return appropriateModalView;
    }

    /* access modifiers changed from: private */
    public static final void createInAppMessageView$lambda$1(DefaultInAppMessageModalViewFactory defaultInAppMessageModalViewFactory, View view) {
        Intrinsics.checkNotNullParameter(defaultInAppMessageModalViewFactory, "this$0");
        if (BrazeInAppMessageManager.Companion.getInstance().getDoesClickOutsideModalViewDismissInAppMessageView()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) defaultInAppMessageModalViewFactory, BrazeLogger.Priority.I, (Throwable) null, (Function0) DefaultInAppMessageModalViewFactory$createInAppMessageView$2$1.INSTANCE, 2, (Object) null);
            BrazeInAppMessageManager.Companion.getInstance().hideCurrentlyDisplayingInAppMessage(true);
        }
    }

    private final InAppMessageModalView getAppropriateModalView(Activity activity, boolean z) {
        if (z) {
            View inflate = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_modal_graphic, (ViewGroup) null);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageModalView");
            return (InAppMessageModalView) inflate;
        }
        View inflate2 = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_modal, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageModalView");
        return (InAppMessageModalView) inflate2;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageModalViewFactory$Companion;", "", "()V", "NON_GRAPHIC_ASPECT_RATIO", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DefaultInAppMessageModalViewFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
