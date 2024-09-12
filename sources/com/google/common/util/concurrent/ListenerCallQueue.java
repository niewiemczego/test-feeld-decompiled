package com.google.common.util.concurrent;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@ElementTypesAreNonnullByDefault
final class ListenerCallQueue<L> {
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final List<PerListenerQueue<L>> listeners = Collections.synchronizedList(new ArrayList());

    interface Event<L> {
        void call(L l);
    }

    ListenerCallQueue() {
    }

    public void addListener(L l, Executor executor) {
        Preconditions.checkNotNull(l, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Preconditions.checkNotNull(executor, "executor");
        this.listeners.add(new PerListenerQueue(l, executor));
    }

    public void enqueue(Event<L> event) {
        enqueueHelper(event, event);
    }

    public void enqueue(Event<L> event, String str) {
        enqueueHelper(event, str);
    }

    private void enqueueHelper(Event<L> event, Object obj) {
        Preconditions.checkNotNull(event, "event");
        Preconditions.checkNotNull(obj, "label");
        synchronized (this.listeners) {
            for (PerListenerQueue<L> add : this.listeners) {
                add.add(event, obj);
            }
        }
    }

    public void dispatch() {
        for (int i = 0; i < this.listeners.size(); i++) {
            this.listeners.get(i).dispatch();
        }
    }

    private static final class PerListenerQueue<L> implements Runnable {
        final Executor executor;
        boolean isThreadScheduled;
        final Queue<Object> labelQueue = Queues.newArrayDeque();
        final L listener;
        final Queue<Event<L>> waitQueue = Queues.newArrayDeque();

        PerListenerQueue(L l, Executor executor2) {
            this.listener = Preconditions.checkNotNull(l);
            this.executor = (Executor) Preconditions.checkNotNull(executor2);
        }

        /* access modifiers changed from: package-private */
        public synchronized void add(Event<L> event, Object obj) {
            this.waitQueue.add(event);
            this.labelQueue.add(obj);
        }

        /* access modifiers changed from: package-private */
        public void dispatch() {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.isThreadScheduled) {
                    this.isThreadScheduled = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                try {
                    this.executor.execute(this);
                } catch (RuntimeException e) {
                    synchronized (this) {
                        this.isThreadScheduled = false;
                        Logger access$000 = ListenerCallQueue.logger;
                        Level level = Level.SEVERE;
                        String valueOf = String.valueOf(this.listener);
                        String valueOf2 = String.valueOf(this.executor);
                        access$000.log(level, new StringBuilder(String.valueOf(valueOf).length() + 42 + String.valueOf(valueOf2).length()).append("Exception while running callbacks for ").append(valueOf).append(" on ").append(valueOf2).toString(), e);
                        throw e;
                    }
                }
            }
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
            	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
            */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                r0 = 0
                r1 = 1
                monitor-enter(r10)     // Catch:{ all -> 0x0078 }
                boolean r2 = r10.isThreadScheduled     // Catch:{ all -> 0x006b }
                com.google.common.base.Preconditions.checkState(r2)     // Catch:{ all -> 0x006b }
                java.util.Queue<com.google.common.util.concurrent.ListenerCallQueue$Event<L>> r2 = r10.waitQueue     // Catch:{ all -> 0x006b }
                java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x006b }
                com.google.common.util.concurrent.ListenerCallQueue$Event r2 = (com.google.common.util.concurrent.ListenerCallQueue.Event) r2     // Catch:{ all -> 0x006b }
                java.util.Queue<java.lang.Object> r3 = r10.labelQueue     // Catch:{ all -> 0x006b }
                java.lang.Object r3 = r3.poll()     // Catch:{ all -> 0x006b }
                if (r2 != 0) goto L_0x001f
                r10.isThreadScheduled = r0     // Catch:{ all -> 0x006b }
                monitor-exit(r10)     // Catch:{ all -> 0x001c }
                return
            L_0x001c:
                r1 = move-exception
                r2 = r0
                goto L_0x006f
            L_0x001f:
                monitor-exit(r10)     // Catch:{ all -> 0x006b }
                L r4 = r10.listener     // Catch:{ RuntimeException -> 0x0026 }
                r2.call(r4)     // Catch:{ RuntimeException -> 0x0026 }
                goto L_0x0000
            L_0x0026:
                r2 = move-exception
                java.util.logging.Logger r4 = com.google.common.util.concurrent.ListenerCallQueue.logger     // Catch:{ all -> 0x0078 }
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch:{ all -> 0x0078 }
                L r6 = r10.listener     // Catch:{ all -> 0x0078 }
                java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0078 }
                java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0078 }
                java.lang.String r7 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x0078 }
                int r7 = r7.length()     // Catch:{ all -> 0x0078 }
                int r7 = r7 + 37
                java.lang.String r8 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0078 }
                int r8 = r8.length()     // Catch:{ all -> 0x0078 }
                int r7 = r7 + r8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
                r8.<init>(r7)     // Catch:{ all -> 0x0078 }
                java.lang.String r7 = "Exception while executing callback: "
                java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ all -> 0x0078 }
                java.lang.StringBuilder r6 = r7.append(r6)     // Catch:{ all -> 0x0078 }
                java.lang.String r7 = " "
                java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ all -> 0x0078 }
                java.lang.StringBuilder r3 = r6.append(r3)     // Catch:{ all -> 0x0078 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0078 }
                r4.log(r5, r3, r2)     // Catch:{ all -> 0x0078 }
                goto L_0x0000
            L_0x006b:
                r2 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
            L_0x006f:
                monitor-exit(r10)     // Catch:{ all -> 0x0076 }
                throw r1     // Catch:{ all -> 0x0071 }
            L_0x0071:
                r1 = move-exception
                r9 = r2
                r2 = r1
                r1 = r9
                goto L_0x0079
            L_0x0076:
                r1 = move-exception
                goto L_0x006f
            L_0x0078:
                r2 = move-exception
            L_0x0079:
                if (r1 == 0) goto L_0x0083
                monitor-enter(r10)
                r10.isThreadScheduled = r0     // Catch:{ all -> 0x0080 }
                monitor-exit(r10)     // Catch:{ all -> 0x0080 }
                goto L_0x0083
            L_0x0080:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0080 }
                throw r0
            L_0x0083:
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.ListenerCallQueue.PerListenerQueue.run():void");
        }
    }
}
