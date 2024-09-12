package com.adapty.internal.data.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/adapty/internal/data/models/FallbackPaywalls;", "", "paywalls", "Ljava/util/ArrayList;", "Lcom/adapty/internal/data/models/PaywallDto;", "Lkotlin/collections/ArrayList;", "version", "", "(Ljava/util/ArrayList;I)V", "getPaywalls", "()Ljava/util/ArrayList;", "getVersion", "()I", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: FallbackPaywalls.kt */
public final class FallbackPaywalls {
    @SerializedName("paywalls")
    private final ArrayList<PaywallDto> paywalls;
    @SerializedName("version")
    private final int version;

    public FallbackPaywalls(ArrayList<PaywallDto> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "paywalls");
        this.paywalls = arrayList;
        this.version = i;
    }

    public final ArrayList<PaywallDto> getPaywalls() {
        return this.paywalls;
    }

    public final int getVersion() {
        return this.version;
    }
}
