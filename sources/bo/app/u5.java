package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.StringUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

public final class u5 implements y1 {
    public static final a c = new a((DefaultConstructorMarker) null);
    private boolean a;
    private final SharedPreferences b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not adding event: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding event to storage with uid " + this.b.t();
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not getting all events.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Ref.ObjectRef objectRef, String str) {
            super(0);
            this.b = objectRef;
            this.c = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not create BrazeEvent from [serialized event string=" + ((String) this.b.element) + ", unique identifier=" + this.c + "] ... Deleting!";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Setting this provider to closed.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Set b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Set set) {
            super(0);
            this.b = set;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage provider is closed. Not deleting events: " + this.b;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting event from storage with uid " + this.b;
        }
    }

    public u5(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = context.getSharedPreferences("com.appboy.storage.appboy_event_storage" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
    }

    public Collection a() {
        if (this.a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) d.b, 2, (Object) null);
            return CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Map<String, ?> all = this.b.getAll();
        Intrinsics.checkNotNullExpressionValue(all, "prefs.all");
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            T value = next.getValue();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.String");
                objectRef.element = (String) value;
                Intrinsics.checkNotNullExpressionValue(str, "eventId");
                x1 b2 = j.h.b((String) value, str);
                if (b2 != null) {
                    linkedHashSet.add(b2);
                }
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new e(objectRef, str));
                a(str);
            }
        }
        return linkedHashSet;
    }

    public void close() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) f.b, 2, (Object) null);
        this.a = true;
    }

    public void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (this.a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(x1Var), 2, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(x1Var), 3, (Object) null);
        this.b.edit().putString(x1Var.t(), x1Var.f()).apply();
    }

    public void a(Set set) {
        Intrinsics.checkNotNullParameter(set, "events");
        if (this.a) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new g(set), 2, (Object) null);
            return;
        }
        SharedPreferences.Editor edit = this.b.edit();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String t = ((x1) it.next()).t();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(t), 3, (Object) null);
            edit.remove(t);
        }
        edit.apply();
    }

    public final void a(String str) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.remove(str);
        edit.apply();
    }
}
