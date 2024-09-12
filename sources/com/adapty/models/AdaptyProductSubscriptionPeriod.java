package com.adapty.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/adapty/models/AdaptyProductSubscriptionPeriod;", "", "unit", "Lcom/adapty/models/AdaptyPeriodUnit;", "numberOfUnits", "", "(Lcom/adapty/models/AdaptyPeriodUnit;I)V", "getNumberOfUnits", "()I", "getUnit", "()Lcom/adapty/models/AdaptyPeriodUnit;", "equals", "", "other", "hashCode", "toString", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdaptyProductSubscriptionPeriod.kt */
public final class AdaptyProductSubscriptionPeriod {
    private final int numberOfUnits;
    private final AdaptyPeriodUnit unit;

    public AdaptyProductSubscriptionPeriod(AdaptyPeriodUnit adaptyPeriodUnit, int i) {
        Intrinsics.checkNotNullParameter(adaptyPeriodUnit, "unit");
        this.unit = adaptyPeriodUnit;
        this.numberOfUnits = i;
    }

    public final AdaptyPeriodUnit getUnit() {
        return this.unit;
    }

    public final int getNumberOfUnits() {
        return this.numberOfUnits;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.adapty.models.AdaptyProductSubscriptionPeriod");
        AdaptyProductSubscriptionPeriod adaptyProductSubscriptionPeriod = (AdaptyProductSubscriptionPeriod) obj;
        return this.unit == adaptyProductSubscriptionPeriod.unit && this.numberOfUnits == adaptyProductSubscriptionPeriod.numberOfUnits;
    }

    public int hashCode() {
        return (this.unit.hashCode() * 31) + this.numberOfUnits;
    }

    public String toString() {
        return "AdaptyProductSubscriptionPeriod(unit=" + this.unit + ", numberOfUnits=" + this.numberOfUnits + ')';
    }
}
