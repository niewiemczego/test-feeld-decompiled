package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda9 implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda9(SQLiteEventStore sQLiteEventStore, long j) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = j;
    }

    public final Object apply(Object obj) {
        return this.f$0.m427lambda$cleanUp$12$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(this.f$1, (SQLiteDatabase) obj);
    }
}
