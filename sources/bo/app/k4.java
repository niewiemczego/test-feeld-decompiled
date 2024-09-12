package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class k4 {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final ReentrantLock a;
    private final List b;
    private final SharedPreferences c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding push campaign to storage with uid " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ j4 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(j4 j4Var) {
            super(0);
            this.b = j4Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Clearing PDE from storage with uid " + this.b.x();
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(List list) {
            super(0);
            this.b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Re-adding PDEs to storage: " + this.b;
        }
    }

    public k4(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.storage.braze_push_delivery_storage" + StringUtils.getCacheFileSuffix(context, (String) null, str), 0);
        this.c = sharedPreferences;
        reentrantLock.lock();
        try {
            arrayList.clear();
            Map<String, ?> all = sharedPreferences.getAll();
            Intrinsics.checkNotNullExpressionValue(all, "pdePrefs.all");
            for (Map.Entry<String, ?> key : all.entrySet()) {
                String str2 = (String) key.getKey();
                List list = this.b;
                Intrinsics.checkNotNullExpressionValue(str2, "campaignId");
                list.add(new j4(str2, this.c.getLong(str2, 0)));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final List a() {
        ArrayList arrayList = new ArrayList();
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                j4 j4Var = (j4) it.next();
                if (arrayList.size() >= 32) {
                    break;
                }
                arrayList.add(j4Var);
            }
            this.b.removeAll(arrayList);
            return arrayList;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(List list) {
        Intrinsics.checkNotNullParameter(list, "events");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(list), 3, (Object) null);
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            this.b.addAll(list);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "pushCampaignId");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(str), 3, (Object) null);
            long nowInSeconds = DateTimeUtils.nowInSeconds();
            this.c.edit().putLong(str, nowInSeconds).apply();
            this.b.add(new j4(str, nowInSeconds));
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(List list) {
        Intrinsics.checkNotNullParameter(list, "events");
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            SharedPreferences.Editor edit = this.c.edit();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                j4 j4Var = (j4) it.next();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(j4Var), 3, (Object) null);
                edit.remove(j4Var.x());
            }
            edit.apply();
            this.b.removeAll(list);
        } finally {
            reentrantLock.unlock();
        }
    }
}
