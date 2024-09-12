package androidx.room;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\t\u0010.\u001a\u00020(H\u0001J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u000bH\u0016J4\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0001¢\u0006\u0002\u00108J\t\u00109\u001a\u00020(H\u0001J\t\u0010:\u001a\u00020\u000fH\u0001J\b\u0010;\u001a\u00020(H\u0016J,\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0014\b\u0001\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0001¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\t\u0010@\u001a\u00020\u000fH\u0001J!\u0010A\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0001J\u0011\u0010E\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\"H\u0001J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020IH\u0016J\u001a\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\u0010\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000bH\u0016J'\u0010G\u001a\u00020H2\u0006\u0010G\u001a\u00020\u000b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010LJ\u0011\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020\u000fH\u0001J\u0011\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020QH\u0001J\u0011\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020\"H\u0001J\u0011\u0010T\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0017H\u0001J\b\u0010V\u001a\u00020(H\u0016JD\u0010W\u001a\u00020\"2\u0006\u00103\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\u000b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0001¢\u0006\u0002\u0010XJ\t\u0010Y\u001a\u00020\u000fH\u0001J\u0011\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0001R(\u0010\b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n\u0018\u00010\t8VX\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0012\u0010\u0013\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000f8WX\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0012\u0010\u0016\u001a\u00020\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001a\u001a\u00020\u0017X\u000f¢\u0006\f\u001a\u0004\b\u001b\u0010\u0019\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000bX\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\u00020\"X\u000f¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006["}, d2 = {"Landroidx/room/QueryInterceptorDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "queryCallbackExecutor", "Ljava/util/concurrent/Executor;", "queryCallback", "Landroidx/room/RoomDatabase$QueryCallback;", "(Landroidx/sqlite/db/SupportSQLiteDatabase;Ljava/util/concurrent/Executor;Landroidx/room/RoomDatabase$QueryCallback;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "maximumSize", "", "getMaximumSize", "()J", "pageSize", "getPageSize", "setPageSize", "(J)V", "path", "getPath", "()Ljava/lang/String;", "version", "", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setMaximumSize", "numBytes", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryInterceptorDatabase.kt */
public final class QueryInterceptorDatabase implements SupportSQLiteDatabase {
    private final SupportSQLiteDatabase delegate;
    private final RoomDatabase.QueryCallback queryCallback;
    private final Executor queryCallbackExecutor;

    public void close() {
        this.delegate.close();
    }

    public int delete(String str, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        return this.delegate.delete(str, str2, objArr);
    }

    public void disableWriteAheadLogging() {
        this.delegate.disableWriteAheadLogging();
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void execPerConnectionSQL(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.delegate.execPerConnectionSQL(str, objArr);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.delegate.getAttachedDbs();
    }

    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    public String getPath() {
        return this.delegate.getPath();
    }

    public int getVersion() {
        return this.delegate.getVersion();
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public long insert(String str, int i, ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.delegate.insert(str, i, contentValues);
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return this.delegate.isExecPerConnectionSQLSupported();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    public boolean isWriteAheadLoggingEnabled() {
        return this.delegate.isWriteAheadLoggingEnabled();
    }

    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    public void setForeignKeyConstraintsEnabled(boolean z) {
        this.delegate.setForeignKeyConstraintsEnabled(z);
    }

    public void setLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    public long setMaximumSize(long j) {
        return this.delegate.setMaximumSize(j);
    }

    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.delegate.update(str, i, contentValues, str2, objArr);
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    public QueryInterceptorDatabase(SupportSQLiteDatabase supportSQLiteDatabase, Executor executor, RoomDatabase.QueryCallback queryCallback2) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "delegate");
        Intrinsics.checkNotNullParameter(executor, "queryCallbackExecutor");
        Intrinsics.checkNotNullParameter(queryCallback2, "queryCallback");
        this.delegate = supportSQLiteDatabase;
        this.queryCallbackExecutor = executor;
        this.queryCallback = queryCallback2;
    }

    public SupportSQLiteStatement compileStatement(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        return new QueryInterceptorStatement(this.delegate.compileStatement(str), str, this.queryCallbackExecutor, this.queryCallback);
    }

    public void beginTransaction() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda8(this));
        this.delegate.beginTransaction();
    }

    /* access modifiers changed from: private */
    public static final void beginTransaction$lambda$0(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    public void beginTransactionNonExclusive() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda0(this));
        this.delegate.beginTransactionNonExclusive();
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionNonExclusive$lambda$1(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda2(this));
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListener$lambda$2(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN EXCLUSIVE TRANSACTION", CollectionsKt.emptyList());
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener, "transactionListener");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda6(this));
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    /* access modifiers changed from: private */
    public static final void beginTransactionWithListenerNonExclusive$lambda$3(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("BEGIN DEFERRED TRANSACTION", CollectionsKt.emptyList());
    }

    public void endTransaction() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda10(this));
        this.delegate.endTransaction();
    }

    /* access modifiers changed from: private */
    public static final void endTransaction$lambda$4(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("END TRANSACTION", CollectionsKt.emptyList());
    }

    public void setTransactionSuccessful() {
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda5(this));
        this.delegate.setTransactionSuccessful();
    }

    /* access modifiers changed from: private */
    public static final void setTransactionSuccessful$lambda$5(QueryInterceptorDatabase queryInterceptorDatabase) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        queryInterceptorDatabase.queryCallback.onQuery("TRANSACTION SUCCESSFUL", CollectionsKt.emptyList());
    }

    public Cursor query(String str) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda9(this, str));
        return this.delegate.query(str);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$6(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        queryInterceptorDatabase.queryCallback.onQuery(str, CollectionsKt.emptyList());
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$7(QueryInterceptorDatabase queryInterceptorDatabase, String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$query");
        Intrinsics.checkNotNullParameter(objArr, "$bindArgs");
        queryInterceptorDatabase.queryCallback.onQuery(str, ArraysKt.toList((T[]) objArr));
    }

    public Cursor query(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda4(this, str, objArr));
        return this.delegate.query(str, objArr);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda7(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$8(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        QueryInterceptorProgram queryInterceptorProgram = new QueryInterceptorProgram();
        supportSQLiteQuery.bindTo(queryInterceptorProgram);
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda3(this, supportSQLiteQuery, queryInterceptorProgram));
        return this.delegate.query(supportSQLiteQuery);
    }

    /* access modifiers changed from: private */
    public static final void query$lambda$9(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNullParameter(queryInterceptorProgram, "$queryInterceptorProgram");
        queryInterceptorDatabase.queryCallback.onQuery(supportSQLiteQuery.getSql(), queryInterceptorProgram.getBindArgsCache$room_runtime_release());
    }

    public void execSQL(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda1(this, str));
        this.delegate.execSQL(str);
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$10(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sql");
        queryInterceptorDatabase.queryCallback.onQuery(str, CollectionsKt.emptyList());
    }

    public void execSQL(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        List arrayList = new ArrayList();
        arrayList.addAll(CollectionsKt.listOf(objArr));
        this.queryCallbackExecutor.execute(new QueryInterceptorDatabase$$ExternalSyntheticLambda11(this, str, arrayList));
        this.delegate.execSQL(str, new List[]{arrayList});
    }

    /* access modifiers changed from: private */
    public static final void execSQL$lambda$11(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        Intrinsics.checkNotNullParameter(queryInterceptorDatabase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$sql");
        Intrinsics.checkNotNullParameter(list, "$inputArguments");
        queryInterceptorDatabase.queryCallback.onQuery(str, list);
    }
}
