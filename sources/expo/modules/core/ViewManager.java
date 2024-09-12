package expo.modules.core;

import android.content.Context;
import android.view.View;
import expo.modules.core.interfaces.ExpoProp;
import expo.modules.core.interfaces.RegistryLifecycleListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ViewManager<V extends View> implements RegistryLifecycleListener {
    private Map<String, ViewManager<V>.PropSetterInfo> mPropSetterInfos;
    private Map<String, Method> mPropSetters;

    public enum ViewManagerType {
        SIMPLE,
        GROUP
    }

    public abstract V createViewInstance(Context context);

    public abstract String getName();

    public abstract ViewManagerType getViewManagerType();

    public void onDropViewInstance(V v) {
    }

    public class PropSetterInfo {
        private Class<?> mExpectedPropertyClass;

        PropSetterInfo(Class<?>[] clsArr) {
            this.mExpectedPropertyClass = clsArr[clsArr.length - 1];
        }

        public Class<?> getExpectedValueClass() {
            return this.mExpectedPropertyClass;
        }
    }

    public List<String> getExportedEventNames() {
        return Collections.emptyList();
    }

    public Map<String, Object> getMetadata() {
        HashMap hashMap = new HashMap();
        hashMap.put("propsNames", getPropSetters().keySet().toArray());
        return hashMap;
    }

    public Map<String, ViewManager<V>.PropSetterInfo> getPropSetterInfos() {
        Map<String, ViewManager<V>.PropSetterInfo> map = this.mPropSetterInfos;
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry next : getPropSetters().entrySet()) {
            hashMap.put((String) next.getKey(), new PropSetterInfo(((Method) next.getValue()).getParameterTypes()));
        }
        this.mPropSetterInfos = hashMap;
        return hashMap;
    }

    public void updateProp(V v, String str, Object obj) throws RuntimeException {
        Method method = getPropSetters().get(str);
        if (method != null) {
            try {
                method.invoke(this, new Object[]{v, transformArgumentToClass(obj, getPropSetterInfos().get(str).getExpectedValueClass())});
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException("Exception occurred while updating property " + str + " on module " + getName() + ": " + e.getMessage(), e);
            }
        } else {
            throw new IllegalArgumentException("There is no propSetter in " + getName() + " for prop of name " + str + ".");
        }
    }

    /* access modifiers changed from: protected */
    public Object transformArgumentToClass(Object obj, Class<?> cls) {
        return ArgumentsHelper.validatedArgumentForClass(obj, cls);
    }

    private Map<String, Method> getPropSetters() {
        Map<String, Method> map = this.mPropSetters;
        if (map != null) {
            return map;
        }
        this.mPropSetters = new HashMap();
        for (Method method : getClass().getDeclaredMethods()) {
            if (method.getAnnotation(ExpoProp.class) != null) {
                String name = ((ExpoProp) method.getAnnotation(ExpoProp.class)).name();
                if (method.getParameterTypes().length != 2) {
                    throw new IllegalArgumentException("Expo prop setter should define at least two arguments: view and prop value. Propsetter for " + name + " of module " + getName() + " does not define these arguments.");
                } else if (!this.mPropSetters.containsKey(name)) {
                    this.mPropSetters.put(name, method);
                } else {
                    throw new IllegalArgumentException("View manager " + getName() + " prop setter name already registered: " + name + ".");
                }
            }
        }
        return this.mPropSetters;
    }
}
