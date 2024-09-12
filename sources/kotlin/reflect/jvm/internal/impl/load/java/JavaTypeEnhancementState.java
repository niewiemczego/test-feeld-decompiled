package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.KotlinVersion;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaTypeEnhancementState.kt */
public final class JavaTypeEnhancementState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final JavaTypeEnhancementState DEFAULT = new JavaTypeEnhancementState(JavaNullabilityAnnotationSettingsKt.getDefaultJsr305Settings$default((KotlinVersion) null, 1, (Object) null), JavaTypeEnhancementState$Companion$DEFAULT$1.INSTANCE);
    private final boolean disabledDefaultAnnotations;
    private final Function1<FqName, ReportLevel> getReportLevelForAnnotation;
    private final Jsr305Settings jsr305;

    public JavaTypeEnhancementState(Jsr305Settings jsr305Settings, Function1<? super FqName, ? extends ReportLevel> function1) {
        Intrinsics.checkNotNullParameter(jsr305Settings, "jsr305");
        Intrinsics.checkNotNullParameter(function1, "getReportLevelForAnnotation");
        this.jsr305 = jsr305Settings;
        this.getReportLevelForAnnotation = function1;
        this.disabledDefaultAnnotations = jsr305Settings.isDisabled() || function1.invoke(JavaNullabilityAnnotationSettingsKt.getJSPECIFY_ANNOTATIONS_PACKAGE()) == ReportLevel.IGNORE;
    }

    public final Jsr305Settings getJsr305() {
        return this.jsr305;
    }

    public final Function1<FqName, ReportLevel> getGetReportLevelForAnnotation() {
        return this.getReportLevelForAnnotation;
    }

    public final boolean getDisabledDefaultAnnotations() {
        return this.disabledDefaultAnnotations;
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final JavaTypeEnhancementState getDEFAULT() {
            return JavaTypeEnhancementState.DEFAULT;
        }
    }

    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.jsr305 + ", getReportLevelForAnnotation=" + this.getReportLevelForAnnotation + ')';
    }
}
