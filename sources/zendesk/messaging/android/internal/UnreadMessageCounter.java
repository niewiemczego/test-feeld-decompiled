package zendesk.messaging.android.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/messaging/android/internal/UnreadMessageCounter;", "", "()V", "unreadMessageCount", "", "getUnreadMessageCount", "increase", "reset", "update", "unreadCount", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnreadMessageCounter.kt */
public final class UnreadMessageCounter {
    private int unreadMessageCount;

    public final int reset() {
        this.unreadMessageCount = 0;
        return 0;
    }

    public final int getUnreadMessageCount() {
        return this.unreadMessageCount;
    }

    public final int update(int i) {
        this.unreadMessageCount = i;
        return i;
    }

    public final int increase() {
        int i = this.unreadMessageCount + 1;
        this.unreadMessageCount = i;
        return i;
    }
}
