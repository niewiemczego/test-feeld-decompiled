package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {
    static final String TAG = "Trace";
    private static Method sAsyncTraceBeginMethod;
    private static Method sAsyncTraceEndMethod;
    private static boolean sHasAppTracingEnabled;
    private static Method sIsTagEnabledMethod;
    private static Method sTraceCounterMethod;
    private static long sTraceTagApp;

    public static boolean isEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.isEnabled();
        }
        return isEnabledFallback();
    }

    public static void forceEnableAppTracing() {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 31) {
            try {
                if (!sHasAppTracingEnabled) {
                    sHasAppTracingEnabled = true;
                    android.os.Trace.class.getMethod("setAppTracingAllowed", new Class[]{Boolean.TYPE}).invoke((Object) null, new Object[]{true});
                }
            } catch (Exception e) {
                handleException("setAppTracingAllowed", e);
            }
        }
    }

    public static void beginSection(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.beginSection(str);
        }
    }

    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            TraceApi18Impl.endSection();
        }
    }

    public static void beginAsyncSection(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(str, i);
        } else {
            beginAsyncSectionFallback(str, i);
        }
    }

    public static void endAsyncSection(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(str, i);
        } else {
            endAsyncSectionFallback(str, i);
        }
    }

    public static void setCounter(String str, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(str, i);
        } else {
            setCounterFallback(str, i);
        }
    }

    private static boolean isEnabledFallback() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sIsTagEnabledMethod == null) {
                    sTraceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                    sIsTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                }
                return ((Boolean) sIsTagEnabledMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp)})).booleanValue();
            } catch (Exception e) {
                handleException("isTagEnabled", e);
            }
        }
        return false;
    }

    private static void beginAsyncSectionFallback(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sAsyncTraceBeginMethod == null) {
                    sAsyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sAsyncTraceBeginMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i)});
            } catch (Exception e) {
                handleException("asyncTraceBegin", e);
            }
        }
    }

    private static void endAsyncSectionFallback(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sAsyncTraceEndMethod == null) {
                    sAsyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sAsyncTraceEndMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i)});
            } catch (Exception e) {
                handleException("asyncTraceEnd", e);
            }
        }
    }

    private static void setCounterFallback(String str, int i) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (sTraceCounterMethod == null) {
                    sTraceCounterMethod = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                sTraceCounterMethod.invoke((Object) null, new Object[]{Long.valueOf(sTraceTagApp), str, Integer.valueOf(i)});
            } catch (Exception e) {
                handleException("traceCounter", e);
            }
        }
    }

    private static void handleException(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v(TAG, "Unable to call " + str + " via reflection", exc);
    }

    private Trace() {
    }
}
