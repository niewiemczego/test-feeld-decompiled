package expo.modules.kotlin.activityresult;

import android.content.IntentSender;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AppContextActivityResultRegistry$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ AppContextActivityResultRegistry f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ IntentSender.SendIntentException f$2;

    public /* synthetic */ AppContextActivityResultRegistry$$ExternalSyntheticLambda1(AppContextActivityResultRegistry appContextActivityResultRegistry, int i, IntentSender.SendIntentException sendIntentException) {
        this.f$0 = appContextActivityResultRegistry;
        this.f$1 = i;
        this.f$2 = sendIntentException;
    }

    public final void run() {
        AppContextActivityResultRegistry.m776onLaunch$lambda1(this.f$0, this.f$1, this.f$2);
    }
}
