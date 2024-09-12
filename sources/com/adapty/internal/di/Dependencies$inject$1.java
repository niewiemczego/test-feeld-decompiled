package com.adapty.internal.di;

import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "T", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: Dependencies.kt */
public final class Dependencies$inject$1 extends Lambda implements Function0<T> {
    final /* synthetic */ String $named;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Dependencies$inject$1(String str) {
        super(0);
        this.$named = str;
    }

    public final T invoke() {
        Dependencies dependencies = Dependencies.INSTANCE;
        String str = this.$named;
        HashMap map$adapty_release = dependencies.getMap$adapty_release();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object obj = map$adapty_release.get(Object.class);
        Intrinsics.checkNotNull(obj);
        Object obj2 = ((Map) obj).get(str);
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.adapty.internal.di.DIObject<T of com.adapty.internal.di.Dependencies.injectInternal>");
        return ((DIObject) obj2).provide();
    }
}
