package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.LightClassOriginKind;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.SequencesKt;

/* compiled from: ReflectJavaClass.kt */
public final class ReflectJavaClass extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaClass {
    private final Class<?> klass;

    public LightClassOriginKind getLightClassOriginKind() {
        return null;
    }

    public boolean hasDefaultConstructor() {
        return false;
    }

    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    public ReflectJavaClass(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "klass");
        this.klass = cls;
    }

    public Class<?> getElement() {
        return this.klass;
    }

    public int getModifiers() {
        return this.klass.getModifiers();
    }

    public List<Name> getInnerClassNames() {
        Class[] declaredClasses = this.klass.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "klass.declaredClasses");
        return SequencesKt.toList(SequencesKt.mapNotNull(SequencesKt.filterNot(ArraysKt.asSequence((T[]) (Object[]) declaredClasses), ReflectJavaClass$innerClassNames$1.INSTANCE), ReflectJavaClass$innerClassNames$2.INSTANCE));
    }

    public FqName getFqName() {
        FqName asSingleFqName = ReflectClassUtilKt.getClassId(this.klass).asSingleFqName();
        Intrinsics.checkNotNullExpressionValue(asSingleFqName, "klass.classId.asSingleFqName()");
        return asSingleFqName;
    }

    public ReflectJavaClass getOuterClass() {
        Class<?> declaringClass = this.klass.getDeclaringClass();
        if (declaringClass != null) {
            return new ReflectJavaClass(declaringClass);
        }
        return null;
    }

    public Collection<JavaClassifierType> getSupertypes() {
        if (Intrinsics.areEqual((Object) this.klass, (Object) Object.class)) {
            return CollectionsKt.emptyList();
        }
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        Type genericSuperclass = this.klass.getGenericSuperclass();
        if (genericSuperclass == null) {
            genericSuperclass = Object.class;
        }
        spreadBuilder.add(genericSuperclass);
        Type[] genericInterfaces = this.klass.getGenericInterfaces();
        Intrinsics.checkNotNullExpressionValue(genericInterfaces, "klass.genericInterfaces");
        spreadBuilder.addSpread(genericInterfaces);
        Iterable<Type> listOf = CollectionsKt.listOf(spreadBuilder.toArray(new Type[spreadBuilder.size()]));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        for (Type reflectJavaClassifierType : listOf) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return (List) arrayList;
    }

    public List<ReflectJavaMethod> getMethods() {
        Method[] declaredMethods = this.klass.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "klass.declaredMethods");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence((T[]) (Object[]) declaredMethods), new ReflectJavaClass$methods$1(this)), ReflectJavaClass$methods$2.INSTANCE));
    }

    /* access modifiers changed from: private */
    public final boolean isEnumValuesOrValueOf(Method method) {
        String name = method.getName();
        if (Intrinsics.areEqual((Object) name, (Object) "values")) {
            Class[] parameterTypes = method.getParameterTypes();
            Intrinsics.checkNotNullExpressionValue(parameterTypes, "method.parameterTypes");
            if (((Object[]) parameterTypes).length == 0) {
                return true;
            }
        } else if (Intrinsics.areEqual((Object) name, (Object) "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    public List<ReflectJavaField> getFields() {
        Field[] declaredFields = this.klass.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "klass.declaredFields");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence((T[]) (Object[]) declaredFields), ReflectJavaClass$fields$1.INSTANCE), ReflectJavaClass$fields$2.INSTANCE));
    }

    public List<ReflectJavaConstructor> getConstructors() {
        Constructor[] declaredConstructors = this.klass.getDeclaredConstructors();
        Intrinsics.checkNotNullExpressionValue(declaredConstructors, "klass.declaredConstructors");
        return SequencesKt.toList(SequencesKt.map(SequencesKt.filterNot(ArraysKt.asSequence((T[]) (Object[]) declaredConstructors), ReflectJavaClass$constructors$1.INSTANCE), ReflectJavaClass$constructors$2.INSTANCE));
    }

    public Name getName() {
        Name identifier = Name.identifier(this.klass.getSimpleName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(klass.simpleName)");
        return identifier;
    }

    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = this.klass.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "klass.typeParameters");
        Object[] objArr = (Object[]) typeParameters;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new ReflectJavaTypeParameter((TypeVariable) obj));
        }
        return (List) arrayList;
    }

    public boolean isInterface() {
        return this.klass.isInterface();
    }

    public boolean isAnnotationType() {
        return this.klass.isAnnotation();
    }

    public boolean isEnum() {
        return this.klass.isEnum();
    }

    public boolean isRecord() {
        Boolean loadIsRecord = Java16SealedRecordLoader.INSTANCE.loadIsRecord(this.klass);
        if (loadIsRecord != null) {
            return loadIsRecord.booleanValue();
        }
        return false;
    }

    public Collection<JavaRecordComponent> getRecordComponents() {
        Object[] loadGetRecordComponents = Java16SealedRecordLoader.INSTANCE.loadGetRecordComponents(this.klass);
        if (loadGetRecordComponents == null) {
            loadGetRecordComponents = new Object[0];
        }
        Collection arrayList = new ArrayList(loadGetRecordComponents.length);
        for (Object reflectJavaRecordComponent : loadGetRecordComponents) {
            arrayList.add(new ReflectJavaRecordComponent(reflectJavaRecordComponent));
        }
        return (List) arrayList;
    }

    public boolean isSealed() {
        Boolean loadIsSealed = Java16SealedRecordLoader.INSTANCE.loadIsSealed(this.klass);
        if (loadIsSealed != null) {
            return loadIsSealed.booleanValue();
        }
        return false;
    }

    public Collection<JavaClassifierType> getPermittedTypes() {
        Class[] loadGetPermittedSubclasses = Java16SealedRecordLoader.INSTANCE.loadGetPermittedSubclasses(this.klass);
        if (loadGetPermittedSubclasses == null) {
            return CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList(loadGetPermittedSubclasses.length);
        for (Class reflectJavaClassifierType : loadGetPermittedSubclasses) {
            arrayList.add(new ReflectJavaClassifierType(reflectJavaClassifierType));
        }
        return (List) arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaClass) && Intrinsics.areEqual((Object) this.klass, (Object) ((ReflectJavaClass) obj).klass);
    }

    public int hashCode() {
        return this.klass.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.klass;
    }
}
