package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

public final class g3 implements ReadWriteProperty {
    private Object a;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ Object b;
        final /* synthetic */ KProperty c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Object obj, KProperty kProperty) {
            super(0);
            this.b = obj;
            this.c = kProperty;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot assign " + this.b + " to only-set-once property " + this.c.getName();
        }
    }

    public Object getValue(Object obj, KProperty kProperty) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return this.a;
    }

    public void setValue(Object obj, KProperty kProperty, Object obj2) {
        Intrinsics.checkNotNullParameter(obj, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        Object obj3 = this.a;
        if (obj3 == null) {
            this.a = obj2;
        } else if (!Intrinsics.areEqual(obj3, obj2)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(obj2, kProperty), 3, (Object) null);
        }
    }
}
