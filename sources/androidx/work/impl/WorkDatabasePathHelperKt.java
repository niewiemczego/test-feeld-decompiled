package androidx.work.impl;

import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0016\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0002XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"DATABASE_EXTRA_FILES", "", "", "[Ljava/lang/String;", "TAG", "WORK_DATABASE_NAME", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkDatabasePathHelper.kt */
public final class WorkDatabasePathHelperKt {
    /* access modifiers changed from: private */
    public static final String[] DATABASE_EXTRA_FILES = {"-journal", "-shm", "-wal"};
    /* access modifiers changed from: private */
    public static final String TAG;
    public static final String WORK_DATABASE_NAME = "androidx.work.workdb";

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WrkDbPathHelper");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"WrkDbPathHelper\")");
        TAG = tagWithPrefix;
    }
}
