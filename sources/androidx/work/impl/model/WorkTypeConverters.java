package androidx.work.impl.model;

import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u001c\u001d\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J\u0016\u0010\u0018\u001a\u00020\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0013H\u0007¨\u0006 "}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters;", "", "()V", "backoffPolicyToInt", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "byteArrayToSetOfTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "bytes", "", "intToBackoffPolicy", "value", "intToNetworkType", "Landroidx/work/NetworkType;", "intToOutOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "intToState", "Landroidx/work/WorkInfo$State;", "networkTypeToInt", "networkType", "outOfQuotaPolicyToInt", "policy", "setOfTriggersToByteArray", "triggers", "stateToInt", "state", "BackoffPolicyIds", "NetworkTypeIds", "OutOfPolicyIds", "StateIds", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkTypeConverters.kt */
public final class WorkTypeConverters {
    public static final WorkTypeConverters INSTANCE = new WorkTypeConverters();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTypeConverters.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|(2:25|26)|27|29|30|31|32|33|34|35|36|37|38|39|41|42|(2:43|44)|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|(2:19|20)|21|23|24|25|26|27|29|30|31|32|33|34|35|36|37|38|39|41|42|43|44|45|47) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0077 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x007f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0098 */
        static {
            /*
                androidx.work.WorkInfo$State[] r0 = androidx.work.WorkInfo.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                androidx.work.WorkInfo$State r2 = androidx.work.WorkInfo.State.ENQUEUED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                androidx.work.WorkInfo$State r3 = androidx.work.WorkInfo.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                androidx.work.WorkInfo$State r4 = androidx.work.WorkInfo.State.SUCCEEDED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                androidx.work.WorkInfo$State r5 = androidx.work.WorkInfo.State.FAILED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.BLOCKED     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.CANCELLED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r7 = 6
                r0[r6] = r7     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                androidx.work.BackoffPolicy[] r0 = androidx.work.BackoffPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.EXPONENTIAL     // Catch:{ NoSuchFieldError -> 0x004e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                androidx.work.BackoffPolicy r6 = androidx.work.BackoffPolicy.LINEAR     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                $EnumSwitchMapping$1 = r0
                androidx.work.NetworkType[] r0 = androidx.work.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.NetworkType r6 = androidx.work.NetworkType.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r6] = r1     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.CONNECTED     // Catch:{ NoSuchFieldError -> 0x006f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r0[r6] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                androidx.work.NetworkType r6 = androidx.work.NetworkType.UNMETERED     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r0[r6] = r3     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.NOT_ROAMING     // Catch:{ NoSuchFieldError -> 0x007f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007f }
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x007f }
            L_0x007f:
                androidx.work.NetworkType r3 = androidx.work.NetworkType.METERED     // Catch:{ NoSuchFieldError -> 0x0087 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0087 }
                r0[r3] = r5     // Catch:{ NoSuchFieldError -> 0x0087 }
            L_0x0087:
                $EnumSwitchMapping$2 = r0
                androidx.work.OutOfQuotaPolicy[] r0 = androidx.work.OutOfQuotaPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                androidx.work.OutOfQuotaPolicy r3 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x0098 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0098 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0098 }
            L_0x0098:
                androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.DROP_WORK_REQUEST     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                $EnumSwitchMapping$3 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.WhenMappings.<clinit>():void");
        }
    }

    private WorkTypeConverters() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$StateIds;", "", "()V", "BLOCKED", "", "CANCELLED", "COMPLETED_STATES", "", "ENQUEUED", "FAILED", "RUNNING", "SUCCEEDED", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTypeConverters.kt */
    public static final class StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final StateIds INSTANCE = new StateIds();
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;

        private StateIds() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$BackoffPolicyIds;", "", "()V", "EXPONENTIAL", "", "LINEAR", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTypeConverters.kt */
    private static final class BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final BackoffPolicyIds INSTANCE = new BackoffPolicyIds();
        public static final int LINEAR = 1;

        private BackoffPolicyIds() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$NetworkTypeIds;", "", "()V", "CONNECTED", "", "METERED", "NOT_REQUIRED", "NOT_ROAMING", "TEMPORARILY_UNMETERED", "UNMETERED", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTypeConverters.kt */
    private static final class NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final NetworkTypeIds INSTANCE = new NetworkTypeIds();
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;

        private NetworkTypeIds() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/work/impl/model/WorkTypeConverters$OutOfPolicyIds;", "", "()V", "DROP_WORK_REQUEST", "", "RUN_AS_NON_EXPEDITED_WORK_REQUEST", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkTypeConverters.kt */
    private static final class OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final OutOfPolicyIds INSTANCE = new OutOfPolicyIds();
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;

        private OutOfPolicyIds() {
        }
    }

    @JvmStatic
    public static final int stateToInt(WorkInfo.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @JvmStatic
    public static final WorkInfo.State intToState(int i) {
        if (i == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to State");
    }

    @JvmStatic
    public static final int backoffPolicyToInt(BackoffPolicy backoffPolicy) {
        Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
        int i = WhenMappings.$EnumSwitchMapping$1[backoffPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final BackoffPolicy intToBackoffPolicy(int i) {
        if (i == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to BackoffPolicy");
    }

    @JvmStatic
    public static final int networkTypeToInt(NetworkType networkType) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        int i = WhenMappings.$EnumSwitchMapping$2[networkType.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 3;
        }
        if (i == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    @JvmStatic
    public static final NetworkType intToNetworkType(int i) {
        if (i == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i == 1) {
            return NetworkType.CONNECTED;
        }
        if (i == 2) {
            return NetworkType.UNMETERED;
        }
        if (i == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to NetworkType");
    }

    @JvmStatic
    public static final int outOfQuotaPolicyToInt(OutOfQuotaPolicy outOfQuotaPolicy) {
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "policy");
        int i = WhenMappings.$EnumSwitchMapping$3[outOfQuotaPolicy.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final OutOfQuotaPolicy intToOutOfQuotaPolicy(int i) {
        if (i == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i + " to OutOfQuotaPolicy");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0068, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0070, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0073, code lost:
        throw r0;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] setOfTriggersToByteArray(java.util.Set<androidx.work.Constraints.ContentUriTrigger> r6) {
        /*
            java.lang.String r0 = "triggers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L_0x000f
            r6 = 0
            byte[] r6 = new byte[r6]
            return r6
        L_0x000f:
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = r0
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            java.io.ByteArrayOutputStream r2 = (java.io.ByteArrayOutputStream) r2     // Catch:{ all -> 0x006d }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x006d }
            r3 = r0
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x006d }
            r2.<init>(r3)     // Catch:{ all -> 0x006d }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x006d }
            r3 = r2
            java.io.ObjectOutputStream r3 = (java.io.ObjectOutputStream) r3     // Catch:{ all -> 0x0066 }
            int r4 = r6.size()     // Catch:{ all -> 0x0066 }
            r3.writeInt(r4)     // Catch:{ all -> 0x0066 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0066 }
        L_0x0032:
            boolean r4 = r6.hasNext()     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r6.next()     // Catch:{ all -> 0x0066 }
            androidx.work.Constraints$ContentUriTrigger r4 = (androidx.work.Constraints.ContentUriTrigger) r4     // Catch:{ all -> 0x0066 }
            android.net.Uri r5 = r4.getUri()     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0066 }
            r3.writeUTF(r5)     // Catch:{ all -> 0x0066 }
            boolean r4 = r4.isTriggeredForDescendants()     // Catch:{ all -> 0x0066 }
            r3.writeBoolean(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x0032
        L_0x0051:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0066 }
            r6 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x006d }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x006d }
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            byte[] r6 = r0.toByteArray()
            java.lang.String r0 = "outputStream.toByteArray()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            return r6
        L_0x0066:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r6)     // Catch:{ all -> 0x006d }
            throw r0     // Catch:{ all -> 0x006d }
        L_0x006d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x006f }
        L_0x006f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.setOfTriggersToByteArray(java.util.Set):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        kotlin.io.CloseableKt.closeFinally(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006d, code lost:
        throw r1;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.Set<androidx.work.Constraints.ContentUriTrigger> byteArrayToSetOfTriggers(byte[] r10) {
        /*
            java.lang.String r0 = "bytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            java.util.Set r0 = (java.util.Set) r0
            int r1 = r10.length
            r2 = 0
            if (r1 != 0) goto L_0x0012
            r1 = 1
            goto L_0x0013
        L_0x0012:
            r1 = r2
        L_0x0013:
            if (r1 == 0) goto L_0x0016
            return r0
        L_0x0016:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r10)
            r10 = r1
            java.io.Closeable r10 = (java.io.Closeable) r10
            r3 = r10
            java.io.ByteArrayInputStream r3 = (java.io.ByteArrayInputStream) r3     // Catch:{ all -> 0x0067 }
            r3 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x005d }
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ IOException -> 0x005d }
            r4.<init>(r1)     // Catch:{ IOException -> 0x005d }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ IOException -> 0x005d }
            r1 = r4
            java.io.ObjectInputStream r1 = (java.io.ObjectInputStream) r1     // Catch:{ all -> 0x0056 }
            int r5 = r1.readInt()     // Catch:{ all -> 0x0056 }
        L_0x0032:
            if (r2 >= r5) goto L_0x0050
            java.lang.String r6 = r1.readUTF()     // Catch:{ all -> 0x0056 }
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch:{ all -> 0x0056 }
            boolean r7 = r1.readBoolean()     // Catch:{ all -> 0x0056 }
            androidx.work.Constraints$ContentUriTrigger r8 = new androidx.work.Constraints$ContentUriTrigger     // Catch:{ all -> 0x0056 }
            java.lang.String r9 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r9)     // Catch:{ all -> 0x0056 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0056 }
            r0.add(r8)     // Catch:{ all -> 0x0056 }
            int r2 = r2 + 1
            goto L_0x0032
        L_0x0050:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0056 }
            kotlin.io.CloseableKt.closeFinally(r4, r3)     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x0056:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ IOException -> 0x005d }
            throw r2     // Catch:{ IOException -> 0x005d }
        L_0x005d:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0067 }
        L_0x0061:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0067 }
            kotlin.io.CloseableKt.closeFinally(r10, r3)
            return r0
        L_0x0067:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r10, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkTypeConverters.byteArrayToSetOfTriggers(byte[]):java.util.Set");
    }
}
