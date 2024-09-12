package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ArrayTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    /* access modifiers changed from: private */
    public final ImmutableMap<C, Integer> columnKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<C> columnList;
    @CheckForNull
    private transient ArrayTable<R, C, V>.ColumnMap columnMap;
    /* access modifiers changed from: private */
    public final ImmutableMap<R, Integer> rowKeyToIndex;
    /* access modifiers changed from: private */
    public final ImmutableList<R> rowList;
    @CheckForNull
    private transient ArrayTable<R, C, V>.RowMap rowMap;

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        return new ArrayTable<>(iterable, iterable2);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, ? extends V> table) {
        if (table instanceof ArrayTable) {
            return new ArrayTable<>((ArrayTable) table);
        }
        return new ArrayTable<>(table);
    }

    private ArrayTable(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        ImmutableList<R> copyOf = ImmutableList.copyOf(iterable);
        this.rowList = copyOf;
        ImmutableList<C> copyOf2 = ImmutableList.copyOf(iterable2);
        this.columnList = copyOf2;
        Preconditions.checkArgument(copyOf.isEmpty() == copyOf2.isEmpty());
        this.rowKeyToIndex = Maps.indexMap(copyOf);
        this.columnKeyToIndex = Maps.indexMap(copyOf2);
        int size = copyOf.size();
        int[] iArr = new int[2];
        iArr[1] = copyOf2.size();
        iArr[0] = size;
        this.array = (Object[][]) Array.newInstance(Object.class, iArr);
        eraseAll();
    }

    private ArrayTable(Table<R, C, ? extends V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> arrayTable) {
        ImmutableList<R> immutableList = arrayTable.rowList;
        this.rowList = immutableList;
        ImmutableList<C> immutableList2 = arrayTable.columnList;
        this.columnList = immutableList2;
        this.rowKeyToIndex = arrayTable.rowKeyToIndex;
        this.columnKeyToIndex = arrayTable.columnKeyToIndex;
        int size = immutableList.size();
        int[] iArr = new int[2];
        iArr[1] = immutableList2.size();
        iArr[0] = size;
        V[][] vArr = (Object[][]) Array.newInstance(Object.class, iArr);
        this.array = vArr;
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = arrayTable.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
    }

    private static abstract class ArrayMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> {
        private final ImmutableMap<K, Integer> keyIndex;

        /* access modifiers changed from: package-private */
        public abstract String getKeyRole();

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V getValue(int i);

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract V setValue(int i, @ParametricNullness V v);

        private ArrayMap(ImmutableMap<K, Integer> immutableMap) {
            this.keyIndex = immutableMap;
        }

        public Set<K> keySet() {
            return this.keyIndex.keySet();
        }

        /* access modifiers changed from: package-private */
        public K getKey(int i) {
            return this.keyIndex.keySet().asList().get(i);
        }

        public int size() {
            return this.keyIndex.size();
        }

        public boolean isEmpty() {
            return this.keyIndex.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> getEntry(final int i) {
            Preconditions.checkElementIndex(i, size());
            return new AbstractMapEntry<K, V>() {
                public K getKey() {
                    return ArrayMap.this.getKey(i);
                }

                @ParametricNullness
                public V getValue() {
                    return ArrayMap.this.getValue(i);
                }

                @ParametricNullness
                public V setValue(@ParametricNullness V v) {
                    return ArrayMap.this.setValue(i, v);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return new AbstractIndexedListIterator<Map.Entry<K, V>>(size()) {
                /* access modifiers changed from: protected */
                public Map.Entry<K, V> get(int i) {
                    return ArrayMap.this.getEntry(i);
                }
            };
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.keyIndex.containsKey(obj);
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            Integer num = this.keyIndex.get(obj);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        @CheckForNull
        public V put(K k, @ParametricNullness V v) {
            Integer num = this.keyIndex.get(k);
            if (num != null) {
                return setValue(num.intValue(), v);
            }
            String keyRole = getKeyRole();
            String valueOf = String.valueOf(k);
            String valueOf2 = String.valueOf(this.keyIndex.keySet());
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(keyRole).length() + 9 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length()).append(keyRole).append(" ").append(valueOf).append(" not in ").append(valueOf2).toString());
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    @CheckForNull
    public V at(int i, int i2) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        return this.array[i][i2];
    }

    @CheckForNull
    public V set(int i, int i2, @CheckForNull V v) {
        Preconditions.checkElementIndex(i, this.rowList.size());
        Preconditions.checkElementIndex(i2, this.columnList.size());
        V[] vArr = this.array[i];
        V v2 = vArr[i2];
        vArr[i2] = v;
        return v2;
    }

    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (Object[][]) Array.newInstance(cls, new int[]{this.rowList.size(), this.columnList.size()});
        for (int i = 0; i < this.rowList.size(); i++) {
            V[] vArr2 = this.array[i];
            System.arraycopy(vArr2, 0, vArr[i], 0, vArr2.length);
        }
        return vArr;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] fill : this.array) {
            Arrays.fill(fill, (Object) null);
        }
    }

    public boolean contains(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return containsRow(obj) && containsColumn(obj2);
    }

    public boolean containsColumn(@CheckForNull Object obj) {
        return this.columnKeyToIndex.containsKey(obj);
    }

    public boolean containsRow(@CheckForNull Object obj) {
        return this.rowKeyToIndex.containsKey(obj);
    }

    public boolean containsValue(@CheckForNull Object obj) {
        for (V[] vArr : this.array) {
            for (V equal : r0[r3]) {
                if (Objects.equal(obj, equal)) {
                    return true;
                }
            }
        }
        return false;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @CheckForNull
    public V put(R r, C c, @CheckForNull V v) {
        Preconditions.checkNotNull(r);
        Preconditions.checkNotNull(c);
        Integer num = this.rowKeyToIndex.get(r);
        boolean z = true;
        Preconditions.checkArgument(num != null, "Row %s not in %s", (Object) r, (Object) this.rowList);
        Integer num2 = this.columnKeyToIndex.get(c);
        if (num2 == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", (Object) c, (Object) this.columnList);
        return set(num.intValue(), num2.intValue(), v);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @CheckForNull
    @Deprecated
    public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public V erase(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Integer num = this.rowKeyToIndex.get(obj);
        Integer num2 = this.columnKeyToIndex.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), (Object) null);
    }

    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public Set<Table.Cell<R, C, V>> cellSet() {
        return super.cellSet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Table.Cell<R, C, V>> cellIterator() {
        return new AbstractIndexedListIterator<Table.Cell<R, C, V>>(size()) {
            /* access modifiers changed from: protected */
            public Table.Cell<R, C, V> get(int i) {
                return ArrayTable.this.getCell(i);
            }
        };
    }

    /* access modifiers changed from: private */
    public Table.Cell<R, C, V> getCell(int i) {
        return new Tables.AbstractCell<R, C, V>(i) {
            final int columnIndex;
            final int rowIndex;
            final /* synthetic */ int val$index;

            {
                this.val$index = r3;
                this.rowIndex = r3 / ArrayTable.this.columnList.size();
                this.columnIndex = r3 % ArrayTable.this.columnList.size();
            }

            public R getRowKey() {
                return ArrayTable.this.rowList.get(this.rowIndex);
            }

            public C getColumnKey() {
                return ArrayTable.this.columnList.get(this.columnIndex);
            }

            @CheckForNull
            public V getValue() {
                return ArrayTable.this.at(this.rowIndex, this.columnIndex);
            }
        };
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public V getValue(int i) {
        return at(i / this.columnList.size(), i % this.columnList.size());
    }

    public Map<R, V> column(C c) {
        Preconditions.checkNotNull(c);
        Integer num = this.columnKeyToIndex.get(c);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new Column(num.intValue());
    }

    private class Column extends ArrayMap<R, V> {
        final int columnIndex;

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        Column(int i) {
            super(ArrayTable.this.rowKeyToIndex);
            this.columnIndex = i;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V getValue(int i) {
            return ArrayTable.this.at(i, this.columnIndex);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V setValue(int i, @CheckForNull V v) {
            return ArrayTable.this.set(i, this.columnIndex, v);
        }
    }

    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        ArrayTable<R, C, V>.ColumnMap columnMap2 = this.columnMap;
        if (columnMap2 != null) {
            return columnMap2;
        }
        ArrayTable<R, C, V>.ColumnMap columnMap3 = new ColumnMap();
        this.columnMap = columnMap3;
        return columnMap3;
    }

    private class ColumnMap extends ArrayMap<C, Map<R, V>> {
        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        private ColumnMap() {
            super(ArrayTable.this.columnKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> getValue(int i) {
            return new Column(i);
        }

        /* access modifiers changed from: package-private */
        public Map<R, V> setValue(int i, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<R, V> put(C c, Map<R, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public Map<C, V> row(R r) {
        Preconditions.checkNotNull(r);
        Integer num = this.rowKeyToIndex.get(r);
        if (num == null) {
            return Collections.emptyMap();
        }
        return new Row(num.intValue());
    }

    private class Row extends ArrayMap<C, V> {
        final int rowIndex;

        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Column";
        }

        Row(int i) {
            super(ArrayTable.this.columnKeyToIndex);
            this.rowIndex = i;
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V getValue(int i) {
            return ArrayTable.this.at(this.rowIndex, i);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public V setValue(int i, @CheckForNull V v) {
            return ArrayTable.this.set(this.rowIndex, i, v);
        }
    }

    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        ArrayTable<R, C, V>.RowMap rowMap2 = this.rowMap;
        if (rowMap2 != null) {
            return rowMap2;
        }
        ArrayTable<R, C, V>.RowMap rowMap3 = new RowMap();
        this.rowMap = rowMap3;
        return rowMap3;
    }

    private class RowMap extends ArrayMap<R, Map<C, V>> {
        /* access modifiers changed from: package-private */
        public String getKeyRole() {
            return "Row";
        }

        private RowMap() {
            super(ArrayTable.this.rowKeyToIndex);
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> getValue(int i) {
            return new Row(i);
        }

        /* access modifiers changed from: package-private */
        public Map<C, V> setValue(int i, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public Map<C, V> put(R r, Map<C, V> map) {
            throw new UnsupportedOperationException();
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> valuesIterator() {
        return new AbstractIndexedListIterator<V>(size()) {
            /* access modifiers changed from: protected */
            @CheckForNull
            public V get(int i) {
                return ArrayTable.this.getValue(i);
            }
        };
    }
}
