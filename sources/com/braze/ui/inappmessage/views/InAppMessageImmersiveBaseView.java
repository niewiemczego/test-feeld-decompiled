package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import com.braze.enums.inappmessage.TextAlign;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageButtonViewUtils;
import com.braze.ui.inappmessage.utils.InAppMessageViewUtils;
import com.braze.ui.support.ViewUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0016\u0010#\u001a\u00020\u001d2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0017H\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006/"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageImmersiveBaseView;", "Lcom/braze/ui/inappmessage/views/InAppMessageBaseView;", "Lcom/braze/ui/inappmessage/views/IInAppMessageImmersiveView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "frameView", "Landroid/view/View;", "getFrameView", "()Landroid/view/View;", "messageHeaderTextView", "Landroid/widget/TextView;", "getMessageHeaderTextView", "()Landroid/widget/TextView;", "messageTextView", "getMessageTextView", "dispatchKeyEvent", "", "event", "Landroid/view/KeyEvent;", "getMessageButtonViews", "", "numButtons", "", "onKeyDown", "keyCode", "resetMessageMargins", "", "imageRetrievalSuccessful", "setFrameColor", "color", "setLargerCloseButtonClickArea", "closeButtonView", "setMessageButtons", "messageButtons", "Lcom/braze/models/inappmessage/MessageButton;", "setMessageCloseButtonColor", "setMessageHeaderText", "text", "", "setMessageHeaderTextAlignment", "textAlign", "Lcom/braze/enums/inappmessage/TextAlign;", "setMessageHeaderTextColor", "setupDirectionalNavigation", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageImmersiveBaseView.kt */
public abstract class InAppMessageImmersiveBaseView extends InAppMessageBaseView implements IInAppMessageImmersiveView {
    public abstract View getFrameView();

    public abstract List<View> getMessageButtonViews(int i);

    public abstract TextView getMessageHeaderTextView();

    public abstract TextView getMessageTextView();

    public InAppMessageImmersiveBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void resetMessageMargins(boolean z) {
        super.resetMessageMargins(z);
        TextView messageTextView = getMessageTextView();
        CharSequence charSequence = null;
        if (StringsKt.isBlank(String.valueOf(messageTextView != null ? messageTextView.getText() : null))) {
            ViewUtils.removeViewFromParent(getMessageTextView());
        }
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            charSequence = messageHeaderTextView.getText();
        }
        if (StringsKt.isBlank(String.valueOf(charSequence))) {
            ViewUtils.removeViewFromParent(getMessageHeaderTextView());
        }
        InAppMessageViewUtils.resetMessageMarginsIfNecessary(getMessageTextView(), getMessageHeaderTextView());
    }

    public void setupDirectionalNavigation(int i) {
        List<View> messageButtonViews = getMessageButtonViews(i);
        View messageCloseButtonView = getMessageCloseButtonView();
        Integer valueOf = messageCloseButtonView != null ? Integer.valueOf(messageCloseButtonView.getId()) : null;
        if (valueOf == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) InAppMessageImmersiveBaseView$setupDirectionalNavigation$1.INSTANCE, 2, (Object) null);
            return;
        }
        if (i == 0) {
            messageCloseButtonView.setNextFocusUpId(valueOf.intValue());
            messageCloseButtonView.setNextFocusDownId(valueOf.intValue());
            messageCloseButtonView.setNextFocusRightId(valueOf.intValue());
            messageCloseButtonView.setNextFocusLeftId(valueOf.intValue());
        } else if (i == 1) {
            View view = messageButtonViews.get(0);
            Integer valueOf2 = Integer.valueOf(view.getId());
            view.setNextFocusLeftId(valueOf.intValue());
            view.setNextFocusRightId(valueOf.intValue());
            view.setNextFocusUpId(valueOf.intValue());
            view.setNextFocusDownId(valueOf.intValue());
            messageCloseButtonView.setNextFocusUpId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusDownId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusRightId(valueOf2.intValue());
            messageCloseButtonView.setNextFocusLeftId(valueOf2.intValue());
            messageCloseButtonView = view;
            valueOf = valueOf2;
        } else if (i != 2) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageImmersiveBaseView$setupDirectionalNavigation$2(i), 2, (Object) null);
        } else {
            View view2 = messageButtonViews.get(1);
            View view3 = messageButtonViews.get(0);
            Integer valueOf3 = Integer.valueOf(view2.getId());
            Integer valueOf4 = Integer.valueOf(view3.getId());
            view2.setNextFocusLeftId(valueOf4.intValue());
            view2.setNextFocusRightId(valueOf4.intValue());
            view2.setNextFocusUpId(valueOf.intValue());
            view2.setNextFocusDownId(valueOf.intValue());
            view3.setNextFocusLeftId(valueOf3.intValue());
            view3.setNextFocusRightId(valueOf3.intValue());
            view3.setNextFocusUpId(valueOf.intValue());
            view3.setNextFocusDownId(valueOf.intValue());
            messageCloseButtonView.setNextFocusUpId(valueOf3.intValue());
            messageCloseButtonView.setNextFocusDownId(valueOf3.intValue());
            messageCloseButtonView.setNextFocusRightId(valueOf3.intValue());
            messageCloseButtonView.setNextFocusLeftId(valueOf4.intValue());
            messageCloseButtonView = view2;
            valueOf = valueOf3;
        }
        if (valueOf != null) {
            setNextFocusUpId(valueOf.intValue());
            setNextFocusDownId(valueOf.intValue());
            setNextFocusRightId(valueOf.intValue());
            setNextFocusLeftId(valueOf.intValue());
        }
        if (Build.VERSION.SDK_INT >= 26 && messageCloseButtonView != null) {
            messageCloseButtonView.setFocusedByDefault(true);
        }
        if (messageCloseButtonView != null) {
            messageCloseButtonView.post(new InAppMessageImmersiveBaseView$$ExternalSyntheticLambda0(messageCloseButtonView));
        }
    }

    /* access modifiers changed from: private */
    public static final void setupDirectionalNavigation$lambda$0(View view) {
        view.requestFocus();
    }

    public void setMessageButtons(List<? extends MessageButton> list) {
        Intrinsics.checkNotNullParameter(list, "messageButtons");
        InAppMessageButtonViewUtils.setButtons(getMessageButtonViews(list.size()), list);
    }

    public void setMessageCloseButtonColor(int i) {
        View messageCloseButtonView = getMessageCloseButtonView();
        if (messageCloseButtonView != null) {
            InAppMessageViewUtils.setViewBackgroundColorFilter(messageCloseButtonView, i);
        }
    }

    public void setMessageHeaderTextColor(int i) {
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextViewColor(messageHeaderTextView, i);
        }
    }

    public void setMessageHeaderText(String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            messageHeaderTextView.setText(str);
        }
    }

    public void setMessageHeaderTextAlignment(TextAlign textAlign) {
        Intrinsics.checkNotNullParameter(textAlign, "textAlign");
        TextView messageHeaderTextView = getMessageHeaderTextView();
        if (messageHeaderTextView != null) {
            InAppMessageViewUtils.setTextAlignment(messageHeaderTextView, textAlign);
        }
    }

    public void setFrameColor(int i) {
        View frameView = getFrameView();
        if (frameView != null) {
            InAppMessageViewUtils.setFrameColor(frameView, Integer.valueOf(i));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (i != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.onKeyDown(i, keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (isInTouchMode() || keyEvent.getKeyCode() != 4 || !BrazeInAppMessageManager.Companion.getInstance().getDoesBackButtonDismissInAppMessageView()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        InAppMessageViewUtils.closeInAppMessageOnKeycodeBack();
        return true;
    }

    public void setLargerCloseButtonClickArea(View view) {
        if (view == null || view.getParent() == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) InAppMessageImmersiveBaseView$setLargerCloseButtonClickArea$1.INSTANCE, 2, (Object) null);
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            ((View) parent).post(new InAppMessageImmersiveBaseView$$ExternalSyntheticLambda1(view, this, parent));
        }
    }

    /* access modifiers changed from: private */
    public static final void setLargerCloseButtonClickArea$lambda$5(View view, InAppMessageImmersiveBaseView inAppMessageImmersiveBaseView, ViewParent viewParent) {
        Intrinsics.checkNotNullParameter(inAppMessageImmersiveBaseView, "this$0");
        Rect rect = new Rect();
        view.getHitRect(rect);
        int dimensionPixelSize = inAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_width);
        int dimensionPixelSize2 = inAppMessageImmersiveBaseView.getContext().getResources().getDimensionPixelSize(R.dimen.com_braze_inappmessage_close_button_click_area_height);
        int width = (dimensionPixelSize - rect.width()) / 2;
        int height = (dimensionPixelSize2 - rect.height()) / 2;
        rect.top -= height;
        rect.bottom += height;
        rect.left -= width;
        rect.right += width;
        ((View) viewParent).setTouchDelegate(new TouchDelegate(rect, view));
    }
}
