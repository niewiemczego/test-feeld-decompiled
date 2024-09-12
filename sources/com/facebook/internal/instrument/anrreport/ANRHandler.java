package com.facebook.internal.instrument.anrreport;

import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import io.sentry.protocol.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/internal/instrument/anrreport/ANRHandler;", "", "()V", "MAX_ANR_REPORT_NUM", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enable", "", "sendANRReports", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ANRHandler.kt */
public final class ANRHandler {
    public static final ANRHandler INSTANCE = new ANRHandler();
    private static final int MAX_ANR_REPORT_NUM = 5;
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private ANRHandler() {
    }

    @JvmStatic
    public static final synchronized void enable() {
        Class<ANRHandler> cls = ANRHandler.class;
        synchronized (cls) {
            if (!CrashShieldHandler.isObjectCrashing(cls)) {
                try {
                    if (!enabled.getAndSet(true)) {
                        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
                            sendANRReports();
                        }
                        ANRDetector aNRDetector = ANRDetector.INSTANCE;
                        ANRDetector.start();
                    }
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, cls);
                }
            }
        }
    }

    @JvmStatic
    public static final void sendANRReports() {
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Utility utility = Utility.INSTANCE;
                if (!Utility.isDataProcessingRestricted()) {
                    InstrumentUtility instrumentUtility = InstrumentUtility.INSTANCE;
                    File[] listAnrReportFiles = InstrumentUtility.listAnrReportFiles();
                    Collection arrayList = new ArrayList(listAnrReportFiles.length);
                    for (File load : listAnrReportFiles) {
                        InstrumentData.Builder builder = InstrumentData.Builder.INSTANCE;
                        arrayList.add(InstrumentData.Builder.load(load));
                    }
                    Collection arrayList2 = new ArrayList();
                    for (Object next : (List) arrayList) {
                        if (((InstrumentData) next).isValid()) {
                            arrayList2.add(next);
                        }
                    }
                    List sortedWith = CollectionsKt.sortedWith((List) arrayList2, new ANRHandler$$ExternalSyntheticLambda0());
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = RangesKt.until(0, Math.min(sortedWith.size(), 5)).iterator();
                    while (it.hasNext()) {
                        jSONArray.put(sortedWith.get(((IntIterator) it).nextInt()));
                    }
                    InstrumentUtility instrumentUtility2 = InstrumentUtility.INSTANCE;
                    InstrumentUtility.sendReports("anr_reports", jSONArray, new ANRHandler$$ExternalSyntheticLambda1(sortedWith));
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-2  reason: not valid java name */
    public static final int m366sendANRReports$lambda2(InstrumentData instrumentData, InstrumentData instrumentData2) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return 0;
        }
        try {
            Intrinsics.checkNotNullExpressionValue(instrumentData2, "o2");
            return instrumentData.compareTo(instrumentData2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sendANRReports$lambda-5  reason: not valid java name */
    public static final void m367sendANRReports$lambda5(List list, GraphResponse graphResponse) {
        Class<ANRHandler> cls = ANRHandler.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
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
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }
}
