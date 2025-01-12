package androidx.work.impl;

import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.RawWorkInfoDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.utils.PreferenceUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class WorkDatabase_Impl extends WorkDatabase {
    private volatile DependencyDao _dependencyDao;
    private volatile PreferenceDao _preferenceDao;
    private volatile RawWorkInfoDao _rawWorkInfoDao;
    private volatile SystemIdInfoDao _systemIdInfoDao;
    private volatile WorkNameDao _workNameDao;
    private volatile WorkProgressDao _workProgressDao;
    private volatile WorkSpecDao _workSpecDao;
    private volatile WorkTagDao _workTagDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(16) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `last_enqueue_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `period_count` INTEGER NOT NULL DEFAULT 0, `generation` INTEGER NOT NULL DEFAULT 0, `required_network_type` INTEGER NOT NULL, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB NOT NULL, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_last_enqueue_time` ON `WorkSpec` (`last_enqueue_time`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `generation` INTEGER NOT NULL DEFAULT 0, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`, `generation`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL(PreferenceUtils.CREATE_PREFERENCE);
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5181942b9ebc31ce68dacb56c16fd79f')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = WorkDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (WorkDatabase_Impl.this.mCallbacks != null) {
                    int size = WorkDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
                hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "Dependency");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(27);
                hashMap2.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap2.put("state", new TableInfo.Column("state", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", "TEXT", false, 0, (String) null, 1));
                hashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("output", new TableInfo.Column("output", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("last_enqueue_time", new TableInfo.Column("last_enqueue_time", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("period_count", new TableInfo.Column("period_count", "INTEGER", true, 0, "0", 1));
                hashMap2.put("generation", new TableInfo.Column("generation", "INTEGER", true, 0, "0", 1));
                hashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", true, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"}), Arrays.asList(new String[]{"ASC"})));
                hashSet4.add(new TableInfo.Index("index_WorkSpec_last_enqueue_time", false, Arrays.asList(new String[]{"last_enqueue_time"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", hashMap2, hashSet3, hashSet4);
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "WorkSpec");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new TableInfo.Column("tag", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo3 = new TableInfo("WorkTag", hashMap3, hashSet5, hashSet6);
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "WorkTag");
                if (!tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                }
                HashMap hashMap4 = new HashMap(3);
                hashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap4.put("generation", new TableInfo.Column("generation", "INTEGER", true, 2, "0", 1));
                hashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                TableInfo tableInfo4 = new TableInfo("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                TableInfo read4 = TableInfo.read(supportSQLiteDatabase2, "SystemIdInfo");
                if (!tableInfo4.equals(read4)) {
                    return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + read4);
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new TableInfo.Column("name", "TEXT", true, 1, (String) null, 1));
                hashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 2, (String) null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"ASC"})));
                TableInfo tableInfo5 = new TableInfo("WorkName", hashMap5, hashSet8, hashSet9);
                TableInfo read5 = TableInfo.read(supportSQLiteDatabase2, "WorkName");
                if (!tableInfo5.equals(read5)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + read5);
                }
                HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new TableInfo.Column("work_spec_id", "TEXT", true, 1, (String) null, 1));
                hashMap6.put(NotificationCompat.CATEGORY_PROGRESS, new TableInfo.Column(NotificationCompat.CATEGORY_PROGRESS, "BLOB", true, 0, (String) null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                TableInfo tableInfo6 = new TableInfo("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                TableInfo read6 = TableInfo.read(supportSQLiteDatabase2, "WorkProgress");
                if (!tableInfo6.equals(read6)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + read6);
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new TableInfo.Column("key", "TEXT", true, 1, (String) null, 1));
                hashMap7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("Preference", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo read7 = TableInfo.read(supportSQLiteDatabase2, "Preference");
                if (!tableInfo7.equals(read7)) {
                    return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + read7);
                }
                return new RoomOpenHelper.ValidationResult(true, (String) null);
            }
        }, "5181942b9ebc31ce68dacb56c16fd79f", "ae2044fb577e65ee8bb576ca48a2f06e")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (!z) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (z) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `Dependency`");
        writableDatabase.execSQL("DELETE FROM `WorkSpec`");
        writableDatabase.execSQL("DELETE FROM `WorkTag`");
        writableDatabase.execSQL("DELETE FROM `SystemIdInfo`");
        writableDatabase.execSQL("DELETE FROM `WorkName`");
        writableDatabase.execSQL("DELETE FROM `WorkProgress`");
        writableDatabase.execSQL("DELETE FROM `Preference`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (!z) {
            writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
        }
        writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
        if (!writableDatabase.inTransaction()) {
            writableDatabase.execSQL("VACUUM");
        }
    }

    /* access modifiers changed from: protected */
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(WorkSpecDao.class, WorkSpecDao_Impl.getRequiredConverters());
        hashMap.put(DependencyDao.class, DependencyDao_Impl.getRequiredConverters());
        hashMap.put(WorkTagDao.class, WorkTagDao_Impl.getRequiredConverters());
        hashMap.put(SystemIdInfoDao.class, SystemIdInfoDao_Impl.getRequiredConverters());
        hashMap.put(WorkNameDao.class, WorkNameDao_Impl.getRequiredConverters());
        hashMap.put(WorkProgressDao.class, WorkProgressDao_Impl.getRequiredConverters());
        hashMap.put(PreferenceDao.class, PreferenceDao_Impl.getRequiredConverters());
        hashMap.put(RawWorkInfoDao.class, RawWorkInfoDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[]{new WorkDatabase_AutoMigration_13_14_Impl(), new WorkDatabase_AutoMigration_14_15_Impl()});
    }

    public WorkSpecDao workSpecDao() {
        WorkSpecDao workSpecDao;
        if (this._workSpecDao != null) {
            return this._workSpecDao;
        }
        synchronized (this) {
            if (this._workSpecDao == null) {
                this._workSpecDao = new WorkSpecDao_Impl(this);
            }
            workSpecDao = this._workSpecDao;
        }
        return workSpecDao;
    }

    public DependencyDao dependencyDao() {
        DependencyDao dependencyDao;
        if (this._dependencyDao != null) {
            return this._dependencyDao;
        }
        synchronized (this) {
            if (this._dependencyDao == null) {
                this._dependencyDao = new DependencyDao_Impl(this);
            }
            dependencyDao = this._dependencyDao;
        }
        return dependencyDao;
    }

    public WorkTagDao workTagDao() {
        WorkTagDao workTagDao;
        if (this._workTagDao != null) {
            return this._workTagDao;
        }
        synchronized (this) {
            if (this._workTagDao == null) {
                this._workTagDao = new WorkTagDao_Impl(this);
            }
            workTagDao = this._workTagDao;
        }
        return workTagDao;
    }

    public SystemIdInfoDao systemIdInfoDao() {
        SystemIdInfoDao systemIdInfoDao;
        if (this._systemIdInfoDao != null) {
            return this._systemIdInfoDao;
        }
        synchronized (this) {
            if (this._systemIdInfoDao == null) {
                this._systemIdInfoDao = new SystemIdInfoDao_Impl(this);
            }
            systemIdInfoDao = this._systemIdInfoDao;
        }
        return systemIdInfoDao;
    }

    public WorkNameDao workNameDao() {
        WorkNameDao workNameDao;
        if (this._workNameDao != null) {
            return this._workNameDao;
        }
        synchronized (this) {
            if (this._workNameDao == null) {
                this._workNameDao = new WorkNameDao_Impl(this);
            }
            workNameDao = this._workNameDao;
        }
        return workNameDao;
    }

    public WorkProgressDao workProgressDao() {
        WorkProgressDao workProgressDao;
        if (this._workProgressDao != null) {
            return this._workProgressDao;
        }
        synchronized (this) {
            if (this._workProgressDao == null) {
                this._workProgressDao = new WorkProgressDao_Impl(this);
            }
            workProgressDao = this._workProgressDao;
        }
        return workProgressDao;
    }

    public PreferenceDao preferenceDao() {
        PreferenceDao preferenceDao;
        if (this._preferenceDao != null) {
            return this._preferenceDao;
        }
        synchronized (this) {
            if (this._preferenceDao == null) {
                this._preferenceDao = new PreferenceDao_Impl(this);
            }
            preferenceDao = this._preferenceDao;
        }
        return preferenceDao;
    }

    public RawWorkInfoDao rawWorkInfoDao() {
        RawWorkInfoDao rawWorkInfoDao;
        if (this._rawWorkInfoDao != null) {
            return this._rawWorkInfoDao;
        }
        synchronized (this) {
            if (this._rawWorkInfoDao == null) {
                this._rawWorkInfoDao = new RawWorkInfoDao_Impl(this);
            }
            rawWorkInfoDao = this._rawWorkInfoDao;
        }
        return rawWorkInfoDao;
    }
}
