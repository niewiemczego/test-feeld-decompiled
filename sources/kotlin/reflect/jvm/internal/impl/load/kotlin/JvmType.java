package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: methodSignatureMapping.kt */
public abstract class JvmType {
    /* access modifiers changed from: private */
    public static final Primitive BOOLEAN = new Primitive(JvmPrimitiveType.BOOLEAN);
    /* access modifiers changed from: private */
    public static final Primitive BYTE = new Primitive(JvmPrimitiveType.BYTE);
    /* access modifiers changed from: private */
    public static final Primitive CHAR = new Primitive(JvmPrimitiveType.CHAR);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Primitive DOUBLE = new Primitive(JvmPrimitiveType.DOUBLE);
    /* access modifiers changed from: private */
    public static final Primitive FLOAT = new Primitive(JvmPrimitiveType.FLOAT);
    /* access modifiers changed from: private */
    public static final Primitive INT = new Primitive(JvmPrimitiveType.INT);
    /* access modifiers changed from: private */
    public static final Primitive LONG = new Primitive(JvmPrimitiveType.LONG);
    /* access modifiers changed from: private */
    public static final Primitive SHORT = new Primitive(JvmPrimitiveType.SHORT);

    public /* synthetic */ JvmType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private JvmType() {
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Primitive extends JvmType {
        private final JvmPrimitiveType jvmPrimitiveType;

        public Primitive(JvmPrimitiveType jvmPrimitiveType2) {
            super((DefaultConstructorMarker) null);
            this.jvmPrimitiveType = jvmPrimitiveType2;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.jvmPrimitiveType;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Object extends JvmType {
        private final String internalName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Object(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "internalName");
            this.internalName = str;
        }

        public final String getInternalName() {
            return this.internalName;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Array extends JvmType {
        private final JvmType elementType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Array(JvmType jvmType) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(jvmType, "elementType");
            this.elementType = jvmType;
        }

        public final JvmType getElementType() {
            return this.elementType;
        }
    }

    public String toString() {
        return JvmTypeFactoryImpl.INSTANCE.toString(this);
    }

    /* compiled from: methodSignatureMapping.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Primitive getBOOLEAN$descriptors_jvm() {
            return JvmType.BOOLEAN;
        }

        public final Primitive getCHAR$descriptors_jvm() {
            return JvmType.CHAR;
        }

        public final Primitive getBYTE$descriptors_jvm() {
            return JvmType.BYTE;
        }

        public final Primitive getSHORT$descriptors_jvm() {
            return JvmType.SHORT;
        }

        public final Primitive getINT$descriptors_jvm() {
            return JvmType.INT;
        }

        public final Primitive getFLOAT$descriptors_jvm() {
            return JvmType.FLOAT;
        }

        public final Primitive getLONG$descriptors_jvm() {
            return JvmType.LONG;
        }

        public final Primitive getDOUBLE$descriptors_jvm() {
            return JvmType.DOUBLE;
        }
    }
}
