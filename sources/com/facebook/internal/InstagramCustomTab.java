package com.facebook.internal;

import android.net.Uri;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.login.CustomTabLoginMethodHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/facebook/internal/InstagramCustomTab;", "Lcom/facebook/internal/CustomTab;", "action", "", "parameters", "Landroid/os/Bundle;", "(Ljava/lang/String;Landroid/os/Bundle;)V", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InstagramCustomTab.kt */
public final class InstagramCustomTab extends CustomTab {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, d2 = {"Lcom/facebook/internal/InstagramCustomTab$Companion;", "", "()V", "getURIForAction", "Landroid/net/Uri;", "action", "", "parameters", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InstagramCustomTab.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Uri getURIForAction(String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(str, "action");
            if (Intrinsics.areEqual((Object) str, (Object) CustomTabLoginMethodHandler.OAUTH_DIALOG)) {
                Utility utility = Utility.INSTANCE;
                ServerProtocol serverProtocol = ServerProtocol.INSTANCE;
                return Utility.buildUri(ServerProtocol.getInstagramDialogAuthority(), ServerProtocol.INSTAGRAM_OAUTH_PATH, bundle);
            }
            Utility utility2 = Utility.INSTANCE;
            ServerProtocol serverProtocol2 = ServerProtocol.INSTANCE;
            String instagramDialogAuthority = ServerProtocol.getInstagramDialogAuthority();
            StringBuilder sb = new StringBuilder();
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            return Utility.buildUri(instagramDialogAuthority, sb.append(FacebookSdk.getGraphApiVersion()).append("/dialog/").append(str).toString(), bundle);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InstagramCustomTab(String str, Bundle bundle) {
        super(str, bundle);
        Intrinsics.checkNotNullParameter(str, "action");
        setUri(Companion.getURIForAction(str, bundle == null ? new Bundle() : bundle));
    }
}
