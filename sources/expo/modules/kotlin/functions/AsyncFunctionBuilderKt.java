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

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u001e\b\u0004\u0010\u0004\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\fø\u0001\u0000¢\u0006\u0002\u0010\b\u001aK\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001*\u00020\u00032$\b\u0004\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nH\fø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001aY\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001*\u00020\u00032*\b\u0004\u0010\u0004\u001a$\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\rH\fø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001ag\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001*\u00020\u000320\b\u0004\u0010\u0004\u001a*\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0010H\fø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001au\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001*\u00020\u000326\b\u0004\u0010\u0004\u001a0\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0013H\fø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001*\u00020\u00032<\b\u0004\u0010\u0004\u001a6\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0016H\fø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001*\u00020\u00032B\b\u0004\u0010\u0004\u001a<\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\fø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a\u0001\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001b\u0018\u0001*\u00020\u00032H\b\u0004\u0010\u0004\u001aB\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001cH\fø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a­\u0001\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\t\u0018\u0001\"\u0006\b\u0002\u0010\f\u0018\u0001\"\u0006\b\u0003\u0010\u000f\u0018\u0001\"\u0006\b\u0004\u0010\u0012\u0018\u0001\"\u0006\b\u0005\u0010\u0015\u0018\u0001\"\u0006\b\u0006\u0010\u0018\u0018\u0001\"\u0006\b\u0007\u0010\u001b\u0018\u0001\"\u0006\b\b\u0010\u001e\u0018\u0001*\u00020\u00032N\b\u0004\u0010\u0004\u001aH\b\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u000f\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001fH\fø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Coroutine", "Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "R", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P0", "Lkotlin/Function2;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function2;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P1", "Lkotlin/Function3;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function3;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P2", "Lkotlin/Function4;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function4;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P3", "Lkotlin/Function5;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function5;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P4", "Lkotlin/Function6;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function6;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P5", "Lkotlin/Function7;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function7;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P6", "Lkotlin/Function8;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function8;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "P7", "Lkotlin/Function9;", "(Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;Lkotlin/jvm/functions/Function9;)Lexpo/modules/kotlin/functions/SuspendFunctionComponent;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: AsyncFunctionBuilder.kt */
public final class AsyncFunctionBuilderKt {
    public static final /* synthetic */ <R> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(asyncFunctionBuilder.getName(), new AnyType[0], new AsyncFunctionBuilder$SuspendBody$1(function1, (Continuation<? super AsyncFunctionBuilder$SuspendBody$1>) null));
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function2<? super P0, ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function2, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$1(function2, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function3<? super P0, ? super P1, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function3, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$2(function3, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function4<? super P0, ? super P1, ? super P2, ? super Continuation<? super R>, ? extends Object> function4) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function4, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$3(function4, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2, P3> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Continuation<? super R>, ? extends Object> function5) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function5, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$4(function5, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2, P3, P4> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Continuation<? super R>, ? extends Object> function6) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function6, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$5(function6, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Continuation<? super R>, ? extends Object> function7) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function7, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$6(function7, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Continuation<? super R>, ? extends Object> function8) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function8, "block");
        String name = asyncFunctionBuilder.getName();
        Intrinsics.reifiedOperationMarker(6, "P0");
        Intrinsics.reifiedOperationMarker(6, "P1");
        Intrinsics.reifiedOperationMarker(6, "P2");
        Intrinsics.reifiedOperationMarker(6, "P3");
        Intrinsics.reifiedOperationMarker(6, "P4");
        Intrinsics.reifiedOperationMarker(6, "P5");
        Intrinsics.reifiedOperationMarker(6, "P6");
        AnyType[] anyTypeArr = {AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null), AnyTypeKt.toAnyType((KType) null)};
        Intrinsics.needClassReification();
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$7(function8, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }

    public static final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SuspendFunctionComponent Coroutine(AsyncFunctionBuilder asyncFunctionBuilder, Function9<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? super Continuation<? super R>, ? extends Object> function9) {
        Intrinsics.checkNotNullParameter(asyncFunctionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(function9, "block");
        String name = asyncFunctionBuilder.getName();
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
        SuspendFunctionComponent suspendFunctionComponent = new SuspendFunctionComponent(name, anyTypeArr, new AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$8(function9, (Continuation) null));
        SuspendFunctionComponent suspendFunctionComponent2 = suspendFunctionComponent;
        asyncFunctionBuilder.setSuspendFunctionComponent(suspendFunctionComponent);
        return suspendFunctionComponent;
    }
}
