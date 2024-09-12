package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.work.Logger;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\r"}, d2 = {"Landroidx/work/impl/WorkDatabasePathHelper;", "", "()V", "getDatabasePath", "Ljava/io/File;", "context", "Landroid/content/Context;", "getDefaultDatabasePath", "getNoBackupPath", "migrateDatabase", "", "migrationPaths", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkDatabasePathHelper.kt */
public final class WorkDatabasePathHelper {
    public static final WorkDatabasePathHelper INSTANCE = new WorkDatabasePathHelper();

    private WorkDatabasePathHelper() {
    }

    @JvmStatic
    public static final void migrateDatabase(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        WorkDatabasePathHelper workDatabasePathHelper = INSTANCE;
        File defaultDatabasePath = workDatabasePathHelper.getDefaultDatabasePath(context);
        if (Build.VERSION.SDK_INT >= 23 && defaultDatabasePath.exists()) {
            Logger.get().debug(WorkDatabasePathHelperKt.TAG, "Migrating WorkDatabase to the no-backup directory");
            for (Map.Entry next : workDatabasePathHelper.migrationPaths(context).entrySet()) {
                File file = (File) next.getKey();
                File file2 = (File) next.getValue();
                if (file.exists()) {
                    if (file2.exists()) {
                        Logger.get().warning(WorkDatabasePathHelperKt.TAG, "Over-writing contents of " + file2);
                    }
                    if (file.renameTo(file2)) {
                        str = "Migrated " + file + "to " + file2;
                    } else {
                        str = "Renaming " + file + " to " + file2 + " failed";
                    }
                    Logger.get().debug(WorkDatabasePathHelperKt.TAG, str);
                }
            }
        }
    }

    public final Map<File, File> migrationPaths(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return MapsKt.emptyMap();
        }
        File defaultDatabasePath = getDefaultDatabasePath(context);
        File databasePath = getDatabasePath(context);
        String[] access$getDATABASE_EXTRA_FILES$p = WorkDatabasePathHelperKt.DATABASE_EXTRA_FILES;
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(access$getDATABASE_EXTRA_FILES$p.length), 16));
        for (String str : access$getDATABASE_EXTRA_FILES$p) {
            Pair pair = TuplesKt.to(new File(defaultDatabasePath.getPath() + str), new File(databasePath.getPath() + str));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return MapsKt.plus(linkedHashMap, TuplesKt.to(defaultDatabasePath, databasePath));
    }

    public final File getDefaultDatabasePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        File databasePath = context.getDatabasePath(WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(WORK_DATABASE_NAME)");
        return databasePath;
    }

    public final File getDatabasePath(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 23) {
            return getDefaultDatabasePath(context);
        }
        return getNoBackupPath(context);
    }

    private final File getNoBackupPath(Context context) {
        return new File(Api21Impl.INSTANCE.getNoBackupFilesDir(context), WorkDatabasePathHelperKt.WORK_DATABASE_NAME);
    }
}
