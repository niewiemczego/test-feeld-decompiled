package com.swmansion.rnscreens.events;

import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000bH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/swmansion/rnscreens/events/ScreenTransitionProgressEvent;", "Lcom/facebook/react/uimanager/events/Event;", "surfaceId", "", "viewId", "progress", "", "isClosing", "", "isGoingForward", "coalescingKey", "", "(IIFZZS)V", "getCoalescingKey", "getEventData", "Lcom/facebook/react/bridge/WritableMap;", "getEventName", "", "Companion", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenTransitionProgressEvent.kt */
public final class ScreenTransitionProgressEvent extends Event<ScreenTransitionProgressEvent> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EVENT_NAME = "topTransitionProgress";
    private final short coalescingKey;
    private final boolean isClosing;
    private final boolean isGoingForward;
    private final float progress;

    public String getEventName() {
        return EVENT_NAME;
    }

    public ScreenTransitionProgressEvent(int i, int i2, float f, boolean z, boolean z2, short s) {
        super(i, i2);
        this.progress = f;
        this.isClosing = z;
        this.isGoingForward = z2;
        this.coalescingKey = s;
    }

    public short getCoalescingKey() {
        return this.coalescingKey;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(NotificationCompat.CATEGORY_PROGRESS, (double) this.progress);
        createMap.putInt("closing", this.isClosing ? 1 : 0);
        createMap.putInt("goingForward", this.isGoingForward ? 1 : 0);
        return createMap;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/events/ScreenTransitionProgressEvent$Companion;", "", "()V", "EVENT_NAME", "", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ScreenTransitionProgressEvent.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
