package com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class FileBackedOutputStream extends OutputStream {
    @CheckForNull
    private File file;
    private final int fileThreshold;
    @CheckForNull
    private MemoryOutput memory;
    private OutputStream out;
    @CheckForNull
    private final File parentDirectory;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        /* access modifiers changed from: package-private */
        public byte[] getBuffer() {
            return this.buf;
        }

        /* access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public synchronized File getFile() {
        return this.file;
    }

    public FileBackedOutputStream(int i) {
        this(i, false);
    }

    public FileBackedOutputStream(int i, boolean z) {
        this(i, z, (File) null);
    }

    private FileBackedOutputStream(int i, boolean z, @CheckForNull File file2) {
        this.fileThreshold = i;
        this.resetOnFinalize = z;
        this.parentDirectory = file2;
        MemoryOutput memoryOutput = new MemoryOutput();
        this.memory = memoryOutput;
        this.out = memoryOutput;
        if (z) {
            this.source = new ByteSource() {
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }

                /* access modifiers changed from: protected */
                public void finalize() {
                    try {
                        FileBackedOutputStream.this.reset();
                    } catch (Throwable th) {
                        th.printStackTrace(System.err);
                    }
                }
            };
        } else {
            this.source = new ByteSource() {
                public InputStream openStream() throws IOException {
                    return FileBackedOutputStream.this.openInputStream();
                }
            };
        }
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    /* access modifiers changed from: private */
    public synchronized InputStream openInputStream() throws IOException {
        if (this.file != null) {
            return new FileInputStream(this.file);
        }
        Objects.requireNonNull(this.memory);
        return new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());
    }

    public synchronized void reset() throws IOException {
        try {
            close();
            MemoryOutput memoryOutput = this.memory;
            if (memoryOutput == null) {
                this.memory = new MemoryOutput();
            } else {
                memoryOutput.reset();
            }
            this.out = this.memory;
            File file2 = this.file;
            if (file2 != null) {
                this.file = null;
                if (!file2.delete()) {
                    String valueOf = String.valueOf(file2);
                    throw new IOException(new StringBuilder(String.valueOf(valueOf).length() + 18).append("Could not delete: ").append(valueOf).toString());
                }
            }
        } catch (Throwable th) {
            if (this.memory == null) {
                this.memory = new MemoryOutput();
            } else {
                this.memory.reset();
            }
            this.out = this.memory;
            File file3 = this.file;
            if (file3 != null) {
                this.file = null;
                if (!file3.delete()) {
                    String valueOf2 = String.valueOf(file3);
                    throw new IOException(new StringBuilder(String.valueOf(valueOf2).length() + 18).append("Could not delete: ").append(valueOf2).toString());
                }
            }
            throw th;
        }
    }

    public synchronized void write(int i) throws IOException {
        update(1);
        this.out.write(i);
    }

    public synchronized void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        update(i2);
        this.out.write(bArr, i, i2);
    }

    public synchronized void close() throws IOException {
        this.out.close();
    }

    public synchronized void flush() throws IOException {
        this.out.flush();
    }

    private void update(int i) throws IOException {
        MemoryOutput memoryOutput = this.memory;
        if (memoryOutput != null && memoryOutput.getCount() + i > this.fileThreshold) {
            File createTempFile = File.createTempFile("FileBackedOutputStream", (String) null, this.parentDirectory);
            if (this.resetOnFinalize) {
                createTempFile.deleteOnExit();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                fileOutputStream.write(this.memory.getBuffer(), 0, this.memory.getCount());
                fileOutputStream.flush();
                this.out = fileOutputStream;
                this.file = createTempFile;
                this.memory = null;
            } catch (IOException e) {
                createTempFile.delete();
                throw e;
            }
        }
    }
}
