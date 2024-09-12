package expo.modules.core;

public class ArgumentsHelper {
    static Object validatedArgumentForClass(Object obj, Class<?> cls) {
        if (Object.class.isAssignableFrom(cls)) {
            if (obj != null) {
                Class<?> cls2 = obj.getClass();
                if (!cls.isAssignableFrom(cls2)) {
                    throw new IllegalArgumentException("Argument of an incompatible class: " + cls2 + " cannot be passed as an argument to parameter expecting " + cls + ".");
                }
            }
        } else if (obj != null) {
            Class<?> cls3 = obj.getClass();
            if (cls != cls3 && !Number.class.isAssignableFrom(cls3) && !Boolean.class.isAssignableFrom(cls3)) {
                throw new IllegalArgumentException("Argument of an incompatible class: " + cls3 + " cannot be passed as an argument to parameter expecting " + cls + ".");
            }
        } else {
            throw new IllegalArgumentException("Argument null cannot be passed to an argument to parameter expecting " + cls + ".");
        }
        return obj;
    }
}
