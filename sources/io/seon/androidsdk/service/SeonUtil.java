package io.seon.androidsdk.service;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.json.JSONArray;
import org.json.JSONObject;

class SeonUtil {
    static AtomicInteger a = new AtomicInteger(0);

    static void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception unused) {
        }
    }

    public static Activity b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Map map = (Map) declaredField.get(invoke);
            if (map != null) {
                for (Object next : map.values()) {
                    Class<?> cls2 = next.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(next)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        return (Activity) declaredField3.get(next);
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    static int c() {
        try {
            return a.get();
        } catch (Exception unused) {
            return -1;
        }
    }

    static void d() {
        try {
            a.incrementAndGet();
        } catch (Exception unused) {
        }
    }

    static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }

    static boolean b(Context context) {
        return a(context) && ((Activity) context).getWindow().getDecorView().getRootView() != null;
    }

    static boolean a(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    static String b(String str) {
        return a(str.getBytes("UTF-8"));
    }

    static JSONArray a(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        for (Object next : collection) {
            if (next instanceof Map) {
                next = a((Map) next);
            } else if (next instanceof Collection) {
                next = a((Collection) next);
            }
            jSONArray.put(next);
        }
        return jSONArray;
    }

    static synchronized void b(Runnable runnable) {
        synchronized (SeonUtil.class) {
            a(runnable, 500);
        }
    }

    static JSONObject a(Map... mapArr) {
        JSONObject jSONObject = new JSONObject();
        for (Map map : mapArr) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        try {
                            if (value instanceof Collection) {
                                value = a((Collection) value);
                            } else if (value instanceof Map) {
                                value = a((Map) value);
                            }
                            jSONObject.put(str, value);
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return sb.toString();
    }

    static void a() {
        try {
            a.decrementAndGet();
        } catch (Exception unused) {
        }
    }

    static String a(String str, Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            String str2 = (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{str});
            if (str2 == null || str2.length() == 0) {
                return null;
            }
            return str2;
        } catch (Exception unused) {
        }
    }

    static boolean a(Context context) {
        return context instanceof Activity;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, CountDownLatch countDownLatch) {
        runnable.run();
        countDownLatch.countDown();
    }

    static String a(byte[] bArr) {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        instance.reset();
        instance.update(bArr);
        return b(instance.digest());
    }

    static synchronized void a(Runnable runnable, int i) {
        synchronized (SeonUtil.class) {
            Looper mainLooper = Looper.getMainLooper();
            Looper myLooper = Looper.myLooper();
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SeonUtil$$ExternalSyntheticLambda0 seonUtil$$ExternalSyntheticLambda0 = new SeonUtil$$ExternalSyntheticLambda0(runnable, countDownLatch);
            if (myLooper == mainLooper) {
                seonUtil$$ExternalSyntheticLambda0.run();
            } else {
                if (myLooper == null) {
                    Looper.prepare();
                }
                new Handler(mainLooper).post(seonUtil$$ExternalSyntheticLambda0);
            }
            try {
                if (countDownLatch.await((long) i, TimeUnit.MILLISECONDS)) {
                    countDownLatch.countDown();
                } else {
                    throw new TimeoutException();
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                countDownLatch.countDown();
                throw th;
            }
        }
    }
}
