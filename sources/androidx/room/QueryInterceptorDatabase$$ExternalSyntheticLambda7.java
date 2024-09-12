package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ SupportSQLiteQuery f$1;
    public final /* synthetic */ QueryInterceptorProgram f$2;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda7(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = supportSQLiteQuery;
        this.f$2 = queryInterceptorProgram;
    }

    public final void run() {
        QueryInterceptorDatabase.query$lambda$8(this.f$0, this.f$1, this.f$2);
    }
}
