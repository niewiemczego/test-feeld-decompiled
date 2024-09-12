package com.braze.ui.inappmessage.views;

import android.view.View;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/views/IInAppMessageImmersiveView;", "Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "messageCloseButtonView", "Landroid/view/View;", "getMessageCloseButtonView", "()Landroid/view/View;", "getMessageButtonViews", "", "numButtons", "", "setupDirectionalNavigation", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IInAppMessageImmersiveView.kt */
public interface IInAppMessageImmersiveView extends IInAppMessageView {
    List<View> getMessageButtonViews(int i);

    View getMessageCloseButtonView();

    void setupDirectionalNavigation(int i);
}
