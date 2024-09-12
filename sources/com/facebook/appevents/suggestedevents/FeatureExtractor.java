package com.facebook.appevents.suggestedevents;

import android.util.Patterns;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0007J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0007J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u0012H\u0002J\b\u0010#\u001a\u00020\u000fH\u0007J)\u0010$\u001a\u00020\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060&H\u0002¢\u0006\u0002\u0010(J0\u0010)\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00062\u0006\u0010-\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0012H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J(\u00100\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00062\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00062\u0006\u00102\u001a\u00020\u0006H\u0002J\u0018\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020\u0015H\u0002J(\u00109\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00122\n\u0010:\u001a\u00060;j\u0002`<2\n\u0010=\u001a\u00060;j\u0002`<H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\rX.¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/facebook/appevents/suggestedevents/FeatureExtractor;", "", "()V", "NUM_OF_FEATURES", "", "REGEX_ADD_TO_CART_BUTTON_TEXT", "", "REGEX_ADD_TO_CART_PAGE_TITLE", "REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD", "REGEX_CR_HAS_LOG_IN_KEYWORDS", "REGEX_CR_HAS_SIGN_ON_KEYWORDS", "REGEX_CR_PASSWORD_FIELD", "eventInfo", "", "initialized", "", "languageInfo", "rules", "Lorg/json/JSONObject;", "textTypeInfo", "getDenseFeatures", "", "viewHierarchy", "appName", "getInteractedNode", "view", "getTextFeature", "buttonText", "activityName", "initialize", "", "file", "Ljava/io/File;", "isButton", "node", "isInitialized", "matchIndicators", "indicators", "", "values", "([Ljava/lang/String;[Ljava/lang/String;)Z", "nonparseFeatures", "siblings", "Lorg/json/JSONArray;", "screenName", "formFieldsJSON", "parseFeatures", "pruneTree", "regexMatched", "pattern", "matchText", "language", "event", "textType", "sum", "a", "b", "updateHintAndTextRecursively", "textSB", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "hintSB", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FeatureExtractor.kt */
public final class FeatureExtractor {
    public static final FeatureExtractor INSTANCE = new FeatureExtractor();
    private static final int NUM_OF_FEATURES = 30;
    private static final String REGEX_ADD_TO_CART_BUTTON_TEXT = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart";
    private static final String REGEX_ADD_TO_CART_PAGE_TITLE = "(?i)add to(\\s|\\Z)|update(\\s|\\Z)|cart|shop|buy";
    private static final String REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD = "(?i)(confirm.*password)|(password.*(confirmation|confirm)|confirmation)";
    private static final String REGEX_CR_HAS_LOG_IN_KEYWORDS = "(?i)(sign in)|login|signIn";
    private static final String REGEX_CR_HAS_SIGN_ON_KEYWORDS = "(?i)(sign.*(up|now)|registration|register|(create|apply).*(profile|account)|open.*account|account.*(open|creation|application)|enroll|join.*now)";
    private static final String REGEX_CR_PASSWORD_FIELD = "password";
    private static Map<String, String> eventInfo;
    private static boolean initialized;
    private static Map<String, String> languageInfo;
    private static JSONObject rules;
    private static Map<String, String> textTypeInfo;

    private FeatureExtractor() {
    }

    @JvmStatic
    public static final boolean isInitialized() {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            return initialized;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    @JvmStatic
    public static final void initialize(File file) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                rules = new JSONObject();
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                rules = new JSONObject(new String(bArr, Charsets.UTF_8));
                try {
                    languageInfo = MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.ENGLISH, "1"), TuplesKt.to(ViewHierarchyConstants.GERMAN, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.SPANISH, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.JAPANESE, "4"));
                    eventInfo = MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.VIEW_CONTENT, "0"), TuplesKt.to(ViewHierarchyConstants.SEARCH, "1"), TuplesKt.to(ViewHierarchyConstants.ADD_TO_CART, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.ADD_TO_WISHLIST, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.INITIATE_CHECKOUT, "4"), TuplesKt.to(ViewHierarchyConstants.ADD_PAYMENT_INFO, "5"), TuplesKt.to(ViewHierarchyConstants.PURCHASE, "6"), TuplesKt.to(ViewHierarchyConstants.LEAD, "7"), TuplesKt.to(ViewHierarchyConstants.COMPLETE_REGISTRATION, "8"));
                    textTypeInfo = MapsKt.mapOf(TuplesKt.to(ViewHierarchyConstants.BUTTON_TEXT, "1"), TuplesKt.to(ViewHierarchyConstants.PAGE_TITLE, ExifInterface.GPS_MEASUREMENT_2D), TuplesKt.to(ViewHierarchyConstants.RESOLVED_DOCUMENT_LINK, ExifInterface.GPS_MEASUREMENT_3D), TuplesKt.to(ViewHierarchyConstants.BUTTON_ID, "4"));
                    initialized = true;
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            } catch (Exception unused) {
            }
        }
    }

    @JvmStatic
    public static final String getTextFeature(String str, String str2, String str3) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(str, "buttonText");
            Intrinsics.checkNotNullParameter(str2, "activityName");
            Intrinsics.checkNotNullParameter(str3, "appName");
            String str4 = str3 + " | " + str2 + ", " + str;
            if (str4 != null) {
                String lowerCase = str4.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                return lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final float[] getDenseFeatures(JSONObject jSONObject, String str) {
        Class<FeatureExtractor> cls = FeatureExtractor.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(jSONObject, "viewHierarchy");
            Intrinsics.checkNotNullParameter(str, "appName");
            if (!initialized) {
                return null;
            }
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            try {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                JSONObject jSONObject2 = new JSONObject(jSONObject.optJSONObject(ViewHierarchyConstants.VIEW_KEY).toString());
                String optString = jSONObject.optString(ViewHierarchyConstants.SCREEN_NAME_KEY);
                JSONArray jSONArray = new JSONArray();
                FeatureExtractor featureExtractor = INSTANCE;
                featureExtractor.pruneTree(jSONObject2, jSONArray);
                featureExtractor.sum(fArr, featureExtractor.parseFeatures(jSONObject2));
                JSONObject interactedNode = featureExtractor.getInteractedNode(jSONObject2);
                if (interactedNode == null) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(optString, "screenName");
                String jSONObject3 = jSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "viewTree.toString()");
                featureExtractor.sum(fArr, featureExtractor.nonparseFeatures(interactedNode, jSONArray, optString, jSONObject3, lowerCase));
                return fArr;
            } catch (JSONException unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final float[] parseFeatures(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            int i = 0;
            for (int i2 = 0; i2 < 30; i2++) {
                fArr[i2] = 0.0f;
            }
            String optString = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString, "node.optString(TEXT_KEY)");
            String lowerCase = optString.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            String optString2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY);
            Intrinsics.checkNotNullExpressionValue(optString2, "node.optString(HINT_KEY)");
            String lowerCase2 = optString2.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
            String optString3 = jSONObject.optString(ViewHierarchyConstants.CLASS_NAME_KEY);
            Intrinsics.checkNotNullExpressionValue(optString3, "node.optString(CLASS_NAME_KEY)");
            String lowerCase3 = optString3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase()");
            int optInt = jSONObject.optInt(ViewHierarchyConstants.INPUT_TYPE_KEY, -1);
            String[] strArr = {lowerCase, lowerCase2};
            if (matchIndicators(new String[]{"$", "amount", FirebaseAnalytics.Param.PRICE, "total"}, strArr)) {
                fArr[0] = fArr[0] + 1.0f;
            }
            if (matchIndicators(new String[]{"password", "pwd"}, strArr)) {
                fArr[1] = fArr[1] + 1.0f;
            }
            if (matchIndicators(new String[]{"tel", "phone"}, strArr)) {
                fArr[2] = fArr[2] + 1.0f;
            }
            if (matchIndicators(new String[]{"search"}, strArr)) {
                fArr[4] = fArr[4] + 1.0f;
            }
            if (optInt >= 0) {
                fArr[5] = fArr[5] + 1.0f;
            }
            if (optInt == 3 || optInt == 2) {
                fArr[6] = fArr[6] + 1.0f;
            }
            if (optInt == 32 || Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                fArr[7] = fArr[7] + 1.0f;
            }
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "checkbox", false, 2, (Object) null)) {
                fArr[8] = fArr[8] + 1.0f;
            }
            if (matchIndicators(new String[]{"complete", "confirm", "done", "submit"}, new String[]{lowerCase})) {
                fArr[10] = fArr[10] + 1.0f;
            }
            if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "radio", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "button", false, 2, (Object) null)) {
                fArr[12] = fArr[12] + 1.0f;
            }
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i3 = i + 1;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "childViews.getJSONObject(i)");
                        sum(fArr, parseFeatures(jSONObject2));
                        if (i3 >= length) {
                            break;
                        }
                        i = i3;
                    }
                }
            } catch (JSONException unused) {
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final float[] nonparseFeatures(JSONObject jSONObject, JSONArray jSONArray, String str, String str2, String str3) {
        String str4 = str2;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            float[] fArr = new float[30];
            for (int i = 0; i < 30; i++) {
                fArr[i] = 0.0f;
            }
            int length = jSONArray.length();
            fArr[3] = length > 1 ? ((float) length) - 1.0f : 0.0f;
            try {
                int length2 = jSONArray.length();
                if (length2 > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2 + 1;
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "siblings.getJSONObject(i)");
                        if (isButton(jSONObject2)) {
                            fArr[9] = fArr[9] + 1.0f;
                        }
                        if (i3 >= length2) {
                            break;
                        }
                        i2 = i3;
                    }
                }
            } catch (JSONException unused) {
            }
            fArr[13] = -1.0f;
            fArr[14] = -1.0f;
            String str5 = str + '|' + str3;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            updateHintAndTextRecursively(jSONObject, sb2, sb);
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "hintSB.toString()");
            String sb4 = sb2.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "textSB.toString()");
            fArr[15] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[16] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.PAGE_TITLE, str5) ? 1.0f : 0.0f;
            fArr[17] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.COMPLETE_REGISTRATION, ViewHierarchyConstants.BUTTON_ID, sb3) ? 1.0f : 0.0f;
            fArr[18] = StringsKt.contains$default((CharSequence) str4, (CharSequence) "password", false, 2, (Object) null) ? 1.0f : 0.0f;
            fArr[19] = regexMatched(REGEX_CR_HAS_CONFIRM_PASSWORD_FIELD, str4) ? 1.0f : 0.0f;
            fArr[20] = regexMatched(REGEX_CR_HAS_LOG_IN_KEYWORDS, str4) ? 1.0f : 0.0f;
            fArr[21] = regexMatched(REGEX_CR_HAS_SIGN_ON_KEYWORDS, str4) ? 1.0f : 0.0f;
            fArr[22] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[24] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.PURCHASE, ViewHierarchyConstants.PAGE_TITLE, str5) ? 1.0f : 0.0f;
            fArr[25] = regexMatched(REGEX_ADD_TO_CART_BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[27] = regexMatched(REGEX_ADD_TO_CART_PAGE_TITLE, str5) ? 1.0f : 0.0f;
            fArr[28] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.BUTTON_TEXT, sb4) ? 1.0f : 0.0f;
            fArr[29] = regexMatched(ViewHierarchyConstants.ENGLISH, ViewHierarchyConstants.LEAD, ViewHierarchyConstants.PAGE_TITLE, str5) ? 1.0f : 0.0f;
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0042 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043 A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A[Catch:{ all -> 0x007a }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005d A[Catch:{ all -> 0x007a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean regexMatched(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /*
            r4 = this;
            boolean r0 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            org.json.JSONObject r0 = rules     // Catch:{ all -> 0x007a }
            r2 = 0
            if (r0 == 0) goto L_0x0074
            java.lang.String r3 = "rulesForLanguage"
            org.json.JSONObject r0 = r0.optJSONObject(r3)     // Catch:{ all -> 0x007a }
            if (r0 != 0) goto L_0x0017
            r5 = r2
            goto L_0x0025
        L_0x0017:
            java.util.Map<java.lang.String, java.lang.String> r3 = languageInfo     // Catch:{ all -> 0x007a }
            if (r3 == 0) goto L_0x006e
            java.lang.Object r5 = r3.get(r5)     // Catch:{ all -> 0x007a }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x007a }
            org.json.JSONObject r5 = r0.optJSONObject(r5)     // Catch:{ all -> 0x007a }
        L_0x0025:
            if (r5 != 0) goto L_0x0029
        L_0x0027:
            r5 = r2
            goto L_0x0040
        L_0x0029:
            java.lang.String r0 = "rulesForEvent"
            org.json.JSONObject r5 = r5.optJSONObject(r0)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            java.util.Map<java.lang.String, java.lang.String> r0 = eventInfo     // Catch:{ all -> 0x007a }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r6 = r0.get(r6)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
        L_0x0040:
            if (r5 != 0) goto L_0x0043
            goto L_0x005a
        L_0x0043:
            java.lang.String r6 = "positiveRules"
            org.json.JSONObject r5 = r5.optJSONObject(r6)     // Catch:{ all -> 0x007a }
            if (r5 != 0) goto L_0x004c
            goto L_0x005a
        L_0x004c:
            java.util.Map<java.lang.String, java.lang.String> r6 = textTypeInfo     // Catch:{ all -> 0x007a }
            if (r6 == 0) goto L_0x0062
            java.lang.Object r6 = r6.get(r7)     // Catch:{ all -> 0x007a }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r5.optString(r6)     // Catch:{ all -> 0x007a }
        L_0x005a:
            if (r2 != 0) goto L_0x005d
            goto L_0x0061
        L_0x005d:
            boolean r1 = r4.regexMatched(r2, r8)     // Catch:{ all -> 0x007a }
        L_0x0061:
            return r1
        L_0x0062:
            java.lang.String r5 = "textTypeInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x0068:
            java.lang.String r5 = "eventInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x006e:
            java.lang.String r5 = "languageInfo"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x0074:
            java.lang.String r5 = "rules"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x007a }
            throw r2     // Catch:{ all -> 0x007a }
        L_0x007a:
            r5 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r5, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.suggestedevents.FeatureExtractor.regexMatched(java.lang.String, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    private final boolean regexMatched(String str, String str2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean matchIndicators(String[] strArr, String[] strArr2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                int length2 = strArr2.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        String str2 = strArr2[i2];
                        i2++;
                        if (StringsKt.contains$default((CharSequence) str2, (CharSequence) str, false, 2, (Object) null)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final boolean pruneTree(JSONObject jSONObject, JSONArray jSONArray) {
        boolean z;
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return true;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            int length = optJSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    if (optJSONArray.getJSONObject(i).optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                        z = true;
                        break;
                    } else if (i2 >= length) {
                        break;
                    } else {
                        i = i2;
                    }
                }
            }
            z = false;
            boolean z2 = z;
            JSONArray jSONArray2 = new JSONArray();
            if (z) {
                int length2 = optJSONArray.length();
                if (length2 > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        jSONArray.put((Object) optJSONArray.getJSONObject(i3));
                        if (i4 >= length2) {
                            break;
                        }
                        i3 = i4;
                    }
                }
            } else {
                int length3 = optJSONArray.length();
                if (length3 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "child");
                        if (pruneTree(jSONObject2, jSONArray)) {
                            jSONArray2.put((Object) jSONObject2);
                            z2 = true;
                        }
                        if (i6 >= length3) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) jSONArray2);
            }
            return z2;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void sum(float[] fArr, float[] fArr2) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            int i = 0;
            try {
                int length = fArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i2 = i + 1;
                        fArr[i] = fArr[i] + fArr2[i];
                        if (i2 <= length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final boolean isButton(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return ((jSONObject.optInt(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY) & 1) << 5) > 0;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void updateHintAndTextRecursively(JSONObject jSONObject, StringBuilder sb, StringBuilder sb2) {
        int length;
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                String optString = jSONObject.optString("text", "");
                Intrinsics.checkNotNullExpressionValue(optString, "view.optString(TEXT_KEY, \"\")");
                String lowerCase = optString.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                String optString2 = jSONObject.optString(ViewHierarchyConstants.HINT_KEY, "");
                Intrinsics.checkNotNullExpressionValue(optString2, "view.optString(HINT_KEY, \"\")");
                String lowerCase2 = optString2.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                boolean z = true;
                int i = 0;
                if (lowerCase.length() > 0) {
                    sb.append(lowerCase).append(" ");
                }
                if (lowerCase2.length() <= 0) {
                    z = false;
                }
                if (z) {
                    sb2.append(lowerCase2).append(" ");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
                if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                    while (true) {
                        int i2 = i + 1;
                        try {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            Intrinsics.checkNotNullExpressionValue(jSONObject2, "currentChildView");
                            updateHintAndTextRecursively(jSONObject2, sb, sb2);
                        } catch (JSONException unused) {
                        }
                        if (i2 < length) {
                            i = i2;
                        } else {
                            return;
                        }
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    private final JSONObject getInteractedNode(JSONObject jSONObject) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            if (jSONObject.optBoolean(ViewHierarchyConstants.IS_INTERACTED_KEY)) {
                return jSONObject;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(ViewHierarchyConstants.CHILDREN_VIEW_KEY);
            if (optJSONArray == null) {
                return null;
            }
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    Intrinsics.checkNotNullExpressionValue(jSONObject2, "children.getJSONObject(i)");
                    JSONObject interactedNode = getInteractedNode(jSONObject2);
                    if (interactedNode != null) {
                        return interactedNode;
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return null;
        } catch (JSONException unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
