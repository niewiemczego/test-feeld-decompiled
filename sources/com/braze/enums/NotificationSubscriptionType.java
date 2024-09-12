package com.braze.enums;

import com.braze.models.IPutIntoJson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/braze/enums/NotificationSubscriptionType;", "", "Lcom/braze/models/IPutIntoJson;", "", "key", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "forJsonPut", "OPTED_IN", "SUBSCRIBED", "UNSUBSCRIBED", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum NotificationSubscriptionType implements IPutIntoJson<String> {
    OPTED_IN("opted_in"),
    SUBSCRIBED("subscribed"),
    UNSUBSCRIBED("unsubscribed");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final Map<String, NotificationSubscriptionType> map = null;
    private final String key;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/braze/enums/NotificationSubscriptionType$Companion;", "", "()V", "map", "", "", "Lcom/braze/enums/NotificationSubscriptionType;", "fromValue", "value", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final NotificationSubscriptionType fromValue(String str) {
            String str2;
            Map access$getMap$cp = NotificationSubscriptionType.map;
            NotificationSubscriptionType notificationSubscriptionType = null;
            if (str != null) {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                str2 = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            Object obj = access$getMap$cp.get(str2);
            if (obj != null) {
                notificationSubscriptionType = obj;
            }
            return notificationSubscriptionType;
        }

        private Companion() {
        }
    }

    static {
        int i;
        Companion = new Companion((DefaultConstructorMarker) null);
        NotificationSubscriptionType[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (NotificationSubscriptionType notificationSubscriptionType : values) {
            linkedHashMap.put(notificationSubscriptionType.key, notificationSubscriptionType);
        }
        map = linkedHashMap;
    }

    private NotificationSubscriptionType(String str) {
        this.key = str;
    }

    @JvmStatic
    public static final NotificationSubscriptionType fromValue(String str) {
        return Companion.fromValue(str);
    }

    public final String getKey() {
        return this.key;
    }

    public String forJsonPut() {
        return this.key;
    }
}
