package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda10 implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Uploader f$0;
    public final /* synthetic */ Map f$1;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda10(Uploader uploader, Map map) {
        this.f$0 = uploader;
        this.f$1 = map;
    }

    public final Object execute() {
        return this.f$0.m420lambda$logAndUpdateState$7$comgoogleandroiddatatransportruntimeschedulingjobschedulingUploader(this.f$1);
    }
}
