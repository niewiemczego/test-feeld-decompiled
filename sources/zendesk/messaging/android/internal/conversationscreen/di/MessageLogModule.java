package zendesk.messaging.android.internal.conversationscreen.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.android.internal.conversationscreen.MessageContainerFactory;
import zendesk.messaging.android.internal.conversationscreen.MessageLogEntryMapper;
import zendesk.messaging.android.internal.conversationscreen.MessageLogLabelProvider;
import zendesk.messaging.android.internal.conversationscreen.MessageLogTimestampFormatter;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0010"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/di/MessageLogModule;", "", "()V", "providesMessageContainerFactory", "Lzendesk/messaging/android/internal/conversationscreen/MessageContainerFactory;", "messageLogLabelProvider", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;", "messageLogTimestampFormatter", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;", "providesMessageLogEntryMapper", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogEntryMapper;", "messageContainerFactory", "providesMessageLogLabelProvider", "context", "Landroid/content/Context;", "providesMessageLogTimestampFormatter", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: MessageLogModule.kt */
public final class MessageLogModule {
    @Provides
    public final MessageLogLabelProvider providesMessageLogLabelProvider(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MessageLogLabelProvider(context);
    }

    @Provides
    public final MessageLogTimestampFormatter providesMessageLogTimestampFormatter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new MessageLogTimestampFormatter(context, (Locale) null, false, 6, (DefaultConstructorMarker) null);
    }

    @Provides
    public final MessageContainerFactory providesMessageContainerFactory(MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter) {
        Intrinsics.checkNotNullParameter(messageLogLabelProvider, "messageLogLabelProvider");
        Intrinsics.checkNotNullParameter(messageLogTimestampFormatter, "messageLogTimestampFormatter");
        return new MessageContainerFactory(messageLogLabelProvider, messageLogTimestampFormatter, (Function0) null, 4, (DefaultConstructorMarker) null);
    }

    @Provides
    public final MessageLogEntryMapper providesMessageLogEntryMapper(MessageContainerFactory messageContainerFactory, MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter) {
        Intrinsics.checkNotNullParameter(messageContainerFactory, "messageContainerFactory");
        Intrinsics.checkNotNullParameter(messageLogLabelProvider, "messageLogLabelProvider");
        Intrinsics.checkNotNullParameter(messageLogTimestampFormatter, "messageLogTimestampFormatter");
        return new MessageLogEntryMapper(messageContainerFactory, messageLogLabelProvider, messageLogTimestampFormatter, (Function0) null, (Function0) null, 24, (DefaultConstructorMarker) null);
    }
}
