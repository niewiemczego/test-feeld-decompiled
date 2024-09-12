package com.reactnativecommunity.cameraroll;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.reactnativecommunity.cameraroll.CameraRollModule;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraRollModule$SaveToCameraRoll$$ExternalSyntheticLambda0 implements MediaScannerConnection.OnScanCompletedListener {
    public final /* synthetic */ CameraRollModule.SaveToCameraRoll f$0;

    public /* synthetic */ CameraRollModule$SaveToCameraRoll$$ExternalSyntheticLambda0(CameraRollModule.SaveToCameraRoll saveToCameraRoll) {
        this.f$0 = saveToCameraRoll;
    }

    public final void onScanCompleted(String str, Uri uri) {
        this.f$0.m617lambda$doInBackgroundGuarded$0$comreactnativecommunitycamerarollCameraRollModule$SaveToCameraRoll(str, uri);
    }
}
