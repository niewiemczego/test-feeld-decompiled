package expo.modules.apploader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AppLoaderProvider {
    private static Map<String, HeadlessAppLoader> loaders = new HashMap();

    public static abstract class Callback {
        public void onComplete(boolean z, Exception exc) {
        }
    }

    public static HeadlessAppLoader getLoader(String str, Context context) {
        if (!loaders.containsKey(str)) {
            try {
                createLoader(str, context);
            } catch (Exception e) {
                Log.e("Expo", "Cannot initialize app loader. " + e.getMessage());
                e.printStackTrace();
                return null;
            }
        }
        return loaders.get(str);
    }

    private static void createLoader(String str, Context context) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("org.unimodules.core.AppLoader#" + str);
            if (string != null) {
                Class<?> cls = Class.forName(string);
                loaders.put(str, (HeadlessAppLoader) cls.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}));
                return;
            }
            throw new IllegalStateException("Unable to instantiate AppLoader!");
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalStateException("Unable to instantiate AppLoader!", e);
        }
    }
}
