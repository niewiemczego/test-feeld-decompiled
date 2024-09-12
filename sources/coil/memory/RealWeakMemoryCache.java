package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0013\u001a\u00020\u0014H\u0001¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J4\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#0!2\u0006\u0010$\u001a\u00020\u0012H\u0016J\u0010\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0012H\u0016RX\u0010\u0003\u001a>\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b0\u0004j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b`\t8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "()V", "cache", "Ljava/util/LinkedHashMap;", "Lcoil/memory/MemoryCache$Key;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "getCache$coil_base_release$annotations", "getCache$coil_base_release", "()Ljava/util/LinkedHashMap;", "keys", "", "getKeys", "()Ljava/util/Set;", "operationsSinceCleanUp", "", "cleanUp", "", "cleanUp$coil_base_release", "cleanUpIfNecessary", "clearMemory", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "", "size", "trimMemory", "level", "Companion", "InternalValue", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WeakMemoryCache.kt */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;

    public static /* synthetic */ void getCache$coil_base_release$annotations() {
    }

    public final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> getCache$coil_base_release() {
        return this.cache;
    }

    public synchronized Set<MemoryCache.Key> getKeys() {
        return CollectionsKt.toSet(this.cache.keySet());
    }

    public synchronized MemoryCache.Value get(MemoryCache.Key key) {
        ArrayList arrayList = this.cache.get(key);
        MemoryCache.Value value = null;
        if (arrayList == null) {
            return null;
        }
        List list = arrayList;
        int i = 0;
        int size = list.size();
        while (true) {
            if (i >= size) {
                break;
            }
            InternalValue internalValue = (InternalValue) list.get(i);
            Bitmap bitmap = (Bitmap) internalValue.getBitmap().get();
            MemoryCache.Value value2 = bitmap != null ? new MemoryCache.Value(bitmap, internalValue.getExtras()) : null;
            if (value2 != null) {
                value = value2;
                break;
            }
            i++;
        }
        cleanUpIfNecessary();
        return value;
    }

    public synchronized void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> map, int i) {
        Map map2 = this.cache;
        Object obj = map2.get(key);
        if (obj == null) {
            obj = new ArrayList();
            map2.put(key, obj);
        }
        ArrayList arrayList = (ArrayList) obj;
        RealWeakMemoryCache realWeakMemoryCache = this;
        int identityHashCode = System.identityHashCode(bitmap);
        InternalValue internalValue = new InternalValue(identityHashCode, new WeakReference(bitmap), map, i);
        int i2 = 0;
        int size = arrayList.size();
        while (true) {
            if (i2 >= size) {
                arrayList.add(internalValue);
                break;
            }
            InternalValue internalValue2 = (InternalValue) arrayList.get(i2);
            if (i < internalValue2.getSize()) {
                i2++;
            } else if (internalValue2.getIdentityHashCode() == identityHashCode && internalValue2.getBitmap().get() == bitmap) {
                arrayList.set(i2, internalValue);
            } else {
                arrayList.add(i2, internalValue);
            }
        }
        cleanUpIfNecessary();
    }

    public synchronized boolean remove(MemoryCache.Key key) {
        return this.cache.remove(key) != null;
    }

    public synchronized void clearMemory() {
        this.operationsSinceCleanUp = 0;
        this.cache.clear();
    }

    public synchronized void trimMemory(int i) {
        if (i >= 10 && i != 20) {
            cleanUp$coil_base_release();
        }
    }

    private final void cleanUpIfNecessary() {
        int i = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i + 1;
        if (i >= 10) {
            cleanUp$coil_base_release();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        r2 = r2.getBitmap();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cleanUp$coil_base_release() {
        /*
            r10 = this;
            r0 = 0
            r10.operationsSinceCleanUp = r0
            java.util.LinkedHashMap<coil.memory.MemoryCache$Key, java.util.ArrayList<coil.memory.RealWeakMemoryCache$InternalValue>> r1 = r10.cache
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x000d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0075
            java.lang.Object r2 = r1.next()
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            int r3 = r3.size()
            r4 = 1
            if (r3 > r4) goto L_0x0041
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)
            coil.memory.RealWeakMemoryCache$InternalValue r2 = (coil.memory.RealWeakMemoryCache.InternalValue) r2
            if (r2 == 0) goto L_0x003a
            java.lang.ref.WeakReference r2 = r2.getBitmap()
            if (r2 == 0) goto L_0x003a
            java.lang.Object r2 = r2.get()
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            if (r2 != 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x0041:
            r3 = r2
            java.util.List r3 = (java.util.List) r3
            int r5 = r3.size()
            r6 = r0
            r7 = r6
        L_0x004a:
            if (r6 >= r5) goto L_0x006b
            int r8 = r6 - r7
            java.lang.Object r9 = r3.get(r8)
            coil.memory.RealWeakMemoryCache$InternalValue r9 = (coil.memory.RealWeakMemoryCache.InternalValue) r9
            java.lang.ref.WeakReference r9 = r9.getBitmap()
            java.lang.Object r9 = r9.get()
            if (r9 != 0) goto L_0x0060
            r9 = r4
            goto L_0x0061
        L_0x0060:
            r9 = r0
        L_0x0061:
            if (r9 == 0) goto L_0x0068
            r3.remove(r8)
            int r7 = r7 + 1
        L_0x0068:
            int r6 = r6 + 1
            goto L_0x004a
        L_0x006b:
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x000d
            r1.remove()
            goto L_0x000d
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.memory.RealWeakMemoryCache.cleanUp$coil_base_release():void");
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$InternalValue;", "", "identityHashCode", "", "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "extras", "", "", "size", "(ILjava/lang/ref/WeakReference;Ljava/util/Map;I)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getIdentityHashCode", "()I", "getSize", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WeakMemoryCache.kt */
    public static final class InternalValue {
        private final WeakReference<Bitmap> bitmap;
        private final Map<String, Object> extras;
        private final int identityHashCode;
        private final int size;

        public InternalValue(int i, WeakReference<Bitmap> weakReference, Map<String, ? extends Object> map, int i2) {
            this.identityHashCode = i;
            this.bitmap = weakReference;
            this.extras = map;
            this.size = i2;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final int getSize() {
            return this.size;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$Companion;", "", "()V", "CLEAN_UP_INTERVAL", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WeakMemoryCache.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
