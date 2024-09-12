package com.adapty.internal.utils;

import com.adapty.models.AdaptySubscriptionUpdateParameters;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/adapty/internal/utils/ReplacementModeMapper;", "", "()V", "map", "", "replacementMode", "Lcom/adapty/models/AdaptySubscriptionUpdateParameters$ReplacementMode;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ReplacementModeMapper.kt */
public final class ReplacementModeMapper {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ReplacementModeMapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode[] r0 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.WITH_TIME_PRORATION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.WITHOUT_PRORATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.CHARGE_PRORATED_PRICE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.DEFERRED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.adapty.models.AdaptySubscriptionUpdateParameters$ReplacementMode r1 = com.adapty.models.AdaptySubscriptionUpdateParameters.ReplacementMode.CHARGE_FULL_PRICE     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.ReplacementModeMapper.WhenMappings.<clinit>():void");
        }
    }

    public final /* synthetic */ int map(AdaptySubscriptionUpdateParameters.ReplacementMode replacementMode) {
        Intrinsics.checkNotNullParameter(replacementMode, "replacementMode");
        int i = WhenMappings.$EnumSwitchMapping$0[replacementMode.ordinal()];
        if (i == 1) {
            return 1;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4) {
            return 6;
        }
        if (i == 5) {
            return 5;
        }
        throw new NoWhenBranchMatchedException();
    }
}
