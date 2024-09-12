package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaTypeParameter.kt */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    public ReflectJavaAnnotation findAnnotation(FqName fqName) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, fqName);
    }

    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public ReflectJavaTypeParameter(TypeVariable<?> typeVariable2) {
        Intrinsics.checkNotNullParameter(typeVariable2, "typeVariable");
        this.typeVariable = typeVariable2;
    }

    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] bounds = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "typeVariable.bounds");
        Object[] objArr = (Object[]) bounds;
        Collection arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(new ReflectJavaClassifierType((Type) obj));
        }
        List<ReflectJavaClassifierType> list = (List) arrayList;
        ReflectJavaClassifierType reflectJavaClassifierType = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(list);
        return Intrinsics.areEqual((Object) reflectJavaClassifierType != null ? reflectJavaClassifierType.getReflectType() : null, (Object) Object.class) ? CollectionsKt.emptyList() : list;
    }

    public AnnotatedElement getElement() {
        TypeVariable<?> typeVariable2 = this.typeVariable;
        if (typeVariable2 instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable2;
        }
        return null;
    }

    public Name getName() {
        Name identifier = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(identifier, "identifier(typeVariable.name)");
        return identifier;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaTypeParameter) && Intrinsics.areEqual((Object) this.typeVariable, (Object) ((ReflectJavaTypeParameter) obj).typeVariable);
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.typeVariable;
    }
}
