package com.adapty.internal.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\fB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bR\u0012\u0010\b\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/internal/di/DIObject;", "T", "", "initializer", "Lkotlin/Function0;", "initType", "Lcom/adapty/internal/di/DIObject$InitType;", "(Lkotlin/jvm/functions/Function0;Lcom/adapty/internal/di/DIObject$InitType;)V", "cachedObject", "Ljava/lang/Object;", "provide", "()Ljava/lang/Object;", "InitType", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DIObject.kt */
public final class DIObject<T> {
    private T cachedObject;
    private final InitType initType;
    private final Function0<T> initializer;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/di/DIObject$InitType;", "", "(Ljava/lang/String;I)V", "NEW", "SINGLETON", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DIObject.kt */
    public enum InitType {
        NEW,
        SINGLETON
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: DIObject.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitType.values().length];
            try {
                iArr[InitType.NEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DIObject(Function0<? extends T> function0, InitType initType2) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        Intrinsics.checkNotNullParameter(initType2, "initType");
        this.initializer = function0;
        this.initType = initType2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DIObject(Function0 function0, InitType initType2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? InitType.SINGLETON : initType2);
    }

    public final /* synthetic */ Object provide() {
        if (WhenMappings.$EnumSwitchMapping$0[this.initType.ordinal()] == 1) {
            return this.initializer.invoke();
        }
        T t = this.cachedObject;
        if (t != null) {
            return t;
        }
        T invoke = this.initializer.invoke();
        this.cachedObject = invoke;
        return invoke;
    }
}
