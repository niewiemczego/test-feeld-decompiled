package com.braze.ui.inappmessage.views;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/braze/ui/inappmessage/views/IInAppMessageView;", "", "hasAppliedWindowInsets", "", "getHasAppliedWindowInsets", "()Z", "setHasAppliedWindowInsets", "(Z)V", "messageClickableView", "Landroid/view/View;", "getMessageClickableView", "()Landroid/view/View;", "applyWindowInsets", "", "insets", "Landroidx/core/view/WindowInsetsCompat;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: IInAppMessageView.kt */
public interface IInAppMessageView {
    void applyWindowInsets(WindowInsetsCompat windowInsetsCompat);

    boolean getHasAppliedWindowInsets();

    View getMessageClickableView();

    void setHasAppliedWindowInsets(boolean z);
}
