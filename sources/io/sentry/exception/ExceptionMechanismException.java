package io.sentry.exception;

import io.sentry.protocol.Mechanism;
import io.sentry.util.Objects;

public final class ExceptionMechanismException extends RuntimeException {
    private static final long serialVersionUID = 142345454265713915L;
    private final Mechanism exceptionMechanism;
    private final boolean snapshot;
    private final Thread thread;
    private final Throwable throwable;

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread2, boolean z) {
        this.exceptionMechanism = (Mechanism) Objects.requireNonNull(mechanism, "Mechanism is required.");
        this.throwable = (Throwable) Objects.requireNonNull(th, "Throwable is required.");
        this.thread = (Thread) Objects.requireNonNull(thread2, "Thread is required.");
        this.snapshot = z;
    }

    public ExceptionMechanismException(Mechanism mechanism, Throwable th, Thread thread2) {
        this(mechanism, th, thread2, false);
    }

    public Mechanism getExceptionMechanism() {
        return this.exceptionMechanism;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public Thread getThread() {
        return this.thread;
    }

    public boolean isSnapshot() {
        return this.snapshot;
    }
}
