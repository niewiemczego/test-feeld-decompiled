package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder;

/* compiled from: KotlinClassFinder.kt */
public interface KotlinClassFinder extends KotlinMetadataFinder {
    Result findKotlinClassOrContent(JavaClass javaClass);

    Result findKotlinClassOrContent(ClassId classId);

    /* compiled from: KotlinClassFinder.kt */
    public static abstract class Result {
        public /* synthetic */ Result(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Result() {
        }

        public final KotlinJvmBinaryClass toKotlinJvmBinaryClass() {
            KotlinClass kotlinClass = this instanceof KotlinClass ? (KotlinClass) this : null;
            if (kotlinClass != null) {
                return kotlinClass.getKotlinJvmBinaryClass();
            }
            return null;
        }

        /* compiled from: KotlinClassFinder.kt */
        public static final class KotlinClass extends Result {
            private final byte[] byteContent;
            private final KotlinJvmBinaryClass kotlinJvmBinaryClass;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass2, byte[] bArr) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass2, "kotlinJvmBinaryClass");
                this.kotlinJvmBinaryClass = kotlinJvmBinaryClass2;
                this.byteContent = bArr;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ KotlinClass(KotlinJvmBinaryClass kotlinJvmBinaryClass2, byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(kotlinJvmBinaryClass2, (i & 2) != 0 ? null : bArr);
            }

            public final KotlinJvmBinaryClass getKotlinJvmBinaryClass() {
                return this.kotlinJvmBinaryClass;
            }
        }

        /* compiled from: KotlinClassFinder.kt */
        public static final class ClassFileContent extends Result {
            private final byte[] content;

            public final byte[] getContent() {
                return this.content;
            }
        }
    }
}
