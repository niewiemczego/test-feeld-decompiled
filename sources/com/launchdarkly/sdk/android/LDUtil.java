package com.launchdarkly.sdk.android;

import android.util.Base64;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.subsystems.ApplicationInfo;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.HttpConfiguration;
import com.launchdarkly.sdk.internal.http.HeadersTransformer;
import com.launchdarkly.sdk.internal.http.HttpProperties;
import com.launchdarkly.sdk.json.JsonSerialization;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Headers;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class LDUtil {
    static final String AUTH_SCHEME = "api_key ";
    private static Pattern TAG_VALUE_REGEX = Pattern.compile("^[-a-zA-Z0-9._]+$");
    static final String USER_AGENT_HEADER_VALUE = "AndroidClient/4.2.3";

    static boolean isHttpErrorRecoverable(int i) {
        return i < 400 || i >= 500 || i == 400 || i == 408 || i == 429;
    }

    LDUtil() {
    }

    static <T> Callback<T> noOpCallback() {
        return new Callback<T>() {
            public void onError(Throwable th) {
            }

            public void onSuccess(T t) {
            }
        };
    }

    static String applicationTagHeader(ApplicationInfo applicationInfo, LDLogger lDLogger) {
        String[][] strArr = {new String[]{"applicationId", "application-id", applicationInfo.getApplicationId()}, new String[]{"applicationVersion", "application-version", applicationInfo.getApplicationVersion()}};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            String[] strArr2 = strArr[i];
            String str = strArr2[0];
            String str2 = strArr2[1];
            String str3 = strArr2[2];
            if (str3 != null) {
                if (!TAG_VALUE_REGEX.matcher(str3).matches()) {
                    lDLogger.warn("Value of ApplicationInfo.{} contained invalid characters and was discarded", (Object) str);
                } else if (str3.length() > 64) {
                    lDLogger.warn("Value of ApplicationInfo.{} was longer than 64 characters and was discarded", (Object) str);
                } else {
                    arrayList.add(str2 + "/" + str3);
                }
            }
        }
        return String.join(" ", arrayList);
    }

    static Headers makeRequestHeaders(HttpConfiguration httpConfiguration, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : httpConfiguration.getDefaultHeaders()) {
            hashMap.put((String) next.getKey(), (String) next.getValue());
        }
        if (map != null) {
            hashMap.putAll(map);
        }
        if (httpConfiguration.getHeaderTransform() != null) {
            httpConfiguration.getHeaderTransform().updateHeaders(hashMap);
        }
        return Headers.of((Map<String, String>) hashMap);
    }

    static String urlSafeBase64Hash(String str) {
        try {
            return Base64.encodeToString(MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256).digest(str.getBytes(Charset.forName("UTF-8"))), 10);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    static String base64Url(LDContext lDContext) {
        return Base64.encodeToString(JsonSerialization.serialize(lDContext).getBytes(), 10);
    }

    static HttpProperties makeHttpProperties(ClientContext clientContext) {
        final HttpConfiguration http = clientContext.getHttp();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : http.getDefaultHeaders()) {
            hashMap.put((String) next.getKey(), (String) next.getValue());
        }
        AnonymousClass2 r0 = null;
        if (http.getHeaderTransform() != null) {
            r0 = new HeadersTransformer() {
                public void updateHeaders(Map<String, String> map) {
                    HttpConfiguration.this.getHeaderTransform().updateHeaders(map);
                }
            };
        }
        return new HttpProperties((long) http.getConnectTimeoutMillis(), hashMap, r0, (Proxy) null, (Authenticator) null, (SocketFactory) null, (long) http.getConnectTimeoutMillis(), (SSLSocketFactory) null, (X509TrustManager) null);
    }

    static void logExceptionAtErrorLevel(LDLogger lDLogger, Throwable th, String str, Object... objArr) {
        logException(lDLogger, th, true, str, objArr);
    }

    static void logExceptionAtWarnLevel(LDLogger lDLogger, Throwable th, String str, Object... objArr) {
        logException(lDLogger, th, false, str, objArr);
    }

    private static void logException(LDLogger lDLogger, Throwable th, boolean z, String str, Object... objArr) {
        String str2 = str + " - {}";
        Object exceptionSummary = LogValues.exceptionSummary(th);
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        copyOf[objArr.length] = exceptionSummary;
        if (z) {
            lDLogger.error(str2, copyOf);
        } else {
            lDLogger.warn(str2, copyOf);
        }
        lDLogger.debug(LogValues.exceptionTrace(th));
    }
}
