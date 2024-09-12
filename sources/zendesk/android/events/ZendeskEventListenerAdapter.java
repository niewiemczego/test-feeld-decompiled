package zendesk.android.events;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.events.ZendeskEvent;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\nH\u0017¨\u0006\u000b"}, d2 = {"Lzendesk/android/events/ZendeskEventListenerAdapter;", "Lzendesk/android/events/ZendeskEventListener;", "()V", "onAuthenticationFailed", "", "event", "Lzendesk/android/events/ZendeskEvent$AuthenticationFailed;", "onEvent", "Lzendesk/android/events/ZendeskEvent;", "onUnreadMessageCountChanged", "Lzendesk/android/events/ZendeskEvent$UnreadMessageCountChanged;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskEventListenerAdapter.kt */
public abstract class ZendeskEventListenerAdapter implements ZendeskEventListener {
    public void onAuthenticationFailed(ZendeskEvent.AuthenticationFailed authenticationFailed) {
        Intrinsics.checkNotNullParameter(authenticationFailed, "event");
    }

    public void onUnreadMessageCountChanged(ZendeskEvent.UnreadMessageCountChanged unreadMessageCountChanged) {
        Intrinsics.checkNotNullParameter(unreadMessageCountChanged, "event");
    }

    public final void onEvent(ZendeskEvent zendeskEvent) {
        Intrinsics.checkNotNullParameter(zendeskEvent, "event");
        if (zendeskEvent instanceof ZendeskEvent.UnreadMessageCountChanged) {
            onUnreadMessageCountChanged((ZendeskEvent.UnreadMessageCountChanged) zendeskEvent);
        } else if (zendeskEvent instanceof ZendeskEvent.AuthenticationFailed) {
            onAuthenticationFailed((ZendeskEvent.AuthenticationFailed) zendeskEvent);
        }
    }
}
