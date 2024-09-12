package zendesk.ui.android.conversation.connectionbanner;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerRendering;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerRendering;", "connectionBannerRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionBannerView.kt */
final class ConnectionBannerView$onRestoreInstanceState$1 extends Lambda implements Function1<ConnectionBannerRendering, ConnectionBannerRendering> {
    final /* synthetic */ Parcelable $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionBannerView$onRestoreInstanceState$1(Parcelable parcelable) {
        super(1);
        this.$state = parcelable;
    }

    public final ConnectionBannerRendering invoke(ConnectionBannerRendering connectionBannerRendering) {
        Intrinsics.checkNotNullParameter(connectionBannerRendering, "connectionBannerRendering");
        ConnectionBannerRendering.Builder builder = connectionBannerRendering.toBuilder();
        final Parcelable parcelable = this.$state;
        return builder.state(new Function1<ConnectionBannerState, ConnectionBannerState>() {
            public final ConnectionBannerState invoke(ConnectionBannerState connectionBannerState) {
                Intrinsics.checkNotNullParameter(connectionBannerState, "it");
                return connectionBannerState.copy(((ConnectionBannerView.SavedState) parcelable).getConnectionState$zendesk_ui_ui_android());
            }
        }).build();
    }
}
