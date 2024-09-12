package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaPropertyInitializerEvaluator;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.components.SignaturePropagator;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.ModuleClassResolver;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElementFactory;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.kotlin.PackagePartProvider;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.SyntheticJavaPartsProvider;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolverImpl;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.extensions.TypeAttributeTranslators;

/* compiled from: DeserializationComponentsForJava.kt */
public final class DeserializationComponentsForJavaKt {
    public static /* synthetic */ LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider$default(JavaClassFinder javaClassFinder, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ErrorReporter errorReporter, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider, int i, Object obj) {
        PackagePartProvider packagePartProvider2;
        if ((i & 512) != 0) {
            packagePartProvider2 = PackagePartProvider.Empty.INSTANCE;
        } else {
            packagePartProvider2 = packagePartProvider;
        }
        return makeLazyJavaPackageFragmentProvider(javaClassFinder, moduleDescriptor, storageManager, notFoundClasses, kotlinClassFinder, deserializedDescriptorResolver, errorReporter, javaSourceElementFactory, moduleClassResolver, packagePartProvider2);
    }

    public static final LazyJavaPackageFragmentProvider makeLazyJavaPackageFragmentProvider(JavaClassFinder javaClassFinder, ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ErrorReporter errorReporter, JavaSourceElementFactory javaSourceElementFactory, ModuleClassResolver moduleClassResolver, PackagePartProvider packagePartProvider) {
        StorageManager storageManager2 = storageManager;
        JavaClassFinder javaClassFinder2 = javaClassFinder;
        Intrinsics.checkNotNullParameter(javaClassFinder, "javaClassFinder");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver, "deserializedDescriptorResolver");
        Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
        Intrinsics.checkNotNullParameter(javaSourceElementFactory, "javaSourceElementFactory");
        Intrinsics.checkNotNullParameter(moduleClassResolver, "singleModuleClassResolver");
        Intrinsics.checkNotNullParameter(packagePartProvider, "packagePartProvider");
        SignaturePropagator signaturePropagator = SignaturePropagator.DO_NOTHING;
        SignaturePropagator signaturePropagator2 = signaturePropagator;
        JavaResolverComponents javaResolverComponents = r0;
        Intrinsics.checkNotNullExpressionValue(signaturePropagator, "DO_NOTHING");
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        JavaResolverCache javaResolverCache2 = javaResolverCache;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        JavaPropertyInitializerEvaluator javaPropertyInitializerEvaluator = JavaPropertyInitializerEvaluator.DoNothing.INSTANCE;
        JavaResolverComponents javaResolverComponents2 = javaResolverComponents;
        SamConversionResolver samConversionResolverImpl = new SamConversionResolverImpl(storageManager2, CollectionsKt.emptyList());
        SupertypeLoopChecker supertypeLoopChecker = SupertypeLoopChecker.EMPTY.INSTANCE;
        LookupTracker lookupTracker = LookupTracker.DO_NOTHING.INSTANCE;
        JavaClassFinder javaClassFinder3 = javaClassFinder2;
        ReflectionTypes reflectionTypes = r2;
        ReflectionTypes reflectionTypes2 = new ReflectionTypes(moduleDescriptor, notFoundClasses);
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver = r0;
        AnnotationTypeQualifierResolver annotationTypeQualifierResolver2 = new AnnotationTypeQualifierResolver(JavaTypeEnhancementState.Companion.getDEFAULT());
        SignatureEnhancement signatureEnhancement = r0;
        SignatureEnhancement signatureEnhancement2 = new SignatureEnhancement(new JavaTypeEnhancement(JavaResolverSettings.Default.INSTANCE));
        StorageManager storageManager3 = storageManager;
        JavaClassFinder javaClassFinder4 = javaClassFinder3;
        JavaResolverComponents javaResolverComponents3 = new JavaResolverComponents(storageManager3, javaClassFinder4, kotlinClassFinder, deserializedDescriptorResolver, signaturePropagator2, errorReporter, javaResolverCache2, javaPropertyInitializerEvaluator, samConversionResolverImpl, javaSourceElementFactory, moduleClassResolver, packagePartProvider, supertypeLoopChecker, lookupTracker, moduleDescriptor, reflectionTypes, annotationTypeQualifierResolver, signatureEnhancement, JavaClassesTracker.Default.INSTANCE, JavaResolverSettings.Default.INSTANCE, NewKotlinTypeChecker.Companion.getDefault(), JavaTypeEnhancementState.Companion.getDEFAULT(), new DeserializationComponentsForJavaKt$makeLazyJavaPackageFragmentProvider$javaResolverComponents$1(), (SyntheticJavaPartsProvider) null, 8388608, (DefaultConstructorMarker) null);
        return new LazyJavaPackageFragmentProvider(javaResolverComponents);
    }

    public static final DeserializationComponentsForJava makeDeserializationComponentsForJava(ModuleDescriptor moduleDescriptor, StorageManager storageManager, NotFoundClasses notFoundClasses, LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, KotlinClassFinder kotlinClassFinder, DeserializedDescriptorResolver deserializedDescriptorResolver, ErrorReporter errorReporter) {
        StorageManager storageManager2 = storageManager;
        NotFoundClasses notFoundClasses2 = notFoundClasses;
        KotlinClassFinder kotlinClassFinder2 = kotlinClassFinder;
        DeserializedDescriptorResolver deserializedDescriptorResolver2 = deserializedDescriptorResolver;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(notFoundClasses2, "notFoundClasses");
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider2 = lazyJavaPackageFragmentProvider;
        Intrinsics.checkNotNullParameter(lazyJavaPackageFragmentProvider2, "lazyJavaPackageFragmentProvider");
        Intrinsics.checkNotNullParameter(kotlinClassFinder2, "reflectKotlinClassFinder");
        Intrinsics.checkNotNullParameter(deserializedDescriptorResolver2, "deserializedDescriptorResolver");
        ErrorReporter errorReporter2 = errorReporter;
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        return new DeserializationComponentsForJava(storageManager2, moduleDescriptor, DeserializationConfiguration.Default.INSTANCE, new JavaClassDataFinder(kotlinClassFinder2, deserializedDescriptorResolver2), new BinaryClassAnnotationAndConstantLoaderImpl(moduleDescriptor, notFoundClasses2, storageManager, kotlinClassFinder2), lazyJavaPackageFragmentProvider2, notFoundClasses2, errorReporter2, LookupTracker.DO_NOTHING.INSTANCE, ContractDeserializer.Companion.getDEFAULT(), NewKotlinTypeChecker.Companion.getDefault(), new TypeAttributeTranslators(CollectionsKt.listOf(DefaultTypeAttributeTranslator.INSTANCE)));
    }
}
