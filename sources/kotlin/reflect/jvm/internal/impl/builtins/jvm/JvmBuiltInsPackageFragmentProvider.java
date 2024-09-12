package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AbstractDeserializedPackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragment;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsPackageFragmentImpl;

/* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
public final class JvmBuiltInsPackageFragmentProvider extends AbstractDeserializedPackageFragmentProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public JvmBuiltInsPackageFragmentProvider(kotlin.reflect.jvm.internal.impl.storage.StorageManager r26, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder r27, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor r28, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses r29, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider r30, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter r31, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration r32, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker r33, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver r34) {
        /*
            r25 = this;
            r0 = r25
            r12 = r26
            r1 = r27
            r14 = r28
            r6 = r29
            r2 = r26
            r3 = r28
            r13 = r29
            r15 = r30
            r16 = r31
            r4 = r32
            r18 = r33
            r19 = r34
            java.lang.String r5 = "storageManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r5)
            java.lang.String r5 = "finder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r5)
            java.lang.String r5 = "moduleDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            java.lang.String r5 = "notFoundClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r5)
            java.lang.String r5 = "additionalClassPartsProvider"
            r7 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            java.lang.String r5 = "platformDependentDeclarationFilter"
            r7 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            java.lang.String r5 = "deserializationConfiguration"
            r7 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            java.lang.String r5 = "kotlinTypeChecker"
            r7 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            java.lang.String r5 = "samConversionResolver"
            r7 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r5)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder r1 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.KotlinMetadataFinder) r1
            r0.<init>(r12, r1, r14)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents r11 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents
            r1 = r11
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder r5 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedClassDataFinder
            r8 = r0
            kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider r8 = (kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider) r8
            r7 = r8
            r5.<init>(r8)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder r5 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder) r5
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl r8 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoaderImpl
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r9 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE
            kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol r9 = (kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol) r9
            r8.<init>(r14, r6, r9)
            r6 = r8
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader r6 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader) r6
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings$Default r8 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings.Default.INSTANCE
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings r8 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.LocalClassifierTypeSettings) r8
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter r10 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ErrorReporter.DO_NOTHING
            r9 = r10
            r27 = r11
            java.lang.String r11 = "DO_NOTHING"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker$DO_NOTHING r10 = kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker.DO_NOTHING.INSTANCE
            kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker r10 = (kotlin.reflect.jvm.internal.impl.incremental.components.LookupTracker) r10
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer$ThrowException r11 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer.ThrowException.INSTANCE
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer r11 = (kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer) r11
            r24 = r27
            r0 = 2
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory[] r0 = new kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory[r0]
            r27 = r1
            kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory r1 = new kotlin.reflect.jvm.internal.impl.builtins.functions.BuiltInFictitiousFunctionClassFactory
            r1.<init>(r12, r14)
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r1
            r17 = 0
            r0[r17] = r1
            kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory r1 = new kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInClassDescriptorFactory
            r17 = 0
            r20 = 4
            r21 = 0
            r29 = r1
            r30 = r26
            r31 = r28
            r32 = r17
            r33 = r20
            r34 = r21
            r29.<init>(r30, r31, r32, r33, r34)
            kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory r1 = (kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory) r1
            r12 = 1
            r0[r12] = r1
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            r12 = r0
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer$Companion r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer.Companion
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.ContractDeserializer r14 = r0.getDEFAULT()
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol r0 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInSerializerProtocol.INSTANCE
            kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite r17 = r0.getExtensionRegistry()
            r20 = 0
            r22 = 786432(0xc0000, float:1.102026E-39)
            r23 = 0
            r1 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r0 = r25
            r1 = r24
            r0.setComponents(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsPackageFragmentProvider.<init>(kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinder, kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider, kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter, kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationConfiguration, kotlin.reflect.jvm.internal.impl.types.checker.NewKotlinTypeChecker, kotlin.reflect.jvm.internal.impl.resolve.sam.SamConversionResolver):void");
    }

    /* access modifiers changed from: protected */
    public DeserializedPackageFragment findPackage(FqName fqName) {
        BuiltInsPackageFragmentImpl builtInsPackageFragmentImpl;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        InputStream findBuiltInsData = getFinder().findBuiltInsData(fqName);
        if (findBuiltInsData != null) {
            builtInsPackageFragmentImpl = BuiltInsPackageFragmentImpl.Companion.create(fqName, getStorageManager(), getModuleDescriptor(), findBuiltInsData, false);
        } else {
            builtInsPackageFragmentImpl = null;
        }
        return builtInsPackageFragmentImpl;
    }

    /* compiled from: JvmBuiltInsPackageFragmentProvider.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
