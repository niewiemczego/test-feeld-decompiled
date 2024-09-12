package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007J!\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/facebook/appevents/internal/HashUtils;", "", "()V", "BUFFER_SIZE", "", "MD5", "", "TAG", "kotlin.jvm.PlatformType", "TRUSTED_CERTS", "", "[Ljava/lang/String;", "computeChecksum", "path", "computeChecksumWithPackageManager", "context", "Landroid/content/Context;", "nanosTimeout", "", "(Landroid/content/Context;Ljava/lang/Long;)Ljava/lang/String;", "computeFileMd5", "file", "Ljava/io/File;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: HashUtils.kt */
public final class HashUtils {
    private static final int BUFFER_SIZE = 1024;
    public static final HashUtils INSTANCE = new HashUtils();
    private static final String MD5 = "MD5";
    /* access modifiers changed from: private */
    public static final String TAG = "HashUtils";
    private static final String[] TRUSTED_CERTS = {"MIIEQzCCAyugAwIBAgIJAMLgh0ZkSjCNMA0GCSqGSIb3DQEBBAUAMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDAeFw0wODA4MjEyMzEzMzRaFw0zNjAxMDcyMzEzMzRaMHQxCzAJBgNVBAYTAlVTMRMwEQYDVQQIEwpDYWxpZm9ybmlhMRYwFAYDVQQHEw1Nb3VudGFpbiBWaWV3MRQwEgYDVQQKEwtHb29nbGUgSW5jLjEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBAKtWLgDYO6IIrgqWbxJOKdoR8qtW0I9Y4sypEwPpt1TTcvZApxsdyxMJZ2JORland2qSGT2y5b+3JKkedxiLDmpHpDsz2WCbdxgxRczfey5YZnTJ4VZbH0xqWVW/8lGmPav5xVwnIiJS6HXk+BVKZF+JcWjAsb/GEuq/eFdpuzSqeYTcfi6idkyugwfYwXFU1+5fZKUaRKYCwkkFQVfcAs1fXA5V+++FGfvjJ/CxURaSxaBvGdGDhfXE28LWuT9ozCl5xw4Yq5OGazvV24mZVSoOO0yZ31j7kYvtwYK6NeADwbSxDdJEqO4k//0zOHKrUiGYXtqw/A0LFFtqoZKFjnkCAQOjgdkwgdYwHQYDVR0OBBYEFMd9jMIhF1Ylmn/Tgt9r45jk14alMIGmBgNVHSMEgZ4wgZuAFMd9jMIhF1Ylmn/Tgt9r45jk14aloXikdjB0MQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEUMBIGA1UEChMLR29vZ2xlIEluYy4xEDAOBgNVBAsTB0FuZHJvaWQxEDAOBgNVBAMTB0FuZHJvaWSCCQDC4IdGZEowjTAMBgNVHRMEBTADAQH/MA0GCSqGSIb3DQEBBAUAA4IBAQBt0lLO74UwLDYKqs6Tm8/yzKkEu116FmH4rkaymUIE0P9KaMftGlMexFlaYjzmB2OxZyl6euNXEsQH8gjwyxCUKRJNexBiGcCEyj6z+a1fuHHvkiaai+KL8W1EyNmgjmyy8AW7P+LLlkR+ho5zEHatRbM/YAnqGcFh5iZBqpknHf1SKMXFh4dd239FJ1jWYfbMDMy3NS5CTMQ2XFI1MvcyUTdZPErjQfTbQe3aDQsQcafEQPD+nqActifKZ0Np0IS9L9kR/wbNvyz6ENwPiTrjV2KRkEjH78ZMcUQXg0L3BYHJ3lc69Vs5Ddf9uUGGMYldX3WfMBEmh/9iFBDAaTCK", "MIIEqDCCA5CgAwIBAgIJANWFuGx90071MA0GCSqGSIb3DQEBBAUAMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTAeFw0wODA0MTUyMzM2NTZaFw0zNTA5MDEyMzM2NTZaMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgCggEBANbOLggKv+IxTdGNs8/TGFy0PTP6DHThvbbR24kT9ixcOd9W+EaBPWW+wPPKQmsHxajtWjmQwWfna8mZuSeJS48LIgAZlKkpFeVyxW0qMBujb8X8ETrWy550NaFtI6t9+u7hZeTfHwqNvacKhp1RbE6dBRGWynwMVX8XW8N1+UjFaq6GCJukT4qmpN2afb8sCjUigq0GuMwYXrFVee74bQgLHWGJwPmvmLHC69EH6kWr22ijx4OKXlSIx2xT1AsSHee70w5iDBiK4aph27yH3TxkXy9V89TDdexAcKk/cVHYNnDBapcavl7y0RiQ4biu8ymM8Ga/nmzhRKya6G0cGw8CAQOjgfwwgfkwHQYDVR0OBBYEFI0cxb6VTEM8YYY6FbBMvAPyT+CyMIHJBgNVHSMEgcEwgb6AFI0cxb6VTEM8YYY6FbBMvAPyT+CyoYGapIGXMIGUMQswCQYDVQQGEwJVUzETMBEGA1UECBMKQ2FsaWZvcm5pYTEWMBQGA1UEBxMNTW91bnRhaW4gVmlldzEQMA4GA1UEChMHQW5kcm9pZDEQMA4GA1UECxMHQW5kcm9pZDEQMA4GA1UEAxMHQW5kcm9pZDEiMCAGCSqGSIb3DQEJARYTYW5kcm9pZEBhbmRyb2lkLmNvbYIJANWFuGx90071MAwGA1UdEwQFMAMBAf8wDQYJKoZIhvcNAQEEBQADggEBABnTDPEF+3iSP0wNfdIjIz1AlnrPzgAIHVvXxunW7SBrDhEglQZBbKJEk5kT0mtKoOD1JMrSu1xuTKEBahWRbqHsXclaXjoBADb0kkjVEJu/Lh5hgYZnOjvlba8Ld7HCKePCVePoTJBdI4fvugnL8TsgK05aIskyY0hKI9L8KfqfGTl1lzOv2KoWD0KWwtAWPoGChZxmQ+nBli+gwYMzM1vAkP+aayLe0a1EQimlOalO762r0GXO0ks+UeXde2Z4e+8S/pf7pITEI/tP+MxJTALw9QUWEv9lKTk+jkbqxbsh8nfBUapfKqYn0eidpwq2AzVp3juYl7//fKnaPhJD9gs="};

    private HashUtils() {
    }

    @JvmStatic
    public static final String computeChecksum(String str) throws Exception {
        return INSTANCE.computeFileMd5(new File(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String computeFileMd5(java.io.File r7) throws java.lang.Exception {
        /*
            r6 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r7)
            java.io.InputStream r1 = (java.io.InputStream) r1
            r7 = 1024(0x400, float:1.435E-42)
            r0.<init>(r1, r7)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r1
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r2 = r0
            java.io.BufferedInputStream r2 = (java.io.BufferedInputStream) r2     // Catch:{ all -> 0x0045 }
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ all -> 0x0045 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0045 }
        L_0x001f:
            int r4 = r2.read(r7)     // Catch:{ all -> 0x0045 }
            if (r4 <= 0) goto L_0x0029
            r5 = 0
            r3.update(r7, r5, r4)     // Catch:{ all -> 0x0045 }
        L_0x0029:
            r5 = -1
            if (r4 != r5) goto L_0x001f
            java.math.BigInteger r7 = new java.math.BigInteger     // Catch:{ all -> 0x0045 }
            r2 = 1
            byte[] r3 = r3.digest()     // Catch:{ all -> 0x0045 }
            r7.<init>(r2, r3)     // Catch:{ all -> 0x0045 }
            r2 = 16
            java.lang.String r7 = r7.toString(r2)     // Catch:{ all -> 0x0045 }
            java.lang.String r2 = "BigInteger(1, md.digest()).toString(16)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)     // Catch:{ all -> 0x0045 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r7
        L_0x0045:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.internal.HashUtils.computeFileMd5(java.io.File):java.lang.String");
    }

    @JvmStatic
    public static final String computeChecksumWithPackageManager(Context context, Long l) {
        Intrinsics.checkNotNullParameter(context, "context");
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        String[] strArr = TRUSTED_CERTS;
        Collection arrayList = new ArrayList(strArr.length);
        for (String decode : strArr) {
            arrayList.add(instance.generateCertificate(new ByteArrayInputStream(Base64.decode(decode, 0))));
        }
        List mutableList = CollectionsKt.toMutableList((List) arrayList);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition newCondition = reentrantLock.newCondition();
        reentrantLock.lock();
        try {
            Field field = Class.forName("android.content.pm.Checksum").getField("TYPE_WHOLE_MD5");
            Intrinsics.checkNotNullExpressionValue(field, "checksumClass.getField(\"TYPE_WHOLE_MD5\")");
            Object obj = field.get((Object) null);
            Class<?> cls = Class.forName("android.content.pm.PackageManager$OnChecksumsReadyListener");
            Object newProxyInstance = Proxy.newProxyInstance(HashUtils.class.getClassLoader(), new Class[]{cls}, new HashUtils$computeChecksumWithPackageManager$listener$1(obj, objectRef, reentrantLock, newCondition));
            Intrinsics.checkNotNullExpressionValue(newProxyInstance, "var resultChecksum: String? = null\n    val lock = ReentrantLock()\n    val checksumReady = lock.newCondition()\n    lock.lock()\n\n    try {\n      val checksumClass = Class.forName(\"android.content.pm.Checksum\")\n      val typeWholeMd5Field: Field = checksumClass.getField(\"TYPE_WHOLE_MD5\")\n      val TYPE_WHOLE_MD5 = typeWholeMd5Field.get(null)\n      val checksumReadyListenerClass =\n          Class.forName(\"android.content.pm.PackageManager\\$OnChecksumsReadyListener\")\n      val listener: Any =\n          Proxy.newProxyInstance(\n              HashUtils::class.java.classLoader,\n              arrayOf(checksumReadyListenerClass),\n              object : InvocationHandler {\n                override operator fun invoke(o: Any?, method: Method, objects: Array<Any>): Any? {\n                  try {\n                    if (method.name == \"onChecksumsReady\" &&\n                        objects.size == 1 &&\n                        objects[0] is List<*>) {\n                      val list = objects[0] as List<*>\n                      for (c in list) {\n                        if (c != null) {\n                          val getSplitNameMethod: Method = c.javaClass.getMethod(\"getSplitName\")\n                          val getTypeMethod: Method = c.javaClass.getMethod(\"getType\")\n                          if (getSplitNameMethod.invoke(c) == null &&\n                              getTypeMethod.invoke(c) == TYPE_WHOLE_MD5) {\n                            val getValueMethod: Method = c.javaClass.getMethod(\"getValue\")\n                            val checksumValue = getValueMethod.invoke(c) as ByteArray\n                            resultChecksum = BigInteger(1, checksumValue).toString(16)\n                            lock.lock()\n                            try {\n                              checksumReady.signalAll()\n                            } finally {\n                              lock.unlock()\n                            }\n                            return null\n                          }\n                        }\n                      }\n                    }\n                  } catch (t: Throwable) {\n                    Log.d(TAG, \"Can't fetch checksum.\", t)\n                  }\n                  return null\n                }\n              })");
            Method method = PackageManager.class.getMethod("requestChecksums", new Class[]{String.class, Boolean.TYPE, Integer.TYPE, List.class, cls});
            Intrinsics.checkNotNullExpressionValue(method, "PackageManager::class\n              .java\n              .getMethod(\n                  \"requestChecksums\",\n                  String::class.java,\n                  Boolean::class.javaPrimitiveType,\n                  Int::class.javaPrimitiveType,\n                  MutableList::class.java,\n                  checksumReadyListenerClass)");
            method.invoke(context.getPackageManager(), new Object[]{context.getPackageName(), false, obj, CollectionsKt.toMutableList(mutableList), newProxyInstance});
            if (l == null) {
                newCondition.await();
            } else {
                newCondition.awaitNanos(l.longValue());
            }
            String str = (String) objectRef.element;
            reentrantLock.unlock();
            return str;
        } catch (Throwable unused) {
            reentrantLock.unlock();
            return null;
        }
    }
}
