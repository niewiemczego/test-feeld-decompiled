package com.adapty.internal.data.models.requests;

import com.adapty.internal.data.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/adapty/internal/data/models/requests/SendEventRequest;", "", "events", "", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "(Ljava/util/List;)V", "getEvents", "()Ljava/util/List;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SendEventRequest.kt */
public final class SendEventRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<AnalyticsEvent> events;

    public SendEventRequest(List<AnalyticsEvent> list) {
        Intrinsics.checkNotNullParameter(list, "events");
        this.events = list;
    }

    public final List<AnalyticsEvent> getEvents() {
        return this.events;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¨\u0006\b"}, d2 = {"Lcom/adapty/internal/data/models/requests/SendEventRequest$Companion;", "", "()V", "create", "Lcom/adapty/internal/data/models/requests/SendEventRequest;", "events", "", "Lcom/adapty/internal/data/models/AnalyticsEvent;", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SendEventRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SendEventRequest create(List<AnalyticsEvent> list) {
            Intrinsics.checkNotNullParameter(list, "events");
            return new SendEventRequest(list);
        }
    }
}
