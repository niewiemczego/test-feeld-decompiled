package kotlinx.coroutines.debug.internal;

import _COROUTINE.ArtificialStackFrames;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001}B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u00101\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H3022\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0001J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;J\u0011\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010>¢\u0006\u0002\u0010?J9\u0010@\u001a\b\u0012\u0004\u0012\u0002HA0;\"\b\b\u0000\u0010A*\u00020\u00012\u001e\b\u0004\u0010B\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u0002HA0CH\bJ\u0010\u0010E\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0002J\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0;J\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010I\u001a\u00020<2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;J\u000e\u0010K\u001a\u00020)2\u0006\u0010I\u001a\u00020<J.\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00040;2\u0006\u0010M\u001a\u00020)2\b\u0010N\u001a\u0004\u0018\u00010'2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J=\u0010O\u001a\u000e\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020Q0P2\u0006\u0010R\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010TJ1\u0010U\u001a\u00020Q2\u0006\u0010V\u001a\u00020Q2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00040>2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002¢\u0006\u0002\u0010WJ\u0016\u0010X\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\u0015\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020*H\u0000¢\u0006\u0002\b[J\r\u0010\\\u001a\u00020\u0014H\u0000¢\u0006\u0002\b]J\u001e\u0010^\u001a\u00020\u00142\u0006\u00108\u001a\u0002092\f\u0010_\u001a\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\u0014\u0010`\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J'\u0010b\u001a\b\u0012\u0004\u0012\u0002H302\"\u0004\b\u0000\u001032\f\u00104\u001a\b\u0012\u0004\u0012\u0002H302H\u0000¢\u0006\u0002\bcJ\u0019\u0010d\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\beJ\u0019\u0010f\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0002\bgJ%\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040;\"\b\b\u0000\u00103*\u00020i2\u0006\u0010j\u001a\u0002H3H\u0002¢\u0006\u0002\u0010kJ\b\u0010l\u001a\u00020\u0014H\u0002J\b\u0010m\u001a\u00020\u0014H\u0002J\r\u0010n\u001a\u00020\u0014H\u0000¢\u0006\u0002\boJ\u0018\u0010p\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00072\u0006\u0010M\u001a\u00020)H\u0002J\u001c\u0010q\u001a\u00020\u00142\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J(\u0010q\u001a\u00020\u00142\n\u0010a\u001a\u0006\u0012\u0002\b\u00030\u000b2\n\u00105\u001a\u0006\u0012\u0002\b\u0003022\u0006\u0010M\u001a\u00020)H\u0002J4\u0010r\u001a\u00020\u0014*\u00020*2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0t2\n\u0010u\u001a\u00060vj\u0002`w2\u0006\u0010x\u001a\u00020)H\u0002J\u0010\u0010y\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u000bH\u0002J\u0016\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u0006\u0012\u0002\b\u000302H\u0002J\u0013\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b*\u00020\u0007H\u0010J\u000f\u0010z\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0010J\u0012\u0010{\u001a\u000206*\b\u0012\u0004\u0012\u00020\u00040;H\u0002J\f\u0010|\u001a\u00020)*\u00020\u0001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b\u0012\u0004\u0012\u00020\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\t\u0010\u001d\u001a\u00020\u001eX\u0004R\u0011\u0010\u001f\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019R\t\u0010$\u001a\u00020%X\u0004R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010(\u001a\u00020)*\u00020*8BX\u0004¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u0010/\u001a\u00020\u000f*\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u0006~"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "capturedCoroutines", "", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutinesMap", "", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/Function1;", "", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "()Z", "setEnableCreationStackTraces$kotlinx_coroutines_core", "(Z)V", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "weakRefCleanerThread", "Ljava/lang/Thread;", "debugString", "", "Lkotlinx/coroutines/Job;", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "createOwner", "Lkotlin/coroutines/Continuation;", "T", "completion", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "dumpCoroutinesInfo", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfoAsJsonAndReferences", "", "()[Ljava/lang/Object;", "dumpCoroutinesInfoImpl", "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesSynchronized", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "enhanceStackTraceWithThreadDump", "info", "coroutineTrace", "enhanceStackTraceWithThreadDumpAsJson", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", "", "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "getDynamicAttach", "hierarchyToString", "job", "hierarchyToString$kotlinx_coroutines_core", "install", "install$kotlinx_coroutines_core", "printStackTrace", "frames", "probeCoroutineCompleted", "owner", "probeCoroutineCreated", "probeCoroutineCreated$kotlinx_coroutines_core", "probeCoroutineResumed", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "sanitizeStackTrace", "", "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "uninstall$kotlinx_coroutines_core", "updateRunningState", "updateState", "build", "map", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "isFinished", "realCaller", "toStackTraceFrame", "toStringRepr", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DebugProbesImpl.kt */
public final class DebugProbesImpl {
    private static final StackTraceElement ARTIFICIAL_FRAME = new ArtificialStackFrames().coroutineCreation();
    public static final DebugProbesImpl INSTANCE;
    /* access modifiers changed from: private */
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = new ConcurrentWeakMap<>(true);
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces = true;
    private static boolean ignoreCoroutinesWithEmptyContext = true;
    private static final DebugProbesImpl$Installations$kotlinx$VolatileWrapper installations$kotlinx$VolatileWrapper = new DebugProbesImpl$Installations$kotlinx$VolatileWrapper((DefaultConstructorMarker) null);
    private static boolean sanitizeStackTraces = true;
    private static final DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper sequenceNumber$kotlinx$VolatileWrapper = new DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper((DefaultConstructorMarker) null);
    private static Thread weakRefCleanerThread;

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    public final boolean isInstalled$kotlinx_coroutines_debug() {
        return DebugProbesImpl$Installations$kotlinx$VolatileWrapper.installations$FU.get(installations$kotlinx$VolatileWrapper) > 0;
    }

    private DebugProbesImpl() {
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean z) {
        sanitizeStackTraces = z;
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean z) {
        enableCreationStackTraces = z;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean z) {
        ignoreCoroutinesWithEmptyContext = z;
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            obj = Result.m983constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m989isFailureimpl(obj)) {
            obj = null;
        }
        return (Function1) obj;
    }

    public final void install$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (DebugProbesImpl$Installations$kotlinx$VolatileWrapper.installations$FU.incrementAndGet(installations$kotlinx$VolatileWrapper) <= 1) {
            startWeakRefCleanerThread();
            if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = dynamicAttach) != null) {
                function1.invoke(true);
            }
        }
    }

    public final void uninstall$kotlinx_coroutines_core() {
        Function1<Boolean, Unit> function1;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Agent was not installed".toString());
        } else if (DebugProbesImpl$Installations$kotlinx$VolatileWrapper.installations$FU.decrementAndGet(installations$kotlinx$VolatileWrapper) == 0) {
            stopWeakRefCleanerThread();
            capturedCoroutinesMap.clear();
            callerInfoCache.clear();
            if (!AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() && (function1 = dynamicAttach) != null) {
                function1.invoke(false);
            }
        }
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE, 21, (Object) null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread != null) {
            weakRefCleanerThread = null;
            thread.interrupt();
            thread.join();
        }
    }

    public final String hierarchyToString$kotlinx_coroutines_core(Job job) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            Collection arrayList = new ArrayList();
            for (Object next : getCapturedCoroutines()) {
                if (((CoroutineOwner) next).delegate.getContext().get(Job.Key) != null) {
                    arrayList.add(next);
                }
            }
            Iterable<CoroutineOwner> iterable = (List) arrayList;
            Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
            for (CoroutineOwner coroutineOwner : iterable) {
                linkedHashMap.put(JobKt.getJob(coroutineOwner.delegate.getContext()), coroutineOwner.info);
            }
            StringBuilder sb = new StringBuilder();
            INSTANCE.build(job, linkedHashMap, sb, "");
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            sb.append(str + getDebugString(job) + ", continuation is " + debugCoroutineInfoImpl.getState$kotlinx_coroutines_core() + " at line " + ((StackTraceElement) CollectionsKt.firstOrNull(debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core())) + 10);
            str = str + 9;
        } else if (!(job instanceof ScopeCoroutine)) {
            sb.append(str + getDebugString(job) + 10);
            str = str + 9;
        }
        for (Job build : job.getChildren()) {
            build(build, map, sb, str);
        }
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> function2) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfoImpl$3(function2)));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0038, code lost:
        r7 = r7.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        /*
            r15 = this;
            java.util.List r0 = r15.dumpCoroutinesInfo()
            int r1 = r0.size()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r1)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r1)
            java.util.Iterator r1 = r0.iterator()
        L_0x001b:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00ca
            java.lang.Object r5 = r1.next()
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r5 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfo) r5
            kotlin.coroutines.CoroutineContext r6 = r5.getContext()
            kotlinx.coroutines.CoroutineName$Key r7 = kotlinx.coroutines.CoroutineName.Key
            kotlin.coroutines.CoroutineContext$Key r7 = (kotlin.coroutines.CoroutineContext.Key) r7
            kotlin.coroutines.CoroutineContext$Element r7 = r6.get(r7)
            kotlinx.coroutines.CoroutineName r7 = (kotlinx.coroutines.CoroutineName) r7
            r8 = 0
            if (r7 == 0) goto L_0x0043
            java.lang.String r7 = r7.getName()
            if (r7 == 0) goto L_0x0043
            java.lang.String r7 = r15.toStringRepr(r7)
            goto L_0x0044
        L_0x0043:
            r7 = r8
        L_0x0044:
            kotlinx.coroutines.CoroutineDispatcher$Key r9 = kotlinx.coroutines.CoroutineDispatcher.Key
            kotlin.coroutines.CoroutineContext$Key r9 = (kotlin.coroutines.CoroutineContext.Key) r9
            kotlin.coroutines.CoroutineContext$Element r9 = r6.get(r9)
            kotlinx.coroutines.CoroutineDispatcher r9 = (kotlinx.coroutines.CoroutineDispatcher) r9
            if (r9 == 0) goto L_0x0055
            java.lang.String r9 = r15.toStringRepr(r9)
            goto L_0x0056
        L_0x0055:
            r9 = r8
        L_0x0056:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "\n                {\n                    \"name\": "
            java.lang.StringBuilder r10 = r10.append(r11)
            java.lang.StringBuilder r7 = r10.append(r7)
            java.lang.String r10 = ",\n                    \"id\": "
            java.lang.StringBuilder r7 = r7.append(r10)
            kotlinx.coroutines.CoroutineId$Key r10 = kotlinx.coroutines.CoroutineId.Key
            kotlin.coroutines.CoroutineContext$Key r10 = (kotlin.coroutines.CoroutineContext.Key) r10
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r10)
            kotlinx.coroutines.CoroutineId r6 = (kotlinx.coroutines.CoroutineId) r6
            if (r6 == 0) goto L_0x007f
            long r10 = r6.getId()
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
        L_0x007f:
            java.lang.StringBuilder r6 = r7.append(r8)
            java.lang.String r7 = ",\n                    \"dispatcher\": "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r9)
            java.lang.String r7 = ",\n                    \"sequenceNumber\": "
            java.lang.StringBuilder r6 = r6.append(r7)
            long r7 = r5.getSequenceNumber()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = ",\n                    \"state\": \""
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = r5.getState()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "\"\n                } \n                "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r6 = kotlin.text.StringsKt.trimIndent(r6)
            r4.add(r6)
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r6 = r5.getLastObservedFrame()
            r3.add(r6)
            java.lang.Thread r5 = r5.getLastObservedThread()
            r2.add(r5)
            goto L_0x001b
        L_0x00ca:
            r1 = 4
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 91
            java.lang.StringBuilder r5 = r5.append(r6)
            r6 = r4
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r14 = 0
            java.lang.String r4 = kotlin.collections.CollectionsKt.joinToString$default(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            java.lang.StringBuilder r4 = r5.append(r4)
            r5 = 93
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r1[r5] = r4
            r4 = 1
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.Thread[] r6 = new java.lang.Thread[r5]
            java.lang.Object[] r2 = r2.toArray(r6)
            r1[r4] = r2
            r2 = 2
            java.util.Collection r3 = (java.util.Collection) r3
            kotlin.coroutines.jvm.internal.CoroutineStackFrame[] r4 = new kotlin.coroutines.jvm.internal.CoroutineStackFrame[r5]
            java.lang.Object[] r3 = r3.toArray(r4)
            r1[r2] = r3
            r2 = 3
            java.util.Collection r0 = (java.util.Collection) r0
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo[] r3 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo[r5]
            java.lang.Object[] r0 = r0.toArray(r3)
            r1[r2] = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoAsJsonAndReferences():java.lang.Object[]");
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo debugCoroutineInfo) {
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(debugCoroutineInfo, debugCoroutineInfo.lastObservedStackTrace());
        List arrayList = new ArrayList();
        for (StackTraceElement next : enhanceStackTraceWithThreadDump) {
            StringBuilder append = new StringBuilder().append("\n                {\n                    \"declaringClass\": \"").append(next.getClassName()).append("\",\n                    \"methodName\": \"").append(next.getMethodName()).append("\",\n                    \"fileName\": ");
            String fileName = next.getFileName();
            arrayList.add(StringsKt.trimIndent(append.append(fileName != null ? toStringRepr(fileName) : null).append(",\n                    \"lineNumber\": ").append(next.getLineNumber()).append("\n                }\n                ").toString()));
        }
        return '[' + CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']';
    }

    private final String toStringRepr(Object obj) {
        return DebugProbesImplKt.repr(obj.toString());
    }

    public final void dumpCoroutines(PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    private final void dumpCoroutinesSynchronized(PrintStream printStream) {
        String str;
        if (isInstalled$kotlinx_coroutines_debug()) {
            printStream.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));
            for (CoroutineOwner coroutineOwner : SequencesKt.sortedWith(SequencesKt.filter(CollectionsKt.asSequence(getCapturedCoroutines()), DebugProbesImpl$dumpCoroutinesSynchronized$2.INSTANCE), new DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1())) {
                DebugCoroutineInfoImpl debugCoroutineInfoImpl = coroutineOwner.info;
                List<StackTraceElement> lastObservedStackTrace$kotlinx_coroutines_core = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
                DebugProbesImpl debugProbesImpl = INSTANCE;
                List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl = debugProbesImpl.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfoImpl.getState$kotlinx_coroutines_core(), debugCoroutineInfoImpl.lastObservedThread, lastObservedStackTrace$kotlinx_coroutines_core);
                if (!Intrinsics.areEqual((Object) debugCoroutineInfoImpl.getState$kotlinx_coroutines_core(), (Object) DebugCoroutineInfoImplKt.RUNNING) || enhanceStackTraceWithThreadDumpImpl != lastObservedStackTrace$kotlinx_coroutines_core) {
                    str = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core();
                } else {
                    str = debugCoroutineInfoImpl.getState$kotlinx_coroutines_core() + " (Last suspension stacktrace, not an actual stacktrace)";
                }
                printStream.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + str);
                if (lastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                    printStream.print("\n\tat " + ARTIFICIAL_FRAME);
                    debugProbesImpl.printStackTrace(printStream, debugCoroutineInfoImpl.getCreationStackTrace());
                } else {
                    debugProbesImpl.printStackTrace(printStream, enhanceStackTraceWithThreadDumpImpl);
                }
            }
            return;
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stackTraceElement : list) {
            printStream.print("\n\tat " + stackTraceElement);
        }
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo debugCoroutineInfo, List<StackTraceElement> list) {
        return enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.Companion;
            DebugProbesImpl debugProbesImpl = this;
            obj = Result.m983constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m983constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m989isFailureimpl(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) "resumeWith") && Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) "ContinuationImpl.kt")) {
                break;
            }
            i++;
        }
        Pair<Integer, Integer> findContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, list);
        int intValue = findContinuationStartIndex.component1().intValue();
        int intValue2 = findContinuationStartIndex.component2().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i) - intValue) - 1) - intValue2);
        int i2 = i - intValue2;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(stackTraceElementArr[i3]);
        }
        int size = list.size();
        for (int i4 = intValue + 1; i4 < size; i4++) {
            arrayList.add(list.get(i4));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i2 = 0; i2 < 3; i2++) {
            int findIndexOfFrame = INSTANCE.findIndexOfFrame((i - 1) - i2, stackTraceElementArr, list);
            if (findIndexOfFrame != -1) {
                return TuplesKt.to(Integer.valueOf(findIndexOfFrame), Integer.valueOf(i2));
            }
        }
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int i, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull((T[]) stackTraceElementArr, i);
        if (stackTraceElement == null) {
            return -1;
        }
        int i2 = 0;
        for (StackTraceElement next : list) {
            if (Intrinsics.areEqual((Object) next.getFileName(), (Object) stackTraceElement.getFileName()) && Intrinsics.areEqual((Object) next.getClassName(), (Object) stackTraceElement.getClassName()) && Intrinsics.areEqual((Object) next.getMethodName(), (Object) stackTraceElement.getMethodName())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    private final void updateState(Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            if (ignoreCoroutinesWithEmptyContext && continuation.getContext() == EmptyCoroutineContext.INSTANCE) {
                return;
            }
            if (Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING)) {
                CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
                if (coroutineStackFrame != null) {
                    updateRunningState(coroutineStackFrame, str);
                    return;
                }
                return;
            }
            CoroutineOwner<?> owner = owner(continuation);
            if (owner != null) {
                updateState(owner, continuation, str);
            }
        }
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String str) {
        boolean z;
        if (isInstalled$kotlinx_coroutines_debug()) {
            ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = callerInfoCache;
            DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
            if (remove != null) {
                z = false;
            } else {
                CoroutineOwner<?> owner = owner(coroutineStackFrame);
                if (owner != null && (remove = owner.info) != null) {
                    z = true;
                    CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                    CoroutineStackFrame realCaller = lastObservedFrame$kotlinx_coroutines_core != null ? realCaller(lastObservedFrame$kotlinx_coroutines_core) : null;
                    if (realCaller != null) {
                        concurrentWeakMap.remove(realCaller);
                    }
                } else {
                    return;
                }
            }
            Intrinsics.checkNotNull(coroutineStackFrame, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame, z);
            CoroutineStackFrame realCaller2 = realCaller(coroutineStackFrame);
            if (realCaller2 != null) {
                concurrentWeakMap.put(realCaller2, remove);
            }
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation, true);
        }
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> continuation) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return continuation;
        }
        if ((ignoreCoroutinesWithEmptyContext && continuation.getContext() == EmptyCoroutineContext.INSTANCE) || owner((Continuation<?>) continuation) != null) {
            return continuation;
        }
        return createOwner(continuation, enableCreationStackTraces ? toStackTraceFrame(sanitizeStackTrace(new Exception())) : null);
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, DebugProbesImpl$SequenceNumber$kotlinx$VolatileWrapper.sequenceNumber$FU.incrementAndGet(sequenceNumber$kotlinx$VolatileWrapper)));
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, true);
        if (!isInstalled$kotlinx_coroutines_debug()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    /* access modifiers changed from: private */
    public final void probeCoroutineCompleted(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame realCaller;
        capturedCoroutinesMap.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core != null && (realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) != null) {
            callerInfoCache.remove(realCaller);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001d\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\fX\u0005¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DebugProbesImpl.kt */
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        public final Continuation<T> delegate;
        public final DebugCoroutineInfoImpl info;

        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfoImpl debugCoroutineInfoImpl) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom$kotlinx_coroutines_core();
        }

        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getCallerFrame();
            }
            return null;
        }

        public StackTraceElement getStackTraceElement() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getStackTraceElement();
            }
            return null;
        }

        public void resumeWith(Object obj) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(obj);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T t) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (Intrinsics.areEqual((Object) stackTrace[length2].getClassName(), (Object) "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i = length2;
                    break;
                } else if (i2 < 0) {
                    break;
                } else {
                    length2 = i2;
                }
            }
        }
        int i3 = i + 1;
        if (!sanitizeStackTraces) {
            int i4 = length - i3;
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(stackTrace[i5 + i3]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i3) + 1);
        while (i3 < length) {
            if (isInternalMethod(stackTrace[i3])) {
                Collection collection = arrayList2;
                collection.add(stackTrace[i3]);
                int i6 = i3 + 1;
                while (i6 < length && isInternalMethod(stackTrace[i6])) {
                    i6++;
                }
                int i7 = i6 - 1;
                int i8 = i7;
                while (i8 > i3 && stackTrace[i8].getFileName() == null) {
                    i8--;
                }
                if (i8 > i3 && i8 < i7) {
                    collection.add(stackTrace[i8]);
                }
                collection.add(stackTrace[i7]);
                i3 = i6;
            } else {
                arrayList2.add(stackTrace[i3]);
                i3++;
            }
        }
        return arrayList2;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1()));
        }
        throw new IllegalStateException("Debug probes are not installed".toString());
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return new StackTraceFrame(stackTraceFrame, ARTIFICIAL_FRAME);
    }
}
