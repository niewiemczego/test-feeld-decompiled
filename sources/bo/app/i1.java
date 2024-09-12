package bo.app;

import android.os.SystemClock;
import com.braze.support.BrazeLogger;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import kotlin.random.RandomKt;

public final class i1 implements w1 {
    public static final a g = new a((DefaultConstructorMarker) null);
    private static final int h = ((int) TimeUnit.SECONDS.toMillis(45));
    /* access modifiers changed from: private */
    public final int a;
    private final int b;
    /* access modifiers changed from: private */
    public final int c;
    /* access modifiers changed from: private */
    public final int d;
    private final Random e;
    /* access modifiers changed from: private */
    public int f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(Random random, int i, int i2) {
            Intrinsics.checkNotNullParameter(random, "random");
            return random.nextInt(Math.abs(i - i2) + 1) + Math.min(i, i2);
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ i1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i1 i1Var) {
            super(0);
            this.b = i1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Computing new sleep delay. Previous sleep delay: " + this.b.f;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ i1 b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(i1 i1Var, int i, int i2) {
            super(0);
            this.b = i1Var;
            this.c = i;
            this.d = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "New sleep duration: " + this.b.f + " ms. Default sleep duration: " + this.c + " ms. Max sleep: " + this.b.a + " ms. Min sleep: " + this.b.c + " ms. Scale factor: " + this.b.d + " randomValueBetweenSleepIntervals: " + this.d;
        }
    }

    public i1(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = RandomKt.Random(SystemClock.uptimeMillis());
    }

    public int a() {
        return a(this.b);
    }

    public void b() {
        this.f = 0;
    }

    public boolean c() {
        return this.f != 0;
    }

    public int a(int i) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(this), 3, (Object) null);
        int a2 = g.a(this.e, i, this.f * this.d);
        this.f = Math.max(this.c, Math.min(this.a, a2));
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(this, i, a2), 3, (Object) null);
        return this.f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i1(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i5 & 2) != 0 ? h : i2, (i5 & 4) != 0 ? l5.e.b() : i3, (i5 & 8) != 0 ? 3 : i4);
    }
}
