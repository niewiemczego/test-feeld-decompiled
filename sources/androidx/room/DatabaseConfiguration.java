package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001Bi\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017B\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bB\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fB¥\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!¢\u0006\u0002\u0010#B¯\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u0010&B½\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\u0010(BË\u0001\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b¢\u0006\u0002\u0010+BÍ\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\b\u0010,\u001a\u0004\u0018\u00010-\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010$\u001a\u0004\u0018\u00010%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u00020\u000e2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0016H\u0016J\u0010\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u0016H\u0017R\u0010\u0010\u001a\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00108\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010,\u001a\u0004\u0018\u00010-8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010$\u001a\u0004\u0018\u00010%8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u00128\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Landroidx/room/DatabaseConfiguration;", "", "context", "Landroid/content/Context;", "name", "", "sqliteOpenHelperFactory", "Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;", "migrationContainer", "Landroidx/room/RoomDatabase$MigrationContainer;", "callbacks", "", "Landroidx/room/RoomDatabase$Callback;", "allowMainThreadQueries", "", "journalMode", "Landroidx/room/RoomDatabase$JournalMode;", "queryExecutor", "Ljava/util/concurrent/Executor;", "requireMigration", "migrationNotRequiredFrom", "", "", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;ZLjava/util/Set;)V", "transactionExecutor", "multiInstanceInvalidation", "allowDestructiveMigrationOnDowngrade", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;)V", "copyFromAssetPath", "copyFromFile", "Ljava/io/File;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;)V", "copyFromInputStream", "Ljava/util/concurrent/Callable;", "Ljava/io/InputStream;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;)V", "prepackagedDatabaseCallback", "Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;)V", "typeConverters", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;)V", "autoMigrationSpecs", "Landroidx/room/migration/AutoMigrationSpec;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;ZZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "multiInstanceInvalidationServiceIntent", "Landroid/content/Intent;", "(Landroid/content/Context;Ljava/lang/String;Landroidx/sqlite/db/SupportSQLiteOpenHelper$Factory;Landroidx/room/RoomDatabase$MigrationContainer;Ljava/util/List;ZLandroidx/room/RoomDatabase$JournalMode;Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroid/content/Intent;ZZLjava/util/Set;Ljava/lang/String;Ljava/io/File;Ljava/util/concurrent/Callable;Landroidx/room/RoomDatabase$PrepackagedDatabaseCallback;Ljava/util/List;Ljava/util/List;)V", "isMigrationRequired", "fromVersion", "toVersion", "isMigrationRequiredFrom", "version", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DatabaseConfiguration.kt */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<? extends RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, Executor executor2, Intent intent, boolean z2, boolean z3, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback2, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        RoomDatabase.JournalMode journalMode3 = journalMode2;
        Executor executor3 = executor;
        Executor executor4 = executor2;
        Intent intent2 = intent;
        List<? extends Object> list4 = list2;
        List<? extends AutoMigrationSpec> list5 = list3;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(factory, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(migrationContainer2, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode3, "journalMode");
        Intrinsics.checkNotNullParameter(executor3, "queryExecutor");
        Intrinsics.checkNotNullParameter(executor4, "transactionExecutor");
        Intrinsics.checkNotNullParameter(list4, "typeConverters");
        Intrinsics.checkNotNullParameter(list5, "autoMigrationSpecs");
        this.context = context2;
        this.name = str;
        this.sqliteOpenHelperFactory = factory;
        this.migrationContainer = migrationContainer2;
        this.callbacks = list;
        this.allowMainThreadQueries = z;
        this.journalMode = journalMode3;
        this.queryExecutor = executor3;
        this.transactionExecutor = executor4;
        this.multiInstanceInvalidationServiceIntent = intent2;
        this.requireMigration = z2;
        this.allowDestructiveMigrationOnDowngrade = z3;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback2;
        this.typeConverters = list4;
        this.autoMigrationSpecs = list5;
        this.multiInstanceInvalidation = intent2 != null;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "This constructor is deprecated.", replaceWith = @ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    public DatabaseConfiguration(Context context2, String str, SupportSQLiteOpenHelper.Factory factory, RoomDatabase.MigrationContainer migrationContainer2, List<? extends RoomDatabase.Callback> list, boolean z, RoomDatabase.JournalMode journalMode2, Executor executor, boolean z2, Set<Integer> set) {
        this(context2, str, factory, migrationContainer2, list, z, journalMode2, executor, executor, (Intent) null, z2, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) CollectionsKt.emptyList(), (List<? extends AutoMigrationSpec>) CollectionsKt.emptyList());
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(factory, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(migrationContainer2, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode2, "journalMode");
        Intrinsics.checkNotNullParameter(executor, "queryExecutor");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r30 == 0) goto L_0x0034
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r10 = r0
            java.util.List r18 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r19 = kotlin.collections.CollectionsKt.emptyList()
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r30 == 0) goto L_0x0034
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r10 = r0
            java.util.List r18 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r19 = kotlin.collections.CollectionsKt.emptyList()
            r16 = 0
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r30 == 0) goto L_0x0034
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r10 = r0
            java.util.List r18 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r19 = kotlin.collections.CollectionsKt.emptyList()
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            if (r30 == 0) goto L_0x0034
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r10 = r0
            java.util.List r18 = kotlin.collections.CollectionsKt.emptyList()
            java.util.List r19 = kotlin.collections.CollectionsKt.emptyList()
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, java.util.List<? extends java.lang.Object> r38) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "typeConverters"
            r15 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            if (r30 == 0) goto L_0x003b
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x003c
        L_0x003b:
            r0 = 0
        L_0x003c:
            r10 = r0
            java.util.List r19 = kotlin.collections.CollectionsKt.emptyList()
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "This constructor is deprecated.", replaceWith = @kotlin.ReplaceWith(expression = "DatabaseConfiguration(Context, String, SupportSQLiteOpenHelper.Factory, RoomDatabase.MigrationContainer, List, boolean, RoomDatabase.JournalMode, Executor, Executor, Intent, boolean, boolean, Set, String, File, Callable, RoomDatabase.PrepackagedDatabaseCallback, List, List)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DatabaseConfiguration(android.content.Context r21, java.lang.String r22, androidx.sqlite.db.SupportSQLiteOpenHelper.Factory r23, androidx.room.RoomDatabase.MigrationContainer r24, java.util.List<? extends androidx.room.RoomDatabase.Callback> r25, boolean r26, androidx.room.RoomDatabase.JournalMode r27, java.util.concurrent.Executor r28, java.util.concurrent.Executor r29, boolean r30, boolean r31, boolean r32, java.util.Set<java.lang.Integer> r33, java.lang.String r34, java.io.File r35, java.util.concurrent.Callable<java.io.InputStream> r36, androidx.room.RoomDatabase.PrepackagedDatabaseCallback r37, java.util.List<? extends java.lang.Object> r38, java.util.List<? extends androidx.room.migration.AutoMigrationSpec> r39) {
        /*
            r20 = this;
            r1 = r21
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "sqliteOpenHelperFactory"
            r3 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "migrationContainer"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "journalMode"
            r7 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "queryExecutor"
            r8 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "transactionExecutor"
            r9 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "typeConverters"
            r15 = r38
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "autoMigrationSpecs"
            r14 = r39
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            if (r30 == 0) goto L_0x0042
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<androidx.room.MultiInstanceInvalidationService> r2 = androidx.room.MultiInstanceInvalidationService.class
            r0.<init>(r1, r2)
            goto L_0x0043
        L_0x0042:
            r0 = 0
        L_0x0043:
            r10 = r0
            r17 = 0
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r11 = r31
            r12 = r32
            r13 = r33
            r14 = r34
            r15 = r35
            r16 = r36
            r18 = r38
            r19 = r39
            r0.<init>((android.content.Context) r1, (java.lang.String) r2, (androidx.sqlite.db.SupportSQLiteOpenHelper.Factory) r3, (androidx.room.RoomDatabase.MigrationContainer) r4, (java.util.List<? extends androidx.room.RoomDatabase.Callback>) r5, (boolean) r6, (androidx.room.RoomDatabase.JournalMode) r7, (java.util.concurrent.Executor) r8, (java.util.concurrent.Executor) r9, (android.content.Intent) r10, (boolean) r11, (boolean) r12, (java.util.Set<java.lang.Integer>) r13, (java.lang.String) r14, (java.io.File) r15, (java.util.concurrent.Callable<java.io.InputStream>) r16, (androidx.room.RoomDatabase.PrepackagedDatabaseCallback) r17, (java.util.List<? extends java.lang.Object>) r18, (java.util.List<? extends androidx.room.migration.AutoMigrationSpec>) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.DatabaseConfiguration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Factory, androidx.room.RoomDatabase$MigrationContainer, java.util.List, boolean, androidx.room.RoomDatabase$JournalMode, java.util.concurrent.Executor, java.util.concurrent.Executor, boolean, boolean, boolean, java.util.Set, java.lang.String, java.io.File, java.util.concurrent.Callable, androidx.room.RoomDatabase$PrepackagedDatabaseCallback, java.util.List, java.util.List):void");
    }

    @Deprecated(message = "Use [isMigrationRequired(int, int)] which takes\n      [allowDestructiveMigrationOnDowngrade] into account.", replaceWith = @ReplaceWith(expression = "isMigrationRequired(version, version + 1)", imports = {}))
    public boolean isMigrationRequiredFrom(int i) {
        return isMigrationRequired(i, i + 1);
    }

    public boolean isMigrationRequired(int i, int i2) {
        Set<Integer> set;
        if ((i > i2) && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        if (!this.requireMigration || ((set = this.migrationNotRequiredFrom) != null && set.contains(Integer.valueOf(i)))) {
            return false;
        }
        return true;
    }
}
