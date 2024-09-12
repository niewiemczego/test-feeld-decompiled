package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

public class WorkInitializer {
    private final Executor executor;
    private final SynchronizationGuard guard;
    private final WorkScheduler scheduler;
    private final EventStore store;

    @Inject
    WorkInitializer(Executor executor2, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.executor = executor2;
        this.store = eventStore;
        this.scheduler = workScheduler;
        this.guard = synchronizationGuard;
    }

    public void ensureContextsScheduled() {
        this.executor.execute(new WorkInitializer$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ensureContextsScheduled$1$com-google-android-datatransport-runtime-scheduling-jobscheduling-WorkInitializer  reason: not valid java name */
    public /* synthetic */ void m425lambda$ensureContextsScheduled$1$comgoogleandroiddatatransportruntimeschedulingjobschedulingWorkInitializer() {
        this.guard.runCriticalSection(new WorkInitializer$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$ensureContextsScheduled$0$com-google-android-datatransport-runtime-scheduling-jobscheduling-WorkInitializer  reason: not valid java name */
    public /* synthetic */ Object m424lambda$ensureContextsScheduled$0$comgoogleandroiddatatransportruntimeschedulingjobschedulingWorkInitializer() {
        for (TransportContext schedule : this.store.loadActiveContexts()) {
            this.scheduler.schedule(schedule, 1);
        }
        return null;
    }
}
