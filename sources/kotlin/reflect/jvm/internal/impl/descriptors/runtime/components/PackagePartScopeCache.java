package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EmptyPackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmClassName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: PackagePartScopeCache.kt */
public final class PackagePartScopeCache {
    private final ConcurrentHashMap<ClassId, MemberScope> cache = new ConcurrentHashMap<>();
    private final ReflectKotlinClassFinder kotlinClassFinder;
    private final DeserializedDescriptorResolver resolver;

    public PackagePartScopeCache(DeserializedDescriptorResolver deserializedDescriptorResolver, ReflectKotlinClassFinder reflectKotlinClassFinder) {
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "resolver");
        Intrinsics.checkNotNullParameter(reflectKotlinClassFinder, "kotlinClassFinder");
        this.resolver = deserializedDescriptorResolver;
        this.kotlinClassFinder = reflectKotlinClassFinder;
    }

    public final MemberScope getPackagePartScope(ReflectKotlinClass reflectKotlinClass) {
        List<KotlinJvmBinaryClass> list;
        Intrinsics.checkNotNullParameter(reflectKotlinClass, "fileClass");
        ConcurrentMap concurrentMap = this.cache;
        ClassId classId = reflectKotlinClass.getClassId();
        Object obj = concurrentMap.get(classId);
        if (obj == null) {
            FqName packageFqName = reflectKotlinClass.getClassId().getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "fileClass.classId.packageFqName");
            if (reflectKotlinClass.getClassHeader().getKind() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                Collection arrayList = new ArrayList();
                for (String byInternalName : reflectKotlinClass.getClassHeader().getMultifilePartNames()) {
                    ClassId classId2 = ClassId.topLevel(JvmClassName.byInternalName(byInternalName).getFqNameForTopLevelClassMaybeWithDollars());
                    Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                    KotlinJvmBinaryClass findKotlinClass = KotlinClassFinderKt.findKotlinClass((KotlinClassFinder) this.kotlinClassFinder, classId2);
                    if (findKotlinClass != null) {
                        arrayList.add(findKotlinClass);
                    }
                }
                list = (List) arrayList;
            } else {
                list = CollectionsKt.listOf(reflectKotlinClass);
            }
            EmptyPackageFragmentDescriptor emptyPackageFragmentDescriptor = new EmptyPackageFragmentDescriptor(this.resolver.getComponents().getModuleDescriptor(), packageFqName);
            Collection arrayList2 = new ArrayList();
            for (KotlinJvmBinaryClass createKotlinPackagePartScope : list) {
                MemberScope createKotlinPackagePartScope2 = this.resolver.createKotlinPackagePartScope(emptyPackageFragmentDescriptor, createKotlinPackagePartScope);
                if (createKotlinPackagePartScope2 != null) {
                    arrayList2.add(createKotlinPackagePartScope2);
                }
            }
            MemberScope create = ChainedMemberScope.Companion.create("package " + packageFqName + " (" + reflectKotlinClass + ')', CollectionsKt.toList((List) arrayList2));
            Object putIfAbsent = concurrentMap.putIfAbsent(classId, create);
            obj = putIfAbsent == null ? create : putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "cache.getOrPut(fileClass…ileClass)\", scopes)\n    }");
        return (MemberScope) obj;
    }
}
