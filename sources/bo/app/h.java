package bo.app;

import bo.app.m0;
import com.braze.support.BrazeLogger;
import java.io.File;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.apache.commons.io.IOUtils;

public final class h {
    private final m0 a;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error while retrieving disk for key " + this.b + " diskKey " + this.c;
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get bitmap from disk cache for key " + this.b + " diskKey " + this.c;
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to load image from disk cache: " + this.b + IOUtils.DIR_SEPARATOR_UNIX + this.c;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error while producing output stream or compressing bitmap for key " + this.b + " diskKey " + this.c;
        }
    }

    public h(File file, int i, int i2, long j) {
        m0 a2 = m0.a(file, i, i2, j);
        Intrinsics.checkNotNullExpressionValue(a2, "open(directory, appVersion, valueCount, maxSize)");
        this.a = a2;
    }

    private final String c(String str) {
        return String.valueOf(str.hashCode());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7, android.graphics.Bitmap r8) {
        /*
            r6 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "bitmap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = r6.c(r7)
            bo.app.m0 r1 = r6.a     // Catch:{ all -> 0x0034 }
            bo.app.m0$c r1 = r1.a((java.lang.String) r0)     // Catch:{ all -> 0x0034 }
            r2 = 0
            java.io.OutputStream r2 = r1.a((int) r2)     // Catch:{ all -> 0x0034 }
            r3 = 0
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ all -> 0x002d }
            r5 = 100
            r8.compress(r4, r5, r2)     // Catch:{ all -> 0x002d }
            r2.flush()     // Catch:{ all -> 0x002d }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x0034 }
            r1.b()     // Catch:{ all -> 0x0034 }
            goto L_0x0041
        L_0x002d:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r8)     // Catch:{ all -> 0x0034 }
            throw r1     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r8 = move-exception
            com.braze.support.BrazeLogger r1 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r2 = com.braze.support.BrazeLogger.Priority.E
            bo.app.h$d r3 = new bo.app.h$d
            r3.<init>(r7, r0)
            r1.brazelog((java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0<java.lang.String>) r3)
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.h.a(java.lang.String, android.graphics.Bitmap):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap b(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = r10.c(r11)
            r1 = 0
            bo.app.m0 r2 = r10.a     // Catch:{ all -> 0x0024 }
            bo.app.m0$d r2 = r2.b((java.lang.String) r0)     // Catch:{ all -> 0x0024 }
            r3 = 0
            java.io.InputStream r3 = r2.a(r3)     // Catch:{ all -> 0x001d }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ all -> 0x001d }
            kotlin.io.CloseableKt.closeFinally(r2, r1)     // Catch:{ all -> 0x0024 }
            return r3
        L_0x001d:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001f }
        L_0x001f:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)     // Catch:{ all -> 0x0024 }
            throw r4     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r2 = move-exception
            com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.h$b r5 = new bo.app.h$b
            r5.<init>(r11, r0)
            r3.brazelog((java.lang.Object) r10, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r2, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
            bo.app.h$c r7 = new bo.app.h$c
            r7.<init>(r11, r0)
            r5 = 0
            r6 = 0
            r8 = 3
            r9 = 0
            r4 = r10
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.Object) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.h.b(java.lang.String):android.graphics.Bitmap");
    }

    public final boolean a(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        String c2 = c(str);
        try {
            m0.d b2 = this.a.b(c2);
            boolean z = b2 != null;
            CloseableKt.closeFinally(b2, (Throwable) null);
            return z;
        } catch (Throwable th) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, th, (Function0<String>) new a(str, c2));
            return false;
        }
    }
}
