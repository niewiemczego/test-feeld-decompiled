package io.sentry.instrumentation.file;

import io.sentry.HubAdapter;
import io.sentry.IHub;
import io.sentry.ISpan;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class SentryFileInputStream extends FileInputStream {
    private final FileInputStream delegate;
    private final FileIOSpanManager spanManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SentryFileInputStream(String str) throws FileNotFoundException {
        this(str != null ? new File(str) : null, (IHub) HubAdapter.getInstance());
    }

    public SentryFileInputStream(File file) throws FileNotFoundException {
        this(file, (IHub) HubAdapter.getInstance());
    }

    public SentryFileInputStream(FileDescriptor fileDescriptor) {
        this(fileDescriptor, (IHub) HubAdapter.getInstance());
    }

    SentryFileInputStream(File file, IHub iHub) throws FileNotFoundException {
        this(init(file, (FileInputStream) null, iHub));
    }

    SentryFileInputStream(FileDescriptor fileDescriptor, IHub iHub) {
        this(init(fileDescriptor, (FileInputStream) null, iHub), fileDescriptor);
    }

    private SentryFileInputStream(FileInputStreamInitData fileInputStreamInitData, FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        this.spanManager = new FileIOSpanManager(fileInputStreamInitData.span, fileInputStreamInitData.file, fileInputStreamInitData.options);
        this.delegate = fileInputStreamInitData.delegate;
    }

    private SentryFileInputStream(FileInputStreamInitData fileInputStreamInitData) throws FileNotFoundException {
        super(getFileDescriptor(fileInputStreamInitData.delegate));
        this.spanManager = new FileIOSpanManager(fileInputStreamInitData.span, fileInputStreamInitData.file, fileInputStreamInitData.options);
        this.delegate = fileInputStreamInitData.delegate;
    }

    /* access modifiers changed from: private */
    public static FileInputStreamInitData init(File file, FileInputStream fileInputStream, IHub iHub) throws FileNotFoundException {
        ISpan startSpan = FileIOSpanManager.startSpan(iHub, "file.read");
        if (fileInputStream == null) {
            fileInputStream = new FileInputStream(file);
        }
        return new FileInputStreamInitData(file, startSpan, fileInputStream, iHub.getOptions());
    }

    /* access modifiers changed from: private */
    public static FileInputStreamInitData init(FileDescriptor fileDescriptor, FileInputStream fileInputStream, IHub iHub) {
        ISpan startSpan = FileIOSpanManager.startSpan(iHub, "file.read");
        if (fileInputStream == null) {
            fileInputStream = new FileInputStream(fileDescriptor);
        }
        return new FileInputStreamInitData((File) null, startSpan, fileInputStream, iHub.getOptions());
    }

    public int read() throws IOException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.spanManager.performIO(new SentryFileInputStream$$ExternalSyntheticLambda0(this, atomicInteger));
        return atomicInteger.get();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$read$0$io-sentry-instrumentation-file-SentryFileInputStream  reason: not valid java name */
    public /* synthetic */ Integer m925lambda$read$0$iosentryinstrumentationfileSentryFileInputStream(AtomicInteger atomicInteger) throws IOException {
        int read = this.delegate.read();
        atomicInteger.set(read);
        return Integer.valueOf(read != -1 ? 1 : 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$read$1$io-sentry-instrumentation-file-SentryFileInputStream  reason: not valid java name */
    public /* synthetic */ Integer m926lambda$read$1$iosentryinstrumentationfileSentryFileInputStream(byte[] bArr) throws IOException {
        return Integer.valueOf(this.delegate.read(bArr));
    }

    public int read(byte[] bArr) throws IOException {
        return ((Integer) this.spanManager.performIO(new SentryFileInputStream$$ExternalSyntheticLambda2(this, bArr))).intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$read$2$io-sentry-instrumentation-file-SentryFileInputStream  reason: not valid java name */
    public /* synthetic */ Integer m927lambda$read$2$iosentryinstrumentationfileSentryFileInputStream(byte[] bArr, int i, int i2) throws IOException {
        return Integer.valueOf(this.delegate.read(bArr, i, i2));
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return ((Integer) this.spanManager.performIO(new SentryFileInputStream$$ExternalSyntheticLambda1(this, bArr, i, i2))).intValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$skip$3$io-sentry-instrumentation-file-SentryFileInputStream  reason: not valid java name */
    public /* synthetic */ Long m928lambda$skip$3$iosentryinstrumentationfileSentryFileInputStream(long j) throws IOException {
        return Long.valueOf(this.delegate.skip(j));
    }

    public long skip(long j) throws IOException {
        return ((Long) this.spanManager.performIO(new SentryFileInputStream$$ExternalSyntheticLambda3(this, j))).longValue();
    }

    public void close() throws IOException {
        this.spanManager.finish(this.delegate);
    }

    private static FileDescriptor getFileDescriptor(FileInputStream fileInputStream) throws FileNotFoundException {
        try {
            return fileInputStream.getFD();
        } catch (IOException unused) {
            throw new FileNotFoundException("No file descriptor");
        }
    }

    public static final class Factory {
        public static FileInputStream create(FileInputStream fileInputStream, String str) throws FileNotFoundException {
            return new SentryFileInputStream(SentryFileInputStream.init(str != null ? new File(str) : null, fileInputStream, (IHub) HubAdapter.getInstance()));
        }

        public static FileInputStream create(FileInputStream fileInputStream, File file) throws FileNotFoundException {
            return new SentryFileInputStream(SentryFileInputStream.init(file, fileInputStream, (IHub) HubAdapter.getInstance()));
        }

        public static FileInputStream create(FileInputStream fileInputStream, FileDescriptor fileDescriptor) {
            return new SentryFileInputStream(SentryFileInputStream.init(fileDescriptor, fileInputStream, (IHub) HubAdapter.getInstance()), fileDescriptor);
        }

        static FileInputStream create(FileInputStream fileInputStream, File file, IHub iHub) throws FileNotFoundException {
            return new SentryFileInputStream(SentryFileInputStream.init(file, fileInputStream, iHub));
        }
    }
}
