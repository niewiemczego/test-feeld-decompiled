package zendesk.android.internal.proactivemessaging.model;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.squareup.moshi.JsonClass;
import io.sentry.protocol.SentryStackFrame;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.android.pageviewevents.PageView;
import zendesk.conversationkit.android.model.VisitType;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0014\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0014\u0010\u000f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\nH\u0002\u0001\u0002\r\u0014¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Expression;", "", "()V", "evaluate", "", "event", "Lzendesk/android/pageviewevents/PageView;", "locale", "Ljava/util/Locale;", "visitType", "Lzendesk/conversationkit/android/model/VisitType;", "evaluate$zendesk_zendesk_android", "evaluateAsALocale", "Lzendesk/android/internal/proactivemessaging/model/Expression$ExpressionClass;", "targetValue", "evaluateAsAString", "", "evaluateAsAVisitType", "BoolValue", "ExpressionClass", "Lzendesk/android/internal/proactivemessaging/model/Expression$BoolValue;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Expression.kt */
public abstract class Expression {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Expression.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ExpressionFunction.values().length];
            iArr[ExpressionFunction.EQUALS.ordinal()] = 1;
            iArr[ExpressionFunction.NOT_EQUALS.ordinal()] = 2;
            iArr[ExpressionFunction.CONTAINS_ANY.ordinal()] = 3;
            iArr[ExpressionFunction.CONTAINS_NONE.ordinal()] = 4;
            iArr[ExpressionFunction.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ExpressionTarget.values().length];
            iArr2[ExpressionTarget.PATH.ordinal()] = 1;
            iArr2[ExpressionTarget.PAGE_TITLE.ordinal()] = 2;
            iArr2[ExpressionTarget.USER_TYPE.ordinal()] = 3;
            iArr2[ExpressionTarget.LANGUAGE.ordinal()] = 4;
            iArr2[ExpressionTarget.UNKNOWN.ordinal()] = 5;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ Expression(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Expression() {
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Expression$ExpressionClass;", "Lzendesk/android/internal/proactivemessaging/model/Expression;", "type", "Lzendesk/android/internal/proactivemessaging/model/ExpressionType;", "function", "Lzendesk/android/internal/proactivemessaging/model/ExpressionFunction;", "target", "Lzendesk/android/internal/proactivemessaging/model/ExpressionTarget;", "args", "", "", "(Lzendesk/android/internal/proactivemessaging/model/ExpressionType;Lzendesk/android/internal/proactivemessaging/model/ExpressionFunction;Lzendesk/android/internal/proactivemessaging/model/ExpressionTarget;Ljava/util/List;)V", "getArgs", "()Ljava/util/List;", "getFunction", "()Lzendesk/android/internal/proactivemessaging/model/ExpressionFunction;", "getTarget", "()Lzendesk/android/internal/proactivemessaging/model/ExpressionTarget;", "getType", "()Lzendesk/android/internal/proactivemessaging/model/ExpressionType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Expression.kt */
    public static final class ExpressionClass extends Expression {
        private final List<Object> args;
        private final ExpressionFunction function;
        private final ExpressionTarget target;
        private final ExpressionType type;

        public static /* synthetic */ ExpressionClass copy$default(ExpressionClass expressionClass, ExpressionType expressionType, ExpressionFunction expressionFunction, ExpressionTarget expressionTarget, List<Object> list, int i, Object obj) {
            if ((i & 1) != 0) {
                expressionType = expressionClass.type;
            }
            if ((i & 2) != 0) {
                expressionFunction = expressionClass.function;
            }
            if ((i & 4) != 0) {
                expressionTarget = expressionClass.target;
            }
            if ((i & 8) != 0) {
                list = expressionClass.args;
            }
            return expressionClass.copy(expressionType, expressionFunction, expressionTarget, list);
        }

        public final ExpressionType component1() {
            return this.type;
        }

        public final ExpressionFunction component2() {
            return this.function;
        }

        public final ExpressionTarget component3() {
            return this.target;
        }

        public final List<Object> component4() {
            return this.args;
        }

        public final ExpressionClass copy(ExpressionType expressionType, ExpressionFunction expressionFunction, ExpressionTarget expressionTarget, List<? extends Object> list) {
            Intrinsics.checkNotNullParameter(expressionType, "type");
            Intrinsics.checkNotNullParameter(expressionFunction, SentryStackFrame.JsonKeys.FUNCTION);
            Intrinsics.checkNotNullParameter(expressionTarget, TouchesHelper.TARGET_KEY);
            Intrinsics.checkNotNullParameter(list, StepData.ARGS);
            return new ExpressionClass(expressionType, expressionFunction, expressionTarget, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ExpressionClass)) {
                return false;
            }
            ExpressionClass expressionClass = (ExpressionClass) obj;
            return this.type == expressionClass.type && this.function == expressionClass.function && this.target == expressionClass.target && Intrinsics.areEqual((Object) this.args, (Object) expressionClass.args);
        }

        public int hashCode() {
            return (((((this.type.hashCode() * 31) + this.function.hashCode()) * 31) + this.target.hashCode()) * 31) + this.args.hashCode();
        }

        public String toString() {
            return "ExpressionClass(type=" + this.type + ", function=" + this.function + ", target=" + this.target + ", args=" + this.args + ')';
        }

        public final ExpressionType getType() {
            return this.type;
        }

        public final ExpressionFunction getFunction() {
            return this.function;
        }

        public final ExpressionTarget getTarget() {
            return this.target;
        }

        public final List<Object> getArgs() {
            return this.args;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ExpressionClass(ExpressionType expressionType, ExpressionFunction expressionFunction, ExpressionTarget expressionTarget, List<? extends Object> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(expressionType, "type");
            Intrinsics.checkNotNullParameter(expressionFunction, SentryStackFrame.JsonKeys.FUNCTION);
            Intrinsics.checkNotNullParameter(expressionTarget, TouchesHelper.TARGET_KEY);
            Intrinsics.checkNotNullParameter(list, StepData.ARGS);
            this.type = expressionType;
            this.function = expressionFunction;
            this.target = expressionTarget;
            this.args = list;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean evaluateAsAString(zendesk.android.internal.proactivemessaging.model.Expression.ExpressionClass r8, java.lang.String r9) {
        /*
            r7 = this;
            zendesk.android.internal.proactivemessaging.model.ExpressionFunction r0 = r8.getFunction()
            int[] r1 = zendesk.android.internal.proactivemessaging.model.Expression.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r0 == r2) goto L_0x00b1
            r5 = 2
            if (r0 == r5) goto L_0x0097
            r5 = 3
            r6 = 10
            if (r0 == r5) goto L_0x0062
            r5 = 4
            if (r0 == r5) goto L_0x0029
            r8 = 5
            if (r0 != r8) goto L_0x0023
            goto L_0x00c8
        L_0x0023:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x0029:
            java.util.List r8 = r8.getArgs()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r6)
            r0.<init>(r5)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x003e:
            boolean r5 = r8.hasNext()
            if (r5 == 0) goto L_0x0057
            java.lang.Object r5 = r8.next()
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x004f
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0050
        L_0x004f:
            r5 = r4
        L_0x0050:
            if (r5 != 0) goto L_0x0053
            r5 = r3
        L_0x0053:
            r0.add(r5)
            goto L_0x003e
        L_0x0057:
            java.util.List r0 = (java.util.List) r0
            boolean r8 = r0.contains(r9)
            if (r8 != 0) goto L_0x00c8
        L_0x005f:
            r1 = r2
            goto L_0x00c8
        L_0x0062:
            java.util.List r8 = r8.getArgs()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r8, r6)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r8 = r8.iterator()
        L_0x0077:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x0090
            java.lang.Object r1 = r8.next()
            boolean r2 = r1 instanceof java.lang.String
            if (r2 == 0) goto L_0x0088
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0089
        L_0x0088:
            r1 = r4
        L_0x0089:
            if (r1 != 0) goto L_0x008c
            r1 = r3
        L_0x008c:
            r0.add(r1)
            goto L_0x0077
        L_0x0090:
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.contains(r9)
            goto L_0x00c8
        L_0x0097:
            java.util.List r8 = r8.getArgs()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            boolean r0 = r8 instanceof java.lang.String
            if (r0 == 0) goto L_0x00a6
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L_0x00a6:
            if (r4 != 0) goto L_0x00a9
            goto L_0x00aa
        L_0x00a9:
            r3 = r4
        L_0x00aa:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)
            if (r8 != 0) goto L_0x00c8
            goto L_0x005f
        L_0x00b1:
            java.util.List r8 = r8.getArgs()
            java.lang.Object r8 = kotlin.collections.CollectionsKt.first(r8)
            boolean r0 = r8 instanceof java.lang.String
            if (r0 == 0) goto L_0x00c0
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4
        L_0x00c0:
            if (r4 != 0) goto L_0x00c3
            goto L_0x00c4
        L_0x00c3:
            r3 = r4
        L_0x00c4:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r9)
        L_0x00c8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.model.Expression.evaluateAsAString(zendesk.android.internal.proactivemessaging.model.Expression$ExpressionClass, java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean evaluateAsALocale(zendesk.android.internal.proactivemessaging.model.Expression.ExpressionClass r7, java.util.Locale r8) {
        /*
            r6 = this;
            zendesk.android.internal.proactivemessaging.model.ExpressionFunction r0 = r7.getFunction()
            int[] r1 = zendesk.android.internal.proactivemessaging.model.Expression.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            java.lang.String r1 = ""
            r2 = 0
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L_0x0045
            r5 = 2
            if (r0 == r5) goto L_0x0026
            r7 = 3
            if (r0 == r7) goto L_0x0060
            r7 = 4
            if (r0 == r7) goto L_0x0060
            r7 = 5
            if (r0 != r7) goto L_0x0020
            goto L_0x0060
        L_0x0020:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0026:
            java.util.List r7 = r7.getArgs()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            boolean r0 = r7 instanceof java.lang.String
            if (r0 == 0) goto L_0x0035
            r2 = r7
            java.lang.String r2 = (java.lang.String) r2
        L_0x0035:
            if (r2 != 0) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r1 = r2
        L_0x0039:
            java.util.Locale r7 = java.util.Locale.forLanguageTag(r1)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 != 0) goto L_0x0060
            r3 = r4
            goto L_0x0060
        L_0x0045:
            java.util.List r7 = r7.getArgs()
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            boolean r0 = r7 instanceof java.lang.String
            if (r0 == 0) goto L_0x0054
            r2 = r7
            java.lang.String r2 = (java.lang.String) r2
        L_0x0054:
            if (r2 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r1 = r2
        L_0x0058:
            java.util.Locale r7 = java.util.Locale.forLanguageTag(r1)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
        L_0x0060:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.model.Expression.evaluateAsALocale(zendesk.android.internal.proactivemessaging.model.Expression$ExpressionClass, java.util.Locale):boolean");
    }

    private final boolean evaluateAsAVisitType(ExpressionClass expressionClass, VisitType visitType) {
        int i = WhenMappings.$EnumSwitchMapping$0[expressionClass.getFunction().ordinal()];
        if (i == 1) {
            Object first = CollectionsKt.first(expressionClass.getArgs());
            String str = first instanceof String ? (String) first : null;
            if (str == null) {
                str = "";
            }
            return StringsKt.equals(str, visitType.name(), true);
        } else if (i == 2 || i == 3 || i == 4 || i == 5) {
            return false;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean evaluate$zendesk_zendesk_android(PageView pageView, Locale locale, VisitType visitType) {
        Intrinsics.checkNotNullParameter(pageView, "event");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(visitType, "visitType");
        if (this instanceof BoolValue) {
            return ((BoolValue) this).getValue();
        }
        if (this instanceof ExpressionClass) {
            ExpressionClass expressionClass = (ExpressionClass) this;
            int i = WhenMappings.$EnumSwitchMapping$1[expressionClass.getTarget().ordinal()];
            if (i == 1) {
                return evaluateAsAString(expressionClass, pageView.getUrl());
            }
            if (i == 2) {
                return evaluateAsAString(expressionClass, pageView.getPageTitle());
            }
            if (i == 3) {
                return evaluateAsAVisitType(expressionClass, visitType);
            }
            if (i == 4) {
                return evaluateAsALocale(expressionClass, locale);
            }
            if (i == 5) {
                return false;
            }
            throw new NoWhenBranchMatchedException();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/Expression$BoolValue;", "Lzendesk/android/internal/proactivemessaging/model/Expression;", "value", "", "(Z)V", "getValue", "()Z", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Expression.kt */
    public static final class BoolValue extends Expression {
        private final boolean value;

        public BoolValue(boolean z) {
            super((DefaultConstructorMarker) null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }
}
