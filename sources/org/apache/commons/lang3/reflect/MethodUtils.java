package org.apache.commons.lang3.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;

public class MethodUtils {
    public static Object invokeMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(obj.getClass(), str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactMethod(Object obj, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactMethod(obj, str, objArr, clsArr);
    }

    public static Object invokeExactMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Method accessibleMethod = getAccessibleMethod(obj.getClass(), str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke(obj, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on object: " + obj.getClass().getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Method accessibleMethod = getAccessibleMethod(cls, str, clsArr);
        if (accessibleMethod != null) {
            return accessibleMethod.invoke((Object) null, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeStaticMethod(cls, str, objArr, clsArr);
    }

    public static Object invokeStaticMethod(Class<?> cls, String str, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        Method matchingAccessibleMethod = getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod.invoke((Object) null, objArr);
        }
        throw new NoSuchMethodException("No such accessible method: " + str + "() on class: " + cls.getName());
    }

    public static Object invokeExactStaticMethod(Class<?> cls, String str, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (objArr == null) {
            objArr = ArrayUtils.EMPTY_OBJECT_ARRAY;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i = 0; i < length; i++) {
            clsArr[i] = objArr[i].getClass();
        }
        return invokeExactStaticMethod(cls, str, objArr, clsArr);
    }

    public static Method getAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return getAccessibleMethod(cls.getMethod(str, clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public static Method getAccessibleMethod(Method method) {
        if (!MemberUtils.isAccessible(method)) {
            return null;
        }
        Class<?> declaringClass = method.getDeclaringClass();
        if (Modifier.isPublic(declaringClass.getModifiers())) {
            return method;
        }
        String name = method.getName();
        Class[] parameterTypes = method.getParameterTypes();
        Method accessibleMethodFromInterfaceNest = getAccessibleMethodFromInterfaceNest(declaringClass, name, parameterTypes);
        return accessibleMethodFromInterfaceNest == null ? getAccessibleMethodFromSuperclass(declaringClass, name, parameterTypes) : accessibleMethodFromInterfaceNest;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Method getAccessibleMethodFromSuperclass(java.lang.Class<?> r2, java.lang.String r3, java.lang.Class<?>... r4) {
        /*
            java.lang.Class r2 = r2.getSuperclass()
        L_0x0004:
            r0 = 0
            if (r2 == 0) goto L_0x001c
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isPublic(r1)
            if (r1 == 0) goto L_0x0017
            java.lang.reflect.Method r2 = r2.getMethod(r3, r4)     // Catch:{ NoSuchMethodException -> 0x0016 }
            return r2
        L_0x0016:
            return r0
        L_0x0017:
            java.lang.Class r2 = r2.getSuperclass()
            goto L_0x0004
        L_0x001c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.reflect.MethodUtils.getAccessibleMethodFromSuperclass(java.lang.Class, java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static Method getAccessibleMethodFromInterfaceNest(Class<?> cls, String str, Class<?>... clsArr) {
        Method method = null;
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            Class[] interfaces = cls2.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (Modifier.isPublic(interfaces[i].getModifiers())) {
                    try {
                        method = interfaces[i].getDeclaredMethod(str, clsArr);
                    } catch (NoSuchMethodException unused) {
                    }
                    if (method != null || (method = getAccessibleMethodFromInterfaceNest(interfaces[i], str, clsArr)) != null) {
                        break;
                    }
                }
            }
        }
        return method;
    }

    public static Method getMatchingAccessibleMethod(Class<?> cls, String str, Class<?>... clsArr) {
        Method accessibleMethod;
        try {
            Method method = cls.getMethod(str, clsArr);
            MemberUtils.setAccessibleWorkaround(method);
            return method;
        } catch (NoSuchMethodException unused) {
            Method method2 = null;
            for (Method method3 : cls.getMethods()) {
                if (method3.getName().equals(str) && ClassUtils.isAssignable(clsArr, (Class<?>[]) method3.getParameterTypes(), true) && (accessibleMethod = getAccessibleMethod(method3)) != null && (method2 == null || MemberUtils.compareParameterTypes(accessibleMethod.getParameterTypes(), method2.getParameterTypes(), clsArr) < 0)) {
                    method2 = accessibleMethod;
                }
            }
            if (method2 != null) {
                MemberUtils.setAccessibleWorkaround(method2);
            }
            return method2;
        }
    }
}
