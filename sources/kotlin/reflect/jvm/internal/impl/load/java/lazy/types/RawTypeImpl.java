package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: RawType.kt */
public final class RawTypeImpl extends FlexibleType implements RawType {
    private RawTypeImpl(SimpleType simpleType, SimpleType simpleType2, boolean z) {
        super(simpleType, simpleType2);
        if (!z) {
            KotlinTypeChecker.DEFAULT.isSubtypeOf(simpleType, simpleType2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RawTypeImpl(SimpleType simpleType, SimpleType simpleType2) {
        this(simpleType, simpleType2, false);
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
    }

    public SimpleType getDelegate() {
        return getLowerBound();
    }

    public MemberScope getMemberScope() {
        ClassifierDescriptor declarationDescriptor = getConstructor().getDeclarationDescriptor();
        ClassDescriptor classDescriptor = declarationDescriptor instanceof ClassDescriptor ? (ClassDescriptor) declarationDescriptor : null;
        if (classDescriptor != null) {
            MemberScope memberScope = classDescriptor.getMemberScope(new RawSubstitution((TypeParameterUpperBoundEraser) null, 1, (DefaultConstructorMarker) null));
            Intrinsics.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution())");
            return memberScope;
        }
        throw new IllegalStateException(("Incorrect classifier: " + getConstructor().getDeclarationDescriptor()).toString());
    }

    public RawTypeImpl replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new RawTypeImpl(getLowerBound().replaceAttributes(typeAttributes), getUpperBound().replaceAttributes(typeAttributes));
    }

    public RawTypeImpl makeNullableAsSpecified(boolean z) {
        return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(z), getUpperBound().makeNullableAsSpecified(z));
    }

    private static final boolean render$onlyOutDiffers(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) StringsKt.removePrefix(str2, (CharSequence) "out ")) || Intrinsics.areEqual((Object) str2, (Object) ProxyConfig.MATCH_ALL_SCHEMES);
    }

    private static final List<String> render$renderArguments(DescriptorRenderer descriptorRenderer, KotlinType kotlinType) {
        Iterable<TypeProjection> arguments = kotlinType.getArguments();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(arguments, 10));
        for (TypeProjection renderTypeProjection : arguments) {
            arrayList.add(descriptorRenderer.renderTypeProjection(renderTypeProjection));
        }
        return (List) arrayList;
    }

    private static final String render$replaceArgs(String str, String str2) {
        if (!StringsKt.contains$default((CharSequence) str, (char) Typography.less, false, 2, (Object) null)) {
            return str;
        }
        return StringsKt.substringBefore$default(str, (char) Typography.less, (String) null, 2, (Object) null) + Typography.less + str2 + Typography.greater + StringsKt.substringAfterLast$default(str, (char) Typography.greater, (String) null, 2, (Object) null);
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        String renderType = descriptorRenderer.renderType(getLowerBound());
        String renderType2 = descriptorRenderer.renderType(getUpperBound());
        if (descriptorRendererOptions.getDebugMode()) {
            return "raw (" + renderType + ".." + renderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return descriptorRenderer.renderFlexibleType(renderType, renderType2, TypeUtilsKt.getBuiltIns(this));
        }
        List<String> render$renderArguments = render$renderArguments(descriptorRenderer, getLowerBound());
        List<String> render$renderArguments2 = render$renderArguments(descriptorRenderer, getUpperBound());
        Iterable iterable = render$renderArguments;
        String joinToString$default = CollectionsKt.joinToString$default(iterable, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, RawTypeImpl$render$newArgs$1.INSTANCE, 30, (Object) null);
        Iterable zip = CollectionsKt.zip(iterable, render$renderArguments2);
        boolean z = true;
        if (!(zip instanceof Collection) || !((Collection) zip).isEmpty()) {
            Iterator it = zip.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pair pair = (Pair) it.next();
                if (!render$onlyOutDiffers((String) pair.getFirst(), (String) pair.getSecond())) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            renderType2 = render$replaceArgs(renderType2, joinToString$default);
        }
        String render$replaceArgs = render$replaceArgs(renderType, joinToString$default);
        if (Intrinsics.areEqual((Object) render$replaceArgs, (Object) renderType2)) {
            return render$replaceArgs;
        }
        return descriptorRenderer.renderFlexibleType(render$replaceArgs, renderType2, TypeUtilsKt.getBuiltIns(this));
    }

    public FlexibleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getLowerBound());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        KotlinType refineType2 = kotlinTypeRefiner.refineType(getUpperBound());
        Intrinsics.checkNotNull(refineType2, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new RawTypeImpl((SimpleType) refineType, (SimpleType) refineType2, true);
    }
}
