package androidx.sqlite.db.framework;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.CancellationSignal;
import android.text.TextUtils;
import android.util.Pair;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.actions.SearchIntents;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020(2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020(H\u0016J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\bH\u0016J3\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u00108J\b\u00109\u001a\u00020(H\u0017J\b\u0010:\u001a\u00020\fH\u0016J\b\u0010;\u001a\u00020(H\u0016J)\u0010<\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0012\u0010=\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\bH\u0016J'\u0010?\u001a\u00020(2\u0006\u00101\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010>J\b\u0010@\u001a\u00020\fH\u0016J \u0010A\u001a\u00020\u00142\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020DH\u0016J\u000e\u0010E\u001a\u00020\f2\u0006\u0010F\u001a\u00020\u0003J\u0010\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020!H\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020KH\u0016J\u001a\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010MH\u0017J\u0010\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\bH\u0016J'\u0010I\u001a\u00020J2\u0006\u0010I\u001a\u00020\b2\u0010\u0010=\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010706H\u0016¢\u0006\u0002\u0010NJ\u0010\u0010O\u001a\u00020(2\u0006\u0010P\u001a\u00020\fH\u0017J\u0010\u0010Q\u001a\u00020(2\u0006\u0010R\u001a\u00020SH\u0016J\u0010\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020!H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010V\u001a\u00020(H\u0016JC\u0010W\u001a\u00020!2\u0006\u00103\u001a\u00020\b2\u0006\u0010B\u001a\u00020!2\u0006\u0010C\u001a\u00020D2\b\u00104\u001a\u0004\u0018\u00010\b2\u0012\u00105\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u000107\u0018\u000106H\u0016¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u00020\fH\u0016J\u0010\u0010Y\u001a\u00020\f2\u0006\u0010Z\u001a\u00020\u0014H\u0016R(\u0010\u0005\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u000e\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u00020\f8WX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\rR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006]"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "delegate", "Landroid/database/sqlite/SQLiteDatabase;", "(Landroid/database/sqlite/SQLiteDatabase;)V", "attachedDbs", "", "Landroid/util/Pair;", "", "getAttachedDbs", "()Ljava/util/List;", "isDatabaseIntegrityOk", "", "()Z", "isDbLockedByCurrentThread", "isExecPerConnectionSQLSupported", "isOpen", "isReadOnly", "isWriteAheadLoggingEnabled", "numBytes", "", "maximumSize", "getMaximumSize", "()J", "setMaximumSize", "(J)V", "pageSize", "getPageSize", "setPageSize", "path", "getPath", "()Ljava/lang/String;", "value", "", "version", "getVersion", "()I", "setVersion", "(I)V", "beginTransaction", "", "beginTransactionNonExclusive", "beginTransactionWithListener", "transactionListener", "Landroid/database/sqlite/SQLiteTransactionListener;", "beginTransactionWithListenerNonExclusive", "close", "compileStatement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "sql", "delete", "table", "whereClause", "whereArgs", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I", "disableWriteAheadLogging", "enableWriteAheadLogging", "endTransaction", "execPerConnectionSQL", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)V", "execSQL", "inTransaction", "insert", "conflictAlgorithm", "values", "Landroid/content/ContentValues;", "isDelegate", "sqLiteDatabase", "needUpgrade", "newVersion", "query", "Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "cancellationSignal", "Landroid/os/CancellationSignal;", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "setForeignKeyConstraintsEnabled", "enabled", "setLocale", "locale", "Ljava/util/Locale;", "setMaxSqlCacheSize", "cacheSize", "setTransactionSuccessful", "update", "(Ljava/lang/String;ILandroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/Object;)I", "yieldIfContendedSafely", "sleepAfterYieldDelayMillis", "Api30Impl", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteDatabase.kt */
public final class FrameworkSQLiteDatabase implements SupportSQLiteDatabase {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private final List<Pair<String, String>> attachedDbs;
    private final SQLiteDatabase delegate;

    public FrameworkSQLiteDatabase(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "delegate");
        this.delegate = sQLiteDatabase;
        this.attachedDbs = sQLiteDatabase.getAttachedDbs();
    }

    public SupportSQLiteStatement compileStatement(String str) {
        Intrinsics.checkNotNullParameter(str, "sql");
        SQLiteStatement compileStatement = this.delegate.compileStatement(str);
        Intrinsics.checkNotNullExpressionValue(compileStatement, "delegate.compileStatement(sql)");
        return new FrameworkSQLiteStatement(compileStatement);
    }

    public void beginTransaction() {
        this.delegate.beginTransaction();
    }

    public void beginTransactionNonExclusive() {
        this.delegate.beginTransactionNonExclusive();
    }

    public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListener(sQLiteTransactionListener);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        Intrinsics.checkNotNullParameter(sQLiteTransactionListener, "transactionListener");
        this.delegate.beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
    }

    public void endTransaction() {
        this.delegate.endTransaction();
    }

    public void setTransactionSuccessful() {
        this.delegate.setTransactionSuccessful();
    }

    public boolean inTransaction() {
        return this.delegate.inTransaction();
    }

    public boolean isDbLockedByCurrentThread() {
        return this.delegate.isDbLockedByCurrentThread();
    }

    public boolean yieldIfContendedSafely() {
        return this.delegate.yieldIfContendedSafely();
    }

    public boolean yieldIfContendedSafely(long j) {
        return this.delegate.yieldIfContendedSafely(j);
    }

    public int getVersion() {
        return this.delegate.getVersion();
    }

    public void setVersion(int i) {
        this.delegate.setVersion(i);
    }

    public long getMaximumSize() {
        return this.delegate.getMaximumSize();
    }

    /* renamed from: setMaximumSize  reason: collision with other method in class */
    public void m57setMaximumSize(long j) {
        this.delegate.setMaximumSize(j);
    }

    public long setMaximumSize(long j) {
        this.delegate.setMaximumSize(j);
        return this.delegate.getMaximumSize();
    }

    public boolean isExecPerConnectionSQLSupported() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public void execPerConnectionSQL(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "sql");
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.INSTANCE.execPerConnectionSQL(this.delegate, str, objArr);
            return;
        }
        throw new UnsupportedOperationException("execPerConnectionSQL is not supported on a SDK version lower than 30, current version is: " + Build.VERSION.SDK_INT);
    }

    public long getPageSize() {
        return this.delegate.getPageSize();
    }

    public void setPageSize(long j) {
        this.delegate.setPageSize(j);
    }

    public Cursor query(String str) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str));
    }

    public Cursor query(String str, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        return query((SupportSQLiteQuery) new SimpleSQLiteQuery(str, objArr));
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        Cursor rawQueryWithFactory = this.delegate.rawQueryWithFactory(new FrameworkSQLiteDatabase$$ExternalSyntheticLambda1(new FrameworkSQLiteDatabase$query$cursorFactory$1(supportSQLiteQuery)), supportSQLiteQuery.getSql(), EMPTY_STRING_ARRAY, (String) null);
        Intrinsics.checkNotNullExpressionValue(rawQueryWithFactory, "delegate.rawQueryWithFac…EMPTY_STRING_ARRAY, null)");
        return rawQueryWithFactory;
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$0(Function4 function4, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(function4, "$tmp0");
        return (Cursor) function4.invoke(sQLiteDatabase, sQLiteCursorDriver, str, sQLiteQuery);
    }

    public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, SearchIntents.EXTRA_QUERY);
        SQLiteDatabase sQLiteDatabase = this.delegate;
        String sql = supportSQLiteQuery.getSql();
        String[] strArr = EMPTY_STRING_ARRAY;
        Intrinsics.checkNotNull(cancellationSignal);
        return SupportSQLiteCompat.Api16Impl.rawQueryWithFactory(sQLiteDatabase, sql, strArr, (String) null, cancellationSignal, new FrameworkSQLiteDatabase$$ExternalSyntheticLambda0(supportSQLiteQuery));
    }

    /* access modifiers changed from: private */
    public static final Cursor query$lambda$1(SupportSQLiteQuery supportSQLiteQuery, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        Intrinsics.checkNotNullParameter(supportSQLiteQuery, "$query");
        Intrinsics.checkNotNull(sQLiteQuery);
        supportSQLiteQuery.bindTo(new FrameworkSQLiteProgram(sQLiteQuery));
        return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
    }

    public long insert(String str, int i, ContentValues contentValues) throws SQLException {
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        return this.delegate.insertWithOnConflict(str, (String) null, contentValues, i);
    }

    public int delete(String str, String str2, Object[] objArr) {
        Intrinsics.checkNotNullParameter(str, "table");
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(str);
        CharSequence charSequence = str2;
        if (!(charSequence == null || charSequence.length() == 0)) {
            sb.append(" WHERE ");
            sb.append(str2);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        SupportSQLiteStatement compileStatement = compileStatement(sb2);
        SimpleSQLiteQuery.Companion.bind(compileStatement, objArr);
        return compileStatement.executeUpdateDelete();
    }

    public int update(String str, int i, ContentValues contentValues, String str2, Object[] objArr) {
        int i2;
        Intrinsics.checkNotNullParameter(str, "table");
        Intrinsics.checkNotNullParameter(contentValues, "values");
        int i3 = 0;
        if (contentValues.size() != 0) {
            int size = contentValues.size();
            if (objArr == null) {
                i2 = size;
            } else {
                i2 = objArr.length + size;
            }
            Object[] objArr2 = new Object[i2];
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i]);
            sb.append(str);
            sb.append(" SET ");
            for (String next : contentValues.keySet()) {
                sb.append(i3 > 0 ? "," : "");
                sb.append(next);
                objArr2[i3] = contentValues.get(next);
                sb.append("=?");
                i3++;
            }
            if (objArr != null) {
                for (int i4 = size; i4 < i2; i4++) {
                    objArr2[i4] = objArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            SupportSQLiteStatement compileStatement = compileStatement(sb2);
            SimpleSQLiteQuery.Companion.bind(compileStatement, objArr2);
            return compileStatement.executeUpdateDelete();
        }
        throw new IllegalArgumentException("Empty values".toString());
    }

    public void execSQL(String str) throws SQLException {
        Intrinsics.checkNotNullParameter(str, "sql");
        this.delegate.execSQL(str);
    }

    public void execSQL(String str, Object[] objArr) throws SQLException {
        Intrinsics.checkNotNullParameter(str, "sql");
        Intrinsics.checkNotNullParameter(objArr, "bindArgs");
        this.delegate.execSQL(str, objArr);
    }

    public boolean isReadOnly() {
        return this.delegate.isReadOnly();
    }

    public boolean isOpen() {
        return this.delegate.isOpen();
    }

    public boolean needUpgrade(int i) {
        return this.delegate.needUpgrade(i);
    }

    public String getPath() {
        return this.delegate.getPath();
    }

    public void setLocale(Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.delegate.setLocale(locale);
    }

    public void setMaxSqlCacheSize(int i) {
        this.delegate.setMaxSqlCacheSize(i);
    }

    public void setForeignKeyConstraintsEnabled(boolean z) {
        SupportSQLiteCompat.Api16Impl.setForeignKeyConstraintsEnabled(this.delegate, z);
    }

    public boolean enableWriteAheadLogging() {
        return this.delegate.enableWriteAheadLogging();
    }

    public void disableWriteAheadLogging() {
        SupportSQLiteCompat.Api16Impl.disableWriteAheadLogging(this.delegate);
    }

    public boolean isWriteAheadLoggingEnabled() {
        return SupportSQLiteCompat.Api16Impl.isWriteAheadLoggingEnabled(this.delegate);
    }

    public List<Pair<String, String>> getAttachedDbs() {
        return this.attachedDbs;
    }

    public boolean isDatabaseIntegrityOk() {
        return this.delegate.isDatabaseIntegrityOk();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final boolean isDelegate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
        return Intrinsics.areEqual((Object) this.delegate, (Object) sQLiteDatabase);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Api30Impl;", "", "()V", "execPerConnectionSQL", "", "sQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sql", "", "bindArgs", "", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/Object;)V", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteDatabase.kt */
    public static final class Api30Impl {
        public static final Api30Impl INSTANCE = new Api30Impl();

        private Api30Impl() {
        }

        public final void execPerConnectionSQL(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sQLiteDatabase");
            Intrinsics.checkNotNullParameter(str, "sql");
            sQLiteDatabase.execPerConnectionSQL(str, objArr);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase$Companion;", "", "()V", "CONFLICT_VALUES", "", "", "[Ljava/lang/String;", "EMPTY_STRING_ARRAY", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteDatabase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
