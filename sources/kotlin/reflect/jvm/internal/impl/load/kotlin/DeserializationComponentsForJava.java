package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.CompositePackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.SingleModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JavaDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;
import kotlin.text.Typography;

/* compiled from: DeserializationComponentsForJava.kt */
public final class DeserializationComponentsForJava {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final DeserializationComponents components;

    public DeserializationComponentsForJava(StorageManager storageManager, ModuleDescriptor moduleDescriptor, DeserializationConfiguration deserializationConfiguration, JavaClassDataFinder javaClassDataFinder, BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, NotFoundClasses notFoundClasses, ErrorReporter errorReporter, LookupTracker lookupTracker, ContractDeserializer contractDeserializer, NewKotlinTypeChecker newKotlinTypeChecker, TypeAttributeTranslators typeAttributeTranslators) {
        PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
        AdditionalClassPartsProvider additionalClassPartsProvider;
        StorageManager storageManager2 = storageManager;
        JavaClassDataFinder javaClassDataFinder2 = javaClassDataFinder;
        BinaryClassAnnotationAndConstantLoaderImpl binaryClassAnnotationAndConstantLoaderImpl2 = binaryClassAnnotationAndConstantLoaderImpl;
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(deserializationConfiguration, "configuration");
        Intrinsics.checkNotNullParameter(javaClassDataFinder2, "classDataFinder");
        Intrinsics.checkNotNullParameter(binaryClassAnnotationAndConstantLoaderImpl2, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider2, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(lookupTracker, "lookupTracker");
        Intrinsics.checkNotNullParameter(contractDeserializer, "contractDeserializer");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(typeAttributeTranslators, "typeAttributeTranslators");
        KotlinBuiltIns builtIns = moduleDescriptor.getBuiltIns();
        JvmBuiltIns jvmBuiltIns = builtIns instanceof JvmBuiltIns ? (JvmBuiltIns) builtIns : null;
        DeserializationComponents deserializationComponents = r0;
        DeserializationComponents deserializationComponents2 = new DeserializationComponents(storageManager, moduleDescriptor, deserializationConfiguration, javaClassDataFinder2, binaryClassAnnotationAndConstantLoaderImpl2, lazyJavaPackageFragmentProvider2, LocalClassifierTypeSettings.Default.INSTANCE, errorReporter, lookupTracker, JavaFlexibleTypeDeserializer.INSTANCE, CollectionsKt.emptyList(), notFoundClasses, contractDeserializer, (jvmBuiltIns == null || (additionalClassPartsProvider = jvmBuiltIns.getCustomizer()) == null) ? AdditionalClassPartsProvider.None.INSTANCE : additionalClassPartsProvider, (jvmBuiltIns == null || (platformDependentDeclarationFilter = jvmBuiltIns.getCustomizer()) == null) ? PlatformDependentDeclarationFilter.NoPlatformDependent.INSTANCE : platformDependentDeclarationFilter, JvmProtoBufUtil.INSTANCE.getEXTENSION_REGISTRY(), newKotlinTypeChecker, new SamConversionResolverImpl(storageManager2, CollectionsKt.emptyList()), (PlatformDependentTypeTransformer) null, typeAttributeTranslators.getTranslators(), 262144, (DefaultConstructorMarker) null);
        this.components = deserializationComponents;
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    /* compiled from: DeserializationComponentsForJava.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* compiled from: DeserializationComponentsForJava.kt */
        public static final class ModuleData {
            private final DeserializationComponentsForJava deserializationComponentsForJava;
            private final DeserializedDescriptorResolver deserializedDescriptorResolver;

            public ModuleData(DeserializationComponentsForJava deserializationComponentsForJava2, DeserializedDescriptorResolver deserializedDescriptorResolver2) {
                Intrinsics.checkNotNullParameter(deserializationComponentsForJava2, "deserializationComponentsForJava");
                Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
                this.deserializationComponentsForJava = deserializationComponentsForJava2;
                this.deserializedDescriptorResolver = deserializedDescriptorResolver2;
            }

            public final DeserializationComponentsForJava getDeserializationComponentsForJava() {
                return this.deserializationComponentsForJava;
            }

            public final DeserializedDescriptorResolver getDeserializedDescriptorResolver() {
                return this.deserializedDescriptorResolver;
            }
        }

        public final ModuleData createModuleData(KotlinClassFinder kotlinClassFinder, KotlinClassFinder kotlinClassFinder2, JavaClassFinder javaClassFinder, String str, ErrorReporter errorReporter, JavaSourceElementFactory javaSourceElementFactory) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
            Intrinsics.checkNotNullParameter(kotlinClassFinder2, "jvmBuiltInsKotlinClassFinder");
            JavaClassFinder javaClassFinder2 = javaClassFinder;
            Intrinsics.checkNotNullParameter(javaClassFinder2, "javaClassFinder");
            Intrinsics.checkNotNullParameter(str2, "moduleName");
            Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
            JavaSourceElementFactory javaSourceElementFactory2 = javaSourceElementFactory;
            Intrinsics.checkNotNullParameter(javaSourceElementFactory2, "javaSourceElementFactory");
            StorageManager lockBasedStorageManager = new LockBasedStorageManager("DeserializationComponentsForJava.ModuleData");
            JvmBuiltIns jvmBuiltIns = new JvmBuiltIns(lockBasedStorageManager, JvmBuiltIns.Kind.FROM_DEPENDENCIES);
            Name special = Name.special(Typography.less + str2 + Typography.greater);
            Intrinsics.checkNotNullExpressionValue(special, "special(\"<$moduleName>\")");
            ModuleDescriptorImpl moduleDescriptorImpl = new ModuleDescriptorImpl(special, lockBasedStorageManager, jvmBuiltIns, (TargetPlatform) null, (Map) null, (Name) null, 56, (DefaultConstructorMarker) null);
            jvmBuiltIns.setBuiltInsModule(moduleDescriptorImpl);
            ModuleDescriptor moduleDescriptor = moduleDescriptorImpl;
            jvmBuiltIns.initialize(moduleDescriptor, true);
            DeserializedDescriptorResolver deserializedDescriptorResolver = new DeserializedDescriptorResolver();
            SingleModuleClassResolver singleModuleClassResolver = new SingleModuleClassResolver();
            NotFoundClasses notFoundClasses = new NotFoundClasses(lockBasedStorageManager, moduleDescriptor);
            NotFoundClasses notFoundClasses2 = notFoundClasses;
            NotFoundClasses notFoundClasses3 = notFoundClasses;
            KotlinClassFinder kotlinClassFinder3 = kotlinClassFinder;
            SingleModuleClassResolver singleModuleClassResolver2 = singleModuleClassResolver;
            DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
            DeserializedDescriptorResolver deserializedDescriptorResolver3 = deserializedDescriptorResolver;
            ErrorReporter errorReporter2 = errorReporter;
            ModuleDescriptorImpl moduleDescriptorImpl2 = moduleDescriptorImpl;
            JvmBuiltIns jvmBuiltIns2 = jvmBuiltIns;
            LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default = DeserializationComponentsForJavaKt.makeLazyJavaPackageFragmentProvider$default(javaClassFinder2, moduleDescriptor, lockBasedStorageManager, notFoundClasses2, kotlinClassFinder3, deserializedDescriptorResolver2, errorReporter2, javaSourceElementFactory2, singleModuleClassResolver, (PackagePartProvider) null, 512, (Object) null);
            DeserializationComponentsForJava makeDeserializationComponentsForJava = DeserializationComponentsForJavaKt.makeDeserializationComponentsForJava(moduleDescriptor, lockBasedStorageManager, notFoundClasses3, makeLazyJavaPackageFragmentProvider$default, kotlinClassFinder3, deserializedDescriptorResolver3, errorReporter2);
            DeserializedDescriptorResolver deserializedDescriptorResolver4 = deserializedDescriptorResolver3;
            deserializedDescriptorResolver4.setComponents(makeDeserializationComponentsForJava);
            JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
            Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
            JavaDescriptorResolver javaDescriptorResolver = new JavaDescriptorResolver(makeLazyJavaPackageFragmentProvider$default, javaResolverCache);
            singleModuleClassResolver2.setResolver(javaDescriptorResolver);
            JvmBuiltInsPackageFragmentProvider jvmBuiltInsPackageFragmentProvider = new JvmBuiltInsPackageFragmentProvider(lockBasedStorageManager, kotlinClassFinder2, moduleDescriptor, notFoundClasses3, jvmBuiltIns2.getCustomizer(), jvmBuiltIns2.getCustomizer(), DeserializationConfiguration.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), new SamConversionResolverImpl(lockBasedStorageManager, CollectionsKt.emptyList()));
            ModuleDescriptorImpl moduleDescriptorImpl3 = moduleDescriptorImpl2;
            moduleDescriptorImpl3.setDependencies(moduleDescriptorImpl3);
            moduleDescriptorImpl3.initialize(new CompositePackageFragmentProvider(CollectionsKt.listOf(javaDescriptorResolver.getPackageFragmentProvider(), jvmBuiltInsPackageFragmentProvider), "CompositeProvider@RuntimeModuleData for " + moduleDescriptorImpl3));
            return new ModuleData(makeDeserializationComponentsForJava, deserializedDescriptorResolver4);
        }
    }
}
