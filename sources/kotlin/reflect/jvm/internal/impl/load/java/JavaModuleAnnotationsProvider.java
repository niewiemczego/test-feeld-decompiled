package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* compiled from: JavaModuleAnnotationsProvider.kt */
public interface JavaModuleAnnotationsProvider {
    List<JavaAnnotation> getAnnotationsForModuleOwnerOfClass(ClassId classId);
}
