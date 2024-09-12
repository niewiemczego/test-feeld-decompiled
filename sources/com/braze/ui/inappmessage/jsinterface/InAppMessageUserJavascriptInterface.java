package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\bH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0007J!\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u001bJ\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0007J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0007J\u0012\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\bH\u0007J(\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0007J \u0010&\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0007J\u001a\u0010*\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0007J \u0010+\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0007J \u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u0014H\u0007J\u0012\u0010/\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\bH\u0007J\u0012\u00103\u001a\u00020\u00062\b\u00104\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0007J\u0012\u00106\u001a\u00020\u00062\b\u00107\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u00108\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010<\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010>\u001a\u00020\u00062\u0006\u00102\u001a\u00020\bH\u0007J\u0014\u0010?\u001a\u0004\u0018\u00010@2\b\u00102\u001a\u0004\u0018\u00010\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "addAlias", "", "alias", "", "label", "addToCustomAttributeArray", "key", "value", "addToSubscriptionGroup", "subscriptionGroupId", "incrementCustomUserAttribute", "attribute", "monthFromInt", "Lcom/braze/enums/Month;", "monthInt", "", "parseGender", "Lcom/braze/enums/Gender;", "genderString", "parseStringArrayFromJsonString", "", "jsonArrayString", "(Ljava/lang/String;)[Ljava/lang/String;", "removeFromCustomAttributeArray", "removeFromSubscriptionGroup", "setCountry", "country", "setCustomAttribute", "user", "Lcom/braze/BrazeUser;", "jsonStringValue", "merge", "", "setCustomLocationAttribute", "latitude", "", "longitude", "setCustomUserAttributeArray", "setCustomUserAttributeJSON", "setDateOfBirth", "year", "day", "setEmail", "email", "setEmailNotificationSubscriptionType", "subscriptionType", "setFirstName", "firstName", "setGender", "setHomeCity", "homeCity", "setLanguage", "language", "setLastName", "lastName", "setPhoneNumber", "phoneNumber", "setPushNotificationSubscriptionType", "subscriptionTypeFromJavascriptString", "Lcom/braze/enums/NotificationSubscriptionType;", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageUserJavascriptInterface.kt */
public final class InAppMessageUserJavascriptInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String JS_BRIDGE_ATTRIBUTE_VALUE = "value";
    private final Context context;

    public InAppMessageUserJavascriptInterface(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    @JavascriptInterface
    public final void setFirstName(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setFirstName$1(str));
    }

    @JavascriptInterface
    public final void setLastName(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setLastName$1(str));
    }

    @JavascriptInterface
    public final void setEmail(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setEmail$1(str));
    }

    @JavascriptInterface
    public final void setGender(String str) {
        Intrinsics.checkNotNullParameter(str, "genderString");
        Gender parseGender = parseGender(str);
        if (parseGender == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setGender$1(str), 2, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setGender$2(parseGender));
    }

    @JavascriptInterface
    public final void setDateOfBirth(int i, int i2, int i3) {
        Month monthFromInt = monthFromInt(i2);
        if (monthFromInt == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setDateOfBirth$1(i2), 2, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setDateOfBirth$2(i, monthFromInt, i3));
    }

    @JavascriptInterface
    public final void setCountry(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCountry$1(str));
    }

    @JavascriptInterface
    public final void setLanguage(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setLanguage$1(str));
    }

    @JavascriptInterface
    public final void setHomeCity(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setHomeCity$1(str));
    }

    @JavascriptInterface
    public final void setEmailNotificationSubscriptionType(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionType");
        NotificationSubscriptionType subscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(str);
        if (subscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$1(str), 2, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setEmailNotificationSubscriptionType$2(subscriptionTypeFromJavascriptString));
    }

    @JavascriptInterface
    public final void setPushNotificationSubscriptionType(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionType");
        NotificationSubscriptionType subscriptionTypeFromJavascriptString = subscriptionTypeFromJavascriptString(str);
        if (subscriptionTypeFromJavascriptString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$1(str), 2, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setPushNotificationSubscriptionType$2(subscriptionTypeFromJavascriptString));
    }

    @JavascriptInterface
    public final void setPhoneNumber(String str) {
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setPhoneNumber$1(str));
    }

    @JavascriptInterface
    public final void setCustomUserAttributeJSON(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "jsonStringValue");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomUserAttributeJSON$1(this, str, str2, z));
    }

    @JavascriptInterface
    public final void setCustomUserAttributeArray(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        String[] parseStringArrayFromJsonString = parseStringArrayFromJsonString(str2);
        if (parseStringArrayFromJsonString == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$1(str), 2, (Object) null);
            return;
        }
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomUserAttributeArray$2(str, parseStringArrayFromJsonString));
    }

    @JavascriptInterface
    public final void addToCustomAttributeArray(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addToCustomAttributeArray$1(str, str2));
    }

    @JavascriptInterface
    public final void removeFromCustomAttributeArray(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$removeFromCustomAttributeArray$1(str, str2));
    }

    @JavascriptInterface
    public final void incrementCustomUserAttribute(String str) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$incrementCustomUserAttribute$1(str));
    }

    @JavascriptInterface
    public final void setCustomLocationAttribute(String str, double d, double d2) {
        Intrinsics.checkNotNullParameter(str, "attribute");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$setCustomLocationAttribute$1(str, d, d2));
    }

    @JavascriptInterface
    public final void addAlias(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "alias");
        Intrinsics.checkNotNullParameter(str2, "label");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addAlias$1(str, str2));
    }

    @JavascriptInterface
    public final void addToSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$addToSubscriptionGroup$1(str));
    }

    @JavascriptInterface
    public final void removeFromSubscriptionGroup(String str) {
        Intrinsics.checkNotNullParameter(str, "subscriptionGroupId");
        Companion.runOnUser(Braze.Companion.getInstance(this.context), new InAppMessageUserJavascriptInterface$removeFromSubscriptionGroup$1(str));
    }

    public final Month monthFromInt(int i) {
        if (i < 1 || i > 12) {
            return null;
        }
        return Month.Companion.getMonth(i - 1);
    }

    public final NotificationSubscriptionType subscriptionTypeFromJavascriptString(String str) {
        return NotificationSubscriptionType.Companion.fromValue(str);
    }

    public final void setCustomAttribute(BrazeUser brazeUser, String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(brazeUser, "user");
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "jsonStringValue");
        try {
            Object obj = new JSONObject(str2).get("value");
            if (obj instanceof String) {
                brazeUser.setCustomUserAttribute(str, (String) obj);
            } else if (obj instanceof Boolean) {
                brazeUser.setCustomUserAttribute(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Integer) {
                brazeUser.setCustomUserAttribute(str, ((Number) obj).intValue());
            } else if (obj instanceof Double) {
                brazeUser.setCustomUserAttribute(str, ((Number) obj).doubleValue());
            } else if (obj instanceof JSONObject) {
                brazeUser.setCustomUserAttribute(str, (JSONObject) obj, z);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new InAppMessageUserJavascriptInterface$setCustomAttribute$1(str, str2), 2, (Object) null);
            }
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new InAppMessageUserJavascriptInterface$setCustomAttribute$2(str, str2));
        }
    }

    public final String[] parseStringArrayFromJsonString(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.getString(i));
            }
            return (String[]) arrayList.toArray(new String[0]);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) InAppMessageUserJavascriptInterface$parseStringArrayFromJsonString$2.INSTANCE);
            return null;
        }
    }

    public final Gender parseGender(String str) {
        Intrinsics.checkNotNullParameter(str, "genderString");
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.MALE.forJsonPut())) {
            return Gender.MALE;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.FEMALE.forJsonPut())) {
            return Gender.FEMALE;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.OTHER.forJsonPut())) {
            return Gender.OTHER;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.UNKNOWN.forJsonPut())) {
            return Gender.UNKNOWN;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.NOT_APPLICABLE.forJsonPut())) {
            return Gender.NOT_APPLICABLE;
        }
        if (Intrinsics.areEqual((Object) lowerCase, (Object) Gender.PREFER_NOT_TO_SAY.forJsonPut())) {
            return Gender.PREFER_NOT_TO_SAY;
        }
        return null;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0005\u001a\u00020\u0006*\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00060\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface$Companion;", "", "()V", "JS_BRIDGE_ATTRIBUTE_VALUE", "", "runOnUser", "", "Lcom/braze/Braze;", "block", "Lkotlin/Function1;", "Lcom/braze/BrazeUser;", "Lkotlin/ParameterName;", "name", "user", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InAppMessageUserJavascriptInterface.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void runOnUser(Braze braze, Function1<? super BrazeUser, Unit> function1) {
            braze.getCurrentUser(new InAppMessageUserJavascriptInterface$Companion$$ExternalSyntheticLambda0(function1));
        }

        /* access modifiers changed from: private */
        public static final void runOnUser$lambda$0(Function1 function1, BrazeUser brazeUser) {
            Intrinsics.checkNotNullParameter(function1, "$block");
            Intrinsics.checkNotNullParameter(brazeUser, "it");
            function1.invoke(brazeUser);
        }
    }
}
