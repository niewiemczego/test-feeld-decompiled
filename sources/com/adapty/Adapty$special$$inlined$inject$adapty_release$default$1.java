package com.adapty;

import com.adapty.internal.AdaptyInternal;
import com.adapty.internal.di.DIObject;
import com.adapty.internal.di.Dependencies;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;", "com/adapty/internal/di/Dependencies$inject$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: Dependencies.kt */
public final class Adapty$special$$inlined$inject$adapty_release$default$1 extends Lambda implements Function0<AdaptyInternal> {
    final /* synthetic */ String $named;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Adapty$special$$inlined$inject$adapty_release$default$1(String str) {
        super(0);
        this.$named = str;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.Object, com.adapty.internal.AdaptyInternal] */
    public final AdaptyInternal invoke() {
        Dependencies dependencies = Dependencies.INSTANCE;
        String str = this.$named;
        Object obj = dependencies.getMap$adapty_release().get(AdaptyInternal.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get(str);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return ((DIObject) obj2).provide();
    }
}
