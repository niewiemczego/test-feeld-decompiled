package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaMethod.kt */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    private final Method member;

    public ReflectJavaMethod(Method method) {
        Intrinsics.checkNotNullParameter(method, "member");
        this.member = method;
    }

    public boolean getHasAnnotationParameterDefaultValue() {
        return JavaMethod.DefaultImpls.getHasAnnotationParameterDefaultValue(this);
    }

    public Method getMember() {
        return this.member;
    }

    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = getMember().getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = getMember().getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return getValueParameters(genericParameterTypes, parameterAnnotations, getMember().isVarArgs());
    }

    public ReflectJavaType getReturnType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericReturnType = getMember().getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        return factory.create(genericReturnType);
    }

    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        Object defaultValue = getMember().getDefaultValue();
        ReflectJavaAnnotationArgument reflectJavaAnnotationArgument = null;
        if (defaultValue != null) {
            reflectJavaAnnotationArgument = ReflectJavaAnnotationArgument.Factory.create(defaultValue, (Name) null);
        }
        return reflectJavaAnnotationArgument;
    }

    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = getMember().getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        Object[] objArr = (Object[]) typeParameters;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new ReflectJavaTypeParameter((TypeVariable) obj));
        }
        return (List) arrayList;
    }
}
