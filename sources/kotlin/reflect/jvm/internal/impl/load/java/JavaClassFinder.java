package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPackage;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: JavaClassFinder.kt */
public interface JavaClassFinder {
    JavaClass findClass(Request request);

    JavaPackage findPackage(FqName fqName, boolean z);

    Set<String> knownClassNamesInPackage(FqName fqName);

    /* compiled from: JavaClassFinder.kt */
    public static final class Request {
        private final ClassId classId;
        private final JavaClass outerClass;
        private final byte[] previouslyFoundClassFileContent;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Request)) {
                return false;
            }
            Request request = (Request) obj;
            return Intrinsics.areEqual((Object) this.classId, (Object) request.classId) && Intrinsics.areEqual((Object) this.previouslyFoundClassFileContent, (Object) request.previouslyFoundClassFileContent) && Intrinsics.areEqual((Object) this.outerClass, (Object) request.outerClass);
        }

        public int hashCode() {
            int hashCode = this.classId.hashCode() * 31;
            byte[] bArr = this.previouslyFoundClassFileContent;
            int i = 0;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            JavaClass javaClass = this.outerClass;
            if (javaClass != null) {
                i = javaClass.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Request(classId=" + this.classId + ", previouslyFoundClassFileContent=" + Arrays.toString(this.previouslyFoundClassFileContent) + ", outerClass=" + this.outerClass + ')';
        }

        public Request(ClassId classId2, byte[] bArr, JavaClass javaClass) {
            Intrinsics.checkNotNullParameter(classId2, "classId");
            this.classId = classId2;
            this.previouslyFoundClassFileContent = bArr;
            this.outerClass = javaClass;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Request(ClassId classId2, byte[] bArr, JavaClass javaClass, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(classId2, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : javaClass);
        }

        public final ClassId getClassId() {
            return this.classId;
        }
    }

    /* compiled from: JavaClassFinder.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ JavaPackage findPackage$default(JavaClassFinder javaClassFinder, FqName fqName, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                return javaClassFinder.findPackage(fqName, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findPackage");
        }
    }
}
