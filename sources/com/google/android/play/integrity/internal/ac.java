package com.google.android.play.integrity.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class ac {
    private static final Map a = new HashMap();
    /* access modifiers changed from: private */
    public final Context b;
    /* access modifiers changed from: private */
    public final q c;
    private final String d;
    /* access modifiers changed from: private */
    public final List e = new ArrayList();
    private final Set f = new HashSet();
    /* access modifiers changed from: private */
    public final Object g = new Object();
    /* access modifiers changed from: private */
    public boolean h;
    private final Intent i;
    /* access modifiers changed from: private */
    public final x j;
    private final WeakReference k;
    private final IBinder.DeathRecipient l = new t(this);
    /* access modifiers changed from: private */
    public final AtomicInteger m = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ServiceConnection f28n;
    /* access modifiers changed from: private */
    public IInterface o;

    public ac(Context context, q qVar, String str, Intent intent, x xVar, w wVar) {
        this.b = context;
        this.c = qVar;
        this.d = str;
        this.i = intent;
        this.j = xVar;
        this.k = new WeakReference((Object) null);
    }

    public static /* synthetic */ void k(ac acVar) {
        acVar.c.c("reportBinderDeath", new Object[0]);
        w wVar = (w) acVar.k.get();
        if (wVar != null) {
            acVar.c.c("calling onBinderDied", new Object[0]);
            wVar.a();
        } else {
            acVar.c.c("%s : Binder has died.", acVar.d);
            for (r a2 : acVar.e) {
                a2.a(acVar.w());
            }
            acVar.e.clear();
        }
        synchronized (acVar.g) {
            acVar.x();
        }
    }

    static /* bridge */ /* synthetic */ void o(ac acVar, TaskCompletionSource taskCompletionSource) {
        acVar.f.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new s(acVar, taskCompletionSource));
    }

    static /* bridge */ /* synthetic */ void r(ac acVar) {
        acVar.c.c("linkToDeath", new Object[0]);
        try {
            acVar.o.asBinder().linkToDeath(acVar.l, 0);
        } catch (RemoteException e2) {
            acVar.c.b(e2, "linkToDeath failed", new Object[0]);
        }
    }

    static /* bridge */ /* synthetic */ void s(ac acVar) {
        acVar.c.c("unlinkToDeath", new Object[0]);
        acVar.o.asBinder().unlinkToDeath(acVar.l, 0);
    }

    private final RemoteException w() {
        if (Build.VERSION.SDK_INT < 15) {
            return new RemoteException();
        }
        return new RemoteException(String.valueOf(this.d).concat(" : Binder has died."));
    }

    /* access modifiers changed from: private */
    public final void x() {
        for (TaskCompletionSource trySetException : this.f) {
            trySetException.trySetException(w());
        }
        this.f.clear();
    }

    public final Handler c() {
        Handler handler;
        Map map = a;
        synchronized (map) {
            if (!map.containsKey(this.d)) {
                HandlerThread handlerThread = new HandlerThread(this.d, 10);
                handlerThread.start();
                map.put(this.d, new Handler(handlerThread.getLooper()));
            }
            handler = (Handler) map.get(this.d);
        }
        return handler;
    }

    public final IInterface e() {
        return this.o;
    }

    public final void t(r rVar, TaskCompletionSource taskCompletionSource) {
        c().post(new u(this, rVar.c(), taskCompletionSource, rVar));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void u(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.g) {
            this.f.remove(taskCompletionSource);
        }
    }

    public final void v(TaskCompletionSource taskCompletionSource) {
        synchronized (this.g) {
            this.f.remove(taskCompletionSource);
        }
        c().post(new v(this));
    }

    static /* bridge */ /* synthetic */ void q(ac acVar, r rVar) {
        if (acVar.o == null && !acVar.h) {
            acVar.c.c("Initiate binding to the service.", new Object[0]);
            acVar.e.add(rVar);
            ab abVar = new ab(acVar, (aa) null);
            acVar.f28n = abVar;
            acVar.h = true;
            if (!acVar.b.bindService(acVar.i, abVar, 1)) {
                acVar.c.c("Failed to bind to the service.", new Object[0]);
                acVar.h = false;
                for (r a2 : acVar.e) {
                    a2.a(new ad());
                }
                acVar.e.clear();
            }
        } else if (acVar.h) {
            acVar.c.c("Waiting to bind to the service.", new Object[0]);
            acVar.e.add(rVar);
        } else {
            rVar.run();
        }
    }
}
