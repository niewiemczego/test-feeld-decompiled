package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.java.JavaVisibilities;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner;

/* compiled from: ReflectJavaModifierListOwner.kt */
public interface ReflectJavaModifierListOwner extends JavaModifierListOwner {
    int getModifiers();

    /* compiled from: ReflectJavaModifierListOwner.kt */
    public static final class DefaultImpls {
        public static boolean isAbstract(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isAbstract(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isStatic(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isStatic(reflectJavaModifierListOwner.getModifiers());
        }

        public static boolean isFinal(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            return Modifier.isFinal(reflectJavaModifierListOwner.getModifiers());
        }

        public static Visibility getVisibility(ReflectJavaModifierListOwner reflectJavaModifierListOwner) {
            int modifiers = reflectJavaModifierListOwner.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                return Visibilities.Public.INSTANCE;
            }
            if (Modifier.isPrivate(modifiers)) {
                return Visibilities.Private.INSTANCE;
            }
            if (!Modifier.isProtected(modifiers)) {
                return JavaVisibilities.PackageVisibility.INSTANCE;
            }
            if (Modifier.isStatic(modifiers)) {
                return JavaVisibilities.ProtectedStaticVisibility.INSTANCE;
            }
            return JavaVisibilities.ProtectedAndPackage.INSTANCE;
        }
    }
}
