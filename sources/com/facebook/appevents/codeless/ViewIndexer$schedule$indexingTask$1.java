package com.facebook.appevents.codeless;

import java.util.TimerTask;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/appevents/codeless/ViewIndexer$schedule$indexingTask$1", "Ljava/util/TimerTask;", "run", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ViewIndexer.kt */
public final class ViewIndexer$schedule$indexingTask$1 extends TimerTask {
    final /* synthetic */ ViewIndexer this$0;

    ViewIndexer$schedule$indexingTask$1(ViewIndexer viewIndexer) {
        this.this$0 = viewIndexer;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x008c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            com.facebook.appevents.codeless.ViewIndexer r0 = r7.this$0     // Catch:{ Exception -> 0x00a5 }
            java.lang.ref.WeakReference r0 = com.facebook.appevents.codeless.ViewIndexer.access$getActivityReference$p(r0)     // Catch:{ Exception -> 0x00a5 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x00a5 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ Exception -> 0x00a5 }
            android.view.View r1 = com.facebook.appevents.internal.AppEventUtility.getRootView(r0)     // Catch:{ Exception -> 0x00a5 }
            if (r0 == 0) goto L_0x00a4
            if (r1 != 0) goto L_0x0018
            goto L_0x00a4
        L_0x0018:
            java.lang.Class r0 = r0.getClass()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r0 = r0.getSimpleName()     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.CodelessManager r2 = com.facebook.appevents.codeless.CodelessManager.INSTANCE     // Catch:{ Exception -> 0x00a5 }
            boolean r2 = com.facebook.appevents.codeless.CodelessManager.getIsAppIndexingEnabled$facebook_core_release()     // Catch:{ Exception -> 0x00a5 }
            if (r2 != 0) goto L_0x0029
            return
        L_0x0029:
            com.facebook.internal.InternalSettings r2 = com.facebook.internal.InternalSettings.INSTANCE     // Catch:{ Exception -> 0x00a5 }
            boolean r2 = com.facebook.internal.InternalSettings.isUnityApp()     // Catch:{ Exception -> 0x00a5 }
            if (r2 == 0) goto L_0x0037
            com.facebook.appevents.codeless.internal.UnityReflection r0 = com.facebook.appevents.codeless.internal.UnityReflection.INSTANCE     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.internal.UnityReflection.captureViewHierarchy()     // Catch:{ Exception -> 0x00a5 }
            return
        L_0x0037:
            java.util.concurrent.FutureTask r2 = new java.util.concurrent.FutureTask     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker r3 = new com.facebook.appevents.codeless.ViewIndexer$ScreenshotTaker     // Catch:{ Exception -> 0x00a5 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00a5 }
            java.util.concurrent.Callable r3 = (java.util.concurrent.Callable) r3     // Catch:{ Exception -> 0x00a5 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.ViewIndexer r3 = r7.this$0     // Catch:{ Exception -> 0x00a5 }
            android.os.Handler r3 = com.facebook.appevents.codeless.ViewIndexer.access$getUiThreadHandler$p(r3)     // Catch:{ Exception -> 0x00a5 }
            r4 = r2
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch:{ Exception -> 0x00a5 }
            r3.post(r4)     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r3 = ""
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x005d }
            java.lang.Object r2 = r2.get(r4, r6)     // Catch:{ Exception -> 0x005d }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x005d }
            r3 = r2
            goto L_0x0069
        L_0x005d:
            r2 = move-exception
            java.lang.String r4 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r5 = "Failed to take screenshot."
            java.lang.Throwable r2 = (java.lang.Throwable) r2     // Catch:{ Exception -> 0x00a5 }
            android.util.Log.e(r4, r5, r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x0069:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a5 }
            r2.<init>()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r4 = "screenname"
            r2.put((java.lang.String) r4, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x008c }
            java.lang.String r0 = "screenshot"
            r2.put((java.lang.String) r0, (java.lang.Object) r3)     // Catch:{ JSONException -> 0x008c }
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x008c }
            r0.<init>()     // Catch:{ JSONException -> 0x008c }
            com.facebook.appevents.codeless.internal.ViewHierarchy r3 = com.facebook.appevents.codeless.internal.ViewHierarchy.INSTANCE     // Catch:{ JSONException -> 0x008c }
            org.json.JSONObject r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getDictionaryOfView(r1)     // Catch:{ JSONException -> 0x008c }
            r0.put((java.lang.Object) r1)     // Catch:{ JSONException -> 0x008c }
            java.lang.String r1 = "view"
            r2.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x008c }
            goto L_0x0095
        L_0x008c:
            java.lang.String r0 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = "Failed to create JSONObject"
            android.util.Log.e(r0, r1)     // Catch:{ Exception -> 0x00a5 }
        L_0x0095:
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r1 = "viewTree.toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.ViewIndexer r1 = r7.this$0     // Catch:{ Exception -> 0x00a5 }
            com.facebook.appevents.codeless.ViewIndexer.access$sendToServer(r1, r0)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00b1
        L_0x00a4:
            return
        L_0x00a5:
            r0 = move-exception
            java.lang.String r1 = com.facebook.appevents.codeless.ViewIndexer.access$getTAG$cp()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.String r2 = "UI Component tree indexing failure!"
            android.util.Log.e(r1, r2, r0)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.ViewIndexer$schedule$indexingTask$1.run():void");
    }
}
