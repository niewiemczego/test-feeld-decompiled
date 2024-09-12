package androidx.room;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda2(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f$0 = queryInterceptorDatabase;
    }

    public final void run() {
        QueryInterceptorDatabase.beginTransactionWithListener$lambda$2(this.f$0);
    }
}
