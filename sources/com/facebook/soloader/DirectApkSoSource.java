package com.facebook.soloader;

import android.content.Context;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.soloader.SysUtil;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DirectApkSoSource extends SoSource {
    private final File mApkFile;
    private final Set<String> mDirectApkLdPaths;
    private final Map<String, Set<String>> mLibsInApkMap;

    public DirectApkSoSource(Context context) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths("");
        this.mApkFile = new File(context.getApplicationInfo().sourceDir);
    }

    public DirectApkSoSource(File file) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths(SysUtil.getBaseName(file.getName()));
        this.mApkFile = file;
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader != null) {
            for (String next : this.mDirectApkLdPaths) {
                Set set = this.mLibsInApkMap.get(next);
                if (TextUtils.isEmpty(next) || set == null || !set.contains(str)) {
                    Log.v("SoLoader", str + " not found on " + next);
                } else {
                    loadDependencies(str, i, threadPolicy);
                    try {
                        i |= 4;
                        SoLoader.sSoFileLoader.load(next + File.separator + str, i);
                        Log.d("SoLoader", str + " found on " + next);
                        return 1;
                    } catch (UnsatisfiedLinkError e) {
                        Log.w("SoLoader", str + " not found on " + next + " flag: " + i, e);
                    }
                }
            }
            return 0;
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    public File unpackLibrary(String str) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    static Set<String> getDirectApkLdPaths(String str) {
        HashSet hashSet = new HashSet();
        String classLoaderLdLoadLibrary = Build.VERSION.SDK_INT >= 14 ? SysUtil.Api14Utils.getClassLoaderLdLoadLibrary() : null;
        if (classLoaderLdLoadLibrary != null) {
            for (String str2 : classLoaderLdLoadLibrary.split(CertificateUtil.DELIMITER)) {
                if (str2.contains(str + ".apk!/")) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    private static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            return NativeDeps.getDependencies(str, elfByteChannel);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = getDependencies(r8, r2);
        r3 = r8.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        if (r4 >= r3) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (contains(r5) != false) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
        if (r5.startsWith("/") == false) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r9 | 1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r2 = new com.facebook.soloader.ElfZipFileChannel(r1, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadDependencies(java.lang.String r8, int r9, android.os.StrictMode.ThreadPolicy r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "/"
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            java.io.File r2 = r7.mApkFile
            r1.<init>(r2)
            java.util.Enumeration r2 = r1.entries()     // Catch:{ all -> 0x006c }
        L_0x000d:
            boolean r3 = r2.hasMoreElements()     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0068
            java.lang.Object r3 = r2.nextElement()     // Catch:{ all -> 0x006c }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x000d
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r5.<init>()     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r5 = r5.append(r0)     // Catch:{ all -> 0x006c }
            java.lang.StringBuilder r5 = r5.append(r8)     // Catch:{ all -> 0x006c }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006c }
            boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x006c }
            if (r4 == 0) goto L_0x000d
            com.facebook.soloader.ElfZipFileChannel r2 = new com.facebook.soloader.ElfZipFileChannel     // Catch:{ all -> 0x006c }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x006c }
            java.lang.String[] r8 = getDependencies(r8, r2)     // Catch:{ all -> 0x005e }
            int r3 = r8.length     // Catch:{ all -> 0x005e }
            r4 = 0
        L_0x0041:
            if (r4 >= r3) goto L_0x005a
            r5 = r8[r4]     // Catch:{ all -> 0x005e }
            boolean r6 = r7.contains(r5)     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0057
            boolean r6 = r5.startsWith(r0)     // Catch:{ all -> 0x005e }
            if (r6 == 0) goto L_0x0052
            goto L_0x0057
        L_0x0052:
            r6 = r9 | 1
            com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r6, r10)     // Catch:{ all -> 0x005e }
        L_0x0057:
            int r4 = r4 + 1
            goto L_0x0041
        L_0x005a:
            r2.close()     // Catch:{ all -> 0x006c }
            goto L_0x0068
        L_0x005e:
            r8 = move-exception
            r2.close()     // Catch:{ all -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r9 = move-exception
            r8.addSuppressed(r9)     // Catch:{ all -> 0x006c }
        L_0x0067:
            throw r8     // Catch:{ all -> 0x006c }
        L_0x0068:
            r1.close()
            return
        L_0x006c:
            r8 = move-exception
            r1.close()     // Catch:{ all -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r9 = move-exception
            r8.addSuppressed(r9)
        L_0x0075:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.DirectApkSoSource.loadDependencies(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        int indexOf;
        int i2;
        String str = null;
        for (String next : this.mDirectApkLdPaths) {
            if (!TextUtils.isEmpty(next) && (indexOf = next.indexOf(33)) >= 0 && (i2 = indexOf + 2) < next.length()) {
                str = next.substring(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                ZipFile zipFile = new ZipFile(this.mApkFile);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry != null && zipEntry.getName().startsWith(str) && zipEntry.getName().endsWith(".so") && zipEntry.getMethod() == 0) {
                            append(next, zipEntry.getName().substring(str.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        return;
        throw th;
    }

    public String toString() {
        return getClass().getName() + "[root = " + LdPathsToString() + ']';
    }

    private synchronized boolean contains(String str) {
        for (Set<String> contains : this.mLibsInApkMap.values()) {
            if (contains.contains(str)) {
                return true;
            }
        }
        return false;
    }

    private synchronized void append(String str, String str2) {
        if (!this.mLibsInApkMap.containsKey(str)) {
            this.mLibsInApkMap.put(str, new HashSet());
        }
        this.mLibsInApkMap.get(str).add(str2);
    }

    private String LdPathsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (String append : this.mDirectApkLdPaths) {
            sb.append(append).append(", ");
        }
        sb.append(')');
        return sb.toString();
    }
}
