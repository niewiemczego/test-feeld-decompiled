package zendesk.android;

import com.google.android.gms.actions.SearchIntents;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lzendesk/android/ZendeskCredentials;", "", "channelKey", "", "(Ljava/lang/String;)V", "getChannelKey", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "Builder", "Companion", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskCredentials.kt */
public final class ZendeskCredentials {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOG_TAG = "ZendeskCredentials";
    private final String channelKey;

    public /* synthetic */ ZendeskCredentials(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @JvmStatic
    public static final Builder builder(String str) {
        return Companion.builder(str);
    }

    private ZendeskCredentials(String str) {
        this.channelKey = str;
    }

    public final String getChannelKey() {
        return this.channelKey;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ZendeskCredentials) && Intrinsics.areEqual((Object) this.channelKey, (Object) ((ZendeskCredentials) obj).channelKey);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.channelKey});
    }

    public String toString() {
        return "ZendeskCredentials(channelKey='" + this.channelKey + "')";
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0004J\n\u0010\u000b\u001a\u00020\u0004*\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/android/ZendeskCredentials$Companion;", "", "()V", "LOG_TAG", "", "builder", "Lzendesk/android/ZendeskCredentials$Builder;", "channelKey", "fromQuery", "Lzendesk/android/ZendeskCredentials;", "query", "toQuery", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskCredentials.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder(String str) {
            Intrinsics.checkNotNullParameter(str, "channelKey");
            return new Builder(str);
        }

        public final String toQuery(ZendeskCredentials zendeskCredentials) {
            Intrinsics.checkNotNullParameter(zendeskCredentials, "<this>");
            return "channelKey=" + zendeskCredentials.getChannelKey();
        }

        public final ZendeskCredentials fromQuery(String str) {
            Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
            Collection arrayList = new ArrayList();
            Iterator it = StringsKt.split$default((CharSequence) str, new String[]{"&"}, false, 0, 6, (Object) null).iterator();
            while (true) {
                Pair pair = null;
                if (!it.hasNext()) {
                    break;
                }
                CharSequence charSequence = (String) it.next();
                if (StringsKt.contains$default(charSequence, (CharSequence) "=", false, 2, (Object) null)) {
                    List split$default = StringsKt.split$default(charSequence, new String[]{"="}, false, 2, 2, (Object) null);
                    pair = TuplesKt.to((String) split$default.get(0), (String) split$default.get(1));
                } else {
                    Pair pair2 = null;
                }
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            String str2 = (String) MapsKt.toMap((List) arrayList).get("channelKey");
            if (str2 != null) {
                return new ZendeskCredentials(str2, (DefaultConstructorMarker) null);
            }
            Void voidR = null;
            Logger.w(ZendeskCredentials.LOG_TAG, "Invalid query provided, unable to obtain an instance of MessagingCredentials.", new Object[0]);
            ZendeskCredentials zendeskCredentials = null;
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lzendesk/android/ZendeskCredentials$Builder;", "", "channelKey", "", "(Ljava/lang/String;)V", "build", "Lzendesk/android/ZendeskCredentials;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskCredentials.kt */
    public static final class Builder {
        private final String channelKey;

        public Builder(String str) {
            Intrinsics.checkNotNullParameter(str, "channelKey");
            this.channelKey = str;
        }

        public final ZendeskCredentials build() {
            return new ZendeskCredentials(this.channelKey, (DefaultConstructorMarker) null);
        }
    }
}
