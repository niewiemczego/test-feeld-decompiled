package zendesk.messaging.android.internal.conversationscreen.messagelog;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.UrlSource;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.ui.android.conversation.carousel.CarouselCellAction;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lzendesk/ui/android/conversation/carousel/CarouselCellAction;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createCarouselCell$1$items$1$action$1$1 extends Lambda implements Function1<CarouselCellAction, Unit> {
    final /* synthetic */ MessageAction.Link $action;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createCarouselCell$1$items$1$action$1$1(UriHandler uriHandler, MessageAction.Link link) {
        super(1);
        this.$uriHandler = uriHandler;
        this.$action = link;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CarouselCellAction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CarouselCellAction carouselCellAction) {
        Intrinsics.checkNotNullParameter(carouselCellAction, "it");
        this.$uriHandler.onUriClicked(this.$action.getUri(), UrlSource.CAROUSEL);
    }
}
