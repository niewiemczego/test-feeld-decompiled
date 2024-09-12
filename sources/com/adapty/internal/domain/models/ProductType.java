package com.adapty.internal.domain.models;

import com.adapty.internal.domain.models.BackendProduct;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/adapty/internal/domain/models/ProductType;", "", "()V", "Consumable", "NonConsumable", "Subscription", "Lcom/adapty/internal/domain/models/ProductType$Consumable;", "Lcom/adapty/internal/domain/models/ProductType$NonConsumable;", "Lcom/adapty/internal/domain/models/ProductType$Subscription;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BackendProduct.kt */
public abstract class ProductType {
    public /* synthetic */ ProductType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ProductType() {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/domain/models/ProductType$Consumable;", "Lcom/adapty/internal/domain/models/ProductType;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BackendProduct.kt */
    public static final class Consumable extends ProductType {
        public static final Consumable INSTANCE = new Consumable();
        private static final String NAME = "cons";

        private Consumable() {
            super((DefaultConstructorMarker) null);
        }

        public final String getNAME() {
            return NAME;
        }

        public String toString() {
            return NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/domain/models/ProductType$NonConsumable;", "Lcom/adapty/internal/domain/models/ProductType;", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "toString", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BackendProduct.kt */
    public static final class NonConsumable extends ProductType {
        public static final NonConsumable INSTANCE = new NonConsumable();
        private static final String NAME = "noncons";

        private NonConsumable() {
            super((DefaultConstructorMarker) null);
        }

        public final String getNAME() {
            return NAME;
        }

        public String toString() {
            return NAME;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/adapty/internal/domain/models/ProductType$Subscription;", "Lcom/adapty/internal/domain/models/ProductType;", "subscriptionData", "Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "(Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;)V", "getSubscriptionData", "()Lcom/adapty/internal/domain/models/BackendProduct$SubscriptionData;", "toString", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: BackendProduct.kt */
    public static final class Subscription extends ProductType {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final String NAME = "subs";
        private final BackendProduct.SubscriptionData subscriptionData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Subscription(BackendProduct.SubscriptionData subscriptionData2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(subscriptionData2, "subscriptionData");
            this.subscriptionData = subscriptionData2;
        }

        public final BackendProduct.SubscriptionData getSubscriptionData() {
            return this.subscriptionData;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/domain/models/ProductType$Subscription$Companion;", "", "()V", "NAME", "", "getNAME", "()Ljava/lang/String;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* compiled from: BackendProduct.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final String getNAME() {
                return Subscription.NAME;
            }
        }

        public String toString() {
            return NAME;
        }
    }
}
