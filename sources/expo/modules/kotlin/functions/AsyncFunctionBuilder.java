package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J9\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u00012\u001e\b\u0004\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0013H\bø\u0001\u0000¢\u0006\u0002\u0010\u0015JV\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u000123\b\u0004\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H\bø\u0001\u0000¢\u0006\u0002\u0010\u001aJs\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u00012H\b\u0004\u0010\u0012\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001cH\bø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0001\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u00012]\b\u0004\u0010\u0012\u001aW\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010 H\bø\u0001\u0000¢\u0006\u0002\u0010\"J­\u0001\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010#\u0018\u00012r\b\u0004\u0010\u0012\u001al\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010$H\bø\u0001\u0000¢\u0006\u0002\u0010&JÌ\u0001\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010#\u0018\u0001\"\u0006\b\u0005\u0010'\u0018\u00012\u0001\b\u0004\u0010\u0012\u001a\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H'¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b()\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010(H\bø\u0001\u0000¢\u0006\u0002\u0010*Jé\u0001\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010#\u0018\u0001\"\u0006\b\u0005\u0010'\u0018\u0001\"\u0006\b\u0006\u0010+\u0018\u00012\u0001\b\u0004\u0010\u0012\u001a\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H'¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(-\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010,H\bø\u0001\u0000¢\u0006\u0002\u0010.J\u0002\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010#\u0018\u0001\"\u0006\b\u0005\u0010'\u0018\u0001\"\u0006\b\u0006\u0010+\u0018\u0001\"\u0006\b\u0007\u0010/\u0018\u00012²\u0001\b\u0004\u0010\u0012\u001a«\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H'¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(1\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000100H\bø\u0001\u0000¢\u0006\u0002\u00102J£\u0002\u0010\u0010\u001a\u00020\n\"\u0006\b\u0000\u0010\u0011\u0018\u0001\"\u0006\b\u0001\u0010\u0016\u0018\u0001\"\u0006\b\u0002\u0010\u001b\u0018\u0001\"\u0006\b\u0003\u0010\u001f\u0018\u0001\"\u0006\b\u0004\u0010#\u0018\u0001\"\u0006\b\u0005\u0010'\u0018\u0001\"\u0006\b\u0006\u0010+\u0018\u0001\"\u0006\b\u0007\u0010/\u0018\u0001\"\u0006\b\b\u00103\u0018\u00012Ç\u0001\b\u0004\u0010\u0012\u001aÀ\u0001\b\u0001\u0012\u0013\u0012\u0011H\u0016¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u0011H\u001b¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(!\u0012\u0013\u0012\u0011H#¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(%\u0012\u0013\u0012\u0011H'¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b()\u0012\u0013\u0012\u0011H+¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H/¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(1\u0012\u0013\u0012\u0011H3¢\u0006\f\b\u0018\u0012\b\b\u0002\u0012\u0004\b\b(5\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000104H\bø\u0001\u0000¢\u0006\u0002\u00106J\r\u00107\u001a\u00020\nH\u0000¢\u0006\u0002\b8R\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "", "name", "", "(Ljava/lang/String;)V", "getName$annotations", "()V", "getName", "()Ljava/lang/String;", "suspendFunctionComponent", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "getSuspendFunctionComponent$annotations", "getSuspendFunctionComponent", "()Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "setSuspendFunctionComponent", "(Lexpo/modules/kotlin/functions/SuspendFunctionComponent;)V", "SuspendBody", "R", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P0", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "p0", "(Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P1", "Lkotlin/Function3;", "p1", "(Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P2", "Lkotlin/Function4;", "p2", "(Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P3", "Lkotlin/Function5;", "p3", "(Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P4", "Lkotlin/Function6;", "p4", "(Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P5", "Lkotlin/Function7;", "p5", "(Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P6", "Lkotlin/Function8;", "p6", "(Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P7", "Lkotlin/Function9;", "p7", "(Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "build", "build$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilder {
    private final String name;
    private SuspendFunctionComponent suspendFunctionComponent;

    public static /* synthetic */ void getName$annotations() {
    }

    public static /* synthetic */ void getSuspendFunctionComponent$annotations() {
    }

    public AsyncFunctionBuilder(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }

    public final SuspendFunctionComponent getSuspendFunctionComponent() {
        return this.suspendFunctionComponent;
    }

    public final void setSuspendFunctionComponent(SuspendFunctionComponent suspendFunctionComponent2) {
        this.suspendFunctionComponent = suspendFunctionComponent2;
    }

    public final /* synthetic */ <R> SuspendFunctionComponent SuspendBody(Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(getName(), new AnyType[0], new AsyncFunctionBuilder$SuspendBody$1(function1, (Continuation<? super AsyncFunctionBuilder$SuspendBody$1>) null));
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0> SuspendFunctionComponent SuspendBody(Function2<? super P0, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$3(function2, (Continuation<? super AsyncFunctionBuilder$SuspendBody$3>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1> SuspendFunctionComponent SuspendBody(Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$5(function3, (Continuation<? super AsyncFunctionBuilder$SuspendBody$5>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent SuspendBody(Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$7(function4, (Continuation<? super AsyncFunctionBuilder$SuspendBody$7>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent SuspendBody(Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$9(function5, (Continuation<? super AsyncFunctionBuilder$SuspendBody$9>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent SuspendBody(Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6) {
        Intrinsics.checkNotNullParameter(function6, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$11(function6, (Continuation<? super AsyncFunctionBuilder$SuspendBody$11>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent SuspendBody(Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function7) {
        Intrinsics.checkNotNullParameter(function7, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$13(function7, (Continuation<? super AsyncFunctionBuilder$SuspendBody$13>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SuspendFunctionComponent SuspendBody(Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function8) {
        Intrinsics.checkNotNullParameter(function8, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        Intrinsics.reifiedOperationMarker(6, "P6");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$15(function8, (Continuation<? super AsyncFunctionBuilder$SuspendBody$15>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent SuspendBody(Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function9) {
        Intrinsics.checkNotNullParameter(function9, "block");
        String name2 = getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        Intrinsics.reifiedOperationMarker(6, "P6");
        Intrinsics.reifiedOperationMarker(6, "P7");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent2 = new SuspendFunctionComponent(name2, anyTypeArr, new AsyncFunctionBuilder$SuspendBody$17(function9, (Continuation<? super AsyncFunctionBuilder$SuspendBody$17>) null));
        SuspendFunctionComponent suspendFunctionComponent3 = suspendFunctionComponent2;
        setSuspendFunctionComponent(suspendFunctionComponent2);
        return suspendFunctionComponent2;
    }

    public final SuspendFunctionComponent build$expo_modules_core_release() {
        SuspendFunctionComponent suspendFunctionComponent2 = this.suspendFunctionComponent;
        if (suspendFunctionComponent2 != null) {
            return suspendFunctionComponent2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
