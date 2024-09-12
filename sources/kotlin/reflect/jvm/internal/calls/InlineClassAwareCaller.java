package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0001 \u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001cB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0002\u0010\u001bR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InlineClassAwareCaller.kt */
public final class InlineClassAwareCaller<M extends Member> implements Caller<M> {
    private final Caller<M> caller;
    private final BoxUnboxData data;
    private final boolean isDefault;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        if ((r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller) != false) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InlineClassAwareCaller(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, kotlin.reflect.jvm.internal.calls.Caller<? extends M> r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "caller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r10.<init>()
            r10.caller = r12
            r10.isDefault = r13
            r12 = r10
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller r12 = (kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller) r12
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = r11.getReturnType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            java.lang.Class r12 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r12)
            r13 = 0
            if (r12 == 0) goto L_0x0027
            java.lang.reflect.Method r12 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getBoxMethod(r12, r11)
            goto L_0x0028
        L_0x0027:
            r12 = r13
        L_0x0028:
            r0 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0045
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            kotlin.ranges.IntRange$Companion r13 = kotlin.ranges.IntRange.Companion
            kotlin.ranges.IntRange r13 = r13.getEMPTY()
            java.lang.reflect.Method[] r0 = new java.lang.reflect.Method[r1]
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.reflect.Method[] r0 = (java.lang.reflect.Method[]) r0
            r11.<init>(r13, r0, r12)
            goto L_0x0163
        L_0x0045:
            kotlin.reflect.jvm.internal.calls.Caller<M> r0 = r10.caller
            boolean r2 = r0 instanceof kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
            java.lang.String r3 = "descriptor.containingDeclaration"
            r4 = -1
            r5 = 1
            if (r2 == 0) goto L_0x0050
            goto L_0x0076
        L_0x0050:
            boolean r2 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r2 == 0) goto L_0x0059
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 == 0) goto L_0x0075
            goto L_0x0076
        L_0x0059:
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r0 = r11.getDispatchReceiverParameter()
            if (r0 == 0) goto L_0x0075
            kotlin.reflect.jvm.internal.calls.Caller<M> r0 = r10.caller
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.calls.BoundCaller
            if (r0 != 0) goto L_0x0075
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r11.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            boolean r0 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r0)
            if (r0 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r4 = r5
            goto L_0x0076
        L_0x0075:
            r4 = r1
        L_0x0076:
            boolean r0 = r10.isDefault
            if (r0 == 0) goto L_0x007c
            r0 = 2
            goto L_0x007d
        L_0x007c:
            r0 = r1
        L_0x007d:
            boolean r2 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r2 == 0) goto L_0x008c
            r2 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            boolean r2 = r2.isSuspend()
            if (r2 == 0) goto L_0x008c
            r2 = r5
            goto L_0x008d
        L_0x008c:
            r2 = r1
        L_0x008d:
            int r0 = r0 + r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor r6 = r11.getExtensionReceiverParameter()
            if (r6 == 0) goto L_0x009e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            goto L_0x009f
        L_0x009e:
            r6 = r13
        L_0x009f:
            if (r6 == 0) goto L_0x00a5
            r2.add(r6)
            goto L_0x00e8
        L_0x00a5:
            boolean r6 = r11 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor
            if (r6 == 0) goto L_0x00ce
            r3 = r11
            kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = r3.getConstructedClass()
            java.lang.String r6 = "descriptor.constructedClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            boolean r6 = r3.isInner()
            if (r6 == 0) goto L_0x00e8
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r3 = r3.getContainingDeclaration()
            java.lang.String r6 = "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r6)
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getDefaultType()
            r2.add(r3)
            goto L_0x00e8
        L_0x00ce:
            kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r6 = r11.getContainingDeclaration()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r3)
            boolean r3 = r6 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r3 == 0) goto L_0x00e8
            boolean r3 = kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt.isInlineClass(r6)
            if (r3 == 0) goto L_0x00e8
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r6.getDefaultType()
            r2.add(r3)
        L_0x00e8:
            java.util.List r3 = r11.getValueParameters()
            java.lang.String r6 = "descriptor.valueParameters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00f7:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x010e
            java.lang.Object r6 = r3.next()
            r7 = r2
            java.util.Collection r7 = (java.util.Collection) r7
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r6
            kotlin.reflect.jvm.internal.impl.types.KotlinType r6 = r6.getType()
            r7.add(r6)
            goto L_0x00f7
        L_0x010e:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.List r2 = (java.util.List) r2
            int r3 = r2.size()
            int r3 = r3 + r4
            int r3 = r3 + r0
            r0 = r10
            kotlin.reflect.jvm.internal.calls.Caller r0 = (kotlin.reflect.jvm.internal.calls.Caller) r0
            int r6 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r0)
            if (r6 != r3) goto L_0x0166
            int r0 = java.lang.Math.max(r4, r1)
            int r6 = r2.size()
            int r6 = r6 + r4
            kotlin.ranges.IntRange r0 = kotlin.ranges.RangesKt.until((int) r0, (int) r6)
            java.lang.reflect.Method[] r6 = new java.lang.reflect.Method[r3]
            r7 = r1
        L_0x0132:
            if (r7 >= r3) goto L_0x015e
            int r8 = r0.getFirst()
            int r9 = r0.getLast()
            if (r7 > r9) goto L_0x0142
            if (r8 > r7) goto L_0x0142
            r8 = r5
            goto L_0x0143
        L_0x0142:
            r8 = r1
        L_0x0143:
            if (r8 == 0) goto L_0x0158
            int r8 = r7 - r4
            java.lang.Object r8 = r2.get(r8)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r8 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r8
            java.lang.Class r8 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.toInlineClass((kotlin.reflect.jvm.internal.impl.types.KotlinType) r8)
            if (r8 == 0) goto L_0x0158
            java.lang.reflect.Method r8 = kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt.getUnboxMethod(r8, r11)
            goto L_0x0159
        L_0x0158:
            r8 = r13
        L_0x0159:
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0132
        L_0x015e:
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r11 = new kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData
            r11.<init>(r0, r6, r12)
        L_0x0163:
            r10.data = r11
            return
        L_0x0166:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r12 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r1 = "Inconsistent number of parameters in the descriptor and Java reflection object: "
            java.lang.StringBuilder r13 = r13.append(r1)
            int r0 = kotlin.reflect.jvm.internal.calls.CallerKt.getArity(r0)
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.String r0 = " != "
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.StringBuilder r13 = r13.append(r3)
            java.lang.String r0 = "\nCalling: "
            java.lang.StringBuilder r13 = r13.append(r0)
            java.lang.StringBuilder r11 = r13.append(r11)
            java.lang.String r13 = "\nParameter types: "
            java.lang.StringBuilder r11 = r11.append(r13)
            java.util.List r13 = r10.getParameterTypes()
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r13 = ")\nDefault: "
            java.lang.StringBuilder r11 = r11.append(r13)
            boolean r13 = r10.isDefault
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.Caller, boolean):void");
    }

    public M getMember() {
        return this.caller.getMember();
    }

    public Type getReturnType() {
        return this.caller.getReturnType();
    }

    public List<Type> getParameterTypes() {
        return this.caller.getParameterTypes();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003H\u0002J\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H\u0002¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "", "argumentRange", "Lkotlin/ranges/IntRange;", "unbox", "", "Ljava/lang/reflect/Method;", "box", "(Lkotlin/ranges/IntRange;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "getArgumentRange", "()Lkotlin/ranges/IntRange;", "getBox", "()Ljava/lang/reflect/Method;", "getUnbox", "()[Ljava/lang/reflect/Method;", "[Ljava/lang/reflect/Method;", "component1", "component2", "component3", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: InlineClassAwareCaller.kt */
    private static final class BoxUnboxData {
        private final IntRange argumentRange;
        private final Method box;
        private final Method[] unbox;

        public BoxUnboxData(IntRange intRange, Method[] methodArr, Method method) {
            Intrinsics.checkNotNullParameter(intRange, "argumentRange");
            Intrinsics.checkNotNullParameter(methodArr, "unbox");
            this.argumentRange = intRange;
            this.unbox = methodArr;
            this.box = method;
        }

        public final IntRange component1() {
            return this.argumentRange;
        }

        public final Method[] component2() {
            return this.unbox;
        }

        public final Method component3() {
            return this.box;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        r0 = r0.invoke((java.lang.Object) null, new java.lang.Object[]{r10});
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object call(java.lang.Object[] r10) {
        /*
            r9 = this;
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller$BoxUnboxData r0 = r9.data
            kotlin.ranges.IntRange r1 = r0.component1()
            java.lang.reflect.Method[] r2 = r0.component2()
            java.lang.reflect.Method r0 = r0.component3()
            int r3 = r10.length
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r4 = "copyOf(this, size)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r4)
            int r4 = r1.getFirst()
            int r1 = r1.getLast()
            r5 = 0
            if (r4 > r1) goto L_0x0052
        L_0x002d:
            r6 = r2[r4]
            r7 = r10[r4]
            if (r6 == 0) goto L_0x004b
            if (r7 == 0) goto L_0x003c
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r7 = r6.invoke(r7, r8)
            goto L_0x004b
        L_0x003c:
            java.lang.Class r6 = r6.getReturnType()
            java.lang.String r7 = "method.returnType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            java.lang.reflect.Type r6 = (java.lang.reflect.Type) r6
            java.lang.Object r7 = kotlin.reflect.jvm.internal.UtilKt.defaultPrimitiveValue(r6)
        L_0x004b:
            r3[r4] = r7
            if (r4 == r1) goto L_0x0052
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0052:
            kotlin.reflect.jvm.internal.calls.Caller<M> r10 = r9.caller
            java.lang.Object r10 = r10.call(r3)
            if (r0 == 0) goto L_0x0068
            r1 = 0
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r5] = r10
            java.lang.Object r0 = r0.invoke(r1, r2)
            if (r0 != 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r10 = r0
        L_0x0068:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller.call(java.lang.Object[]):java.lang.Object");
    }
}
