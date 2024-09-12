package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda18 implements SQLiteEventStore.Function {
    public final /* synthetic */ long f$0;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda18(long j) {
        this.f$0 = j;
    }

    public final Object apply(Object obj) {
        return ((Cursor) obj).moveToNext();
    }
}
