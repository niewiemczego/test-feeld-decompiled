package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import zendesk.android.messaging.UrlSource;
import zendesk.conversationkit.android.model.Field;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.StubUriHandler;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.MessageShape;
import zendesk.ui.android.conversation.actionbutton.ActionButton;
import zendesk.ui.android.conversation.carousel.CarouselCellView;
import zendesk.ui.android.conversation.file.FileView;
import zendesk.ui.android.conversation.form.FormRendering;
import zendesk.ui.android.conversation.form.FormResponseRendering;
import zendesk.ui.android.conversation.form.FormResponseView;
import zendesk.ui.android.conversation.form.FormView;
import zendesk.ui.android.conversation.imagecell.ImageCellDirection;
import zendesk.ui.android.conversation.imagecell.ImageCellView;
import zendesk.ui.android.conversation.imagecell.ImageType;
import zendesk.ui.android.conversation.textcell.TextCellView;
import zendesk.ui.android.conversation.typingindicatorcell.TypingIndicatorCellView;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011JE\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\u0010\u001bJC\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u0018¢\u0006\u0002\u0010 JG\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u0018H\u0002¢\u0006\u0002\u0010#J,\u0010$\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020\b2\u001c\u0010&\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020'0\u0018j\b\u0012\u0004\u0012\u00020'`(JD\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010\u0007\u001a\u00020\b2.\u0010&\u001a*\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0,\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0,0\u0018j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0,`(J[\u0010-\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\"2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010/JM\u00100\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u00101Ji\u00102\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u00103\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001a0\u00182\u0014\b\u0002\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u00105J\u000e\u00106\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u00107\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0003J\u0018\u0010=\u001a\u00020>2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J\u001f\u0010?\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020A2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010BJ#\u0010C\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020A2\f\b\u0001\u0010D\u001a\u00020E\"\u00020\u000eH\u0000¢\u0006\u0002\bFJ \u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u0019H\u0002J\u001b\u0010J\u001a\u00020\u000e*\u00020\u000e2\b\b\u0002\u0010K\u001a\u00020\u0004H\u0001¢\u0006\u0002\bLJ\u001c\u0010M\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010N*\u00020\f2\u0006\u0010@\u001a\u00020AH\u0002J$\u0010P\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010N*\n\u0012\u0004\u0012\u00020Q\u0018\u00010N2\u0006\u0010@\u001a\u00020AH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogCellFactory;", "", "()V", "DEFAULT_ALPHA_FACTOR", "", "createCarouselCell", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "content", "Lzendesk/conversationkit/android/model/MessageContent$Carousel;", "container", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "pressedColor", "", "uriHandler", "Lzendesk/messaging/android/internal/UriHandler;", "(Landroid/view/ViewGroup;Lzendesk/conversationkit/android/model/MessageContent$Carousel;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Ljava/lang/Integer;Lzendesk/messaging/android/internal/UriHandler;)Landroid/view/View;", "createFileCell", "fileContent", "Lzendesk/conversationkit/android/model/MessageContent$File;", "item", "outboundMessageColor", "onFileClicked", "Lkotlin/Function1;", "", "", "(Lzendesk/conversationkit/android/model/MessageContent$File;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "createFileUploadCell", "uploadContent", "Lzendesk/conversationkit/android/model/MessageContent$FileUpload;", "onFailedMessageClicked", "(Lzendesk/conversationkit/android/model/MessageContent$FileUpload;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "createFileView", "Lzendesk/conversationkit/android/model/MessageContent$Image;", "(Lzendesk/conversationkit/android/model/MessageContent$Image;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)Landroid/view/View;", "createFormResponseView", "Lzendesk/ui/android/conversation/form/FormResponseView;", "renderingUpdate", "Lzendesk/ui/android/conversation/form/FormResponseRendering;", "Lzendesk/messaging/android/internal/conversationscreen/RenderingUpdate;", "createFormView", "Lzendesk/ui/android/conversation/form/FormView;", "Lzendesk/conversationkit/android/model/Field;", "Lzendesk/ui/android/conversation/form/FormRendering;", "createImageCell", "actionColor", "(Lzendesk/conversationkit/android/model/MessageContent$Image;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Lzendesk/messaging/android/internal/UriHandler;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Landroid/view/View;", "createImageUploadCell", "(Lzendesk/conversationkit/android/model/MessageContent$FileUpload;Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lzendesk/messaging/android/internal/UriHandler;)Landroid/view/View;", "createTextCell", "onMessageContainerClicked", "onMessageTextClicked", "(Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;Landroid/view/ViewGroup;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lzendesk/messaging/android/internal/UriHandler;)Landroid/view/View;", "createTypingIndicatorCell", "createUnsupportedCell", "getCellDrawable", "shape", "Lzendesk/messaging/android/internal/model/MessageShape;", "direction", "Lzendesk/messaging/android/internal/model/MessageDirection;", "getImageCellDirection", "Lzendesk/ui/android/conversation/imagecell/ImageCellDirection;", "getOutboundMessageColor", "context", "Landroid/content/Context;", "(Landroid/content/Context;Ljava/lang/Integer;)I", "getTotalDimen", "dimens", "", "getTotalDimen$zendesk_messaging_messaging_android", "onActionUriClicked", "source", "uri", "adjustAlpha", "factor", "adjustAlpha$zendesk_messaging_messaging_android", "getCellActions", "", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "toListOfActionButton", "Lzendesk/conversationkit/android/model/MessageAction;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
public final class MessageLogCellFactory {
    private static final float DEFAULT_ALPHA_FACTOR = 0.5f;
    public static final MessageLogCellFactory INSTANCE = new MessageLogCellFactory();

    private MessageLogCellFactory() {
    }

    public final View createUnsupportedCell(MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        TextCellView textCellView = new TextCellView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        textCellView.render(new MessageLogCellFactory$createUnsupportedCell$1$1(textCellView, messageContainer));
        return textCellView;
    }

    public static /* synthetic */ View createTextCell$default(MessageLogCellFactory messageLogCellFactory, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Integer num2, Function1 function1, Function1 function12, UriHandler uriHandler, int i, Object obj) {
        UriHandler uriHandler2;
        Integer num3 = (i & 4) != 0 ? null : num;
        Integer num4 = (i & 8) != 0 ? null : num2;
        Function1 function13 = (i & 16) != 0 ? MessageLogCellFactory$createTextCell$1.INSTANCE : function1;
        Function1 function14 = (i & 32) != 0 ? MessageLogCellFactory$createTextCell$2.INSTANCE : function12;
        if ((i & 64) != 0) {
            uriHandler2 = StubUriHandler.INSTANCE;
        } else {
            uriHandler2 = uriHandler;
        }
        return messageLogCellFactory.createTextCell(messageContainer, viewGroup, num3, num4, function13, function14, uriHandler2);
    }

    public final View createTextCell(MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Integer num2, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, Function1<? super String, Unit> function12, UriHandler uriHandler) {
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "onMessageContainerClicked");
        Intrinsics.checkNotNullParameter(function12, "onMessageTextClicked");
        Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        TextCellView textCellView = new TextCellView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        textCellView.render(new MessageLogCellFactory$createTextCell$3$1(messageContainer, textCellView, num != null ? num.intValue() : ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_message), num2, function1, function12, uriHandler));
        return textCellView;
    }

    public final View createTypingIndicatorCell(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        TypingIndicatorCellView typingIndicatorCellView = new TypingIndicatorCellView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        typingIndicatorCellView.render(new MessageLogCellFactory$createTypingIndicatorCell$1$1(typingIndicatorCellView));
        return typingIndicatorCellView;
    }

    public static /* synthetic */ View createFileCell$default(MessageLogCellFactory messageLogCellFactory, MessageContent.File file, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            function1 = MessageLogCellFactory$createFileCell$1.INSTANCE;
        }
        return messageLogCellFactory.createFileCell(file, messageContainer, viewGroup, num2, function1);
    }

    public final View createFileCell(MessageContent.File file, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(file, "fileContent");
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "onFileClicked");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        FileView fileView = new FileView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        fileView.render(new MessageLogCellFactory$createFileCell$2$1(num, fileView, messageContainer, file, function1));
        return fileView;
    }

    public static /* synthetic */ View createFileUploadCell$default(MessageLogCellFactory messageLogCellFactory, MessageContent.FileUpload fileUpload, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        return messageLogCellFactory.createFileUploadCell(fileUpload, messageContainer, viewGroup, num, function1);
    }

    public final View createFileUploadCell(MessageContent.FileUpload fileUpload, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1<? super MessageLogEntry.MessageContainer, Unit> function1) {
        Intrinsics.checkNotNullParameter(fileUpload, "uploadContent");
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "onFailedMessageClicked");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        FileView fileView = new FileView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        fileView.render(new MessageLogCellFactory$createFileUploadCell$1$1(num, fileView, messageContainer, fileUpload, function1));
        return fileView;
    }

    public final FormView<Field> createFormView(ViewGroup viewGroup, Function1<? super FormRendering<Field>, FormRendering<Field>> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        FormView formView = new FormView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        formView.render(function1);
        return formView;
    }

    public final FormResponseView createFormResponseView(ViewGroup viewGroup, Function1<? super FormResponseRendering, FormResponseRendering> function1) {
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        FormResponseView formResponseView = new FormResponseView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        formResponseView.render(function1);
        return formResponseView;
    }

    public static /* synthetic */ View createCarouselCell$default(MessageLogCellFactory messageLogCellFactory, ViewGroup viewGroup, MessageContent.Carousel carousel, MessageLogEntry.MessageContainer messageContainer, Integer num, UriHandler uriHandler, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            uriHandler = StubUriHandler.INSTANCE;
        }
        return messageLogCellFactory.createCarouselCell(viewGroup, carousel, messageContainer, num2, uriHandler);
    }

    public final View createCarouselCell(ViewGroup viewGroup, MessageContent.Carousel carousel, MessageLogEntry.MessageContainer messageContainer, Integer num, UriHandler uriHandler) {
        ViewGroup viewGroup2 = viewGroup;
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(carousel, "content");
        Intrinsics.checkNotNullParameter(messageContainer, TtmlNode.RUBY_CONTAINER);
        Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        CarouselCellView carouselCellView = new CarouselCellView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        int i = 0;
        for (Number intValue : CollectionsKt.listOf(Integer.valueOf(R.dimen.zma_cell_inbound_margin_end), Integer.valueOf(R.dimen.zuia_horizontal_spacing_medium), Integer.valueOf(R.dimen.zuia_avatar_image_size))) {
            i += viewGroup.getResources().getDimensionPixelSize(intValue.intValue());
        }
        carouselCellView.render(new MessageLogCellFactory$createCarouselCell$1(viewGroup, i, num, messageContainer, carousel, uriHandler));
        return carouselCellView;
    }

    public static /* synthetic */ View createImageCell$default(MessageLogCellFactory messageLogCellFactory, MessageContent.Image image, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, UriHandler uriHandler, Integer num, Function1 function1, Integer num2, int i, Object obj) {
        Function1 function12;
        UriHandler uriHandler2 = (i & 8) != 0 ? StubUriHandler.INSTANCE : uriHandler;
        Integer num3 = (i & 16) != 0 ? null : num;
        if ((i & 32) != 0) {
            function12 = MessageLogCellFactory$createImageCell$1.INSTANCE;
        } else {
            function12 = function1;
        }
        return messageLogCellFactory.createImageCell(image, messageContainer, viewGroup, uriHandler2, num3, function12, (i & 64) != 0 ? null : num2);
    }

    public final View createImageCell(MessageContent.Image image, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, UriHandler uriHandler, Integer num, Function1<? super String, Unit> function1, Integer num2) {
        int i;
        Intrinsics.checkNotNullParameter(image, "content");
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
        Intrinsics.checkNotNullParameter(function1, "onFileClicked");
        if (ImageType.Companion.isSupported(image.getMediaType())) {
            Context context = viewGroup.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
            ImageCellView imageCellView = new ImageCellView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
            MessageLogCellFactory messageLogCellFactory = INSTANCE;
            Context context2 = imageCellView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            int outboundMessageColor = messageLogCellFactory.getOutboundMessageColor(context2, num);
            Context context3 = viewGroup.getContext();
            if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                i = R.color.zma_color_message_inbound_text;
            } else {
                i = R.color.zma_color_message_outbound_text;
            }
            int color = ContextCompat.getColor(context3, i);
            if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                outboundMessageColor = ContextCompat.getColor(viewGroup.getContext(), R.color.zma_color_message_inbound_background);
            }
            imageCellView.render(new MessageLogCellFactory$createImageCell$cell$1$1(image, viewGroup, messageContainer, imageCellView, color, outboundMessageColor, num2, uriHandler));
            return imageCellView;
        }
        Integer num3 = num;
        return createFileView(image, messageContainer, viewGroup, num, function1);
    }

    static /* synthetic */ View createFileView$default(MessageLogCellFactory messageLogCellFactory, MessageContent.Image image, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 16) != 0) {
            function1 = MessageLogCellFactory$createFileView$1.INSTANCE;
        }
        return messageLogCellFactory.createFileView(image, messageContainer, viewGroup, num2, function1);
    }

    private final View createFileView(MessageContent.Image image, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1<? super String, Unit> function1) {
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        FileView fileView = new FileView(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        fileView.render(new MessageLogCellFactory$createFileView$2(viewGroup, num, messageContainer, image, function1));
        return fileView;
    }

    public static /* synthetic */ View createImageUploadCell$default(MessageLogCellFactory messageLogCellFactory, MessageContent.FileUpload fileUpload, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1 function1, UriHandler uriHandler, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            uriHandler = StubUriHandler.INSTANCE;
        }
        return messageLogCellFactory.createImageUploadCell(fileUpload, messageContainer, viewGroup, num2, function1, uriHandler);
    }

    public final View createImageUploadCell(MessageContent.FileUpload fileUpload, MessageLogEntry.MessageContainer messageContainer, ViewGroup viewGroup, Integer num, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, UriHandler uriHandler) {
        Intrinsics.checkNotNullParameter(fileUpload, "content");
        Intrinsics.checkNotNullParameter(messageContainer, "item");
        Intrinsics.checkNotNullParameter(viewGroup, "parentView");
        Intrinsics.checkNotNullParameter(function1, "onFailedMessageClicked");
        Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parentView.context");
        ImageCellView imageCellView = new ImageCellView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        imageCellView.render(new MessageLogCellFactory$createImageUploadCell$1$1(num, imageCellView, messageContainer, fileUpload, function1, uriHandler));
        return imageCellView;
    }

    /* access modifiers changed from: private */
    public final int getCellDrawable(MessageShape messageShape, MessageDirection messageDirection) {
        if (messageShape == MessageShape.STANDALONE && messageDirection == MessageDirection.INBOUND) {
            return R.drawable.zuia_message_cell_inbound_shape_single;
        }
        if (messageShape == MessageShape.GROUP_TOP && messageDirection == MessageDirection.INBOUND) {
            return R.drawable.zuia_message_cell_inbound_shape_top;
        }
        if (messageShape == MessageShape.GROUP_MIDDLE && messageDirection == MessageDirection.INBOUND) {
            return R.drawable.zuia_message_cell_inbound_shape_middle;
        }
        if (messageShape == MessageShape.GROUP_BOTTOM && messageDirection == MessageDirection.INBOUND) {
            return R.drawable.zuia_message_cell_inbound_shape_bottom;
        }
        if (messageShape == MessageShape.STANDALONE && messageDirection == MessageDirection.OUTBOUND) {
            return R.drawable.zuia_message_cell_outbound_shape_single;
        }
        if (messageShape == MessageShape.GROUP_TOP && messageDirection == MessageDirection.OUTBOUND) {
            return R.drawable.zuia_message_cell_outbound_shape_top;
        }
        if (messageShape == MessageShape.GROUP_MIDDLE && messageDirection == MessageDirection.OUTBOUND) {
            return R.drawable.zuia_message_cell_outbound_shape_middle;
        }
        if (messageShape == MessageShape.GROUP_BOTTOM && messageDirection == MessageDirection.OUTBOUND) {
            return R.drawable.zuia_message_cell_outbound_shape_bottom;
        }
        return R.drawable.zuia_message_cell_inbound_shape_single;
    }

    /* access modifiers changed from: private */
    public final ImageCellDirection getImageCellDirection(MessageShape messageShape, MessageDirection messageDirection) {
        if (messageShape == MessageShape.STANDALONE && messageDirection == MessageDirection.INBOUND) {
            return ImageCellDirection.INBOUND_SINGLE;
        }
        if (messageShape == MessageShape.GROUP_TOP && messageDirection == MessageDirection.INBOUND) {
            return ImageCellDirection.INBOUND_TOP;
        }
        if (messageShape == MessageShape.GROUP_MIDDLE && messageDirection == MessageDirection.INBOUND) {
            return ImageCellDirection.INBOUND_MIDDLE;
        }
        if (messageShape == MessageShape.GROUP_BOTTOM && messageDirection == MessageDirection.INBOUND) {
            return ImageCellDirection.INBOUND_BOTTOM;
        }
        if (messageShape == MessageShape.STANDALONE && messageDirection == MessageDirection.OUTBOUND) {
            return ImageCellDirection.OUTBOUND_SINGLE;
        }
        if (messageShape == MessageShape.GROUP_TOP && messageDirection == MessageDirection.OUTBOUND) {
            return ImageCellDirection.OUTBOUND_TOP;
        }
        if (messageShape == MessageShape.GROUP_MIDDLE && messageDirection == MessageDirection.OUTBOUND) {
            return ImageCellDirection.OUTBOUND_MIDDLE;
        }
        if (messageShape == MessageShape.GROUP_BOTTOM && messageDirection == MessageDirection.OUTBOUND) {
            return ImageCellDirection.OUTBOUND_BOTTOM;
        }
        return ImageCellDirection.INBOUND_SINGLE;
    }

    /* access modifiers changed from: private */
    public final int getOutboundMessageColor(Context context, Integer num) {
        return num != null ? num.intValue() : ContextCompat.getColor(context, R.color.zma_color_message);
    }

    /* access modifiers changed from: private */
    public final List<ActionButton> getCellActions(MessageLogEntry.MessageContainer messageContainer, Context context) {
        MessageContent content = messageContainer.getMessage().getContent();
        if (content instanceof MessageContent.Text) {
            return toListOfActionButton(((MessageContent.Text) content).getActions(), context);
        }
        if (content instanceof MessageContent.Image) {
            return toListOfActionButton(((MessageContent.Image) content).getActions(), context);
        }
        List list = null;
        return null;
    }

    private final List<ActionButton> toListOfActionButton(List<? extends MessageAction> list, Context context) {
        ActionButton actionButton;
        if (list == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (MessageAction messageAction : list) {
            if (messageAction instanceof MessageAction.Reply) {
                Context context2 = context;
                actionButton = null;
            } else {
                if (messageAction instanceof MessageAction.Link) {
                    MessageAction.Link link = (MessageAction.Link) messageAction;
                    actionButton = new ActionButton(link.getText(), link.getUri(), (String) null, false, UrlSource.LINK_MESSAGE_ACTION.name(), 12, (DefaultConstructorMarker) null);
                } else if (messageAction instanceof MessageAction.WebView) {
                    MessageAction.WebView webView = (MessageAction.WebView) messageAction;
                    actionButton = new ActionButton(webView.getText(), webView.getUri(), webView.getFallback(), false, UrlSource.WEBVIEW_MESSAGE_ACTION.name(), 8, (DefaultConstructorMarker) null);
                } else {
                    String string = context.getString(R.string.zuia_option_not_supported);
                    Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…uia_option_not_supported)");
                    actionButton = new ActionButton(string, (String) null, (String) null, false, (String) null, 22, (DefaultConstructorMarker) null);
                }
                Context context3 = context;
            }
            if (actionButton != null) {
                arrayList.add(actionButton);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public final void onActionUriClicked(String str, UriHandler uriHandler, String str2) {
        UrlSource findByValue = UrlSource.Companion.findByValue(str);
        if (findByValue != null) {
            uriHandler.onUriClicked(str2, findByValue);
        }
    }

    public static /* synthetic */ int adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory messageLogCellFactory, int i, float f, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = 0.5f;
        }
        return messageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android(i, f);
    }

    public final int adjustAlpha$zendesk_messaging_messaging_android(int i, float f) {
        return Color.argb(MathKt.roundToInt(((float) Color.alpha(i)) * f), Color.red(i), Color.green(i), Color.blue(i));
    }

    public final int getTotalDimen$zendesk_messaging_messaging_android(Context context, int... iArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iArr, "dimens");
        int i = 0;
        for (int dimensionPixelSize : iArr) {
            i += context.getResources().getDimensionPixelSize(dimensionPixelSize);
        }
        return i;
    }
}
