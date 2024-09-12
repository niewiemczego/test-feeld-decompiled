package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class UnpackingSoSource extends DirectorySoSource {
    private static final String DEPS_FILE_NAME = "dso_deps";
    private static final String INSTANCE_LOCK_FILE_NAME = "dso_instance_lock";
    private static final String LOCK_FILE_NAME = "dso_lock";
    private static final String MANIFEST_FILE_NAME = "dso_manifest";
    private static final byte MANIFEST_VERSION = 1;
    protected static final byte STATE_CLEAN = 1;
    protected static final byte STATE_DIRTY = 0;
    private static final String STATE_FILE_NAME = "dso_state";
    private static final String TAG = "fb-UnpackingSoSource";
    @Nullable
    private String[] mAbis;
    protected final Context mContext;
    @Nullable
    protected String mCorruptedLib;
    @Nullable
    protected FileLocker mInstanceLock;
    private final Map<String, Object> mLibsBeingLoaded = new HashMap();

    protected interface InputDso extends Closeable {
        int available() throws IOException;

        Dso getDso();

        String getFileName();

        InputStream getStream();

        void write(DataOutput dataOutput, byte[] bArr) throws IOException;
    }

    /* access modifiers changed from: protected */
    public String getSoNameFromFileName(String str) {
        return str;
    }

    /* access modifiers changed from: protected */
    public abstract Unpacker makeUnpacker(byte b) throws IOException;

    protected UnpackingSoSource(Context context, String str) {
        super(getSoStorePath(context, str), 1);
        this.mContext = context;
    }

    protected UnpackingSoSource(Context context, File file) {
        super(file, 1);
        this.mContext = context;
    }

    public static File getSoStorePath(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    public String[] getSoSourceAbis() {
        String[] strArr = this.mAbis;
        return strArr == null ? super.getSoSourceAbis() : strArr;
    }

    public void setSoSourceAbis(String[] strArr) {
        this.mAbis = strArr;
    }

    public static class Dso {
        public final String hash;
        public final String name;

        public Dso(String str, String str2) {
            this.name = str;
            this.hash = str2;
        }
    }

    public static final class DsoManifest {
        public final Dso[] dsos;

        public DsoManifest(Dso[] dsoArr) {
            this.dsos = dsoArr;
        }

        static final DsoManifest read(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    Dso[] dsoArr = new Dso[readInt];
                    for (int i = 0; i < readInt; i++) {
                        dsoArr[i] = new Dso(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new DsoManifest(dsoArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void write(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.dsos.length);
            int i = 0;
            while (true) {
                Dso[] dsoArr = this.dsos;
                if (i < dsoArr.length) {
                    dataOutput.writeUTF(dsoArr[i].name);
                    dataOutput.writeUTF(this.dsos[i].hash);
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static class InputDsoStream implements InputDso {
        private final InputStream content;
        private final Dso dso;

        public InputDsoStream(Dso dso2, InputStream inputStream) {
            this.dso = dso2;
            this.content = inputStream;
        }

        public void write(DataOutput dataOutput, byte[] bArr) throws IOException {
            SysUtil.copyBytes(dataOutput, this.content, Integer.MAX_VALUE, bArr);
        }

        public Dso getDso() {
            return this.dso;
        }

        public String getFileName() {
            return this.dso.name;
        }

        public int available() throws IOException {
            return this.content.available();
        }

        public InputStream getStream() {
            return this.content;
        }

        public void close() throws IOException {
            this.content.close();
        }
    }

    protected static abstract class InputDsoIterator implements Closeable {
        public void close() throws IOException {
        }

        public abstract boolean hasNext();

        @Nullable
        public abstract InputDso next() throws IOException;

        protected InputDsoIterator() {
        }
    }

    protected static abstract class Unpacker implements Closeable {
        public void close() throws IOException {
        }

        public abstract DsoManifest getDsoManifest() throws IOException;

        public abstract InputDsoIterator openDsoIterator() throws IOException;

        protected Unpacker() {
        }
    }

    /* access modifiers changed from: private */
    public static void writeState(File file, byte b) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.write(b);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
            return;
        } catch (SyncFailedException e) {
            Log.w(TAG, "state file sync failed", e);
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void deleteUnmentionedFiles(Dso[] dsoArr) throws IOException {
        String[] list = this.soDirectory.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(STATE_FILE_NAME) && !str.equals(LOCK_FILE_NAME) && !str.equals(INSTANCE_LOCK_FILE_NAME) && !str.equals(DEPS_FILE_NAME) && !str.equals(MANIFEST_FILE_NAME)) {
                    boolean z = false;
                    int i = 0;
                    while (!z && i < dsoArr.length) {
                        if (dsoArr[i].name.equals(getSoNameFromFileName(str))) {
                            z = true;
                        }
                        i++;
                    }
                    if (!z) {
                        File file = new File(this.soDirectory, str);
                        Log.v(TAG, "deleting unaccounted-for file " + file);
                        SysUtil.dumbDeleteRecursive(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.soDirectory);
    }

    private void extractDso(InputDso inputDso, byte[] bArr) throws IOException {
        boolean writable;
        Log.i(TAG, "extracting DSO " + inputDso.getDso().name);
        try {
            if (this.soDirectory.setWritable(true)) {
                extractDsoImpl(inputDso, bArr);
                if (writable) {
                    return;
                }
                return;
            }
            throw new IOException("cannot make directory writable for us: " + this.soDirectory);
        } finally {
            if (!this.soDirectory.setWritable(false)) {
                Log.w(TAG, "error removing " + this.soDirectory.getCanonicalPath() + " write permission");
            }
        }
    }

    private void extractDsoImpl(InputDso inputDso, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.soDirectory, inputDso.getFileName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            if (file.exists() && !file.setWritable(true)) {
                Log.w(TAG, "error adding write permission to: " + file);
            }
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (IOException e) {
                Log.w(TAG, "error overwriting " + file + " trying to delete and start over", e);
                SysUtil.dumbDeleteRecursive(file);
                randomAccessFile = new RandomAccessFile(file, "rw");
            }
            randomAccessFile2 = randomAccessFile;
            int available = inputDso.available();
            if (available > 1) {
                SysUtil.fallocateIfSupported(randomAccessFile2.getFD(), (long) available);
            }
            inputDso.write(randomAccessFile2, bArr);
            randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
            if (file.setExecutable(true, false)) {
                if (!file.setWritable(false)) {
                    Log.w(TAG, "error removing " + file + " write permission");
                }
                randomAccessFile2.close();
                return;
            }
            throw new IOException("cannot make file executable: " + file);
        } catch (IOException e2) {
            SysUtil.dumbDeleteRecursive(file);
            throw e2;
        } catch (Throwable th) {
            if (!file.setWritable(false)) {
                Log.w(TAG, "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045 A[Catch:{ all -> 0x00ae, all -> 0x00b5, all -> 0x0038, all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A[Catch:{ all -> 0x00ae, all -> 0x00b5, all -> 0x0038, all -> 0x00e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void regenerate(byte r10, com.facebook.soloader.UnpackingSoSource.DsoManifest r11, com.facebook.soloader.UnpackingSoSource.InputDsoIterator r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "regenerating DSO store "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.Class r1 = r9.getClass()
            java.lang.String r1 = r1.getName()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "fb-UnpackingSoSource"
            android.util.Log.v(r1, r0)
            java.io.File r0 = new java.io.File
            java.io.File r2 = r9.soDirectory
            java.lang.String r3 = "dso_manifest"
            r0.<init>(r2, r3)
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile
            java.lang.String r3 = "rw"
            r2.<init>(r0, r3)
            r0 = 1
            if (r10 != r0) goto L_0x0041
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = com.facebook.soloader.UnpackingSoSource.DsoManifest.read(r2)     // Catch:{ Exception -> 0x003b }
            goto L_0x0042
        L_0x0038:
            r10 = move-exception
            goto L_0x00dc
        L_0x003b:
            r10 = move-exception
            java.lang.String r3 = "error reading existing DSO manifest"
            android.util.Log.i(r1, r3, r10)     // Catch:{ all -> 0x0038 }
        L_0x0041:
            r10 = 0
        L_0x0042:
            r3 = 0
            if (r10 != 0) goto L_0x004c
            com.facebook.soloader.UnpackingSoSource$DsoManifest r10 = new com.facebook.soloader.UnpackingSoSource$DsoManifest     // Catch:{ all -> 0x0038 }
            com.facebook.soloader.UnpackingSoSource$Dso[] r4 = new com.facebook.soloader.UnpackingSoSource.Dso[r3]     // Catch:{ all -> 0x0038 }
            r10.<init>(r4)     // Catch:{ all -> 0x0038 }
        L_0x004c:
            com.facebook.soloader.UnpackingSoSource$Dso[] r11 = r11.dsos     // Catch:{ all -> 0x0038 }
            r9.deleteUnmentionedFiles(r11)     // Catch:{ all -> 0x0038 }
            r11 = 32768(0x8000, float:4.5918E-41)
            byte[] r11 = new byte[r11]     // Catch:{ all -> 0x0038 }
        L_0x0056:
            boolean r4 = r12.hasNext()     // Catch:{ all -> 0x0038 }
            if (r4 == 0) goto L_0x00ba
            com.facebook.soloader.UnpackingSoSource$InputDso r4 = r12.next()     // Catch:{ all -> 0x0038 }
            r5 = r0
            r6 = r3
        L_0x0062:
            if (r5 == 0) goto L_0x0091
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00ae }
            int r7 = r7.length     // Catch:{ all -> 0x00ae }
            if (r6 >= r7) goto L_0x0091
            com.facebook.soloader.UnpackingSoSource$Dso r7 = r4.getDso()     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x00ae }
            com.facebook.soloader.UnpackingSoSource$Dso[] r8 = r10.dsos     // Catch:{ all -> 0x00ae }
            r8 = r8[r6]     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r8.name     // Catch:{ all -> 0x00ae }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x008e
            com.facebook.soloader.UnpackingSoSource$Dso[] r7 = r10.dsos     // Catch:{ all -> 0x00ae }
            r7 = r7[r6]     // Catch:{ all -> 0x00ae }
            java.lang.String r7 = r7.hash     // Catch:{ all -> 0x00ae }
            com.facebook.soloader.UnpackingSoSource$Dso r8 = r4.getDso()     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r8.hash     // Catch:{ all -> 0x00ae }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x008e
            r5 = r3
        L_0x008e:
            int r6 = r6 + 1
            goto L_0x0062
        L_0x0091:
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x00ae }
            java.io.File r7 = r9.soDirectory     // Catch:{ all -> 0x00ae }
            java.lang.String r8 = r4.getFileName()     // Catch:{ all -> 0x00ae }
            r6.<init>(r7, r8)     // Catch:{ all -> 0x00ae }
            boolean r6 = r6.exists()     // Catch:{ all -> 0x00ae }
            if (r6 != 0) goto L_0x00a3
            r5 = r0
        L_0x00a3:
            if (r5 == 0) goto L_0x00a8
            r9.extractDso(r4, r11)     // Catch:{ all -> 0x00ae }
        L_0x00a8:
            if (r4 == 0) goto L_0x0056
            r4.close()     // Catch:{ all -> 0x0038 }
            goto L_0x0056
        L_0x00ae:
            r10 = move-exception
            if (r4 == 0) goto L_0x00b9
            r4.close()     // Catch:{ all -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r11 = move-exception
            r10.addSuppressed(r11)     // Catch:{ all -> 0x0038 }
        L_0x00b9:
            throw r10     // Catch:{ all -> 0x0038 }
        L_0x00ba:
            r2.close()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Finished regenerating DSO store "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.Class r11 = r9.getClass()
            java.lang.String r11 = r11.getName()
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.util.Log.v(r1, r10)
            return
        L_0x00dc:
            r2.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r11 = move-exception
            r10.addSuppressed(r11)
        L_0x00e4:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.regenerate(byte, com.facebook.soloader.UnpackingSoSource$DsoManifest, com.facebook.soloader.UnpackingSoSource$InputDsoIterator):void");
    }

    /* access modifiers changed from: protected */
    public boolean depsChanged(byte[] bArr, byte[] bArr2) {
        return !Arrays.equals(bArr, bArr2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean refreshLocked(com.facebook.soloader.FileLocker r12, int r13, byte[] r14) throws java.io.IOException {
        /*
            r11 = this;
            java.lang.String r0 = "fb-UnpackingSoSource"
            java.io.File r4 = new java.io.File
            java.io.File r1 = r11.soDirectory
            java.lang.String r2 = "dso_state"
            r4.<init>(r1, r2)
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile
            java.lang.String r2 = "rw"
            r1.<init>(r4, r2)
            r8 = 1
            r3 = 0
            byte r5 = r1.readByte()     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            if (r5 == r8) goto L_0x0044
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            r5.<init>()     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            java.lang.String r6 = "dso store "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            java.io.File r6 = r11.soDirectory     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            java.lang.String r6 = " regeneration interrupted: wiping clean"
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            java.lang.String r5 = r5.toString()     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            android.util.Log.v(r0, r5)     // Catch:{ EOFException -> 0x0043, all -> 0x0039 }
            goto L_0x0043
        L_0x0039:
            r12 = move-exception
            r1.close()     // Catch:{ all -> 0x003e }
            goto L_0x0042
        L_0x003e:
            r13 = move-exception
            r12.addSuppressed(r13)
        L_0x0042:
            throw r12
        L_0x0043:
            r5 = r3
        L_0x0044:
            r1.close()
            java.io.File r6 = new java.io.File
            java.io.File r1 = r11.soDirectory
            java.lang.String r7 = "dso_deps"
            r6.<init>(r1, r7)
            r1 = 0
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile
            r7.<init>(r6, r2)
            long r9 = r7.length()     // Catch:{ all -> 0x00f4 }
            int r2 = (int) r9     // Catch:{ all -> 0x00f4 }
            byte[] r9 = new byte[r2]     // Catch:{ all -> 0x00f4 }
            int r10 = r7.read(r9)     // Catch:{ all -> 0x00f4 }
            if (r10 == r2) goto L_0x0069
            java.lang.String r2 = "short read of so store deps file: marking unclean"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00f4 }
            r5 = r3
        L_0x0069:
            boolean r2 = r11.depsChanged(r9, r14)     // Catch:{ all -> 0x00f4 }
            if (r2 == 0) goto L_0x0075
            java.lang.String r2 = "deps mismatch on deps store: regenerating"
            android.util.Log.v(r0, r2)     // Catch:{ all -> 0x00f4 }
            r5 = r3
        L_0x0075:
            if (r5 == 0) goto L_0x007e
            r2 = r13 & 2
            if (r2 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r0 = r1
            goto L_0x00a0
        L_0x007e:
            java.lang.String r1 = "so store dirty: regenerating"
            android.util.Log.v(r0, r1)     // Catch:{ all -> 0x00f4 }
            writeState(r4, r3)     // Catch:{ all -> 0x00f4 }
            com.facebook.soloader.UnpackingSoSource$Unpacker r0 = r11.makeUnpacker(r5)     // Catch:{ all -> 0x00f4 }
            com.facebook.soloader.UnpackingSoSource$DsoManifest r1 = r0.getDsoManifest()     // Catch:{ all -> 0x00e8 }
            com.facebook.soloader.UnpackingSoSource$InputDsoIterator r2 = r0.openDsoIterator()     // Catch:{ all -> 0x00e8 }
            r11.regenerate(r5, r1, r2)     // Catch:{ all -> 0x00dc }
            if (r2 == 0) goto L_0x009a
            r2.close()     // Catch:{ all -> 0x00e8 }
        L_0x009a:
            if (r0 == 0) goto L_0x007c
            r0.close()     // Catch:{ all -> 0x00f4 }
            goto L_0x007c
        L_0x00a0:
            r7.close()
            if (r0 != 0) goto L_0x00a6
            return r3
        L_0x00a6:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r3)
            r1 = r11
            r2 = r12
            r3 = r14
            r5 = r6
            r6 = r0
            java.lang.Runnable r12 = r1.createSyncer(r2, r3, r4, r5, r6, r7)
            r13 = r13 & r8
            if (r13 == 0) goto L_0x00d8
            java.lang.Thread r13 = new java.lang.Thread
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "SoSync:"
            java.lang.StringBuilder r14 = r14.append(r0)
            java.io.File r0 = r11.soDirectory
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r14 = r14.append(r0)
            java.lang.String r14 = r14.toString()
            r13.<init>(r12, r14)
            r13.start()
            goto L_0x00db
        L_0x00d8:
            r12.run()
        L_0x00db:
            return r8
        L_0x00dc:
            r12 = move-exception
            if (r2 == 0) goto L_0x00e7
            r2.close()     // Catch:{ all -> 0x00e3 }
            goto L_0x00e7
        L_0x00e3:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x00e8 }
        L_0x00e7:
            throw r12     // Catch:{ all -> 0x00e8 }
        L_0x00e8:
            r12 = move-exception
            if (r0 == 0) goto L_0x00f3
            r0.close()     // Catch:{ all -> 0x00ef }
            goto L_0x00f3
        L_0x00ef:
            r13 = move-exception
            r12.addSuppressed(r13)     // Catch:{ all -> 0x00f4 }
        L_0x00f3:
            throw r12     // Catch:{ all -> 0x00f4 }
        L_0x00f4:
            r12 = move-exception
            r7.close()     // Catch:{ all -> 0x00f9 }
            goto L_0x00fd
        L_0x00f9:
            r13 = move-exception
            r12.addSuppressed(r13)
        L_0x00fd:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.UnpackingSoSource.refreshLocked(com.facebook.soloader.FileLocker, int, byte[]):boolean");
    }

    private Runnable createSyncer(FileLocker fileLocker, byte[] bArr, File file, File file2, DsoManifest dsoManifest, Boolean bool) {
        final File file3 = file2;
        final byte[] bArr2 = bArr;
        final DsoManifest dsoManifest2 = dsoManifest;
        final File file4 = file;
        final FileLocker fileLocker2 = fileLocker;
        final Boolean bool2 = bool;
        return new Runnable() {
            public void run() {
                RandomAccessFile randomAccessFile;
                RandomAccessFile randomAccessFile2;
                try {
                    Log.v(UnpackingSoSource.TAG, "starting syncer worker");
                    randomAccessFile = new RandomAccessFile(file3, "rw");
                    randomAccessFile.write(bArr2);
                    randomAccessFile.setLength(randomAccessFile.getFilePointer());
                    randomAccessFile.close();
                    randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.soDirectory, UnpackingSoSource.MANIFEST_FILE_NAME), "rw");
                    dsoManifest2.write(randomAccessFile2);
                    randomAccessFile2.close();
                    SysUtil.fsyncRecursive(UnpackingSoSource.this.soDirectory);
                    UnpackingSoSource.writeState(file4, (byte) 1);
                    try {
                        Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                        fileLocker2.close();
                        return;
                    } catch (IOException e) {
                        if (!bool2.booleanValue()) {
                            throw new RuntimeException(e);
                        }
                        return;
                    }
                    throw th;
                    throw th;
                } catch (Throwable th) {
                    Log.v(UnpackingSoSource.TAG, "releasing dso store lock for " + UnpackingSoSource.this.soDirectory + " (from syncer thread)");
                    fileLocker2.close();
                    throw th;
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public byte[] getDepsBlock() throws IOException {
        Parcel obtain = Parcel.obtain();
        Unpacker makeUnpacker = makeUnpacker((byte) 1);
        try {
            Dso[] dsoArr = makeUnpacker.getDsoManifest().dsos;
            obtain.writeByte((byte) 1);
            obtain.writeInt(dsoArr.length);
            for (int i = 0; i < dsoArr.length; i++) {
                obtain.writeString(dsoArr[i].name);
                obtain.writeString(dsoArr[i].hash);
            }
            if (makeUnpacker != null) {
                makeUnpacker.close();
            }
            byte[] marshall = obtain.marshall();
            obtain.recycle();
            return marshall;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public FileLocker getOrCreateLock(File file, boolean z) throws IOException {
        return SysUtil.getOrCreateLockOnDir(this.soDirectory, file, z);
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        SysUtil.mkdirOrThrow(this.soDirectory);
        FileLocker orCreateLock = getOrCreateLock(new File(this.soDirectory, LOCK_FILE_NAME), true);
        if (this.mInstanceLock == null) {
            this.mInstanceLock = getOrCreateLock(new File(this.soDirectory, INSTANCE_LOCK_FILE_NAME), false);
        }
        boolean canWrite = this.soDirectory.canWrite();
        try {
            Log.v(TAG, "locked dso store " + this.soDirectory);
            if (!canWrite) {
                this.soDirectory.setWritable(true);
            }
            if (refreshLocked(orCreateLock, i, getDepsBlock())) {
                orCreateLock = null;
            } else {
                Log.i(TAG, "dso store is up-to-date: " + this.soDirectory);
            }
            if (orCreateLock == null) {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        } finally {
            if (!canWrite) {
                this.soDirectory.setWritable(false);
            }
            if (orCreateLock != null) {
                Log.v(TAG, "releasing dso store lock for " + this.soDirectory);
                orCreateLock.close();
            } else {
                Log.v(TAG, "not releasing dso store lock for " + this.soDirectory + " (syncer thread started)");
            }
        }
    }

    private Object getLibraryLock(String str) {
        Object obj;
        synchronized (this.mLibsBeingLoaded) {
            obj = this.mLibsBeingLoaded.get(str);
            if (obj == null) {
                obj = new Object();
                this.mLibsBeingLoaded.put(str, obj);
            }
        }
        return obj;
    }

    @Nullable
    public String getLibraryPath(String str) throws IOException {
        File soFileByName = getSoFileByName(str);
        if (soFileByName == null) {
            return null;
        }
        return soFileByName.getCanonicalPath();
    }

    /* access modifiers changed from: protected */
    public synchronized void prepare(String str) throws IOException {
        synchronized (getLibraryLock(str)) {
            this.mCorruptedLib = str;
            prepare(2);
        }
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int loadLibraryFrom;
        synchronized (getLibraryLock(str)) {
            loadLibraryFrom = loadLibraryFrom(str, i, this.soDirectory, threadPolicy);
        }
        return loadLibraryFrom;
    }
}
