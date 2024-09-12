package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda22 implements SQLiteEventStore.Function {
    public final /* synthetic */ long f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda22(long j) {
        this.f$0 = j;
    }

    public final Object apply(Object obj) {
        return SQLiteEventStore.lambda$getTimeWindow$22(this.f$0, (SQLiteDatabase) obj);
    }
}
