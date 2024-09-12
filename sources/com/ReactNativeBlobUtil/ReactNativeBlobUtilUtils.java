package com.ReactNativeBlobUtil;

import android.net.Uri;
import android.util.Base64;
import app.notifee.core.event.LogEvent;
import com.ReactNativeBlobUtil.Utils.PathResolver;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.OkHttpClient;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class ReactNativeBlobUtilUtils {
    public static X509TrustManager sharedTrustManager;

    public static String getMD5(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format(Locale.ROOT, "%02x", new Object[]{Integer.valueOf(b & 255)}));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
        return null;
    }

    public static void emitWarningEvent(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("event", LogEvent.LEVEL_WARN);
        createMap.putString("detail", str);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_MESSAGE, createMap);
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient(OkHttpClient okHttpClient) {
        try {
            X509TrustManager x509TrustManager = sharedTrustManager;
            if (x509TrustManager != null) {
                TrustManager[] trustManagerArr = {x509TrustManager};
                SSLContext instance = SSLContext.getInstance("SSL");
                instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
                SSLSocketFactory socketFactory = instance.getSocketFactory();
                OkHttpClient.Builder newBuilder = okHttpClient.newBuilder();
                newBuilder.sslSocketFactory(socketFactory, sharedTrustManager);
                newBuilder.hostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String str, SSLSession sSLSession) {
                        return true;
                    }
                });
                return newBuilder;
            }
            throw new IllegalStateException("Use of own trust manager but none defined");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] stringToBytes(String str, String str2) {
        if (str2.equalsIgnoreCase("ascii")) {
            return str.getBytes(Charset.forName("US-ASCII"));
        }
        if (str2.toLowerCase(Locale.ROOT).contains(ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64)) {
            return Base64.decode(str, 2);
        }
        if (str2.equalsIgnoreCase(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
            return str.getBytes(Charset.forName("UTF-8"));
        }
        return str.getBytes(Charset.forName("US-ASCII"));
    }

    public static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        if (!str.matches("\\w+\\:.*")) {
            return str;
        }
        if (str.startsWith("file://")) {
            return str.replace("file://", "");
        }
        Uri parse = Uri.parse(str);
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return str;
        }
        return PathResolver.getRealPathFromURI(ReactNativeBlobUtilImpl.RCTContext, parse);
    }

    public static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }

    public static boolean isContentUri(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT);
    }
}
