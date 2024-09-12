package io.sentry.instrumentation.file;

import io.sentry.ISpan;
import io.sentry.SentryOptions;
import java.io.File;
import java.io.FileInputStream;

final class FileInputStreamInitData {
    final FileInputStream delegate;
    final File file;
    final SentryOptions options;
    final ISpan span;

    FileInputStreamInitData(File file2, ISpan iSpan, FileInputStream fileInputStream, SentryOptions sentryOptions) {
        this.file = file2;
        this.span = iSpan;
        this.delegate = fileInputStream;
        this.options = sentryOptions;
    }
}
