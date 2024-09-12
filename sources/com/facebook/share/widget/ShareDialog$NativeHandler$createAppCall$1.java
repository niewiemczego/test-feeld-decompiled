package com.facebook.share.widget;

import android.os.Bundle;
import com.facebook.internal.AppCall;
import com.facebook.internal.DialogPresenter;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.model.ShareContent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"com/facebook/share/widget/ShareDialog$NativeHandler$createAppCall$1", "Lcom/facebook/internal/DialogPresenter$ParameterProvider;", "legacyParameters", "Landroid/os/Bundle;", "getLegacyParameters", "()Landroid/os/Bundle;", "parameters", "getParameters", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ShareDialog.kt */
public final class ShareDialog$NativeHandler$createAppCall$1 implements DialogPresenter.ParameterProvider {
    final /* synthetic */ AppCall $appCall;
    final /* synthetic */ ShareContent<?, ?> $content;
    final /* synthetic */ boolean $shouldFailOnDataError;

    ShareDialog$NativeHandler$createAppCall$1(AppCall appCall, ShareContent<?, ?> shareContent, boolean z) {
        this.$appCall = appCall;
        this.$content = shareContent;
        this.$shouldFailOnDataError = z;
    }

    public Bundle getParameters() {
        NativeDialogParameters nativeDialogParameters = NativeDialogParameters.INSTANCE;
        return NativeDialogParameters.create(this.$appCall.getCallId(), this.$content, this.$shouldFailOnDataError);
    }

    public Bundle getLegacyParameters() {
        LegacyNativeDialogParameters legacyNativeDialogParameters = LegacyNativeDialogParameters.INSTANCE;
        return LegacyNativeDialogParameters.create(this.$appCall.getCallId(), this.$content, this.$shouldFailOnDataError);
    }
}
