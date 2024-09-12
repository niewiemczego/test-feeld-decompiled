package org.apache.commons.lang3.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

public class FieldUtils {
    public static Field getField(Class<?> cls, String str) {
        Field field = getField(cls, str, false);
        MemberUtils.setAccessibleWorkaround(field);
        return field;
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        if (cls == null) {
            throw new IllegalArgumentException("The class must not be null");
        } else if (str != null) {
            Class<?> cls2 = cls;
            while (cls2 != null) {
                try {
                    Field declaredField = cls2.getDeclaredField(str);
                    if (!Modifier.isPublic(declaredField.getModifiers())) {
                        if (z) {
                            declaredField.setAccessible(true);
                        } else {
                            cls2 = cls2.getSuperclass();
                        }
                    }
                    return declaredField;
                } catch (NoSuchFieldException unused) {
                }
            }
            Field field = null;
            for (Class field2 : ClassUtils.getAllInterfaces(cls)) {
                try {
                    Field field3 = field2.getField(str);
                    if (field == null) {
                        field = field3;
                    } else {
                        throw new IllegalArgumentException("Reference to field " + str + " is ambiguous relative to " + cls + "; a matching field exists on two or more implemented interfaces.");
                    }
                } catch (NoSuchFieldException unused2) {
                }
            }
            return field;
        } else {
            throw new IllegalArgumentException("The field name must not be null");
        }
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        return getDeclaredField(cls, str, false);
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        if (cls == null) {
            throw new IllegalArgumentException("The class must not be null");
        } else if (str != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!MemberUtils.isAccessible(declaredField)) {
                    if (!z) {
                        return null;
                    }
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                return null;
            }
        } else {
            throw new IllegalArgumentException("The field name must not be null");
        }
    }

    public static Object readStaticField(Field field) throws IllegalAccessException {
        return readStaticField(field, false);
    }

    public static Object readStaticField(Field field, boolean z) throws IllegalAccessException {
        if (field == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (Modifier.isStatic(field.getModifiers())) {
            Object obj = null;
            return readField(field, (Object) null, z);
        } else {
            throw new IllegalArgumentException("The field '" + field.getName() + "' is not static");
        }
    }

    public static Object readStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readStaticField(cls, str, false);
    }

    public static Object readStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        if (field != null) {
            return readStaticField(field, false);
        }
        throw new IllegalArgumentException("Cannot locate field " + str + " on " + cls);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str) throws IllegalAccessException {
        return readDeclaredStaticField(cls, str, false);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        if (declaredField != null) {
            return readStaticField(declaredField, false);
        }
        throw new IllegalArgumentException("Cannot locate declared field " + cls.getName() + "." + str);
    }

    public static Object readField(Field field, Object obj) throws IllegalAccessException {
        return readField(field, obj, false);
    }

    public static Object readField(Field field, Object obj, boolean z) throws IllegalAccessException {
        if (field != null) {
            if (!z || field.isAccessible()) {
                MemberUtils.setAccessibleWorkaround(field);
            } else {
                field.setAccessible(true);
            }
            return field.get(obj);
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static Object readField(Object obj, String str) throws IllegalAccessException {
        return readField(obj, str, false);
    }

    public static Object readField(Object obj, String str, boolean z) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z);
            if (field != null) {
                return readField(field, obj);
            }
            throw new IllegalArgumentException("Cannot locate field " + str + " on " + cls);
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static Object readDeclaredField(Object obj, String str) throws IllegalAccessException {
        return readDeclaredField(obj, str, false);
    }

    public static Object readDeclaredField(Object obj, String str, boolean z) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z);
            if (declaredField != null) {
                return readField(declaredField, obj);
            }
            throw new IllegalArgumentException("Cannot locate declared field " + cls.getName() + "." + str);
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeStaticField(field, obj, false);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        if (field == null) {
            throw new IllegalArgumentException("The field must not be null");
        } else if (Modifier.isStatic(field.getModifiers())) {
            Object obj2 = null;
            writeField(field, (Object) null, obj, z);
        } else {
            throw new IllegalArgumentException("The field '" + field.getName() + "' is not static");
        }
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeStaticField(cls, str, obj, false);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        if (field != null) {
            writeStaticField(field, obj);
            return;
        }
        throw new IllegalArgumentException("Cannot locate field " + str + " on " + cls);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeDeclaredStaticField(cls, str, obj, false);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        if (declaredField != null) {
            Object obj2 = null;
            writeField(declaredField, (Object) null, obj);
            return;
        }
        throw new IllegalArgumentException("Cannot locate declared field " + cls.getName() + "." + str);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, false);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        if (field != null) {
            if (!z || field.isAccessible()) {
                MemberUtils.setAccessibleWorkaround(field);
            } else {
                field.setAccessible(true);
            }
            field.set(obj, obj2);
            return;
        }
        throw new IllegalArgumentException("The field must not be null");
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, false);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field field = getField(cls, str, z);
            if (field != null) {
                writeField(field, obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Cannot locate declared field " + cls.getName() + "." + str);
        }
        throw new IllegalArgumentException("target object must not be null");
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeDeclaredField(obj, str, obj2, false);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        if (obj != null) {
            Class<?> cls = obj.getClass();
            Field declaredField = getDeclaredField(cls, str, z);
            if (declaredField != null) {
                writeField(declaredField, obj, obj2);
                return;
            }
            throw new IllegalArgumentException("Cannot locate declared field " + cls.getName() + "." + str);
        }
        throw new IllegalArgumentException("target object must not be null");
    }
}
