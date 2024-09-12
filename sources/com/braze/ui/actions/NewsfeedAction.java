package com.braze.ui.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.ui.activities.BrazeFeedActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/braze/ui/actions/NewsfeedAction;", "Lcom/braze/ui/actions/IAction;", "extras", "Landroid/os/Bundle;", "channel", "Lcom/braze/enums/Channel;", "(Landroid/os/Bundle;Lcom/braze/enums/Channel;)V", "getChannel", "()Lcom/braze/enums/Channel;", "getExtras", "()Landroid/os/Bundle;", "execute", "", "context", "Landroid/content/Context;", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: NewsfeedAction.kt */
public class NewsfeedAction implements IAction {
    private final Channel channel;
    private final Bundle extras;

    public NewsfeedAction(Bundle bundle, Channel channel2) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.extras = bundle;
        this.channel = channel2;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public void execute(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent(context, BrazeFeedActivity.class);
            Bundle bundle = this.extras;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) NewsfeedAction$execute$1.INSTANCE);
        }
    }
}
