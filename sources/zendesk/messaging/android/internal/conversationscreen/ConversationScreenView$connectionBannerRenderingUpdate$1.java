package zendesk.messaging.android.internal.conversationscreen;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.ConnectionStatus;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerRendering;
import zendesk.ui.android.conversation.connectionbanner.ConnectionBannerState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/connectionbanner/ConnectionBannerRendering;", "connectionBannerRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationScreenView.kt */
final class ConversationScreenView$connectionBannerRenderingUpdate$1 extends Lambda implements Function1<ConnectionBannerRendering, ConnectionBannerRendering> {
    final /* synthetic */ ConversationScreenView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConversationScreenView$connectionBannerRenderingUpdate$1(ConversationScreenView conversationScreenView) {
        super(1);
        this.this$0 = conversationScreenView;
    }

    public final ConnectionBannerRendering invoke(ConnectionBannerRendering connectionBannerRendering) {
        Intrinsics.checkNotNullParameter(connectionBannerRendering, "connectionBannerRendering");
        ConnectionBannerRendering.Builder onRetryClicked = connectionBannerRendering.toBuilder().onRetryClicked(this.this$0.rendering.getOnRetryConnectionClicked$zendesk_messaging_messaging_android());
        final ConversationScreenView conversationScreenView = this.this$0;
        return onRetryClicked.state(new Function1<ConnectionBannerState, ConnectionBannerState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.ConversationScreenView$connectionBannerRenderingUpdate$1$1$WhenMappings */
            /* compiled from: ConversationScreenView.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ConnectionStatus.values().length];
                    iArr[ConnectionStatus.DISCONNECTED.ordinal()] = 1;
                    iArr[ConnectionStatus.CONNECTING_REALTIME.ordinal()] = 2;
                    iArr[ConnectionStatus.CONNECTED_REALTIME.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final ConnectionBannerState invoke(ConnectionBannerState connectionBannerState) {
                ConnectionBannerState.ConnectionState connectionState;
                Intrinsics.checkNotNullParameter(connectionBannerState, "state");
                ConnectionStatus connectionStatus = conversationScreenView.rendering.getState$zendesk_messaging_messaging_android().getConnectionStatus();
                int i = connectionStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[connectionStatus.ordinal()];
                if (i == 1) {
                    connectionState = ConnectionBannerState.ConnectionState.Disconnected.INSTANCE;
                } else if (i == 2) {
                    connectionState = ConnectionBannerState.ConnectionState.Reconnecting.INSTANCE;
                } else if (i != 3) {
                    connectionState = ConnectionBannerState.ConnectionState.Connected.INSTANCE;
                } else {
                    connectionState = ConnectionBannerState.ConnectionState.Reconnected.INSTANCE;
                }
                return connectionBannerState.copy(connectionState);
            }
        }).build();
    }
}
