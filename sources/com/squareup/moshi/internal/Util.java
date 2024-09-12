package com.squareup.moshi.internal;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.HttpUrl;

public final class Util {
    @Nullable
    public static final Class<?> DEFAULT_CONSTRUCTOR_MARKER;
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
    @Nullable
    private static final Class<? extends Annotation> METADATA;
    public static final Set<Annotation> NO_ANNOTATIONS = Collections.emptySet();
    private static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;

    private static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName(getKotlinMetadataClassName());
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        METADATA = cls;
        try {
            cls2 = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
        } catch (ClassNotFoundException unused2) {
        }
        DEFAULT_CONSTRUCTOR_MARKER = cls2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        linkedHashMap.put(Boolean.TYPE, Boolean.class);
        linkedHashMap.put(Byte.TYPE, Byte.class);
        linkedHashMap.put(Character.TYPE, Character.class);
        linkedHashMap.put(Double.TYPE, Double.class);
        linkedHashMap.put(Float.TYPE, Float.class);
        linkedHashMap.put(Integer.TYPE, Integer.class);
        linkedHashMap.put(Long.TYPE, Long.class);
        linkedHashMap.put(Short.TYPE, Short.class);
        linkedHashMap.put(Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(linkedHashMap);
    }

    private Util() {
    }

    public static String jsonName(String str, AnnotatedElement annotatedElement) {
        return jsonName(str, (Json) annotatedElement.getAnnotation(Json.class));
    }

    public static String jsonName(String str, @Nullable Json json) {
        if (json == null) {
            return str;
        }
        String name = json.name();
        return Json.UNSET_NAME.equals(name) ? str : name;
    }

    public static boolean typesMatch(Type type, Type type2) {
        return Types.equals(type, type2);
    }

    public static Set<? extends Annotation> jsonAnnotations(AnnotatedElement annotatedElement) {
        return jsonAnnotations(annotatedElement.getAnnotations());
    }

    public static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : NO_ANNOTATIONS;
    }

    public static boolean isAnnotationPresent(Set<? extends Annotation> set, Class<? extends Annotation> cls) {
        if (set.isEmpty()) {
            return false;
        }
        for (Annotation annotationType : set) {
            if (annotationType.annotationType() == cls) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasNullable(Annotation[] annotationArr) {
        for (Annotation annotationType : annotationArr) {
            if (annotationType.annotationType().getSimpleName().equals("Nullable")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPlatformType(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static RuntimeException rethrowCause(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        } else if (targetException instanceof Error) {
            throw ((Error) targetException);
        } else {
            throw new RuntimeException(targetException);
        }
    }

    public static Type canonicalize(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new GenericArrayTypeImpl(canonicalize(cls.getComponentType())) : cls;
        } else if (type instanceof ParameterizedType) {
            if (type instanceof ParameterizedTypeImpl) {
                return type;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        } else if (type instanceof GenericArrayType) {
            if (type instanceof GenericArrayTypeImpl) {
                return type;
            }
            return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
        } else if (!(type instanceof WildcardType) || (type instanceof WildcardTypeImpl)) {
            return type;
        } else {
            WildcardType wildcardType = (WildcardType) type;
            return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
    }

    public static Type removeSubtypeWildcard(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return resolve(type, cls, type2, new LinkedHashSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v14, resolved type: java.lang.reflect.WildcardType} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type resolve(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable<?>> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0018
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto L_0x000e
            return r10
        L_0x000e:
            r11.add(r0)
            java.lang.reflect.Type r10 = resolveTypeVariable(r8, r9, r0)
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x0018:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0035
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x0035
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            java.lang.reflect.GenericArrayType r0 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x0034:
            return r0
        L_0x0035:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x004b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            java.lang.reflect.GenericArrayType r10 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x004a:
            return r10
        L_0x004b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = resolve(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x005f
            r0 = r1
            goto L_0x0060
        L_0x005f:
            r0 = r2
        L_0x0060:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x0065:
            if (r2 >= r5) goto L_0x0080
            r6 = r4[r2]
            java.lang.reflect.Type r6 = resolve(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x007d
            if (r0 != 0) goto L_0x007b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = r1
        L_0x007b:
            r4[r2] = r6
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0080:
            if (r0 == 0) goto L_0x008c
            com.squareup.moshi.internal.Util$ParameterizedTypeImpl r8 = new com.squareup.moshi.internal.Util$ParameterizedTypeImpl
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            r10 = r8
        L_0x008c:
            return r10
        L_0x008d:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00bf
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x00ad
            r1 = r0[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.supertypeOf(r8)
            return r8
        L_0x00ad:
            int r0 = r3.length
            if (r0 != r1) goto L_0x00bf
            r0 = r3[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)
            r9 = r3[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.subtypeOf(r8)
            return r8
        L_0x00bf:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }

    static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                Class<?> cls3 = interfaces[i];
                if (cls3 == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(cls3)) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    static int hashCodeOrZero(@Nullable Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    @Nullable
    static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        @Nullable
        private final Type ownerType;
        private final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(@Nullable Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || Types.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = Util.canonicalize(type);
            }
            this.ownerType = type3;
            this.rawType = Util.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i < typeArr2.length) {
                    Type type4 = typeArr2[i];
                    type4.getClass();
                    Util.checkNotPrimitive(type4);
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[i] = Util.canonicalize(typeArr3[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getRawType() {
            return this.rawType;
        }

        @Nullable
        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Types.equals(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ Util.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(Util.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb.toString();
            }
            sb.append("<").append(Util.typeToString(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                sb.append(", ").append(Util.typeToString(this.typeArguments[i]));
            }
            return sb.append(">").toString();
        }
    }

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = Util.canonicalize(type);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Types.equals(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Util.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        @Nullable
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                Type type = typeArr2[0];
                type.getClass();
                Util.checkNotPrimitive(type);
                if (typeArr[0] == Object.class) {
                    this.lowerBound = Util.canonicalize(typeArr2[0]);
                    this.upperBound = Object.class;
                    return;
                }
                throw new IllegalArgumentException();
            } else {
                Type type2 = typeArr[0];
                type2.getClass();
                Util.checkNotPrimitive(type2);
                this.lowerBound = null;
                this.upperBound = Util.canonicalize(typeArr[0]);
            }
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return Util.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Types.equals(this, (WildcardType) obj);
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                return "? super " + Util.typeToString(this.lowerBound);
            }
            if (this.upperBound == Object.class) {
                return "?";
            }
            return "? extends " + Util.typeToString(this.upperBound);
        }
    }

    public static String typeAnnotatedWithAnnotations(Type type, Set<? extends Annotation> set) {
        return type + (set.isEmpty() ? " (with no annotations)" : " annotated " + set);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        throw rethrowCause(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0080, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        throw new java.lang.RuntimeException("Failed to instantiate the generated JsonAdapter for " + r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b3, code lost:
        throw new java.lang.RuntimeException("Failed to access the generated JsonAdapter for " + r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b4, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b7, code lost:
        if ((r7 instanceof java.lang.reflect.ParameterizedType) != false) goto L_0x00ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ec, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter constructor for '" + r7 + "'. Suspiciously, the type was not parameterized but the target class '" + r1.getCanonicalName() + "' is generic. Consider using Types#newParameterizedType() to define these missing type variables.", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0105, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter constructor for " + r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0106, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x011f, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter class for " + r7, r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0064 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a A[ExcHandler: InvocationTargetException (r6v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[ExcHandler: InstantiationException (r6v4 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009a A[ExcHandler: IllegalAccessException (r6v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:5:0x001b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0106 A[ExcHandler: ClassNotFoundException (r6v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x001b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0064=Splitter:B:16:0x0064, B:12:0x0046=Splitter:B:12:0x0046} */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.squareup.moshi.JsonAdapter<?> generatedAdapter(com.squareup.moshi.Moshi r6, java.lang.reflect.Type r7, java.lang.Class<?> r8) {
        /*
            java.lang.Class<com.squareup.moshi.JsonClass> r0 = com.squareup.moshi.JsonClass.class
            java.lang.annotation.Annotation r0 = r8.getAnnotation(r0)
            com.squareup.moshi.JsonClass r0 = (com.squareup.moshi.JsonClass) r0
            r1 = 0
            if (r0 == 0) goto L_0x0120
            boolean r0 = r0.generateAdapter()
            if (r0 != 0) goto L_0x0013
            goto L_0x0120
        L_0x0013:
            java.lang.String r0 = r8.getName()
            java.lang.String r0 = com.squareup.moshi.Types.generatedJsonAdapterName((java.lang.String) r0)
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r2 = 1
            java.lang.Class r1 = java.lang.Class.forName(r0, r2, r8)     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r0 = 0
            if (r8 == 0) goto L_0x0055
            r8 = r7
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Class<com.squareup.moshi.Moshi> r5 = com.squareup.moshi.Moshi.class
            r4[r0] = r5     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Class<java.lang.reflect.Type[]> r5 = java.lang.reflect.Type[].class
            r4[r2] = r5     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.reflect.Constructor r4 = r1.getDeclaredConstructor(r4)     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r3[r0] = r6     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r3[r2] = r8     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            goto L_0x006c
        L_0x0046:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Class<java.lang.reflect.Type[]> r3 = java.lang.reflect.Type[].class
            r6[r0] = r3     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.reflect.Constructor r4 = r1.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r3[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            goto L_0x006c
        L_0x0055:
            java.lang.Class[] r8 = new java.lang.Class[r2]     // Catch:{ NoSuchMethodException -> 0x0064, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Class<com.squareup.moshi.Moshi> r3 = com.squareup.moshi.Moshi.class
            r8[r0] = r3     // Catch:{ NoSuchMethodException -> 0x0064, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.reflect.Constructor r4 = r1.getDeclaredConstructor(r8)     // Catch:{ NoSuchMethodException -> 0x0064, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ NoSuchMethodException -> 0x0064, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            r3[r0] = r6     // Catch:{ NoSuchMethodException -> 0x0064, ClassNotFoundException -> 0x0106, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            goto L_0x006c
        L_0x0064:
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.reflect.Constructor r4 = r1.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
        L_0x006c:
            r4.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            java.lang.Object r6 = r4.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            com.squareup.moshi.JsonAdapter r6 = (com.squareup.moshi.JsonAdapter) r6     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            com.squareup.moshi.JsonAdapter r6 = r6.nullSafe()     // Catch:{ ClassNotFoundException -> 0x0106, NoSuchMethodException -> 0x00b4, IllegalAccessException -> 0x009a, InstantiationException -> 0x0080, InvocationTargetException -> 0x007a }
            return r6
        L_0x007a:
            r6 = move-exception
            java.lang.RuntimeException r6 = rethrowCause(r6)
            throw r6
        L_0x0080:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to instantiate the generated JsonAdapter for "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x009a:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to access the generated JsonAdapter for "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00b4:
            r6 = move-exception
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType
            if (r8 != 0) goto L_0x00ed
            java.lang.reflect.TypeVariable[] r8 = r1.getTypeParameters()
            int r8 = r8.length
            if (r8 == 0) goto L_0x00ed
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Failed to find the generated JsonAdapter constructor for '"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r0 = "'. Suspiciously, the type was not parameterized but the target class '"
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r0 = r1.getCanonicalName()
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r0 = "' is generic. Consider using Types#newParameterizedType() to define these missing type variables."
            java.lang.StringBuilder r7 = r7.append(r0)
            java.lang.String r7 = r7.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00ed:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x0106:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter class for "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x0120:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.generatedAdapter(com.squareup.moshi.Moshi, java.lang.reflect.Type, java.lang.Class):com.squareup.moshi.JsonAdapter");
    }

    public static boolean isKotlin(Class<?> cls) {
        Class<? extends Annotation> cls2 = METADATA;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static <T> Constructor<T> lookupDefaultsConstructor(Class<T> cls) {
        if (DEFAULT_CONSTRUCTOR_MARKER != null) {
            Constructor<T> findConstructor = findConstructor(cls);
            findConstructor.setAccessible(true);
            return findConstructor;
        }
        throw new IllegalStateException("DefaultConstructorMarker not on classpath. Make sure the Kotlin stdlib is on the classpath.");
    }

    private static <T> Constructor<T> findConstructor(Class<T> cls) {
        for (Constructor<T> constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0 && parameterTypes[parameterTypes.length - 1].equals(DEFAULT_CONSTRUCTOR_MARKER)) {
                return constructor;
            }
        }
        throw new IllegalStateException("No defaults constructor found for " + cls);
    }

    public static JsonDataException missingProperty(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Required value '%s' missing at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Required value '%s' (JSON name '%s') missing at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static JsonDataException unexpectedNull(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Non-null value '%s' was null at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Non-null value '%s' (JSON name '%s') was null at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static <T> Class<T> boxIfPrimitive(Class<T> cls) {
        Class<T> cls2 = PRIMITIVE_TO_WRAPPER_TYPE.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
