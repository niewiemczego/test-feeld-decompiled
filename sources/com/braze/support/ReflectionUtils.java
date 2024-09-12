package com.braze.support;

import com.braze.support.BrazeLogger;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.util.JSStackTrace;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0012\b\u0002\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J=\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000fJC\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002¢\u0006\u0002\u0010\u0013J?\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0014JC\u0010\u0015\u001a\u0004\u0018\u00010\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0013J?\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u001e\u0010\u0006\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0002\b\u0003\u0018\u00010\b0\u000e\"\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u0014JE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u00112\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/braze/support/ReflectionUtils;", "", "()V", "constructObjectQuietly", "classpath", "", "parameterTypes", "", "Ljava/lang/Class;", "args", "doesMethodExist", "", "className", "methodName", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Z", "getDeclaredMethodQuietly", "Ljava/lang/reflect/Method;", "clazz", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getMethodQuietly", "invokeMethodQuietly", "Lkotlin/Pair;", "receiver", "method", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Lkotlin/Pair;", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReflectionUtils {
    public static final ReflectionUtils INSTANCE = new ReflectionUtils();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed constructObjectQuietly";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ Ref.ObjectRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, Ref.ObjectRef objectRef) {
            super(0);
            this.b = str;
            this.c = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            StringBuilder append = new StringBuilder().append("Could not find ").append(this.b).append(" on ");
            Class cls = (Class) this.c.element;
            return append.append(cls != null ? cls.getName() : null).toString();
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to find " + this.b + " on ${clazz.name} or any parent classes";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed getDeclaredMethodQuietly";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed getMethodQuietly";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed getMethodQuietly";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed invokeMethodQuietly";
        }
    }

    private ReflectionUtils() {
    }

    public static /* synthetic */ Object constructObjectQuietly$default(ReflectionUtils reflectionUtils, String str, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            list2 = CollectionsKt.emptyList();
        }
        return reflectionUtils.constructObjectQuietly(str, list, list2);
    }

    @JvmStatic
    public static final boolean doesMethodExist(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        return getMethodQuietly(str, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length)) != null;
    }

    private final Method getDeclaredMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = cls;
        while (true) {
            T t = objectRef.element;
            if (t != null) {
                try {
                    return ((Class) t).getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
                } catch (Exception unused) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, (Function0) new b(str, objectRef), 2, (Object) null);
                    objectRef.element = ((Class) objectRef.element).getSuperclass();
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.D, (Throwable) null, (Function0) new c(str), 2, (Object) null);
                return null;
            }
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(Class<?> cls, String str, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(str, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            return cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e2, (Function0<String>) e.b);
            return null;
        }
    }

    @JvmStatic
    public static final Pair<Boolean, Object> invokeMethodQuietly(Object obj, Method method, Object... objArr) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return new Pair<>(Boolean.TRUE, method.invoke(obj, Arrays.copyOf(objArr, objArr.length)));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e2, (Function0<String>) g.b);
            return new Pair<>(Boolean.FALSE, null);
        }
    }

    public final Object constructObjectQuietly(String str, List<? extends Class<?>> list, List<? extends Object> list2) {
        Intrinsics.checkNotNullParameter(str, "classpath");
        Intrinsics.checkNotNullParameter(list, "parameterTypes");
        Intrinsics.checkNotNullParameter(list2, StepData.ARGS);
        try {
            Class<?> cls = Class.forName(str);
            Class[] clsArr = (Class[]) list.toArray(new Class[0]);
            Constructor<?> constructor = cls.getConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            Object[] array = list2.toArray(new Object[0]);
            return constructor.newInstance(Arrays.copyOf(array, array.length));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) a.b);
            return null;
        }
    }

    @JvmStatic
    public static final Method getMethodQuietly(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return getMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) INSTANCE, BrazeLogger.Priority.D, (Throwable) e2, (Function0<String>) f.b);
            return null;
        }
    }

    public final Method getDeclaredMethodQuietly(String str, String str2, Class<?>... clsArr) {
        Intrinsics.checkNotNullParameter(str, "className");
        Intrinsics.checkNotNullParameter(str2, JSStackTrace.METHOD_NAME_KEY);
        Intrinsics.checkNotNullParameter(clsArr, "parameterTypes");
        try {
            Class<?> cls = Class.forName(str);
            Intrinsics.checkNotNullExpressionValue(cls, "clazz");
            return getDeclaredMethodQuietly(cls, str2, (Class<?>[]) (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.D, (Throwable) e2, (Function0<String>) d.b);
            return null;
        }
    }
}
