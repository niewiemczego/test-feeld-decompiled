package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\b\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\t\u0010\r\u001a\u00020\u0006H\u0002R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsConfig;", "", "disabledEventTypes", "", "", "expiresAt", "", "(Ljava/util/List;J)V", "getDisabledEventTypes", "()Ljava/util/List;", "getExpiresAt", "()J", "component1", "component2", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsConfig.kt */
public final class AnalyticsConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final AnalyticsConfig DEFAULT = new AnalyticsConfig(CollectionsKt.emptyList(), 0);
    @SerializedName("blacklist")
    private final List<String> disabledEventTypes;
    @SerializedName("expires_at")
    private final long expiresAt;

    public AnalyticsConfig(List<String> list, long j) {
        Intrinsics.checkNotNullParameter(list, "disabledEventTypes");
        this.disabledEventTypes = list;
        this.expiresAt = j;
    }

    public final List<String> getDisabledEventTypes() {
        return this.disabledEventTypes;
    }

    public final long getExpiresAt() {
        return this.expiresAt;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/data/models/AnalyticsConfig$Companion;", "", "()V", "DEFAULT", "Lcom/adapty/internal/data/models/AnalyticsConfig;", "getDEFAULT", "()Lcom/adapty/internal/data/models/AnalyticsConfig;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AnalyticsConfig getDEFAULT() {
            return AnalyticsConfig.DEFAULT;
        }
    }

    public final List<String> component1() {
        return this.disabledEventTypes;
    }

    public final long component2() {
        return this.expiresAt;
    }
}
