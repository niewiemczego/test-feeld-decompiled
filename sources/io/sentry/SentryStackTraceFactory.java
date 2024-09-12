package io.sentry;

import io.sentry.protocol.SentryStackFrame;
import io.sentry.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SentryStackTraceFactory {
    private static final int STACKTRACE_FRAME_LIMIT = 100;
    private final SentryOptions options;

    public SentryStackTraceFactory(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public List<SentryStackFrame> getStackFrames(StackTraceElement[] stackTraceElementArr, boolean z) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if (z || !className.startsWith("io.sentry.") || className.startsWith("io.sentry.samples.") || className.startsWith("io.sentry.mobile.")) {
                    SentryStackFrame sentryStackFrame = new SentryStackFrame();
                    sentryStackFrame.setInApp(isInApp(className));
                    sentryStackFrame.setModule(className);
                    sentryStackFrame.setFunction(stackTraceElement.getMethodName());
                    sentryStackFrame.setFilename(stackTraceElement.getFileName());
                    if (stackTraceElement.getLineNumber() >= 0) {
                        sentryStackFrame.setLineno(Integer.valueOf(stackTraceElement.getLineNumber()));
                    }
                    sentryStackFrame.setNative(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                    arrayList.add(sentryStackFrame);
                    if (arrayList.size() >= 100) {
                        break;
                    }
                }
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public Boolean isInApp(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        for (String startsWith : this.options.getInAppIncludes()) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        for (String startsWith2 : this.options.getInAppExcludes()) {
            if (str.startsWith(startsWith2)) {
                return false;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<SentryStackFrame> getInAppCallStack(Throwable th) {
        List<SentryStackFrame> stackFrames = getStackFrames(th.getStackTrace(), false);
        if (stackFrames == null) {
            return Collections.emptyList();
        }
        List<SentryStackFrame> filterListEntries = CollectionUtils.filterListEntries(stackFrames, new SentryStackTraceFactory$$ExternalSyntheticLambda0());
        if (!filterListEntries.isEmpty()) {
            return filterListEntries;
        }
        return CollectionUtils.filterListEntries(stackFrames, new SentryStackTraceFactory$$ExternalSyntheticLambda1());
    }

    static /* synthetic */ boolean lambda$getInAppCallStack$1(SentryStackFrame sentryStackFrame) {
        String module = sentryStackFrame.getModule();
        boolean z = false;
        if (module != null && (module.startsWith("sun.") || module.startsWith("java.") || module.startsWith("android.") || module.startsWith("com.android."))) {
            z = true;
        }
        return !z;
    }

    public List<SentryStackFrame> getInAppCallStack() {
        return getInAppCallStack(new Exception());
    }
}
