package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

public final class FileLocker implements Closeable {
    @Nullable
    private FileLock mLock;
    private FileOutputStream mLockFileOutputStream;

    public static FileLocker lock(File file) throws IOException {
        return new FileLocker(file, false);
    }

    @Nullable
    public static FileLocker tryLock(File file) throws IOException {
        FileLocker fileLocker = new FileLocker(file, true);
        if (fileLocker.mLock != null) {
            return fileLocker;
        }
        fileLocker.close();
        return null;
    }

    private void init(File file, boolean z) throws IOException {
        FileLock fileLock;
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.mLockFileOutputStream = fileOutputStream;
        if (z) {
            try {
                fileLock = fileOutputStream.getChannel().tryLock();
            } catch (IOException unused) {
                fileLock = null;
            }
        } else {
            try {
                fileLock = fileOutputStream.getChannel().lock();
            } catch (Throwable th) {
                this.mLockFileOutputStream.close();
                throw th;
            }
        }
        if (fileLock == null) {
            this.mLockFileOutputStream.close();
        }
        this.mLock = fileLock;
    }

    private FileLocker(File file, boolean z) throws IOException {
        init(file, z);
    }

    public void close() throws IOException {
        try {
            FileLock fileLock = this.mLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.mLockFileOutputStream.close();
        }
    }
}
