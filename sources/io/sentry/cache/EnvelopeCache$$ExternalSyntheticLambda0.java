package io.sentry.cache;

import java.io.File;
import java.io.FilenameFilter;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EnvelopeCache$$ExternalSyntheticLambda0 implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.endsWith(EnvelopeCache.SUFFIX_ENVELOPE_FILE);
    }
}
