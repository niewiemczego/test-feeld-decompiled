package com.facebook.login;

import androidx.activity.result.ActivityResult;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Landroidx/activity/result/ActivityResult;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: LoginFragment.kt */
final class LoginFragment$getLoginMethodHandlerCallback$1 extends Lambda implements Function1<ActivityResult, Unit> {
    final /* synthetic */ FragmentActivity $activity;
    final /* synthetic */ LoginFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginFragment$getLoginMethodHandlerCallback$1(LoginFragment loginFragment, FragmentActivity fragmentActivity) {
        super(1);
        this.this$0 = loginFragment;
        this.$activity = fragmentActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ActivityResult) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "result");
        if (activityResult.getResultCode() == -1) {
            this.this$0.getLoginClient().onActivityResult(LoginClient.Companion.getLoginRequestCode(), activityResult.getResultCode(), activityResult.getData());
        } else {
            this.$activity.finish();
        }
    }
}
