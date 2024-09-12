package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda16 implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda16(SQLiteEventStore sQLiteEventStore, String str, String str2) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = str;
        this.f$2 = str2;
    }

    public final Object apply(Object obj) {
        return this.f$0.m435lambda$recordFailure$4$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(this.f$1, this.f$2, (SQLiteDatabase) obj);
    }
}
