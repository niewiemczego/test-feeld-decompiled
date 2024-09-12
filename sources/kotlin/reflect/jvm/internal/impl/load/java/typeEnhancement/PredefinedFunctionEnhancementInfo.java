package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class PredefinedFunctionEnhancementInfo {
    private final List<TypeEnhancementInfo> parametersInfo;
    private final TypeEnhancementInfo returnTypeInfo;

    public PredefinedFunctionEnhancementInfo() {
        this((TypeEnhancementInfo) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List<TypeEnhancementInfo> list) {
        Intrinsics.checkNotNullParameter(list, "parametersInfo");
        this.returnTypeInfo = typeEnhancementInfo;
        this.parametersInfo = list;
    }

    public final TypeEnhancementInfo getReturnTypeInfo() {
        return this.returnTypeInfo;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PredefinedFunctionEnhancementInfo(TypeEnhancementInfo typeEnhancementInfo, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : typeEnhancementInfo, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<TypeEnhancementInfo> getParametersInfo() {
        return this.parametersInfo;
    }
}
