package com.adapty.internal.data.cache;

import com.adapty.internal.data.models.ProfileDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cache.CacheRepository", f = "CacheRepository.kt", i = {0, 0}, l = {69}, m = "saveProfile", n = {"this", "profile"}, s = {"L$0", "L$1"})
/* compiled from: CacheRepository.kt */
final class CacheRepository$saveProfile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CacheRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheRepository$saveProfile$1(CacheRepository cacheRepository, Continuation<? super CacheRepository$saveProfile$1> continuation) {
        super(continuation);
        this.this$0 = cacheRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.saveProfile((ProfileDto) null, this);
    }
}
