package androidx.room;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J%\u00106\u001a\u0002H7\"\u0004\b\u0000\u001072\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H709¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u00020\rJ\u000e\u0010<\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020\u000bR\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R \u0010\f\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001e\u0010\u001f\u001a\u00020\u00038\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010&\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0000@\u0000X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020,8AX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010.¨\u0006@"}, d2 = {"Landroidx/room/AutoCloser;", "", "autoCloseTimeoutAmount", "", "autoCloseTimeUnit", "Ljava/util/concurrent/TimeUnit;", "autoCloseExecutor", "Ljava/util/concurrent/Executor;", "(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/Executor;)V", "autoCloseTimeoutInMs", "autoCloser", "Ljava/lang/Runnable;", "delegateDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getDelegateDatabase$room_runtime_release", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "setDelegateDatabase$room_runtime_release", "(Landroidx/sqlite/db/SupportSQLiteDatabase;)V", "delegateOpenHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getDelegateOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "setDelegateOpenHelper", "(Landroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "executeAutoCloser", "executor", "handler", "Landroid/os/Handler;", "isActive", "", "()Z", "lastDecrementRefCountTimeStamp", "getLastDecrementRefCountTimeStamp$room_runtime_release", "()J", "setLastDecrementRefCountTimeStamp$room_runtime_release", "(J)V", "lock", "manuallyClosed", "onAutoCloseCallback", "getOnAutoCloseCallback$room_runtime_release", "()Ljava/lang/Runnable;", "setOnAutoCloseCallback$room_runtime_release", "(Ljava/lang/Runnable;)V", "refCount", "", "getRefCount$room_runtime_release", "()I", "setRefCount$room_runtime_release", "(I)V", "refCountForTest", "getRefCountForTest$room_runtime_release", "closeDatabaseIfOpen", "", "decrementCountAndScheduleClose", "executeRefCountingFunction", "V", "block", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "incrementCountAndEnsureDbIsOpen", "init", "setAutoCloseCallback", "onAutoClose", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AutoCloser.kt */
public final class AutoCloser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String autoCloseBug = "https://issuetracker.google.com/issues/new?component=413107&template=1096568";
    private long autoCloseTimeoutInMs;
    private final Runnable autoCloser;
    private SupportSQLiteDatabase delegateDatabase;
    public SupportSQLiteOpenHelper delegateOpenHelper;
    private final Runnable executeAutoCloser;
    private final Executor executor;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private long lastDecrementRefCountTimeStamp;
    private final Object lock = new Object();
    private boolean manuallyClosed;
    private Runnable onAutoCloseCallback;
    private int refCount;

    public AutoCloser(long j, TimeUnit timeUnit, Executor executor2) {
        Intrinsics.checkNotNullParameter(timeUnit, "autoCloseTimeUnit");
        Intrinsics.checkNotNullParameter(executor2, "autoCloseExecutor");
        this.autoCloseTimeoutInMs = timeUnit.toMillis(j);
        this.executor = executor2;
        this.lastDecrementRefCountTimeStamp = SystemClock.uptimeMillis();
        this.executeAutoCloser = new AutoCloser$$ExternalSyntheticLambda0(this);
        this.autoCloser = new AutoCloser$$ExternalSyntheticLambda1(this);
    }

    public final SupportSQLiteOpenHelper getDelegateOpenHelper() {
        SupportSQLiteOpenHelper supportSQLiteOpenHelper = this.delegateOpenHelper;
        if (supportSQLiteOpenHelper != null) {
            return supportSQLiteOpenHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegateOpenHelper");
        return null;
    }

    public final void setDelegateOpenHelper(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "<set-?>");
        this.delegateOpenHelper = supportSQLiteOpenHelper;
    }

    public final Runnable getOnAutoCloseCallback$room_runtime_release() {
        return this.onAutoCloseCallback;
    }

    public final void setOnAutoCloseCallback$room_runtime_release(Runnable runnable) {
        this.onAutoCloseCallback = runnable;
    }

    public final int getRefCount$room_runtime_release() {
        return this.refCount;
    }

    public final void setRefCount$room_runtime_release(int i) {
        this.refCount = i;
    }

    public final long getLastDecrementRefCountTimeStamp$room_runtime_release() {
        return this.lastDecrementRefCountTimeStamp;
    }

    public final void setLastDecrementRefCountTimeStamp$room_runtime_release(long j) {
        this.lastDecrementRefCountTimeStamp = j;
    }

    public final SupportSQLiteDatabase getDelegateDatabase$room_runtime_release() {
        return this.delegateDatabase;
    }

    public final void setDelegateDatabase$room_runtime_release(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.delegateDatabase = supportSQLiteDatabase;
    }

    /* access modifiers changed from: private */
    public static final void executeAutoCloser$lambda$0(AutoCloser autoCloser2) {
        Intrinsics.checkNotNullParameter(autoCloser2, "this$0");
        autoCloser2.executor.execute(autoCloser2.autoCloser);
    }

    /* access modifiers changed from: private */
    public static final void autoCloser$lambda$3(AutoCloser autoCloser2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(autoCloser2, "this$0");
        synchronized (autoCloser2.lock) {
            if (SystemClock.uptimeMillis() - autoCloser2.lastDecrementRefCountTimeStamp >= autoCloser2.autoCloseTimeoutInMs) {
                if (autoCloser2.refCount == 0) {
                    Runnable runnable = autoCloser2.onAutoCloseCallback;
                    if (runnable != null) {
                        runnable.run();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit != null) {
                        SupportSQLiteDatabase supportSQLiteDatabase = autoCloser2.delegateDatabase;
                        if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                            supportSQLiteDatabase.close();
                        }
                        autoCloser2.delegateDatabase = null;
                        Unit unit2 = Unit.INSTANCE;
                        return;
                    }
                    throw new IllegalStateException("onAutoCloseCallback is null but it should have been set before use. Please file a bug against Room at: https://issuetracker.google.com/issues/new?component=413107&template=1096568".toString());
                }
            }
        }
    }

    public final void init(SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "delegateOpenHelper");
        setDelegateOpenHelper(supportSQLiteOpenHelper);
    }

    public final <V> V executeRefCountingFunction(Function1<? super SupportSQLiteDatabase, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            return function1.invoke(incrementCountAndEnsureDbIsOpen());
        } finally {
            decrementCountAndScheduleClose();
        }
    }

    public final SupportSQLiteDatabase incrementCountAndEnsureDbIsOpen() {
        synchronized (this.lock) {
            this.handler.removeCallbacks(this.executeAutoCloser);
            this.refCount++;
            if (!this.manuallyClosed) {
                SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
                if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
                    return supportSQLiteDatabase;
                }
                SupportSQLiteDatabase writableDatabase = getDelegateOpenHelper().getWritableDatabase();
                this.delegateDatabase = writableDatabase;
                return writableDatabase;
            }
            throw new IllegalStateException("Attempting to open already closed database.".toString());
        }
    }

    public final void decrementCountAndScheduleClose() {
        synchronized (this.lock) {
            int i = this.refCount;
            if (i > 0) {
                int i2 = i - 1;
                this.refCount = i2;
                if (i2 == 0) {
                    if (this.delegateDatabase != null) {
                        this.handler.postDelayed(this.executeAutoCloser, this.autoCloseTimeoutInMs);
                    } else {
                        return;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return;
            }
            throw new IllegalStateException("ref count is 0 or lower but we're supposed to decrement".toString());
        }
    }

    public final void closeDatabaseIfOpen() throws IOException {
        synchronized (this.lock) {
            this.manuallyClosed = true;
            SupportSQLiteDatabase supportSQLiteDatabase = this.delegateDatabase;
            if (supportSQLiteDatabase != null) {
                supportSQLiteDatabase.close();
            }
            this.delegateDatabase = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean isActive() {
        return !this.manuallyClosed;
    }

    public final int getRefCountForTest$room_runtime_release() {
        int i;
        synchronized (this.lock) {
            i = this.refCount;
        }
        return i;
    }

    public final void setAutoCloseCallback(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "onAutoClose");
        this.onAutoCloseCallback = runnable;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/AutoCloser$Companion;", "", "()V", "autoCloseBug", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AutoCloser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
