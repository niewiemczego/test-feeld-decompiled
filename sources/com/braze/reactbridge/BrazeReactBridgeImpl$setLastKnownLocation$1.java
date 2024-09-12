package com.braze.reactbridge;

import com.braze.BrazeUser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/braze/BrazeUser;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridgeImpl.kt */
final class BrazeReactBridgeImpl$setLastKnownLocation$1 extends Lambda implements Function1<BrazeUser, Unit> {
    final /* synthetic */ double $altitude;
    final /* synthetic */ double $horizontalAccuracy;
    final /* synthetic */ double $latitude;
    final /* synthetic */ double $longitude;
    final /* synthetic */ double $verticalAccuracy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BrazeReactBridgeImpl$setLastKnownLocation$1(double d, double d2, double d3, double d4, double d5) {
        super(1);
        this.$horizontalAccuracy = d;
        this.$verticalAccuracy = d2;
        this.$altitude = d3;
        this.$latitude = d4;
        this.$longitude = d5;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BrazeUser) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BrazeUser brazeUser) {
        Intrinsics.checkNotNullParameter(brazeUser, "it");
        Double valueOf = Double.valueOf(this.$horizontalAccuracy);
        boolean z = true;
        if (valueOf.doubleValue() < 0.0d) {
            valueOf = null;
        }
        Double valueOf2 = Double.valueOf(this.$verticalAccuracy);
        Double d = !((valueOf2.doubleValue() > 0.0d ? 1 : (valueOf2.doubleValue() == 0.0d ? 0 : -1)) < 0) ? valueOf2 : null;
        Double valueOf3 = Double.valueOf(this.$altitude);
        valueOf3.doubleValue();
        if (d != null) {
            z = false;
        }
        brazeUser.setLastKnownLocation(this.$latitude, this.$longitude, !z ? valueOf3 : null, valueOf, d);
    }
}
