package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryStackFrame;
import io.sentry.protocol.SentryStackTrace;
import io.sentry.protocol.SentryThread;
import io.sentry.util.Objects;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;

public final class SentryExceptionFactory {
    private final SentryStackTraceFactory sentryStackTraceFactory;

    public SentryExceptionFactory(SentryStackTraceFactory sentryStackTraceFactory2) {
        this.sentryStackTraceFactory = (SentryStackTraceFactory) Objects.requireNonNull(sentryStackTraceFactory2, "The SentryStackTraceFactory is required.");
    }

    public List<SentryException> getSentryExceptionsFromThread(SentryThread sentryThread, Mechanism mechanism, Throwable th) {
        SentryStackTrace stacktrace = sentryThread.getStacktrace();
        if (stacktrace == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(getSentryException(th, mechanism, sentryThread.getId(), stacktrace.getFrames(), true));
        return arrayList;
    }

    public List<SentryException> getSentryExceptions(Throwable th) {
        return getSentryExceptions(extractExceptionQueue(th));
    }

    private List<SentryException> getSentryExceptions(Deque<SentryException> deque) {
        return new ArrayList(deque);
    }

    private SentryException getSentryException(Throwable th, Mechanism mechanism, Long l, List<SentryStackFrame> list, boolean z) {
        Package packageR = th.getClass().getPackage();
        String name = th.getClass().getName();
        SentryException sentryException = new SentryException();
        String message = th.getMessage();
        if (packageR != null) {
            name = name.replace(packageR.getName() + ".", "");
        }
        String name2 = packageR != null ? packageR.getName() : null;
        if (list != null && !list.isEmpty()) {
            SentryStackTrace sentryStackTrace = new SentryStackTrace(list);
            if (z) {
                sentryStackTrace.setSnapshot(true);
            }
            sentryException.setStacktrace(sentryStackTrace);
        }
        sentryException.setThreadId(l);
        sentryException.setType(name);
        sentryException.setMechanism(mechanism);
        sentryException.setModule(name2);
        sentryException.setValue(message);
        return sentryException;
    }

    /* access modifiers changed from: package-private */
    public Deque<SentryException> extractExceptionQueue(Throwable th) {
        boolean z;
        Mechanism mechanism;
        Thread thread;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th != null && hashSet.add(th)) {
            boolean z2 = false;
            if (th instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) th;
                Mechanism exceptionMechanism = exceptionMechanismException.getExceptionMechanism();
                Throwable throwable = exceptionMechanismException.getThrowable();
                thread = exceptionMechanismException.getThread();
                z = exceptionMechanismException.isSnapshot();
                mechanism = exceptionMechanism;
                th = throwable;
            } else {
                thread = Thread.currentThread();
                mechanism = null;
                z = false;
            }
            if (mechanism != null && Boolean.FALSE.equals(mechanism.isHandled())) {
                z2 = true;
            }
            arrayDeque.addFirst(getSentryException(th, mechanism, Long.valueOf(thread.getId()), this.sentryStackTraceFactory.getStackFrames(th.getStackTrace(), z2), z));
            th = th.getCause();
        }
        return arrayDeque;
    }
}
