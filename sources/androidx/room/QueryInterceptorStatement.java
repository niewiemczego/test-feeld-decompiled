package androidx.room;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\t\u0010\u001a\u001a\u00020\u000eH\u0001J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u001a\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010 \u001a\u00020\u0016H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/room/QueryInterceptorStatement;", "Landroidx/sqlite/db/SupportSQLiteStatement;", "delegate", "sqlStatement", "", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/String;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "bindArgsCache", "", "", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "clearBindings", "close", "execute", "executeInsert", "executeUpdateDelete", "saveArgsToCache", "bindIndex", "simpleQueryForLong", "simpleQueryForString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryInterceptorStatement.kt */
public final class QueryInterceptorStatement implements SupportSQLiteStatement {
    private final List<Object> bindArgsCache = new ArrayList();
    private final SupportSQLiteStatement delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;
    private final String sqlStatement;

    public void close() {
        this.delegate.close();
    }

    public QueryInterceptorStatement(SupportSQLiteStatement supportSQLiteStatement, String str, Executor executor, RoomDatabase.QueryCallback queryCallback2) {
        Intrinsics.checkNotNullParameter(supportSQLiteStatement, "delegate");
        Intrinsics.checkNotNullParameter(str, "sqlStatement");
        Intrinsics.checkNotNullParameter(executor, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteStatement;
        this.sqlStatement = str;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    public void execute() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda1(this));
        this.delegate.execute();
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$0(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public int executeUpdateDelete() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda0(this));
        return this.delegate.executeUpdateDelete();
    }

    /* access modifiers changed from: private */
    public static final void executeUpdateDelete$lambda$1(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public long executeInsert() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda2(this));
        return this.delegate.executeInsert();
    }

    /* access modifiers changed from: private */
    public static final void executeInsert$lambda$2(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public long simpleQueryForLong() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda4(this));
        return this.delegate.simpleQueryForLong();
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForLong$lambda$3(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public String simpleQueryForString() {
        this.queryCallbackExecutor.execute(new QueryInterceptorStatement$$ExternalSyntheticLambda3(this));
        return this.delegate.simpleQueryForString();
    }

    /* access modifiers changed from: private */
    public static final void simpleQueryForString$lambda$4(QueryInterceptorStatement queryInterceptorStatement) {
        Intrinsics.checkNotNullParameter(queryInterceptorStatement, "this$0");
        queryInterceptorStatement.queryCallback.onQuery(queryInterceptorStatement.sqlStatement, queryInterceptorStatement.bindArgsCache);
    }

    public void bindNull(int i) {
        Object[] array = this.bindArgsCache.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        saveArgsToCache(i, Arrays.copyOf(array, array.length));
        this.delegate.bindNull(i);
    }

    public void bindLong(int i, long j) {
        saveArgsToCache(i, Long.valueOf(j));
        this.delegate.bindLong(i, j);
    }

    public void bindDouble(int i, double d) {
        saveArgsToCache(i, Double.valueOf(d));
        this.delegate.bindDouble(i, d);
    }

    public void bindString(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        saveArgsToCache(i, str);
        this.delegate.bindString(i, str);
    }

    public void bindBlob(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "value");
        saveArgsToCache(i, bArr);
        this.delegate.bindBlob(i, bArr);
    }

    public void clearBindings() {
        this.bindArgsCache.clear();
        this.delegate.clearBindings();
    }

    private final void saveArgsToCache(int i, Object obj) {
        int i2 = i - 1;
        if (i2 >= this.bindArgsCache.size()) {
            int size = (i2 - this.bindArgsCache.size()) + 1;
            for (int i3 = 0; i3 < size; i3++) {
                this.bindArgsCache.add((Object) null);
            }
        }
        this.bindArgsCache.set(i2, obj);
    }
}
