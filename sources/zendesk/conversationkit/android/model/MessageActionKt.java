package zendesk.conversationkit.android.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.internal.rest.model.MessageActionDto;
import zendesk.conversationkit.android.model.MessageAction;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toAction", "Lzendesk/conversationkit/android/model/MessageAction;", "Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "zendesk.conversationkit_conversationkit-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageAction.kt */
public final class MessageActionKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageAction.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MessageActionType.values().length];
            iArr[MessageActionType.BUY.ordinal()] = 1;
            iArr[MessageActionType.LINK.ordinal()] = 2;
            iArr[MessageActionType.LOCATION_REQUEST.ordinal()] = 3;
            iArr[MessageActionType.POSTBACK.ordinal()] = 4;
            iArr[MessageActionType.REPLY.ordinal()] = 5;
            iArr[MessageActionType.SHARE.ordinal()] = 6;
            iArr[MessageActionType.WEBVIEW.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final MessageAction toAction(MessageActionDto messageActionDto) {
        Intrinsics.checkNotNullParameter(messageActionDto, "<this>");
        MessageActionType findByValue = MessageActionType.Companion.findByValue(messageActionDto.getType());
        boolean z = false;
        String str = "";
        switch (findByValue == null ? -1 : WhenMappings.$EnumSwitchMapping$0[findByValue.ordinal()]) {
            case -1:
                return null;
            case 1:
                String id = messageActionDto.getId();
                Map<String, Object> metadata = messageActionDto.getMetadata();
                String text = messageActionDto.getText();
                String str2 = text == null ? str : text;
                String uri = messageActionDto.getUri();
                String str3 = uri == null ? str : uri;
                Long amount = messageActionDto.getAmount();
                long longValue = amount != null ? amount.longValue() : 0;
                String currency = messageActionDto.getCurrency();
                return new MessageAction.Buy(id, metadata, str2, str3, longValue, currency == null ? str : currency, Intrinsics.areEqual((Object) messageActionDto.getState(), (Object) "paid") ? MessageActionBuyState.PAID : MessageActionBuyState.OFFERED);
            case 2:
                String id2 = messageActionDto.getId();
                Map<String, Object> metadata2 = messageActionDto.getMetadata();
                String text2 = messageActionDto.getText();
                if (text2 == null) {
                    text2 = str;
                }
                String uri2 = messageActionDto.getUri();
                if (uri2 == null) {
                    uri2 = str;
                }
                Boolean bool = messageActionDto.getDefault();
                if (bool != null) {
                    z = bool.booleanValue();
                }
                return new MessageAction.Link(id2, metadata2, text2, uri2, z);
            case 3:
                String id3 = messageActionDto.getId();
                Map<String, Object> metadata3 = messageActionDto.getMetadata();
                String text3 = messageActionDto.getText();
                if (text3 != null) {
                    str = text3;
                }
                return new MessageAction.LocationRequest(id3, metadata3, str);
            case 4:
                String id4 = messageActionDto.getId();
                Map<String, Object> metadata4 = messageActionDto.getMetadata();
                String text4 = messageActionDto.getText();
                if (text4 == null) {
                    text4 = str;
                }
                String payload = messageActionDto.getPayload();
                if (payload != null) {
                    str = payload;
                }
                return new MessageAction.Postback(id4, metadata4, text4, str);
            case 5:
                String id5 = messageActionDto.getId();
                Map<String, Object> metadata5 = messageActionDto.getMetadata();
                String text5 = messageActionDto.getText();
                String str4 = text5 == null ? str : text5;
                String iconUrl = messageActionDto.getIconUrl();
                String payload2 = messageActionDto.getPayload();
                if (payload2 == null) {
                    payload2 = str;
                }
                return new MessageAction.Reply(id5, metadata5, str4, iconUrl, payload2);
            case 6:
                return new MessageAction.Share(messageActionDto.getId(), messageActionDto.getMetadata());
            case 7:
                String id6 = messageActionDto.getId();
                Map<String, Object> metadata6 = messageActionDto.getMetadata();
                String text6 = messageActionDto.getText();
                String str5 = text6 == null ? str : text6;
                String uri3 = messageActionDto.getUri();
                String str6 = uri3 == null ? str : uri3;
                String fallback = messageActionDto.getFallback();
                String str7 = fallback == null ? str : fallback;
                Boolean bool2 = messageActionDto.getDefault();
                if (bool2 != null) {
                    z = bool2.booleanValue();
                }
                return new MessageAction.WebView(id6, metadata6, str5, str6, str7, z);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
