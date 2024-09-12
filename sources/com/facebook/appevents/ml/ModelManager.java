package com.facebook.appevents.ml;

import android.os.Bundle;
import android.text.TextUtils;
import com.adapty.internal.utils.UtilsKt;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.FileDownloadTask;
import com.facebook.appevents.suggestedevents.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u000278B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020%H\u0002J\u0014\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u001bH\u0002J9\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u0010!\u001a\u00020\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020'0-2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040-H\u0007¢\u0006\u0002\u00100J%\u00101\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105J%\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010-2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020'H\u0002¢\u0006\u0002\u00105R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager;", "", "()V", "ASSET_URI_KEY", "", "CACHE_KEY_MODELS", "CACHE_KEY_REQUEST_TIMESTAMP", "MODEL_ASSERT_STORE", "MODEL_REQUEST_INTERVAL_MILLISECONDS", "", "MTML_INTEGRITY_DETECT_PREDICTION", "", "MTML_SUGGESTED_EVENTS_PREDICTION", "MTML_USE_CASE", "RULES_URI_KEY", "THRESHOLD_KEY", "USE_CASE_KEY", "VERSION_ID_KEY", "isLocaleEnglish", "", "()Z", "taskHandlers", "", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "addModels", "", "models", "Lorg/json/JSONObject;", "enable", "enableMTML", "fetchModels", "getRuleFile", "Ljava/io/File;", "task", "Lcom/facebook/appevents/ml/ModelManager$Task;", "isValidTimestamp", "timestamp", "", "parseJsonArray", "", "jsonArray", "Lorg/json/JSONArray;", "parseRawJsonObject", "jsonObject", "predict", "", "denses", "texts", "(Lcom/facebook/appevents/ml/ModelManager$Task;[[F[Ljava/lang/String;)[Ljava/lang/String;", "processIntegrityDetectionResult", "res", "Lcom/facebook/appevents/ml/MTensor;", "thresholds", "(Lcom/facebook/appevents/ml/MTensor;[F)[Ljava/lang/String;", "processSuggestedEventResult", "Task", "TaskHandler", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ModelManager.kt */
public final class ModelManager {
    private static final String ASSET_URI_KEY = "asset_uri";
    private static final String CACHE_KEY_MODELS = "models";
    private static final String CACHE_KEY_REQUEST_TIMESTAMP = "model_request_timestamp";
    public static final ModelManager INSTANCE = new ModelManager();
    private static final String MODEL_ASSERT_STORE = "com.facebook.internal.MODEL_STORE";
    public static final int MODEL_REQUEST_INTERVAL_MILLISECONDS = 259200000;
    private static final List<String> MTML_INTEGRITY_DETECT_PREDICTION = CollectionsKt.listOf("none", "address", IntegrityManager.INTEGRITY_TYPE_HEALTH);
    private static final List<String> MTML_SUGGESTED_EVENTS_PREDICTION = CollectionsKt.listOf("other", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION, AppEventsConstants.EVENT_NAME_ADDED_TO_CART, AppEventsConstants.EVENT_NAME_PURCHASED, AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
    private static final String MTML_USE_CASE = "MTML";
    private static final String RULES_URI_KEY = "rules_uri";
    private static final String THRESHOLD_KEY = "thresholds";
    private static final String USE_CASE_KEY = "use_case";
    private static final String VERSION_ID_KEY = "version_id";
    private static final Map<String, TaskHandler> taskHandlers = new ConcurrentHashMap();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ModelManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Task.values().length];
            iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 1;
            iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private ModelManager() {
    }

    public static final /* synthetic */ float[] access$parseJsonArray(ModelManager modelManager, JSONArray jSONArray) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            return modelManager.parseJsonArray(jSONArray);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$Task;", "", "(Ljava/lang/String;I)V", "toKey", "", "toUseCase", "MTML_INTEGRITY_DETECT", "MTML_APP_EVENT_PREDICTION", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ModelManager.kt */
    public enum Task {
        MTML_INTEGRITY_DETECT,
        MTML_APP_EVENT_PREDICTION;

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        /* compiled from: ModelManager.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[Task.values().length];
                iArr[Task.MTML_INTEGRITY_DETECT.ordinal()] = 1;
                iArr[Task.MTML_APP_EVENT_PREDICTION.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final String toKey() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return "integrity_detect";
            }
            if (i == 2) {
                return "app_event_pred";
            }
            throw new NoWhenBranchMatchedException();
        }

        public final String toUseCase() {
            int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
            if (i == 1) {
                return "MTML_INTEGRITY_DETECT";
            }
            if (i == 2) {
                return "MTML_APP_EVENT_PRED";
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @JvmStatic
    public static final void enable() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Utility utility = Utility.INSTANCE;
                Utility.runOnNonUiThread(new ModelManager$$ExternalSyntheticLambda0());
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ Exception -> 0x0084, all -> 0x0080 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060 A[Catch:{ Exception -> 0x0084, all -> 0x0080 }] */
    /* renamed from: enable$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m280enable$lambda0() {
        /*
            java.lang.String r0 = "model_request_timestamp"
            java.lang.String r1 = "models"
            java.lang.Class<com.facebook.appevents.ml.ModelManager> r2 = com.facebook.appevents.ml.ModelManager.class
            boolean r3 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r2)
            if (r3 == 0) goto L_0x000d
            return
        L_0x000d:
            com.facebook.FacebookSdk r3 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            android.content.Context r3 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            java.lang.String r4 = "com.facebook.internal.MODEL_STORE"
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r4 = 0
            java.lang.String r4 = r3.getString(r1, r4)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r4 == 0) goto L_0x0034
            r6 = r4
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            int r6 = r6.length()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r6 != 0) goto L_0x002b
            r5 = 1
        L_0x002b:
            if (r5 == 0) goto L_0x002e
            goto L_0x0034
        L_0x002e:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r5.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            goto L_0x0039
        L_0x0034:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r5.<init>()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
        L_0x0039:
            r6 = 0
            long r6 = r3.getLong(r0, r6)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            com.facebook.internal.FeatureManager r4 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            com.facebook.internal.FeatureManager$Feature r4 = com.facebook.internal.FeatureManager.Feature.ModelRequest     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            boolean r4 = com.facebook.internal.FeatureManager.isEnabled(r4)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r4 == 0) goto L_0x0057
            int r4 = r5.length()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r4 == 0) goto L_0x0057
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            boolean r4 = r4.isValidTimestamp(r6)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r4 != 0) goto L_0x0077
        L_0x0057:
            com.facebook.appevents.ml.ModelManager r4 = INSTANCE     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            org.json.JSONObject r5 = r4.fetchModels()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            if (r5 != 0) goto L_0x0060
            return
        L_0x0060:
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            java.lang.String r4 = r5.toString()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            android.content.SharedPreferences$Editor r1 = r3.putString(r1, r4)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            android.content.SharedPreferences$Editor r0 = r1.putLong(r0, r3)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r0.apply()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
        L_0x0077:
            com.facebook.appevents.ml.ModelManager r0 = INSTANCE     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r0.addModels(r5)     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            r0.enableMTML()     // Catch:{ Exception -> 0x0084, all -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r0 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r0, r2)
        L_0x0084:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.m280enable$lambda0():void");
    }

    private final boolean isValidTimestamp(long j) {
        if (CrashShieldHandler.isObjectCrashing(this) || j == 0) {
            return false;
        }
        try {
            return System.currentTimeMillis() - j < 259200000;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final void addModels(JSONObject jSONObject) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        TaskHandler build = TaskHandler.Companion.build(jSONObject.getJSONObject(keys.next()));
                        if (build != null) {
                            taskHandlers.put(build.getUseCase(), build);
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:15|16|21) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return new org.json.JSONObject();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0064 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject parseRawJsonObject(org.json.JSONObject r13) {
        /*
            r12 = this;
            java.lang.String r0 = "asset_uri"
            java.lang.String r1 = "thresholds"
            java.lang.String r2 = "version_id"
            java.lang.String r3 = "rules_uri"
            java.lang.String r4 = "use_case"
            boolean r5 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r12)
            r6 = 0
            if (r5 == 0) goto L_0x0012
            return r6
        L_0x0012:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
            java.lang.String r7 = "data"
            org.json.JSONArray r13 = r13.getJSONArray(r7)     // Catch:{ JSONException -> 0x0064 }
            r7 = 0
            int r8 = r13.length()     // Catch:{ JSONException -> 0x0064 }
            if (r8 <= 0) goto L_0x0069
        L_0x0024:
            int r9 = r7 + 1
            org.json.JSONObject r7 = r13.getJSONObject(r7)     // Catch:{ JSONException -> 0x0064 }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0064 }
            r10.<init>()     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r2)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r2, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r4, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            org.json.JSONArray r11 = r7.getJSONArray(r1)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r1, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            java.lang.String r11 = r7.getString(r0)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r0, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
            boolean r11 = r7.has(r3)     // Catch:{ JSONException -> 0x0064 }
            if (r11 == 0) goto L_0x0058
            java.lang.String r11 = r7.getString(r3)     // Catch:{ JSONException -> 0x0064 }
            r10.put((java.lang.String) r3, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0064 }
        L_0x0058:
            java.lang.String r7 = r7.getString(r4)     // Catch:{ JSONException -> 0x0064 }
            r5.put((java.lang.String) r7, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0064 }
            if (r9 < r8) goto L_0x0062
            goto L_0x0069
        L_0x0062:
            r7 = r9
            goto L_0x0024
        L_0x0064:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x006a }
            r5.<init>()     // Catch:{ all -> 0x006a }
        L_0x0069:
            return r5
        L_0x006a:
            r13 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r13, r12)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.ml.ModelManager.parseRawJsonObject(org.json.JSONObject):org.json.JSONObject");
    }

    private final JSONObject fetchModels() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            String[] strArr = {USE_CASE_KEY, VERSION_ID_KEY, ASSET_URI_KEY, RULES_URI_KEY, THRESHOLD_KEY};
            Bundle bundle = new Bundle();
            bundle.putString(GraphRequest.FIELDS_PARAM, TextUtils.join(",", strArr));
            GraphRequest newGraphPathRequest = GraphRequest.Companion.newGraphPathRequest((AccessToken) null, "app/model_asset", (GraphRequest.Callback) null);
            newGraphPathRequest.setParameters(bundle);
            JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
            if (jSONObject == null) {
                return null;
            }
            return parseRawJsonObject(jSONObject);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final void enableMTML() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                List arrayList = new ArrayList();
                String str = null;
                int i = 0;
                for (Map.Entry next : taskHandlers.entrySet()) {
                    String str2 = (String) next.getKey();
                    TaskHandler taskHandler = (TaskHandler) next.getValue();
                    if (Intrinsics.areEqual((Object) str2, (Object) Task.MTML_APP_EVENT_PREDICTION.toUseCase())) {
                        String assetUri = taskHandler.getAssetUri();
                        int max = Math.max(i, taskHandler.getVersionId());
                        FeatureManager featureManager = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.SuggestedEvents) && isLocaleEnglish()) {
                            arrayList.add(taskHandler.setOnPostExecute(new ModelManager$$ExternalSyntheticLambda1()));
                        }
                        str = assetUri;
                        i = max;
                    }
                    if (Intrinsics.areEqual((Object) str2, (Object) Task.MTML_INTEGRITY_DETECT.toUseCase())) {
                        str = taskHandler.getAssetUri();
                        i = Math.max(i, taskHandler.getVersionId());
                        FeatureManager featureManager2 = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.IntelligentIntegrity)) {
                            arrayList.add(taskHandler.setOnPostExecute(new ModelManager$$ExternalSyntheticLambda2()));
                        }
                    }
                }
                if (str != null && i > 0 && !arrayList.isEmpty()) {
                    TaskHandler.Companion.execute(new TaskHandler(MTML_USE_CASE, str, (String) null, i, (float[]) null), arrayList);
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-1  reason: not valid java name */
    public static final void m281enableMTML$lambda1() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                SuggestedEventsManager suggestedEventsManager = SuggestedEventsManager.INSTANCE;
                SuggestedEventsManager.enable();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: enableMTML$lambda-2  reason: not valid java name */
    public static final void m282enableMTML$lambda2() {
        Class<ModelManager> cls = ModelManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                IntegrityManager integrityManager = IntegrityManager.INSTANCE;
                IntegrityManager.enable();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean isLocaleEnglish() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            Utility utility = Utility.INSTANCE;
            Locale resourceLocale = Utility.getResourceLocale();
            if (resourceLocale != null) {
                String language = resourceLocale.getLanguage();
                Intrinsics.checkNotNullExpressionValue(language, "locale.language");
                if (StringsKt.contains$default((CharSequence) language, (CharSequence) UtilsKt.DEFAULT_PAYWALL_LOCALE, false, 2, (Object) null)) {
                    return true;
                }
                return false;
            }
            return true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    private final float[] parseJsonArray(JSONArray jSONArray) {
        if (CrashShieldHandler.isObjectCrashing(this) || jSONArray == null) {
            return null;
        }
        try {
            float[] fArr = new float[jSONArray.length()];
            int i = 0;
            int length = jSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    try {
                        String string = jSONArray.getString(i);
                        Intrinsics.checkNotNullExpressionValue(string, "jsonArray.getString(i)");
                        fArr[i] = Float.parseFloat(string);
                    } catch (JSONException unused) {
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return fArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final File getRuleFile(Task task) {
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                return null;
            }
            return taskHandler.getRuleFile();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    @JvmStatic
    public static final String[] predict(Task task, float[][] fArr, String[] strArr) {
        Model model;
        float[][] fArr2 = fArr;
        String[] strArr2 = strArr;
        Class<ModelManager> cls = ModelManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(fArr2, "denses");
            Intrinsics.checkNotNullParameter(strArr2, "texts");
            TaskHandler taskHandler = taskHandlers.get(task.toUseCase());
            if (taskHandler == null) {
                model = null;
            } else {
                model = taskHandler.getModel();
            }
            if (model == null) {
                return null;
            }
            float[] thresholds = taskHandler.getThresholds();
            int length = strArr2.length;
            boolean z = false;
            int length2 = fArr2[0].length;
            MTensor mTensor = new MTensor(new int[]{length, length2});
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    System.arraycopy(fArr2[i], 0, mTensor.getData(), i * length2, length2);
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            MTensor predictOnMTML = model.predictOnMTML(mTensor, strArr2, task.toKey());
            if (!(predictOnMTML == null || thresholds == null)) {
                if (!(predictOnMTML.getData().length == 0)) {
                    if (thresholds.length == 0) {
                        z = true;
                    }
                    if (!z) {
                        int i3 = WhenMappings.$EnumSwitchMapping$0[task.ordinal()];
                        if (i3 == 1) {
                            return INSTANCE.processSuggestedEventResult(predictOnMTML, thresholds);
                        }
                        if (i3 == 2) {
                            return INSTANCE.processIntegrityDetectionResult(predictOnMTML, thresholds);
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            String[] strArr3 = null;
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return null;
        }
    }

    private final String[] processSuggestedEventResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            Iterable until = RangesKt.until(0, shape);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String str = "other";
                int length = fArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                        str = MTML_SUGGESTED_EVENTS_PREDICTION.get(i2);
                    }
                    i++;
                    i2 = i3;
                }
                arrayList.add(str);
            }
            Object[] array = ((List) arrayList).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    private final String[] processIntegrityDetectionResult(MTensor mTensor, float[] fArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int shape = mTensor.getShape(0);
            int shape2 = mTensor.getShape(1);
            float[] data = mTensor.getData();
            if (shape2 != fArr.length) {
                return null;
            }
            Iterable until = RangesKt.until(0, shape);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                String str = "none";
                int length = fArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    int i3 = i2 + 1;
                    if (data[(nextInt * shape2) + i2] >= fArr[i]) {
                        str = MTML_INTEGRITY_DETECT_PREDICTION.get(i2);
                    }
                    i++;
                    i2 = i3;
                }
                arrayList.add(str);
            }
            Object[] array = ((List) arrayList).toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 *2\u00020\u0001:\u0001*B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "", "useCase", "", "assetUri", "ruleUri", "versionId", "", "thresholds", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[F)V", "getAssetUri", "()Ljava/lang/String;", "setAssetUri", "(Ljava/lang/String;)V", "model", "Lcom/facebook/appevents/ml/Model;", "getModel", "()Lcom/facebook/appevents/ml/Model;", "setModel", "(Lcom/facebook/appevents/ml/Model;)V", "onPostExecute", "Ljava/lang/Runnable;", "ruleFile", "Ljava/io/File;", "getRuleFile", "()Ljava/io/File;", "setRuleFile", "(Ljava/io/File;)V", "getRuleUri", "setRuleUri", "getThresholds", "()[F", "setThresholds", "([F)V", "getUseCase", "setUseCase", "getVersionId", "()I", "setVersionId", "(I)V", "setOnPostExecute", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ModelManager.kt */
    public static final class TaskHandler {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private String assetUri;
        private Model model;
        /* access modifiers changed from: private */
        public Runnable onPostExecute;
        private File ruleFile;
        private String ruleUri;
        private float[] thresholds;
        private String useCase;
        private int versionId;

        public TaskHandler(String str, String str2, String str3, int i, float[] fArr) {
            Intrinsics.checkNotNullParameter(str, "useCase");
            Intrinsics.checkNotNullParameter(str2, "assetUri");
            this.useCase = str;
            this.assetUri = str2;
            this.ruleUri = str3;
            this.versionId = i;
            this.thresholds = fArr;
        }

        public final String getUseCase() {
            return this.useCase;
        }

        public final void setUseCase(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.useCase = str;
        }

        public final String getAssetUri() {
            return this.assetUri;
        }

        public final void setAssetUri(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.assetUri = str;
        }

        public final String getRuleUri() {
            return this.ruleUri;
        }

        public final void setRuleUri(String str) {
            this.ruleUri = str;
        }

        public final int getVersionId() {
            return this.versionId;
        }

        public final void setVersionId(int i) {
            this.versionId = i;
        }

        public final float[] getThresholds() {
            return this.thresholds;
        }

        public final void setThresholds(float[] fArr) {
            this.thresholds = fArr;
        }

        public final File getRuleFile() {
            return this.ruleFile;
        }

        public final void setRuleFile(File file) {
            this.ruleFile = file;
        }

        public final Model getModel() {
            return this.model;
        }

        public final void setModel(Model model2) {
            this.model = model2;
        }

        public final TaskHandler setOnPostExecute(Runnable runnable) {
            this.onPostExecute = runnable;
            return this;
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\"\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0004J\u001c\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/ml/ModelManager$TaskHandler$Companion;", "", "()V", "build", "Lcom/facebook/appevents/ml/ModelManager$TaskHandler;", "json", "Lorg/json/JSONObject;", "deleteOldFiles", "", "useCase", "", "versionId", "", "download", "uri", "name", "onComplete", "Lcom/facebook/appevents/internal/FileDownloadTask$Callback;", "execute", "handler", "master", "slaves", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: ModelManager.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TaskHandler build(JSONObject jSONObject) {
                if (jSONObject == null) {
                    TaskHandler taskHandler = null;
                    return null;
                }
                try {
                    String string = jSONObject.getString(ModelManager.USE_CASE_KEY);
                    String string2 = jSONObject.getString(ModelManager.ASSET_URI_KEY);
                    String optString = jSONObject.optString(ModelManager.RULES_URI_KEY, (String) null);
                    int i = jSONObject.getInt(ModelManager.VERSION_ID_KEY);
                    float[] access$parseJsonArray = ModelManager.access$parseJsonArray(ModelManager.INSTANCE, jSONObject.getJSONArray(ModelManager.THRESHOLD_KEY));
                    Intrinsics.checkNotNullExpressionValue(string, "useCase");
                    Intrinsics.checkNotNullExpressionValue(string2, "assetUri");
                    return new TaskHandler(string, string2, optString, i, access$parseJsonArray);
                } catch (Exception unused) {
                    TaskHandler taskHandler2 = null;
                    return null;
                }
            }

            public final void execute(TaskHandler taskHandler) {
                Intrinsics.checkNotNullParameter(taskHandler, "handler");
                execute(taskHandler, CollectionsKt.listOf(taskHandler));
            }

            public final void execute(TaskHandler taskHandler, List<TaskHandler> list) {
                Intrinsics.checkNotNullParameter(taskHandler, "master");
                Intrinsics.checkNotNullParameter(list, "slaves");
                deleteOldFiles(taskHandler.getUseCase(), taskHandler.getVersionId());
                download(taskHandler.getAssetUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId(), new ModelManager$TaskHandler$Companion$$ExternalSyntheticLambda0(list));
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1  reason: not valid java name */
            public static final void m284execute$lambda1(List list, File file) {
                Intrinsics.checkNotNullParameter(list, "$slaves");
                Intrinsics.checkNotNullParameter(file, "file");
                Model build = Model.Companion.build(file);
                if (build != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        TaskHandler taskHandler = (TaskHandler) it.next();
                        TaskHandler.Companion.download(taskHandler.getRuleUri(), taskHandler.getUseCase() + '_' + taskHandler.getVersionId() + "_rule", new ModelManager$TaskHandler$Companion$$ExternalSyntheticLambda1(taskHandler, build));
                    }
                }
            }

            /* access modifiers changed from: private */
            /* renamed from: execute$lambda-1$lambda-0  reason: not valid java name */
            public static final void m285execute$lambda1$lambda0(TaskHandler taskHandler, Model model, File file) {
                Intrinsics.checkNotNullParameter(taskHandler, "$slave");
                Intrinsics.checkNotNullParameter(file, "file");
                taskHandler.setModel(model);
                taskHandler.setRuleFile(file);
                Runnable access$getOnPostExecute$p = taskHandler.onPostExecute;
                if (access$getOnPostExecute$p != null) {
                    access$getOnPostExecute$p.run();
                }
            }

            private final void deleteOldFiles(String str, int i) {
                File[] listFiles;
                Utils utils = Utils.INSTANCE;
                File mlDir = Utils.getMlDir();
                if (mlDir != null && (listFiles = mlDir.listFiles()) != null) {
                    if (!(listFiles.length == 0)) {
                        String str2 = str + '_' + i;
                        int length = listFiles.length;
                        int i2 = 0;
                        while (i2 < length) {
                            File file = listFiles[i2];
                            i2++;
                            String name = file.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "name");
                            if (StringsKt.startsWith$default(name, str, false, 2, (Object) null) && !StringsKt.startsWith$default(name, str2, false, 2, (Object) null)) {
                                file.delete();
                            }
                        }
                    }
                }
            }

            private final void download(String str, String str2, FileDownloadTask.Callback callback) {
                Utils utils = Utils.INSTANCE;
                File file = new File(Utils.getMlDir(), str2);
                if (str == null || file.exists()) {
                    callback.onComplete(file);
                } else {
                    new FileDownloadTask(str, file, callback).execute(new String[0]);
                }
            }
        }
    }
}
