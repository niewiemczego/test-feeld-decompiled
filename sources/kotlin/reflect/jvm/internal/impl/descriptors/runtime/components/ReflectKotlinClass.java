package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.ReadKotlinClassHeaderAnnotationVisitor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: ReflectKotlinClass.kt */
public final class ReflectKotlinClass implements KotlinJvmBinaryClass {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    private final KotlinClassHeader classHeader;
    private final Class<?> klass;

    public /* synthetic */ ReflectKotlinClass(Class cls, KotlinClassHeader kotlinClassHeader, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, kotlinClassHeader);
    }

    private ReflectKotlinClass(Class<?> cls, KotlinClassHeader kotlinClassHeader) {
        this.klass = cls;
        this.classHeader = kotlinClassHeader;
    }

    public final Class<?> getKlass() {
        return this.klass;
    }

    public KotlinClassHeader getClassHeader() {
        return this.classHeader;
    }

    /* compiled from: ReflectKotlinClass.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectKotlinClass create(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "klass");
            ReadKotlinClassHeaderAnnotationVisitor readKotlinClassHeaderAnnotationVisitor = new ReadKotlinClassHeaderAnnotationVisitor();
            ReflectClassStructure.INSTANCE.loadClassAnnotations(cls, readKotlinClassHeaderAnnotationVisitor);
            KotlinClassHeader createHeader = readKotlinClassHeaderAnnotationVisitor.createHeader();
            if (createHeader == null) {
                return null;
            }
            return new ReflectKotlinClass(cls, createHeader, (DefaultConstructorMarker) null);
        }
    }

    public String getLocation() {
        StringBuilder sb = new StringBuilder();
        String name = this.klass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "klass.name");
        return sb.append(StringsKt.replace$default(name, '.', (char) IOUtils.DIR_SEPARATOR_UNIX, false, 4, (Object) null)).append(".class").toString();
    }

    public ClassId getClassId() {
        return ReflectClassUtilKt.getClassId(this.klass);
    }

    public void loadClassAnnotations(KotlinJvmBinaryClass.AnnotationVisitor annotationVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(annotationVisitor, "visitor");
        ReflectClassStructure.INSTANCE.loadClassAnnotations(this.klass, annotationVisitor);
    }

    public void visitMembers(KotlinJvmBinaryClass.MemberVisitor memberVisitor, byte[] bArr) {
        Intrinsics.checkNotNullParameter(memberVisitor, "visitor");
        ReflectClassStructure.INSTANCE.visitMembers(this.klass, memberVisitor);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectKotlinClass) && Intrinsics.areEqual((Object) this.klass, (Object) ((ReflectKotlinClass) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
