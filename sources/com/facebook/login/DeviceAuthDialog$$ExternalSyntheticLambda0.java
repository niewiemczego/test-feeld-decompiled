package com.facebook.login;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceAuthDialog$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ DeviceAuthDialog f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Date f$2;
    public final /* synthetic */ Date f$3;

    public /* synthetic */ DeviceAuthDialog$$ExternalSyntheticLambda0(DeviceAuthDialog deviceAuthDialog, String str, Date date, Date date2) {
        this.f$0 = deviceAuthDialog;
        this.f$1 = str;
        this.f$2 = date;
        this.f$3 = date2;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        DeviceAuthDialog.m379onSuccess$lambda10(this.f$0, this.f$1, this.f$2, this.f$3, graphResponse);
    }
}
