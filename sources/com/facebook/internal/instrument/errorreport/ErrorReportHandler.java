package com.facebook.internal.instrument.errorreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentUtility;
import io.sentry.protocol.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\u0013\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000e\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/internal/instrument/errorreport/ErrorReportHandler;", "", "()V", "MAX_ERROR_REPORT_NUM", "", "enable", "", "listErrorReportFiles", "", "Ljava/io/File;", "()[Ljava/io/File;", "save", "msg", "", "sendErrorReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ErrorReportHandler.kt */
public final class ErrorReportHandler {
    public static final ErrorReportHandler INSTANCE = new ErrorReportHandler();
    private static final int MAX_ERROR_REPORT_NUM = 1000;

    private ErrorReportHandler() {
    }

    @JvmStatic
    public static final void save(String str) {
        try {
            new ErrorReportData(str).save();
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final void enable() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            sendErrorReports();
        }
    }

    @JvmStatic
    public static final void sendErrorReports() {
        Utility utility = Utility.INSTANCE;
        if (!Utility.isDataProcessingRestricted()) {
            File[] listErrorReportFiles = listErrorReportFiles();
            ArrayList arrayList = new ArrayList();
            int length = listErrorReportFiles.length;
            int i = 0;
            int i2 = 0;
            while (i2 < length) {
                File file = listErrorReportFiles[i2];
                i2++;
                ErrorReportData errorReportData = new ErrorReportData(file);
                if (errorReportData.isValid()) {
                    arrayList.add(errorReportData);
                }
            }
            CollectionsKt.sortWith(arrayList, new ErrorReportHandler$$ExternalSyntheticLambda0());
            JSONArray jSONArray = new JSONArray();
            while (i < arrayList.size() && i < 1000) {
                jSONArray.put(arrayList.get(i));
                i++;
            }
            InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
            InstrumentUtility.sendReports("error_reports", jSONArray, new ErrorReportHandler$$ExternalSyntheticLambda1(arrayList));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-0  reason: not valid java name */
    public static final int m372sendErrorReports$lambda0(ErrorReportData errorReportData, ErrorReportData errorReportData2) {
        Intrinsics.checkNotNullExpressionValue(errorReportData2, "o2");
        return errorReportData.compareTo(errorReportData2);
    }

    /* access modifiers changed from: private */
    /* renamed from: sendErrorReports$lambda-2  reason: not valid java name */
    public static final void m373sendErrorReports$lambda2(ArrayList arrayList, GraphResponse graphResponse) {
        Intrinsics.checkNotNullParameter(arrayList, "$validReports");
        Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
        try {
            if (graphResponse.getError() == null) {
                JSONObject jsonObject = graphResponse.getJsonObject();
                if (Intrinsics.areEqual((Object) jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), (Object) true)) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ErrorReportData) it.next()).clear();
                    }
                }
            }
        } catch (JSONException unused) {
        }
    }

    @JvmStatic
    public static final File[] listErrorReportFiles() {
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        File instrumentReportDir = InstrumentUtility.getInstrumentReportDir();
        if (instrumentReportDir == null) {
            return new File[0];
        }
        File[] listFiles = instrumentReportDir.listFiles(new ErrorReportHandler$$ExternalSyntheticLambda2());
        Intrinsics.checkNotNullExpressionValue(listFiles, "reportDir.listFiles { dir, name ->\n      name.matches(Regex(String.format(\"^%s[0-9]+.json$\", InstrumentUtility.ERROR_REPORT_PREFIX)))\n    }");
        return listFiles;
    }

    /* access modifiers changed from: private */
    /* renamed from: listErrorReportFiles$lambda-3  reason: not valid java name */
    public static final boolean m371listErrorReportFiles$lambda3(File file, String str) {
        Intrinsics.checkNotNullExpressionValue(str, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("^%s[0-9]+.json$", Arrays.copyOf(new Object[]{InstrumentUtility.ERROR_REPORT_PREFIX}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return new Regex(format).matches(str);
    }
}
