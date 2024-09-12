package zendesk.messaging.android.internal.conversationscreen.messagelog;

import zendesk.messaging.android.internal.model.MessageLogEntry;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MessageLogView$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MessageLogView f$0;
    public final /* synthetic */ MessageLogEntry.MessageContainer f$1;

    public /* synthetic */ MessageLogView$$ExternalSyntheticLambda1(MessageLogView messageLogView, MessageLogEntry.MessageContainer messageContainer) {
        this.f$0 = messageLogView;
        this.f$1 = messageContainer;
    }

    public final void run() {
        MessageLogView.m693announceNewMessageContentForAccessibility$lambda9(this.f$0, this.f$1);
    }
}
