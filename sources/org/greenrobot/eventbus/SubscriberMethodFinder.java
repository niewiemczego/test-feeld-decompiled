package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final FindState[] FIND_STATE_POOL = new FindState[4];
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = new ConcurrentHashMap();
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;

    SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean z, boolean z2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = z;
        this.ignoreGeneratedIndex = z2;
    }

    /* access modifiers changed from: package-private */
    public List<SubscriberMethod> findSubscriberMethods(Class<?> cls) {
        List<SubscriberMethod> list;
        Map<Class<?>, List<SubscriberMethod>> map = METHOD_CACHE;
        List<SubscriberMethod> list2 = map.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.ignoreGeneratedIndex) {
            list = findUsingReflection(cls);
        } else {
            list = findUsingInfo(cls);
        }
        if (!list.isEmpty()) {
            map.put(cls, list);
            return list;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> cls) {
        FindState prepareFindState = prepareFindState();
        prepareFindState.initForSubscriber(cls);
        while (prepareFindState.clazz != null) {
            prepareFindState.subscriberInfo = getSubscriberInfo(prepareFindState);
            if (prepareFindState.subscriberInfo != null) {
                for (SubscriberMethod subscriberMethod : prepareFindState.subscriberInfo.getSubscriberMethods()) {
                    if (prepareFindState.checkAdd(subscriberMethod.method, subscriberMethod.eventType)) {
                        prepareFindState.subscriberMethods.add(subscriberMethod);
                    }
                }
            } else {
                findUsingReflectionInSingleClass(prepareFindState);
            }
            prepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(prepareFindState);
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState findState) {
        ArrayList arrayList = new ArrayList(findState.subscriberMethods);
        findState.recycle();
        synchronized (FIND_STATE_POOL) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                FindState[] findStateArr = FIND_STATE_POOL;
                if (findStateArr[i] == null) {
                    findStateArr[i] = findState;
                    break;
                }
                i++;
            }
        }
        return arrayList;
    }

    private FindState prepareFindState() {
        synchronized (FIND_STATE_POOL) {
            for (int i = 0; i < 4; i++) {
                FindState[] findStateArr = FIND_STATE_POOL;
                FindState findState = findStateArr[i];
                if (findState != null) {
                    findStateArr[i] = null;
                    return findState;
                }
            }
            return new FindState();
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        if (!(findState.subscriberInfo == null || findState.subscriberInfo.getSuperSubscriberInfo() == null)) {
            SubscriberInfo superSubscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo();
            if (findState.clazz == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        List<SubscriberInfoIndex> list = this.subscriberInfoIndexes;
        if (list == null) {
            return null;
        }
        for (SubscriberInfoIndex subscriberInfo : list) {
            SubscriberInfo subscriberInfo2 = subscriberInfo.getSubscriberInfo(findState.clazz);
            if (subscriberInfo2 != null) {
                return subscriberInfo2;
            }
        }
        return null;
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> cls) {
        FindState prepareFindState = prepareFindState();
        prepareFindState.initForSubscriber(cls);
        while (prepareFindState.clazz != null) {
            findUsingReflectionInSingleClass(prepareFindState);
            prepareFindState.moveToSuperclass();
        }
        return getMethodsAndRelease(prepareFindState);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fb, code lost:
        r15 = "Could not inspect methods of " + r15.clazz.getName();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0116, code lost:
        if (r14.ignoreGeneratedIndex != false) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0118, code lost:
        r15 = r15 + ". Please consider using EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x012c, code lost:
        r15 = r15 + ". Please make this class visible to EventBus annotation processor to avoid reflection.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0144, code lost:
        throw new org.greenrobot.eventbus.EventBusException(r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
        r1 = r15.clazz.getMethods();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000e, code lost:
        r15.skipSuperClasses = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0008 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void findUsingReflectionInSingleClass(org.greenrobot.eventbus.SubscriberMethodFinder.FindState r15) {
        /*
            r14 = this;
            r0 = 1
            java.lang.Class<?> r1 = r15.clazz     // Catch:{ all -> 0x0008 }
            java.lang.reflect.Method[] r1 = r1.getDeclaredMethods()     // Catch:{ all -> 0x0008 }
            goto L_0x0010
        L_0x0008:
            java.lang.Class<?> r1 = r15.clazz     // Catch:{ LinkageError -> 0x00fa }
            java.lang.reflect.Method[] r1 = r1.getMethods()     // Catch:{ LinkageError -> 0x00fa }
            r15.skipSuperClasses = r0
        L_0x0010:
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L_0x0013:
            if (r4 >= r2) goto L_0x00f9
            r6 = r1[r4]
            int r5 = r6.getModifiers()
            r7 = r5 & 1
            java.lang.String r8 = "."
            if (r7 == 0) goto L_0x00ae
            r5 = r5 & 5192(0x1448, float:7.276E-42)
            if (r5 != 0) goto L_0x00ae
            java.lang.Class[] r5 = r6.getParameterTypes()
            int r7 = r5.length
            if (r7 != r0) goto L_0x005b
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r7 = org.greenrobot.eventbus.Subscribe.class
            java.lang.annotation.Annotation r7 = r6.getAnnotation(r7)
            org.greenrobot.eventbus.Subscribe r7 = (org.greenrobot.eventbus.Subscribe) r7
            if (r7 == 0) goto L_0x00f5
            r8 = r5[r3]
            boolean r5 = r15.checkAdd(r6, r8)
            if (r5 == 0) goto L_0x00f5
            org.greenrobot.eventbus.ThreadMode r9 = r7.threadMode()
            java.util.List<org.greenrobot.eventbus.SubscriberMethod> r11 = r15.subscriberMethods
            org.greenrobot.eventbus.SubscriberMethod r12 = new org.greenrobot.eventbus.SubscriberMethod
            int r10 = r7.priority()
            boolean r13 = r7.sticky()
            r5 = r12
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r13
            r5.<init>(r6, r7, r8, r9, r10)
            r11.add(r12)
            goto L_0x00f5
        L_0x005b:
            boolean r7 = r14.strictMethodVerification
            if (r7 == 0) goto L_0x00f5
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r7 = org.greenrobot.eventbus.Subscribe.class
            boolean r7 = r6.isAnnotationPresent(r7)
            if (r7 != 0) goto L_0x0069
            goto L_0x00f5
        L_0x0069:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.StringBuilder r15 = r15.append(r8)
            java.lang.String r0 = r6.getName()
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "@Subscribe method "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r1 = "must have exactly 1 parameter but has "
            java.lang.StringBuilder r15 = r15.append(r1)
            int r1 = r5.length
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r15 = r15.toString()
            r0.<init>((java.lang.String) r15)
            throw r0
        L_0x00ae:
            boolean r5 = r14.strictMethodVerification
            if (r5 == 0) goto L_0x00f5
            java.lang.Class<org.greenrobot.eventbus.Subscribe> r5 = org.greenrobot.eventbus.Subscribe.class
            boolean r5 = r6.isAnnotationPresent(r5)
            if (r5 != 0) goto L_0x00bb
            goto L_0x00f5
        L_0x00bb:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r0 = r0.getName()
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.StringBuilder r15 = r15.append(r8)
            java.lang.String r0 = r6.getName()
            java.lang.StringBuilder r15 = r15.append(r0)
            java.lang.String r15 = r15.toString()
            org.greenrobot.eventbus.EventBusException r0 = new org.greenrobot.eventbus.EventBusException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r1 = " is a illegal @Subscribe method: must be public, non-static, and non-abstract"
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r15 = r15.toString()
            r0.<init>((java.lang.String) r15)
            throw r0
        L_0x00f5:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x00f9:
            return
        L_0x00fa:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Could not inspect methods of "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.Class<?> r15 = r15.clazz
            java.lang.String r15 = r15.getName()
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r15 = r15.toString()
            boolean r1 = r14.ignoreGeneratedIndex
            if (r1 == 0) goto L_0x012c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r1 = ". Please consider using EventBus annotation processor to avoid reflection."
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r15 = r15.toString()
            goto L_0x013f
        L_0x012c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r15 = r1.append(r15)
            java.lang.String r1 = ". Please make this class visible to EventBus annotation processor to avoid reflection."
            java.lang.StringBuilder r15 = r15.append(r1)
            java.lang.String r15 = r15.toString()
        L_0x013f:
            org.greenrobot.eventbus.EventBusException r1 = new org.greenrobot.eventbus.EventBusException
            r1.<init>(r15, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.SubscriberMethodFinder.findUsingReflectionInSingleClass(org.greenrobot.eventbus.SubscriberMethodFinder$FindState):void");
    }

    static void clearCaches() {
        METHOD_CACHE.clear();
    }

    static class FindState {
        final Map<Class, Object> anyMethodByEventType = new HashMap();
        Class<?> clazz;
        final StringBuilder methodKeyBuilder = new StringBuilder(128);
        boolean skipSuperClasses;
        Class<?> subscriberClass;
        final Map<String, Class> subscriberClassByMethodKey = new HashMap();
        SubscriberInfo subscriberInfo;
        final List<SubscriberMethod> subscriberMethods = new ArrayList();

        FindState() {
        }

        /* access modifiers changed from: package-private */
        public void initForSubscriber(Class<?> cls) {
            this.clazz = cls;
            this.subscriberClass = cls;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        /* access modifiers changed from: package-private */
        public void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        /* access modifiers changed from: package-private */
        public boolean checkAdd(Method method, Class<?> cls) {
            Object put = this.anyMethodByEventType.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (checkAddWithMethodSignature((Method) put, cls)) {
                    this.anyMethodByEventType.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return checkAddWithMethodSignature(method, cls);
        }

        private boolean checkAddWithMethodSignature(Method method, Class<?> cls) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(method.getName());
            this.methodKeyBuilder.append(Typography.greater).append(cls.getName());
            String sb = this.methodKeyBuilder.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.subscriberClassByMethodKey.put(sb, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.subscriberClassByMethodKey.put(sb, put);
            return false;
        }

        /* access modifiers changed from: package-private */
        public void moveToSuperclass() {
            if (this.skipSuperClasses) {
                this.clazz = null;
                return;
            }
            Class<? super Object> superclass = this.clazz.getSuperclass();
            this.clazz = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.") || name.startsWith("androidx.")) {
                this.clazz = null;
            }
        }
    }
}
