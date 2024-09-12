package io.sentry.instrumentation.file;

import io.sentry.HubAdapter;
import io.sentry.IHub;
import io.sentry.ISpan;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class SentryFileOutputStream extends FileOutputStream {
    private final FileOutputStream delegate;
    private final FileIOSpanManager spanManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SentryFileOutputStream(String str) throws FileNotFoundException {
        this(str != null ? new File(str) : null, false, (IHub) HubAdapter.getInstance());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SentryFileOutputStream(String str, boolean z) throws FileNotFoundException {
        this(init(str != null ? new File(str) : null, z, (FileOutputStream) null, HubAdapter.getInstance()));
    }

    public SentryFileOutputStream(File file) throws FileNotFoundException {
        this(file, false, (IHub) HubAdapter.getInstance());
    }

    public SentryFileOutputStream(File file, boolean z) throws FileNotFoundException {
        this(init(file, z, (FileOutputStream) null, HubAdapter.getInstance()));
    }

    public SentryFileOutputStream(FileDescriptor fileDescriptor) {
        this(init(fileDescriptor, (FileOutputStream) null, HubAdapter.getInstance()), fileDescriptor);
    }

    SentryFileOutputStream(File file, boolean z, IHub iHub) throws FileNotFoundException {
        this(init(file, z, (FileOutputStream) null, iHub));
    }

    private SentryFileOutputStream(FileOutputStreamInitData fileOutputStreamInitData, FileDescriptor fileDescriptor) {
        super(fileDescriptor);
        this.spanManager = new FileIOSpanManager(fileOutputStreamInitData.span, fileOutputStreamInitData.file, fileOutputStreamInitData.options);
        this.delegate = fileOutputStreamInitData.delegate;
    }

    private SentryFileOutputStream(FileOutputStreamInitData fileOutputStreamInitData) throws FileNotFoundException {
        super(getFileDescriptor(fileOutputStreamInitData.delegate));
        this.spanManager = new FileIOSpanManager(fileOutputStreamInitData.span, fileOutputStreamInitData.file, fileOutputStreamInitData.options);
        this.delegate = fileOutputStreamInitData.delegate;
    }

    /* access modifiers changed from: private */
    public static FileOutputStreamInitData init(File file, boolean z, FileOutputStream fileOutputStream, IHub iHub) throws FileNotFoundException {
        ISpan startSpan = FileIOSpanManager.startSpan(iHub, "file.write");
        if (fileOutputStream == null) {
            fileOutputStream = new FileOutputStream(file, z);
        }
        return new FileOutputStreamInitData(file, z, startSpan, fileOutputStream, iHub.getOptions());
    }

    /* access modifiers changed from: private */
    public static FileOutputStreamInitData init(FileDescriptor fileDescriptor, FileOutputStream fileOutputStream, IHub iHub) {
        ISpan startSpan = FileIOSpanManager.startSpan(iHub, "file.write");
        if (fileOutputStream == null) {
            fileOutputStream = new FileOutputStream(fileDescriptor);
        }
        return new FileOutputStreamInitData((File) null, false, startSpan, fileOutputStream, iHub.getOptions());
    }

    public void write(int i) throws IOException {
        this.spanManager.performIO(new SentryFileOutputStream$$ExternalSyntheticLambda1(this, i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$write$0$io-sentry-instrumentation-file-SentryFileOutputStream  reason: not valid java name */
    public /* synthetic */ Integer m929lambda$write$0$iosentryinstrumentationfileSentryFileOutputStream(int i) throws IOException {
        this.delegate.write(i);
        return 1;
    }

    public void write(byte[] bArr) throws IOException {
        this.spanManager.performIO(new SentryFileOutputStream$$ExternalSyntheticLambda2(this, bArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$write$1$io-sentry-instrumentation-file-SentryFileOutputStream  reason: not valid java name */
    public /* synthetic */ Integer m930lambda$write$1$iosentryinstrumentationfileSentryFileOutputStream(byte[] bArr) throws IOException {
        this.delegate.write(bArr);
        return Integer.valueOf(bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.spanManager.performIO(new SentryFileOutputStream$$ExternalSyntheticLambda0(this, bArr, i, i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$write$2$io-sentry-instrumentation-file-SentryFileOutputStream  reason: not valid java name */
    public /* synthetic */ Integer m931lambda$write$2$iosentryinstrumentationfileSentryFileOutputStream(byte[] bArr, int i, int i2) throws IOException {
        this.delegate.write(bArr, i, i2);
        return Integer.valueOf(i2);
    }

    public void close() throws IOException {
        this.spanManager.finish(this.delegate);
    }

    private static FileDescriptor getFileDescriptor(FileOutputStream fileOutputStream) throws FileNotFoundException {
        try {
            return fileOutputStream.getFD();
        } catch (IOException unused) {
            throw new FileNotFoundException("No file descriptor");
        }
    }

    public static final class Factory {
        public static FileOutputStream create(FileOutputStream fileOutputStream, String str) throws FileNotFoundException {
            return new SentryFileOutputStream(SentryFileOutputStream.init(str != null ? new File(str) : null, false, fileOutputStream, HubAdapter.getInstance()));
        }

        public static FileOutputStream create(FileOutputStream fileOutputStream, String str, boolean z) throws FileNotFoundException {
            return new SentryFileOutputStream(SentryFileOutputStream.init(str != null ? new File(str) : null, z, fileOutputStream, HubAdapter.getInstance()));
        }

        public static FileOutputStream create(FileOutputStream fileOutputStream, File file) throws FileNotFoundException {
            return new SentryFileOutputStream(SentryFileOutputStream.init(file, false, fileOutputStream, HubAdapter.getInstance()));
        }

        public static FileOutputStream create(FileOutputStream fileOutputStream, File file, boolean z) throws FileNotFoundException {
            return new SentryFileOutputStream(SentryFileOutputStream.init(file, z, fileOutputStream, HubAdapter.getInstance()));
        }

        public static FileOutputStream create(FileOutputStream fileOutputStream, FileDescriptor fileDescriptor) {
            return new SentryFileOutputStream(SentryFileOutputStream.init(fileDescriptor, fileOutputStream, HubAdapter.getInstance()), fileDescriptor);
        }
    }
}
