package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Uploader$$ExternalSyntheticLambda5 implements SynchronizationGuard.CriticalSection {
    public final /* synthetic */ Uploader f$0;
    public final /* synthetic */ TransportContext f$1;

    public /* synthetic */ Uploader$$ExternalSyntheticLambda5(Uploader uploader, TransportContext transportContext) {
        this.f$0 = uploader;
        this.f$1 = transportContext;
    }

    public final Object execute() {
        return this.f$0.m415lambda$logAndUpdateState$2$comgoogleandroiddatatransportruntimeschedulingjobschedulingUploader(this.f$1);
    }
}
