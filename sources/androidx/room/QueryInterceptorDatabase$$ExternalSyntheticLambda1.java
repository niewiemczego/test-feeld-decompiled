package androidx.room;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryInterceptorDatabase$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ QueryInterceptorDatabase f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ QueryInterceptorDatabase$$ExternalSyntheticLambda1(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f$0 = queryInterceptorDatabase;
        this.f$1 = str;
    }

    public final void run() {
        QueryInterceptorDatabase.execSQL$lambda$10(this.f$0, this.f$1);
    }
}
