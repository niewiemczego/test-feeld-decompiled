package com.facebook.appevents.ml;

import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.ml.ModelManager;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ModelManager$TaskHandler$Companion$$ExternalSyntheticLambda1 implements FileDownloadTask.Callback {
    public final /* synthetic */ ModelManager.TaskHandler f$0;
    public final /* synthetic */ Model f$1;

    public /* synthetic */ ModelManager$TaskHandler$Companion$$ExternalSyntheticLambda1(ModelManager.TaskHandler taskHandler, Model model) {
        this.f$0 = taskHandler;
        this.f$1 = model;
    }

    public final void onComplete(File file) {
        ModelManager.TaskHandler.Companion.m285execute$lambda1$lambda0(this.f$0, this.f$1, file);
    }
}
