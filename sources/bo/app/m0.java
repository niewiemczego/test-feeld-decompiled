package bo.app;

import coil.disk.DiskLruCache;
import com.braze.support.BrazeLogger;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class m0 {
    static final Pattern o = Pattern.compile("[a-z0-9_-]{1,120}");
    private static final String p = BrazeLogger.getBrazeLogTag((Class<?>) m0.class);
    /* access modifiers changed from: private */
    public static final OutputStream q = new b();
    /* access modifiers changed from: private */
    public final File a;
    private final File b;
    private final File c;
    private final File d;
    private final int e;
    private long f;
    /* access modifiers changed from: private */
    public final int g;
    private long h = 0;
    /* access modifiers changed from: private */
    public Writer i;
    private final LinkedHashMap j = new LinkedHashMap(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int k;
    private long l = 0;
    final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: n  reason: collision with root package name */
    private final Callable f16n = new a();

    class a implements Callable {
        a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() {
            /*
                r4 = this;
                bo.app.m0 r0 = bo.app.m0.this
                monitor-enter(r0)
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.i     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0028 }
                r1.i()     // Catch:{ all -> 0x0028 }
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.e()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0028 }
                r1.h()     // Catch:{ all -> 0x0028 }
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.k = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.a.call():java.lang.Void");
        }
    }

    class b extends OutputStream {
        b() {
        }

        public void write(int i) {
        }
    }

    public final class c {
        /* access modifiers changed from: private */
        public final z0 a;
        /* access modifiers changed from: private */
        public final boolean[] b;
        /* access modifiers changed from: private */
        public boolean c;
        private boolean d;

        private class a extends FilterOutputStream {
            /* synthetic */ a(c cVar, OutputStream outputStream, a aVar) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = c.this.c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = c.this.c = true;
                }
            }

            public void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = c.this.c = true;
                }
            }

            private a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = c.this.c = true;
                }
            }
        }

        /* synthetic */ c(m0 m0Var, z0 z0Var, a aVar) {
            this(z0Var);
        }

        private c(z0 z0Var) {
            this.a = z0Var;
            this.b = z0Var.c ? null : new boolean[m0.this.g];
        }

        public void b() {
            if (this.c) {
                m0.this.a(this, false);
                m0.this.d(this.a.a);
            } else {
                m0.this.a(this, true);
            }
            this.d = true;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream a(int r5) {
            /*
                r4 = this;
                if (r5 < 0) goto L_0x004b
                bo.app.m0 r0 = bo.app.m0.this
                int r0 = r0.g
                if (r5 >= r0) goto L_0x004b
                bo.app.m0 r0 = bo.app.m0.this
                monitor-enter(r0)
                bo.app.z0 r1 = r4.a     // Catch:{ all -> 0x0048 }
                bo.app.m0$c r2 = r1.d     // Catch:{ all -> 0x0048 }
                if (r2 != r4) goto L_0x0042
                boolean r2 = r1.c     // Catch:{ all -> 0x0048 }
                if (r2 != 0) goto L_0x001c
                boolean[] r2 = r4.b     // Catch:{ all -> 0x0048 }
                r3 = 1
                r2[r5] = r3     // Catch:{ all -> 0x0048 }
            L_0x001c:
                java.io.File r5 = r1.b((int) r5)     // Catch:{ all -> 0x0048 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0026 }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0026 }
                goto L_0x0034
            L_0x0026:
                bo.app.m0 r1 = bo.app.m0.this     // Catch:{ all -> 0x0048 }
                java.io.File r1 = r1.a     // Catch:{ all -> 0x0048 }
                r1.mkdirs()     // Catch:{ all -> 0x0048 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003c }
                r1.<init>(r5)     // Catch:{ FileNotFoundException -> 0x003c }
            L_0x0034:
                bo.app.m0$c$a r5 = new bo.app.m0$c$a     // Catch:{ all -> 0x0048 }
                r2 = 0
                r5.<init>(r4, r1, r2)     // Catch:{ all -> 0x0048 }
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                return r5
            L_0x003c:
                java.io.OutputStream r5 = bo.app.m0.q     // Catch:{ all -> 0x0048 }
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                return r5
            L_0x0042:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0048 }
                r5.<init>()     // Catch:{ all -> 0x0048 }
                throw r5     // Catch:{ all -> 0x0048 }
            L_0x0048:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0048 }
                throw r5
            L_0x004b:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected index "
                java.lang.StringBuilder r1 = r1.append(r2)
                java.lang.StringBuilder r5 = r1.append(r5)
                java.lang.String r1 = " to be greater than 0 and less than the maximum value count of "
                java.lang.StringBuilder r5 = r5.append(r1)
                bo.app.m0 r1 = bo.app.m0.this
                int r1 = r1.g
                java.lang.StringBuilder r5 = r5.append(r1)
                java.lang.String r5 = r5.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.c.a(int):java.io.OutputStream");
        }

        public void a() {
            m0.this.a(this, false);
        }
    }

    public final class d implements Closeable {
        private final String a;
        private final long b;
        private final InputStream[] c;
        private final long[] d;

        /* synthetic */ d(m0 m0Var, String str, long j, InputStream[] inputStreamArr, long[] jArr, a aVar) {
            this(str, j, inputStreamArr, jArr);
        }

        public InputStream a(int i) {
            return this.c[i];
        }

        public void close() {
            for (InputStream a2 : this.c) {
                y6.a((Closeable) a2);
            }
        }

        private d(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.a = str;
            this.b = j;
            this.c = inputStreamArr;
            this.d = jArr;
        }
    }

    private m0(File file, int i2, int i3, long j2) {
        File file2 = file;
        this.a = file2;
        this.e = i2;
        this.b = new File(file2, DiskLruCache.JOURNAL_FILE);
        this.c = new File(file2, DiskLruCache.JOURNAL_FILE_TMP);
        this.d = new File(file2, DiskLruCache.JOURNAL_FILE_BACKUP);
        this.g = i3;
        this.f = j2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.k = r0 - r9.j.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.b() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.i = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.b, true), bo.app.y6.a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g() {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            bo.app.x5 r1 = new bo.app.x5
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.b
            r2.<init>(r3)
            java.nio.charset.Charset r3 = bo.app.y6.a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.c()     // Catch:{ all -> 0x00c3 }
            java.lang.String r3 = r1.c()     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = r1.c()     // Catch:{ all -> 0x00c3 }
            java.lang.String r5 = r1.c()     // Catch:{ all -> 0x00c3 }
            java.lang.String r6 = r1.c()     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00c3 }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.e     // Catch:{ all -> 0x00c3 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00c3 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.g     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00c3 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00c3 }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.c()     // Catch:{ EOFException -> 0x005f }
            r9.c((java.lang.String) r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap r2 = r9.j     // Catch:{ all -> 0x00c3 }
            int r2 = r2.size()     // Catch:{ all -> 0x00c3 }
            int r0 = r0 - r2
            r9.k = r0     // Catch:{ all -> 0x00c3 }
            boolean r0 = r1.b()     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x0072
            r9.h()     // Catch:{ all -> 0x00c3 }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00c3 }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00c3 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00c3 }
            java.io.File r4 = r9.b     // Catch:{ all -> 0x00c3 }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00c3 }
            java.nio.charset.Charset r4 = bo.app.y6.a     // Catch:{ all -> 0x00c3 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00c3 }
            r0.<init>(r2)     // Catch:{ all -> 0x00c3 }
            r9.i = r0     // Catch:{ all -> 0x00c3 }
        L_0x0088:
            bo.app.y6.a((java.io.Closeable) r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c3 }
            r7.<init>()     // Catch:{ all -> 0x00c3 }
            java.lang.String r8 = "unexpected journal header: ["
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r2 = r7.append(r2)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r2 = r2.append(r0)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x00c3 }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "]"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x00c3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c3 }
            r4.<init>(r0)     // Catch:{ all -> 0x00c3 }
            throw r4     // Catch:{ all -> 0x00c3 }
        L_0x00c3:
            r0 = move-exception
            bo.app.y6.a((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.g():void");
    }

    /* access modifiers changed from: private */
    public synchronized void h() {
        Writer writer = this.i;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), y6.a));
        try {
            bufferedWriter.write(DiskLruCache.MAGIC);
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.e));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (z0 z0Var : this.j.values()) {
                if (z0Var.d != null) {
                    bufferedWriter.write("DIRTY " + z0Var.a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + z0Var.a + z0Var.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.b.exists()) {
                a(this.b, this.d, true);
            }
            a(this.c, this.b, false);
            this.d.delete();
            this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), y6.a));
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return;
        throw th;
    }

    /* access modifiers changed from: private */
    public void i() {
        while (this.h > this.f) {
            d((String) ((Map.Entry) this.j.entrySet().iterator().next()).getKey());
        }
    }

    private void c(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i2);
            if (indexOf2 == -1) {
                str2 = str.substring(i2);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.j.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i2, indexOf2);
            }
            z0 z0Var = (z0) this.j.get(str2);
            if (z0Var == null) {
                z0Var = new z0(str2, this.g, this.a);
                this.j.put(str2, z0Var);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                z0Var.c = true;
                z0Var.d = null;
                z0Var.b(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                z0Var.d = new c(this, z0Var, (a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* access modifiers changed from: private */
    public boolean e() {
        int i2 = this.k;
        return i2 >= 2000 && i2 >= this.j.size();
    }

    private void f() {
        a(this.c);
        Iterator it = this.j.values().iterator();
        while (it.hasNext()) {
            z0 z0Var = (z0) it.next();
            int i2 = 0;
            if (z0Var.d == null) {
                while (i2 < this.g) {
                    this.h += z0Var.b[i2];
                    i2++;
                }
            } else {
                z0Var.d = null;
                while (i2 < this.g) {
                    a(z0Var.a(i2));
                    a(z0Var.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.k++;
        r11.i.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        if (e() == false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        r11.m.submit(r11.f16n);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0071, code lost:
        return new bo.app.m0.d(r11, r12, r0.e, r8, r0.b, (bo.app.m0.a) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0081, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0072 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized bo.app.m0.d b(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.b()     // Catch:{ all -> 0x0082 }
            r11.e((java.lang.String) r12)     // Catch:{ all -> 0x0082 }
            java.util.LinkedHashMap r0 = r11.j     // Catch:{ all -> 0x0082 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0082 }
            bo.app.z0 r0 = (bo.app.z0) r0     // Catch:{ all -> 0x0082 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.c     // Catch:{ all -> 0x0082 }
            if (r2 != 0) goto L_0x001a
            monitor-exit(r11)
            return r1
        L_0x001a:
            int r2 = r11.g     // Catch:{ all -> 0x0082 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0082 }
            r2 = 0
            r3 = r2
        L_0x0020:
            int r4 = r11.g     // Catch:{ FileNotFoundException -> 0x0072 }
            if (r3 >= r4) goto L_0x0032
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0072 }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x0072 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0072 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0072 }
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0032:
            int r1 = r11.k     // Catch:{ all -> 0x0082 }
            int r1 = r1 + 1
            r11.k = r1     // Catch:{ all -> 0x0082 }
            java.io.Writer r1 = r11.i     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0082 }
            r2.<init>()     // Catch:{ all -> 0x0082 }
            java.lang.String r3 = "READ "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.StringBuilder r2 = r2.append(r12)     // Catch:{ all -> 0x0082 }
            r3 = 10
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0082 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0082 }
            r1.append(r2)     // Catch:{ all -> 0x0082 }
            boolean r1 = r11.e()     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0063
            java.util.concurrent.ThreadPoolExecutor r1 = r11.m     // Catch:{ all -> 0x0082 }
            java.util.concurrent.Callable r2 = r11.f16n     // Catch:{ all -> 0x0082 }
            r1.submit(r2)     // Catch:{ all -> 0x0082 }
        L_0x0063:
            bo.app.m0$d r1 = new bo.app.m0$d     // Catch:{ all -> 0x0082 }
            long r6 = r0.e     // Catch:{ all -> 0x0082 }
            long[] r9 = r0.b     // Catch:{ all -> 0x0082 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x0082 }
            monitor-exit(r11)
            return r1
        L_0x0072:
            int r12 = r11.g     // Catch:{ all -> 0x0082 }
            if (r2 >= r12) goto L_0x0080
            r12 = r8[r2]     // Catch:{ all -> 0x0082 }
            if (r12 == 0) goto L_0x0080
            bo.app.y6.a((java.io.Closeable) r12)     // Catch:{ all -> 0x0082 }
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0080:
            monitor-exit(r11)
            return r1
        L_0x0082:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.b(java.lang.String):bo.app.m0$d");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean d(java.lang.String r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.b()     // Catch:{ all -> 0x0090 }
            r7.e((java.lang.String) r8)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap r0 = r7.j     // Catch:{ all -> 0x0090 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0090 }
            bo.app.z0 r0 = (bo.app.z0) r0     // Catch:{ all -> 0x0090 }
            r1 = 0
            if (r0 == 0) goto L_0x008e
            bo.app.m0$c r2 = r0.d     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0018
            goto L_0x008e
        L_0x0018:
            int r2 = r7.g     // Catch:{ all -> 0x0090 }
            if (r1 >= r2) goto L_0x0056
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0090 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0090 }
            if (r3 == 0) goto L_0x002d
            goto L_0x0046
        L_0x002d:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r0.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = "failed to delete "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0090 }
            r8.<init>(r0)     // Catch:{ all -> 0x0090 }
            throw r8     // Catch:{ all -> 0x0090 }
        L_0x0046:
            long r2 = r7.h     // Catch:{ all -> 0x0090 }
            long[] r4 = r0.b     // Catch:{ all -> 0x0090 }
            r5 = r4[r1]     // Catch:{ all -> 0x0090 }
            long r2 = r2 - r5
            r7.h = r2     // Catch:{ all -> 0x0090 }
            r2 = 0
            r4[r1] = r2     // Catch:{ all -> 0x0090 }
            int r1 = r1 + 1
            goto L_0x0018
        L_0x0056:
            int r0 = r7.k     // Catch:{ all -> 0x0090 }
            r1 = 1
            int r0 = r0 + r1
            r7.k = r0     // Catch:{ all -> 0x0090 }
            java.io.Writer r0 = r7.i     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "REMOVE "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r2 = r2.append(r8)     // Catch:{ all -> 0x0090 }
            r3 = 10
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0090 }
            r0.append(r2)     // Catch:{ all -> 0x0090 }
            java.util.LinkedHashMap r0 = r7.j     // Catch:{ all -> 0x0090 }
            r0.remove(r8)     // Catch:{ all -> 0x0090 }
            boolean r8 = r7.e()     // Catch:{ all -> 0x0090 }
            if (r8 == 0) goto L_0x008c
            java.util.concurrent.ThreadPoolExecutor r8 = r7.m     // Catch:{ all -> 0x0090 }
            java.util.concurrent.Callable r0 = r7.f16n     // Catch:{ all -> 0x0090 }
            r8.submit(r0)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            monitor-exit(r7)
            return r1
        L_0x008e:
            monitor-exit(r7)
            return r1
        L_0x0090:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.d(java.lang.String):boolean");
    }

    private void e(String str) {
        if (!o.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public static m0 a(File file, int i2, int i3, long j2) {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i3 > 0) {
            File file2 = new File(file, DiskLruCache.JOURNAL_FILE_BACKUP);
            if (file2.exists()) {
                File file3 = new File(file, DiskLruCache.JOURNAL_FILE);
                if (file3.exists()) {
                    file2.delete();
                } else {
                    a(file2, file3, false);
                }
            }
            m0 m0Var = new m0(file, i2, i3, j2);
            if (m0Var.b.exists()) {
                try {
                    m0Var.g();
                    m0Var.f();
                    return m0Var;
                } catch (IOException e2) {
                    BrazeLogger.w(p, "DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                    m0Var.d();
                }
            }
            file.mkdirs();
            m0 m0Var2 = new m0(file, i2, i3, j2);
            m0Var2.h();
            return m0Var2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public void d() {
        c();
        y6.a(this.a);
    }

    private static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized void c() {
        if (this.i != null) {
            Iterator it = new ArrayList(this.j.values()).iterator();
            while (it.hasNext()) {
                c cVar = ((z0) it.next()).d;
                if (cVar != null) {
                    cVar.a();
                }
            }
            i();
            this.i.close();
            this.i = null;
        }
    }

    public c a(String str) {
        return a(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized bo.app.m0.c a(java.lang.String r6, long r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.b()     // Catch:{ all -> 0x0063 }
            r5.e((java.lang.String) r6)     // Catch:{ all -> 0x0063 }
            java.util.LinkedHashMap r0 = r5.j     // Catch:{ all -> 0x0063 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0063 }
            bo.app.z0 r0 = (bo.app.z0) r0     // Catch:{ all -> 0x0063 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0020
            if (r0 == 0) goto L_0x001e
            long r3 = r0.e     // Catch:{ all -> 0x0063 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0020
        L_0x001e:
            monitor-exit(r5)
            return r2
        L_0x0020:
            if (r0 != 0) goto L_0x0031
            bo.app.z0 r0 = new bo.app.z0     // Catch:{ all -> 0x0063 }
            int r7 = r5.g     // Catch:{ all -> 0x0063 }
            java.io.File r8 = r5.a     // Catch:{ all -> 0x0063 }
            r0.<init>(r6, r7, r8)     // Catch:{ all -> 0x0063 }
            java.util.LinkedHashMap r7 = r5.j     // Catch:{ all -> 0x0063 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0063 }
            goto L_0x0037
        L_0x0031:
            bo.app.m0$c r7 = r0.d     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            bo.app.m0$c r7 = new bo.app.m0$c     // Catch:{ all -> 0x0063 }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x0063 }
            r0.d = r7     // Catch:{ all -> 0x0063 }
            java.io.Writer r8 = r5.i     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r0.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "DIRTY "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r6 = r0.append(r6)     // Catch:{ all -> 0x0063 }
            r0 = 10
            java.lang.StringBuilder r6 = r6.append(r0)     // Catch:{ all -> 0x0063 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0063 }
            r8.write(r6)     // Catch:{ all -> 0x0063 }
            java.io.Writer r6 = r5.i     // Catch:{ all -> 0x0063 }
            r6.flush()     // Catch:{ all -> 0x0063 }
            monitor-exit(r5)
            return r7
        L_0x0063:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.a(java.lang.String, long):bo.app.m0$c");
    }

    private void b() {
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ff, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(bo.app.m0.c r10, boolean r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            bo.app.z0 r0 = r10.a     // Catch:{ all -> 0x0106 }
            bo.app.m0$c r1 = r0.d     // Catch:{ all -> 0x0106 }
            if (r1 != r10) goto L_0x0100
            r1 = 0
            if (r11 == 0) goto L_0x004b
            boolean r2 = r0.c     // Catch:{ all -> 0x0106 }
            if (r2 != 0) goto L_0x004b
            r2 = r1
        L_0x0011:
            int r3 = r9.g     // Catch:{ all -> 0x0106 }
            if (r2 >= r3) goto L_0x004b
            boolean[] r3 = r10.b     // Catch:{ all -> 0x0106 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0106 }
            if (r3 == 0) goto L_0x002f
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x0106 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0106 }
            if (r3 != 0) goto L_0x002c
            r10.a()     // Catch:{ all -> 0x0106 }
            monitor-exit(r9)
            return
        L_0x002c:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x002f:
            r10.a()     // Catch:{ all -> 0x0106 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r11.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0106 }
            r10.<init>(r11)     // Catch:{ all -> 0x0106 }
            throw r10     // Catch:{ all -> 0x0106 }
        L_0x004b:
            int r10 = r9.g     // Catch:{ all -> 0x0106 }
            if (r1 >= r10) goto L_0x007b
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x0106 }
            if (r11 == 0) goto L_0x0075
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0106 }
            if (r2 == 0) goto L_0x0078
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0106 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0106 }
            long[] r10 = r0.b     // Catch:{ all -> 0x0106 }
            r3 = r10[r1]     // Catch:{ all -> 0x0106 }
            long r5 = r2.length()     // Catch:{ all -> 0x0106 }
            long[] r10 = r0.b     // Catch:{ all -> 0x0106 }
            r10[r1] = r5     // Catch:{ all -> 0x0106 }
            long r7 = r9.h     // Catch:{ all -> 0x0106 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.h = r7     // Catch:{ all -> 0x0106 }
            goto L_0x0078
        L_0x0075:
            a((java.io.File) r10)     // Catch:{ all -> 0x0106 }
        L_0x0078:
            int r1 = r1 + 1
            goto L_0x004b
        L_0x007b:
            int r10 = r9.k     // Catch:{ all -> 0x0106 }
            r1 = 1
            int r10 = r10 + r1
            r9.k = r10     // Catch:{ all -> 0x0106 }
            r10 = 0
            r0.d = r10     // Catch:{ all -> 0x0106 }
            boolean r10 = r0.c     // Catch:{ all -> 0x0106 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00bf
            r0.c = r1     // Catch:{ all -> 0x0106 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r1.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "CLEAN "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r0.a     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0106 }
            r10.write(r1)     // Catch:{ all -> 0x0106 }
            if (r11 == 0) goto L_0x00e4
            long r10 = r9.l     // Catch:{ all -> 0x0106 }
            r1 = 1
            long r1 = r1 + r10
            r9.l = r1     // Catch:{ all -> 0x0106 }
            r0.e = r10     // Catch:{ all -> 0x0106 }
            goto L_0x00e4
        L_0x00bf:
            java.util.LinkedHashMap r10 = r9.j     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = r0.a     // Catch:{ all -> 0x0106 }
            r10.remove(r11)     // Catch:{ all -> 0x0106 }
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r11.<init>()     // Catch:{ all -> 0x0106 }
            java.lang.String r1 = "REMOVE "
            java.lang.StringBuilder r11 = r11.append(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = r0.a     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r11 = r11.append(r0)     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ all -> 0x0106 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0106 }
            r10.write(r11)     // Catch:{ all -> 0x0106 }
        L_0x00e4:
            java.io.Writer r10 = r9.i     // Catch:{ all -> 0x0106 }
            r10.flush()     // Catch:{ all -> 0x0106 }
            long r10 = r9.h     // Catch:{ all -> 0x0106 }
            long r0 = r9.f     // Catch:{ all -> 0x0106 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00f7
            boolean r10 = r9.e()     // Catch:{ all -> 0x0106 }
            if (r10 == 0) goto L_0x00fe
        L_0x00f7:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.m     // Catch:{ all -> 0x0106 }
            java.util.concurrent.Callable r11 = r9.f16n     // Catch:{ all -> 0x0106 }
            r10.submit(r11)     // Catch:{ all -> 0x0106 }
        L_0x00fe:
            monitor-exit(r9)
            return
        L_0x0100:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0106 }
            r10.<init>()     // Catch:{ all -> 0x0106 }
            throw r10     // Catch:{ all -> 0x0106 }
        L_0x0106:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.m0.a(bo.app.m0$c, boolean):void");
    }
}
