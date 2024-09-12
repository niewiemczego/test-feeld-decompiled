package com.facebook.login;

import android.content.DialogInterface;
import com.facebook.login.DeviceAuthDialog;
import java.util.Date;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DeviceAuthDialog$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ DeviceAuthDialog f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ DeviceAuthDialog.PermissionsLists f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ Date f$4;
    public final /* synthetic */ Date f$5;

    public /* synthetic */ DeviceAuthDialog$$ExternalSyntheticLambda1(DeviceAuthDialog deviceAuthDialog, String str, DeviceAuthDialog.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.f$0 = deviceAuthDialog;
        this.f$1 = str;
        this.f$2 = permissionsLists;
        this.f$3 = str2;
        this.f$4 = date;
        this.f$5 = date2;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        DeviceAuthDialog.m380presentConfirmation$lambda6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
    }
}
