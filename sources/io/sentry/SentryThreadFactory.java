package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SentryThreadFactory {
    private final SentryOptions options;
    private final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryThreadFactory(SentryStackTraceFactory sentryStackTraceFactory2, SentryOptions sentryOptions) {
        this.sentryStackTraceFactory = (SentryStackTraceFactory) Objects.requireNonNull(sentryStackTraceFactory2, "The SentryStackTraceFactory is required.");
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "The SentryOptions is required");
    }

    /* access modifiers changed from: package-private */
    public List<SentryThread> getCurrentThread() {
        HashMap hashMap = new HashMap();
        Thread currentThread = Thread.currentThread();
        hashMap.put(currentThread, currentThread.getStackTrace());
        return getCurrentThreads(hashMap, (List<Long>) null, false);
    }

    /* access modifiers changed from: package-private */
    public List<SentryThread> getCurrentThreads(List<Long> list, boolean z) {
        return getCurrentThreads(Thread.getAllStackTraces(), list, z);
    }

    /* access modifiers changed from: package-private */
    public List<SentryThread> getCurrentThreads(List<Long> list) {
        return getCurrentThreads(Thread.getAllStackTraces(), list, false);
    }

    /* access modifiers changed from: package-private */
    public List<SentryThread> getCurrentThreads(Map<Thread, StackTraceElement[]> map, List<Long> list, boolean z) {
        Thread currentThread = Thread.currentThread();
        if (map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!map.containsKey(currentThread)) {
            map.put(currentThread, currentThread.getStackTrace());
        }
        for (Map.Entry next : map.entrySet()) {
            Thread thread = (Thread) next.getKey();
            arrayList.add(getSentryThread((thread == currentThread && !z) || (list != null && list.contains(Long.valueOf(thread.getId()))), (StackTraceElement[]) next.getValue(), (Thread) next.getKey()));
        }
        return arrayList;
    }

    private SentryThread getSentryThread(boolean z, StackTraceElement[] stackTraceElementArr, Thread thread) {
        SentryThread sentryThread = new SentryThread();
        sentryThread.setName(thread.getName());
        sentryThread.setPriority(Integer.valueOf(thread.getPriority()));
        sentryThread.setId(Long.valueOf(thread.getId()));
        sentryThread.setDaemon(Boolean.valueOf(thread.isDaemon()));
        sentryThread.setState(thread.getState().name());
        sentryThread.setCrashed(Boolean.valueOf(z));
        List<SentryStackFrame> stackFrames = this.sentryStackTraceFactory.getStackFrames(stackTraceElementArr, false);
        if (this.options.isAttachStacktrace() && stackFrames != null && !stackFrames.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(stackFrames);
            sentryStackTrace.setSnapshot(true);
            sentryThread.setStacktrace(sentryStackTrace);
        }
        return sentryThread;
    }
}
