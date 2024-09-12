package com.adapty.internal.domain;

import com.adapty.internal.data.cloud.Request;
import com.adapty.internal.data.models.ProfileDto;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "value", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProfileInteractor.kt */
final class ProfileInteractor$sendIpWhenReceived$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ ProfileInteractor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileInteractor$sendIpWhenReceived$1(ProfileInteractor profileInteractor) {
        super(1);
        this.this$0 = profileInteractor;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.adapty.internal.domain.ProfileInteractor$sendIpWhenReceived$1$1", f = "ProfileInteractor.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.adapty.internal.domain.ProfileInteractor$sendIpWhenReceived$1$1  reason: invalid class name */
    /* compiled from: ProfileInteractor.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(profileInteractor, str, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                final ProfileInteractor profileInteractor = profileInteractor;
                final String str = str;
                this.label = 1;
                if (FlowKt.collect(FlowKt.m2547catch(Intrinsics.checkNotNullParameter(Intrinsics.checkNotNullParameter(FlowKt.flow(new Function2<FlowCollector<? super Pair<? extends ProfileDto, ? extends Request.CurrentDataWhenSent>>, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 r0 = 

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final String str) {
                            Intrinsics.checkNotNullParameter(str, "value");
                            final ProfileInteractor profileInteractor = this.this$0;
                            Job unused = Intrinsics.checkNotNullParameter(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), "block");
                        }
                    }
