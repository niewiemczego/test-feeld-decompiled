package app.notifee.core;

import android.content.Intent;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Notifee$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ Intent f$0;

    public /* synthetic */ Notifee$$ExternalSyntheticLambda10(Intent intent) {
        this.f$0 = intent;
    }

    public final void run() {
        Notifee.getContext().startActivity(this.f$0);
    }
}
