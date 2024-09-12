package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.ConversationType;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/CreateConversationRequestDto;", "", "type", "Lzendesk/conversationkit/android/model/ConversationType;", "intent", "Lzendesk/conversationkit/android/internal/rest/model/Intent;", "client", "Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "(Lzendesk/conversationkit/android/model/ConversationType;Lzendesk/conversationkit/android/internal/rest/model/Intent;Lzendesk/conversationkit/android/internal/rest/model/ClientDto;)V", "getClient", "()Lzendesk/conversationkit/android/internal/rest/model/ClientDto;", "getIntent", "()Lzendesk/conversationkit/android/internal/rest/model/Intent;", "getType", "()Lzendesk/conversationkit/android/model/ConversationType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CreateConversationRequestDto.kt */
public final class CreateConversationRequestDto {
    private final ClientDto client;
    private final Intent intent;
    private final ConversationType type;

    public static /* synthetic */ CreateConversationRequestDto copy$default(CreateConversationRequestDto createConversationRequestDto, ConversationType conversationType, Intent intent2, ClientDto clientDto, int i, Object obj) {
        if ((i & 1) != 0) {
            conversationType = createConversationRequestDto.type;
        }
        if ((i & 2) != 0) {
            intent2 = createConversationRequestDto.intent;
        }
        if ((i & 4) != 0) {
            clientDto = createConversationRequestDto.client;
        }
        return createConversationRequestDto.copy(conversationType, intent2, clientDto);
    }

    public final ConversationType component1() {
        return this.type;
    }

    public final Intent component2() {
        return this.intent;
    }

    public final ClientDto component3() {
        return this.client;
    }

    public final CreateConversationRequestDto copy(ConversationType conversationType, Intent intent2, ClientDto clientDto) {
        Intrinsics.checkNotNullParameter(conversationType, "type");
        Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullParameter(clientDto, "client");
        return new CreateConversationRequestDto(conversationType, intent2, clientDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateConversationRequestDto)) {
            return false;
        }
        CreateConversationRequestDto createConversationRequestDto = (CreateConversationRequestDto) obj;
        return this.type == createConversationRequestDto.type && this.intent == createConversationRequestDto.intent && Intrinsics.areEqual((Object) this.client, (Object) createConversationRequestDto.client);
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.intent.hashCode()) * 31) + this.client.hashCode();
    }

    public String toString() {
        return "CreateConversationRequestDto(type=" + this.type + ", intent=" + this.intent + ", client=" + this.client + ')';
    }

    public CreateConversationRequestDto(ConversationType conversationType, Intent intent2, ClientDto clientDto) {
        Intrinsics.checkNotNullParameter(conversationType, "type");
        Intrinsics.checkNotNullParameter(intent2, SDKConstants.PARAM_INTENT);
        Intrinsics.checkNotNullParameter(clientDto, "client");
        this.type = conversationType;
        this.intent = intent2;
        this.client = clientDto;
    }

    public final ConversationType getType() {
        return this.type;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final ClientDto getClient() {
        return this.client;
    }
}
