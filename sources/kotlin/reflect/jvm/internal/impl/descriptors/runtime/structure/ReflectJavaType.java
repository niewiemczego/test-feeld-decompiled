package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaType.kt */
public abstract class ReflectJavaType implements JavaType {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    /* access modifiers changed from: protected */
    public abstract Type getReflectType();

    public JavaAnnotation findAnnotation(FqName fqName) {
        return JavaType.DefaultImpls.findAnnotation(this, fqName);
    }

    /* compiled from: ReflectJavaType.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final ReflectJavaType create(Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new ReflectJavaPrimitiveType(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                return new ReflectJavaArrayType(type);
            }
            if (type instanceof WildcardType) {
                return new ReflectJavaWildcardType((WildcardType) type);
            }
            return new ReflectJavaClassifierType(type);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics.areEqual((Object) getReflectType(), (Object) ((ReflectJavaType) obj).getReflectType());
    }

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
