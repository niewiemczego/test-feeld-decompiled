package coil.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import coil.util.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0003\u0018\u0019\u001aJ\b\u0010\r\u001a\u00020\u000eH&J\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0004H¦\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0004H&J\u0019\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0010H¦\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\bH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u001b"}, d2 = {"Lcoil/memory/MemoryCache;", "", "keys", "", "Lcoil/memory/MemoryCache$Key;", "getKeys", "()Ljava/util/Set;", "maxSize", "", "getMaxSize", "()I", "size", "getSize", "clear", "", "get", "Lcoil/memory/MemoryCache$Value;", "key", "remove", "", "set", "value", "trimMemory", "level", "Builder", "Key", "Value", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MemoryCache.kt */
public interface MemoryCache {
    void clear();

    Value get(Key key);

    Set<Key> getKeys();

    int getMaxSize();

    int getSize();

    boolean remove(Key key);

    void set(Key key, Value value);

    void trimMemory(int i);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcoil/memory/MemoryCache$Key;", "Landroid/os/Parcelable;", "key", "", "extras", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getExtras", "()Ljava/util/Map;", "getKey", "()Ljava/lang/String;", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Key implements Parcelable {
        public static final Parcelable.Creator<Key> CREATOR = new Creator();
        private final Map<String, String> extras;
        private final String key;

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: MemoryCache.kt */
        public static final class Creator implements Parcelable.Creator<Key> {
            public final Key createFromParcel(Parcel parcel) {
                String readString = parcel.readString();
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
                return new Key(readString, linkedHashMap);
            }

            public final Key[] newArray(int i) {
                return new Key[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.key);
            Map<String, String> map = this.extras;
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }

        public Key(String str, Map<String, String> map) {
            this.key = str;
            this.extras = map;
        }

        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Key(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, String> getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Key copy$default(Key key2, String str, Map<String, String> map, int i, Object obj) {
            if ((i & 1) != 0) {
                str = key2.key;
            }
            if ((i & 2) != 0) {
                map = key2.extras;
            }
            return key2.copy(str, map);
        }

        public final Key copy(String str, Map<String, String> map) {
            return new Key(str, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Key) {
                Key key2 = (Key) obj;
                if (!Intrinsics.areEqual((Object) this.key, (Object) key2.key) || !Intrinsics.areEqual((Object) this.extras, (Object) key2.extras)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Key(key=" + this.key + ", extras=" + this.extras + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcoil/memory/MemoryCache$Value;", "", "bitmap", "Landroid/graphics/Bitmap;", "extras", "", "", "(Landroid/graphics/Bitmap;Ljava/util/Map;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getExtras", "()Ljava/util/Map;", "copy", "equals", "", "other", "hashCode", "", "toString", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Value {
        private final Bitmap bitmap;
        private final Map<String, Object> extras;

        public Value(Bitmap bitmap2, Map<String, ? extends Object> map) {
            this.bitmap = bitmap2;
            this.extras = map;
        }

        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Value(Bitmap bitmap2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(bitmap2, (i & 2) != 0 ? MapsKt.emptyMap() : map);
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public static /* synthetic */ Value copy$default(Value value, Bitmap bitmap2, Map<String, Object> map, int i, Object obj) {
            if ((i & 1) != 0) {
                bitmap2 = value.bitmap;
            }
            if ((i & 2) != 0) {
                map = value.extras;
            }
            return value.copy(bitmap2, map);
        }

        public final Value copy(Bitmap bitmap2, Map<String, ? extends Object> map) {
            return new Value(bitmap2, map);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Value) {
                Value value = (Value) obj;
                if (!Intrinsics.areEqual((Object) this.bitmap, (Object) value.bitmap) || !Intrinsics.areEqual((Object) this.extras, (Object) value.extras)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.bitmap.hashCode() * 31) + this.extras.hashCode();
        }

        public String toString() {
            return "Value(bitmap=" + this.bitmap + ", extras=" + this.extras + ')';
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\u000f\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcoil/memory/MemoryCache$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "maxSizeBytes", "", "maxSizePercent", "", "strongReferencesEnabled", "", "weakReferencesEnabled", "build", "Lcoil/memory/MemoryCache;", "size", "percent", "enable", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MemoryCache.kt */
    public static final class Builder {
        private final Context context;
        private int maxSizeBytes;
        private double maxSizePercent;
        private boolean strongReferencesEnabled = true;
        private boolean weakReferencesEnabled = true;

        public Builder(Context context2) {
            this.context = context2;
            this.maxSizePercent = Utils.defaultMemoryCacheSizePercent(context2);
        }

        public final Builder maxSizePercent(double d) {
            Builder builder = this;
            if (0.0d <= d && d <= 1.0d) {
                this.maxSizeBytes = 0;
                this.maxSizePercent = d;
                return this;
            }
            throw new IllegalArgumentException("size must be in the range [0.0, 1.0].".toString());
        }

        public final Builder maxSizeBytes(int i) {
            Builder builder = this;
            if (i >= 0) {
                this.maxSizePercent = 0.0d;
                this.maxSizeBytes = i;
                return this;
            }
            throw new IllegalArgumentException("size must be >= 0.".toString());
        }

        public final Builder strongReferencesEnabled(boolean z) {
            Builder builder = this;
            this.strongReferencesEnabled = z;
            return this;
        }

        public final Builder weakReferencesEnabled(boolean z) {
            Builder builder = this;
            this.weakReferencesEnabled = z;
            return this;
        }

        public final MemoryCache build() {
            WeakMemoryCache weakMemoryCache;
            StrongMemoryCache strongMemoryCache;
            int i;
            if (this.weakReferencesEnabled) {
                weakMemoryCache = new RealWeakMemoryCache();
            } else {
                weakMemoryCache = new EmptyWeakMemoryCache();
            }
            if (this.strongReferencesEnabled) {
                double d = this.maxSizePercent;
                if (d > 0.0d) {
                    i = Utils.calculateMemoryCacheSize(this.context, d);
                } else {
                    i = this.maxSizeBytes;
                }
                if (i > 0) {
                    strongMemoryCache = new RealStrongMemoryCache(i, weakMemoryCache);
                } else {
                    strongMemoryCache = new EmptyStrongMemoryCache(weakMemoryCache);
                }
            } else {
                strongMemoryCache = new EmptyStrongMemoryCache(weakMemoryCache);
            }
            return new RealMemoryCache(strongMemoryCache, weakMemoryCache);
        }
    }
}
