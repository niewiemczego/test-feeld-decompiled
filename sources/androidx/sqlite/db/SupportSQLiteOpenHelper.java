package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import com.facebook.appevents.UserDataStore;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H'R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Ljava/io/Closeable;", "databaseName", "", "getDatabaseName", "()Ljava/lang/String;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "close", "", "setWriteAheadLoggingEnabled", "enabled", "", "Callback", "Configuration", "Factory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SupportSQLiteOpenHelper.kt */
public interface SupportSQLiteOpenHelper extends Closeable {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "", "create", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "configuration", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SupportSQLiteOpenHelper.kt */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "", "version", "", "(I)V", "deleteDatabaseFile", "", "fileName", "", "onConfigure", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "onCorruption", "onCreate", "onDowngrade", "oldVersion", "newVersion", "onOpen", "onUpgrade", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SupportSQLiteOpenHelper.kt */
    public static abstract class Callback {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String TAG = "SupportSQLite";
        public final int version;

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public Callback(int i) {
            this.version = i;
        }

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            Intrinsics.checkNotNullParameter(supportSQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
            if (r1 != null) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0043, code lost:
            r4 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
            if (r4.hasNext() != false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004f, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "p.second");
            deleteDatabaseFile((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0060, code lost:
            r4 = r4.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0064, code lost:
            if (r4 != null) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
            deleteDatabaseFile(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0069, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x003d */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0089  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x003b A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v15 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v7 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v8 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v8 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:6:0x0036, B:9:0x003d, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:6:0x0036] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "p.second"
                java.lang.String r1 = "db"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r1 = r1.append(r4)
                java.lang.String r2 = ".path"
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.e(r2, r1)
                boolean r1 = r4.isOpen()
                if (r1 != 0) goto L_0x0035
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0034
                r3.deleteDatabaseFile(r4)
            L_0x0034:
                return
            L_0x0035:
                r1 = 0
                java.util.List r1 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x003d, all -> 0x003b }
                goto L_0x003d
            L_0x003b:
                r2 = move-exception
                goto L_0x0041
            L_0x003d:
                r4.close()     // Catch:{ IOException -> 0x006a, all -> 0x003b }
                goto L_0x006a
            L_0x0041:
                if (r1 == 0) goto L_0x0060
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x0049:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0069
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x0049
            L_0x0060:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0069
                r3.deleteDatabaseFile(r4)
            L_0x0069:
                throw r2
            L_0x006a:
                if (r1 == 0) goto L_0x0089
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x0072:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0092
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x0072
            L_0x0089:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0092
                r3.deleteDatabaseFile(r4)
            L_0x0092:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        private final void deleteDatabaseFile(String str) {
            boolean z = true;
            if (!StringsKt.equals(str, ":memory:", true)) {
                CharSequence charSequence = str;
                int length = charSequence.length() - 1;
                int i = 0;
                boolean z2 = false;
                while (i <= length) {
                    boolean z3 = Intrinsics.compare((int) charSequence.charAt(!z2 ? i : length), 32) <= 0;
                    if (!z2) {
                        if (!z3) {
                            z2 = true;
                        } else {
                            i++;
                        }
                    } else if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (charSequence.subSequence(i, length + 1).toString().length() != 0) {
                    z = false;
                }
                if (!z) {
                    Log.w(TAG, "deleting the database file: " + str);
                    try {
                        if (Build.VERSION.SDK_INT >= 16) {
                            SupportSQLiteCompat.Api16Impl.deleteDatabase(new File(str));
                            return;
                        }
                        try {
                            if (!new File(str).delete()) {
                                Log.e(TAG, "Could not delete the database file " + str);
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "error while deleting corrupted database file", e);
                        }
                    } catch (Exception e2) {
                        Log.w(TAG, "delete failed: ", e2);
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback$Companion;", "", "()V", "TAG", "", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SupportSQLiteOpenHelper.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0010\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "Builder", "Companion", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SupportSQLiteOpenHelper.kt */
    public static final class Configuration {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        @JvmStatic
        public static final Builder builder(Context context2) {
            return Companion.builder(context2);
        }

        public Configuration(Context context2, String str, Callback callback2, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(callback2, "callback");
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z;
            this.allowDataLossOnRecovery = z2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Configuration(Context context2, String str, Callback callback2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(context2, str, callback2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allowDataLossOnRecovery", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "name", "", "useNoBackupDirectory", "build", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration;", "noBackupDirectory", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SupportSQLiteOpenHelper.kt */
        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context context2) {
                Intrinsics.checkNotNullParameter(context2, "context");
                this.context = context2;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
                if ((r0 == null || r0.length() == 0) == false) goto L_0x001c;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration build() {
                /*
                    r7 = this;
                    androidx.sqlite.db.SupportSQLiteOpenHelper$Callback r3 = r7.callback
                    if (r3 == 0) goto L_0x003a
                    boolean r0 = r7.useNoBackupDirectory
                    r1 = 0
                    r2 = 1
                    if (r0 == 0) goto L_0x001c
                    java.lang.String r0 = r7.name
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    if (r0 == 0) goto L_0x0019
                    int r0 = r0.length()
                    if (r0 != 0) goto L_0x0017
                    goto L_0x0019
                L_0x0017:
                    r0 = r1
                    goto L_0x001a
                L_0x0019:
                    r0 = r2
                L_0x001a:
                    if (r0 != 0) goto L_0x001d
                L_0x001c:
                    r1 = r2
                L_0x001d:
                    if (r1 == 0) goto L_0x002e
                    androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration r6 = new androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration
                    android.content.Context r1 = r7.context
                    java.lang.String r2 = r7.name
                    boolean r4 = r7.useNoBackupDirectory
                    boolean r5 = r7.allowDataLossOnRecovery
                    r0 = r6
                    r0.<init>(r1, r2, r3, r4, r5)
                    return r6
                L_0x002e:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.String r1 = "Must set a non-null database name to a configuration that uses the no backup directory."
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L_0x003a:
                    java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                    java.lang.String r1 = "Must set a callback to create the configuration."
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.Builder.build():androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration");
            }

            public Builder name(String str) {
                Builder builder = this;
                this.name = str;
                return this;
            }

            public Builder callback(Callback callback2) {
                Intrinsics.checkNotNullParameter(callback2, "callback");
                Builder builder = this;
                this.callback = callback2;
                return this;
            }

            public Builder noBackupDirectory(boolean z) {
                Builder builder = this;
                this.useNoBackupDirectory = z;
                return this;
            }

            public Builder allowDataLossOnRecovery(boolean z) {
                Builder builder = this;
                this.allowDataLossOnRecovery = z;
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Companion;", "", "()V", "builder", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Configuration$Builder;", "context", "Landroid/content/Context;", "sqlite_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: SupportSQLiteOpenHelper.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public final Builder builder(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new Builder(context);
            }
        }
    }
}
