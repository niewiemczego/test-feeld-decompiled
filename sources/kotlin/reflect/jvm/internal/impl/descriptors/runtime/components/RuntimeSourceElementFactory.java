package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceFile;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaElement;

/* compiled from: RuntimeSourceElementFactory.kt */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory {
    public static final RuntimeSourceElementFactory INSTANCE = new RuntimeSourceElementFactory();

    /* compiled from: RuntimeSourceElementFactory.kt */
    public static final class RuntimeSourceElement implements JavaSourceElement {
        private final ReflectJavaElement javaElement;

        public RuntimeSourceElement(ReflectJavaElement reflectJavaElement) {
            Intrinsics.checkNotNullParameter(reflectJavaElement, "javaElement");
            this.javaElement = reflectJavaElement;
        }

        public ReflectJavaElement getJavaElement() {
            return this.javaElement;
        }

        public String toString() {
            return getClass().getName() + ": " + getJavaElement();
        }

        public SourceFile getContainingFile() {
            SourceFile sourceFile = SourceFile.NO_SOURCE_FILE;
            Intrinsics.checkNotNullExpressionValue(sourceFile, "NO_SOURCE_FILE");
            return sourceFile;
        }
    }

    private RuntimeSourceElementFactory() {
    }

    public JavaSourceElement source(JavaElement javaElement) {
        Intrinsics.checkNotNullParameter(javaElement, "javaElement");
        return new RuntimeSourceElement((ReflectJavaElement) javaElement);
    }
}
