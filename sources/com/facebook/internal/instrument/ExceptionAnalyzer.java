package com.facebook.internal.instrument;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import io.sentry.protocol.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\r\u0010\n\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\u0006H\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/instrument/ExceptionAnalyzer;", "", "()V", "enabled", "", "enable", "", "execute", "e", "", "isDebug", "isDebug$facebook_core_release", "sendExceptionAnalysisReports", "sendExceptionAnalysisReports$facebook_core_release", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ExceptionAnalyzer.kt */
public final class ExceptionAnalyzer {
    public static final ExceptionAnalyzer INSTANCE = new ExceptionAnalyzer();
    private static boolean enabled;

    @JvmStatic
    public static final boolean isDebug$facebook_core_release() {
        return false;
    }

    private ExceptionAnalyzer() {
    }

    @JvmStatic
    public static final void enable() {
        ExceptionAnalyzer exceptionAnalyzer = INSTANCE;
        enabled = true;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            exceptionAnalyzer.sendExceptionAnalysisReports$facebook_core_release();
        }
    }

    @JvmStatic
    public static final void execute(Throwable th) {
        if (enabled && !isDebug$facebook_core_release() && th != null) {
            Set hashSet = new HashSet();
            StackTraceElement[] stackTrace = th.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace, "e.stackTrace");
            for (Object obj : (Object[]) stackTrace) {
                FeatureManager featureManager = FeatureManager.INSTANCE;
                String className = ((StackTraceElement) obj).getClassName();
                Intrinsics.checkNotNullExpressionValue(className, "it.className");
                FeatureManager.Feature feature = FeatureManager.getFeature(className);
                if (feature != FeatureManager.Feature.Unknown) {
                    FeatureManager featureManager2 = FeatureManager.INSTANCE;
                    FeatureManager.disableFeature(feature);
                    hashSet.add(feature.toString());
                }
            }
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                Collection collection = hashSet;
                if (!collection.isEmpty()) {
                    InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                    InstrumentData.Builder.build(new JSONArray((Collection<?>) collection)).save();
                }
            }
        }
    }

    public final void sendExceptionAnalysisReports$facebook_core_release() {
        Utility utility = Utility.INSTANCE;
        if (!Utility.isDataProcessingRestricted()) {
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            File[] listExceptionAnalysisReportFiles = InstrumentUtility.listExceptionAnalysisReportFiles();
            List arrayList = new ArrayList();
            int length = listExceptionAnalysisReportFiles.length;
            int i = 0;
            while (i < length) {
                File file = listExceptionAnalysisReportFiles[i];
                i++;
                InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                InstrumentData load = InstrumentData.Builder.load(file);
                if (load.isValid()) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("crash_shield", (Object) load.toString());
                        GraphRequest.Companion companion = GraphRequest.Companion;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        String format = String.format("%s/instruments", Arrays.copyOf(new Object[]{FacebookSdk.getApplicationId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        arrayList.add(companion.newPostRequest((AccessToken) null, format, jSONObject, new ExceptionAnalyzer$$ExternalSyntheticLambda0(load)));
                    } catch (JSONException unused) {
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                new GraphRequestBatch((Collection<GraphRequest>) arrayList).executeAsync();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendExceptionAnalysisReports$lambda-1  reason: not valid java name */
    public static final void m355sendExceptionAnalysisReports$lambda1(InstrumentData instrumentData, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(instrumentData, "$instrumentData");
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        try {
            if (graphResponse.getError() == null) {
                JSONObject jsonObject = graphResponse.getJsonObject();
                if (Intrinsics.areEqual((Object) jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), (Object) true)) {
                    instrumentData.clear();
                }
            }
        } catch (JSONException unused) {
        }
    }
}
