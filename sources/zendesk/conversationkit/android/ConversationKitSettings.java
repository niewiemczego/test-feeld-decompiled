package zendesk.conversationkit.android;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0003\r\u000e\u000fB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitSettings;", "", "integrationId", "", "region", "Lzendesk/conversationkit/android/ConversationKitSettings$Region;", "baseUrl", "(Ljava/lang/String;Lzendesk/conversationkit/android/ConversationKitSettings$Region;Ljava/lang/String;)V", "getBaseUrl$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "getIntegrationId", "getRegion", "()Lzendesk/conversationkit/android/ConversationKitSettings$Region;", "Builder", "Companion", "Region", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationKitSettings.kt */
public final class ConversationKitSettings {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String baseUrl;
    private final String integrationId;
    private final Region region;

    public /* synthetic */ ConversationKitSettings(String str, Region region2, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, region2, str2);
    }

    @JvmStatic
    public static final Builder builder(String str) {
        return Companion.builder(str);
    }

    private ConversationKitSettings(String str, Region region2, String str2) {
        this.integrationId = str;
        this.region = region2;
        this.baseUrl = str2;
    }

    public final String getIntegrationId() {
        return this.integrationId;
    }

    public final Region getRegion() {
        return this.region;
    }

    public final String getBaseUrl$zendesk_conversationkit_conversationkit_android() {
        return this.baseUrl;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitSettings$Builder;", "", "integrationId", "", "(Ljava/lang/String;)V", "baseUrl", "region", "Lzendesk/conversationkit/android/ConversationKitSettings$Region;", "build", "Lzendesk/conversationkit/android/ConversationKitSettings;", "withBaseUrl", "withRegion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitSettings.kt */
    public static final class Builder {
        private String baseUrl;
        private final String integrationId;
        private Region region = Region.US;

        public Builder(String str) {
            Intrinsics.checkNotNullParameter(str, "integrationId");
            this.integrationId = str;
        }

        public final Builder withRegion(Region region2) {
            Intrinsics.checkNotNullParameter(region2, "region");
            Builder builder = this;
            this.region = region2;
            return this;
        }

        public final Builder withBaseUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "baseUrl");
            Builder builder = this;
            this.baseUrl = str;
            return this;
        }

        public final ConversationKitSettings build() {
            String str = this.integrationId;
            Region region2 = this.region;
            String str2 = this.baseUrl;
            if (str2 == null) {
                str2 = "";
            }
            return new ConversationKitSettings(str, region2, str2, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitSettings$Region;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "US", "EU", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitSettings.kt */
    public enum Region {
        US(""),
        EU(".eu-1");
        
        private final String value;

        private Region(String str) {
            this.value = str;
        }

        public final String getValue$zendesk_conversationkit_conversationkit_android() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/ConversationKitSettings$Companion;", "", "()V", "builder", "Lzendesk/conversationkit/android/ConversationKitSettings$Builder;", "integrationId", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConversationKitSettings.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder(String str) {
            Intrinsics.checkNotNullParameter(str, "integrationId");
            return new Builder(str);
        }
    }
}
