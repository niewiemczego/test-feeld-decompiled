package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;

/* compiled from: FunctionInvokeDescriptor.kt */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    public boolean isExternal() {
        return false;
    }

    public boolean isInline() {
        return false;
    }

    public boolean isTailrec() {
        return false;
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor doSubstitute(kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl.CopyConfiguration r7) {
        /*
            r6 = this;
            java.lang.String r0 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = super.doSubstitute(r7)
            kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor r7 = (kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor) r7
            if (r7 != 0) goto L_0x000f
            r7 = 0
            return r7
        L_0x000f:
            java.util.List r0 = r7.getValueParameters()
            java.lang.String r1 = "substituted.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 0
            java.lang.String r4 = "it.type"
            r5 = 1
            if (r2 == 0) goto L_0x002d
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x002d
        L_0x002b:
            r3 = r5
            goto L_0x004f
        L_0x002d:
            java.util.Iterator r0 = r0.iterator()
        L_0x0031:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r2 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r2)
            if (r2 == 0) goto L_0x004c
            r2 = r5
            goto L_0x004d
        L_0x004c:
            r2 = r3
        L_0x004d:
            if (r2 == 0) goto L_0x0031
        L_0x004f:
            if (r3 == 0) goto L_0x0054
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r7
            return r7
        L_0x0054:
            java.util.List r0 = r7.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x006e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0089
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            kotlin.reflect.jvm.internal.impl.name.Name r2 = kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(r2)
            r1.add(r2)
            goto L_0x006e
        L_0x0089:
            java.util.List r1 = (java.util.List) r1
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r7 = r7.replaceParameterNames(r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.doSubstitute(kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor");
    }

    /* access modifiers changed from: protected */
    public FunctionDescriptorImpl createSubstitutedCopy(DeclarationDescriptor declarationDescriptor, FunctionDescriptor functionDescriptor, CallableMemberDescriptor.Kind kind, Name name, Annotations annotations, SourceElement sourceElement) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(sourceElement, "source");
        return new FunctionInvokeDescriptor(declarationDescriptor, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    private final FunctionDescriptor replaceParameterNames(List<Name> list) {
        boolean z;
        Name name;
        boolean z2;
        int size = getValueParameters().size() - list.size();
        boolean z3 = true;
        if (size == 0) {
            List<ValueParameterDescriptor> valueParameters = getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            Iterable zip = CollectionsKt.zip(list, valueParameters);
            if (!(zip instanceof Collection) || !((Collection) zip).isEmpty()) {
                Iterator it = zip.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!Intrinsics.areEqual((Object) (Name) pair.component1(), (Object) ((ValueParameterDescriptor) pair.component2()).getName())) {
                        z2 = false;
                        break;
                    }
                }
            }
            z2 = true;
            if (z2) {
                return this;
            }
        }
        List<ValueParameterDescriptor> valueParameters2 = getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "valueParameters");
        Iterable<ValueParameterDescriptor> iterable = valueParameters2;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ValueParameterDescriptor valueParameterDescriptor : iterable) {
            Name name2 = valueParameterDescriptor.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "it.name");
            int index = valueParameterDescriptor.getIndex();
            int i = index - size;
            if (i >= 0 && (name = list.get(i)) != null) {
                name2 = name;
            }
            arrayList.add(valueParameterDescriptor.copy(this, name2, index));
        }
        List list2 = (List) arrayList;
        FunctionDescriptorImpl.CopyConfiguration newCopyBuilder = newCopyBuilder(TypeSubstitutor.EMPTY);
        Iterable iterable2 = list;
        if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
            Iterator it2 = iterable2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((Name) it2.next()) == null) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
        }
        z3 = false;
        FunctionDescriptorImpl.CopyConfiguration original = newCopyBuilder.setHasSynthesizedParameterNames(z3).setValueParameters(list2).setOriginal((CallableMemberDescriptor) getOriginal());
        Intrinsics.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        FunctionDescriptor doSubstitute = super.doSubstitute(original);
        Intrinsics.checkNotNull(doSubstitute);
        return doSubstitute;
    }

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final FunctionInvokeDescriptor create(FunctionClassDescriptor functionClassDescriptor, boolean z) {
            Intrinsics.checkNotNullParameter(functionClassDescriptor, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClassDescriptor.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClassDescriptor, (FunctionInvokeDescriptor) null, CallableMemberDescriptor.Kind.DECLARATION, z, (DefaultConstructorMarker) null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClassDescriptor.getThisAsReceiverParameter();
            List emptyList = CollectionsKt.emptyList();
            List emptyList2 = CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object next : declaredTypeParameters) {
                if (!(((TypeParameterDescriptor) next).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(next);
            }
            Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(arrayList);
            Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(withIndex, 10));
            for (IndexedValue indexedValue : withIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, emptyList, emptyList2, (List) arrayList2, (KotlinType) ((TypeParameterDescriptor) CollectionsKt.last(declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String str;
            String asString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(asString, "typeParameter.name.asString()");
            if (Intrinsics.areEqual((Object) asString, (Object) ExifInterface.GPS_DIRECTION_TRUE)) {
                str = "instance";
            } else if (Intrinsics.areEqual((Object) asString, (Object) ExifInterface.LONGITUDE_EAST)) {
                str = "receiver";
            } else {
                str = asString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name identifier = Name.identifier(str);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
            SourceElement sourceElement = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, (ValueParameterDescriptor) null, i, empty, identifier, defaultType, false, false, false, (KotlinType) null, sourceElement);
        }
    }
}
