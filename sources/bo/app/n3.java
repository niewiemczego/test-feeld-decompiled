package bo.app;

import com.braze.support.DateTimeUtils;
import kotlin.jvm.internal.Intrinsics;

public final class n3 extends n5 {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n3(bo.app.p5 r4, double r5, java.lang.Double r7, boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            bo.app.p5$a r4 = bo.app.p5.d
            bo.app.p5 r4 = r4.a()
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0012
            double r5 = com.braze.support.DateTimeUtils.nowInSecondsPrecise()
        L_0x0012:
            r0 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0018
            r7 = 0
        L_0x0018:
            r10 = r7
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001e
            r8 = 0
        L_0x001e:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r0
            r9 = r10
            r10 = r2
            r5.<init>(r6, r7, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n3.<init>(bo.app.p5, double, java.lang.Double, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void A() {
        a(true);
        a(Double.valueOf(DateTimeUtils.nowInSecondsPrecise()));
    }

    public void a(Double d) {
        super.a(d);
    }

    public String toString() {
        return "\nMutableSession(sessionId=" + s() + ", startTime=" + x() + ", endTime=" + w() + ", isSealed=" + y() + ", duration=" + v() + ')';
    }

    public Double w() {
        return super.w();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n3(p5 p5Var, double d, Double d2, boolean z) {
        super(p5Var, d, d2, z);
        Intrinsics.checkNotNullParameter(p5Var, "sessionId");
    }
}
