package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.util.AttributeSet;
import com.braze.ui.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageHtmlView;", "Lcom/braze/ui/inappmessage/views/InAppMessageHtmlBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getWebViewViewId", "", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageHtmlView.kt */
public class InAppMessageHtmlView extends InAppMessageHtmlBaseView {
    public InAppMessageHtmlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getWebViewViewId() {
        return R.id.com_braze_inappmessage_html_webview;
    }
}
