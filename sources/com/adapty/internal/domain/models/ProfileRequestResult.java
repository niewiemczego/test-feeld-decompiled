package com.adapty.internal.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/domain/models/ProfileRequestResult;", "", "()V", "ProfileIdChanged", "ProfileIdSame", "ProfileNotCreated", "Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileIdChanged;", "Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileIdSame;", "Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileNotCreated;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProfileRequestResult.kt */
public abstract class ProfileRequestResult {
    public /* synthetic */ ProfileRequestResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProfileRequestResult() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileIdSame;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileRequestResult.kt */
    public static final class ProfileIdSame extends ProfileRequestResult {
        public static final ProfileIdSame INSTANCE = new ProfileIdSame();

        private ProfileIdSame() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileIdChanged;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "()V", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileRequestResult.kt */
    public static final class ProfileIdChanged extends ProfileRequestResult {
        public static final ProfileIdChanged INSTANCE = new ProfileIdChanged();

        private ProfileIdChanged() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/domain/models/ProfileRequestResult$ProfileNotCreated;", "Lcom/adapty/internal/domain/models/ProfileRequestResult;", "error", "", "(Ljava/lang/Throwable;)V", "getError", "()Ljava/lang/Throwable;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ProfileRequestResult.kt */
    public static final class ProfileNotCreated extends ProfileRequestResult {
        private final Throwable error;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ProfileNotCreated(Throwable th) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(th, "error");
            this.error = th;
        }

        public final Throwable getError() {
            return this.error;
        }
    }
}
