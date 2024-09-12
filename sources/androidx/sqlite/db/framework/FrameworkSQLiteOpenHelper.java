package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0003\"#$B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\tH\u0017R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014*\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0016X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "useNoBackupDirectory", "", "allowDataLossOnRecovery", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;ZZ)V", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "delegate", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "getDelegate$delegate", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper;)Ljava/lang/Object;", "getDelegate", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "lazyDelegate", "Lkotlin/Lazy;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "writableDatabase", "getWritableDatabase", "writeAheadLoggingEnabled", "close", "", "setWriteAheadLoggingEnabled", "enabled", "Companion", "DBRefHolder", "OpenHelper", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteOpenHelper.kt */
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "SupportSQLite";
    /* access modifiers changed from: private */
    public final boolean allowDataLossOnRecovery;
    /* access modifiers changed from: private */
    public final SupportSQLiteOpenHelper.Callback callback;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy<OpenHelper> lazyDelegate;
    /* access modifiers changed from: private */
    public final String name;
    /* access modifiers changed from: private */
    public final boolean useNoBackupDirectory;
    /* access modifiers changed from: private */
    public boolean writeAheadLoggingEnabled;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2) {
        this(context2, str, callback2, false, false, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z) {
        this(context2, str, callback2, z, false, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
    }

    public FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.context = context2;
        this.name = str;
        this.callback = callback2;
        this.useNoBackupDirectory = z;
        this.allowDataLossOnRecovery = z2;
        this.lazyDelegate = LazyKt.lazy(new FrameworkSQLiteOpenHelper$lazyDelegate$1(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrameworkSQLiteOpenHelper(Context context2, String str, SupportSQLiteOpenHelper.Callback callback2, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2, str, callback2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2);
    }

    private final OpenHelper getDelegate() {
        return this.lazyDelegate.getValue();
    }

    private static Object getDelegate$delegate(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        return frameworkSQLiteOpenHelper.lazyDelegate;
    }

    public String getDatabaseName() {
        return this.name;
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        if (this.lazyDelegate.isInitialized()) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(getDelegate(), z);
        }
        this.writeAheadLoggingEnabled = z;
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        return getDelegate().getSupportDatabase(true);
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        return getDelegate().getSupportDatabase(false);
    }

    public void close() {
        if (this.lazyDelegate.isInitialized()) {
            getDelegate().close();
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u0000 /2\u00020\u0001:\u0003-./B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J \u0010'\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016J \u0010,\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)H\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "dbRef", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "callback", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "allowDataLossOnRecovery", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;Z)V", "getAllowDataLossOnRecovery", "()Z", "getCallback", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper$Callback;", "getContext", "()Landroid/content/Context;", "getDbRef", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "lock", "Landroidx/sqlite/util/ProcessLock;", "migrated", "opened", "close", "", "getSupportDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "writable", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getWritableOrReadableDatabase", "innerGetDatabase", "onConfigure", "db", "onCreate", "onDowngrade", "oldVersion", "", "newVersion", "onOpen", "onUpgrade", "CallbackException", "CallbackName", "Companion", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    private static final class OpenHelper extends SQLiteOpenHelper {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean allowDataLossOnRecovery;
        private final SupportSQLiteOpenHelper.Callback callback;
        private final Context context;
        private final DBRefHolder dbRef;
        private final ProcessLock lock;
        private boolean migrated;
        private boolean opened;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "", "(Ljava/lang/String;I)V", "ON_CONFIGURE", "ON_CREATE", "ON_UPGRADE", "ON_DOWNGRADE", "ON_OPEN", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public enum CallbackName {
            ON_CONFIGURE,
            ON_CREATE,
            ON_UPGRADE,
            ON_DOWNGRADE,
            ON_OPEN
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName[] r0 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CONFIGURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_UPGRADE     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_DOWNGRADE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackName.ON_OPEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.<clinit>():void");
            }
        }

        public final Context getContext() {
            return this.context;
        }

        public final DBRefHolder getDbRef() {
            return this.dbRef;
        }

        public final SupportSQLiteOpenHelper.Callback getCallback() {
            return this.callback;
        }

        public final boolean getAllowDataLossOnRecovery() {
            return this.allowDataLossOnRecovery;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context2, String str, DBRefHolder dBRefHolder, SupportSQLiteOpenHelper.Callback callback2, boolean z) {
            super(context2, str, (SQLiteDatabase.CursorFactory) null, callback2.version, new FrameworkSQLiteOpenHelper$OpenHelper$$ExternalSyntheticLambda0(callback2, dBRefHolder));
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(dBRefHolder, "dbRef");
            Intrinsics.checkNotNullParameter(callback2, "callback");
            this.context = context2;
            this.dbRef = dBRefHolder;
            this.callback = callback2;
            this.allowDataLossOnRecovery = z;
            if (str == null) {
                str = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
            }
            File cacheDir = context2.getCacheDir();
            Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
            this.lock = new ProcessLock(str, cacheDir, false);
        }

        /* access modifiers changed from: private */
        public static final void _init_$lambda$0(SupportSQLiteOpenHelper.Callback callback2, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(callback2, "$callback");
            Intrinsics.checkNotNullParameter(dBRefHolder, "$dbRef");
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(sQLiteDatabase, "dbObj");
            callback2.onCorruption(companion.getWrappedDb(dBRefHolder, sQLiteDatabase));
        }

        public final SupportSQLiteDatabase getSupportDatabase(boolean z) {
            try {
                this.lock.lock(!this.opened && getDatabaseName() != null);
                this.migrated = false;
                SQLiteDatabase innerGetDatabase = innerGetDatabase(z);
                if (this.migrated) {
                    close();
                    return getSupportDatabase(z);
                }
                SupportSQLiteDatabase wrappedDb = getWrappedDb(innerGetDatabase);
                this.lock.unlock();
                return wrappedDb;
            } finally {
                this.lock.unlock();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|10|12|13|14|15|16) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0040 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final android.database.sqlite.SQLiteDatabase innerGetDatabase(boolean r5) {
            /*
                r4 = this;
                java.lang.String r0 = r4.getDatabaseName()
                if (r0 == 0) goto L_0x0033
                android.content.Context r1 = r4.context
                java.io.File r1 = r1.getDatabasePath(r0)
                java.io.File r1 = r1.getParentFile()
                if (r1 == 0) goto L_0x0033
                r1.mkdirs()
                boolean r2 = r1.isDirectory()
                if (r2 != 0) goto L_0x0033
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Invalid database parent file, not a directory: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r1 = r2.append(r1)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.w(r2, r1)
            L_0x0033:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x0038 }
                return r5
            L_0x0038:
                super.close()
                r1 = 500(0x1f4, double:2.47E-321)
                java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0040 }
            L_0x0040:
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ all -> 0x0045 }
                return r5
            L_0x0045:
                r1 = move-exception
                super.close()
                boolean r2 = r1 instanceof androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException
                if (r2 == 0) goto L_0x0072
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackException r1 = (androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.CallbackException) r1
                java.lang.Throwable r2 = r1.getCause()
                androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper$OpenHelper$CallbackName r1 = r1.getCallbackName()
                int[] r3 = androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.WhenMappings.$EnumSwitchMapping$0
                int r1 = r1.ordinal()
                r1 = r3[r1]
                r3 = 1
                if (r1 == r3) goto L_0x0071
                r3 = 2
                if (r1 == r3) goto L_0x0071
                r3 = 3
                if (r1 == r3) goto L_0x0071
                r3 = 4
                if (r1 == r3) goto L_0x0071
                boolean r1 = r2 instanceof android.database.sqlite.SQLiteException
                if (r1 == 0) goto L_0x0070
                goto L_0x007c
            L_0x0070:
                throw r2
            L_0x0071:
                throw r2
            L_0x0072:
                boolean r2 = r1 instanceof android.database.sqlite.SQLiteException
                if (r2 == 0) goto L_0x008d
                if (r0 == 0) goto L_0x008c
                boolean r2 = r4.allowDataLossOnRecovery
                if (r2 == 0) goto L_0x008c
            L_0x007c:
                android.content.Context r1 = r4.context
                r1.deleteDatabase(r0)
                android.database.sqlite.SQLiteDatabase r5 = r4.getWritableOrReadableDatabase(r5)     // Catch:{ CallbackException -> 0x0086 }
                return r5
            L_0x0086:
                r5 = move-exception
                java.lang.Throwable r5 = r5.getCause()
                throw r5
            L_0x008c:
                throw r1
            L_0x008d:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper.OpenHelper.innerGetDatabase(boolean):android.database.sqlite.SQLiteDatabase");
        }

        private final SQLiteDatabase getWritableOrReadableDatabase(boolean z) {
            if (z) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.checkNotNullExpressionValue(writableDatabase, "{\n                super.…eDatabase()\n            }");
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.checkNotNullExpressionValue(readableDatabase, "{\n                super.…eDatabase()\n            }");
            return readableDatabase;
        }

        public final FrameworkSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            return Companion.getWrappedDb(this.dbRef, sQLiteDatabase);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            try {
                this.callback.onCreate(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CREATE, th);
            }
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
            this.migrated = true;
            try {
                this.callback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_UPGRADE, th);
            }
        }

        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            try {
                this.callback.onConfigure(getWrappedDb(sQLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_CONFIGURE, th);
            }
        }

        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            this.migrated = true;
            try {
                this.callback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.ON_DOWNGRADE, th);
            }
        }

        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
            if (!this.migrated) {
                try {
                    this.callback.onOpen(getWrappedDb(sQLiteDatabase));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.ON_OPEN, th);
                }
            }
            this.opened = true;
        }

        public void close() {
            try {
                ProcessLock.lock$default(this.lock, false, 1, (Object) null);
                super.close();
                this.dbRef.setDb((FrameworkSQLiteDatabase) null);
                this.opened = false;
            } finally {
                this.lock.unlock();
            }
        }

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "callbackName", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "cause", "", "(Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;Ljava/lang/Throwable;)V", "getCallbackName", "()Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$CallbackName;", "getCause", "()Ljava/lang/Throwable;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        private static final class CallbackException extends RuntimeException {
            private final CallbackName callbackName;
            private final Throwable cause;

            public final CallbackName getCallbackName() {
                return this.callbackName;
            }

            public Throwable getCause() {
                return this.cause;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName2, Throwable th) {
                super(th);
                Intrinsics.checkNotNullParameter(callbackName2, "callbackName");
                Intrinsics.checkNotNullParameter(th, "cause");
                this.callbackName = callbackName2;
                this.cause = th;
            }
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper$Companion;", "", "()V", "getWrappedDb", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "refHolder", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "sqLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: FrameworkSQLiteOpenHelper.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final FrameworkSQLiteDatabase getWrappedDb(DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
                Intrinsics.checkNotNullParameter(dBRefHolder, "refHolder");
                Intrinsics.checkNotNullParameter(sQLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase db = dBRefHolder.getDb();
                if (db != null && db.isDelegate(sQLiteDatabase)) {
                    return db;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sQLiteDatabase);
                dBRefHolder.setDb(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$Companion;", "", "()V", "TAG", "", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$DBRefHolder;", "", "db", "Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "(Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;)V", "getDb", "()Landroidx/sqlite/db/framework/FrameworkSQLiteDatabase;", "setDb", "sqlite-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FrameworkSQLiteOpenHelper.kt */
    private static final class DBRefHolder {
        private FrameworkSQLiteDatabase db;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase getDb() {
            return this.db;
        }

        public final void setDb(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.db = frameworkSQLiteDatabase;
        }
    }
}
