package com.braze.support;

import bo.app.e3;
import bo.app.z1;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;
import com.braze.models.inappmessage.InAppMessageControl;
import com.braze.models.inappmessage.InAppMessageFull;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.models.inappmessage.InAppMessageHtmlFull;
import com.braze.models.inappmessage.InAppMessageModal;
import com.braze.models.inappmessage.InAppMessageSlideup;
import com.braze.support.BrazeLogger;
import java.util.Locale;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public abstract class h {
    private static final String a = BrazeLogger.INSTANCE.getBrazeLogTag("InAppMessageModelUtils");

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.braze.enums.inappmessage.MessageType[] r0 = com.braze.enums.inappmessage.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.FULL     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.MODAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.SLIDEUP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML_FULL     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.braze.enums.inappmessage.MessageType r1 = com.braze.enums.inappmessage.MessageType.HTML     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.support.h.a.<clinit>():void");
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deserializing control in-app message.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "In-app message type was unknown for in-app message: " + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unknown in-app message type. Returning null: " + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize the in-app message: " + JsonUtils.getPrettyPrintedString(this.b) + ". Returning null.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In-app message string was blank.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to deserialize the in-app message string: " + this.b;
        }
    }

    public static final IInAppMessage a(String str, z1 z1Var) {
        Intrinsics.checkNotNullParameter(str, "inAppMessageJsonString");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        if (StringsKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, a, BrazeLogger.Priority.I, (Throwable) null, (Function0) f.b, 4, (Object) null);
            return null;
        }
        try {
            return a(new JSONObject(str), z1Var);
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog(a, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new g(str));
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = r1.optJSONObject("dark");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final org.json.JSONArray b(org.json.JSONObject r1) {
        /*
            java.lang.String r0 = "inAppMessageJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "themes"
            org.json.JSONObject r1 = r1.optJSONObject(r0)
            if (r1 == 0) goto L_0x001c
            java.lang.String r0 = "dark"
            org.json.JSONObject r1 = r1.optJSONObject(r0)
            if (r1 == 0) goto L_0x001c
            java.lang.String r0 = "btns"
            org.json.JSONArray r1 = r1.optJSONArray(r0)
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            if (r1 != 0) goto L_0x0024
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.support.h.b(org.json.JSONObject):org.json.JSONArray");
    }

    public static final boolean c(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        return jSONObject.optBoolean(InAppMessageBase.IS_CONTROL, false);
    }

    public static final IInAppMessage a(JSONObject jSONObject, z1 z1Var) {
        MessageType messageType;
        IInAppMessage iInAppMessage;
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        try {
            if (c(jSONObject)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, a, BrazeLogger.Priority.D, (Throwable) null, (Function0) b.b, 4, (Object) null);
                return new InAppMessageControl(jSONObject, z1Var);
            }
            try {
                c cVar = c.a;
                String string = jSONObject.getString("type");
                Intrinsics.checkNotNullExpressionValue(string, "jsonObject.getString(key)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String upperCase = string.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                MessageType[] values = MessageType.values();
                int i = 0;
                int length = values.length;
                while (i < length) {
                    messageType = values[i];
                    if (!Intrinsics.areEqual((Object) messageType.name(), (Object) upperCase)) {
                        i++;
                    } else if (messageType == null) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, a, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(jSONObject), 4, (Object) null);
                        return null;
                    } else {
                        int i2 = a.a[messageType.ordinal()];
                        if (i2 == 1) {
                            iInAppMessage = new InAppMessageFull(jSONObject, z1Var);
                        } else if (i2 == 2) {
                            iInAppMessage = new InAppMessageModal(jSONObject, z1Var);
                        } else if (i2 == 3) {
                            iInAppMessage = new InAppMessageSlideup(jSONObject, z1Var);
                        } else if (i2 == 4) {
                            iInAppMessage = new InAppMessageHtmlFull(jSONObject, z1Var);
                        } else if (i2 != 5) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, a, BrazeLogger.Priority.W, (Throwable) null, (Function0) new d(jSONObject), 4, (Object) null);
                            return null;
                        } else {
                            iInAppMessage = new InAppMessageHtml(jSONObject, z1Var);
                        }
                        return iInAppMessage;
                    }
                }
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            } catch (Exception unused) {
                messageType = null;
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog(a, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new e(jSONObject));
            return null;
        }
    }

    public static final e3 a(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "inAppMessageJson");
        JSONObject optJSONObject = jSONObject.optJSONObject("themes");
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject("dark") : null;
        if (optJSONObject2 != null) {
            return new e3(optJSONObject2);
        }
        return null;
    }
}
