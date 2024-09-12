package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.google.android.gms.actions.SearchIntents;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0000J\u0016\u00102\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020#R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0012\u0012\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\rR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f8\u0006X\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\r¨\u00067"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "(I)V", "<set-?>", "argCount", "getArgCount", "()I", "bindingTypes", "", "getBindingTypes$annotations", "()V", "blobBindings", "", "", "getBlobBindings$annotations", "[[B", "getCapacity", "doubleBindings", "", "getDoubleBindings$annotations", "longBindings", "", "getLongBindings$annotations", "query", "", "sql", "getSql", "()Ljava/lang/String;", "stringBindings", "getStringBindings$annotations", "[Ljava/lang/String;", "bindBlob", "", "index", "value", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "bindTo", "statement", "clearBindings", "close", "copyArgumentsFrom", "other", "init", "initArgCount", "release", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RoomSQLiteQuery.kt */
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: RoomSQLiteQuery.kt */
    public @interface Binding {
    }

    public /* synthetic */ RoomSQLiteQuery(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String str, int i) {
        return Companion.acquire(str, i);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    public static /* synthetic */ void getLongBindings$annotations() {
    }

    public static /* synthetic */ void getStringBindings$annotations() {
    }

    public void close() {
    }

    private RoomSQLiteQuery(int i) {
        this.capacity = i;
        int i2 = i + 1;
        this.bindingTypes = new int[i2];
        this.longBindings = new long[i2];
        this.doubleBindings = new double[i2];
        this.stringBindings = new String[i2];
        this.blobBindings = new byte[i2][];
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public int getArgCount() {
        return this.argCount;
    }

    public final void init(String str, int i) {
        Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
        this.query = str;
        this.argCount = i;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        Intrinsics.checkNotNullParameter(supportSQLiteProgram, "statement");
        int argCount2 = getArgCount();
        if (1 <= argCount2) {
            int i = 1;
            while (true) {
                int i2 = this.bindingTypes[i];
                if (i2 == 1) {
                    supportSQLiteProgram.bindNull(i);
                } else if (i2 == 2) {
                    supportSQLiteProgram.bindLong(i, this.longBindings[i]);
                } else if (i2 == 3) {
                    supportSQLiteProgram.bindDouble(i, this.doubleBindings[i]);
                } else if (i2 == 4) {
                    String str = this.stringBindings[i];
                    if (str != null) {
                        supportSQLiteProgram.bindString(i, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else if (i2 == 5) {
                    byte[] bArr = this.blobBindings[i];
                    if (bArr != null) {
                        supportSQLiteProgram.bindBlob(i, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                if (i != argCount2) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void bindNull(int i) {
        this.bindingTypes[i] = 1;
    }

    public void bindLong(int i, long j) {
        this.bindingTypes[i] = 2;
        this.longBindings[i] = j;
    }

    public void bindDouble(int i, double d) {
        this.bindingTypes[i] = 3;
        this.doubleBindings[i] = d;
    }

    public void bindString(int i, String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.bindingTypes[i] = 4;
        this.stringBindings[i] = str;
    }

    public void bindBlob(int i, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "value");
        this.bindingTypes[i] = 5;
        this.blobBindings[i] = bArr;
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        Intrinsics.checkNotNullParameter(roomSQLiteQuery, "other");
        int argCount2 = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount2);
    }

    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill((Object[]) this.blobBindings, (Object) null);
        this.query = null;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002¨\u0006\u001b"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", "()V", "BLOB", "", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "DOUBLE", "LONG", "NULL", "POOL_LIMIT", "getPOOL_LIMIT$annotations", "STRING", "queryPool", "Ljava/util/TreeMap;", "Landroidx/room/RoomSQLiteQuery;", "getQueryPool$annotations", "acquire", "query", "", "argumentCount", "copyFrom", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "prunePoolLocked", "", "prunePoolLocked$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RoomSQLiteQuery.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        public static /* synthetic */ void getQueryPool$annotations() {
        }

        private Companion() {
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            Intrinsics.checkNotNullParameter(supportSQLiteQuery, "supportSQLiteQuery");
            RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(acquire));
            return acquire;
        }

        @JvmStatic
        public final RoomSQLiteQuery acquire(String str, int i) {
            Intrinsics.checkNotNullParameter(str, SearchIntents.EXTRA_QUERY);
            synchronized (RoomSQLiteQuery.queryPool) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = RoomSQLiteQuery.queryPool.ceilingEntry(Integer.valueOf(i));
                if (ceilingEntry != null) {
                    RoomSQLiteQuery.queryPool.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(str, i);
                    Intrinsics.checkNotNullExpressionValue(value, "sqliteQuery");
                    return value;
                }
                Unit unit = Unit.INSTANCE;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i, (DefaultConstructorMarker) null);
                roomSQLiteQuery.init(str, i);
                return roomSQLiteQuery;
            }
        }

        public final void prunePoolLocked$room_runtime_release() {
            if (RoomSQLiteQuery.queryPool.size() > 15) {
                int size = RoomSQLiteQuery.queryPool.size() - 10;
                Iterator<Integer> it = RoomSQLiteQuery.queryPool.descendingKeySet().iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i;
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
