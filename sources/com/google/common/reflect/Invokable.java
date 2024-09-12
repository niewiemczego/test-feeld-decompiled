package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class Invokable<T, R> implements AnnotatedElement, Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    /* access modifiers changed from: package-private */
    public abstract Type[] getGenericExceptionTypes();

    /* access modifiers changed from: package-private */
    public abstract Type[] getGenericParameterTypes();

    /* access modifiers changed from: package-private */
    public abstract Type getGenericReturnType();

    /* access modifiers changed from: package-private */
    public abstract Annotation[][] getParameterAnnotations();

    public abstract TypeVariable<?>[] getTypeParameters();

    /* access modifiers changed from: package-private */
    @CheckForNull
    public abstract Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    <M extends AccessibleObject & Member> Invokable(M m) {
        Preconditions.checkNotNull(m);
        this.accessibleObject = m;
        this.member = (Member) m;
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.accessibleObject.isAnnotationPresent(cls);
    }

    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.accessibleObject.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    public final void setAccessible(boolean z) {
        this.accessibleObject.setAccessible(z);
    }

    public final boolean trySetAccessible() {
        try {
            this.accessibleObject.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    public final String getName() {
        return this.member.getName();
    }

    public final int getModifiers() {
        return this.member.getModifiers();
    }

    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPackagePrivate() {
        return !isPrivate() && !isPublic() && !isProtected();
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    /* access modifiers changed from: package-private */
    public final boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    /* access modifiers changed from: package-private */
    public final boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        if (!getOwnerType().equals(invokable.getOwnerType()) || !this.member.equals(invokable.member)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public String toString() {
        return this.member.toString();
    }

    @CheckForNull
    public final R invoke(@CheckForNull T t, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return invokeInternal(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public final TypeToken<? extends R> getReturnType() {
        return TypeToken.of(getGenericReturnType());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] genericParameterTypes = getGenericParameterTypes();
        Annotation[][] parameterAnnotations = getParameterAnnotations();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            builder.add((Object) new Parameter(this, i, TypeToken.of(genericParameterTypes[i]), parameterAnnotations[i]));
        }
        return builder.build();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type of : getGenericExceptionTypes()) {
            builder.add((Object) TypeToken.of(of));
        }
        return builder.build();
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.of(cls));
    }

    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf((TypeToken<?>) getReturnType())) {
            return this;
        }
        String valueOf = String.valueOf(getReturnType());
        String valueOf2 = String.valueOf(typeToken);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 35 + String.valueOf(valueOf2).length()).append("Invokable is known to return ").append(valueOf).append(", not ").append(valueOf2).toString());
    }

    public final Class<? super T> getDeclaringClass() {
        return this.member.getDeclaringClass();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }

    static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        MethodInvokable(Method method2) {
            super(method2);
            this.method = method2;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public final Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(obj, objArr);
        }

        /* access modifiers changed from: package-private */
        public Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        /* access modifiers changed from: package-private */
        public Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        /* access modifiers changed from: package-private */
        public Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        /* access modifiers changed from: package-private */
        public final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        public final boolean isOverridable() {
            return !isFinal() && !isPrivate() && !isStatic() && !Modifier.isFinal(getDeclaringClass().getModifiers());
        }

        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        public final boolean isOverridable() {
            return false;
        }

        ConstructorInvokable(Constructor<?> constructor2) {
            super(constructor2);
            this.constructor = constructor2;
        }

        /* access modifiers changed from: package-private */
        public final Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.constructor.newInstance(objArr);
            } catch (InstantiationException e) {
                String valueOf = String.valueOf(this.constructor);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 8).append(valueOf).append(" failed.").toString(), e);
            }
        }

        /* access modifiers changed from: package-private */
        public Type getGenericReturnType() {
            Class declaringClass = getDeclaringClass();
            TypeVariable[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.newParameterizedType(declaringClass, typeParameters) : declaringClass;
        }

        /* access modifiers changed from: package-private */
        public Type[] getGenericParameterTypes() {
            Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !mayNeedHiddenThis()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        /* access modifiers changed from: package-private */
        public Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        /* access modifiers changed from: package-private */
        public final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable[] typeParameters2 = this.constructor.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }

        private boolean mayNeedHiddenThis() {
            Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                return false;
            }
            return true;
        }
    }
}
