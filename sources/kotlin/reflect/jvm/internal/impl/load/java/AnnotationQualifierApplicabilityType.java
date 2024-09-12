package kotlin.reflect.jvm.internal.impl.load.java;

/* compiled from: AnnotationQualifierApplicabilityType.kt */
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");
    
    private final String javaTarget;

    private AnnotationQualifierApplicabilityType(String str) {
        this.javaTarget = str;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
