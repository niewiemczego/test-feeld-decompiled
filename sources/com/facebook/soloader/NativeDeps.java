package com.facebook.soloader;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;

public final class NativeDeps {
    private static final float HASHMAP_LOAD_FACTOR = 1.0f;
    private static final int INITIAL_HASH = 5381;
    private static final int LIB_PREFIX_LEN = 3;
    private static final int LIB_PREFIX_SUFFIX_LEN = (3 + 3);
    private static final int LIB_SUFFIX_LEN = 3;
    private static final String LOG_TAG = "NativeDeps";
    private static final int WAITING_THREADS_WARNING_THRESHOLD = 3;
    @Nullable
    private static byte[] sEncodedDeps = null;
    private static volatile boolean sInitialized = false;
    private static Map<Integer, List<Integer>> sPrecomputedDeps = null;
    private static List<Integer> sPrecomputedLibs = null;
    /* access modifiers changed from: private */
    public static volatile boolean sUseDepsFileAsync = false;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sWaitForDepsFileLock = new ReentrantReadWriteLock();

    public static String[] getDependencies(String str, File file) throws IOException {
        String[] awaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
        if (awaitGetDepsFromPrecomputedDeps != null) {
            return awaitGetDepsFromPrecomputedDeps;
        }
        return MinElf.extract_DT_NEEDED(file);
    }

    public static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        String[] awaitGetDepsFromPrecomputedDeps = awaitGetDepsFromPrecomputedDeps(str);
        if (awaitGetDepsFromPrecomputedDeps != null) {
            return awaitGetDepsFromPrecomputedDeps;
        }
        return MinElf.extract_DT_NEEDED(elfByteChannel);
    }

    @Nullable
    private static String[] awaitGetDepsFromPrecomputedDeps(String str) {
        if (sInitialized) {
            return tryGetDepsFromPrecomputedDeps(str);
        }
        if (!sUseDepsFileAsync) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sWaitForDepsFileLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            String[] tryGetDepsFromPrecomputedDeps = tryGetDepsFromPrecomputedDeps(str);
            reentrantReadWriteLock.readLock().unlock();
            return tryGetDepsFromPrecomputedDeps;
        } catch (Throwable th) {
            sWaitForDepsFileLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean useDepsFile(final Context context, boolean z, final boolean z2) {
        if (!z) {
            return useDepsFileFromApkSync(context, z2);
        }
        new Thread(new Runnable() {
            public void run() {
                NativeDeps.sWaitForDepsFileLock.writeLock().lock();
                boolean unused = NativeDeps.sUseDepsFileAsync = true;
                try {
                    boolean unused2 = NativeDeps.useDepsFileFromApkSync(context, z2);
                } finally {
                    int readLockCount = NativeDeps.sWaitForDepsFileLock.getReadLockCount();
                    if (readLockCount >= 3) {
                        Log.w(NativeDeps.LOG_TAG, "NativeDeps initialization finished with " + Integer.toString(readLockCount) + " threads waiting.");
                    }
                    NativeDeps.sWaitForDepsFileLock.writeLock().unlock();
                    boolean unused3 = NativeDeps.sUseDepsFileAsync = false;
                }
            }
        }, "soloader-nativedeps-init").start();
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean useDepsFileFromApkSync(Context context, boolean z) {
        boolean z2;
        try {
            z2 = initDeps(context, z);
        } catch (IOException unused) {
            z2 = false;
        }
        if (!z2 && z) {
            try {
                NativeDepsUnpacker.ensureNativeDepsAvailable(context);
                z2 = initDeps(context, z);
            } catch (IOException unused2) {
            }
        }
        if (!z2) {
            Log.w(LOG_TAG, "Failed to extract native deps from APK, falling back to using MinElf to get library dependencies.");
        }
        return z2;
    }

    private static boolean initDeps(Context context, boolean z) throws IOException {
        byte[] bArr;
        byte[] bArr2;
        verifyUninitialized();
        if (z) {
            bArr = SysUtil.makeApkDepBlock(new File(context.getApplicationInfo().sourceDir), context);
            bArr2 = NativeDepsUnpacker.readNativeDepsFromDisk(context);
        } else {
            bArr2 = NativeDepsUnpacker.readNativeDepsFromApk(context);
            bArr = null;
        }
        return processDepsBytes(bArr, bArr2);
    }

    private static void indexLib(int i, int i2) {
        sPrecomputedLibs.add(Integer.valueOf(i2));
        List list = sPrecomputedDeps.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            sPrecomputedDeps.put(Integer.valueOf(i), list);
        }
        list.add(Integer.valueOf(i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void indexDepsBytes(byte[] r8, int r9) {
        /*
            r0 = 0
            r1 = 1
            r3 = r0
            r4 = r3
            r2 = r1
        L_0x0005:
            if (r2 == 0) goto L_0x0021
            r3 = 5381(0x1505, float:7.54E-42)
            r4 = r9
        L_0x000a:
            byte r5 = r8[r4]     // Catch:{ IndexOutOfBoundsException -> 0x0034 }
            r6 = 32
            if (r5 <= r6) goto L_0x0018
            int r6 = r3 << 5
            int r6 = r6 + r3
            int r3 = r6 + r5
            int r4 = r4 + 1
            goto L_0x000a
        L_0x0018:
            indexLib(r3, r9)     // Catch:{ IndexOutOfBoundsException -> 0x0034 }
            if (r5 == r6) goto L_0x001f
            r2 = r1
            goto L_0x002e
        L_0x001f:
            r2 = r0
            goto L_0x002e
        L_0x0021:
            byte r5 = r8[r9]     // Catch:{ IndexOutOfBoundsException -> 0x0033 }
            r6 = 10
            if (r5 == r6) goto L_0x002a
            int r9 = r9 + 1
            goto L_0x0021
        L_0x002a:
            r2 = r1
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x002e:
            int r4 = r4 + r1
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x0005
        L_0x0033:
            r9 = r4
        L_0x0034:
            if (r2 == 0) goto L_0x003c
            int r8 = r8.length
            if (r9 == r8) goto L_0x003c
            indexLib(r3, r9)
        L_0x003c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.NativeDeps.indexDepsBytes(byte[], int):void");
    }

    private static int verifyBytesAndGetOffset(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null || bArr.length == 0 || bArr2.length < bArr.length + 4) {
            return -1;
        }
        if (bArr2.length != bArr.length + 4 + ByteBuffer.wrap(bArr2, bArr.length, 4).getInt()) {
            return -1;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return -1;
            }
        }
        return bArr.length + 4;
    }

    private static int findNextLine(byte[] bArr, int i) {
        while (i < bArr.length && bArr[i] != 10) {
            i++;
        }
        return i < bArr.length ? i + 1 : i;
    }

    private static int parseLibCount(byte[] bArr, int i, int i2) {
        try {
            return Integer.parseInt(new String(bArr, i, i2));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    static boolean processDepsBytes(byte[] bArr, byte[] bArr2) throws IOException {
        int i;
        int parseLibCount;
        if (bArr != null) {
            i = verifyBytesAndGetOffset(bArr, bArr2);
            if (i == -1) {
                return false;
            }
        } else {
            i = 0;
        }
        int findNextLine = findNextLine(bArr2, i);
        if (findNextLine >= bArr2.length || (parseLibCount = parseLibCount(bArr2, i, (findNextLine - i) - 1)) <= 0) {
            return false;
        }
        sPrecomputedDeps = new HashMap(((int) (((float) parseLibCount) / 1.0f)) + 1, 1.0f);
        sPrecomputedLibs = new ArrayList(parseLibCount);
        indexDepsBytes(bArr2, findNextLine);
        if (sPrecomputedLibs.size() != parseLibCount) {
            return false;
        }
        sEncodedDeps = bArr2;
        sInitialized = true;
        return true;
    }

    private static boolean libIsAtOffset(String str, int i) {
        int i2;
        int i3 = LIB_PREFIX_LEN;
        while (true) {
            int length = str.length();
            i2 = LIB_SUFFIX_LEN;
            if (i3 < length - i2 && i < sEncodedDeps.length && (str.codePointAt(i3) & 255) == sEncodedDeps[i]) {
                i3++;
                i++;
            }
        }
        return i3 == str.length() - i2;
    }

    private static int hashLib(String str) {
        int i = INITIAL_HASH;
        for (int i2 = LIB_PREFIX_LEN; i2 < str.length() - LIB_SUFFIX_LEN; i2++) {
            i = str.codePointAt(i2) + (i << 5) + i;
        }
        return i;
    }

    private static int getOffsetForLib(String str) {
        List<Integer> list = sPrecomputedDeps.get(Integer.valueOf(hashLib(str)));
        if (list == null) {
            return -1;
        }
        for (Integer intValue : list) {
            int intValue2 = intValue.intValue();
            if (libIsAtOffset(str, intValue2)) {
                return intValue2;
            }
        }
        return -1;
    }

    @Nullable
    private static String getLibString(int i) {
        if (i >= sPrecomputedLibs.size()) {
            return null;
        }
        int intValue = sPrecomputedLibs.get(i).intValue();
        int i2 = intValue;
        while (true) {
            byte[] bArr = sEncodedDeps;
            if (i2 >= bArr.length || bArr[i2] <= 32) {
                int i3 = (i2 - intValue) + LIB_PREFIX_SUFFIX_LEN;
                char[] cArr = new char[i3];
                cArr[0] = 'l';
                cArr[1] = 'i';
                cArr[2] = 'b';
            } else {
                i2++;
            }
        }
        int i32 = (i2 - intValue) + LIB_PREFIX_SUFFIX_LEN;
        char[] cArr2 = new char[i32];
        cArr2[0] = 'l';
        cArr2[1] = 'i';
        cArr2[2] = 'b';
        for (int i4 = 0; i4 < i32 - LIB_PREFIX_SUFFIX_LEN; i4++) {
            cArr2[LIB_PREFIX_LEN + i4] = (char) sEncodedDeps[intValue + i4];
        }
        cArr2[i32 - 3] = '.';
        cArr2[i32 - 2] = 's';
        cArr2[i32 - 1] = 'o';
        return new String(cArr2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] getDepsForLibAtOffset(int r6, int r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r6 = r6 + r7
            int r7 = LIB_PREFIX_SUFFIX_LEN
            int r6 = r6 - r7
            r7 = 0
            r1 = r7
            r2 = r1
        L_0x000c:
            byte[] r3 = sEncodedDeps
            int r4 = r3.length
            r5 = 0
            if (r6 >= r4) goto L_0x003e
            byte r3 = r3[r6]
            r4 = 10
            if (r3 == r4) goto L_0x003e
            r4 = 32
            if (r3 != r4) goto L_0x002b
            if (r2 == 0) goto L_0x003a
            java.lang.String r1 = getLibString(r1)
            if (r1 != 0) goto L_0x0025
            return r5
        L_0x0025:
            r0.add(r1)
            r1 = r7
            r2 = r1
            goto L_0x003a
        L_0x002b:
            r2 = 48
            if (r3 < r2) goto L_0x003d
            r2 = 57
            if (r3 <= r2) goto L_0x0034
            goto L_0x003d
        L_0x0034:
            int r1 = r1 * 10
            int r3 = r3 + -48
            int r1 = r1 + r3
            r2 = 1
        L_0x003a:
            int r6 = r6 + 1
            goto L_0x000c
        L_0x003d:
            return r5
        L_0x003e:
            if (r2 == 0) goto L_0x004a
            java.lang.String r6 = getLibString(r1)
            if (r6 != 0) goto L_0x0047
            return r5
        L_0x0047:
            r0.add(r6)
        L_0x004a:
            int r6 = r0.size()
            if (r6 != 0) goto L_0x0051
            return r5
        L_0x0051:
            int r6 = r0.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r0.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.NativeDeps.getDepsForLibAtOffset(int, int):java.lang.String[]");
    }

    @Nullable
    static String[] tryGetDepsFromPrecomputedDeps(String str) {
        int offsetForLib;
        if (sInitialized && str.length() > LIB_PREFIX_SUFFIX_LEN && (offsetForLib = getOffsetForLib(str)) != -1) {
            return getDepsForLibAtOffset(offsetForLib, str.length());
        }
        return null;
    }

    private static void verifyUninitialized() {
        if (sInitialized) {
            synchronized (NativeDeps.class) {
                if (sInitialized) {
                    throw new IllegalStateException("Trying to initialize NativeDeps but it was already initialized");
                }
            }
        }
    }
}
