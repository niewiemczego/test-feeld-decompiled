package expo.modules.core;

import android.content.Context;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ExportedModule implements RegistryLifecycleListener {
    private Context mContext;
    private Map<String, MethodInfo> mExportedMethodInfos;
    private Map<String, Method> mExportedMethods;

    public abstract String getName();

    public class MethodInfo {
        private Class<?>[] mParameterTypes;

        MethodInfo(Method method) {
            this.mParameterTypes = method.getParameterTypes();
        }

        public Class<?>[] getParameterTypes() {
            return this.mParameterTypes;
        }
    }

    public ExportedModule(Context context) {
        this.mContext = context;
    }

    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(Collections.emptyMap());
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    public Map<String, MethodInfo> getExportedMethodInfos() {
        Map<String, MethodInfo> map = this.mExportedMethodInfos;
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : getExportedMethods().entrySet()) {
            hashMap.put((String) next.getKey(), new MethodInfo((Method) next.getValue()));
        }
        this.mExportedMethodInfos = hashMap;
        return hashMap;
    }

    public Object invokeExportedMethod(String str, Collection<Object> collection) throws NoSuchMethodException, RuntimeException {
        Method method = this.mExportedMethods.get(str);
        if (method != null) {
            int length = method.getParameterTypes().length;
            if (collection.size() == length) {
                Class[] parameterTypes = method.getParameterTypes();
                Iterator<Object> it = collection.iterator();
                ArrayList arrayList = new ArrayList(collection.size());
                for (int i = 0; i < length; i++) {
                    arrayList.add(transformArgumentToClass(it.next(), parameterTypes[i]));
                }
                try {
                    return method.invoke(this, arrayList.toArray());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Exception occurred while executing exported method " + str + " on module " + getName() + ": " + e.getMessage(), e);
                } catch (InvocationTargetException e2) {
                    e2.printStackTrace();
                    throw new RuntimeException("Exception occurred while executing exported method " + str + " on module " + getName() + ": " + e2.getCause().getMessage(), e2.getCause());
                }
            } else {
                throw new IllegalArgumentException("Method " + str + " on class " + getName() + " expects " + length + " arguments, whereas " + collection.size() + " arguments have been provided.");
            }
        } else {
            throw new NoSuchMethodException("Module " + getName() + "does not export method " + str + ".");
        }
    }

    /* access modifiers changed from: protected */
    public Object transformArgumentToClass(Object obj, Class<?> cls) {
        return ArgumentsHelper.validatedArgumentForClass(obj, cls);
    }

    public Map<String, Method> getExportedMethods() {
        Map<String, Method> map = this.mExportedMethods;
        if (map != null) {
            return map;
        }
        this.mExportedMethods = new HashMap();
        Class cls = getClass();
        while (cls != null && ExportedModule.class.isAssignableFrom(cls)) {
            for (Map.Entry next : getExportedMethods(cls).entrySet()) {
                if (!this.mExportedMethods.containsKey(next.getKey())) {
                    this.mExportedMethods.put((String) next.getKey(), (Method) next.getValue());
                }
            }
            cls = cls.getSuperclass();
        }
        return this.mExportedMethods;
    }

    /* access modifiers changed from: protected */
    public Map<String, Method> getExportedMethods(Class cls) {
        HashMap hashMap = new HashMap();
        for (Method method : cls.getDeclaredMethods()) {
            if (method.getAnnotation(ExpoMethod.class) != null) {
                String name = method.getName();
                Class<Promise>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length < 1) {
                    throw new IllegalArgumentException("Method " + name + " of Java Module " + getName() + " does not define any arguments - minimum argument set is a Promise");
                } else if (parameterTypes[parameterTypes.length - 1] != Promise.class) {
                    throw new IllegalArgumentException("Last argument of method " + name + " of Java Module " + getName() + " does not expect a Promise");
                } else if (!hashMap.containsKey(name)) {
                    hashMap.put(name, method);
                } else {
                    throw new IllegalArgumentException("Java Module " + getName() + " method name already registered: " + name + ".");
                }
            }
        }
        return hashMap;
    }
}
