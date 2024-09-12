package kotlinx.coroutines.channels;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.primitives.Longs;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\"\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004Þ\u0001ß\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\bWJ\u001e\u0010X\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\b\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\b\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\blJ\u0012\u0010m\u001a\u00020\u00072\b\b\u0002\u0010n\u001a\u00020\u0010H\u0002J\b\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\b\u0012\u0004\u0012\u00028\u00000yH\u0002J\u0016\u0010z\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020\u0007H\u0002J\b\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\f\u0010g\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\b\u0010\u001a\u00020\u0007H\u0014J\"\u0010\u0001\u001a\u00020\u00072\u0014\u0010\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0\u0001H\u0002ø\u0001\u0000J\u0019\u0010\u0001\u001a\u00020\u00072\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002J$\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\b\u000309H\u0002¢\u0006\u0003\u0010\u0001J\u001c\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J(\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u00002\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0001H\u0002¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u0001\u001a\u00020\u0007H\u0014J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J!\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J\u0013\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J%\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JD\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0010H@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0002\u0010\u0001\u001a\u0003H\u0001\"\u0005\b\u0001\u0010\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\f2$\u0010\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012X\b\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0005\u0012\u0003H\u000108H\b¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\b\u0010\u0001\u001a\u00030¨\u00012#\u0010\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\bJ2\u0010©\u0001\u001a\u00028\u00002\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\b\u0003092\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\f\u0010Y\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010­\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001f\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0001\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0006\b¯\u0001\u0010\u0001J\u0002\u0010°\u0001\u001a\u0003H\u0001\"\u0005\b\u0001\u0010\u00012\u0007\u0010\u0001\u001a\u00028\u00002\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0005\u0012\u0003H\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u00010¤\u00012o\b\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\b:\u0012\t\b;\u0012\u0005\b\b(´\u0001\u0012\u0005\u0012\u0003H\u00010³\u0001H\b¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\b\u0010\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\b¢\u0006\u0003\u0010·\u0001J;\u0010¸\u0001\u001a\u00020\u00072\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\b»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\bÀ\u0001J!\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J*\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J(\u0010É\u0001\u001a\u00020\u001c2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J5\u0010Ê\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002J5\u0010Ë\u0001\u001a\u0004\u0018\u00010\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\fH\u0002JK\u0010Ì\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001JK\u0010Ï\u0001\u001a\u00020\u00042\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001J\u0012\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Ó\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\bÔ\u0001J$\u0010Õ\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ö\u0001\u001a\u00020\u0007*\u00030¨\u00012\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ú\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Û\u0001\u001a\u00020\u001c*\u00020\f2\u0007\u0010\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Ü\u0001J#\u0010Ý\u0001\u001a\u00020\u001c*\u00020\f2\f\u0010s\u001a\b\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004R\t\u0010\r\u001a\u00020\u000eX\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b!\u0010\u001e\u001a\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0004¢\u0006\f\u0012\u0004\b$\u0010\u001e\u001a\u0004\b#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000'8VX\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010*R)\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0'8VX\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b-\u0010\u001e\u001a\u0004\b.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0004¢\u0006\f\u0012\u0004\b0\u0010\u001e\u001a\u0004\b1\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0004¢\u0006\f\u0012\u0004\b4\u0010\u001e\u001a\u0004\b5\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\b\u000309¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(=\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0004¢\u0006\b\n\u0000\u0012\u0004\b@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\t\u0010D\u001a\u00020\u000eX\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0004R\t\u0010J\u001a\u00020\u000eX\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010N\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006à\u0001"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BufferedChannel.kt */
public class BufferedChannel<E> implements Channel<E> {
    private static final AtomicReferenceFieldUpdater _closeCause$FU;
    private static final AtomicLongFieldUpdater bufferEnd$FU;
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU;
    private static final AtomicReferenceFieldUpdater closeHandler$FU;
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU;
    /* access modifiers changed from: private */
    public static final AtomicReferenceFieldUpdater receiveSegment$FU;
    /* access modifiers changed from: private */
    public static final AtomicLongFieldUpdater receivers$FU;
    /* access modifiers changed from: private */
    public static final AtomicReferenceFieldUpdater sendSegment$FU;
    /* access modifiers changed from: private */
    public static final AtomicLongFieldUpdater sendersAndCloseStatus$FU;
    @Volatile
    private volatile Object _closeCause;
    @Volatile
    private volatile long bufferEnd;
    @Volatile
    private volatile Object bufferEndSegment;
    private final int capacity;
    @Volatile
    private volatile Object closeHandler;
    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    @Volatile
    private volatile Object receiveSegment;
    @Volatile
    private volatile long receivers;
    @Volatile
    private volatile Object sendSegment;
    @Volatile
    private volatile long sendersAndCloseStatus;

    static {
        Class<BufferedChannel> cls = BufferedChannel.class;
        sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(cls, "sendersAndCloseStatus");
        receivers$FU = AtomicLongFieldUpdater.newUpdater(cls, "receivers");
        bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(cls, "bufferEnd");
        completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(cls, "completedExpandBuffersAndPauseFlag");
        sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "sendSegment");
        receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "receiveSegment");
        bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "bufferEndSegment");
        _closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "_closeCause");
        closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "closeHandler");
    }

    private final Object getAndUpdate$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function1, Object obj) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, obj, obj2, function1.invoke(obj2)));
        return obj2;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    private static /* synthetic */ void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function1, Object obj) {
        while (true) {
            function1.invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function1, Object obj) {
        while (true) {
            function1.invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function1, Object obj) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.invoke(Long.valueOf(j)).longValue()));
    }

    /* access modifiers changed from: protected */
    public boolean isConflatedDropOldest() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onClosedIdempotent() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveDequeued() {
    }

    /* access modifiers changed from: protected */
    public void onReceiveEnqueued() {
    }

    public Object receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    /* renamed from: receiveCatching-JP2dKIU  reason: not valid java name */
    public Object m2512receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m2510receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    public Object send(E e, Continuation<? super Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public BufferedChannel(int i, Function1<? super E, Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i >= 0) {
            this.bufferEnd = BufferedChannelKt.initialBufferEnd(i);
            this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
            ChannelSegment channelSegment = new ChannelSegment(0, (ChannelSegment) null, this, 3);
            this.sendSegment = channelSegment;
            this.receiveSegment = channelSegment;
            if (isRendezvousOrUnlimited()) {
                channelSegment = BufferedChannelKt.NULL_SEGMENT;
                Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            }
            this.bufferEndSegment = channelSegment;
            this.onUndeliveredElementReceiveCancellationConstructor = function1 != null ? new BufferedChannel$onUndeliveredElementReceiveCancellationConstructor$1$1(this) : null;
            this._closeCause = BufferedChannelKt.NO_CLOSE_CAUSE;
            return;
        }
        throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", imports = {}))
    public boolean offer(E e) {
        return Channel.DefaultImpls.offer(this, e);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    public Object receiveOrNull(Continuation<? super E> continuation) {
        return Channel.DefaultImpls.receiveOrNull(this, continuation);
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$FU.get(this) & 1152921504606846975L;
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$FU.get(this);
    }

    private final long getBufferEndCounter() {
        return bufferEnd$FU.get(this);
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == Long.MAX_VALUE;
    }

    static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Unit> continuation) {
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean access$isClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j2) {
                ChannelSegment access$findSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    Object onClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend;
                    }
                }
            }
            int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i, e, j, (Object) null, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            } else if (access$updateCellSend == 1) {
                break;
            } else if (access$updateCellSend != 2) {
                if (access$updateCellSend == 3) {
                    Object sendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i, e, j, continuation);
                    if (sendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return sendOnNoWaiterSuspend;
                    }
                } else if (access$updateCellSend == 4) {
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object onClosedSend2 = bufferedChannel.onClosedSend(e, continuation);
                    if (onClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return onClosedSend2;
                    }
                } else if (access$updateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
            } else if (access$isClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object onClosedSend3 = bufferedChannel.onClosedSend(e, continuation);
                if (onClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return onClosedSend3;
                }
            } else if (DebugKt.getASSERTIONS_ENABLED()) {
                throw new AssertionError();
            }
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void prepareSenderForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E e, CancellableContinuation<? super Unit> cancellableContinuation) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, cancellableContinuation.getContext());
        }
        Continuation continuation = cancellableContinuation;
        Throwable sendException = getSendException();
        if (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) {
            sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation);
        }
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return kotlinx.coroutines.channels.ChannelResult.Companion.m2535closedJP2dKIU(getSendException());
     */
    /* renamed from: trySend-JP2dKIU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m2514trySendJP2dKIU(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = sendersAndCloseStatus$FU
            long r0 = r0.get(r14)
            boolean r0 = r14.shouldSendSuspend(r0)
            if (r0 == 0) goto L_0x0013
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m2536failurePtdJZtk()
            return r15
        L_0x0013:
            kotlinx.coroutines.internal.Symbol r8 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$FU
            java.lang.Object r0 = r0.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x0021:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$FU
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = r14.isClosedForSend0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r9 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r9 % r3
            int r12 = (int) r3
            long r3 = r0.id
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0050
            kotlinx.coroutines.channels.ChannelSegment r1 = r14.findSegmentSend(r1, r0)
            if (r1 != 0) goto L_0x004e
            if (r11 == 0) goto L_0x0021
            goto L_0x0091
        L_0x004e:
            r13 = r1
            goto L_0x0051
        L_0x0050:
            r13 = r0
        L_0x0051:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00b3
            r1 = 1
            if (r0 == r1) goto L_0x00b6
            r1 = 2
            if (r0 == r1) goto L_0x008c
            r1 = 3
            if (r0 == r1) goto L_0x007f
            r1 = 4
            if (r0 == r1) goto L_0x0073
            r1 = 5
            if (r0 == r1) goto L_0x006e
            goto L_0x0071
        L_0x006e:
            r13.cleanPrev()
        L_0x0071:
            r0 = r13
            goto L_0x0021
        L_0x0073:
            long r0 = r14.getReceiversCounter$kotlinx_coroutines_core()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L_0x0091
            r13.cleanPrev()
            goto L_0x0091
        L_0x007f:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x008c:
            if (r11 == 0) goto L_0x009c
            r13.onSlotCleaned()
        L_0x0091:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r0 = r14.getSendException()
            java.lang.Object r15 = r15.m2535closedJP2dKIU(r0)
            goto L_0x00be
        L_0x009c:
            boolean r15 = r8 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x00a3
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8
            goto L_0x00a4
        L_0x00a3:
            r8 = 0
        L_0x00a4:
            if (r8 == 0) goto L_0x00a9
            r14.prepareSenderForSuspension(r8, r13, r12)
        L_0x00a9:
            r13.onSlotCleaned()
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r15 = r15.m2536failurePtdJZtk()
            goto L_0x00be
        L_0x00b3:
            r13.cleanPrev()
        L_0x00b6:
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.Object r15 = r15.m2537successJP2dKIU(r0)
        L_0x00be:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m2514trySendJP2dKIU(java.lang.Object):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private static final class SendBroadcast implements Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        public void invokeOnCancellation(Segment<?> segment, int i) {
            this.$$delegate_0.invokeOnCancellation(segment, i);
        }

        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.cont = cancellableContinuation;
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        Function4 function42;
        ChannelSegment channelSegment;
        BufferedChannel bufferedChannel2 = bufferedChannel;
        Object obj4 = obj2;
        if (obj3 == null) {
            if ((i & 32) != 0) {
                function42 = BufferedChannel$sendImpl$1.INSTANCE;
            } else {
                function42 = function4;
            }
            ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$FU.get(bufferedChannel2);
            while (true) {
                long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(bufferedChannel2);
                long j = andIncrement & 1152921504606846975L;
                boolean access$isClosedForSend0 = bufferedChannel2.isClosedForSend0(andIncrement);
                long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j2) {
                    ChannelSegment access$findSegmentSend = bufferedChannel2.findSegmentSend(j2, channelSegment2);
                    if (access$findSegmentSend != null) {
                        channelSegment = access$findSegmentSend;
                    } else if (access$isClosedForSend0) {
                        return function02.invoke();
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                int access$updateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, obj, j, obj2, access$isClosedForSend0);
                if (access$updateCellSend == 0) {
                    channelSegment.cleanPrev();
                    return function0.invoke();
                } else if (access$updateCellSend == 1) {
                    return function0.invoke();
                } else {
                    if (access$updateCellSend != 2) {
                        if (access$updateCellSend == 3) {
                            return function42.invoke(channelSegment, Integer.valueOf(i2), obj, Long.valueOf(j));
                        } else if (access$updateCellSend != 4) {
                            if (access$updateCellSend == 5) {
                                channelSegment.cleanPrev();
                            }
                            channelSegment2 = channelSegment;
                        } else {
                            if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                                channelSegment.cleanPrev();
                            }
                            return function02.invoke();
                        }
                    } else if (access$isClosedForSend0) {
                        channelSegment.onSlotCleaned();
                        return function02.invoke();
                    } else {
                        Waiter waiter = obj4 instanceof Waiter ? (Waiter) obj4 : null;
                        if (waiter != null) {
                            bufferedChannel2.prepareSenderForSuspension(waiter, channelSegment, i2);
                        }
                        return function2.invoke(channelSegment, Integer.valueOf(i2));
                    }
                }
            }
        } else {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
    }

    /* access modifiers changed from: protected */
    public final <R> R sendImpl(E e, Object obj, Function0<? extends R> function0, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> function2, Function0<? extends R> function02, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> function4) {
        ChannelSegment channelSegment;
        Object obj2 = obj;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
            long j2 = j / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (j % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j2) {
                ChannelSegment access$findSegmentSend = findSegmentSend(j2, channelSegment2);
                if (access$findSegmentSend != null) {
                    channelSegment = access$findSegmentSend;
                } else if (access$isClosedForSend0) {
                    return function02.invoke();
                }
            } else {
                channelSegment = channelSegment2;
            }
            int access$updateCellSend = updateCellSend(channelSegment, i, e, j, obj, access$isClosedForSend0);
            if (access$updateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.invoke();
            } else if (access$updateCellSend == 1) {
                return function0.invoke();
            } else {
                if (access$updateCellSend != 2) {
                    if (access$updateCellSend == 3) {
                        return function4.invoke(channelSegment, Integer.valueOf(i), e, Long.valueOf(j));
                    } else if (access$updateCellSend != 4) {
                        if (access$updateCellSend == 5) {
                            channelSegment.cleanPrev();
                        }
                        channelSegment2 = channelSegment;
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        return function02.invoke();
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function02.invoke();
                } else {
                    Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                    if (waiter != null) {
                        prepareSenderForSuspension(waiter, channelSegment, i);
                    }
                    return function2.invoke(channelSegment, Integer.valueOf(i));
                }
            }
        }
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> channelSegment, int i, E e, long j, Waiter waiter, Function0<Unit> function0, Function0<Unit> function02) {
        ChannelSegment channelSegment2;
        Waiter waiter2 = waiter;
        int access$updateCellSend = updateCellSend(channelSegment, i, e, j, waiter, false);
        if (access$updateCellSend == 0) {
            ChannelSegment<E> channelSegment3 = channelSegment;
            channelSegment.cleanPrev();
            function0.invoke();
        } else if (access$updateCellSend == 1) {
            function0.invoke();
        } else if (access$updateCellSend == 2) {
            prepareSenderForSuspension(waiter2, channelSegment, i);
        } else if (access$updateCellSend == 4) {
            if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            function02.invoke();
        } else if (access$updateCellSend == 5) {
            channelSegment.cleanPrev();
            ChannelSegment channelSegment4 = (ChannelSegment) sendSegment$FU.get(this);
            while (true) {
                long andIncrement = sendersAndCloseStatus$FU.getAndIncrement(this);
                long j2 = andIncrement & 1152921504606846975L;
                boolean access$isClosedForSend0 = isClosedForSend0(andIncrement);
                long j3 = j2 / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (j2 % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment4.id != j3) {
                    ChannelSegment access$findSegmentSend = findSegmentSend(j3, channelSegment4);
                    if (access$findSegmentSend != null) {
                        channelSegment2 = access$findSegmentSend;
                    } else if (access$isClosedForSend0) {
                        function02.invoke();
                        return;
                    }
                } else {
                    channelSegment2 = channelSegment4;
                }
                ChannelSegment channelSegment5 = channelSegment2;
                int i3 = i2;
                int access$updateCellSend2 = updateCellSend(channelSegment2, i2, e, j2, waiter, access$isClosedForSend0);
                if (access$updateCellSend2 == 0) {
                    channelSegment5.cleanPrev();
                    function0.invoke();
                    return;
                } else if (access$updateCellSend2 == 1) {
                    function0.invoke();
                    return;
                } else if (access$updateCellSend2 != 2) {
                    if (access$updateCellSend2 == 3) {
                        throw new IllegalStateException("unexpected".toString());
                    } else if (access$updateCellSend2 != 4) {
                        if (access$updateCellSend2 == 5) {
                            channelSegment5.cleanPrev();
                        }
                        channelSegment4 = channelSegment5;
                    } else {
                        if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment5.cleanPrev();
                        }
                        function02.invoke();
                        return;
                    }
                } else if (access$isClosedForSend0) {
                    channelSegment5.onSlotCleaned();
                    function02.invoke();
                    return;
                } else {
                    if (!(waiter2 instanceof Waiter)) {
                        waiter2 = null;
                    }
                    if (waiter2 != null) {
                        prepareSenderForSuspension(waiter2, channelSegment5, i3);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
        } else {
            throw new IllegalStateException("unexpected".toString());
        }
    }

    /* access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        channelSegment.storeElement$kotlinx_coroutines_core(i, e);
        if (z) {
            return updateCellSendSlow(channelSegment, i, e, j, obj, z);
        }
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(j)) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (obj == null) {
                return 3;
            } else {
                if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof Waiter) {
            channelSegment.cleanElement$kotlinx_coroutines_core(i);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment.onCancelledRequest(i, true);
            }
            return 5;
        }
        return updateCellSendSlow(channelSegment, i, e, j, obj, z);
    }

    private final int updateCellSendSlow(ChannelSegment<E> channelSegment, int i, E e, long j, Object obj, boolean z) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(j) || z) {
                    if (z) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            channelSegment.onCancelledRequest(i, false);
                            return 4;
                        }
                    } else if (obj == null) {
                        return 3;
                    } else {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, obj)) {
                            return 2;
                        }
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, (Object) null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                return 5;
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                completeCloseOrCancel();
                return 4;
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!((state$kotlinx_coroutines_core instanceof Waiter) || (state$kotlinx_coroutines_core instanceof WaiterEB))) {
                        throw new AssertionError();
                    }
                }
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                }
                if (tryResumeReceiver(state$kotlinx_coroutines_core, e)) {
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                    onReceiveDequeued();
                    return 0;
                }
                if (channelSegment.getAndSetState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                    channelSegment.onCancelledRequest(i, true);
                }
                return 5;
            }
        }
    }

    private final boolean shouldSendSuspend(long j) {
        if (isClosedForSend0(j)) {
            return false;
        }
        return !bufferOrRendezvousSend(j & 1152921504606846975L);
    }

    private final boolean bufferOrRendezvousSend(long j) {
        return j < getBufferEndCounter() || j < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        Function1<Throwable, Unit> function1 = null;
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            ReceiveCatching receiveCatching = (ReceiveCatching) obj;
            CancellableContinuation cancellableContinuation = receiveCatching.cont;
            ChannelResult r2 = ChannelResult.m2522boximpl(ChannelResult.Companion.m2537successJP2dKIU(e));
            Function1<E, Unit> function12 = this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, receiveCatching.cont.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, r2, function1);
        } else if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        } else if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation2 = (CancellableContinuation) obj;
            Function1<E, Unit> function13 = this.onUndeliveredElement;
            if (function13 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function13, e, cancellableContinuation2.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation2, e, function1);
        } else {
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
    }

    static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, (Object) null);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                throw new IllegalStateException("unexpected".toString());
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation);
            } else {
                channelSegment.cleanPrev();
                return access$updateCellReceive;
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* access modifiers changed from: private */
    public final void prepareReceiverForSuspension(Waiter waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        waiter.invokeOnCancellation(channelSegment, i);
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object m2510receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r14, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r15) {
        /*
            boolean r0 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatching$1
            r0.<init>(r14, r15)
        L_0x0019:
            r6 = r0
            java.lang.Object r15 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r15)
            kotlinx.coroutines.channels.ChannelResult r15 = (kotlinx.coroutines.channels.ChannelResult) r15
            java.lang.Object r14 = r15.m2534unboximpl()
            goto L_0x00b9
        L_0x0032:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = receiveSegment$FU
            java.lang.Object r1 = r1.get(r14)
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1
        L_0x0048:
            boolean r3 = r14.isClosedForReceive()
            if (r3 == 0) goto L_0x005a
            kotlinx.coroutines.channels.ChannelResult$Companion r15 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Throwable r14 = r14.getCloseCause()
            java.lang.Object r14 = r15.m2535closedJP2dKIU(r14)
            goto L_0x00b9
        L_0x005a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = receivers$FU
            long r4 = r3.getAndIncrement(r14)
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r3
            long r7 = r4 / r7
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.id
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x007c
            kotlinx.coroutines.channels.ChannelSegment r7 = r14.findSegmentReceive(r7, r1)
            if (r7 != 0) goto L_0x007a
            goto L_0x0048
        L_0x007a:
            r13 = r7
            goto L_0x007d
        L_0x007c:
            r13 = r1
        L_0x007d:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = r7.updateCellReceive(r8, r9, r10, r12)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND
            if (r1 == r7) goto L_0x00ba
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED
            if (r1 != r7) goto L_0x009f
            long r7 = r14.getSendersCounter$kotlinx_coroutines_core()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x009d
            r13.cleanPrev()
        L_0x009d:
            r1 = r13
            goto L_0x0048
        L_0x009f:
            kotlinx.coroutines.internal.Symbol r15 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER
            if (r1 != r15) goto L_0x00b0
            r6.label = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.m2511receiveCatchingOnNoWaiterSuspendGKJJFZk(r2, r3, r4, r6)
            if (r14 != r0) goto L_0x00b9
            return r0
        L_0x00b0:
            r13.cleanPrev()
            kotlinx.coroutines.channels.ChannelResult$Companion r14 = kotlinx.coroutines.channels.ChannelResult.Companion
            java.lang.Object r14 = r14.m2537successJP2dKIU(r1)
        L_0x00b9:
            return r14
        L_0x00ba:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m2510receiveCatchingJP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v3, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r8v4, types: [kotlinx.coroutines.Waiter] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v9 */
    /* JADX WARNING: type inference failed for: r8v10 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m2511receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> r17, int r18, long r19, kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r21) {
        /*
            r16 = this;
            r7 = r16
            r0 = r17
            r8 = r18
            r9 = r19
            r1 = r21
            boolean r2 = r1 instanceof kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            if (r2 == 0) goto L_0x001e
            r2 = r1
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = (kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001e
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0023
        L_0x001e:
            kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 r2 = new kotlinx.coroutines.channels.BufferedChannel$receiveCatchingOnNoWaiterSuspend$1
            r2.<init>(r7, r1)
        L_0x0023:
            java.lang.Object r1 = r2.result
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r4 = 1
            if (r3 == 0) goto L_0x0049
            if (r3 != r4) goto L_0x0041
            long r3 = r2.J$0
            int r0 = r2.I$0
            java.lang.Object r0 = r2.L$1
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            java.lang.Object r0 = r2.L$0
            kotlinx.coroutines.channels.BufferedChannel r0 = (kotlinx.coroutines.channels.BufferedChannel) r0
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0160
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r1)
            r2.L$0 = r7
            r2.L$1 = r0
            r2.I$0 = r8
            r2.J$0 = r9
            r2.label = r4
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r12)
            kotlinx.coroutines.CancellableContinuationImpl r13 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r1)
            kotlinx.coroutines.channels.ReceiveCatching r14 = new kotlinx.coroutines.channels.ReceiveCatching     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13, r1)     // Catch:{ all -> 0x0167 }
            r14.<init>(r13)     // Catch:{ all -> 0x0167 }
            r6 = r14
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x0167 }
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0167 }
            if (r1 != r2) goto L_0x0087
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14     // Catch:{ all -> 0x0167 }
            r7.prepareReceiverForSuspension(r14, r0, r8)     // Catch:{ all -> 0x0167 }
            goto L_0x0150
        L_0x0087:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0167 }
            r8 = 0
            if (r1 != r2) goto L_0x0136
            long r1 = r16.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0167 }
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0099
            r17.cleanPrev()     // Catch:{ all -> 0x0167 }
        L_0x0099:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$FU     // Catch:{ all -> 0x0167 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0     // Catch:{ all -> 0x0167 }
        L_0x00a3:
            boolean r1 = r16.isClosedForReceive()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x00b1
            r0 = r13
            kotlinx.coroutines.CancellableContinuation r0 = (kotlinx.coroutines.CancellableContinuation) r0     // Catch:{ all -> 0x0167 }
            r7.onClosedReceiveCatchingOnNoWaiterSuspend(r0)     // Catch:{ all -> 0x0167 }
            goto L_0x0150
        L_0x00b1:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = receivers$FU     // Catch:{ all -> 0x0167 }
            long r9 = r1.getAndIncrement(r7)     // Catch:{ all -> 0x0167 }
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0167 }
            long r1 = (long) r1     // Catch:{ all -> 0x0167 }
            long r1 = r9 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0167 }
            long r3 = (long) r3     // Catch:{ all -> 0x0167 }
            long r3 = r9 % r3
            int r15 = (int) r3     // Catch:{ all -> 0x0167 }
            long r3 = r0.id     // Catch:{ all -> 0x0167 }
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x00d2
            kotlinx.coroutines.channels.ChannelSegment r1 = r7.findSegmentReceive(r1, r0)     // Catch:{ all -> 0x0167 }
            if (r1 != 0) goto L_0x00d1
            goto L_0x00a3
        L_0x00d1:
            r0 = r1
        L_0x00d2:
            r6 = r14
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x0167 }
            r1 = r16
            r2 = r0
            r3 = r15
            r4 = r9
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x0167 }
            if (r1 != r2) goto L_0x00f4
            r1 = r14
            kotlinx.coroutines.Waiter r1 = (kotlinx.coroutines.Waiter) r1     // Catch:{ all -> 0x0167 }
            boolean r1 = r1 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x00ee
            r8 = r14
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8     // Catch:{ all -> 0x0167 }
        L_0x00ee:
            if (r8 == 0) goto L_0x0150
            r7.prepareReceiverForSuspension(r8, r0, r15)     // Catch:{ all -> 0x0167 }
            goto L_0x0150
        L_0x00f4:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x0167 }
            if (r1 != r2) goto L_0x0106
            long r1 = r16.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0167 }
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a3
            r0.cleanPrev()     // Catch:{ all -> 0x0167 }
            goto L_0x00a3
        L_0x0106:
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x0167 }
            if (r1 == r2) goto L_0x0129
            r0.cleanPrev()     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0167 }
            java.lang.Object r0 = r0.m2537successJP2dKIU(r1)     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.channels.ChannelResult r0 = kotlinx.coroutines.channels.ChannelResult.m2522boximpl(r0)     // Catch:{ all -> 0x0167 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r7.onUndeliveredElement     // Catch:{ all -> 0x0167 }
            if (r2 == 0) goto L_0x0125
            kotlin.coroutines.CoroutineContext r3 = r13.getContext()     // Catch:{ all -> 0x0167 }
            kotlin.jvm.functions.Function1 r8 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r2, r1, r3)     // Catch:{ all -> 0x0167 }
        L_0x0125:
            r13.resume(r0, r8)     // Catch:{ all -> 0x0167 }
            goto L_0x0150
        L_0x0129:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0167 }
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0167 }
            r0.<init>(r1)     // Catch:{ all -> 0x0167 }
            throw r0     // Catch:{ all -> 0x0167 }
        L_0x0136:
            r17.cleanPrev()     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.Companion     // Catch:{ all -> 0x0167 }
            java.lang.Object r0 = r0.m2537successJP2dKIU(r1)     // Catch:{ all -> 0x0167 }
            kotlinx.coroutines.channels.ChannelResult r0 = kotlinx.coroutines.channels.ChannelResult.m2522boximpl(r0)     // Catch:{ all -> 0x0167 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r2 = r7.onUndeliveredElement     // Catch:{ all -> 0x0167 }
            if (r2 == 0) goto L_0x0125
            kotlin.coroutines.CoroutineContext r3 = r13.getContext()     // Catch:{ all -> 0x0167 }
            kotlin.jvm.functions.Function1 r8 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r2, r1, r3)     // Catch:{ all -> 0x0167 }
            goto L_0x0125
        L_0x0150:
            java.lang.Object r1 = r13.getResult()
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r1 != r0) goto L_0x015d
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r12)
        L_0x015d:
            if (r1 != r11) goto L_0x0160
            return r11
        L_0x0160:
            kotlinx.coroutines.channels.ChannelResult r1 = (kotlinx.coroutines.channels.ChannelResult) r1
            java.lang.Object r0 = r1.m2534unboximpl()
            return r0
        L_0x0167:
            r0 = move-exception
            r13.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.m2511receiveCatchingOnNoWaiterSuspendGKJJFZk(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cancellableContinuation) {
        Result.Companion companion = Result.Companion;
        cancellableContinuation.resumeWith(Result.m983constructorimpl(ChannelResult.m2522boximpl(ChannelResult.Companion.m2535closedJP2dKIU(getCloseCause()))));
    }

    /* renamed from: tryReceive-PtdJZtk  reason: not valid java name */
    public Object m2513tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        long j = receivers$FU.get(this);
        long j2 = sendersAndCloseStatus$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.Companion.m2535closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.Companion.m2536failurePtdJZtk();
        }
        Symbol access$getINTERRUPTED_RCV$p = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            long j3 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j3) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j3, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, access$getINTERRUPTED_RCV$p);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = access$getINTERRUPTED_RCV$p instanceof Waiter ? (Waiter) access$getINTERRUPTED_RCV$p : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.Companion.m2536failurePtdJZtk();
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment.cleanPrev();
                return ChannelResult.Companion.m2537successJP2dKIU(access$updateCellReceive);
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        return ChannelResult.Companion.m2535closedJP2dKIU(getCloseCause());
    }

    /* access modifiers changed from: protected */
    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long j) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        if (!DebugKt.getASSERTIONS_ENABLED() || isConflatedDropOldest()) {
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
                long j2 = atomicLongFieldUpdater.get(this);
                if (j >= Math.max(((long) this.capacity) + j2, getBufferEndCounter())) {
                    if (atomicLongFieldUpdater.compareAndSet(this, j2, j2 + 1)) {
                        long j3 = j2 / ((long) BufferedChannelKt.SEGMENT_SIZE);
                        int i = (int) (j2 % ((long) BufferedChannelKt.SEGMENT_SIZE));
                        if (channelSegment.id != j3) {
                            ChannelSegment findSegmentReceive = findSegmentReceive(j3, channelSegment);
                            if (findSegmentReceive == null) {
                                continue;
                            } else {
                                channelSegment = findSegmentReceive;
                            }
                        }
                        Object updateCellReceive = updateCellReceive(channelSegment, i, j2, (Object) null);
                        if (updateCellReceive != BufferedChannelKt.FAILED) {
                            channelSegment.cleanPrev();
                            Function1<E, Unit> function1 = this.onUndeliveredElement;
                            if (!(function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, updateCellReceive, (UndeliveredElementException) null, 2, (Object) null)) == null)) {
                                throw callUndeliveredElementCatchingException$default;
                            }
                        } else if (j2 < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        if (obj2 == null) {
            if ((i & 16) != 0) {
                function32 = BufferedChannel$receiveImpl$1.INSTANCE;
            }
            ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = receivers$FU.getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment.id != j) {
                    ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = access$findSegmentReceive;
                    }
                }
                Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i2, andIncrement, obj);
                if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                    Waiter waiter = obj instanceof Waiter ? (Waiter) obj : null;
                    if (waiter != null) {
                        bufferedChannel.prepareReceiverForSuspension(waiter, channelSegment, i2);
                    }
                    return function3.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return function32.invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                } else {
                    channelSegment.cleanPrev();
                    return function1.invoke(access$updateCellReceive);
                }
            }
            return function0.invoke();
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
    }

    private final <R> R receiveImpl(Object obj, Function1<? super E, ? extends R> function1, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function3, Function0<? extends R> function0, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function32) {
        ChannelSegment channelSegment;
        Object obj2 = obj;
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment2.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment2);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, obj);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = obj2 instanceof Waiter ? (Waiter) obj2 : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                }
                Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function33 = function3;
                return function3.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
            }
            Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> function34 = function3;
            if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                channelSegment2 = channelSegment;
            } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                return function32.invoke(channelSegment, Integer.valueOf(i), Long.valueOf(andIncrement));
            } else {
                channelSegment.cleanPrev();
                Function1<? super E, ? extends R> function12 = function1;
                return function1.invoke(access$updateCellReceive);
            }
        }
        return function0.invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> channelSegment, int i, long j, Waiter waiter, Function1<? super E, Unit> function1, Function0<Unit> function0) {
        Object access$updateCellReceive = updateCellReceive(channelSegment, i, j, waiter);
        if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
            prepareReceiverForSuspension(waiter, channelSegment, i);
        } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
            if (j < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$FU.get(this);
            while (!isClosedForReceive()) {
                long andIncrement = receivers$FU.getAndIncrement(this);
                long j2 = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i2 = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j2) {
                    ChannelSegment access$findSegmentReceive = findSegmentReceive(j2, channelSegment2);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment2 = access$findSegmentReceive;
                    }
                }
                Object access$updateCellReceive2 = updateCellReceive(channelSegment2, i2, andIncrement, waiter);
                if (access$updateCellReceive2 == BufferedChannelKt.SUSPEND) {
                    if (!(waiter instanceof Waiter)) {
                        waiter = null;
                    }
                    if (waiter != null) {
                        prepareReceiverForSuspension(waiter, channelSegment2, i2);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                } else if (access$updateCellReceive2 == BufferedChannelKt.FAILED) {
                    if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment2.cleanPrev();
                    }
                } else if (access$updateCellReceive2 != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment2.cleanPrev();
                    function1.invoke(access$updateCellReceive2);
                    return;
                } else {
                    throw new IllegalStateException("unexpected".toString());
                }
            }
            function0.invoke();
        } else {
            channelSegment.cleanPrev();
            function1.invoke(access$updateCellReceive);
        }
    }

    /* access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (state$kotlinx_coroutines_core == null) {
            if (j >= (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                    expandBuffer();
                    return BufferedChannelKt.SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
        }
        return updateCellReceiveSlow(channelSegment, i, j, obj);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> channelSegment, int i, long j, Object obj) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (j < (sendersAndCloseStatus$FU.get(this) & 1152921504606846975L)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.FAILED;
                    }
                } else if (obj == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                } else {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, obj)) {
                        expandBuffer();
                        return BufferedChannelKt.SUSPEND;
                    }
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return BufferedChannelKt.FAILED;
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return BufferedChannelKt.FAILED;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    expandBuffer();
                    return BufferedChannelKt.FAILED;
                } else if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                    boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                    if (z) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.DONE_RCV);
                        expandBuffer();
                        return channelSegment.retrieveElement$kotlinx_coroutines_core(i);
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    if (z) {
                        expandBuffer();
                    }
                    return BufferedChannelKt.FAILED;
                }
            }
        }
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, Unit.INSTANCE, (Function1) null, 2, (Object) null);
        } else if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, Unit.INSTANCE);
            if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            if (trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL) {
                return true;
            }
            return false;
        } else if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).getCont(), true, (Function1) null, 2, (Object) null);
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
        }
    }

    private final void expandBuffer() {
        if (!isRendezvousOrUnlimited()) {
            ChannelSegment channelSegment = (ChannelSegment) bufferEndSegment$FU.get(this);
            while (true) {
                long andIncrement = bufferEnd$FU.getAndIncrement(this);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                    if (channelSegment.id < j && channelSegment.getNext() != null) {
                        moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                    }
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                if (channelSegment.id != j) {
                    ChannelSegment findSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                    if (findSegmentBufferEnd == null) {
                        continue;
                    } else {
                        channelSegment = findSegmentBufferEnd;
                    }
                }
                if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE)), andIncrement)) {
                    incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
                    return;
                }
                incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            }
        }
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
        if (!(state$kotlinx_coroutines_core instanceof Waiter) || j < receivers$FU.get(this) || !channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(channelSegment, i, j);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
            channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
            return true;
        }
        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
        channelSegment.onCancelledRequest(i, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> channelSegment, int i, long j) {
        while (true) {
            Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                if (j < receivers$FU.get(this)) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, new WaiterEB((Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, channelSegment, i)) {
                        channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    channelSegment.setState$kotlinx_coroutines_core(i, BufferedChannelKt.INTERRUPTED_SEND);
                    channelSegment.onCancelledRequest(i, false);
                    return false;
                }
            } else if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                return false;
            } else {
                if (state$kotlinx_coroutines_core == null) {
                    if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return true;
                } else {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
        return true;
    }

    static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                j = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(j);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
    }

    private final void incCompletedExpandBufferAttempts(long j) {
        boolean z;
        if ((completedExpandBuffersAndPauseFlag$FU.addAndGet(this, j) & Longs.MAX_POWER_OF_TWO) != 0) {
            do {
                if ((completedExpandBuffersAndPauseFlag$FU.get(this) & Longs.MAX_POWER_OF_TWO) != 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } while (z);
        }
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long j) {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        if (!isRendezvousOrUnlimited()) {
            do {
            } while (getBufferEndCounter() <= j);
            int access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
            int i = 0;
            while (i < access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p) {
                long bufferEndCounter = getBufferEndCounter();
                if (bufferEndCounter != (DurationKt.MAX_MILLIS & completedExpandBuffersAndPauseFlag$FU.get(this)) || bufferEndCounter != getBufferEndCounter()) {
                    i++;
                } else {
                    return;
                }
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$FU;
            do {
                j2 = atomicLongFieldUpdater2.get(this);
            } while (!atomicLongFieldUpdater2.compareAndSet(this, j2, BufferedChannelKt.constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, true)));
            while (true) {
                long bufferEndCounter2 = getBufferEndCounter();
                atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$FU;
                long j4 = atomicLongFieldUpdater.get(this);
                long j5 = j4 & DurationKt.MAX_MILLIS;
                boolean z = (Longs.MAX_POWER_OF_TWO & j4) != 0;
                if (bufferEndCounter2 == j5 && bufferEndCounter2 == getBufferEndCounter()) {
                    break;
                } else if (!z) {
                    atomicLongFieldUpdater.compareAndSet(this, j4, BufferedChannelKt.constructEBCompletedAndPauseFlag(j5, true));
                }
            }
            do {
                j3 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j3, BufferedChannelKt.constructEBCompletedAndPauseFlag(j3 & DurationKt.MAX_MILLIS, false)));
        }
    }

    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause2Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), (Function3) null, 8, (DefaultConstructorMarker) null);
    }

    private final void onClosedSelectOnSend(E e, SelectInstance<?> selectInstance) {
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, e, selectInstance.getContext());
        }
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectSend(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        return new SelectClause1Impl<>(this, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3), (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> selectInstance) {
        selectInstance.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceive(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object obj, Object obj2) {
        if (obj2 != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return obj2;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object obj, Object obj2) {
        Object obj3;
        if (obj2 == BufferedChannelKt.getCHANNEL_CLOSED()) {
            obj3 = ChannelResult.Companion.m2535closedJP2dKIU(getCloseCause());
        } else {
            obj3 = ChannelResult.Companion.m2537successJP2dKIU(obj2);
        }
        return ChannelResult.m2522boximpl(obj3);
    }

    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0006HBø\u0001\u0000¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BufferedChannel.kt */
    private final class BufferedChannelIterator implements ChannelIterator<E>, Waiter {
        /* access modifiers changed from: private */
        public CancellableContinuationImpl<? super Boolean> continuation;
        /* access modifiers changed from: private */
        public Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation continuation2) {
            return ChannelIterator.DefaultImpls.next(this, continuation2);
        }

        public Object hasNext(Continuation<? super Boolean> continuation2) {
            ChannelSegment channelSegment;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.receiveSegment$FU.get(bufferedChannel);
            while (!bufferedChannel.isClosedForReceive()) {
                long andIncrement = BufferedChannel.receivers$FU.getAndIncrement(bufferedChannel);
                long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
                int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
                if (channelSegment2.id != j) {
                    ChannelSegment access$findSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                    if (access$findSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = access$findSegmentReceive;
                    }
                } else {
                    channelSegment = channelSegment2;
                }
                Object access$updateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, andIncrement, (Object) null);
                if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                    throw new IllegalStateException("unreachable".toString());
                } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                    if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else if (access$updateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return hasNextOnNoWaiterSuspend(channelSegment, i, andIncrement, continuation2);
                } else {
                    channelSegment.cleanPrev();
                    this.receiveResult = access$updateCellReceive;
                    return Boxing.boxBoolean(true);
                }
            }
            return Boxing.boxBoolean(onClosedHasNext());
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX WARNING: type inference failed for: r9v0 */
        /* JADX WARNING: type inference failed for: r9v2, types: [kotlin.jvm.functions.Function1] */
        /* JADX WARNING: type inference failed for: r9v3, types: [kotlinx.coroutines.Waiter] */
        /* JADX WARNING: type inference failed for: r9v7 */
        /* JADX WARNING: type inference failed for: r9v8 */
        /* JADX WARNING: type inference failed for: r9v9 */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r11, int r12, long r13, kotlin.coroutines.Continuation<? super java.lang.Boolean> r15) {
            /*
                r10 = this;
                kotlinx.coroutines.channels.BufferedChannel<E> r6 = kotlinx.coroutines.channels.BufferedChannel.this
                kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r15)
                kotlinx.coroutines.CancellableContinuationImpl r7 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
                r10.continuation = r7     // Catch:{ all -> 0x00fa }
                r5 = r10
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00fa }
                r0 = r6
                r1 = r11
                r2 = r12
                r3 = r13
                java.lang.Object r0 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00fa }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00fa }
                if (r0 != r1) goto L_0x0026
                r13 = r10
                kotlinx.coroutines.Waiter r13 = (kotlinx.coroutines.Waiter) r13     // Catch:{ all -> 0x00fa }
                r6.prepareReceiverForSuspension(r13, r11, r12)     // Catch:{ all -> 0x00fa }
                goto L_0x00ec
            L_0x0026:
                kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00fa }
                r8 = 1
                r9 = 0
                if (r0 != r12) goto L_0x00d2
                long r0 = r6.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00fa }
                int r12 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
                if (r12 >= 0) goto L_0x0039
                r11.cleanPrev()     // Catch:{ all -> 0x00fa }
            L_0x0039:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r11 = kotlinx.coroutines.channels.BufferedChannel.receiveSegment$FU     // Catch:{ all -> 0x00fa }
                java.lang.Object r11 = r11.get(r6)     // Catch:{ all -> 0x00fa }
                kotlinx.coroutines.channels.ChannelSegment r11 = (kotlinx.coroutines.channels.ChannelSegment) r11     // Catch:{ all -> 0x00fa }
            L_0x0043:
                boolean r12 = r6.isClosedForReceive()     // Catch:{ all -> 0x00fa }
                if (r12 == 0) goto L_0x004e
                r10.onClosedHasNextNoWaiterSuspend()     // Catch:{ all -> 0x00fa }
                goto L_0x00ec
            L_0x004e:
                java.util.concurrent.atomic.AtomicLongFieldUpdater r12 = kotlinx.coroutines.channels.BufferedChannel.receivers$FU     // Catch:{ all -> 0x00fa }
                long r12 = r12.getAndIncrement(r6)     // Catch:{ all -> 0x00fa }
                int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00fa }
                long r0 = (long) r14     // Catch:{ all -> 0x00fa }
                long r0 = r12 / r0
                int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00fa }
                long r2 = (long) r14     // Catch:{ all -> 0x00fa }
                long r2 = r12 % r2
                int r14 = (int) r2     // Catch:{ all -> 0x00fa }
                long r2 = r11.id     // Catch:{ all -> 0x00fa }
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 == 0) goto L_0x006f
                kotlinx.coroutines.channels.ChannelSegment r0 = r6.findSegmentReceive(r0, r11)     // Catch:{ all -> 0x00fa }
                if (r0 != 0) goto L_0x006e
                goto L_0x0043
            L_0x006e:
                r11 = r0
            L_0x006f:
                r5 = r10
                kotlinx.coroutines.Waiter r5 = (kotlinx.coroutines.Waiter) r5     // Catch:{ all -> 0x00fa }
                r0 = r6
                r1 = r11
                r2 = r14
                r3 = r12
                java.lang.Object r0 = r0.updateCellReceive(r1, r2, r3, r5)     // Catch:{ all -> 0x00fa }
                kotlinx.coroutines.internal.Symbol r1 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00fa }
                if (r0 != r1) goto L_0x0090
                r12 = r10
                kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12     // Catch:{ all -> 0x00fa }
                boolean r12 = r12 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00fa }
                if (r12 == 0) goto L_0x008a
                r9 = r10
                kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9     // Catch:{ all -> 0x00fa }
            L_0x008a:
                if (r9 == 0) goto L_0x00ec
                r6.prepareReceiverForSuspension(r9, r11, r14)     // Catch:{ all -> 0x00fa }
                goto L_0x00ec
            L_0x0090:
                kotlinx.coroutines.internal.Symbol r14 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00fa }
                if (r0 != r14) goto L_0x00a2
                long r0 = r6.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00fa }
                int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
                if (r12 >= 0) goto L_0x0043
                r11.cleanPrev()     // Catch:{ all -> 0x00fa }
                goto L_0x0043
            L_0x00a2:
                kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00fa }
                if (r0 == r12) goto L_0x00c5
                r11.cleanPrev()     // Catch:{ all -> 0x00fa }
                r10.receiveResult = r0     // Catch:{ all -> 0x00fa }
                r10.continuation = r9     // Catch:{ all -> 0x00fa }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x00fa }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r6.onUndeliveredElement     // Catch:{ all -> 0x00fa }
                if (r12 == 0) goto L_0x00c1
                kotlin.coroutines.CoroutineContext r13 = r7.getContext()     // Catch:{ all -> 0x00fa }
                kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r12, r0, r13)     // Catch:{ all -> 0x00fa }
            L_0x00c1:
                r7.resume(r11, r9)     // Catch:{ all -> 0x00fa }
                goto L_0x00ec
            L_0x00c5:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fa }
                java.lang.String r12 = "unexpected"
                java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00fa }
                r11.<init>(r12)     // Catch:{ all -> 0x00fa }
                throw r11     // Catch:{ all -> 0x00fa }
            L_0x00d2:
                r11.cleanPrev()     // Catch:{ all -> 0x00fa }
                r10.receiveResult = r0     // Catch:{ all -> 0x00fa }
                r10.continuation = r9     // Catch:{ all -> 0x00fa }
                java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x00fa }
                kotlin.jvm.functions.Function1<E, kotlin.Unit> r12 = r6.onUndeliveredElement     // Catch:{ all -> 0x00fa }
                if (r12 == 0) goto L_0x00c1
                kotlin.coroutines.CoroutineContext r13 = r7.getContext()     // Catch:{ all -> 0x00fa }
                kotlin.jvm.functions.Function1 r9 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r12, r0, r13)     // Catch:{ all -> 0x00fa }
                goto L_0x00c1
            L_0x00ec:
                java.lang.Object r11 = r7.getResult()
                java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r11 != r12) goto L_0x00f9
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r15)
            L_0x00f9:
                return r11
            L_0x00fa:
                r11 = move-exception
                r7.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator.hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public void invokeOnCancellation(Segment<?> segment, int i) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, i);
            }
        }

        /* access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m983constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(closeCause)));
        }

        public E next() {
            E e = this.receiveResult;
            if (e != BufferedChannelKt.NO_RECEIVE_RESULT) {
                this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
                if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                    return e;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
            }
            throw new IllegalStateException("`hasNext()` has not been invoked".toString());
        }

        public final boolean tryResumeHasNext(E e) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            Function1<Throwable, Unit> function1 = null;
            this.continuation = null;
            this.receiveResult = e;
            CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
            Function1<E, Unit> function12 = BufferedChannel.this.onUndeliveredElement;
            if (function12 != null) {
                function1 = OnUndeliveredElementKt.bindCancellationFun(function12, e, cancellableContinuationImpl.getContext());
            }
            return BufferedChannelKt.tryResume0(cancellableContinuation, true, function1);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl.resumeWith(Result.m983constructorimpl(false));
                return;
            }
            Continuation continuation2 = cancellableContinuationImpl;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                closeCause = StackTraceRecoveryKt.recoverFromStackFrame(closeCause, (CoroutineStackFrame) continuation2);
            }
            Result.Companion companion2 = Result.Companion;
            continuation2.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(closeCause)));
        }
    }

    /* access modifiers changed from: protected */
    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$FU.get(this);
    }

    /* access modifiers changed from: protected */
    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    /* access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public boolean close(Throwable th) {
        return closeOrCancelImpl(th, false);
    }

    public final boolean cancel(Throwable th) {
        return cancelImpl$kotlinx_coroutines_core(th);
    }

    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core((Throwable) null);
    }

    public final void cancel(CancellationException cancellationException) {
        cancelImpl$kotlinx_coroutines_core(cancellationException);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(th, true);
    }

    /* access modifiers changed from: protected */
    public boolean closeOrCancelImpl(Throwable th, boolean z) {
        if (z) {
            markCancellationStarted();
        }
        boolean m = AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_closeCause$FU, this, BufferedChannelKt.NO_CLOSE_CAUSE, th);
        if (z) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (m) {
            invokeCloseHandler();
        }
        return m;
    }

    private final void invokeCloseHandler() {
        Object obj;
        Symbol symbol;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                symbol = BufferedChannelKt.CLOSE_HANDLER_CLOSED;
            } else {
                symbol = BufferedChannelKt.CLOSE_HANDLER_INVOKED;
            }
        } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, obj, symbol));
        if (obj != null) {
            Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
            ((Function1) obj).invoke(getCloseCause());
        }
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$FU;
        if (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            do {
                Object obj = atomicReferenceFieldUpdater.get(this);
                if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                    if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                        throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                    }
                    throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                }
            } while (!AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$FU, this, BufferedChannelKt.CLOSE_HANDLER_CLOSED, BufferedChannelKt.CLOSE_HANDLER_INVOKED));
            function1.invoke(getCloseCause());
        }
    }

    private final void markClosed() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 2);
            } else if (i == 1) {
                j2 = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 3);
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) (j >> 60)) == 0) {
            } else {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final ChannelSegment<E> completeClose(long j) {
        ChannelSegment<E> closeLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(closeLinkedList);
            if (markAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(closeLinkedList, j);
        return closeLinkedList;
    }

    private final void completeCancel(long j) {
        removeUnprocessedElements(completeClose(j));
    }

    private final ChannelSegment<E> closeLinkedList() {
        ChannelSegment channelSegment = bufferEndSegment$FU.get(this);
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment2;
        }
        ChannelSegment channelSegment3 = (ChannelSegment) receiveSegment$FU.get(this);
        if (channelSegment3.id > ((ChannelSegment) channelSegment).id) {
            channelSegment = channelSegment3;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.close((ConcurrentLinkedListNode) channelSegment);
    }

    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> channelSegment) {
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 < i) {
                    long j = (channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i);
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        return -1;
                    }
                    while (true) {
                        Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                        if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                            if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                channelSegment.onSlotCleaned();
                                break;
                            }
                        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                            return j;
                        }
                    }
                } else {
                    channelSegment = (ChannelSegment) channelSegment.getPrev();
                }
            }
        } while (channelSegment != null);
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b3, code lost:
        r12 = (kotlinx.coroutines.channels.ChannelSegment) r12.getPrev();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> r12) {
        /*
            r11 = this;
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r11.onUndeliveredElement
            r1 = 0
            r2 = 1
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m2564constructorimpl$default(r1, r2, r1)
        L_0x0008:
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            int r4 = r4 - r2
        L_0x000b:
            r5 = -1
            if (r5 >= r4) goto L_0x00b3
            long r6 = r12.id
            int r8 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r8 = (long) r8
            long r6 = r6 * r8
            long r8 = (long) r4
            long r6 = r6 + r8
        L_0x0016:
            java.lang.Object r8 = r12.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            if (r8 != r9) goto L_0x0048
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0040
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0040:
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x0048:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            if (r8 == r9) goto L_0x00a2
            if (r8 != 0) goto L_0x0051
            goto L_0x00a2
        L_0x0051:
            boolean r9 = r8 instanceof kotlinx.coroutines.Waiter
            if (r9 != 0) goto L_0x006e
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x005a
            goto L_0x006e
        L_0x005a:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x00bb
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            if (r8 != r9) goto L_0x0067
            goto L_0x00bb
        L_0x0067:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            if (r8 == r9) goto L_0x0016
            goto L_0x00af
        L_0x006e:
            long r9 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r9 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r9 < 0) goto L_0x00bb
            boolean r9 = r8 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x0080
            r9 = r8
            kotlinx.coroutines.channels.WaiterEB r9 = (kotlinx.coroutines.channels.WaiterEB) r9
            kotlinx.coroutines.Waiter r9 = r9.waiter
            goto L_0x0083
        L_0x0080:
            r9 = r8
            kotlinx.coroutines.Waiter r9 = (kotlinx.coroutines.Waiter) r9
        L_0x0083:
            kotlinx.coroutines.internal.Symbol r10 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r10)
            if (r8 == 0) goto L_0x0016
            if (r0 == 0) goto L_0x0097
            java.lang.Object r5 = r12.getElement$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.UndeliveredElementException r1 = kotlinx.coroutines.internal.OnUndeliveredElementKt.callUndeliveredElementCatchingException(r0, r5, r1)
        L_0x0097:
            java.lang.Object r3 = kotlinx.coroutines.internal.InlineList.m2569plusFjFbRPM(r3, r9)
            r12.cleanElement$kotlinx_coroutines_core(r4)
            r12.onSlotCleaned()
            goto L_0x00af
        L_0x00a2:
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r8 = r12.casState$kotlinx_coroutines_core(r4, r8, r9)
            if (r8 == 0) goto L_0x0016
            r12.onSlotCleaned()
        L_0x00af:
            int r4 = r4 + -1
            goto L_0x000b
        L_0x00b3:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r12 = r12.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r12 = (kotlinx.coroutines.channels.ChannelSegment) r12
            if (r12 != 0) goto L_0x0008
        L_0x00bb:
            if (r3 == 0) goto L_0x00e1
            boolean r12 = r3 instanceof java.util.ArrayList
            if (r12 != 0) goto L_0x00c7
            kotlinx.coroutines.Waiter r3 = (kotlinx.coroutines.Waiter) r3
            r11.resumeSenderOnCancelledChannel(r3)
            goto L_0x00e1
        L_0x00c7:
            java.lang.String r12 = "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r12)
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r12 = r3.size()
            int r12 = r12 - r2
        L_0x00d3:
            if (r5 >= r12) goto L_0x00e1
            java.lang.Object r0 = r3.get(r12)
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0
            r11.resumeSenderOnCancelledChannel(r0)
            int r12 = r12 + -1
            goto L_0x00d3
        L_0x00e1:
            if (r1 != 0) goto L_0x00e4
            return
        L_0x00e4:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment):void");
    }

    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> channelSegment, long j) {
        Object r0 = InlineList.m2564constructorimpl$default((Object) null, 1, (DefaultConstructorMarker) null);
        loop0:
        while (channelSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((channelSegment.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) + ((long) i) < j) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            channelSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            r0 = InlineList.m2569plusFjFbRPM(r0, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                            channelSegment.onCancelledRequest(i, true);
                            break;
                        }
                    } else if (!(state$kotlinx_coroutines_core instanceof Waiter)) {
                        break;
                    } else if (channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        r0 = InlineList.m2569plusFjFbRPM(r0, state$kotlinx_coroutines_core);
                        channelSegment.onCancelledRequest(i, true);
                        break;
                    }
                }
            }
            channelSegment = (ChannelSegment) channelSegment.getPrev();
        }
        if (r0 == null) {
            return;
        }
        if (!(r0 instanceof ArrayList)) {
            resumeReceiverOnClosedChannel((Waiter) r0);
            return;
        }
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
        ArrayList arrayList = (ArrayList) r0;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            resumeReceiverOnClosedChannel((Waiter) arrayList.get(size));
        }
    }

    private final void resumeReceiverOnClosedChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter waiter) {
        resumeWaiterOnClosedChannel(waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter waiter, boolean z) {
        if (waiter instanceof SendBroadcast) {
            Result.Companion companion = Result.Companion;
            ((SendBroadcast) waiter).getCont().resumeWith(Result.m983constructorimpl(false));
        } else if (waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) waiter;
            Result.Companion companion2 = Result.Companion;
            continuation.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (waiter instanceof ReceiveCatching) {
            Result.Companion companion3 = Result.Companion;
            ((ReceiveCatching) waiter).cont.resumeWith(Result.m983constructorimpl(ChannelResult.m2522boximpl(ChannelResult.Companion.m2535closedJP2dKIU(getCloseCause()))));
        } else if (waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) waiter).tryResumeHasNextOnClosedChannel();
        } else if (waiter instanceof SelectInstance) {
            ((SelectInstance) waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
        } else {
            throw new IllegalStateException(("Unexpected waiter: " + waiter).toString());
        }
    }

    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$FU.get(this));
    }

    /* access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$FU.get(this));
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    private final boolean isClosed(long j, boolean z) {
        int i = (int) (j >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(j & 1152921504606846975L);
            if (z && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        } else if (i == 3) {
            completeCancel(j & 1152921504606846975L);
        } else {
            throw new IllegalStateException(("unexpected close status: " + i).toString());
        }
        return true;
    }

    public boolean isEmpty() {
        if (!isClosedForReceive() && !hasElements$kotlinx_coroutines_core()) {
            return !isClosedForReceive();
        }
        return false;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$FU;
            ChannelSegment channelSegment = (ChannelSegment) atomicReferenceFieldUpdater.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            long j = receiversCounter$kotlinx_coroutines_core / ((long) BufferedChannelKt.SEGMENT_SIZE);
            if (channelSegment.id == j || (channelSegment = findSegmentReceive(j, channelSegment)) != null) {
                channelSegment.cleanPrev();
                if (isCellNonEmpty(channelSegment, (int) (receiversCounter$kotlinx_coroutines_core % ((long) BufferedChannelKt.SEGMENT_SIZE)), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core + 1);
            } else if (((ChannelSegment) atomicReferenceFieldUpdater.get(this)).id < j) {
                return false;
            }
        }
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> channelSegment, int i, long j) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && j == getReceiversCounter$kotlinx_coroutines_core()) {
                    return true;
                }
                return false;
            }
        } while (!channelSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0043, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentSend(long r12, kotlinx.coroutines.channels.ChannelSegment<E> r14) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$FU
            kotlin.reflect.KFunction r1 = kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
        L_0x0008:
            r2 = r14
            kotlinx.coroutines.internal.Segment r2 = (kotlinx.coroutines.internal.Segment) r2
            java.lang.Object r2 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(r2, r12, r1)
            boolean r3 = kotlinx.coroutines.internal.SegmentOrClosed.m2578isClosedimpl(r2)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0050
            kotlinx.coroutines.internal.Segment r3 = kotlinx.coroutines.internal.SegmentOrClosed.m2576getSegmentimpl(r2)
        L_0x001b:
            java.lang.Object r6 = r0.get(r11)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            long r7 = r6.id
            long r9 = r3.id
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x002b
        L_0x0029:
            r3 = r5
            goto L_0x0043
        L_0x002b:
            boolean r7 = r3.tryIncPointers$kotlinx_coroutines_core()
            if (r7 != 0) goto L_0x0033
            r3 = r4
            goto L_0x0043
        L_0x0033:
            boolean r7 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r0, r11, r6, r3)
            if (r7 == 0) goto L_0x0046
            boolean r3 = r6.decPointers$kotlinx_coroutines_core()
            if (r3 == 0) goto L_0x0029
            r6.remove()
            goto L_0x0029
        L_0x0043:
            if (r3 == 0) goto L_0x0008
            goto L_0x0050
        L_0x0046:
            boolean r6 = r3.decPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L_0x001b
            r3.remove()
            goto L_0x001b
        L_0x0050:
            boolean r0 = kotlinx.coroutines.internal.SegmentOrClosed.m2578isClosedimpl(r2)
            r1 = 0
            if (r0 == 0) goto L_0x006c
            r11.completeCloseOrCancel()
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00aa
            r14.cleanPrev()
            goto L_0x00aa
        L_0x006c:
            kotlinx.coroutines.internal.Segment r14 = kotlinx.coroutines.internal.SegmentOrClosed.m2576getSegmentimpl(r2)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
            long r2 = r14.id
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x0093
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            r11.updateSendersCounterIfLower(r12)
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.getReceiversCounter$kotlinx_coroutines_core()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00aa
            r14.cleanPrev()
            goto L_0x00aa
        L_0x0093:
            boolean r0 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r0 == 0) goto L_0x00a9
            long r0 = r14.id
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 != 0) goto L_0x00a0
            r4 = r5
        L_0x00a0:
            if (r4 == 0) goto L_0x00a3
            goto L_0x00a9
        L_0x00a3:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x00a9:
            r1 = r14
        L_0x00aa:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.findSegmentSend(long, kotlinx.coroutines.channels.ChannelSegment):kotlinx.coroutines.channels.ChannelSegment");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0043, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0029, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentReceive(long r12, kotlinx.coroutines.channels.ChannelSegment<E> r14) {
        /*
            r11 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$FU
            kotlin.reflect.KFunction r1 = kotlinx.coroutines.channels.BufferedChannelKt.createSegmentFunction()
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
        L_0x0008:
            r2 = r14
            kotlinx.coroutines.internal.Segment r2 = (kotlinx.coroutines.internal.Segment) r2
            java.lang.Object r2 = kotlinx.coroutines.internal.ConcurrentLinkedListKt.findSegmentInternal(r2, r12, r1)
            boolean r3 = kotlinx.coroutines.internal.SegmentOrClosed.m2578isClosedimpl(r2)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0050
            kotlinx.coroutines.internal.Segment r3 = kotlinx.coroutines.internal.SegmentOrClosed.m2576getSegmentimpl(r2)
        L_0x001b:
            java.lang.Object r6 = r0.get(r11)
            kotlinx.coroutines.internal.Segment r6 = (kotlinx.coroutines.internal.Segment) r6
            long r7 = r6.id
            long r9 = r3.id
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L_0x002b
        L_0x0029:
            r3 = r5
            goto L_0x0043
        L_0x002b:
            boolean r7 = r3.tryIncPointers$kotlinx_coroutines_core()
            if (r7 != 0) goto L_0x0033
            r3 = r4
            goto L_0x0043
        L_0x0033:
            boolean r7 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r0, r11, r6, r3)
            if (r7 == 0) goto L_0x0046
            boolean r3 = r6.decPointers$kotlinx_coroutines_core()
            if (r3 == 0) goto L_0x0029
            r6.remove()
            goto L_0x0029
        L_0x0043:
            if (r3 == 0) goto L_0x0008
            goto L_0x0050
        L_0x0046:
            boolean r6 = r3.decPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L_0x001b
            r3.remove()
            goto L_0x001b
        L_0x0050:
            boolean r0 = kotlinx.coroutines.internal.SegmentOrClosed.m2578isClosedimpl(r2)
            r1 = 0
            if (r0 == 0) goto L_0x006d
            r11.completeCloseOrCancel()
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.getSendersCounter$kotlinx_coroutines_core()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00f0
            r14.cleanPrev()
            goto L_0x00f0
        L_0x006d:
            kotlinx.coroutines.internal.Segment r14 = kotlinx.coroutines.internal.SegmentOrClosed.m2576getSegmentimpl(r2)
            kotlinx.coroutines.channels.ChannelSegment r14 = (kotlinx.coroutines.channels.ChannelSegment) r14
            boolean r0 = r11.isRendezvousOrUnlimited()
            if (r0 != 0) goto L_0x00b8
            long r2 = r11.getBufferEndCounter()
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r6 = (long) r0
            long r2 = r2 / r6
            int r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x00b8
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$FU
        L_0x0087:
            java.lang.Object r2 = r0.get(r11)
            kotlinx.coroutines.internal.Segment r2 = (kotlinx.coroutines.internal.Segment) r2
            long r6 = r2.id
            r3 = r14
            kotlinx.coroutines.internal.Segment r3 = (kotlinx.coroutines.internal.Segment) r3
            long r8 = r3.id
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto L_0x00b8
            boolean r6 = r3.tryIncPointers$kotlinx_coroutines_core()
            if (r6 == 0) goto L_0x00b8
            boolean r6 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r0, r11, r2, r3)
            if (r6 == 0) goto L_0x00ae
            boolean r0 = r2.decPointers$kotlinx_coroutines_core()
            if (r0 == 0) goto L_0x00b8
            r2.remove()
            goto L_0x00b8
        L_0x00ae:
            boolean r2 = r3.decPointers$kotlinx_coroutines_core()
            if (r2 == 0) goto L_0x0087
            r3.remove()
            goto L_0x0087
        L_0x00b8:
            long r2 = r14.id
            int r0 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d9
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            r11.updateReceiversCounterIfLower(r12)
            long r12 = r14.id
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r2 = (long) r0
            long r12 = r12 * r2
            long r2 = r11.getSendersCounter$kotlinx_coroutines_core()
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 >= 0) goto L_0x00f0
            r14.cleanPrev()
            goto L_0x00f0
        L_0x00d9:
            boolean r0 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r0 == 0) goto L_0x00ef
            long r0 = r14.id
            int r12 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r12 != 0) goto L_0x00e6
            r4 = r5
        L_0x00e6:
            if (r4 == 0) goto L_0x00e9
            goto L_0x00ef
        L_0x00e9:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        L_0x00ef:
            r1 = r14
        L_0x00f0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.findSegmentReceive(long, kotlinx.coroutines.channels.ChannelSegment):kotlinx.coroutines.channels.ChannelSegment");
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long j, ChannelSegment<E> channelSegment, long j2) {
        Object findSegmentInternal;
        boolean z;
        boolean z2;
        long j3 = j;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        do {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(channelSegment, j3, function2);
            z = false;
            if (SegmentOrClosed.m2578isClosedimpl(findSegmentInternal)) {
                break;
            }
            Segment r5 = SegmentOrClosed.m2576getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                if (segment.id >= r5.id) {
                    break;
                } else if (!r5.tryIncPointers$kotlinx_coroutines_core()) {
                    z2 = false;
                    continue;
                    break;
                } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, r5)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                } else if (r5.decPointers$kotlinx_coroutines_core()) {
                    r5.remove();
                }
            }
            z2 = true;
            continue;
        } while (!z2);
        if (SegmentOrClosed.m2578isClosedimpl(findSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
            incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            return null;
        }
        ChannelSegment<E> channelSegment2 = (ChannelSegment) SegmentOrClosed.m2576getSegmentimpl(findSegmentInternal);
        if (channelSegment2.id > j3) {
            if (bufferEnd$FU.compareAndSet(this, j2 + 1, channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE))) {
                incCompletedExpandBufferAttempts((channelSegment2.id * ((long) BufferedChannelKt.SEGMENT_SIZE)) - j2);
                return null;
            }
            incCompletedExpandBufferAttempts$default(this, 0, 1, (Object) null);
            return null;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (channelSegment2.id == j3) {
                z = true;
            }
            if (!z) {
                throw new AssertionError();
            }
        }
        return channelSegment2;
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long j, ChannelSegment<E> channelSegment) {
        boolean z;
        ChannelSegment<E> channelSegment2;
        ChannelSegment<E> channelSegment3;
        while (channelSegment.id < j && (channelSegment3 = (ChannelSegment) channelSegment.getNext()) != null) {
            channelSegment = channelSegment3;
        }
        while (true) {
            if (!channelSegment.isRemoved() || (channelSegment2 = (ChannelSegment) channelSegment.getNext()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$FU;
                while (true) {
                    Segment segment = (Segment) atomicReferenceFieldUpdater.get(this);
                    Segment segment2 = channelSegment;
                    z = true;
                    if (segment.id >= segment2.id) {
                        break;
                    } else if (!segment2.tryIncPointers$kotlinx_coroutines_core()) {
                        z = false;
                        break;
                    } else if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, this, segment, segment2)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                    } else if (segment2.decPointers$kotlinx_coroutines_core()) {
                        segment2.remove();
                    }
                }
                if (z) {
                    return;
                }
            } else {
                channelSegment = channelSegment2;
            }
        }
    }

    private final void updateSendersCounterIfLower(long j) {
        long j2;
        long j3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            j3 = 1152921504606846975L & j2;
            if (j3 < j) {
            } else {
                return;
            }
        } while (!sendersAndCloseStatus$FU.compareAndSet(this, j2, BufferedChannelKt.constructSendersAndCloseStatus(j3, (int) (j2 >> 60))));
    }

    private final void updateReceiversCounterIfLower(long j) {
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$FU;
        do {
            j2 = atomicLongFieldUpdater.get(this);
            if (j2 >= j || receivers$FU.compareAndSet(this, j2, j)) {
            }
            j2 = atomicLongFieldUpdater.get(this);
            return;
        } while (receivers$FU.compareAndSet(this, j2, j));
    }

    /* JADX WARNING: type inference failed for: r2v16, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01f4, code lost:
        r3 = r3.getNext();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01fb, code lost:
        if (r3 != null) goto L_0x021f;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r16 = this;
            r0 = r16
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$FU
            long r2 = r2.get(r0)
            r4 = 60
            long r2 = r2 >> r4
            int r2 = (int) r2
            r3 = 3
            r4 = 2
            if (r2 == r4) goto L_0x001e
            if (r2 == r3) goto L_0x0018
            goto L_0x0023
        L_0x0018:
            java.lang.String r2 = "cancelled,"
            r1.append(r2)
            goto L_0x0023
        L_0x001e:
            java.lang.String r2 = "closed,"
            r1.append(r2)
        L_0x0023:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "capacity="
            java.lang.StringBuilder r2 = r2.append(r5)
            int r5 = r0.capacity
            java.lang.StringBuilder r2 = r2.append(r5)
            r5 = 44
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = "data=["
            r1.append(r2)
            kotlinx.coroutines.channels.ChannelSegment[] r2 = new kotlinx.coroutines.channels.ChannelSegment[r3]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$FU
            java.lang.Object r3 = r3.get(r0)
            r6 = 0
            r2[r6] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$FU
            java.lang.Object r3 = r3.get(r0)
            r7 = 1
            r2[r7] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = bufferEndSegment$FU
            java.lang.Object r3 = r3.get(r0)
            r2[r4] = r3
            java.util.List r2 = kotlin.collections.CollectionsKt.listOf(r2)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0073:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x008f
            java.lang.Object r4 = r2.next()
            r8 = r4
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            kotlinx.coroutines.channels.ChannelSegment r9 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r8 == r9) goto L_0x0088
            r8 = r7
            goto L_0x0089
        L_0x0088:
            r8 = r6
        L_0x0089:
            if (r8 == 0) goto L_0x0073
            r3.add(r4)
            goto L_0x0073
        L_0x008f:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r2 = r3.iterator()
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0223
            java.lang.Object r3 = r2.next()
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00a8
            goto L_0x00c2
        L_0x00a8:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r8 = r4.id
        L_0x00ad:
            java.lang.Object r4 = r2.next()
            r10 = r4
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10
            long r10 = r10.id
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x00bc
            r3 = r4
            r8 = r10
        L_0x00bc:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x00ad
        L_0x00c2:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            long r10 = r16.getReceiversCounter$kotlinx_coroutines_core()
            long r12 = r16.getSendersCounter$kotlinx_coroutines_core()
        L_0x00cc:
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r6
        L_0x00cf:
            if (r4 >= r2) goto L_0x01f4
            long r8 = r3.id
            int r14 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r14 = (long) r14
            long r8 = r8 * r14
            long r14 = (long) r4
            long r8 = r8 + r14
            int r14 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r14 < 0) goto L_0x00e1
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 >= 0) goto L_0x01fd
        L_0x00e1:
            java.lang.Object r15 = r3.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r6 = r3.getElement$kotlinx_coroutines_core(r4)
            boolean r7 = r15 instanceof kotlinx.coroutines.CancellableContinuation
            if (r7 == 0) goto L_0x0103
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x00f7
            if (r14 < 0) goto L_0x00f7
            java.lang.String r7 = "receive"
            goto L_0x01b3
        L_0x00f7:
            if (r14 >= 0) goto L_0x00ff
            if (r7 < 0) goto L_0x00ff
            java.lang.String r7 = "send"
            goto L_0x01b3
        L_0x00ff:
            java.lang.String r7 = "cont"
            goto L_0x01b3
        L_0x0103:
            boolean r7 = r15 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r7 == 0) goto L_0x011d
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0111
            if (r14 < 0) goto L_0x0111
            java.lang.String r7 = "onReceive"
            goto L_0x01b3
        L_0x0111:
            if (r14 >= 0) goto L_0x0119
            if (r7 < 0) goto L_0x0119
            java.lang.String r7 = "onSend"
            goto L_0x01b3
        L_0x0119:
            java.lang.String r7 = "select"
            goto L_0x01b3
        L_0x011d:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r7 == 0) goto L_0x0125
            java.lang.String r7 = "receiveCatching"
            goto L_0x01b3
        L_0x0125:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r7 == 0) goto L_0x012d
            java.lang.String r7 = "sendBroadcast"
            goto L_0x01b3
        L_0x012d:
            boolean r7 = r15 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r7 == 0) goto L_0x014c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "EB("
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r7 = r7.append(r15)
            r8 = 41
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.String r7 = r7.toString()
            goto L_0x01b3
        L_0x014c:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0158
            r7 = 1
            goto L_0x0160
        L_0x0158:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.RESUMING_BY_EB
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0160:
            if (r7 == 0) goto L_0x0165
            java.lang.String r7 = "resuming_sender"
            goto L_0x01b3
        L_0x0165:
            if (r15 != 0) goto L_0x0169
            r7 = 1
            goto L_0x0171
        L_0x0169:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.IN_BUFFER
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0171:
            if (r7 == 0) goto L_0x0175
            r7 = 1
            goto L_0x017d
        L_0x0175:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x017d:
            if (r7 == 0) goto L_0x0181
            r7 = 1
            goto L_0x0189
        L_0x0181:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0189:
            if (r7 == 0) goto L_0x018d
            r7 = 1
            goto L_0x0195
        L_0x018d:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x0195:
            if (r7 == 0) goto L_0x0199
            r7 = 1
            goto L_0x01a1
        L_0x0199:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x01a1:
            if (r7 == 0) goto L_0x01a5
            r7 = 1
            goto L_0x01ad
        L_0x01a5:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
        L_0x01ad:
            if (r7 != 0) goto L_0x01ee
            java.lang.String r7 = r15.toString()
        L_0x01b3:
            if (r6 == 0) goto L_0x01da
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            java.lang.StringBuilder r8 = r8.append(r9)
            java.lang.StringBuilder r7 = r8.append(r7)
            java.lang.StringBuilder r7 = r7.append(r5)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r7 = "),"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            goto L_0x01ee
        L_0x01da:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r5)
            java.lang.String r6 = r6.toString()
            r1.append(r6)
        L_0x01ee:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            goto L_0x00cf
        L_0x01f4:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r2 = r3.getNext()
            r3 = r2
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            if (r3 != 0) goto L_0x021f
        L_0x01fd:
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            char r2 = kotlin.text.StringsKt.last(r2)
            if (r2 != r5) goto L_0x0215
            int r2 = r1.length()
            r4 = 1
            int r2 = r2 - r4
            java.lang.StringBuilder r2 = r1.deleteCharAt(r2)
            java.lang.String r3 = "this.deleteCharAt(index)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0215:
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            return r1
        L_0x021f:
            r6 = 0
            r7 = 1
            goto L_0x00cc
        L_0x0223:
            java.util.NoSuchElementException r1 = new java.util.NoSuchElementException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toString():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r1v44, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String toStringDebug$kotlinx_coroutines_core() {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "S="
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r11.getSendersCounter$kotlinx_coroutines_core()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",R="
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r11.getReceiversCounter$kotlinx_coroutines_core()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",B="
            java.lang.StringBuilder r1 = r1.append(r2)
            long r2 = r11.getBufferEndCounter()
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",B'="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = completedExpandBuffersAndPauseFlag$FU
            long r2 = r2.get(r11)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = ",C="
            java.lang.StringBuilder r1 = r1.append(r2)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$FU
            long r3 = r2.get(r11)
            r5 = 60
            long r3 = r3 >> r5
            int r3 = (int) r3
            java.lang.StringBuilder r1 = r1.append(r3)
            r3 = 44
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            long r1 = r2.get(r11)
            long r1 = r1 >> r5
            int r1 = (int) r1
            r2 = 3
            r4 = 2
            r5 = 1
            if (r1 == r5) goto L_0x0081
            if (r1 == r4) goto L_0x007b
            if (r1 == r2) goto L_0x0075
            goto L_0x0086
        L_0x0075:
            java.lang.String r1 = "CANCELLED,"
            r0.append(r1)
            goto L_0x0086
        L_0x007b:
            java.lang.String r1 = "CLOSED,"
            r0.append(r1)
            goto L_0x0086
        L_0x0081:
            java.lang.String r1 = "CANCELLATION_STARTED,"
            r0.append(r1)
        L_0x0086:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = "SEND_SEGM="
            java.lang.StringBuilder r1 = r1.append(r6)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = sendSegment$FU
            java.lang.Object r7 = r6.get(r11)
            java.lang.String r7 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r7)
            java.lang.StringBuilder r1 = r1.append(r7)
            java.lang.String r7 = ",RCV_SEGM="
            java.lang.StringBuilder r1 = r1.append(r7)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = receiveSegment$FU
            java.lang.Object r8 = r7.get(r11)
            java.lang.String r8 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r8)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            boolean r1 = r11.isRendezvousOrUnlimited()
            if (r1 != 0) goto L_0x00e0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = ",EB_SEGM="
            java.lang.StringBuilder r1 = r1.append(r8)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = bufferEndSegment$FU
            java.lang.Object r8 = r8.get(r11)
            java.lang.String r8 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r8)
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
        L_0x00e0:
            java.lang.String r1 = "  "
            r0.append(r1)
            kotlinx.coroutines.channels.ChannelSegment[] r1 = new kotlinx.coroutines.channels.ChannelSegment[r2]
            java.lang.Object r2 = r7.get(r11)
            r7 = 0
            r1[r7] = r2
            java.lang.Object r2 = r6.get(r11)
            r1[r5] = r2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = bufferEndSegment$FU
            java.lang.Object r2 = r2.get(r11)
            r1[r4] = r2
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x010d:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0129
            java.lang.Object r4 = r1.next()
            r6 = r4
            kotlinx.coroutines.channels.ChannelSegment r6 = (kotlinx.coroutines.channels.ChannelSegment) r6
            kotlinx.coroutines.channels.ChannelSegment r8 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r6 == r8) goto L_0x0122
            r6 = r5
            goto L_0x0123
        L_0x0122:
            r6 = r7
        L_0x0123:
            if (r6 == 0) goto L_0x010d
            r2.add(r4)
            goto L_0x010d
        L_0x0129:
            java.util.List r2 = (java.util.List) r2
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r1 = r2.iterator()
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x025c
            java.lang.Object r2 = r1.next()
            boolean r4 = r1.hasNext()
            if (r4 != 0) goto L_0x0142
            goto L_0x015c
        L_0x0142:
            r4 = r2
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.id
        L_0x0147:
            java.lang.Object r6 = r1.next()
            r8 = r6
            kotlinx.coroutines.channels.ChannelSegment r8 = (kotlinx.coroutines.channels.ChannelSegment) r8
            long r8 = r8.id
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0156
            r2 = r6
            r4 = r8
        L_0x0156:
            boolean r6 = r1.hasNext()
            if (r6 != 0) goto L_0x0147
        L_0x015c:
            kotlinx.coroutines.channels.ChannelSegment r2 = (kotlinx.coroutines.channels.ChannelSegment) r2
        L_0x015e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r2)
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = "=["
            java.lang.StringBuilder r1 = r1.append(r4)
            boolean r4 = r2.isRemoved()
            if (r4 == 0) goto L_0x017a
            java.lang.String r4 = "*"
            goto L_0x017c
        L_0x017a:
            java.lang.String r4 = ""
        L_0x017c:
            java.lang.StringBuilder r1 = r1.append(r4)
            long r4 = r2.id
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r4 = ",prev="
            java.lang.StringBuilder r1 = r1.append(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r2.getPrev()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            r5 = 0
            if (r4 == 0) goto L_0x019a
            java.lang.String r4 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
            goto L_0x019b
        L_0x019a:
            r4 = r5
        L_0x019b:
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r7
        L_0x01ad:
            if (r4 >= r1) goto L_0x0226
            java.lang.Object r6 = r2.getState$kotlinx_coroutines_core(r4)
            java.lang.Object r8 = r2.getElement$kotlinx_coroutines_core(r4)
            boolean r9 = r6 instanceof kotlinx.coroutines.CancellableContinuation
            if (r9 == 0) goto L_0x01be
            java.lang.String r6 = "cont"
            goto L_0x01f5
        L_0x01be:
            boolean r9 = r6 instanceof kotlinx.coroutines.selects.SelectInstance
            if (r9 == 0) goto L_0x01c5
            java.lang.String r6 = "select"
            goto L_0x01f5
        L_0x01c5:
            boolean r9 = r6 instanceof kotlinx.coroutines.channels.ReceiveCatching
            if (r9 == 0) goto L_0x01cc
            java.lang.String r6 = "receiveCatching"
            goto L_0x01f5
        L_0x01cc:
            boolean r9 = r6 instanceof kotlinx.coroutines.channels.BufferedChannel.SendBroadcast
            if (r9 == 0) goto L_0x01d3
            java.lang.String r6 = "send(broadcast)"
            goto L_0x01f5
        L_0x01d3:
            boolean r9 = r6 instanceof kotlinx.coroutines.channels.WaiterEB
            if (r9 == 0) goto L_0x01f1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "EB("
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r6 = r9.append(r6)
            r9 = 41
            java.lang.StringBuilder r6 = r6.append(r9)
            java.lang.String r6 = r6.toString()
            goto L_0x01f5
        L_0x01f1:
            java.lang.String r6 = java.lang.String.valueOf(r6)
        L_0x01f5:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r10 = 91
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r9 = r9.append(r4)
            java.lang.String r10 = "]=("
            java.lang.StringBuilder r9 = r9.append(r10)
            java.lang.StringBuilder r6 = r9.append(r6)
            java.lang.StringBuilder r6 = r6.append(r3)
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r8 = "),"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.String r6 = r6.toString()
            r0.append(r6)
            int r4 = r4 + 1
            goto L_0x01ad
        L_0x0226:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "next="
            java.lang.StringBuilder r1 = r1.append(r4)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r4 = r2.getNext()
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            if (r4 == 0) goto L_0x023d
            java.lang.String r5 = kotlinx.coroutines.DebugStringsKt.getHexAddress(r4)
        L_0x023d:
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r4 = "]  "
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.append(r1)
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r1 = r2.getNext()
            r2 = r1
            kotlinx.coroutines.channels.ChannelSegment r2 = (kotlinx.coroutines.channels.ChannelSegment) r2
            if (r2 != 0) goto L_0x015e
            java.lang.String r0 = r0.toString()
            return r0
        L_0x025c:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.toStringDebug$kotlinx_coroutines_core():java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v27, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01fc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void checkSegmentStructureInvariants() {
        /*
            r10 = this;
            boolean r0 = r10.isRendezvousOrUnlimited()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0037
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$FU
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r3 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r0 != r3) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x001a
            goto L_0x0054
        L_0x001a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0037:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$FU
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            long r3 = r0.id
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$FU
            java.lang.Object r0 = r0.get(r10)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            long r5 = r0.id
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x0051
            r0 = r2
            goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            if (r0 == 0) goto L_0x023d
        L_0x0054:
            r0 = 3
            kotlinx.coroutines.channels.ChannelSegment[] r0 = new kotlinx.coroutines.channels.ChannelSegment[r0]
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = receiveSegment$FU
            java.lang.Object r3 = r3.get(r10)
            r0[r1] = r3
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = sendSegment$FU
            java.lang.Object r3 = r3.get(r10)
            r0[r2] = r3
            r3 = 2
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = bufferEndSegment$FU
            java.lang.Object r4 = r4.get(r10)
            r0[r3] = r4
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r0 = r0.iterator()
        L_0x0081:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x009d
            java.lang.Object r4 = r0.next()
            r5 = r4
            kotlinx.coroutines.channels.ChannelSegment r5 = (kotlinx.coroutines.channels.ChannelSegment) r5
            kotlinx.coroutines.channels.ChannelSegment r6 = kotlinx.coroutines.channels.BufferedChannelKt.NULL_SEGMENT
            if (r5 == r6) goto L_0x0096
            r5 = r2
            goto L_0x0097
        L_0x0096:
            r5 = r1
        L_0x0097:
            if (r5 == 0) goto L_0x0081
            r3.add(r4)
            goto L_0x0081
        L_0x009d:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r0 = r3.iterator()
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0237
            java.lang.Object r3 = r0.next()
            boolean r4 = r0.hasNext()
            if (r4 != 0) goto L_0x00b6
            goto L_0x00d0
        L_0x00b6:
            r4 = r3
            kotlinx.coroutines.channels.ChannelSegment r4 = (kotlinx.coroutines.channels.ChannelSegment) r4
            long r4 = r4.id
        L_0x00bb:
            java.lang.Object r6 = r0.next()
            r7 = r6
            kotlinx.coroutines.channels.ChannelSegment r7 = (kotlinx.coroutines.channels.ChannelSegment) r7
            long r7 = r7.id
            int r9 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r9 <= 0) goto L_0x00ca
            r3 = r6
            r4 = r7
        L_0x00ca:
            boolean r6 = r0.hasNext()
            if (r6 != 0) goto L_0x00bb
        L_0x00d0:
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.getPrev()
            if (r0 != 0) goto L_0x00da
            r0 = r2
            goto L_0x00db
        L_0x00da:
            r0 = r1
        L_0x00db:
            if (r0 == 0) goto L_0x021a
        L_0x00dd:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.getNext()
            if (r0 == 0) goto L_0x0219
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 == 0) goto L_0x0104
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r0.getPrev()
            if (r0 != r3) goto L_0x0102
            goto L_0x0104
        L_0x0102:
            r0 = r1
            goto L_0x0105
        L_0x0104:
            r0 = r2
        L_0x0105:
            if (r0 == 0) goto L_0x01fc
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            r4 = r1
            r5 = r4
        L_0x010b:
            if (r4 >= r0) goto L_0x01b0
            java.lang.Object r6 = r3.getState$kotlinx_coroutines_core(r4)
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.BUFFERED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x01ac
            boolean r7 = r6 instanceof kotlinx.coroutines.Waiter
            if (r7 != 0) goto L_0x01ac
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0129
            r7 = r2
            goto L_0x0131
        L_0x0129:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.INTERRUPTED_SEND
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x0131:
            if (r7 == 0) goto L_0x0135
            r7 = r2
            goto L_0x013d
        L_0x0135:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.getCHANNEL_CLOSED()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x013d:
            java.lang.String r8 = "Check failed."
            if (r7 == 0) goto L_0x0159
            java.lang.Object r6 = r3.getElement$kotlinx_coroutines_core(r4)
            if (r6 != 0) goto L_0x0149
            r6 = r2
            goto L_0x014a
        L_0x0149:
            r6 = r1
        L_0x014a:
            if (r6 == 0) goto L_0x014f
            int r5 = r5 + 1
            goto L_0x01ac
        L_0x014f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r8.toString()
            r0.<init>(r1)
            throw r0
        L_0x0159:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.POISONED
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x0165
            r7 = r2
            goto L_0x016d
        L_0x0165:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.BufferedChannelKt.DONE_RCV
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
        L_0x016d:
            if (r7 == 0) goto L_0x0185
            java.lang.Object r6 = r3.getElement$kotlinx_coroutines_core(r4)
            if (r6 != 0) goto L_0x0177
            r6 = r2
            goto L_0x0178
        L_0x0177:
            r6 = r1
        L_0x0178:
            if (r6 == 0) goto L_0x017b
            goto L_0x01ac
        L_0x017b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = r8.toString()
            r0.<init>(r1)
            throw r0
        L_0x0185:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unexpected segment cell state: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r2 = ".\nChannel state: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01ac:
            int r4 = r4 + 1
            goto L_0x010b
        L_0x01b0:
            int r0 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            if (r5 != r0) goto L_0x01f0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = receiveSegment$FU
            java.lang.Object r0 = r0.get(r10)
            if (r3 == r0) goto L_0x01cf
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$FU
            java.lang.Object r0 = r0.get(r10)
            if (r3 == r0) goto L_0x01cf
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = bufferEndSegment$FU
            java.lang.Object r0 = r0.get(r10)
            if (r3 != r0) goto L_0x01cd
            goto L_0x01cf
        L_0x01cd:
            r0 = r1
            goto L_0x01d0
        L_0x01cf:
            r0 = r2
        L_0x01d0:
            if (r0 == 0) goto L_0x01d3
            goto L_0x01f0
        L_0x01d3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Logically removed segment is reachable.\nChannel state: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x01f0:
            kotlinx.coroutines.internal.ConcurrentLinkedListNode r0 = r3.getNext()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r3 = r0
            kotlinx.coroutines.channels.ChannelSegment r3 = (kotlinx.coroutines.channels.ChannelSegment) r3
            goto L_0x00dd
        L_0x01fc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The `segment.next.prev === segment` invariant is violated.\nChannel state: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0219:
            return
        L_0x021a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0237:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r0.<init>()
            throw r0
        L_0x023d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "bufferEndSegment should not have lower id than receiveSegment.\nChannel state: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r10)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.checkSegmentStructureInvariants():void");
    }

    /* access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super Unit> continuation) {
        UndeliveredElementException callUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (callUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Continuation continuation2 = cancellableContinuation;
            Throwable sendException = getSendException();
            Result.Companion companion = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation2 instanceof CoroutineStackFrame)) {
                sendException = StackTraceRecoveryKt.recoverFromStackFrame(sendException, (CoroutineStackFrame) continuation2);
            }
            continuation2.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            Throwable th = callUndeliveredElementCatchingException$default;
            ExceptionsKt.addSuppressed(th, getSendException());
            Continuation continuation3 = cancellableContinuation;
            Result.Companion companion2 = Result.Companion;
            if (DebugKt.getRECOVER_STACK_TRACES() && (continuation3 instanceof CoroutineStackFrame)) {
                th = StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation3);
            }
            continuation3.resumeWith(Result.m983constructorimpl(ResultKt.createFailure(th)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x014c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x014d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r22, int r23, E r24, long r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r27) {
        /*
            r21 = this;
            r9 = r21
            r0 = r24
            kotlin.coroutines.Continuation r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r27)
            kotlinx.coroutines.CancellableContinuationImpl r10 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r1)
            r7 = r10
            kotlinx.coroutines.Waiter r7 = (kotlinx.coroutines.Waiter) r7     // Catch:{ all -> 0x0150 }
            r8 = 0
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r24
            r5 = r25
            int r1 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0150 }
            if (r1 == 0) goto L_0x0128
            r11 = 1
            if (r1 == r11) goto L_0x011c
            r12 = 2
            if (r1 == r12) goto L_0x0111
            r13 = 4
            if (r1 == r13) goto L_0x0101
            java.lang.String r14 = "unexpected"
            r15 = 5
            if (r1 != r15) goto L_0x00f7
            r22.cleanPrev()     // Catch:{ all -> 0x0150 }
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = sendSegment$FU     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x0150 }
            kotlinx.coroutines.channels.ChannelSegment r1 = (kotlinx.coroutines.channels.ChannelSegment) r1     // Catch:{ all -> 0x0150 }
        L_0x003c:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = sendersAndCloseStatus$FU     // Catch:{ all -> 0x0150 }
            long r2 = r2.getAndIncrement(r9)     // Catch:{ all -> 0x0150 }
            r4 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r16 = r2 & r4
            boolean r18 = r9.isClosedForSend0(r2)     // Catch:{ all -> 0x0150 }
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0150 }
            long r2 = (long) r2     // Catch:{ all -> 0x0150 }
            long r2 = r16 / r2
            int r4 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x0150 }
            long r4 = (long) r4     // Catch:{ all -> 0x0150 }
            long r4 = r16 % r4
            int r8 = (int) r4     // Catch:{ all -> 0x0150 }
            long r4 = r1.id     // Catch:{ all -> 0x0150 }
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0072
            kotlinx.coroutines.channels.ChannelSegment r2 = r9.findSegmentSend(r2, r1)     // Catch:{ all -> 0x0150 }
            if (r2 != 0) goto L_0x0070
            if (r18 == 0) goto L_0x003c
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x0150 }
        L_0x006b:
            r9.onClosedSendOnNoWaiterSuspend(r0, r1)     // Catch:{ all -> 0x0150 }
            goto L_0x0139
        L_0x0070:
            r7 = r2
            goto L_0x0073
        L_0x0072:
            r7 = r1
        L_0x0073:
            r19 = r10
            kotlinx.coroutines.Waiter r19 = (kotlinx.coroutines.Waiter) r19     // Catch:{ all -> 0x0150 }
            r1 = r21
            r2 = r7
            r3 = r8
            r4 = r24
            r5 = r16
            r22 = r7
            r7 = r19
            r20 = r8
            r8 = r18
            int r1 = r1.updateCellSend(r2, r3, r4, r5, r7, r8)     // Catch:{ all -> 0x0150 }
            if (r1 == 0) goto L_0x00e6
            if (r1 == r11) goto L_0x00d7
            if (r1 == r12) goto L_0x00b8
            r2 = 3
            if (r1 == r2) goto L_0x00ae
            if (r1 == r13) goto L_0x009f
            if (r1 == r15) goto L_0x0099
            goto L_0x009c
        L_0x0099:
            r22.cleanPrev()     // Catch:{ all -> 0x0150 }
        L_0x009c:
            r1 = r22
            goto L_0x003c
        L_0x009f:
            long r1 = r21.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0150 }
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x00aa
            r22.cleanPrev()     // Catch:{ all -> 0x0150 }
        L_0x00aa:
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x0150 }
            goto L_0x006b
        L_0x00ae:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0150 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0150 }
            r0.<init>(r1)     // Catch:{ all -> 0x0150 }
            throw r0     // Catch:{ all -> 0x0150 }
        L_0x00b8:
            if (r18 == 0) goto L_0x00c1
            r22.onSlotCleaned()     // Catch:{ all -> 0x0150 }
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x0150 }
            goto L_0x006b
        L_0x00c1:
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0150 }
            boolean r0 = r0 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x0150 }
            if (r0 == 0) goto L_0x00cc
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0150 }
            goto L_0x00cd
        L_0x00cc:
            r0 = 0
        L_0x00cd:
            if (r0 == 0) goto L_0x0139
            r2 = r22
            r1 = r20
            r9.prepareSenderForSuspension(r0, r2, r1)     // Catch:{ all -> 0x0150 }
            goto L_0x0139
        L_0x00d7:
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0150 }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0150 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = kotlin.Result.m983constructorimpl(r1)     // Catch:{ all -> 0x0150 }
        L_0x00e2:
            r0.resumeWith(r1)     // Catch:{ all -> 0x0150 }
            goto L_0x0139
        L_0x00e6:
            r2 = r22
            r2.cleanPrev()     // Catch:{ all -> 0x0150 }
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0150 }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0150 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = kotlin.Result.m983constructorimpl(r1)     // Catch:{ all -> 0x0150 }
            goto L_0x00e2
        L_0x00f7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0150 }
            java.lang.String r1 = r14.toString()     // Catch:{ all -> 0x0150 }
            r0.<init>(r1)     // Catch:{ all -> 0x0150 }
            throw r0     // Catch:{ all -> 0x0150 }
        L_0x0101:
            long r1 = r21.getReceiversCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x0150 }
            int r1 = (r25 > r1 ? 1 : (r25 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x010c
            r22.cleanPrev()     // Catch:{ all -> 0x0150 }
        L_0x010c:
            r1 = r10
            kotlinx.coroutines.CancellableContinuation r1 = (kotlinx.coroutines.CancellableContinuation) r1     // Catch:{ all -> 0x0150 }
            goto L_0x006b
        L_0x0111:
            r0 = r10
            kotlinx.coroutines.Waiter r0 = (kotlinx.coroutines.Waiter) r0     // Catch:{ all -> 0x0150 }
            r1 = r22
            r2 = r23
            r9.prepareSenderForSuspension(r0, r1, r2)     // Catch:{ all -> 0x0150 }
            goto L_0x0139
        L_0x011c:
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0150 }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0150 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = kotlin.Result.m983constructorimpl(r1)     // Catch:{ all -> 0x0150 }
            goto L_0x00e2
        L_0x0128:
            r1 = r22
            r22.cleanPrev()     // Catch:{ all -> 0x0150 }
            r0 = r10
            kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0     // Catch:{ all -> 0x0150 }
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0150 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0150 }
            java.lang.Object r1 = kotlin.Result.m983constructorimpl(r1)     // Catch:{ all -> 0x0150 }
            goto L_0x00e2
        L_0x0139:
            java.lang.Object r0 = r10.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x0146
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r27)
        L_0x0146:
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x014d
            return r0
        L_0x014d:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0150:
            r0 = move-exception
            r10.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, java.lang.Object, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c9, code lost:
        r0 = kotlin.Result.Companion;
        r11.resumeWith(kotlin.Result.m983constructorimpl(kotlin.coroutines.jvm.internal.Boxing.boxBoolean(true)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <E> java.lang.Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> r19, E r20, kotlin.coroutines.Continuation<? super java.lang.Boolean> r21) {
        /*
            r8 = r19
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r21)
            r10 = 1
            r9.<init>(r0, r10)
            r9.initCancellability()
            r11 = r9
            kotlinx.coroutines.CancellableContinuation r11 = (kotlinx.coroutines.CancellableContinuation) r11
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r0 = r8.onUndeliveredElement
            r12 = 0
            if (r0 != 0) goto L_0x0019
            r0 = r10
            goto L_0x001a
        L_0x0019:
            r0 = r12
        L_0x001a:
            if (r0 == 0) goto L_0x00e6
            kotlinx.coroutines.channels.BufferedChannel$SendBroadcast r13 = new kotlinx.coroutines.channels.BufferedChannel$SendBroadcast
            r13.<init>(r11)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$FU
            java.lang.Object r0 = r0.get(r8)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x002b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$FU
            long r1 = r1.getAndIncrement(r8)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r14 = r1 & r3
            boolean r16 = r8.isClosedForSend0(r1)
            int r1 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r1 = (long) r1
            long r1 = r14 / r1
            int r3 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r3 = (long) r3
            long r3 = r14 % r3
            int r7 = (int) r3
            long r3 = r0.id
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x005a
            kotlinx.coroutines.channels.ChannelSegment r1 = r8.findSegmentSend(r1, r0)
            if (r1 != 0) goto L_0x0058
            if (r16 == 0) goto L_0x002b
            goto L_0x00a2
        L_0x0058:
            r6 = r1
            goto L_0x005b
        L_0x005a:
            r6 = r0
        L_0x005b:
            r0 = r19
            r1 = r6
            r2 = r7
            r3 = r20
            r4 = r14
            r17 = r6
            r6 = r13
            r18 = r7
            r7 = r16
            int r0 = r0.updateCellSend(r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto L_0x00c4
            if (r0 == r10) goto L_0x00c9
            r1 = 2
            if (r0 == r1) goto L_0x009d
            r1 = 3
            if (r0 == r1) goto L_0x0090
            r1 = 4
            if (r0 == r1) goto L_0x0084
            r1 = 5
            if (r0 == r1) goto L_0x007e
            goto L_0x0081
        L_0x007e:
            r17.cleanPrev()
        L_0x0081:
            r0 = r17
            goto L_0x002b
        L_0x0084:
            long r0 = r19.getReceiversCounter$kotlinx_coroutines_core()
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x00a2
            r17.cleanPrev()
            goto L_0x00a2
        L_0x0090:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "unexpected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009d:
            if (r16 == 0) goto L_0x00b2
            r17.onSlotCleaned()
        L_0x00a2:
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r12)
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)
            r11.resumeWith(r0)
            goto L_0x00d8
        L_0x00b2:
            boolean r0 = r13 instanceof kotlinx.coroutines.Waiter
            if (r0 == 0) goto L_0x00b9
            kotlinx.coroutines.Waiter r13 = (kotlinx.coroutines.Waiter) r13
            goto L_0x00ba
        L_0x00b9:
            r13 = 0
        L_0x00ba:
            if (r13 == 0) goto L_0x00d8
            r1 = r17
            r0 = r18
            r8.prepareSenderForSuspension(r13, r1, r0)
            goto L_0x00d8
        L_0x00c4:
            r1 = r17
            r1.cleanPrev()
        L_0x00c9:
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)
            r11.resumeWith(r0)
        L_0x00d8:
            java.lang.Object r0 = r9.getResult()
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r1) goto L_0x00e5
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r21)
        L_0x00e5:
            return r0
        L_0x00e6:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v4, types: [kotlin.jvm.functions.Function1] */
    /* JADX WARNING: type inference failed for: r2v5, types: [kotlinx.coroutines.Waiter] */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> r10, int r11, long r12, kotlin.coroutines.Continuation<? super E> r14) {
        /*
            r9 = this;
            kotlin.coroutines.Continuation r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r14)
            kotlinx.coroutines.CancellableContinuationImpl r0 = kotlinx.coroutines.CancellableContinuationKt.getOrCreateCancellableContinuation(r0)
            r6 = r0
            kotlinx.coroutines.Waiter r6 = (kotlinx.coroutines.Waiter) r6     // Catch:{ all -> 0x00e3 }
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            java.lang.Object r1 = r1.updateCellReceive(r2, r3, r4, r6)     // Catch:{ all -> 0x00e3 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00e3 }
            if (r1 != r2) goto L_0x0021
            r12 = r0
            kotlinx.coroutines.Waiter r12 = (kotlinx.coroutines.Waiter) r12     // Catch:{ all -> 0x00e3 }
            r9.prepareReceiverForSuspension(r12, r10, r11)     // Catch:{ all -> 0x00e3 }
            goto L_0x00d5
        L_0x0021:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00e3 }
            r2 = 0
            if (r1 != r11) goto L_0x00c5
            long r3 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00e3 }
            int r11 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x0033
            r10.cleanPrev()     // Catch:{ all -> 0x00e3 }
        L_0x0033:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r10 = receiveSegment$FU     // Catch:{ all -> 0x00e3 }
            java.lang.Object r10 = r10.get(r9)     // Catch:{ all -> 0x00e3 }
            kotlinx.coroutines.channels.ChannelSegment r10 = (kotlinx.coroutines.channels.ChannelSegment) r10     // Catch:{ all -> 0x00e3 }
        L_0x003d:
            boolean r11 = r9.isClosedForReceive()     // Catch:{ all -> 0x00e3 }
            if (r11 == 0) goto L_0x004b
            r10 = r0
            kotlinx.coroutines.CancellableContinuation r10 = (kotlinx.coroutines.CancellableContinuation) r10     // Catch:{ all -> 0x00e3 }
            r9.onClosedReceiveOnNoWaiterSuspend(r10)     // Catch:{ all -> 0x00e3 }
            goto L_0x00d5
        L_0x004b:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r11 = receivers$FU     // Catch:{ all -> 0x00e3 }
            long r11 = r11.getAndIncrement(r9)     // Catch:{ all -> 0x00e3 }
            int r13 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00e3 }
            long r3 = (long) r13     // Catch:{ all -> 0x00e3 }
            long r3 = r11 / r3
            int r13 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE     // Catch:{ all -> 0x00e3 }
            long r5 = (long) r13     // Catch:{ all -> 0x00e3 }
            long r5 = r11 % r5
            int r13 = (int) r5     // Catch:{ all -> 0x00e3 }
            long r5 = r10.id     // Catch:{ all -> 0x00e3 }
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x006c
            kotlinx.coroutines.channels.ChannelSegment r1 = r9.findSegmentReceive(r3, r10)     // Catch:{ all -> 0x00e3 }
            if (r1 != 0) goto L_0x006b
            goto L_0x003d
        L_0x006b:
            r10 = r1
        L_0x006c:
            r8 = r0
            kotlinx.coroutines.Waiter r8 = (kotlinx.coroutines.Waiter) r8     // Catch:{ all -> 0x00e3 }
            r3 = r9
            r4 = r10
            r5 = r13
            r6 = r11
            java.lang.Object r1 = r3.updateCellReceive(r4, r5, r6, r8)     // Catch:{ all -> 0x00e3 }
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND     // Catch:{ all -> 0x00e3 }
            if (r1 != r3) goto L_0x008d
            r11 = r0
            kotlinx.coroutines.Waiter r11 = (kotlinx.coroutines.Waiter) r11     // Catch:{ all -> 0x00e3 }
            boolean r11 = r11 instanceof kotlinx.coroutines.Waiter     // Catch:{ all -> 0x00e3 }
            if (r11 == 0) goto L_0x0087
            r2 = r0
            kotlinx.coroutines.Waiter r2 = (kotlinx.coroutines.Waiter) r2     // Catch:{ all -> 0x00e3 }
        L_0x0087:
            if (r2 == 0) goto L_0x00d5
            r9.prepareReceiverForSuspension(r2, r10, r13)     // Catch:{ all -> 0x00e3 }
            goto L_0x00d5
        L_0x008d:
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.channels.BufferedChannelKt.FAILED     // Catch:{ all -> 0x00e3 }
            if (r1 != r13) goto L_0x009f
            long r3 = r9.getSendersCounter$kotlinx_coroutines_core()     // Catch:{ all -> 0x00e3 }
            int r11 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r11 >= 0) goto L_0x003d
            r10.cleanPrev()     // Catch:{ all -> 0x00e3 }
            goto L_0x003d
        L_0x009f:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.channels.BufferedChannelKt.SUSPEND_NO_WAITER     // Catch:{ all -> 0x00e3 }
            if (r1 == r11) goto L_0x00b8
            r10.cleanPrev()     // Catch:{ all -> 0x00e3 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r10 = r9.onUndeliveredElement     // Catch:{ all -> 0x00e3 }
            if (r10 == 0) goto L_0x00b4
            kotlin.coroutines.CoroutineContext r11 = r0.getContext()     // Catch:{ all -> 0x00e3 }
            kotlin.jvm.functions.Function1 r2 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r10, r1, r11)     // Catch:{ all -> 0x00e3 }
        L_0x00b4:
            r0.resume(r1, r2)     // Catch:{ all -> 0x00e3 }
            goto L_0x00d5
        L_0x00b8:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e3 }
            java.lang.String r11 = "unexpected"
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e3 }
            r10.<init>(r11)     // Catch:{ all -> 0x00e3 }
            throw r10     // Catch:{ all -> 0x00e3 }
        L_0x00c5:
            r10.cleanPrev()     // Catch:{ all -> 0x00e3 }
            kotlin.jvm.functions.Function1<E, kotlin.Unit> r10 = r9.onUndeliveredElement     // Catch:{ all -> 0x00e3 }
            if (r10 == 0) goto L_0x00b4
            kotlin.coroutines.CoroutineContext r11 = r0.getContext()     // Catch:{ all -> 0x00e3 }
            kotlin.jvm.functions.Function1 r2 = kotlinx.coroutines.internal.OnUndeliveredElementKt.bindCancellationFun(r10, r1, r11)     // Catch:{ all -> 0x00e3 }
            goto L_0x00b4
        L_0x00d5:
            java.lang.Object r10 = r0.getResult()
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r10 != r11) goto L_0x00e2
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r14)
        L_0x00e2:
            return r10
        L_0x00e3:
            r10 = move-exception
            r0.releaseClaimedReusableContinuation$kotlinx_coroutines_core()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment, int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008b, code lost:
        r14.selectInRegistrationPhase(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerSelectForSend(kotlinx.coroutines.selects.SelectInstance<?> r14, java.lang.Object r15) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = sendSegment$FU
            java.lang.Object r0 = r0.get(r13)
            kotlinx.coroutines.channels.ChannelSegment r0 = (kotlinx.coroutines.channels.ChannelSegment) r0
        L_0x000a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = sendersAndCloseStatus$FU
            long r1 = r1.getAndIncrement(r13)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r3 = r3 & r1
            boolean r1 = r13.isClosedForSend0(r1)
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r5 = (long) r2
            long r5 = r3 / r5
            int r2 = kotlinx.coroutines.channels.BufferedChannelKt.SEGMENT_SIZE
            long r7 = (long) r2
            long r7 = r3 % r7
            int r2 = (int) r7
            long r7 = r0.id
            int r7 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0037
            kotlinx.coroutines.channels.ChannelSegment r5 = r13.findSegmentSend(r5, r0)
            if (r5 != 0) goto L_0x0036
            if (r1 == 0) goto L_0x000a
            goto L_0x0076
        L_0x0036:
            r0 = r5
        L_0x0037:
            r5 = r13
            r6 = r0
            r7 = r2
            r8 = r15
            r9 = r3
            r11 = r14
            r12 = r1
            int r5 = r5.updateCellSend(r6, r7, r8, r9, r11, r12)
            if (r5 == 0) goto L_0x0088
            r6 = 1
            if (r5 == r6) goto L_0x008b
            r6 = 2
            if (r5 == r6) goto L_0x0071
            r1 = 3
            if (r5 == r1) goto L_0x0064
            r1 = 4
            if (r5 == r1) goto L_0x0058
            r1 = 5
            if (r5 == r1) goto L_0x0054
            goto L_0x000a
        L_0x0054:
            r0.cleanPrev()
            goto L_0x000a
        L_0x0058:
            long r1 = r13.getReceiversCounter$kotlinx_coroutines_core()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0076
            r0.cleanPrev()
            goto L_0x0076
        L_0x0064:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        L_0x0071:
            if (r1 == 0) goto L_0x007a
            r0.onSlotCleaned()
        L_0x0076:
            r13.onClosedSelectOnSend(r15, r14)
            goto L_0x0090
        L_0x007a:
            boolean r15 = r14 instanceof kotlinx.coroutines.Waiter
            if (r15 == 0) goto L_0x0081
            kotlinx.coroutines.Waiter r14 = (kotlinx.coroutines.Waiter) r14
            goto L_0x0082
        L_0x0081:
            r14 = 0
        L_0x0082:
            if (r14 == 0) goto L_0x0090
            r13.prepareSenderForSuspension(r14, r0, r2)
            goto L_0x0090
        L_0x0088:
            r0.cleanPrev()
        L_0x008b:
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            r14.selectInRegistrationPhase(r15)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BufferedChannel.registerSelectForSend(kotlinx.coroutines.selects.SelectInstance, java.lang.Object):void");
    }

    /* access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> selectInstance, Object obj) {
        ChannelSegment channelSegment = (ChannelSegment) receiveSegment$FU.get(this);
        while (!isClosedForReceive()) {
            long andIncrement = receivers$FU.getAndIncrement(this);
            long j = andIncrement / ((long) BufferedChannelKt.SEGMENT_SIZE);
            int i = (int) (andIncrement % ((long) BufferedChannelKt.SEGMENT_SIZE));
            if (channelSegment.id != j) {
                ChannelSegment access$findSegmentReceive = findSegmentReceive(j, channelSegment);
                if (access$findSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = access$findSegmentReceive;
                }
            }
            Object access$updateCellReceive = updateCellReceive(channelSegment, i, andIncrement, selectInstance);
            if (access$updateCellReceive == BufferedChannelKt.SUSPEND) {
                Waiter waiter = selectInstance instanceof Waiter ? (Waiter) selectInstance : null;
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i);
                    return;
                }
                return;
            } else if (access$updateCellReceive == BufferedChannelKt.FAILED) {
                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else if (access$updateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                channelSegment.cleanPrev();
                selectInstance.selectInRegistrationPhase(access$updateCellReceive);
                return;
            } else {
                throw new IllegalStateException("unexpected".toString());
            }
        }
        onClosedSelectOnReceive(selectInstance);
    }
}
