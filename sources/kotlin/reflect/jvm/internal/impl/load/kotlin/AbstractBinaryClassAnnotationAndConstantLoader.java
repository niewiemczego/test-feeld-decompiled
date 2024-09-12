package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationLoader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
public abstract class AbstractBinaryClassAnnotationAndConstantLoader<A, C> extends AbstractBinaryClassAnnotationLoader<A, AnnotationsContainerWithConstants<? extends A, ? extends C>> implements AnnotationAndConstantLoader<A, C> {
    private final MemoizedFunctionToNotNull<KotlinJvmBinaryClass, AnnotationsContainerWithConstants<A, C>> storage;

    /* access modifiers changed from: protected */
    public abstract C loadConstant(String str, Object obj);

    /* access modifiers changed from: protected */
    public abstract C transformToUnsignedConstant(C c);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractBinaryClassAnnotationAndConstantLoader(StorageManager storageManager, KotlinClassFinder kotlinClassFinder) {
        super(kotlinClassFinder);
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinClassFinder, "kotlinClassFinder");
        this.storage = storageManager.createMemoizedFunction(new AbstractBinaryClassAnnotationAndConstantLoader$storage$1(this));
    }

    /* access modifiers changed from: protected */
    public AnnotationsContainerWithConstants<A, C> getAnnotationsContainer(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics.checkNotNullParameter(kotlinJvmBinaryClass, "binaryClass");
        return this.storage.invoke(kotlinJvmBinaryClass);
    }

    public C loadAnnotationDefaultValue(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY_GETTER, kotlinType, AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationDefaultValue$1.INSTANCE);
    }

    public C loadPropertyConstant(ProtoContainer protoContainer, ProtoBuf.Property property, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(protoContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(property, "proto");
        Intrinsics.checkNotNullParameter(kotlinType, "expectedType");
        return loadConstantFromProperty(protoContainer, property, AnnotatedCallableKind.PROPERTY, kotlinType, AbstractBinaryClassAnnotationAndConstantLoader$loadPropertyConstant$1.INSTANCE);
    }

    private final C loadConstantFromProperty(ProtoContainer protoContainer, ProtoBuf.Property property, AnnotatedCallableKind annotatedCallableKind, KotlinType kotlinType, Function2<? super AnnotationsContainerWithConstants<? extends A, ? extends C>, ? super MemberSignature, ? extends C> function2) {
        MemberSignature callableSignature;
        C invoke;
        KotlinJvmBinaryClass findClassWithAnnotationsAndInitializers = findClassWithAnnotationsAndInitializers(protoContainer, getSpecialCaseContainerClass(protoContainer, true, true, Flags.IS_CONST.get(property.getFlags()), JvmProtoBufUtil.isMovedFromInterfaceCompanion(property)));
        if (findClassWithAnnotationsAndInitializers == null || (callableSignature = getCallableSignature(property, protoContainer.getNameResolver(), protoContainer.getTypeTable(), annotatedCallableKind, findClassWithAnnotationsAndInitializers.getClassHeader().getMetadataVersion().isAtLeast(DeserializedDescriptorResolver.Companion.getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm()))) == null || (invoke = function2.invoke(this.storage.invoke(findClassWithAnnotationsAndInitializers), callableSignature)) == null) {
            return null;
        }
        return UnsignedTypes.isUnsignedType(kotlinType) ? transformToUnsignedConstant(invoke) : invoke;
    }

    /* access modifiers changed from: private */
    public final AnnotationsContainerWithConstants<A, C> loadAnnotationsAndInitializers(KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        kotlinJvmBinaryClass.visitMembers(new AbstractBinaryClassAnnotationAndConstantLoader$loadAnnotationsAndInitializers$1(this, hashMap, kotlinJvmBinaryClass, hashMap3, hashMap2), getCachedFileContent(kotlinJvmBinaryClass));
        return new AnnotationsContainerWithConstants<>(hashMap, hashMap2, hashMap3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isRepeatableWithImplicitContainer(kotlin.reflect.jvm.internal.impl.name.ClassId r3, java.util.Map<kotlin.reflect.jvm.internal.impl.name.Name, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue<?>> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "annotationClassId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations r0 = kotlin.reflect.jvm.internal.impl.SpecialJvmAnnotations.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.ClassId r0 = r0.getJAVA_LANG_ANNOTATION_REPEATABLE()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            r0 = 0
            if (r3 != 0) goto L_0x0018
            return r0
        L_0x0018:
            java.lang.String r3 = "value"
            kotlin.reflect.jvm.internal.impl.name.Name r3 = kotlin.reflect.jvm.internal.impl.name.Name.identifier(r3)
            java.lang.Object r3 = r4.get(r3)
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue
            r1 = 0
            if (r4 == 0) goto L_0x002b
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue r3 = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue) r3
            goto L_0x002c
        L_0x002b:
            r3 = r1
        L_0x002c:
            if (r3 != 0) goto L_0x002f
            return r0
        L_0x002f:
            java.lang.Object r3 = r3.getValue()
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass
            if (r4 == 0) goto L_0x003a
            r1 = r3
            kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue$Value$NormalClass r1 = (kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.NormalClass) r1
        L_0x003a:
            if (r1 != 0) goto L_0x003d
            return r0
        L_0x003d:
            kotlin.reflect.jvm.internal.impl.name.ClassId r3 = r1.getClassId()
            boolean r3 = r2.isImplicitRepeatableContainer(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.kotlin.AbstractBinaryClassAnnotationAndConstantLoader.isRepeatableWithImplicitContainer(kotlin.reflect.jvm.internal.impl.name.ClassId, java.util.Map):boolean");
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public static final class AnnotationsContainerWithConstants<A, C> extends AbstractBinaryClassAnnotationLoader.AnnotationsContainer<A> {
        private final Map<MemberSignature, C> annotationParametersDefaultValues;
        private final Map<MemberSignature, List<A>> memberAnnotations;
        private final Map<MemberSignature, C> propertyConstants;

        public Map<MemberSignature, List<A>> getMemberAnnotations() {
            return this.memberAnnotations;
        }

        public final Map<MemberSignature, C> getPropertyConstants() {
            return this.propertyConstants;
        }

        public final Map<MemberSignature, C> getAnnotationParametersDefaultValues() {
            return this.annotationParametersDefaultValues;
        }

        public AnnotationsContainerWithConstants(Map<MemberSignature, ? extends List<? extends A>> map, Map<MemberSignature, ? extends C> map2, Map<MemberSignature, ? extends C> map3) {
            Intrinsics.checkNotNullParameter(map, "memberAnnotations");
            Intrinsics.checkNotNullParameter(map2, "propertyConstants");
            Intrinsics.checkNotNullParameter(map3, "annotationParametersDefaultValues");
            this.memberAnnotations = map;
            this.propertyConstants = map2;
            this.annotationParametersDefaultValues = map3;
        }
    }
}
