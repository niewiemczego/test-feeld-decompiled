package bo.app;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class a1 extends Lambda implements Function0 {
    final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a1(String str) {
        super(0);
        this.b = str;
    }

    /* renamed from: a */
    public final String invoke() {
        return "Failed to create valid enum from string: " + this.b;
    }
}
