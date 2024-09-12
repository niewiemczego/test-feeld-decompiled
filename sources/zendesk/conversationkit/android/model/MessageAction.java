package zendesk.conversationkit.android.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u000f\u0010\u0011\u0012\u0013\u0014\u0015B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0001\u0007\u0016\u0017\u0018\u0019\u001a\u001b\u001c¨\u0006\u001d"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction;", "", "type", "Lzendesk/conversationkit/android/model/MessageActionType;", "(Lzendesk/conversationkit/android/model/MessageActionType;)V", "id", "", "getId", "()Ljava/lang/String;", "metadata", "", "getMetadata", "()Ljava/util/Map;", "getType", "()Lzendesk/conversationkit/android/model/MessageActionType;", "Buy", "Link", "LocationRequest", "Postback", "Reply", "Share", "WebView", "Lzendesk/conversationkit/android/model/MessageAction$Buy;", "Lzendesk/conversationkit/android/model/MessageAction$Link;", "Lzendesk/conversationkit/android/model/MessageAction$LocationRequest;", "Lzendesk/conversationkit/android/model/MessageAction$Postback;", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/conversationkit/android/model/MessageAction$Share;", "Lzendesk/conversationkit/android/model/MessageAction$WebView;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageAction.kt */
public abstract class MessageAction {
    private final MessageActionType type;

    public /* synthetic */ MessageAction(MessageActionType messageActionType, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageActionType);
    }

    public abstract String getId();

    public abstract Map<String, Object> getMetadata();

    private MessageAction(MessageActionType messageActionType) {
        this.type = messageActionType;
    }

    public final MessageActionType getType() {
        return this.type;
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J]\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$Buy;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "uri", "amount", "", "currency", "state", "Lzendesk/conversationkit/android/model/MessageActionBuyState;", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lzendesk/conversationkit/android/model/MessageActionBuyState;)V", "getAmount", "()J", "getCurrency", "()Ljava/lang/String;", "getId", "getMetadata", "()Ljava/util/Map;", "getState", "()Lzendesk/conversationkit/android/model/MessageActionBuyState;", "getText", "getUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class Buy extends MessageAction {
        private final long amount;
        private final String currency;
        private final String id;
        private final Map<String, Object> metadata;
        private final MessageActionBuyState state;
        private final String text;
        private final String uri;

        public static /* synthetic */ Buy copy$default(Buy buy, String str, Map map, String str2, String str3, long j, String str4, MessageActionBuyState messageActionBuyState, int i, Object obj) {
            Buy buy2 = buy;
            return buy.copy((i & 1) != 0 ? buy.getId() : str, (i & 2) != 0 ? buy.getMetadata() : map, (i & 4) != 0 ? buy2.text : str2, (i & 8) != 0 ? buy2.uri : str3, (i & 16) != 0 ? buy2.amount : j, (i & 32) != 0 ? buy2.currency : str4, (i & 64) != 0 ? buy2.state : messageActionBuyState);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final String component4() {
            return this.uri;
        }

        public final long component5() {
            return this.amount;
        }

        public final String component6() {
            return this.currency;
        }

        public final MessageActionBuyState component7() {
            return this.state;
        }

        public final Buy copy(String str, Map<String, ? extends Object> map, String str2, String str3, long j, String str4, MessageActionBuyState messageActionBuyState) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            String str5 = str4;
            Intrinsics.checkNotNullParameter(str5, FirebaseAnalytics.Param.CURRENCY);
            MessageActionBuyState messageActionBuyState2 = messageActionBuyState;
            Intrinsics.checkNotNullParameter(messageActionBuyState2, "state");
            return new Buy(str, map, str2, str3, j, str5, messageActionBuyState2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Buy)) {
                return false;
            }
            Buy buy = (Buy) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) buy.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) buy.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) buy.text) && Intrinsics.areEqual((Object) this.uri, (Object) buy.uri) && this.amount == buy.amount && Intrinsics.areEqual((Object) this.currency, (Object) buy.currency) && this.state == buy.state;
        }

        public int hashCode() {
            return (((((((((((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode()) * 31) + this.uri.hashCode()) * 31) + Long.hashCode(this.amount)) * 31) + this.currency.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "Buy(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ", uri=" + this.uri + ", amount=" + this.amount + ", currency=" + this.currency + ", state=" + this.state + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        public final String getUri() {
            return this.uri;
        }

        public final long getAmount() {
            return this.amount;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final MessageActionBuyState getState() {
            return this.state;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Buy(String str, Map<String, ? extends Object> map, String str2, String str3, long j, String str4, MessageActionBuyState messageActionBuyState) {
            super(MessageActionType.BUY, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            Intrinsics.checkNotNullParameter(str4, FirebaseAnalytics.Param.CURRENCY);
            Intrinsics.checkNotNullParameter(messageActionBuyState, "state");
            this.id = str;
            this.metadata = map;
            this.text = str2;
            this.uri = str3;
            this.amount = j;
            this.currency = str4;
            this.state = messageActionBuyState;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\nHÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001f"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$Link;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "uri", "default", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Z)V", "getDefault", "()Z", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getText", "getUri", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class Link extends MessageAction {

        /* renamed from: default  reason: not valid java name */
        private final boolean f9default;
        private final String id;
        private final Map<String, Object> metadata;
        private final String text;
        private final String uri;

        public static /* synthetic */ Link copy$default(Link link, String str, Map<String, Object> map, String str2, String str3, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = link.getId();
            }
            if ((i & 2) != 0) {
                map = link.getMetadata();
            }
            Map<String, Object> map2 = map;
            if ((i & 4) != 0) {
                str2 = link.text;
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                str3 = link.uri;
            }
            String str5 = str3;
            if ((i & 16) != 0) {
                z = link.f9default;
            }
            return link.copy(str, map2, str4, str5, z);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final String component4() {
            return this.uri;
        }

        public final boolean component5() {
            return this.f9default;
        }

        public final Link copy(String str, Map<String, ? extends Object> map, String str2, String str3, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            return new Link(str, map, str2, str3, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) link.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) link.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) link.text) && Intrinsics.areEqual((Object) this.uri, (Object) link.uri) && this.f9default == link.f9default;
        }

        public int hashCode() {
            int hashCode = ((((((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode()) * 31) + this.uri.hashCode()) * 31;
            boolean z = this.f9default;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Link(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ", uri=" + this.uri + ", default=" + this.f9default + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        public final String getUri() {
            return this.uri;
        }

        public final boolean getDefault() {
            return this.f9default;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Link(String str, Map<String, ? extends Object> map, String str2, String str3, boolean z) {
            super(MessageActionType.LINK, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            this.id = str;
            this.metadata = map;
            this.text = str2;
            this.uri = str3;
            this.f9default = z;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$LocationRequest;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getText", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class LocationRequest extends MessageAction {
        private final String id;
        private final Map<String, Object> metadata;
        private final String text;

        public static /* synthetic */ LocationRequest copy$default(LocationRequest locationRequest, String str, Map<String, Object> map, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = locationRequest.getId();
            }
            if ((i & 2) != 0) {
                map = locationRequest.getMetadata();
            }
            if ((i & 4) != 0) {
                str2 = locationRequest.text;
            }
            return locationRequest.copy(str, map, str2);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final LocationRequest copy(String str, Map<String, ? extends Object> map, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            return new LocationRequest(str, map, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocationRequest)) {
                return false;
            }
            LocationRequest locationRequest = (LocationRequest) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) locationRequest.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) locationRequest.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) locationRequest.text);
        }

        public int hashCode() {
            return (((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "LocationRequest(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LocationRequest(String str, Map<String, ? extends Object> map, String str2) {
            super(MessageActionType.LOCATION_REQUEST, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            this.id = str;
            this.metadata = map;
            this.text = str2;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$Postback;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "payload", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "getPayload", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class Postback extends MessageAction {
        private final String id;
        private final Map<String, Object> metadata;
        private final String payload;
        private final String text;

        public static /* synthetic */ Postback copy$default(Postback postback, String str, Map<String, Object> map, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = postback.getId();
            }
            if ((i & 2) != 0) {
                map = postback.getMetadata();
            }
            if ((i & 4) != 0) {
                str2 = postback.text;
            }
            if ((i & 8) != 0) {
                str3 = postback.payload;
            }
            return postback.copy(str, map, str2, str3);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final String component4() {
            return this.payload;
        }

        public final Postback copy(String str, Map<String, ? extends Object> map, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "payload");
            return new Postback(str, map, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Postback)) {
                return false;
            }
            Postback postback = (Postback) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) postback.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) postback.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) postback.text) && Intrinsics.areEqual((Object) this.payload, (Object) postback.payload);
        }

        public int hashCode() {
            return (((((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode()) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "Postback(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ", payload=" + this.payload + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        public final String getPayload() {
            return this.payload;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Postback(String str, Map<String, ? extends Object> map, String str2, String str3) {
            super(MessageActionType.POSTBACK, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "payload");
            this.id = str;
            this.metadata = map;
            this.text = str2;
            this.payload = str3;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JK\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001e"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$Reply;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "iconUrl", "payload", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIconUrl", "()Ljava/lang/String;", "getId", "getMetadata", "()Ljava/util/Map;", "getPayload", "getText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class Reply extends MessageAction {
        private final String iconUrl;
        private final String id;
        private final Map<String, Object> metadata;
        private final String payload;
        private final String text;

        public static /* synthetic */ Reply copy$default(Reply reply, String str, Map<String, Object> map, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = reply.getId();
            }
            if ((i & 2) != 0) {
                map = reply.getMetadata();
            }
            Map<String, Object> map2 = map;
            if ((i & 4) != 0) {
                str2 = reply.text;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = reply.iconUrl;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = reply.payload;
            }
            return reply.copy(str, map2, str5, str6, str4);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final String component4() {
            return this.iconUrl;
        }

        public final String component5() {
            return this.payload;
        }

        public final Reply copy(String str, Map<String, ? extends Object> map, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str4, "payload");
            return new Reply(str, map, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Reply)) {
                return false;
            }
            Reply reply = (Reply) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) reply.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) reply.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) reply.text) && Intrinsics.areEqual((Object) this.iconUrl, (Object) reply.iconUrl) && Intrinsics.areEqual((Object) this.payload, (Object) reply.payload);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode()) * 31;
            String str = this.iconUrl;
            if (str != null) {
                i = str.hashCode();
            }
            return ((hashCode + i) * 31) + this.payload.hashCode();
        }

        public String toString() {
            return "Reply(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ", iconUrl=" + this.iconUrl + ", payload=" + this.payload + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        public final String getIconUrl() {
            return this.iconUrl;
        }

        public final String getPayload() {
            return this.payload;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Reply(String str, Map<String, ? extends Object> map, String str2, String str3, String str4) {
            super(MessageActionType.REPLY, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str4, "payload");
            this.id = str;
            this.metadata = map;
            this.text = str2;
            this.iconUrl = str3;
            this.payload = str4;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$Share;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "getMetadata", "()Ljava/util/Map;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class Share extends MessageAction {
        private final String id;
        private final Map<String, Object> metadata;

        public static /* synthetic */ Share copy$default(Share share, String str, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = share.getId();
            }
            if ((i & 2) != 0) {
                map = share.getMetadata();
            }
            return share.copy(str, map);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final Share copy(String str, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(str, "id");
            return new Share(str, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Share)) {
                return false;
            }
            Share share = (Share) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) share.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) share.getMetadata());
        }

        public int hashCode() {
            return (getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode());
        }

        public String toString() {
            return "Share(id=" + getId() + ", metadata=" + getMetadata() + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Share(String str, Map<String, ? extends Object> map) {
            super(MessageActionType.SHARE, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            this.id = str;
            this.metadata = map;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JS\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Lzendesk/conversationkit/android/model/MessageAction$WebView;", "Lzendesk/conversationkit/android/model/MessageAction;", "id", "", "metadata", "", "", "text", "uri", "fallback", "default", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDefault", "()Z", "getFallback", "()Ljava/lang/String;", "getId", "getMetadata", "()Ljava/util/Map;", "getText", "getUri", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public static final class WebView extends MessageAction {

        /* renamed from: default  reason: not valid java name */
        private final boolean f10default;
        private final String fallback;
        private final String id;
        private final Map<String, Object> metadata;
        private final String text;
        private final String uri;

        public static /* synthetic */ WebView copy$default(WebView webView, String str, Map<String, Object> map, String str2, String str3, String str4, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = webView.getId();
            }
            if ((i & 2) != 0) {
                map = webView.getMetadata();
            }
            Map<String, Object> map2 = map;
            if ((i & 4) != 0) {
                str2 = webView.text;
            }
            String str5 = str2;
            if ((i & 8) != 0) {
                str3 = webView.uri;
            }
            String str6 = str3;
            if ((i & 16) != 0) {
                str4 = webView.fallback;
            }
            String str7 = str4;
            if ((i & 32) != 0) {
                z = webView.f10default;
            }
            return webView.copy(str, map2, str5, str6, str7, z);
        }

        public final String component1() {
            return getId();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return this.text;
        }

        public final String component4() {
            return this.uri;
        }

        public final String component5() {
            return this.fallback;
        }

        public final boolean component6() {
            return this.f10default;
        }

        public final WebView copy(String str, Map<String, ? extends Object> map, String str2, String str3, String str4, boolean z) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            Intrinsics.checkNotNullParameter(str4, "fallback");
            return new WebView(str, map, str2, str3, str4, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebView)) {
                return false;
            }
            WebView webView = (WebView) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) webView.getId()) && Intrinsics.areEqual((Object) getMetadata(), (Object) webView.getMetadata()) && Intrinsics.areEqual((Object) this.text, (Object) webView.text) && Intrinsics.areEqual((Object) this.uri, (Object) webView.uri) && Intrinsics.areEqual((Object) this.fallback, (Object) webView.fallback) && this.f10default == webView.f10default;
        }

        public int hashCode() {
            int hashCode = ((((((((getId().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31) + this.text.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.fallback.hashCode()) * 31;
            boolean z = this.f10default;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "WebView(id=" + getId() + ", metadata=" + getMetadata() + ", text=" + this.text + ", uri=" + this.uri + ", fallback=" + this.fallback + ", default=" + this.f10default + ')';
        }

        public String getId() {
            return this.id;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public final String getText() {
            return this.text;
        }

        public final String getUri() {
            return this.uri;
        }

        public final String getFallback() {
            return this.fallback;
        }

        public final boolean getDefault() {
            return this.f10default;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WebView(String str, Map<String, ? extends Object> map, String str2, String str3, String str4, boolean z) {
            super(MessageActionType.WEBVIEW, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(str3, "uri");
            Intrinsics.checkNotNullParameter(str4, "fallback");
            this.id = str;
            this.metadata = map;
            this.text = str2;
            this.uri = str3;
            this.fallback = str4;
            this.f10default = z;
        }
    }
}
