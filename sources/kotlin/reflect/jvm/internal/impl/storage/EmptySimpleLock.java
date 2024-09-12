package kotlin.reflect.jvm.internal.impl.storage;

/* compiled from: locks.kt */
public final class EmptySimpleLock implements SimpleLock {
    public static final EmptySimpleLock INSTANCE = new EmptySimpleLock();

    public void lock() {
    }

    public void unlock() {
    }

    private EmptySimpleLock() {
    }
}
