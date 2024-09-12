package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;
import kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker;

/* compiled from: context.kt */
public final class DeserializationComponents {
    private final AdditionalClassPartsProvider additionalClassPartsProvider;
    private final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> annotationAndConstantLoader;
    private final ClassDataFinder classDataFinder;
    private final ClassDeserializer classDeserializer;
    private final DeserializationConfiguration configuration;
    private final ContractDeserializer contractDeserializer;
    private final ErrorReporter errorReporter;
    private final ExtensionRegistryLite extensionRegistryLite;
    private final Iterable<ClassDescriptorFactory> fictitiousClassDescriptorFactories;
    private final FlexibleTypeDeserializer flexibleTypeDeserializer;
    private final NewKotlinTypeChecker kotlinTypeChecker;
    private final LocalClassifierTypeSettings localClassifierTypeSettings;
    private final LookupTracker lookupTracker;
    private final ModuleDescriptor moduleDescriptor;
    private final NotFoundClasses notFoundClasses;
    private final PackageFragmentProvider packageFragmentProvider;
    private final PlatformDependentDeclarationFilter platformDependentDeclarationFilter;
    private final PlatformDependentTypeTransformer platformDependentTypeTransformer;
    private final SamConversionResolver samConversionResolver;
    private final StorageManager storageManager;
    private final List<TypeAttributeTranslator> typeAttributeTranslators;

    public DeserializationComponents(StorageManager storageManager2, ModuleDescriptor moduleDescriptor2, DeserializationConfiguration deserializationConfiguration, ClassDataFinder classDataFinder2, AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader2, PackageFragmentProvider packageFragmentProvider2, LocalClassifierTypeSettings localClassifierTypeSettings2, ErrorReporter errorReporter2, LookupTracker lookupTracker2, FlexibleTypeDeserializer flexibleTypeDeserializer2, Iterable<? extends ClassDescriptorFactory> iterable, NotFoundClasses notFoundClasses2, ContractDeserializer contractDeserializer2, AdditionalClassPartsProvider additionalClassPartsProvider2, PlatformDependentDeclarationFilter platformDependentDeclarationFilter2, ExtensionRegistryLite extensionRegistryLite2, NewKotlinTypeChecker newKotlinTypeChecker, SamConversionResolver samConversionResolver2, PlatformDependentTypeTransformer platformDependentTypeTransformer2, List<? extends TypeAttributeTranslator> list) {
        StorageManager storageManager3 = storageManager2;
        ModuleDescriptor moduleDescriptor3 = moduleDescriptor2;
        DeserializationConfiguration deserializationConfiguration2 = deserializationConfiguration;
        ClassDataFinder classDataFinder3 = classDataFinder2;
        AnnotationAndConstantLoader<? extends AnnotationDescriptor, ? extends ConstantValue<?>> annotationAndConstantLoader3 = annotationAndConstantLoader2;
        PackageFragmentProvider packageFragmentProvider3 = packageFragmentProvider2;
        LocalClassifierTypeSettings localClassifierTypeSettings3 = localClassifierTypeSettings2;
        ErrorReporter errorReporter3 = errorReporter2;
        LookupTracker lookupTracker3 = lookupTracker2;
        FlexibleTypeDeserializer flexibleTypeDeserializer3 = flexibleTypeDeserializer2;
        Iterable<? extends ClassDescriptorFactory> iterable2 = iterable;
        NotFoundClasses notFoundClasses3 = notFoundClasses2;
        ContractDeserializer contractDeserializer3 = contractDeserializer2;
        AdditionalClassPartsProvider additionalClassPartsProvider3 = additionalClassPartsProvider2;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite2;
        Intrinsics.checkNotNullParameter(storageManager3, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor3, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(deserializationConfiguration2, "configuration");
        Intrinsics.checkNotNullParameter(classDataFinder3, "classDataFinder");
        Intrinsics.checkNotNullParameter(annotationAndConstantLoader3, "annotationAndConstantLoader");
        Intrinsics.checkNotNullParameter(packageFragmentProvider3, "packageFragmentProvider");
        Intrinsics.checkNotNullParameter(localClassifierTypeSettings3, "localClassifierTypeSettings");
        Intrinsics.checkNotNullParameter(errorReporter3, "errorReporter");
        Intrinsics.checkNotNullParameter(lookupTracker3, "lookupTracker");
        Intrinsics.checkNotNullParameter(flexibleTypeDeserializer3, "flexibleTypeDeserializer");
        Intrinsics.checkNotNullParameter(iterable2, "fictitiousClassDescriptorFactories");
        Intrinsics.checkNotNullParameter(notFoundClasses3, "notFoundClasses");
        Intrinsics.checkNotNullParameter(contractDeserializer3, "contractDeserializer");
        Intrinsics.checkNotNullParameter(additionalClassPartsProvider3, "additionalClassPartsProvider");
        Intrinsics.checkNotNullParameter(platformDependentDeclarationFilter2, "platformDependentDeclarationFilter");
        Intrinsics.checkNotNullParameter(extensionRegistryLite2, "extensionRegistryLite");
        Intrinsics.checkNotNullParameter(newKotlinTypeChecker, "kotlinTypeChecker");
        Intrinsics.checkNotNullParameter(samConversionResolver2, "samConversionResolver");
        Intrinsics.checkNotNullParameter(platformDependentTypeTransformer2, "platformDependentTypeTransformer");
        Intrinsics.checkNotNullParameter(list, "typeAttributeTranslators");
        this.storageManager = storageManager3;
        this.moduleDescriptor = moduleDescriptor3;
        this.configuration = deserializationConfiguration2;
        this.classDataFinder = classDataFinder3;
        this.annotationAndConstantLoader = annotationAndConstantLoader3;
        this.packageFragmentProvider = packageFragmentProvider3;
        this.localClassifierTypeSettings = localClassifierTypeSettings3;
        this.errorReporter = errorReporter3;
        this.lookupTracker = lookupTracker3;
        this.flexibleTypeDeserializer = flexibleTypeDeserializer3;
        this.fictitiousClassDescriptorFactories = iterable2;
        this.notFoundClasses = notFoundClasses3;
        this.contractDeserializer = contractDeserializer3;
        this.additionalClassPartsProvider = additionalClassPartsProvider3;
        this.platformDependentDeclarationFilter = platformDependentDeclarationFilter2;
        this.extensionRegistryLite = extensionRegistryLite2;
        this.kotlinTypeChecker = newKotlinTypeChecker;
        this.samConversionResolver = samConversionResolver2;
        this.platformDependentTypeTransformer = platformDependentTypeTransformer2;
        this.typeAttributeTranslators = list;
        this.classDeserializer = new ClassDeserializer(this);
    }

    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    public final DeserializationConfiguration getConfiguration() {
        return this.configuration;
    }

    public final ClassDataFinder getClassDataFinder() {
        return this.classDataFinder;
    }

    public final AnnotationAndConstantLoader<AnnotationDescriptor, ConstantValue<?>> getAnnotationAndConstantLoader() {
        return this.annotationAndConstantLoader;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        return this.packageFragmentProvider;
    }

    public final LocalClassifierTypeSettings getLocalClassifierTypeSettings() {
        return this.localClassifierTypeSettings;
    }

    public final ErrorReporter getErrorReporter() {
        return this.errorReporter;
    }

    public final LookupTracker getLookupTracker() {
        return this.lookupTracker;
    }

    public final FlexibleTypeDeserializer getFlexibleTypeDeserializer() {
        return this.flexibleTypeDeserializer;
    }

    public final Iterable<ClassDescriptorFactory> getFictitiousClassDescriptorFactories() {
        return this.fictitiousClassDescriptorFactories;
    }

    public final NotFoundClasses getNotFoundClasses() {
        return this.notFoundClasses;
    }

    public final ContractDeserializer getContractDeserializer() {
        return this.contractDeserializer;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DeserializationComponents(kotlin.reflect.jvm.internal.impl.storage.StorageManager r24, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r25, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r26, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader r28, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r29, kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings r30, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r31, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker r32, kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer r33, java.lang.Iterable r34, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r35, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer r36, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r37, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r38, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r39, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r40, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver r41, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer r42, java.util.List r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r23 = this;
            r0 = r44
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x000d
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider$None r1 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider.None.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider) r1
            r16 = r1
            goto L_0x000f
        L_0x000d:
            r16 = r37
        L_0x000f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x001a
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter$All r1 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter.All.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter) r1
            r17 = r1
            goto L_0x001c
        L_0x001a:
            r17 = r38
        L_0x001c:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x002c
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker$Companion r1 = kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker.Companion
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeCheckerImpl r1 = r1.getDefault()
            kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r1 = (kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker) r1
            r19 = r1
            goto L_0x002e
        L_0x002c:
            r19 = r40
        L_0x002e:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x003a
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer$None r1 = kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer.None.INSTANCE
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer) r1
            r21 = r1
            goto L_0x003c
        L_0x003a:
            r21 = r42
        L_0x003c:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x004a
            kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator r0 = kotlin.reflect.jvm.internal.impl.types.DefaultTypeAttributeTranslator.INSTANCE
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            r22 = r0
            goto L_0x004c
        L_0x004a:
            r22 = r43
        L_0x004c:
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r11 = r32
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            r18 = r39
            r20 = r41
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader, kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider, kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter, kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker, kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer, java.lang.Iterable, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses, kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return this.additionalClassPartsProvider;
    }

    public final PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return this.platformDependentDeclarationFilter;
    }

    public final ExtensionRegistryLite getExtensionRegistryLite() {
        return this.extensionRegistryLite;
    }

    public final NewKotlinTypeChecker getKotlinTypeChecker() {
        return this.kotlinTypeChecker;
    }

    public final PlatformDependentTypeTransformer getPlatformDependentTypeTransformer() {
        return this.platformDependentTypeTransformer;
    }

    public final List<TypeAttributeTranslator> getTypeAttributeTranslators() {
        return this.typeAttributeTranslators;
    }

    public final ClassDeserializer getClassDeserializer() {
        return this.classDeserializer;
    }

    public final ClassDescriptor deserializeClass(ClassId classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        return ClassDeserializer.deserializeClass$default(this.classDeserializer, classId, (ClassData) null, 2, (Object) null);
    }

    public final DeserializationContext createContext(PackageFragmentDescriptor packageFragmentDescriptor, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics.checkNotNullParameter(packageFragmentDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics.checkNotNullParameter(typeTable, "typeTable");
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        Intrinsics.checkNotNullParameter(versionRequirementTable2, "versionRequirementTable");
        BinaryVersion binaryVersion2 = binaryVersion;
        Intrinsics.checkNotNullParameter(binaryVersion2, "metadataVersion");
        return new DeserializationContext(this, nameResolver, packageFragmentDescriptor, typeTable, versionRequirementTable2, binaryVersion2, deserializedContainerSource, (TypeDeserializer) null, CollectionsKt.emptyList());
    }
}
