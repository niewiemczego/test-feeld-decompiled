package app.notifee.core.database;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import n.o.t.i.f.e.e.o;
import n.o.t.i.f.e.e.q;

public class a {
    public static a b;
    public o a;

    public a(Context context) {
        this.a = NotifeeCoreDatabase.a(context).a();
    }

    public static a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context);
            }
            aVar = b;
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(q qVar) {
        this.a.a(qVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        this.a.a(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ q d(String str) throws Exception {
        return this.a.b(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.a.b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d() throws Exception {
        return this.a.a();
    }

    public Task<q> b(String str) {
        return Tasks.call(NotifeeCoreDatabase.b, new a$$ExternalSyntheticLambda7(this, str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List b(Boolean bool) throws Exception {
        return this.a.a(bool);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(q qVar) {
        this.a.b(qVar);
    }

    public void d(q qVar) {
        NotifeeCoreDatabase.b.execute(new a$$ExternalSyntheticLambda3(this, qVar));
    }

    public Task<List<q>> b() {
        return Tasks.call(NotifeeCoreDatabase.b, new a$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(List list) {
        this.a.a((List<String>) list);
    }

    public void a(q qVar) {
        NotifeeCoreDatabase.b.execute(new a$$ExternalSyntheticLambda4(this, qVar));
    }

    public Task<List<q>> a(Boolean bool) {
        return Tasks.call(NotifeeCoreDatabase.b, new a$$ExternalSyntheticLambda5(this, bool));
    }

    public void a(String str) {
        NotifeeCoreDatabase.b.execute(new a$$ExternalSyntheticLambda6(this, str));
    }

    public void a(List<String> list) {
        NotifeeCoreDatabase.b.execute(new a$$ExternalSyntheticLambda2(this, list));
    }

    public void a() {
        NotifeeCoreDatabase.b.execute(new a$$ExternalSyntheticLambda1(this));
    }
}
