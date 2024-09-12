package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.carousel.CarouselCellState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/carousel/CarouselCellState;", "state", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createCarouselCell$1 extends Lambda implements Function1<CarouselCellState, CarouselCellState> {
    final /* synthetic */ MessageLogEntry.MessageContainer $container;
    final /* synthetic */ MessageContent.Carousel $content;
    final /* synthetic */ int $margin;
    final /* synthetic */ ViewGroup $parentView;
    final /* synthetic */ Integer $pressedColor;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createCarouselCell$1(ViewGroup viewGroup, int i, Integer num, MessageLogEntry.MessageContainer messageContainer, MessageContent.Carousel carousel, UriHandler uriHandler) {
        super(1);
        this.$parentView = viewGroup;
        this.$margin = i;
        this.$pressedColor = num;
        this.$container = messageContainer;
        this.$content = carousel;
        this.$uriHandler = uriHandler;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: zendesk.ui.android.conversation.avatar.AvatarImageState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: zendesk.ui.android.conversation.avatar.AvatarImageState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: zendesk.ui.android.conversation.avatar.AvatarImageState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: zendesk.ui.android.conversation.carousel.CarouselCellAction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: zendesk.ui.android.conversation.avatar.AvatarImageState} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v9, resolved type: zendesk.ui.android.conversation.avatar.AvatarImageState} */
    /* JADX WARNING: type inference failed for: r7v6, types: [zendesk.ui.android.conversation.carousel.CarouselCellAction] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final zendesk.ui.android.conversation.carousel.CarouselCellState invoke(zendesk.ui.android.conversation.carousel.CarouselCellState r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            java.lang.String r2 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            zendesk.ui.android.conversation.carousel.CarouselRendering r2 = new zendesk.ui.android.conversation.carousel.CarouselRendering
            android.view.ViewGroup r3 = r0.$parentView
            android.content.Context r3 = r3.getContext()
            int r4 = zendesk.messaging.R.color.zma_color_message_inbound_text
            int r3 = androidx.core.content.ContextCompat.getColor(r3, r4)
            int r4 = r0.$margin
            java.lang.Integer r5 = r0.$pressedColor
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r6 = r0.$container
            zendesk.messaging.android.internal.model.MessagePosition r6 = r6.getPosition()
            zendesk.messaging.android.internal.model.MessagePosition r7 = zendesk.messaging.android.internal.model.MessagePosition.GROUP_BOTTOM
            if (r6 == r7) goto L_0x0032
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r6 = r0.$container
            zendesk.messaging.android.internal.model.MessagePosition r6 = r6.getPosition()
            zendesk.messaging.android.internal.model.MessagePosition r7 = zendesk.messaging.android.internal.model.MessagePosition.STANDALONE
            if (r6 != r7) goto L_0x0030
            goto L_0x0032
        L_0x0030:
            r6 = 0
            goto L_0x0033
        L_0x0032:
            r6 = 1
        L_0x0033:
            r2.<init>(r3, r4, r5, r6)
            zendesk.conversationkit.android.model.MessageContent$Carousel r3 = r0.$content
            java.util.List r3 = r3.getItems()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            zendesk.messaging.android.internal.UriHandler r4 = r0.$uriHandler
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r3, r6)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r3 = r3.iterator()
        L_0x0051:
            boolean r6 = r3.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x00bb
            java.lang.Object r6 = r3.next()
            zendesk.conversationkit.android.model.MessageItem r6 = (zendesk.conversationkit.android.model.MessageItem) r6
            java.util.List r8 = r6.getActions()
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x006f:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x0081
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof zendesk.conversationkit.android.model.MessageAction.Link
            if (r11 == 0) goto L_0x006f
            r9.add(r10)
            goto L_0x006f
        L_0x0081:
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r8 = kotlin.collections.CollectionsKt.firstOrNull(r9)
            zendesk.conversationkit.android.model.MessageAction$Link r8 = (zendesk.conversationkit.android.model.MessageAction.Link) r8
            if (r8 == 0) goto L_0x009f
            zendesk.ui.android.conversation.carousel.CarouselCellAction r7 = new zendesk.ui.android.conversation.carousel.CarouselCellAction
            java.lang.String r9 = r8.getId()
            java.lang.String r10 = r8.getText()
            zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createCarouselCell$1$items$1$action$1$1 r11 = new zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createCarouselCell$1$items$1$action$1$1
            r11.<init>(r4, r8)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            r7.<init>(r9, r10, r11)
        L_0x009f:
            r17 = r7
            zendesk.ui.android.conversation.carousel.CarouselCellData$Item r7 = new zendesk.ui.android.conversation.carousel.CarouselCellData$Item
            java.lang.String r13 = r6.getTitle()
            java.lang.String r14 = r6.getDescription()
            java.lang.String r15 = r6.getMediaUrl()
            java.lang.String r16 = r6.getMediaType()
            r12 = r7
            r12.<init>(r13, r14, r15, r16, r17)
            r5.add(r7)
            goto L_0x0051
        L_0x00bb:
            java.util.List r5 = (java.util.List) r5
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r3 = r0.$container
            java.lang.String r3 = r3.getAvatarUrl()
            if (r3 == 0) goto L_0x00ef
            zendesk.ui.android.conversation.avatar.AvatarImageState$Builder r3 = new zendesk.ui.android.conversation.avatar.AvatarImageState$Builder
            r3.<init>()
            android.view.ViewGroup r4 = r0.$parentView
            android.content.Context r4 = r4.getContext()
            int r6 = zendesk.messaging.R.color.zma_color_message_inbound_background
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r6)
            zendesk.ui.android.conversation.avatar.AvatarImageState$Builder r3 = r3.backgroundColor(r4)
            zendesk.ui.android.conversation.avatar.AvatarMask r4 = zendesk.ui.android.conversation.avatar.AvatarMask.CIRCLE
            zendesk.ui.android.conversation.avatar.AvatarImageState$Builder r3 = r3.mask(r4)
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r4 = r0.$container
            java.lang.String r4 = r4.getAvatarUrl()
            zendesk.ui.android.conversation.avatar.AvatarImageState$Builder r3 = r3.uri((java.lang.String) r4)
            zendesk.ui.android.conversation.avatar.AvatarImageState r7 = r3.build()
            goto L_0x00f2
        L_0x00ef:
            r3 = r7
            zendesk.ui.android.conversation.avatar.AvatarImageState r3 = (zendesk.ui.android.conversation.avatar.AvatarImageState) r3
        L_0x00f2:
            zendesk.ui.android.conversation.carousel.CarouselCellState r1 = r1.copy(r5, r7, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createCarouselCell$1.invoke(zendesk.ui.android.conversation.carousel.CarouselCellState):zendesk.ui.android.conversation.carousel.CarouselCellState");
    }
}
