package bo.app;

import com.braze.models.IPutIntoJson;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

public enum h1 implements IPutIntoJson {
    LOCATION_RECORDED("lr"),
    CUSTOM_EVENT("ce"),
    PURCHASE("p"),
    PUSH_STORY_PAGE_CLICK("cic"),
    PUSH_CLICKED("pc"),
    PUSH_ACTION_BUTTON_CLICKED("ca"),
    INTERNAL(ContextChain.TAG_INFRA),
    INTERNAL_ERROR("ie"),
    NEWS_FEED_CARD_IMPRESSION("ci"),
    NEWS_FEED_CARD_CLICK("cc"),
    GEOFENCE("g"),
    CONTENT_CARDS_CLICK("ccc"),
    CONTENT_CARDS_IMPRESSION("cci"),
    CONTENT_CARDS_CONTROL_IMPRESSION("ccic"),
    CONTENT_CARDS_DISMISS("ccd"),
    INCREMENT("inc"),
    ADD_TO_CUSTOM_ATTRIBUTE_ARRAY("add"),
    REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY("rem"),
    SET_CUSTOM_ATTRIBUTE_ARRAY("set"),
    INAPP_MESSAGE_IMPRESSION(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK),
    INAPP_MESSAGE_CONTROL_IMPRESSION("iec"),
    INAPP_MESSAGE_CLICK("sc"),
    INAPP_MESSAGE_BUTTON_CLICK("sbc"),
    USER_ALIAS("uae"),
    SESSION_START("ss"),
    SESSION_END("se"),
    TEST_TYPE(TtmlNode.TAG_TT),
    LOCATION_CUSTOM_ATTRIBUTE_ADD("lcaa"),
    LOCATION_CUSTOM_ATTRIBUTE_REMOVE("lcar"),
    NESTED_CUSTOM_ATTRIBUTE_MERGE("ncam"),
    SUBSCRIPTION_GROUP_UPDATE("sgu"),
    FEATURE_FLAG_IMPRESSION_EVENT("ffi"),
    PUSH_DELIVERY_EVENT("pde"),
    UNKNOWN("");
    
    public static final a c = null;
    /* access modifiers changed from: private */
    public static final Map d = null;
    private final String b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final h1 a(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            Object obj = h1.d.get(str);
            if (obj == null) {
                obj = h1.UNKNOWN;
            }
            return (h1) obj;
        }

        private a() {
        }
    }

    static {
        int i;
        c = new a((DefaultConstructorMarker) null);
        h1[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (h1 h1Var : values) {
            linkedHashMap.put(h1Var.b, h1Var);
        }
        d = linkedHashMap;
    }

    private h1(String str) {
        this.b = str;
    }

    /* renamed from: w */
    public String forJsonPut() {
        return this.b;
    }
}
