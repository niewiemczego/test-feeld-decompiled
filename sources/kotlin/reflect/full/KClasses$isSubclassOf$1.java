package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KClasses.kt */
/* synthetic */ class KClasses$isSubclassOf$1 extends PropertyReference1 {
    public static final KClasses$isSubclassOf$1 INSTANCE = new KClasses$isSubclassOf$1();

    public String getName() {
        return "superclasses";
    }

    public String getSignature() {
        return "getSuperclasses(Lkotlin/reflect/KClass;)Ljava/util/List;";
    }

    /* synthetic */ KClasses$isSubclassOf$1() {
    }

    public Object get(Object obj) {
        return KClasses.getSuperclasses((KClass) obj);
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinPackage(KClasses.class, "kotlin-reflection");
    }
}
