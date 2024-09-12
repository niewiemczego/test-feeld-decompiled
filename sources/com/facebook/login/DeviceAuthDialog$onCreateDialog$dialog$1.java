package com.facebook.login;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/login/DeviceAuthDialog$onCreateDialog$dialog$1", "Landroid/app/Dialog;", "onBackPressed", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: DeviceAuthDialog.kt */
public final class DeviceAuthDialog$onCreateDialog$dialog$1 extends Dialog {
    final /* synthetic */ DeviceAuthDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeviceAuthDialog$onCreateDialog$dialog$1(DeviceAuthDialog deviceAuthDialog, FragmentActivity fragmentActivity, int i) {
        super(fragmentActivity, i);
        this.this$0 = deviceAuthDialog;
    }

    public void onBackPressed() {
        if (this.this$0.onBackButtonPressed()) {
            super.onBackPressed();
        }
    }
}
