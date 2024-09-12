package com.adapty.internal.utils;

import com.adapty.errors.AdaptyError;
import com.adapty.errors.AdaptyErrorCode;
import com.adapty.utils.AdaptyResult;
import java.util.UUID;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Semaphore;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0016\u001a\u00020\u00172'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a\u0010\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u0001H\u0000\u001a\b\u0010!\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\u0006\u0010$\u001a\u00020\u0001H\u0000\u001a\u0010\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0000\u001a\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H)0(\"\u0004\b\u0000\u0010)2\u0006\u0010*\u001a\u00020\u0003H\u0002\u001a,\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H)0(\"\u0004\b\u0000\u0010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H)0(2\u0006\u0010*\u001a\u00020\u0003H\u0000\u001a\f\u0010,\u001a\u00020-*\u00020.H\u0000\u001a\u0012\u0010/\u001a\u0004\u0018\u00010-*\u0006\u0012\u0002\b\u000300H\u0000\u001a\u001e\u00101\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(H\u0000\u001a\u001e\u00102\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(H\u0000\u001a\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002H)04\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)05H\u0000\u001a0\u00103\u001a\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H806\"\u0004\b\u0000\u00107\"\u0004\b\u0001\u00108*\u000e\u0012\u0004\u0012\u0002H7\u0012\u0004\u0012\u0002H809H\u0000\u001aV\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)000(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(2(\u0010;\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H)00\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019H\u0000ø\u0001\u0000¢\u0006\u0002\u0010<\u001a\f\u0010=\u001a\u00020\u001b*\u00020>H\u0000\u001a(\u0010?\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(2\b\b\u0002\u0010@\u001a\u00020\u0007H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00038\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u000e8\u0000X\u0004¢\u0006\u0002\n\u0000\"#\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108@X\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"DEFAULT_PAYWALL_LOCALE", "", "DEFAULT_PAYWALL_TIMEOUT_MILLIS", "", "getDEFAULT_PAYWALL_TIMEOUT_MILLIS$annotations", "()V", "DEFAULT_RETRY_COUNT", "", "INFINITE_RETRY", "INF_PAYWALL_TIMEOUT_MILLIS", "MIN_PAYWALL_TIMEOUT_MILLIS", "NETWORK_ERROR_DELAY_MILLIS", "PAYWALL_TIMEOUT_MILLIS_SHIFT", "adaptyScope", "Lkotlinx/coroutines/CoroutineScope;", "noLetterRegex", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "getNoLetterRegex", "()Ljava/util/regex/Pattern;", "noLetterRegex$delegate", "Lkotlin/Lazy;", "execute", "Lkotlinx/coroutines/Job;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "extractLanguageCode", "locale", "generateUuid", "getClassForNameOrNull", "Ljava/lang/Class;", "className", "getServerErrorDelay", "attempt", "getTimeoutFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "timeout", "flow", "asAdaptyError", "Lcom/adapty/errors/AdaptyError;", "", "errorOrNull", "Lcom/adapty/utils/AdaptyResult;", "flowOnIO", "flowOnMain", "immutableWithInterop", "Lcom/adapty/utils/ImmutableList;", "", "Lcom/adapty/utils/ImmutableMap;", "K", "V", "", "onSingleResult", "action", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "releaseQuietly", "Lkotlinx/coroutines/sync/Semaphore;", "retryIfNecessary", "maxAttemptCount", "adapty_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: utils.kt */
public final class UtilsKt {
    public static final /* synthetic */ String DEFAULT_PAYWALL_LOCALE = "en";
    public static final int DEFAULT_PAYWALL_TIMEOUT_MILLIS = 5000;
    public static final /* synthetic */ long DEFAULT_RETRY_COUNT = 3;
    public static final /* synthetic */ long INFINITE_RETRY = -1;
    public static final /* synthetic */ int INF_PAYWALL_TIMEOUT_MILLIS = Integer.MAX_VALUE;
    public static final /* synthetic */ int MIN_PAYWALL_TIMEOUT_MILLIS = 1000;
    public static final /* synthetic */ long NETWORK_ERROR_DELAY_MILLIS = 2000;
    public static final /* synthetic */ int PAYWALL_TIMEOUT_MILLIS_SHIFT = 500;
    public static final /* synthetic */ CoroutineScope adaptyScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private static final Lazy noLetterRegex$delegate = LazyKt.lazy(UtilsKt$noLetterRegex$2.INSTANCE);

    @InternalAdaptyApi
    public static /* synthetic */ void getDEFAULT_PAYWALL_TIMEOUT_MILLIS$annotations() {
    }

    public static final /* synthetic */ String generateUuid() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }

    public static final /* synthetic */ Class getClassForNameOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "className");
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static final /* synthetic */ AdaptyError asAdaptyError(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        AdaptyError adaptyError = th instanceof AdaptyError ? (AdaptyError) th : null;
        if (adaptyError != null) {
            return adaptyError;
        }
        return new AdaptyError(th, (String) null, AdaptyErrorCode.UNKNOWN, 2, (DefaultConstructorMarker) null);
    }

    public static final /* synthetic */ Flow onSingleResult(Flow flow, Function2 function2) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        return FlowKt.onEach(FlowKt.m2547catch(new UtilsKt$onSingleResult$$inlined$map$1(flow), new UtilsKt$onSingleResult$2((Continuation<? super UtilsKt$onSingleResult$2>) null)), new UtilsKt$onSingleResult$3(new Ref.BooleanRef(), function2, (Continuation<? super UtilsKt$onSingleResult$3>) null));
    }

    public static final /* synthetic */ AdaptyError errorOrNull(AdaptyResult adaptyResult) {
        Intrinsics.checkNotNullParameter(adaptyResult, "<this>");
        AdaptyResult.Error error = adaptyResult instanceof AdaptyResult.Error ? (AdaptyResult.Error) adaptyResult : null;
        if (error != null) {
            return error.getError();
        }
        return null;
    }

    public static final /* synthetic */ void releaseQuietly(Semaphore semaphore) {
        Intrinsics.checkNotNullParameter(semaphore, "<this>");
        try {
            semaphore.release();
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ Pattern getNoLetterRegex() {
        return (Pattern) noLetterRegex$delegate.getValue();
    }

    public static final /* synthetic */ String extractLanguageCode(String str) {
        Intrinsics.checkNotNullParameter(str, "locale");
        Pattern noLetterRegex = getNoLetterRegex();
        Intrinsics.checkNotNullExpressionValue(noLetterRegex, "noLetterRegex");
        String str2 = (String) CollectionsKt.firstOrNull(StringsKt.split(str, noLetterRegex, 1));
        return str2 == null ? "" : str2;
    }

    private static final <T> Flow<T> getTimeoutFlow(int i) {
        return FlowKt.flow(new UtilsKt$getTimeoutFlow$1(i, (Continuation<? super UtilsKt$getTimeoutFlow$1>) null));
    }

    public static final /* synthetic */ long getServerErrorDelay(long j) {
        return ((long) Math.min(((float) Math.pow((double) 2.0f, (double) ((int) RangesKt.coerceAtMost(j + ((long) 3), 7)))) + ((float) 1), 90.0f)) * 1000;
    }

    public static /* synthetic */ Flow retryIfNecessary$default(Flow flow, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = -1;
        }
        return Intrinsics.checkNotNullParameter(flow, "<this>");
    }
}
