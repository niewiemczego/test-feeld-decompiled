package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueuedTime;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final EntityDeletionOrUpdateAdapter<WorkSpec> __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workSpec.id);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
                if (workSpec.workerClassName == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                }
                if (workSpec.inputMergerClassName == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
                WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
                WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    supportSQLiteStatement.bindLong(20, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(21, constraints.requiresCharging() ? 1 : 0);
                    supportSQLiteStatement.bindLong(22, constraints.requiresDeviceIdle() ? 1 : 0);
                    supportSQLiteStatement.bindLong(23, constraints.requiresBatteryNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(24, constraints.requiresStorageNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(25, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(26, constraints.getContentTriggerMaxDelayMillis());
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(27);
                    } else {
                        supportSQLiteStatement.bindBlob(27, ofTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(20);
                    supportSQLiteStatement.bindNull(21);
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                }
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter<WorkSpec>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, workSpec.id);
                }
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(2, (long) WorkTypeConverters.stateToInt(workSpec.state));
                if (workSpec.workerClassName == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, workSpec.workerClassName);
                }
                if (workSpec.inputMergerClassName == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, workSpec.inputMergerClassName);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec.input);
                if (byteArrayInternal == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec.output);
                if (byteArrayInternal2 == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindBlob(6, byteArrayInternal2);
                }
                supportSQLiteStatement.bindLong(7, workSpec.initialDelay);
                supportSQLiteStatement.bindLong(8, workSpec.intervalDuration);
                supportSQLiteStatement.bindLong(9, workSpec.flexDuration);
                supportSQLiteStatement.bindLong(10, (long) workSpec.runAttemptCount);
                WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(11, (long) WorkTypeConverters.backoffPolicyToInt(workSpec.backoffPolicy));
                supportSQLiteStatement.bindLong(12, workSpec.backoffDelayDuration);
                supportSQLiteStatement.bindLong(13, workSpec.lastEnqueueTime);
                supportSQLiteStatement.bindLong(14, workSpec.minimumRetentionDuration);
                supportSQLiteStatement.bindLong(15, workSpec.scheduleRequestedAt);
                supportSQLiteStatement.bindLong(16, workSpec.expedited ? 1 : 0);
                WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                supportSQLiteStatement.bindLong(17, (long) WorkTypeConverters.outOfQuotaPolicyToInt(workSpec.outOfQuotaPolicy));
                supportSQLiteStatement.bindLong(18, (long) workSpec.getPeriodCount());
                supportSQLiteStatement.bindLong(19, (long) workSpec.getGeneration());
                Constraints constraints = workSpec.constraints;
                if (constraints != null) {
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    supportSQLiteStatement.bindLong(20, (long) WorkTypeConverters.networkTypeToInt(constraints.getRequiredNetworkType()));
                    supportSQLiteStatement.bindLong(21, constraints.requiresCharging() ? 1 : 0);
                    supportSQLiteStatement.bindLong(22, constraints.requiresDeviceIdle() ? 1 : 0);
                    supportSQLiteStatement.bindLong(23, constraints.requiresBatteryNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(24, constraints.requiresStorageNotLow() ? 1 : 0);
                    supportSQLiteStatement.bindLong(25, constraints.getContentTriggerUpdateDelayMillis());
                    supportSQLiteStatement.bindLong(26, constraints.getContentTriggerMaxDelayMillis());
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    byte[] ofTriggersToByteArray = WorkTypeConverters.setOfTriggersToByteArray(constraints.getContentUriTriggers());
                    if (ofTriggersToByteArray == null) {
                        supportSQLiteStatement.bindNull(27);
                    } else {
                        supportSQLiteStatement.bindBlob(27, ofTriggersToByteArray);
                    }
                } else {
                    supportSQLiteStatement.bindNull(20);
                    supportSQLiteStatement.bindNull(21);
                    supportSQLiteStatement.bindNull(22);
                    supportSQLiteStatement.bindNull(23);
                    supportSQLiteStatement.bindNull(24);
                    supportSQLiteStatement.bindNull(25);
                    supportSQLiteStatement.bindNull(26);
                    supportSQLiteStatement.bindNull(27);
                }
                if (workSpec.id == null) {
                    supportSQLiteStatement.bindNull(28);
                } else {
                    supportSQLiteStatement.bindString(28, workSpec.id);
                }
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueuedTime = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
    }

    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
        }
    }

    public int setState(WorkInfo.State state, String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetState.acquire();
        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
        acquire.bindLong(1, (long) WorkTypeConverters.stateToInt(state));
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetState.release(acquire);
        }
    }

    public void incrementPeriodCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementPeriodCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementPeriodCount.release(acquire);
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
        }
    }

    public void setLastEnqueuedTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfSetLastEnqueuedTime.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLastEnqueuedTime.release(acquire);
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
        }
    }

    public int markWorkSpecScheduled(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        acquire.bindLong(1, j);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(acquire);
        }
    }

    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(acquire);
        }
    }

    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(acquire);
        }
    }

    public void incrementGeneration(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfIncrementGeneration.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementGeneration.release(acquire);
        }
    }

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        String str2;
        String str3;
        String str4;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        byte[] bArr3;
        String str5 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if (str5 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str5);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                if (query.moveToFirst()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow);
                    }
                    int i6 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i6);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i7 = query.getInt(columnIndexOrThrow10);
                    int i8 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i8);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    long j6 = query.getLong(columnIndexOrThrow14);
                    long j7 = query.getLong(columnIndexOrThrow15);
                    if (query.getInt(columnIndexOrThrow16) != 0) {
                        i = columnIndexOrThrow17;
                        z = true;
                    } else {
                        i = columnIndexOrThrow17;
                        z = false;
                    }
                    int i9 = query.getInt(i);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i9);
                    int i10 = query.getInt(columnIndexOrThrow18);
                    int i11 = query.getInt(columnIndexOrThrow19);
                    int i12 = query.getInt(columnIndexOrThrow20);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i12);
                    if (query.getInt(columnIndexOrThrow21) != 0) {
                        i2 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        i2 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i2) != 0) {
                        i3 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        i3 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        i4 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        i4 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        i5 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        i5 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j8 = query.getLong(i5);
                    long j9 = query.getLong(columnIndexOrThrow26);
                    if (query.isNull(columnIndexOrThrow27)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(columnIndexOrThrow27);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    workSpec = new WorkSpec(str2, intToState, str3, str4, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(intToNetworkType, z2, z3, z4, z5, j8, j9, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i7, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i10, i11);
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                int i = query.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                arrayList.add(new WorkSpec.IdAndState(str2, WorkTypeConverters.intToState(i)));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllWorkSpecIds() {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                arrayList.add(str);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<List<String>> getAllWorkSpecIdsLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, new Callable<List<String>>() {
            public List<String> call() throws Exception {
                Cursor query;
                String str;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        arrayList.add(str);
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public WorkInfo.State getState(String str) {
        Integer num;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo.State state = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                if (query.isNull(0)) {
                    num = null;
                } else {
                    num = Integer.valueOf(query.getInt(0));
                }
                if (num != null) {
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    state = WorkTypeConverters.intToState(num.intValue());
                }
            }
            return state;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: androidx.work.impl.model.WorkSpec$WorkInfoPojo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r9v4, types: [androidx.work.impl.model.WorkSpec$WorkInfoPojo] */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.work.impl.model.WorkSpec.WorkInfoPojo getWorkStatusPojoForId(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            java.lang.String r2 = "SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?"
            r3 = 1
            androidx.room.RoomSQLiteQuery r2 = androidx.room.RoomSQLiteQuery.acquire(r2, r3)
            if (r0 != 0) goto L_0x0011
            r2.bindNull(r3)
            goto L_0x0014
        L_0x0011:
            r2.bindString(r3, r0)
        L_0x0014:
            androidx.room.RoomDatabase r0 = r1.__db
            r0.assertNotSuspendingTransaction()
            androidx.room.RoomDatabase r0 = r1.__db
            r0.beginTransaction()
            androidx.room.RoomDatabase r0 = r1.__db     // Catch:{ all -> 0x00e4 }
            r4 = 0
            android.database.Cursor r5 = androidx.room.util.DBUtil.query(r0, r2, r3, r4)     // Catch:{ all -> 0x00e4 }
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00dc }
            r6.<init>()     // Catch:{ all -> 0x00dc }
        L_0x002f:
            boolean r7 = r5.moveToNext()     // Catch:{ all -> 0x00dc }
            r8 = 0
            if (r7 == 0) goto L_0x005f
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x00dc }
            java.lang.Object r9 = r0.get(r7)     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r9 = (java.util.ArrayList) r9     // Catch:{ all -> 0x00dc }
            if (r9 != 0) goto L_0x004a
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r9.<init>()     // Catch:{ all -> 0x00dc }
            r0.put(r7, r9)     // Catch:{ all -> 0x00dc }
        L_0x004a:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x00dc }
            java.lang.Object r8 = r6.get(r7)     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x00dc }
            if (r8 != 0) goto L_0x002f
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r8.<init>()     // Catch:{ all -> 0x00dc }
            r6.put(r7, r8)     // Catch:{ all -> 0x00dc }
            goto L_0x002f
        L_0x005f:
            r7 = -1
            r5.moveToPosition(r7)     // Catch:{ all -> 0x00dc }
            r1.__fetchRelationshipWorkTagAsjavaLangString(r0)     // Catch:{ all -> 0x00dc }
            r1.__fetchRelationshipWorkProgressAsandroidxWorkData(r6)     // Catch:{ all -> 0x00dc }
            boolean r7 = r5.moveToFirst()     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x00cb
            boolean r7 = r5.isNull(r8)     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x0077
            r10 = r4
            goto L_0x007c
        L_0x0077:
            java.lang.String r7 = r5.getString(r8)     // Catch:{ all -> 0x00dc }
            r10 = r7
        L_0x007c:
            int r3 = r5.getInt(r3)     // Catch:{ all -> 0x00dc }
            androidx.work.impl.model.WorkTypeConverters r7 = androidx.work.impl.model.WorkTypeConverters.INSTANCE     // Catch:{ all -> 0x00dc }
            androidx.work.WorkInfo$State r11 = androidx.work.impl.model.WorkTypeConverters.intToState(r3)     // Catch:{ all -> 0x00dc }
            r3 = 2
            boolean r7 = r5.isNull(r3)     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            byte[] r4 = r5.getBlob(r3)     // Catch:{ all -> 0x00dc }
        L_0x0092:
            androidx.work.Data r12 = androidx.work.Data.fromByteArray(r4)     // Catch:{ all -> 0x00dc }
            r3 = 3
            int r13 = r5.getInt(r3)     // Catch:{ all -> 0x00dc }
            r3 = 4
            int r14 = r5.getInt(r3)     // Catch:{ all -> 0x00dc }
            java.lang.String r3 = r5.getString(r8)     // Catch:{ all -> 0x00dc }
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x00dc }
            if (r0 != 0) goto L_0x00b1
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
        L_0x00b1:
            r15 = r0
            java.lang.String r0 = r5.getString(r8)     // Catch:{ all -> 0x00dc }
            java.lang.Object r0 = r6.get(r0)     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x00dc }
            if (r0 != 0) goto L_0x00c3
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r0.<init>()     // Catch:{ all -> 0x00dc }
        L_0x00c3:
            r16 = r0
            androidx.work.impl.model.WorkSpec$WorkInfoPojo r4 = new androidx.work.impl.model.WorkSpec$WorkInfoPojo     // Catch:{ all -> 0x00dc }
            r9 = r4
            r9.<init>(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ all -> 0x00dc }
        L_0x00cb:
            androidx.room.RoomDatabase r0 = r1.__db     // Catch:{ all -> 0x00dc }
            r0.setTransactionSuccessful()     // Catch:{ all -> 0x00dc }
            r5.close()     // Catch:{ all -> 0x00e4 }
            r2.release()     // Catch:{ all -> 0x00e4 }
            androidx.room.RoomDatabase r0 = r1.__db
            r0.endTransaction()
            return r4
        L_0x00dc:
            r0 = move-exception
            r5.close()     // Catch:{ all -> 0x00e4 }
            r2.release()     // Catch:{ all -> 0x00e4 }
            throw r0     // Catch:{ all -> 0x00e4 }
        L_0x00e4:
            r0 = move-exception
            androidx.room.RoomDatabase r2 = r1.__db
            r2.endTransaction()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDao_Impl.getWorkStatusPojoForId(java.lang.String):androidx.work.impl.model.WorkSpec$WorkInfoPojo");
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> list) {
        Cursor query;
        String str;
        byte[] bArr;
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) arrayMap.get(string)) == null) {
                    arrayMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) arrayMap2.get(string2)) == null) {
                    arrayMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                int i2 = query.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                WorkInfo.State intToState = WorkTypeConverters.intToState(i2);
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i3 = query.getInt(3);
                int i4 = query.getInt(4);
                ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, i3, i4, arrayList3, arrayList4));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> list) {
        StringBuilder newStringBuilder = StringUtil.newStringBuilder();
        newStringBuilder.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int size = list.size();
        StringUtil.appendPlaceholders(newStringBuilder, size);
        newStringBuilder.append(")");
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size + 0);
        int i = 1;
        for (String next : list) {
            if (next == null) {
                acquire.bindNull(i);
            } else {
                acquire.bindString(i, next);
            }
            i++;
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        int i = query.getInt(1);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i2 = query.getInt(3);
                        int i3 = query.getInt(4);
                        ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, i2, i3, arrayList3, arrayList4));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String str) {
        Cursor query;
        String str2;
        byte[] bArr;
        String str3 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str3 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) arrayMap.get(string)) == null) {
                    arrayMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) arrayMap2.get(string2)) == null) {
                    arrayMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                int i = query.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i2 = query.getInt(3);
                int i3 = query.getInt(4);
                ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str2, intToState, fromByteArray, i2, i3, arrayList3, arrayList4));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        int i = query.getInt(1);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i2 = query.getInt(3);
                        int i3 = query.getInt(4);
                        ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, i2, i3, arrayList3, arrayList4));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String str) {
        Cursor query;
        String str2;
        byte[] bArr;
        String str3 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str3 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str3);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            query = DBUtil.query(this.__db, acquire, true, (CancellationSignal) null);
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            while (query.moveToNext()) {
                String string = query.getString(0);
                if (((ArrayList) arrayMap.get(string)) == null) {
                    arrayMap.put(string, new ArrayList());
                }
                String string2 = query.getString(0);
                if (((ArrayList) arrayMap2.get(string2)) == null) {
                    arrayMap2.put(string2, new ArrayList());
                }
            }
            query.moveToPosition(-1);
            __fetchRelationshipWorkTagAsjavaLangString(arrayMap);
            __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                int i = query.getInt(1);
                WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                if (query.isNull(2)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(2);
                }
                Data fromByteArray = Data.fromByteArray(bArr);
                int i2 = query.getInt(3);
                int i3 = query.getInt(4);
                ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                ArrayList arrayList3 = arrayList2;
                ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                if (arrayList4 == null) {
                    arrayList4 = new ArrayList();
                }
                arrayList.add(new WorkSpec.WorkInfoPojo(str2, intToState, fromByteArray, i2, i3, arrayList3, arrayList4));
            }
            this.__db.setTransactionSuccessful();
            query.close();
            acquire.release();
            this.__db.endTransaction();
            return arrayList;
        } catch (Throwable th) {
            this.__db.endTransaction();
            throw th;
        }
    }

    public LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, new Callable<List<WorkSpec.WorkInfoPojo>>() {
            public List<WorkSpec.WorkInfoPojo> call() throws Exception {
                Cursor query;
                String str;
                byte[] bArr;
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, true, (CancellationSignal) null);
                    ArrayMap arrayMap = new ArrayMap();
                    ArrayMap arrayMap2 = new ArrayMap();
                    while (query.moveToNext()) {
                        String string = query.getString(0);
                        if (((ArrayList) arrayMap.get(string)) == null) {
                            arrayMap.put(string, new ArrayList());
                        }
                        String string2 = query.getString(0);
                        if (((ArrayList) arrayMap2.get(string2)) == null) {
                            arrayMap2.put(string2, new ArrayList());
                        }
                    }
                    query.moveToPosition(-1);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap);
                    WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        if (query.isNull(0)) {
                            str = null;
                        } else {
                            str = query.getString(0);
                        }
                        int i = query.getInt(1);
                        WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                        WorkInfo.State intToState = WorkTypeConverters.intToState(i);
                        if (query.isNull(2)) {
                            bArr = null;
                        } else {
                            bArr = query.getBlob(2);
                        }
                        Data fromByteArray = Data.fromByteArray(bArr);
                        int i2 = query.getInt(3);
                        int i3 = query.getInt(4);
                        ArrayList arrayList2 = (ArrayList) arrayMap.get(query.getString(0));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = (ArrayList) arrayMap2.get(query.getString(0));
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList.add(new WorkSpec.WorkInfoPojo(str, intToState, fromByteArray, i2, i3, arrayList3, arrayList4));
                    }
                    WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                    query.close();
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    return arrayList;
                } catch (Throwable th) {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                    throw th;
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<Data> getInputsFromPrerequisites(String str) {
        byte[] bArr;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    bArr = null;
                } else {
                    bArr = query.getBlob(0);
                }
                arrayList.add(Data.fromByteArray(bArr));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithTag(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        String str2;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str2 = null;
                } else {
                    str2 = query.getString(0);
                }
                arrayList.add(str2);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getAllUnfinishedWork() {
        String str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                if (query.isNull(0)) {
                    str = null;
                } else {
                    str = query.getString(0);
                }
                arrayList.add(str);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean hasUnfinishedWork() {
        boolean z = false;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst() && query.getInt(0) != 0) {
                z = true;
            }
            return z;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public LiveData<Long> getScheduleRequestedAtLiveData(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, new Callable<Long>() {
            public Long call() throws Exception {
                Cursor query = DBUtil.query(WorkSpecDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    return Long.valueOf(query.moveToFirst() ? query.getLong(0) : 0);
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                acquire.release();
            }
        });
    }

    public List<WorkSpec> getEligibleWorkForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    int i8 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i8);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i9 = query.getInt(columnIndexOrThrow10);
                    int i10 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i10);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i11 = i7;
                    long j6 = query.getLong(i11);
                    int i12 = columnIndexOrThrow;
                    int i13 = columnIndexOrThrow15;
                    long j7 = query.getLong(i13);
                    columnIndexOrThrow15 = i13;
                    int i14 = columnIndexOrThrow16;
                    if (query.getInt(i14) != 0) {
                        columnIndexOrThrow16 = i14;
                        i2 = columnIndexOrThrow17;
                        z = true;
                    } else {
                        columnIndexOrThrow16 = i14;
                        i2 = columnIndexOrThrow17;
                        z = false;
                    }
                    int i15 = query.getInt(i2);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i15);
                    columnIndexOrThrow17 = i2;
                    int i16 = columnIndexOrThrow18;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow18 = i16;
                    int i18 = columnIndexOrThrow19;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow19 = i18;
                    int i20 = columnIndexOrThrow20;
                    int i21 = query.getInt(i20);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i21);
                    columnIndexOrThrow20 = i20;
                    int i22 = columnIndexOrThrow21;
                    if (query.getInt(i22) != 0) {
                        columnIndexOrThrow21 = i22;
                        i3 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        columnIndexOrThrow21 = i22;
                        i3 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        columnIndexOrThrow22 = i3;
                        i4 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        columnIndexOrThrow22 = i3;
                        i4 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        columnIndexOrThrow23 = i4;
                        i5 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        columnIndexOrThrow23 = i4;
                        i5 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i5) != 0) {
                        columnIndexOrThrow24 = i5;
                        i6 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        columnIndexOrThrow24 = i5;
                        i6 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j8 = query.getLong(i6);
                    columnIndexOrThrow25 = i6;
                    int i23 = columnIndexOrThrow26;
                    long j9 = query.getLong(i23);
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.isNull(i24)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i24);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    columnIndexOrThrow27 = i24;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(intToNetworkType, z2, z3, z4, z5, j8, j9, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i9, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i17, i19));
                    columnIndexOrThrow = i12;
                    i7 = i11;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        int i6;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i7 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    int i8 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i8);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i9 = query.getInt(columnIndexOrThrow10);
                    int i10 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i10);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i11 = i7;
                    long j6 = query.getLong(i11);
                    int i12 = columnIndexOrThrow;
                    int i13 = columnIndexOrThrow15;
                    long j7 = query.getLong(i13);
                    columnIndexOrThrow15 = i13;
                    int i14 = columnIndexOrThrow16;
                    if (query.getInt(i14) != 0) {
                        columnIndexOrThrow16 = i14;
                        i2 = columnIndexOrThrow17;
                        z = true;
                    } else {
                        columnIndexOrThrow16 = i14;
                        i2 = columnIndexOrThrow17;
                        z = false;
                    }
                    int i15 = query.getInt(i2);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i15);
                    columnIndexOrThrow17 = i2;
                    int i16 = columnIndexOrThrow18;
                    int i17 = query.getInt(i16);
                    columnIndexOrThrow18 = i16;
                    int i18 = columnIndexOrThrow19;
                    int i19 = query.getInt(i18);
                    columnIndexOrThrow19 = i18;
                    int i20 = columnIndexOrThrow20;
                    int i21 = query.getInt(i20);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i21);
                    columnIndexOrThrow20 = i20;
                    int i22 = columnIndexOrThrow21;
                    if (query.getInt(i22) != 0) {
                        columnIndexOrThrow21 = i22;
                        i3 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        columnIndexOrThrow21 = i22;
                        i3 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        columnIndexOrThrow22 = i3;
                        i4 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        columnIndexOrThrow22 = i3;
                        i4 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        columnIndexOrThrow23 = i4;
                        i5 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        columnIndexOrThrow23 = i4;
                        i5 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i5) != 0) {
                        columnIndexOrThrow24 = i5;
                        i6 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        columnIndexOrThrow24 = i5;
                        i6 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j8 = query.getLong(i6);
                    columnIndexOrThrow25 = i6;
                    int i23 = columnIndexOrThrow26;
                    long j9 = query.getLong(i23);
                    columnIndexOrThrow26 = i23;
                    int i24 = columnIndexOrThrow27;
                    if (query.isNull(i24)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i24);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    columnIndexOrThrow27 = i24;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(intToNetworkType, z2, z3, z4, z5, j8, j9, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i9, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i17, i19));
                    columnIndexOrThrow = i12;
                    i7 = i11;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    int i7 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i7);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    int i9 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i9);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i10 = i6;
                    long j6 = query.getLong(i10);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    long j7 = query.getLong(i12);
                    columnIndexOrThrow15 = i12;
                    int i13 = columnIndexOrThrow16;
                    if (query.getInt(i13) != 0) {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = true;
                    } else {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = false;
                    }
                    int i14 = query.getInt(i);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i14);
                    columnIndexOrThrow17 = i;
                    int i15 = columnIndexOrThrow18;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow18 = i15;
                    int i17 = columnIndexOrThrow19;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow19 = i17;
                    int i19 = columnIndexOrThrow20;
                    int i20 = query.getInt(i19);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i20);
                    columnIndexOrThrow20 = i19;
                    int i21 = columnIndexOrThrow21;
                    if (query.getInt(i21) != 0) {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i2) != 0) {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j8 = query.getLong(i5);
                    columnIndexOrThrow25 = i5;
                    int i22 = columnIndexOrThrow26;
                    long j9 = query.getLong(i22);
                    columnIndexOrThrow26 = i22;
                    int i23 = columnIndexOrThrow27;
                    if (query.isNull(i23)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i23);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    columnIndexOrThrow27 = i23;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(intToNetworkType, z2, z3, z4, z5, j8, j9, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i8, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i16, i18));
                    columnIndexOrThrow = i11;
                    i6 = i10;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    int i7 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i7);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j = query.getLong(columnIndexOrThrow7);
                    long j2 = query.getLong(columnIndexOrThrow8);
                    long j3 = query.getLong(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    int i9 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i9);
                    long j4 = query.getLong(columnIndexOrThrow12);
                    long j5 = query.getLong(columnIndexOrThrow13);
                    int i10 = i6;
                    long j6 = query.getLong(i10);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    long j7 = query.getLong(i12);
                    columnIndexOrThrow15 = i12;
                    int i13 = columnIndexOrThrow16;
                    if (query.getInt(i13) != 0) {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = true;
                    } else {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = false;
                    }
                    int i14 = query.getInt(i);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i14);
                    columnIndexOrThrow17 = i;
                    int i15 = columnIndexOrThrow18;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow18 = i15;
                    int i17 = columnIndexOrThrow19;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow19 = i17;
                    int i19 = columnIndexOrThrow20;
                    int i20 = query.getInt(i19);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i20);
                    columnIndexOrThrow20 = i19;
                    int i21 = columnIndexOrThrow21;
                    if (query.getInt(i21) != 0) {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i2) != 0) {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j8 = query.getLong(i5);
                    columnIndexOrThrow25 = i5;
                    int i22 = columnIndexOrThrow26;
                    long j9 = query.getLong(i22);
                    columnIndexOrThrow26 = i22;
                    int i23 = columnIndexOrThrow27;
                    if (query.isNull(i23)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i23);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    columnIndexOrThrow27 = i23;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j, j2, j3, new Constraints(intToNetworkType, z2, z3, z4, z5, j8, j9, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i8, intToBackoffPolicy, j4, j5, j6, j7, z, intToOutOfQuotaPolicy, i16, i18));
                    columnIndexOrThrow = i11;
                    i6 = i10;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRecentlyCompletedWork(long j) {
        RoomSQLiteQuery roomSQLiteQuery;
        String str;
        String str2;
        String str3;
        byte[] bArr;
        byte[] bArr2;
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        byte[] bArr3;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        acquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "output");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "initial_delay");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "interval_duration");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "flex_duration");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "run_attempt_count");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "backoff_policy");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "backoff_delay_duration");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "last_enqueue_time");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "minimum_retention_duration");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, "run_in_foreground");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "out_of_quota_policy");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "period_count");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "generation");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "required_network_type");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "requires_charging");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "requires_device_idle");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "requires_battery_not_low");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "requires_storage_not_low");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "trigger_content_update_delay");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "trigger_max_content_delay");
                int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(query, "content_uri_triggers");
                int i6 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    if (query.isNull(columnIndexOrThrow)) {
                        str = null;
                    } else {
                        str = query.getString(columnIndexOrThrow);
                    }
                    int i7 = query.getInt(columnIndexOrThrow2);
                    WorkTypeConverters workTypeConverters = WorkTypeConverters.INSTANCE;
                    WorkInfo.State intToState = WorkTypeConverters.intToState(i7);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow3);
                    }
                    if (query.isNull(columnIndexOrThrow4)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow4);
                    }
                    if (query.isNull(columnIndexOrThrow5)) {
                        bArr = null;
                    } else {
                        bArr = query.getBlob(columnIndexOrThrow5);
                    }
                    Data fromByteArray = Data.fromByteArray(bArr);
                    if (query.isNull(columnIndexOrThrow6)) {
                        bArr2 = null;
                    } else {
                        bArr2 = query.getBlob(columnIndexOrThrow6);
                    }
                    Data fromByteArray2 = Data.fromByteArray(bArr2);
                    long j2 = query.getLong(columnIndexOrThrow7);
                    long j3 = query.getLong(columnIndexOrThrow8);
                    long j4 = query.getLong(columnIndexOrThrow9);
                    int i8 = query.getInt(columnIndexOrThrow10);
                    int i9 = query.getInt(columnIndexOrThrow11);
                    WorkTypeConverters workTypeConverters2 = WorkTypeConverters.INSTANCE;
                    BackoffPolicy intToBackoffPolicy = WorkTypeConverters.intToBackoffPolicy(i9);
                    long j5 = query.getLong(columnIndexOrThrow12);
                    long j6 = query.getLong(columnIndexOrThrow13);
                    int i10 = i6;
                    long j7 = query.getLong(i10);
                    int i11 = columnIndexOrThrow;
                    int i12 = columnIndexOrThrow15;
                    long j8 = query.getLong(i12);
                    columnIndexOrThrow15 = i12;
                    int i13 = columnIndexOrThrow16;
                    if (query.getInt(i13) != 0) {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = true;
                    } else {
                        columnIndexOrThrow16 = i13;
                        i = columnIndexOrThrow17;
                        z = false;
                    }
                    int i14 = query.getInt(i);
                    WorkTypeConverters workTypeConverters3 = WorkTypeConverters.INSTANCE;
                    OutOfQuotaPolicy intToOutOfQuotaPolicy = WorkTypeConverters.intToOutOfQuotaPolicy(i14);
                    columnIndexOrThrow17 = i;
                    int i15 = columnIndexOrThrow18;
                    int i16 = query.getInt(i15);
                    columnIndexOrThrow18 = i15;
                    int i17 = columnIndexOrThrow19;
                    int i18 = query.getInt(i17);
                    columnIndexOrThrow19 = i17;
                    int i19 = columnIndexOrThrow20;
                    int i20 = query.getInt(i19);
                    WorkTypeConverters workTypeConverters4 = WorkTypeConverters.INSTANCE;
                    NetworkType intToNetworkType = WorkTypeConverters.intToNetworkType(i20);
                    columnIndexOrThrow20 = i19;
                    int i21 = columnIndexOrThrow21;
                    if (query.getInt(i21) != 0) {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = true;
                    } else {
                        columnIndexOrThrow21 = i21;
                        i2 = columnIndexOrThrow22;
                        z2 = false;
                    }
                    if (query.getInt(i2) != 0) {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = true;
                    } else {
                        columnIndexOrThrow22 = i2;
                        i3 = columnIndexOrThrow23;
                        z3 = false;
                    }
                    if (query.getInt(i3) != 0) {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = true;
                    } else {
                        columnIndexOrThrow23 = i3;
                        i4 = columnIndexOrThrow24;
                        z4 = false;
                    }
                    if (query.getInt(i4) != 0) {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = true;
                    } else {
                        columnIndexOrThrow24 = i4;
                        i5 = columnIndexOrThrow25;
                        z5 = false;
                    }
                    long j9 = query.getLong(i5);
                    columnIndexOrThrow25 = i5;
                    int i22 = columnIndexOrThrow26;
                    long j10 = query.getLong(i22);
                    columnIndexOrThrow26 = i22;
                    int i23 = columnIndexOrThrow27;
                    if (query.isNull(i23)) {
                        bArr3 = null;
                    } else {
                        bArr3 = query.getBlob(i23);
                    }
                    WorkTypeConverters workTypeConverters5 = WorkTypeConverters.INSTANCE;
                    columnIndexOrThrow27 = i23;
                    arrayList.add(new WorkSpec(str, intToState, str2, str3, fromByteArray, fromByteArray2, j2, j3, j4, new Constraints(intToNetworkType, z2, z3, z4, z5, j9, j10, WorkTypeConverters.byteArrayToSetOfTriggers(bArr3)), i8, intToBackoffPolicy, j5, j6, j7, j8, z, intToOutOfQuotaPolicy, i16, i18));
                    columnIndexOrThrow = i11;
                    i6 = i10;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap<String, ArrayList<String>> arrayMap) {
        String str;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap(999);
                int size = arrayMap.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                        arrayMap2 = new ArrayMap(999);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkTagAsjavaLangString(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                str = null;
                            } else {
                                str = query.getString(0);
                            }
                            arrayList.add(str);
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }

    /* access modifiers changed from: private */
    public void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap<String, ArrayList<Data>> arrayMap) {
        byte[] bArr;
        Set<String> keySet = arrayMap.keySet();
        if (!keySet.isEmpty()) {
            if (arrayMap.size() > 999) {
                ArrayMap arrayMap2 = new ArrayMap(999);
                int size = arrayMap.size();
                int i = 0;
                int i2 = 0;
                while (i < size) {
                    arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
                    i++;
                    i2++;
                    if (i2 == 999) {
                        __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                        arrayMap2 = new ArrayMap(999);
                        i2 = 0;
                    }
                }
                if (i2 > 0) {
                    __fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap2);
                    return;
                }
                return;
            }
            StringBuilder newStringBuilder = StringUtil.newStringBuilder();
            newStringBuilder.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
            int size2 = keySet.size();
            StringUtil.appendPlaceholders(newStringBuilder, size2);
            newStringBuilder.append(")");
            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(newStringBuilder.toString(), size2 + 0);
            int i3 = 1;
            for (String next : keySet) {
                if (next == null) {
                    acquire.bindNull(i3);
                } else {
                    acquire.bindString(i3, next);
                }
                i3++;
            }
            Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
            try {
                int columnIndex = CursorUtil.getColumnIndex(query, "work_spec_id");
                if (columnIndex != -1) {
                    while (query.moveToNext()) {
                        ArrayList arrayList = arrayMap.get(query.getString(columnIndex));
                        if (arrayList != null) {
                            if (query.isNull(0)) {
                                bArr = null;
                            } else {
                                bArr = query.getBlob(0);
                            }
                            arrayList.add(Data.fromByteArray(bArr));
                        }
                    }
                    query.close();
                }
            } finally {
                query.close();
            }
        }
    }
}
