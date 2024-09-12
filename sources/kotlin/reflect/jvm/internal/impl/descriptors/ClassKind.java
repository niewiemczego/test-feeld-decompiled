package kotlin.reflect.jvm.internal.impl.descriptors;

import com.adapty.internal.crossplatform.UtilsKt;

/* compiled from: ClassKind.kt */
public enum ClassKind {
    CLASS(UtilsKt.CLASS_KEY),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY((String) null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");
    
    private final String codeRepresentation;

    private ClassKind(String str) {
        this.codeRepresentation = str;
    }

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }
}
