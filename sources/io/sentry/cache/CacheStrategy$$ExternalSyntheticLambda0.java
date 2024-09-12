package io.sentry.cache;

import java.io.File;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CacheStrategy$$ExternalSyntheticLambda0 implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return Long.compare(((File) obj).lastModified(), ((File) obj2).lastModified());
    }
}
