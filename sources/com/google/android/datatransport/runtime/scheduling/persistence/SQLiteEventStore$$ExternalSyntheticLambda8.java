package com.google.android.datatransport.runtime.scheduling.persistence;

import android.database.Cursor;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SQLiteEventStore$$ExternalSyntheticLambda8 implements SQLiteEventStore.Function {
    public final /* synthetic */ SQLiteEventStore f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ TransportContext f$2;

    public /* synthetic */ SQLiteEventStore$$ExternalSyntheticLambda8(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext) {
        this.f$0 = sQLiteEventStore;
        this.f$1 = list;
        this.f$2 = transportContext;
    }

    public final Object apply(Object obj) {
        return this.f$0.m432lambda$loadEvents$14$comgoogleandroiddatatransportruntimeschedulingpersistenceSQLiteEventStore(this.f$1, this.f$2, (Cursor) obj);
    }
}
