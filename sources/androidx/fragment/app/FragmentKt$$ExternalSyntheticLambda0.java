package androidx.fragment.app;

import android.os.Bundle;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FragmentKt$$ExternalSyntheticLambda0 implements FragmentResultListener {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ FragmentKt$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.m39setFragmentResultListener$lambda0(this.f$0, str, bundle);
    }
}
