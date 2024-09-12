package expo.modules.kotlin.activityaware;

import androidx.appcompat.app.AppCompatActivity;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppCompatActivityAwareHelper$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OnActivityAvailableListener f$0;
    public final /* synthetic */ AppCompatActivity f$1;

    public /* synthetic */ AppCompatActivityAwareHelper$$ExternalSyntheticLambda0(OnActivityAvailableListener onActivityAvailableListener, AppCompatActivity appCompatActivity) {
        this.f$0 = onActivityAvailableListener;
        this.f$1 = appCompatActivity;
    }

    public final void run() {
        AppCompatActivityAwareHelper.m774addOnActivityAvailableListener$lambda2$lambda1(this.f$0, this.f$1);
    }
}
