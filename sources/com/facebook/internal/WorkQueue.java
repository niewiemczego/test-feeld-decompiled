package com.facebook.internal;

import com.facebook.FacebookException;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007J\u0014\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\bR\u00020\u0000H\u0002J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\bR\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/facebook/internal/WorkQueue;", "", "maxConcurrent", "", "executor", "Ljava/util/concurrent/Executor;", "(ILjava/util/concurrent/Executor;)V", "pendingJobs", "Lcom/facebook/internal/WorkQueue$WorkNode;", "runningCount", "runningJobs", "workLock", "Ljava/util/concurrent/locks/ReentrantLock;", "addActiveWorkItem", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "addToFront", "", "execute", "", "node", "finishItemAndStartNew", "finished", "startItem", "validate", "Companion", "WorkItem", "WorkNode", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WorkQueue.kt */
public final class WorkQueue {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    /* access modifiers changed from: private */
    public WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    /* access modifiers changed from: private */
    public final ReentrantLock workLock;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkItem;", "", "isRunning", "", "()Z", "cancel", "moveToFront", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    public WorkQueue() {
        this(0, (Executor) null, 3, (DefaultConstructorMarker) null);
    }

    public WorkQueue(int i) {
        this(i, (Executor) null, 2, (DefaultConstructorMarker) null);
    }

    public final WorkItem addActiveWorkItem(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "callback");
        return addActiveWorkItem$default(this, runnable, false, 2, (Object) null);
    }

    public WorkQueue(int i, Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.maxConcurrent = i;
        this.executor = executor2;
        this.workLock = new ReentrantLock();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkQueue(int r1, java.util.concurrent.Executor r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0006
            r1 = 8
        L_0x0006:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0010
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE
            java.util.concurrent.Executor r2 = com.facebook.FacebookSdk.getExecutor()
        L_0x0010:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.WorkQueue.<init>(int, java.util.concurrent.Executor, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/internal/WorkQueue$Companion;", "", "()V", "DEFAULT_MAX_CONCURRENT", "", "assert", "", "condition", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        /* renamed from: assert  reason: not valid java name */
        public final void m353assert(boolean z) {
            if (!z) {
                throw new FacebookException("Validation failed");
            }
        }
    }

    public static /* synthetic */ WorkItem addActiveWorkItem$default(WorkQueue workQueue, Runnable runnable, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return workQueue.addActiveWorkItem(runnable, z);
    }

    /* JADX INFO: finally extract failed */
    public final WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        Intrinsics.checkNotNullParameter(runnable, "callback");
        WorkNode workNode = new WorkNode(this, runnable);
        Lock lock = this.workLock;
        lock.lock();
        try {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
            Unit unit = Unit.INSTANCE;
            lock.unlock();
            startItem();
            return workNode;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    public final void validate() {
        Lock lock = this.workLock;
        lock.lock();
        try {
            WorkNode workNode = this.runningJobs;
            boolean z = false;
            int i = 0;
            if (workNode != null) {
                while (workNode != null) {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                    if (workNode == this.runningJobs) {
                    }
                }
                throw new IllegalStateException("Required value was null.".toString());
            }
            Companion companion = Companion;
            if (this.runningCount == i) {
                z = true;
            }
            companion.m353assert(z);
            Unit unit = Unit.INSTANCE;
        } finally {
            lock.unlock();
        }
    }

    private final void startItem() {
        finishItemAndStartNew((WorkNode) null);
    }

    private final void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2;
        this.workLock.lock();
        if (workNode != null) {
            this.runningJobs = workNode.removeFromList(this.runningJobs);
            this.runningCount--;
        }
        if (this.runningCount < this.maxConcurrent) {
            workNode2 = this.pendingJobs;
            if (workNode2 != null) {
                this.pendingJobs = workNode2.removeFromList(workNode2);
                this.runningJobs = workNode2.addToList(this.runningJobs, false);
                this.runningCount++;
                workNode2.setRunning(true);
            }
        } else {
            workNode2 = null;
        }
        this.workLock.unlock();
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private final void execute(WorkNode workNode) {
        this.executor.execute(new WorkQueue$$ExternalSyntheticLambda0(workNode, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-2  reason: not valid java name */
    public static final void m352execute$lambda2(WorkNode workNode, WorkQueue workQueue) {
        Intrinsics.checkNotNullParameter(workNode, "$node");
        Intrinsics.checkNotNullParameter(workQueue, "this$0");
        try {
            workNode.getCallback().run();
        } finally {
            workQueue.finishItemAndStartNew(workNode);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00060\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\r2\u0006\u0010\u0014\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\rJ\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\u000e\u001a\b\u0018\u00010\u0000R\u00020\r2\f\u0010\f\u001a\b\u0018\u00010\u0000R\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\b\u0018\u00010\u0000R\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/facebook/internal/WorkQueue$WorkNode;", "Lcom/facebook/internal/WorkQueue$WorkItem;", "callback", "Ljava/lang/Runnable;", "(Lcom/facebook/internal/WorkQueue;Ljava/lang/Runnable;)V", "getCallback", "()Ljava/lang/Runnable;", "isRunning", "", "()Z", "setRunning", "(Z)V", "<set-?>", "Lcom/facebook/internal/WorkQueue;", "next", "getNext", "()Lcom/facebook/internal/WorkQueue$WorkNode;", "prev", "addToList", "list", "addToFront", "cancel", "moveToFront", "", "removeFromList", "verify", "shouldBeRunning", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WorkQueue.kt */
    private final class WorkNode implements WorkItem {
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;
        final /* synthetic */ WorkQueue this$0;

        public WorkNode(WorkQueue workQueue, Runnable runnable) {
            Intrinsics.checkNotNullParameter(workQueue, "this$0");
            Intrinsics.checkNotNullParameter(runnable, "callback");
            this.this$0 = workQueue;
            this.callback = runnable;
        }

        public final Runnable getCallback() {
            return this.callback;
        }

        public final WorkNode getNext() {
            return this.next;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void setRunning(boolean z) {
            this.isRunning = z;
        }

        public boolean cancel() {
            Lock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    return true;
                }
                Unit unit = Unit.INSTANCE;
                access$getWorkLock$p.unlock();
                return false;
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public void moveToFront() {
            Lock access$getWorkLock$p = this.this$0.workLock;
            WorkQueue workQueue = this.this$0;
            access$getWorkLock$p.lock();
            try {
                if (!isRunning()) {
                    workQueue.pendingJobs = removeFromList(workQueue.pendingJobs);
                    workQueue.pendingJobs = addToList(workQueue.pendingJobs, true);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                access$getWorkLock$p.unlock();
            }
        }

        public final WorkNode addToList(WorkNode workNode, boolean z) {
            boolean z2 = true;
            WorkQueue.Companion.m353assert(this.next == null);
            Companion companion = WorkQueue.Companion;
            if (this.prev != null) {
                z2 = false;
            }
            companion.m353assert(z2);
            if (workNode == null) {
                this.prev = this;
                this.next = this;
                workNode = this;
            } else {
                this.next = workNode;
                WorkNode workNode2 = workNode.prev;
                this.prev = workNode2;
                if (workNode2 != null) {
                    workNode2.next = this;
                }
                WorkNode workNode3 = this.next;
                if (workNode3 != null) {
                    workNode3.prev = workNode2 == null ? null : workNode2.next;
                }
            }
            if (workNode != null) {
                return z ? this : workNode;
            }
            throw new IllegalStateException("Required value was null.".toString());
        }

        public final WorkNode removeFromList(WorkNode workNode) {
            boolean z = true;
            WorkQueue.Companion.m353assert(this.next != null);
            Companion companion = WorkQueue.Companion;
            if (this.prev == null) {
                z = false;
            }
            companion.m353assert(z);
            if (workNode == this && (workNode = this.next) == this) {
                WorkNode workNode2 = null;
                workNode = null;
            }
            WorkNode workNode3 = this.next;
            if (workNode3 != null) {
                workNode3.prev = this.prev;
            }
            WorkNode workNode4 = this.prev;
            if (workNode4 != null) {
                workNode4.next = workNode3;
            }
            this.prev = null;
            this.next = null;
            return workNode;
        }

        public final void verify(boolean z) {
            WorkNode workNode;
            WorkNode workNode2;
            Companion companion = WorkQueue.Companion;
            WorkNode workNode3 = this.prev;
            if (workNode3 == null || (workNode = workNode3.next) == null) {
                workNode = this;
            }
            boolean z2 = true;
            companion.m353assert(workNode == this);
            Companion companion2 = WorkQueue.Companion;
            WorkNode workNode4 = this.next;
            if (workNode4 == null || (workNode2 = workNode4.prev) == null) {
                workNode2 = this;
            }
            companion2.m353assert(workNode2 == this);
            Companion companion3 = WorkQueue.Companion;
            if (isRunning() != z) {
                z2 = false;
            }
            companion3.m353assert(z2);
        }
    }
}
