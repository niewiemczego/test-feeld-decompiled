package com.launchdarkly.sdk;

import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.json.JsonSerializable;
import java.util.Objects;

@JsonAdapter(EvaluationReasonTypeAdapter.class)
public final class EvaluationReason implements JsonSerializable {
    private static final EvaluationReason ERROR_CLIENT_NOT_READY = new EvaluationReason(ErrorKind.CLIENT_NOT_READY, (Exception) null);
    private static final EvaluationReason ERROR_EXCEPTION = new EvaluationReason(ErrorKind.EXCEPTION, (Exception) null);
    private static final EvaluationReason ERROR_FLAG_NOT_FOUND = new EvaluationReason(ErrorKind.FLAG_NOT_FOUND, (Exception) null);
    private static final EvaluationReason ERROR_MALFORMED_FLAG = new EvaluationReason(ErrorKind.MALFORMED_FLAG, (Exception) null);
    private static final EvaluationReason ERROR_USER_NOT_SPECIFIED = new EvaluationReason(ErrorKind.USER_NOT_SPECIFIED, (Exception) null);
    private static final EvaluationReason ERROR_WRONG_TYPE = new EvaluationReason(ErrorKind.WRONG_TYPE, (Exception) null);
    private static final EvaluationReason FALLTHROUGH_INSTANCE = new EvaluationReason(Kind.FALLTHROUGH);
    private static final EvaluationReason FALLTHROUGH_INSTANCE_IN_EXPERIMENT = new EvaluationReason(Kind.FALLTHROUGH, IN_EXPERIMENT);
    private static boolean IN_EXPERIMENT = true;
    private static boolean NOT_IN_EXPERIMENT = false;
    private static final EvaluationReason OFF_INSTANCE = new EvaluationReason(Kind.OFF);
    private static final EvaluationReason TARGET_MATCH_INSTANCE = new EvaluationReason(Kind.TARGET_MATCH);
    private final BigSegmentsStatus bigSegmentsStatus;
    private final ErrorKind errorKind;
    private final Exception exception;
    private final boolean inExperiment;
    private final Kind kind;
    private final String prerequisiteKey;
    private final String ruleId;
    private final int ruleIndex;

    public enum BigSegmentsStatus {
        HEALTHY,
        STALE,
        NOT_CONFIGURED,
        STORE_ERROR
    }

    public enum ErrorKind {
        CLIENT_NOT_READY,
        FLAG_NOT_FOUND,
        MALFORMED_FLAG,
        USER_NOT_SPECIFIED,
        WRONG_TYPE,
        EXCEPTION
    }

    public enum Kind {
        OFF,
        FALLTHROUGH,
        TARGET_MATCH,
        RULE_MATCH,
        PREREQUISITE_FAILED,
        ERROR
    }

    private EvaluationReason(Kind kind2, int i, String str, String str2, boolean z, ErrorKind errorKind2, Exception exc, BigSegmentsStatus bigSegmentsStatus2) {
        this.kind = kind2;
        this.ruleIndex = i;
        this.ruleId = str;
        this.prerequisiteKey = str2;
        this.inExperiment = z;
        this.errorKind = errorKind2;
        this.exception = exc;
        this.bigSegmentsStatus = bigSegmentsStatus2;
    }

    private EvaluationReason(Kind kind2) {
        this(kind2, -1, (String) null, (String) null, NOT_IN_EXPERIMENT, (ErrorKind) null, (Exception) null, (BigSegmentsStatus) null);
    }

    private EvaluationReason(Kind kind2, boolean z) {
        this(kind2, -1, (String) null, (String) null, z, (ErrorKind) null, (Exception) null, (BigSegmentsStatus) null);
    }

    private EvaluationReason(ErrorKind errorKind2, Exception exc) {
        this(Kind.ERROR, -1, (String) null, (String) null, NOT_IN_EXPERIMENT, errorKind2, exc, (BigSegmentsStatus) null);
    }

    public Kind getKind() {
        return this.kind;
    }

    public int getRuleIndex() {
        return this.ruleIndex;
    }

    public String getRuleId() {
        return this.ruleId;
    }

    public String getPrerequisiteKey() {
        return this.prerequisiteKey;
    }

    public boolean isInExperiment() {
        return this.inExperiment;
    }

    public ErrorKind getErrorKind() {
        return this.errorKind;
    }

    public Exception getException() {
        return this.exception;
    }

    public BigSegmentsStatus getBigSegmentsStatus() {
        return this.bigSegmentsStatus;
    }

    public EvaluationReason withBigSegmentsStatus(BigSegmentsStatus bigSegmentsStatus2) {
        return new EvaluationReason(this.kind, this.ruleIndex, this.ruleId, this.prerequisiteKey, this.inExperiment, this.errorKind, this.exception, bigSegmentsStatus2);
    }

    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind[this.kind.ordinal()];
        String str = "";
        if (i == 1) {
            StringBuilder append = new StringBuilder().append(this.kind).append("(").append(this.ruleIndex);
            if (this.ruleId != null) {
                str = "," + this.ruleId;
            }
            return append.append(str).append(")").toString();
        } else if (i == 2) {
            return this.kind + "(" + this.prerequisiteKey + ")";
        } else {
            if (i != 3) {
                return getKind().name();
            }
            StringBuilder append2 = new StringBuilder().append(this.kind).append("(").append(this.errorKind);
            if (this.exception != null) {
                str = "," + this.exception;
            }
            return append2.append(str).append(")").toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EvaluationReason)) {
            return false;
        }
        EvaluationReason evaluationReason = (EvaluationReason) obj;
        if (this.kind != evaluationReason.kind || this.ruleIndex != evaluationReason.ruleIndex || !Objects.equals(this.ruleId, evaluationReason.ruleId) || !Objects.equals(this.prerequisiteKey, evaluationReason.prerequisiteKey) || this.inExperiment != evaluationReason.inExperiment || !Objects.equals(this.errorKind, evaluationReason.errorKind) || !Objects.equals(this.exception, evaluationReason.exception) || !Objects.equals(this.bigSegmentsStatus, evaluationReason.bigSegmentsStatus)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.kind, Integer.valueOf(this.ruleIndex), this.ruleId, this.prerequisiteKey, Boolean.valueOf(this.inExperiment), this.errorKind, this.exception, this.bigSegmentsStatus});
    }

    public static EvaluationReason off() {
        return OFF_INSTANCE;
    }

    public static EvaluationReason fallthrough() {
        return FALLTHROUGH_INSTANCE;
    }

    public static EvaluationReason fallthrough(boolean z) {
        return z ? FALLTHROUGH_INSTANCE_IN_EXPERIMENT : FALLTHROUGH_INSTANCE;
    }

    public static EvaluationReason targetMatch() {
        return TARGET_MATCH_INSTANCE;
    }

    public static EvaluationReason ruleMatch(int i, String str) {
        return ruleMatch(i, str, NOT_IN_EXPERIMENT);
    }

    public static EvaluationReason ruleMatch(int i, String str, boolean z) {
        return new EvaluationReason(Kind.RULE_MATCH, i, str, (String) null, z, (ErrorKind) null, (Exception) null, (BigSegmentsStatus) null);
    }

    public static EvaluationReason prerequisiteFailed(String str) {
        return new EvaluationReason(Kind.PREREQUISITE_FAILED, -1, (String) null, str, NOT_IN_EXPERIMENT, (ErrorKind) null, (Exception) null, (BigSegmentsStatus) null);
    }

    /* renamed from: com.launchdarkly.sdk.EvaluationReason$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind;
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            /*
                com.launchdarkly.sdk.EvaluationReason$ErrorKind[] r0 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind = r0
                r1 = 1
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r2 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.CLIENT_NOT_READY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r3 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.EXCEPTION     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r4 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.FLAG_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r4 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.MALFORMED_FLAG     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r4 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.USER_NOT_SPECIFIED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.launchdarkly.sdk.EvaluationReason$ErrorKind r4 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.WRONG_TYPE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.launchdarkly.sdk.EvaluationReason$Kind[] r3 = com.launchdarkly.sdk.EvaluationReason.Kind.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind = r3
                com.launchdarkly.sdk.EvaluationReason$Kind r4 = com.launchdarkly.sdk.EvaluationReason.Kind.RULE_MATCH     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.launchdarkly.sdk.EvaluationReason$Kind r3 = com.launchdarkly.sdk.EvaluationReason.Kind.PREREQUISITE_FAILED     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x006e }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.ERROR     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.EvaluationReason.AnonymousClass1.<clinit>():void");
        }
    }

    public static EvaluationReason error(ErrorKind errorKind2) {
        switch (AnonymousClass1.$SwitchMap$com$launchdarkly$sdk$EvaluationReason$ErrorKind[errorKind2.ordinal()]) {
            case 1:
                return ERROR_CLIENT_NOT_READY;
            case 2:
                return ERROR_EXCEPTION;
            case 3:
                return ERROR_FLAG_NOT_FOUND;
            case 4:
                return ERROR_MALFORMED_FLAG;
            case 5:
                return ERROR_USER_NOT_SPECIFIED;
            case 6:
                return ERROR_WRONG_TYPE;
            default:
                return new EvaluationReason(errorKind2, (Exception) null);
        }
    }

    public static EvaluationReason exception(Exception exc) {
        return new EvaluationReason(ErrorKind.EXCEPTION, exc);
    }
}
