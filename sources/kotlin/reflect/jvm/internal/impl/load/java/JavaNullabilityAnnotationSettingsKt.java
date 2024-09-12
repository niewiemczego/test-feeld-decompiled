package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
public final class JavaNullabilityAnnotationSettingsKt {
    private static final FqName CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE;
    private static final FqName JSPECIFY_ANNOTATIONS_PACKAGE;
    private static final JavaNullabilityAnnotationsStatus JSR_305_DEFAULT_SETTINGS = new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null);
    private static final NullabilityAnnotationStates<JavaNullabilityAnnotationsStatus> NULLABILITY_ANNOTATION_SETTINGS;

    static {
        FqName fqName = new FqName("org.jspecify.nullness");
        JSPECIFY_ANNOTATIONS_PACKAGE = fqName;
        FqName fqName2 = new FqName("org.checkerframework.checker.nullness.compatqual");
        CHECKER_FRAMEWORK_COMPATQUAL_ANNOTATIONS_PACKAGE = fqName2;
        NULLABILITY_ANNOTATION_SETTINGS = new NullabilityAnnotationStatesImpl(MapsKt.mapOf(TuplesKt.to(new FqName("org.jetbrains.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.support.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("android.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("com.android.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.eclipse.jdt.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("org.checkerframework.checker.nullness.qual"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(fqName2, JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("javax.annotation"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("edu.umd.cs.findbugs.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("io.reactivex.annotations"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(new FqName("androidx.annotation.RecentlyNullable"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.to(new FqName("androidx.annotation.RecentlyNonNull"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, (KotlinVersion) null, (ReportLevel) null, 4, (DefaultConstructorMarker) null)), TuplesKt.to(new FqName("lombok"), JavaNullabilityAnnotationsStatus.Companion.getDEFAULT()), TuplesKt.to(fqName, new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT)), TuplesKt.to(new FqName("io.reactivex.rxjava3.annotations"), new JavaNullabilityAnnotationsStatus(ReportLevel.WARN, new KotlinVersion(1, 8), ReportLevel.STRICT))));
    }

    public static final FqName getJSPECIFY_ANNOTATIONS_PACKAGE() {
        return JSPECIFY_ANNOTATIONS_PACKAGE;
    }

    public static /* synthetic */ Jsr305Settings getDefaultJsr305Settings$default(KotlinVersion kotlinVersion, int i, Object obj) {
        if ((i & 1) != 0) {
            kotlinVersion = KotlinVersion.CURRENT;
        }
        return getDefaultJsr305Settings(kotlinVersion);
    }

    public static final Jsr305Settings getDefaultJsr305Settings(KotlinVersion kotlinVersion) {
        ReportLevel reportLevel;
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = JSR_305_DEFAULT_SETTINGS;
        if (javaNullabilityAnnotationsStatus.getSinceVersion() == null || javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(kotlinVersion) > 0) {
            reportLevel = javaNullabilityAnnotationsStatus.getReportLevelBefore();
        } else {
            reportLevel = javaNullabilityAnnotationsStatus.getReportLevelAfter();
        }
        ReportLevel reportLevel2 = reportLevel;
        return new Jsr305Settings(reportLevel2, getDefaultMigrationJsr305ReportLevelForGivenGlobal(reportLevel2), (Map) null, 4, (DefaultConstructorMarker) null);
    }

    public static final ReportLevel getDefaultMigrationJsr305ReportLevelForGivenGlobal(ReportLevel reportLevel) {
        Intrinsics.checkNotNullParameter(reportLevel, "globalReportLevel");
        if (reportLevel == ReportLevel.WARN) {
            return null;
        }
        return reportLevel;
    }

    public static final ReportLevel getDefaultReportLevelForAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "annotationFqName");
        return getReportLevelForAnnotation$default(fqName, NullabilityAnnotationStates.Companion.getEMPTY(), (KotlinVersion) null, 4, (Object) null);
    }

    public static /* synthetic */ ReportLevel getReportLevelForAnnotation$default(FqName fqName, NullabilityAnnotationStates nullabilityAnnotationStates, KotlinVersion kotlinVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            kotlinVersion = new KotlinVersion(1, 7, 0);
        }
        return getReportLevelForAnnotation(fqName, nullabilityAnnotationStates, kotlinVersion);
    }

    public static final ReportLevel getReportLevelForAnnotation(FqName fqName, NullabilityAnnotationStates<? extends ReportLevel> nullabilityAnnotationStates, KotlinVersion kotlinVersion) {
        Intrinsics.checkNotNullParameter(fqName, "annotation");
        Intrinsics.checkNotNullParameter(nullabilityAnnotationStates, "configuredReportLevels");
        Intrinsics.checkNotNullParameter(kotlinVersion, "configuredKotlinVersion");
        ReportLevel reportLevel = (ReportLevel) nullabilityAnnotationStates.get(fqName);
        if (reportLevel != null) {
            return reportLevel;
        }
        JavaNullabilityAnnotationsStatus javaNullabilityAnnotationsStatus = NULLABILITY_ANNOTATION_SETTINGS.get(fqName);
        if (javaNullabilityAnnotationsStatus == null) {
            return ReportLevel.IGNORE;
        }
        if (javaNullabilityAnnotationsStatus.getSinceVersion() == null || javaNullabilityAnnotationsStatus.getSinceVersion().compareTo(kotlinVersion) > 0) {
            return javaNullabilityAnnotationsStatus.getReportLevelBefore();
        }
        return javaNullabilityAnnotationsStatus.getReportLevelAfter();
    }
}
