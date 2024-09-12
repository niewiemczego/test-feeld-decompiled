package com.facebook.internal.instrument.crashreport;

import android.util.Log;
import com.braze.Constants;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.ExceptionAnalyzer;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import io.sentry.protocol.Response;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "previousHandler", "(Ljava/lang/Thread$UncaughtExceptionHandler;)V", "uncaughtException", "", "t", "Ljava/lang/Thread;", "e", "", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CrashHandler.kt */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int MAX_CRASH_REPORT_NUM = 5;
    /* access modifiers changed from: private */
    public static final String TAG = CrashHandler.class.getCanonicalName();
    /* access modifiers changed from: private */
    public static CrashHandler instance;
    private final Thread.UncaughtExceptionHandler previousHandler;

    public /* synthetic */ CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, DefaultConstructorMarker defaultConstructorMarker) {
        this(uncaughtExceptionHandler);
    }

    @JvmStatic
    public static final synchronized void enable() {
        synchronized (CrashHandler.class) {
            Companion.enable();
        }
    }

    private CrashHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.previousHandler = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Intrinsics.checkNotNullParameter(thread, Constants.BRAZE_PUSH_TITLE_KEY);
        Intrinsics.checkNotNullParameter(th, "e");
        InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
        if (InstrumentUtility.isSDKRelatedException(th)) {
            ExceptionAnalyzer exceptionAnalyzer = ExceptionAnalyzer.INSTANCE;
            ExceptionAnalyzer.execute(th);
            InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
            InstrumentData.Builder.build(th, InstrumentData.Type.CrashReport).save();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.previousHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/facebook/internal/instrument/crashreport/CrashHandler$Companion;", "", "()V", "MAX_CRASH_REPORT_NUM", "", "TAG", "", "kotlin.jvm.PlatformType", "instance", "Lcom/facebook/internal/instrument/crashreport/CrashHandler;", "enable", "", "sendExceptionReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: CrashHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final synchronized void enable() {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                sendExceptionReports();
            }
            if (CrashHandler.instance != null) {
                Log.w(CrashHandler.TAG, "Already enabled!");
                return;
            }
            CrashHandler.instance = new CrashHandler(Thread.getDefaultUncaughtExceptionHandler(), (DefaultConstructorMarker) null);
            Thread.setDefaultUncaughtExceptionHandler(CrashHandler.instance);
        }

        private final void sendExceptionReports() {
            Utility utility = Utility.INSTANCE;
            if (!Utility.isDataProcessingRestricted()) {
                InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                File[] listExceptionReportFiles = InstrumentUtility.listExceptionReportFiles();
                Collection arrayList = new ArrayList(listExceptionReportFiles.length);
                for (File load : listExceptionReportFiles) {
                    InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                    arrayList.add(InstrumentData.Builder.load(load));
                }
                Collection arrayList2 = new ArrayList();
                for (Object next : (List) arrayList) {
                    if (((InstrumentData) next).isValid()) {
                        arrayList2.add(next);
                    }
                }
                List sortedWith = CollectionsKt.sortedWith((List) arrayList2, new CrashHandler$Companion$$ExternalSyntheticLambda0());
                JSONArray jSONArray = new JSONArray();
                Iterator it = RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
                while (it.hasNext()) {
                    jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                }
                InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
                InstrumentUtility.sendReports("crash_reports", jSONArray, new CrashHandler$Companion$$ExternalSyntheticLambda1(sortedWith));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-2  reason: not valid java name */
        public static final int m368sendExceptionReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        }

        /* access modifiers changed from: private */
        /* renamed from: sendExceptionReports$lambda-5  reason: not valid java name */
        public static final void m369sendExceptionReports$lambda5(List list, GraphResponse graphResponse) {
            Intrinsics.checkNotNullParameter(list, "$validReports");
            Intrinsics.checkNotNullParameter(graphResponse, Response.TYPE);
            try {
                if (graphResponse.getError() == null) {
                    JSONObject jsonObject = graphResponse.getJsonObject();
                    if (Intrinsics.areEqual((Object) jsonObject == null ? null : Boolean.valueOf(jsonObject.getBoolean("success")), (Object) true)) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((InstrumentData) it.next()).clear();
                        }
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }
}
