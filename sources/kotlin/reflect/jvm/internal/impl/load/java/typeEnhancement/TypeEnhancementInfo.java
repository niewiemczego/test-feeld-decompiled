package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: predefinedEnhancementInfo.kt */
public final class TypeEnhancementInfo {
    private final Map<Integer, JavaTypeQualifiers> map;

    public TypeEnhancementInfo(Map<Integer, JavaTypeQualifiers> map2) {
        Intrinsics.checkNotNullParameter(map2, AdaptyImmutableMapTypeAdapterFactory.MAP);
        this.map = map2;
    }

    public final Map<Integer, JavaTypeQualifiers> getMap() {
        return this.map;
    }
}
