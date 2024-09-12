package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class o1 implements b2 {

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot create card control event for Feed card. Returning null. Card id: " + this.b;
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
            return "Cannot create card dismissed event for Feed card. Returning null. Card id: " + this.b;
        }
    }

    public x1 a(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(str), 2, (Object) null);
        return null;
    }

    public x1 b(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        return j.h.e(str);
    }

    public x1 c(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(str), 2, (Object) null);
        return null;
    }

    public x1 d(String str) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        return j.h.f(str);
    }
}
