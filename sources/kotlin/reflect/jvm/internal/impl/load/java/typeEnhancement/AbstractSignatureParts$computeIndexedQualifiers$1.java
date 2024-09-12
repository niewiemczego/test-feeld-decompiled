package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.Map;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractSignatureParts.kt */
final class AbstractSignatureParts$computeIndexedQualifiers$1 extends Lambda implements Function1<Integer, JavaTypeQualifiers> {
    final /* synthetic */ JavaTypeQualifiers[] $computedResult;
    final /* synthetic */ TypeEnhancementInfo $predefined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSignatureParts$computeIndexedQualifiers$1(TypeEnhancementInfo typeEnhancementInfo, JavaTypeQualifiers[] javaTypeQualifiersArr) {
        super(1);
        this.$predefined = typeEnhancementInfo;
        this.$computedResult = javaTypeQualifiersArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    public final JavaTypeQualifiers invoke(int i) {
        Map<Integer, JavaTypeQualifiers> map;
        JavaTypeQualifiers javaTypeQualifiers;
        TypeEnhancementInfo typeEnhancementInfo = this.$predefined;
        if (typeEnhancementInfo != null && (map = typeEnhancementInfo.getMap()) != null && (javaTypeQualifiers = map.get(Integer.valueOf(i))) != null) {
            return javaTypeQualifiers;
        }
        JavaTypeQualifiers[] javaTypeQualifiersArr = this.$computedResult;
        return (i < 0 || i > ArraysKt.getLastIndex((T[]) javaTypeQualifiersArr)) ? JavaTypeQualifiers.Companion.getNONE() : javaTypeQualifiersArr[i];
    }
}
