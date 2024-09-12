package io.sentry.instrumentation.file;

import io.sentry.ISpan;
import io.sentry.SentryOptions;
import java.io.File;
import java.io.FileOutputStream;

final class FileOutputStreamInitData {
    final boolean append;
    final FileOutputStream delegate;
    final File file;
    final SentryOptions options;
    final ISpan span;

    FileOutputStreamInitData(File file2, boolean z, ISpan iSpan, FileOutputStream fileOutputStream, SentryOptions sentryOptions) {
        this.file = file2;
        this.append = z;
        this.span = iSpan;
        this.delegate = fileOutputStream;
        this.options = sentryOptions;
    }
}
