package bo.app;

import bo.app.m0;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class z0 {
    final String a;
    final long[] b;
    boolean c;
    m0.c d;
    long e;
    private final int f;
    private final File g;

    z0(String str, int i, File file) {
        this.a = str;
        this.f = i;
        this.g = file;
        this.b = new long[i];
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        for (long append : this.b) {
            sb.append(' ').append(append);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public void b(String[] strArr) {
        if (strArr.length == this.f) {
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.b[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
            return;
        }
        throw a(strArr);
    }

    /* access modifiers changed from: package-private */
    public IOException a(String[] strArr) {
        throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
    }

    public File a(int i) {
        return new File(this.g, this.a + "." + i);
    }

    public File b(int i) {
        return new File(this.g, this.a + "." + i + DefaultDiskStorage.FileType.TEMP);
    }
}
