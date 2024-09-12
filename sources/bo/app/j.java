package bo.app;

import bo.app.h1;
import com.appsflyer.AppsFlyerProperties;
import com.braze.Constants;
import com.braze.models.FeatureFlag;
import com.braze.models.IBrazeLocation;
import com.braze.models.inappmessage.MessageButton;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

public class j implements x1 {
    public static final a h = new a((DefaultConstructorMarker) null);
    static final /* synthetic */ KProperty[] i;
    private final h1 b;
    private final JSONObject c;
    private final double d;
    private final String e;
    private final g3 f;
    private final g3 g;

    public static final class a {

        /* renamed from: bo.app.j$a$a  reason: collision with other inner class name */
        static final class C0013a extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0013a(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b).put("value", (Object) this.c);
                h1 h1Var = h1.ADD_TO_CUSTOM_ATTRIBUTE_ARRAY;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class a0 extends Lambda implements Function0 {
            final /* synthetic */ long b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a0(long j) {
                super(0);
                this.b = j;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(Constants.BRAZE_PUSH_NOTIFICATION_SOUND_DEFAULT_VALUE, this.b);
                h1 h1Var = h1.SESSION_END;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject(this.b);
                String string = jSONObject.getString("name");
                h1.a aVar = h1.c;
                Intrinsics.checkNotNullExpressionValue(string, "eventTypeString");
                h1 a = aVar.a(string);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                double d = jSONObject.getDouble("time");
                String optionalString = JsonUtils.getOptionalString(jSONObject, "user_id");
                String optionalString2 = JsonUtils.getOptionalString(jSONObject, "session_id");
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "data");
                return new j(a, jSONObject2, d, this.c, optionalString, optionalString2);
            }
        }

        static final class b0 extends Lambda implements Function0 {
            final /* synthetic */ p5 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b0(p5 p5Var) {
                super(0);
                this.b = p5Var;
            }

            /* renamed from: a */
            public final x1 invoke() {
                j jVar = new j(h1.SESSION_START, (JSONObject) null, 0.0d, (String) null, 14, (DefaultConstructorMarker) null);
                jVar.a(this.b);
                return jVar;
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.CONTENT_CARDS_CLICK, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class c0 extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String[] c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c0(String str, String[] strArr) {
                super(0);
                this.b = str;
                this.c = strArr;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", (Object) this.b);
                String[] strArr = this.c;
                if (strArr == null) {
                    jSONObject.put("value", JSONObject.NULL);
                } else {
                    jSONObject.put("value", (Object) JsonUtils.constructJsonArray((T[]) strArr));
                }
                return new j(h1.SET_CUSTOM_ATTRIBUTE_ARRAY, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class d extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.CONTENT_CARDS_CONTROL_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class d0 extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ y5 c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d0(String str, y5 y5Var) {
                super(0);
                this.b = str;
                this.c = y5Var;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(FirebaseAnalytics.Param.GROUP_ID, (Object) this.b).put("status", (Object) this.c.forJsonPut());
                h1 h1Var = h1.SUBSCRIPTION_GROUP_UPDATE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class e extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.CONTENT_CARDS_DISMISS, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class e0 extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e0(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(Constants.BRAZE_PUSH_CONTENT_KEY, (Object) this.b).put("l", (Object) this.c);
                h1 h1Var = h1.USER_ALIAS;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class f extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.CONTENT_CARDS_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class f0 extends Lambda implements Function0 {
            public static final f0 b = new f0();

            f0() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to create event";
            }
        }

        static final class g extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ BrazeProperties c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(String str, BrazeProperties brazeProperties) {
                super(0);
                this.b = str;
                this.c = brazeProperties;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID, (Object) this.b);
                BrazeProperties brazeProperties = this.c;
                if (brazeProperties != null && brazeProperties.getSize() > 0) {
                    put.put("p", (Object) this.c.forJsonPut());
                }
                h1 h1Var = h1.CUSTOM_EVENT;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class h extends Lambda implements Function0 {
            final /* synthetic */ Throwable b;
            final /* synthetic */ p5 c;
            final /* synthetic */ boolean d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(Throwable th, p5 p5Var, boolean z) {
                super(0);
                this.b = th;
                this.c = p5Var;
                this.d = z;
            }

            /* renamed from: a */
            public final x1 invoke() {
                StringBuilder append = new StringBuilder().append("\n                original_sdk_version: 29.0.1\n                exception_class: ").append(this.b.getClass().getName()).append("\n                available_cpus: ").append(Runtime.getRuntime().availableProcessors()).append("\n                ");
                p5 p5Var = this.c;
                JSONObject put = new JSONObject().put("e", (Object) StringsKt.trimIndent(append.append(p5Var != null ? "session_id: " + p5Var : null).append("\n                ").append(j.h.a(this.b)).append("\n            ").toString()));
                if (!this.d) {
                    put.put("nop", true);
                }
                h1 h1Var = h1.INTERNAL_ERROR;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class i extends Lambda implements Function0 {
            final /* synthetic */ FeatureFlag b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            i(FeatureFlag featureFlag) {
                super(0);
                this.b = featureFlag;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("fid", (Object) this.b.getId()).put(FeatureFlag.TRACKING_STRING, (Object) this.b.getTrackingString$android_sdk_base_release());
                h1 h1Var = h1.FEATURE_FLAG_IMPRESSION_EVENT;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        /* renamed from: bo.app.j$a$j  reason: collision with other inner class name */
        static final class C0014j extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0014j(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.NEWS_FEED_CARD_CLICK, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class k extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            k(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) this.b);
                jSONObject.put("ids", (Object) jSONArray);
                return new j(h1.NEWS_FEED_CARD_IMPRESSION, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class l extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            l(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("geo_id", (Object) this.b).put("event_type", (Object) this.c);
                h1 h1Var = h1.GEOFENCE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class m extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            m(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.INAPP_MESSAGE_BUTTON_CLICK, j.h.h(this.b, this.c), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class n extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ MessageButton c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            n(String str, MessageButton messageButton) {
                super(0);
                this.b = str;
                this.c = messageButton;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.INAPP_MESSAGE_BUTTON_CLICK, j.h.h(this.b, this.c.getStringId()), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class o extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            o(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.INAPP_MESSAGE_CLICK, a.a(j.h, this.b, (String) null, 2, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class p extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            p(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.INAPP_MESSAGE_CONTROL_IMPRESSION, a.a(j.h, this.b, (String) null, 2, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class q extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            q(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.INAPP_MESSAGE_IMPRESSION, a.a(j.h, this.b, (String) null, 2, (Object) null), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class r extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ int c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            r(String str, int i) {
                super(0);
                this.b = str;
                this.c = i;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b).put("value", this.c);
                h1 h1Var = h1.INCREMENT;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class s extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            s(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(Constants.BRAZE_PUSH_CUSTOM_NOTIFICATION_ID, (Object) this.b);
                h1 h1Var = h1.INTERNAL;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class t extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ double c;
            final /* synthetic */ double d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            t(String str, double d2, double d3) {
                super(0);
                this.b = str;
                this.c = d2;
                this.d = d3;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b).put(IBrazeLocation.LATITUDE, this.c).put(IBrazeLocation.LONGITUDE, this.d);
                h1 h1Var = h1.LOCATION_CUSTOM_ATTRIBUTE_ADD;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class u extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            u(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b);
                h1 h1Var = h1.LOCATION_CUSTOM_ATTRIBUTE_REMOVE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class v extends Lambda implements Function0 {
            final /* synthetic */ IBrazeLocation b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            v(IBrazeLocation iBrazeLocation) {
                super(0);
                this.b = iBrazeLocation;
            }

            /* renamed from: a */
            public final x1 invoke() {
                return new j(h1.LOCATION_RECORDED, (JSONObject) this.b.forJsonPut(), 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class w extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ JSONObject c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            w(String str, JSONObject jSONObject) {
                super(0);
                this.b = str;
                this.c = jSONObject;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b).put("value", (Object) this.c);
                h1 h1Var = h1.NESTED_CUSTOM_ATTRIBUTE_MERGE;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class x extends Lambda implements Function0 {
            final /* synthetic */ BrazeProperties b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ BigDecimal e;
            final /* synthetic */ int f;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            x(BrazeProperties brazeProperties, String str, String str2, BigDecimal bigDecimal, int i) {
                super(0);
                this.b = brazeProperties;
                this.c = str;
                this.d = str2;
                this.e = bigDecimal;
                this.f = i;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject jSONObject = new JSONObject();
                String str = this.c;
                String str2 = this.d;
                BigDecimal bigDecimal = this.e;
                int i = this.f;
                jSONObject.put("pid", (Object) str);
                jSONObject.put("c", (Object) str2);
                jSONObject.put("p", s3.a(bigDecimal).doubleValue());
                jSONObject.put("q", i);
                BrazeProperties brazeProperties = this.b;
                if (brazeProperties != null && brazeProperties.getSize() > 0) {
                    jSONObject.put("pr", (Object) this.b.forJsonPut());
                }
                return new j(h1.PURCHASE, jSONObject, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class y extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            y(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put(Constants.BRAZE_PUSH_CAMPAIGN_ID_KEY, (Object) this.b).put(Constants.BRAZE_PUSH_CONTENT_KEY, (Object) this.c);
                h1 h1Var = h1.PUSH_STORY_PAGE_CLICK;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        static final class z extends Lambda implements Function0 {
            final /* synthetic */ String b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            z(String str, String str2) {
                super(0);
                this.b = str;
                this.c = str2;
            }

            /* renamed from: a */
            public final x1 invoke() {
                JSONObject put = new JSONObject().put("key", (Object) this.b).put("value", (Object) this.c);
                h1 h1Var = h1.REMOVE_FROM_CUSTOM_ATTRIBUTE_ARRAY;
                Intrinsics.checkNotNullExpressionValue(put, "eventData");
                return new j(h1Var, put, 0.0d, (String) null, 12, (DefaultConstructorMarker) null);
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final x1 a(String str, BrazeProperties brazeProperties) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            return a((Function0) new g(str, brazeProperties));
        }

        public final x1 b(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new d(str));
        }

        public final x1 c(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new e(str));
        }

        public final x1 d(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new f(str));
        }

        public final x1 e(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new C0014j(str));
        }

        public final x1 f(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new k(str));
        }

        public final x1 g(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "alias");
            Intrinsics.checkNotNullParameter(str2, "label");
            return a((Function0) new e0(str, str2));
        }

        public final x1 h(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0) new p(str));
        }

        public final x1 i(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0) new q(str));
        }

        public final x1 j(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return a((Function0) new s(str));
        }

        public final x1 k(String str) {
            return a((Function0) new u(str));
        }

        private a() {
        }

        public final x1 a(String str, String str2, BigDecimal bigDecimal, int i2, BrazeProperties brazeProperties) {
            Intrinsics.checkNotNullParameter(str, "productId");
            Intrinsics.checkNotNullParameter(str2, AppsFlyerProperties.CURRENCY_CODE);
            Intrinsics.checkNotNullParameter(bigDecimal, FirebaseAnalytics.Param.PRICE);
            return a((Function0) new x(brazeProperties, str, str2, bigDecimal, i2));
        }

        public final x1 b(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "serializedEvent");
            Intrinsics.checkNotNullParameter(str2, "uniqueIdentifier");
            return a((Function0) new b(str, str2));
        }

        public final x1 c(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "eventType");
            return a((Function0) new l(str, str2));
        }

        public final x1 d(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            Intrinsics.checkNotNullParameter(str2, "buttonId");
            return a((Function0) new m(str, str2));
        }

        public final x1 e(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "campaignId");
            Intrinsics.checkNotNullParameter(str2, "pageId");
            return a((Function0) new y(str, str2));
        }

        public final x1 f(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return a((Function0) new z(str, str2));
        }

        public final x1 g(String str) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            return a((Function0) new o(str));
        }

        public final JSONObject h(String str, String str2) {
            JSONObject jSONObject = new JSONObject();
            boolean z2 = false;
            if (!(str == null || str.length() == 0)) {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put((Object) str);
                jSONObject.put("trigger_ids", (Object) jSONArray);
            }
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            }
            if (!z2) {
                jSONObject.put("bid", (Object) str2);
            }
            return jSONObject;
        }

        public final x1 a(IBrazeLocation iBrazeLocation) {
            Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
            return a((Function0) new v(iBrazeLocation));
        }

        public final x1 a(Throwable th, p5 p5Var, boolean z2) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            return a((Function0) new h(th, p5Var, z2));
        }

        public final x1 a(String str) {
            Intrinsics.checkNotNullParameter(str, "cardId");
            return a((Function0) new c(str));
        }

        public final x1 a(String str, MessageButton messageButton) {
            Intrinsics.checkNotNullParameter(str, "triggerId");
            Intrinsics.checkNotNullParameter(messageButton, "messageButton");
            return a((Function0) new n(str, messageButton));
        }

        public final x1 a() {
            return j("feed_displayed");
        }

        public final x1 a(FeatureFlag featureFlag) {
            Intrinsics.checkNotNullParameter(featureFlag, "ff");
            return a((Function0) new i(featureFlag));
        }

        public final x1 a(String str, int i2) {
            Intrinsics.checkNotNullParameter(str, "customUserAttributeKey");
            return a((Function0) new r(str, i2));
        }

        public final x1 a(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            return a((Function0) new C0013a(str, str2));
        }

        public final x1 a(String str, String[] strArr) {
            Intrinsics.checkNotNullParameter(str, "key");
            return a((Function0) new c0(str, strArr));
        }

        public final x1 a(p5 p5Var) {
            Intrinsics.checkNotNullParameter(p5Var, "sessionId");
            return a((Function0) new b0(p5Var));
        }

        public final x1 a(long j) {
            return a((Function0) new a0(j));
        }

        public final x1 a(String str, double d2, double d3) {
            Intrinsics.checkNotNullParameter(str, "key");
            return a((Function0) new t(str, d2, d3));
        }

        public final x1 a(String str, JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            return a((Function0) new w(str, jSONObject));
        }

        public final x1 a(String str, y5 y5Var) {
            Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
            Intrinsics.checkNotNullParameter(y5Var, "subscriptionGroupStatus");
            return a((Function0) new d0(str, y5Var));
        }

        public final String a(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "throwable");
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            Intrinsics.checkNotNullExpressionValue(stringWriter2, "result.toString()");
            return StringsKt.take(stringWriter2, 5000);
        }

        public static /* synthetic */ JSONObject a(a aVar, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = null;
            }
            if ((i2 & 2) != 0) {
                str2 = null;
            }
            return aVar.h(str, str2);
        }

        private final x1 a(Function0 function0) {
            try {
                return (x1) function0.invoke();
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) f0.b);
                return null;
            }
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception creating Braze event json";
        }
    }

    static {
        Class<j> cls = j.class;
        i = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "userId", "getUserId()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "sessionId", "getSessionId()Lcom/braze/models/SessionId;", 0))};
    }

    public j(h1 h1Var, JSONObject jSONObject, double d2, String str) {
        Intrinsics.checkNotNullParameter(h1Var, "type");
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        Intrinsics.checkNotNullParameter(str, "uniqueIdentifier");
        this.b = h1Var;
        this.c = jSONObject;
        this.d = d2;
        this.e = str;
        this.f = new g3();
        this.g = new g3();
        if (h1Var == h1.UNKNOWN) {
            throw new IllegalArgumentException("Event type cannot be unknown.");
        }
    }

    public final h1 a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.areEqual((Object) getClass(), (Object) obj.getClass())) {
            return false;
        }
        return Intrinsics.areEqual((Object) t(), (Object) ((j) obj).t());
    }

    public int hashCode() {
        return t().hashCode();
    }

    public boolean m() {
        if (this.b != h1.INTERNAL_ERROR || !q().optBoolean("nop", false)) {
            return false;
        }
        return true;
    }

    public JSONObject q() {
        return this.c;
    }

    public final p5 s() {
        return (p5) this.g.getValue(this, i[1]);
    }

    public String t() {
        return this.e;
    }

    public String toString() {
        return f();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034 A[Catch:{ JSONException -> 0x004d }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[Catch:{ JSONException -> 0x004d }] */
    /* renamed from: u */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject forJsonPut() {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            java.lang.String r1 = "name"
            bo.app.h1 r2 = r5.b     // Catch:{ JSONException -> 0x004d }
            java.lang.String r2 = r2.forJsonPut()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r1 = "data"
            org.json.JSONObject r2 = r5.q()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r1 = "time"
            double r2 = r5.v()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r1, (double) r2)     // Catch:{ JSONException -> 0x004d }
            java.lang.String r1 = r5.w()     // Catch:{ JSONException -> 0x004d }
            if (r1 == 0) goto L_0x0031
            int r1 = r1.length()     // Catch:{ JSONException -> 0x004d }
            if (r1 != 0) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r1 = 0
            goto L_0x0032
        L_0x0031:
            r1 = 1
        L_0x0032:
            if (r1 != 0) goto L_0x003d
            java.lang.String r1 = "user_id"
            java.lang.String r2 = r5.w()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x004d }
        L_0x003d:
            bo.app.p5 r1 = r5.s()     // Catch:{ JSONException -> 0x004d }
            if (r1 == 0) goto L_0x0057
            java.lang.String r2 = "session_id"
            java.lang.String r1 = r1.forJsonPut()     // Catch:{ JSONException -> 0x004d }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x004d }
            goto L_0x0057
        L_0x004d:
            r1 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.E
            bo.app.j$b r4 = bo.app.j.b.b
            r2.brazelog((java.lang.Object) r5, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r1, (kotlin.jvm.functions.Function0<java.lang.String>) r4)
        L_0x0057:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j.forJsonPut():org.json.JSONObject");
    }

    public double v() {
        return this.d;
    }

    public final String w() {
        return (String) this.f.getValue(this, i[0]);
    }

    public final void a(String str) {
        this.f.setValue(this, i[0], str);
    }

    public final void a(p5 p5Var) {
        this.g.setValue(this, i[1], p5Var);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ j(bo.app.h1 r7, org.json.JSONObject r8, double r9, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x0009
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
        L_0x0009:
            r2 = r8
            r8 = r12 & 4
            if (r8 == 0) goto L_0x0012
            double r9 = com.braze.support.DateTimeUtils.nowInSecondsPrecise()
        L_0x0012:
            r3 = r9
            r8 = r12 & 8
            if (r8 == 0) goto L_0x0024
            java.util.UUID r8 = java.util.UUID.randomUUID()
            java.lang.String r11 = r8.toString()
            java.lang.String r8 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
        L_0x0024:
            r5 = r11
            r0 = r6
            r1 = r7
            r0.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j.<init>(bo.app.h1, org.json.JSONObject, double, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public j(h1 h1Var, JSONObject jSONObject, double d2, String str, String str2, String str3) {
        this(h1Var, jSONObject, d2, str);
        Intrinsics.checkNotNullParameter(h1Var, "eventType");
        Intrinsics.checkNotNullParameter(jSONObject, "eventData");
        Intrinsics.checkNotNullParameter(str, "uniqueIdentifier");
        a(str2);
        a(str3 != null ? p5.d.a(str3) : null);
    }
}
