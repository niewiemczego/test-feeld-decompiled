package com.adapty.internal.data.cache;

import com.adapty.internal.data.models.InstallationMeta;
import com.adapty.internal.data.models.ProfileDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cache.CacheRepository", f = "CacheRepository.kt", i = {0, 0, 0, 0}, l = {45}, m = "updateDataOnCreateProfile", n = {"this", "profile", "installationMeta", "profileIdHasChanged"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: CacheRepository.kt */
final class CacheRepository$updateDataOnCreateProfile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CacheRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CacheRepository$updateDataOnCreateProfile$1(CacheRepository cacheRepository, Continuation<? super CacheRepository$updateDataOnCreateProfile$1> continuation) {
        super(continuation);
        this.this$0 = cacheRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateDataOnCreateProfile((ProfileDto) null, (InstallationMeta) null, this);
    }
}
