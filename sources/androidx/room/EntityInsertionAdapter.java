package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\rJ\u001b\u0010\f\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0014\u0010\f\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0017J\u0014\u0010\u0015\u001a\u00020\u00162\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018J#\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001aJ!\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u001d2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¨\u0006\u001f"}, d2 = {"Landroidx/room/EntityInsertionAdapter;", "T", "Landroidx/room/SharedSQLiteStatement;", "database", "Landroidx/room/RoomDatabase;", "(Landroidx/room/RoomDatabase;)V", "bind", "", "statement", "Landroidx/sqlite/db/SupportSQLiteStatement;", "entity", "(Landroidx/sqlite/db/SupportSQLiteStatement;Ljava/lang/Object;)V", "insert", "(Ljava/lang/Object;)V", "entities", "", "([Ljava/lang/Object;)V", "", "insertAndReturnId", "", "(Ljava/lang/Object;)J", "insertAndReturnIdsArray", "", "([Ljava/lang/Object;)[J", "", "insertAndReturnIdsArrayBox", "([Ljava/lang/Object;)[Ljava/lang/Long;", "(Ljava/util/Collection;)[Ljava/lang/Long;", "insertAndReturnIdsList", "", "([Ljava/lang/Object;)Ljava/util/List;", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EntityInsertionAdapter.kt */
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        Intrinsics.checkNotNullParameter(roomDatabase, "database");
    }

    public final void insert(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            for (Object next : collection) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                bind(acquire, next);
                jArr[i] = acquire.executeInsert();
                i = i2;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = i2 + 1;
                bind(acquire, tArr[i]);
                jArr[i2] = acquire.executeInsert();
                i++;
                i2 = i3;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i = 0; i < size; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator it = ArrayIteratorKt.iterator(tArr);
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i = 0; i < length; i++) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            for (T bind : tArr) {
                bind(acquire, bind);
                createListBuilder.add(Long.valueOf(acquire.executeInsert()));
            }
            return CollectionsKt.build(createListBuilder);
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List createListBuilder = CollectionsKt.createListBuilder();
            for (Object bind : collection) {
                bind(acquire, bind);
                createListBuilder.add(Long.valueOf(acquire.executeInsert()));
            }
            return CollectionsKt.build(createListBuilder);
        } finally {
            release(acquire);
        }
    }
}
