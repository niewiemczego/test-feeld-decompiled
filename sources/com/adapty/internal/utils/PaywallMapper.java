package com.adapty.internal.utils;

import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/utils/PaywallMapper;", "", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "type", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "getType", "()Ljava/lang/reflect/Type;", "type$delegate", "Lkotlin/Lazy;", "map", "Lcom/adapty/models/AdaptyPaywall;", "paywallDto", "Lcom/adapty/internal/data/models/PaywallDto;", "products", "", "Lcom/adapty/internal/domain/models/BackendProduct;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PaywallMapper.kt */
public final class PaywallMapper {
    private final Gson gson;
    private final Lazy type$delegate = LazyKt.lazy(PaywallMapper$type$2.INSTANCE);

    public PaywallMapper(Gson gson2) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
    }

    private final Type getType() {
        return (Type) this.type$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ad  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.models.AdaptyPaywall map(com.adapty.internal.data.models.PaywallDto r25, java.util.List r26) {
        /*
            r24 = this;
            java.lang.String r0 = "paywallDto"
            r1 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "products"
            r11 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r2 = r25.getDeveloperId()
            if (r2 == 0) goto L_0x00cf
            java.lang.String r0 = r25.getName()
            java.lang.String r3 = ""
            if (r0 != 0) goto L_0x001d
            r0 = r3
        L_0x001d:
            java.lang.String r4 = r25.getAbTestName()
            if (r4 != 0) goto L_0x0024
            r4 = r3
        L_0x0024:
            java.lang.Integer r3 = r25.getRevision()
            r5 = 0
            if (r3 == 0) goto L_0x0031
            int r3 = r3.intValue()
            r6 = r3
            goto L_0x0032
        L_0x0031:
            r6 = r5
        L_0x0032:
            java.lang.String r7 = r25.getVariationId()
            if (r7 == 0) goto L_0x00bf
            com.adapty.internal.data.models.RemoteConfigDto r3 = r25.getRemoteConfig()
            if (r3 == 0) goto L_0x0044
            java.lang.String r3 = r3.getLang()
            if (r3 != 0) goto L_0x0046
        L_0x0044:
            java.lang.String r3 = "en"
        L_0x0046:
            r8 = r3
            com.adapty.internal.data.models.RemoteConfigDto r3 = r25.getRemoteConfig()
            r9 = 0
            if (r3 == 0) goto L_0x0054
            java.lang.String r3 = r3.getData()
            r10 = r3
            goto L_0x0055
        L_0x0054:
            r10 = r9
        L_0x0055:
            com.adapty.internal.data.models.RemoteConfigDto r3 = r25.getRemoteConfig()     // Catch:{ Exception -> 0x0070 }
            if (r3 == 0) goto L_0x0070
            java.lang.String r3 = r3.getData()     // Catch:{ Exception -> 0x0070 }
            if (r3 == 0) goto L_0x0070
            r15 = r24
            com.google.gson.Gson r12 = r15.gson     // Catch:{ Exception -> 0x0072 }
            java.lang.reflect.Type r13 = r24.getType()     // Catch:{ Exception -> 0x0072 }
            java.lang.Object r3 = r12.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r13)     // Catch:{ Exception -> 0x0072 }
            java.util.Map r3 = (java.util.Map) r3     // Catch:{ Exception -> 0x0072 }
            goto L_0x0073
        L_0x0070:
            r15 = r24
        L_0x0072:
            r3 = r9
        L_0x0073:
            if (r3 == 0) goto L_0x007a
            com.adapty.utils.ImmutableMap r3 = kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, "<this>")
            r9 = r3
        L_0x007a:
            java.lang.String r12 = r25.getPaywallId()
            if (r12 == 0) goto L_0x00ad
            java.lang.Long r3 = r25.getUpdatedAt()
            if (r3 == 0) goto L_0x008b
            long r13 = r3.longValue()
            goto L_0x008d
        L_0x008b:
            r13 = 0
        L_0x008d:
            java.lang.Boolean r1 = r25.getHasViewConfiguration()
            if (r1 == 0) goto L_0x009a
            boolean r1 = r1.booleanValue()
            r16 = r1
            goto L_0x009c
        L_0x009a:
            r16 = r5
        L_0x009c:
            com.adapty.models.AdaptyPaywall r17 = new com.adapty.models.AdaptyPaywall
            r1 = r17
            r3 = r0
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r10 = r16
            r11 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return r17
        L_0x00ad:
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r19 = 0
            com.adapty.errors.AdaptyErrorCode r21 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r22 = 1
            r23 = 0
            java.lang.String r20 = "paywallId in Paywall should not be null"
            r18 = r0
            r18.<init>(r19, r20, r21, r22, r23)
            throw r0
        L_0x00bf:
            r15 = r24
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r2 = 0
            com.adapty.errors.AdaptyErrorCode r4 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r5 = 1
            r6 = 0
            java.lang.String r3 = "variationId in Paywall should not be null"
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            throw r0
        L_0x00cf:
            r15 = r24
            com.adapty.errors.AdaptyError r0 = new com.adapty.errors.AdaptyError
            r8 = 0
            com.adapty.errors.AdaptyErrorCode r10 = com.adapty.errors.AdaptyErrorCode.DECODING_FAILED
            r11 = 1
            r12 = 0
            java.lang.String r9 = "placementId in Paywall should not be null"
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.PaywallMapper.map(com.adapty.internal.data.models.PaywallDto, java.util.List):com.adapty.models.AdaptyPaywall");
    }
}
