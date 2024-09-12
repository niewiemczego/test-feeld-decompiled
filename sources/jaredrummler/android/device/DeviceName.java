package jaredrummler.android.device;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import io.sentry.protocol.Device;
import io.seon.androidsdk.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceName {
    private static Context a;
    private static final Logger b = Logger.withClass(DeviceName.class);

    public interface Callback {
        void a(DeviceInfo deviceInfo, Exception exc);
    }

    public static final class DeviceInfo {
        public final String a;
        public final String b;
        public final String c;
        public final String d;

        public DeviceInfo(String str, String str2, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        private DeviceInfo(JSONObject jSONObject) {
            this.a = jSONObject.getString(Device.JsonKeys.MANUFACTURER);
            this.b = jSONObject.getString("market_name");
            this.c = jSONObject.getString("codename");
            this.d = jSONObject.getString("model");
        }
    }

    public static final class Request {
        final Context a;
        final Handler b;
        String c;
        String d;

        private final class GetDeviceRunnable implements Runnable {
            final Callback a;
            DeviceInfo b;
            Exception c;
            final /* synthetic */ Request d;

            public void run() {
                try {
                    Request request = this.d;
                    this.b = DeviceName.a(request.a, request.c, request.d);
                } catch (Exception e) {
                    this.c = e;
                }
                this.d.b.post(new Runnable() {
                    public void run() {
                        GetDeviceRunnable getDeviceRunnable = GetDeviceRunnable.this;
                        getDeviceRunnable.a.a(getDeviceRunnable.b, getDeviceRunnable.c);
                    }
                });
            }
        }
    }

    private static String a(String str) {
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

    public static String b() {
        String str = Build.DEVICE;
        String str2 = Build.MODEL;
        return a(str, str2, a(str2));
    }

    private static Context a() {
        Context context = a;
        if (context != null) {
            return context;
        }
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
        } catch (Exception unused) {
            try {
                return (Application) Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke((Object) null, (Object[]) null);
            } catch (Exception unused2) {
                throw new RuntimeException("DeviceName must be initialized before usage.");
            }
        }
    }

    public static void b(Context context) {
        a = context.getApplicationContext();
    }

    public static DeviceInfo a(Context context) {
        return a(context.getApplicationContext(), Build.DEVICE, Build.MODEL);
    }

    public static DeviceInfo a(Context context, String str, String str2) {
        DeviceDatabase deviceDatabase;
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_names", 0);
        String format = String.format("%s:%s", new Object[]{str, str2});
        String string = sharedPreferences.getString(format, (String) null);
        if (string != null) {
            try {
                return new DeviceInfo(new JSONObject(string));
            } catch (JSONException e) {
                b.withCause(e);
            }
        }
        try {
            deviceDatabase = new DeviceDatabase(context);
            DeviceInfo a2 = deviceDatabase.a(str, str2);
            if (a2 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Device.JsonKeys.MANUFACTURER, (Object) a2.a);
                jSONObject.put("codename", (Object) a2.c);
                jSONObject.put("model", (Object) a2.d);
                jSONObject.put("market_name", (Object) a2.b);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(format, jSONObject.toString());
                edit.apply();
                deviceDatabase.close();
                return a2;
            }
            deviceDatabase.close();
            return (!str.equals(Build.DEVICE) || !Build.MODEL.equals(str2)) ? new DeviceInfo((String) null, (String) null, str, str2) : new DeviceInfo(Build.MANUFACTURER, str, str, str2);
        } catch (Exception e2) {
            b.withCause(e2);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String a(String str, String str2, String str3) {
        String str4 = a(a(), str, str2).b;
        return str4 == null ? str3 : str4;
    }
}
