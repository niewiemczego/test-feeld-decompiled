package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "matchResult", "Lkotlin/text/MatchResult;", "invoke", "(Lkotlin/text/MatchResult;)Ljava/lang/Integer;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProductMapper.kt */
final class ProductMapper$getPeriodNumberOfUnits$1 extends Lambda implements Function1<MatchResult, Integer> {
    final /* synthetic */ ProductMapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductMapper$getPeriodNumberOfUnits$1(ProductMapper productMapper) {
        super(1);
        this.this$0 = productMapper;
    }

    public final Integer invoke(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        CharSequence charSequence = (String) CollectionsKt.first(matchResult.getGroupValues());
        Appendable sb = new StringBuilder();
        int length = charSequence.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = charSequence.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = ((StringBuilder) sb).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int parseInt = Integer.parseInt(sb2);
        Appendable sb3 = new StringBuilder();
        int length2 = charSequence.length();
        for (int i3 = 0; i3 < length2; i3++) {
            char charAt2 = charSequence.charAt(i3);
            if (Character.isLetter(charAt2)) {
                sb3.append(charAt2);
            }
        }
        String sb4 = ((StringBuilder) sb3).toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "filterTo(StringBuilder(), predicate).toString()");
        Integer num = (Integer) this.this$0.discountPeriodMultipliers.get(sb4);
        if (num != null) {
            i = parseInt * num.intValue();
        }
        return Integer.valueOf(i);
    }
}
