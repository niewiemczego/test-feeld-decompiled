package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import com.appsflyer.AFLogger;
import com.facebook.common.util.UriUtil;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class AFd1fSDK extends AFd1qSDK<Map<String, Object>> {
    private static final int afDebugLog = ((int) TimeUnit.SECONDS.toMillis(2));
    private final Map<String, Object> AFLogger;
    private final List<String> AFVersionDeclaration;
    private Map<String, Object> afErrorLog;
    private final Context afInfoLog;
    private final Uri afRDLog;

    public final long AFInAppEventParameterName() {
        return 60000;
    }

    public final boolean values() {
        return false;
    }

    public AFd1fSDK(Context context, Map<String, Object> map, Uri uri, List<String> list) {
        super(AFd1sSDK.RESOLVE_ESP, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, "ResolveEsp");
        this.afInfoLog = context;
        this.AFLogger = map;
        this.afRDLog = uri;
        this.AFVersionDeclaration = list;
    }

    public final AFd1tSDK AFInAppEventType() throws Exception {
        if (!AFInAppEventParameterName(this.afRDLog.toString())) {
            AFb1xSDK.AFInAppEventType().valueOf(this.afInfoLog, this.AFLogger, this.afRDLog);
            return AFd1tSDK.SUCCESS;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String obj = this.afRDLog.toString();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        Integer num = null;
        String str = null;
        while (true) {
            if (i >= 5) {
                break;
            }
            Map<String, Object> values = values(Uri.parse(obj));
            String str2 = (String) values.get(UriUtil.LOCAL_RESOURCE_SCHEME);
            Integer num2 = (Integer) values.get("status");
            String str3 = (String) values.get("error");
            if (str2 == null || !AFInAppEventParameterName(str2)) {
                Integer num3 = num2;
                str = str3;
                obj = str2;
                num = num3;
            } else {
                if (i < 4) {
                    arrayList.add(str2);
                }
                i++;
                Integer num4 = num2;
                str = str3;
                obj = str2;
                num = num4;
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put(UriUtil.LOCAL_RESOURCE_SCHEME, obj != null ? obj : "");
        hashMap.put("status", Integer.valueOf(num != null ? num.intValue() : -1));
        if (str != null) {
            hashMap.put("error", str);
        }
        if (!arrayList.isEmpty()) {
            hashMap.put("redirects", arrayList);
        }
        hashMap.put("latency", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        synchronized (this.AFLogger) {
            this.AFLogger.put("af_deeplink_r", hashMap);
            this.AFLogger.put("af_deeplink", this.afRDLog.toString());
        }
        AFb1xSDK.AFInAppEventType().valueOf(this.afInfoLog, this.AFLogger, obj != null ? Uri.parse(obj) : this.afRDLog);
        this.afErrorLog = hashMap;
        return AFd1tSDK.SUCCESS;
    }

    private static Map<String, Object> values(Uri uri) {
        HashMap hashMap = new HashMap();
        try {
            AFLogger.afDebugLog(new StringBuilder("ESP deeplink resolving is started: ").append(uri.toString()).toString());
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uri.toString()).openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            int i = afDebugLog;
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setRequestProperty("User-agent", "Dalvik/2.1.0 (Linux; U; Android 6.0.1; Nexus 5 Build/M4B30Z)");
            httpURLConnection.setRequestProperty("af-esp", "6.10.3");
            int responseCode = httpURLConnection.getResponseCode();
            hashMap.put("status", Integer.valueOf(responseCode));
            if (300 <= responseCode && responseCode <= 305) {
                hashMap.put(UriUtil.LOCAL_RESOURCE_SCHEME, httpURLConnection.getHeaderField("Location"));
            }
            httpURLConnection.disconnect();
            AFLogger.afDebugLog("ESP deeplink resolving is finished");
        } catch (Throwable th) {
            hashMap.put("error", th.getLocalizedMessage());
            AFLogger.afErrorLog(th.getMessage(), th);
        }
        return hashMap;
    }

    private boolean AFInAppEventParameterName(String str) {
        if (str.contains("af_tranid=")) {
            return false;
        }
        AFLogger.afRDLog(new StringBuilder("Validate if link ").append(str).append(" belongs to ESP domains: ").append(this.AFVersionDeclaration).toString());
        try {
            return this.AFVersionDeclaration.contains(new URL(str).getHost());
        } catch (MalformedURLException e) {
            AFLogger.afErrorLogForExcManagerOnly("MalformedURLException ESP link", e);
            return false;
        }
    }
}
