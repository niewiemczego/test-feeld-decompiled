package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0001¢\u0006\u0002\u0010\u000fJ\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\bH\u0002J\u0018\u0010&\u001a\u00020 2\u0006\u0010%\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001cH\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u001cH\u0017J\u0010\u0010*\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001a¨\u0006+"}, d2 = {"Landroidx/room/SQLiteCopyOpenHelper;", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "Landroidx/room/DelegatingOpenHelper;", "context", "Landroid/content/Context;", "copyFromAssetPath", "", "copyFromFile", "Ljava/io/File;", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "databaseVersion", "", "delegate", "(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;ILandroidx/sqlite/db/SupportSQLiteOpenHelper;)V", "databaseConfiguration", "Landroidx/room/DatabaseConfiguration;", "databaseName", "getDatabaseName", "()Ljava/lang/String;", "getDelegate", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "readableDatabase", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "getReadableDatabase", "()Landroidx/sqlite/db/SupportSQLiteDatabase;", "verified", "", "writableDatabase", "getWritableDatabase", "close", "", "copyDatabaseFile", "destinationFile", "writable", "createFrameworkOpenHelper", "databaseFile", "dispatchOnOpenPrepackagedDatabase", "setDatabaseConfiguration", "setWriteAheadLoggingEnabled", "enabled", "verifyDatabaseFile", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SQLiteCopyOpenHelper.kt */
public final class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final SupportSQLiteOpenHelper delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context context2, String str, File file, Callable<InputStream> callable, int i, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(supportSQLiteOpenHelper, "delegate");
        this.context = context2;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i;
        this.delegate = supportSQLiteOpenHelper;
    }

    public SupportSQLiteOpenHelper getDelegate() {
        return this.delegate;
    }

    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    public void setWriteAheadLoggingEnabled(boolean z) {
        getDelegate().setWriteAheadLoggingEnabled(z);
    }

    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration2) {
        Intrinsics.checkNotNullParameter(databaseConfiguration2, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration2;
    }

    private final void verifyDatabaseFile(boolean z) {
        String databaseName = getDatabaseName();
        if (databaseName != null) {
            File databasePath = this.context.getDatabasePath(databaseName);
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            DatabaseConfiguration databaseConfiguration3 = null;
            if (databaseConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            boolean z2 = databaseConfiguration2.multiInstanceInvalidation;
            File filesDir = this.context.getFilesDir();
            Intrinsics.checkNotNullExpressionValue(filesDir, "context.filesDir");
            ProcessLock processLock = new ProcessLock(databaseName, filesDir, z2);
            try {
                ProcessLock.lock$default(processLock, false, 1, (Object) null);
                if (!databasePath.exists()) {
                    Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                    copyDatabaseFile(databasePath, z);
                    processLock.unlock();
                    return;
                }
                try {
                    Intrinsics.checkNotNullExpressionValue(databasePath, "databaseFile");
                    int readVersion = DBUtil.readVersion(databasePath);
                    if (readVersion == this.databaseVersion) {
                        processLock.unlock();
                        return;
                    }
                    DatabaseConfiguration databaseConfiguration4 = this.databaseConfiguration;
                    if (databaseConfiguration4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                    } else {
                        databaseConfiguration3 = databaseConfiguration4;
                    }
                    if (databaseConfiguration3.isMigrationRequired(readVersion, this.databaseVersion)) {
                        processLock.unlock();
                        return;
                    }
                    if (this.context.deleteDatabase(databaseName)) {
                        try {
                            copyDatabaseFile(databasePath, z);
                        } catch (IOException e) {
                            Log.w(Room.LOG_TAG, "Unable to copy database file.", e);
                        }
                    } else {
                        Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                    }
                    processLock.unlock();
                } catch (IOException e2) {
                    Log.w(Room.LOG_TAG, "Unable to read database version.", e2);
                    processLock.unlock();
                }
            } catch (IOException e3) {
                throw new RuntimeException("Unable to copy database file.", e3);
            } catch (Throwable th) {
                processLock.unlock();
                throw th;
            }
        } else {
            throw new IllegalStateException("Required value was null.".toString());
        }
    }

    private final void copyDatabaseFile(File file, boolean z) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.copyFromFile != null) {
            FileChannel channel = new FileInputStream(this.copyFromFile).getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "FileInputStream(copyFromFile).channel");
            readableByteChannel = channel;
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                    Intrinsics.checkNotNullExpressionValue(readableByteChannel, "newChannel(inputStream)");
                } catch (Exception e) {
                    throw new IOException("inputStreamCallable exception on call", e);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", DefaultDiskStorage.FileType.TEMP, this.context.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel2 = new FileOutputStream(createTempFile).getChannel();
        Intrinsics.checkNotNullExpressionValue(channel2, "output");
        FileUtil.copy(readableByteChannel, channel2);
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            Intrinsics.checkNotNullExpressionValue(createTempFile, "intermediateFile");
            dispatchOnOpenPrepackagedDatabase(createTempFile, z);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dispatchOnOpenPrepackagedDatabase(java.io.File r4, boolean r5) {
        /*
            r3 = this;
            androidx.room.DatabaseConfiguration r0 = r3.databaseConfiguration
            java.lang.String r1 = "databaseConfiguration"
            r2 = 0
            if (r0 != 0) goto L_0x000b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r2
        L_0x000b:
            androidx.room.RoomDatabase$PrepackagedDatabaseCallback r0 = r0.prepackagedDatabaseCallback
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            androidx.sqlite.db.SupportSQLiteOpenHelper r4 = r3.createFrameworkOpenHelper(r4)
            java.io.Closeable r4 = (java.io.Closeable) r4
            r0 = r4
            androidx.sqlite.db.SupportSQLiteOpenHelper r0 = (androidx.sqlite.db.SupportSQLiteOpenHelper) r0     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x0020
            androidx.sqlite.db.SupportSQLiteDatabase r5 = r0.getWritableDatabase()     // Catch:{ all -> 0x003a }
            goto L_0x0024
        L_0x0020:
            androidx.sqlite.db.SupportSQLiteDatabase r5 = r0.getReadableDatabase()     // Catch:{ all -> 0x003a }
        L_0x0024:
            androidx.room.DatabaseConfiguration r0 = r3.databaseConfiguration     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x002c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch:{ all -> 0x003a }
            r0 = r2
        L_0x002c:
            androidx.room.RoomDatabase$PrepackagedDatabaseCallback r0 = r0.prepackagedDatabaseCallback     // Catch:{ all -> 0x003a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)     // Catch:{ all -> 0x003a }
            r0.onOpenPrepackagedDatabase(r5)     // Catch:{ all -> 0x003a }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003a }
            kotlin.io.CloseableKt.closeFinally(r4, r2)
            return
        L_0x003a:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003c }
        L_0x003c:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.SQLiteCopyOpenHelper.dispatchOnOpenPrepackagedDatabase(java.io.File, boolean):void");
    }

    private final SupportSQLiteOpenHelper createFrameworkOpenHelper(File file) {
        try {
            int readVersion = DBUtil.readVersion(file);
            return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.Companion.builder(this.context).name(file.getAbsolutePath()).callback(new SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1(readVersion, RangesKt.coerceAtLeast(readVersion, 1))).build());
        } catch (IOException e) {
            throw new RuntimeException("Malformed database file, unable to read version.", e);
        }
    }
}
